package com.baidu.tieba.write.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView ML;
    private RelativeLayout cFw;
    private boolean cMt;
    private GridView cxr;
    private View djN;
    private o emG;
    private AlbumActivity emU;
    private h eoa;
    private View eob;
    private View eoc;
    private com.baidu.tieba.write.view.a eod;
    private ab eoe;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.emU = (AlbumActivity) getBaseFragmentActivity();
        this.emG = this.emU.aSv();
        p.aSO().a(this);
        this.eoa = new h(this.emU.getPageContext().getPageActivity());
        this.eod = new com.baidu.tieba.write.view.a(this.emU);
        this.emG.nz("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(t.h.album_image_list_view, (ViewGroup) null);
        this.cFw = (RelativeLayout) this.mView.findViewById(t.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(t.g.view_navigation_bar);
        this.djN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.emU);
        this.eoc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.ML = (TextView) this.eoc.findViewById(t.g.navigationTitle_frs);
        this.cxr = (GridView) this.mView.findViewById(t.g.gv_image_list);
        this.eob = this.mView.findViewById(t.g.gv_foot);
        this.eoe = new ab(this.emU, this.emG);
        this.cxr.setAdapter((ListAdapter) this.eoe);
        this.cxr.setOnScrollListener(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.eoc.setOnClickListener(akVar);
        this.eod.a(alVar);
        this.eoe.a(ahVar);
        this.eoe.a(aiVar);
        this.eoe.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.emU.getPageContext().getPageActivity(), this.cFw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.y(t.j.album_list_no_data, t.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cMt = false;
        if (isShow()) {
            aSG();
        }
    }

    private void aSF() {
        if (this.emG == null && this.emU != null) {
            this.emG = this.emU.aSv();
        }
        if (this.emG != null && this.emG.aSL() == null) {
            setData(aSU(), true);
            nB("-1");
        }
    }

    private List<ImageFileInfo> aSU() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void nB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eoa.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSV() {
        this.eoa.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.eoe != null) {
            this.emG.co(list);
            this.eoe.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.eob.setVisibility(0);
                } else {
                    this.eob.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emU.getLayoutMode().ac(i == 1);
        this.emU.getLayoutMode().x(this.mView);
        if (this.eoe != null) {
            this.eoe.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.emU.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View awm() {
        return this.djN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eoa != null) {
            this.eoa.aPR();
        }
        p.aSO().b(this);
    }

    public void z(int i, boolean z) {
        if (this.cxr != null) {
            int firstVisiblePosition = this.cxr.getFirstVisiblePosition();
            int lastVisiblePosition = this.cxr.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.cxr.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(t.g.select_icon);
                    if (z) {
                        ar.k(imageView, t.f.btn_choose_photo_s);
                    } else {
                        ar.k(imageView, t.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.eoe != null) {
            z(this.eoe.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cMt = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void iy(boolean z) {
        aSG();
    }

    private void aSG() {
        if (!isHidden() && !this.cMt) {
            aSF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (bl(((i + i2) - 1) + 1, 3) == bl(i3, 3)) {
            if (this.eob.getVisibility() != 0) {
                this.eob.setVisibility(0);
            }
        } else if (this.eob.getVisibility() == 0) {
            this.eob.setVisibility(8);
        }
    }

    private int bl(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.eoe.io(true);
        } else if (this.eoe.isScroll()) {
            this.eoe.io(false);
            aPo();
        }
    }

    private void aPo() {
        int childCount = this.cxr.getChildCount();
        int firstVisiblePosition = this.cxr.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cxr.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.pic);
                ImageFileInfo item = this.eoe.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.emU.aSw().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.eoe != null) {
            this.eoe.notifyDataSetChanged();
        }
    }
}

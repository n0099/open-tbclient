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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends BaseFragment implements AbsListView.OnScrollListener, m.a {
    private TextView LN;
    private RelativeLayout ccn;
    private boolean chV;
    private View cuM;
    private l djP;
    private AlbumActivity djW;
    private e dlj;
    private View dlk;
    private View dll;
    private com.baidu.tieba.write.view.a dlm;
    private x dln;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djW = (AlbumActivity) getBaseFragmentActivity();
        this.djP = this.djW.aBa();
        m.aBv().a(this);
        this.dlj = new e(this.djW.getPageContext().getPageActivity());
        this.dlm = new com.baidu.tieba.write.view.a(this.djW);
        this.djP.mm("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(i.g.album_image_list_view, (ViewGroup) null);
        this.ccn = (RelativeLayout) this.mView.findViewById(i.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(i.f.view_navigation_bar);
        this.cuM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.djW);
        this.dll = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.LN = (TextView) this.dll.findViewById(i.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(i.f.gv_image_list);
        this.dlk = this.mView.findViewById(i.f.gv_foot);
        this.dln = new x(this.djW, this.djP);
        this.mGridView.setAdapter((ListAdapter) this.dln);
        this.mGridView.setOnScrollListener(this);
        ad adVar = new ad(this);
        ae aeVar = new ae(this);
        af afVar = new af(this);
        ag agVar = new ag(this);
        ah ahVar = new ah(this);
        this.dll.setOnClickListener(agVar);
        this.dlm.a(ahVar);
        this.dln.a(adVar);
        this.dln.a(aeVar);
        this.dln.a(afVar);
        this.mNoDataView = NoDataViewFactory.a(this.djW.getPageContext().getPageActivity(), this.ccn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.album_list_no_data, i.h.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.chV = false;
        if (isShow()) {
            aBk();
        }
    }

    private void aBj() {
        if (this.djP == null && this.djW != null) {
            this.djP = this.djW.aBa();
        }
        if (this.djP != null && this.djP.aBs() == null) {
            setData(aBB(), true);
            mo("-1");
        }
    }

    private List<ImageFileInfo> aBB() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void mo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dlj.a(str, new ai(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBC() {
        this.dlj.a(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.dln != null) {
            this.djP.bG(list);
            this.dln.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.dlk.setVisibility(0);
                } else {
                    this.dlk.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djW.getLayoutMode().ad(i == 1);
        this.djW.getLayoutMode().k(this.mView);
        this.mNavigationBar.onChangeSkinType(this.djW.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View ajZ() {
        return this.cuM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dlj != null) {
            this.dlj.aBm();
        }
        m.aBv().b(this);
    }

    public void v(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(i.f.select_icon);
                    if (z) {
                        an.i(imageView, i.e.btn_choose_photo_s);
                    } else {
                        an.i(imageView, i.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.dln != null) {
            v(this.dln.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.chV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.m.a
    public void gS(boolean z) {
        aBk();
    }

    private void aBk() {
        if (!isHidden() && !this.chV) {
            aBj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aL(((i + i2) - 1) + 1, 3) == aL(i3, 3)) {
            if (this.dlk.getVisibility() != 0) {
                this.dlk.setVisibility(0);
            }
        } else if (this.dlk.getVisibility() == 0) {
            this.dlk.setVisibility(8);
        }
    }

    private int aL(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.dln.gU(true);
        } else if (this.dln.isScroll()) {
            this.dln.gU(false);
            aBD();
        }
    }

    private void aBD() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.pic);
                ImageFileInfo item = this.dln.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.djW.aBb().a(item, new ak(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.dln != null) {
            this.dln.notifyDataSetChanged();
        }
    }
}

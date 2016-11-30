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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView FZ;
    private GridView dUh;
    private RelativeLayout efO;
    private boolean euz;
    private o gjE;
    private AlbumActivity gjT;
    private View gjU;
    private h gla;
    private View glb;
    private com.baidu.tieba.write.view.a glc;
    private ab gld;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjT = (AlbumActivity) getBaseFragmentActivity();
        this.gjE = this.gjT.buB();
        p.buT().a(this);
        this.gla = new h(this.gjT.getPageContext().getPageActivity());
        this.glc = new com.baidu.tieba.write.view.a(this.gjT);
        this.gjE.sR("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(r.h.album_image_list_view, (ViewGroup) null);
        this.efO = (RelativeLayout) this.mView.findViewById(r.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(r.g.view_navigation_bar);
        this.gjU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gjT);
        this.glb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.FZ = (TextView) this.glb.findViewById(r.g.navigationTitle_frs);
        this.dUh = (GridView) this.mView.findViewById(r.g.gv_image_list);
        this.gld = new ab(this.gjT, this.gjE);
        this.dUh.setAdapter((ListAdapter) this.gld);
        this.dUh.setOnScrollListener(this);
        this.dUh.setSelector(r.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.glb.setOnClickListener(akVar);
        this.glc.a(alVar);
        this.gld.a(ahVar);
        this.gld.a(aiVar);
        this.gld.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.gjT.getPageContext().getPageActivity(), this.efO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.x(r.j.album_list_no_data, r.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.euz = false;
        if (isShow()) {
            buM();
        }
    }

    private void buL() {
        if (this.gjE == null && this.gjT != null) {
            this.gjE = this.gjT.buB();
        }
        if (this.gjE != null && this.gjE.buQ() == null) {
            setData(buZ(), true);
            sT("-1");
        }
    }

    private List<ImageFileInfo> buZ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void sT(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gla.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bva() {
        this.gla.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.gld != null) {
            this.gjE.dB(list);
            this.gld.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjT.getLayoutMode().ai(i == 1);
        this.gjT.getLayoutMode().x(this.mView);
        if (this.gld != null) {
            this.gld.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.gjT.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bgN() {
        return this.gjU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gla != null) {
            this.gla.bqW();
        }
        p.buT().b(this);
    }

    public void aa(int i, boolean z) {
        if (this.dUh != null) {
            int firstVisiblePosition = this.dUh.getFirstVisiblePosition();
            int lastVisiblePosition = this.dUh.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dUh.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(r.g.select_icon);
                    if (z) {
                        at.k(imageView, r.f.btn_choose_photo_s);
                    } else {
                        at.k(imageView, r.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gld != null) {
            aa(this.gld.j(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.euz = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void mk(boolean z) {
        buM();
    }

    private void buM() {
        if (!isHidden() && !this.euz) {
            buL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gld.lO(true);
        } else if (this.gld.isScroll()) {
            this.gld.lO(false);
            bpI();
        }
    }

    private void bpI() {
        int childCount = this.dUh.getChildCount();
        int firstVisiblePosition = this.dUh.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dUh.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.pic);
                ImageFileInfo item = this.gld.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gjT.amA().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.gld != null) {
            this.gld.notifyDataSetChanged();
        }
    }
}

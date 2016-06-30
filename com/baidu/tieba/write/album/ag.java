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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView Dj;
    private RelativeLayout dHM;
    private boolean dOz;
    private GridView dxt;
    private View eqH;
    private o fCA;
    private AlbumActivity fCP;
    private h fDU;
    private View fDV;
    private com.baidu.tieba.write.view.a fDW;
    private ab fDX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCP = (AlbumActivity) getBaseFragmentActivity();
        this.fCA = this.fCP.bjO();
        p.bkg().a(this);
        this.fDU = new h(this.fCP.getPageContext().getPageActivity());
        this.fDW = new com.baidu.tieba.write.view.a(this.fCP);
        this.fCA.qL("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(u.h.album_image_list_view, (ViewGroup) null);
        this.dHM = (RelativeLayout) this.mView.findViewById(u.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(u.g.view_navigation_bar);
        this.eqH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fCP);
        this.fDV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, u.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.Dj = (TextView) this.fDV.findViewById(u.g.navigationTitle_frs);
        this.dxt = (GridView) this.mView.findViewById(u.g.gv_image_list);
        this.fDX = new ab(this.fCP, this.fCA);
        this.dxt.setAdapter((ListAdapter) this.fDX);
        this.dxt.setOnScrollListener(this);
        this.dxt.setSelector(u.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fDV.setOnClickListener(akVar);
        this.fDW.a(alVar);
        this.fDX.a(ahVar);
        this.fDX.a(aiVar);
        this.fDX.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fCP.getPageContext().getPageActivity(), this.dHM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(u.j.album_list_no_data, u.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dOz = false;
        if (isShow()) {
            bjZ();
        }
    }

    private void bjY() {
        if (this.fCA == null && this.fCP != null) {
            this.fCA = this.fCP.bjO();
        }
        if (this.fCA != null && this.fCA.bkd() == null) {
            setData(bkm(), true);
            qN("-1");
        }
    }

    private List<ImageFileInfo> bkm() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void qN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fDU.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkn() {
        this.fDU.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fDX != null) {
            this.fCA.dd(list);
            this.fDX.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fCP.getLayoutMode().ad(i == 1);
        this.fCP.getLayoutMode().w(this.mView);
        if (this.fDX != null) {
            this.fDX.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fCP.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aNm() {
        return this.eqH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fDU != null) {
            this.fDU.bgW();
        }
        p.bkg().b(this);
    }

    public void R(int i, boolean z) {
        if (this.dxt != null) {
            int firstVisiblePosition = this.dxt.getFirstVisiblePosition();
            int lastVisiblePosition = this.dxt.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dxt.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(u.g.select_icon);
                    if (z) {
                        av.k(imageView, u.f.btn_choose_photo_s);
                    } else {
                        av.k(imageView, u.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fDX != null) {
            R(this.fDX.j(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dOz = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void le(boolean z) {
        bjZ();
    }

    private void bjZ() {
        if (!isHidden() && !this.dOz) {
            bjY();
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
            this.fDX.kM(true);
        } else if (this.fDX.isScroll()) {
            this.fDX.kM(false);
            bfF();
        }
    }

    private void bfF() {
        int childCount = this.dxt.getChildCount();
        int firstVisiblePosition = this.dxt.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dxt.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(u.g.pic);
                ImageFileInfo item = this.fDX.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fCP.afd().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fDX != null) {
            this.fDX.notifyDataSetChanged();
        }
    }
}

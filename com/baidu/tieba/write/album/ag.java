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
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView FX;
    private GridView dOC;
    private RelativeLayout dZP;
    private boolean eoP;
    private o gbZ;
    private AlbumActivity gco;
    private View gcp;
    private h gdv;
    private View gdw;
    private com.baidu.tieba.write.view.a gdx;
    private ab gdy;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.v mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gco = (AlbumActivity) getBaseFragmentActivity();
        this.gbZ = this.gco.bsg();
        p.bsy().a(this);
        this.gdv = new h(this.gco.getPageContext().getPageActivity());
        this.gdx = new com.baidu.tieba.write.view.a(this.gco);
        this.gbZ.sv("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(r.h.album_image_list_view, (ViewGroup) null);
        this.dZP = (RelativeLayout) this.mView.findViewById(r.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(r.g.view_navigation_bar);
        this.gcp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gco);
        this.gdw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.FX = (TextView) this.gdw.findViewById(r.g.navigationTitle_frs);
        this.dOC = (GridView) this.mView.findViewById(r.g.gv_image_list);
        this.gdy = new ab(this.gco, this.gbZ);
        this.dOC.setAdapter((ListAdapter) this.gdy);
        this.dOC.setOnScrollListener(this);
        this.dOC.setSelector(r.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.gdw.setOnClickListener(akVar);
        this.gdx.a(alVar);
        this.gdy.a(ahVar);
        this.gdy.a(aiVar);
        this.gdy.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.gco.getPageContext().getPageActivity(), this.dZP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.x(r.j.album_list_no_data, r.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eoP = false;
        if (isShow()) {
            bsr();
        }
    }

    private void bsq() {
        if (this.gbZ == null && this.gco != null) {
            this.gbZ = this.gco.bsg();
        }
        if (this.gbZ != null && this.gbZ.bsv() == null) {
            setData(bsE(), true);
            sx("-1");
        }
    }

    private List<ImageFileInfo> bsE() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void sx(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gdv.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsF() {
        this.gdv.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.gdy != null) {
            this.gbZ.dv(list);
            this.gdy.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gco.getLayoutMode().ah(i == 1);
        this.gco.getLayoutMode().x(this.mView);
        if (this.gdy != null) {
            this.gdy.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.gco.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View ber() {
        return this.gcp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gdv != null) {
            this.gdv.boC();
        }
        p.bsy().b(this);
    }

    public void X(int i, boolean z) {
        if (this.dOC != null) {
            int firstVisiblePosition = this.dOC.getFirstVisiblePosition();
            int lastVisiblePosition = this.dOC.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dOC.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(r.g.select_icon);
                    if (z) {
                        av.k(imageView, r.f.btn_choose_photo_s);
                    } else {
                        av.k(imageView, r.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gdy != null) {
            X(this.gdy.j(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eoP = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lL(boolean z) {
        bsr();
    }

    private void bsr() {
        if (!isHidden() && !this.eoP) {
            bsq();
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
            this.gdy.lp(true);
        } else if (this.gdy.isScroll()) {
            this.gdy.lp(false);
            bno();
        }
    }

    private void bno() {
        int childCount = this.dOC.getChildCount();
        int firstVisiblePosition = this.dOC.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dOC.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.pic);
                ImageFileInfo item = this.gdy.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gco.akF().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.gdy != null) {
            this.gdy.notifyDataSetChanged();
        }
    }
}

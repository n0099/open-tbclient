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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView bKX;
    private GridView dJo;
    private RelativeLayout dVV;
    private boolean ekQ;
    private o fPd;
    private AlbumActivity fPr;
    private View fPs;
    private h fQF;
    private View fQG;
    private com.baidu.tieba.write.view.a fQH;
    private ab fQI;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fPr = (AlbumActivity) getBaseFragmentActivity();
        this.fPd = this.fPr.boo();
        p.boK().a(this);
        this.fQF = new h(this.fPr.getPageContext().getPageActivity());
        this.fQH = new com.baidu.tieba.write.view.a(this.fPr);
        this.fPd.ra("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.dVV = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(w.h.view_navigation_bar);
        this.fPs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fPr);
        this.fQG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.album_iamge_title_layout, (View.OnClickListener) null);
        this.bKX = (TextView) this.fQG.findViewById(w.h.navigationTitle_frs);
        this.dJo = (GridView) this.mView.findViewById(w.h.gv_image_list);
        this.fQI = new ab(this.fPr, this.fPd);
        this.dJo.setAdapter((ListAdapter) this.fQI);
        this.dJo.setOnScrollListener(this);
        this.dJo.setSelector(w.e.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fQG.setOnClickListener(akVar);
        this.fQH.a(alVar);
        this.fQI.a(ahVar);
        this.fQI.a(aiVar);
        this.fQI.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fPr.getPageContext().getPageActivity(), this.dVV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.E(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ekQ = false;
        if (isShow()) {
            boz();
        }
    }

    private void boy() {
        if (this.fPd == null && this.fPr != null) {
            this.fPd = this.fPr.boo();
        }
        if (this.fPd != null && this.fPd.boH() == null) {
            setData(boQ(), true);
            rc("-1");
        }
    }

    private List<ImageFileInfo> boQ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void rc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fQF.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boR() {
        this.fQF.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fQI != null) {
            this.fPd.cX(list);
            this.fQI.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fPr.getLayoutMode().aj(i == 1);
        this.fPr.getLayoutMode().t(this.mView);
        if (this.fQI != null) {
            this.fQI.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fPr.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bdN() {
        return this.fPs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fQF != null) {
            this.fQF.boB();
        }
        p.boK().b(this);
    }

    public void L(int i, boolean z) {
        if (this.dJo != null) {
            int firstVisiblePosition = this.dJo.getFirstVisiblePosition();
            int lastVisiblePosition = this.dJo.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dJo.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(w.h.select_icon);
                    if (z) {
                        aq.j(imageView, w.g.btn_choose_photo_s);
                    } else {
                        aq.j(imageView, w.g.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fQI != null) {
            L(this.fQI.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ekQ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lU(boolean z) {
        boz();
    }

    private void boz() {
        if (!isHidden() && !this.ekQ) {
            boy();
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
            this.fQI.lW(true);
        } else if (this.fQI.isScroll()) {
            this.fQI.lW(false);
            boS();
        }
    }

    private void boS() {
        int childCount = this.dJo.getChildCount();
        int firstVisiblePosition = this.dJo.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dJo.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.fQI.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fPr.aip().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fQI != null) {
            this.fQI.notifyDataSetChanged();
        }
    }
}

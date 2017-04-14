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
    private TextView bIG;
    private GridView dGY;
    private RelativeLayout dTF;
    private boolean eiA;
    private o fMH;
    private AlbumActivity fMV;
    private View fMW;
    private h fOj;
    private View fOk;
    private com.baidu.tieba.write.view.a fOl;
    private ab fOm;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMV = (AlbumActivity) getBaseFragmentActivity();
        this.fMH = this.fMV.bnn();
        p.bnJ().a(this);
        this.fOj = new h(this.fMV.getPageContext().getPageActivity());
        this.fOl = new com.baidu.tieba.write.view.a(this.fMV);
        this.fMH.qZ("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.dTF = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(w.h.view_navigation_bar);
        this.fMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fMV);
        this.fOk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.album_iamge_title_layout, (View.OnClickListener) null);
        this.bIG = (TextView) this.fOk.findViewById(w.h.navigationTitle_frs);
        this.dGY = (GridView) this.mView.findViewById(w.h.gv_image_list);
        this.fOm = new ab(this.fMV, this.fMH);
        this.dGY.setAdapter((ListAdapter) this.fOm);
        this.dGY.setOnScrollListener(this);
        this.dGY.setSelector(w.e.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fOk.setOnClickListener(akVar);
        this.fOl.a(alVar);
        this.fOm.a(ahVar);
        this.fOm.a(aiVar);
        this.fOm.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fMV.getPageContext().getPageActivity(), this.dTF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.E(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eiA = false;
        if (isShow()) {
            bny();
        }
    }

    private void bnx() {
        if (this.fMH == null && this.fMV != null) {
            this.fMH = this.fMV.bnn();
        }
        if (this.fMH != null && this.fMH.bnG() == null) {
            setData(bnP(), true);
            rb("-1");
        }
    }

    private List<ImageFileInfo> bnP() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void rb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fOj.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnQ() {
        this.fOj.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fOm != null) {
            this.fMH.cX(list);
            this.fOm.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fMV.getLayoutMode().aj(i == 1);
        this.fMV.getLayoutMode().t(this.mView);
        if (this.fOm != null) {
            this.fOm.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fMV.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bcM() {
        return this.fMW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fOj != null) {
            this.fOj.bnA();
        }
        p.bnJ().b(this);
    }

    public void L(int i, boolean z) {
        if (this.dGY != null) {
            int firstVisiblePosition = this.dGY.getFirstVisiblePosition();
            int lastVisiblePosition = this.dGY.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dGY.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.fOm != null) {
            L(this.fOm.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eiA = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lK(boolean z) {
        bny();
    }

    private void bny() {
        if (!isHidden() && !this.eiA) {
            bnx();
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
            this.fOm.lM(true);
        } else if (this.fOm.isScroll()) {
            this.fOm.lM(false);
            bnR();
        }
    }

    private void bnR() {
        int childCount = this.dGY.getChildCount();
        int firstVisiblePosition = this.dGY.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dGY.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.fOm.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fMV.aho().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fOm != null) {
            this.fOm.notifyDataSetChanged();
        }
    }
}

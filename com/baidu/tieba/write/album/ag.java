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
    private TextView DK;
    private GridView dAR;
    private RelativeLayout dLY;
    private View eCs;
    private boolean eaM;
    private o fPM;
    private AlbumActivity fQb;
    private h fRh;
    private View fRi;
    private com.baidu.tieba.write.view.a fRj;
    private ab fRk;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fQb = (AlbumActivity) getBaseFragmentActivity();
        this.fPM = this.fQb.bnk();
        p.bnC().a(this);
        this.fRh = new h(this.fQb.getPageContext().getPageActivity());
        this.fRj = new com.baidu.tieba.write.view.a(this.fQb);
        this.fPM.rw("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(u.h.album_image_list_view, (ViewGroup) null);
        this.dLY = (RelativeLayout) this.mView.findViewById(u.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(u.g.view_navigation_bar);
        this.eCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fQb);
        this.fRi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, u.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.DK = (TextView) this.fRi.findViewById(u.g.navigationTitle_frs);
        this.dAR = (GridView) this.mView.findViewById(u.g.gv_image_list);
        this.fRk = new ab(this.fQb, this.fPM);
        this.dAR.setAdapter((ListAdapter) this.fRk);
        this.dAR.setOnScrollListener(this);
        this.dAR.setSelector(u.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fRi.setOnClickListener(akVar);
        this.fRj.a(alVar);
        this.fRk.a(ahVar);
        this.fRk.a(aiVar);
        this.fRk.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fQb.getPageContext().getPageActivity(), this.dLY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(u.j.album_list_no_data, u.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eaM = false;
        if (isShow()) {
            bnv();
        }
    }

    private void bnu() {
        if (this.fPM == null && this.fQb != null) {
            this.fPM = this.fQb.bnk();
        }
        if (this.fPM != null && this.fPM.bnz() == null) {
            setData(bnI(), true);
            ry("-1");
        }
    }

    private List<ImageFileInfo> bnI() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void ry(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fRh.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        this.fRh.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fRk != null) {
            this.fPM.dp(list);
            this.fRk.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fQb.getLayoutMode().af(i == 1);
        this.fQb.getLayoutMode().w(this.mView);
        if (this.fRk != null) {
            this.fRk.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fQb.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aQp() {
        return this.eCs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fRh != null) {
            this.fRh.bkl();
        }
        p.bnC().b(this);
    }

    public void V(int i, boolean z) {
        if (this.dAR != null) {
            int firstVisiblePosition = this.dAR.getFirstVisiblePosition();
            int lastVisiblePosition = this.dAR.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dAR.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.fRk != null) {
            V(this.fRk.j(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eaM = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lt(boolean z) {
        bnv();
    }

    private void bnv() {
        if (!isHidden() && !this.eaM) {
            bnu();
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
            this.fRk.la(true);
        } else if (this.fRk.isScroll()) {
            this.fRk.la(false);
            biW();
        }
    }

    private void biW() {
        int childCount = this.dAR.getChildCount();
        int firstVisiblePosition = this.dAR.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dAR.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(u.g.pic);
                ImageFileInfo item = this.fRk.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fQb.afG().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fRk != null) {
            this.fRk.notifyDataSetChanged();
        }
    }
}

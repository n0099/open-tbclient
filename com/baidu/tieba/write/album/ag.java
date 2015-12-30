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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView Mv;
    private boolean cFa;
    private View cYb;
    private RelativeLayout cyP;
    private o dRW;
    private AlbumActivity dSj;
    private ab dTA;
    private h dTw;
    private View dTx;
    private View dTy;
    private com.baidu.tieba.write.view.a dTz;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dSj = (AlbumActivity) getBaseFragmentActivity();
        this.dRW = this.dSj.aJH();
        p.aKd().a(this);
        this.dTw = new h(this.dSj.getPageContext().getPageActivity());
        this.dTz = new com.baidu.tieba.write.view.a(this.dSj);
        this.dRW.nj("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(n.h.album_image_list_view, (ViewGroup) null);
        this.cyP = (RelativeLayout) this.mView.findViewById(n.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(n.g.view_navigation_bar);
        this.cYb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dSj);
        this.dTy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.Mv = (TextView) this.dTy.findViewById(n.g.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(n.g.gv_image_list);
        this.dTx = this.mView.findViewById(n.g.gv_foot);
        this.dTA = new ab(this.dSj, this.dRW);
        this.mGridView.setAdapter((ListAdapter) this.dTA);
        this.mGridView.setOnScrollListener(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.dTy.setOnClickListener(akVar);
        this.dTz.a(alVar);
        this.dTA.a(ahVar);
        this.dTA.a(aiVar);
        this.dTA.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.dSj.getPageContext().getPageActivity(), this.cyP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(n.j.album_list_no_data, n.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cFa = false;
        if (isShow()) {
            aJS();
        }
    }

    private void aJR() {
        if (this.dRW == null && this.dSj != null) {
            this.dRW = this.dSj.aJH();
        }
        if (this.dRW != null && this.dRW.aKa() == null) {
            setData(aKj(), true);
            nl("-1");
        }
    }

    private List<ImageFileInfo> aKj() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void nl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dTw.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        this.dTw.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.dTA != null) {
            this.dRW.cb(list);
            this.dTA.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.dTx.setVisibility(0);
                } else {
                    this.dTx.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dSj.getLayoutMode().ac(i == 1);
        this.dSj.getLayoutMode().k(this.mView);
        if (this.dTA != null) {
            this.dTA.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.dSj.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aqV() {
        return this.cYb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dTw != null) {
            this.dTw.aJU();
        }
        p.aKd().b(this);
    }

    public void x(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(n.g.select_icon);
                    if (z) {
                        as.i(imageView, n.f.btn_choose_photo_s);
                    } else {
                        as.i(imageView, n.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.dTA != null) {
            x(this.dTA.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cFa = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void hM(boolean z) {
        aJS();
    }

    private void aJS() {
        if (!isHidden() && !this.cFa) {
            aJR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (bf(((i + i2) - 1) + 1, 3) == bf(i3, 3)) {
            if (this.dTx.getVisibility() != 0) {
                this.dTx.setVisibility(0);
            }
        } else if (this.dTx.getVisibility() == 0) {
            this.dTx.setVisibility(8);
        }
    }

    private int bf(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.dTA.hO(true);
        } else if (this.dTA.isScroll()) {
            this.dTA.hO(false);
            aKl();
        }
    }

    private void aKl() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(n.g.pic);
                ImageFileInfo item = this.dTA.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.dSj.aJI().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.dTA != null) {
            this.dTA.notifyDataSetChanged();
        }
    }
}

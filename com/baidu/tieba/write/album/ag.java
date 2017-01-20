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
    private TextView Fj;
    private GridView dHR;
    private RelativeLayout dTs;
    private boolean ehC;
    private o fGE;
    private AlbumActivity fGS;
    private View fGT;
    private h fIg;
    private View fIh;
    private com.baidu.tieba.write.view.a fIi;
    private ab fIj;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGS = (AlbumActivity) getBaseFragmentActivity();
        this.fGE = this.fGS.bmQ();
        p.bnm().a(this);
        this.fIg = new h(this.fGS.getPageContext().getPageActivity());
        this.fIi = new com.baidu.tieba.write.view.a(this.fGS);
        this.fGE.rx("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(r.j.album_image_list_view, (ViewGroup) null);
        this.dTs = (RelativeLayout) this.mView.findViewById(r.h.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(r.h.view_navigation_bar);
        this.fGT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fGS);
        this.fIh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.j.album_iamge_title_layout, (View.OnClickListener) null);
        this.Fj = (TextView) this.fIh.findViewById(r.h.navigationTitle_frs);
        this.dHR = (GridView) this.mView.findViewById(r.h.gv_image_list);
        this.fIj = new ab(this.fGS, this.fGE);
        this.dHR.setAdapter((ListAdapter) this.fIj);
        this.dHR.setOnScrollListener(this);
        this.dHR.setSelector(r.e.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fIh.setOnClickListener(akVar);
        this.fIi.a(alVar);
        this.fIj.a(ahVar);
        this.fIj.a(aiVar);
        this.fIj.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fGS.getPageContext().getPageActivity(), this.dTs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.y(r.l.album_list_no_data, r.l.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ehC = false;
        if (isShow()) {
            bnb();
        }
    }

    private void bna() {
        if (this.fGE == null && this.fGS != null) {
            this.fGE = this.fGS.bmQ();
        }
        if (this.fGE != null && this.fGE.bnj() == null) {
            setData(bns(), true);
            rz("-1");
        }
    }

    private List<ImageFileInfo> bns() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void rz(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fIg.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnt() {
        this.fIg.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fIj != null) {
            this.fGE.dr(list);
            this.fIj.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fGS.getLayoutMode().ai(i == 1);
        this.fGS.getLayoutMode().v(this.mView);
        if (this.fIj != null) {
            this.fIj.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fGS.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bcs() {
        return this.fGT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fIg != null) {
            this.fIg.bnd();
        }
        p.bnm().b(this);
    }

    public void K(int i, boolean z) {
        if (this.dHR != null) {
            int firstVisiblePosition = this.dHR.getFirstVisiblePosition();
            int lastVisiblePosition = this.dHR.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dHR.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(r.h.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.ap.j(imageView, r.g.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.ap.j(imageView, r.g.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fIj != null) {
            K(this.fIj.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ehC = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lI(boolean z) {
        bnb();
    }

    private void bnb() {
        if (!isHidden() && !this.ehC) {
            bna();
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
            this.fIj.lK(true);
        } else if (this.fIj.isScroll()) {
            this.fIj.lK(false);
            bnu();
        }
    }

    private void bnu() {
        int childCount = this.dHR.getChildCount();
        int firstVisiblePosition = this.dHR.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dHR.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.h.pic);
                ImageFileInfo item = this.fIj.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fGS.aii().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fIj != null) {
            this.fIj.notifyDataSetChanged();
        }
    }
}

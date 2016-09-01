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
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView FX;
    private GridView dMG;
    private RelativeLayout dXV;
    private boolean emR;
    private o fZQ;
    private AlbumActivity gaf;
    private View gag;
    private h gbm;
    private View gbn;
    private com.baidu.tieba.write.view.a gbo;
    private ab gbp;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gaf = (AlbumActivity) getBaseFragmentActivity();
        this.fZQ = this.gaf.brA();
        p.brS().a(this);
        this.gbm = new h(this.gaf.getPageContext().getPageActivity());
        this.gbo = new com.baidu.tieba.write.view.a(this.gaf);
        this.fZQ.sg("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(t.h.album_image_list_view, (ViewGroup) null);
        this.dXV = (RelativeLayout) this.mView.findViewById(t.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(t.g.view_navigation_bar);
        this.gag = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gaf);
        this.gbn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.FX = (TextView) this.gbn.findViewById(t.g.navigationTitle_frs);
        this.dMG = (GridView) this.mView.findViewById(t.g.gv_image_list);
        this.gbp = new ab(this.gaf, this.fZQ);
        this.dMG.setAdapter((ListAdapter) this.gbp);
        this.dMG.setOnScrollListener(this);
        this.dMG.setSelector(t.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.gbn.setOnClickListener(akVar);
        this.gbo.a(alVar);
        this.gbp.a(ahVar);
        this.gbp.a(aiVar);
        this.gbp.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.gaf.getPageContext().getPageActivity(), this.dXV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.x(t.j.album_list_no_data, t.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.emR = false;
        if (isShow()) {
            brL();
        }
    }

    private void brK() {
        if (this.fZQ == null && this.gaf != null) {
            this.fZQ = this.gaf.brA();
        }
        if (this.fZQ != null && this.fZQ.brP() == null) {
            setData(brY(), true);
            si("-1");
        }
    }

    private List<ImageFileInfo> brY() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void si(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gbm.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brZ() {
        this.gbm.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.gbp != null) {
            this.fZQ.du(list);
            this.gbp.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gaf.getLayoutMode().ah(i == 1);
        this.gaf.getLayoutMode().x(this.mView);
        if (this.gbp != null) {
            this.gbp.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.gaf.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bdG() {
        return this.gag;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gbm != null) {
            this.gbm.bnU();
        }
        p.brS().b(this);
    }

    public void X(int i, boolean z) {
        if (this.dMG != null) {
            int firstVisiblePosition = this.dMG.getFirstVisiblePosition();
            int lastVisiblePosition = this.dMG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dMG.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(t.g.select_icon);
                    if (z) {
                        av.k(imageView, t.f.btn_choose_photo_s);
                    } else {
                        av.k(imageView, t.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gbp != null) {
            X(this.gbp.j(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.emR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lJ(boolean z) {
        brL();
    }

    private void brL() {
        if (!isHidden() && !this.emR) {
            brK();
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
            this.gbp.lm(true);
        } else if (this.gbp.isScroll()) {
            this.gbp.lm(false);
            bmG();
        }
    }

    private void bmG() {
        int childCount = this.dMG.getChildCount();
        int firstVisiblePosition = this.dMG.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dMG.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.pic);
                ImageFileInfo item = this.gbp.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gaf.akr().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.gbp != null) {
            this.gbp.notifyDataSetChanged();
        }
    }
}

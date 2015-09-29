package com.baidu.tieba.themeCenter.theme.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class f {
    private TextView WM;
    private TextView Xh;
    private com.baidu.tbadk.core.flow.a.c Xs;
    private NoNetworkView aQP;
    private IndicatorView apz;
    private TbImageView ddX;
    private View deN;
    private TextView dec;
    private HorizontalListView dgA;
    private c dgB;
    private SkinDetailActivity dgy;
    private SkinProgressView dgz;
    private int mFontSize;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int topMargin;
    private final int dgw = 20;
    private final int dgx = 10;
    private HorizontalListView.a dgC = new g(this);

    public f(SkinDetailActivity skinDetailActivity) {
        this.topMargin = 0;
        this.dgy = skinDetailActivity;
        this.topMargin = k.d(skinDetailActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgy.getPageContext().getPageActivity()).inflate(i.g.skin_detail_activity_layout, (ViewGroup) null);
        this.dgy.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_scrollview);
        this.mFontSize = k.d(this.dgy.getPageContext().getPageActivity(), i.d.fontsize36);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_detail);
        this.aQP = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.WM = (TextView) this.mRoot.findViewById(i.f.textview_title);
        this.dec = (TextView) this.mRoot.findViewById(i.f.textview_size);
        this.Xh = (TextView) this.mRoot.findViewById(i.f.textview_desc);
        this.ddX = (TbImageView) this.mRoot.findViewById(i.f.imageview_permission);
        this.ddX.setDefaultBgResource(i.e.transparent_bg);
        this.ddX.setDefaultResource(i.e.transparent_bg);
        this.ddX.setGifIconSupport(false);
        this.dgz = (SkinProgressView) this.mRoot.findViewById(i.f.textview_download);
        this.dgz.setFontSize(this.mFontSize);
        this.dgz.setListenerTag(this.dgy.getUniqueId());
        this.dgA = (HorizontalListView) this.mRoot.findViewById(i.f.skin_detail_image_listview);
        this.dgB = new c(this.dgy.getPageContext());
        this.dgA.setAdapter((ListAdapter) this.dgB);
        this.apz = (IndicatorView) this.mRoot.findViewById(i.f.list_view_indicator);
        azu();
        this.Xs.g(this.apz);
        this.dgA.setOnScrollChangedListener(this.dgC);
        this.dgA.setOnItemClickListener(new h(this));
    }

    public void e(int i, float f) {
        if (this.dgz != null) {
            int i2 = 0;
            if (this.mSkinData != null) {
                i2 = this.mSkinData.azb();
            }
            this.dgz.a(i, 0.0f, i2);
        }
    }

    public void g(com.baidu.tieba.themeCenter.b bVar) {
        if (bVar == null) {
            Kr();
            return;
        }
        this.mSkinData = bVar;
        Ks();
        this.WM.setText(n.v(bVar.getTitle(), 20));
        this.ddX.d(bVar.azf(), 10, false);
        this.dec.setText(n.v(bVar.getPackageSize(), 10));
        this.Xh.setText(bVar.getDescription());
        this.dgz.setSkinDetailPage(true);
        this.dgz.setSkinData(this.mSkinData);
        this.dgz.a(this.mSkinData.azc(), 0.0f, this.mSkinData.azb());
        if (bVar.azd() == null || bVar.azd().size() <= 0) {
            this.dgA.setVisibility(8);
            this.apz.setVisibility(8);
            return;
        }
        this.dgB.ah(bVar.azd());
        this.dgB.notifyDataSetChanged();
        this.dgA.setVisibility(0);
        this.apz.setVisibility(0);
        if (bVar.azd().size() == 1) {
            this.apz.setCount(0);
            return;
        }
        this.apz.setCount(bVar.azd().size());
        this.apz.setPosition(0.0f);
    }

    public void Kr() {
        this.deN.setVisibility(8);
        am.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.dgy.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgy.setNetRefreshViewTopMargin(this.topMargin);
        this.dgy.showNetRefreshView(this.mRoot, string, false);
    }

    private void azu() {
        this.Xs = new com.baidu.tbadk.core.flow.a.c();
        this.Xs.setDrawableId(i.e.dot_live_n);
        this.Xs.bX(i.e.dot_live_s);
        this.Xs.setSpacing(i.d.ds10);
        this.Xs.setGravity(17);
    }

    public void Ks() {
        this.deN.setVisibility(0);
        am.j(this.mRoot, i.c.cp_bg_line_c);
        this.dgy.hideNetRefreshView(this.mRoot);
    }

    public void vA() {
        this.dgy.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgy.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dgy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dgA != null && this.dgA.getVisibility() == 0 && this.dgB != null) {
            this.dgB.notifyDataSetChanged();
        }
        if (this.apz != null && this.Xs != null) {
            this.apz.setDrawable(am.getDrawable(this.Xs.tm()));
            this.apz.setSelector(am.getDrawable(this.Xs.getSelectedId()));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgz.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRoot;
    }
}

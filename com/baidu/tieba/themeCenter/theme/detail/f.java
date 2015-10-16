package com.baidu.tieba.themeCenter.theme.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class f {
    private TextView WO;
    private TextView Xj;
    private com.baidu.tbadk.core.flow.a.c Xu;
    private NoNetworkView aRa;
    private IndicatorView apA;
    private TextView deC;
    private TbImageView dex;
    private View dfn;
    private SkinDetailActivity dgY;
    private SkinProgressView dgZ;
    private HorizontalListView dha;
    private c dhb;
    private int mFontSize;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int topMargin;
    private final int dgW = 20;
    private final int dgX = 10;
    private HorizontalListView.a dhc = new g(this);

    public f(SkinDetailActivity skinDetailActivity) {
        this.topMargin = 0;
        this.dgY = skinDetailActivity;
        this.topMargin = k.d(skinDetailActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgY.getPageContext().getPageActivity()).inflate(i.g.skin_detail_activity_layout, (ViewGroup) null);
        this.dgY.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_scrollview);
        this.mFontSize = k.d(this.dgY.getPageContext().getPageActivity(), i.d.fontsize36);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_detail);
        this.aRa = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.WO = (TextView) this.mRoot.findViewById(i.f.textview_title);
        this.deC = (TextView) this.mRoot.findViewById(i.f.textview_size);
        this.Xj = (TextView) this.mRoot.findViewById(i.f.textview_desc);
        this.dex = (TbImageView) this.mRoot.findViewById(i.f.imageview_permission);
        this.dex.setDefaultBgResource(i.e.transparent_bg);
        this.dex.setDefaultResource(i.e.transparent_bg);
        this.dex.setGifIconSupport(false);
        this.dgZ = (SkinProgressView) this.mRoot.findViewById(i.f.textview_download);
        this.dgZ.setFontSize(this.mFontSize);
        this.dgZ.setListenerTag(this.dgY.getUniqueId());
        this.dha = (HorizontalListView) this.mRoot.findViewById(i.f.skin_detail_image_listview);
        this.dhb = new c(this.dgY.getPageContext());
        this.dha.setAdapter((ListAdapter) this.dhb);
        this.apA = (IndicatorView) this.mRoot.findViewById(i.f.list_view_indicator);
        azE();
        this.Xu.g(this.apA);
        this.dha.setOnScrollChangedListener(this.dhc);
        this.dha.setOnItemClickListener(new h(this));
    }

    public void e(int i, float f) {
        if (this.dgZ != null) {
            int i2 = 0;
            if (this.mSkinData != null) {
                i2 = this.mSkinData.azl();
            }
            this.dgZ.a(i, 0.0f, i2);
        }
    }

    public void g(com.baidu.tieba.themeCenter.b bVar) {
        if (bVar == null) {
            Kr();
            return;
        }
        this.mSkinData = bVar;
        Ks();
        this.WO.setText(n.v(bVar.getTitle(), 20));
        this.dex.d(bVar.azp(), 10, false);
        this.deC.setText(n.v(bVar.getPackageSize(), 10));
        this.Xj.setText(bVar.getDescription());
        this.dgZ.setSkinDetailPage(true);
        this.dgZ.setSkinData(this.mSkinData);
        this.dgZ.a(this.mSkinData.azm(), 0.0f, this.mSkinData.azl());
        if (bVar.azn() == null || bVar.azn().size() <= 0) {
            this.dha.setVisibility(8);
            this.apA.setVisibility(8);
            return;
        }
        this.dhb.ah(bVar.azn());
        this.dhb.notifyDataSetChanged();
        this.dha.setVisibility(0);
        this.apA.setVisibility(0);
        if (bVar.azn().size() == 1) {
            this.apA.setCount(0);
            return;
        }
        this.apA.setCount(bVar.azn().size());
        this.apA.setPosition(0.0f);
    }

    public void Kr() {
        this.dfn.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.dgY.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgY.setNetRefreshViewTopMargin(this.topMargin);
        this.dgY.showNetRefreshView(this.mRoot, string, false);
    }

    private void azE() {
        this.Xu = new com.baidu.tbadk.core.flow.a.c();
        this.Xu.setDrawableId(i.e.dot_live_n);
        this.Xu.bX(i.e.dot_live_s);
        this.Xu.setSpacing(i.d.ds10);
        this.Xu.setGravity(17);
    }

    public void Ks() {
        this.dfn.setVisibility(0);
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dgY.hideNetRefreshView(this.mRoot);
    }

    public void vA() {
        this.dgY.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgY.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgY.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dgY.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dha != null && this.dha.getVisibility() == 0 && this.dhb != null) {
            this.dhb.notifyDataSetChanged();
        }
        if (this.apA != null && this.Xu != null) {
            this.apA.setDrawable(an.getDrawable(this.Xu.tm()));
            this.apA.setSelector(an.getDrawable(this.Xu.getSelectedId()));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgZ.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRoot;
    }
}

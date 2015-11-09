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
    private TextView WR;
    private TextView Xm;
    private com.baidu.tbadk.core.flow.a.c Xx;
    private NoNetworkView aRi;
    private IndicatorView ari;
    private View dgT;
    private TbImageView dgd;
    private TextView dgi;
    private SkinDetailActivity diE;
    private SkinProgressView diF;
    private HorizontalListView diG;
    private c diH;
    private int mFontSize;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int topMargin;
    private final int diC = 20;
    private final int diD = 10;
    private HorizontalListView.a diI = new g(this);

    public f(SkinDetailActivity skinDetailActivity) {
        this.topMargin = 0;
        this.diE = skinDetailActivity;
        this.topMargin = k.d(skinDetailActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.diE.getPageContext().getPageActivity()).inflate(i.g.skin_detail_activity_layout, (ViewGroup) null);
        this.diE.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_scrollview);
        this.mFontSize = k.d(this.diE.getPageContext().getPageActivity(), i.d.fontsize36);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_detail);
        this.aRi = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.WR = (TextView) this.mRoot.findViewById(i.f.textview_title);
        this.dgi = (TextView) this.mRoot.findViewById(i.f.textview_size);
        this.Xm = (TextView) this.mRoot.findViewById(i.f.textview_desc);
        this.dgd = (TbImageView) this.mRoot.findViewById(i.f.imageview_permission);
        this.dgd.setDefaultBgResource(i.e.transparent_bg);
        this.dgd.setDefaultResource(i.e.transparent_bg);
        this.dgd.setGifIconSupport(false);
        this.diF = (SkinProgressView) this.mRoot.findViewById(i.f.textview_download);
        this.diF.setFontSize(this.mFontSize);
        this.diF.setListenerTag(this.diE.getUniqueId());
        this.diG = (HorizontalListView) this.mRoot.findViewById(i.f.skin_detail_image_listview);
        this.diH = new c(this.diE.getPageContext());
        this.diG.setAdapter((ListAdapter) this.diH);
        this.ari = (IndicatorView) this.mRoot.findViewById(i.f.list_view_indicator);
        aAq();
        this.Xx.g(this.ari);
        this.diG.setOnScrollChangedListener(this.diI);
        this.diG.setOnItemClickListener(new h(this));
    }

    public void e(int i, float f) {
        if (this.diF != null) {
            int i2 = 0;
            if (this.mSkinData != null) {
                i2 = this.mSkinData.azX();
            }
            this.diF.a(i, 0.0f, i2);
        }
    }

    public void g(com.baidu.tieba.themeCenter.b bVar) {
        if (bVar == null) {
            KD();
            return;
        }
        this.mSkinData = bVar;
        KE();
        this.WR.setText(n.v(bVar.getTitle(), 20));
        this.dgd.d(bVar.aAb(), 10, false);
        this.dgi.setText(n.v(bVar.getPackageSize(), 10));
        this.Xm.setText(bVar.getDescription());
        this.diF.setSkinDetailPage(true);
        this.diF.setSkinData(this.mSkinData);
        this.diF.a(this.mSkinData.azY(), 0.0f, this.mSkinData.azX());
        if (bVar.azZ() == null || bVar.azZ().size() <= 0) {
            this.diG.setVisibility(8);
            this.ari.setVisibility(8);
            return;
        }
        this.diH.ah(bVar.azZ());
        this.diH.notifyDataSetChanged();
        this.diG.setVisibility(0);
        this.ari.setVisibility(0);
        if (bVar.azZ().size() == 1) {
            this.ari.setCount(0);
            return;
        }
        this.ari.setCount(bVar.azZ().size());
        this.ari.setPosition(0.0f);
    }

    public void KD() {
        this.dgT.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.diE.getPageContext().getResources().getString(i.h.no_data_text);
        this.diE.setNetRefreshViewTopMargin(this.topMargin);
        this.diE.showNetRefreshView(this.mRoot, string, false);
    }

    private void aAq() {
        this.Xx = new com.baidu.tbadk.core.flow.a.c();
        this.Xx.setDrawableId(i.e.dot_live_n);
        this.Xx.bX(i.e.dot_live_s);
        this.Xx.setSpacing(i.d.ds10);
        this.Xx.setGravity(17);
    }

    public void KE() {
        this.dgT.setVisibility(0);
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.diE.hideNetRefreshView(this.mRoot);
    }

    public void vB() {
        this.diE.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.diE.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.diE.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.diE.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.diG != null && this.diG.getVisibility() == 0 && this.diH != null) {
            this.diH.notifyDataSetChanged();
        }
        if (this.ari != null && this.Xx != null) {
            this.ari.setDrawable(an.getDrawable(this.Xx.tm()));
            this.ari.setSelector(an.getDrawable(this.Xx.getSelectedId()));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.diF.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRoot;
    }
}

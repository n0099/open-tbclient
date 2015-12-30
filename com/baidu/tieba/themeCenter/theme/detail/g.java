package com.baidu.tieba.themeCenter.theme.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class g {
    private TextView YC;
    private com.baidu.tbadk.core.flow.a.c YN;
    private TextView Yh;
    private IndicatorView ahm;
    private NoNetworkView bam;
    private TbImageView crQ;
    private View csp;
    private TextView dLt;
    private SkinDetailActivity dOq;
    private SkinProgressView dOr;
    private HorizontalListView dOs;
    private d dOt;
    private int mFontSize;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int topMargin;
    private final int dOo = 20;
    private final int dOp = 10;
    private HorizontalListView.a dOu = new h(this);

    public g(SkinDetailActivity skinDetailActivity) {
        this.topMargin = 0;
        this.dOq = skinDetailActivity;
        this.topMargin = k.d(skinDetailActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dOq.getPageContext().getPageActivity()).inflate(n.h.skin_detail_activity_layout, (ViewGroup) null);
        this.dOq.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_scrollview);
        this.mFontSize = k.d(this.dOq.getPageContext().getPageActivity(), n.e.fontsize36);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.theme_detail);
        this.bam = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.Yh = (TextView) this.mRoot.findViewById(n.g.textview_title);
        this.dLt = (TextView) this.mRoot.findViewById(n.g.textview_size);
        this.YC = (TextView) this.mRoot.findViewById(n.g.textview_desc);
        this.crQ = (TbImageView) this.mRoot.findViewById(n.g.imageview_permission);
        this.crQ.setDefaultBgResource(n.f.transparent_bg);
        this.crQ.setDefaultResource(n.f.transparent_bg);
        this.crQ.setGifIconSupport(false);
        this.dOr = (SkinProgressView) this.mRoot.findViewById(n.g.textview_download);
        this.dOr.setFontSize(this.mFontSize);
        this.dOr.setListenerTag(this.dOq.getUniqueId());
        this.dOs = (HorizontalListView) this.mRoot.findViewById(n.g.skin_detail_image_listview);
        this.dOt = new d(this.dOq.getPageContext());
        this.dOs.setAdapter((ListAdapter) this.dOt);
        this.ahm = (IndicatorView) this.mRoot.findViewById(n.g.list_view_indicator);
        aHQ();
        this.YN.g(this.ahm);
        this.dOs.setOnScrollChangedListener(this.dOu);
        this.dOs.setOnItemClickListener(new i(this));
    }

    public void e(int i, float f) {
        int i2;
        int i3 = 0;
        if (this.dOr != null) {
            if (this.mSkinData != null) {
                i2 = this.mSkinData.aHt();
                i3 = this.mSkinData.getActivityFinish();
            } else {
                i2 = 0;
            }
            this.dOr.b(i, 0.0f, i2, i3);
        }
    }

    public void i(com.baidu.tieba.themeCenter.b bVar) {
        if (bVar == null) {
            Mr();
            return;
        }
        this.mSkinData = bVar;
        Ms();
        this.Yh.setText(o.x(bVar.getTitle(), 20));
        this.crQ.d(bVar.aHx(), 10, false);
        this.dLt.setText(o.x(bVar.getPackageSize(), 10));
        this.YC.setText(bVar.getDescription());
        this.dOr.setSkinDetailPage(true);
        this.dOr.setSkinData(this.mSkinData);
        this.dOr.b(this.mSkinData.aHu(), 0.0f, this.mSkinData.aHt(), this.mSkinData.getActivityFinish());
        if (bVar.aHv() == null || bVar.aHv().size() <= 0) {
            this.dOs.setVisibility(8);
            this.ahm.setVisibility(8);
            return;
        }
        this.dOt.ao(bVar.aHv());
        this.dOt.notifyDataSetChanged();
        this.dOs.setVisibility(0);
        this.ahm.setVisibility(0);
        if (bVar.aHv().size() == 1) {
            this.ahm.setCount(0);
            return;
        }
        this.ahm.setCount(bVar.aHv().size());
        this.ahm.setPosition(0.0f);
    }

    public void Mr() {
        this.csp.setVisibility(8);
        as.j(this.mRoot, n.d.cp_bg_line_d);
        String string = this.dOq.getPageContext().getResources().getString(n.j.no_data_text);
        this.dOq.setNetRefreshViewTopMargin(this.topMargin);
        this.dOq.showNetRefreshView(this.mRoot, string, false);
    }

    private void aHQ() {
        this.YN = new com.baidu.tbadk.core.flow.a.c();
        this.YN.setDrawableId(n.f.point_live_n);
        this.YN.bY(n.f.point_live_s);
        this.YN.setSpacing(n.e.ds10);
        this.YN.setGravity(17);
    }

    public void Ms() {
        this.csp.setVisibility(0);
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dOq.hideNetRefreshView(this.mRoot);
    }

    public void vR() {
        this.dOq.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
        this.dOq.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dOq.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dOq.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dOs != null && this.dOs.getVisibility() == 0 && this.dOt != null) {
            this.dOt.notifyDataSetChanged();
        }
        if (this.ahm != null && this.YN != null) {
            this.ahm.setDrawable(as.getDrawable(this.YN.tB()));
            this.ahm.setSelector(as.getDrawable(this.YN.getSelectedId()));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dOr.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRoot;
    }
}

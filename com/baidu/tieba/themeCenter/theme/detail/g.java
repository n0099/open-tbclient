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
    private TextView XE;
    private TextView XZ;
    private com.baidu.tbadk.core.flow.a.c Yk;
    private NoNetworkView aWm;
    private IndicatorView agf;
    private TbImageView cnN;

    /* renamed from: com  reason: collision with root package name */
    private View f132com;
    private TextView dDP;
    private SkinDetailActivity dGP;
    private SkinProgressView dGQ;
    private HorizontalListView dGR;
    private d dGS;
    private int mFontSize;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int topMargin;
    private final int dGN = 20;
    private final int dGO = 10;
    private HorizontalListView.a dGT = new h(this);

    public g(SkinDetailActivity skinDetailActivity) {
        this.topMargin = 0;
        this.dGP = skinDetailActivity;
        this.topMargin = k.d(skinDetailActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dGP.getPageContext().getPageActivity()).inflate(n.g.skin_detail_activity_layout, (ViewGroup) null);
        this.dGP.setContentView(this.mRoot);
        this.f132com = this.mRoot.findViewById(n.f.body_scrollview);
        this.mFontSize = k.d(this.dGP.getPageContext().getPageActivity(), n.d.fontsize36);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.theme_detail);
        this.aWm = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.XE = (TextView) this.mRoot.findViewById(n.f.textview_title);
        this.dDP = (TextView) this.mRoot.findViewById(n.f.textview_size);
        this.XZ = (TextView) this.mRoot.findViewById(n.f.textview_desc);
        this.cnN = (TbImageView) this.mRoot.findViewById(n.f.imageview_permission);
        this.cnN.setDefaultBgResource(n.e.transparent_bg);
        this.cnN.setDefaultResource(n.e.transparent_bg);
        this.cnN.setGifIconSupport(false);
        this.dGQ = (SkinProgressView) this.mRoot.findViewById(n.f.textview_download);
        this.dGQ.setFontSize(this.mFontSize);
        this.dGQ.setListenerTag(this.dGP.getUniqueId());
        this.dGR = (HorizontalListView) this.mRoot.findViewById(n.f.skin_detail_image_listview);
        this.dGS = new d(this.dGP.getPageContext());
        this.dGR.setAdapter((ListAdapter) this.dGS);
        this.agf = (IndicatorView) this.mRoot.findViewById(n.f.list_view_indicator);
        aFB();
        this.Yk.g(this.agf);
        this.dGR.setOnScrollChangedListener(this.dGT);
        this.dGR.setOnItemClickListener(new i(this));
    }

    public void e(int i, float f) {
        int i2;
        int i3 = 0;
        if (this.dGQ != null) {
            if (this.mSkinData != null) {
                i2 = this.mSkinData.aFe();
                i3 = this.mSkinData.getActivityFinish();
            } else {
                i2 = 0;
            }
            this.dGQ.b(i, 0.0f, i2, i3);
        }
    }

    public void i(com.baidu.tieba.themeCenter.b bVar) {
        if (bVar == null) {
            LY();
            return;
        }
        this.mSkinData = bVar;
        LZ();
        this.XE.setText(o.w(bVar.getTitle(), 20));
        this.cnN.d(bVar.aFi(), 10, false);
        this.dDP.setText(o.w(bVar.getPackageSize(), 10));
        this.XZ.setText(bVar.getDescription());
        this.dGQ.setSkinDetailPage(true);
        this.dGQ.setSkinData(this.mSkinData);
        this.dGQ.b(this.mSkinData.aFf(), 0.0f, this.mSkinData.aFe(), this.mSkinData.getActivityFinish());
        if (bVar.aFg() == null || bVar.aFg().size() <= 0) {
            this.dGR.setVisibility(8);
            this.agf.setVisibility(8);
            return;
        }
        this.dGS.ao(bVar.aFg());
        this.dGS.notifyDataSetChanged();
        this.dGR.setVisibility(0);
        this.agf.setVisibility(0);
        if (bVar.aFg().size() == 1) {
            this.agf.setCount(0);
            return;
        }
        this.agf.setCount(bVar.aFg().size());
        this.agf.setPosition(0.0f);
    }

    public void LY() {
        this.f132com.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        String string = this.dGP.getPageContext().getResources().getString(n.i.no_data_text);
        this.dGP.setNetRefreshViewTopMargin(this.topMargin);
        this.dGP.showNetRefreshView(this.mRoot, string, false);
    }

    private void aFB() {
        this.Yk = new com.baidu.tbadk.core.flow.a.c();
        this.Yk.setDrawableId(n.e.point_live_n);
        this.Yk.cf(n.e.point_live_s);
        this.Yk.setSpacing(n.d.ds10);
        this.Yk.setGravity(17);
    }

    public void LZ() {
        this.f132com.setVisibility(0);
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dGP.hideNetRefreshView(this.mRoot);
    }

    public void wh() {
        this.dGP.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.dGP.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dGP.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dGP.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.dGR != null && this.dGR.getVisibility() == 0 && this.dGS != null) {
            this.dGS.notifyDataSetChanged();
        }
        if (this.agf != null && this.Yk != null) {
            this.agf.setDrawable(as.getDrawable(this.Yk.tR()));
            this.agf.setSelector(as.getDrawable(this.Yk.getSelectedId()));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dGQ.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRoot;
    }
}

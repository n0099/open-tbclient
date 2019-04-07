package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private g cXp;
    private NoNetworkView dbq;
    private NoNetworkView.a emy;
    private com.baidu.tbadk.core.dialog.a eoT;
    private com.baidu.tieba.interestlabel.model.a gDE;
    private View gDF;
    private TextView gDG;
    private GridLineView gDH;
    private com.baidu.tieba.interestlabel.a.b gDI;
    private boolean gDJ;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.emy = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && LabelSettingView.this.gDI.getCount() == 0 && LabelSettingView.this.gDE != null) {
                    LabelSettingView.this.gDE.byO();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gDE = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.dbq = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.gDH = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.gDF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.gDG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.dbq.a(this.emy);
        this.eoT = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eoT.lz(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.eoT.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eoT.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eoT.b(this.mPageContext);
        this.gDI = new com.baidu.tieba.interestlabel.a.b(this);
        this.gDH.setAdapter((ListAdapter) this.gDI);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.T(bVar.byS())) {
            this.gDH.setVisibility(0);
            this.gDI.setData(bVar);
            this.gDI.notifyDataSetChanged();
        }
    }

    public void lS(boolean z) {
        this.gDJ = z;
        this.gDG.setSelected(z);
    }

    public boolean bze() {
        return (this.gDI == null || v.c(this.gDI.byP(), this.gDI.byQ())) ? false : true;
    }

    public void showDialog() {
        this.eoT.aaW();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gDG != null) {
                al.j(this.gDG, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dbq != null) {
                this.dbq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gDH != null) {
                this.gDH.onChangeSkinType();
            }
            if (this.cXp != null) {
                this.cXp.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDF) {
            if (bze()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.gDG && this.gDE != null && this.gDJ) {
            TiebaStatic.log(new am("c12237").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            this.gDE.cZ(this.gDI.byQ());
        }
    }

    public void cE(boolean z) {
        if (!aXo()) {
            if (this.cXp == null) {
                this.cXp = new g(getContext());
                this.cXp.onChangeSkinType();
            }
            this.cXp.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXp != null) {
            this.cXp.dettachView(this);
            this.cXp = null;
        }
    }

    public boolean aXo() {
        if (this.cXp != null) {
            return this.cXp.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXp()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && LabelSettingView.this.gDE != null) {
                            LabelSettingView.this.gDE.byO();
                        }
                    }
                });
            }
            this.mRefreshView.jQ(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.any();
            this.gDH.setVisibility(8);
        }
    }

    public void aBq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXp() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.dbq != null) {
            this.dbq.b(this.emy);
        }
        this.eoT.dismiss();
        hideLoadingView();
        aBq();
    }
}

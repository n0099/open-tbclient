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
    private g cXm;
    private NoNetworkView dbm;
    private NoNetworkView.a emM;
    private com.baidu.tbadk.core.dialog.a eph;
    private com.baidu.tieba.interestlabel.model.a gDQ;
    private View gDR;
    private TextView gDS;
    private GridLineView gDT;
    private com.baidu.tieba.interestlabel.a.b gDU;
    private boolean gDV;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.emM = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && LabelSettingView.this.gDU.getCount() == 0 && LabelSettingView.this.gDQ != null) {
                    LabelSettingView.this.gDQ.byR();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gDQ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.dbm = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.gDT = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.gDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.gDS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.dbm.a(this.emM);
        this.eph = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eph.ly(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.eph.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eph.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eph.b(this.mPageContext);
        this.gDU = new com.baidu.tieba.interestlabel.a.b(this);
        this.gDT.setAdapter((ListAdapter) this.gDU);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.T(bVar.byV())) {
            this.gDT.setVisibility(0);
            this.gDU.setData(bVar);
            this.gDU.notifyDataSetChanged();
        }
    }

    public void lS(boolean z) {
        this.gDV = z;
        this.gDS.setSelected(z);
    }

    public boolean bzh() {
        return (this.gDU == null || v.c(this.gDU.byS(), this.gDU.byT())) ? false : true;
    }

    public void showDialog() {
        this.eph.aaZ();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gDS != null) {
                al.j(this.gDS, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dbm != null) {
                this.dbm.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gDT != null) {
                this.gDT.onChangeSkinType();
            }
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDR) {
            if (bzh()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.gDS && this.gDQ != null && this.gDV) {
            TiebaStatic.log(new am("c12237").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            this.gDQ.dc(this.gDU.byT());
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXm == null) {
                this.cXm = new g(getContext());
                this.cXm.onChangeSkinType();
            }
            this.cXm.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
        }
    }

    public boolean aXq() {
        if (this.cXm != null) {
            return this.cXm.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXr()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && LabelSettingView.this.gDQ != null) {
                            LabelSettingView.this.gDQ.byR();
                        }
                    }
                });
            }
            this.mRefreshView.jR(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anB();
            this.gDT.setVisibility(8);
        }
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXr() {
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
        if (this.dbm != null) {
            this.dbm.b(this.emM);
        }
        this.eph.dismiss();
        hideLoadingView();
        aBt();
    }
}

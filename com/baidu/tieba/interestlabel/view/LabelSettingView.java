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
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bGG;
    private NoNetworkView bKI;
    private NoNetworkView.a cSD;
    private com.baidu.tbadk.core.dialog.a cUX;
    private com.baidu.tieba.interestlabel.model.a fdh;
    private View fdi;
    private TextView fdj;
    private GridLineView fdk;
    private com.baidu.tieba.interestlabel.a.b fdl;
    private boolean fdm;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bE(boolean z) {
                if (z && LabelSettingView.this.fdl.getCount() == 0 && LabelSettingView.this.fdh != null) {
                    LabelSettingView.this.fdh.aVg();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fdh = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bKI = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fdk = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fdi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fdj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bKI.a(this.cSD);
        this.cUX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cUX.ej(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.cUX.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cUX.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cUX.b(this.mPageContext);
        this.fdl = new com.baidu.tieba.interestlabel.a.b(this);
        this.fdk.setAdapter((ListAdapter) this.fdl);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aVk())) {
            this.fdk.setVisibility(0);
            this.fdl.setData(bVar);
            this.fdl.notifyDataSetChanged();
        }
    }

    public void jl(boolean z) {
        this.fdm = z;
        this.fdj.setSelected(z);
    }

    public boolean aVw() {
        return (this.fdl == null || v.c(this.fdl.aVh(), this.fdl.aVi())) ? false : true;
    }

    public void showDialog() {
        this.cUX.AB();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fdj != null) {
                al.h(this.fdj, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bKI != null) {
                this.bKI.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fdk != null) {
                this.fdk.onChangeSkinType();
            }
            if (this.bGG != null) {
                this.bGG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fdi) {
            if (aVw()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fdj && this.fdh != null && this.fdm) {
            TiebaStatic.log(new am("c12237").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fdh.cK(this.fdl.aVi());
        }
    }

    public void showLoadingView(boolean z) {
        if (!aKY()) {
            if (this.bGG == null) {
                this.bGG = new f(getContext());
                this.bGG.onChangeSkinType();
            }
            this.bGG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bGG != null) {
            this.bGG.dettachView(this);
            this.bGG = null;
        }
    }

    public boolean aKY() {
        if (this.bGG != null) {
            return this.bGG.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!aIj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK() && LabelSettingView.this.fdh != null) {
                            LabelSettingView.this.fdh.aVg();
                        }
                    }
                });
            }
            this.mRefreshView.fP(this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.MH();
            this.fdk.setVisibility(8);
        }
    }

    public void ZS() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aIj() {
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
        if (this.bKI != null) {
            this.bKI.b(this.cSD);
        }
        this.cUX.dismiss();
        hideLoadingView();
        ZS();
    }
}

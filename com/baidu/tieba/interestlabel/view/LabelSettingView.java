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
    private f bKv;
    private NoNetworkView bOx;
    private NoNetworkView.a cZk;
    private com.baidu.tbadk.core.dialog.a dbG;
    private com.baidu.tieba.interestlabel.model.a fjZ;
    private View fka;
    private TextView fkb;
    private GridLineView fkc;
    private com.baidu.tieba.interestlabel.a.b fkd;
    private boolean fke;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                if (z && LabelSettingView.this.fkd.getCount() == 0 && LabelSettingView.this.fjZ != null) {
                    LabelSettingView.this.fjZ.aWX();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fjZ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bOx = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fkc = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fka = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fkb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bOx.a(this.cZk);
        this.dbG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.dbG.eB(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.dbG.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.dbG.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.dbG.b(this.mPageContext);
        this.fkd = new com.baidu.tieba.interestlabel.a.b(this);
        this.fkc.setAdapter((ListAdapter) this.fkd);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aXb())) {
            this.fkc.setVisibility(0);
            this.fkd.setData(bVar);
            this.fkd.notifyDataSetChanged();
        }
    }

    public void jo(boolean z) {
        this.fke = z;
        this.fkb.setSelected(z);
    }

    public boolean aXn() {
        return (this.fkd == null || v.c(this.fkd.aWY(), this.fkd.aWZ())) ? false : true;
    }

    public void showDialog() {
        this.dbG.BF();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fkb != null) {
                al.h(this.fkb, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bOx != null) {
                this.bOx.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fkc != null) {
                this.fkc.onChangeSkinType();
            }
            if (this.bKv != null) {
                this.bKv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fka) {
            if (aXn()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fkb && this.fjZ != null && this.fke) {
            TiebaStatic.log(new am("c12237").aA("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fjZ.cO(this.fkd.aWZ());
        }
    }

    public void showLoadingView(boolean z) {
        if (!aMP()) {
            if (this.bKv == null) {
                this.bKv = new f(getContext());
                this.bKv.onChangeSkinType();
            }
            this.bKv.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bKv != null) {
            this.bKv.dettachView(this);
            this.bKv = null;
        }
    }

    public boolean aMP() {
        if (this.bKv != null) {
            return this.bKv.isViewAttached();
        }
        return false;
    }

    public void jp(boolean z) {
        if (!aKa()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK() && LabelSettingView.this.fjZ != null) {
                            LabelSettingView.this.fjZ.aWX();
                        }
                    }
                });
            }
            this.mRefreshView.gd(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.NL();
            this.fkc.setVisibility(8);
        }
    }

    public void aaY() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aKa() {
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
        if (this.bOx != null) {
            this.bOx.b(this.cZk);
        }
        this.dbG.dismiss();
        hideLoadingView();
        aaY();
    }
}

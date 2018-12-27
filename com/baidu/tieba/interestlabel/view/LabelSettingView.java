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
    private f bKy;
    private NoNetworkView bOA;
    private NoNetworkView.a dcc;
    private com.baidu.tbadk.core.dialog.a dez;
    private com.baidu.tieba.interestlabel.model.a fmQ;
    private View fmR;
    private TextView fmS;
    private GridLineView fmT;
    private com.baidu.tieba.interestlabel.a.b fmU;
    private boolean fmV;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                if (z && LabelSettingView.this.fmU.getCount() == 0 && LabelSettingView.this.fmQ != null) {
                    LabelSettingView.this.fmQ.aXL();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fmQ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bOA = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fmT = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fmR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fmS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bOA.a(this.dcc);
        this.dez = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.dez.eB(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.dez.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.dez.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.dez.b(this.mPageContext);
        this.fmU = new com.baidu.tieba.interestlabel.a.b(this);
        this.fmT.setAdapter((ListAdapter) this.fmU);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aXP())) {
            this.fmT.setVisibility(0);
            this.fmU.setData(bVar);
            this.fmU.notifyDataSetChanged();
        }
    }

    public void jr(boolean z) {
        this.fmV = z;
        this.fmS.setSelected(z);
    }

    public boolean aYb() {
        return (this.fmU == null || v.c(this.fmU.aXM(), this.fmU.aXN())) ? false : true;
    }

    public void showDialog() {
        this.dez.BF();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fmS != null) {
                al.h(this.fmS, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bOA != null) {
                this.bOA.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fmT != null) {
                this.fmT.onChangeSkinType();
            }
            if (this.bKy != null) {
                this.bKy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmR) {
            if (aYb()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fmS && this.fmQ != null && this.fmV) {
            TiebaStatic.log(new am("c12237").aA("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fmQ.cP(this.fmU.aXN());
        }
    }

    public void showLoadingView(boolean z) {
        if (!aND()) {
            if (this.bKy == null) {
                this.bKy = new f(getContext());
                this.bKy.onChangeSkinType();
            }
            this.bKy.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this);
            this.bKy = null;
        }
    }

    public boolean aND() {
        if (this.bKy != null) {
            return this.bKy.isViewAttached();
        }
        return false;
    }

    public void js(boolean z) {
        if (!aKP()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK() && LabelSettingView.this.fmQ != null) {
                            LabelSettingView.this.fmQ.aXL();
                        }
                    }
                });
            }
            this.mRefreshView.ge(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.NM();
            this.fmT.setVisibility(8);
        }
    }

    public void aba() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aKP() {
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
        if (this.bOA != null) {
            this.bOA.b(this.dcc);
        }
        this.dez.dismiss();
        hideLoadingView();
        aba();
    }
}

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
    private NoNetworkView bBq;
    private f bxm;
    private NoNetworkView.a cJe;
    private com.baidu.tbadk.core.dialog.a cLy;
    private com.baidu.tieba.interestlabel.model.a eUe;
    private View eUf;
    private TextView eUg;
    private GridLineView eUh;
    private com.baidu.tieba.interestlabel.a.b eUi;
    private boolean eUj;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bd(boolean z) {
                if (z && LabelSettingView.this.eUi.getCount() == 0 && LabelSettingView.this.eUe != null) {
                    LabelSettingView.this.eUe.aSv();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eUe = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bBq = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.eUh = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.eUf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eUg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bBq.a(this.cJe);
        this.cLy = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cLy.dT(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.cLy.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cLy.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cLy.b(this.mPageContext);
        this.eUi = new com.baidu.tieba.interestlabel.a.b(this);
        this.eUh.setAdapter((ListAdapter) this.eUi);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.z(bVar.aSz())) {
            this.eUh.setVisibility(0);
            this.eUi.setData(bVar);
            this.eUi.notifyDataSetChanged();
        }
    }

    public void iJ(boolean z) {
        this.eUj = z;
        this.eUg.setSelected(z);
    }

    public boolean aSL() {
        return (this.eUi == null || v.c(this.eUi.aSw(), this.eUi.aSx())) ? false : true;
    }

    public void showDialog() {
        this.cLy.yl();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eUg != null) {
                al.h(this.eUg, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bBq != null) {
                this.bBq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eUh != null) {
                this.eUh.onChangeSkinType();
            }
            if (this.bxm != null) {
                this.bxm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eUf) {
            if (aSL()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eUg && this.eUe != null && this.eUj) {
            TiebaStatic.log(new am("c12237").al("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eUe.cx(this.eUi.aSx());
        }
    }

    public void hs(boolean z) {
        if (!aIi()) {
            if (this.bxm == null) {
                this.bxm = new f(getContext());
                this.bxm.onChangeSkinType();
            }
            this.bxm.c(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this);
            this.bxm = null;
        }
    }

    public boolean aIi() {
        if (this.bxm != null) {
            return this.bxm.Ks();
        }
        return false;
    }

    public void iK(boolean z) {
        if (!aFt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ky() && LabelSettingView.this.eUe != null) {
                            LabelSettingView.this.eUe.aSv();
                        }
                    }
                });
            }
            this.mRefreshView.fs(this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds380));
            this.mRefreshView.c(this, z);
            this.mRefreshView.KA();
            this.eUh.setVisibility(8);
        }
    }

    public void Wa() {
        if (this.mRefreshView != null) {
            this.mRefreshView.ad(this);
            this.mRefreshView = null;
        }
    }

    public boolean aFt() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Ks();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.bBq != null) {
            this.bBq.b(this.cJe);
        }
        this.cLy.dismiss();
        hideLoadingView();
        Wa();
    }
}

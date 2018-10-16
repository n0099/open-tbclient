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
    private f bFV;
    private NoNetworkView bJX;
    private NoNetworkView.a cRx;
    private com.baidu.tbadk.core.dialog.a cTR;
    private com.baidu.tieba.interestlabel.model.a fbM;
    private View fbN;
    private TextView fbO;
    private GridLineView fbP;
    private com.baidu.tieba.interestlabel.a.b fbQ;
    private boolean fbR;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bn(boolean z) {
                if (z && LabelSettingView.this.fbQ.getCount() == 0 && LabelSettingView.this.fbM != null) {
                    LabelSettingView.this.fbM.aVJ();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fbM = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bJX = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fbP = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fbN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fbO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bJX.a(this.cRx);
        this.cTR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cTR.ej(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.cTR.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cTR.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cTR.b(this.mPageContext);
        this.fbQ = new com.baidu.tieba.interestlabel.a.b(this);
        this.fbP.setAdapter((ListAdapter) this.fbQ);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.J(bVar.aVN())) {
            this.fbP.setVisibility(0);
            this.fbQ.setData(bVar);
            this.fbQ.notifyDataSetChanged();
        }
    }

    public void jb(boolean z) {
        this.fbR = z;
        this.fbO.setSelected(z);
    }

    public boolean aVZ() {
        return (this.fbQ == null || v.c(this.fbQ.aVK(), this.fbQ.aVL())) ? false : true;
    }

    public void showDialog() {
        this.cTR.Au();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fbO != null) {
                al.h(this.fbO, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bJX != null) {
                this.bJX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fbP != null) {
                this.fbP.onChangeSkinType();
            }
            if (this.bFV != null) {
                this.bFV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbN) {
            if (aVZ()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fbO && this.fbM != null && this.fbR) {
            TiebaStatic.log(new am("c12237").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fbM.cM(this.fbQ.aVL());
        }
    }

    public void hK(boolean z) {
        if (!aLA()) {
            if (this.bFV == null) {
                this.bFV = new f(getContext());
                this.bFV.onChangeSkinType();
            }
            this.bFV.c(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bFV != null) {
            this.bFV.ad(this);
            this.bFV = null;
        }
    }

    public boolean aLA() {
        if (this.bFV != null) {
            return this.bFV.Mq();
        }
        return false;
    }

    public void jc(boolean z) {
        if (!aIL()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && LabelSettingView.this.fbM != null) {
                            LabelSettingView.this.fbM.aVJ();
                        }
                    }
                });
            }
            this.mRefreshView.fB(this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds380));
            this.mRefreshView.c(this, z);
            this.mRefreshView.My();
            this.fbP.setVisibility(8);
        }
    }

    public void ZH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.ad(this);
            this.mRefreshView = null;
        }
    }

    public boolean aIL() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Mq();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.bJX != null) {
            this.bJX.b(this.cRx);
        }
        this.cTR.dismiss();
        hideLoadingView();
        ZH();
    }
}

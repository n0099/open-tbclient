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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bqL;
    private NoNetworkView buT;
    private NoNetworkView.a cAL;
    private com.baidu.tbadk.core.dialog.a cDe;
    private com.baidu.tieba.interestlabel.model.a eIU;
    private View eIV;
    private TextView eIW;
    private GridLineView eIX;
    private com.baidu.tieba.interestlabel.a.b eIY;
    private boolean eIZ;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aS(boolean z) {
                if (z && LabelSettingView.this.eIY.getCount() == 0 && LabelSettingView.this.eIU != null) {
                    LabelSettingView.this.eIU.aPk();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eIU = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.buT = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eIX = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.k.choose_interest_label));
        this.eIV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eIW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.item_label_setting_nav_complete, this);
        this.buT.a(this.cAL);
        this.cDe = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cDe.dE(this.mPageContext.getString(d.k.confirm_give_up_label));
        this.cDe.a(this.mPageContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cDe.b(this.mPageContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cDe.b(this.mPageContext);
        this.eIY = new com.baidu.tieba.interestlabel.a.b(this);
        this.eIX.setAdapter((ListAdapter) this.eIY);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.A(bVar.aPo())) {
            this.eIX.setVisibility(0);
            this.eIY.setData(bVar);
            this.eIY.notifyDataSetChanged();
        }
    }

    public void ii(boolean z) {
        this.eIZ = z;
        this.eIW.setSelected(z);
    }

    public boolean aPA() {
        return (this.eIY == null || w.c(this.eIY.aPl(), this.eIY.aPm())) ? false : true;
    }

    public void showDialog() {
        this.cDe.xn();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eIW != null) {
                am.h(this.eIW, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.buT != null) {
                this.buT.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eIX != null) {
                this.eIX.onChangeSkinType();
            }
            if (this.bqL != null) {
                this.bqL.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eIV) {
            if (aPA()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eIW && this.eIU != null && this.eIZ) {
            TiebaStatic.log(new an("c12237").ah("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eIU.cw(this.eIY.aPm());
        }
    }

    public void gR(boolean z) {
        if (!aEW()) {
            if (this.bqL == null) {
                this.bqL = new f(getContext());
                this.bqL.onChangeSkinType();
            }
            this.bqL.d(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bqL != null) {
            this.bqL.Q(this);
            this.bqL = null;
        }
    }

    public boolean aEW() {
        if (this.bqL != null) {
            return this.bqL.Jh();
        }
        return false;
    }

    public void ij(boolean z) {
        if (!aCB()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jr() && LabelSettingView.this.eIU != null) {
                            LabelSettingView.this.eIU.aPk();
                        }
                    }
                });
            }
            this.mRefreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.d(this, z);
            this.mRefreshView.Jp();
            this.eIX.setVisibility(8);
        }
    }

    public void Uc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this);
            this.mRefreshView = null;
        }
    }

    public boolean aCB() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Jh();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.buT != null) {
            this.buT.b(this.cAL);
        }
        this.cDe.dismiss();
        hideLoadingView();
        Uc();
    }
}

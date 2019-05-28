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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private g dhY;
    private NoNetworkView dlX;
    private NoNetworkView.a eCl;
    private com.baidu.tbadk.core.dialog.a eEC;
    private com.baidu.tieba.interestlabel.model.a gUY;
    private View gUZ;
    private TextView gVa;
    private GridLineView gVb;
    private com.baidu.tieba.interestlabel.a.b gVc;
    private boolean gVd;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && LabelSettingView.this.gVc.getCount() == 0 && LabelSettingView.this.gUY != null) {
                    LabelSettingView.this.gUY.bGB();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gUY = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dlX = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.gVb = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.gUZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.gVa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dlX.a(this.eCl);
        this.eEC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eEC.mE(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eEC.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eEC.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eEC.b(this.mPageContext);
        this.gVc = new com.baidu.tieba.interestlabel.a.b(this);
        this.gVb.setAdapter((ListAdapter) this.gVc);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bGF())) {
            this.gVb.setVisibility(0);
            this.gVc.setData(bVar);
            this.gVc.notifyDataSetChanged();
        }
    }

    public void mH(boolean z) {
        this.gVd = z;
        this.gVa.setSelected(z);
    }

    public boolean bGR() {
        return (this.gVc == null || v.c(this.gVc.bGC(), this.gVc.bGD())) ? false : true;
    }

    public void showDialog() {
        this.eEC.afG();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gVa != null) {
                al.j(this.gVa, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dlX != null) {
                this.dlX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gVb != null) {
                this.gVb.onChangeSkinType();
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUZ) {
            if (bGR()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.gVa && this.gUY != null && this.gVd) {
            TiebaStatic.log(new am("c12237").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            this.gUY.dh(this.gVc.bGD());
        }
    }

    public void cV(boolean z) {
        if (!beF()) {
            if (this.dhY == null) {
                this.dhY = new g(getContext());
                this.dhY.onChangeSkinType();
            }
            this.dhY.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
        }
    }

    public boolean beF() {
        if (this.dhY != null) {
            return this.dhY.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beG()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && LabelSettingView.this.gUY != null) {
                            LabelSettingView.this.gUY.bGB();
                        }
                    }
                });
            }
            this.mRefreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.gVb.setVisibility(8);
        }
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beG() {
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
        if (this.dlX != null) {
            this.dlX.b(this.eCl);
        }
        this.eEC.dismiss();
        hideLoadingView();
        aHK();
    }
}

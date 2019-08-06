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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View bCe;
    private g djN;
    private NoNetworkView dnM;
    private NoNetworkView.a eHo;
    private com.baidu.tbadk.core.dialog.a eJF;
    private com.baidu.tieba.interestlabel.model.a hcd;
    private TextView hce;
    private GridLineView hcf;
    private com.baidu.tieba.interestlabel.a.b hcg;
    private boolean hch;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && LabelSettingView.this.hcg.getCount() == 0 && LabelSettingView.this.hcd != null) {
                    LabelSettingView.this.hcd.bJx();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hcd = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dnM = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hcf = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.bCe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hce = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dnM.a(this.eHo);
        this.eJF = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eJF.mO(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eJF.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eJF.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eJF.b(this.mPageContext);
        this.hcg = new com.baidu.tieba.interestlabel.a.b(this);
        this.hcf.setAdapter((ListAdapter) this.hcg);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bJB())) {
            this.hcf.setVisibility(0);
            this.hcg.setData(bVar);
            this.hcg.notifyDataSetChanged();
        }
    }

    public void mW(boolean z) {
        this.hch = z;
        this.hce.setSelected(z);
    }

    public boolean bJN() {
        return (this.hcg == null || v.c(this.hcg.bJy(), this.hcg.bJz())) ? false : true;
    }

    public void showDialog() {
        this.eJF.agK();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hce != null) {
                am.j(this.hce, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dnM != null) {
                this.dnM.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hcf != null) {
                this.hcf.onChangeSkinType();
            }
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCe) {
            if (bJN()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hce && this.hcd != null && this.hch) {
            TiebaStatic.log(new an("c12237").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hcd.di(this.hcg.bJz());
        }
    }

    public void cY(boolean z) {
        if (!bgL()) {
            if (this.djN == null) {
                this.djN = new g(getContext());
                this.djN.onChangeSkinType();
            }
            this.djN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
        }
    }

    public boolean bgL() {
        if (this.djN != null) {
            return this.djN.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && LabelSettingView.this.hcd != null) {
                            LabelSettingView.this.hcd.bJx();
                        }
                    }
                });
            }
            this.mRefreshView.kL(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atK();
            this.hcf.setVisibility(8);
        }
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bgM() {
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
        if (this.dnM != null) {
            this.dnM.b(this.eHo);
        }
        this.eJF.dismiss();
        hideLoadingView();
        aJj();
    }
}

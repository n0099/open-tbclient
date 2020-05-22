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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View dyp;
    private NoNetworkView.a faq;
    private NoNetworkView fbX;
    private g fkQ;
    private com.baidu.tieba.interestlabel.model.a iVC;
    private TextView iVD;
    private GridLineView iVE;
    private com.baidu.tieba.interestlabel.a.b iVF;
    private com.baidu.tbadk.core.dialog.a iVG;
    private boolean iVH;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.faq = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.iVF.getCount() == 0 && LabelSettingView.this.iVC != null) {
                    LabelSettingView.this.iVC.csq();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iVC = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fbX = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.iVE = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.iVD = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fbX.a(this.faq);
        this.iVG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.iVG.vO(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.iVG.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.iVG.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iVG.b(this.mPageContext);
        this.iVF = new com.baidu.tieba.interestlabel.a.b(this);
        this.iVE.setAdapter((ListAdapter) this.iVF);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.csu())) {
            this.iVE.setVisibility(0);
            this.iVF.setData(bVar);
            this.iVF.notifyDataSetChanged();
        }
    }

    public void pX(boolean z) {
        this.iVH = z;
        this.iVD.setSelected(z);
    }

    public boolean csG() {
        return (this.iVF == null || v.equalList(this.iVF.csr(), this.iVF.css())) ? false : true;
    }

    public void showDialog() {
        this.iVG.aST();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iVD != null) {
                am.setViewTextColor(this.iVD, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fbX != null) {
                this.fbX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iVE != null) {
                this.iVE.onChangeSkinType();
            }
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iVF != null) {
                this.iVF.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyp) {
            if (csG()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.iVD && this.iVC != null && this.iVH) {
            TiebaStatic.log(new an("c12237").dh("uid", TbadkCoreApplication.getCurrentAccount()));
            this.iVC.dp(this.iVF.css());
        }
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(getContext());
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.iVC != null) {
                            LabelSettingView.this.iVC.csq();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iVE.setVisibility(8);
        }
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPM() {
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
        if (this.fbX != null) {
            this.fbX.b(this.faq);
        }
        this.iVG.dismiss();
        hideLoadingView();
        bqO();
    }
}

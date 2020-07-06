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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View dDv;
    private NoNetworkView.a flL;
    private NoNetworkView fns;
    private g fwo;
    private com.baidu.tieba.interestlabel.model.a jnC;
    private TextView jnD;
    private GridLineView jnE;
    private com.baidu.tieba.interestlabel.a.b jnF;
    private com.baidu.tbadk.core.dialog.a jnG;
    private boolean jnH;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.flL = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.jnF.getCount() == 0 && LabelSettingView.this.jnC != null) {
                    LabelSettingView.this.jnC.cwq();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jnC = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fns = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.jnE = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dDv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.jnD = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fns.a(this.flL);
        this.jnG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.jnG.we(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.jnG.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.jnG.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jnG.b(this.mPageContext);
        this.jnF = new com.baidu.tieba.interestlabel.a.b(this);
        this.jnE.setAdapter((ListAdapter) this.jnF);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.isEmpty(bVar.cwu())) {
            this.jnE.setVisibility(0);
            this.jnF.setData(bVar);
            this.jnF.notifyDataSetChanged();
        }
    }

    public void qh(boolean z) {
        this.jnH = z;
        this.jnD.setSelected(z);
    }

    public boolean cwG() {
        return (this.jnF == null || w.equalList(this.jnF.cwr(), this.jnF.cws())) ? false : true;
    }

    public void showDialog() {
        this.jnG.aUN();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jnD != null) {
                an.setViewTextColor(this.jnD, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fns != null) {
                this.fns.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jnE != null) {
                this.jnE.onChangeSkinType();
            }
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jnF != null) {
                this.jnF.notifyDataSetChanged();
            }
            setBackgroundColor(an.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dDv) {
            if (cwG()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.jnD && this.jnC != null && this.jnH) {
            TiebaStatic.log(new ao("c12237").dk("uid", TbadkCoreApplication.getCurrentAccount()));
            this.jnC.dE(this.jnF.cws());
        }
    }

    public void ga(boolean z) {
        if (!bSR()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public boolean bSR() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void mB(boolean z) {
        if (!bSS()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.jnC != null) {
                            LabelSettingView.this.jnC.cwq();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jnE.setVisibility(8);
        }
    }

    public void btO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bSS() {
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
        if (this.fns != null) {
            this.fns.b(this.flL);
        }
        this.jnG.dismiss();
        hideLoadingView();
        btO();
    }
}

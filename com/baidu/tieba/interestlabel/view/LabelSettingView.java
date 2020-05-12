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
    private View dkp;
    private NoNetworkView ePq;
    private g eYg;
    private NoNetworkView.a gGr;
    private com.baidu.tieba.interestlabel.model.a iGE;
    private TextView iGF;
    private GridLineView iGG;
    private com.baidu.tieba.interestlabel.a.b iGH;
    private com.baidu.tbadk.core.dialog.a iGI;
    private boolean iGJ;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.iGH.getCount() == 0 && LabelSettingView.this.iGE != null) {
                    LabelSettingView.this.iGE.clO();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iGE = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.ePq = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.iGG = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dkp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.iGF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.ePq.a(this.gGr);
        this.iGI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.iGI.ui(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.iGI.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.iGI.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iGI.b(this.mPageContext);
        this.iGH = new com.baidu.tieba.interestlabel.a.b(this);
        this.iGG.setAdapter((ListAdapter) this.iGH);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.clS())) {
            this.iGG.setVisibility(0);
            this.iGH.setData(bVar);
            this.iGH.notifyDataSetChanged();
        }
    }

    public void pA(boolean z) {
        this.iGJ = z;
        this.iGF.setSelected(z);
    }

    public boolean cme() {
        return (this.iGH == null || v.equalList(this.iGH.clP(), this.iGH.clQ())) ? false : true;
    }

    public void showDialog() {
        this.iGI.aMS();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iGF != null) {
                am.setViewTextColor(this.iGF, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.ePq != null) {
                this.ePq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iGG != null) {
                this.iGG.onChangeSkinType();
            }
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iGH != null) {
                this.iGH.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dkp) {
            if (cme()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.iGF && this.iGE != null && this.iGJ) {
            TiebaStatic.log(new an("c12237").cI("uid", TbadkCoreApplication.getCurrentAccount()));
            this.iGE.dr(this.iGH.clQ());
        }
    }

    public void fK(boolean z) {
        if (!bJs()) {
            if (this.eYg == null) {
                this.eYg = new g(getContext());
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
        }
    }

    public boolean bJs() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.iGE != null) {
                            LabelSettingView.this.iGE.clO();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iGG.setVisibility(8);
        }
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJt() {
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
        if (this.ePq != null) {
            this.ePq.b(this.gGr);
        }
        this.iGI.dismiss();
        hideLoadingView();
        blr();
    }
}

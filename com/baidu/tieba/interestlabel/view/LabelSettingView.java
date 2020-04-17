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
    private View dkl;
    private NoNetworkView ePl;
    private g eYb;
    private NoNetworkView.a gGl;
    private GridLineView iGA;
    private com.baidu.tieba.interestlabel.a.b iGB;
    private com.baidu.tbadk.core.dialog.a iGC;
    private boolean iGD;
    private com.baidu.tieba.interestlabel.model.a iGy;
    private TextView iGz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.iGB.getCount() == 0 && LabelSettingView.this.iGy != null) {
                    LabelSettingView.this.iGy.clP();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iGy = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.ePl = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.iGA = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dkl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.iGz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.ePl.a(this.gGl);
        this.iGC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.iGC.uf(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.iGC.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.iGC.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iGC.b(this.mPageContext);
        this.iGB = new com.baidu.tieba.interestlabel.a.b(this);
        this.iGA.setAdapter((ListAdapter) this.iGB);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.clT())) {
            this.iGA.setVisibility(0);
            this.iGB.setData(bVar);
            this.iGB.notifyDataSetChanged();
        }
    }

    public void pA(boolean z) {
        this.iGD = z;
        this.iGz.setSelected(z);
    }

    public boolean cmf() {
        return (this.iGB == null || v.equalList(this.iGB.clQ(), this.iGB.clR())) ? false : true;
    }

    public void showDialog() {
        this.iGC.aMU();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iGz != null) {
                am.setViewTextColor(this.iGz, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.ePl != null) {
                this.ePl.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iGA != null) {
                this.iGA.onChangeSkinType();
            }
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iGB != null) {
                this.iGB.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dkl) {
            if (cmf()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.iGz && this.iGy != null && this.iGD) {
            TiebaStatic.log(new an("c12237").cI("uid", TbadkCoreApplication.getCurrentAccount()));
            this.iGy.dr(this.iGB.clR());
        }
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new g(getContext());
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.iGy != null) {
                            LabelSettingView.this.iGy.clP();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iGA.setVisibility(8);
        }
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJu() {
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
        if (this.ePl != null) {
            this.ePl.b(this.gGl);
        }
        this.iGC.dismiss();
        hideLoadingView();
        blt();
    }
}

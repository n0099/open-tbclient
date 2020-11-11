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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View evh;
    private NoNetworkView.a ghG;
    private NoNetworkView gjn;
    private g gso;
    private com.baidu.tieba.interestlabel.model.a kBD;
    private TextView kBE;
    private GridLineView kBF;
    private com.baidu.tieba.interestlabel.a.b kBG;
    private com.baidu.tbadk.core.dialog.a kBH;
    private boolean kBI;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kBG.getCount() == 0 && LabelSettingView.this.kBD != null) {
                    LabelSettingView.this.kBD.cYd();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kBD = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gjn = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kBF = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.evh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kBE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gjn.a(this.ghG);
        this.kBH = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kBH.Bo(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kBH.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kBH.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kBH.b(this.mPageContext);
        this.kBG = new com.baidu.tieba.interestlabel.a.b(this);
        this.kBF.setAdapter((ListAdapter) this.kBG);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cYh())) {
            this.kBF.setVisibility(0);
            this.kBG.setData(bVar);
            this.kBG.notifyDataSetChanged();
        }
    }

    public void sL(boolean z) {
        this.kBI = z;
        this.kBE.setSelected(z);
    }

    public boolean cYt() {
        return (this.kBG == null || y.equalList(this.kBG.cYe(), this.kBG.cYf())) ? false : true;
    }

    public void Qj() {
        this.kBH.bpc();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kBE != null) {
                ap.setViewTextColor(this.kBE, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gjn != null) {
                this.gjn.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kBF != null) {
                this.kBF.onChangeSkinType();
            }
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kBG != null) {
                this.kBG.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evh) {
            if (cYt()) {
                Qj();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kBE && this.kBD != null && this.kBI) {
            TiebaStatic.log(new aq("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kBD.eu(this.kBG.cYf());
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kBD != null) {
                            LabelSettingView.this.kBD.cYd();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kBF.setVisibility(8);
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmK() {
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
        if (this.gjn != null) {
            this.gjn.b(this.ghG);
        }
        this.kBH.dismiss();
        hideLoadingView();
        Wk();
    }
}

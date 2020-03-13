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
    private View cKT;
    private NoNetworkView elv;
    private g euk;
    private NoNetworkView.a fYY;
    private com.baidu.tieba.interestlabel.model.a hVh;
    private TextView hVi;
    private GridLineView hVj;
    private com.baidu.tieba.interestlabel.a.b hVk;
    private com.baidu.tbadk.core.dialog.a hVl;
    private boolean hVm;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hVk.getCount() == 0 && LabelSettingView.this.hVh != null) {
                    LabelSettingView.this.hVh.caV();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hVh = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.elv = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hVj = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cKT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hVi = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.elv.a(this.fYY);
        this.hVl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hVl.sS(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hVl.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hVl.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVl.b(this.mPageContext);
        this.hVk = new com.baidu.tieba.interestlabel.a.b(this);
        this.hVj.setAdapter((ListAdapter) this.hVk);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.caZ())) {
            this.hVj.setVisibility(0);
            this.hVk.setData(bVar);
            this.hVk.notifyDataSetChanged();
        }
    }

    public void oq(boolean z) {
        this.hVm = z;
        this.hVi.setSelected(z);
    }

    public boolean cbl() {
        return (this.hVk == null || v.equalList(this.hVk.caW(), this.hVk.caX())) ? false : true;
    }

    public void showDialog() {
        this.hVl.aEC();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hVi != null) {
                am.setViewTextColor(this.hVi, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.elv != null) {
                this.elv.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hVj != null) {
                this.hVj.onChangeSkinType();
            }
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hVk != null) {
                this.hVk.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKT) {
            if (cbl()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hVi && this.hVh != null && this.hVm) {
            TiebaStatic.log(new an("c12237").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hVh.dg(this.hVk.caX());
        }
    }

    public void eM(boolean z) {
        if (!bzl()) {
            if (this.euk == null) {
                this.euk = new g(getContext());
                this.euk.onChangeSkinType();
            }
            this.euk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
        }
    }

    public boolean bzl() {
        if (this.euk != null) {
            return this.euk.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hVh != null) {
                            LabelSettingView.this.hVh.caV();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hVj.setVisibility(8);
        }
    }

    public void bcy() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzm() {
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
        if (this.elv != null) {
            this.elv.b(this.fYY);
        }
        this.hVl.dismiss();
        hideLoadingView();
        bcy();
    }
}

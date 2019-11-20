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
    private View bUg;
    private g dDz;
    private NoNetworkView dvR;
    private NoNetworkView.a eQL;
    private com.baidu.tbadk.core.dialog.a eTd;
    private com.baidu.tieba.interestlabel.model.a hbj;
    private TextView hbk;
    private GridLineView hbl;
    private com.baidu.tieba.interestlabel.a.b hbm;
    private boolean hbn;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hbm.getCount() == 0 && LabelSettingView.this.hbj != null) {
                    LabelSettingView.this.hbj.bGS();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hbj = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dvR = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hbl = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.bUg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hbk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dvR.a(this.eQL);
        this.eTd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eTd.nn(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eTd.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eTd.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eTd.b(this.mPageContext);
        this.hbm = new com.baidu.tieba.interestlabel.a.b(this);
        this.hbl.setAdapter((ListAdapter) this.hbm);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.bGW())) {
            this.hbl.setVisibility(0);
            this.hbm.setData(bVar);
            this.hbm.notifyDataSetChanged();
        }
    }

    public void mN(boolean z) {
        this.hbn = z;
        this.hbk.setSelected(z);
    }

    public boolean bHi() {
        return (this.hbm == null || v.equalList(this.hbm.bGT(), this.hbm.bGU())) ? false : true;
    }

    public void showDialog() {
        this.eTd.akM();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hbk != null) {
                am.setViewTextColor(this.hbk, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dvR != null) {
                this.dvR.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hbl != null) {
                this.hbl.onChangeSkinType();
            }
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hbm != null) {
                this.hbm.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUg) {
            if (bHi()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hbk && this.hbj != null && this.hbn) {
            TiebaStatic.log(new an("c12237").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hbj.dv(this.hbm.bGU());
        }
    }

    public void dp(boolean z) {
        if (!bfj()) {
            if (this.dDz == null) {
                this.dDz = new g(getContext());
                this.dDz.onChangeSkinType();
            }
            this.dDz.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
        }
    }

    public boolean bfj() {
        if (this.dDz != null) {
            return this.dDz.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfk()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hbj != null) {
                            LabelSettingView.this.hbj.bGS();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hbl.setVisibility(8);
        }
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfk() {
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
        if (this.dvR != null) {
            this.dvR.b(this.eQL);
        }
        this.eTd.dismiss();
        hideLoadingView();
        aJm();
    }
}

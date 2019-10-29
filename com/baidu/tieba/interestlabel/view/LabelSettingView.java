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
    private View bUX;
    private g dEq;
    private NoNetworkView dwI;
    private NoNetworkView.a eRC;
    private com.baidu.tbadk.core.dialog.a eTU;
    private com.baidu.tieba.interestlabel.model.a hca;
    private TextView hcb;
    private GridLineView hcc;
    private com.baidu.tieba.interestlabel.a.b hcd;
    private boolean hce;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hcd.getCount() == 0 && LabelSettingView.this.hca != null) {
                    LabelSettingView.this.hca.bGU();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hca = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dwI = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hcc = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.bUX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hcb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dwI.a(this.eRC);
        this.eTU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eTU.nn(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eTU.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eTU.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eTU.b(this.mPageContext);
        this.hcd = new com.baidu.tieba.interestlabel.a.b(this);
        this.hcc.setAdapter((ListAdapter) this.hcd);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.bGY())) {
            this.hcc.setVisibility(0);
            this.hcd.setData(bVar);
            this.hcd.notifyDataSetChanged();
        }
    }

    public void mN(boolean z) {
        this.hce = z;
        this.hcb.setSelected(z);
    }

    public boolean bHk() {
        return (this.hcd == null || v.equalList(this.hcd.bGV(), this.hcd.bGW())) ? false : true;
    }

    public void showDialog() {
        this.eTU.akO();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hcb != null) {
                am.setViewTextColor(this.hcb, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dwI != null) {
                this.dwI.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hcc != null) {
                this.hcc.onChangeSkinType();
            }
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hcd != null) {
                this.hcd.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUX) {
            if (bHk()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hcb && this.hca != null && this.hce) {
            TiebaStatic.log(new an("c12237").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hca.dv(this.hcd.bGW());
        }
    }

    public void dp(boolean z) {
        if (!bfl()) {
            if (this.dEq == null) {
                this.dEq = new g(getContext());
                this.dEq.onChangeSkinType();
            }
            this.dEq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
        }
    }

    public boolean bfl() {
        if (this.dEq != null) {
            return this.dEq.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hca != null) {
                            LabelSettingView.this.hca.bGU();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hcc.setVisibility(8);
        }
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfm() {
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
        if (this.dwI != null) {
            this.dwI.b(this.eRC);
        }
        this.eTU.dismiss();
        hideLoadingView();
        aJo();
    }
}

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
    private NoNetworkView.a faB;
    private NoNetworkView fci;
    private g flb;
    private com.baidu.tieba.interestlabel.model.a iWp;
    private TextView iWq;
    private GridLineView iWr;
    private com.baidu.tieba.interestlabel.a.b iWs;
    private com.baidu.tbadk.core.dialog.a iWt;
    private boolean iWu;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.faB = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.iWs.getCount() == 0 && LabelSettingView.this.iWp != null) {
                    LabelSettingView.this.iWp.csz();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iWp = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fci = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.iWr = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.iWq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fci.a(this.faB);
        this.iWt = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.iWt.vO(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.iWt.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.iWt.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iWt.b(this.mPageContext);
        this.iWs = new com.baidu.tieba.interestlabel.a.b(this);
        this.iWr.setAdapter((ListAdapter) this.iWs);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.csD())) {
            this.iWr.setVisibility(0);
            this.iWs.setData(bVar);
            this.iWs.notifyDataSetChanged();
        }
    }

    public void pX(boolean z) {
        this.iWu = z;
        this.iWq.setSelected(z);
    }

    public boolean csP() {
        return (this.iWs == null || v.equalList(this.iWs.csA(), this.iWs.csB())) ? false : true;
    }

    public void showDialog() {
        this.iWt.aST();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iWq != null) {
                am.setViewTextColor(this.iWq, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fci != null) {
                this.fci.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.iWr != null) {
                this.iWr.onChangeSkinType();
            }
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iWs != null) {
                this.iWs.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyp) {
            if (csP()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.iWq && this.iWp != null && this.iWu) {
            TiebaStatic.log(new an("c12237").dh("uid", TbadkCoreApplication.getCurrentAccount()));
            this.iWp.dq(this.iWs.csB());
        }
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(getContext());
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.iWp != null) {
                            LabelSettingView.this.iWp.csz();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iWr.setVisibility(8);
        }
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPO() {
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
        if (this.fci != null) {
            this.fci.b(this.faB);
        }
        this.iWt.dismiss();
        hideLoadingView();
        bqQ();
    }
}

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
/* loaded from: classes22.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View dUO;
    private NoNetworkView.a fFF;
    private NoNetworkView fHl;
    private g fQf;
    private com.baidu.tieba.interestlabel.model.a jUl;
    private TextView jUm;
    private GridLineView jUn;
    private com.baidu.tieba.interestlabel.a.b jUo;
    private com.baidu.tbadk.core.dialog.a jUp;
    private boolean jUq;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.jUo.getCount() == 0 && LabelSettingView.this.jUl != null) {
                    LabelSettingView.this.jUl.cON();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jUl = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fHl = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.jUn = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dUO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.jUm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fHl.a(this.fFF);
        this.jUp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.jUp.zV(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.jUp.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.jUp.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jUp.b(this.mPageContext);
        this.jUo = new com.baidu.tieba.interestlabel.a.b(this);
        this.jUn.setAdapter((ListAdapter) this.jUo);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cOR())) {
            this.jUn.setVisibility(0);
            this.jUo.setData(bVar);
            this.jUo.notifyDataSetChanged();
        }
    }

    public void rE(boolean z) {
        this.jUq = z;
        this.jUm.setSelected(z);
    }

    public boolean cPd() {
        return (this.jUo == null || y.equalList(this.jUo.cOO(), this.jUo.cOP())) ? false : true;
    }

    public void NY() {
        this.jUp.bia();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jUm != null) {
                ap.setViewTextColor(this.jUm, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fHl != null) {
                this.fHl.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jUn != null) {
                this.jUn.onChangeSkinType();
            }
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jUo != null) {
                this.jUo.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUO) {
            if (cPd()) {
                NY();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.jUm && this.jUl != null && this.jUq) {
            TiebaStatic.log(new aq("c12237").dF("uid", TbadkCoreApplication.getCurrentAccount()));
            this.jUl.ea(this.jUo.cOP());
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.jUl != null) {
                            LabelSettingView.this.jUl.cON();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jUn.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cdF() {
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
        if (this.fHl != null) {
            this.fHl.b(this.fFF);
        }
        this.jUp.dismiss();
        hideLoadingView();
        bHn();
    }
}

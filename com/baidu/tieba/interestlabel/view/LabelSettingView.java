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
    private View egQ;
    private NoNetworkView.a fRO;
    private NoNetworkView fTu;
    private g gcx;
    private com.baidu.tieba.interestlabel.model.a kjl;
    private TextView kjm;
    private GridLineView kjn;
    private com.baidu.tieba.interestlabel.a.b kjo;
    private com.baidu.tbadk.core.dialog.a kjp;
    private boolean kjq;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fRO = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kjo.getCount() == 0 && LabelSettingView.this.kjl != null) {
                    LabelSettingView.this.kjl.cSv();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kjl = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fTu = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kjn = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.egQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kjm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fTu.a(this.fRO);
        this.kjp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kjp.AH(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kjp.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kjp.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kjp.b(this.mPageContext);
        this.kjo = new com.baidu.tieba.interestlabel.a.b(this);
        this.kjn.setAdapter((ListAdapter) this.kjo);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cSz())) {
            this.kjn.setVisibility(0);
            this.kjo.setData(bVar);
            this.kjo.notifyDataSetChanged();
        }
    }

    public void sk(boolean z) {
        this.kjq = z;
        this.kjm.setSelected(z);
    }

    public boolean cSL() {
        return (this.kjo == null || y.equalList(this.kjo.cSw(), this.kjo.cSx())) ? false : true;
    }

    public void Pd() {
        this.kjp.bkJ();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kjm != null) {
                ap.setViewTextColor(this.kjm, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fTu != null) {
                this.fTu.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kjn != null) {
                this.kjn.onChangeSkinType();
            }
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kjo != null) {
                this.kjo.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egQ) {
            if (cSL()) {
                Pd();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kjm && this.kjl != null && this.kjq) {
            TiebaStatic.log(new aq("c12237").dK("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kjl.ed(this.kjo.cSx());
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kjl != null) {
                            LabelSettingView.this.kjl.cSv();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kjn.setVisibility(8);
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean chb() {
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
        if (this.fTu != null) {
            this.fTu.b(this.fRO);
        }
        this.kjp.dismiss();
        hideLoadingView();
        SK();
    }
}

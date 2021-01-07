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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View eKd;
    private NoNetworkView gCe;
    private g gLj;
    private NoNetworkView.a gzW;
    private com.baidu.tieba.interestlabel.model.a kUR;
    private TextView kUS;
    private GridLineView kUT;
    private com.baidu.tieba.interestlabel.a.b kUU;
    private com.baidu.tbadk.core.dialog.a kUV;
    private boolean kUW;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kUU.getCount() == 0 && LabelSettingView.this.kUR != null) {
                    LabelSettingView.this.kUR.dcw();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kUR = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gCe = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kUT = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eKd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kUS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gCe.a(this.gzW);
        this.kUV = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kUV.Bo(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kUV.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kUV.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kUV.b(this.mPageContext);
        this.kUU = new com.baidu.tieba.interestlabel.a.b(this);
        this.kUT.setAdapter((ListAdapter) this.kUU);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !x.isEmpty(bVar.dcA())) {
            this.kUT.setVisibility(0);
            this.kUU.setData(bVar);
            this.kUU.notifyDataSetChanged();
        }
    }

    public void tr(boolean z) {
        this.kUW = z;
        this.kUS.setSelected(z);
    }

    public boolean dcM() {
        return (this.kUU == null || x.equalList(this.kUU.dcx(), this.kUU.dcy())) ? false : true;
    }

    public void SY() {
        this.kUV.btY();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kUS != null) {
                ao.setViewTextColor(this.kUS, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gCe != null) {
                this.gCe.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kUT != null) {
                this.kUT.onChangeSkinType();
            }
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kUU != null) {
                this.kUU.notifyDataSetChanged();
            }
            setBackgroundColor(ao.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKd) {
            if (dcM()) {
                SY();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kUS && this.kUR != null && this.kUW) {
            TiebaStatic.log(new aq("c12237").dX("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kUR.eF(this.kUU.dcy());
        }
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void pU(boolean z) {
        if (!ctu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kUR != null) {
                            LabelSettingView.this.kUR.dcw();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kUT.setVisibility(8);
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean ctu() {
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
        if (this.gCe != null) {
            this.gCe.b(this.gzW);
        }
        this.kUV.dismiss();
        hideLoadingView();
        Zj();
    }
}

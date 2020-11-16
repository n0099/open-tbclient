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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View ety;
    private NoNetworkView.a ghn;
    private NoNetworkView giU;
    private g grV;
    private com.baidu.tieba.interestlabel.model.a kBS;
    private TextView kBT;
    private GridLineView kBU;
    private com.baidu.tieba.interestlabel.a.b kBV;
    private com.baidu.tbadk.core.dialog.a kBW;
    private boolean kBX;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ghn = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kBV.getCount() == 0 && LabelSettingView.this.kBS != null) {
                    LabelSettingView.this.kBS.cXz();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kBS = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.giU = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kBU = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.ety = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kBT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.giU.a(this.ghn);
        this.kBW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kBW.AJ(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kBW.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kBW.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kBW.b(this.mPageContext);
        this.kBV = new com.baidu.tieba.interestlabel.a.b(this);
        this.kBU.setAdapter((ListAdapter) this.kBV);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cXD())) {
            this.kBU.setVisibility(0);
            this.kBV.setData(bVar);
            this.kBV.notifyDataSetChanged();
        }
    }

    public void sO(boolean z) {
        this.kBX = z;
        this.kBT.setSelected(z);
    }

    public boolean cXP() {
        return (this.kBV == null || y.equalList(this.kBV.cXA(), this.kBV.cXB())) ? false : true;
    }

    public void PA() {
        this.kBW.bog();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kBT != null) {
                ap.setViewTextColor(this.kBT, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.giU != null) {
                this.giU.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kBU != null) {
                this.kBU.onChangeSkinType();
            }
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kBV != null) {
                this.kBV.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ety) {
            if (cXP()) {
                PA();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kBT && this.kBS != null && this.kBX) {
            TiebaStatic.log(new ar("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kBS.eu(this.kBV.cXB());
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kBS != null) {
                            LabelSettingView.this.kBS.cXz();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kBU.setVisibility(8);
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmm() {
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
        if (this.giU != null) {
            this.giU.b(this.ghn);
        }
        this.kBW.dismiss();
        hideLoadingView();
        VB();
    }
}

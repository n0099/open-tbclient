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
    private View cKS;
    private NoNetworkView eli;
    private g etX;
    private NoNetworkView.a fYL;
    private com.baidu.tieba.interestlabel.model.a hUV;
    private TextView hUW;
    private GridLineView hUX;
    private com.baidu.tieba.interestlabel.a.b hUY;
    private com.baidu.tbadk.core.dialog.a hUZ;
    private boolean hVa;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hUY.getCount() == 0 && LabelSettingView.this.hUV != null) {
                    LabelSettingView.this.hUV.caU();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hUV = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.eli = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hUX = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cKS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hUW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.eli.a(this.fYL);
        this.hUZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hUZ.sS(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hUZ.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hUZ.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hUZ.b(this.mPageContext);
        this.hUY = new com.baidu.tieba.interestlabel.a.b(this);
        this.hUX.setAdapter((ListAdapter) this.hUY);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.caY())) {
            this.hUX.setVisibility(0);
            this.hUY.setData(bVar);
            this.hUY.notifyDataSetChanged();
        }
    }

    public void oq(boolean z) {
        this.hVa = z;
        this.hUW.setSelected(z);
    }

    public boolean cbk() {
        return (this.hUY == null || v.equalList(this.hUY.caV(), this.hUY.caW())) ? false : true;
    }

    public void showDialog() {
        this.hUZ.aEC();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hUW != null) {
                am.setViewTextColor(this.hUW, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.eli != null) {
                this.eli.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hUX != null) {
                this.hUX.onChangeSkinType();
            }
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hUY != null) {
                this.hUY.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKS) {
            if (cbk()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hUW && this.hUV != null && this.hVa) {
            TiebaStatic.log(new an("c12237").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hUV.dg(this.hUY.caW());
        }
    }

    public void eM(boolean z) {
        if (!bzk()) {
            if (this.etX == null) {
                this.etX = new g(getContext());
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
        }
    }

    public boolean bzk() {
        if (this.etX != null) {
            return this.etX.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzl()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hUV != null) {
                            LabelSettingView.this.hUV.caU();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hUX.setVisibility(8);
        }
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzl() {
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
        if (this.eli != null) {
            this.eli.b(this.fYL);
        }
        this.hUZ.dismiss();
        hideLoadingView();
        bcx();
    }
}

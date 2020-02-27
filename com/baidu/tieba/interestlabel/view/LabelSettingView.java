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
    private View cKR;
    private NoNetworkView elh;
    private g etW;
    private NoNetworkView.a fYJ;
    private com.baidu.tieba.interestlabel.model.a hUT;
    private TextView hUU;
    private GridLineView hUV;
    private com.baidu.tieba.interestlabel.a.b hUW;
    private com.baidu.tbadk.core.dialog.a hUX;
    private boolean hUY;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hUW.getCount() == 0 && LabelSettingView.this.hUT != null) {
                    LabelSettingView.this.hUT.caS();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hUT = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.elh = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hUV = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cKR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hUU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.elh.a(this.fYJ);
        this.hUX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hUX.sS(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hUX.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hUX.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hUX.b(this.mPageContext);
        this.hUW = new com.baidu.tieba.interestlabel.a.b(this);
        this.hUV.setAdapter((ListAdapter) this.hUW);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.caW())) {
            this.hUV.setVisibility(0);
            this.hUW.setData(bVar);
            this.hUW.notifyDataSetChanged();
        }
    }

    public void oq(boolean z) {
        this.hUY = z;
        this.hUU.setSelected(z);
    }

    public boolean cbi() {
        return (this.hUW == null || v.equalList(this.hUW.caT(), this.hUW.caU())) ? false : true;
    }

    public void showDialog() {
        this.hUX.aEA();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hUU != null) {
                am.setViewTextColor(this.hUU, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.elh != null) {
                this.elh.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hUV != null) {
                this.hUV.onChangeSkinType();
            }
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hUW != null) {
                this.hUW.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKR) {
            if (cbi()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hUU && this.hUT != null && this.hUY) {
            TiebaStatic.log(new an("c12237").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hUT.dg(this.hUW.caU());
        }
    }

    public void eM(boolean z) {
        if (!bzi()) {
            if (this.etW == null) {
                this.etW = new g(getContext());
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
        }
    }

    public boolean bzi() {
        if (this.etW != null) {
            return this.etW.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hUT != null) {
                            LabelSettingView.this.hUT.caS();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hUV.setVisibility(8);
        }
    }

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzj() {
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
        if (this.elh != null) {
            this.elh.b(this.fYJ);
        }
        this.hUX.dismiss();
        hideLoadingView();
        bcv();
    }
}

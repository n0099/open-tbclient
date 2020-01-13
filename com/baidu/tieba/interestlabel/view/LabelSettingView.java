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
/* loaded from: classes8.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View cGO;
    private NoNetworkView ehd;
    private g epL;
    private NoNetworkView.a fWI;
    private com.baidu.tieba.interestlabel.model.a hSV;
    private TextView hSW;
    private GridLineView hSX;
    private com.baidu.tieba.interestlabel.a.b hSY;
    private com.baidu.tbadk.core.dialog.a hSZ;
    private boolean hTa;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hSY.getCount() == 0 && LabelSettingView.this.hSV != null) {
                    LabelSettingView.this.hSV.bZr();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hSV = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.ehd = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hSX = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cGO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hSW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.ehd.a(this.fWI);
        this.hSZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hSZ.sC(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hSZ.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hSZ.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hSZ.b(this.mPageContext);
        this.hSY = new com.baidu.tieba.interestlabel.a.b(this);
        this.hSX.setAdapter((ListAdapter) this.hSY);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.bZv())) {
            this.hSX.setVisibility(0);
            this.hSY.setData(bVar);
            this.hSY.notifyDataSetChanged();
        }
    }

    public void oo(boolean z) {
        this.hTa = z;
        this.hSW.setSelected(z);
    }

    public boolean bZH() {
        return (this.hSY == null || v.equalList(this.hSY.bZs(), this.hSY.bZt())) ? false : true;
    }

    public void showDialog() {
        this.hSZ.aCp();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hSW != null) {
                am.setViewTextColor(this.hSW, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.ehd != null) {
                this.ehd.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hSX != null) {
                this.hSX.onChangeSkinType();
            }
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hSY != null) {
                this.hSY.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cGO) {
            if (bZH()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hSW && this.hSV != null && this.hTa) {
            TiebaStatic.log(new an("c12237").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hSV.dk(this.hSY.bZt());
        }
    }

    public void eF(boolean z) {
        if (!bxG()) {
            if (this.epL == null) {
                this.epL = new g(getContext());
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
        }
    }

    public boolean bxG() {
        if (this.epL != null) {
            return this.epL.isViewAttached();
        }
        return false;
    }

    public void kJ(boolean z) {
        if (!bxH()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hSV != null) {
                            LabelSettingView.this.hSV.bZr();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hSX.setVisibility(8);
        }
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bxH() {
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
        if (this.ehd != null) {
            this.ehd.b(this.fWI);
        }
        this.hSZ.dismiss();
        hideLoadingView();
        baf();
    }
}

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
/* loaded from: classes7.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View cGC;
    private NoNetworkView egT;
    private g eoy;
    private NoNetworkView.a fTz;
    private com.baidu.tieba.interestlabel.model.a hPr;
    private TextView hPs;
    private GridLineView hPt;
    private com.baidu.tieba.interestlabel.a.b hPu;
    private com.baidu.tbadk.core.dialog.a hPv;
    private boolean hPw;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hPu.getCount() == 0 && LabelSettingView.this.hPr != null) {
                    LabelSettingView.this.hPr.bYi();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hPr = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.egT = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hPt = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cGC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hPs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.egT.a(this.fTz);
        this.hPv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hPv.sz(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hPv.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hPv.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hPv.b(this.mPageContext);
        this.hPu = new com.baidu.tieba.interestlabel.a.b(this);
        this.hPt.setAdapter((ListAdapter) this.hPu);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.bYm())) {
            this.hPt.setVisibility(0);
            this.hPu.setData(bVar);
            this.hPu.notifyDataSetChanged();
        }
    }

    public void oc(boolean z) {
        this.hPw = z;
        this.hPs.setSelected(z);
    }

    public boolean bYy() {
        return (this.hPu == null || v.equalList(this.hPu.bYj(), this.hPu.bYk())) ? false : true;
    }

    public void showDialog() {
        this.hPv.aBW();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hPs != null) {
                am.setViewTextColor(this.hPs, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.egT != null) {
                this.egT.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hPt != null) {
                this.hPt.onChangeSkinType();
            }
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hPu != null) {
                this.hPu.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cGC) {
            if (bYy()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hPs && this.hPr != null && this.hPw) {
            TiebaStatic.log(new an("c12237").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hPr.dk(this.hPu.bYk());
        }
    }

    public void eA(boolean z) {
        if (!bwE()) {
            if (this.eoy == null) {
                this.eoy = new g(getContext());
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
        }
    }

    public boolean bwE() {
        if (this.eoy != null) {
            return this.eoy.isViewAttached();
        }
        return false;
    }

    public void ky(boolean z) {
        if (!bwF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hPr != null) {
                            LabelSettingView.this.hPr.bYi();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hPt.setVisibility(8);
        }
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bwF() {
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
        if (this.egT != null) {
            this.egT.b(this.fTz);
        }
        this.hPv.dismiss();
        hideLoadingView();
        aZK();
    }
}

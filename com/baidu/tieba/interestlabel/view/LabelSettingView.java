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
/* loaded from: classes17.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View dSA;
    private NoNetworkView.a fCp;
    private NoNetworkView fDV;
    private g fMN;
    private com.baidu.tieba.interestlabel.model.a jLD;
    private TextView jLE;
    private GridLineView jLF;
    private com.baidu.tieba.interestlabel.a.b jLG;
    private com.baidu.tbadk.core.dialog.a jLH;
    private boolean jLI;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.jLG.getCount() == 0 && LabelSettingView.this.jLD != null) {
                    LabelSettingView.this.jLD.cLg();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jLD = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fDV = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.jLF = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dSA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.jLE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fDV.a(this.fCp);
        this.jLH = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.jLH.zz(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.jLH.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.jLH.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jLH.b(this.mPageContext);
        this.jLG = new com.baidu.tieba.interestlabel.a.b(this);
        this.jLF.setAdapter((ListAdapter) this.jLG);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cLk())) {
            this.jLF.setVisibility(0);
            this.jLG.setData(bVar);
            this.jLG.notifyDataSetChanged();
        }
    }

    public void ru(boolean z) {
        this.jLI = z;
        this.jLE.setSelected(z);
    }

    public boolean cLw() {
        return (this.jLG == null || y.equalList(this.jLG.cLh(), this.jLG.cLi())) ? false : true;
    }

    public void Nv() {
        this.jLH.bhg();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jLE != null) {
                ap.setViewTextColor(this.jLE, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fDV != null) {
                this.fDV.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jLF != null) {
                this.jLF.onChangeSkinType();
            }
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jLG != null) {
                this.jLG.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dSA) {
            if (cLw()) {
                Nv();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.jLE && this.jLD != null && this.jLI) {
            TiebaStatic.log(new aq("c12237").dD("uid", TbadkCoreApplication.getCurrentAccount()));
            this.jLD.dS(this.jLG.cLi());
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.jLD != null) {
                            LabelSettingView.this.jLD.cLg();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jLF.setVisibility(8);
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgw() {
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
        if (this.fDV != null) {
            this.fDV.b(this.fCp);
        }
        this.jLH.dismiss();
        hideLoadingView();
        bFW();
    }
}

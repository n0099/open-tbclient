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
    private View dSE;
    private NoNetworkView.a fCt;
    private NoNetworkView fDZ;
    private g fMR;
    private com.baidu.tieba.interestlabel.model.a jLJ;
    private TextView jLK;
    private GridLineView jLL;
    private com.baidu.tieba.interestlabel.a.b jLM;
    private com.baidu.tbadk.core.dialog.a jLN;
    private boolean jLO;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fCt = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.jLM.getCount() == 0 && LabelSettingView.this.jLJ != null) {
                    LabelSettingView.this.jLJ.cLh();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jLJ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fDZ = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.jLL = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dSE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.jLK = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fDZ.a(this.fCt);
        this.jLN = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.jLN.zA(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.jLN.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.jLN.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jLN.b(this.mPageContext);
        this.jLM = new com.baidu.tieba.interestlabel.a.b(this);
        this.jLL.setAdapter((ListAdapter) this.jLM);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cLl())) {
            this.jLL.setVisibility(0);
            this.jLM.setData(bVar);
            this.jLM.notifyDataSetChanged();
        }
    }

    public void rw(boolean z) {
        this.jLO = z;
        this.jLK.setSelected(z);
    }

    public boolean cLx() {
        return (this.jLM == null || y.equalList(this.jLM.cLi(), this.jLM.cLj())) ? false : true;
    }

    public void Nv() {
        this.jLN.bhg();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jLK != null) {
                ap.setViewTextColor(this.jLK, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fDZ != null) {
                this.fDZ.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jLL != null) {
                this.jLL.onChangeSkinType();
            }
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jLM != null) {
                this.jLM.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dSE) {
            if (cLx()) {
                Nv();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.jLK && this.jLJ != null && this.jLO) {
            TiebaStatic.log(new aq("c12237").dD("uid", TbadkCoreApplication.getCurrentAccount()));
            this.jLJ.dS(this.jLM.cLj());
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.jLJ != null) {
                            LabelSettingView.this.jLJ.cLh();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jLL.setVisibility(8);
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgx() {
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
        if (this.fDZ != null) {
            this.fDZ.b(this.fCt);
        }
        this.jLN.dismiss();
        hideLoadingView();
        bFX();
    }
}

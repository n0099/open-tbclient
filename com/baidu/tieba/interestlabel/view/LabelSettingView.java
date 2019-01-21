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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bLm;
    private NoNetworkView bPm;
    private NoNetworkView.a dcQ;
    private com.baidu.tbadk.core.dialog.a dfm;
    private com.baidu.tieba.interestlabel.model.a fnL;
    private View fnM;
    private TextView fnN;
    private GridLineView fnO;
    private com.baidu.tieba.interestlabel.a.b fnP;
    private boolean fnQ;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                if (z && LabelSettingView.this.fnP.getCount() == 0 && LabelSettingView.this.fnL != null) {
                    LabelSettingView.this.fnL.aYl();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fnL = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bPm = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fnO = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fnM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fnN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bPm.a(this.dcQ);
        this.dfm = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.dfm.eK(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.dfm.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.dfm.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.dfm.b(this.mPageContext);
        this.fnP = new com.baidu.tieba.interestlabel.a.b(this);
        this.fnO.setAdapter((ListAdapter) this.fnP);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aYp())) {
            this.fnO.setVisibility(0);
            this.fnP.setData(bVar);
            this.fnP.notifyDataSetChanged();
        }
    }

    public void jr(boolean z) {
        this.fnQ = z;
        this.fnN.setSelected(z);
    }

    public boolean aYB() {
        return (this.fnP == null || v.c(this.fnP.aYm(), this.fnP.aYn())) ? false : true;
    }

    public void showDialog() {
        this.dfm.BS();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fnN != null) {
                al.h(this.fnN, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bPm != null) {
                this.bPm.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fnO != null) {
                this.fnO.onChangeSkinType();
            }
            if (this.bLm != null) {
                this.bLm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fnM) {
            if (aYB()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fnN && this.fnL != null && this.fnQ) {
            TiebaStatic.log(new am("c12237").aB("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fnL.cQ(this.fnP.aYn());
        }
    }

    public void showLoadingView(boolean z) {
        if (!aOd()) {
            if (this.bLm == null) {
                this.bLm = new f(getContext());
                this.bLm.onChangeSkinType();
            }
            this.bLm.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bLm != null) {
            this.bLm.dettachView(this);
            this.bLm = null;
        }
    }

    public boolean aOd() {
        if (this.bLm != null) {
            return this.bLm.isViewAttached();
        }
        return false;
    }

    public void js(boolean z) {
        if (!aLn()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK() && LabelSettingView.this.fnL != null) {
                            LabelSettingView.this.fnL.aYl();
                        }
                    }
                });
            }
            this.mRefreshView.ge(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.Od();
            this.fnO.setVisibility(8);
        }
    }

    public void abx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aLn() {
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
        if (this.bPm != null) {
            this.bPm.b(this.dcQ);
        }
        this.dfm.dismiss();
        hideLoadingView();
        abx();
    }
}

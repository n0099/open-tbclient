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
    private f bLl;
    private NoNetworkView bPl;
    private NoNetworkView.a dcP;
    private com.baidu.tbadk.core.dialog.a dfl;
    private com.baidu.tieba.interestlabel.model.a fnK;
    private View fnL;
    private TextView fnM;
    private GridLineView fnN;
    private com.baidu.tieba.interestlabel.a.b fnO;
    private boolean fnP;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                if (z && LabelSettingView.this.fnO.getCount() == 0 && LabelSettingView.this.fnK != null) {
                    LabelSettingView.this.fnK.aYl();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fnK = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.label_setting_navigation_bar_view);
        this.bPl = (NoNetworkView) findViewById(e.g.label_setting_no_network_view);
        this.fnN = (GridLineView) findViewById(e.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(e.j.choose_interest_label));
        this.fnL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.fnM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.item_label_setting_nav_complete, this);
        this.bPl.a(this.dcP);
        this.dfl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.dfl.eK(this.mPageContext.getString(e.j.confirm_give_up_label));
        this.dfl.a(this.mPageContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.dfl.b(this.mPageContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.dfl.b(this.mPageContext);
        this.fnO = new com.baidu.tieba.interestlabel.a.b(this);
        this.fnN.setAdapter((ListAdapter) this.fnO);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aYp())) {
            this.fnN.setVisibility(0);
            this.fnO.setData(bVar);
            this.fnO.notifyDataSetChanged();
        }
    }

    public void jr(boolean z) {
        this.fnP = z;
        this.fnM.setSelected(z);
    }

    public boolean aYB() {
        return (this.fnO == null || v.c(this.fnO.aYm(), this.fnO.aYn())) ? false : true;
    }

    public void showDialog() {
        this.dfl.BS();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fnM != null) {
                al.h(this.fnM, e.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bPl != null) {
                this.bPl.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fnN != null) {
                this.fnN.onChangeSkinType();
            }
            if (this.bLl != null) {
                this.bLl.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fnL) {
            if (aYB()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.fnM && this.fnK != null && this.fnP) {
            TiebaStatic.log(new am("c12237").aB("uid", TbadkCoreApplication.getCurrentAccount()));
            this.fnK.cQ(this.fnO.aYn());
        }
    }

    public void showLoadingView(boolean z) {
        if (!aOd()) {
            if (this.bLl == null) {
                this.bLl = new f(getContext());
                this.bLl.onChangeSkinType();
            }
            this.bLl.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bLl != null) {
            this.bLl.dettachView(this);
            this.bLl = null;
        }
    }

    public boolean aOd() {
        if (this.bLl != null) {
            return this.bLl.isViewAttached();
        }
        return false;
    }

    public void js(boolean z) {
        if (!aLn()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK() && LabelSettingView.this.fnK != null) {
                            LabelSettingView.this.fnK.aYl();
                        }
                    }
                });
            }
            this.mRefreshView.ge(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.Od();
            this.fnN.setVisibility(8);
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
        if (this.bPl != null) {
            this.bPl.b(this.dcP);
        }
        this.dfl.dismiss();
        hideLoadingView();
        abx();
    }
}

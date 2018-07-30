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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f brt;
    private NoNetworkView bvz;
    private NoNetworkView.a cDq;
    private com.baidu.tbadk.core.dialog.a cFK;
    private com.baidu.tieba.interestlabel.model.a eMO;
    private View eMP;
    private TextView eMQ;
    private GridLineView eMR;
    private com.baidu.tieba.interestlabel.a.b eMS;
    private boolean eMT;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                if (z && LabelSettingView.this.eMS.getCount() == 0 && LabelSettingView.this.eMO != null) {
                    LabelSettingView.this.eMO.aQk();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eMO = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.bvz = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eMR = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.eMP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eMQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.bvz.a(this.cDq);
        this.cFK = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cFK.dB(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.cFK.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cFK.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cFK.b(this.mPageContext);
        this.eMS = new com.baidu.tieba.interestlabel.a.b(this);
        this.eMR.setAdapter((ListAdapter) this.eMS);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.z(bVar.aQo())) {
            this.eMR.setVisibility(0);
            this.eMS.setData(bVar);
            this.eMS.notifyDataSetChanged();
        }
    }

    public void il(boolean z) {
        this.eMT = z;
        this.eMQ.setSelected(z);
    }

    public boolean aQA() {
        return (this.eMS == null || w.c(this.eMS.aQl(), this.eMS.aQm())) ? false : true;
    }

    public void showDialog() {
        this.cFK.xf();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eMQ != null) {
                am.h(this.eMQ, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bvz != null) {
                this.bvz.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eMR != null) {
                this.eMR.onChangeSkinType();
            }
            if (this.brt != null) {
                this.brt.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMP) {
            if (aQA()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eMQ && this.eMO != null && this.eMT) {
            TiebaStatic.log(new an("c12237").af("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eMO.cw(this.eMS.aQm());
        }
    }

    public void gU(boolean z) {
        if (!aFW()) {
            if (this.brt == null) {
                this.brt = new f(getContext());
                this.brt.onChangeSkinType();
            }
            this.brt.c(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.brt != null) {
            this.brt.Q(this);
            this.brt = null;
        }
    }

    public boolean aFW() {
        if (this.brt != null) {
            return this.brt.Jc();
        }
        return false;
    }

    public void im(boolean z) {
        if (!aDj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.js() && LabelSettingView.this.eMO != null) {
                            LabelSettingView.this.eMO.aQk();
                        }
                    }
                });
            }
            this.mRefreshView.fh(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.c(this, z);
            this.mRefreshView.Jk();
            this.eMR.setVisibility(8);
        }
    }

    public void Uk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this);
            this.mRefreshView = null;
        }
    }

    public boolean aDj() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Jc();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.bvz != null) {
            this.bvz.b(this.cDq);
        }
        this.cFK.dismiss();
        hideLoadingView();
        Uk();
    }
}

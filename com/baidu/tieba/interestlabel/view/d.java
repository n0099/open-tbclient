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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    private f bXd;
    private NoNetworkView cba;
    private NoNetworkView.a dbo;
    private com.baidu.tbadk.core.dialog.a ddL;
    private com.baidu.tieba.interestlabel.model.a eYb;
    private View eYc;
    private TextView eYd;
    private GridLineView eYe;
    private com.baidu.tieba.interestlabel.a.b eYf;
    private boolean eYg;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                if (z && d.this.eYf.getCount() == 0 && d.this.eYb != null) {
                    d.this.eYb.aOH();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eYb = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.cba = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eYe = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.eYc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eYd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.cba.a(this.dbo);
        this.ddL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.ddL.dk(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.ddL.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                d.this.mPageContext.getPageActivity().finish();
            }
        });
        this.ddL.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ddL.b(this.mPageContext);
        this.eYf = new com.baidu.tieba.interestlabel.a.b(this);
        this.eYe.setAdapter((ListAdapter) this.eYf);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.E(bVar.aOL())) {
            this.eYe.setVisibility(0);
            this.eYf.setData(bVar);
            this.eYf.notifyDataSetChanged();
        }
    }

    public void it(boolean z) {
        this.eYg = z;
        this.eYd.setSelected(z);
    }

    public boolean aOX() {
        return (this.eYf == null || v.b((List) this.eYf.aOI(), (List) this.eYf.aOJ())) ? false : true;
    }

    public void showDialog() {
        this.ddL.AV();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYd != null) {
                aj.r(this.eYd, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.cba != null) {
                this.cba.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYe != null) {
                this.eYe.onChangeSkinType();
            }
            if (this.bXd != null) {
                this.bXd.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eYc) {
            if (aOX()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eYd && this.eYb != null && this.eYg) {
            TiebaStatic.log(new ak("c12237").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eYb.cr(this.eYf.aOJ());
        }
    }

    public void gZ(boolean z) {
        if (!aEu()) {
            if (this.bXd == null) {
                this.bXd = new f(getContext());
                this.bXd.onChangeSkinType();
            }
            this.bXd.j(this, z);
        }
    }

    public void VV() {
        if (this.bXd != null) {
            this.bXd.bk(this);
            this.bXd = null;
        }
    }

    public boolean aEu() {
        if (this.bXd != null) {
            return this.bXd.MJ();
        }
        return false;
    }

    public void iu(boolean z) {
        if (!aCg()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ox() && d.this.eYb != null) {
                            d.this.eYb.aOH();
                        }
                    }
                });
            }
            this.mRefreshView.ib(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.j(this, z);
            this.mRefreshView.MR();
            this.eYe.setVisibility(8);
        }
    }

    public void XN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.bk(this);
            this.mRefreshView = null;
        }
    }

    public boolean aCg() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.MJ();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.cba != null) {
            this.cba.b(this.dbo);
        }
        this.ddL.dismiss();
        VV();
        XN();
    }
}

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
    private f bXm;
    private NoNetworkView cbj;
    private NoNetworkView.a dbx;
    private com.baidu.tbadk.core.dialog.a ddU;
    private com.baidu.tieba.interestlabel.model.a eXZ;
    private View eYa;
    private TextView eYb;
    private GridLineView eYc;
    private com.baidu.tieba.interestlabel.a.b eYd;
    private boolean eYe;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dbx = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                if (z && d.this.eYd.getCount() == 0 && d.this.eXZ != null) {
                    d.this.eXZ.aOH();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eXZ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.cbj = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eYc = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.eYa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eYb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.cbj.a(this.dbx);
        this.ddU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.ddU.dk(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.ddU.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                d.this.mPageContext.getPageActivity().finish();
            }
        });
        this.ddU.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ddU.b(this.mPageContext);
        this.eYd = new com.baidu.tieba.interestlabel.a.b(this);
        this.eYc.setAdapter((ListAdapter) this.eYd);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.E(bVar.aOL())) {
            this.eYc.setVisibility(0);
            this.eYd.setData(bVar);
            this.eYd.notifyDataSetChanged();
        }
    }

    public void io(boolean z) {
        this.eYe = z;
        this.eYb.setSelected(z);
    }

    public boolean aOX() {
        return (this.eYd == null || v.b((List) this.eYd.aOI(), (List) this.eYd.aOJ())) ? false : true;
    }

    public void showDialog() {
        this.ddU.AU();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYb != null) {
                aj.r(this.eYb, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.cbj != null) {
                this.cbj.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYc != null) {
                this.eYc.onChangeSkinType();
            }
            if (this.bXm != null) {
                this.bXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eYa) {
            if (aOX()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eYb && this.eXZ != null && this.eYe) {
            TiebaStatic.log(new ak("c12237").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eXZ.cr(this.eYd.aOJ());
        }
    }

    public void gU(boolean z) {
        if (!aEu()) {
            if (this.bXm == null) {
                this.bXm = new f(getContext());
                this.bXm.onChangeSkinType();
            }
            this.bXm.j(this, z);
        }
    }

    public void VV() {
        if (this.bXm != null) {
            this.bXm.bk(this);
            this.bXm = null;
        }
    }

    public boolean aEu() {
        if (this.bXm != null) {
            return this.bXm.MJ();
        }
        return false;
    }

    public void ip(boolean z) {
        if (!aCg()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ox() && d.this.eXZ != null) {
                            d.this.eXZ.aOH();
                        }
                    }
                });
            }
            this.mRefreshView.ib(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.j(this, z);
            this.mRefreshView.MR();
            this.eYc.setVisibility(8);
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
        if (this.cbj != null) {
            this.cbj.b(this.dbx);
        }
        this.ddU.dismiss();
        VV();
        XN();
    }
}

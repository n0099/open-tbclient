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
    private f bXa;
    private NoNetworkView caX;
    private NoNetworkView.a dbl;
    private com.baidu.tbadk.core.dialog.a ddI;
    private com.baidu.tieba.interestlabel.model.a eXN;
    private View eXO;
    private TextView eXP;
    private GridLineView eXQ;
    private com.baidu.tieba.interestlabel.a.b eXR;
    private boolean eXS;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dbl = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                if (z && d.this.eXR.getCount() == 0 && d.this.eXN != null) {
                    d.this.eXN.aOG();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eXN = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.caX = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eXQ = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.j.choose_interest_label));
        this.eXO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eXP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.item_label_setting_nav_complete, this);
        this.caX.a(this.dbl);
        this.ddI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.ddI.dk(this.mPageContext.getString(d.j.confirm_give_up_label));
        this.ddI.a(this.mPageContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                d.this.mPageContext.getPageActivity().finish();
            }
        });
        this.ddI.b(this.mPageContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ddI.b(this.mPageContext);
        this.eXR = new com.baidu.tieba.interestlabel.a.b(this);
        this.eXQ.setAdapter((ListAdapter) this.eXR);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.E(bVar.aOK())) {
            this.eXQ.setVisibility(0);
            this.eXR.setData(bVar);
            this.eXR.notifyDataSetChanged();
        }
    }

    public void io(boolean z) {
        this.eXS = z;
        this.eXP.setSelected(z);
    }

    public boolean aOW() {
        return (this.eXR == null || v.b((List) this.eXR.aOH(), (List) this.eXR.aOI())) ? false : true;
    }

    public void showDialog() {
        this.ddI.AU();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eXP != null) {
                aj.r(this.eXP, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.caX != null) {
                this.caX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eXQ != null) {
                this.eXQ.onChangeSkinType();
            }
            if (this.bXa != null) {
                this.bXa.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXO) {
            if (aOW()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eXP && this.eXN != null && this.eXS) {
            TiebaStatic.log(new ak("c12237").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eXN.cr(this.eXR.aOI());
        }
    }

    public void gU(boolean z) {
        if (!aEt()) {
            if (this.bXa == null) {
                this.bXa = new f(getContext());
                this.bXa.onChangeSkinType();
            }
            this.bXa.j(this, z);
        }
    }

    public void VU() {
        if (this.bXa != null) {
            this.bXa.bk(this);
            this.bXa = null;
        }
    }

    public boolean aEt() {
        if (this.bXa != null) {
            return this.bXa.MI();
        }
        return false;
    }

    public void ip(boolean z) {
        if (!aCf()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ox() && d.this.eXN != null) {
                            d.this.eXN.aOG();
                        }
                    }
                });
            }
            this.mRefreshView.ib(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.j(this, z);
            this.mRefreshView.MQ();
            this.eXQ.setVisibility(8);
        }
    }

    public void XM() {
        if (this.mRefreshView != null) {
            this.mRefreshView.bk(this);
            this.mRefreshView = null;
        }
    }

    public boolean aCf() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.MI();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.caX != null) {
            this.caX.b(this.dbl);
        }
        this.ddI.dismiss();
        VU();
        XM();
    }
}

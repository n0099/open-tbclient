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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bpl;
    private NoNetworkView btu;
    private NoNetworkView.a cCR;
    private com.baidu.tbadk.core.dialog.a cFl;
    private com.baidu.tieba.interestlabel.model.a eFe;
    private View eFf;
    private TextView eFg;
    private GridLineView eFh;
    private com.baidu.tieba.interestlabel.a.b eFi;
    private boolean eFj;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                if (z && LabelSettingView.this.eFi.getCount() == 0 && LabelSettingView.this.eFe != null) {
                    LabelSettingView.this.eFe.aOE();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eFe = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.btu = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.eFh = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.k.choose_interest_label));
        this.eFf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eFg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.item_label_setting_nav_complete, this);
        this.btu.a(this.cCR);
        this.cFl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cFl.dB(this.mPageContext.getString(d.k.confirm_give_up_label));
        this.cFl.a(this.mPageContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cFl.b(this.mPageContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cFl.b(this.mPageContext);
        this.eFi = new com.baidu.tieba.interestlabel.a.b(this);
        this.eFh.setAdapter((ListAdapter) this.eFi);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.z(bVar.aOI())) {
            this.eFh.setVisibility(0);
            this.eFi.setData(bVar);
            this.eFi.notifyDataSetChanged();
        }
    }

    public void hY(boolean z) {
        this.eFj = z;
        this.eFg.setSelected(z);
    }

    public boolean aOU() {
        return (this.eFi == null || w.c(this.eFi.aOF(), this.eFi.aOG())) ? false : true;
    }

    public void showDialog() {
        this.cFl.xa();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eFg != null) {
                al.h(this.eFg, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.btu != null) {
                this.btu.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eFh != null) {
                this.eFh.onChangeSkinType();
            }
            if (this.bpl != null) {
                this.bpl.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFf) {
            if (aOU()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eFg && this.eFe != null && this.eFj) {
            TiebaStatic.log(new am("c12237").ah("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eFe.cs(this.eFi.aOG());
        }
    }

    public void gH(boolean z) {
        if (!aEn()) {
            if (this.bpl == null) {
                this.bpl = new f(getContext());
                this.bpl.onChangeSkinType();
            }
            this.bpl.d(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.bpl != null) {
            this.bpl.P(this);
            this.bpl = null;
        }
    }

    public boolean aEn() {
        if (this.bpl != null) {
            return this.bpl.IP();
        }
        return false;
    }

    public void hZ(boolean z) {
        if (!aBV()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jr() && LabelSettingView.this.eFe != null) {
                            LabelSettingView.this.eFe.aOE();
                        }
                    }
                });
            }
            this.mRefreshView.ff(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.d(this, z);
            this.mRefreshView.IX();
            this.eFh.setVisibility(8);
        }
    }

    public void TI() {
        if (this.mRefreshView != null) {
            this.mRefreshView.P(this);
            this.mRefreshView = null;
        }
    }

    public boolean aBV() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.IP();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.btu != null) {
            this.btu.b(this.cCR);
        }
        this.cFl.dismiss();
        hideLoadingView();
        TI();
    }
}

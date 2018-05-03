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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bha;
    private NoNetworkView bla;
    private NoNetworkView.a ctd;
    private com.baidu.tbadk.core.dialog.a cvz;
    private com.baidu.tieba.interestlabel.model.a esF;
    private View esG;
    private TextView esH;
    private GridLineView esI;
    private com.baidu.tieba.interestlabel.a.b esJ;
    private boolean esK;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ctd = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                if (z && LabelSettingView.this.esJ.getCount() == 0 && LabelSettingView.this.esF != null) {
                    LabelSettingView.this.esF.aJJ();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.esF = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.bla = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.esI = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.k.choose_interest_label));
        this.esG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.esH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.item_label_setting_nav_complete, this);
        this.bla.a(this.ctd);
        this.cvz = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cvz.dc(this.mPageContext.getString(d.k.confirm_give_up_label));
        this.cvz.a(this.mPageContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cvz.b(this.mPageContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cvz.b(this.mPageContext);
        this.esJ = new com.baidu.tieba.interestlabel.a.b(this);
        this.esI.setAdapter((ListAdapter) this.esJ);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.w(bVar.aJN())) {
            this.esI.setVisibility(0);
            this.esJ.setData(bVar);
            this.esJ.notifyDataSetChanged();
        }
    }

    public void hR(boolean z) {
        this.esK = z;
        this.esH.setSelected(z);
    }

    public boolean aJZ() {
        return (this.esJ == null || v.b((List) this.esJ.aJK(), (List) this.esJ.aJL())) ? false : true;
    }

    public void showDialog() {
        this.cvz.tD();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.esH != null) {
                ak.h(this.esH, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bla != null) {
                this.bla.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.esI != null) {
                this.esI.onChangeSkinType();
            }
            if (this.bha != null) {
                this.bha.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.esG) {
            if (aJZ()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view2 == this.esH && this.esF != null && this.esK) {
            TiebaStatic.log(new al("c12237").ac("uid", TbadkCoreApplication.getCurrentAccount()));
            this.esF.ck(this.esJ.aJL());
        }
    }

    public void gA(boolean z) {
        if (!azu()) {
            if (this.bha == null) {
                this.bha = new f(getContext());
                this.bha.onChangeSkinType();
            }
            this.bha.d(this, z);
        }
    }

    public void Ou() {
        if (this.bha != null) {
            this.bha.P(this);
            this.bha = null;
        }
    }

    public boolean azu() {
        if (this.bha != null) {
            return this.bha.Fm();
        }
        return false;
    }

    public void hS(boolean z) {
        if (!axe()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (j.gD() && LabelSettingView.this.esF != null) {
                            LabelSettingView.this.esF.aJJ();
                        }
                    }
                });
            }
            this.mRefreshView.fa(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.d(this, z);
            this.mRefreshView.Fu();
            this.esI.setVisibility(8);
        }
    }

    public void Qn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.P(this);
            this.mRefreshView = null;
        }
    }

    public boolean axe() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Fm();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.bla != null) {
            this.bla.b(this.ctd);
        }
        this.cvz.dismiss();
        Ou();
        Qn();
    }
}

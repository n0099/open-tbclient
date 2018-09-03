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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f brv;
    private NoNetworkView bvB;
    private NoNetworkView.a cDn;
    private com.baidu.tbadk.core.dialog.a cFH;
    private com.baidu.tieba.interestlabel.model.a eMJ;
    private View eMK;
    private TextView eML;
    private GridLineView eMM;
    private com.baidu.tieba.interestlabel.a.b eMN;
    private boolean eMO;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aR(boolean z) {
                if (z && LabelSettingView.this.eMN.getCount() == 0 && LabelSettingView.this.eMJ != null) {
                    LabelSettingView.this.eMJ.aQh();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eMJ = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.label_setting_navigation_bar_view);
        this.bvB = (NoNetworkView) findViewById(f.g.label_setting_no_network_view);
        this.eMM = (GridLineView) findViewById(f.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(f.j.choose_interest_label));
        this.eMK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.eML = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.item_label_setting_nav_complete, this);
        this.bvB.a(this.cDn);
        this.cFH = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cFH.dB(this.mPageContext.getString(f.j.confirm_give_up_label));
        this.cFH.a(this.mPageContext.getString(f.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cFH.b(this.mPageContext.getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cFH.b(this.mPageContext);
        this.eMN = new com.baidu.tieba.interestlabel.a.b(this);
        this.eMM.setAdapter((ListAdapter) this.eMN);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.z(bVar.aQl())) {
            this.eMM.setVisibility(0);
            this.eMN.setData(bVar);
            this.eMN.notifyDataSetChanged();
        }
    }

    public void il(boolean z) {
        this.eMO = z;
        this.eML.setSelected(z);
    }

    public boolean aQx() {
        return (this.eMN == null || w.c(this.eMN.aQi(), this.eMN.aQj())) ? false : true;
    }

    public void showDialog() {
        this.cFH.xe();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eML != null) {
                am.h(this.eML, f.C0146f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.bvB != null) {
                this.bvB.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eMM != null) {
                this.eMM.onChangeSkinType();
            }
            if (this.brv != null) {
                this.brv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMK) {
            if (aQx()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.eML && this.eMJ != null && this.eMO) {
            TiebaStatic.log(new an("c12237").ae("uid", TbadkCoreApplication.getCurrentAccount()));
            this.eMJ.cw(this.eMN.aQj());
        }
    }

    public void gU(boolean z) {
        if (!aFT()) {
            if (this.brv == null) {
                this.brv = new com.baidu.tbadk.k.f(getContext());
                this.brv.onChangeSkinType();
            }
            this.brv.c(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.brv != null) {
            this.brv.Q(this);
            this.brv = null;
        }
    }

    public boolean aFT() {
        if (this.brv != null) {
            return this.brv.Jc();
        }
        return false;
    }

    public void im(boolean z) {
        if (!aDg()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.js() && LabelSettingView.this.eMJ != null) {
                            LabelSettingView.this.eMJ.aQh();
                        }
                    }
                });
            }
            this.mRefreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(f.e.ds380));
            this.mRefreshView.c(this, z);
            this.mRefreshView.Jk();
            this.eMM.setVisibility(8);
        }
    }

    public void Un() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this);
            this.mRefreshView = null;
        }
    }

    public boolean aDg() {
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
        if (this.bvB != null) {
            this.bvB.b(this.cDn);
        }
        this.cFH.dismiss();
        hideLoadingView();
        Un();
    }
}

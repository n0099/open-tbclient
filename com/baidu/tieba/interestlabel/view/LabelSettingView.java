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
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private g dhX;
    private NoNetworkView dlW;
    private NoNetworkView.a eCk;
    private com.baidu.tbadk.core.dialog.a eEB;
    private com.baidu.tieba.interestlabel.model.a gUV;
    private View gUW;
    private TextView gUX;
    private GridLineView gUY;
    private com.baidu.tieba.interestlabel.a.b gUZ;
    private boolean gVa;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && LabelSettingView.this.gUZ.getCount() == 0 && LabelSettingView.this.gUV != null) {
                    LabelSettingView.this.gUV.bGy();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gUV = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dlW = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.gUY = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.gUW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.gUX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dlW.a(this.eCk);
        this.eEB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eEB.mE(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eEB.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eEB.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eEB.b(this.mPageContext);
        this.gUZ = new com.baidu.tieba.interestlabel.a.b(this);
        this.gUY.setAdapter((ListAdapter) this.gUZ);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bGC())) {
            this.gUY.setVisibility(0);
            this.gUZ.setData(bVar);
            this.gUZ.notifyDataSetChanged();
        }
    }

    public void mH(boolean z) {
        this.gVa = z;
        this.gUX.setSelected(z);
    }

    public boolean bGO() {
        return (this.gUZ == null || v.c(this.gUZ.bGz(), this.gUZ.bGA())) ? false : true;
    }

    public void showDialog() {
        this.eEB.afG();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gUX != null) {
                al.j(this.gUX, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dlW != null) {
                this.dlW.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gUY != null) {
                this.gUY.onChangeSkinType();
            }
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUW) {
            if (bGO()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.gUX && this.gUV != null && this.gVa) {
            TiebaStatic.log(new am("c12237").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            this.gUV.dh(this.gUZ.bGA());
        }
    }

    public void cV(boolean z) {
        if (!beC()) {
            if (this.dhX == null) {
                this.dhX = new g(getContext());
                this.dhX.onChangeSkinType();
            }
            this.dhX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
        }
    }

    public boolean beC() {
        if (this.dhX != null) {
            return this.dhX.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beD()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && LabelSettingView.this.gUV != null) {
                            LabelSettingView.this.gUV.bGy();
                        }
                    }
                });
            }
            this.mRefreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.gUY.setVisibility(8);
        }
    }

    public void aHH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beD() {
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
        if (this.dlW != null) {
            this.dlW.b(this.eCk);
        }
        this.eEB.dismiss();
        hideLoadingView();
        aHH();
    }
}

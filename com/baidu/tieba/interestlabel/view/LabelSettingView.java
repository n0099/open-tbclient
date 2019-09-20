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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View bCC;
    private g dly;
    private NoNetworkView dpy;
    private NoNetworkView.a eIX;
    private com.baidu.tbadk.core.dialog.a eLo;
    private com.baidu.tieba.interestlabel.model.a hdX;
    private TextView hdY;
    private GridLineView hdZ;
    private com.baidu.tieba.interestlabel.a.b hea;
    private boolean heb;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                if (z && LabelSettingView.this.hea.getCount() == 0 && LabelSettingView.this.hdX != null) {
                    LabelSettingView.this.hdX.bKk();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hdX = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dpy = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hdZ = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hdY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dpy.a(this.eIX);
        this.eLo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eLo.mQ(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eLo.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eLo.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eLo.b(this.mPageContext);
        this.hea = new com.baidu.tieba.interestlabel.a.b(this);
        this.hdZ.setAdapter((ListAdapter) this.hea);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bKo())) {
            this.hdZ.setVisibility(0);
            this.hea.setData(bVar);
            this.hea.notifyDataSetChanged();
        }
    }

    public void mZ(boolean z) {
        this.heb = z;
        this.hdY.setSelected(z);
    }

    public boolean bKA() {
        return (this.hea == null || v.c(this.hea.bKl(), this.hea.bKm())) ? false : true;
    }

    public void showDialog() {
        this.eLo.agO();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hdY != null) {
                am.j(this.hdY, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dpy != null) {
                this.dpy.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hdZ != null) {
                this.hdZ.onChangeSkinType();
            }
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hea != null) {
                this.hea.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCC) {
            if (bKA()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hdY && this.hdX != null && this.heb) {
            TiebaStatic.log(new an("c12237").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hdX.di(this.hea.bKm());
        }
    }

    public void cY(boolean z) {
        if (!bhr()) {
            if (this.dly == null) {
                this.dly = new g(getContext());
                this.dly.onChangeSkinType();
            }
            this.dly.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
        }
    }

    public boolean bhr() {
        if (this.dly != null) {
            return this.dly.isViewAttached();
        }
        return false;
    }

    public void jx(boolean z) {
        if (!bhs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && LabelSettingView.this.hdX != null) {
                            LabelSettingView.this.hdX.bKk();
                        }
                    }
                });
            }
            this.mRefreshView.kO(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atW();
            this.hdZ.setVisibility(8);
        }
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bhs() {
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
        if (this.dpy != null) {
            this.dpy.b(this.eIX);
        }
        this.eLo.dismiss();
        hideLoadingView();
        aJN();
    }
}

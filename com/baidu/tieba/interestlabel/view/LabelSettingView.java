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
    private View bCe;
    private g djG;
    private NoNetworkView dnF;
    private NoNetworkView.a eHh;
    private com.baidu.tbadk.core.dialog.a eJy;
    private com.baidu.tieba.interestlabel.model.a hbl;
    private TextView hbm;
    private GridLineView hbn;
    private com.baidu.tieba.interestlabel.a.b hbo;
    private boolean hbp;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && LabelSettingView.this.hbo.getCount() == 0 && LabelSettingView.this.hbl != null) {
                    LabelSettingView.this.hbl.bJj();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hbl = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.dnF = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hbn = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.bCe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hbm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.dnF.a(this.eHh);
        this.eJy = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.eJy.mO(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.eJy.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.eJy.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eJy.b(this.mPageContext);
        this.hbo = new com.baidu.tieba.interestlabel.a.b(this);
        this.hbn.setAdapter((ListAdapter) this.hbo);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bJn())) {
            this.hbn.setVisibility(0);
            this.hbo.setData(bVar);
            this.hbo.notifyDataSetChanged();
        }
    }

    public void mW(boolean z) {
        this.hbp = z;
        this.hbm.setSelected(z);
    }

    public boolean bJz() {
        return (this.hbo == null || v.c(this.hbo.bJk(), this.hbo.bJl())) ? false : true;
    }

    public void showDialog() {
        this.eJy.agI();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hbm != null) {
                am.j(this.hbm, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.dnF != null) {
                this.dnF.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hbn != null) {
                this.hbn.onChangeSkinType();
            }
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCe) {
            if (bJz()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hbm && this.hbl != null && this.hbp) {
            TiebaStatic.log(new an("c12237").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hbl.dj(this.hbo.bJl());
        }
    }

    public void cY(boolean z) {
        if (!bgI()) {
            if (this.djG == null) {
                this.djG = new g(getContext());
                this.djG.onChangeSkinType();
            }
            this.djG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this);
            this.djG = null;
        }
    }

    public boolean bgI() {
        if (this.djG != null) {
            return this.djG.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgJ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && LabelSettingView.this.hbl != null) {
                            LabelSettingView.this.hbl.bJj();
                        }
                    }
                });
            }
            this.mRefreshView.kK(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atI();
            this.hbn.setVisibility(8);
        }
    }

    public void aJh() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bgJ() {
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
        if (this.dnF != null) {
            this.dnF.b(this.eHh);
        }
        this.eJy.dismiss();
        hideLoadingView();
        aJh();
    }
}

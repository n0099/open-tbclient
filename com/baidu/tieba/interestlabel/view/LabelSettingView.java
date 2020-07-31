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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View dJs;
    private g fBv;
    private NoNetworkView.a fqT;
    private NoNetworkView fsB;
    private com.baidu.tieba.interestlabel.model.a jwg;
    private TextView jwh;
    private GridLineView jwi;
    private com.baidu.tieba.interestlabel.a.b jwj;
    private com.baidu.tbadk.core.dialog.a jwk;
    private boolean jwl;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.jwj.getCount() == 0 && LabelSettingView.this.jwg != null) {
                    LabelSettingView.this.jwg.cAo();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jwg = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.fsB = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.jwi = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.dJs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.jwh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.fsB.a(this.fqT);
        this.jwk = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.jwk.xl(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.jwk.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.jwk.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jwk.b(this.mPageContext);
        this.jwj = new com.baidu.tieba.interestlabel.a.b(this);
        this.jwi.setAdapter((ListAdapter) this.jwj);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !x.isEmpty(bVar.cAs())) {
            this.jwi.setVisibility(0);
            this.jwj.setData(bVar);
            this.jwj.notifyDataSetChanged();
        }
    }

    public void qO(boolean z) {
        this.jwl = z;
        this.jwh.setSelected(z);
    }

    public boolean cAE() {
        return (this.jwj == null || x.equalList(this.jwj.cAp(), this.jwj.cAq())) ? false : true;
    }

    public void showDialog() {
        this.jwk.aYL();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jwh != null) {
                ao.setViewTextColor(this.jwh, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.fsB != null) {
                this.fsB.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.jwi != null) {
                this.jwi.onChangeSkinType();
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jwj != null) {
                this.jwj.notifyDataSetChanged();
            }
            setBackgroundColor(ao.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dJs) {
            if (cAE()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.jwh && this.jwg != null && this.jwl) {
            TiebaStatic.log(new ap("c12237").dn("uid", TbadkCoreApplication.getCurrentAccount()));
            this.jwg.dL(this.jwj.cAq());
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.jwg != null) {
                            LabelSettingView.this.jwg.cAo();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jwi.setVisibility(8);
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bWj() {
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
        if (this.fsB != null) {
            this.fsB.b(this.fqT);
        }
        this.jwk.dismiss();
        hideLoadingView();
        bwX();
    }
}

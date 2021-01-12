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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View eFs;
    private g gGD;
    private NoNetworkView.a gvp;
    private NoNetworkView gxx;
    private com.baidu.tieba.interestlabel.model.a kQm;
    private TextView kQn;
    private GridLineView kQo;
    private com.baidu.tieba.interestlabel.a.b kQp;
    private com.baidu.tbadk.core.dialog.a kQq;
    private boolean kQr;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kQp.getCount() == 0 && LabelSettingView.this.kQm != null) {
                    LabelSettingView.this.kQm.cYE();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kQm = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gxx = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kQo = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eFs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kQn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gxx.a(this.gvp);
        this.kQq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kQq.Ad(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kQq.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kQq.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kQq.b(this.mPageContext);
        this.kQp = new com.baidu.tieba.interestlabel.a.b(this);
        this.kQo.setAdapter((ListAdapter) this.kQp);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !x.isEmpty(bVar.cYI())) {
            this.kQo.setVisibility(0);
            this.kQp.setData(bVar);
            this.kQp.notifyDataSetChanged();
        }
    }

    public void tn(boolean z) {
        this.kQr = z;
        this.kQn.setSelected(z);
    }

    public boolean cYU() {
        return (this.kQp == null || x.equalList(this.kQp.cYF(), this.kQp.cYG())) ? false : true;
    }

    public void Pd() {
        this.kQq.bqe();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kQn != null) {
                ao.setViewTextColor(this.kQn, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gxx != null) {
                this.gxx.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kQo != null) {
                this.kQo.onChangeSkinType();
            }
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kQp != null) {
                this.kQp.notifyDataSetChanged();
            }
            setBackgroundColor(ao.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFs) {
            if (cYU()) {
                Pd();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kQn && this.kQm != null && this.kQr) {
            TiebaStatic.log(new aq("c12237").dW("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kQm.eF(this.kQp.cYG());
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kQm != null) {
                            LabelSettingView.this.kQm.cYE();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kQo.setVisibility(8);
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cpC() {
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
        if (this.gxx != null) {
            this.gxx.b(this.gvp);
        }
        this.kQq.dismiss();
        hideLoadingView();
        Vq();
    }
}

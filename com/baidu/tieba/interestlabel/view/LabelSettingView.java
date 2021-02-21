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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View eHy;
    private NoNetworkView gAv;
    private g gJB;
    private NoNetworkView.a gyn;
    private com.baidu.tieba.interestlabel.model.a kYC;
    private TextView kYD;
    private GridLineView kYE;
    private com.baidu.tieba.interestlabel.a.b kYF;
    private com.baidu.tbadk.core.dialog.a kYG;
    private boolean kYH;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kYF.getCount() == 0 && LabelSettingView.this.kYC != null) {
                    LabelSettingView.this.kYC.daJ();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kYC = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gAv = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kYE = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eHy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kYD = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gAv.a(this.gyn);
        this.kYG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kYG.Au(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kYG.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kYG.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kYG.b(this.mPageContext);
        this.kYF = new com.baidu.tieba.interestlabel.a.b(this);
        this.kYE.setAdapter((ListAdapter) this.kYF);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.daN())) {
            this.kYE.setVisibility(0);
            this.kYF.setData(bVar);
            this.kYF.notifyDataSetChanged();
        }
    }

    public void tA(boolean z) {
        this.kYH = z;
        this.kYD.setSelected(z);
    }

    public boolean daZ() {
        return (this.kYF == null || y.equalList(this.kYF.daK(), this.kYF.daL())) ? false : true;
    }

    public void QE() {
        this.kYG.bqx();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kYD != null) {
                ap.setViewTextColor(this.kYD, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gAv != null) {
                this.gAv.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kYE != null) {
                this.kYE.onChangeSkinType();
            }
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kYF != null) {
                this.kYF.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHy) {
            if (daZ()) {
                QE();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kYD && this.kYC != null && this.kYH) {
            TiebaStatic.log(new ar("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kYC.eD(this.kYF.daL());
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kYC != null) {
                            LabelSettingView.this.kYC.daJ();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kYE.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqT() {
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
        if (this.gAv != null) {
            this.gAv.b(this.gyn);
        }
        this.kYG.dismiss();
        hideLoadingView();
        WZ();
    }
}

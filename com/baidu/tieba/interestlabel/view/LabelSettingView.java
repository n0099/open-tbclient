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
    private NoNetworkView gAh;
    private g gJn;
    private NoNetworkView.a gxZ;
    private com.baidu.tieba.interestlabel.model.a kYo;
    private TextView kYp;
    private GridLineView kYq;
    private com.baidu.tieba.interestlabel.a.b kYr;
    private com.baidu.tbadk.core.dialog.a kYs;
    private boolean kYt;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kYr.getCount() == 0 && LabelSettingView.this.kYo != null) {
                    LabelSettingView.this.kYo.daC();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kYo = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gAh = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kYq = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eHy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kYp = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gAh.a(this.gxZ);
        this.kYs = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kYs.Au(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kYs.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kYs.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kYs.b(this.mPageContext);
        this.kYr = new com.baidu.tieba.interestlabel.a.b(this);
        this.kYq.setAdapter((ListAdapter) this.kYr);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.daG())) {
            this.kYq.setVisibility(0);
            this.kYr.setData(bVar);
            this.kYr.notifyDataSetChanged();
        }
    }

    public void tA(boolean z) {
        this.kYt = z;
        this.kYp.setSelected(z);
    }

    public boolean daS() {
        return (this.kYr == null || y.equalList(this.kYr.daD(), this.kYr.daE())) ? false : true;
    }

    public void QE() {
        this.kYs.bqx();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kYp != null) {
                ap.setViewTextColor(this.kYp, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gAh != null) {
                this.gAh.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kYq != null) {
                this.kYq.onChangeSkinType();
            }
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kYr != null) {
                this.kYr.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHy) {
            if (daS()) {
                QE();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kYp && this.kYo != null && this.kYt) {
            TiebaStatic.log(new ar("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kYo.eD(this.kYr.daE());
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kYo != null) {
                            LabelSettingView.this.kYo.daC();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kYq.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqM() {
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
        if (this.gAh != null) {
            this.gAh.b(this.gxZ);
        }
        this.kYs.dismiss();
        hideLoadingView();
        WZ();
    }
}

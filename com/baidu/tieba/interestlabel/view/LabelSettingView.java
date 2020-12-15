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
/* loaded from: classes23.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View eAA;
    private g gAg;
    private NoNetworkView.a gpz;
    private NoNetworkView grf;
    private com.baidu.tieba.interestlabel.model.a kPm;
    private TextView kPn;
    private GridLineView kPo;
    private com.baidu.tieba.interestlabel.a.b kPp;
    private com.baidu.tbadk.core.dialog.a kPq;
    private boolean kPr;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kPp.getCount() == 0 && LabelSettingView.this.kPm != null) {
                    LabelSettingView.this.kPm.dcL();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kPm = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.grf = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kPo = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eAA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kPn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.grf.a(this.gpz);
        this.kPq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kPq.Bq(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kPq.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kPq.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kPq.b(this.mPageContext);
        this.kPp = new com.baidu.tieba.interestlabel.a.b(this);
        this.kPo.setAdapter((ListAdapter) this.kPp);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.dcP())) {
            this.kPo.setVisibility(0);
            this.kPp.setData(bVar);
            this.kPp.notifyDataSetChanged();
        }
    }

    public void tq(boolean z) {
        this.kPr = z;
        this.kPn.setSelected(z);
    }

    public boolean ddb() {
        return (this.kPp == null || y.equalList(this.kPp.dcM(), this.kPp.dcN())) ? false : true;
    }

    public void RU() {
        this.kPq.brv();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kPn != null) {
                ap.setViewTextColor(this.kPn, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.grf != null) {
                this.grf.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kPo != null) {
                this.kPo.onChangeSkinType();
            }
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kPp != null) {
                this.kPp.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAA) {
            if (ddb()) {
                RU();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kPn && this.kPm != null && this.kPr) {
            TiebaStatic.log(new ar("c12237").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kPm.eF(this.kPp.dcN());
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kPm != null) {
                            LabelSettingView.this.kPm.dcL();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kPo.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqA() {
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
        if (this.grf != null) {
            this.grf.b(this.gpz);
        }
        this.kPq.dismiss();
        hideLoadingView();
        Yb();
    }
}

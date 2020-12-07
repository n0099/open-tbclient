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
    private g gAe;
    private NoNetworkView.a gpx;
    private NoNetworkView grd;
    private com.baidu.tieba.interestlabel.model.a kPk;
    private TextView kPl;
    private GridLineView kPm;
    private com.baidu.tieba.interestlabel.a.b kPn;
    private com.baidu.tbadk.core.dialog.a kPo;
    private boolean kPp;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gpx = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kPn.getCount() == 0 && LabelSettingView.this.kPk != null) {
                    LabelSettingView.this.kPk.dcK();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kPk = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.grd = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kPm = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eAA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kPl = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.grd.a(this.gpx);
        this.kPo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kPo.Bq(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kPo.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kPo.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kPo.b(this.mPageContext);
        this.kPn = new com.baidu.tieba.interestlabel.a.b(this);
        this.kPm.setAdapter((ListAdapter) this.kPn);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.dcO())) {
            this.kPm.setVisibility(0);
            this.kPn.setData(bVar);
            this.kPn.notifyDataSetChanged();
        }
    }

    public void tq(boolean z) {
        this.kPp = z;
        this.kPl.setSelected(z);
    }

    public boolean dda() {
        return (this.kPn == null || y.equalList(this.kPn.dcL(), this.kPn.dcM())) ? false : true;
    }

    public void RU() {
        this.kPo.brv();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kPl != null) {
                ap.setViewTextColor(this.kPl, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.grd != null) {
                this.grd.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kPm != null) {
                this.kPm.onChangeSkinType();
            }
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kPn != null) {
                this.kPn.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAA) {
            if (dda()) {
                RU();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kPl && this.kPk != null && this.kPp) {
            TiebaStatic.log(new ar("c12237").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kPk.eF(this.kPn.dcM());
        }
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kPk != null) {
                            LabelSettingView.this.kPk.dcK();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kPm.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqz() {
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
        if (this.grd != null) {
            this.grd.b(this.gpx);
        }
        this.kPo.dismiss();
        hideLoadingView();
        Yb();
    }
}

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
/* loaded from: classes7.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View eIZ;
    private NoNetworkView gCe;
    private g gLk;
    private NoNetworkView.a gzW;
    private com.baidu.tieba.interestlabel.model.a laF;
    private TextView laG;
    private GridLineView laH;
    private com.baidu.tieba.interestlabel.a.b laI;
    private com.baidu.tbadk.core.dialog.a laJ;
    private boolean laK;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.laI.getCount() == 0 && LabelSettingView.this.laF != null) {
                    LabelSettingView.this.laF.daS();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.laF = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gCe = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.laH = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.eIZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.laG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gCe.a(this.gzW);
        this.laJ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.laJ.AB(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.laJ.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.laJ.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.laJ.b(this.mPageContext);
        this.laI = new com.baidu.tieba.interestlabel.a.b(this);
        this.laH.setAdapter((ListAdapter) this.laI);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.daW())) {
            this.laH.setVisibility(0);
            this.laI.setData(bVar);
            this.laI.notifyDataSetChanged();
        }
    }

    public void tA(boolean z) {
        this.laK = z;
        this.laG.setSelected(z);
    }

    public boolean dbi() {
        return (this.laI == null || y.equalList(this.laI.daT(), this.laI.daU())) ? false : true;
    }

    public void QH() {
        this.laJ.bqz();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.laG != null) {
                ap.setViewTextColor(this.laG, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gCe != null) {
                this.gCe.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.laH != null) {
                this.laH.onChangeSkinType();
            }
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.laI != null) {
                this.laI.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.CAM_X0205));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eIZ) {
            if (dbi()) {
                QH();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.laG && this.laF != null && this.laK) {
            TiebaStatic.log(new ar("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.laF.eD(this.laI.daU());
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.laF != null) {
                            LabelSettingView.this.laF.daS();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.laH.setVisibility(8);
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqZ() {
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
        if (this.gCe != null) {
            this.gCe.b(this.gzW);
        }
        this.laJ.dismiss();
        hideLoadingView();
        Xc();
    }
}

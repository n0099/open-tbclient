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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View epo;
    private NoNetworkView.a gbR;
    private NoNetworkView gdx;
    private g gmB;
    private com.baidu.tieba.interestlabel.model.a kvI;
    private TextView kvJ;
    private GridLineView kvK;
    private com.baidu.tieba.interestlabel.a.b kvL;
    private com.baidu.tbadk.core.dialog.a kvM;
    private boolean kvN;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.kvL.getCount() == 0 && LabelSettingView.this.kvI != null) {
                    LabelSettingView.this.kvI.cVC();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kvI = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.gdx = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.kvK = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.epo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.kvJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.gdx.a(this.gbR);
        this.kvM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.kvM.Ba(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.kvM.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.kvM.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvM.b(this.mPageContext);
        this.kvL = new com.baidu.tieba.interestlabel.a.b(this);
        this.kvK.setAdapter((ListAdapter) this.kvL);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cVG())) {
            this.kvK.setVisibility(0);
            this.kvL.setData(bVar);
            this.kvL.notifyDataSetChanged();
        }
    }

    public void sC(boolean z) {
        this.kvN = z;
        this.kvJ.setSelected(z);
    }

    public boolean cVS() {
        return (this.kvL == null || y.equalList(this.kvL.cVD(), this.kvL.cVE())) ? false : true;
    }

    public void PJ() {
        this.kvM.bmC();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kvJ != null) {
                ap.setViewTextColor(this.kvJ, R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.gdx != null) {
                this.gdx.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.kvK != null) {
                this.kvK.onChangeSkinType();
            }
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kvL != null) {
                this.kvL.notifyDataSetChanged();
            }
            setBackgroundColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epo) {
            if (cVS()) {
                PJ();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.kvJ && this.kvI != null && this.kvN) {
            TiebaStatic.log(new aq("c12237").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            this.kvI.em(this.kvL.cVE());
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.kvI != null) {
                            LabelSettingView.this.kvI.cVC();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.kvK.setVisibility(8);
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cki() {
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
        if (this.gdx != null) {
            this.gdx.b(this.gbR);
        }
        this.kvM.dismiss();
        hideLoadingView();
        TK();
    }
}

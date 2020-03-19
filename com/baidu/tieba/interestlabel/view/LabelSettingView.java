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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private View cLe;
    private NoNetworkView elL;
    private g euG;
    private NoNetworkView.a fZG;
    private com.baidu.tieba.interestlabel.model.a hWH;
    private TextView hWI;
    private GridLineView hWJ;
    private com.baidu.tieba.interestlabel.a.b hWK;
    private com.baidu.tbadk.core.dialog.a hWL;
    private boolean hWM;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && LabelSettingView.this.hWK.getCount() == 0 && LabelSettingView.this.hWH != null) {
                    LabelSettingView.this.hWH.cbo();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hWH = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
        this.elL = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
        this.hWJ = (GridLineView) findViewById(R.id.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(R.string.choose_interest_label));
        this.cLe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.hWI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
        this.elL.a(this.fZG);
        this.hWL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.hWL.sS(this.mPageContext.getString(R.string.confirm_give_up_label));
        this.hWL.a(this.mPageContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.hWL.b(this.mPageContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hWL.b(this.mPageContext);
        this.hWK = new com.baidu.tieba.interestlabel.a.b(this);
        this.hWJ.setAdapter((ListAdapter) this.hWK);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.cbs())) {
            this.hWJ.setVisibility(0);
            this.hWK.setData(bVar);
            this.hWK.notifyDataSetChanged();
        }
    }

    public void ow(boolean z) {
        this.hWM = z;
        this.hWI.setSelected(z);
    }

    public boolean cbE() {
        return (this.hWK == null || v.equalList(this.hWK.cbp(), this.hWK.cbq())) ? false : true;
    }

    public void showDialog() {
        this.hWL.aEG();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hWI != null) {
                am.setViewTextColor(this.hWI, (int) R.drawable.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.elL != null) {
                this.elL.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.hWJ != null) {
                this.hWJ.onChangeSkinType();
            }
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hWK != null) {
                this.hWK.notifyDataSetChanged();
            }
            setBackgroundColor(am.getColor(this.mSkinType, R.color.cp_bg_line_e));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cLe) {
            if (cbE()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view == this.hWI && this.hWH != null && this.hWM) {
            TiebaStatic.log(new an("c12237").cx("uid", TbadkCoreApplication.getCurrentAccount()));
            this.hWH.dg(this.hWK.cbq());
        }
    }

    public void eN(boolean z) {
        if (!bzr()) {
            if (this.euG == null) {
                this.euG = new g(getContext());
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
        }
    }

    public boolean bzr() {
        if (this.euG != null) {
            return this.euG.isViewAttached();
        }
        return false;
    }

    public void kS(boolean z) {
        if (!bzs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && LabelSettingView.this.hWH != null) {
                            LabelSettingView.this.hWH.cbo();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hWJ.setVisibility(8);
        }
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzs() {
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
        if (this.elL != null) {
            this.elL.b(this.fZG);
        }
        this.hWL.dismiss();
        hideLoadingView();
        bcC();
    }
}

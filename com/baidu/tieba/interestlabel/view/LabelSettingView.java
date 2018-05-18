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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    private f bhf;
    private NoNetworkView blp;
    private NoNetworkView.a cun;
    private com.baidu.tbadk.core.dialog.a cwI;
    private com.baidu.tieba.interestlabel.model.a etO;
    private View etP;
    private TextView etQ;
    private GridLineView etR;
    private com.baidu.tieba.interestlabel.a.b etS;
    private boolean etT;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private g mRefreshView;
    private int mSkinType;

    public LabelSettingView(TbPageContext<?> tbPageContext, com.baidu.tieba.interestlabel.model.a aVar) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cun = new NoNetworkView.a() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                if (z && LabelSettingView.this.etS.getCount() == 0 && LabelSettingView.this.etO != null) {
                    LabelSettingView.this.etO.aJI();
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.etO = aVar;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.activity_label_setting_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.label_setting_navigation_bar_view);
        this.blp = (NoNetworkView) findViewById(d.g.label_setting_no_network_view);
        this.etR = (GridLineView) findViewById(d.g.label_setting_gridview);
        this.mNavigationBar.setTitleText(context.getString(d.k.choose_interest_label));
        this.etP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.etQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.item_label_setting_nav_complete, this);
        this.blp.a(this.cun);
        this.cwI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        this.cwI.dc(this.mPageContext.getString(d.k.confirm_give_up_label));
        this.cwI.a(this.mPageContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                LabelSettingView.this.mPageContext.getPageActivity().finish();
            }
        });
        this.cwI.b(this.mPageContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.cwI.b(this.mPageContext);
        this.etS = new com.baidu.tieba.interestlabel.a.b(this);
        this.etR.setAdapter((ListAdapter) this.etS);
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.w(bVar.aJM())) {
            this.etR.setVisibility(0);
            this.etS.setData(bVar);
            this.etS.notifyDataSetChanged();
        }
    }

    public void hS(boolean z) {
        this.etT = z;
        this.etQ.setSelected(z);
    }

    public boolean aJY() {
        return (this.etS == null || v.b((List) this.etS.aJJ(), (List) this.etS.aJK())) ? false : true;
    }

    public void showDialog() {
        this.cwI.tC();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPageContext != null && this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.etQ != null) {
                ak.h(this.etQ, d.f.color_nav_complete_selector);
            }
            if (this.mPageContext != null && this.blp != null) {
                this.blp.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.etR != null) {
                this.etR.onChangeSkinType();
            }
            if (this.bhf != null) {
                this.bhf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.etP) {
            if (aJY()) {
                showDialog();
            } else {
                this.mPageContext.getPageActivity().finish();
            }
        } else if (view2 == this.etQ && this.etO != null && this.etT) {
            TiebaStatic.log(new al("c12237").ac("uid", TbadkCoreApplication.getCurrentAccount()));
            this.etO.cn(this.etS.aJK());
        }
    }

    public void gB(boolean z) {
        if (!azs()) {
            if (this.bhf == null) {
                this.bhf = new f(getContext());
                this.bhf.onChangeSkinType();
            }
            this.bhf.d(this, z);
        }
    }

    public void Os() {
        if (this.bhf != null) {
            this.bhf.P(this);
            this.bhf = null;
        }
    }

    public boolean azs() {
        if (this.bhf != null) {
            return this.bhf.Fk();
        }
        return false;
    }

    public void hT(boolean z) {
        if (!axd()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.LabelSettingView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (j.gD() && LabelSettingView.this.etO != null) {
                            LabelSettingView.this.etO.aJI();
                        }
                    }
                });
            }
            this.mRefreshView.fb(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.d(this, z);
            this.mRefreshView.Fs();
            this.etR.setVisibility(8);
        }
    }

    public void Qk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.P(this);
            this.mRefreshView = null;
        }
    }

    public boolean axd() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.Fk();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.blp != null) {
            this.blp.b(this.cun);
        }
        this.cwI.dismiss();
        Os();
        Qk();
    }
}

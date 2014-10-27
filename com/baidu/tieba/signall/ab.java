package com.baidu.tieba.signall;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.f {
    public static int bLD;
    private com.baidu.tbadk.core.view.y Yc;
    private b bKy;
    private RelativeLayout bLE;
    private x bLF;
    private BdListView bLG;
    private o bLH;
    private RelativeLayout bLI;
    private TextView bLJ;
    private TextView bLK;
    private LinearLayout bLL;
    private TextView bLM;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public ab(BaseActivity baseActivity) {
        super(baseActivity);
        this.Yc = null;
        this.mActivity = baseActivity;
        this.mActivity.setContentView(com.baidu.tieba.w.signallforum_view);
        this.bLE = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ac(this));
        this.bLG = (BdListView) this.mActivity.findViewById(com.baidu.tieba.v.signallforum_list);
        this.bLG.setOnItemClickListener(baseActivity);
        this.Yc = new com.baidu.tbadk.core.view.y(baseActivity);
        this.bLG.setPullRefresh(this.Yc);
        this.bLM = (TextView) com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.signallforum_maxcount_warning, null);
        this.bLG.addFooterView(this.bLM);
        this.bLF = new x(this.mActivity);
        this.mProgressBar = this.bLF.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mActivity);
        this.bLG.addHeaderView(this.bLF);
        this.bLF.setVisibility(8);
        this.bLI = (RelativeLayout) this.bLF.findViewById(com.baidu.tieba.v.guidecontainer);
        this.bLL = (LinearLayout) this.bLF.findViewById(com.baidu.tieba.v.guideopenbtn);
        this.bLJ = (TextView) this.bLF.findViewById(com.baidu.tieba.v.guidetip);
        this.bLK = (TextView) this.bLF.findViewById(com.baidu.tieba.v.guideopen);
        this.bLL.setOnClickListener(this.mActivity);
        this.bLH = new o(this.mActivity, null);
        this.bLG.setAdapter((ListAdapter) this.bLH);
        this.bLG.setOnScrollListener(this.bLH);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.bLE);
        this.mActivity.getLayoutMode().h(this.bLM);
        this.mActivity.getLayoutMode().h(this.bLF);
        aw.i(this.bLE, com.baidu.tieba.s.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(i);
        this.Yc.bM(i);
        this.bLH.notifyDataSetChanged();
    }

    public void d(b bVar) {
        if (bVar != null) {
            this.bKy = bVar;
            add();
            ArrayList<d> acx = bVar.acx();
            this.bLH.b(this.bKy);
            if (acx.size() == bLD) {
                this.bLM.setVisibility(0);
                this.bLM.setText(bVar.acu());
                return;
            }
            this.bLM.setVisibility(8);
        }
    }

    private void add() {
        if (this.bKy != null) {
            this.bLF.setHasPrivilege(this.bKy.acB());
            this.bLF.setmCurrentStatus(this.bKy.acD());
            TextView message1 = this.bLF.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.bKy.acq()) + this.bKy.acr() + this.bKy.acs());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.m251getInst().getResources().getColor(com.baidu.tieba.s.sign_all_forum_text_color));
            int length = this.bKy.acq().length();
            spannableString.setSpan(foregroundColorSpan, length, this.bKy.acr().length() + length, 33);
            message1.setText(spannableString);
            this.bLF.getMessage2().setText(this.bKy.act());
            this.bLJ.setText(this.bKy.getContent());
            if (TextUtils.isEmpty(this.bKy.acC())) {
                this.bLK.setText(com.baidu.tieba.y.sign_all_forum_memberbtn_content);
            } else {
                this.bLK.setText(this.bKy.acC());
            }
            this.bLF.setVisibility(0);
            if (this.bKy.acB()) {
                this.bLI.setVisibility(8);
            } else {
                this.bLI.setVisibility(0);
            }
        }
    }

    public void hO() {
        this.bLG.hO();
    }

    public void IN() {
        this.bLG.hN();
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.bLG.setOnItemClickListener(onItemClickListener);
    }

    public x ade() {
        return this.bLF;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView adf() {
        return this.bLG;
    }

    public b adg() {
        return this.bKy;
    }

    public o adh() {
        return this.bLH;
    }

    public LinearLayout adi() {
        return this.bLL;
    }
}

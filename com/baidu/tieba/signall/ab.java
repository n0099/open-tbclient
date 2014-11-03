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
    public static int bLS;
    private com.baidu.tbadk.core.view.y Yg;
    private b bKN;
    private RelativeLayout bLT;
    private x bLU;
    private BdListView bLV;
    private o bLW;
    private RelativeLayout bLX;
    private TextView bLY;
    private TextView bLZ;
    private LinearLayout bMa;
    private TextView bMb;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public ab(BaseActivity baseActivity) {
        super(baseActivity);
        this.Yg = null;
        this.mActivity = baseActivity;
        this.mActivity.setContentView(com.baidu.tieba.w.signallforum_view);
        this.bLT = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ac(this));
        this.bLV = (BdListView) this.mActivity.findViewById(com.baidu.tieba.v.signallforum_list);
        this.bLV.setOnItemClickListener(baseActivity);
        this.Yg = new com.baidu.tbadk.core.view.y(baseActivity);
        this.bLV.setPullRefresh(this.Yg);
        this.bMb = (TextView) com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.signallforum_maxcount_warning, null);
        this.bLV.addFooterView(this.bMb);
        this.bLU = new x(this.mActivity);
        this.mProgressBar = this.bLU.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mActivity);
        this.bLV.addHeaderView(this.bLU);
        this.bLU.setVisibility(8);
        this.bLX = (RelativeLayout) this.bLU.findViewById(com.baidu.tieba.v.guidecontainer);
        this.bMa = (LinearLayout) this.bLU.findViewById(com.baidu.tieba.v.guideopenbtn);
        this.bLY = (TextView) this.bLU.findViewById(com.baidu.tieba.v.guidetip);
        this.bLZ = (TextView) this.bLU.findViewById(com.baidu.tieba.v.guideopen);
        this.bMa.setOnClickListener(this.mActivity);
        this.bLW = new o(this.mActivity, null);
        this.bLV.setAdapter((ListAdapter) this.bLW);
        this.bLV.setOnScrollListener(this.bLW);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.bLT);
        this.mActivity.getLayoutMode().h(this.bMb);
        this.mActivity.getLayoutMode().h(this.bLU);
        aw.i(this.bLT, com.baidu.tieba.s.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(i);
        this.Yg.bM(i);
        this.bLW.notifyDataSetChanged();
    }

    public void d(b bVar) {
        if (bVar != null) {
            this.bKN = bVar;
            adg();
            ArrayList<d> acA = bVar.acA();
            this.bLW.b(this.bKN);
            if (acA.size() == bLS) {
                this.bMb.setVisibility(0);
                this.bMb.setText(bVar.acx());
                return;
            }
            this.bMb.setVisibility(8);
        }
    }

    private void adg() {
        if (this.bKN != null) {
            this.bLU.setHasPrivilege(this.bKN.acE());
            this.bLU.setmCurrentStatus(this.bKN.acG());
            TextView message1 = this.bLU.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.bKN.act()) + this.bKN.acu() + this.bKN.acv());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.m251getInst().getResources().getColor(com.baidu.tieba.s.sign_all_forum_text_color));
            int length = this.bKN.act().length();
            spannableString.setSpan(foregroundColorSpan, length, this.bKN.acu().length() + length, 33);
            message1.setText(spannableString);
            this.bLU.getMessage2().setText(this.bKN.acw());
            this.bLY.setText(this.bKN.getContent());
            if (TextUtils.isEmpty(this.bKN.acF())) {
                this.bLZ.setText(com.baidu.tieba.y.sign_all_forum_memberbtn_content);
            } else {
                this.bLZ.setText(this.bKN.acF());
            }
            this.bLU.setVisibility(0);
            if (this.bKN.acE()) {
                this.bLX.setVisibility(8);
            } else {
                this.bLX.setVisibility(0);
            }
        }
    }

    public void hO() {
        this.bLV.hO();
    }

    public void IR() {
        this.bLV.hN();
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.bLV.setOnItemClickListener(onItemClickListener);
    }

    public x adh() {
        return this.bLU;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView adi() {
        return this.bLV;
    }

    public b adj() {
        return this.bKN;
    }

    public o adk() {
        return this.bLW;
    }

    public LinearLayout adl() {
        return this.bMa;
    }
}

package com.baidu.tieba.signall;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int cJT;
    private c cIN;
    private SignAllForumActivity cJU;
    private RelativeLayout cJV;
    private s cJW;
    private BdListView cJX;
    private n cJY;
    private RelativeLayout cJZ;
    private TextView cKa;
    private TextView cKb;
    private LinearLayout cKc;
    private TextView cKd;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.z mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cJU = signAllForumActivity;
        this.cJU.setContentView(i.g.signallforum_view);
        this.cJV = (RelativeLayout) this.cJU.findViewById(i.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cJU.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cJU.getPageContext().getString(i.h.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.cJX = (BdListView) this.cJU.findViewById(i.f.signallforum_list);
        this.cJX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.z(signAllForumActivity.getPageContext());
        this.cJX.setPullRefresh(this.mPullView);
        this.cKd = (TextView) LayoutInflater.from(this.cJU.getPageContext().getPageActivity()).inflate(i.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.cJX.addFooterView(this.cKd);
        this.cJW = new s(this.cJU.getPageContext().getPageActivity());
        this.mProgressBar = this.cJW.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cJU);
        this.cJX.addHeaderView(this.cJW);
        this.cJW.setVisibility(8);
        this.cJZ = (RelativeLayout) this.cJW.findViewById(i.f.guidecontainer);
        this.cKc = (LinearLayout) this.cJW.findViewById(i.f.guideopenbtn);
        this.cKa = (TextView) this.cJW.findViewById(i.f.guidetip);
        this.cKb = (TextView) this.cJW.findViewById(i.f.guideopen);
        this.cKc.setOnClickListener(this.cJU);
        this.cJY = new n(this.cJU, null);
        this.cJX.setAdapter((ListAdapter) this.cJY);
        this.cJX.setOnScrollListener(this.cJY);
    }

    public void onChangeSkinType(int i) {
        this.cJU.getLayoutMode().ad(i == 1);
        this.cJU.getLayoutMode().k(this.cJV);
        this.cJU.getLayoutMode().k(this.cKd);
        this.cJU.getLayoutMode().k(this.cJW);
        al.i(this.cJV, i.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cM(i);
        this.cJY.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cIN = cVar;
            arE();
            ArrayList<e> aqW = cVar.aqW();
            this.cJY.b(this.cIN);
            if (aqW.size() == cJT) {
                this.cKd.setVisibility(0);
                this.cKd.setText(cVar.aqT());
                return;
            }
            this.cKd.setVisibility(8);
        }
    }

    private void arE() {
        if (this.cIN != null) {
            this.cJW.setHasPrivilege(this.cIN.ara());
            this.cJW.setmCurrentStatus(this.cIN.arc());
            TextView message1 = this.cJW.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cIN.aqQ()) + this.cIN.afU() + this.cIN.aqR());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(i.c.sign_all_forum_text_color));
            int length = this.cIN.aqQ().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cIN.afU().length() + length, 33);
            message1.setText(spannableString);
            this.cJW.getMessage2().setText(this.cIN.aqS());
            this.cKa.setText(this.cIN.getContent());
            if (TextUtils.isEmpty(this.cIN.arb())) {
                this.cKb.setText(i.h.sign_all_forum_memberbtn_content);
            } else {
                this.cKb.setText(this.cIN.arb());
            }
            this.cJW.setVisibility(0);
            if (this.cIN.ara() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cJZ.setVisibility(8);
            } else {
                this.cJZ.setVisibility(0);
            }
        }
    }

    public void nv() {
        this.cJX.nv();
    }

    public void IZ() {
        this.cJX.completePullRefresh();
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cJX.setOnItemClickListener(onItemClickListener);
    }

    public s arF() {
        return this.cJW;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView arG() {
        return this.cJX;
    }

    public c arH() {
        return this.cIN;
    }

    public n arI() {
        return this.cJY;
    }

    public LinearLayout arJ() {
        return this.cKc;
    }
}

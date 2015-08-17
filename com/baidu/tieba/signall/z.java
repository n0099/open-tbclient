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
    public static int cBv;
    private c cAp;
    private n cBA;
    private RelativeLayout cBB;
    private TextView cBC;
    private TextView cBD;
    private LinearLayout cBE;
    private TextView cBF;
    private SignAllForumActivity cBw;
    private RelativeLayout cBx;
    private s cBy;
    private BdListView cBz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.z mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cBw = signAllForumActivity;
        this.cBw.setContentView(i.g.signallforum_view);
        this.cBx = (RelativeLayout) this.cBw.findViewById(i.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cBw.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cBw.getPageContext().getString(i.C0057i.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.cBz = (BdListView) this.cBw.findViewById(i.f.signallforum_list);
        this.cBz.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.z(signAllForumActivity.getPageContext());
        this.cBz.setPullRefresh(this.mPullView);
        this.cBF = (TextView) LayoutInflater.from(this.cBw.getPageContext().getPageActivity()).inflate(i.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.cBz.addFooterView(this.cBF);
        this.cBy = new s(this.cBw.getPageContext().getPageActivity());
        this.mProgressBar = this.cBy.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cBw);
        this.cBz.addHeaderView(this.cBy);
        this.cBy.setVisibility(8);
        this.cBB = (RelativeLayout) this.cBy.findViewById(i.f.guidecontainer);
        this.cBE = (LinearLayout) this.cBy.findViewById(i.f.guideopenbtn);
        this.cBC = (TextView) this.cBy.findViewById(i.f.guidetip);
        this.cBD = (TextView) this.cBy.findViewById(i.f.guideopen);
        this.cBE.setOnClickListener(this.cBw);
        this.cBA = new n(this.cBw, null);
        this.cBz.setAdapter((ListAdapter) this.cBA);
        this.cBz.setOnScrollListener(this.cBA);
    }

    public void onChangeSkinType(int i) {
        this.cBw.getLayoutMode().ad(i == 1);
        this.cBw.getLayoutMode().k(this.cBx);
        this.cBw.getLayoutMode().k(this.cBF);
        this.cBw.getLayoutMode().k(this.cBy);
        al.j(this.cBx, i.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cG(i);
        this.cBA.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cAp = cVar;
            anv();
            ArrayList<e> amN = cVar.amN();
            this.cBA.b(this.cAp);
            if (amN.size() == cBv) {
                this.cBF.setVisibility(0);
                this.cBF.setText(cVar.amK());
                return;
            }
            this.cBF.setVisibility(8);
        }
    }

    private void anv() {
        if (this.cAp != null) {
            this.cBy.setHasPrivilege(this.cAp.amR());
            this.cBy.setmCurrentStatus(this.cAp.amT());
            TextView message1 = this.cBy.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cAp.amH()) + this.cAp.afD() + this.cAp.amI());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(i.c.sign_all_forum_text_color));
            int length = this.cAp.amH().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cAp.afD().length() + length, 33);
            message1.setText(spannableString);
            this.cBy.getMessage2().setText(this.cAp.amJ());
            this.cBC.setText(this.cAp.getContent());
            if (TextUtils.isEmpty(this.cAp.amS())) {
                this.cBD.setText(i.C0057i.sign_all_forum_memberbtn_content);
            } else {
                this.cBD.setText(this.cAp.amS());
            }
            this.cBy.setVisibility(0);
            if (this.cAp.amR() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cBB.setVisibility(8);
            } else {
                this.cBB.setVisibility(0);
            }
        }
    }

    public void ny() {
        this.cBz.ny();
    }

    public void Jl() {
        this.cBz.completePullRefresh();
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cBz.setOnItemClickListener(onItemClickListener);
    }

    public s anw() {
        return this.cBy;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView anx() {
        return this.cBz;
    }

    public c any() {
        return this.cAp;
    }

    public n anz() {
        return this.cBA;
    }

    public LinearLayout anA() {
        return this.cBE;
    }
}

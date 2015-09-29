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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int cQO;
    private c cPI;
    private SignAllForumActivity cQP;
    private RelativeLayout cQQ;
    private s cQR;
    private BdListView cQS;
    private n cQT;
    private RelativeLayout cQU;
    private TextView cQV;
    private TextView cQW;
    private LinearLayout cQX;
    private TextView cQY;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cQP = signAllForumActivity;
        this.cQP.setContentView(i.g.signallforum_view);
        this.cQQ = (RelativeLayout) this.cQP.findViewById(i.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cQP.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cQP.getPageContext().getString(i.h.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.cQS = (BdListView) this.cQP.findViewById(i.f.signallforum_list);
        this.cQS.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.r(signAllForumActivity.getPageContext());
        this.cQS.setPullRefresh(this.mPullView);
        this.cQY = (TextView) LayoutInflater.from(this.cQP.getPageContext().getPageActivity()).inflate(i.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.cQS.addFooterView(this.cQY);
        this.cQR = new s(this.cQP.getPageContext().getPageActivity());
        this.mProgressBar = this.cQR.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cQP);
        this.cQS.addHeaderView(this.cQR);
        this.cQR.setVisibility(8);
        this.cQU = (RelativeLayout) this.cQR.findViewById(i.f.guidecontainer);
        this.cQX = (LinearLayout) this.cQR.findViewById(i.f.guideopenbtn);
        this.cQV = (TextView) this.cQR.findViewById(i.f.guidetip);
        this.cQW = (TextView) this.cQR.findViewById(i.f.guideopen);
        this.cQX.setOnClickListener(this.cQP);
        this.cQT = new n(this.cQP, null);
        this.cQS.setAdapter((ListAdapter) this.cQT);
        this.cQS.setOnScrollListener(this.cQT);
    }

    public void onChangeSkinType(int i) {
        this.cQP.getLayoutMode().ad(i == 1);
        this.cQP.getLayoutMode().k(this.cQQ);
        this.cQP.getLayoutMode().k(this.cQY);
        this.cQP.getLayoutMode().k(this.cQR);
        am.j(this.cQQ, i.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cN(i);
        this.cQT.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cPI = cVar;
            atS();
            ArrayList<e> atk = cVar.atk();
            this.cQT.b(this.cPI);
            if (atk.size() == cQO) {
                this.cQY.setVisibility(0);
                this.cQY.setText(cVar.ath());
                return;
            }
            this.cQY.setVisibility(8);
        }
    }

    private void atS() {
        if (this.cPI != null) {
            this.cQR.setHasPrivilege(this.cPI.ato());
            this.cQR.setmCurrentStatus(this.cPI.atq());
            TextView message1 = this.cQR.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cPI.ate()) + this.cPI.ahT() + this.cPI.atf());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(i.c.sign_all_forum_text_color));
            int length = this.cPI.ate().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cPI.ahT().length() + length, 33);
            message1.setText(spannableString);
            this.cQR.getMessage2().setText(this.cPI.atg());
            this.cQV.setText(this.cPI.getContent());
            if (TextUtils.isEmpty(this.cPI.atp())) {
                this.cQW.setText(i.h.sign_all_forum_memberbtn_content);
            } else {
                this.cQW.setText(this.cPI.atp());
            }
            this.cQR.setVisibility(0);
            if (this.cPI.ato() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cQU.setVisibility(8);
            } else {
                this.cQU.setVisibility(0);
            }
        }
    }

    public void nw() {
        this.cQS.nw();
    }

    public void IU() {
        this.cQS.completePullRefresh();
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cQS.setOnItemClickListener(onItemClickListener);
    }

    public s atT() {
        return this.cQR;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView atU() {
        return this.cQS;
    }

    public c atV() {
        return this.cPI;
    }

    public n atW() {
        return this.cQT;
    }

    public LinearLayout atX() {
        return this.cQX;
    }
}

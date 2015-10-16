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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int cRn;
    private c cQh;
    private SignAllForumActivity cRo;
    private RelativeLayout cRp;
    private s cRq;
    private BdListView cRr;
    private n cRs;
    private RelativeLayout cRt;
    private TextView cRu;
    private TextView cRv;
    private LinearLayout cRw;
    private TextView cRx;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cRo = signAllForumActivity;
        this.cRo.setContentView(i.g.signallforum_view);
        this.cRp = (RelativeLayout) this.cRo.findViewById(i.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cRo.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cRo.getPageContext().getString(i.h.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.cRr = (BdListView) this.cRo.findViewById(i.f.signallforum_list);
        this.cRr.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.r(signAllForumActivity.getPageContext());
        this.cRr.setPullRefresh(this.mPullView);
        this.cRx = (TextView) LayoutInflater.from(this.cRo.getPageContext().getPageActivity()).inflate(i.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.cRr.addFooterView(this.cRx);
        this.cRq = new s(this.cRo.getPageContext().getPageActivity());
        this.mProgressBar = this.cRq.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cRo);
        this.cRr.addHeaderView(this.cRq);
        this.cRq.setVisibility(8);
        this.cRt = (RelativeLayout) this.cRq.findViewById(i.f.guidecontainer);
        this.cRw = (LinearLayout) this.cRq.findViewById(i.f.guideopenbtn);
        this.cRu = (TextView) this.cRq.findViewById(i.f.guidetip);
        this.cRv = (TextView) this.cRq.findViewById(i.f.guideopen);
        this.cRw.setOnClickListener(this.cRo);
        this.cRs = new n(this.cRo, null);
        this.cRr.setAdapter((ListAdapter) this.cRs);
        this.cRr.setOnScrollListener(this.cRs);
    }

    public void onChangeSkinType(int i) {
        this.cRo.getLayoutMode().ad(i == 1);
        this.cRo.getLayoutMode().k(this.cRp);
        this.cRo.getLayoutMode().k(this.cRx);
        this.cRo.getLayoutMode().k(this.cRq);
        an.j(this.cRp, i.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cN(i);
        this.cRs.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cQh = cVar;
            atY();
            ArrayList<e> atq = cVar.atq();
            this.cRs.b(this.cQh);
            if (atq.size() == cRn) {
                this.cRx.setVisibility(0);
                this.cRx.setText(cVar.atn());
                return;
            }
            this.cRx.setVisibility(8);
        }
    }

    private void atY() {
        if (this.cQh != null) {
            this.cRq.setHasPrivilege(this.cQh.atu());
            this.cRq.setmCurrentStatus(this.cQh.atw());
            TextView message1 = this.cRq.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cQh.atk()) + this.cQh.ahT() + this.cQh.atl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(i.c.sign_all_forum_text_color));
            int length = this.cQh.atk().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cQh.ahT().length() + length, 33);
            message1.setText(spannableString);
            this.cRq.getMessage2().setText(this.cQh.atm());
            this.cRu.setText(this.cQh.getContent());
            if (TextUtils.isEmpty(this.cQh.atv())) {
                this.cRv.setText(i.h.sign_all_forum_memberbtn_content);
            } else {
                this.cRv.setText(this.cQh.atv());
            }
            this.cRq.setVisibility(0);
            if (this.cQh.atu() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cRt.setVisibility(8);
            } else {
                this.cRt.setVisibility(0);
            }
        }
    }

    public void nw() {
        this.cRr.nw();
    }

    public void IU() {
        this.cRr.completePullRefresh();
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cRr.setOnItemClickListener(onItemClickListener);
    }

    public s atZ() {
        return this.cRq;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aua() {
        return this.cRr;
    }

    public c aub() {
        return this.cQh;
    }

    public n auc() {
        return this.cRs;
    }

    public LinearLayout aud() {
        return this.cRw;
    }
}

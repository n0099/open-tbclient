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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int bAj;
    private c dpZ;
    private SignAllForumActivity drf;
    private ViewGroup drg;
    private s drh;
    private BdListView dri;
    private MemberBuyEntryButton drj;
    private n drk;
    private RelativeLayout drl;
    private TextView drm;
    private TextView drn;
    private LinearLayout dro;
    private TextView drp;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.s mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.drf = signAllForumActivity;
        this.drf.setContentView(n.g.signallforum_view);
        this.drg = (ViewGroup) this.drf.findViewById(n.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.drf.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.drf.getPageContext().getString(n.i.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.dri = (BdListView) this.drf.findViewById(n.f.signallforum_list);
        this.drj = (MemberBuyEntryButton) this.drf.findViewById(n.f.sign_all_forum_buy_member);
        this.dri.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.s(signAllForumActivity.getPageContext());
        this.dri.setPullRefresh(this.mPullView);
        this.drp = (TextView) LayoutInflater.from(this.drf.getPageContext().getPageActivity()).inflate(n.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.dri.addFooterView(this.drp);
        this.drh = new s(this.drf.getPageContext().getPageActivity());
        this.mProgressBar = this.drh.getProgressBar();
        this.mProgressBar.setOnClickListener(this.drf);
        this.dri.addHeaderView(this.drh);
        this.drh.setVisibility(8);
        this.drl = (RelativeLayout) this.drh.findViewById(n.f.guidecontainer);
        this.dro = (LinearLayout) this.drh.findViewById(n.f.guideopenbtn);
        this.drm = (TextView) this.drh.findViewById(n.f.guidetip);
        this.drn = (TextView) this.drh.findViewById(n.f.guideopen);
        this.dro.setOnClickListener(this.drf);
        this.drk = new n(this.drf, null);
        this.dri.setAdapter((ListAdapter) this.drk);
        this.dri.setOnScrollListener(this.drk);
    }

    public void onChangeSkinType(int i) {
        this.drf.getLayoutMode().af(i == 1);
        this.drf.getLayoutMode().k(this.drg);
        this.drf.getLayoutMode().k(this.drp);
        this.drf.getLayoutMode().k(this.drh);
        as.j(this.drg, n.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.drj.onChangeSkinType(getPageContext(), i);
        this.mPullView.cV(i);
        this.drk.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.dpZ = cVar;
            aAc();
            this.drj.show(z);
            ArrayList<e> azu = cVar.azu();
            this.drk.b(this.dpZ);
            if (azu.size() == bAj) {
                this.drp.setVisibility(0);
                this.drp.setText(cVar.azr());
                return;
            }
            this.drp.setVisibility(8);
        }
    }

    private void aAc() {
        if (this.dpZ != null) {
            this.drh.setHasPrivilege(this.dpZ.azy());
            this.drh.setmCurrentStatus(this.dpZ.azA());
            TextView message1 = this.drh.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.dpZ.azo()) + this.dpZ.amY() + this.dpZ.azp());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(n.c.sign_all_forum_text_color));
            int length = this.dpZ.azo().length();
            spannableString.setSpan(foregroundColorSpan, length, this.dpZ.amY().length() + length, 33);
            message1.setText(spannableString);
            this.drh.getMessage2().setText(this.dpZ.azq());
            this.drm.setText(this.dpZ.getContent());
            if (TextUtils.isEmpty(this.dpZ.azz())) {
                this.drn.setText(n.i.sign_all_forum_memberbtn_content);
            } else {
                this.drn.setText(this.dpZ.azz());
            }
            this.drh.setVisibility(0);
            if (this.dpZ.azy() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.drl.setVisibility(8);
            } else {
                this.drl.setVisibility(0);
            }
        }
    }

    public void nD() {
        this.dri.nD();
    }

    public void Kr() {
        this.dri.completePullRefresh();
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.dri.setOnItemClickListener(onItemClickListener);
    }

    public s aAd() {
        return this.drh;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aAe() {
        return this.dri;
    }

    public c aAf() {
        return this.dpZ;
    }

    public n aAg() {
        return this.drk;
    }

    public LinearLayout aAh() {
        return this.dro;
    }
}

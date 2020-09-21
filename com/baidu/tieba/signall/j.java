package com.baidu.tieba.signall;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int mgY;
    private BdListView VG;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c mfD;
    private SignAllForumActivity mgZ;
    private SignAllForumProgressView mha;
    private g mhb;
    private RelativeLayout mhc;
    private TextView mhd;
    private TextView mhe;
    private LinearLayout mhf;
    private TextView mhg;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.mgZ = signAllForumActivity;
        this.mgZ.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.mgZ.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mgZ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mgZ.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.mgZ.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.VG = (BdListView) this.mgZ.findViewById(R.id.signallforum_list);
        this.VG.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.VG.setPullRefresh(this.mPullView);
        this.mhg = (TextView) LayoutInflater.from(this.mgZ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.VG.addFooterView(this.mhg);
        this.mha = new SignAllForumProgressView(this.mgZ.getPageContext().getPageActivity());
        this.mProgressBar = this.mha.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mgZ);
        this.VG.addHeaderView(this.mha);
        this.mha.setVisibility(8);
        this.mhc = (RelativeLayout) this.mha.findViewById(R.id.guidecontainer);
        this.mhf = (LinearLayout) this.mha.findViewById(R.id.guideopenbtn);
        this.mhd = (TextView) this.mha.findViewById(R.id.guidetip);
        this.mhe = (TextView) this.mha.findViewById(R.id.guideopen);
        this.mhf.setOnClickListener(this.mgZ);
        this.mhb = new g(this.mgZ, null);
        this.VG.setAdapter((ListAdapter) this.mhb);
        this.VG.setOnScrollListener(this.mhb);
    }

    public void onChangeSkinType(int i) {
        this.mgZ.getLayoutMode().setNightMode(i == 1);
        this.mgZ.getLayoutMode().onModeChanged(this.mRootView);
        this.mgZ.getLayoutMode().onModeChanged(this.mhg);
        this.mgZ.getLayoutMode().onModeChanged(this.mha);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mha != null) {
            this.mha.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.mhb.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.mfD = cVar;
            dys();
            ArrayList<d> dxG = cVar.dxG();
            this.mhb.c(this.mfD);
            if (dxG.size() == mgY) {
                this.mhg.setVisibility(0);
                this.mhg.setText(cVar.dxD());
            } else {
                this.mhg.setVisibility(8);
            }
            String dxx = this.mfD.dxx();
            if (!StringUtils.isNull(dxx)) {
                this.mha.a(this.mgZ, dxx, this.mfD.dxy());
                return;
            }
            this.mha.dyr();
        }
    }

    private void dys() {
        if (this.mfD != null) {
            this.mha.setHasPrivilege(this.mfD.dxK());
            this.mha.setmCurrentStatus(this.mfD.dxM());
            TextView message1 = this.mha.getMessage1();
            SpannableString spannableString = new SpannableString(this.mfD.dxA() + this.mfD.dgZ() + this.mfD.dxB());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.mfD.dxA().length();
            spannableString.setSpan(foregroundColorSpan, length, this.mfD.dgZ().length() + length, 33);
            message1.setText(spannableString);
            this.mha.getMessage2().setText(this.mfD.dxC());
            this.mhd.setText(this.mfD.getContent());
            if (TextUtils.isEmpty(this.mfD.dxL())) {
                this.mhe.setText(R.string.member_buy_open);
            } else {
                this.mhe.setText(this.mfD.dxL());
            }
            this.mha.setVisibility(0);
            if (this.mfD.dxK() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.mhc.setVisibility(8);
            } else {
                this.mhc.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.VG.startPullRefresh();
    }

    public void completeRefresh() {
        this.VG.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.VG.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dyt() {
        return this.mha;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dyu() {
        return this.VG;
    }

    public c dyv() {
        return this.mfD;
    }

    public g dyw() {
        return this.mhb;
    }

    public LinearLayout dyx() {
        return this.mhf;
    }

    public void setListViewSelection(int i) {
        this.VG.setSelection(i);
    }

    public RelativeLayout caY() {
        return this.mRootView;
    }
}

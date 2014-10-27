package com.baidu.tieba.recommend;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.z;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    private final DailyRecommendActivity bIp;
    private final PinnedHeaderListView bIq;
    private final View bIr;
    private final TextView bIs;
    private final i bIt;
    private final z bxJ;
    public final PbListView bxK;
    private final NavigationBar mNavigationBar;
    private final ProgressBar mProgress;
    private final View mView;

    public r(DailyRecommendActivity dailyRecommendActivity, aa aaVar, l lVar) {
        super(dailyRecommendActivity);
        this.bIp = dailyRecommendActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.daily_recommend_view, null);
        this.bIp.setContentView(this.mView);
        this.bIq = (PinnedHeaderListView) this.mView.findViewById(v.pinnedHeaderListview);
        this.bIt = new i(dailyRecommendActivity, lVar);
        this.bIs = (TextView) this.mView.findViewById(v.text_info);
        this.bxJ = new z(this.mContext);
        this.bIq.setPullRefresh(this.bxJ);
        this.bIq.setAdapter((ListAdapter) this.bIt);
        this.bIq.setOnSrollToBottomListener(aaVar);
        this.mProgress = (ProgressBar) this.mView.findViewById(v.progress);
        this.mProgress.setVisibility(8);
        this.bxK = new PbListView(this.bIp);
        this.bxK.setOnClickListener(new s(this));
        this.bIr = this.bxK.getView().findViewById(v.pb_more_view);
        this.mNavigationBar = (NavigationBar) this.bIp.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bIp.getString(y.dailyrecommend_title));
    }

    public void XB() {
        this.bxK.YH();
    }

    public void YH() {
        this.mProgress.setVisibility(0);
    }

    public void d(boolean z, String str) {
        this.mProgress.setVisibility(8);
        if (!z && str != null) {
            this.bIp.showToast(str);
        }
    }

    public void onDestroy() {
        this.mProgress.setVisibility(8);
        this.bxK.XT();
    }

    public void a(com.baidu.tieba.data.l lVar, boolean z) {
        this.bIq.hN();
        if (z) {
            this.bxK.setText(this.bIp.getString(y.pb_load_more));
        } else {
            this.bxK.setText(this.bIp.getString(y.no_more_to_load));
        }
        this.bxK.XT();
        if (lVar != null) {
            if (lVar.yG().size() > 0) {
                this.bIq.setNextPage(this.bxK);
            }
            this.bIt.b(lVar);
            this.bIt.notifyDataSetChanged();
        }
    }

    public void abL() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.custom_home_text_info);
        this.bIs.setVisibility(0);
        loadAnimation.setAnimationListener(new t(this));
        this.bIs.startAnimation(loadAnimation);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        aw.h(this.bIq, com.baidu.tieba.s.cp_bg_line_c);
        this.bxJ.bM(i);
        if (this.bxK != null) {
            this.bxK.bM(i);
        }
        aw.b(this.bIs, com.baidu.tieba.s.cp_link_tip_d, 1);
        aw.h((View) this.bIs, u.bg_update);
        this.bIt.notifyDataSetChanged();
    }

    public void onResume() {
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.bxJ.a(fVar);
    }
}

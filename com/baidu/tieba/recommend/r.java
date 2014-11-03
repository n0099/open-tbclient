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
    private final DailyRecommendActivity bID;
    private final PinnedHeaderListView bIE;
    private final View bIF;
    private final TextView bIG;
    private final i bIH;
    private final z bxX;
    public final PbListView bxY;
    private final NavigationBar mNavigationBar;
    private final ProgressBar mProgress;
    private final View mView;

    public r(DailyRecommendActivity dailyRecommendActivity, aa aaVar, l lVar) {
        super(dailyRecommendActivity);
        this.bID = dailyRecommendActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.daily_recommend_view, null);
        this.bID.setContentView(this.mView);
        this.bIE = (PinnedHeaderListView) this.mView.findViewById(v.pinnedHeaderListview);
        this.bIH = new i(dailyRecommendActivity, lVar);
        this.bIG = (TextView) this.mView.findViewById(v.text_info);
        this.bxX = new z(this.mContext);
        this.bIE.setPullRefresh(this.bxX);
        this.bIE.setAdapter((ListAdapter) this.bIH);
        this.bIE.setOnSrollToBottomListener(aaVar);
        this.mProgress = (ProgressBar) this.mView.findViewById(v.progress);
        this.mProgress.setVisibility(8);
        this.bxY = new PbListView(this.bID);
        this.bxY.setOnClickListener(new s(this));
        this.bIF = this.bxY.getView().findViewById(v.pb_more_view);
        this.mNavigationBar = (NavigationBar) this.bID.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bID.getString(y.dailyrecommend_title));
    }

    public void XE() {
        this.bxY.YK();
    }

    public void YK() {
        this.mProgress.setVisibility(0);
    }

    public void d(boolean z, String str) {
        this.mProgress.setVisibility(8);
        if (!z && str != null) {
            this.bID.showToast(str);
        }
    }

    public void onDestroy() {
        this.mProgress.setVisibility(8);
        this.bxY.XW();
    }

    public void a(com.baidu.tieba.data.l lVar, boolean z) {
        this.bIE.hN();
        if (z) {
            this.bxY.setText(this.bID.getString(y.pb_load_more));
        } else {
            this.bxY.setText(this.bID.getString(y.no_more_to_load));
        }
        this.bxY.XW();
        if (lVar != null) {
            if (lVar.yI().size() > 0) {
                this.bIE.setNextPage(this.bxY);
            }
            this.bIH.b(lVar);
            this.bIH.notifyDataSetChanged();
        }
    }

    public void abO() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.custom_home_text_info);
        this.bIG.setVisibility(0);
        loadAnimation.setAnimationListener(new t(this));
        this.bIG.startAnimation(loadAnimation);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        aw.h(this.bIE, com.baidu.tieba.s.cp_bg_line_c);
        this.bxX.bM(i);
        if (this.bxY != null) {
            this.bxY.bM(i);
        }
        aw.b(this.bIG, com.baidu.tieba.s.cp_link_tip_d, 1);
        aw.h((View) this.bIG, u.bg_update);
        this.bIH.notifyDataSetChanged();
    }

    public void onResume() {
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.bxX.a(fVar);
    }
}

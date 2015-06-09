package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private int ajy = -1;
    private ImageView bVA;
    private PersonInfoActivity bVg;
    private View bVm;
    private RelativeLayout bVn;
    private TextView bVo;
    private TextView bVp;
    private ImageView bVq;
    private View bVr;
    private RelativeLayout bVs;
    private TextView bVt;
    private TextView bVu;
    private ImageView bVv;
    private View bVw;
    private RelativeLayout bVx;
    private TextView bVy;
    private TextView bVz;
    private boolean mIsHost;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bVm = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVn = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_like_rl);
        this.bVo = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_like_text);
        this.bVp = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_like_bar);
        this.bVq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.bVn.setOnClickListener(this.bVg);
        this.bVr = this.mRootView.findViewById(com.baidu.tieba.q.line1);
        this.bVs = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_friend_rl);
        this.bVt = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_friend_text);
        this.bVu = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_friend);
        this.bVv = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_middle);
        this.bVs.setOnClickListener(this.bVg);
        this.bVw = this.mRootView.findViewById(com.baidu.tieba.q.line2);
        this.bVx = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_group_rl);
        this.bVy = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_group_text);
        this.bVz = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_group);
        this.bVA = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        this.bVx.setOnClickListener(this.bVg);
        oG();
    }

    public RelativeLayout afl() {
        return this.bVx;
    }

    public RelativeLayout afd() {
        return this.bVn;
    }

    public RelativeLayout aff() {
        return this.bVs;
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVm, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVn, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVo, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVp, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVq, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVr, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVs, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVt, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVu, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVv, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVw, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVx, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVy, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVz, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVA, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afm() {
        oG();
        v aeU = this.bVg.aeU();
        PersonTainInfo afy = aeU.afy();
        if (afy == null) {
            this.bVm.setVisibility(8);
        } else if (afy.getIsFriend() == 1) {
            this.bVm.setVisibility(8);
        } else {
            UserData userData = aeU.getUserData();
            if (userData == null) {
                this.bVm.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bVm.setVisibility(8);
                return;
            }
            if (personPrivate.yR() == 1) {
                this.bVn.setVisibility(0);
                this.bVr.setVisibility(0);
            } else {
                this.bVn.setVisibility(8);
                this.bVr.setVisibility(8);
            }
            if (personPrivate.yU() == 1) {
                this.bVs.setVisibility(0);
                this.bVr.setVisibility(0);
            } else {
                this.bVs.setVisibility(8);
                this.bVr.setVisibility(8);
            }
            int yS = personPrivate.yS();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (yS == 1 && appResponseToIntentClass) {
                this.bVx.setVisibility(0);
                this.bVw.setVisibility(0);
            } else {
                this.bVx.setVisibility(8);
                this.bVw.setVisibility(8);
            }
            this.bVm.setVisibility(0);
            List<CommonForum> commonForum = afy.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bVp.setText(N(arrayList));
            } else {
                this.bVn.setVisibility(8);
                this.bVr.setVisibility(8);
            }
            List<CommonFriend> commonFriend = afy.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bVu.setText(N(arrayList2));
            } else {
                this.bVs.setVisibility(8);
                this.bVr.setVisibility(8);
            }
            List<CommonGroup> commonGroup = afy.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bVz.setText(N(arrayList3));
            } else {
                this.bVx.setVisibility(8);
                this.bVw.setVisibility(8);
            }
            if (this.bVn.getVisibility() == 8 && this.bVs.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVm.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bVm.setLayoutParams(layoutParams);
            }
        }
    }

    public String N(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 10)) + this.bVg.getPageContext().getString(com.baidu.tieba.t.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 10) + this.bVg.getPageContext().getString(com.baidu.tieba.t.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 15)) + this.bVg.getPageContext().getString(com.baidu.tieba.t.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

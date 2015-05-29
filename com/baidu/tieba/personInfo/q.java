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
    private PersonInfoActivity bVf;
    private View bVl;
    private RelativeLayout bVm;
    private TextView bVn;
    private TextView bVo;
    private ImageView bVp;
    private View bVq;
    private RelativeLayout bVr;
    private TextView bVs;
    private TextView bVt;
    private ImageView bVu;
    private View bVv;
    private RelativeLayout bVw;
    private TextView bVx;
    private TextView bVy;
    private ImageView bVz;
    private boolean mIsHost;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bVl = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVm = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_like_rl);
        this.bVn = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_like_text);
        this.bVo = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_like_bar);
        this.bVp = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.bVm.setOnClickListener(this.bVf);
        this.bVq = this.mRootView.findViewById(com.baidu.tieba.q.line1);
        this.bVr = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_friend_rl);
        this.bVs = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_friend_text);
        this.bVt = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_friend);
        this.bVu = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_middle);
        this.bVr.setOnClickListener(this.bVf);
        this.bVv = this.mRootView.findViewById(com.baidu.tieba.q.line2);
        this.bVw = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.common_group_rl);
        this.bVx = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_group_text);
        this.bVy = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.common_group);
        this.bVz = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        this.bVw.setOnClickListener(this.bVf);
        oG();
    }

    public RelativeLayout afk() {
        return this.bVw;
    }

    public RelativeLayout afc() {
        return this.bVm;
    }

    public RelativeLayout afe() {
        return this.bVr;
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVl, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVm, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVn, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVo, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVp, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVq, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVr, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVs, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVt, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVu, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVv, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVw, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVx, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVy, com.baidu.tieba.n.cp_cont_b, 1);
            ay.i(this.bVz, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afl() {
        oG();
        v aeT = this.bVf.aeT();
        PersonTainInfo afx = aeT.afx();
        if (afx == null) {
            this.bVl.setVisibility(8);
        } else if (afx.getIsFriend() == 1) {
            this.bVl.setVisibility(8);
        } else {
            UserData userData = aeT.getUserData();
            if (userData == null) {
                this.bVl.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bVl.setVisibility(8);
                return;
            }
            if (personPrivate.yQ() == 1) {
                this.bVm.setVisibility(0);
                this.bVq.setVisibility(0);
            } else {
                this.bVm.setVisibility(8);
                this.bVq.setVisibility(8);
            }
            if (personPrivate.yT() == 1) {
                this.bVr.setVisibility(0);
                this.bVq.setVisibility(0);
            } else {
                this.bVr.setVisibility(8);
                this.bVq.setVisibility(8);
            }
            int yR = personPrivate.yR();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (yR == 1 && appResponseToIntentClass) {
                this.bVw.setVisibility(0);
                this.bVv.setVisibility(0);
            } else {
                this.bVw.setVisibility(8);
                this.bVv.setVisibility(8);
            }
            this.bVl.setVisibility(0);
            List<CommonForum> commonForum = afx.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bVo.setText(N(arrayList));
            } else {
                this.bVm.setVisibility(8);
                this.bVq.setVisibility(8);
            }
            List<CommonFriend> commonFriend = afx.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bVt.setText(N(arrayList2));
            } else {
                this.bVr.setVisibility(8);
                this.bVq.setVisibility(8);
            }
            List<CommonGroup> commonGroup = afx.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bVy.setText(N(arrayList3));
            } else {
                this.bVw.setVisibility(8);
                this.bVv.setVisibility(8);
            }
            if (this.bVm.getVisibility() == 8 && this.bVr.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVl.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bVl.setLayoutParams(layoutParams);
            }
        }
    }

    public String N(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 10)) + this.bVf.getPageContext().getString(com.baidu.tieba.t.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 10) + this.bVf.getPageContext().getString(com.baidu.tieba.t.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 15)) + this.bVf.getPageContext().getString(com.baidu.tieba.t.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

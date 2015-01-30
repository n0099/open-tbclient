package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private PersonInfoActivity bJZ;
    private View bKf;
    private RelativeLayout bKg;
    private TextView bKh;
    private TextView bKi;
    private ImageView bKj;
    private View bKk;
    private RelativeLayout bKl;
    private TextView bKm;
    private TextView bKn;
    private ImageView bKo;
    private View bKp;
    private RelativeLayout bKq;
    private TextView bKr;
    private TextView bKs;
    private ImageView bKt;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bKf = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKg = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_like_rl);
        this.bKh = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_text);
        this.bKi = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_bar);
        this.bKj = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bKg.setOnClickListener(this.bJZ);
        this.bKk = this.mRootView.findViewById(com.baidu.tieba.w.line1);
        this.bKl = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_rl);
        this.bKm = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_text);
        this.bKn = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend);
        this.bKo = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bKl.setOnClickListener(this.bJZ);
        this.bKp = this.mRootView.findViewById(com.baidu.tieba.w.line2);
        this.bKq = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_group_rl);
        this.bKr = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group_text);
        this.bKs = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group);
        this.bKt = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bKq.setOnClickListener(this.bJZ);
        kE();
    }

    public RelativeLayout abH() {
        return this.bKq;
    }

    public RelativeLayout abz() {
        return this.bKg;
    }

    public RelativeLayout abB() {
        return this.bKl;
    }

    public void kE() {
        bc.j(this.bKf, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKg, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKh, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKi, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKj, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKk, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKl, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKm, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKn, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKo, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKp, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKq, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKr, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKs, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKt, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abI() {
        v abq = this.bJZ.abq();
        PersonTainInfo abV = abq.abV();
        if (abV == null) {
            this.bKf.setVisibility(8);
        } else if (abV.getIsFriend() == 1) {
            this.bKf.setVisibility(8);
        } else {
            UserData userData = abq.getUserData();
            if (userData == null) {
                this.bKf.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bKf.setVisibility(8);
                return;
            }
            if (personPrivate.uN() == 1) {
                this.bKg.setVisibility(0);
                this.bKk.setVisibility(0);
            } else {
                this.bKg.setVisibility(8);
                this.bKk.setVisibility(8);
            }
            if (personPrivate.uQ() == 1) {
                this.bKl.setVisibility(0);
                this.bKk.setVisibility(0);
            } else {
                this.bKl.setVisibility(8);
                this.bKk.setVisibility(8);
            }
            if (personPrivate.uO() == 1) {
                this.bKq.setVisibility(0);
                this.bKp.setVisibility(0);
            } else {
                this.bKq.setVisibility(8);
                this.bKp.setVisibility(8);
            }
            this.bKf.setVisibility(0);
            List<CommonForum> commonForum = abV.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bKi.setText(M(arrayList));
            } else {
                this.bKg.setVisibility(8);
                this.bKk.setVisibility(8);
            }
            List<CommonFriend> commonFriend = abV.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bKn.setText(M(arrayList2));
            } else {
                this.bKl.setVisibility(8);
                this.bKk.setVisibility(8);
            }
            List<CommonGroup> commonGroup = abV.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bKs.setText(M(arrayList3));
            } else {
                this.bKq.setVisibility(8);
                this.bKp.setVisibility(8);
            }
            if (this.bKg.getVisibility() == 8 && this.bKl.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKf.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKf.setLayoutParams(layoutParams);
            }
        }
    }

    public String M(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.m.f(arrayList.get(0), 0, 10)) + this.bJZ.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.m.f(arrayList.get(1), 0, 10) + this.bJZ.getPageContext().getString(com.baidu.tieba.z.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.m.f(arrayList.get(0), 0, 15)) + this.bJZ.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.m.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

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
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private int aiq = -1;
    private TextView bSA;
    private TextView bSB;
    private ImageView bSC;
    private PersonInfoActivity bSi;
    private View bSo;
    private RelativeLayout bSp;
    private TextView bSq;
    private TextView bSr;
    private ImageView bSs;
    private View bSt;
    private RelativeLayout bSu;
    private TextView bSv;
    private TextView bSw;
    private ImageView bSx;
    private View bSy;
    private RelativeLayout bSz;
    private boolean mIsHost;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bSo = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bSp = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_like_rl);
        this.bSq = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_like_text);
        this.bSr = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_like_bar);
        this.bSs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.bSp.setOnClickListener(this.bSi);
        this.bSt = this.mRootView.findViewById(com.baidu.tieba.v.line1);
        this.bSu = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_friend_rl);
        this.bSv = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_friend_text);
        this.bSw = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_friend);
        this.bSx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bSu.setOnClickListener(this.bSi);
        this.bSy = this.mRootView.findViewById(com.baidu.tieba.v.line2);
        this.bSz = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_group_rl);
        this.bSA = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_group_text);
        this.bSB = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_group);
        this.bSC = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bSz.setOnClickListener(this.bSi);
        oq();
    }

    public RelativeLayout adQ() {
        return this.bSz;
    }

    public RelativeLayout adI() {
        return this.bSp;
    }

    public RelativeLayout adK() {
        return this.bSu;
    }

    public void oq() {
        if (this.aiq != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSo, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bSp, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSq, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSr, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSs, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bSt, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSu, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSv, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSw, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSx, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bSy, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSz, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSA, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSB, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSC, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void adR() {
        oq();
        v ady = this.bSi.ady();
        PersonTainInfo aed = ady.aed();
        if (aed == null) {
            this.bSo.setVisibility(8);
        } else if (aed.getIsFriend() == 1) {
            this.bSo.setVisibility(8);
        } else {
            UserData userData = ady.getUserData();
            if (userData == null) {
                this.bSo.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bSo.setVisibility(8);
                return;
            }
            if (personPrivate.xX() == 1) {
                this.bSp.setVisibility(0);
                this.bSt.setVisibility(0);
            } else {
                this.bSp.setVisibility(8);
                this.bSt.setVisibility(8);
            }
            if (personPrivate.ya() == 1) {
                this.bSu.setVisibility(0);
                this.bSt.setVisibility(0);
            } else {
                this.bSu.setVisibility(8);
                this.bSt.setVisibility(8);
            }
            int xY = personPrivate.xY();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (xY == 1 && appResponseToIntentClass) {
                this.bSz.setVisibility(0);
                this.bSy.setVisibility(0);
            } else {
                this.bSz.setVisibility(8);
                this.bSy.setVisibility(8);
            }
            this.bSo.setVisibility(0);
            List<CommonForum> commonForum = aed.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bSr.setText(Q(arrayList));
            } else {
                this.bSp.setVisibility(8);
                this.bSt.setVisibility(8);
            }
            List<CommonFriend> commonFriend = aed.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bSw.setText(Q(arrayList2));
            } else {
                this.bSu.setVisibility(8);
                this.bSt.setVisibility(8);
            }
            List<CommonGroup> commonGroup = aed.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bSB.setText(Q(arrayList3));
            } else {
                this.bSz.setVisibility(8);
                this.bSy.setVisibility(8);
            }
            if (this.bSp.getVisibility() == 8 && this.bSu.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSo.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bSo.setLayoutParams(layoutParams);
            }
        }
    }

    public String Q(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 10)) + this.bSi.getPageContext().getString(com.baidu.tieba.y.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 10) + this.bSi.getPageContext().getString(com.baidu.tieba.y.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 15)) + this.bSi.getPageContext().getString(com.baidu.tieba.y.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

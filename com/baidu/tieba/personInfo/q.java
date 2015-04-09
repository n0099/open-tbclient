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
    private int aiy = -1;
    private View bSE;
    private RelativeLayout bSF;
    private TextView bSG;
    private TextView bSH;
    private ImageView bSI;
    private View bSJ;
    private RelativeLayout bSK;
    private TextView bSL;
    private TextView bSM;
    private ImageView bSN;
    private View bSO;
    private RelativeLayout bSP;
    private TextView bSQ;
    private TextView bSR;
    private ImageView bSS;
    private PersonInfoActivity bSy;
    private boolean mIsHost;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bSE = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bSF = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_like_rl);
        this.bSG = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_like_text);
        this.bSH = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_like_bar);
        this.bSI = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.bSF.setOnClickListener(this.bSy);
        this.bSJ = this.mRootView.findViewById(com.baidu.tieba.v.line1);
        this.bSK = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_friend_rl);
        this.bSL = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_friend_text);
        this.bSM = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_friend);
        this.bSN = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bSK.setOnClickListener(this.bSy);
        this.bSO = this.mRootView.findViewById(com.baidu.tieba.v.line2);
        this.bSP = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.common_group_rl);
        this.bSQ = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_group_text);
        this.bSR = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.common_group);
        this.bSS = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bSP.setOnClickListener(this.bSy);
        oq();
    }

    public RelativeLayout aef() {
        return this.bSP;
    }

    public RelativeLayout adX() {
        return this.bSF;
    }

    public RelativeLayout adZ() {
        return this.bSK;
    }

    public void oq() {
        if (this.aiy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSE, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bSF, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSG, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSH, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSI, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bSJ, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSK, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSL, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSM, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSN, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bSO, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSP, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSQ, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSR, com.baidu.tieba.s.cp_cont_b, 1);
            ba.i(this.bSS, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void aeg() {
        oq();
        v adN = this.bSy.adN();
        PersonTainInfo aes = adN.aes();
        if (aes == null) {
            this.bSE.setVisibility(8);
        } else if (aes.getIsFriend() == 1) {
            this.bSE.setVisibility(8);
        } else {
            UserData userData = adN.getUserData();
            if (userData == null) {
                this.bSE.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bSE.setVisibility(8);
                return;
            }
            if (personPrivate.yd() == 1) {
                this.bSF.setVisibility(0);
                this.bSJ.setVisibility(0);
            } else {
                this.bSF.setVisibility(8);
                this.bSJ.setVisibility(8);
            }
            if (personPrivate.yg() == 1) {
                this.bSK.setVisibility(0);
                this.bSJ.setVisibility(0);
            } else {
                this.bSK.setVisibility(8);
                this.bSJ.setVisibility(8);
            }
            int ye = personPrivate.ye();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (ye == 1 && appResponseToIntentClass) {
                this.bSP.setVisibility(0);
                this.bSO.setVisibility(0);
            } else {
                this.bSP.setVisibility(8);
                this.bSO.setVisibility(8);
            }
            this.bSE.setVisibility(0);
            List<CommonForum> commonForum = aes.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bSH.setText(S(arrayList));
            } else {
                this.bSF.setVisibility(8);
                this.bSJ.setVisibility(8);
            }
            List<CommonFriend> commonFriend = aes.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bSM.setText(S(arrayList2));
            } else {
                this.bSK.setVisibility(8);
                this.bSJ.setVisibility(8);
            }
            List<CommonGroup> commonGroup = aes.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bSR.setText(S(arrayList3));
            } else {
                this.bSP.setVisibility(8);
                this.bSO.setVisibility(8);
            }
            if (this.bSF.getVisibility() == 8 && this.bSK.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSE.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bSE.setLayoutParams(layoutParams);
            }
        }
    }

    public String S(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 10)) + this.bSy.getPageContext().getString(com.baidu.tieba.y.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 10) + this.bSy.getPageContext().getString(com.baidu.tieba.y.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.l.f(arrayList.get(0), 0, 15)) + this.bSy.getPageContext().getString(com.baidu.tieba.y.comma) + com.baidu.tbadk.util.l.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

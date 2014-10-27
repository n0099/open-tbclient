package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private View HS;
    private PersonInfoActivity bEE;
    private View bEK;
    private RelativeLayout bEL;
    private TextView bEM;
    private TextView bEN;
    private ImageView bEO;
    private View bEP;
    private RelativeLayout bEQ;
    private TextView bER;
    private TextView bES;
    private ImageView bET;
    private View bEU;
    private RelativeLayout bEV;
    private TextView bEW;
    private TextView bEX;
    private ImageView bEY;
    private boolean mIsHost;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_common, null);
        nu();
    }

    private void nu() {
        this.bEK = this.HS.findViewById(com.baidu.tieba.v.root_next);
        this.bEL = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.common_like_rl);
        this.bEM = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_like_text);
        this.bEN = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_like_bar);
        this.bEO = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_top);
        this.bEL.setOnClickListener(this.bEE);
        this.bEP = this.HS.findViewById(com.baidu.tieba.v.line1);
        this.bEQ = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.common_friend_rl);
        this.bER = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_friend_text);
        this.bES = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_friend);
        this.bET = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bEQ.setOnClickListener(this.bEE);
        this.bEU = this.HS.findViewById(com.baidu.tieba.v.line2);
        this.bEV = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.common_group_rl);
        this.bEW = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_group_text);
        this.bEX = (TextView) this.HS.findViewById(com.baidu.tieba.v.common_group);
        this.bEY = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bEV.setOnClickListener(this.bEE);
        pS();
    }

    public RelativeLayout aaG() {
        return this.bEV;
    }

    public RelativeLayout aay() {
        return this.bEL;
    }

    public RelativeLayout aaA() {
        return this.bEQ;
    }

    public void pS() {
        aw.i(this.bEK, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bEL, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bEM, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bEN, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bEO, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bEP, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bEQ, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bER, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bES, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bET, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bEU, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bEV, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bEW, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bEX, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bEY, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void Hu() {
        v aap = this.bEE.aap();
        PersonTainInfo aaS = aap.aaS();
        if (aaS == null) {
            this.bEK.setVisibility(8);
        } else if (aaS.getIsFriend() == 1) {
            this.bEK.setVisibility(8);
        } else {
            UserData userData = aap.getUserData();
            if (userData == null) {
                this.bEK.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bEK.setVisibility(8);
                return;
            }
            if (personPrivate.qS() == 1) {
                this.bEL.setVisibility(0);
                this.bEP.setVisibility(0);
            } else {
                this.bEL.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            if (personPrivate.qV() == 1) {
                this.bEQ.setVisibility(0);
                this.bEP.setVisibility(0);
            } else {
                this.bEQ.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            if (personPrivate.qT() == 1) {
                this.bEV.setVisibility(0);
                this.bEU.setVisibility(0);
            } else {
                this.bEV.setVisibility(8);
                this.bEU.setVisibility(8);
            }
            this.bEK.setVisibility(0);
            List<CommonForum> commonForum = aaS.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bEN.setText(H(arrayList));
            } else {
                this.bEL.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            List<CommonFriend> commonFriend = aaS.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bES.setText(H(arrayList2));
            } else {
                this.bEQ.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            List<CommonGroup> commonGroup = aaS.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bEX.setText(H(arrayList3));
            } else {
                this.bEV.setVisibility(8);
                this.bEU.setVisibility(8);
            }
            if (this.bEL.getVisibility() == 8 && this.bEQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bEK.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bEK.setLayoutParams(layoutParams);
            }
        }
    }

    public String H(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tieba.game.a.g.g(arrayList.get(0), 0, 10)) + this.bEE.getString(com.baidu.tieba.y.comma) + com.baidu.tieba.game.a.g.g(arrayList.get(1), 0, 10) + this.bEE.getString(com.baidu.tieba.y.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tieba.game.a.g.g(arrayList.get(0), 0, 15)) + this.bEE.getString(com.baidu.tieba.y.comma) + com.baidu.tieba.game.a.g.g(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.HS;
    }
}

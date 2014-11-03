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
    private View HT;
    private PersonInfoActivity bES;
    private View bEY;
    private RelativeLayout bEZ;
    private TextView bFa;
    private TextView bFb;
    private ImageView bFc;
    private View bFd;
    private RelativeLayout bFe;
    private TextView bFf;
    private TextView bFg;
    private ImageView bFh;
    private View bFi;
    private RelativeLayout bFj;
    private TextView bFk;
    private TextView bFl;
    private ImageView bFm;
    private boolean mIsHost;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_common, null);
        nu();
    }

    private void nu() {
        this.bEY = this.HT.findViewById(com.baidu.tieba.v.root_next);
        this.bEZ = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.common_like_rl);
        this.bFa = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_like_text);
        this.bFb = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_like_bar);
        this.bFc = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_top);
        this.bEZ.setOnClickListener(this.bES);
        this.bFd = this.HT.findViewById(com.baidu.tieba.v.line1);
        this.bFe = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.common_friend_rl);
        this.bFf = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_friend_text);
        this.bFg = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_friend);
        this.bFh = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bFe.setOnClickListener(this.bES);
        this.bFi = this.HT.findViewById(com.baidu.tieba.v.line2);
        this.bFj = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.common_group_rl);
        this.bFk = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_group_text);
        this.bFl = (TextView) this.HT.findViewById(com.baidu.tieba.v.common_group);
        this.bFm = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bFj.setOnClickListener(this.bES);
        pU();
    }

    public RelativeLayout aaI() {
        return this.bFj;
    }

    public RelativeLayout aaA() {
        return this.bEZ;
    }

    public RelativeLayout aaC() {
        return this.bFe;
    }

    public void pU() {
        aw.i(this.bEY, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bEZ, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFa, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFb, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bFc, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bFd, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFe, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFf, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFg, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bFh, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bFi, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFj, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFk, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFl, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bFm, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void aaJ() {
        v aar = this.bES.aar();
        PersonTainInfo aaV = aar.aaV();
        if (aaV == null) {
            this.bEY.setVisibility(8);
        } else if (aaV.getIsFriend() == 1) {
            this.bEY.setVisibility(8);
        } else {
            UserData userData = aar.getUserData();
            if (userData == null) {
                this.bEY.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bEY.setVisibility(8);
                return;
            }
            if (personPrivate.qU() == 1) {
                this.bEZ.setVisibility(0);
                this.bFd.setVisibility(0);
            } else {
                this.bEZ.setVisibility(8);
                this.bFd.setVisibility(8);
            }
            if (personPrivate.qX() == 1) {
                this.bFe.setVisibility(0);
                this.bFd.setVisibility(0);
            } else {
                this.bFe.setVisibility(8);
                this.bFd.setVisibility(8);
            }
            if (personPrivate.qV() == 1) {
                this.bFj.setVisibility(0);
                this.bFi.setVisibility(0);
            } else {
                this.bFj.setVisibility(8);
                this.bFi.setVisibility(8);
            }
            this.bEY.setVisibility(0);
            List<CommonForum> commonForum = aaV.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bFb.setText(I(arrayList));
            } else {
                this.bEZ.setVisibility(8);
                this.bFd.setVisibility(8);
            }
            List<CommonFriend> commonFriend = aaV.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bFg.setText(I(arrayList2));
            } else {
                this.bFe.setVisibility(8);
                this.bFd.setVisibility(8);
            }
            List<CommonGroup> commonGroup = aaV.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bFl.setText(I(arrayList3));
            } else {
                this.bFj.setVisibility(8);
                this.bFi.setVisibility(8);
            }
            if (this.bEZ.getVisibility() == 8 && this.bFe.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bEY.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bEY.setLayoutParams(layoutParams);
            }
        }
    }

    public String I(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tieba.game.a.g.g(arrayList.get(0), 0, 10)) + this.bES.getString(com.baidu.tieba.y.comma) + com.baidu.tieba.game.a.g.g(arrayList.get(1), 0, 10) + this.bES.getString(com.baidu.tieba.y.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tieba.game.a.g.g(arrayList.get(0), 0, 15)) + this.bES.getString(com.baidu.tieba.y.comma) + com.baidu.tieba.game.a.g.g(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.HT;
    }
}

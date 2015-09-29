package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private int apR = -1;
    private PersonInfoActivity cqt;
    private View csE;
    private RelativeLayout csF;
    private TextView csG;
    private TextView csH;
    private ImageView csI;
    private View csJ;
    private RelativeLayout csK;
    private TextView csL;
    private TextView csM;
    private ImageView csN;
    private View csO;
    private RelativeLayout csP;
    private TextView csQ;
    private TextView csR;
    private ImageView csS;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_common, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csE = this.mRootView.findViewById(i.f.root_next);
        this.csF = (RelativeLayout) this.mRootView.findViewById(i.f.common_like_rl);
        this.csG = (TextView) this.mRootView.findViewById(i.f.common_like_text);
        this.csH = (TextView) this.mRootView.findViewById(i.f.common_like_bar);
        this.csI = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.csF.setOnClickListener(this.cqt);
        this.csJ = this.mRootView.findViewById(i.f.line1);
        this.csK = (RelativeLayout) this.mRootView.findViewById(i.f.common_friend_rl);
        this.csL = (TextView) this.mRootView.findViewById(i.f.common_friend_text);
        this.csM = (TextView) this.mRootView.findViewById(i.f.common_friend);
        this.csN = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.csK.setOnClickListener(this.cqt);
        this.csO = this.mRootView.findViewById(i.f.line2);
        this.csP = (RelativeLayout) this.mRootView.findViewById(i.f.common_group_rl);
        this.csQ = (TextView) this.mRootView.findViewById(i.f.common_group_text);
        this.csR = (TextView) this.mRootView.findViewById(i.f.common_group);
        this.csS = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.csP.setOnClickListener(this.cqt);
        oO();
    }

    public RelativeLayout ajB() {
        return this.csP;
    }

    public RelativeLayout ajr() {
        return this.csF;
    }

    public RelativeLayout aju() {
        return this.csK;
    }

    public void oO() {
        if (this.apR != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
            am.j(this.csE, i.c.cp_bg_line_d);
            am.i(this.csF, i.e.personinfo_select_bg);
            am.b(this.csG, i.c.cp_cont_d, 1);
            am.b(this.csH, i.c.cp_cont_b, 1);
            am.i(this.csI, i.e.icon_dredge_arrow_r_n);
            am.j(this.csJ, i.c.cp_bg_line_b);
            am.i(this.csK, i.e.personinfo_select_bg);
            am.b(this.csL, i.c.cp_cont_d, 1);
            am.b(this.csM, i.c.cp_cont_b, 1);
            am.i(this.csN, i.e.icon_dredge_arrow_r_n);
            am.j(this.csO, i.c.cp_bg_line_b);
            am.i(this.csP, i.e.personinfo_select_bg);
            am.b(this.csQ, i.c.cp_cont_d, 1);
            am.b(this.csR, i.c.cp_cont_b, 1);
            am.i(this.csS, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ajC() {
        oO();
        y ajf = this.cqt.ajf();
        PersonTainInfo ajN = ajf.ajN();
        if (ajN == null) {
            this.csE.setVisibility(8);
        } else if (ajN.getIsFriend() == 1) {
            this.csE.setVisibility(8);
        } else {
            UserData userData = ajf.getUserData();
            if (userData == null) {
                this.csE.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.csE.setVisibility(8);
                return;
            }
            if (personPrivate.zZ() == 1) {
                this.csF.setVisibility(0);
                this.csJ.setVisibility(0);
            } else {
                this.csF.setVisibility(8);
                this.csJ.setVisibility(8);
            }
            if (personPrivate.Ac() == 1) {
                this.csK.setVisibility(0);
                this.csJ.setVisibility(0);
            } else {
                this.csK.setVisibility(8);
                this.csJ.setVisibility(8);
            }
            int Aa = personPrivate.Aa();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (Aa == 1 && appResponseToIntentClass) {
                this.csP.setVisibility(0);
                this.csO.setVisibility(0);
            } else {
                this.csP.setVisibility(8);
                this.csO.setVisibility(8);
            }
            this.csE.setVisibility(0);
            List<CommonForum> commonForum = ajN.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.csH.setText(U(arrayList));
            } else {
                this.csF.setVisibility(8);
                this.csJ.setVisibility(8);
            }
            List<CommonFriend> commonFriend = ajN.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.csM.setText(U(arrayList2));
            } else {
                this.csK.setVisibility(8);
                this.csJ.setVisibility(8);
            }
            List<CommonGroup> commonGroup = ajN.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.csR.setText(U(arrayList3));
            } else {
                this.csP.setVisibility(8);
                this.csO.setVisibility(8);
            }
            if (this.csF.getVisibility() == 8 && this.csK.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csE.getLayoutParams();
                layoutParams.topMargin = 0;
                this.csE.setLayoutParams(layoutParams);
            }
        }
    }

    public String U(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 10)) + this.cqt.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 10) + this.cqt.getPageContext().getString(i.h.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 15)) + this.cqt.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

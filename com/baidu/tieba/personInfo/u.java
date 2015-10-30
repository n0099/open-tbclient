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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private int apS = -1;
    private PersonInfoActivity cqE;
    private View csP;
    private RelativeLayout csQ;
    private TextView csR;
    private TextView csS;
    private ImageView csT;
    private View csU;
    private RelativeLayout csV;
    private TextView csW;
    private TextView csX;
    private ImageView csY;
    private View csZ;
    private RelativeLayout cta;
    private TextView ctb;
    private TextView ctc;
    private ImageView ctd;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_common, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csP = this.mRootView.findViewById(i.f.root_next);
        this.csQ = (RelativeLayout) this.mRootView.findViewById(i.f.common_like_rl);
        this.csR = (TextView) this.mRootView.findViewById(i.f.common_like_text);
        this.csS = (TextView) this.mRootView.findViewById(i.f.common_like_bar);
        this.csT = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.csQ.setOnClickListener(this.cqE);
        this.csU = this.mRootView.findViewById(i.f.line1);
        this.csV = (RelativeLayout) this.mRootView.findViewById(i.f.common_friend_rl);
        this.csW = (TextView) this.mRootView.findViewById(i.f.common_friend_text);
        this.csX = (TextView) this.mRootView.findViewById(i.f.common_friend);
        this.csY = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.csV.setOnClickListener(this.cqE);
        this.csZ = this.mRootView.findViewById(i.f.line2);
        this.cta = (RelativeLayout) this.mRootView.findViewById(i.f.common_group_rl);
        this.ctb = (TextView) this.mRootView.findViewById(i.f.common_group_text);
        this.ctc = (TextView) this.mRootView.findViewById(i.f.common_group);
        this.ctd = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cta.setOnClickListener(this.cqE);
        oO();
    }

    public RelativeLayout ajx() {
        return this.cta;
    }

    public RelativeLayout ajn() {
        return this.csQ;
    }

    public RelativeLayout ajq() {
        return this.csV;
    }

    public void oO() {
        if (this.apS != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.csP, i.c.cp_bg_line_d);
            an.i(this.csQ, i.e.personinfo_select_bg);
            an.b(this.csR, i.c.cp_cont_d, 1);
            an.b(this.csS, i.c.cp_cont_b, 1);
            an.i(this.csT, i.e.icon_dredge_arrow_r_n);
            an.j(this.csU, i.c.cp_bg_line_b);
            an.i(this.csV, i.e.personinfo_select_bg);
            an.b(this.csW, i.c.cp_cont_d, 1);
            an.b(this.csX, i.c.cp_cont_b, 1);
            an.i(this.csY, i.e.icon_dredge_arrow_r_n);
            an.j(this.csZ, i.c.cp_bg_line_b);
            an.i(this.cta, i.e.personinfo_select_bg);
            an.b(this.ctb, i.c.cp_cont_d, 1);
            an.b(this.ctc, i.c.cp_cont_b, 1);
            an.i(this.ctd, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ajy() {
        oO();
        y ajb = this.cqE.ajb();
        PersonTainInfo ajJ = ajb.ajJ();
        if (ajJ == null) {
            this.csP.setVisibility(8);
        } else if (ajJ.getIsFriend() == 1) {
            this.csP.setVisibility(8);
        } else {
            UserData userData = ajb.getUserData();
            if (userData == null) {
                this.csP.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.csP.setVisibility(8);
                return;
            }
            if (personPrivate.zW() == 1) {
                this.csQ.setVisibility(0);
                this.csU.setVisibility(0);
            } else {
                this.csQ.setVisibility(8);
                this.csU.setVisibility(8);
            }
            if (personPrivate.zZ() == 1) {
                this.csV.setVisibility(0);
                this.csU.setVisibility(0);
            } else {
                this.csV.setVisibility(8);
                this.csU.setVisibility(8);
            }
            int zX = personPrivate.zX();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (zX == 1 && appResponseToIntentClass) {
                this.cta.setVisibility(0);
                this.csZ.setVisibility(0);
            } else {
                this.cta.setVisibility(8);
                this.csZ.setVisibility(8);
            }
            this.csP.setVisibility(0);
            List<CommonForum> commonForum = ajJ.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.csS.setText(U(arrayList));
            } else {
                this.csQ.setVisibility(8);
                this.csU.setVisibility(8);
            }
            List<CommonFriend> commonFriend = ajJ.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.csX.setText(U(arrayList2));
            } else {
                this.csV.setVisibility(8);
                this.csU.setVisibility(8);
            }
            List<CommonGroup> commonGroup = ajJ.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.ctc.setText(U(arrayList3));
            } else {
                this.cta.setVisibility(8);
                this.csZ.setVisibility(8);
            }
            if (this.csQ.getVisibility() == 8 && this.csV.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csP.getLayoutParams();
                layoutParams.topMargin = 0;
                this.csP.setLayoutParams(layoutParams);
            }
        }
    }

    public String U(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 10)) + this.cqE.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 10) + this.cqE.getPageContext().getString(i.h.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 15)) + this.cqE.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private TextView bIA;
    private TextView bIB;
    private ImageView bIC;
    private View bID;
    private RelativeLayout bIE;
    private TextView bIF;
    private TextView bIG;
    private ImageView bIH;
    private PersonInfoActivity bIn;
    private View bIt;
    private RelativeLayout bIu;
    private TextView bIv;
    private TextView bIw;
    private ImageView bIx;
    private View bIy;
    private RelativeLayout bIz;
    private boolean mIsHost;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bIt = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bIu = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_like_rl);
        this.bIv = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_text);
        this.bIw = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_bar);
        this.bIx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bIu.setOnClickListener(this.bIn);
        this.bIy = this.mRootView.findViewById(com.baidu.tieba.w.line1);
        this.bIz = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_rl);
        this.bIA = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_text);
        this.bIB = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend);
        this.bIC = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bIz.setOnClickListener(this.bIn);
        this.bID = this.mRootView.findViewById(com.baidu.tieba.w.line2);
        this.bIE = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_group_rl);
        this.bIF = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group_text);
        this.bIG = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group);
        this.bIH = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bIE.setOnClickListener(this.bIn);
        kE();
    }

    public RelativeLayout abd() {
        return this.bIE;
    }

    public RelativeLayout aaV() {
        return this.bIu;
    }

    public RelativeLayout aaX() {
        return this.bIz;
    }

    public void kE() {
        ax.j(this.bIt, com.baidu.tieba.t.cp_bg_line_d);
        ax.i(this.bIu, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIv, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bIw, com.baidu.tieba.t.cp_cont_b, 1);
        ax.i(this.bIx, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        ax.j(this.bIy, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bIz, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIA, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bIB, com.baidu.tieba.t.cp_cont_b, 1);
        ax.i(this.bIC, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        ax.j(this.bID, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bIE, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIF, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bIG, com.baidu.tieba.t.cp_cont_b, 1);
        ax.i(this.bIH, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abe() {
        v aaL = this.bIn.aaL();
        PersonTainInfo abr = aaL.abr();
        if (abr == null) {
            this.bIt.setVisibility(8);
        } else if (abr.getIsFriend() == 1) {
            this.bIt.setVisibility(8);
        } else {
            UserData userData = aaL.getUserData();
            if (userData == null) {
                this.bIt.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bIt.setVisibility(8);
                return;
            }
            if (personPrivate.uw() == 1) {
                this.bIu.setVisibility(0);
                this.bIy.setVisibility(0);
            } else {
                this.bIu.setVisibility(8);
                this.bIy.setVisibility(8);
            }
            if (personPrivate.uz() == 1) {
                this.bIz.setVisibility(0);
                this.bIy.setVisibility(0);
            } else {
                this.bIz.setVisibility(8);
                this.bIy.setVisibility(8);
            }
            if (personPrivate.ux() == 1) {
                this.bIE.setVisibility(0);
                this.bID.setVisibility(0);
            } else {
                this.bIE.setVisibility(8);
                this.bID.setVisibility(8);
            }
            this.bIt.setVisibility(0);
            List<CommonForum> commonForum = abr.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bIw.setText(L(arrayList));
            } else {
                this.bIu.setVisibility(8);
                this.bIy.setVisibility(8);
            }
            List<CommonFriend> commonFriend = abr.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bIB.setText(L(arrayList2));
            } else {
                this.bIz.setVisibility(8);
                this.bIy.setVisibility(8);
            }
            List<CommonGroup> commonGroup = abr.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bIG.setText(L(arrayList3));
            } else {
                this.bIE.setVisibility(8);
                this.bID.setVisibility(8);
            }
            if (this.bIu.getVisibility() == 8 && this.bIz.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIt.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bIt.setLayoutParams(layoutParams);
            }
        }
    }

    public String L(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.j.f(arrayList.get(0), 0, 10)) + this.bIn.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.j.f(arrayList.get(1), 0, 10) + this.bIn.getPageContext().getString(com.baidu.tieba.z.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.j.f(arrayList.get(0), 0, 15)) + this.bIn.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.j.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

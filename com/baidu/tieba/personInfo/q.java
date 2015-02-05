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
    private PersonInfoActivity bJY;
    private View bKe;
    private RelativeLayout bKf;
    private TextView bKg;
    private TextView bKh;
    private ImageView bKi;
    private View bKj;
    private RelativeLayout bKk;
    private TextView bKl;
    private TextView bKm;
    private ImageView bKn;
    private View bKo;
    private RelativeLayout bKp;
    private TextView bKq;
    private TextView bKr;
    private ImageView bKs;
    private View mRootView;

    public q(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_common, null);
        initView();
    }

    private void initView() {
        this.bKe = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKf = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_like_rl);
        this.bKg = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_text);
        this.bKh = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_like_bar);
        this.bKi = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bKf.setOnClickListener(this.bJY);
        this.bKj = this.mRootView.findViewById(com.baidu.tieba.w.line1);
        this.bKk = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_rl);
        this.bKl = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend_text);
        this.bKm = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_friend);
        this.bKn = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bKk.setOnClickListener(this.bJY);
        this.bKo = this.mRootView.findViewById(com.baidu.tieba.w.line2);
        this.bKp = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.common_group_rl);
        this.bKq = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group_text);
        this.bKr = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.common_group);
        this.bKs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bKp.setOnClickListener(this.bJY);
        kx();
    }

    public RelativeLayout abC() {
        return this.bKp;
    }

    public RelativeLayout abu() {
        return this.bKf;
    }

    public RelativeLayout abw() {
        return this.bKk;
    }

    public void kx() {
        bc.j(this.bKe, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKf, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKg, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKh, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKi, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKj, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKk, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKl, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKm, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKn, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKo, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKp, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKq, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKr, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bKs, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abD() {
        v abl = this.bJY.abl();
        PersonTainInfo abQ = abl.abQ();
        if (abQ == null) {
            this.bKe.setVisibility(8);
        } else if (abQ.getIsFriend() == 1) {
            this.bKe.setVisibility(8);
        } else {
            UserData userData = abl.getUserData();
            if (userData == null) {
                this.bKe.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.bKe.setVisibility(8);
                return;
            }
            if (personPrivate.uH() == 1) {
                this.bKf.setVisibility(0);
                this.bKj.setVisibility(0);
            } else {
                this.bKf.setVisibility(8);
                this.bKj.setVisibility(8);
            }
            if (personPrivate.uK() == 1) {
                this.bKk.setVisibility(0);
                this.bKj.setVisibility(0);
            } else {
                this.bKk.setVisibility(8);
                this.bKj.setVisibility(8);
            }
            if (personPrivate.uI() == 1) {
                this.bKp.setVisibility(0);
                this.bKo.setVisibility(0);
            } else {
                this.bKp.setVisibility(8);
                this.bKo.setVisibility(8);
            }
            this.bKe.setVisibility(0);
            List<CommonForum> commonForum = abQ.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.bKh.setText(M(arrayList));
            } else {
                this.bKf.setVisibility(8);
                this.bKj.setVisibility(8);
            }
            List<CommonFriend> commonFriend = abQ.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.bKm.setText(M(arrayList2));
            } else {
                this.bKk.setVisibility(8);
                this.bKj.setVisibility(8);
            }
            List<CommonGroup> commonGroup = abQ.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.bKr.setText(M(arrayList3));
            } else {
                this.bKp.setVisibility(8);
                this.bKo.setVisibility(8);
            }
            if (this.bKf.getVisibility() == 8 && this.bKk.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKe.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKe.setLayoutParams(layoutParams);
            }
        }
    }

    public String M(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.m.f(arrayList.get(0), 0, 10)) + this.bJY.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.m.f(arrayList.get(1), 0, 10) + this.bJY.getPageContext().getString(com.baidu.tieba.z.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.m.f(arrayList.get(0), 0, 15)) + this.bJY.getPageContext().getString(com.baidu.tieba.z.comma) + com.baidu.tbadk.util.m.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

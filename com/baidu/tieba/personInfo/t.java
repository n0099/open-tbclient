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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private int arr = -1;
    private PersonInfoActivity ckP;
    private View cmY;
    private RelativeLayout cmZ;
    private TextView cna;
    private TextView cnb;
    private ImageView cnc;
    private View cnd;
    private RelativeLayout cne;
    private TextView cnf;
    private TextView cng;
    private ImageView cnh;
    private View cni;
    private RelativeLayout cnj;
    private TextView cnk;
    private TextView cnl;
    private ImageView cnm;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_common, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cmY = this.mRootView.findViewById(i.f.root_next);
        this.cmZ = (RelativeLayout) this.mRootView.findViewById(i.f.common_like_rl);
        this.cna = (TextView) this.mRootView.findViewById(i.f.common_like_text);
        this.cnb = (TextView) this.mRootView.findViewById(i.f.common_like_bar);
        this.cnc = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.cmZ.setOnClickListener(this.ckP);
        this.cnd = this.mRootView.findViewById(i.f.line1);
        this.cne = (RelativeLayout) this.mRootView.findViewById(i.f.common_friend_rl);
        this.cnf = (TextView) this.mRootView.findViewById(i.f.common_friend_text);
        this.cng = (TextView) this.mRootView.findViewById(i.f.common_friend);
        this.cnh = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cne.setOnClickListener(this.ckP);
        this.cni = this.mRootView.findViewById(i.f.line2);
        this.cnj = (RelativeLayout) this.mRootView.findViewById(i.f.common_group_rl);
        this.cnk = (TextView) this.mRootView.findViewById(i.f.common_group_text);
        this.cnl = (TextView) this.mRootView.findViewById(i.f.common_group);
        this.cnm = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cnj.setOnClickListener(this.ckP);
        oN();
    }

    public RelativeLayout ahz() {
        return this.cnj;
    }

    public RelativeLayout ahp() {
        return this.cmZ;
    }

    public RelativeLayout ahs() {
        return this.cne;
    }

    public void oN() {
        if (this.arr != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arr = TbadkCoreApplication.m411getInst().getSkinType();
            al.i(this.cmY, i.c.cp_bg_line_d);
            al.h(this.cmZ, i.e.personinfo_select_bg);
            al.b(this.cna, i.c.cp_cont_d, 1);
            al.b(this.cnb, i.c.cp_cont_b, 1);
            al.h(this.cnc, i.e.icon_dredge_arrow_r_n);
            al.i(this.cnd, i.c.cp_bg_line_b);
            al.h(this.cne, i.e.personinfo_select_bg);
            al.b(this.cnf, i.c.cp_cont_d, 1);
            al.b(this.cng, i.c.cp_cont_b, 1);
            al.h(this.cnh, i.e.icon_dredge_arrow_r_n);
            al.i(this.cni, i.c.cp_bg_line_b);
            al.h(this.cnj, i.e.personinfo_select_bg);
            al.b(this.cnk, i.c.cp_cont_d, 1);
            al.b(this.cnl, i.c.cp_cont_b, 1);
            al.h(this.cnm, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahA() {
        oN();
        w ahd = this.ckP.ahd();
        PersonTainInfo ahM = ahd.ahM();
        if (ahM == null) {
            this.cmY.setVisibility(8);
        } else if (ahM.getIsFriend() == 1) {
            this.cmY.setVisibility(8);
        } else {
            UserData userData = ahd.getUserData();
            if (userData == null) {
                this.cmY.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.cmY.setVisibility(8);
                return;
            }
            if (personPrivate.Ao() == 1) {
                this.cmZ.setVisibility(0);
                this.cnd.setVisibility(0);
            } else {
                this.cmZ.setVisibility(8);
                this.cnd.setVisibility(8);
            }
            if (personPrivate.Ar() == 1) {
                this.cne.setVisibility(0);
                this.cnd.setVisibility(0);
            } else {
                this.cne.setVisibility(8);
                this.cnd.setVisibility(8);
            }
            int Ap = personPrivate.Ap();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (Ap == 1 && appResponseToIntentClass) {
                this.cnj.setVisibility(0);
                this.cni.setVisibility(0);
            } else {
                this.cnj.setVisibility(8);
                this.cni.setVisibility(8);
            }
            this.cmY.setVisibility(0);
            List<CommonForum> commonForum = ahM.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.cnb.setText(T(arrayList));
            } else {
                this.cmZ.setVisibility(8);
                this.cnd.setVisibility(8);
            }
            List<CommonFriend> commonFriend = ahM.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.cng.setText(T(arrayList2));
            } else {
                this.cne.setVisibility(8);
                this.cnd.setVisibility(8);
            }
            List<CommonGroup> commonGroup = ahM.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.cnl.setText(T(arrayList3));
            } else {
                this.cnj.setVisibility(8);
                this.cni.setVisibility(8);
            }
            if (this.cmZ.getVisibility() == 8 && this.cne.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmY.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cmY.setLayoutParams(layoutParams);
            }
        }
    }

    public String T(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.k.f(arrayList.get(0), 0, 10)) + this.ckP.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.k.f(arrayList.get(1), 0, 10) + this.ckP.getPageContext().getString(i.h.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.k.f(arrayList.get(0), 0, 15)) + this.ckP.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.k.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

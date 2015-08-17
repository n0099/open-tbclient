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
    private int apH = -1;
    private PersonInfoActivity cjU;
    private View clV;
    private RelativeLayout clW;
    private TextView clX;
    private TextView clY;
    private ImageView clZ;
    private View cma;
    private RelativeLayout cmb;
    private TextView cmc;
    private TextView cme;
    private ImageView cmf;
    private View cmg;
    private RelativeLayout cmh;
    private TextView cmi;
    private TextView cmj;
    private ImageView cmk;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_common, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.clV = this.mRootView.findViewById(i.f.root_next);
        this.clW = (RelativeLayout) this.mRootView.findViewById(i.f.common_like_rl);
        this.clX = (TextView) this.mRootView.findViewById(i.f.common_like_text);
        this.clY = (TextView) this.mRootView.findViewById(i.f.common_like_bar);
        this.clZ = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.clW.setOnClickListener(this.cjU);
        this.cma = this.mRootView.findViewById(i.f.line1);
        this.cmb = (RelativeLayout) this.mRootView.findViewById(i.f.common_friend_rl);
        this.cmc = (TextView) this.mRootView.findViewById(i.f.common_friend_text);
        this.cme = (TextView) this.mRootView.findViewById(i.f.common_friend);
        this.cmf = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cmb.setOnClickListener(this.cjU);
        this.cmg = this.mRootView.findViewById(i.f.line2);
        this.cmh = (RelativeLayout) this.mRootView.findViewById(i.f.common_group_rl);
        this.cmi = (TextView) this.mRootView.findViewById(i.f.common_group_text);
        this.cmj = (TextView) this.mRootView.findViewById(i.f.common_group);
        this.cmk = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cmh.setOnClickListener(this.cjU);
        oQ();
    }

    public RelativeLayout ahh() {
        return this.cmh;
    }

    public RelativeLayout agX() {
        return this.clW;
    }

    public RelativeLayout aha() {
        return this.cmb;
    }

    public void oQ() {
        if (this.apH != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apH = TbadkCoreApplication.m411getInst().getSkinType();
            al.j(this.clV, i.c.cp_bg_line_d);
            al.i(this.clW, i.e.personinfo_select_bg);
            al.b(this.clX, i.c.cp_cont_d, 1);
            al.b(this.clY, i.c.cp_cont_b, 1);
            al.i(this.clZ, i.e.icon_dredge_arrow_r_n);
            al.j(this.cma, i.c.cp_bg_line_b);
            al.i(this.cmb, i.e.personinfo_select_bg);
            al.b(this.cmc, i.c.cp_cont_d, 1);
            al.b(this.cme, i.c.cp_cont_b, 1);
            al.i(this.cmf, i.e.icon_dredge_arrow_r_n);
            al.j(this.cmg, i.c.cp_bg_line_b);
            al.i(this.cmh, i.e.personinfo_select_bg);
            al.b(this.cmi, i.c.cp_cont_d, 1);
            al.b(this.cmj, i.c.cp_cont_b, 1);
            al.i(this.cmk, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahi() {
        oQ();
        w agL = this.cjU.agL();
        PersonTainInfo ahu = agL.ahu();
        if (ahu == null) {
            this.clV.setVisibility(8);
        } else if (ahu.getIsFriend() == 1) {
            this.clV.setVisibility(8);
        } else {
            UserData userData = agL.getUserData();
            if (userData == null) {
                this.clV.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.clV.setVisibility(8);
                return;
            }
            if (personPrivate.Ab() == 1) {
                this.clW.setVisibility(0);
                this.cma.setVisibility(0);
            } else {
                this.clW.setVisibility(8);
                this.cma.setVisibility(8);
            }
            if (personPrivate.Ae() == 1) {
                this.cmb.setVisibility(0);
                this.cma.setVisibility(0);
            } else {
                this.cmb.setVisibility(8);
                this.cma.setVisibility(8);
            }
            int Ac = personPrivate.Ac();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (Ac == 1 && appResponseToIntentClass) {
                this.cmh.setVisibility(0);
                this.cmg.setVisibility(0);
            } else {
                this.cmh.setVisibility(8);
                this.cmg.setVisibility(8);
            }
            this.clV.setVisibility(0);
            List<CommonForum> commonForum = ahu.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.clY.setText(T(arrayList));
            } else {
                this.clW.setVisibility(8);
                this.cma.setVisibility(8);
            }
            List<CommonFriend> commonFriend = ahu.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.cme.setText(T(arrayList2));
            } else {
                this.cmb.setVisibility(8);
                this.cma.setVisibility(8);
            }
            List<CommonGroup> commonGroup = ahu.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.cmj.setText(T(arrayList3));
            } else {
                this.cmh.setVisibility(8);
                this.cmg.setVisibility(8);
            }
            if (this.clW.getVisibility() == 8 && this.cmb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clV.getLayoutParams();
                layoutParams.topMargin = 0;
                this.clV.setLayoutParams(layoutParams);
            }
        }
    }

    public String T(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.k.f(arrayList.get(0), 0, 10)) + this.cjU.getPageContext().getString(i.C0057i.comma) + com.baidu.tbadk.util.k.f(arrayList.get(1), 0, 10) + this.cjU.getPageContext().getString(i.C0057i.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.k.f(arrayList.get(0), 0, 15)) + this.cjU.getPageContext().getString(i.C0057i.comma) + com.baidu.tbadk.util.k.f(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

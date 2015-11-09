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
    private int arf = -1;
    private PersonInfoActivity csa;
    private View cul;
    private RelativeLayout cum;
    private TextView cun;
    private TextView cuo;
    private ImageView cup;
    private View cuq;
    private RelativeLayout cur;
    private TextView cus;
    private TextView cut;
    private ImageView cuu;
    private View cuv;
    private RelativeLayout cuw;
    private TextView cux;
    private TextView cuy;
    private ImageView cuz;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_common, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cul = this.mRootView.findViewById(i.f.root_next);
        this.cum = (RelativeLayout) this.mRootView.findViewById(i.f.common_like_rl);
        this.cun = (TextView) this.mRootView.findViewById(i.f.common_like_text);
        this.cuo = (TextView) this.mRootView.findViewById(i.f.common_like_bar);
        this.cup = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.cum.setOnClickListener(this.csa);
        this.cuq = this.mRootView.findViewById(i.f.line1);
        this.cur = (RelativeLayout) this.mRootView.findViewById(i.f.common_friend_rl);
        this.cus = (TextView) this.mRootView.findViewById(i.f.common_friend_text);
        this.cut = (TextView) this.mRootView.findViewById(i.f.common_friend);
        this.cuu = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cur.setOnClickListener(this.csa);
        this.cuv = this.mRootView.findViewById(i.f.line2);
        this.cuw = (RelativeLayout) this.mRootView.findViewById(i.f.common_group_rl);
        this.cux = (TextView) this.mRootView.findViewById(i.f.common_group_text);
        this.cuy = (TextView) this.mRootView.findViewById(i.f.common_group);
        this.cuz = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cuw.setOnClickListener(this.csa);
        oP();
    }

    public RelativeLayout akd() {
        return this.cuw;
    }

    public RelativeLayout ajT() {
        return this.cum;
    }

    public RelativeLayout ajW() {
        return this.cur;
    }

    public void oP() {
        if (this.arf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.cul, i.c.cp_bg_line_d);
            an.i(this.cum, i.e.personinfo_select_bg);
            an.b(this.cun, i.c.cp_cont_d, 1);
            an.b(this.cuo, i.c.cp_cont_b, 1);
            an.i(this.cup, i.e.icon_dredge_arrow_r_n);
            an.j(this.cuq, i.c.cp_bg_line_b);
            an.i(this.cur, i.e.personinfo_select_bg);
            an.b(this.cus, i.c.cp_cont_d, 1);
            an.b(this.cut, i.c.cp_cont_b, 1);
            an.i(this.cuu, i.e.icon_dredge_arrow_r_n);
            an.j(this.cuv, i.c.cp_bg_line_b);
            an.i(this.cuw, i.e.personinfo_select_bg);
            an.b(this.cux, i.c.cp_cont_d, 1);
            an.b(this.cuy, i.c.cp_cont_b, 1);
            an.i(this.cuz, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ake() {
        oP();
        y ajH = this.csa.ajH();
        PersonTainInfo akp = ajH.akp();
        if (akp == null) {
            this.cul.setVisibility(8);
        } else if (akp.getIsFriend() == 1) {
            this.cul.setVisibility(8);
        } else {
            UserData userData = ajH.getUserData();
            if (userData == null) {
                this.cul.setVisibility(8);
                return;
            }
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            if (personPrivate == null) {
                this.cul.setVisibility(8);
                return;
            }
            if (personPrivate.Ab() == 1) {
                this.cum.setVisibility(0);
                this.cuq.setVisibility(0);
            } else {
                this.cum.setVisibility(8);
                this.cuq.setVisibility(8);
            }
            if (personPrivate.Ae() == 1) {
                this.cur.setVisibility(0);
                this.cuq.setVisibility(0);
            } else {
                this.cur.setVisibility(8);
                this.cuq.setVisibility(8);
            }
            int Ac = personPrivate.Ac();
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
            if (Ac == 1 && appResponseToIntentClass) {
                this.cuw.setVisibility(0);
                this.cuv.setVisibility(0);
            } else {
                this.cuw.setVisibility(8);
                this.cuv.setVisibility(8);
            }
            this.cul.setVisibility(0);
            List<CommonForum> commonForum = akp.getCommonForum();
            if (commonForum != null && commonForum.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < commonForum.size(); i++) {
                    if (commonForum.get(i) != null && !TextUtils.isEmpty(commonForum.get(i).getForumName())) {
                        arrayList.add(commonForum.get(i).getForumName());
                    }
                }
                this.cuo.setText(U(arrayList));
            } else {
                this.cum.setVisibility(8);
                this.cuq.setVisibility(8);
            }
            List<CommonFriend> commonFriend = akp.getCommonFriend();
            if (commonFriend != null && commonFriend.size() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < commonFriend.size(); i2++) {
                    if (commonFriend.get(i2) != null && !TextUtils.isEmpty(commonFriend.get(i2).getCommonFriend())) {
                        arrayList2.add(commonFriend.get(i2).getCommonFriend());
                    }
                }
                this.cut.setText(U(arrayList2));
            } else {
                this.cur.setVisibility(8);
                this.cuq.setVisibility(8);
            }
            List<CommonGroup> commonGroup = akp.getCommonGroup();
            if (commonGroup != null && commonGroup.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < commonGroup.size(); i3++) {
                    if (commonGroup.get(i3) != null && !TextUtils.isEmpty(commonGroup.get(i3).getCommonGroup())) {
                        arrayList3.add(commonGroup.get(i3).getCommonGroup());
                    }
                }
                this.cuy.setText(U(arrayList3));
            } else {
                this.cuw.setVisibility(8);
                this.cuv.setVisibility(8);
            }
            if (this.cum.getVisibility() == 8 && this.cur.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cul.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cul.setLayoutParams(layoutParams);
            }
        }
    }

    public String U(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 10)) + this.csa.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 10) + this.csa.getPageContext().getString(i.h.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(com.baidu.tbadk.util.n.e(arrayList.get(0), 0, 15)) + this.csa.getPageContext().getString(i.h.comma) + com.baidu.tbadk.util.n.e(arrayList.get(1), 0, 15);
        }
        return arrayList.get(0);
    }

    public View getRootView() {
        return this.mRootView;
    }
}

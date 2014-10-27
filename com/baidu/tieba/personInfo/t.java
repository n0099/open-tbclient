package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private View HS;
    private PersonInfoActivity bEE;
    private View bEK;
    private ImageView bEO;
    private ImageView bEY;
    private TextView bFA;
    private TextView bFB;
    private TextView bFC;
    private TextView bFD;
    private TextView bFE;
    private TextView bFF;
    private RelativeLayout bFs;
    private TextView bFt;
    private TextView bFu;
    private LinearLayout bFv;
    private TextView bFw;
    private RelativeLayout bFx;
    private LinearLayout bFy;
    private TextView bFz;
    private View bhZ;
    private boolean mIsHost;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_group_view, null);
        nu();
    }

    private void nu() {
        this.bEK = this.HS.findViewById(com.baidu.tieba.v.root_next);
        this.bFs = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.group_ll);
        this.bFs.setOnClickListener(this.bEE);
        this.bFt = (TextView) this.HS.findViewById(com.baidu.tieba.v.group_num);
        this.bFu = (TextView) this.HS.findViewById(com.baidu.tieba.v.group_num_text);
        this.bFv = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.group_info_ll);
        this.bFw = (TextView) this.HS.findViewById(com.baidu.tieba.v.no_group_tip);
        this.bEO = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_top);
        this.bhZ = this.HS.findViewById(com.baidu.tieba.v.line);
        this.bFx = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.bar_ll);
        this.bFx.setOnClickListener(this.bEE);
        this.bFz = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_num);
        this.bFA = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_num_text);
        this.bFy = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.bar_info_ll);
        this.bFB = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_name_1);
        this.bFC = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_name_2);
        this.bFD = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_name_3);
        this.bFE = (TextView) this.HS.findViewById(com.baidu.tieba.v.bar_name_4);
        this.bFF = (TextView) this.HS.findViewById(com.baidu.tieba.v.no_bar_tip);
        this.bEY = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_bottom);
        pS();
    }

    public void pS() {
        aw.i(this.bEK, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bFs, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFt, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFu, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFw, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bEO, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bhZ, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFx, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFz, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFA, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFB, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFC, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFD, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFE, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFF, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bEY, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void Hu() {
        v aap = this.bEE.aap();
        UserData userData = aap.getUserData();
        PersonTainInfo aaS = aap.aaS();
        c(aaS, userData);
        a(aaS, userData);
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            int qT = personPrivate != null ? personPrivate.qT() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (qT == 1 || (qT == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFu.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bFu.setLayoutParams(layoutParams);
                this.bFt.setText("");
                this.bFt.setTextSize(0.0f);
                aw.h((View) this.bFt, com.baidu.tieba.u.icon_mycenter_lock);
                this.bFv.setVisibility(8);
                this.bFw.setVisibility(0);
                this.bFw.setText(com.baidu.tieba.y.set_private);
                this.bEO.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String bB = ay.bB(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bFt.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (bB.contains("w") && bB.length() > 3) {
                this.bFt.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFt.setBackgroundDrawable(null);
            this.bFt.setText(bB);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFu.getLayoutParams();
            layoutParams.topMargin = -this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bFu.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bFv.setVisibility(8);
                this.bEO.setVisibility(8);
                this.bFw.setVisibility(0);
                this.bFw.setText(com.baidu.tieba.y.no_group_tip);
                return;
            }
            this.bFv.removeAllViews();
            this.bFv.setVisibility(0);
            this.bEO.setVisibility(0);
            this.bFw.setVisibility(8);
            com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = ek.inflate(this.bEE, com.baidu.tieba.w.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.v.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
                    this.bFv.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            int qS = personPrivate != null ? personPrivate.qS() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                f(userData);
            } else if (qS == 1 || (qS == 2 && isFriend == 1)) {
                f(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFA.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bFA.setLayoutParams(layoutParams);
                this.bFz.setText("");
                this.bFz.setTextSize(0.0f);
                aw.h((View) this.bFz, com.baidu.tieba.u.icon_mycenter_lock);
                this.bFy.setVisibility(8);
                this.bFF.setVisibility(0);
                this.bFF.setText(com.baidu.tieba.y.set_private);
                this.bEY.setVisibility(8);
            }
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            String bB = ay.bB(userData.getLike_bars());
            this.bFz.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (bB.contains("w") && bB.length() > 3) {
                this.bFz.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFz.setBackgroundDrawable(null);
            this.bFz.setText(bB);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFA.getLayoutParams();
            layoutParams.topMargin = -this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bFA.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bFy.setVisibility(8);
                this.bFF.setVisibility(0);
                this.bFF.setText(com.baidu.tieba.y.no_attention_bar);
                this.bEY.setVisibility(8);
                return;
            }
            this.bFy.setVisibility(0);
            this.bFF.setVisibility(8);
            this.bEY.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < likeForum.size(); i++) {
                if (!TextUtils.isEmpty(likeForum.get(i).getForumName())) {
                    arrayList.add(likeForum.get(i).getForumName());
                }
            }
            int size = arrayList.size();
            if (size > 4) {
                size = 4;
            }
            switch (size) {
                case 1:
                    this.bFB.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bFB.setText((CharSequence) arrayList.get(0));
                    this.bFC.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bFB.setText((CharSequence) arrayList.get(0));
                    this.bFC.setText((CharSequence) arrayList.get(1));
                    this.bFD.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bFB.setText((CharSequence) arrayList.get(0));
                    this.bFC.setText((CharSequence) arrayList.get(1));
                    this.bFD.setText((CharSequence) arrayList.get(2));
                    this.bFE.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout aaD() {
        return this.bFs;
    }

    public RelativeLayout aay() {
        return this.bFx;
    }

    public View getRootView() {
        return this.HS;
    }
}

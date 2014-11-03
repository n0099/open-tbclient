package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private View HT;
    private PersonInfoActivity bES;
    private View bEY;
    private RelativeLayout bFG;
    private TextView bFH;
    private TextView bFI;
    private LinearLayout bFJ;
    private TextView bFK;
    private RelativeLayout bFL;
    private LinearLayout bFM;
    private TextView bFN;
    private TextView bFO;
    private TextView bFP;
    private TextView bFQ;
    private TextView bFR;
    private TextView bFS;
    private TextView bFT;
    private ImageView bFc;
    private ImageView bFm;
    private View bip;
    private boolean mIsHost;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_group_view, null);
        nu();
    }

    private void nu() {
        this.bEY = this.HT.findViewById(com.baidu.tieba.v.root_next);
        this.bFG = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.group_ll);
        this.bFG.setOnClickListener(this.bES);
        this.bFH = (TextView) this.HT.findViewById(com.baidu.tieba.v.group_num);
        this.bFI = (TextView) this.HT.findViewById(com.baidu.tieba.v.group_num_text);
        this.bFJ = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.group_info_ll);
        this.bFK = (TextView) this.HT.findViewById(com.baidu.tieba.v.no_group_tip);
        this.bFc = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_top);
        this.bip = this.HT.findViewById(com.baidu.tieba.v.line);
        this.bFL = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.bar_ll);
        this.bFL.setOnClickListener(this.bES);
        this.bFN = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_num);
        this.bFO = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_num_text);
        this.bFM = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.bar_info_ll);
        this.bFP = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_name_1);
        this.bFQ = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_name_2);
        this.bFR = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_name_3);
        this.bFS = (TextView) this.HT.findViewById(com.baidu.tieba.v.bar_name_4);
        this.bFT = (TextView) this.HT.findViewById(com.baidu.tieba.v.no_bar_tip);
        this.bFm = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_bottom);
        pU();
    }

    public void pU() {
        aw.i(this.bEY, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bFG, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFH, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFI, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFK, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bFc, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bip, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFL, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFN, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFO, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFP, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFQ, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFR, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFS, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bFT, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bFm, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void aaJ() {
        v aar = this.bES.aar();
        UserData userData = aar.getUserData();
        PersonTainInfo aaV = aar.aaV();
        c(aaV, userData);
        a(aaV, userData);
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            int qV = personPrivate != null ? personPrivate.qV() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (qV == 1 || (qV == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFI.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bFI.setLayoutParams(layoutParams);
                this.bFH.setText("");
                this.bFH.setTextSize(0.0f);
                aw.h((View) this.bFH, com.baidu.tieba.u.icon_mycenter_lock);
                this.bFJ.setVisibility(8);
                this.bFK.setVisibility(0);
                this.bFK.setText(com.baidu.tieba.y.set_private);
                this.bFc.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String bB = az.bB(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bFH.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (bB.contains("w") && bB.length() > 3) {
                this.bFH.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFH.setBackgroundDrawable(null);
            this.bFH.setText(bB);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFI.getLayoutParams();
            layoutParams.topMargin = -this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bFI.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bFJ.setVisibility(8);
                this.bFc.setVisibility(8);
                this.bFK.setVisibility(0);
                this.bFK.setText(com.baidu.tieba.y.no_group_tip);
                return;
            }
            this.bFJ.removeAllViews();
            this.bFJ.setVisibility(0);
            this.bFc.setVisibility(0);
            this.bFK.setVisibility(8);
            com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = ek.inflate(this.bES, com.baidu.tieba.w.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.v.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
                    this.bFJ.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            int qU = personPrivate != null ? personPrivate.qU() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                f(userData);
            } else if (qU == 1 || (qU == 2 && isFriend == 1)) {
                f(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFO.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bFO.setLayoutParams(layoutParams);
                this.bFN.setText("");
                this.bFN.setTextSize(0.0f);
                aw.h((View) this.bFN, com.baidu.tieba.u.icon_mycenter_lock);
                this.bFM.setVisibility(8);
                this.bFT.setVisibility(0);
                this.bFT.setText(com.baidu.tieba.y.set_private);
                this.bFm.setVisibility(8);
            }
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            String bB = az.bB(userData.getLike_bars());
            this.bFN.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (bB.contains("w") && bB.length() > 3) {
                this.bFN.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFN.setBackgroundDrawable(null);
            this.bFN.setText(bB);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFO.getLayoutParams();
            layoutParams.topMargin = -this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bFO.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bFM.setVisibility(8);
                this.bFT.setVisibility(0);
                this.bFT.setText(com.baidu.tieba.y.no_attention_bar);
                this.bFm.setVisibility(8);
                return;
            }
            this.bFM.setVisibility(0);
            this.bFT.setVisibility(8);
            this.bFm.setVisibility(0);
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
                    this.bFP.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bFP.setText((CharSequence) arrayList.get(0));
                    this.bFQ.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bFP.setText((CharSequence) arrayList.get(0));
                    this.bFQ.setText((CharSequence) arrayList.get(1));
                    this.bFR.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bFP.setText((CharSequence) arrayList.get(0));
                    this.bFQ.setText((CharSequence) arrayList.get(1));
                    this.bFR.setText((CharSequence) arrayList.get(2));
                    this.bFS.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout aaF() {
        return this.bFG;
    }

    public RelativeLayout aaA() {
        return this.bFL;
    }

    public View getRootView() {
        return this.HT;
    }
}

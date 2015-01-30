package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private PersonInfoActivity bJZ;
    private RelativeLayout bKN;
    private TextView bKO;
    private TextView bKP;
    private LinearLayout bKQ;
    private TextView bKR;
    private RelativeLayout bKS;
    private LinearLayout bKT;
    private TextView bKU;
    private TextView bKV;
    private TextView bKW;
    private TextView bKX;
    private TextView bKY;
    private TextView bKZ;
    private View bKf;
    private ImageView bKj;
    private ImageView bKt;
    private TextView bLa;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bKf = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKN = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_ll);
        this.bKN.setOnClickListener(this.bJZ);
        this.bKO = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num);
        this.bKP = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num_text);
        this.bKQ = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_info_ll);
        this.bKR = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_group_tip);
        this.bKj = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.w.line);
        this.bKS = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_ll);
        this.bKS.setOnClickListener(this.bJZ);
        this.bKU = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num);
        this.bKV = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num_text);
        this.bKT = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_info_ll);
        this.bKW = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_1);
        this.bKX = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_2);
        this.bKY = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_3);
        this.bKZ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_4);
        this.bLa = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_bar_tip);
        this.bKt = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        kE();
    }

    public void kE() {
        bc.j(this.bKf, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKN, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKO, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKP, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKR, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKj, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKS, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKU, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKV, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKW, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKX, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKY, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKZ, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bLa, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKt, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abI() {
        v abq = this.bJZ.abq();
        UserData userData = abq.getUserData();
        PersonTainInfo abV = abq.abV();
        c(abV, userData);
        a(abV, userData);
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int uO = personPrivate != null ? personPrivate.uO() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                b(personTainInfo, userData);
                return;
            }
            if (uO == 1 || (uO == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKP.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKP.setLayoutParams(layoutParams);
                this.bKO.setText("");
                this.bKO.setTextSize(0.0f);
                bc.i((View) this.bKO, com.baidu.tieba.v.icon_mycenter_lock);
                this.bKQ.setVisibility(8);
                this.bKR.setVisibility(0);
                this.bKR.setText(com.baidu.tieba.z.set_private);
                this.bKj.setVisibility(8);
            }
            if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bKN.setVisibility(8);
            } else {
                this.bKN.setVisibility(0);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cf = bf.cf(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bKO.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (cf.contains("w") && cf.length() > 3) {
                this.bKO.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKO.setBackgroundDrawable(null);
            this.bKO.setText(cf);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKP.getLayoutParams();
            layoutParams.topMargin = -this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bKP.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bKQ.setVisibility(8);
                this.bKj.setVisibility(8);
                this.bKR.setVisibility(0);
                this.bKR.setText(com.baidu.tieba.z.no_group_tip);
                return;
            }
            this.bKQ.removeAllViews();
            this.bKQ.setVisibility(0);
            this.bKj.setVisibility(0);
            this.bKR.setVisibility(8);
            com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = ei.inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.w.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
                    this.bKQ.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int uN = personPrivate != null ? personPrivate.uN() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                i(userData);
            } else if (uN == 1 || (uN == 2 && isFriend == 1)) {
                i(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKV.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKV.setLayoutParams(layoutParams);
                this.bKU.setText("");
                this.bKU.setTextSize(0.0f);
                bc.i((View) this.bKU, com.baidu.tieba.v.icon_mycenter_lock);
                this.bKT.setVisibility(8);
                this.bLa.setVisibility(0);
                this.bLa.setText(com.baidu.tieba.z.set_private);
                this.bKt.setVisibility(8);
            }
        }
    }

    public void i(UserData userData) {
        if (userData != null) {
            String cf = bf.cf(userData.getLike_bars());
            this.bKU.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (cf.contains("w") && cf.length() > 3) {
                this.bKU.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKU.setBackgroundDrawable(null);
            this.bKU.setText(cf);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKV.getLayoutParams();
            layoutParams.topMargin = -this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bKV.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bKT.setVisibility(8);
                this.bLa.setVisibility(0);
                this.bLa.setText(com.baidu.tieba.z.no_attention_bar);
                this.bKt.setVisibility(8);
                return;
            }
            this.bKT.setVisibility(0);
            this.bLa.setVisibility(8);
            this.bKt.setVisibility(0);
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
                    this.bKW.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bKW.setText((CharSequence) arrayList.get(0));
                    this.bKX.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bKW.setText((CharSequence) arrayList.get(0));
                    this.bKX.setText((CharSequence) arrayList.get(1));
                    this.bKY.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bKW.setText((CharSequence) arrayList.get(0));
                    this.bKX.setText((CharSequence) arrayList.get(1));
                    this.bKY.setText((CharSequence) arrayList.get(2));
                    this.bKZ.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout abE() {
        return this.bKN;
    }

    public RelativeLayout abz() {
        return this.bKS;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

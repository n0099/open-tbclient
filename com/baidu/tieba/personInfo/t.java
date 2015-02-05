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
    private PersonInfoActivity bJY;
    private RelativeLayout bKM;
    private TextView bKN;
    private TextView bKO;
    private LinearLayout bKP;
    private TextView bKQ;
    private RelativeLayout bKR;
    private LinearLayout bKS;
    private TextView bKT;
    private TextView bKU;
    private TextView bKV;
    private TextView bKW;
    private TextView bKX;
    private TextView bKY;
    private TextView bKZ;
    private View bKe;
    private ImageView bKi;
    private ImageView bKs;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bKe = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKM = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_ll);
        this.bKM.setOnClickListener(this.bJY);
        this.bKN = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num);
        this.bKO = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num_text);
        this.bKP = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_info_ll);
        this.bKQ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_group_tip);
        this.bKi = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.w.line);
        this.bKR = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_ll);
        this.bKR.setOnClickListener(this.bJY);
        this.bKT = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num);
        this.bKU = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num_text);
        this.bKS = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_info_ll);
        this.bKV = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_1);
        this.bKW = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_2);
        this.bKX = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_3);
        this.bKY = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_4);
        this.bKZ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_bar_tip);
        this.bKs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        kx();
    }

    public void kx() {
        bc.j(this.bKe, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKM, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKN, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKO, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKQ, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKi, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKR, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKT, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKU, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKV, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKW, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKX, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKY, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bKZ, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKs, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abD() {
        v abl = this.bJY.abl();
        UserData userData = abl.getUserData();
        PersonTainInfo abQ = abl.abQ();
        c(abQ, userData);
        a(abQ, userData);
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int uI = personPrivate != null ? personPrivate.uI() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                b(personTainInfo, userData);
                return;
            }
            if (uI == 1 || (uI == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKO.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKO.setLayoutParams(layoutParams);
                this.bKN.setText("");
                this.bKN.setTextSize(0.0f);
                bc.i((View) this.bKN, com.baidu.tieba.v.icon_mycenter_lock);
                this.bKP.setVisibility(8);
                this.bKQ.setVisibility(0);
                this.bKQ.setText(com.baidu.tieba.z.set_private);
                this.bKi.setVisibility(8);
            }
            if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bKM.setVisibility(8);
            } else {
                this.bKM.setVisibility(0);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cf = bf.cf(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bKN.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (cf.contains("w") && cf.length() > 3) {
                this.bKN.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKN.setBackgroundDrawable(null);
            this.bKN.setText(cf);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKO.getLayoutParams();
            layoutParams.topMargin = -this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bKO.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bKP.setVisibility(8);
                this.bKi.setVisibility(8);
                this.bKQ.setVisibility(0);
                this.bKQ.setText(com.baidu.tieba.z.no_group_tip);
                return;
            }
            this.bKP.removeAllViews();
            this.bKP.setVisibility(0);
            this.bKi.setVisibility(0);
            this.bKQ.setVisibility(8);
            com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = ei.inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.w.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
                    this.bKP.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int uH = personPrivate != null ? personPrivate.uH() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                i(userData);
            } else if (uH == 1 || (uH == 2 && isFriend == 1)) {
                i(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKU.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bKU.setLayoutParams(layoutParams);
                this.bKT.setText("");
                this.bKT.setTextSize(0.0f);
                bc.i((View) this.bKT, com.baidu.tieba.v.icon_mycenter_lock);
                this.bKS.setVisibility(8);
                this.bKZ.setVisibility(0);
                this.bKZ.setText(com.baidu.tieba.z.set_private);
                this.bKs.setVisibility(8);
            }
        }
    }

    public void i(UserData userData) {
        if (userData != null) {
            String cf = bf.cf(userData.getLike_bars());
            this.bKT.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (cf.contains("w") && cf.length() > 3) {
                this.bKT.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKT.setBackgroundDrawable(null);
            this.bKT.setText(cf);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKU.getLayoutParams();
            layoutParams.topMargin = -this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bKU.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bKS.setVisibility(8);
                this.bKZ.setVisibility(0);
                this.bKZ.setText(com.baidu.tieba.z.no_attention_bar);
                this.bKs.setVisibility(8);
                return;
            }
            this.bKS.setVisibility(0);
            this.bKZ.setVisibility(8);
            this.bKs.setVisibility(0);
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
                    this.bKV.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bKV.setText((CharSequence) arrayList.get(0));
                    this.bKW.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bKV.setText((CharSequence) arrayList.get(0));
                    this.bKW.setText((CharSequence) arrayList.get(1));
                    this.bKX.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bKV.setText((CharSequence) arrayList.get(0));
                    this.bKW.setText((CharSequence) arrayList.get(1));
                    this.bKX.setText((CharSequence) arrayList.get(2));
                    this.bKY.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout abz() {
        return this.bKM;
    }

    public RelativeLayout abu() {
        return this.bKR;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private int ajy = -1;
    private ImageView bVA;
    private RelativeLayout bVU;
    private TextView bVV;
    private TextView bVW;
    private LinearLayout bVX;
    private TextView bVY;
    private RelativeLayout bVZ;
    private PersonInfoActivity bVg;
    private View bVm;
    private ImageView bVq;
    private LinearLayout bWa;
    private TextView bWb;
    private TextView bWc;
    private TextView bWd;
    private TextView bWe;
    private TextView bWf;
    private TextView bWg;
    private TextView bWh;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bVm = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVU = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.group_ll);
        this.bVU.setOnClickListener(this.bVg);
        this.bVV = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.group_num);
        this.bVW = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.group_num_text);
        this.bVX = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.group_info_ll);
        this.bVY = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_group_tip);
        this.bVq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.q.line);
        this.bVZ = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.bar_ll);
        this.bVZ.setOnClickListener(this.bVg);
        this.bWb = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_num);
        this.bWc = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_num_text);
        this.bWa = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.bar_info_ll);
        this.bWd = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_1);
        this.bWe = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_2);
        this.bWf = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_3);
        this.bWg = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_4);
        this.bWh = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_bar_tip);
        this.bVA = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        oG();
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVm, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVU, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVV, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bVW, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVY, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVq, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.line, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVZ, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bWb, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bWc, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bWd, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWe, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWf, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWg, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWh, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVA, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afm() {
        v aeU = this.bVg.aeU();
        UserData userData = aeU.getUserData();
        PersonTainInfo afy = aeU.afy();
        c(afy, userData);
        a(afy, userData);
        oG();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int yS = personPrivate != null ? personPrivate.yS() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bVU.setVisibility(8);
                return;
            }
            this.bVU.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (yS == 1 || (yS == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVW.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bVW.setLayoutParams(layoutParams);
                this.bVV.setText("");
                this.bVV.setTextSize(0.0f);
                this.bVV.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVX.setVisibility(8);
                this.bVY.setVisibility(0);
                this.bVY.setText(com.baidu.tieba.t.set_private);
                this.bVq.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cl = bb.cl(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bVV.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
            if (cl.contains("w") && cl.length() > 3) {
                this.bVV.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bVV.setCompoundDrawables(null, null, null, null);
            this.bVV.setText(cl);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVW.getLayoutParams();
            layoutParams.topMargin = -this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
            this.bVW.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bVX.setVisibility(8);
                this.bVq.setVisibility(8);
                this.bVY.setVisibility(0);
                this.bVY.setText(com.baidu.tieba.t.no_group_tip);
                return;
            }
            this.bVX.removeAllViews();
            this.bVX.setVisibility(0);
            this.bVq.setVisibility(0);
            this.bVY.setVisibility(8);
            com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = hr.inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.q.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds26);
                    this.bVX.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int yR = personPrivate != null ? personPrivate.yR() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                h(userData);
            } else if (yR == 1 || (yR == 2 && isFriend == 1)) {
                h(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWc.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bWc.setLayoutParams(layoutParams);
                this.bWb.setText("");
                this.bWb.setTextSize(0.0f);
                this.bWb.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bWa.setVisibility(8);
                this.bWh.setVisibility(0);
                this.bWh.setText(com.baidu.tieba.t.set_private);
                this.bVA.setVisibility(8);
            }
        }
    }

    public void h(UserData userData) {
        if (userData != null) {
            String cl = bb.cl(userData.getLike_bars());
            this.bWb.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
            if (cl.contains("w") && cl.length() > 3) {
                this.bWb.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bWb.setCompoundDrawables(null, null, null, null);
            this.bWb.setText(cl);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWc.getLayoutParams();
            layoutParams.topMargin = -this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
            this.bWc.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bWa.setVisibility(8);
                this.bWh.setVisibility(0);
                this.bWh.setText(com.baidu.tieba.t.no_attention_bar);
                this.bVA.setVisibility(8);
                return;
            }
            this.bWa.setVisibility(0);
            this.bWh.setVisibility(8);
            this.bVA.setVisibility(0);
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
                    this.bWd.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bWd.setText((CharSequence) arrayList.get(0));
                    this.bWe.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bWd.setText((CharSequence) arrayList.get(0));
                    this.bWe.setText((CharSequence) arrayList.get(1));
                    this.bWf.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bWd.setText((CharSequence) arrayList.get(0));
                    this.bWe.setText((CharSequence) arrayList.get(1));
                    this.bWf.setText((CharSequence) arrayList.get(2));
                    this.bWg.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout afi() {
        return this.bVU;
    }

    public RelativeLayout afd() {
        return this.bVZ;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

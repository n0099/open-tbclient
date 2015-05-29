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
    private RelativeLayout bVT;
    private TextView bVU;
    private TextView bVV;
    private LinearLayout bVW;
    private TextView bVX;
    private RelativeLayout bVY;
    private LinearLayout bVZ;
    private PersonInfoActivity bVf;
    private View bVl;
    private ImageView bVp;
    private ImageView bVz;
    private TextView bWa;
    private TextView bWb;
    private TextView bWc;
    private TextView bWd;
    private TextView bWe;
    private TextView bWf;
    private TextView bWg;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bVl = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVT = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.group_ll);
        this.bVT.setOnClickListener(this.bVf);
        this.bVU = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.group_num);
        this.bVV = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.group_num_text);
        this.bVW = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.group_info_ll);
        this.bVX = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_group_tip);
        this.bVp = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.q.line);
        this.bVY = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.bar_ll);
        this.bVY.setOnClickListener(this.bVf);
        this.bWa = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_num);
        this.bWb = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_num_text);
        this.bVZ = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.bar_info_ll);
        this.bWc = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_1);
        this.bWd = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_2);
        this.bWe = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_3);
        this.bWf = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.bar_name_4);
        this.bWg = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_bar_tip);
        this.bVz = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        oG();
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVl, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVT, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVU, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bVV, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVX, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVp, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.line, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVY, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bWa, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bWb, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bWc, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWd, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWe, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWf, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(this.bWg, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVz, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afl() {
        v aeT = this.bVf.aeT();
        UserData userData = aeT.getUserData();
        PersonTainInfo afx = aeT.afx();
        c(afx, userData);
        a(afx, userData);
        oG();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int yR = personPrivate != null ? personPrivate.yR() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bVT.setVisibility(8);
                return;
            }
            this.bVT.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (yR == 1 || (yR == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVV.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bVV.setLayoutParams(layoutParams);
                this.bVU.setText("");
                this.bVU.setTextSize(0.0f);
                this.bVU.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVW.setVisibility(8);
                this.bVX.setVisibility(0);
                this.bVX.setText(com.baidu.tieba.t.set_private);
                this.bVp.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cl = bb.cl(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bVU.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
            if (cl.contains("w") && cl.length() > 3) {
                this.bVU.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bVU.setCompoundDrawables(null, null, null, null);
            this.bVU.setText(cl);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVV.getLayoutParams();
            layoutParams.topMargin = -this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
            this.bVV.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bVW.setVisibility(8);
                this.bVp.setVisibility(8);
                this.bVX.setVisibility(0);
                this.bVX.setText(com.baidu.tieba.t.no_group_tip);
                return;
            }
            this.bVW.removeAllViews();
            this.bVW.setVisibility(0);
            this.bVp.setVisibility(0);
            this.bVX.setVisibility(8);
            com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = hr.inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.q.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds26);
                    this.bVW.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int yQ = personPrivate != null ? personPrivate.yQ() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                h(userData);
            } else if (yQ == 1 || (yQ == 2 && isFriend == 1)) {
                h(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bWb.setLayoutParams(layoutParams);
                this.bWa.setText("");
                this.bWa.setTextSize(0.0f);
                this.bWa.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVZ.setVisibility(8);
                this.bWg.setVisibility(0);
                this.bWg.setText(com.baidu.tieba.t.set_private);
                this.bVz.setVisibility(8);
            }
        }
    }

    public void h(UserData userData) {
        if (userData != null) {
            String cl = bb.cl(userData.getLike_bars());
            this.bWa.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
            if (cl.contains("w") && cl.length() > 3) {
                this.bWa.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bWa.setCompoundDrawables(null, null, null, null);
            this.bWa.setText(cl);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
            layoutParams.topMargin = -this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
            this.bWb.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bVZ.setVisibility(8);
                this.bWg.setVisibility(0);
                this.bWg.setText(com.baidu.tieba.t.no_attention_bar);
                this.bVz.setVisibility(8);
                return;
            }
            this.bVZ.setVisibility(0);
            this.bWg.setVisibility(8);
            this.bVz.setVisibility(0);
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
                    this.bWc.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bWc.setText((CharSequence) arrayList.get(0));
                    this.bWd.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bWc.setText((CharSequence) arrayList.get(0));
                    this.bWd.setText((CharSequence) arrayList.get(1));
                    this.bWe.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bWc.setText((CharSequence) arrayList.get(0));
                    this.bWd.setText((CharSequence) arrayList.get(1));
                    this.bWe.setText((CharSequence) arrayList.get(2));
                    this.bWf.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout afh() {
        return this.bVT;
    }

    public RelativeLayout afc() {
        return this.bVY;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

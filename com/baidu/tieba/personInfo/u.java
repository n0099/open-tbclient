package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private int apH = -1;
    private PersonInfoActivity cjU;
    private View clV;
    private ImageView clZ;
    private ImageView cmk;
    private RelativeLayout cml;
    private TextView cmm;
    private TextView cmn;
    private LinearLayout cmo;
    private TextView cmp;
    private RelativeLayout cmq;
    private LinearLayout cmr;
    private TextView cms;
    private TextView cmt;
    private TextView cmu;
    private TextView cmv;
    private TextView cmw;
    private TextView cmx;
    private TextView cmy;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.clV = this.mRootView.findViewById(i.f.root_next);
        this.cml = (RelativeLayout) this.mRootView.findViewById(i.f.group_ll);
        this.cml.setOnClickListener(this.cjU);
        this.cmm = (TextView) this.mRootView.findViewById(i.f.group_num);
        this.cmn = (TextView) this.mRootView.findViewById(i.f.group_num_text);
        this.cmo = (LinearLayout) this.mRootView.findViewById(i.f.group_info_ll);
        this.cmp = (TextView) this.mRootView.findViewById(i.f.no_group_tip);
        this.clZ = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.line = this.mRootView.findViewById(i.f.line);
        this.cmq = (RelativeLayout) this.mRootView.findViewById(i.f.bar_ll);
        this.cmq.setOnClickListener(this.cjU);
        this.cms = (TextView) this.mRootView.findViewById(i.f.bar_num);
        this.cmt = (TextView) this.mRootView.findViewById(i.f.bar_num_text);
        this.cmr = (LinearLayout) this.mRootView.findViewById(i.f.bar_info_ll);
        this.cmu = (TextView) this.mRootView.findViewById(i.f.bar_name_1);
        this.cmv = (TextView) this.mRootView.findViewById(i.f.bar_name_2);
        this.cmw = (TextView) this.mRootView.findViewById(i.f.bar_name_3);
        this.cmx = (TextView) this.mRootView.findViewById(i.f.bar_name_4);
        this.cmy = (TextView) this.mRootView.findViewById(i.f.no_bar_tip);
        this.cmk = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        oQ();
    }

    public void oQ() {
        if (this.apH != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apH = TbadkCoreApplication.m411getInst().getSkinType();
            al.j(this.clV, i.c.cp_bg_line_d);
            al.i(this.cml, i.e.personinfo_select_bg);
            al.b(this.cmm, i.c.cp_cont_f, 1);
            al.b(this.cmn, i.c.cp_cont_d, 1);
            al.b(this.cmp, i.c.cp_cont_e, 1);
            al.i(this.clZ, i.e.icon_dredge_arrow_r_n);
            al.j(this.line, i.c.cp_bg_line_b);
            al.i(this.cmq, i.e.personinfo_select_bg);
            al.b(this.cms, i.c.cp_cont_f, 1);
            al.b(this.cmt, i.c.cp_cont_d, 1);
            al.b(this.cmu, i.c.cp_cont_b, 1);
            al.b(this.cmv, i.c.cp_cont_b, 1);
            al.b(this.cmw, i.c.cp_cont_b, 1);
            al.b(this.cmx, i.c.cp_cont_b, 1);
            al.b(this.cmy, i.c.cp_cont_e, 1);
            al.i(this.cmk, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahi() {
        w agL = this.cjU.agL();
        UserData userData = agL.getUserData();
        PersonTainInfo ahu = agL.ahu();
        c(ahu, userData);
        a(ahu, userData);
        oQ();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            int Ac = personPrivate != null ? personPrivate.Ac() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.cml.setVisibility(8);
                this.line.setVisibility(8);
                return;
            }
            this.cml.setVisibility(0);
            this.line.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (Ac == 1 || (Ac == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmn.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cmn.setLayoutParams(layoutParams);
                this.cmm.setText("");
                this.cmm.setTextSize(0.0f);
                this.cmm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cmo.setVisibility(8);
                this.cmp.setVisibility(0);
                this.cmp.setText(i.C0057i.set_private);
                this.clZ.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String ct = aq.ct(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.cmm.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds72));
            if (ct.contains("w") && ct.length() > 3) {
                this.cmm.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cmm.setCompoundDrawables(null, null, null, null);
            this.cmm.setText(ct);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmn.getLayoutParams();
            layoutParams.topMargin = -this.cjU.getResources().getDimensionPixelSize(i.d.ds10);
            this.cmn.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.cmo.setVisibility(8);
                this.clZ.setVisibility(8);
                this.cmp.setVisibility(0);
                this.cmp.setText(i.C0057i.no_group_tip);
                return;
            }
            this.cmo.removeAllViews();
            this.cmo.setVisibility(0);
            this.clZ.setVisibility(0);
            this.cmp.setVisibility(8);
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(i.f.group_name);
                    ((HeadImageView) inflate.findViewById(i.f.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    al.b(textView, i.c.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.cjU.getResources().getDimensionPixelSize(i.d.ds26);
                    this.cmo.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            int Ab = personPrivate != null ? personPrivate.Ab() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                e(userData);
            } else if (Ab == 1 || (Ab == 2 && isFriend == 1)) {
                e(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmt.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cmt.setLayoutParams(layoutParams);
                this.cms.setText("");
                this.cms.setTextSize(0.0f);
                this.cms.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cmr.setVisibility(8);
                this.cmy.setVisibility(0);
                this.cmy.setText(i.C0057i.set_private);
                this.cmk.setVisibility(8);
            }
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            String ct = aq.ct(userData.getLike_bars());
            this.cms.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds72));
            if (ct.contains("w") && ct.length() > 3) {
                this.cms.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cms.setCompoundDrawables(null, null, null, null);
            this.cms.setText(ct);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmt.getLayoutParams();
            layoutParams.topMargin = -this.cjU.getResources().getDimensionPixelSize(i.d.ds10);
            this.cmt.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.cmr.setVisibility(8);
                this.cmy.setVisibility(0);
                this.cmy.setText(i.C0057i.no_attention_bar);
                this.cmk.setVisibility(8);
                return;
            }
            this.cmr.setVisibility(0);
            this.cmy.setVisibility(8);
            this.cmk.setVisibility(0);
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
            ahj();
            switch (size) {
                case 1:
                    this.cmu.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.cmu.setText((CharSequence) arrayList.get(0));
                    this.cmv.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.cmu.setText((CharSequence) arrayList.get(0));
                    this.cmv.setText((CharSequence) arrayList.get(1));
                    this.cmw.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.cmu.setText((CharSequence) arrayList.get(0));
                    this.cmv.setText((CharSequence) arrayList.get(1));
                    this.cmw.setText((CharSequence) arrayList.get(2));
                    this.cmx.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    private void ahj() {
        this.cmu.setText((CharSequence) null);
        this.cmv.setText((CharSequence) null);
        this.cmw.setText((CharSequence) null);
        this.cmx.setText((CharSequence) null);
    }

    public RelativeLayout ahe() {
        return this.cml;
    }

    public RelativeLayout agX() {
        return this.cmq;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

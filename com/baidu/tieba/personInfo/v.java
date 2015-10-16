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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private int apS = -1;
    private PersonInfoActivity cqE;
    private View csP;
    private ImageView csT;
    private ImageView ctd;
    private RelativeLayout cte;
    private TextView ctf;
    private TextView ctg;
    private LinearLayout cth;
    private TextView cti;
    private RelativeLayout ctj;
    private LinearLayout ctk;
    private TextView ctl;
    private TextView ctm;
    private TextView ctn;
    private TextView cto;
    private TextView ctp;
    private TextView ctq;
    private TextView ctr;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public v(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csP = this.mRootView.findViewById(i.f.root_next);
        this.cte = (RelativeLayout) this.mRootView.findViewById(i.f.group_ll);
        this.cte.setOnClickListener(this.cqE);
        this.ctf = (TextView) this.mRootView.findViewById(i.f.group_num);
        this.ctg = (TextView) this.mRootView.findViewById(i.f.group_num_text);
        this.cth = (LinearLayout) this.mRootView.findViewById(i.f.group_info_ll);
        this.cti = (TextView) this.mRootView.findViewById(i.f.no_group_tip);
        this.csT = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.line = this.mRootView.findViewById(i.f.line);
        this.ctj = (RelativeLayout) this.mRootView.findViewById(i.f.bar_ll);
        this.ctj.setOnClickListener(this.cqE);
        this.ctl = (TextView) this.mRootView.findViewById(i.f.bar_num);
        this.ctm = (TextView) this.mRootView.findViewById(i.f.bar_num_text);
        this.ctk = (LinearLayout) this.mRootView.findViewById(i.f.bar_info_ll);
        this.ctn = (TextView) this.mRootView.findViewById(i.f.bar_name_1);
        this.cto = (TextView) this.mRootView.findViewById(i.f.bar_name_2);
        this.ctp = (TextView) this.mRootView.findViewById(i.f.bar_name_3);
        this.ctq = (TextView) this.mRootView.findViewById(i.f.bar_name_4);
        this.ctr = (TextView) this.mRootView.findViewById(i.f.no_bar_tip);
        this.ctd = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        oO();
    }

    public void oO() {
        if (this.apS != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.csP, i.c.cp_bg_line_d);
            an.i(this.cte, i.e.personinfo_select_bg);
            an.b(this.ctf, i.c.cp_cont_f, 1);
            an.b(this.ctg, i.c.cp_cont_d, 1);
            an.b(this.cti, i.c.cp_cont_e, 1);
            an.i(this.csT, i.e.icon_dredge_arrow_r_n);
            an.j(this.line, i.c.cp_bg_line_b);
            an.i(this.ctj, i.e.personinfo_select_bg);
            an.b(this.ctl, i.c.cp_cont_f, 1);
            an.b(this.ctm, i.c.cp_cont_d, 1);
            an.b(this.ctn, i.c.cp_cont_b, 1);
            an.b(this.cto, i.c.cp_cont_b, 1);
            an.b(this.ctp, i.c.cp_cont_b, 1);
            an.b(this.ctq, i.c.cp_cont_b, 1);
            an.b(this.ctr, i.c.cp_cont_e, 1);
            an.i(this.ctd, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ajC() {
        y ajf = this.cqE.ajf();
        UserData userData = ajf.getUserData();
        PersonTainInfo ajN = ajf.ajN();
        c(ajN, userData);
        a(ajN, userData);
        oO();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            int Aa = personPrivate != null ? personPrivate.Aa() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.cte.setVisibility(8);
                this.line.setVisibility(8);
                return;
            }
            this.cte.setVisibility(0);
            this.line.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (Aa == 1 || (Aa == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctg.getLayoutParams();
                layoutParams.topMargin = 0;
                this.ctg.setLayoutParams(layoutParams);
                this.ctf.setText("");
                this.ctf.setTextSize(0.0f);
                this.ctf.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cth.setVisibility(8);
                this.cti.setVisibility(0);
                this.cti.setText(i.h.set_private);
                this.csT.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cA = as.cA(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.ctf.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.ctf.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.ctf.setCompoundDrawables(null, null, null, null);
            this.ctf.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctg.getLayoutParams();
            layoutParams.topMargin = -this.cqE.getResources().getDimensionPixelSize(i.d.ds10);
            this.ctg.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.cth.setVisibility(8);
                this.csT.setVisibility(8);
                this.cti.setVisibility(0);
                this.cti.setText(i.h.no_group_tip);
                return;
            }
            this.cth.removeAllViews();
            this.cth.setVisibility(0);
            this.csT.setVisibility(0);
            this.cti.setVisibility(8);
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(i.f.group_name);
                    ((HeadImageView) inflate.findViewById(i.f.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    an.b(textView, i.c.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.cqE.getResources().getDimensionPixelSize(i.d.ds26);
                    this.cth.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            int zZ = personPrivate != null ? personPrivate.zZ() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                e(userData);
            } else if (zZ == 1 || (zZ == 2 && isFriend == 1)) {
                e(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctm.getLayoutParams();
                layoutParams.topMargin = 0;
                this.ctm.setLayoutParams(layoutParams);
                this.ctl.setText("");
                this.ctl.setTextSize(0.0f);
                this.ctl.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.ctk.setVisibility(8);
                this.ctr.setVisibility(0);
                this.ctr.setText(i.h.set_private);
                this.ctd.setVisibility(8);
            }
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            String cA = as.cA(userData.getLike_bars());
            this.ctl.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.ctl.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.ctl.setCompoundDrawables(null, null, null, null);
            this.ctl.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctm.getLayoutParams();
            layoutParams.topMargin = -this.cqE.getResources().getDimensionPixelSize(i.d.ds10);
            this.ctm.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.ctk.setVisibility(8);
                this.ctr.setVisibility(0);
                this.ctr.setText(i.h.no_attention_bar);
                this.ctd.setVisibility(8);
                return;
            }
            this.ctk.setVisibility(0);
            this.ctr.setVisibility(8);
            this.ctd.setVisibility(0);
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
            ajD();
            switch (size) {
                case 1:
                    this.ctn.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.ctn.setText((CharSequence) arrayList.get(0));
                    this.cto.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.ctn.setText((CharSequence) arrayList.get(0));
                    this.cto.setText((CharSequence) arrayList.get(1));
                    this.ctp.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.ctn.setText((CharSequence) arrayList.get(0));
                    this.cto.setText((CharSequence) arrayList.get(1));
                    this.ctp.setText((CharSequence) arrayList.get(2));
                    this.ctq.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    private void ajD() {
        this.ctn.setText((CharSequence) null);
        this.cto.setText((CharSequence) null);
        this.ctp.setText((CharSequence) null);
        this.ctq.setText((CharSequence) null);
    }

    public RelativeLayout ajy() {
        return this.cte;
    }

    public RelativeLayout ajr() {
        return this.ctj;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

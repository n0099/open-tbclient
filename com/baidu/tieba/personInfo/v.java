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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private int apR = -1;
    private PersonInfoActivity cqt;
    private View csE;
    private ImageView csI;
    private ImageView csS;
    private RelativeLayout csT;
    private TextView csU;
    private TextView csV;
    private LinearLayout csW;
    private TextView csX;
    private RelativeLayout csY;
    private LinearLayout csZ;
    private TextView cta;
    private TextView ctb;
    private TextView ctc;
    private TextView ctd;
    private TextView cte;
    private TextView ctf;
    private TextView ctg;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public v(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csE = this.mRootView.findViewById(i.f.root_next);
        this.csT = (RelativeLayout) this.mRootView.findViewById(i.f.group_ll);
        this.csT.setOnClickListener(this.cqt);
        this.csU = (TextView) this.mRootView.findViewById(i.f.group_num);
        this.csV = (TextView) this.mRootView.findViewById(i.f.group_num_text);
        this.csW = (LinearLayout) this.mRootView.findViewById(i.f.group_info_ll);
        this.csX = (TextView) this.mRootView.findViewById(i.f.no_group_tip);
        this.csI = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.line = this.mRootView.findViewById(i.f.line);
        this.csY = (RelativeLayout) this.mRootView.findViewById(i.f.bar_ll);
        this.csY.setOnClickListener(this.cqt);
        this.cta = (TextView) this.mRootView.findViewById(i.f.bar_num);
        this.ctb = (TextView) this.mRootView.findViewById(i.f.bar_num_text);
        this.csZ = (LinearLayout) this.mRootView.findViewById(i.f.bar_info_ll);
        this.ctc = (TextView) this.mRootView.findViewById(i.f.bar_name_1);
        this.ctd = (TextView) this.mRootView.findViewById(i.f.bar_name_2);
        this.cte = (TextView) this.mRootView.findViewById(i.f.bar_name_3);
        this.ctf = (TextView) this.mRootView.findViewById(i.f.bar_name_4);
        this.ctg = (TextView) this.mRootView.findViewById(i.f.no_bar_tip);
        this.csS = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        oO();
    }

    public void oO() {
        if (this.apR != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
            am.j(this.csE, i.c.cp_bg_line_d);
            am.i(this.csT, i.e.personinfo_select_bg);
            am.b(this.csU, i.c.cp_cont_f, 1);
            am.b(this.csV, i.c.cp_cont_d, 1);
            am.b(this.csX, i.c.cp_cont_e, 1);
            am.i(this.csI, i.e.icon_dredge_arrow_r_n);
            am.j(this.line, i.c.cp_bg_line_b);
            am.i(this.csY, i.e.personinfo_select_bg);
            am.b(this.cta, i.c.cp_cont_f, 1);
            am.b(this.ctb, i.c.cp_cont_d, 1);
            am.b(this.ctc, i.c.cp_cont_b, 1);
            am.b(this.ctd, i.c.cp_cont_b, 1);
            am.b(this.cte, i.c.cp_cont_b, 1);
            am.b(this.ctf, i.c.cp_cont_b, 1);
            am.b(this.ctg, i.c.cp_cont_e, 1);
            am.i(this.csS, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ajC() {
        y ajf = this.cqt.ajf();
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
                this.csT.setVisibility(8);
                this.line.setVisibility(8);
                return;
            }
            this.csT.setVisibility(0);
            this.line.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (Aa == 1 || (Aa == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csV.getLayoutParams();
                layoutParams.topMargin = 0;
                this.csV.setLayoutParams(layoutParams);
                this.csU.setText("");
                this.csU.setTextSize(0.0f);
                this.csU.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.csW.setVisibility(8);
                this.csX.setVisibility(0);
                this.csX.setText(i.h.set_private);
                this.csI.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cA = ar.cA(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.csU.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.csU.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.csU.setCompoundDrawables(null, null, null, null);
            this.csU.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csV.getLayoutParams();
            layoutParams.topMargin = -this.cqt.getResources().getDimensionPixelSize(i.d.ds10);
            this.csV.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.csW.setVisibility(8);
                this.csI.setVisibility(8);
                this.csX.setVisibility(0);
                this.csX.setText(i.h.no_group_tip);
                return;
            }
            this.csW.removeAllViews();
            this.csW.setVisibility(0);
            this.csI.setVisibility(0);
            this.csX.setVisibility(8);
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(i.f.group_name);
                    ((HeadImageView) inflate.findViewById(i.f.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    am.b(textView, i.c.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.cqt.getResources().getDimensionPixelSize(i.d.ds26);
                    this.csW.addView(inflate, layoutParams2);
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
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctb.getLayoutParams();
                layoutParams.topMargin = 0;
                this.ctb.setLayoutParams(layoutParams);
                this.cta.setText("");
                this.cta.setTextSize(0.0f);
                this.cta.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.csZ.setVisibility(8);
                this.ctg.setVisibility(0);
                this.ctg.setText(i.h.set_private);
                this.csS.setVisibility(8);
            }
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            String cA = ar.cA(userData.getLike_bars());
            this.cta.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.cta.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cta.setCompoundDrawables(null, null, null, null);
            this.cta.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctb.getLayoutParams();
            layoutParams.topMargin = -this.cqt.getResources().getDimensionPixelSize(i.d.ds10);
            this.ctb.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.csZ.setVisibility(8);
                this.ctg.setVisibility(0);
                this.ctg.setText(i.h.no_attention_bar);
                this.csS.setVisibility(8);
                return;
            }
            this.csZ.setVisibility(0);
            this.ctg.setVisibility(8);
            this.csS.setVisibility(0);
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
                    this.ctc.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.ctc.setText((CharSequence) arrayList.get(0));
                    this.ctd.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.ctc.setText((CharSequence) arrayList.get(0));
                    this.ctd.setText((CharSequence) arrayList.get(1));
                    this.cte.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.ctc.setText((CharSequence) arrayList.get(0));
                    this.ctd.setText((CharSequence) arrayList.get(1));
                    this.cte.setText((CharSequence) arrayList.get(2));
                    this.ctf.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    private void ajD() {
        this.ctc.setText((CharSequence) null);
        this.ctd.setText((CharSequence) null);
        this.cte.setText((CharSequence) null);
        this.ctf.setText((CharSequence) null);
    }

    public RelativeLayout ajy() {
        return this.csT;
    }

    public RelativeLayout ajr() {
        return this.csY;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

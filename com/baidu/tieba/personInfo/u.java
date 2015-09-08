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
    private int arr = -1;
    private PersonInfoActivity ckP;
    private View cmY;
    private TextView cnA;
    private ImageView cnc;
    private ImageView cnm;
    private RelativeLayout cnn;
    private TextView cno;
    private TextView cnp;
    private LinearLayout cnq;
    private TextView cnr;
    private RelativeLayout cns;
    private LinearLayout cnt;
    private TextView cnu;
    private TextView cnv;
    private TextView cnw;
    private TextView cnx;
    private TextView cny;
    private TextView cnz;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cmY = this.mRootView.findViewById(i.f.root_next);
        this.cnn = (RelativeLayout) this.mRootView.findViewById(i.f.group_ll);
        this.cnn.setOnClickListener(this.ckP);
        this.cno = (TextView) this.mRootView.findViewById(i.f.group_num);
        this.cnp = (TextView) this.mRootView.findViewById(i.f.group_num_text);
        this.cnq = (LinearLayout) this.mRootView.findViewById(i.f.group_info_ll);
        this.cnr = (TextView) this.mRootView.findViewById(i.f.no_group_tip);
        this.cnc = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.line = this.mRootView.findViewById(i.f.line);
        this.cns = (RelativeLayout) this.mRootView.findViewById(i.f.bar_ll);
        this.cns.setOnClickListener(this.ckP);
        this.cnu = (TextView) this.mRootView.findViewById(i.f.bar_num);
        this.cnv = (TextView) this.mRootView.findViewById(i.f.bar_num_text);
        this.cnt = (LinearLayout) this.mRootView.findViewById(i.f.bar_info_ll);
        this.cnw = (TextView) this.mRootView.findViewById(i.f.bar_name_1);
        this.cnx = (TextView) this.mRootView.findViewById(i.f.bar_name_2);
        this.cny = (TextView) this.mRootView.findViewById(i.f.bar_name_3);
        this.cnz = (TextView) this.mRootView.findViewById(i.f.bar_name_4);
        this.cnA = (TextView) this.mRootView.findViewById(i.f.no_bar_tip);
        this.cnm = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        oN();
    }

    public void oN() {
        if (this.arr != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arr = TbadkCoreApplication.m411getInst().getSkinType();
            al.i(this.cmY, i.c.cp_bg_line_d);
            al.h(this.cnn, i.e.personinfo_select_bg);
            al.b(this.cno, i.c.cp_cont_f, 1);
            al.b(this.cnp, i.c.cp_cont_d, 1);
            al.b(this.cnr, i.c.cp_cont_e, 1);
            al.h(this.cnc, i.e.icon_dredge_arrow_r_n);
            al.i(this.line, i.c.cp_bg_line_b);
            al.h(this.cns, i.e.personinfo_select_bg);
            al.b(this.cnu, i.c.cp_cont_f, 1);
            al.b(this.cnv, i.c.cp_cont_d, 1);
            al.b(this.cnw, i.c.cp_cont_b, 1);
            al.b(this.cnx, i.c.cp_cont_b, 1);
            al.b(this.cny, i.c.cp_cont_b, 1);
            al.b(this.cnz, i.c.cp_cont_b, 1);
            al.b(this.cnA, i.c.cp_cont_e, 1);
            al.h(this.cnm, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahA() {
        w ahd = this.ckP.ahd();
        UserData userData = ahd.getUserData();
        PersonTainInfo ahM = ahd.ahM();
        c(ahM, userData);
        a(ahM, userData);
        oN();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            int Ap = personPrivate != null ? personPrivate.Ap() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.cnn.setVisibility(8);
                this.line.setVisibility(8);
                return;
            }
            this.cnn.setVisibility(0);
            this.line.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (Ap == 1 || (Ap == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnp.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cnp.setLayoutParams(layoutParams);
                this.cno.setText("");
                this.cno.setTextSize(0.0f);
                this.cno.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cnq.setVisibility(8);
                this.cnr.setVisibility(0);
                this.cnr.setText(i.h.set_private);
                this.cnc.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cy = aq.cy(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.cno.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds72));
            if (cy.contains("w") && cy.length() > 3) {
                this.cno.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cno.setCompoundDrawables(null, null, null, null);
            this.cno.setText(cy);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnp.getLayoutParams();
            layoutParams.topMargin = -this.ckP.getResources().getDimensionPixelSize(i.d.ds10);
            this.cnp.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.cnq.setVisibility(8);
                this.cnc.setVisibility(8);
                this.cnr.setVisibility(0);
                this.cnr.setText(i.h.no_group_tip);
                return;
            }
            this.cnq.removeAllViews();
            this.cnq.setVisibility(0);
            this.cnc.setVisibility(0);
            this.cnr.setVisibility(8);
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(i.f.group_name);
                    ((HeadImageView) inflate.findViewById(i.f.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    al.b(textView, i.c.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.ckP.getResources().getDimensionPixelSize(i.d.ds26);
                    this.cnq.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            int Ao = personPrivate != null ? personPrivate.Ao() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                e(userData);
            } else if (Ao == 1 || (Ao == 2 && isFriend == 1)) {
                e(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnv.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cnv.setLayoutParams(layoutParams);
                this.cnu.setText("");
                this.cnu.setTextSize(0.0f);
                this.cnu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cnt.setVisibility(8);
                this.cnA.setVisibility(0);
                this.cnA.setText(i.h.set_private);
                this.cnm.setVisibility(8);
            }
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            String cy = aq.cy(userData.getLike_bars());
            this.cnu.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds72));
            if (cy.contains("w") && cy.length() > 3) {
                this.cnu.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cnu.setCompoundDrawables(null, null, null, null);
            this.cnu.setText(cy);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnv.getLayoutParams();
            layoutParams.topMargin = -this.ckP.getResources().getDimensionPixelSize(i.d.ds10);
            this.cnv.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.cnt.setVisibility(8);
                this.cnA.setVisibility(0);
                this.cnA.setText(i.h.no_attention_bar);
                this.cnm.setVisibility(8);
                return;
            }
            this.cnt.setVisibility(0);
            this.cnA.setVisibility(8);
            this.cnm.setVisibility(0);
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
            ahB();
            switch (size) {
                case 1:
                    this.cnw.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.cnw.setText((CharSequence) arrayList.get(0));
                    this.cnx.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.cnw.setText((CharSequence) arrayList.get(0));
                    this.cnx.setText((CharSequence) arrayList.get(1));
                    this.cny.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.cnw.setText((CharSequence) arrayList.get(0));
                    this.cnx.setText((CharSequence) arrayList.get(1));
                    this.cny.setText((CharSequence) arrayList.get(2));
                    this.cnz.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    private void ahB() {
        this.cnw.setText((CharSequence) null);
        this.cnx.setText((CharSequence) null);
        this.cny.setText((CharSequence) null);
        this.cnz.setText((CharSequence) null);
    }

    public RelativeLayout ahw() {
        return this.cnn;
    }

    public RelativeLayout ahp() {
        return this.cns;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

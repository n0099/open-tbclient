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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private ImageView bIH;
    private PersonInfoActivity bIn;
    private View bIt;
    private ImageView bIx;
    private RelativeLayout bJb;
    private TextView bJc;
    private TextView bJd;
    private LinearLayout bJe;
    private TextView bJf;
    private RelativeLayout bJg;
    private LinearLayout bJh;
    private TextView bJi;
    private TextView bJj;
    private TextView bJk;
    private TextView bJl;
    private TextView bJm;
    private TextView bJn;
    private TextView bJo;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bIt = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bJb = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_ll);
        this.bJb.setOnClickListener(this.bIn);
        this.bJc = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num);
        this.bJd = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.group_num_text);
        this.bJe = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.group_info_ll);
        this.bJf = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_group_tip);
        this.bIx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.w.line);
        this.bJg = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_ll);
        this.bJg.setOnClickListener(this.bIn);
        this.bJi = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num);
        this.bJj = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_num_text);
        this.bJh = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.bar_info_ll);
        this.bJk = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_1);
        this.bJl = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_2);
        this.bJm = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_3);
        this.bJn = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.bar_name_4);
        this.bJo = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_bar_tip);
        this.bIH = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        kE();
    }

    public void kE() {
        ax.j(this.bIt, com.baidu.tieba.t.cp_bg_line_d);
        ax.i(this.bJb, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bJc, com.baidu.tieba.t.cp_cont_f, 1);
        ax.b(this.bJd, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bJf, com.baidu.tieba.t.cp_cont_e, 1);
        ax.i(this.bIx, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        ax.j(this.line, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bJg, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bJi, com.baidu.tieba.t.cp_cont_f, 1);
        ax.b(this.bJj, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bJk, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(this.bJl, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(this.bJm, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(this.bJn, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(this.bJo, com.baidu.tieba.t.cp_cont_e, 1);
        ax.i(this.bIH, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abe() {
        v aaL = this.bIn.aaL();
        UserData userData = aaL.getUserData();
        PersonTainInfo abr = aaL.abr();
        c(abr, userData);
        a(abr, userData);
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int ux = personPrivate != null ? personPrivate.ux() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                b(personTainInfo, userData);
                return;
            }
            if (ux == 1 || (ux == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJd.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bJd.setLayoutParams(layoutParams);
                this.bJc.setText("");
                this.bJc.setTextSize(0.0f);
                ax.i((View) this.bJc, com.baidu.tieba.v.icon_mycenter_lock);
                this.bJe.setVisibility(8);
                this.bJf.setVisibility(0);
                this.bJf.setText(com.baidu.tieba.z.set_private);
                this.bIx.setVisibility(8);
            }
            if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bJb.setVisibility(8);
            } else {
                this.bJb.setVisibility(0);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String bY = ba.bY(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bJc.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (bY.contains("w") && bY.length() > 3) {
                this.bJc.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bJc.setBackgroundDrawable(null);
            this.bJc.setText(bY);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJd.getLayoutParams();
            layoutParams.topMargin = -this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bJd.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bJe.setVisibility(8);
                this.bIx.setVisibility(8);
                this.bJf.setVisibility(0);
                this.bJf.setText(com.baidu.tieba.z.no_group_tip);
                return;
            }
            this.bJe.removeAllViews();
            this.bJe.setVisibility(0);
            this.bIx.setVisibility(0);
            this.bJf.setVisibility(8);
            com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = ek.inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.w.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    ax.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
                    this.bJe.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int uw = personPrivate != null ? personPrivate.uw() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                i(userData);
            } else if (uw == 1 || (uw == 2 && isFriend == 1)) {
                i(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJj.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bJj.setLayoutParams(layoutParams);
                this.bJi.setText("");
                this.bJi.setTextSize(0.0f);
                ax.i((View) this.bJi, com.baidu.tieba.v.icon_mycenter_lock);
                this.bJh.setVisibility(8);
                this.bJo.setVisibility(0);
                this.bJo.setText(com.baidu.tieba.z.set_private);
                this.bIH.setVisibility(8);
            }
        }
    }

    public void i(UserData userData) {
        if (userData != null) {
            String bY = ba.bY(userData.getLike_bars());
            this.bJi.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
            if (bY.contains("w") && bY.length() > 3) {
                this.bJi.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bJi.setBackgroundDrawable(null);
            this.bJi.setText(bY);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJj.getLayoutParams();
            layoutParams.topMargin = -this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
            this.bJj.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bJh.setVisibility(8);
                this.bJo.setVisibility(0);
                this.bJo.setText(com.baidu.tieba.z.no_attention_bar);
                this.bIH.setVisibility(8);
                return;
            }
            this.bJh.setVisibility(0);
            this.bJo.setVisibility(8);
            this.bIH.setVisibility(0);
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
                    this.bJk.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bJk.setText((CharSequence) arrayList.get(0));
                    this.bJl.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bJk.setText((CharSequence) arrayList.get(0));
                    this.bJl.setText((CharSequence) arrayList.get(1));
                    this.bJm.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bJk.setText((CharSequence) arrayList.get(0));
                    this.bJl.setText((CharSequence) arrayList.get(1));
                    this.bJm.setText((CharSequence) arrayList.get(2));
                    this.bJn.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout aba() {
        return this.bJb;
    }

    public RelativeLayout aaV() {
        return this.bJg;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private int aiq = -1;
    private ImageView bSC;
    private RelativeLayout bSW;
    private TextView bSX;
    private TextView bSY;
    private LinearLayout bSZ;
    private PersonInfoActivity bSi;
    private View bSo;
    private ImageView bSs;
    private TextView bTa;
    private RelativeLayout bTb;
    private LinearLayout bTc;
    private TextView bTd;
    private TextView bTe;
    private TextView bTf;
    private TextView bTg;
    private TextView bTh;
    private TextView bTi;
    private TextView bTj;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bSo = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bSW = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.group_ll);
        this.bSW.setOnClickListener(this.bSi);
        this.bSX = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.group_num);
        this.bSY = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.group_num_text);
        this.bSZ = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.group_info_ll);
        this.bTa = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_group_tip);
        this.bSs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.v.line);
        this.bTb = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.bar_ll);
        this.bTb.setOnClickListener(this.bSi);
        this.bTd = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_num);
        this.bTe = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_num_text);
        this.bTc = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.bar_info_ll);
        this.bTf = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_1);
        this.bTg = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_2);
        this.bTh = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_3);
        this.bTi = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_4);
        this.bTj = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_bar_tip);
        this.bSC = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        oq();
    }

    public void oq() {
        if (this.aiq != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSo, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bSW, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSX, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bSY, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bTa, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSs, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.line, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bTb, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTd, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bTe, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bTf, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTg, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTh, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTi, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTj, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSC, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void adR() {
        v ady = this.bSi.ady();
        UserData userData = ady.getUserData();
        PersonTainInfo aed = ady.aed();
        c(aed, userData);
        a(aed, userData);
        oq();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int xY = personPrivate != null ? personPrivate.xY() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bSW.setVisibility(8);
                return;
            }
            this.bSW.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (xY == 1 || (xY == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSY.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bSY.setLayoutParams(layoutParams);
                this.bSX.setText("");
                this.bSX.setTextSize(0.0f);
                this.bSX.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bSZ.setVisibility(8);
                this.bTa.setVisibility(0);
                this.bTa.setText(com.baidu.tieba.y.set_private);
                this.bSs.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String ch = bd.ch(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bSX.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (ch.contains("w") && ch.length() > 3) {
                this.bSX.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bSX.setCompoundDrawables(null, null, null, null);
            this.bSX.setText(ch);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSY.getLayoutParams();
            layoutParams.topMargin = -this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bSY.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bSZ.setVisibility(8);
                this.bSs.setVisibility(8);
                this.bTa.setVisibility(0);
                this.bTa.setText(com.baidu.tieba.y.no_group_tip);
                return;
            }
            this.bSZ.removeAllViews();
            this.bSZ.setVisibility(0);
            this.bSs.setVisibility(0);
            this.bTa.setVisibility(8);
            com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = hH.inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.v.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
                    this.bSZ.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int xX = personPrivate != null ? personPrivate.xX() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                h(userData);
            } else if (xX == 1 || (xX == 2 && isFriend == 1)) {
                h(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTe.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bTe.setLayoutParams(layoutParams);
                this.bTd.setText("");
                this.bTd.setTextSize(0.0f);
                this.bTd.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bTc.setVisibility(8);
                this.bTj.setVisibility(0);
                this.bTj.setText(com.baidu.tieba.y.set_private);
                this.bSC.setVisibility(8);
            }
        }
    }

    public void h(UserData userData) {
        if (userData != null) {
            String ch = bd.ch(userData.getLike_bars());
            this.bTd.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (ch.contains("w") && ch.length() > 3) {
                this.bTd.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bTd.setCompoundDrawables(null, null, null, null);
            this.bTd.setText(ch);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTe.getLayoutParams();
            layoutParams.topMargin = -this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bTe.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bTc.setVisibility(8);
                this.bTj.setVisibility(0);
                this.bTj.setText(com.baidu.tieba.y.no_attention_bar);
                this.bSC.setVisibility(8);
                return;
            }
            this.bTc.setVisibility(0);
            this.bTj.setVisibility(8);
            this.bSC.setVisibility(0);
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
                    this.bTf.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bTf.setText((CharSequence) arrayList.get(0));
                    this.bTg.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bTf.setText((CharSequence) arrayList.get(0));
                    this.bTg.setText((CharSequence) arrayList.get(1));
                    this.bTh.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bTf.setText((CharSequence) arrayList.get(0));
                    this.bTg.setText((CharSequence) arrayList.get(1));
                    this.bTh.setText((CharSequence) arrayList.get(2));
                    this.bTi.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout adN() {
        return this.bSW;
    }

    public RelativeLayout adI() {
        return this.bTb;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

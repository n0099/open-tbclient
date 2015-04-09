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
    private int aiy = -1;
    private View bSE;
    private ImageView bSI;
    private ImageView bSS;
    private PersonInfoActivity bSy;
    private RelativeLayout bTm;
    private TextView bTn;
    private TextView bTo;
    private LinearLayout bTp;
    private TextView bTq;
    private RelativeLayout bTr;
    private LinearLayout bTs;
    private TextView bTt;
    private TextView bTu;
    private TextView bTv;
    private TextView bTw;
    private TextView bTx;
    private TextView bTy;
    private TextView bTz;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_group_view, null);
        initView();
    }

    private void initView() {
        this.bSE = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bTm = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.group_ll);
        this.bTm.setOnClickListener(this.bSy);
        this.bTn = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.group_num);
        this.bTo = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.group_num_text);
        this.bTp = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.group_info_ll);
        this.bTq = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_group_tip);
        this.bSI = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.line = this.mRootView.findViewById(com.baidu.tieba.v.line);
        this.bTr = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.bar_ll);
        this.bTr.setOnClickListener(this.bSy);
        this.bTt = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_num);
        this.bTu = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_num_text);
        this.bTs = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.bar_info_ll);
        this.bTv = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_1);
        this.bTw = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_2);
        this.bTx = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_3);
        this.bTy = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.bar_name_4);
        this.bTz = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_bar_tip);
        this.bSS = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        oq();
    }

    public void oq() {
        if (this.aiy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSE, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bTm, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTn, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bTo, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bTq, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSI, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.line, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bTr, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTt, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bTu, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bTv, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTw, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTx, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTy, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(this.bTz, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSS, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void aeg() {
        v adN = this.bSy.adN();
        UserData userData = adN.getUserData();
        PersonTainInfo aes = adN.aes();
        c(aes, userData);
        a(aes, userData);
        oq();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int ye = personPrivate != null ? personPrivate.ye() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.bTm.setVisibility(8);
                return;
            }
            this.bTm.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (ye == 1 || (ye == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTo.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bTo.setLayoutParams(layoutParams);
                this.bTn.setText("");
                this.bTn.setTextSize(0.0f);
                this.bTn.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bTp.setVisibility(8);
                this.bTq.setVisibility(0);
                this.bTq.setText(com.baidu.tieba.y.set_private);
                this.bSI.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String ch = bd.ch(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.bTn.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (ch.contains("w") && ch.length() > 3) {
                this.bTn.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bTn.setCompoundDrawables(null, null, null, null);
            this.bTn.setText(ch);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTo.getLayoutParams();
            layoutParams.topMargin = -this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bTo.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.bTp.setVisibility(8);
                this.bSI.setVisibility(8);
                this.bTq.setVisibility(0);
                this.bTq.setText(com.baidu.tieba.y.no_group_tip);
                return;
            }
            this.bTp.removeAllViews();
            this.bTp.setVisibility(0);
            this.bSI.setVisibility(0);
            this.bTq.setVisibility(8);
            com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = hH.inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_group_item, null);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.group_name);
                    ((HeadImageView) inflate.findViewById(com.baidu.tieba.v.group_head)).c(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
                    this.bTp.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            int yd = personPrivate != null ? personPrivate.yd() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                h(userData);
            } else if (yd == 1 || (yd == 2 && isFriend == 1)) {
                h(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTu.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bTu.setLayoutParams(layoutParams);
                this.bTt.setText("");
                this.bTt.setTextSize(0.0f);
                this.bTt.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bTs.setVisibility(8);
                this.bTz.setVisibility(0);
                this.bTz.setText(com.baidu.tieba.y.set_private);
                this.bSS.setVisibility(8);
            }
        }
    }

    public void h(UserData userData) {
        if (userData != null) {
            String ch = bd.ch(userData.getLike_bars());
            this.bTt.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
            if (ch.contains("w") && ch.length() > 3) {
                this.bTt.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bTt.setCompoundDrawables(null, null, null, null);
            this.bTt.setText(ch);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTu.getLayoutParams();
            layoutParams.topMargin = -this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
            this.bTu.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.bTs.setVisibility(8);
                this.bTz.setVisibility(0);
                this.bTz.setText(com.baidu.tieba.y.no_attention_bar);
                this.bSS.setVisibility(8);
                return;
            }
            this.bTs.setVisibility(0);
            this.bTz.setVisibility(8);
            this.bSS.setVisibility(0);
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
                    this.bTv.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.bTv.setText((CharSequence) arrayList.get(0));
                    this.bTw.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.bTv.setText((CharSequence) arrayList.get(0));
                    this.bTw.setText((CharSequence) arrayList.get(1));
                    this.bTx.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.bTv.setText((CharSequence) arrayList.get(0));
                    this.bTw.setText((CharSequence) arrayList.get(1));
                    this.bTx.setText((CharSequence) arrayList.get(2));
                    this.bTy.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    public RelativeLayout aec() {
        return this.bTm;
    }

    public RelativeLayout adX() {
        return this.bTr;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

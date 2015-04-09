package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private int aiy = -1;
    private PersonInfoActivity bSy;
    private RelativeLayout bUa;
    private TextView bUb;
    private TextView bUc;
    private LinearLayout bUd;
    private TextView bUe;
    private ImageView brL;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bUa = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.post_ll);
        this.bUa.setOnClickListener(this.bSy);
        this.bUb = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.post_num);
        this.bUc = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.post_num_text);
        this.bUd = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.post_info_ll);
        this.bUe = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_post_tip);
        this.brL = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow);
        oq();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUa.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bUa.setLayoutParams(layoutParams);
        }
    }

    public void oq() {
        if (this.aiy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
            ba.i(this.bUa, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bUb, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bUc, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bUe, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.brL, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void aeg() {
        oq();
        v adN = this.bSy.adN();
        UserData userData = adN.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo aes = adN.aes();
            int yf = personPrivate != null ? personPrivate.yf() : 1;
            int isFriend = aes != null ? aes.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, adN);
            } else if (yf == 1 || (yf == 2 && isFriend == 1)) {
                a(userData, adN);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUc.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bUc.setLayoutParams(layoutParams);
                this.bUb.setText("");
                this.bUb.setTextSize(0.0f);
                this.bUb.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bUe.setVisibility(0);
                this.bUe.setText(com.baidu.tieba.y.set_private);
                this.bUd.setVisibility(8);
                this.brL.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String ch = bd.ch(userData.getPosts_num());
        this.bUb.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
        if (ch.contains("w") && ch.length() > 3) {
            this.bUb.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
        }
        this.bUb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bUb.setText(ch);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUc.getLayoutParams();
        layoutParams.topMargin = -this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
        this.bUc.setLayoutParams(layoutParams);
        List<PersonInfoPostList> aer = vVar.aer();
        if (aer == null || aer.size() <= 0) {
            this.bUd.setVisibility(8);
            this.brL.setVisibility(8);
            this.bUe.setVisibility(0);
            this.bUe.setText(com.baidu.tieba.y.no_post_tip);
            return;
        }
        this.bUd.setVisibility(0);
        this.brL.setVisibility(0);
        this.bUe.setVisibility(8);
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        this.bUd.removeAllViews();
        int size = aer.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = aer.get(i2);
            View inflate = hH.inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.v.line);
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView2, com.baidu.tieba.s.cp_cont_f, 1);
            ba.j(findViewById, com.baidu.tieba.s.cp_bg_line_b);
            textView.setText(personInfoPostList.getTitle());
            List<PersonInfoAbstract> abstractThread = personInfoPostList.getAbstractThread();
            if (abstractThread != null && abstractThread.size() > 0 && !StringUtils.isNull(abstractThread.get(0).getText())) {
                textView2.setText(abstractThread.get(0).getText());
            } else {
                textView2.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            if (i2 == 0) {
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.topMargin = this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
            }
            this.bUd.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout aee() {
        return this.bUa;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

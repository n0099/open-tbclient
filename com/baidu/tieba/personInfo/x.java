package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private View HT;
    private PersonInfoActivity bES;
    private ImageView bGA;
    private RelativeLayout bGv;
    private TextView bGw;
    private TextView bGx;
    private LinearLayout bGy;
    private TextView bGz;
    private boolean mIsHost;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_post_view, null);
        nu();
    }

    private void nu() {
        this.bGv = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.post_ll);
        this.bGv.setOnClickListener(this.bES);
        this.bGw = (TextView) this.HT.findViewById(com.baidu.tieba.v.post_num);
        this.bGx = (TextView) this.HT.findViewById(com.baidu.tieba.v.post_num_text);
        this.bGy = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.post_info_ll);
        this.bGz = (TextView) this.HT.findViewById(com.baidu.tieba.v.no_post_tip);
        this.bGA = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow);
        pU();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGv.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bGv.setLayoutParams(layoutParams);
        }
    }

    public void pU() {
        aw.h(this.bGv, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bGw, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bGx, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bGz, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bGA, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void aaJ() {
        v aar = this.bES.aar();
        UserData userData = aar.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            PersonTainInfo aaV = aar.aaV();
            int qW = personPrivate != null ? personPrivate.qW() : 1;
            int isFriend = aaV != null ? aaV.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, aar);
            } else if (qW == 1 || (qW == 2 && isFriend == 1)) {
                a(userData, aar);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGx.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bGx.setLayoutParams(layoutParams);
                this.bGw.setText("");
                this.bGw.setTextSize(0.0f);
                aw.h((View) this.bGw, com.baidu.tieba.u.icon_mycenter_lock);
                this.bGz.setVisibility(0);
                this.bGz.setText(com.baidu.tieba.y.set_private);
                this.bGy.setVisibility(8);
                this.bGA.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String bB = az.bB(userData.getPosts_num());
        this.bGw.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
        if (bB.contains("w") && bB.length() > 3) {
            this.bGw.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
        }
        this.bGw.setBackgroundDrawable(null);
        this.bGw.setText(bB);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGx.getLayoutParams();
        layoutParams.topMargin = -this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
        this.bGx.setLayoutParams(layoutParams);
        List<PersonInfoPostList> aaU = vVar.aaU();
        if (aaU == null || aaU.size() <= 0) {
            this.bGy.setVisibility(8);
            this.bGA.setVisibility(8);
            this.bGz.setVisibility(0);
            this.bGz.setText(com.baidu.tieba.y.no_post_tip);
            return;
        }
        this.bGy.setVisibility(0);
        this.bGA.setVisibility(0);
        this.bGz.setVisibility(8);
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        this.bGy.removeAllViews();
        int size = aaU.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = aaU.get(i2);
            View inflate = ek.inflate(this.bES, com.baidu.tieba.w.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.v.line);
            aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView2, com.baidu.tieba.s.cp_cont_f, 1);
            aw.i(findViewById, com.baidu.tieba.s.cp_bg_line_b);
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
                layoutParams2.topMargin = this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
            }
            this.bGy.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout aaH() {
        return this.bGv;
    }

    public View getRootView() {
        return this.HT;
    }
}

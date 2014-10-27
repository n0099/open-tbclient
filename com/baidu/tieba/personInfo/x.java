package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private View HS;
    private PersonInfoActivity bEE;
    private RelativeLayout bGh;
    private TextView bGi;
    private TextView bGj;
    private LinearLayout bGk;
    private TextView bGl;
    private ImageView bGm;
    private boolean mIsHost;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_post_view, null);
        nu();
    }

    private void nu() {
        this.bGh = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.post_ll);
        this.bGh.setOnClickListener(this.bEE);
        this.bGi = (TextView) this.HS.findViewById(com.baidu.tieba.v.post_num);
        this.bGj = (TextView) this.HS.findViewById(com.baidu.tieba.v.post_num_text);
        this.bGk = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.post_info_ll);
        this.bGl = (TextView) this.HS.findViewById(com.baidu.tieba.v.no_post_tip);
        this.bGm = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow);
        pS();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bGh.setLayoutParams(layoutParams);
        }
    }

    public void pS() {
        aw.h(this.bGh, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bGi, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bGj, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bGl, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bGm, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public void Hu() {
        v aap = this.bEE.aap();
        UserData userData = aap.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.c personPrivate = userData.getPersonPrivate();
            PersonTainInfo aaS = aap.aaS();
            int qU = personPrivate != null ? personPrivate.qU() : 1;
            int isFriend = aaS != null ? aaS.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, aap);
            } else if (qU == 1 || (qU == 2 && isFriend == 1)) {
                a(userData, aap);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGj.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bGj.setLayoutParams(layoutParams);
                this.bGi.setText("");
                this.bGi.setTextSize(0.0f);
                aw.h((View) this.bGi, com.baidu.tieba.u.icon_mycenter_lock);
                this.bGl.setVisibility(0);
                this.bGl.setText(com.baidu.tieba.y.set_private);
                this.bGk.setVisibility(8);
                this.bGm.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String bB = ay.bB(userData.getPosts_num());
        this.bGi.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
        if (bB.contains("w") && bB.length() > 3) {
            this.bGi.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
        }
        this.bGi.setBackgroundDrawable(null);
        this.bGi.setText(bB);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGj.getLayoutParams();
        layoutParams.topMargin = -this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
        this.bGj.setLayoutParams(layoutParams);
        List<PersonInfoPostList> aaR = vVar.aaR();
        if (aaR == null || aaR.size() <= 0) {
            this.bGk.setVisibility(8);
            this.bGm.setVisibility(8);
            this.bGl.setVisibility(0);
            this.bGl.setText(com.baidu.tieba.y.no_post_tip);
            return;
        }
        this.bGk.setVisibility(0);
        this.bGm.setVisibility(0);
        this.bGl.setVisibility(8);
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        this.bGk.removeAllViews();
        int size = aaR.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = aaR.get(i2);
            View inflate = ek.inflate(this.bEE, com.baidu.tieba.w.personinfo_post_item, null);
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
                layoutParams2.topMargin = this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
            }
            this.bGk.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout aaF() {
        return this.bGh;
    }

    public View getRootView() {
        return this.HS;
    }
}

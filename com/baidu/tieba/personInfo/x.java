package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private ImageView aZP;
    private PersonInfoActivity bJZ;
    private RelativeLayout bLB;
    private TextView bLC;
    private TextView bLD;
    private LinearLayout bLE;
    private TextView bLF;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bLB = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_ll);
        this.bLB.setOnClickListener(this.bJZ);
        this.bLC = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num);
        this.bLD = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num_text);
        this.bLE = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_info_ll);
        this.bLF = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_post_tip);
        this.aZP = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow);
        kE();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLB.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bLB.setLayoutParams(layoutParams);
        }
    }

    public void kE() {
        bc.i(this.bLB, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bLC, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bLD, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bLF, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.aZP, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abI() {
        v abq = this.bJZ.abq();
        UserData userData = abq.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo abV = abq.abV();
            int uP = personPrivate != null ? personPrivate.uP() : 1;
            int isFriend = abV != null ? abV.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, abq);
            } else if (uP == 1 || (uP == 2 && isFriend == 1)) {
                a(userData, abq);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLD.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bLD.setLayoutParams(layoutParams);
                this.bLC.setText("");
                this.bLC.setTextSize(0.0f);
                bc.i((View) this.bLC, com.baidu.tieba.v.icon_mycenter_lock);
                this.bLF.setVisibility(0);
                this.bLF.setText(com.baidu.tieba.z.set_private);
                this.bLE.setVisibility(8);
                this.aZP.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String cf = bf.cf(userData.getPosts_num());
        this.bLC.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
        if (cf.contains("w") && cf.length() > 3) {
            this.bLC.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
        }
        this.bLC.setBackgroundDrawable(null);
        this.bLC.setText(cf);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLD.getLayoutParams();
        layoutParams.topMargin = -this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
        this.bLD.setLayoutParams(layoutParams);
        List<PersonInfoPostList> abU = vVar.abU();
        if (abU == null || abU.size() <= 0) {
            this.bLE.setVisibility(8);
            this.aZP.setVisibility(8);
            this.bLF.setVisibility(0);
            this.bLF.setText(com.baidu.tieba.z.no_post_tip);
            return;
        }
        this.bLE.setVisibility(0);
        this.aZP.setVisibility(0);
        this.bLF.setVisibility(8);
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        this.bLE.removeAllViews();
        int size = abU.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = abU.get(i2);
            View inflate = ei.inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.w.line);
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView2, com.baidu.tieba.t.cp_cont_f, 1);
            bc.j(findViewById, com.baidu.tieba.t.cp_bg_line_b);
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
                layoutParams2.topMargin = this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
            }
            this.bLE.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout abG() {
        return this.bLB;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

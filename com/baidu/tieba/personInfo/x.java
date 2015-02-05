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
    private ImageView aZO;
    private PersonInfoActivity bJY;
    private RelativeLayout bLA;
    private TextView bLB;
    private TextView bLC;
    private LinearLayout bLD;
    private TextView bLE;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bLA = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_ll);
        this.bLA.setOnClickListener(this.bJY);
        this.bLB = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num);
        this.bLC = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num_text);
        this.bLD = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_info_ll);
        this.bLE = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_post_tip);
        this.aZO = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow);
        kx();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bLA.setLayoutParams(layoutParams);
        }
    }

    public void kx() {
        bc.i(this.bLA, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bLB, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bLC, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bLE, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.aZO, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abD() {
        v abl = this.bJY.abl();
        UserData userData = abl.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo abQ = abl.abQ();
            int uJ = personPrivate != null ? personPrivate.uJ() : 1;
            int isFriend = abQ != null ? abQ.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, abl);
            } else if (uJ == 1 || (uJ == 2 && isFriend == 1)) {
                a(userData, abl);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLC.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bLC.setLayoutParams(layoutParams);
                this.bLB.setText("");
                this.bLB.setTextSize(0.0f);
                bc.i((View) this.bLB, com.baidu.tieba.v.icon_mycenter_lock);
                this.bLE.setVisibility(0);
                this.bLE.setText(com.baidu.tieba.z.set_private);
                this.bLD.setVisibility(8);
                this.aZO.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String cf = bf.cf(userData.getPosts_num());
        this.bLB.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
        if (cf.contains("w") && cf.length() > 3) {
            this.bLB.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
        }
        this.bLB.setBackgroundDrawable(null);
        this.bLB.setText(cf);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLC.getLayoutParams();
        layoutParams.topMargin = -this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
        this.bLC.setLayoutParams(layoutParams);
        List<PersonInfoPostList> abP = vVar.abP();
        if (abP == null || abP.size() <= 0) {
            this.bLD.setVisibility(8);
            this.aZO.setVisibility(8);
            this.bLE.setVisibility(0);
            this.bLE.setText(com.baidu.tieba.z.no_post_tip);
            return;
        }
        this.bLD.setVisibility(0);
        this.aZO.setVisibility(0);
        this.bLE.setVisibility(8);
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        this.bLD.removeAllViews();
        int size = abP.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = abP.get(i2);
            View inflate = ei.inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_item, null);
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
                layoutParams2.topMargin = this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
            }
            this.bLD.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout abB() {
        return this.bLA;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

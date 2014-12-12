package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private ImageView aYt;
    private PersonInfoActivity bIn;
    private RelativeLayout bJQ;
    private TextView bJR;
    private TextView bJS;
    private LinearLayout bJT;
    private TextView bJU;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bJQ = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_ll);
        this.bJQ.setOnClickListener(this.bIn);
        this.bJR = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num);
        this.bJS = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.post_num_text);
        this.bJT = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.post_info_ll);
        this.bJU = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_post_tip);
        this.aYt = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow);
        kE();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJQ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bJQ.setLayoutParams(layoutParams);
        }
    }

    public void kE() {
        ax.i(this.bJQ, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bJR, com.baidu.tieba.t.cp_cont_f, 1);
        ax.b(this.bJS, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bJU, com.baidu.tieba.t.cp_cont_e, 1);
        ax.i(this.aYt, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public void abe() {
        v aaL = this.bIn.aaL();
        UserData userData = aaL.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo abr = aaL.abr();
            int uy = personPrivate != null ? personPrivate.uy() : 1;
            int isFriend = abr != null ? abr.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, aaL);
            } else if (uy == 1 || (uy == 2 && isFriend == 1)) {
                a(userData, aaL);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJS.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bJS.setLayoutParams(layoutParams);
                this.bJR.setText("");
                this.bJR.setTextSize(0.0f);
                ax.i((View) this.bJR, com.baidu.tieba.v.icon_mycenter_lock);
                this.bJU.setVisibility(0);
                this.bJU.setText(com.baidu.tieba.z.set_private);
                this.bJT.setVisibility(8);
                this.aYt.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String bY = ba.bY(userData.getPosts_num());
        this.bJR.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds72));
        if (bY.contains("w") && bY.length() > 3) {
            this.bJR.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
        }
        this.bJR.setBackgroundDrawable(null);
        this.bJR.setText(bY);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJS.getLayoutParams();
        layoutParams.topMargin = -this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10);
        this.bJS.setLayoutParams(layoutParams);
        List<PersonInfoPostList> abq = vVar.abq();
        if (abq == null || abq.size() <= 0) {
            this.bJT.setVisibility(8);
            this.aYt.setVisibility(8);
            this.bJU.setVisibility(0);
            this.bJU.setText(com.baidu.tieba.z.no_post_tip);
            return;
        }
        this.bJT.setVisibility(0);
        this.aYt.setVisibility(0);
        this.bJU.setVisibility(8);
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        this.bJT.removeAllViews();
        int size = abq.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = abq.get(i2);
            View inflate = ek.inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.w.line);
            ax.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            ax.b(textView2, com.baidu.tieba.t.cp_cont_f, 1);
            ax.j(findViewById, com.baidu.tieba.t.cp_bg_line_b);
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
                layoutParams2.topMargin = this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26);
            }
            this.bJT.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout abc() {
        return this.bJQ;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

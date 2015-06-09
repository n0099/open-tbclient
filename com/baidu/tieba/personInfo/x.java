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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private int ajy = -1;
    private PersonInfoActivity bVg;
    private RelativeLayout bWI;
    private TextView bWJ;
    private TextView bWK;
    private LinearLayout bWL;
    private TextView bWM;
    private ImageView buy;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bWI = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.post_ll);
        this.bWI.setOnClickListener(this.bVg);
        this.bWJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.post_num);
        this.bWK = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.post_num_text);
        this.bWL = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.post_info_ll);
        this.bWM = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_post_tip);
        this.buy = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow);
        oG();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bWI.setLayoutParams(layoutParams);
        }
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.i(this.bWI, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bWJ, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bWK, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bWM, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.buy, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afm() {
        oG();
        v aeU = this.bVg.aeU();
        UserData userData = aeU.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo afy = aeU.afy();
            int yT = personPrivate != null ? personPrivate.yT() : 1;
            int isFriend = afy != null ? afy.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, aeU);
            } else if (yT == 1 || (yT == 2 && isFriend == 1)) {
                a(userData, aeU);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWK.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bWK.setLayoutParams(layoutParams);
                this.bWJ.setText("");
                this.bWJ.setTextSize(0.0f);
                this.bWJ.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bWM.setVisibility(0);
                this.bWM.setText(com.baidu.tieba.t.set_private);
                this.bWL.setVisibility(8);
                this.buy.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String cl = bb.cl(userData.getPosts_num());
        this.bWJ.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
        if (cl.contains("w") && cl.length() > 3) {
            this.bWJ.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
        }
        this.bWJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bWJ.setText(cl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWK.getLayoutParams();
        layoutParams.topMargin = -this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
        this.bWK.setLayoutParams(layoutParams);
        List<PersonInfoPostList> afx = vVar.afx();
        if (afx == null || afx.size() <= 0) {
            this.bWL.setVisibility(8);
            this.buy.setVisibility(8);
            this.bWM.setVisibility(0);
            this.bWM.setText(com.baidu.tieba.t.no_post_tip);
            return;
        }
        this.bWL.setVisibility(0);
        this.buy.setVisibility(0);
        this.bWM.setVisibility(8);
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        this.bWL.removeAllViews();
        int size = afx.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = afx.get(i2);
            View inflate = hr.inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.q.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.q.line);
            ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView2, com.baidu.tieba.n.cp_cont_f, 1);
            ay.j(findViewById, com.baidu.tieba.n.cp_bg_line_b);
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
                layoutParams2.topMargin = this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds26);
            }
            this.bWL.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout afk() {
        return this.bWI;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

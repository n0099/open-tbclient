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
    private PersonInfoActivity bVf;
    private RelativeLayout bWH;
    private TextView bWI;
    private TextView bWJ;
    private LinearLayout bWK;
    private TextView bWL;
    private ImageView bux;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bWH = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.post_ll);
        this.bWH.setOnClickListener(this.bVf);
        this.bWI = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.post_num);
        this.bWJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.post_num_text);
        this.bWK = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.post_info_ll);
        this.bWL = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_post_tip);
        this.bux = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow);
        oG();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWH.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bWH.setLayoutParams(layoutParams);
        }
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.i(this.bWH, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bWI, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bWJ, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bWL, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bux, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public void afl() {
        oG();
        v aeT = this.bVf.aeT();
        UserData userData = aeT.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo afx = aeT.afx();
            int yS = personPrivate != null ? personPrivate.yS() : 1;
            int isFriend = afx != null ? afx.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, aeT);
            } else if (yS == 1 || (yS == 2 && isFriend == 1)) {
                a(userData, aeT);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWJ.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bWJ.setLayoutParams(layoutParams);
                this.bWI.setText("");
                this.bWI.setTextSize(0.0f);
                this.bWI.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bWL.setVisibility(0);
                this.bWL.setText(com.baidu.tieba.t.set_private);
                this.bWK.setVisibility(8);
                this.bux.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String cl = bb.cl(userData.getPosts_num());
        this.bWI.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds72));
        if (cl.contains("w") && cl.length() > 3) {
            this.bWI.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
        }
        this.bWI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bWI.setText(cl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWJ.getLayoutParams();
        layoutParams.topMargin = -this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10);
        this.bWJ.setLayoutParams(layoutParams);
        List<PersonInfoPostList> afw = vVar.afw();
        if (afw == null || afw.size() <= 0) {
            this.bWK.setVisibility(8);
            this.bux.setVisibility(8);
            this.bWL.setVisibility(0);
            this.bWL.setText(com.baidu.tieba.t.no_post_tip);
            return;
        }
        this.bWK.setVisibility(0);
        this.bux.setVisibility(0);
        this.bWL.setVisibility(8);
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        this.bWK.removeAllViews();
        int size = afw.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = afw.get(i2);
            View inflate = hr.inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_post_item, null);
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
                layoutParams2.topMargin = this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds26);
            }
            this.bWK.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout afj() {
        return this.bWH;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

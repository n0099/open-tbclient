package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private int arr = -1;
    private ImageView bIV;
    private PersonInfoActivity ckP;
    private RelativeLayout cof;
    private TextView cog;
    private TextView coh;
    private LinearLayout coi;
    private TextView coj;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cof = (RelativeLayout) this.mRootView.findViewById(i.f.post_ll);
        this.cof.setOnClickListener(this.ckP);
        this.cog = (TextView) this.mRootView.findViewById(i.f.post_num);
        this.coh = (TextView) this.mRootView.findViewById(i.f.post_num_text);
        this.coi = (LinearLayout) this.mRootView.findViewById(i.f.post_info_ll);
        this.coj = (TextView) this.mRootView.findViewById(i.f.no_post_tip);
        this.bIV = (ImageView) this.mRootView.findViewById(i.f.arrow);
        oN();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cof.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.cof.setLayoutParams(layoutParams);
        }
    }

    public void oN() {
        if (this.arr != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arr = TbadkCoreApplication.m411getInst().getSkinType();
            al.h(this.cof, i.e.personinfo_select_bg);
            al.b(this.cog, i.c.cp_cont_f, 1);
            al.b(this.coh, i.c.cp_cont_d, 1);
            al.b(this.coj, i.c.cp_cont_e, 1);
            al.h(this.bIV, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahA() {
        oN();
        w ahd = this.ckP.ahd();
        UserData userData = ahd.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            PersonTainInfo ahM = ahd.ahM();
            int Aq = personPrivate != null ? personPrivate.Aq() : 1;
            int isFriend = ahM != null ? ahM.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, ahd);
            } else if (Aq == 1 || (Aq == 2 && isFriend == 1)) {
                a(userData, ahd);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coh.getLayoutParams();
                layoutParams.topMargin = 0;
                this.coh.setLayoutParams(layoutParams);
                this.cog.setText("");
                this.cog.setTextSize(0.0f);
                this.cog.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.coj.setVisibility(0);
                this.coj.setText(i.h.set_private);
                this.coi.setVisibility(8);
                this.bIV.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, w wVar) {
        String cy = aq.cy(userData.getPosts_num());
        this.cog.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds72));
        if (cy.contains("w") && cy.length() > 3) {
            this.cog.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds48));
        }
        this.cog.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.cog.setText(cy);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coh.getLayoutParams();
        layoutParams.topMargin = -this.ckP.getResources().getDimensionPixelSize(i.d.ds10);
        this.coh.setLayoutParams(layoutParams);
        List<PersonInfoPostList> postList = wVar.getPostList();
        if (postList == null || postList.size() <= 0) {
            this.coi.setVisibility(8);
            this.bIV.setVisibility(8);
            this.coj.setVisibility(0);
            this.coj.setText(i.h.no_post_tip);
            return;
        }
        this.coi.setVisibility(0);
        this.bIV.setVisibility(0);
        this.coj.setVisibility(8);
        this.coi.removeAllViews();
        int size = postList.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = postList.get(i2);
            View inflate = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.post_title);
            TextView textView2 = (TextView) inflate.findViewById(i.f.post_content);
            View findViewById = inflate.findViewById(i.f.line);
            al.b(textView, i.c.cp_cont_b, 1);
            al.b(textView2, i.c.cp_cont_f, 1);
            al.i(findViewById, i.c.cp_bg_line_b);
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
                layoutParams2.topMargin = this.ckP.getResources().getDimensionPixelSize(i.d.ds26);
            }
            this.coi.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout ahy() {
        return this.cof;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

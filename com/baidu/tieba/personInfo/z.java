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
    private int apH = -1;
    private ImageView bIo;
    private PersonInfoActivity cjU;
    private RelativeLayout cnd;
    private TextView cne;
    private TextView cnf;
    private LinearLayout cng;
    private TextView cnh;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cnd = (RelativeLayout) this.mRootView.findViewById(i.f.post_ll);
        this.cnd.setOnClickListener(this.cjU);
        this.cne = (TextView) this.mRootView.findViewById(i.f.post_num);
        this.cnf = (TextView) this.mRootView.findViewById(i.f.post_num_text);
        this.cng = (LinearLayout) this.mRootView.findViewById(i.f.post_info_ll);
        this.cnh = (TextView) this.mRootView.findViewById(i.f.no_post_tip);
        this.bIo = (ImageView) this.mRootView.findViewById(i.f.arrow);
        oQ();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnd.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.cnd.setLayoutParams(layoutParams);
        }
    }

    public void oQ() {
        if (this.apH != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apH = TbadkCoreApplication.m411getInst().getSkinType();
            al.i(this.cnd, i.e.personinfo_select_bg);
            al.b(this.cne, i.c.cp_cont_f, 1);
            al.b(this.cnf, i.c.cp_cont_d, 1);
            al.b(this.cnh, i.c.cp_cont_e, 1);
            al.i(this.bIo, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ahi() {
        oQ();
        w agL = this.cjU.agL();
        UserData userData = agL.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.g personPrivate = userData.getPersonPrivate();
            PersonTainInfo ahu = agL.ahu();
            int Ad = personPrivate != null ? personPrivate.Ad() : 1;
            int isFriend = ahu != null ? ahu.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, agL);
            } else if (Ad == 1 || (Ad == 2 && isFriend == 1)) {
                a(userData, agL);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnf.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cnf.setLayoutParams(layoutParams);
                this.cne.setText("");
                this.cne.setTextSize(0.0f);
                this.cne.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cnh.setVisibility(0);
                this.cnh.setText(i.C0057i.set_private);
                this.cng.setVisibility(8);
                this.bIo.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, w wVar) {
        String ct = aq.ct(userData.getPosts_num());
        this.cne.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds72));
        if (ct.contains("w") && ct.length() > 3) {
            this.cne.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds48));
        }
        this.cne.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.cne.setText(ct);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnf.getLayoutParams();
        layoutParams.topMargin = -this.cjU.getResources().getDimensionPixelSize(i.d.ds10);
        this.cnf.setLayoutParams(layoutParams);
        List<PersonInfoPostList> postList = wVar.getPostList();
        if (postList == null || postList.size() <= 0) {
            this.cng.setVisibility(8);
            this.bIo.setVisibility(8);
            this.cnh.setVisibility(0);
            this.cnh.setText(i.C0057i.no_post_tip);
            return;
        }
        this.cng.setVisibility(0);
        this.bIo.setVisibility(0);
        this.cnh.setVisibility(8);
        this.cng.removeAllViews();
        int size = postList.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = postList.get(i2);
            View inflate = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.post_title);
            TextView textView2 = (TextView) inflate.findViewById(i.f.post_content);
            View findViewById = inflate.findViewById(i.f.line);
            al.b(textView, i.c.cp_cont_b, 1);
            al.b(textView2, i.c.cp_cont_f, 1);
            al.j(findViewById, i.c.cp_bg_line_b);
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
                layoutParams2.topMargin = this.cjU.getResources().getDimensionPixelSize(i.d.ds26);
            }
            this.cng.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout ahg() {
        return this.cnd;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes.dex */
public class ab {
    private int arf = -1;
    private ImageView bMG;
    private PersonInfoActivity csa;
    private RelativeLayout cvt;
    private TextView cvu;
    private TextView cvv;
    private LinearLayout cvw;
    private TextView cvx;
    private boolean mIsHost;
    private View mRootView;

    public ab(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cvt = (RelativeLayout) this.mRootView.findViewById(i.f.post_ll);
        this.cvt.setOnClickListener(this.csa);
        this.cvu = (TextView) this.mRootView.findViewById(i.f.post_num);
        this.cvv = (TextView) this.mRootView.findViewById(i.f.post_num_text);
        this.cvw = (LinearLayout) this.mRootView.findViewById(i.f.post_info_ll);
        this.cvx = (TextView) this.mRootView.findViewById(i.f.no_post_tip);
        this.bMG = (ImageView) this.mRootView.findViewById(i.f.arrow);
        oP();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvt.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.cvt.setLayoutParams(layoutParams);
        }
    }

    public void oP() {
        if (this.arf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
            an.i(this.cvt, i.e.personinfo_select_bg);
            an.b(this.cvu, i.c.cp_cont_f, 1);
            an.b(this.cvv, i.c.cp_cont_d, 1);
            an.b(this.cvx, i.c.cp_cont_e, 1);
            an.i(this.bMG, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void c(AntiData antiData) {
        oP();
        y ajH = this.csa.ajH();
        UserData userData = ajH.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            PersonTainInfo akp = ajH.akp();
            int Ad = personPrivate != null ? personPrivate.Ad() : 1;
            int isFriend = akp != null ? akp.getIsFriend() : 1;
            if (this.mIsHost) {
                if (antiData != null && (AntiHelper.e(antiData) || AntiHelper.g(antiData))) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvt.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.d(this.csa.getPageContext().getPageActivity(), i.d.ds156);
                    this.cvt.setLayoutParams(layoutParams);
                }
                a(userData, ajH);
            } else if (Ad == 1 || (Ad == 2 && isFriend == 1)) {
                a(userData, ajH);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cvv.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.cvv.setLayoutParams(layoutParams2);
                this.cvu.setText("");
                this.cvu.setTextSize(0.0f);
                this.cvu.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cvx.setVisibility(0);
                this.cvx.setText(i.h.set_private);
                this.cvw.setVisibility(8);
                this.bMG.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, y yVar) {
        String cA = as.cA(userData.getPosts_num());
        this.cvu.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds72));
        if (cA.contains("w") && cA.length() > 3) {
            this.cvu.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds48));
        }
        this.cvu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.cvu.setText(cA);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvv.getLayoutParams();
        layoutParams.topMargin = -this.csa.getResources().getDimensionPixelSize(i.d.ds10);
        this.cvv.setLayoutParams(layoutParams);
        List<PersonInfoPostList> postList = yVar.getPostList();
        if (postList == null || postList.size() <= 0) {
            this.cvw.setVisibility(8);
            this.bMG.setVisibility(8);
            this.cvx.setVisibility(0);
            this.cvx.setText(i.h.no_post_tip);
            return;
        }
        this.cvw.setVisibility(0);
        this.bMG.setVisibility(0);
        this.cvx.setVisibility(8);
        this.cvw.removeAllViews();
        int size = postList.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = postList.get(i2);
            View inflate = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.post_title);
            TextView textView2 = (TextView) inflate.findViewById(i.f.post_content);
            View findViewById = inflate.findViewById(i.f.line);
            an.b(textView, i.c.cp_cont_b, 1);
            an.b(textView2, i.c.cp_cont_f, 1);
            an.j(findViewById, i.c.cp_bg_line_b);
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
                layoutParams2.topMargin = this.csa.getResources().getDimensionPixelSize(i.d.ds26);
            }
            this.cvw.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout akc() {
        return this.cvt;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

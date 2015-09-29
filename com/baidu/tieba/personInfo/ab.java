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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes.dex */
public class ab {
    private int apR = -1;
    private ImageView bMa;
    private PersonInfoActivity cqt;
    private RelativeLayout ctM;
    private TextView ctN;
    private TextView ctO;
    private LinearLayout ctP;
    private TextView ctQ;
    private boolean mIsHost;
    private View mRootView;

    public ab(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.ctM = (RelativeLayout) this.mRootView.findViewById(i.f.post_ll);
        this.ctM.setOnClickListener(this.cqt);
        this.ctN = (TextView) this.mRootView.findViewById(i.f.post_num);
        this.ctO = (TextView) this.mRootView.findViewById(i.f.post_num_text);
        this.ctP = (LinearLayout) this.mRootView.findViewById(i.f.post_info_ll);
        this.ctQ = (TextView) this.mRootView.findViewById(i.f.no_post_tip);
        this.bMa = (ImageView) this.mRootView.findViewById(i.f.arrow);
        oO();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctM.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.ctM.setLayoutParams(layoutParams);
        }
    }

    public void oO() {
        if (this.apR != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
            am.i(this.ctM, i.e.personinfo_select_bg);
            am.b(this.ctN, i.c.cp_cont_f, 1);
            am.b(this.ctO, i.c.cp_cont_d, 1);
            am.b(this.ctQ, i.c.cp_cont_e, 1);
            am.i(this.bMa, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void c(AntiData antiData) {
        oO();
        y ajf = this.cqt.ajf();
        UserData userData = ajf.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            PersonTainInfo ajN = ajf.ajN();
            int Ab = personPrivate != null ? personPrivate.Ab() : 1;
            int isFriend = ajN != null ? ajN.getIsFriend() : 1;
            if (this.mIsHost) {
                if (antiData != null && (AntiHelper.e(antiData) || AntiHelper.g(antiData))) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctM.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.d(this.cqt.getPageContext().getPageActivity(), i.d.ds156);
                    this.ctM.setLayoutParams(layoutParams);
                }
                a(userData, ajf);
            } else if (Ab == 1 || (Ab == 2 && isFriend == 1)) {
                a(userData, ajf);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ctO.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.ctO.setLayoutParams(layoutParams2);
                this.ctN.setText("");
                this.ctN.setTextSize(0.0f);
                this.ctN.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.ctQ.setVisibility(0);
                this.ctQ.setText(i.h.set_private);
                this.ctP.setVisibility(8);
                this.bMa.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, y yVar) {
        String cA = ar.cA(userData.getPosts_num());
        this.ctN.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds72));
        if (cA.contains("w") && cA.length() > 3) {
            this.ctN.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds48));
        }
        this.ctN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ctN.setText(cA);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctO.getLayoutParams();
        layoutParams.topMargin = -this.cqt.getResources().getDimensionPixelSize(i.d.ds10);
        this.ctO.setLayoutParams(layoutParams);
        List<PersonInfoPostList> postList = yVar.getPostList();
        if (postList == null || postList.size() <= 0) {
            this.ctP.setVisibility(8);
            this.bMa.setVisibility(8);
            this.ctQ.setVisibility(0);
            this.ctQ.setText(i.h.no_post_tip);
            return;
        }
        this.ctP.setVisibility(0);
        this.bMa.setVisibility(0);
        this.ctQ.setVisibility(8);
        this.ctP.removeAllViews();
        int size = postList.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = postList.get(i2);
            View inflate = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.post_title);
            TextView textView2 = (TextView) inflate.findViewById(i.f.post_content);
            View findViewById = inflate.findViewById(i.f.line);
            am.b(textView, i.c.cp_cont_b, 1);
            am.b(textView2, i.c.cp_cont_f, 1);
            am.j(findViewById, i.c.cp_bg_line_b);
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
                layoutParams2.topMargin = this.cqt.getResources().getDimensionPixelSize(i.d.ds26);
            }
            this.ctP.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout ajA() {
        return this.ctM;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

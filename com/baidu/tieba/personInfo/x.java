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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private int aiq = -1;
    private PersonInfoActivity bSi;
    private RelativeLayout bTK;
    private TextView bTL;
    private TextView bTM;
    private LinearLayout bTN;
    private TextView bTO;
    private ImageView brv;
    private boolean mIsHost;
    private View mRootView;

    public x(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_post_view, null);
        initView();
    }

    private void initView() {
        this.bTK = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.post_ll);
        this.bTK.setOnClickListener(this.bSi);
        this.bTL = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.post_num);
        this.bTM = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.post_num_text);
        this.bTN = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.post_info_ll);
        this.bTO = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_post_tip);
        this.brv = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow);
        oq();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.bTK.setLayoutParams(layoutParams);
        }
    }

    public void oq() {
        if (this.aiq != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
            ba.i(this.bTK, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTL, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bTM, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bTO, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.brv, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public void adR() {
        oq();
        v ady = this.bSi.ady();
        UserData userData = ady.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.h personPrivate = userData.getPersonPrivate();
            PersonTainInfo aed = ady.aed();
            int xZ = personPrivate != null ? personPrivate.xZ() : 1;
            int isFriend = aed != null ? aed.getIsFriend() : 1;
            if (this.mIsHost) {
                a(userData, ady);
            } else if (xZ == 1 || (xZ == 2 && isFriend == 1)) {
                a(userData, ady);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTM.getLayoutParams();
                layoutParams.topMargin = 0;
                this.bTM.setLayoutParams(layoutParams);
                this.bTL.setText("");
                this.bTL.setTextSize(0.0f);
                this.bTL.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.bTO.setVisibility(0);
                this.bTO.setText(com.baidu.tieba.y.set_private);
                this.bTN.setVisibility(8);
                this.brv.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, v vVar) {
        String ch = bd.ch(userData.getPosts_num());
        this.bTL.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds72));
        if (ch.contains("w") && ch.length() > 3) {
            this.bTL.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
        }
        this.bTL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bTL.setText(ch);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTM.getLayoutParams();
        layoutParams.topMargin = -this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10);
        this.bTM.setLayoutParams(layoutParams);
        List<PersonInfoPostList> aec = vVar.aec();
        if (aec == null || aec.size() <= 0) {
            this.bTN.setVisibility(8);
            this.brv.setVisibility(8);
            this.bTO.setVisibility(0);
            this.bTO.setText(com.baidu.tieba.y.no_post_tip);
            return;
        }
        this.bTN.setVisibility(0);
        this.brv.setVisibility(0);
        this.bTO.setVisibility(8);
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        this.bTN.removeAllViews();
        int size = aec.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = aec.get(i2);
            View inflate = hH.inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_post_item, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.post_title);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.post_content);
            View findViewById = inflate.findViewById(com.baidu.tieba.v.line);
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView2, com.baidu.tieba.s.cp_cont_f, 1);
            ba.j(findViewById, com.baidu.tieba.s.cp_bg_line_b);
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
                layoutParams2.topMargin = this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
            }
            this.bTN.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout adP() {
        return this.bTK;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

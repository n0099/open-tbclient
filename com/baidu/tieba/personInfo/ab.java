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
    private int apS = -1;
    private ImageView bMl;
    private PersonInfoActivity cqE;
    private RelativeLayout ctX;
    private TextView ctY;
    private TextView ctZ;
    private LinearLayout cua;
    private TextView cub;
    private boolean mIsHost;
    private View mRootView;

    public ab(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.ctX = (RelativeLayout) this.mRootView.findViewById(i.f.post_ll);
        this.ctX.setOnClickListener(this.cqE);
        this.ctY = (TextView) this.mRootView.findViewById(i.f.post_num);
        this.ctZ = (TextView) this.mRootView.findViewById(i.f.post_num_text);
        this.cua = (LinearLayout) this.mRootView.findViewById(i.f.post_info_ll);
        this.cub = (TextView) this.mRootView.findViewById(i.f.no_post_tip);
        this.bMl = (ImageView) this.mRootView.findViewById(i.f.arrow);
        oO();
        if (this.mIsHost) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.ctX.setLayoutParams(layoutParams);
        }
    }

    public void oO() {
        if (this.apS != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
            an.i(this.ctX, i.e.personinfo_select_bg);
            an.b(this.ctY, i.c.cp_cont_f, 1);
            an.b(this.ctZ, i.c.cp_cont_d, 1);
            an.b(this.cub, i.c.cp_cont_e, 1);
            an.i(this.bMl, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void c(AntiData antiData) {
        oO();
        y ajb = this.cqE.ajb();
        UserData userData = ajb.getUserData();
        if (userData != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            PersonTainInfo ajJ = ajb.ajJ();
            int zY = personPrivate != null ? personPrivate.zY() : 1;
            int isFriend = ajJ != null ? ajJ.getIsFriend() : 1;
            if (this.mIsHost) {
                if (antiData != null && (AntiHelper.e(antiData) || AntiHelper.g(antiData))) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctX.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.d(this.cqE.getPageContext().getPageActivity(), i.d.ds156);
                    this.ctX.setLayoutParams(layoutParams);
                }
                a(userData, ajb);
            } else if (zY == 1 || (zY == 2 && isFriend == 1)) {
                a(userData, ajb);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ctZ.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.ctZ.setLayoutParams(layoutParams2);
                this.ctY.setText("");
                this.ctY.setTextSize(0.0f);
                this.ctY.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cub.setVisibility(0);
                this.cub.setText(i.h.set_private);
                this.cua.setVisibility(8);
                this.bMl.setVisibility(8);
            }
        }
    }

    private void a(UserData userData, y yVar) {
        String cA = as.cA(userData.getPosts_num());
        this.ctY.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds72));
        if (cA.contains("w") && cA.length() > 3) {
            this.ctY.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds48));
        }
        this.ctY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ctY.setText(cA);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctZ.getLayoutParams();
        layoutParams.topMargin = -this.cqE.getResources().getDimensionPixelSize(i.d.ds10);
        this.ctZ.setLayoutParams(layoutParams);
        List<PersonInfoPostList> postList = yVar.getPostList();
        if (postList == null || postList.size() <= 0) {
            this.cua.setVisibility(8);
            this.bMl.setVisibility(8);
            this.cub.setVisibility(0);
            this.cub.setText(i.h.no_post_tip);
            return;
        }
        this.cua.setVisibility(0);
        this.bMl.setVisibility(0);
        this.cub.setVisibility(8);
        this.cua.removeAllViews();
        int size = postList.size();
        int i = size > 3 ? 3 : size;
        for (int i2 = 0; i2 < i; i2++) {
            PersonInfoPostList personInfoPostList = postList.get(i2);
            View inflate = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_post_item, (ViewGroup) null);
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
                layoutParams2.topMargin = this.cqE.getResources().getDimensionPixelSize(i.d.ds26);
            }
            this.cua.addView(inflate, layoutParams2);
        }
    }

    public RelativeLayout ajw() {
        return this.ctX;
    }

    public View getRootView() {
        return this.mRootView;
    }
}

package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes18.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean isBJH;
    private boolean kZg;

    public BlueLikeButton(Context context) {
        super(context);
        this.kZg = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kZg = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kZg = false;
        this.isBJH = false;
    }

    public void setBJH(boolean z) {
        this.isBJH = z;
    }

    public void aN(boolean z) {
        this.kZg = z;
        if (z) {
            if (this.isBJH) {
                setText(R.string.followed);
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).of(R.color.cp_bg_line_c).aZ(this);
                ap.setViewTextColor(this, R.color.cp_cont_b, 1);
                return;
            }
            setText(R.string.followed);
            setBackgroundDrawable(ap.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.cp_cont_e, 1);
        } else if (this.isBJH) {
            setText(R.string.attention);
            com.baidu.tbadk.core.util.e.a.c(com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).ol(1).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b, R.color.cp_link_tip_a).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).ol(1).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).bjT()).aZ(this);
            ap.setViewTextColor(this, R.color.cp_cont_a, 1);
        } else {
            setText(R.string.attention);
            setBackgroundDrawable(ap.getDrawable(R.drawable.selector_like_button_bg));
            setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.cp_cont_g, 1);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void pk(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bk(View view) {
        if (!this.isBJH) {
            TiebaStatic.log(new aq("c12503").dD("obj_locate", "4"));
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c12507");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 2);
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (!this.kZg) {
                Context context = getContext();
                if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                    String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                    List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                    if (currentPageSourceKeyList != null && at.equals((String) y.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !at.isEmpty(stringExtra)) {
                        TiebaStatic.log(new aq("c12613").ai("obj_type", 1).dD("tid", stringExtra));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }
}

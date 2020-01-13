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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean iZZ;
    private boolean isBJH;

    public BlueLikeButton(Context context) {
        super(context);
        this.iZZ = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZZ = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZZ = false;
        this.isBJH = false;
    }

    public void setBJH(boolean z) {
        this.isBJH = z;
    }

    public void fN(boolean z) {
        this.iZZ = z;
        if (z) {
            if (this.isBJH) {
                setText(R.string.followed);
                com.baidu.tbadk.core.util.f.a.aEM().kk(0).kr(1).ag(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).kl(R.color.cp_bg_line_c).aQ(this);
                am.setViewTextColor(this, R.color.cp_cont_b, 1);
                return;
            }
            setText(R.string.followed);
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, R.color.cp_cont_e, 1);
        } else if (this.isBJH) {
            setText(R.string.attention);
            com.baidu.tbadk.core.util.f.a.c(com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).kr(1).ag(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b, R.color.cp_link_tip_a).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).kr(1).ag(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).aEP()).aQ(this);
            am.setViewTextColor(this, R.color.cp_cont_a, 1);
        } else {
            setText(R.string.attention);
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_bg));
            setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, R.color.cp_cont_g, 1);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void l(boolean z, int i) {
        fN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        l(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ba(View view) {
        if (!this.isBJH) {
            TiebaStatic.log(new an("c12503").cp("obj_locate", "4"));
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c12507");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.Z("obj_locate", 2);
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (!this.iZZ) {
                Context context = getContext();
                if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                    String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                    List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                    if (currentPageSourceKeyList != null && aq.equals((String) v.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !aq.isEmpty(stringExtra)) {
                        TiebaStatic.log(new an("c12613").Z("obj_type", 1).cp("tid", stringExtra));
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

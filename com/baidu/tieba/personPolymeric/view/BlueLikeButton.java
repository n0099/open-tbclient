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
/* loaded from: classes11.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean isBJH;
    private boolean kfv;

    public BlueLikeButton(Context context) {
        super(context);
        this.kfv = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kfv = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kfv = false;
        this.isBJH = false;
    }

    public void setBJH(boolean z) {
        this.isBJH = z;
    }

    public void hr(boolean z) {
        this.kfv = z;
        if (z) {
            if (this.isBJH) {
                setText(R.string.followed);
                com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).O(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).lo(R.color.cp_bg_line_c).aR(this);
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
            com.baidu.tbadk.core.util.e.a.c(com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).lu(1).O(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b, R.color.cp_link_tip_a).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).lu(1).O(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).aVB()).aR(this);
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
    public void r(boolean z, int i) {
        hr(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mo(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (!this.isBJH) {
            TiebaStatic.log(new an("c12503").dh("obj_locate", "4"));
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c12507");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.ag("obj_locate", 2);
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (!this.kfv) {
                Context context = getContext();
                if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                    String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                    List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                    if (currentPageSourceKeyList != null && aq.equals((String) v.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !aq.isEmpty(stringExtra)) {
                        TiebaStatic.log(new an("c12613").ag("obj_type", 1).dh("tid", stringExtra));
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

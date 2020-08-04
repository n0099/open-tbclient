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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes18.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean isBJH;
    private boolean kJs;

    public BlueLikeButton(Context context) {
        super(context);
        this.kJs = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kJs = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kJs = false;
        this.isBJH = false;
    }

    public void setBJH(boolean z) {
        this.isBJH = z;
    }

    public void aM(boolean z) {
        this.kJs = z;
        if (z) {
            if (this.isBJH) {
                setText(R.string.followed);
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).mb(R.color.cp_bg_line_c).aX(this);
                ao.setViewTextColor(this, R.color.cp_cont_b, 1);
                return;
            }
            setText(R.string.followed);
            setBackgroundDrawable(ao.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this, R.color.cp_cont_e, 1);
        } else if (this.isBJH) {
            setText(R.string.attention);
            com.baidu.tbadk.core.util.e.a.c(com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).mh(1).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b, R.color.cp_link_tip_a).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).mh(1).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).bbx()).aX(this);
            ao.setViewTextColor(this, R.color.cp_cont_a, 1);
        } else {
            setText(R.string.attention);
            setBackgroundDrawable(ao.getDrawable(R.drawable.selector_like_button_bg));
            setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this, R.color.cp_cont_g, 1);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void nc(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bi(View view) {
        if (!this.isBJH) {
            TiebaStatic.log(new ap("c12503").dn("obj_locate", "4"));
            if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ap apVar = new ap("c12507");
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar.ah("obj_locate", 2);
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(apVar);
            }
            if (!this.kJs) {
                Context context = getContext();
                if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                    String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                    List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                    if (currentPageSourceKeyList != null && as.equals((String) x.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !as.isEmpty(stringExtra)) {
                        TiebaStatic.log(new ap("c12613").ah("obj_type", 1).dn("tid", stringExtra));
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

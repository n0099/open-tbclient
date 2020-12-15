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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes24.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean isBJH;
    private boolean mek;

    public BlueLikeButton(Context context) {
        super(context);
        this.mek = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mek = false;
        this.isBJH = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mek = false;
        this.isBJH = false;
    }

    public void setBJH(boolean z) {
        this.isBJH = z;
    }

    public void aP(boolean z) {
        this.mek = z;
        if (z) {
            if (this.isBJH) {
                setText(R.string.followed);
                com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ac(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).qg(R.color.CAM_X0204).bq(this);
                ap.setViewTextColor(this, R.color.CAM_X0105, 1);
                return;
            }
            setText(R.string.followed);
            setBackgroundDrawable(ap.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.CAM_X0110, 1);
        } else if (this.isBJH) {
            setText(R.string.attention);
            com.baidu.tbadk.core.util.e.a.c(com.baidu.tbadk.core.util.e.a.b.buA().qf(0).qo(1).ac(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.CAM_X0303, R.color.CAM_X0302).buC(), com.baidu.tbadk.core.util.e.a.b.buA().qf(0).qo(1).ac(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42)).b("TL_BR", R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).buC()).bq(this);
            ap.setViewTextColor(this, R.color.CAM_X0101, 1);
        } else {
            setText(R.string.attention);
            setBackgroundDrawable(ap.getDrawable(R.drawable.selector_like_button_bg));
            setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.CAM_X0111, 1);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rq(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bB(View view) {
        if (!this.isBJH) {
            TiebaStatic.log(new ar("c12503").dY("obj_locate", "4"));
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c12507");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.al("obj_locate", 2);
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (!this.mek) {
                Context context = getContext();
                if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.m.a)) {
                    String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                    List<String> currentPageSourceKeyList = ((com.baidu.tbadk.m.a) context).getCurrentPageSourceKeyList();
                    if (currentPageSourceKeyList != null && au.equals((String) y.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !au.isEmpty(stringExtra)) {
                        TiebaStatic.log(new ar("c12613").al("obj_type", 1).dY("tid", stringExtra));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }
}

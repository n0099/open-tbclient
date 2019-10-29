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
/* loaded from: classes6.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean ifh;

    public BlueLikeButton(Context context) {
        super(context);
        this.ifh = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifh = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifh = false;
    }

    public void ew(boolean z) {
        this.ifh = z;
        if (z) {
            setText(R.string.followed);
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, R.color.cp_cont_e, 1);
            return;
        }
        setText(R.string.attention);
        setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(boolean z, int i) {
        ew(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        g(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iU(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        TiebaStatic.log(new an("c12503").bS("obj_locate", "4"));
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            an anVar = new an("c12507");
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.O("obj_locate", 2);
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
        }
        if (!this.ifh) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && aq.equals((String) v.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE) && !aq.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").O("obj_type", 1).bS("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ifh) {
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, R.color.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, R.color.cp_cont_g, 1);
    }
}

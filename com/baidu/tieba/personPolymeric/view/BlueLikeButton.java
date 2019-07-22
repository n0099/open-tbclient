package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean irD;

    public BlueLikeButton(Context context) {
        super(context);
        this.irD = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irD = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irD = false;
    }

    public void ev(boolean z) {
        this.irD = z;
        if (z) {
            setText(R.string.followed);
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this, R.color.cp_cont_e, 1);
            return;
        }
        setText(R.string.attention);
        setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        ev(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void je(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        TiebaStatic.log(new an("c12503").bT("obj_locate", "4"));
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            an anVar = new an("c12507");
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.P("obj_locate", 2);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
        }
        if (!this.irD) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && aq.bV((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !aq.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").P("obj_type", 1).bT("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.irD) {
            setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this, R.color.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(am.getDrawable(R.drawable.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this, R.color.cp_cont_g, 1);
    }
}

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean ill;

    public BlueLikeButton(Context context) {
        super(context);
        this.ill = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ill = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ill = false;
    }

    public void er(boolean z) {
        this.ill = z;
        if (z) {
            setText(R.string.followed);
            setBackgroundDrawable(al.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this, R.color.cp_cont_e, 1);
            return;
        }
        setText(R.string.attention);
        setBackgroundDrawable(al.getDrawable(R.drawable.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        er(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iY(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aX(View view) {
        TiebaStatic.log(new am("c12503").bT("obj_locate", "4"));
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            am amVar = new am("c12507");
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.P("obj_locate", 2);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
        }
        if (!this.ill) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.o.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.o.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ap.equals((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ap.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").P("obj_type", 1).bT("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ill) {
            setBackgroundDrawable(al.getDrawable(R.drawable.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this, R.color.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(al.getDrawable(R.drawable.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this, R.color.cp_cont_g, 1);
    }
}

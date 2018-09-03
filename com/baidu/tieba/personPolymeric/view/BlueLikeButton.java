package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean gbG;

    public BlueLikeButton(Context context) {
        super(context);
        this.gbG = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbG = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbG = false;
    }

    public void aW(boolean z) {
        this.gbG = z;
        if (z) {
            setText(f.j.followed);
            setBackgroundDrawable(am.getDrawable(f.C0146f.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this, f.d.cp_cont_e, 1);
            return;
        }
        setText(f.j.attention);
        setBackgroundDrawable(am.getDrawable(f.C0146f.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(f.e.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this, f.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aW(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dH(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void L(View view) {
        TiebaStatic.log(new an("c12503").ae("obj_locate", "4"));
        if (!this.gbG) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ap.equals((String) w.d(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ap.isEmpty(stringExtra)) {
                    TiebaStatic.log(new an("c12613").r("obj_type", 1).ae("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gbG) {
            setBackgroundDrawable(am.getDrawable(f.C0146f.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this, f.d.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(am.getDrawable(f.C0146f.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this, f.d.cp_cont_g, 1);
    }
}

package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean fXo;

    public BlueLikeButton(Context context) {
        super(context);
        this.fXo = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXo = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fXo = false;
    }

    public void aU(boolean z) {
        this.fXo = z;
        if (z) {
            setText(d.k.followed);
            setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this, d.C0141d.cp_cont_e, 1);
            return;
        }
        setText(d.k.attention);
        setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(d.e.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this, d.C0141d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dE(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void K(View view) {
        TiebaStatic.log(new am("c12503").ah("obj_locate", "4"));
        if (!this.fXo) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ao.equals((String) w.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ao.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").r("obj_type", 1).ah("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fXo) {
            setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this, d.C0141d.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this, d.C0141d.cp_cont_g, 1);
    }
}

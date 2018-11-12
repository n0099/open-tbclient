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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean grX;

    public BlueLikeButton(Context context) {
        super(context);
        this.grX = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.grX = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.grX = false;
    }

    public void bJ(boolean z) {
        this.grX = z;
        if (z) {
            setText(e.j.followed);
            setBackgroundDrawable(al.getDrawable(e.f.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this, e.d.cp_cont_e, 1);
            return;
        }
        setText(e.j.attention);
        setBackgroundDrawable(al.getDrawable(e.f.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(e.C0200e.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        bJ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eq(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        TiebaStatic.log(new am("c12503").ax("obj_locate", "4"));
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            am amVar = new am("c12507");
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.x("obj_locate", 2);
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
        }
        if (!this.grX) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ao.equals((String) v.d(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ao.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").x("obj_type", 1).ax("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.grX) {
            setBackgroundDrawable(al.getDrawable(e.f.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this, e.d.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(al.getDrawable(e.f.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this, e.d.cp_cont_g, 1);
    }
}

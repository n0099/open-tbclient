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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes6.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean hSI;

    public BlueLikeButton(Context context) {
        super(context);
        this.hSI = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSI = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSI = false;
    }

    public void dU(boolean z) {
        this.hSI = z;
        if (z) {
            setText(d.j.followed);
            setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this, d.C0277d.cp_cont_e, 1);
            return;
        }
        setText(d.j.attention);
        setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(d.e.tbds20), 0, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this, d.C0277d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        dU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void il(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aR(View view) {
        TiebaStatic.log(new am("c12503").bJ("obj_locate", "4"));
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            am amVar = new am("c12507");
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.T("obj_locate", 2);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
        }
        if (!this.hSI) {
            Context context = getContext();
            if ((context instanceof Activity) && (context instanceof com.baidu.tbadk.pageStayDuration.a)) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
                List<String> currentPageSourceKeyList = ((com.baidu.tbadk.pageStayDuration.a) context).getCurrentPageSourceKeyList();
                if (currentPageSourceKeyList != null && ap.equals((String) v.c(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") && !ap.isEmpty(stringExtra)) {
                    TiebaStatic.log(new am("c12613").T("obj_type", 1).bJ("tid", stringExtra));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.hSI) {
            setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this, d.C0277d.cp_cont_e, 1);
            return;
        }
        setBackgroundDrawable(al.getDrawable(d.f.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this, d.C0277d.cp_cont_g, 1);
    }
}

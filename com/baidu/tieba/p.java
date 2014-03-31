package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class p implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        Context context;
        Drawable drawable;
        Context context2;
        Context context3;
        Drawable drawable2;
        Context context4;
        z = this.a.r;
        if (!z) {
            z2 = this.a.q;
            if (z2) {
                if (TbadkApplication.j().l() == 1) {
                    context4 = this.a.o;
                    drawable2 = context4.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_n_1);
                } else {
                    context3 = this.a.o;
                    drawable2 = context3.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_n);
                }
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.a.f.setCompoundDrawables(drawable2, null, null, null);
                this.a.p = false;
                this.a.q = false;
                return;
            }
            if (TbadkApplication.j().l() == 1) {
                context2 = this.a.o;
                drawable = context2.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_s_1);
            } else {
                context = this.a.o;
                drawable = context.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_s);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.f.setCompoundDrawables(drawable, null, null, null);
            this.a.p = true;
            this.a.q = true;
        }
    }
}

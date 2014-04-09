package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class l implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        o oVar;
        Context context;
        Drawable drawable;
        Context context2;
        z = this.a.p;
        TiebaStatic.a(this.a.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.a.r = true;
        z2 = this.a.q;
        if (z2) {
            if (TbadkApplication.j().l() == 1) {
                context2 = this.a.o;
                drawable = context2.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_d_1);
            } else {
                context = this.a.o;
                drawable = context.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_d);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.f.setCompoundDrawables(drawable, null, null, null);
        }
        oVar = this.a.k;
        oVar.a(z);
    }
}

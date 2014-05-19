package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        ac acVar;
        Context context;
        Drawable drawable;
        Context context2;
        z = this.a.p;
        TiebaStatic.eventStat(this.a.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.a.r = true;
        z2 = this.a.q;
        if (z2) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                context2 = this.a.o;
                drawable = context2.getResources().getDrawable(q.btn_dailog_choose_d_1);
            } else {
                context = this.a.o;
                drawable = context.getResources().getDrawable(q.btn_dailog_choose_d);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.f.setCompoundDrawables(drawable, null, null, null);
        }
        acVar = this.a.k;
        acVar.a(z);
    }
}

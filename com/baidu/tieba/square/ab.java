package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2371a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f2371a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        ad adVar = view.getTag() instanceof ad ? (ad) view.getTag() : null;
        String a2 = SquareActivity.a("forum_list_recommend", adVar.c());
        if (adVar != null) {
            context = this.f2371a.b;
            UtilHelper.a(context, adVar.b(), null, a2);
        }
    }
}

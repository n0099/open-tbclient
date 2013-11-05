package com.baidu.tieba.kn.ladders;

import android.content.Context;
import android.widget.Toast;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f1755a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f1755a.b;
        Toast.makeText(context, (int) R.string.neterror, 0).show();
    }
}

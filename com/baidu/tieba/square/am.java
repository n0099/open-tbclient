package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements aw {
    final /* synthetic */ SquareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SquareActivity squareActivity) {
        this.a = squareActivity;
    }

    @Override // com.baidu.tieba.square.aw
    public void a(boolean z, String str, ar arVar) {
        by byVar;
        boolean z2;
        BaseFragmentActivity baseFragmentActivity;
        by byVar2;
        by byVar3;
        boolean z3;
        by byVar4;
        by byVar5;
        av avVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        byVar = this.a.b;
        byVar.a(true, "");
        if (z && arVar != null) {
            byVar5 = this.a.b;
            avVar = this.a.c;
            byVar5.a(avVar.a());
            handler = this.a.g;
            runnable = this.a.h;
            handler.removeCallbacks(runnable);
            handler2 = this.a.g;
            runnable2 = this.a.h;
            handler2.postDelayed(runnable2, 0L);
            this.a.d = true;
            this.a.J();
        }
        z2 = this.a.e;
        if (z2) {
            this.a.e = false;
            byVar4 = this.a.b;
            byVar4.g();
        }
        if (!UtilHelper.b()) {
            byVar3 = this.a.b;
            byVar3.h();
            z3 = this.a.d;
            if (!z3) {
                this.a.I();
                return;
            }
            return;
        }
        baseFragmentActivity = this.a.f;
        baseFragmentActivity.a(str);
        byVar2 = this.a.b;
        byVar2.i();
    }
}

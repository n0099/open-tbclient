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
        bz bzVar;
        boolean z2;
        BaseFragmentActivity baseFragmentActivity;
        bz bzVar2;
        bz bzVar3;
        boolean z3;
        bz bzVar4;
        bz bzVar5;
        av avVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bzVar = this.a.b;
        bzVar.a(true, "");
        if (z && arVar != null) {
            bzVar5 = this.a.b;
            avVar = this.a.c;
            bzVar5.a(avVar.a());
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
            bzVar4 = this.a.b;
            bzVar4.g();
        }
        if (!UtilHelper.b()) {
            bzVar3 = this.a.b;
            bzVar3.h();
            z3 = this.a.d;
            if (!z3) {
                this.a.I();
                return;
            }
            return;
        }
        baseFragmentActivity = this.a.f;
        baseFragmentActivity.a(str);
        bzVar2 = this.a.b;
        bzVar2.i();
    }
}

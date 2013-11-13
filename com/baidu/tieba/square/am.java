package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ay {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SquareActivity squareActivity) {
        this.f2382a = squareActivity;
    }

    @Override // com.baidu.tieba.square.ay
    public void a(boolean z, String str, ar arVar) {
        bw bwVar;
        boolean z2;
        BaseFragmentActivity baseFragmentActivity;
        bw bwVar2;
        bw bwVar3;
        boolean z3;
        bw bwVar4;
        bw bwVar5;
        ax axVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bwVar = this.f2382a.b;
        bwVar.a(true, "");
        if (z && arVar != null) {
            bwVar5 = this.f2382a.b;
            axVar = this.f2382a.c;
            bwVar5.a(axVar.a());
            handler = this.f2382a.g;
            runnable = this.f2382a.h;
            handler.removeCallbacks(runnable);
            handler2 = this.f2382a.g;
            runnable2 = this.f2382a.h;
            handler2.postDelayed(runnable2, 0L);
            this.f2382a.d = true;
            this.f2382a.J();
        }
        z2 = this.f2382a.e;
        if (z2) {
            this.f2382a.e = false;
            bwVar4 = this.f2382a.b;
            bwVar4.g();
        }
        if (!UtilHelper.b()) {
            bwVar3 = this.f2382a.b;
            bwVar3.i();
            z3 = this.f2382a.d;
            if (!z3) {
                this.f2382a.I();
                return;
            }
            return;
        }
        baseFragmentActivity = this.f2382a.f;
        baseFragmentActivity.a(str);
        bwVar2 = this.f2382a.b;
        bwVar2.j();
    }
}

package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SquareActivity squareActivity) {
        this.f2366a = squareActivity;
    }

    @Override // com.baidu.tieba.square.aw
    public void a(boolean z, String str, ar arVar) {
        bu buVar;
        boolean z2;
        BaseFragmentActivity baseFragmentActivity;
        bu buVar2;
        bu buVar3;
        boolean z3;
        bu buVar4;
        bu buVar5;
        av avVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        buVar = this.f2366a.b;
        buVar.a(true, "");
        if (z && arVar != null) {
            buVar5 = this.f2366a.b;
            avVar = this.f2366a.c;
            buVar5.a(avVar.a());
            handler = this.f2366a.g;
            runnable = this.f2366a.h;
            handler.removeCallbacks(runnable);
            handler2 = this.f2366a.g;
            runnable2 = this.f2366a.h;
            handler2.postDelayed(runnable2, 0L);
            this.f2366a.d = true;
            this.f2366a.J();
        }
        z2 = this.f2366a.e;
        if (z2) {
            this.f2366a.e = false;
            buVar4 = this.f2366a.b;
            buVar4.g();
        }
        if (!UtilHelper.b()) {
            buVar3 = this.f2366a.b;
            buVar3.i();
            z3 = this.f2366a.d;
            if (!z3) {
                this.f2366a.I();
                return;
            }
            return;
        }
        baseFragmentActivity = this.f2366a.f;
        baseFragmentActivity.a(str);
        buVar2 = this.f2366a.b;
        buVar2.j();
    }
}

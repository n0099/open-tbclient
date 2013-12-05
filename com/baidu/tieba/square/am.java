package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SquareActivity squareActivity) {
        this.f2483a = squareActivity;
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
        buVar = this.f2483a.b;
        buVar.a(true, "");
        if (z && arVar != null) {
            buVar5 = this.f2483a.b;
            avVar = this.f2483a.c;
            buVar5.a(avVar.a());
            handler = this.f2483a.g;
            runnable = this.f2483a.h;
            handler.removeCallbacks(runnable);
            handler2 = this.f2483a.g;
            runnable2 = this.f2483a.h;
            handler2.postDelayed(runnable2, 0L);
            this.f2483a.d = true;
            this.f2483a.J();
        }
        z2 = this.f2483a.e;
        if (z2) {
            this.f2483a.e = false;
            buVar4 = this.f2483a.b;
            buVar4.g();
        }
        if (!UtilHelper.b()) {
            buVar3 = this.f2483a.b;
            buVar3.h();
            z3 = this.f2483a.d;
            if (!z3) {
                this.f2483a.I();
                return;
            }
            return;
        }
        baseFragmentActivity = this.f2483a.f;
        baseFragmentActivity.b(str);
        buVar2 = this.f2483a.b;
        buVar2.i();
    }
}

package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements aw {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // com.baidu.tieba.square.aw
    public void a(boolean z, String str, ar arVar) {
        az azVar;
        boolean z2;
        long j;
        long j2;
        av avVar;
        long j3;
        av avVar2;
        av avVar3;
        av avVar4;
        BaseFragmentActivity baseFragmentActivity;
        az azVar2;
        az azVar3;
        boolean z3;
        az azVar4;
        az azVar5;
        av avVar5;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        azVar = this.a.c;
        azVar.a(true, "");
        if (z && arVar != null) {
            azVar5 = this.a.c;
            avVar5 = this.a.d;
            azVar5.a(avVar5.e());
            handler = this.a.i;
            runnable = this.a.j;
            handler.removeCallbacks(runnable);
            handler2 = this.a.i;
            runnable2 = this.a.j;
            handler2.postDelayed(runnable2, 0L);
            this.a.e = true;
            this.a.i();
        }
        z2 = this.a.f;
        if (z2) {
            this.a.f = false;
            azVar4 = this.a.c;
            azVar4.d();
        } else {
            j = this.a.g;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.g;
                avVar = this.a.d;
                long d = avVar.d();
                j3 = this.a.g;
                long j4 = d - j3;
                avVar2 = this.a.d;
                long b = avVar2.b();
                avVar3 = this.a.d;
                long c = avVar3.c();
                avVar4 = this.a.d;
                TiebaStatic.page("op_square_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - avVar4.a());
                this.a.g = -1L;
            }
        }
        if (!UtilHelper.isNetOk()) {
            azVar3 = this.a.c;
            azVar3.e();
            z3 = this.a.e;
            if (z3) {
                return;
            }
            this.a.h();
            return;
        }
        baseFragmentActivity = this.a.h;
        baseFragmentActivity.a(str);
        azVar2 = this.a.c;
        azVar2.f();
    }
}

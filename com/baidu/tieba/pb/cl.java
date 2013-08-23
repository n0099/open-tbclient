package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tieba.view.an {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bo boVar) {
        this.f1541a = boVar;
    }

    @Override // com.baidu.tieba.view.an
    public void a(int i) {
        switch (i) {
            case 0:
                if (!this.f1541a.u()) {
                    new Handler().postDelayed(new co(this), 0L);
                } else {
                    new Handler().postDelayed(new cp(this), 0L);
                }
                this.f1541a.ap = true;
                return;
            case 1:
                if (!this.f1541a.u()) {
                    new Handler().postDelayed(new cm(this), 0L);
                } else {
                    new Handler().postDelayed(new cn(this), 0L);
                }
                this.f1541a.ap = false;
                return;
            default:
                return;
        }
    }
}

package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements com.baidu.tieba.view.ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1252a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bk bkVar) {
        this.f1252a = bkVar;
    }

    @Override // com.baidu.tieba.view.ae
    public void a(int i) {
        switch (i) {
            case 0:
                if (!this.f1252a.t()) {
                    new Handler().postDelayed(new ck(this), 0L);
                } else {
                    new Handler().postDelayed(new cl(this), 0L);
                }
                this.f1252a.an = true;
                return;
            case 1:
                if (!this.f1252a.t()) {
                    new Handler().postDelayed(new ci(this), 0L);
                } else {
                    new Handler().postDelayed(new cj(this), 0L);
                }
                this.f1252a.an = false;
                return;
            default:
                return;
        }
    }
}

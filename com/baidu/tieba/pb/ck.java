package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements com.baidu.tieba.view.aq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bn bnVar) {
        this.f1503a = bnVar;
    }

    @Override // com.baidu.tieba.view.aq
    public void a(int i) {
        switch (i) {
            case 0:
                if (!this.f1503a.t()) {
                    new Handler().postDelayed(new cn(this), 0L);
                } else {
                    new Handler().postDelayed(new co(this), 0L);
                }
                this.f1503a.an = true;
                return;
            case 1:
                if (!this.f1503a.t()) {
                    new Handler().postDelayed(new cl(this), 0L);
                } else {
                    new Handler().postDelayed(new cm(this), 0L);
                }
                this.f1503a.an = false;
                return;
            default:
                return;
        }
    }
}

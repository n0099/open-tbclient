package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements com.baidu.tieba.view.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(bt btVar) {
        this.f2102a = btVar;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        switch (i) {
            case 0:
                if (!this.f2102a.E()) {
                    new Handler().postDelayed(new cr(this), 0L);
                } else {
                    new Handler().postDelayed(new cs(this), 0L);
                }
                this.f2102a.at = true;
                return;
            case 1:
                if (!this.f2102a.E()) {
                    new Handler().postDelayed(new cp(this), 0L);
                } else {
                    new Handler().postDelayed(new cq(this), 0L);
                }
                this.f2102a.at = false;
                return;
            default:
                return;
        }
    }
}

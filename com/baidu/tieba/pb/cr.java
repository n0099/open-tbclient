package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements com.baidu.tieba.view.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(br brVar) {
        this.f1589a = brVar;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        switch (i) {
            case 0:
                if (!this.f1589a.E()) {
                    new Handler().postDelayed(new cu(this), 0L);
                } else {
                    new Handler().postDelayed(new cv(this), 0L);
                }
                this.f1589a.at = true;
                return;
            case 1:
                if (!this.f1589a.E()) {
                    new Handler().postDelayed(new cs(this), 0L);
                } else {
                    new Handler().postDelayed(new ct(this), 0L);
                }
                this.f1589a.at = false;
                return;
            default:
                return;
        }
    }
}

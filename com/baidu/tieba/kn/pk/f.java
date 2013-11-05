package com.baidu.tieba.kn.pk;

import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1773a;
    final /* synthetic */ PKJumpActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PKJumpActivity pKJumpActivity, s sVar) {
        this.b = pKJumpActivity;
        this.f1773a = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProgressBar progressBar;
        String str;
        String str2;
        String str3;
        progressBar = this.b.e;
        progressBar.setVisibility(8);
        this.b.overridePendingTransition(0, 0);
        if (this.f1773a.g()) {
            PKJumpActivity pKJumpActivity = this.b;
            str3 = this.b.c;
            PKWaitingActivity.a(pKJumpActivity, str3, this.f1773a.d());
        } else if (this.f1773a.f()) {
            PKJumpActivity pKJumpActivity2 = this.b;
            str2 = this.b.c;
            PKEndActivity.a(pKJumpActivity2, str2, this.f1773a.d());
        } else {
            PKJumpActivity pKJumpActivity3 = this.b;
            str = this.b.c;
            PKingActivity.a(pKJumpActivity3, str, this.f1773a.d());
        }
        this.b.finish();
        this.b.overridePendingTransition(0, 0);
    }
}

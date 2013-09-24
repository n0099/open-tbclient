package com.baidu.tieba.kn.pk;

import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKJumpActivity f1278a;
    private final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PKJumpActivity pKJumpActivity, s sVar) {
        this.f1278a = pKJumpActivity;
        this.b = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProgressBar progressBar;
        String str;
        String str2;
        String str3;
        progressBar = this.f1278a.e;
        progressBar.setVisibility(8);
        this.f1278a.overridePendingTransition(0, 0);
        if (this.b.g()) {
            PKJumpActivity pKJumpActivity = this.f1278a;
            str3 = this.f1278a.c;
            PKWaitingActivity.a(pKJumpActivity, str3, this.b.d());
        } else if (this.b.f()) {
            PKJumpActivity pKJumpActivity2 = this.f1278a;
            str2 = this.f1278a.c;
            PKEndActivity.a(pKJumpActivity2, str2, this.b.d());
        } else {
            PKJumpActivity pKJumpActivity3 = this.f1278a;
            str = this.f1278a.c;
            PKingActivity.a(pKJumpActivity3, str, this.b.d());
        }
        this.f1278a.finish();
        this.f1278a.overridePendingTransition(0, 0);
    }
}

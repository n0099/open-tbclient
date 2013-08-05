package com.baidu.tieba.kn.pk;

import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKJumpActivity f1213a;
    private final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PKJumpActivity pKJumpActivity, s sVar) {
        this.f1213a = pKJumpActivity;
        this.b = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProgressBar progressBar;
        String str;
        String str2;
        String str3;
        progressBar = this.f1213a.e;
        progressBar.setVisibility(8);
        this.f1213a.overridePendingTransition(0, 0);
        if (this.b.f()) {
            PKJumpActivity pKJumpActivity = this.f1213a;
            str3 = this.f1213a.c;
            PKWaitingActivity.a(pKJumpActivity, str3, this.b.c());
        } else if (this.b.e()) {
            PKJumpActivity pKJumpActivity2 = this.f1213a;
            str2 = this.f1213a.c;
            PKEndActivity.a(pKJumpActivity2, str2, this.b.c());
        } else {
            PKJumpActivity pKJumpActivity3 = this.f1213a;
            str = this.f1213a.c;
            PKingActivity.a(pKJumpActivity3, str, this.b.c());
        }
        this.f1213a.finish();
        this.f1213a.overridePendingTransition(0, 0);
    }
}

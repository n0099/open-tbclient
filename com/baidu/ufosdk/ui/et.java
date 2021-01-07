package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
final class et implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f5860a;

    private et(er erVar) {
        this.f5860a = erVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ et(er erVar, byte b2) {
        this(erVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                eu b2 = er.b(this.f5860a);
                er.a(this.f5860a).getText().toString();
                b2.a();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                er.b(this.f5860a).a(er.a(this.f5860a).getText().toString());
                return;
            default:
                return;
        }
    }
}

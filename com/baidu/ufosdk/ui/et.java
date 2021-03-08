package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
final class et implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f3772a;

    private et(er erVar) {
        this.f3772a = erVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ et(er erVar, byte b) {
        this(erVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                eu b = er.b(this.f3772a);
                er.a(this.f3772a).getText().toString();
                b.a();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                er.b(this.f3772a).a(er.a(this.f3772a).getText().toString());
                return;
            default:
                return;
        }
    }
}

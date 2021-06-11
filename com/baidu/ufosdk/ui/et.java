package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public final class et implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ er f22923a;

    public et(er erVar) {
        this.f22923a = erVar;
    }

    public /* synthetic */ et(er erVar, byte b2) {
        this(erVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                eu b2 = er.b(this.f22923a);
                er.a(this.f22923a).getText().toString();
                b2.a();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                er.b(this.f22923a).a(er.a(this.f22923a).getText().toString());
                return;
            default:
                return;
        }
    }
}

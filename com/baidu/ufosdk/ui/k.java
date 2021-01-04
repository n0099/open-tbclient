package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
final class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f5884a;

    private k(j jVar) {
        this.f5884a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, byte b2) {
        this(jVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                j.a(this.f5884a).b();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                j.a(this.f5884a).a();
                return;
            default:
                return;
        }
    }
}

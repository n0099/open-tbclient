package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
final class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f3787a;

    private k(j jVar) {
        this.f3787a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, byte b) {
        this(jVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                j.a(this.f3787a).b();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                j.a(this.f3787a).a();
                return;
            default:
                return;
        }
    }
}

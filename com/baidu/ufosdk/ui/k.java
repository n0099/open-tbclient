package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public final class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f22972a;

    public k(j jVar) {
        this.f22972a = jVar;
    }

    public /* synthetic */ k(j jVar, byte b2) {
        this(jVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.dimen.L_X06 /* 2131165189 */:
                j.a(this.f22972a).b();
                return;
            case R.dimen.M_H_X001 /* 2131165190 */:
                j.a(this.f22972a).a();
                return;
            default:
                return;
        }
    }
}

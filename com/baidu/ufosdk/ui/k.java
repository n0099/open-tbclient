package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
final class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f3879a;

    private k(j jVar) {
        this.f3879a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, byte b) {
        this(jVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.xml.pass_sdk_file_provider /* 2131165189 */:
                j.a(this.f3879a).b();
                return;
            case R.xml.tieba_file_paths /* 2131165190 */:
                j.a(this.f3879a).a();
                return;
            default:
                return;
        }
    }
}

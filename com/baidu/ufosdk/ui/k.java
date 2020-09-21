package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
final class k implements View.OnClickListener {
    final /* synthetic */ j a;

    private k(j jVar) {
        this.a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, byte b) {
        this(jVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.xml.pass_sdk_file_provider /* 2131165189 */:
                j.a(this.a).b();
                return;
            case R.xml.tieba_file_paths /* 2131165190 */:
                j.a(this.a).a();
                return;
            default:
                return;
        }
    }
}

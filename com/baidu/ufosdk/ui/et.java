package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
final class et implements View.OnClickListener {
    final /* synthetic */ er a;

    private et(er erVar) {
        this.a = erVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ et(er erVar, byte b) {
        this(erVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.xml.pass_sdk_file_provider /* 2131165189 */:
                eu b = er.b(this.a);
                er.a(this.a).getText().toString();
                b.a();
                return;
            case R.xml.tieba_file_paths /* 2131165190 */:
                er.b(this.a).a(er.a(this.a).getText().toString());
                return;
            default:
                return;
        }
    }
}

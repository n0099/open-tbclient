package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
final class et implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f3869a;

    private et(er erVar) {
        this.f3869a = erVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ et(er erVar, byte b) {
        this(erVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.xml.null_network_security_config /* 2131165189 */:
                eu b = er.b(this.f3869a);
                er.a(this.f3869a).getText().toString();
                b.a();
                return;
            case R.xml.pass_sdk_file_provider /* 2131165190 */:
                er.b(this.f3869a).a(er.a(this.f3869a).getText().toString());
                return;
            default:
                return;
        }
    }
}

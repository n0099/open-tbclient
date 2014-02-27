package com.baidu.tieba.pb;

import android.text.ClipboardManager;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(NewPbActivity newPbActivity, String str) {
        this.a = newPbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = this.b;
        try {
            ((ClipboardManager) com.baidu.adp.a.b.a().b().getSystemService("clipboard")).setText(str == null ? "" : str);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b("copyToClipboard failed: " + th.getMessage());
        }
        BdUtilHelper.a(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
    }
}

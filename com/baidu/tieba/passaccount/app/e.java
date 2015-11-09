package com.baidu.tieba.passaccount.app;

import android.widget.Toast;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends AuthorizationListener {
    final /* synthetic */ FillUProfileActivity cdE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FillUProfileActivity fillUProfileActivity) {
        this.cdE = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        Toast.makeText(this.cdE.getPageContext().getPageActivity(), "正常化成功", 0).show();
        this.cdE.aeq();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        Toast.makeText(this.cdE.getPageContext().getPageActivity(), String.format("%s(%d)", str, Integer.valueOf(i)), 0).show();
        this.cdE.finish();
    }
}

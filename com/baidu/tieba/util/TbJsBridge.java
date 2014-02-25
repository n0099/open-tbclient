package com.baidu.tieba.util;

import android.app.Activity;
import android.net.Uri;
import android.widget.Toast;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
public class TbJsBridge {
    private Activity mActivity;

    public TbJsBridge(Activity activity) {
        this.mActivity = activity;
    }

    public void closePage(String str) {
        if (!bs.c(str)) {
            Toast.makeText(this.mActivity, str, 0).show();
        }
        this.mActivity.finish();
    }

    public void jumpToLogin(int i) {
        LoginActivity.a(this.mActivity, com.baidu.adp.lib.f.b.a(String.valueOf(i), 0));
    }

    public void showShareDialog(String str, String str2, String str3, String str4) {
        com.baidu.tieba.widget.share.f fVar = new com.baidu.tieba.widget.share.f();
        fVar.a = str;
        fVar.b = str2;
        fVar.c = str4;
        if (!bs.c(str3)) {
            fVar.d = Uri.parse(str3);
        }
        com.baidu.tieba.widget.share.d dVar = new com.baidu.tieba.widget.share.d(this.mActivity);
        dVar.a(fVar, true);
        dVar.a();
    }
}

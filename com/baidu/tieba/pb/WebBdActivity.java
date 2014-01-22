package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.dex.wrapper.BdBrowserDelegate;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends com.baidu.tieba.j implements Observer {
    private BdBrowserDelegate a;

    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.d(context)) {
            com.baidu.adp.lib.g.g.a(context, context.getString(R.string.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebBdActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra("bduss", str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = TiebaApplication.h().e().a(this);
        if (this.a == null) {
            UtilHelper.a((Context) this, getIntent().getStringExtra(SocialConstants.PARAM_URL), true);
            finish();
            return;
        }
        try {
            this.a.onCreate(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.g.e.a("Exception: " + th.getMessage());
            UtilHelper.a((Context) this, getIntent().getStringExtra(SocialConstants.PARAM_URL), true);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.onPause();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.a.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.a.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.onDestroy();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.a.onActivityResult(i, i2, intent);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.a.update(observable, obj);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }
}

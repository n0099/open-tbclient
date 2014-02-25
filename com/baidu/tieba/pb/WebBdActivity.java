package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbplugin.plugins.BdBrowserDelegate;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends com.baidu.tieba.f implements Observer {
    private BdBrowserDelegate a;

    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.e(context)) {
            BdUtilHelper.a(context, context.getString(R.string.web_view_corrupted));
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (BdBrowserDelegate) com.baidu.tbplugin.j.a().a(BdBrowserDelegate.class);
        if (this.a == null) {
            UtilHelper.a((Context) this, getIntent().getStringExtra(SocialConstants.PARAM_URL), true);
            finish();
            return;
        }
        try {
            this.a.setActivity(this);
            this.a.setCallback(new ex(this));
            this.a.onCreate(bundle);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("Exception: " + th.getMessage());
            UtilHelper.a((Context) this, getIntent().getStringExtra(SocialConstants.PARAM_URL), true);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.onPause();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.a != null) {
            this.a.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.onDestroy();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a != null && (this.a.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.a != null) {
            this.a.onActivityResult(i, i2, intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.a != null) {
            this.a.update(observable, obj);
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a != null && (this.a.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent));
    }
}

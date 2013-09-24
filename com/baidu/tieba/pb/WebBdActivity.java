package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import com.baidu.browser.Browser;
import com.baidu.browser.explorer.BdExploreViewListener;
import com.baidu.browser.explorer.share.BdSharer;
import com.baidu.browser.framework.BdUploadHandler;
import com.baidu.browser.version.BdPvStatistic;
import com.baidu.browser.version.BdUpdateTask;
import com.baidu.browser.webkit.BdCookieManager;
import com.baidu.browser.webkit.BdCookieSyncManager;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewManager;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends com.baidu.tieba.j implements Browser.BrowserListener, BdExploreViewListener, Observer {

    /* renamed from: a  reason: collision with root package name */
    private String f1519a = null;
    private String b = null;
    private String c = null;
    private BdUploadHandler d;
    private BdValueCallback<Uri> e;

    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.f(context)) {
            UtilHelper.a(context, context.getString(R.string.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebBdActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("url", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.f1519a = intent.getStringExtra("url");
        this.b = intent.getStringExtra("bduss");
        this.c = intent.getStringExtra("ptoken");
    }

    public void b() {
        if (this.b != null) {
            BdCookieSyncManager.createInstance(this);
            BdCookieManager.getInstance().setCookie("wappass.baidu.com", "BDUSS=" + this.b + "; domain=.baidu.com;");
            if (this.c != null) {
                BdCookieManager.getInstance().setCookie("wappass.baidu.com", "PTOKEN=" + this.c + "; domain=.baidu.com;");
            }
            BdCookieSyncManager.getInstance().sync();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        if (this.f1519a == null) {
            finish();
            return;
        }
        String guessUrl = URLUtil.guessUrl(this.f1519a);
        if (!URLUtil.isNetworkUrl(guessUrl)) {
            finish();
            return;
        }
        try {
            b();
            requestWindowFeature(1);
            BdWebViewManager.getInstance().addObserver(this);
            Browser.getInstance(this).onCreate(bundle);
            Browser.getInstance(this).setmListener(this);
            setContentView(Browser.getInstance(this).getRootView());
            Browser.getInstance(this).loadUrl(guessUrl);
            new BdUpdateTask(this).execute(new String[0]);
            BdPvStatistic.getInstance(this).addLauchCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        Browser.getInstance(this).onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Browser.getInstance(this).onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        Browser.getInstance(this).onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Browser.getInstance(this).finish();
        BdPvStatistic.getInstance(this).saveLauchCount();
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str) {
        this.d = new BdUploadHandler(this);
        this.d.openFileChooser(bdValueCallback, str);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback<Uri> bdValueCallback) {
        if (this.e == null) {
            this.e = bdValueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            startActivityForResult(Intent.createChooser(intent, getString(R.string.browser_choose_upload)), 1);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onGoHome() {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onExit() {
        finish();
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onOpenFromBrowser(String str, String str2) {
        BdSharer.sendTextShare(this, str, str2);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onBrowserStateChanged(int i, Object obj) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onClickVoiceSearch() {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onLongPress(BdWebView.BdHitTestResult bdHitTestResult) {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onShowTabWindow() {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onHideTabWindow() {
    }

    @Override // com.baidu.browser.Browser.BrowserListener, com.baidu.browser.explorer.BdExploreViewListener
    public void onSelectionSearch(String str) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (this.e != null) {
                this.e.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.e = null;
            }
        } else if (i == 2 && this.d != null) {
            this.d.onResult(i2, intent);
        }
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onDownloadStartNoStream(String str, String str2, String str3, String str4, long j) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Bundle onTabChangStarted(Bundle bundle) {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Bundle onTabChangeFinished(Bundle bundle) {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Message onRequestCopyHref() {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onProtocolSearch(String str) {
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        switch (((Message) obj).what) {
            case 0:
            case 1:
            case 2:
            case 3:
            default:
                return;
        }
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onWebViewTouch(MotionEvent motionEvent) {
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Browser.getInstance(this).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        return com.baidu.tieba.recommend.ae.a(this, str);
    }
}

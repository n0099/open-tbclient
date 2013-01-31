package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import com.baidu.browser.Browser;
import com.baidu.browser.core.util.BdUtil;
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
import com.baidu.tieba.frs.FrsActivity;
import java.net.URI;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes.dex */
public class WebBdActivity extends com.baidu.tieba.e implements Browser.BrowserListener, BdExploreViewListener, Observer {
    private String c = null;
    private String d = null;
    private String e = null;
    private BdUploadHandler f;
    private BdValueCallback g;

    public static void a(Context context, String str, String str2, String str3) {
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
        this.c = intent.getStringExtra("url");
        this.d = intent.getStringExtra("bduss");
        this.e = intent.getStringExtra("ptoken");
    }

    public void i() {
        if (this.d != null) {
            BdCookieSyncManager.createInstance(this);
            BdCookieManager.getInstance().setCookie("wappass.baidu.com", "BDUSS=" + this.d + "; domain=.baidu.com;");
            if (this.e != null) {
                BdCookieManager.getInstance().setCookie("wappass.baidu.com", "PTOKEN=" + this.e + "; domain=.baidu.com;");
            }
            BdCookieSyncManager.getInstance().sync();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        if (this.c == null) {
            finish();
            return;
        }
        String guessUrl = URLUtil.guessUrl(this.c);
        if (!URLUtil.isNetworkUrl(guessUrl)) {
            finish();
            return;
        }
        try {
            i();
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        Browser.getInstance(this).onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Browser.getInstance(this).onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        Browser.getInstance(this).onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Browser.getInstance(this).finish();
        BdPvStatistic.getInstance(this).saveLauchCount();
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback bdValueCallback, String str) {
        this.f = new BdUploadHandler(this);
        this.f.openFileChooser(bdValueCallback, str);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback bdValueCallback) {
        if (this.g == null) {
            this.g = bdValueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            startActivityForResult(Intent.createChooser(intent, getString(getResources().getIdentifier("choose_upload", "string", getPackageName()))), 1);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
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
            if (this.g != null) {
                this.g.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.g = null;
            }
        } else if (i == 2 && this.f != null) {
            this.f.onResult(i2, intent);
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Browser.getInstance(this).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:9:0x0020). Please submit an issue!!! */
    @Override // com.baidu.browser.Browser.BrowserListener
    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        if (str != null && str.contains("jump_tieba_native=1")) {
            try {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), BdUtil.UTF8)) {
                    if (nameValuePair.getName().equalsIgnoreCase("kz")) {
                        PbActivity.a(this, nameValuePair.getValue(), (String) null);
                        return true;
                    } else if (nameValuePair.getName().equalsIgnoreCase("kw")) {
                        FrsActivity.a(this, nameValuePair.getValue(), (String) null);
                        return true;
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "shouldOverrideUrlLoading", e.getMessage());
            }
        }
        return false;
    }
}

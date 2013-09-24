package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.zeus.ConsoleMessage;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.WebStorage;
import com.baidu.zeus.WebView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CallbackProxy extends Handler {
    private static final int ADD_HISTORY_ITEM = 135;
    private static final int ADD_MESSAGE_TO_CONSOLE = 129;
    private static final int ASYNC_KEYEVENTS = 116;
    private static final int AUTH_CREDENTIALS = 137;
    private static final int AUTH_REQUEST = 104;
    private static final int AUTO_LOGIN = 146;
    private static final int BAIDUPV_COLLECTED = 140;
    private static final int CLIENT_CERT_REQUEST = 147;
    private static final int CLOSE_WINDOW = 110;
    private static final int CREATE_WINDOW = 109;
    private static final int DOWNLOAD_FILE = 118;
    private static final int EXCEEDED_DATABASE_QUOTA = 126;
    private static final int FIRST_LAYOUT_DID = 141;
    private static final int FULLSCREEN_MODE = 144;
    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT = 131;
    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT = 130;
    private static final int GET_VISITED_HISTORY = 133;
    private static final int HAS_VIDEO = 148;
    private static final int HISTORY_INDEX_CHANGED = 136;
    static final int INPUT_TYPE_COLOR = 9000;
    static final int INPUT_TYPE_DATE = 9001;
    static final int INPUT_TYPE_DATETIME = 9003;
    static final int INPUT_TYPE_DATETIME_LOCAL = 9006;
    static final int INPUT_TYPE_MONTH = 9005;
    static final int INPUT_TYPE_TIME = 9002;
    static final int INPUT_TYPE_WEEK = 9004;
    private static final int JS_ALERT = 112;
    private static final int JS_CONFIRM = 113;
    private static final int JS_PICKERDIALOG = 20120201;
    private static final int JS_PROMPT = 114;
    private static final int JS_TIMEOUT = 128;
    private static final int JS_UNLOAD = 115;
    private static final int LOAD_RESOURCE = 108;
    private static final String LOGTAG = "CallbackProxy";
    private static final int MAINACTIONS_COLLECTED = 139;
    private static final int NOTIFY = 200;
    private static final int NOTIFY_DOWNLOAD_FLASH = 202;
    private static final int NOTIFY_PLAY_VIDEO = 201;
    private static final int OPEN_FILE_CHOOSER = 134;
    private static final int OPEN_FLASH_URL = 143;
    private static final int OVERRIDE_URL = 103;
    private static final int PAGE_CAN_BE_SCALED = 142;
    private static final int PAGE_FINISHED = 121;
    private static final int PAGE_STARTED = 100;
    private static final boolean PERF_PROBE = false;
    private static final int PROCEEDED_AFTER_SSL_ERROR = 145;
    private static final int PROGRESS = 106;
    private static final int REACHED_APPCACHE_MAXSIZE = 127;
    private static final int RECEIVED_CERTIFICATE = 124;
    private static final int RECEIVED_ICON = 101;
    private static final int RECEIVED_TITLE = 102;
    private static final int RECEIVED_TOUCH_ICON_URL = 132;
    private static final int REPORT_ERROR = 119;
    private static final int REQUEST_FOCUS = 122;
    private static final int RESEND_POST_DATA = 120;
    private static final int SAVE_PASSWORD = 111;
    private static final int SCALE_CHANGED = 123;
    private static final int SSL_ERROR = 105;
    private static final int SUBJETS_COLLECTED = 138;
    private static final int SWITCH_OUT_HISTORY = 125;
    private static final int UPDATE_VISITED = 107;
    private final Context mContext;
    private volatile DownloadListener mDownloadListener;
    private boolean mProgressUpdatePending;
    private volatile WebBackForwardListClient mWebBackForwardListClient;
    private volatile WebChromeClient mWebChromeClient;
    private long mWebCoreIdleTime;
    private long mWebCoreThreadTime;
    private final WebView mWebView;
    private volatile WebViewClient mWebViewClient;
    private volatile int mLatestProgress = 100;
    public boolean mInStopLoading = false;
    private final WebBackForwardList mBackForwardList = new WebBackForwardList(this);

    /* loaded from: classes.dex */
    class ResultTransport<E> {
        private E mResult;

        public ResultTransport(E e) {
            this.mResult = e;
        }

        public synchronized void setResult(E e) {
            this.mResult = e;
        }

        public synchronized E getResult() {
            return this.mResult;
        }
    }

    public CallbackProxy(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.mWebViewClient = webViewClient;
    }

    public WebViewClient getWebViewClient() {
        return this.mWebViewClient;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.mWebChromeClient = webChromeClient;
    }

    public WebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public WebBackForwardList getBackForwardList() {
        return this.mBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        this.mWebBackForwardListClient = webBackForwardListClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebBackForwardListClient getWebBackForwardListClient() {
        return this.mWebBackForwardListClient;
    }

    public boolean uiOverrideUrlLoading(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.shouldOverrideUrlLoading(this.mWebView, str);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
        try {
            this.mContext.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    public boolean uiOpenFlashUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (this.mWebViewClient != null) {
            Log.e(LOGTAG, "enter uiOpenFlashUrl = " + str);
            return this.mWebViewClient.shouldOpenFlash(this.mWebView, str);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
        try {
            this.mContext.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    public boolean uiOverrideKeyEvent(KeyEvent keyEvent) {
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.shouldOverrideKeyEvent(this.mWebView, keyEvent);
        }
        return false;
    }

    public boolean sendSubjectOnClick(String str, String str2, String str3) {
        if (this.mWebViewClient != null) {
            this.mWebView.setUnderSubject(true);
            return this.mWebViewClient.shouldShowSubject(this.mWebView, str, str2, str3);
        }
        return false;
    }

    public boolean onTextCopied() {
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.onTextCopied(this.mWebView);
        }
        return false;
    }

    public void onSubjectsCollected(boolean z, int i) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(SUBJETS_COLLECTED);
            obtainMessage.getData().putBoolean("enable", z);
            obtainMessage.getData().putInt("count", i);
            sendMessage(obtainMessage);
        }
    }

    public void onFirstLayoutDid(String str) {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(FIRST_LAYOUT_DID, str));
        }
    }

    public void onPageCanBeScaled() {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(PAGE_CAN_BE_SCALED));
        }
    }

    public void onMainActionsCollected(boolean z) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(MAINACTIONS_COLLECTED);
            obtainMessage.getData().putBoolean("enable", z);
            sendMessage(obtainMessage);
        }
    }

    public void onBaiduSearchPVCollected() {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(BAIDUPV_COLLECTED));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        TextView textView;
        String str3;
        String str4;
        String str5;
        switch (message.what) {
            case 100:
                this.mWebView.setCertificate(null);
                this.mWebView.initialSubjectRects();
                this.mWebView.initialSubjectRingScale();
                if (this.mWebView.mStopingLoading) {
                    this.mInStopLoading = true;
                }
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onPageStarted(this.mWebView, message.getData().getString("url"), (Bitmap) message.obj);
                    return;
                }
                return;
            case 101:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.onReceivedIcon(this.mWebView, (Bitmap) message.obj);
                    return;
                }
                return;
            case 102:
                if (this.mWebChromeClient != null) {
                    if (this.mWebView != null && (!this.mWebView.mStopingLoading || this.mInStopLoading)) {
                        this.mWebChromeClient.onReceivedTitle(this.mWebView, (String) message.obj);
                        return;
                    } else {
                        Log.e(LOGTAG, "stoping load title");
                        return;
                    }
                }
                return;
            case 103:
                boolean uiOverrideUrlLoading = uiOverrideUrlLoading(message.getData().getString("url"));
                ResultTransport resultTransport = (ResultTransport) message.obj;
                synchronized (this) {
                    resultTransport.setResult(Boolean.valueOf(uiOverrideUrlLoading));
                    notify();
                }
                return;
            case 104:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onReceivedHttpAuthRequest(this.mWebView, (HttpAuthHandler) message.obj, message.getData().getString("host"), message.getData().getString("realm"));
                    return;
                }
                return;
            case 105:
                if (this.mWebViewClient != null) {
                    HashMap hashMap = (HashMap) message.obj;
                    this.mWebViewClient.onReceivedSslError(this.mWebView, (SslErrorHandler) hashMap.get("handler"), (SslError) hashMap.get("error"));
                    return;
                }
                return;
            case PROGRESS /* 106 */:
                synchronized (this) {
                    if (this.mWebChromeClient != null) {
                        if (this.mWebView != null && !this.mWebView.mStopingLoading) {
                            this.mWebChromeClient.onProgressChanged(this.mWebView, this.mLatestProgress);
                        } else if (this.mInStopLoading && this.mLatestProgress >= this.mWebView.lastProgress) {
                            this.mWebView.mStopingLoading = false;
                            this.mInStopLoading = false;
                            this.mWebView.stopProgressTimer();
                            this.mWebChromeClient.onProgressChanged(this.mWebView, this.mLatestProgress);
                        }
                    }
                    this.mProgressUpdatePending = false;
                }
                return;
            case UPDATE_VISITED /* 107 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.doUpdateVisitedHistory(this.mWebView, (String) message.obj, message.arg1 != 0);
                    return;
                }
                return;
            case LOAD_RESOURCE /* 108 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onLoadResource(this.mWebView, (String) message.obj);
                    return;
                }
                return;
            case CREATE_WINDOW /* 109 */:
                if (this.mWebChromeClient != null) {
                    if (!this.mWebChromeClient.onCreateWindow(this.mWebView, message.arg1 == 1, message.arg2 == 1, (Message) message.obj)) {
                        synchronized (this) {
                            notify();
                        }
                    }
                    this.mWebView.dismissZoomControl();
                    return;
                }
                return;
            case CLOSE_WINDOW /* 110 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.onCloseWindow((WebView) message.obj);
                    return;
                }
                return;
            case SAVE_PASSWORD /* 111 */:
                Bundle data = message.getData();
                if (!this.mWebView.onSavePassword(data.getString("host"), data.getString("username"), data.getString("password"), (Message) message.obj)) {
                    synchronized (this) {
                        notify();
                    }
                    return;
                }
                return;
            case JS_ALERT /* 112 */:
                if (this.mWebChromeClient != null) {
                    final JsResult jsResult = (JsResult) message.obj;
                    String string = message.getData().getString("message");
                    String string2 = message.getData().getString("url");
                    if (!this.mWebChromeClient.onJsAlert(this.mWebView, string2, string, jsResult)) {
                        try {
                            str5 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_js_alert", "string", this.mContext.getPackageName()));
                        } catch (Exception e) {
                            str5 = "OK";
                        }
                        new AlertDialog.Builder(this.mContext).setTitle(getJsDialogTitle(string2)).setMessage(string).setPositiveButton(str5, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsResult.confirm();
                            }
                        }).setCancelable(false).show();
                    }
                    jsResult.setReady();
                    return;
                }
                return;
            case JS_CONFIRM /* 113 */:
                if (this.mWebChromeClient != null) {
                    final JsResult jsResult2 = (JsResult) message.obj;
                    String string3 = message.getData().getString("message");
                    String string4 = message.getData().getString("url");
                    if (!this.mWebChromeClient.onJsConfirm(this.mWebView, string4, string3, jsResult2)) {
                        try {
                            str3 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_js_confirm_ok", "string", this.mContext.getPackageName()));
                            str4 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_js_confirm_cancel", "string", this.mContext.getPackageName()));
                        } catch (Exception e2) {
                            str3 = "OK";
                            str4 = "Cancel";
                        }
                        new AlertDialog.Builder(this.mContext).setTitle(getJsDialogTitle(string4)).setMessage(string3).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsResult2.confirm();
                            }
                        }).setNegativeButton(str4, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsResult2.cancel();
                            }
                        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.zeus.CallbackProxy.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                jsResult2.cancel();
                            }
                        }).show();
                    }
                    jsResult2.setReady();
                    return;
                }
                return;
            case JS_PROMPT /* 114 */:
                if (this.mWebChromeClient != null) {
                    final JsPromptResult jsPromptResult = (JsPromptResult) message.obj;
                    String string5 = message.getData().getString("message");
                    String string6 = message.getData().getString("default");
                    String string7 = message.getData().getString("url");
                    if (!this.mWebChromeClient.onJsPrompt(this.mWebView, string7, string5, string6, jsPromptResult)) {
                        View inflate = LayoutInflater.from(this.mContext).inflate(this.mContext.getResources().getIdentifier("zeus_js_prompt", "layout", this.mContext.getPackageName()), (ViewGroup) null);
                        final EditText editText = (EditText) inflate.findViewById(this.mContext.getResources().getIdentifier("zeus_value", LocaleUtil.INDONESIAN, this.mContext.getPackageName()));
                        if (editText != null) {
                            editText.setText(string6);
                        }
                        int identifier = this.mContext.getResources().getIdentifier("zeus_message", LocaleUtil.INDONESIAN, this.mContext.getPackageName());
                        if (inflate != null && (textView = (TextView) inflate.findViewById(identifier)) != null) {
                            textView.setText(string5);
                        }
                        try {
                            str = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_js_confirm_ok", "string", this.mContext.getPackageName()));
                            str2 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_js_confirm_cancel", "string", this.mContext.getPackageName()));
                        } catch (Exception e3) {
                            str = "OK";
                            str2 = "Cancel";
                        }
                        new AlertDialog.Builder(this.mContext).setTitle(getJsDialogTitle(string7)).setView(inflate).setPositiveButton(str, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (editText != null && editText.getText() != null) {
                                    jsPromptResult.confirm(editText.getText().toString());
                                }
                            }
                        }).setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsPromptResult.cancel();
                            }
                        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.zeus.CallbackProxy.5
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                jsPromptResult.cancel();
                            }
                        }).show();
                    }
                    jsPromptResult.setReady();
                    return;
                }
                return;
            case JS_UNLOAD /* 115 */:
                if (this.mWebChromeClient != null) {
                    final JsResult jsResult3 = (JsResult) message.obj;
                    String string8 = message.getData().getString("message");
                    if (!this.mWebChromeClient.onJsBeforeUnload(this.mWebView, message.getData().getString("url"), string8, jsResult3)) {
                        new AlertDialog.Builder(this.mContext).setMessage("Navigate away from this page?\n\n" + string8 + "\n\nSelect OK to continue, or Cancel to stay on the current page.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.9
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsResult3.confirm();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.CallbackProxy.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                jsResult3.cancel();
                            }
                        }).show();
                    }
                    jsResult3.setReady();
                    return;
                }
                return;
            case ASYNC_KEYEVENTS /* 116 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onUnhandledKeyEvent(this.mWebView, (KeyEvent) message.obj);
                    return;
                }
                return;
            case DOWNLOAD_FILE /* 118 */:
                if (this.mDownloadListener != null) {
                    this.mDownloadListener.onDownloadStart(message.getData().getString("url"), message.getData().getString("userAgent"), message.getData().getString("contentDisposition"), message.getData().getString("mimetype"), Long.valueOf(message.getData().getLong("contentLength")).longValue());
                    return;
                }
                return;
            case REPORT_ERROR /* 119 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onReceivedError(this.mWebView, message.arg1, message.getData().getString("description"), message.getData().getString("failingUrl"));
                    return;
                }
                return;
            case RESEND_POST_DATA /* 120 */:
                Message message2 = (Message) message.getData().getParcelable("resend");
                Message message3 = (Message) message.getData().getParcelable("dontResend");
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onFormResubmission(this.mWebView, message3, message2);
                    return;
                } else {
                    message3.sendToTarget();
                    return;
                }
            case PAGE_FINISHED /* 121 */:
                String str6 = (String) message.obj;
                this.mWebView.onPageFinished(str6);
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onPageFinished(this.mWebView, str6);
                }
                if (!this.mWebView.mStopingLoading || this.mInStopLoading) {
                    this.mInStopLoading = false;
                    this.mWebView.stopProgressTimer();
                    return;
                }
                return;
            case REQUEST_FOCUS /* 122 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.onRequestFocus(this.mWebView);
                    return;
                }
                return;
            case SCALE_CHANGED /* 123 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onScaleChanged(this.mWebView, message.getData().getFloat("old"), message.getData().getFloat("new"));
                    return;
                }
                return;
            case RECEIVED_CERTIFICATE /* 124 */:
                this.mWebView.setCertificate((SslCertificate) message.obj);
                return;
            case SWITCH_OUT_HISTORY /* 125 */:
                this.mWebView.switchOutDrawHistory();
                return;
            case EXCEEDED_DATABASE_QUOTA /* 126 */:
                if (this.mWebChromeClient != null) {
                    HashMap hashMap2 = (HashMap) message.obj;
                    this.mWebChromeClient.onExceededDatabaseQuota((String) hashMap2.get("url"), (String) hashMap2.get("databaseIdentifier"), ((Long) hashMap2.get("currentQuota")).longValue(), ((Long) hashMap2.get("estimatedSize")).longValue(), ((Long) hashMap2.get("totalUsedQuota")).longValue(), (WebStorage.QuotaUpdater) hashMap2.get("quotaUpdater"));
                    return;
                }
                return;
            case 127:
                if (this.mWebChromeClient != null) {
                    HashMap hashMap3 = (HashMap) message.obj;
                    this.mWebChromeClient.onReachedMaxAppCacheSize(((Long) hashMap3.get("spaceNeeded")).longValue(), ((Long) hashMap3.get("totalUsedQuota")).longValue(), (WebStorage.QuotaUpdater) hashMap3.get("quotaUpdater"));
                    return;
                }
                return;
            case 128:
                if (this.mWebChromeClient != null) {
                    JsResult jsResult4 = (JsResult) message.obj;
                    if (this.mWebChromeClient.onJsTimeout()) {
                        jsResult4.confirm();
                    } else {
                        jsResult4.cancel();
                    }
                    jsResult4.setReady();
                    return;
                }
                return;
            case ADD_MESSAGE_TO_CONSOLE /* 129 */:
                String string9 = message.getData().getString("message");
                String string10 = message.getData().getString("sourceID");
                int i = message.getData().getInt("lineNumber");
                int i2 = message.getData().getInt("msgLevel");
                int length = ConsoleMessage.MessageLevel.values().length;
                if (i2 >= 0 && i2 < length) {
                    r2 = i2;
                }
                ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.values()[r2];
                if (!this.mWebChromeClient.onConsoleMessage(new ConsoleMessage(string9, string10, i, messageLevel))) {
                    String str7 = string9 + " at " + string10 + ":" + i;
                    switch (messageLevel) {
                        case TIP:
                            Log.v("Web Console", str7);
                            return;
                        case LOG:
                            Log.i("Web Console", str7);
                            return;
                        case WARNING:
                            Log.w("Web Console", str7);
                            return;
                        case ERROR:
                            Log.e("Web Console", str7);
                            return;
                        case DEBUG:
                            Log.d("Web Console", str7);
                            return;
                        default:
                            return;
                    }
                }
                return;
            case GEOLOCATION_PERMISSIONS_SHOW_PROMPT /* 130 */:
                if (this.mWebChromeClient != null) {
                    HashMap hashMap4 = (HashMap) message.obj;
                    this.mWebChromeClient.onGeolocationPermissionsShowPrompt((String) hashMap4.get("origin"), (GeolocationPermissions.Callback) hashMap4.get("callback"));
                    return;
                }
                return;
            case GEOLOCATION_PERMISSIONS_HIDE_PROMPT /* 131 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
                    return;
                }
                return;
            case RECEIVED_TOUCH_ICON_URL /* 132 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.onReceivedTouchIconUrl(this.mWebView, (String) message.obj, message.arg1 == 1);
                    return;
                }
                return;
            case GET_VISITED_HISTORY /* 133 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.getVisitedHistory((ValueCallback) message.obj);
                    return;
                }
                return;
            case OPEN_FILE_CHOOSER /* 134 */:
                if (this.mWebChromeClient != null) {
                    this.mWebChromeClient.openFileChooser((UploadFile) message.obj);
                    return;
                }
                return;
            case ADD_HISTORY_ITEM /* 135 */:
                if (this.mWebBackForwardListClient != null) {
                    this.mWebBackForwardListClient.onNewHistoryItem((WebHistoryItem) message.obj);
                    return;
                }
                return;
            case HISTORY_INDEX_CHANGED /* 136 */:
                if (this.mWebBackForwardListClient != null) {
                    this.mWebBackForwardListClient.onIndexChanged((WebHistoryItem) message.obj, message.arg1);
                    return;
                }
                return;
            case AUTH_CREDENTIALS /* 137 */:
                this.mWebView.setHttpAuthUsernamePassword(message.getData().getString("host"), message.getData().getString("realm"), message.getData().getString("username"), message.getData().getString("password"));
                return;
            case SUBJETS_COLLECTED /* 138 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onSubjectsCollected(this.mWebView, message.getData().getBoolean("enable"), message.getData().getInt("count"));
                    return;
                }
                return;
            case MAINACTIONS_COLLECTED /* 139 */:
                if (this.mWebViewClient != null) {
                    boolean z = message.getData().getBoolean("enable");
                    this.mWebViewClient.onMainActionsCollected(this.mWebView, z, z ? this.mWebView.getActionNodesCount() : 0);
                    return;
                }
                return;
            case BAIDUPV_COLLECTED /* 140 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onBaiduSearchPVCollected(this.mWebView);
                    return;
                }
                return;
            case FIRST_LAYOUT_DID /* 141 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onFirstLayoutDid(this.mWebView, (String) message.obj);
                    return;
                }
                return;
            case PAGE_CAN_BE_SCALED /* 142 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onPageCanBeScaled(this.mWebView);
                    return;
                }
                return;
            case OPEN_FLASH_URL /* 143 */:
                boolean uiOpenFlashUrl = uiOpenFlashUrl(message.getData().getString("url"));
                ResultTransport resultTransport2 = (ResultTransport) message.obj;
                synchronized (this) {
                    resultTransport2.setResult(Boolean.valueOf(uiOpenFlashUrl));
                    notify();
                }
                return;
            case FULLSCREEN_MODE /* 144 */:
                boolean z2 = message.getData().getBoolean("show");
                int i3 = message.getData().getInt("width");
                int i4 = message.getData().getInt("height");
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onFullScreenMode(this.mWebView, z2, i3, i4);
                    return;
                }
                return;
            case PROCEEDED_AFTER_SSL_ERROR /* 145 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onProceededAfterSslError(this.mWebView, (SslError) message.obj);
                    return;
                }
                return;
            case AUTO_LOGIN /* 146 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onReceivedLoginRequest(this.mWebView, message.getData().getString("realm"), message.getData().getString("account"), message.getData().getString("args"));
                    return;
                }
                return;
            case CLIENT_CERT_REQUEST /* 147 */:
                if (this.mWebViewClient != null) {
                    HashMap hashMap5 = (HashMap) message.obj;
                    this.mWebViewClient.onReceivedClientCertRequest(this.mWebView, (ClientCertRequestHandler) hashMap5.get("handler"), (String) hashMap5.get("host_and_port"));
                    return;
                }
                return;
            case HAS_VIDEO /* 148 */:
                if (this.mWebViewClient != null) {
                    this.mWebViewClient.onHasVideo(this.mWebView);
                    return;
                }
                return;
            case 200:
                synchronized (this) {
                    notify();
                }
                return;
            case NOTIFY_PLAY_VIDEO /* 201 */:
                if (this.mDownloadListener != null) {
                    this.mDownloadListener.onPlayVideo(message.getData().getString("url"));
                    return;
                }
                return;
            case NOTIFY_DOWNLOAD_FLASH /* 202 */:
                if (this.mDownloadListener != null) {
                    this.mDownloadListener.onDownLoadFlash(message.getData().getString("platform"));
                    return;
                }
                return;
            case JS_PICKERDIALOG /* 20120201 */:
                PickerDialog.showDialog(this.mContext, message.getData().getInt("type"), message.getData().getString("default"), (JsPromptResult) message.obj, this.mWebChromeClient);
                return;
            default:
                return;
        }
    }

    public int getProgress() {
        return this.mLatestProgress;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }

    private String getJsDialogTitle(String str) {
        if (URLUtil.isDataUrl(str)) {
            return "JavaScript";
        }
        try {
            new URL(str);
            return " ";
        } catch (MalformedURLException e) {
            return str;
        }
    }

    public void onPageStarted(String str, Bitmap bitmap) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(100);
            obtainMessage.obj = bitmap;
            obtainMessage.getData().putString("url", str);
            sendMessage(obtainMessage);
        }
    }

    public void onPageFinished(String str) {
        sendMessage(obtainMessage(PAGE_FINISHED, str));
    }

    public void onFullScreenMode(boolean z, int i, int i2) {
        Message obtainMessage = obtainMessage(FULLSCREEN_MODE);
        obtainMessage.getData().putBoolean("show", z);
        obtainMessage.getData().putInt("width", i);
        obtainMessage.getData().putInt("height", i2);
        sendMessage(obtainMessage);
    }

    public void hasVideo() {
        sendMessage(obtainMessage(HAS_VIDEO));
    }

    public void onTooManyRedirects(Message message, Message message2) {
    }

    public void onReceivedError(int i, String str, String str2) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(REPORT_ERROR);
            obtainMessage.arg1 = i;
            obtainMessage.getData().putString("description", str);
            obtainMessage.getData().putString("failingUrl", str2);
            sendMessage(obtainMessage);
        }
    }

    public void onFormResubmission(Message message, Message message2) {
        if (this.mWebViewClient == null) {
            message.sendToTarget();
            return;
        }
        Message obtainMessage = obtainMessage(RESEND_POST_DATA);
        Bundle data = obtainMessage.getData();
        data.putParcelable("resend", message2);
        data.putParcelable("dontResend", message);
        sendMessage(obtainMessage);
    }

    public boolean shouldOpenFlash(String str) {
        ResultTransport resultTransport = new ResultTransport(false);
        Message obtainMessage = obtainMessage(OPEN_FLASH_URL);
        obtainMessage.getData().putString("url", str);
        obtainMessage.obj = resultTransport;
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for shouldOpenFlash");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return ((Boolean) resultTransport.getResult()).booleanValue();
    }

    public boolean shouldOverrideUrlLoading(String str) {
        ResultTransport resultTransport = new ResultTransport(false);
        Message obtainMessage = obtainMessage(103);
        obtainMessage.getData().putString("url", str);
        obtainMessage.obj = resultTransport;
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for overrideUrl");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return ((Boolean) resultTransport.getResult()).booleanValue();
    }

    public void onReceivedHttpAuthRequest(HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.mWebViewClient == null) {
            httpAuthHandler.cancel();
            return;
        }
        Message obtainMessage = obtainMessage(104, httpAuthHandler);
        obtainMessage.getData().putString("host", str);
        obtainMessage.getData().putString("realm", str2);
        sendMessage(obtainMessage);
    }

    public void onReceivedSslError(SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mWebViewClient == null) {
            sslErrorHandler.cancel();
            return;
        }
        Message obtainMessage = obtainMessage(105);
        HashMap hashMap = new HashMap();
        hashMap.put("handler", sslErrorHandler);
        hashMap.put("error", sslError);
        obtainMessage.obj = hashMap;
        sendMessage(obtainMessage);
    }

    public void onProceededAfterSslError(SslError sslError) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
            obtainMessage.obj = sslError;
            sendMessage(obtainMessage);
        }
    }

    public void onReceivedClientCertRequest(ClientCertRequestHandler clientCertRequestHandler, String str) {
        if (this.mWebViewClient == null) {
            clientCertRequestHandler.cancel();
            return;
        }
        Message obtainMessage = obtainMessage(CLIENT_CERT_REQUEST);
        HashMap hashMap = new HashMap();
        hashMap.put("handler", clientCertRequestHandler);
        hashMap.put("host_and_port", str);
        obtainMessage.obj = hashMap;
        sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceivedLoginRequest(String str, String str2, String str3) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(AUTO_LOGIN);
            Bundle data = obtainMessage.getData();
            data.putString("realm", str);
            data.putString("account", str2);
            data.putString("args", str3);
            sendMessage(obtainMessage);
        }
    }

    public void onReceivedCertificate(SslCertificate sslCertificate) {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(RECEIVED_CERTIFICATE, sslCertificate));
        }
    }

    public void doUpdateVisitedHistory(String str, boolean z) {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(UPDATE_VISITED, z ? 1 : 0, 0, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebResourceResponse shouldInterceptRequest(String str) {
        if (this.mWebViewClient == null) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.mWebViewClient.shouldInterceptRequest(this.mWebView, str);
        if (shouldInterceptRequest == null) {
            sendMessage(obtainMessage(LOAD_RESOURCE, str));
            return shouldInterceptRequest;
        }
        return shouldInterceptRequest;
    }

    public void onLoadResource(String str) {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(LOAD_RESOURCE, str));
        }
    }

    public void onUnhandledKeyEvent(KeyEvent keyEvent) {
        if (this.mWebViewClient != null) {
            sendMessage(obtainMessage(ASYNC_KEYEVENTS, keyEvent));
        }
    }

    public void onScaleChanged(float f, float f2) {
        if (this.mWebViewClient != null) {
            Message obtainMessage = obtainMessage(SCALE_CHANGED);
            Bundle data = obtainMessage.getData();
            data.putFloat("old", f);
            data.putFloat("new", f2);
            sendMessage(obtainMessage);
        }
    }

    public boolean onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.mDownloadListener == null) {
            return false;
        }
        Message obtainMessage = obtainMessage(DOWNLOAD_FILE);
        Bundle data = obtainMessage.getData();
        data.putString("url", str);
        data.putString("userAgent", str2);
        data.putString("mimetype", str4);
        data.putLong("contentLength", j);
        data.putString("contentDisposition", str3);
        sendMessage(obtainMessage);
        return true;
    }

    public boolean onPlayVideo(String str) {
        if (this.mDownloadListener == null) {
            return false;
        }
        Message obtainMessage = obtainMessage(NOTIFY_PLAY_VIDEO);
        obtainMessage.getData().putString("url", str);
        sendMessage(obtainMessage);
        return true;
    }

    public boolean onDownLoadFlash(String str) {
        if (this.mDownloadListener == null) {
            return false;
        }
        Message obtainMessage = obtainMessage(NOTIFY_DOWNLOAD_FLASH);
        obtainMessage.getData().putString("platform", str);
        sendMessage(obtainMessage);
        return true;
    }

    public boolean onSavePassword(String str, String str2, String str3, Message message) {
        Message obtainMessage = obtainMessage(SAVE_PASSWORD, obtainMessage(200));
        Bundle data = obtainMessage.getData();
        data.putString("host", str);
        data.putString("username", str2);
        data.putString("password", str3);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for onSavePassword");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return false;
    }

    public void onReceivedHttpAuthCredentials(String str, String str2, String str3, String str4) {
        Message obtainMessage = obtainMessage(AUTH_CREDENTIALS);
        obtainMessage.getData().putString("host", str);
        obtainMessage.getData().putString("realm", str2);
        obtainMessage.getData().putString("username", str3);
        obtainMessage.getData().putString("password", str4);
        sendMessage(obtainMessage);
    }

    public void onProgressChanged(int i) {
        synchronized (this) {
            if (this.mWebChromeClient != null && this.mLatestProgress != i) {
                this.mLatestProgress = i;
                if (!this.mProgressUpdatePending) {
                    sendEmptyMessage(PROGRESS);
                    this.mProgressUpdatePending = true;
                }
            }
        }
    }

    public WebView createWindow(boolean z, boolean z2) {
        if (this.mWebChromeClient == null) {
            return null;
        }
        WebView webView = this.mWebView;
        webView.getClass();
        WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtainMessage = obtainMessage(200);
        obtainMessage.obj = webViewTransport;
        synchronized (this) {
            sendMessage(obtainMessage(CREATE_WINDOW, z ? 1 : 0, z2 ? 1 : 0, obtainMessage));
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for createWindow");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        WebView webView2 = webViewTransport.getWebView();
        if (webView2 != null && webView2.getWebViewCore() != null) {
            webView2.getWebViewCore().initializeSubwindow();
            return webView2;
        }
        return webView2;
    }

    public void onRequestFocus() {
        if (this.mWebChromeClient != null) {
            sendEmptyMessage(REQUEST_FOCUS);
        }
    }

    public void onCloseWindow(WebView webView) {
        if (this.mWebChromeClient != null) {
            sendMessage(obtainMessage(CLOSE_WINDOW, webView));
        }
    }

    public void onReceivedIcon(Bitmap bitmap) {
        WebHistoryItem currentItem = this.mBackForwardList.getCurrentItem();
        if (currentItem != null) {
            currentItem.setFavicon(bitmap);
        }
        if (this.mWebChromeClient != null) {
            sendMessage(obtainMessage(101, bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceivedTouchIconUrl(String str, boolean z) {
        WebHistoryItem currentItem = this.mBackForwardList.getCurrentItem();
        if (currentItem != null && (z || currentItem.getTouchIconUrl() == null)) {
            currentItem.setTouchIconUrl(str);
        }
        if (this.mWebChromeClient != null) {
            sendMessage(obtainMessage(RECEIVED_TOUCH_ICON_URL, z ? 1 : 0, 0, str));
        }
    }

    public void onReceivedTitle(String str) {
        if (this.mWebChromeClient != null) {
            sendMessage(obtainMessage(102, str));
        }
    }

    public void onJsAlert(String str, String str2) {
        if (this.mWebChromeClient != null) {
            Message obtainMessage = obtainMessage(JS_ALERT, new JsResult(this, false));
            obtainMessage.getData().putString("message", str2);
            obtainMessage.getData().putString("url", str);
            synchronized (this) {
                sendMessage(obtainMessage);
                try {
                    wait();
                } catch (InterruptedException e) {
                    Log.e(LOGTAG, "Caught exception while waiting for jsAlert");
                    Log.e(LOGTAG, Log.getStackTraceString(e));
                }
            }
        }
    }

    public boolean onJsConfirm(String str, String str2) {
        if (this.mWebChromeClient == null) {
            return false;
        }
        JsResult jsResult = new JsResult(this, false);
        Message obtainMessage = obtainMessage(JS_CONFIRM, jsResult);
        obtainMessage.getData().putString("message", str2);
        obtainMessage.getData().putString("url", str);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsConfirm");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return jsResult.getResult();
    }

    public String onJsPrompt(String str, String str2, String str3) {
        if (this.mWebChromeClient == null) {
            return null;
        }
        JsPromptResult jsPromptResult = new JsPromptResult(this);
        Message obtainMessage = obtainMessage(JS_PROMPT, jsPromptResult);
        obtainMessage.getData().putString("message", str2);
        obtainMessage.getData().putString("default", str3);
        obtainMessage.getData().putString("url", str);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsPrompt");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return jsPromptResult.getStringResult();
    }

    public String onOpenDateTimeOrColorChooser(int i, String str) {
        JsPromptResult jsPromptResult = new JsPromptResult(this);
        Message obtainMessage = obtainMessage(JS_PICKERDIALOG, jsPromptResult);
        obtainMessage.getData().putInt("type", i);
        obtainMessage.getData().putString("default", str);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsPrompt");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return jsPromptResult.getStringResult();
    }

    public boolean onJsBeforeUnload(String str, String str2) {
        if (this.mWebChromeClient == null) {
            return true;
        }
        JsResult jsResult = new JsResult(this, true);
        Message obtainMessage = obtainMessage(JS_UNLOAD, jsResult);
        obtainMessage.getData().putString("message", str2);
        obtainMessage.getData().putString("url", str);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return jsResult.getResult();
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.mWebChromeClient == null) {
            quotaUpdater.updateQuota(j);
            return;
        }
        Message obtainMessage = obtainMessage(EXCEEDED_DATABASE_QUOTA);
        HashMap hashMap = new HashMap();
        hashMap.put("databaseIdentifier", str2);
        hashMap.put("url", str);
        hashMap.put("currentQuota", Long.valueOf(j));
        hashMap.put("estimatedSize", Long.valueOf(j2));
        hashMap.put("totalUsedQuota", Long.valueOf(j3));
        hashMap.put("quotaUpdater", quotaUpdater);
        obtainMessage.obj = hashMap;
        sendMessage(obtainMessage);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.mWebChromeClient == null) {
            quotaUpdater.updateQuota(0L);
            return;
        }
        Message obtainMessage = obtainMessage(127);
        HashMap hashMap = new HashMap();
        hashMap.put("spaceNeeded", Long.valueOf(j));
        hashMap.put("totalUsedQuota", Long.valueOf(j2));
        hashMap.put("quotaUpdater", quotaUpdater);
        obtainMessage.obj = hashMap;
        sendMessage(obtainMessage);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.mWebChromeClient != null) {
            Message obtainMessage = obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
            HashMap hashMap = new HashMap();
            hashMap.put("origin", str);
            hashMap.put("callback", callback);
            obtainMessage.obj = hashMap;
            sendMessage(obtainMessage);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        if (this.mWebChromeClient != null) {
            sendMessage(obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT));
        }
    }

    public void addMessageToConsole(String str, int i, String str2, int i2) {
        if (this.mWebChromeClient != null) {
            Message obtainMessage = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
            obtainMessage.getData().putString("message", str);
            obtainMessage.getData().putString("sourceID", str2);
            obtainMessage.getData().putInt("lineNumber", i);
            obtainMessage.getData().putInt("msgLevel", i2);
            sendMessage(obtainMessage);
        }
    }

    public boolean onJsTimeout() {
        if (this.mWebChromeClient == null) {
            return true;
        }
        JsResult jsResult = new JsResult(this, true);
        Message obtainMessage = obtainMessage(128, jsResult);
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return jsResult.getResult();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.mWebChromeClient != null) {
            Message obtainMessage = obtainMessage(GET_VISITED_HISTORY);
            obtainMessage.obj = valueCallback;
            sendMessage(obtainMessage);
        }
    }

    public String getStringById(int i) {
        if (this.mWebChromeClient == null) {
            return null;
        }
        return this.mWebChromeClient.getStringById(i);
    }

    /* loaded from: classes.dex */
    class UploadFile implements ValueCallback<Uri> {
        private Uri mValue;

        private UploadFile() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.zeus.ValueCallback
        public void onReceiveValue(Uri uri) {
            this.mValue = uri;
            synchronized (CallbackProxy.this) {
                CallbackProxy.this.notify();
            }
        }

        public Uri getResult() {
            return this.mValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri openFileChooser() {
        if (this.mWebChromeClient == null) {
            return null;
        }
        Message obtainMessage = obtainMessage(OPEN_FILE_CHOOSER);
        UploadFile uploadFile = new UploadFile();
        obtainMessage.obj = uploadFile;
        synchronized (this) {
            sendMessage(obtainMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for openFileChooser");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return uploadFile.getResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNewHistoryItem(WebHistoryItem webHistoryItem) {
        if (this.mWebBackForwardListClient != null) {
            sendMessage(obtainMessage(ADD_HISTORY_ITEM, webHistoryItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onIndexChanged(WebHistoryItem webHistoryItem, int i) {
        if (this.mWebBackForwardListClient != null) {
            sendMessage(obtainMessage(HISTORY_INDEX_CHANGED, i, 0, webHistoryItem));
        }
    }
}

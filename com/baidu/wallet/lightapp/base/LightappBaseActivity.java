package com.baidu.wallet.lightapp.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import androidx.core.content.FileProvider;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes5.dex */
public abstract class LightappBaseActivity extends BaseActivity implements NoProguard {
    public static final int CALL_CAMERA_ID_DETECT = 5;
    public static final int CALL_CAMERA_REQUESTCODE = 3;
    public static final int CONTACTS_REQUESTCODE = 4;
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static final int FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 2;
    public static final int INPUT_FILE_GET_CAMMERA_PERMISSION = 101;
    public static final int INPUT_FILE_GET_STORAGE_PERMISSION = 102;
    public static final int INSERT_EVENTS_REQUEST = 6;
    public static int WEBVIEW_ERROR_TIME;

    /* renamed from: e  reason: collision with root package name */
    public Uri f24500e;
    public LightappJsClient mLightappJsClient;
    public List<String> mPhoneContacts;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageForAndroid5;
    public LightappBrowserWebView mWebView;
    public boolean mNeedClearHistory = true;

    /* renamed from: a  reason: collision with root package name */
    public Intent f24496a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f24497b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f24498c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24499d = false;
    public boolean mNeedOverrideUrl = false;
    public long mLangbridgeHash = 0;

    /* loaded from: classes5.dex */
    public class BaseCustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public BaseCustomWebViewClient() {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            LightappBaseActivity lightappBaseActivity = LightappBaseActivity.this;
            if (lightappBaseActivity.mNeedClearHistory) {
                lightappBaseActivity.mWebView.clearHistory();
                if (str == null || str.contains("about:blank")) {
                    return;
                }
                LightappBaseActivity.this.mNeedClearHistory = false;
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LightappBaseActivity.this.mLightappJsClient.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(i + "", str2));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(i + "", str2));
            LogUtil.d("LightappBaseActivity", "onReceivedError.showErrorPage");
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogUtil.d("LightappBaseActivity", "OriginalUrl : " + webView.getOriginalUrl());
            LogUtil.d("LightappBaseActivity", "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                LightappBaseActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                    LightappBaseActivity.this.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GlobalUtils.toast(LightappBaseActivity.this.getActivity(), "请先配置邮箱");
                }
            } else if (!str.toLowerCase(Locale.CHINA).startsWith("http") && !str.toLowerCase(Locale.CHINA).startsWith("https") && !str.toLowerCase(Locale.CHINA).startsWith("file")) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    LightappBaseActivity.this.startActivity(parseUri);
                    return true;
                } catch (Exception e3) {
                    LogUtil.d("LightappBaseActivity", e3.getMessage());
                }
            } else {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LightappBaseActivity.this.mLangbridgeHash, str);
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public abstract com.baidu.wallet.lightapp.multipage.a getBusinessImpl();

    public abstract String getContentLayoutId();

    public abstract String getErrMsg();

    public abstract String getLightappWebviewId();

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f24496a = null;
        this.f24497b = -1;
        if (i == 1) {
            if (this.mUploadMessage == null) {
                return;
            }
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (data != null) {
                this.mUploadMessage.onReceiveValue(data);
            } else {
                this.mUploadMessage.onReceiveValue(this.f24500e);
            }
            this.mUploadMessage = null;
            this.f24500e = null;
        } else if (i == 2) {
            if (this.mUploadMessageForAndroid5 == null) {
                return;
            }
            Uri data2 = (intent == null || i2 != -1) ? null : intent.getData();
            if (data2 != null) {
                this.mUploadMessageForAndroid5.onReceiveValue(new Uri[]{data2});
            } else {
                Uri uri = this.f24500e;
                if (uri != null) {
                    this.mUploadMessageForAndroid5.onReceiveValue(new Uri[]{uri});
                } else {
                    this.mUploadMessageForAndroid5.onReceiveValue(new Uri[0]);
                }
            }
            this.mUploadMessageForAndroid5 = null;
            this.f24500e = null;
        } else if (i == 3) {
            if (i2 == -1) {
                this.mLightappJsClient.onCallCameraPicCallbackLocal();
            }
        } else if (i != 4) {
            if (i == 6) {
                this.mLightappJsClient.onInsertCalendarEventDone(i2 == -1);
            }
        } else if (i2 == -1) {
            if (intent != null && intent.getData() != null) {
                List<String> loadRawPhone = ContactManager.getIContactsImpl().loadRawPhone(intent.getData(), getActivity());
                this.mPhoneContacts = loadRawPhone;
                if (loadRawPhone != null && loadRawPhone.size() > 1) {
                    if (this.mPhoneContacts.size() == 2) {
                        String str = this.mPhoneContacts.get(0);
                        String str2 = this.mPhoneContacts.get(1);
                        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                            str = "";
                        }
                        this.mLightappJsClient.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                        return;
                    }
                    prepareSelectNumDialog(this.mPhoneContacts, new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.base.LightappBaseActivity.1
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                            if (i3 <= 0 || i3 >= LightappBaseActivity.this.mPhoneContacts.size()) {
                                return;
                            }
                            String replace = LightappBaseActivity.this.mPhoneContacts.get(i3).replace(" ", "").replace("-", "");
                            LightappBaseActivity lightappBaseActivity = LightappBaseActivity.this;
                            lightappBaseActivity.mLightappJsClient.onContactsSelectedLocal(0, new String[]{lightappBaseActivity.mPhoneContacts.get(0), replace}, "");
                        }
                    });
                    return;
                }
            }
            this.mLightappJsClient.onContactsSelectedLocal(1, null, getErrMsg());
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null && lightappBrowserWebView.canGoBack()) {
            LogUtil.d("LightappBaseActivity", "cangoback:  " + this.mWebView.getUrl());
            this.mWebView.goBack();
            onWebViewBack();
            this.mNeedOverrideUrl = true;
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(ResUtils.layout(getActivity(), getContentLayoutId()));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            WEBVIEW_ERROR_TIME++;
            if (!stackTraceString.contains("NameNotFoundException: com.android.webview") && !stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") && !stackTraceString.contains("MissingWebViewPackageException: Failed to load WebView provider")) {
                if (WEBVIEW_ERROR_TIME >= 3) {
                    Toast.makeText(getActivity(), ResUtils.getString(this, "langbridge_webview_error2"), 1).show();
                }
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(th.getMessage(), "1", "" + WEBVIEW_ERROR_TIME, stackTraceString));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(th.getMessage(), "1", "" + WEBVIEW_ERROR_TIME, stackTraceString));
            } else {
                Toast.makeText(getActivity(), ResUtils.getString(this, "langbridge_webview_error"), 1).show();
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(th.getMessage(), "0", "" + WEBVIEW_ERROR_TIME, stackTraceString));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(th.getMessage(), "0", "" + WEBVIEW_ERROR_TIME, stackTraceString));
            }
        }
        LightappBrowserWebView lightappBrowserWebView = (LightappBrowserWebView) findViewById(ResUtils.id(getActivity(), getLightappWebviewId()));
        this.mWebView = lightappBrowserWebView;
        if (lightappBrowserWebView == null) {
            return;
        }
        lightappBrowserWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDatabaseEnabled(true);
        this.mWebView.getSettings().setGeolocationDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        setSupportZoom();
        this.mWebView.getSettings().setTextZoom(100);
        this.mWebView.getSettings().setGeolocationEnabled(true);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.clearCache(false);
        this.mWebView.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        LightappJsClient lightappJsClient = new LightappJsClient(getBusinessImpl(), this.mWebView);
        this.mLightappJsClient = lightappJsClient;
        this.mWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LightappJsClient lightappJsClient = this.mLightappJsClient;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        if (this.mWebView == null || LightappWebViewCenter.getInstance().releaseLightappWebView(this, this.mWebView)) {
            return;
        }
        this.mWebView.removeAllViews();
        ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mWebView);
        }
        this.mWebView.clearHistory();
        this.mWebView.destroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mLightappJsClient.onRequestPermissionsResultLocal(i, strArr, iArr);
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        if (i != 101) {
            if (i == 102) {
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (iArr[i2] != 0) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    a(this.f24498c, this.f24499d, this.f24497b);
                    this.f24498c = "";
                    this.f24499d = false;
                    this.f24497b = -1;
                }
            }
            z = false;
        } else if (iArr[0] == 0) {
            Intent intent = this.f24496a;
            if (intent != null) {
                startActivityForResult(intent, this.f24497b);
            }
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.f24497b == 1) {
                ValueCallback<Uri> valueCallback = this.mUploadMessage;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.mUploadMessage = null;
                }
                this.f24500e = null;
            } else if (i == 2) {
                ValueCallback<Uri[]> valueCallback2 = this.mUploadMessageForAndroid5;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(new Uri[0]);
                    this.mUploadMessageForAndroid5 = null;
                }
                this.f24500e = null;
            }
        }
    }

    public abstract void onWebViewBack();

    public abstract void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener);

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.getSettings().setDisplayZoomControls(false);
        } else {
            setZoomControlGone(this.mWebView);
        }
        this.mWebView.getSettings().setUseWideViewPort(true);
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalAccessException e2) {
                LogUtil.d(e2.getMessage());
            } catch (IllegalArgumentException e3) {
                LogUtil.d(e3.getMessage());
            }
        } catch (NoSuchFieldException e4) {
            LogUtil.d(e4.getMessage());
        } catch (SecurityException e5) {
            LogUtil.d(e5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r14.equals("image") != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, boolean z, int i) {
        Intent intent;
        Intent intent2;
        if (!PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") && !PermissionManager.checkCallingPermission(getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            this.f24498c = str;
            this.f24499d = z;
            this.f24497b = i;
            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.base.LightappBaseActivity.2
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LightappBaseActivity.this.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 102);
                    } else {
                        LightappBaseActivity.this.onRequestPermissionsResult(102, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str2, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str2, Boolean bool) {
                }
            });
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        PackageManager packageManager = getPackageManager();
        String[] split = str.split("/");
        if (split == null || split.length <= 0) {
            return;
        }
        char c2 = 0;
        if (TextUtils.isEmpty(split[0])) {
            return;
        }
        if (z) {
            String str2 = split[0];
            int hashCode = str2.hashCode();
            if (hashCode == 93166550) {
                if (str2.equals("audio")) {
                    c2 = 2;
                    if (c2 != 0) {
                    }
                    intent = intent2;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                intent = intent2;
            } else if (hashCode != 100313435) {
                if (hashCode == 112202875 && str2.equals("video")) {
                    c2 = 1;
                    if (c2 != 0) {
                        File file = new File(externalStoragePublicDirectory + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg");
                        if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                            Activity activity = getActivity();
                            this.f24500e = FileProvider.getUriForFile(activity, getPackageName() + ".fileprovider", file);
                        } else {
                            Activity activity2 = getActivity();
                            this.f24500e = FileProvider.getUriForFile(activity2, getPackageName() + ".langbrigeProvider", file);
                        }
                        grantUriPermission(getPackageName(), this.f24500e, 3);
                        intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent2.putExtra("output", this.f24500e);
                        if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                            this.f24496a = intent2;
                            this.f24497b = i;
                            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.base.LightappBaseActivity.3
                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isAllAgree(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        PermissionManager.checkCallingOrSelfPermission(LightappBaseActivity.this.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                    } else {
                                        LightappBaseActivity.this.onRequestPermissionsResult(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                    }
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isShow(String str3, Boolean bool) {
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void requestResult(String str3, Boolean bool) {
                                }
                            });
                            return;
                        }
                    } else if (c2 == 1) {
                        File file2 = new File(externalStoragePublicDirectory + File.separator + "video_" + System.currentTimeMillis() + ".mp4");
                        if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                            Activity activity3 = getActivity();
                            this.f24500e = FileProvider.getUriForFile(activity3, getPackageName() + ".fileprovider", file2);
                        } else {
                            Activity activity4 = getActivity();
                            this.f24500e = FileProvider.getUriForFile(activity4, getPackageName() + ".langbrigeProvider", file2);
                        }
                        grantUriPermission(getPackageName(), this.f24500e, 3);
                        intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
                        intent2.putExtra("output", this.f24500e);
                        if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                            this.f24496a = intent2;
                            this.f24497b = i;
                            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.base.LightappBaseActivity.4
                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isAllAgree(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        PermissionManager.checkCallingOrSelfPermission(LightappBaseActivity.this.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                    } else {
                                        LightappBaseActivity.this.onRequestPermissionsResult(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                    }
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isShow(String str3, Boolean bool) {
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void requestResult(String str3, Boolean bool) {
                                }
                            });
                            return;
                        }
                    } else if (c2 != 2) {
                        intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.setType(str);
                    } else {
                        intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
                    }
                    intent = intent2;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                intent = intent2;
            }
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(str);
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, i);
        }
    }

    /* loaded from: classes5.dex */
    public class BaseCustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public BaseCustomChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes;
            LightappBaseActivity.this.mUploadMessageForAndroid5 = valueCallback;
            if (fileChooserParams == null || (acceptTypes = fileChooserParams.getAcceptTypes()) == null || acceptTypes.length <= 0 || TextUtils.isEmpty(acceptTypes[0])) {
                return true;
            }
            LightappBaseActivity.this.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            if (intent.resolveActivity(LightappBaseActivity.this.getPackageManager()) != null) {
                LightappBaseActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
            } else {
                PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            if (intent.resolveActivity(LightappBaseActivity.this.getPackageManager()) != null) {
                LightappBaseActivity.this.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
            } else {
                PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            LightappBaseActivity.this.a(str, !TextUtils.isEmpty(str2), 1);
        }
    }
}

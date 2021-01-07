package com.baidu.webkit.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.Statistics;
import com.baidu.webkit.internal.e;
import com.baidu.webkit.sdk.WebViewProvider;
import com.baidu.webkit.sdk.jsapi.IJsAbility;
import com.baidu.webkit.sdk.jsapi.ZeusJsBridge;
import com.baidu.webkit.sdk.performance.PagePerformanceTiming;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.baidu.webkit.sdk.system.WebViewImpl;
import java.io.BufferedWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class WebView extends AbsoluteLayout implements View.OnLongClickListener, ViewGroup.OnHierarchyChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final String DATA_REDUCTION_PROXY_SETTING_CHANGED = "com.baidu.webkit.sdk.DATA_REDUCTION_PROXY_SETTING_CHANGED";
    private static final String JAVASCTIPT_URL = "javascript:";
    private static final String LOGTAG = "WebView";
    public static final int RENDERER_PRIORITY_BOUND = 1;
    public static final int RENDERER_PRIORITY_IMPORTANT = 2;
    public static final int RENDERER_PRIORITY_WAIVED = 0;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_MODERATE = 1;
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_NONE = 0;
    private static volatile boolean sEnforceThreadChecking;
    private boolean mDestroyed;
    private FindListenerDistributor mFindListener;
    public boolean mHasPerformedLongPress;
    private boolean mIsPrivateInit;
    private JSInterfaceStatistics mJSInterfaceStatistics;
    private ZeusJsBridge mJsBridge;
    private boolean mOnViewHierarchy;
    private WebViewProvider mProvider;
    private e mSecureProcessor;
    private int mSetOverScrollModeBeforeProviderReady;
    private int mSoftInputMode;
    private Statistics.Client mStatisticClient;
    private WebViewDelegate mViewDelegate;
    private final Looper mWebViewThread;

    /* loaded from: classes15.dex */
    public final class DelegateAdapter implements WebViewProvider.ScrollDelegate, WebViewProvider.ViewDelegate {
        private final WebViewImpl mChildView;

        public DelegateAdapter(WebViewImpl webViewImpl) {
            this.mChildView = webViewImpl;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeHorizontalScrollOffset() {
            return WebView.super.computeHorizontalScrollOffset();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeHorizontalScrollRange() {
            return WebView.super.computeHorizontalScrollRange();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final void computeScroll() {
            WebView.super.computeScroll();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollExtent() {
            return this.mChildView.computeVerticalScrollExtent();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollOffset() {
            return this.mChildView.computeVerticalScrollOffset();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollRange() {
            return this.mChildView.computeVerticalScrollRange();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return WebView.super.dispatchKeyEvent(keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final View findFocus(View view) {
            return this.mChildView.findFocus();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
            if (Build.VERSION.SDK_INT >= 16) {
                return WebView.super.getAccessibilityNodeProvider();
            }
            return null;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final Handler getHandler(Handler handler) {
            return this.mChildView.getHandler();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final AbsoluteLayout getWebViewImpl() {
            return this.mChildView;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onAttachedToWindow() {
            WebView.super.onAttachedToWindow();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onCheckIsTextEditor() {
            return this.mChildView.onCheckIsTextEditor();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onConfigurationChanged(Configuration configuration) {
            WebView.super.onConfigurationChanged(configuration);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return WebView.super.onCreateInputConnection(editorInfo);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDetachedFromWindow() {
            WebView.super.onDetachedFromWindow();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onDragEvent(DragEvent dragEvent) {
            return WebView.super.onDragEvent(dragEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDraw(Canvas canvas) {
            WebView.super.onDraw(canvas);
            ((android.webkit.WebView) WebView.this.mProvider).draw(canvas);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setBounds(i, i2, i3, i4);
            drawable.draw(canvas);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onFinishTemporaryDetach() {
            WebView.super.onFinishTemporaryDetach();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            WebView.super.onFocusChanged(z, i, rect);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
            if (Build.VERSION.SDK_INT >= 12) {
                return WebView.super.onGenericMotionEvent(motionEvent);
            }
            return false;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            if (Build.VERSION.SDK_INT >= 14) {
                return WebView.super.onHoverEvent(motionEvent);
            }
            return false;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            WebView.super.onInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            WebView.super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.mChildView.super_onInterceptTouchEvent(motionEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            return WebView.super.onKeyDown(i, keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
            return WebView.super.onKeyMultiple(i, i2, keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyUp(int i, KeyEvent keyEvent) {
            return WebView.super.onKeyUp(i, keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onMeasure(int i, int i2) {
            WebView.super.onMeasure(i, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            this.mChildView.super_onOverScrolled(i, i2, z, z2);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onProvideVirtualStructure(ViewStructure viewStructure) {
            WebView.super.onProvideVirtualStructure(viewStructure);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            this.mChildView.super_onScrollChanged(i, i2, i3, i4);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            WebView.super.onSizeChanged(i3, i4, i3, i4);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onStartTemporaryDetach() {
            WebView.super.onStartTemporaryDetach();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mChildView.super_onTouchEvent(motionEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onTrackballEvent(MotionEvent motionEvent) {
            return WebView.super.onTrackballEvent(motionEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onVisibilityChanged(View view, int i) {
            WebView.super.onVisibilityChanged(view, i);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onWindowFocusChanged(boolean z) {
            WebView.super.onWindowFocusChanged(z);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onWindowVisibilityChanged(int i) {
            WebView.super.onWindowVisibilityChanged(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean performAccessibilityAction(int i, Bundle bundle) {
            return WebView.super.performAccessibilityAction(i, bundle);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean performLongClick() {
            return this.mChildView.super_performLongClick();
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void preDispatchDraw(Canvas canvas) {
            WebView.super.dispatchDraw(canvas);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
            return WebView.super.requestChildRectangleOnScreen(view, rect, z);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean requestFocus(int i, Rect rect) {
            WebView.super.requestFocus(i, rect);
            return this.mChildView.requestFocus(i, rect);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setBackgroundColor(int i) {
            WebView.super.setBackgroundColor(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean setFrame(int i, int i2, int i3, int i4) {
            return false;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setLayerType(int i, Paint paint) {
            if (Build.VERSION.SDK_INT >= 11) {
                WebView.super.setLayerType(i, paint);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            WebView.super.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setOverScrollMode(int i) {
            WebView.super.setOverScrollMode(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setScrollBarStyle(int i) {
            WebView.super.setScrollBarStyle(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean shouldDelayChildPressedState() {
            if (Build.VERSION.SDK_INT >= 14) {
                return WebView.super.shouldDelayChildPressedState();
            }
            return false;
        }
    }

    /* loaded from: classes15.dex */
    public interface FindListener {
        void onFindResultReceived(int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class FindListenerDistributor implements FindListener {
        private FindListener mFindDialogFindListener;
        private FindListener mUserFindListener;

        private FindListenerDistributor() {
        }

        @Override // com.baidu.webkit.sdk.WebView.FindListener
        public void onFindResultReceived(int i, int i2, boolean z) {
            if (this.mFindDialogFindListener != null) {
                this.mFindDialogFindListener.onFindResultReceived(i, i2, z);
            }
            if (this.mUserFindListener != null) {
                this.mUserFindListener.onFindResultReceived(i, i2, z);
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int NORMAL_TEXT_TYPE = 10;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TEXT_TYPE = 12;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int SRC_JS_ANCHOR_TYPE = 11;
        public static final int UNKNOWN_TYPE = 0;
        private String mExtra;
        private String mExtra2;
        private String mFirstNavigationUrl;
        private String mFrameUrl;
        private boolean mIsSelectable;
        private boolean mIsTextNode;
        private String mOriginFrameSrcUrl;
        private String mOriginLinkUrl;
        private String mOriginSrcUrl;
        private String mPageUrl;
        private int mType = 0;

        public String getExtra() {
            return this.mExtra;
        }

        public String getExtra2() {
            return this.mExtra2;
        }

        public String getFirstNavigationUrl() {
            return this.mFirstNavigationUrl;
        }

        public String getFrameUrl() {
            return this.mFrameUrl;
        }

        public String getOriginFrameSrcUrl() {
            return this.mOriginFrameSrcUrl;
        }

        public String getOriginLinkUrl() {
            return this.mOriginLinkUrl;
        }

        public String getOriginSrcUrl() {
            return this.mOriginSrcUrl;
        }

        public String getPageUrl() {
            return this.mPageUrl;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isSelectable() {
            return this.mIsSelectable;
        }

        public boolean isTextNode() {
            return this.mIsTextNode;
        }

        public void setExtra(String str) {
            this.mExtra = str;
        }

        public void setExtra2(String str) {
            this.mExtra2 = str;
        }

        public void setFirstNavigationUrl(String str) {
            this.mFirstNavigationUrl = str;
        }

        public void setFrameUrl(String str) {
            this.mFrameUrl = str;
        }

        public void setIsSelectable(boolean z) {
            this.mIsSelectable = z;
        }

        public void setIsTextNode(boolean z) {
            this.mIsTextNode = z;
        }

        public void setOriginFrameSrcUrl(String str) {
            this.mOriginFrameSrcUrl = str;
        }

        public void setOriginLinkUrl(String str) {
            this.mOriginLinkUrl = str;
        }

        public void setOriginSrcUrl(String str) {
            this.mOriginSrcUrl = str;
        }

        public void setPageUrl(String str) {
            this.mPageUrl = str;
        }

        public void setType(int i) {
            this.mType = i;
        }
    }

    /* loaded from: classes15.dex */
    public interface IVirtualMemoryListener {
        void onVirtualMemoryPressure(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class JSInterfaceStatistics implements Statistics.Record {
        protected HashMap<String, String> mJSInfo;

        private JSInterfaceStatistics() {
            this.mJSInfo = new HashMap<>();
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public int getType() {
            return Statistics.MONITOR_TYPE_ADD_JAVA_SCRIPT;
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public String getUrl() {
            return "";
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public String toJSON() {
            try {
                if (this.mJSInfo != null && this.mJSInfo.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", Statistics.MONITOR_TYPE_ADD_JAVA_SCRIPT);
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.mJSInfo.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", entry.getKey());
                        jSONObject2.put("callstack", entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject.toString();
                }
            } catch (JSONException e) {
            }
            return "";
        }
    }

    /* loaded from: classes15.dex */
    public interface MainResourcePrefetchListener {
        void onPrefetchFinished(String str, long j, boolean z, String str2, int i);
    }

    /* loaded from: classes15.dex */
    public interface OnDragListener {
        boolean onDrag(View view, DragEvent dragEvent);
    }

    /* loaded from: classes15.dex */
    public interface OnGenericMotionListener {
        boolean onGenericMotion(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes15.dex */
    public interface OnHoverListener {
        boolean onHover(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes15.dex */
    public interface OnSystemUiVisibilityChangeListener {
        void onSystemUiVisibilityChange(int i);
    }

    /* loaded from: classes15.dex */
    public class PageInfo {
        public PageInfo() {
        }

        public byte[] getBody() {
            return null;
        }

        public String getHeader() {
            return null;
        }

        public String getIp() {
            return null;
        }

        public String getTime() {
            return null;
        }

        public String getUrl() {
            return null;
        }
    }

    @Deprecated
    /* loaded from: classes15.dex */
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    /* loaded from: classes15.dex */
    public enum PrerenderStatus {
        STARTED,
        FAILED,
        JUMPED,
        FINISHED
    }

    /* loaded from: classes15.dex */
    public class PrivateAccess {
        public PrivateAccess() {
        }

        public void awakenScrollBars(int i) {
            WebView.this.awakenScrollBars(i);
        }

        public void awakenScrollBars(int i, boolean z) {
            WebView.this.awakenScrollBars(i, z);
        }

        public float getHorizontalScrollFactor() {
            try {
                return ((Float) Class.forName("android.view.View").getMethod("getHorizontalScrollFactor", new Class[0]).invoke(WebView.this, null)).floatValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 1.0f;
            }
        }

        public int getHorizontalScrollbarHeight() {
            return WebView.this.getHorizontalScrollbarHeight();
        }

        public float getVerticalScrollFactor() {
            try {
                return ((Float) Class.forName("android.view.View").getMethod("getVerticalScrollFactor", new Class[0]).invoke(WebView.this, null)).floatValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 1.0f;
            }
        }

        public boolean isPrivateInit() {
            return WebView.this.mIsPrivateInit;
        }

        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            WebView.this.onOverScrolled(i, i2, z, z2);
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            WebView.this.onScrollChanged(i, i2, i3, i4);
        }

        public void overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            try {
                WebView.this.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            WebView.this.setMeasuredDimension(i, i2);
        }

        public void super_computeScroll() {
            WebView.super.computeScroll();
        }

        public boolean super_dispatchKeyEvent(KeyEvent keyEvent) {
            return WebView.super.dispatchKeyEvent(keyEvent);
        }

        public int super_getScrollBarStyle() {
            return WebView.super.getScrollBarStyle();
        }

        public void super_onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setBounds(i, i2, i3, i4);
            drawable.draw(canvas);
        }

        public boolean super_onGenericMotionEvent(MotionEvent motionEvent) {
            return WebView.super.onGenericMotionEvent(motionEvent);
        }

        public boolean super_onHoverEvent(MotionEvent motionEvent) {
            return WebView.super.onHoverEvent(motionEvent);
        }

        public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
            return WebView.super.onInterceptTouchEvent(motionEvent);
        }

        public boolean super_performAccessibilityAction(int i, Bundle bundle) {
            return WebView.super.performAccessibilityAction(i, bundle);
        }

        public boolean super_performLongClick() {
            return WebView.super.performLongClick();
        }

        public boolean super_requestFocus(int i, Rect rect) {
            return WebView.super.requestFocus(i, rect);
        }

        public void super_scrollTo(int i, int i2) {
            WebView.super.scrollTo(i, i2);
        }

        public boolean super_setFrame(int i, int i2, int i3, int i4) {
            return false;
        }

        public void super_setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            WebView.super.setLayoutParams(layoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface RendererPriority {
    }

    /* loaded from: classes15.dex */
    public enum SaveAsType {
        SAVE_AS_WEB_ARCHIVE,
        SAVE_AS_HTML_FOLDER,
        SAVE_AS_HTML_ONLY
    }

    /* loaded from: classes15.dex */
    public static abstract class VisualStateCallback {
        public abstract void onComplete(long j);
    }

    /* loaded from: classes15.dex */
    public class WebPageInfoList {
        public WebPageInfoList() {
        }

        public ArrayList<PageInfo> getWebPageInfoList() {
            return null;
        }
    }

    /* loaded from: classes15.dex */
    public enum WebViewState {
        NORMAL_WEBVIEW_STATE,
        SINGLE_WEBVIEW_STATE,
        MULTIPLE_WEBVIEW_STATE
    }

    /* loaded from: classes15.dex */
    public class WebViewTransport {
        private final Object lockObject = new Object();
        private WebView mWebview;

        public WebViewTransport() {
        }

        public WebView getWebView() {
            WebView webView;
            synchronized (this.lockObject) {
                webView = this.mWebview;
            }
            return webView;
        }

        public void setWebView(WebView webView) {
            synchronized (this.lockObject) {
                this.mWebview = webView;
            }
        }
    }

    /* loaded from: classes15.dex */
    public enum WebViewType {
        NORMAL,
        BIGPLUGIN
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Resources.getSystem().getIdentifier("webViewStyle", "attr", HttpConstants.OS_TYPE_VALUE));
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(21)
    public WebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        initWebView(context, null, false);
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        initWebView(context, null, z);
    }

    public WebView(Context context, boolean z) {
        super(context, null, Resources.getSystem().getIdentifier("webViewStyle", "attr", HttpConstants.OS_TYPE_VALUE));
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        this.mIsPrivateInit = z;
        initWebView(context, null, false);
    }

    public static void AdBlockInitInternel(String str, boolean z) {
        getFactory().getStatics().AdBlockInit(str, z);
    }

    public static void addToWebCache(String str, boolean z, Map<String, String> map) {
        getFactory().getStatics().addToWebCache(str, z, true, map);
    }

    public static void addToWebCache(String str, boolean z, boolean z2) {
        getFactory().getStatics().addToWebCache(str, z, z2, null);
    }

    public static void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map) {
        getFactory().getStatics().addToWebCache(str, z, z2, map);
    }

    public static void addVirtualMemoryListener(IVirtualMemoryListener iVirtualMemoryListener) {
        getFactory().getStatics().addVirtualMemoryListener(iVirtualMemoryListener);
    }

    public static void cancelPrefetch(String str) {
        getFactory().getStatics().cancelPrefetch(str);
    }

    public static void cancelResourcePrefetch(String str) {
        getFactory().getStatics().cancelResourcePrefetch(str);
    }

    private void checkThread() {
        if (this.mWebViewThread == null || Looper.myLooper() == this.mWebViewThread) {
            return;
        }
        Throwable th = new Throwable("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + this.mWebViewThread + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
        Log.w(LOGTAG, android.util.Log.getStackTraceString(th));
        if (sEnforceThreadChecking) {
            throw new RuntimeException(th);
        }
    }

    public static void clearAllTextureCacheAndGLResource() {
    }

    public static void clearClientCertPreferences(Runnable runnable) {
        getFactory().getStatics().clearClientCertPreferences(runnable);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
    }

    public static void disableWebView() {
        WebViewFactory.disableWebView();
    }

    @Deprecated
    public static void enablePlatformNotifications() {
    }

    public static void enableSlowWholeDocumentDraw() {
        getFactory().getStatics().enableSlowWholeDocumentDraw();
    }

    private void ensureProviderCreated() {
        checkThread();
        if (this.mProvider == null) {
            this.mProvider = getFactory().createWebView(this, new PrivateAccess());
        }
    }

    @Nullable
    @Deprecated
    public static String findAddress(String str) {
        return getFactory().getStatics().findAddress(str);
    }

    public static HashMap<String, Long> getCurrentSystemInfraInfo() {
        return getFactory().getStatics().getCurrentSystemInfraInfo();
    }

    @Nullable
    public static PackageInfo getCurrentWebViewPackage() {
        PackageInfo loadedPackageInfo = WebViewFactory.getLoadedPackageInfo();
        if (loadedPackageInfo != null) {
            return loadedPackageInfo;
        }
        return null;
    }

    private boolean getEnableJsPrompt() {
        boolean z;
        try {
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            z = false;
        } catch (Throwable th) {
            Log.e(LOGTAG, "getStaticWebSeting error:" + th);
        }
        if (WebViewFactory.hasProvider()) {
            z = ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT)).booleanValue();
            return z && getSettings().getEnableJsPrompt();
        }
        z = false;
        if (z) {
            return false;
        }
    }

    private static synchronized WebViewFactoryProvider getFactory() {
        WebViewFactoryProvider provider;
        synchronized (WebView.class) {
            provider = WebViewFactory.getProvider();
        }
        return provider;
    }

    private JSInterfaceStatistics getJSInterfaceStatistics() {
        if (this.mJSInterfaceStatistics == null) {
            this.mJSInterfaceStatistics = new JSInterfaceStatistics();
        }
        return this.mJSInterfaceStatistics;
    }

    @NonNull
    public static ClassLoader getWebViewClassLoader() {
        return getFactory().getWebViewClassLoader();
    }

    public static String getZeusSeriesNum(int i, int i2, int i3) {
        return getFactory().getStatics().getZeusSeriesNum(i, i2, i3);
    }

    public static boolean hasGPU() {
        return true;
    }

    private void initWebView(Context context, Map<String, Object> map, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (!this.mIsPrivateInit) {
            if (WebViewFactory.isZeusProvider()) {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_WEBVIEW_METHOD);
            } else {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_SYS_WEBVIEW);
            }
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        }
        sEnforceThreadChecking = context.getApplicationInfo().targetSdkVersion >= 18;
        checkThread();
        ensureProviderCreated();
        if (!this.mIsPrivateInit) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_INIT);
        }
        this.mProvider.init(map, z);
        if (!this.mIsPrivateInit) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_INIT);
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_WEBVIEW_DEFAULT_SETTINGS);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setScrollbarFadingEnabled(true);
        setScrollBarStyle(0);
        setOverScrollMode(0);
        getSettings().initDefaultSettings(context, WebViewFactory.getProvider());
        if (!this.mProvider.isZeusWebViewProvider()) {
            super.addView(getWebView(), -1, -1);
            setOnLongClickListener(this);
        }
        if (this.mSetOverScrollModeBeforeProviderReady != -1) {
            this.mProvider.getViewDelegate().setOverScrollMode(this.mSetOverScrollModeBeforeProviderReady);
            this.mSetOverScrollModeBeforeProviderReady = -1;
        }
        CookieSyncManager.setGetInstanceIsAllowed();
        this.mJsBridge = new ZeusJsBridge(this);
        this.mJsBridge.init();
        if (!this.mIsPrivateInit) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_WEBVIEW_DEFAULT_SETTINGS);
            if (WebViewFactory.isZeusProvider()) {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_WEBVIEW_METHOD);
            } else {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_SYS_WEBVIEW);
            }
        }
        if (WebViewFactory.isZeusProvider()) {
            ZeusWebViewPreloadClass.getInstance().flushLoadClassesToFile();
        }
    }

    public static boolean isInWebCache(String str) {
        return getFactory().getStatics().isInWebCache(str);
    }

    public static void makeMF30Inited() {
        getFactory().getStatics().makeMF30Inited();
    }

    public static void onMemoryPresure() {
        getFactory().getStatics().onMemoryPresure(2, null);
    }

    public static void onMemoryPresure(int i, Activity activity) {
        getFactory().getStatics().onMemoryPresure(i, activity);
    }

    private void onOverScrolledDelegate(int i, int i2, boolean z, boolean z2) {
        if (this.mViewDelegate != null) {
            this.mViewDelegate.onOverScrolled(i, i2, z, z2);
        } else {
            onOverScrolledSuper(i, i2, z, z2);
        }
    }

    private void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        if (this.mViewDelegate != null) {
            this.mViewDelegate.onScrollChanged(i, i2, i3, i4);
        } else {
            onScrollChangedSuper(i, i2, i3, i4);
        }
    }

    private boolean onTouchEventDelegate(MotionEvent motionEvent) {
        return this.mViewDelegate != null ? this.mViewDelegate.onTouchEvent(motionEvent) : onTouchEventSuper(motionEvent);
    }

    private void pauseDraw() {
    }

    public static void preconnectUrl(String str, Context context) {
        if (!WebViewFactory.hasProvider()) {
        }
    }

    public static void prefetch(String str, Map<String, String> map, MainResourcePrefetchListener mainResourcePrefetchListener) {
        getFactory().getStatics().prefetch(str, map, mainResourcePrefetchListener);
    }

    public static void prefetchResource(String str, String[] strArr, Map<String, String> map) {
        getFactory().getStatics().prefetchResource(str, strArr, map);
    }

    public static void removeFromWebCache(String str) {
        getFactory().getStatics().removeFromWebCache(str);
    }

    public static void removeVirtualMemoryWatcher(IVirtualMemoryListener iVirtualMemoryListener) {
        getFactory().getStatics().removeVirtualMemoryWatcher(iVirtualMemoryListener);
    }

    public static void resolveUrl(String str, Context context) {
        if (WebViewFactory.hasProvider()) {
            getFactory().getStatics().resolveUrl(str);
        }
    }

    private void resumeDraw() {
    }

    public static void setDataDirectorySuffix(String str) {
        if (str == null) {
            Log.e(LOGTAG, "suffix is null", new IllegalArgumentException("null"));
            return;
        }
        setDataDirectorySuffixSystem(str);
        WebViewFactory.setDataDirectorySuffix(str);
    }

    private static void setDataDirectorySuffixSystem(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                android.webkit.WebView.class.getMethod("setDataDirectorySuffix", String.class).invoke(null, str);
            } catch (IllegalStateException e) {
                throw e;
            } catch (Throwable th) {
                Log.e(LOGTAG, "Failed to set data directory suffix: ", th);
            }
        }
    }

    private void setFindIsUp(boolean z) {
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
    }

    private void setupFindListenerIfNeeded() {
        if (this.mFindListener == null) {
            this.mFindListener = new FindListenerDistributor();
            this.mProvider.setFindListener(this.mFindListener);
        }
    }

    @Deprecated
    public void ResetClearView() {
        checkThread();
        this.mProvider.resetClearView();
    }

    public void addEmbeddedTitleBarFinished() {
        this.mProvider.addEmbeddedTitleBarFinished();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: Throwable -> 0x00ba, TRY_LEAVE, TryCatch #0 {Throwable -> 0x00ba, blocks: (B:8:0x001a, B:10:0x001f, B:12:0x0049, B:14:0x005a, B:17:0x0064, B:20:0x006b), top: B:44:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addJavascriptInterface(Object obj, String str) {
        boolean z;
        StringBuilder sb;
        StackTraceElement[] stackTrace;
        checkThread();
        try {
            sb = new StringBuilder();
            stackTrace = new NullPointerException().getStackTrace();
        } catch (Throwable th) {
            z = false;
        }
        if (stackTrace != null) {
            if (stackTrace.length > 0) {
                z = false;
                for (int i = 0; i < stackTrace.length - 1; i++) {
                    try {
                        StackTraceElement stackTraceElement = stackTrace[i];
                        sb.append("\tat " + stackTraceElement);
                        String methodName = stackTraceElement.getMethodName();
                        String methodName2 = stackTrace[i + 1].getMethodName();
                        if (methodName.equalsIgnoreCase("addJavascriptInterface")) {
                            if (stackTrace[i + 1].getClassName().equalsIgnoreCase("java.lang.reflect.Method") && methodName2.equalsIgnoreCase("invoke")) {
                                z = true;
                            }
                        } else if (!z) {
                            break;
                        }
                    } catch (Throwable th2) {
                    }
                }
                if (z) {
                    getJSInterfaceStatistics().mJSInfo.put(str, sb.toString());
                }
                if (!z) {
                    if (this.mStatisticClient == null || this.mJSInterfaceStatistics == null) {
                        return;
                    }
                    this.mStatisticClient.onCommitRecord(this.mJSInterfaceStatistics);
                    return;
                }
                e secureProcessor = getSecureProcessor();
                boolean z2 = secureProcessor.a() ? false : true;
                if (obj != null && !TextUtils.isEmpty(str)) {
                    secureProcessor.d().put(str, obj);
                    secureProcessor.d = null;
                }
                if (!z2 || getEnableJsPrompt()) {
                    return;
                }
                checkThread();
                this.mProvider.addJavascriptInterface(obj, str);
                return;
            }
        }
        z = false;
        if (z) {
        }
        if (!z) {
        }
    }

    public void addJavascriptInterface(Object obj, String str, boolean z) {
        checkThread();
        this.mProvider.addJavascriptInterface(obj, str);
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        if (this.mJsBridge != null) {
            this.mJsBridge.addExternalJsFeature(str, iJsAbility);
        }
    }

    public void addNoStatePrefetch(String str, String str2) {
        checkThread();
        this.mProvider.addNoStatePrefetch(str, str2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
            super.addView(view);
        } else {
            getWebView().addView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
            super.addView(view, i);
        } else {
            getWebView().addView(view, i);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
            super.addView(view, i, i2);
        } else {
            getWebView().addView(view, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
            super.addView(view, i, layoutParams);
        } else {
            getWebView().addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
            super.addView(view, -1, layoutParams);
        } else {
            getWebView().addView(view, -1, layoutParams);
        }
    }

    public void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory) {
        this.mProvider.addZeusPluginFactory(zeusPluginFactory);
    }

    public boolean canGoBack() {
        checkThread();
        return this.mProvider.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        checkThread();
        return this.mProvider.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        checkThread();
        return this.mProvider.canGoForward();
    }

    public boolean canGoPrerender() {
        if (!isDestroyed()) {
            checkThread();
            return this.mProvider.canGoPrerender();
        }
        Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
        new Exception().printStackTrace();
        return false;
    }

    @Deprecated
    public boolean canZoomIn() {
        checkThread();
        return this.mProvider.canZoomIn();
    }

    @Deprecated
    public boolean canZoomOut() {
        checkThread();
        return this.mProvider.canZoomOut();
    }

    public void cancelCurrentNoStatePrefetch() {
        checkThread();
        this.mProvider.cancelCurrentNoStatePrefetch();
    }

    public Bitmap captureBitmap() {
        return captureBitmap(getMeasuredWidth(), getMeasuredHeight());
    }

    public Bitmap captureBitmap(int i, int i2) {
        checkThread();
        try {
            if (this.mProvider.isZeusWebViewProvider()) {
                Picture capturePicture = this.mProvider.capturePicture(i, i2, false);
                Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.RGB_565);
                capturePicture.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            System.gc();
            return null;
        }
    }

    public Bitmap captureHistoryBitmap(int i, int i2, int i3) {
        Picture captureHistoryPicture;
        checkThread();
        try {
            if (this.mProvider.isZeusWebViewProvider() && (captureHistoryPicture = this.mProvider.captureHistoryPicture(i, i2, i3)) != null && captureHistoryPicture.getWidth() > 0 && captureHistoryPicture.getHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                captureHistoryPicture.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            System.gc();
            return null;
        }
    }

    public Picture captureHistoryPicture(int i, int i2, int i3) {
        Picture captureHistoryPicture;
        checkThread();
        try {
            if (this.mProvider.isZeusWebViewProvider() && (captureHistoryPicture = this.mProvider.captureHistoryPicture(i, i2, i3)) != null && captureHistoryPicture.getWidth() > 0) {
                if (captureHistoryPicture.getHeight() > 0) {
                    return captureHistoryPicture;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            System.gc();
            return null;
        }
    }

    @Deprecated
    public Picture capturePicture() {
        return capturePicture(true);
    }

    public Picture capturePicture(boolean z) {
        checkThread();
        return this.mProvider.capturePicture(z ? 0 : getMeasuredWidth(), z ? 0 : getMeasuredHeight(), z);
    }

    public void changeWapPreloadUrlStyle(int i, String str) {
    }

    public void clearCache(boolean z) {
        checkThread();
        this.mProvider.clearCache(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.clearFocus();
        } else {
            getWebView().clearFocus();
        }
    }

    public void clearFormData() {
        checkThread();
        this.mProvider.clearFormData();
    }

    public void clearHistory() {
        checkThread();
        this.mProvider.clearHistory();
    }

    public void clearMatches() {
        checkThread();
        this.mProvider.clearMatches();
    }

    public void clearPrerender() {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        checkThread();
        this.mProvider.clearPrerender();
    }

    public void clearSslPreferences() {
        checkThread();
        this.mProvider.clearSslPreferences();
    }

    @Deprecated
    public void clearView() {
        checkThread();
        this.mProvider.clearView();
    }

    public void completeSelection() {
        this.mProvider.selectionDone();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return this.mProvider.getScrollDelegate().computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return this.mProvider.getScrollDelegate().computeHorizontalScrollRange();
    }

    public int computeMaxScrollX() {
        return 0;
    }

    public int computeMaxScrollY() {
        return 0;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mProvider.getScrollDelegate().computeScroll();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return this.mProvider.getScrollDelegate().computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.mProvider.getScrollDelegate().computeVerticalScrollOffset();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return this.mProvider.getScrollDelegate().computeVerticalScrollRange();
    }

    public WebBackForwardList copyBackForwardList() {
        checkThread();
        return this.mProvider.copyBackForwardListZeus();
    }

    public WebMessagePort[] createWebMessageChannel() {
        return null;
    }

    public void cutdownUserData(int i) {
        if (this.mProvider != null) {
            this.mProvider.cutdownUserData(i);
        }
    }

    @Deprecated
    public void debugDump() {
        checkThread();
    }

    public void destroy() {
        e secureProcessor = getSecureProcessor();
        if (secureProcessor.c.getContext().getPackageName().contains(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
            if (secureProcessor.f5970b != null) {
                secureProcessor.f5970b.clear();
                secureProcessor.f5970b = null;
            }
            if (secureProcessor.c.getWebViewClient() != null) {
                secureProcessor.d = null;
            }
        }
        checkThread();
        if (this.mJsBridge != null) {
            this.mJsBridge.release();
            this.mJsBridge = null;
        }
        this.mProvider.destroy();
        this.mDestroyed = true;
    }

    public void destroyCanvasCacheBmp() {
    }

    @Override // android.view.View
    public void destroyDrawingCache() {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.destroyDrawingCache();
        } else {
            getWebView().destroyDrawingCache();
        }
    }

    public void disableMedia() {
        this.mProvider.disableMedia();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mProvider.getViewDelegate().preDispatchDraw(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mProvider.getViewDelegate().dispatchKeyEvent(keyEvent);
    }

    public void documentHasImages(Message message) {
        checkThread();
        this.mProvider.documentHasImages(message);
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        this.mProvider.dumpViewHierarchyWithProperties(bufferedWriter, i);
    }

    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        this.mProvider.emulateShiftHeldOnLink();
    }

    public void emulateShiftHeldOnLink() {
        this.mProvider.emulateShiftHeldOnLink();
    }

    public void emulateShiftHeldOnNormalText() {
        this.mProvider.emulateShiftHeldOnNormalText();
    }

    public void enableMedia() {
        this.mProvider.enableMedia();
    }

    public void evaluateJavaScriptOnPrerender(String str, ValueCallback<String> valueCallback) {
        checkThread();
        this.mProvider.evaluateJavaScriptOnPrerender(str, valueCallback);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        checkThread();
        this.mProvider.evaluateJavaScript(str, valueCallback);
    }

    public void execJavaScript(String str) {
        loadUrl(JAVASCTIPT_URL + str);
    }

    public void execJavaScriptExt(String str, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            loadUrl("javascript:(" + str + ")()");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(JAVASCTIPT_URL + str + "('");
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append(strArr[i]);
            if (i != strArr.length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("')");
        loadUrl(stringBuffer.toString());
    }

    public void exitFullScreenMode() {
        this.mProvider.exitFullScreenMode();
    }

    public void extendSelection() {
        this.mProvider.extendSelection();
    }

    @Deprecated
    public int findAll(String str) {
        checkThread();
        StrictMode.noteSlowCall("findAll blocks UI: prefer findAllAsync");
        return this.mProvider.findAll(str);
    }

    public void findAllAsync(String str) {
        checkThread();
        this.mProvider.findAllAsync(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public View findFocus() {
        return this.mProvider.getViewDelegate().findFocus(super.findFocus());
    }

    public View findHierarchyView(String str, int i) {
        return this.mProvider.findHierarchyView(str, i);
    }

    public void findNext(boolean z) {
        checkThread();
        this.mProvider.findNext(z);
    }

    public void flingScroll(int i, int i2) {
        checkThread();
        this.mProvider.flingScroll(i, i2);
    }

    @Deprecated
    public void freeMemory() {
        checkThread();
        this.mProvider.freeMemory();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return WebView.class.getName();
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mProvider.getViewDelegate().getAccessibilityNodeProvider();
        return accessibilityNodeProvider == null ? super.getAccessibilityNodeProvider() : accessibilityNodeProvider;
    }

    public int getActionNodesCount() {
        return 0;
    }

    public float getActualZoomScale() {
        return getScale();
    }

    public Bitmap getCanvasCacheBmp() {
        return this.mProvider.getCanvasCacheBmp();
    }

    public SslCertificate getCertificate() {
        checkThread();
        return this.mProvider.getCertificate();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    public int getContentHeight() {
        checkThread();
        return this.mProvider.getContentHeight();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    public int getContentWidth() {
        return this.mProvider.getContentWidth();
    }

    public float getCurrentScale() {
        return getScale();
    }

    public View getCurrentTitleBar() {
        return this.mViewDelegate.getCurrentTitleBar();
    }

    public View getEmbeddedTitlebar() {
        return this.mViewDelegate.getEmbeddedTitlebar();
    }

    public Bitmap getFavicon() {
        checkThread();
        return this.mProvider.getFavicon();
    }

    public String getGpuInfo() {
        return this.mProvider.getGpuInfo();
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.mProvider.getViewDelegate().getHandler(super.getHandler());
    }

    public HitTestResult getHitTestResult() {
        checkThread();
        return this.mProvider.getHitTestResultZeus();
    }

    @Deprecated
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        checkThread();
        return this.mProvider.getHttpAuthUsernamePassword(str, str2);
    }

    public View getLandingPageTitleBar() {
        return this.mViewDelegate.getLandingPageTitleBar();
    }

    public Bitmap getMagnifierBmp() {
        return null;
    }

    public void getManifestInfo(ManifestInfoCallback manifestInfoCallback) {
        if (manifestInfoCallback == null) {
            return;
        }
        this.mProvider.getManifestInfo(manifestInfoCallback);
    }

    public float getMaxZoomScale() {
        return this.mProvider.getMaxZoomScale();
    }

    public float getMinZoomScale() {
        return this.mProvider.getMinZoomScale();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    public String getOriginalUrl() {
        checkThread();
        return this.mProvider == null ? "" : this.mProvider.getOriginalUrl();
    }

    public WebPageInfoList getPageInfo() {
        return new WebPageInfoList();
    }

    public int getProgress() {
        checkThread();
        return this.mProvider.getProgress();
    }

    public String getReferer() {
        checkThread();
        return this.mProvider == null ? "" : this.mProvider.getReferer();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        return this.mProvider.getRendererPriorityWaivedWhenNotVisible();
    }

    public int getRendererRequestedPriority() {
        return this.mProvider.getRendererRequestedPriority();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    @Deprecated
    public float getScale() {
        checkThread();
        return this.mProvider.getScale();
    }

    public int getScrollState() {
        return 0;
    }

    public View getSearchResultTitleBar() {
        return this.mViewDelegate.getSearchResultTitleBar();
    }

    public e getSecureProcessor() {
        if (this.mSecureProcessor == null) {
            this.mSecureProcessor = new e(this);
        }
        return this.mSecureProcessor;
    }

    public boolean getSelectingText() {
        return this.mProvider.getSelectingText();
    }

    public WebSettings getSettings() {
        checkThread();
        return this.mProvider.getSettingsZeus();
    }

    public CharSequence getTextFieldText() {
        return this.mProvider.getTextFieldText();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    public String getTitle() {
        checkThread();
        return this.mProvider == null ? "" : this.mProvider.getTitle();
    }

    public int getTitleHeight() {
        return 0;
    }

    public int getTitlebarHeight() {
        return this.mViewDelegate.getTitlebarHeight();
    }

    public int getTouchMode() {
        return this.mProvider.getTouchMode();
    }

    @ViewDebug.ExportedProperty(category = "webview")
    public String getUrl() {
        checkThread();
        return this.mProvider == null ? "" : this.mProvider.getUrl();
    }

    public Object getUserData(int i, int i2) {
        if (this.mProvider != null) {
            return this.mProvider.getUserData(i, i2);
        }
        return null;
    }

    @Override // android.view.View
    public int getVerticalScrollbarWidth() {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.getVerticalScrollbarWidth() : getWebView().getVerticalScrollbarWidth();
    }

    public WebViewDelegate getViewDelegate() {
        return this.mViewDelegate;
    }

    @Override // android.view.View
    public int getVisibility() {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.getVisibility() : getWebView().getVisibility();
    }

    public int getVisibleTitleHeight() {
        checkThread();
        return this.mProvider.getVisibleTitleHeightZeus();
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        this.mProvider.getWebAppShortcutData(webAppShortcutDataListener, false);
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        this.mProvider.getWebAppShortcutData(webAppShortcutDataListener, z);
    }

    public WebChromeClient getWebChromeClient() {
        checkThread();
        return this.mProvider.getWebChromeClientZeus();
    }

    public AbsoluteLayout getWebView() {
        return this.mProvider.getViewDelegate().getWebViewImpl();
    }

    public WebViewClient getWebViewClient() {
        checkThread();
        return this.mProvider.getWebViewClientZeus();
    }

    @NonNull
    public Looper getWebViewLooper() {
        return this.mWebViewThread;
    }

    public ViewGroup getWebViewPager() {
        return this.mProvider.getWebViewPager();
    }

    public WebViewProvider getWebViewProvider() {
        return this.mProvider;
    }

    public final int getWebViewScrollX() {
        return getWebView().getScrollX();
    }

    public final int getWebViewScrollY() {
        return getWebView().getScrollY();
    }

    public WebViewType getWebViewType() {
        return WebViewType.NORMAL;
    }

    public void goBack() {
        checkThread();
        this.mProvider.goBack();
    }

    public void goBackOrForward(int i) {
        checkThread();
        this.mProvider.goBackOrForward(i);
    }

    public void goForward() {
        checkThread();
        this.mProvider.goForward();
    }

    public void goNextOrPreTextField(boolean z) {
        this.mProvider.goNextOrPreTextField(z);
    }

    public void goPrerender() {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        checkThread();
        this.mProvider.goPrerender();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.hasFocus() : getWebView().hasFocus();
    }

    public boolean hasJavascriptInterfaceExt(String str) {
        if (this.mJsBridge != null) {
            return this.mJsBridge.hasExternalJsFeature(str);
        }
        return false;
    }

    public void hideMagnifier(int i, int i2) {
    }

    public void hitAd(String str) {
        this.mProvider.hitAd(str);
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.indexOfChild(view) : getWebView().indexOfChild(view);
    }

    public void insertTextFieldText(CharSequence charSequence) {
        this.mProvider.insertTextFieldText(charSequence);
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.invalidate();
        } else {
            getWebView().invalidate();
        }
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.invalidate(i, i2, i3, i4);
        } else {
            getWebView().invalidate(i, i2, i3, i4);
        }
    }

    public void invokeZoomPicker() {
        checkThread();
        this.mProvider.invokeZoomPicker();
    }

    public boolean isAutoShowTitlebar() {
        return this.mProvider.isAutoShowTitlebar();
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    @Override // android.view.View
    public boolean isDrawingCacheEnabled() {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.isDrawingCacheEnabled() : getWebView().isDrawingCacheEnabled();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) ? super.isFocused() : getWebView().isFocused();
    }

    public boolean isMobileSite() {
        return this.mProvider.isMobileSite();
    }

    public boolean isOnViewHierarchy() {
        return this.mOnViewHierarchy;
    }

    public boolean isPaused() {
        return this.mProvider.isPaused();
    }

    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        return this.mProvider.isPrivateBrowsingEnabled();
    }

    public boolean isScrollInProgress() {
        return this.mProvider.isScrollInProgress();
    }

    public boolean isTitlebarCanShow() {
        return this.mViewDelegate.isTitlebarCanShow();
    }

    public boolean isTitlebarShowing() {
        return this.mViewDelegate.isTitlebarShowing();
    }

    public boolean isWapAllowScale() {
        return true;
    }

    public void loadData(String str, String str2, String str3) {
        checkThread();
        this.mProvider.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        checkThread();
        this.mProvider.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
        checkThread();
        this.mProvider.loadDataWithBaseURL(str, str2, str3, str4, str5, z);
    }

    public void loadUrl(String str) {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str != null) {
                try {
                    if (!str.startsWith(JAVASCTIPT_URL) && getWebViewProvider() != null) {
                        getSecureProcessor().a(str);
                        PagePerformanceTiming performanceTiming = getWebViewProvider().getPerformanceTiming();
                        if (performanceTiming != null) {
                            performanceTiming.markLoadUrlStart(str);
                        }
                    }
                } catch (Throwable th) {
                }
            }
            this.mProvider.loadUrl(str);
        }
        while (true) {
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str != null && !str.startsWith(JAVASCTIPT_URL) && getWebViewProvider() != null) {
                getSecureProcessor().a(str);
                PagePerformanceTiming performanceTiming = getWebViewProvider().getPerformanceTiming();
                if (performanceTiming != null) {
                    performanceTiming.markLoadUrlStart(str);
                }
            }
            this.mProvider.loadUrl(str, map);
        }
        while (true) {
        }
    }

    public void loadUrl(String str, Map<String, String> map, boolean z) {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str != null) {
                if (str != null && !str.startsWith(JAVASCTIPT_URL) && getWebViewProvider() != null) {
                    getSecureProcessor().a(str);
                    PagePerformanceTiming performanceTiming = getWebViewProvider().getPerformanceTiming();
                    if (performanceTiming != null) {
                        performanceTiming.markLoadUrlStart(str);
                    }
                }
                this.mProvider.loadUrl(str, map, z);
            }
        }
        while (true) {
        }
    }

    public void mediaPlayerStatusChanged(int i, float f, float f2) {
    }

    public void mediaPlayerTimeChanged(float f, float f2) {
    }

    public void moveMagnifier(int i, int i2) {
    }

    public int nightModeColorStyle() {
        return 0;
    }

    public boolean notifyNativeExitFullScreenIfNeeded(int i) {
        return true;
    }

    public void notifyPageLeave() {
        checkThread();
        this.mProvider.notifyPageLeave();
    }

    public void notifyUnsafeInvolved(int i, String str) {
        checkThread();
        this.mProvider.notifyUnsafeInvolved(i, str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mProvider.getViewDelegate().onAttachedToWindow();
        try {
            Context context = getContext();
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            setScrollContainer(true);
            WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
            this.mSoftInputMode = attributes.softInputMode;
            if (attributes.softInputMode == 0 || attributes.softInputMode == 16) {
                ((Activity) context).getWindow().setSoftInputMode(16);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        try {
            return this.mProvider.getViewDelegate().onCheckIsTextEditor();
        } catch (RuntimeException e) {
            Log.w(LOGTAG, "Ignoring RuntimeException with fallback", e);
            return super.onCheckIsTextEditor();
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        this.mProvider.getViewDelegate().onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mProvider.getViewDelegate().onCreateInputConnection(editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mProvider.getViewDelegate().onDetachedFromWindow();
        super.onDetachedFromWindow();
        try {
            Context context = getContext();
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            ((Activity) context).getWindow().setSoftInputMode(this.mSoftInputMode);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        return this.mProvider.getViewDelegate().onDragEvent(dragEvent);
    }

    @Override // android.view.View
    @SuppressLint({"WrongCall"})
    protected void onDraw(Canvas canvas) {
        this.mProvider.getViewDelegate().onDraw(canvas);
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        this.mProvider.getViewDelegate().onDrawVerticalScrollBar(canvas, drawable, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.mProvider.getViewDelegate().onFinishTemporaryDetach();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        this.mProvider.getViewDelegate().onFocusChanged(z, i, rect);
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mProvider.getViewDelegate().onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    @Deprecated
    public void onGlobalFocusChanged(View view, View view2) {
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return this.mProvider.getViewDelegate().onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
                if (getAccessibilityNodeProvider() == null) {
                    this.mProvider.getViewDelegate().onInitializeAccessibilityEvent(accessibilityEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                if (getAccessibilityNodeProvider() == null) {
                    this.mProvider.getViewDelegate().onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            return true;
        }
        return this.mProvider.getViewDelegate().onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mProvider.getViewDelegate().onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.mProvider.getViewDelegate().onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mProvider.getViewDelegate().onKeyUp(i, keyEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        HitTestResult hitTestResult = getHitTestResult();
        if (hitTestResult != null) {
            int type = hitTestResult.getType();
            if (getWebChromeClient() != null) {
                if (type == 8 && Build.VERSION.SDK_INT == 19) {
                    type = 5;
                }
                if (type == 7 || type == 5) {
                    getWebChromeClient().performLongClick(this, type, hitTestResult.getExtra(), null, -1, -1);
                }
            }
            return (type == 0 || type == 9) ? false : true;
        }
        return false;
    }

    @Override // android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mProvider.getViewDelegate().onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        onOverScrolledDelegate(i, i2, z, z2);
    }

    public void onOverScrolledSuper(int i, int i2, boolean z, boolean z2) {
        this.mProvider.getViewDelegate().onOverScrolled(i, i2, z, z2);
    }

    public void onPageSwapFromWebview(WebView webView, String str, boolean z) {
        checkThread();
        this.mProvider.onPageSwapFromWebview(webView, str, z);
    }

    public void onPause() {
        checkThread();
        this.mProvider.onPause();
    }

    public void onPauseAll() {
        checkThread();
        this.mProvider.onPauseAll();
    }

    @Override // android.view.View
    public void onProvideVirtualStructure(ViewStructure viewStructure) {
        this.mProvider.getViewDelegate().onProvideVirtualStructure(viewStructure);
    }

    public void onResume() {
        checkThread();
        this.mProvider.onResume();
    }

    public void onResumeAll() {
        checkThread();
        this.mProvider.onResumeAll();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        onScrollChangedDelegate(i, i2, i3, i4);
    }

    public void onScrollChangedSuper(int i, int i2, int i3, int i4) {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            return;
        }
        try {
            if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
                super.onScrollChanged(i, i2, i3, i4);
            }
            this.mProvider.getViewDelegate().onScrollChanged(i, i2, i3, i4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mProvider.getViewDelegate().onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mProvider.getViewDelegate().onStartTemporaryDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEventDelegate(motionEvent);
    }

    public boolean onTouchEventSuper(MotionEvent motionEvent) {
        return this.mProvider.getViewDelegate().onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mProvider.getViewDelegate().onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ensureProviderCreated();
        this.mProvider.getViewDelegate().onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        this.mProvider.getViewDelegate().onWindowFocusChanged(z);
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mProvider.getViewDelegate().onWindowVisibilityChanged(i);
    }

    @Deprecated
    public boolean overlayHorizontalScrollbar() {
        return true;
    }

    @Deprecated
    public boolean overlayVerticalScrollbar() {
        return false;
    }

    public boolean pageDown(boolean z) {
        checkThread();
        return this.mProvider.pageDown(z);
    }

    public boolean pageUp(boolean z) {
        checkThread();
        return this.mProvider.pageUp(z);
    }

    public void pause(boolean z) {
    }

    public void pauseMedia() {
        this.mProvider.pauseMedia();
    }

    public void pauseTimers() {
        checkThread();
        this.mProvider.pauseTimers();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                super.performAccessibilityAction(i, bundle);
                if (getAccessibilityNodeProvider() == null) {
                    return this.mProvider.getViewDelegate().performAccessibilityAction(i, bundle);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return this.mProvider.getViewDelegate().performLongClick();
    }

    public void postUrl(String str, byte[] bArr) {
        checkThread();
        if (URLUtil.isNetworkUrl(str)) {
            this.mProvider.postUrl(str, bArr);
        } else {
            this.mProvider.loadUrl(str);
        }
    }

    public void postVisualStateCallback(long j, VisualStateCallback visualStateCallback) {
        checkThread();
        this.mProvider.insertVisualStateCallback(j, visualStateCallback);
    }

    public void postWebMessage(WebMessage webMessage, Uri uri) {
        checkThread();
        this.mProvider.postMessageToMainFrame(webMessage, uri);
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        checkThread();
    }

    public void reload() {
        PagePerformanceTiming performanceTiming;
        checkThread();
        if (getWebViewProvider() != null && (performanceTiming = getWebViewProvider().getPerformanceTiming()) != null) {
            performanceTiming.markLoadUrlStart(getUrl());
        }
        this.mProvider.reload();
    }

    public void removeHistoryItems() {
        this.mProvider.removeHistoryItems();
    }

    public void removeJavascriptInterface(String str) {
        e secureProcessor = getSecureProcessor();
        if (!"searchBoxJavaBridge_".equalsIgnoreCase(str) && secureProcessor.c.getContext().getPackageName().contains(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
            r0 = secureProcessor.a() ? false : true;
            secureProcessor.d().remove(str);
            if (secureProcessor.c.getWebViewClient() != null) {
                secureProcessor.d = null;
            }
        }
        if (r0) {
            checkThread();
            this.mProvider.removeJavascriptInterface(str);
        }
    }

    public void removeJavascriptInterfaceExt(String str) {
        if (this.mJsBridge != null) {
            this.mJsBridge.removeExternalJsFeature(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.removeView(view);
        } else {
            getWebView().removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mProvider.getViewDelegate().requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        return this.mProvider.getViewDelegate().requestFocus(i, rect);
    }

    public void requestFocusNodeHref(Message message) {
        checkThread();
        this.mProvider.requestFocusNodeHref(message);
    }

    public void requestImageRef(Message message) {
        checkThread();
        this.mProvider.requestImageRef(message);
    }

    public final boolean requestWebViewFocus() {
        return getWebView().requestFocus();
    }

    public void resetLoadingAnimation() {
        this.mProvider.resetLoadingAnimation();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        checkThread();
        return this.mProvider.restoreStateZeus(bundle);
    }

    public void resume(boolean z) {
    }

    public void resumeMedia() {
        this.mProvider.resumeMedia();
    }

    public void resumeTimers() {
        checkThread();
        this.mProvider.resumeTimers();
    }

    public boolean savePageAsLocalFiles(String str, String str2, SaveAsType saveAsType) {
        return this.mProvider.savePageAsLocalFiles(str, str2, saveAsType);
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        checkThread();
        this.mProvider.savePassword(str, str2, str3);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        checkThread();
        return this.mProvider.saveStateZeus(bundle);
    }

    public void saveWebArchive(String str) {
        checkThread();
        this.mProvider.saveWebArchive(str);
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        checkThread();
        this.mProvider.saveWebArchive(str, z, valueCallback);
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.scrollBy(i, i2);
        } else {
            getWebView().scrollBy(i, i2);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.scrollTo(i, i2);
        } else {
            getWebView().scrollTo(i, i2);
        }
    }

    public void sendFeedback(String str) {
        sendFeedback("", str);
    }

    public void sendFeedback(String str, String str2) {
        this.mProvider.sendFeedback(str, str2);
    }

    public void setAutoShowTitlebar(boolean z) {
        this.mProvider.setAutoShowTitlebar(z);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mProvider.getViewDelegate().setBackgroundColor(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setBackgroundResource(i);
        } else {
            getWebView().setBackgroundResource(i);
        }
    }

    public void setBeginScale() {
        this.mProvider.setBeginScale();
    }

    public void setBottomControlsHeight(int i) {
        this.mProvider.setBottomControlsHeight(i);
    }

    @Deprecated
    public void setCachePictureEnabled(boolean z) {
    }

    public void setCanvasCacheBmp(Bitmap bitmap) {
        this.mProvider.setCanvasCacheBmp(bitmap);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        checkThread();
        this.mProvider.setCertificate(sslCertificate);
    }

    public void setCurrentTitleBar(boolean z) {
        this.mViewDelegate.setCurrentTitleBar(z);
    }

    public void setDefaultViewSize(int i, int i2) {
        checkThread();
        this.mProvider.setDefaultViewSize(i, i2);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        checkThread();
        this.mProvider.setDownloadListener(downloadListener);
    }

    @Override // android.view.View
    public void setDrawingCacheEnabled(boolean z) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setDrawingCacheEnabled(z);
        } else {
            getWebView().setDrawingCacheEnabled(z);
        }
    }

    public void setEmbeddedTitleBar(View view) {
        setEmbeddedTitleBar(view, 0);
    }

    public void setEmbeddedTitleBar(View view, int i) {
    }

    public void setEndScale() {
        this.mProvider.setEndScale();
    }

    public void setFindListener(FindListener findListener) {
        checkThread();
        setupFindListenerIfNeeded();
        this.mFindListener.mUserFindListener = findListener;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setFocusable(z);
        } else {
            getWebView().setFocusable(z);
        }
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setHorizontalScrollBarEnabled(z);
        } else {
            getWebView().setHorizontalScrollBarEnabled(z);
        }
    }

    @Deprecated
    public void setHorizontalScrollbarOverlay(boolean z) {
    }

    @Deprecated
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        checkThread();
        this.mProvider.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setInitialScale(int i) {
        checkThread();
        this.mProvider.setInitialScale(i);
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        super.setLayerType(i, paint);
        this.mProvider.getViewDelegate().setLayerType(i, paint);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mProvider.getViewDelegate().setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        checkThread();
        this.mProvider.setMapTrackballToArrowKeys(z);
    }

    public void setNetworkAvailable(boolean z) {
        checkThread();
        this.mProvider.setNetworkAvailable(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnClickListener(onClickListener);
        } else {
            getWebView().setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnCreateContextMenuListener(onCreateContextMenuListener);
        } else {
            getWebView().setOnCreateContextMenuListener(onCreateContextMenuListener);
        }
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            getWebView().setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnKeyListener(onKeyListener);
        } else {
            getWebView().setOnKeyListener(onKeyListener);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnLongClickListener(onLongClickListener);
        } else {
            getWebView().setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setOnTouchListener(onTouchListener);
        } else {
            getWebView().setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        if (this.mProvider == null) {
            this.mSetOverScrollModeBeforeProviderReady = i;
        } else {
            this.mProvider.getViewDelegate().setOverScrollMode(i);
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        this.mProvider.setPageTransformer(z, pageTransformer);
    }

    public void setPauseSyncActions(boolean z) {
        checkThread();
        this.mProvider.setPauseSyncActions(z);
    }

    @Deprecated
    public void setPictureListener(PictureListener pictureListener) {
        checkThread();
        this.mProvider.setPictureListener(pictureListener);
    }

    public boolean setPreviewZoomScale(float f) {
        return this.mProvider.setPreviewZoomScale(f);
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        this.mProvider.setRendererPriorityPolicy(i, z);
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        this.mProvider.getViewDelegate().setScrollBarStyle(i);
        super.setScrollBarStyle(i);
    }

    @Override // android.view.View
    public void setScrollbarFadingEnabled(boolean z) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setScrollbarFadingEnabled(z);
        } else {
            getWebView().setScrollbarFadingEnabled(z);
        }
    }

    public boolean setSelectingText(boolean z) {
        this.mProvider.setSelectingText(z);
        return true;
    }

    public void setStatisticsClient(Statistics.Client client) {
        this.mStatisticClient = client;
    }

    public void setStatusBar(View view, int i) {
        this.mProvider.setStatusBar(view, i);
    }

    public void setSubjectScrollToOnload(int i) {
    }

    public void setTextFieldText(CharSequence charSequence) {
        this.mProvider.setTextFieldText(charSequence);
    }

    public void setTopControlsHeight(int i, boolean z) {
        this.mProvider.setTopControlsHeight(i, z);
    }

    public void setUserData(int i, int i2, Object obj) {
        if (this.mProvider != null) {
            this.mProvider.setUserData(i, i2, obj);
        }
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setVerticalScrollBarEnabled(z);
        } else {
            getWebView().setVerticalScrollBarEnabled(z);
        }
    }

    @Deprecated
    public void setVerticalScrollbarOverlay(boolean z) {
    }

    public void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        this.mProvider.setVideoPlayerFactory(videoPlayerFactory);
    }

    public void setViewDelegate(WebViewDelegate webViewDelegate) {
        this.mViewDelegate = webViewDelegate;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
            super.setVisibility(i);
        } else {
            getWebView().setVisibility(i);
        }
    }

    public boolean setVisitedLinkNightColor(int i) {
        return true;
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        checkThread();
        this.mProvider.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        checkThread();
        this.mProvider.setWebViewClient(webViewClient);
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        this.mProvider.setWebViewMargin(i, i2, i3, i4);
    }

    public void setWebViewPagerContainer(ViewGroup viewGroup) {
        this.mProvider.setWebViewPagerContainer(viewGroup);
    }

    public void setWebViewPagerSize(int i, int i2) {
        this.mProvider.setWebViewPagerSize(i, i2);
    }

    public void setWebViewState(WebViewState webViewState) {
    }

    public void setWebViewType(WebViewType webViewType) {
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup
    @Deprecated
    public boolean shouldDelayChildPressedState() {
        return this.mProvider.getViewDelegate().shouldDelayChildPressedState();
    }

    @Deprecated
    public boolean showFindDialog(String str, boolean z) {
        checkThread();
        return this.mProvider.showFindDialog(str, z);
    }

    public void showMagnifier(int i, int i2, int i3, int i4, boolean z) {
    }

    public void startLoadingAnimation(String str) {
        this.mProvider.startLoadingAnimation(str);
    }

    public int startPrerender(String str) {
        if (!isDestroyed()) {
            checkThread();
            return this.mProvider.startPrerender(str);
        }
        Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
        new Exception().printStackTrace();
        return -1;
    }

    public boolean startPreviewZoomScale() {
        return true;
    }

    public void stopLoading() {
        checkThread();
        this.mProvider.stopLoading();
    }

    public void stopPrerender() {
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        checkThread();
        this.mProvider.stopPrerender();
    }

    public void suspendScheduledTasks(String str) {
        checkThread();
        this.mProvider.suspendScheduledTasks(str);
    }

    public void switchTitleBar(boolean z) {
        this.mProvider.switchTitleBar(z);
    }

    public void updateTopControlOffset(int i) {
        this.mProvider.updateTopControlOffset(i);
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        this.mProvider.updateTopControlsState(z, z2, z3);
    }

    public void zoomBy(float f) {
        checkThread();
        if (f < 0.01d) {
            throw new IllegalArgumentException("zoomFactor must be greater than 0.01.");
        }
        if (f > 100.0d) {
            throw new IllegalArgumentException("zoomFactor must be less than 100.");
        }
        this.mProvider.zoomByZeus(f);
    }

    public boolean zoomIn() {
        checkThread();
        return this.mProvider.zoomIn();
    }

    public boolean zoomOut() {
        checkThread();
        return this.mProvider.zoomOut();
    }
}

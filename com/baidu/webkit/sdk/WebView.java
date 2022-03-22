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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Statistics;
import com.baidu.webkit.internal.a;
import com.baidu.webkit.internal.monitor.MonitorType;
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
/* loaded from: classes6.dex */
public class WebView extends AbsoluteLayout implements View.OnLongClickListener, ViewGroup.OnHierarchyChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATA_REDUCTION_PROXY_SETTING_CHANGED = "com.baidu.webkit.sdk.DATA_REDUCTION_PROXY_SETTING_CHANGED";
    public static final String JAVASCTIPT_URL = "javascript:";
    public static final String LOGTAG = "WebView";
    public static final int RENDERER_PRIORITY_BOUND = 1;
    public static final int RENDERER_PRIORITY_IMPORTANT = 2;
    public static final int RENDERER_PRIORITY_WAIVED = 0;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_MODERATE = 1;
    public static final int VIRTUAL_MEMORY_PRESSURE_LEVEL_NONE = 0;
    public static long mIdentifier;
    public static volatile boolean sEnforceThreadChecking;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCurrentSourceId;
    public boolean mDestroyed;
    public FindListenerDistributor mFindListener;
    public boolean mHasPerformedLongPress;
    public boolean mIsPrivateInit;
    public JSInterfaceStatistics mJSInterfaceStatistics;
    public ZeusJsBridge mJsBridge;
    public boolean mOnViewHierarchy;
    public WebViewProvider mProvider;
    public a mSecureProcessor;
    public int mSetOverScrollModeBeforeProviderReady;
    public int mSoftInputMode;
    public Statistics.Client mStatisticClient;
    public WebViewDelegate mViewDelegate;
    public final Looper mWebViewThread;

    /* renamed from: com.baidu.webkit.sdk.WebView$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class DelegateAdapter implements WebViewProvider.ScrollDelegate, WebViewProvider.ViewDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebViewImpl mChildView;
        public final /* synthetic */ WebView this$0;

        public DelegateAdapter(WebView webView, WebViewImpl webViewImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView, webViewImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
            this.mChildView = webViewImpl;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeHorizontalScrollOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WebView.super.computeHorizontalScrollOffset() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeHorizontalScrollRange() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? WebView.super.computeHorizontalScrollRange() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final void computeScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                WebView.super.computeScroll();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollExtent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mChildView.computeVerticalScrollExtent() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mChildView.computeVerticalScrollOffset() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ScrollDelegate
        public final int computeVerticalScrollRange() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mChildView.computeVerticalScrollRange() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) ? WebView.super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final View findFocus(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) ? this.mChildView.findFocus() : (View) invokeL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    return WebView.super.getAccessibilityNodeProvider();
                }
                return null;
            }
            return (AccessibilityNodeProvider) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final Handler getHandler(Handler handler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, handler)) == null) ? this.mChildView.getHandler() : (Handler) invokeL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final AbsoluteLayout getWebViewImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mChildView : (AbsoluteLayout) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onAttachedToWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                WebView.super.onAttachedToWindow();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onCheckIsTextEditor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mChildView.onCheckIsTextEditor() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, configuration) == null) {
                WebView.super.onConfigurationChanged(configuration);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, editorInfo)) == null) ? WebView.super.onCreateInputConnection(editorInfo) : (InputConnection) invokeL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                WebView.super.onDetachedFromWindow();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onDragEvent(DragEvent dragEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dragEvent)) == null) ? WebView.super.onDragEvent(dragEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, canvas) == null) {
                WebView.super.onDraw(canvas);
                ((android.webkit.WebView) this.this$0.mProvider).draw(canvas);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{canvas, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                drawable.setBounds(i, i2, i3, i4);
                drawable.draw(canvas);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onFinishTemporaryDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                WebView.super.onFinishTemporaryDetach();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
                WebView.super.onFocusChanged(z, i, rect);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
                if (Build.VERSION.SDK_INT >= 12) {
                    return WebView.super.onGenericMotionEvent(motionEvent);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
                if (Build.VERSION.SDK_INT >= 14) {
                    return WebView.super.onHoverEvent(motionEvent);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, accessibilityEvent) == null) {
                WebView.super.onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, accessibilityNodeInfo) == null) {
                WebView.super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) ? this.mChildView.super_onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, keyEvent)) == null) ? WebView.super.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048603, this, i, i2, keyEvent)) == null) ? WebView.super.onKeyMultiple(i, i2, keyEvent) : invokeIIL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onKeyUp(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i, keyEvent)) == null) ? WebView.super.onKeyUp(i, keyEvent) : invokeIL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) {
                WebView.super.onMeasure(i, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.mChildView.super_onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onProvideVirtualStructure(ViewStructure viewStructure) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, viewStructure) == null) {
                WebView.super.onProvideVirtualStructure(viewStructure);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048608, this, i, i2, i3, i4) == null) {
                this.mChildView.super_onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048609, this, i, i2, i3, i4) == null) {
                WebView.super.onSizeChanged(i3, i4, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onStartTemporaryDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
                WebView.super.onStartTemporaryDetach();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, motionEvent)) == null) ? this.mChildView.super_onTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean onTrackballEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) ? WebView.super.onTrackballEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onVisibilityChanged(View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048613, this, view, i) == null) {
                WebView.super.onVisibilityChanged(view, i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onWindowFocusChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
                WebView.super.onWindowFocusChanged(z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void onWindowVisibilityChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
                WebView.super.onWindowVisibilityChanged(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean performAccessibilityAction(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048616, this, i, bundle)) == null) ? WebView.super.performAccessibilityAction(i, bundle) : invokeIL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean performLongClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mChildView.super_performLongClick() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void preDispatchDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048618, this, canvas) == null) {
                WebView.super.dispatchDraw(canvas);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048619, this, view, rect, z)) == null) ? WebView.super.requestChildRectangleOnScreen(view, rect, z) : invokeLLZ.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean requestFocus(int i, Rect rect) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i, rect)) == null) {
                WebView.super.requestFocus(i, rect);
                return this.mChildView.requestFocus(i, rect);
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setBackgroundColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
                WebView.super.setBackgroundColor(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean setFrame(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048622, this, i, i2, i3, i4)) == null) {
                return false;
            }
            return invokeIIII.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setLayerType(int i, Paint paint) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048623, this, i, paint) == null) || Build.VERSION.SDK_INT < 11) {
                return;
            }
            WebView.super.setLayerType(i, paint);
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048624, this, layoutParams) == null) {
                WebView.super.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setOverScrollMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
                WebView.super.setOverScrollMode(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final void setScrollBarStyle(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
                WebView.super.setScrollBarStyle(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewProvider.ViewDelegate
        public final boolean shouldDelayChildPressedState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
                if (Build.VERSION.SDK_INT >= 14) {
                    return WebView.super.shouldDelayChildPressedState();
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface FindListener {
        void onFindResultReceived(int i, int i2, boolean z);
    }

    /* loaded from: classes6.dex */
    public class FindListenerDistributor implements FindListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FindListener mFindDialogFindListener;
        public FindListener mUserFindListener;
        public final /* synthetic */ WebView this$0;

        public FindListenerDistributor(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
        }

        public /* synthetic */ FindListenerDistributor(WebView webView, AnonymousClass1 anonymousClass1) {
            this(webView);
        }

        @Override // com.baidu.webkit.sdk.WebView.FindListener
        public void onFindResultReceived(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                FindListener findListener = this.mFindDialogFindListener;
                if (findListener != null) {
                    findListener.onFindResultReceived(i, i2, z);
                }
                FindListener findListener2 = this.mUserFindListener;
                if (findListener2 != null) {
                    findListener2.onFindResultReceived(i, i2, z);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class HitTestResult {
        public static /* synthetic */ Interceptable $ic = null;
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
        public transient /* synthetic */ FieldHolder $fh;
        public String mCustomData;
        public boolean mDataNoNaDialogEnabled;
        public String mExtra;
        public String mExtra2;
        public String mFirstNavigationUrl;
        public String mFrameUrl;
        public boolean mIsSelectable;
        public boolean mIsTextNode;
        public String mOriginFrameSrcUrl;
        public String mOriginLinkUrl;
        public String mOriginSrcUrl;
        public String mPageUrl;
        public float mTouchPageX;
        public float mTouchPageY;
        public int mType;

        public HitTestResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mType = 0;
        }

        public String getCustomData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCustomData : (String) invokeV.objValue;
        }

        public boolean getDataNoNaDialogEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDataNoNaDialogEnabled : invokeV.booleanValue;
        }

        public String getExtra() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtra : (String) invokeV.objValue;
        }

        public String getExtra2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mExtra2 : (String) invokeV.objValue;
        }

        public String getFirstNavigationUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFirstNavigationUrl : (String) invokeV.objValue;
        }

        public String getFrameUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrameUrl : (String) invokeV.objValue;
        }

        public String getOriginFrameSrcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOriginFrameSrcUrl : (String) invokeV.objValue;
        }

        public String getOriginLinkUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOriginLinkUrl : (String) invokeV.objValue;
        }

        public String getOriginSrcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mOriginSrcUrl : (String) invokeV.objValue;
        }

        public String getPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPageUrl : (String) invokeV.objValue;
        }

        public float getTouchPageX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTouchPageX : invokeV.floatValue;
        }

        public float getTouchPageY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mTouchPageY : invokeV.floatValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mType : invokeV.intValue;
        }

        public boolean isSelectable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsSelectable : invokeV.booleanValue;
        }

        public boolean isTextNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIsTextNode : invokeV.booleanValue;
        }

        public void setCustomData(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.mCustomData = str;
            }
        }

        public void setDataNoNaDialogEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                this.mDataNoNaDialogEnabled = z;
            }
        }

        public void setExtra(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.mExtra = str;
            }
        }

        public void setExtra2(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.mExtra2 = str;
            }
        }

        public void setFirstNavigationUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.mFirstNavigationUrl = str;
            }
        }

        public void setFrameUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                this.mFrameUrl = str;
            }
        }

        public void setIsSelectable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
                this.mIsSelectable = z;
            }
        }

        public void setIsTextNode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
                this.mIsTextNode = z;
            }
        }

        public void setOriginFrameSrcUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.mOriginFrameSrcUrl = str;
            }
        }

        public void setOriginLinkUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
                this.mOriginLinkUrl = str;
            }
        }

        public void setOriginSrcUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
                this.mOriginSrcUrl = str;
            }
        }

        public void setPageUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
                this.mPageUrl = str;
            }
        }

        public void setTouchPageX(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
                this.mTouchPageX = f2;
            }
        }

        public void setTouchPageY(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
                this.mTouchPageY = f2;
            }
        }

        public void setType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
                this.mType = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface IVirtualMemoryListener {
        void onVirtualMemoryPressure(int i);
    }

    /* loaded from: classes6.dex */
    public class JSInterfaceStatistics implements Statistics.Record {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, String> mJSInfo;
        public final /* synthetic */ WebView this$0;

        public JSInterfaceStatistics(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
            this.mJSInfo = new HashMap<>();
        }

        public /* synthetic */ JSInterfaceStatistics(WebView webView, AnonymousClass1 anonymousClass1) {
            this(webView);
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MonitorType.MONITOR_TYPE_ADD_JAVA_SCRIPT : invokeV.intValue;
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.webkit.internal.Statistics.Record
        public String toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    if (this.mJSInfo == null || this.mJSInfo.size() <= 0) {
                        return "";
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", MonitorType.MONITOR_TYPE_ADD_JAVA_SCRIPT);
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.mJSInfo.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", entry.getKey());
                        jSONObject2.put("callstack", entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject.toString();
                } catch (JSONException unused) {
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface MainResourcePrefetchListener {
        void onPrefetchFinished(String str, long j, boolean z, String str2, int i);
    }

    /* loaded from: classes6.dex */
    public interface OnDragListener {
        boolean onDrag(View view, DragEvent dragEvent);
    }

    /* loaded from: classes6.dex */
    public interface OnGenericMotionListener {
        boolean onGenericMotion(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes6.dex */
    public interface OnHoverListener {
        boolean onHover(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes6.dex */
    public interface OnSystemUiVisibilityChangeListener {
        void onSystemUiVisibilityChange(int i);
    }

    /* loaded from: classes6.dex */
    public class PageInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView this$0;

        public PageInfo(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
        }

        public byte[] getBody() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (byte[]) invokeV.objValue;
        }

        public String getHeader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getIp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class PrerenderStatus {
        public static final /* synthetic */ PrerenderStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PrerenderStatus FAILED;
        public static final PrerenderStatus FINISHED;
        public static final PrerenderStatus JUMPED;
        public static final PrerenderStatus STARTED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1954309617, "Lcom/baidu/webkit/sdk/WebView$PrerenderStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1954309617, "Lcom/baidu/webkit/sdk/WebView$PrerenderStatus;");
                    return;
                }
            }
            STARTED = new PrerenderStatus("STARTED", 0);
            FAILED = new PrerenderStatus("FAILED", 1);
            JUMPED = new PrerenderStatus("JUMPED", 2);
            PrerenderStatus prerenderStatus = new PrerenderStatus("FINISHED", 3);
            FINISHED = prerenderStatus;
            $VALUES = new PrerenderStatus[]{STARTED, FAILED, JUMPED, prerenderStatus};
        }

        public PrerenderStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PrerenderStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PrerenderStatus) Enum.valueOf(PrerenderStatus.class, str) : (PrerenderStatus) invokeL.objValue;
        }

        public static PrerenderStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PrerenderStatus[]) $VALUES.clone() : (PrerenderStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class PrivateAccess {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView this$0;

        public PrivateAccess(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
        }

        public void awakenScrollBars(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.this$0.awakenScrollBars(i);
            }
        }

        public void awakenScrollBars(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.this$0.awakenScrollBars(i, z);
            }
        }

        public float getHorizontalScrollFactor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    return ((Float) Class.forName("android.view.View").getMethod("getHorizontalScrollFactor", new Class[0]).invoke(this.this$0, null)).floatValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 1.0f;
                }
            }
            return invokeV.floatValue;
        }

        public int getHorizontalScrollbarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.getHorizontalScrollbarHeight() : invokeV.intValue;
        }

        public float getVerticalScrollFactor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    return ((Float) Class.forName("android.view.View").getMethod("getVerticalScrollFactor", new Class[0]).invoke(this.this$0, null)).floatValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 1.0f;
                }
            }
            return invokeV.floatValue;
        }

        public boolean isPrivateInit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.this$0.mIsPrivateInit : invokeV.booleanValue;
        }

        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.this$0.onOverScrolled(i, i2, z, z2);
            }
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
                this.this$0.onScrollChanged(i, i2, i3, i4);
            }
        }

        public void overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)}) == null) {
                try {
                    this.this$0.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
                this.this$0.setMeasuredDimension(i, i2);
            }
        }

        public void super_computeScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                WebView.super.computeScroll();
            }
        }

        public boolean super_dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, keyEvent)) == null) ? WebView.super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
        }

        public int super_getScrollBarStyle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? WebView.super.getScrollBarStyle() : invokeV.intValue;
        }

        public void super_onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{canvas, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                drawable.setBounds(i, i2, i3, i4);
                drawable.draw(canvas);
            }
        }

        public boolean super_onGenericMotionEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? WebView.super.onGenericMotionEvent(motionEvent) : invokeL.booleanValue;
        }

        public boolean super_onHoverEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) ? WebView.super.onHoverEvent(motionEvent) : invokeL.booleanValue;
        }

        public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) ? WebView.super.onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        public boolean super_performAccessibilityAction(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, bundle)) == null) ? WebView.super.performAccessibilityAction(i, bundle) : invokeIL.booleanValue;
        }

        public boolean super_performLongClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? WebView.super.performLongClick() : invokeV.booleanValue;
        }

        public boolean super_requestFocus(int i, Rect rect) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i, rect)) == null) ? WebView.super.requestFocus(i, rect) : invokeIL.booleanValue;
        }

        public void super_scrollTo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
                WebView.super.scrollTo(i, i2);
            }
        }

        public boolean super_setFrame(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048597, this, i, i2, i3, i4)) == null) {
                return false;
            }
            return invokeIIII.booleanValue;
        }

        public void super_setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, layoutParams) == null) {
                WebView.super.setLayoutParams(layoutParams);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface RendererPriority {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class SaveAsType {
        public static final /* synthetic */ SaveAsType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SaveAsType SAVE_AS_HTML_FOLDER;
        public static final SaveAsType SAVE_AS_HTML_ONLY;
        public static final SaveAsType SAVE_AS_WEB_ARCHIVE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(719467475, "Lcom/baidu/webkit/sdk/WebView$SaveAsType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(719467475, "Lcom/baidu/webkit/sdk/WebView$SaveAsType;");
                    return;
                }
            }
            SAVE_AS_WEB_ARCHIVE = new SaveAsType("SAVE_AS_WEB_ARCHIVE", 0);
            SAVE_AS_HTML_FOLDER = new SaveAsType("SAVE_AS_HTML_FOLDER", 1);
            SaveAsType saveAsType = new SaveAsType("SAVE_AS_HTML_ONLY", 2);
            SAVE_AS_HTML_ONLY = saveAsType;
            $VALUES = new SaveAsType[]{SAVE_AS_WEB_ARCHIVE, SAVE_AS_HTML_FOLDER, saveAsType};
        }

        public SaveAsType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SaveAsType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SaveAsType) Enum.valueOf(SaveAsType.class, str) : (SaveAsType) invokeL.objValue;
        }

        public static SaveAsType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SaveAsType[]) $VALUES.clone() : (SaveAsType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class VisualStateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public VisualStateCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void onComplete(long j);
    }

    /* loaded from: classes6.dex */
    public class WebPageInfoList {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView this$0;

        public WebPageInfoList(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
        }

        public ArrayList<PageInfo> getWebPageInfoList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class WebViewState {
        public static final /* synthetic */ WebViewState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WebViewState MULTIPLE_WEBVIEW_STATE;
        public static final WebViewState NORMAL_WEBVIEW_STATE;
        public static final WebViewState SINGLE_WEBVIEW_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1493559268, "Lcom/baidu/webkit/sdk/WebView$WebViewState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1493559268, "Lcom/baidu/webkit/sdk/WebView$WebViewState;");
                    return;
                }
            }
            NORMAL_WEBVIEW_STATE = new WebViewState("NORMAL_WEBVIEW_STATE", 0);
            SINGLE_WEBVIEW_STATE = new WebViewState("SINGLE_WEBVIEW_STATE", 1);
            WebViewState webViewState = new WebViewState("MULTIPLE_WEBVIEW_STATE", 2);
            MULTIPLE_WEBVIEW_STATE = webViewState;
            $VALUES = new WebViewState[]{NORMAL_WEBVIEW_STATE, SINGLE_WEBVIEW_STATE, webViewState};
        }

        public WebViewState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static WebViewState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebViewState) Enum.valueOf(WebViewState.class, str) : (WebViewState) invokeL.objValue;
        }

        public static WebViewState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebViewState[]) $VALUES.clone() : (WebViewState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class WebViewTransport {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object lockObject;
        public WebView mWebview;
        public final /* synthetic */ WebView this$0;

        public WebViewTransport(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webView;
            this.lockObject = new Object();
        }

        public WebView getWebView() {
            InterceptResult invokeV;
            WebView webView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.lockObject) {
                    webView = this.mWebview;
                }
                return webView;
            }
            return (WebView) invokeV.objValue;
        }

        public void setWebView(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) {
                synchronized (this.lockObject) {
                    this.mWebview = webView;
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class WebViewType {
        public static final /* synthetic */ WebViewType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WebViewType BIGPLUGIN;
        public static final WebViewType NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1850381031, "Lcom/baidu/webkit/sdk/WebView$WebViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1850381031, "Lcom/baidu/webkit/sdk/WebView$WebViewType;");
                    return;
                }
            }
            NORMAL = new WebViewType("NORMAL", 0);
            WebViewType webViewType = new WebViewType("BIGPLUGIN", 1);
            BIGPLUGIN = webViewType;
            $VALUES = new WebViewType[]{NORMAL, webViewType};
        }

        public WebViewType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static WebViewType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebViewType) Enum.valueOf(WebViewType.class, str) : (WebViewType) invokeL.objValue;
        }

        public static WebViewType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebViewType[]) $VALUES.clone() : (WebViewType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Resources.getSystem().getIdentifier("webViewStyle", "attr", "android"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public WebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        initWebView(context, null, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        initWebView(context, null, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z) {
        super(context, null, Resources.getSystem().getIdentifier("webViewStyle", "attr", "android"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.mSetOverScrollModeBeforeProviderReady = -1;
        this.mOnViewHierarchy = true;
        this.mSoftInputMode = 0;
        this.mWebViewThread = Looper.myLooper();
        this.mIsPrivateInit = z;
        initWebView(context, null, false);
    }

    public static void AdBlockInitInternel(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, str, z) == null) {
            getFactory().getStatics().AdBlockInit(str, z);
        }
    }

    public static void addToWebCache(String str, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65599, null, str, map, z) == null) {
            getFactory().getStatics().addToWebCache(str, false, true, map, z);
        }
    }

    public static void addToWebCache(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65600, null, str, z) == null) {
            getFactory().getStatics().addToWebCache(str, false, true, null, z);
        }
    }

    public static void addToWebCache(String str, boolean z, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{str, Boolean.valueOf(z), map}) == null) {
            getFactory().getStatics().addToWebCache(str, z, true, map, false);
        }
    }

    public static void addToWebCache(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65602, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            getFactory().getStatics().addToWebCache(str, z, z2, null, false);
        }
    }

    public static void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65603, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), map}) == null) {
            getFactory().getStatics().addToWebCache(str, z, z2, map, false);
        }
    }

    public static void addVirtualMemoryListener(IVirtualMemoryListener iVirtualMemoryListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, null, iVirtualMemoryListener) == null) {
            getFactory().getStatics().addVirtualMemoryListener(iVirtualMemoryListener);
        }
    }

    public static void cancelPrefetch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65605, null, str) == null) {
            getFactory().getStatics().cancelPrefetch(str);
        }
    }

    public static void cancelResourcePrefetch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, null, str) == null) {
            getFactory().getStatics().cancelResourcePrefetch(str);
        }
    }

    private void checkThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65607, this) == null) || this.mWebViewThread == null || Looper.myLooper() == this.mWebViewThread) {
            return;
        }
        Throwable th = new Throwable("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + this.mWebViewThread + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + SmallTailInfo.EMOTION_SUFFIX);
        Log.w(LOGTAG, android.util.Log.getStackTraceString(th));
        if (sEnforceThreadChecking) {
            throw new RuntimeException(th);
        }
    }

    public static void clearAllTextureCacheAndGLResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65608, null) == null) {
        }
    }

    public static void clearClientCertPreferences(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, runnable) == null) {
            getFactory().getStatics().clearClientCertPreferences(runnable);
        }
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, null) == null) {
        }
    }

    public static void disableWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65611, null) == null) {
            WebViewFactory.disableWebView();
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65612, null) == null) {
        }
    }

    public static void enableSlowWholeDocumentDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, null) == null) {
            getFactory().getStatics().enableSlowWholeDocumentDraw();
        }
    }

    private void ensureProviderCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65614, this) == null) {
            checkThread();
            if (this.mProvider == null) {
                this.mProvider = getFactory().createWebView(this, new PrivateAccess(this));
            }
        }
    }

    @Nullable
    @Deprecated
    public static String findAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, str)) == null) ? getFactory().getStatics().findAddress(str) : (String) invokeL.objValue;
    }

    public static HashMap<String, Long> getCurrentSystemInfraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) ? getFactory().getStatics().getCurrentSystemInfraInfo() : (HashMap) invokeV.objValue;
    }

    @Nullable
    public static PackageInfo getCurrentWebViewPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            PackageInfo loadedPackageInfo = WebViewFactory.getLoadedPackageInfo();
            if (loadedPackageInfo != null) {
                return loadedPackageInfo;
            }
            return null;
        }
        return (PackageInfo) invokeV.objValue;
    }

    private boolean getEnableJsPrompt() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65618, this)) != null) {
            return invokeV.booleanValue;
        }
        try {
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            Log.e(LOGTAG, "getStaticWebSeting error:".concat(String.valueOf(th)));
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

    public static synchronized WebViewFactoryProvider getFactory() {
        InterceptResult invokeV;
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            synchronized (WebView.class) {
                provider = WebViewFactory.getProvider();
            }
            return provider;
        }
        return (WebViewFactoryProvider) invokeV.objValue;
    }

    private JSInterfaceStatistics getJSInterfaceStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, this)) == null) {
            if (this.mJSInterfaceStatistics == null) {
                this.mJSInterfaceStatistics = new JSInterfaceStatistics(this, null);
            }
            return this.mJSInterfaceStatistics;
        }
        return (JSInterfaceStatistics) invokeV.objValue;
    }

    @NonNull
    public static ClassLoader getWebViewClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) ? getFactory().getWebViewClassLoader() : (ClassLoader) invokeV.objValue;
    }

    public static String getZeusSeriesNum(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65622, null, i, i2, i3)) == null) ? getFactory().getStatics().getZeusSeriesNum(i, i2, i3) : (String) invokeIII.objValue;
    }

    public static boolean hasGPU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    private void initWebView(Context context, Map<String, Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65624, this, context, map, z) == null) {
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
            ZeusJsBridge zeusJsBridge = new ZeusJsBridge(this);
            this.mJsBridge = zeusJsBridge;
            zeusJsBridge.init();
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
    }

    public static boolean isInWebCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65625, null, str)) == null) ? getFactory().getStatics().isInWebCache(str) : invokeL.booleanValue;
    }

    public static void makeMF30Inited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65626, null) == null) {
            getFactory().getStatics().makeMF30Inited();
        }
    }

    public static void onMemoryPresure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65627, null) == null) {
            getFactory().getStatics().onMemoryPresure(2, null);
        }
    }

    public static void onMemoryPresure(int i, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65628, null, i, activity) == null) {
            getFactory().getStatics().onMemoryPresure(i, activity);
        }
    }

    private void onOverScrolledDelegate(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65629, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            WebViewDelegate webViewDelegate = this.mViewDelegate;
            if (webViewDelegate != null) {
                webViewDelegate.onOverScrolled(i, i2, z, z2);
            } else {
                onOverScrolledSuper(i, i2, z, z2);
            }
        }
    }

    private void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65630, this, i, i2, i3, i4) == null) {
            WebViewDelegate webViewDelegate = this.mViewDelegate;
            if (webViewDelegate != null) {
                webViewDelegate.onScrollChanged(i, i2, i3, i4);
            } else {
                onScrollChangedSuper(i, i2, i3, i4);
            }
        }
    }

    private boolean onTouchEventDelegate(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, this, motionEvent)) == null) {
            WebViewDelegate webViewDelegate = this.mViewDelegate;
            return webViewDelegate != null ? webViewDelegate.onTouchEvent(motionEvent) : onTouchEventSuper(motionEvent);
        }
        return invokeL.booleanValue;
    }

    private void pauseDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65632, this) == null) {
        }
    }

    public static void preconnectUrl(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65633, null, str, context) == null) && WebViewFactory.hasProvider()) {
            Log.w(Log.LOG_TAG, "Webview preconnectUrl url= ".concat(String.valueOf(str)));
            getFactory().getStatics().preconnectUrl(str, 0);
        }
    }

    public static void prefetch(String str, Map<String, String> map, MainResourcePrefetchListener mainResourcePrefetchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65634, null, str, map, mainResourcePrefetchListener) == null) {
            getFactory().getStatics().prefetch(str, map, mainResourcePrefetchListener);
        }
    }

    public static void prefetchResource(String str, String[] strArr, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65635, null, str, strArr, map) == null) {
            getFactory().getStatics().prefetchResource(str, strArr, map);
        }
    }

    public static void removeFromWebCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65636, null, str) == null) {
            getFactory().getStatics().removeFromWebCache(str);
        }
    }

    public static void removeVirtualMemoryWatcher(IVirtualMemoryListener iVirtualMemoryListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65637, null, iVirtualMemoryListener) == null) {
            getFactory().getStatics().removeVirtualMemoryWatcher(iVirtualMemoryListener);
        }
    }

    public static void resolveUrl(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65638, null, str, context) == null) && WebViewFactory.hasProvider()) {
            getFactory().getStatics().resolveUrl(str);
        }
    }

    private void resumeDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65639, this) == null) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65640, null, str) == null) {
            WebViewFactory.setDataDirectorySuffix(str);
        }
    }

    private void setFindIsUp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65641, this, z) == null) {
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65642, null, z) == null) {
        }
    }

    private void setupFindListenerIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65643, this) == null) && this.mFindListener == null) {
            FindListenerDistributor findListenerDistributor = new FindListenerDistributor(this, null);
            this.mFindListener = findListenerDistributor;
            this.mProvider.setFindListener(findListenerDistributor);
        }
    }

    @Deprecated
    public void ResetClearView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkThread();
            this.mProvider.resetClearView();
        }
    }

    public void addEmbeddedTitleBarFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mProvider.addEmbeddedTitleBarFinished();
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        JSInterfaceStatistics jSInterfaceStatistics;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str) == null) {
            checkThread();
            int i = 0;
            try {
                StringBuilder sb = new StringBuilder();
                StackTraceElement[] stackTrace = new NullPointerException().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    int i2 = 0;
                    while (i < stackTrace.length - 1) {
                        try {
                            StackTraceElement stackTraceElement = stackTrace[i];
                            sb.append("\tat ".concat(String.valueOf(stackTraceElement)));
                            String methodName = stackTraceElement.getMethodName();
                            i++;
                            String methodName2 = stackTrace[i].getMethodName();
                            if (!methodName.equalsIgnoreCase("addJavascriptInterface")) {
                                if (i2 == 0) {
                                    break;
                                }
                            } else if (stackTrace[i].getClassName().equalsIgnoreCase("java.lang.reflect.Method") && methodName2.equalsIgnoreCase("invoke")) {
                                i2 = 1;
                            }
                        } catch (Throwable unused) {
                            i = i2;
                        }
                    }
                    i = i2;
                }
                if (i != 0) {
                    getJSInterfaceStatistics().mJSInfo.put(str, sb.toString());
                }
            } catch (Throwable unused2) {
            }
            if (i != 0) {
                Statistics.Client client = this.mStatisticClient;
                if (client == null || (jSInterfaceStatistics = this.mJSInterfaceStatistics) == null) {
                    return;
                }
                client.onCommitRecord(jSInterfaceStatistics);
                return;
            }
            a secureProcessor = getSecureProcessor();
            boolean a = true ^ secureProcessor.a();
            if (obj != null && !TextUtils.isEmpty(str)) {
                secureProcessor.d().put(str, obj);
                secureProcessor.f37830d = null;
            }
            if (!a || getEnableJsPrompt()) {
                return;
            }
            checkThread();
            this.mProvider.addJavascriptInterface(obj, str);
        }
    }

    public void addJavascriptInterface(Object obj, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, obj, str, z) == null) {
            checkThread();
            this.mProvider.addJavascriptInterface(obj, str);
        }
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        ZeusJsBridge zeusJsBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, iJsAbility, str) == null) || (zeusJsBridge = this.mJsBridge) == null) {
            return;
        }
        zeusJsBridge.addExternalJsFeature(str, iJsAbility);
    }

    public void addNoStatePrefetch(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            checkThread();
            this.mProvider.addNoStatePrefetch(str, str2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
                super.addView(view);
            } else {
                getWebView().addView(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i) == null) {
            if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
                super.addView(view, i);
            } else {
                getWebView().addView(view, i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i, i2) == null) {
            if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
                super.addView(view, i, i2);
            } else {
                getWebView().addView(view, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, view, i, layoutParams) == null) {
            if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
                super.addView(view, i, layoutParams);
            } else {
                getWebView().addView(view, i, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view, layoutParams) == null) {
            if (this.mProvider == null || view == getWebView() || this.mProvider.isZeusWebViewProvider()) {
                super.addView(view, -1, layoutParams);
            } else {
                getWebView().addView(view, -1, layoutParams);
            }
        }
    }

    public void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, webMessageListener, str, strArr) == null) {
            this.mProvider.addWebMessageListener(webMessageListener, str, strArr);
        }
    }

    public void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zeusPluginFactory) == null) {
            this.mProvider.addZeusPluginFactory(zeusPluginFactory);
        }
    }

    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            checkThread();
            return this.mProvider.canGoBack();
        }
        return invokeV.booleanValue;
    }

    public boolean canGoBackOrForward(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            checkThread();
            return this.mProvider.canGoBackOrForward(i);
        }
        return invokeI.booleanValue;
    }

    public boolean canGoForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            checkThread();
            return this.mProvider.canGoForward();
        }
        return invokeV.booleanValue;
    }

    public boolean canGoPrerender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!isDestroyed()) {
                checkThread();
                return this.mProvider.canGoPrerender();
            }
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean canZoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            checkThread();
            return this.mProvider.canZoomIn();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean canZoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            checkThread();
            return this.mProvider.canZoomOut();
        }
        return invokeV.booleanValue;
    }

    public void cancelCurrentNoStatePrefetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            checkThread();
            this.mProvider.cancelCurrentNoStatePrefetch();
        }
    }

    public Bitmap captureBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? captureBitmap(getMeasuredWidth(), getMeasuredHeight()) : (Bitmap) invokeV.objValue;
    }

    public Bitmap captureBitmap(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            checkThread();
            try {
                if (this.mProvider.isZeusWebViewProvider()) {
                    Picture capturePicture = this.mProvider.capturePicture(i, i2, false);
                    Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.RGB_565);
                    capturePicture.draw(new Canvas(createBitmap));
                    return createBitmap;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                System.gc();
                return null;
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    public Bitmap captureHistoryBitmap(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Picture captureHistoryPicture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048598, this, i, i2, i3)) == null) {
            checkThread();
            try {
                if (this.mProvider.isZeusWebViewProvider() && (captureHistoryPicture = this.mProvider.captureHistoryPicture(i, i2, i3)) != null && captureHistoryPicture.getWidth() > 0 && captureHistoryPicture.getHeight() > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    captureHistoryPicture.draw(new Canvas(createBitmap));
                    return createBitmap;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                System.gc();
                return null;
            }
        }
        return (Bitmap) invokeIII.objValue;
    }

    public Picture captureHistoryPicture(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Picture captureHistoryPicture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048599, this, i, i2, i3)) == null) {
            checkThread();
            try {
                if (this.mProvider.isZeusWebViewProvider() && (captureHistoryPicture = this.mProvider.captureHistoryPicture(i, i2, i3)) != null && captureHistoryPicture.getWidth() > 0) {
                    if (captureHistoryPicture.getHeight() > 0) {
                        return captureHistoryPicture;
                    }
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                System.gc();
                return null;
            }
        }
        return (Picture) invokeIII.objValue;
    }

    @Deprecated
    public Picture capturePicture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? capturePicture(true) : (Picture) invokeV.objValue;
    }

    public Picture capturePicture(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            checkThread();
            return this.mProvider.capturePicture(z ? 0 : getMeasuredWidth(), z ? 0 : getMeasuredHeight(), z);
        }
        return (Picture) invokeZ.objValue;
    }

    public void capturePicture(ValueCallback<Picture> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, valueCallback) == null) {
            checkThread();
            this.mProvider.capturePicture(getMeasuredWidth(), getMeasuredHeight(), valueCallback);
        }
    }

    public void changeWapPreloadUrlStyle(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, str) == null) {
        }
    }

    public void clearCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            checkThread();
            this.mProvider.clearCache(z);
        }
    }

    public boolean clearDiskJsCodeCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? this.mProvider.clearDiskJsCodeCache(str) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.clearFocus();
            } else {
                getWebView().clearFocus();
            }
        }
    }

    public void clearFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            checkThread();
            this.mProvider.clearFormData();
        }
    }

    public void clearHistory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            checkThread();
            this.mProvider.clearHistory();
        }
    }

    public void clearMatches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            checkThread();
            this.mProvider.clearMatches();
        }
    }

    public void clearPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (isDestroyed()) {
                Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
                new Exception().printStackTrace();
                return;
            }
            checkThread();
            this.mProvider.clearPrerender();
        }
    }

    public void clearSslPreferences() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            checkThread();
            this.mProvider.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            checkThread();
            this.mProvider.clearView();
        }
    }

    public void completeSelection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.mProvider.selectionDone();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? super.computeHorizontalScrollExtent() : invokeV.intValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mProvider.getScrollDelegate().computeHorizontalScrollOffset() : invokeV.intValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mProvider.getScrollDelegate().computeHorizontalScrollRange() : invokeV.intValue;
    }

    public int computeMaxScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int computeMaxScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.mProvider.getScrollDelegate().computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mProvider.getScrollDelegate().computeVerticalScrollExtent() : invokeV.intValue;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mProvider.getScrollDelegate().computeVerticalScrollOffset() : invokeV.intValue;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mProvider.getScrollDelegate().computeVerticalScrollRange() : invokeV.intValue;
    }

    public WebBackForwardList copyBackForwardList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            checkThread();
            return this.mProvider.copyBackForwardListZeus();
        }
        return (WebBackForwardList) invokeV.objValue;
    }

    public WebMessagePort[] createWebMessageChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (WebMessagePort[]) invokeV.objValue;
    }

    public void cutdownUserData(int i) {
        WebViewProvider webViewProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i) == null) || (webViewProvider = this.mProvider) == null) {
            return;
        }
        webViewProvider.cutdownUserData(i);
    }

    @Deprecated
    public void debugDump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            checkThread();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            a secureProcessor = getSecureProcessor();
            if (secureProcessor.f37829c.getContext().getPackageName().contains("com.baidu.searchbox")) {
                HashMap<String, Object> hashMap = secureProcessor.f37828b;
                if (hashMap != null) {
                    hashMap.clear();
                    secureProcessor.f37828b = null;
                }
                if (secureProcessor.f37829c.getWebViewClient() != null) {
                    secureProcessor.f37830d = null;
                }
            }
            checkThread();
            ZeusJsBridge zeusJsBridge = this.mJsBridge;
            if (zeusJsBridge != null) {
                zeusJsBridge.release();
                this.mJsBridge = null;
            }
            this.mProvider.destroy();
            this.mDestroyed = true;
        }
    }

    public void destroyCanvasCacheBmp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    public void disableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.mProvider.disableMedia();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, canvas) == null) {
            this.mProvider.getViewDelegate().preDispatchDraw(canvas);
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, keyEvent)) == null) ? this.mProvider.getViewDelegate().dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public void documentHasImages(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, message) == null) {
            checkThread();
            this.mProvider.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048633, this, bufferedWriter, i) == null) {
            this.mProvider.dumpViewHierarchyWithProperties(bufferedWriter, i);
        }
    }

    @Deprecated
    public void emulateShiftHeld() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            checkThread();
            this.mProvider.emulateShiftHeldOnLink();
        }
    }

    public void emulateShiftHeldOnLink() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.mProvider.emulateShiftHeldOnLink();
        }
    }

    public void emulateShiftHeldOnNormalText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.mProvider.emulateShiftHeldOnNormalText();
        }
    }

    public void enableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.mProvider.enableMedia();
        }
    }

    public void evaluateJavaScriptOnPrerender(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, str, valueCallback) == null) {
            checkThread();
            this.mProvider.evaluateJavaScriptOnPrerender(str, valueCallback);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, str, valueCallback) == null) {
            checkThread();
            this.mProvider.evaluateJavaScript(str, valueCallback);
        }
    }

    public void evaluateJavascriptMethod(String str, String str2, String str3, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048640, this, str, str2, str3, valueCallback) == null) {
            checkThread();
            this.mProvider.evaluateJavaScriptMethod(str, str2, str3, valueCallback);
        }
    }

    public void execJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            loadUrl("javascript:".concat(String.valueOf(str)));
        }
    }

    public void execJavaScriptExt(String str, String... strArr) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, str, strArr) == null) {
            if (strArr == null || strArr.length == 0) {
                str2 = "javascript:(" + str + ")()";
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("javascript:" + str + "('");
                for (int i = 0; i < strArr.length; i++) {
                    stringBuffer.append(strArr[i]);
                    if (i != strArr.length - 1) {
                        stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
                stringBuffer.append("')");
                str2 = stringBuffer.toString();
            }
            loadUrl(str2);
        }
    }

    public void exitFullScreenMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.mProvider.exitFullScreenMode();
        }
    }

    public void extendSelection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.mProvider.extendSelection();
        }
    }

    @Deprecated
    public int findAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            checkThread();
            StrictMode.noteSlowCall("findAll blocks UI: prefer findAllAsync");
            return this.mProvider.findAll(str);
        }
        return invokeL.intValue;
    }

    public void findAllAsync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            checkThread();
            this.mProvider.findAllAsync(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public View findFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mProvider.getViewDelegate().findFocus(super.findFocus()) : (View) invokeV.objValue;
    }

    public View findHierarchyView(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048648, this, str, i)) == null) ? this.mProvider.findHierarchyView(str, i) : (View) invokeLI.objValue;
    }

    public void findNext(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            checkThread();
            this.mProvider.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i, i2) == null) {
            checkThread();
            this.mProvider.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            checkThread();
            this.mProvider.freeMemory();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? WebView.class.getName() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            AccessibilityNodeProvider accessibilityNodeProvider = this.mProvider.getViewDelegate().getAccessibilityNodeProvider();
            return accessibilityNodeProvider == null ? super.getAccessibilityNodeProvider() : accessibilityNodeProvider;
        }
        return (AccessibilityNodeProvider) invokeV.objValue;
    }

    public int getActionNodesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public float getActualZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? getScale() : invokeV.floatValue;
    }

    public Bitmap getCanvasCacheBmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mProvider.getCanvasCacheBmp() : (Bitmap) invokeV.objValue;
    }

    public SslCertificate getCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            checkThread();
            return this.mProvider.getCertificate();
        }
        return (SslCertificate) invokeV.objValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    public int getContentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            checkThread();
            return this.mProvider.getContentHeight();
        }
        return invokeV.intValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    public int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mProvider.getContentWidth() : invokeV.intValue;
    }

    public String getCookieByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, str)) == null) ? CookieManager.getInstance().getCookie(str) : (String) invokeL.objValue;
    }

    public float getCurrentScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? getScale() : invokeV.floatValue;
    }

    public long getCurrentSourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mCurrentSourceId : invokeV.longValue;
    }

    public View getCurrentTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.mViewDelegate.getCurrentTitleBar() : (View) invokeV.objValue;
    }

    public View getEmbeddedTitlebar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mViewDelegate.getEmbeddedTitlebar() : (View) invokeV.objValue;
    }

    public Bitmap getFavicon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            checkThread();
            return this.mProvider.getFavicon();
        }
        return (Bitmap) invokeV.objValue;
    }

    public String getGpuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mProvider.getGpuInfo() : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.mProvider.getViewDelegate().getHandler(super.getHandler()) : (Handler) invokeV.objValue;
    }

    public HitTestResult getHitTestResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            checkThread();
            return this.mProvider.getHitTestResultZeus();
        }
        return (HitTestResult) invokeV.objValue;
    }

    @Deprecated
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048669, this, str, str2)) == null) {
            checkThread();
            return this.mProvider.getHttpAuthUsernamePassword(str, str2);
        }
        return (String[]) invokeLL.objValue;
    }

    public View getLandingPageTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.mViewDelegate.getLandingPageTitleBar() : (View) invokeV.objValue;
    }

    public Bitmap getMagnifierBmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void getManifestInfo(ManifestInfoCallback manifestInfoCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, manifestInfoCallback) == null) || manifestInfoCallback == null) {
            return;
        }
        this.mProvider.getManifestInfo(manifestInfoCallback);
    }

    public float getMaxZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.mProvider.getMaxZoomScale() : invokeV.floatValue;
    }

    public float getMinZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mProvider.getMinZoomScale() : invokeV.floatValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            checkThread();
            WebViewProvider webViewProvider = this.mProvider;
            return webViewProvider == null ? "" : webViewProvider.getOriginalUrl();
        }
        return (String) invokeV.objValue;
    }

    public WebPageInfoList getPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? new WebPageInfoList(this) : (WebPageInfoList) invokeV.objValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            checkThread();
            return this.mProvider.getProgress();
        }
        return invokeV.intValue;
    }

    public String getReferer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            checkThread();
            WebViewProvider webViewProvider = this.mProvider;
            return webViewProvider == null ? "" : webViewProvider.getReferer();
        }
        return (String) invokeV.objValue;
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.mProvider.getRendererPriorityWaivedWhenNotVisible() : invokeV.booleanValue;
    }

    public int getRendererRequestedPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mProvider.getRendererRequestedPriority() : invokeV.intValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    @Deprecated
    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            checkThread();
            return this.mProvider.getScale();
        }
        return invokeV.floatValue;
    }

    public int getScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public View getSearchResultTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.mViewDelegate.getSearchResultTitleBar() : (View) invokeV.objValue;
    }

    public a getSecureProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (this.mSecureProcessor == null) {
                this.mSecureProcessor = new a(this);
            }
            return this.mSecureProcessor;
        }
        return (a) invokeV.objValue;
    }

    public boolean getSelectingText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.mProvider.getSelectingText() : invokeV.booleanValue;
    }

    public WebSettings getSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            checkThread();
            return this.mProvider.getSettingsZeus();
        }
        return (WebSettings) invokeV.objValue;
    }

    public CharSequence getTextFieldText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.mProvider.getTextFieldText() : (CharSequence) invokeV.objValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            checkThread();
            WebViewProvider webViewProvider = this.mProvider;
            return webViewProvider == null ? "" : webViewProvider.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public int getTitleHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTitlebarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mViewDelegate.getTitlebarHeight() : invokeV.intValue;
    }

    public int getTouchMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.mProvider.getTouchMode() : invokeV.intValue;
    }

    @ViewDebug.ExportedProperty(category = AlbumActivityConfig.FROM_WEB_VIEW)
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            checkThread();
            WebViewProvider webViewProvider = this.mProvider;
            return webViewProvider == null ? "" : webViewProvider.getUrl();
        }
        return (String) invokeV.objValue;
    }

    public Object getUserData(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048693, this, i, i2)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider != null) {
                return webViewProvider.getUserData(i, i2);
            }
            return null;
        }
        return invokeII.objValue;
    }

    @Override // android.view.View
    public int getVerticalScrollbarWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.getVerticalScrollbarWidth() : getWebView().getVerticalScrollbarWidth();
        }
        return invokeV.intValue;
    }

    public WebViewDelegate getViewDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.mViewDelegate : (WebViewDelegate) invokeV.objValue;
    }

    @Override // android.view.View
    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.getVisibility() : getWebView().getVisibility();
        }
        return invokeV.intValue;
    }

    public int getVisibleTitleHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            checkThread();
            return this.mProvider.getVisibleTitleHeightZeus();
        }
        return invokeV.intValue;
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, webAppShortcutDataListener) == null) {
            this.mProvider.getWebAppShortcutData(webAppShortcutDataListener, false);
        }
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048699, this, webAppShortcutDataListener, z) == null) {
            this.mProvider.getWebAppShortcutData(webAppShortcutDataListener, z);
        }
    }

    public WebChromeClient getWebChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            checkThread();
            return this.mProvider.getWebChromeClientZeus();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    public AbsoluteLayout getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.mProvider.getViewDelegate().getWebViewImpl() : (AbsoluteLayout) invokeV.objValue;
    }

    public WebViewClient getWebViewClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            checkThread();
            return this.mProvider.getWebViewClientZeus();
        }
        return (WebViewClient) invokeV.objValue;
    }

    @NonNull
    public Looper getWebViewLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.mWebViewThread : (Looper) invokeV.objValue;
    }

    public ViewGroup getWebViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.mProvider.getWebViewPager() : (ViewGroup) invokeV.objValue;
    }

    public WebViewProvider getWebViewProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.mProvider : (WebViewProvider) invokeV.objValue;
    }

    public final int getWebViewScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? getWebView().getScrollX() : invokeV.intValue;
    }

    public final int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? getWebView().getScrollY() : invokeV.intValue;
    }

    public WebViewType getWebViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? WebViewType.NORMAL : (WebViewType) invokeV.objValue;
    }

    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            checkThread();
            this.mProvider.goBack();
        }
    }

    public void goBackOrForward(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i) == null) {
            checkThread();
            this.mProvider.goBackOrForward(i);
        }
    }

    public void goForward() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            checkThread();
            this.mProvider.goForward();
        }
    }

    public void goNextOrPreTextField(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
            this.mProvider.goNextOrPreTextField(z);
        }
    }

    public void goPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            if (isDestroyed()) {
                Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
                new Exception().printStackTrace();
                return;
            }
            checkThread();
            this.mProvider.goPrerender();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.hasFocus() : getWebView().hasFocus();
        }
        return invokeV.booleanValue;
    }

    public boolean hasJavascriptInterfaceExt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048715, this, str)) == null) {
            ZeusJsBridge zeusJsBridge = this.mJsBridge;
            if (zeusJsBridge != null) {
                return zeusJsBridge.hasExternalJsFeature(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void hideMagnifier(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048716, this, i, i2) == null) {
        }
    }

    public void hitAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.mProvider.hitAd(str);
        }
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048718, this, view)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.indexOfChild(view) : getWebView().indexOfChild(view);
        }
        return invokeL.intValue;
    }

    public void insertTextFieldText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, charSequence) == null) {
            this.mProvider.insertTextFieldText(charSequence);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.invalidate();
            } else {
                getWebView().invalidate();
            }
        }
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048721, this, i, i2, i3, i4) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.invalidate(i, i2, i3, i4);
            } else {
                getWebView().invalidate(i, i2, i3, i4);
            }
        }
    }

    public void invokeZoomPicker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            checkThread();
            this.mProvider.invokeZoomPicker();
        }
    }

    public boolean isAutoShowTitlebar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.mProvider.isAutoShowTitlebar() : invokeV.booleanValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.mDestroyed : invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isDrawingCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.isDrawingCacheEnabled() : getWebView().isDrawingCacheEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            return (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) ? super.isFocused() : getWebView().isFocused();
        }
        return invokeV.booleanValue;
    }

    public boolean isMobileSite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.mProvider.isMobileSite() : invokeV.booleanValue;
    }

    public boolean isOnViewHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.mOnViewHierarchy : invokeV.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.mProvider.isPaused() : invokeV.booleanValue;
    }

    public boolean isPrivateBrowsingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            checkThread();
            return this.mProvider.isPrivateBrowsingEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isScrollInProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.mProvider.isScrollInProgress() : invokeV.booleanValue;
    }

    public boolean isTitlebarCanShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.mViewDelegate.isTitlebarCanShow() : invokeV.booleanValue;
    }

    public boolean isTitlebarShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.mViewDelegate.isTitlebarShowing() : invokeV.booleanValue;
    }

    public boolean isWapAllowScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048735, this, str, str2, str3) == null) {
            checkThread();
            this.mProvider.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048736, this, str, str2, str3, str4, str5) == null) {
            checkThread();
            this.mProvider.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048737, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            checkThread();
            this.mProvider.loadDataWithBaseURL(str, str2, str3, str4, str5, z);
        }
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048738, this, str) != null) {
            return;
        }
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str != null) {
                try {
                    if (!str.startsWith("javascript:") && getWebViewProvider() != null) {
                        getSecureProcessor().a(str);
                        PagePerformanceTiming performanceTiming = getWebViewProvider().getPerformanceTiming();
                        if (performanceTiming != null) {
                            performanceTiming.markLoadUrlStart(str);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.mProvider.loadUrl(str);
        }
        while (true) {
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048739, this, str, map) != null) {
            return;
        }
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str != null && !str.startsWith("javascript:") && getWebViewProvider() != null) {
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLZ(1048740, this, str, map, z) != null) {
            return;
        }
        if (isDestroyed()) {
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return;
        }
        if (str == null || !str.contains("force.flyflow.anr.now")) {
            checkThread();
            if (str == null) {
                return;
            }
            if (str != null && !str.startsWith("javascript:") && getWebViewProvider() != null) {
                getSecureProcessor().a(str);
                PagePerformanceTiming performanceTiming = getWebViewProvider().getPerformanceTiming();
                if (performanceTiming != null) {
                    performanceTiming.markLoadUrlStart(str);
                }
            }
            this.mProvider.loadUrl(str, map, z);
        }
        while (true) {
        }
    }

    public void mediaPlayerStatusChanged(int i, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048741, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    public void mediaPlayerTimeChanged(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048742, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    public void moveMagnifier(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048743, this, i, i2) == null) {
        }
    }

    public int nightModeColorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean notifyNativeExitFullScreenIfNeeded(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048745, this, i)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    public void notifyUkmPageLeave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            checkThread();
            this.mProvider.notifyUkmPageLeave();
        }
    }

    public void notifyUnsafeInvolved(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048747, this, i, str) == null) {
            checkThread();
            this.mProvider.notifyUnsafeInvolved(i, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
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
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            try {
                return this.mProvider.getViewDelegate().onCheckIsTextEditor();
            } catch (RuntimeException e2) {
                Log.w(LOGTAG, "Ignoring RuntimeException with fallback", e2);
                return super.onCheckIsTextEditor();
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewAdded(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048750, this, view, view2) == null) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewRemoved(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048751, this, view, view2) == null) {
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, configuration) == null) {
            this.mProvider.getViewDelegate().onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, editorInfo)) == null) ? this.mProvider.getViewDelegate().onCreateInputConnection(editorInfo) : (InputConnection) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
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
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, dragEvent)) == null) ? this.mProvider.getViewDelegate().onDragEvent(dragEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    @SuppressLint({"WrongCall"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, canvas) == null) {
            this.mProvider.getViewDelegate().onDraw(canvas);
        }
    }

    public void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{canvas, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mProvider.getViewDelegate().onDrawVerticalScrollBar(canvas, drawable, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            super.onFinishTemporaryDetach();
            this.mProvider.getViewDelegate().onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048759, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
            this.mProvider.getViewDelegate().onFocusChanged(z, i, rect);
            super.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048760, this, motionEvent)) == null) ? this.mProvider.getViewDelegate().onGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    @Deprecated
    public void onGlobalFocusChanged(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048761, this, view, view2) == null) {
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048762, this, motionEvent)) == null) ? this.mProvider.getViewDelegate().onHoverEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048763, this, accessibilityEvent) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            if (getAccessibilityNodeProvider() == null) {
                this.mProvider.getViewDelegate().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048764, this, accessibilityNodeInfo) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (getAccessibilityNodeProvider() == null) {
                this.mProvider.getViewDelegate().onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048765, this, motionEvent)) == null) {
            if (isDestroyed()) {
                Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
                return true;
            }
            return this.mProvider.getViewDelegate().onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048766, this, i, keyEvent)) == null) ? this.mProvider.getViewDelegate().onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048767, this, i, i2, keyEvent)) == null) ? this.mProvider.getViewDelegate().onKeyMultiple(i, i2, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048768, this, i, keyEvent)) == null) ? this.mProvider.getViewDelegate().onKeyUp(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048769, this, view)) == null) {
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
                if (type != 0 && type != 9) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048770, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.mProvider.getViewDelegate().onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048771, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            onOverScrolledDelegate(i, i2, z, z2);
        }
    }

    public void onOverScrolledSuper(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048772, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mProvider.getViewDelegate().onOverScrolled(i, i2, z, z2);
        }
    }

    public void onPageSwapFromWebview(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048773, this, webView, str, z) == null) {
            checkThread();
            this.mProvider.onPageSwapFromWebview(webView, str, z);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            checkThread();
            this.mProvider.onPause();
        }
    }

    public void onPauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048775, this) == null) {
            checkThread();
            this.mProvider.onPauseAll();
        }
    }

    @Override // android.view.View
    public void onProvideVirtualStructure(ViewStructure viewStructure) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, viewStructure) == null) {
            this.mProvider.getViewDelegate().onProvideVirtualStructure(viewStructure);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            checkThread();
            this.mProvider.onResume();
        }
    }

    public void onResumeAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            checkThread();
            this.mProvider.onResumeAll();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048779, this, i, i2, i3, i4) == null) {
            onScrollChangedDelegate(i, i2, i3, i4);
        }
    }

    public void onScrollChangedSuper(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048780, this, i, i2, i3, i4) == null) {
            if (isDestroyed()) {
                Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
                return;
            }
            try {
                if (this.mProvider == null || this.mProvider.isZeusWebViewProvider()) {
                    super.onScrollChanged(i, i2, i3, i4);
                }
                this.mProvider.getViewDelegate().onScrollChanged(i, i2, i3, i4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048781, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.mProvider.getViewDelegate().onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            super.onStartTemporaryDetach();
            this.mProvider.getViewDelegate().onStartTemporaryDetach();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048783, this, motionEvent)) == null) ? onTouchEventDelegate(motionEvent) : invokeL.booleanValue;
    }

    public boolean onTouchEventSuper(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048784, this, motionEvent)) == null) ? this.mProvider.getViewDelegate().onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048785, this, motionEvent)) == null) ? this.mProvider.getViewDelegate().onTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048786, this, view, i) == null) {
            super.onVisibilityChanged(view, i);
            ensureProviderCreated();
            this.mProvider.getViewDelegate().onVisibilityChanged(view, i);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048787, this, z) == null) {
            this.mProvider.getViewDelegate().onWindowFocusChanged(z);
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048788, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            this.mProvider.getViewDelegate().onWindowVisibilityChanged(i);
        }
    }

    @Deprecated
    public boolean overlayHorizontalScrollbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean overlayVerticalScrollbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean pageDown(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048791, this, z)) == null) {
            checkThread();
            return this.mProvider.pageDown(z);
        }
        return invokeZ.booleanValue;
    }

    public boolean pageUp(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048792, this, z)) == null) {
            checkThread();
            return this.mProvider.pageUp(z);
        }
        return invokeZ.booleanValue;
    }

    public void pause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
        }
    }

    public void pauseMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            this.mProvider.pauseMedia();
        }
    }

    public void pauseTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            checkThread();
            this.mProvider.pauseTimers();
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048796, this, i, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    super.performAccessibilityAction(i, bundle);
                    if (getAccessibilityNodeProvider() == null) {
                        return this.mProvider.getViewDelegate().performAccessibilityAction(i, bundle);
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.mProvider.getViewDelegate().performLongClick() : invokeV.booleanValue;
    }

    public void postUrl(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048798, this, str, bArr) == null) {
            checkThread();
            if (URLUtil.isNetworkUrl(str)) {
                this.mProvider.postUrl(str, bArr);
            } else {
                this.mProvider.loadUrl(str);
            }
        }
    }

    public void postVisualStateCallback(long j, VisualStateCallback visualStateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048799, this, j, visualStateCallback) == null) {
            checkThread();
            this.mProvider.insertVisualStateCallback(j, visualStateCallback);
        }
    }

    public void postWebMessage(WebMessage webMessage, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048800, this, webMessage, uri) == null) {
            checkThread();
            this.mProvider.postMessageToMainFrame(webMessage, uri);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            checkThread();
        }
    }

    public void reinjectJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048802, this) == null) {
            checkThread();
            this.mProvider.reinjectJavascriptInterface();
        }
    }

    public void reload() {
        PagePerformanceTiming performanceTiming;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048803, this) == null) {
            checkThread();
            if (getWebViewProvider() != null && (performanceTiming = getWebViewProvider().getPerformanceTiming()) != null) {
                performanceTiming.markLoadUrlStart(getUrl());
            }
            this.mProvider.reload();
        }
    }

    public void removeHistoryItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048804, this) == null) {
            this.mProvider.removeHistoryItems();
        }
    }

    public void removeJavascriptInterface(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, str) == null) {
            a secureProcessor = getSecureProcessor();
            boolean z = true;
            if (!"searchBoxJavaBridge_".equalsIgnoreCase(str) && secureProcessor.f37829c.getContext().getPackageName().contains("com.baidu.searchbox")) {
                boolean z2 = !secureProcessor.a();
                secureProcessor.d().remove(str);
                if (secureProcessor.f37829c.getWebViewClient() != null) {
                    secureProcessor.f37830d = null;
                }
                z = z2;
            }
            if (z) {
                checkThread();
                this.mProvider.removeJavascriptInterface(str);
            }
        }
    }

    public void removeJavascriptInterfaceExt(String str) {
        ZeusJsBridge zeusJsBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048806, this, str) == null) || (zeusJsBridge = this.mJsBridge) == null) {
            return;
        }
        zeusJsBridge.removeExternalJsFeature(str);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, view) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.removeView(view);
            } else {
                getWebView().removeView(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048808, this, view, rect, z)) == null) ? this.mProvider.getViewDelegate().requestChildRectangleOnScreen(view, rect, z) : invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048809, this, i, rect)) == null) ? this.mProvider.getViewDelegate().requestFocus(i, rect) : invokeIL.booleanValue;
    }

    public void requestFocusNodeHref(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, message) == null) {
            checkThread();
            this.mProvider.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, message) == null) {
            checkThread();
            this.mProvider.requestImageRef(message);
        }
    }

    public final boolean requestWebViewFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048812, this)) == null) ? getWebView().requestFocus() : invokeV.booleanValue;
    }

    public void resetLoadingAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048813, this) == null) {
            this.mProvider.resetLoadingAnimation();
        }
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048814, this, bundle)) == null) {
            checkThread();
            return this.mProvider.restoreStateZeus(bundle);
        }
        return (WebBackForwardList) invokeL.objValue;
    }

    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048815, this, z) == null) {
        }
    }

    public void resumeMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048816, this) == null) {
            this.mProvider.resumeMedia();
        }
    }

    public void resumeTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048817, this) == null) {
            checkThread();
            this.mProvider.resumeTimers();
        }
    }

    public boolean savePageAsLocalFiles(String str, String str2, SaveAsType saveAsType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048818, this, str, str2, saveAsType)) == null) ? this.mProvider.savePageAsLocalFiles(str, str2, saveAsType) : invokeLLL.booleanValue;
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048819, this, str, str2, str3) == null) {
            checkThread();
            this.mProvider.savePassword(str, str2, str3);
        }
    }

    public WebBackForwardList saveState(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048820, this, bundle)) == null) {
            checkThread();
            return this.mProvider.saveStateZeus(bundle);
        }
        return (WebBackForwardList) invokeL.objValue;
    }

    public void saveWebArchive(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048821, this, str) == null) {
            checkThread();
            this.mProvider.saveWebArchive(str);
        }
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048822, this, new Object[]{str, Boolean.valueOf(z), valueCallback}) == null) {
            checkThread();
            this.mProvider.saveWebArchive(str, z, valueCallback);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048823, this, i, i2) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.scrollBy(i, i2);
            } else {
                getWebView().scrollBy(i, i2);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048824, this, i, i2) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.scrollTo(i, i2);
            } else {
                getWebView().scrollTo(i, i2);
            }
        }
    }

    public void sendFeedback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048825, this, str) == null) {
            sendFeedback("", str);
        }
    }

    public void sendFeedback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048826, this, str, str2) == null) {
            this.mProvider.sendFeedback(str, str2);
        }
    }

    public void setAutoShowTitlebar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048827, this, z) == null) {
            this.mProvider.setAutoShowTitlebar(z);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048828, this, i) == null) {
            this.mProvider.getViewDelegate().setBackgroundColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048829, this, i) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setBackgroundResource(i);
            } else {
                getWebView().setBackgroundResource(i);
            }
        }
    }

    public void setBeginScale() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048830, this) == null) {
            this.mProvider.setBeginScale();
        }
    }

    public void setBottomControlsHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048831, this, i) == null) {
            this.mProvider.setBottomControlsHeight(i);
        }
    }

    @Deprecated
    public void setCachePictureEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048832, this, z) == null) {
        }
    }

    public void setCanvasCacheBmp(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048833, this, bitmap) == null) {
            this.mProvider.setCanvasCacheBmp(bitmap);
        }
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048834, this, sslCertificate) == null) {
            checkThread();
            this.mProvider.setCertificate(sslCertificate);
        }
    }

    public void setCurrentSourceIdByIdentifier() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048835, this) == null) {
            long j = mIdentifier + 1;
            mIdentifier = j;
            this.mCurrentSourceId = j << 16;
            Log.i("huqin-sourceid", "setCurrentSourceIdByIdentifier sourceId = " + this.mCurrentSourceId);
        }
    }

    public void setCurrentSourceIdByNavigationId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048836, this, j) == null) || j < 0) {
            return;
        }
        this.mCurrentSourceId = (j << 2) + 1;
        Log.i("huqin-sourceid", "setCurrentSourceIdByNavigationId sourceId = " + this.mCurrentSourceId);
    }

    public void setCurrentTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048837, this, z) == null) {
            this.mViewDelegate.setCurrentTitleBar(z);
        }
    }

    public void setDefaultViewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048838, this, i, i2) == null) {
            checkThread();
            this.mProvider.setDefaultViewSize(i, i2);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, downloadListener) == null) {
            checkThread();
            this.mProvider.setDownloadListener(downloadListener);
        }
    }

    @Override // android.view.View
    public void setDrawingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048840, this, z) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setDrawingCacheEnabled(z);
            } else {
                getWebView().setDrawingCacheEnabled(z);
            }
        }
    }

    public void setEmbeddedTitleBar(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048841, this, view) == null) {
            setEmbeddedTitleBar(view, 0);
        }
    }

    public void setEmbeddedTitleBar(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048842, this, view, i) == null) {
        }
    }

    public void setEndScale() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048843, this) == null) {
            this.mProvider.setEndScale();
        }
    }

    public void setFindListener(FindListener findListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, findListener) == null) {
            checkThread();
            setupFindListenerIfNeeded();
            this.mFindListener.mUserFindListener = findListener;
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048845, this, z) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setFocusable(z);
            } else {
                getWebView().setFocusable(z);
            }
        }
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048846, this, z) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setHorizontalScrollBarEnabled(z);
            } else {
                getWebView().setHorizontalScrollBarEnabled(z);
            }
        }
    }

    @Deprecated
    public void setHorizontalScrollbarOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048847, this, z) == null) {
        }
    }

    @Deprecated
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048848, this, str, str2, str3, str4) == null) {
            checkThread();
            this.mProvider.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048849, this, i) == null) {
            checkThread();
            this.mProvider.setInitialScale(i);
        }
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048850, this, i, paint) == null) {
            super.setLayerType(i, paint);
            this.mProvider.getViewDelegate().setLayerType(i, paint);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048851, this, layoutParams) == null) {
            this.mProvider.getViewDelegate().setLayoutParams(layoutParams);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048852, this, z) == null) {
            checkThread();
            this.mProvider.setMapTrackballToArrowKeys(z);
        }
    }

    public void setNetworkAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048853, this, z) == null) {
            checkThread();
            this.mProvider.setNetworkAvailable(z);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, onClickListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnClickListener(onClickListener);
            } else {
                getWebView().setOnClickListener(onClickListener);
            }
        }
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048855, this, onCreateContextMenuListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnCreateContextMenuListener(onCreateContextMenuListener);
            } else {
                getWebView().setOnCreateContextMenuListener(onCreateContextMenuListener);
            }
        }
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, onFocusChangeListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnFocusChangeListener(onFocusChangeListener);
            } else {
                getWebView().setOnFocusChangeListener(onFocusChangeListener);
            }
        }
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, onKeyListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnKeyListener(onKeyListener);
            } else {
                getWebView().setOnKeyListener(onKeyListener);
            }
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048858, this, onLongClickListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnLongClickListener(onLongClickListener);
            } else {
                getWebView().setOnLongClickListener(onLongClickListener);
            }
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048859, this, onTouchListener) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setOnTouchListener(onTouchListener);
            } else {
                getWebView().setOnTouchListener(onTouchListener);
            }
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048860, this, i) == null) {
            super.setOverScrollMode(i);
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null) {
                this.mSetOverScrollModeBeforeProviderReady = i;
            } else {
                webViewProvider.getViewDelegate().setOverScrollMode(i);
            }
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048861, this, z, pageTransformer) == null) {
            this.mProvider.setPageTransformer(z, pageTransformer);
        }
    }

    public void setPauseSyncActions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048862, this, z) == null) {
            checkThread();
            this.mProvider.setPauseSyncActions(z);
        }
    }

    @Deprecated
    public void setPictureListener(PictureListener pictureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, pictureListener) == null) {
            checkThread();
            this.mProvider.setPictureListener(pictureListener);
        }
    }

    public boolean setPreviewZoomScale(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048864, this, f2)) == null) ? this.mProvider.setPreviewZoomScale(f2) : invokeF.booleanValue;
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048865, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mProvider.setRendererPriorityPolicy(i, z);
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048866, this, i) == null) {
            this.mProvider.getViewDelegate().setScrollBarStyle(i);
            super.setScrollBarStyle(i);
        }
    }

    @Override // android.view.View
    public void setScrollbarFadingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048867, this, z) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setScrollbarFadingEnabled(z);
            } else {
                getWebView().setScrollbarFadingEnabled(z);
            }
        }
    }

    public boolean setSelectingText(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048868, this, z)) == null) {
            this.mProvider.setSelectingText(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void setStatisticsClient(Statistics.Client client) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048869, this, client) == null) {
            this.mStatisticClient = client;
        }
    }

    public void setStatusBar(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048870, this, view, i) == null) {
            this.mProvider.setStatusBar(view, i);
        }
    }

    public void setSubjectScrollToOnload(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048871, this, i) == null) {
        }
    }

    public void setTextFieldText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048872, this, charSequence) == null) {
            this.mProvider.setTextFieldText(charSequence);
        }
    }

    public void setTopControlsHeight(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048873, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mProvider.setTopControlsHeight(i, z);
        }
    }

    public void setUserData(int i, int i2, Object obj) {
        WebViewProvider webViewProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048874, this, i, i2, obj) == null) || (webViewProvider = this.mProvider) == null) {
            return;
        }
        webViewProvider.setUserData(i, i2, obj);
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048875, this, z) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setVerticalScrollBarEnabled(z);
            } else {
                getWebView().setVerticalScrollBarEnabled(z);
            }
        }
    }

    @Deprecated
    public void setVerticalScrollbarOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048876, this, z) == null) {
        }
    }

    public void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048877, this, videoPlayerFactory) == null) {
            this.mProvider.setVideoPlayerFactory(videoPlayerFactory);
        }
    }

    public void setViewDelegate(WebViewDelegate webViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, webViewDelegate) == null) {
            this.mViewDelegate = webViewDelegate;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048879, this, i) == null) {
            WebViewProvider webViewProvider = this.mProvider;
            if (webViewProvider == null || webViewProvider.isZeusWebViewProvider()) {
                super.setVisibility(i);
            } else {
                getWebView().setVisibility(i);
            }
        }
    }

    public boolean setVisitedLinkNightColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048880, this, i)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048881, this, webBackForwardListClient) == null) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048882, this, webChromeClient) == null) {
            checkThread();
            this.mProvider.setWebChromeClient(webChromeClient);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048883, this, webViewClient) == null) {
            checkThread();
            this.mProvider.setWebViewClient(webViewClient);
        }
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048884, this, i, i2, i3, i4) == null) {
            this.mProvider.setWebViewMargin(i, i2, i3, i4);
        }
    }

    public void setWebViewPagerContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048885, this, viewGroup) == null) {
            this.mProvider.setWebViewPagerContainer(viewGroup);
        }
    }

    public void setWebViewPagerSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048886, this, i, i2) == null) {
            this.mProvider.setWebViewPagerSize(i, i2);
        }
    }

    public void setWebViewState(WebViewState webViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048887, this, webViewState) == null) {
        }
    }

    public void setWebViewType(WebViewType webViewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048888, this, webViewType) == null) {
        }
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup
    @Deprecated
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048889, this)) == null) ? this.mProvider.getViewDelegate().shouldDelayChildPressedState() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean showFindDialog(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048890, this, str, z)) == null) {
            checkThread();
            return this.mProvider.showFindDialog(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public void showMagnifier(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048891, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
        }
    }

    public void startLoadingAnimation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048892, this, str) == null) {
            this.mProvider.startLoadingAnimation(str);
        }
    }

    public int startPrerender(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048893, this, str)) == null) {
            if (!isDestroyed()) {
                checkThread();
                return this.mProvider.startPrerender(str);
            }
            Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
            new Exception().printStackTrace();
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean startPreviewZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048894, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048895, this) == null) {
            checkThread();
            this.mProvider.stopLoading();
        }
    }

    public void stopPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048896, this) == null) {
            if (isDestroyed()) {
                Log.e(Log.LOG_TAG, "Webview has destoryed !!!");
                new Exception().printStackTrace();
                return;
            }
            checkThread();
            this.mProvider.stopPrerender();
        }
    }

    public void suspendScheduledTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048897, this, str) == null) {
            checkThread();
            this.mProvider.suspendScheduledTasks(str);
        }
    }

    public void switchTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048898, this, z) == null) {
            this.mProvider.switchTitleBar(z);
        }
    }

    public void updateTopControlOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048899, this, i) == null) {
            this.mProvider.updateTopControlOffset(i);
        }
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048900, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mProvider.updateTopControlsState(z, z2, z3);
        }
    }

    public void zoomBy(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048901, this, f2) == null) {
            checkThread();
            double d2 = f2;
            if (d2 < 0.01d) {
                throw new IllegalArgumentException("zoomFactor must be greater than 0.01.");
            }
            if (d2 > 100.0d) {
                throw new IllegalArgumentException("zoomFactor must be less than 100.");
            }
            this.mProvider.zoomByZeus(f2);
        }
    }

    public boolean zoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048902, this)) == null) {
            checkThread();
            return this.mProvider.zoomIn();
        }
        return invokeV.booleanValue;
    }

    public boolean zoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048903, this)) == null) {
            checkThread();
            return this.mProvider.zoomOut();
        }
        return invokeV.booleanValue;
    }
}

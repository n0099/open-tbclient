package com.baidu.webkit.sdk.system;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.webkit.WebMessage;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import java.lang.reflect.Field;
/* loaded from: classes12.dex */
final class Glue {
    private static Field ImmutableField;

    /* renamed from: com.baidu.webkit.sdk.system.Glue$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$PluginState;
        static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$ZoomDensity;

        static {
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[WebSettings.RenderPriority.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[WebSettings.RenderPriority.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[WebSettings.RenderPriority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState = new int[WebSettings.PluginState.values().length];
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            $SwitchMap$android$webkit$WebSettings$PluginState = new int[WebSettings.PluginState.values().length];
            try {
                $SwitchMap$android$webkit$WebSettings$PluginState[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$PluginState[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$PluginState[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm = new int[WebSettings.LayoutAlgorithm.values().length];
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 4;
            } catch (NoSuchFieldError e13) {
            }
            $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm = new int[WebSettings.LayoutAlgorithm.values().length];
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 4;
            } catch (NoSuchFieldError e17) {
            }
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity = new int[WebSettings.ZoomDensity.values().length];
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e20) {
            }
            $SwitchMap$android$webkit$WebSettings$ZoomDensity = new int[WebSettings.ZoomDensity.values().length];
            try {
                $SwitchMap$android$webkit$WebSettings$ZoomDensity[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$ZoomDensity[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$ZoomDensity[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e23) {
            }
        }
    }

    /* loaded from: classes12.dex */
    private static class ResultReceiverWrapper implements JsResult.ResultReceiver {
        private android.webkit.JsResult mJsResult;

        private ResultReceiverWrapper(android.webkit.JsResult jsResult) {
            try {
                this.mJsResult = jsResult;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* synthetic */ ResultReceiverWrapper(android.webkit.JsResult jsResult, AnonymousClass1 anonymousClass1) {
            this(jsResult);
        }

        @Override // com.baidu.webkit.sdk.JsResult.ResultReceiver
        public void onJsResultComplete(JsResult jsResult) {
            try {
                if (jsResult instanceof JsPromptResult) {
                    JsPromptResult jsPromptResult = (JsPromptResult) jsResult;
                    if (this.mJsResult instanceof android.webkit.JsPromptResult) {
                        ((android.webkit.JsPromptResult) this.mJsResult).confirm(jsPromptResult.getStringResult());
                    }
                } else {
                    this.mJsResult.confirm();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mJsResult.confirm();
            }
        }
    }

    static {
        try {
            Field declaredField = WebResourceResponse.class.getDeclaredField("mImmutable");
            ImmutableField = declaredField;
            declaredField.setAccessible(true);
        } catch (Exception e) {
            Log.e("Glue", "WebResourceResponse.getDeclaredField.mImmutable Exception.");
        }
    }

    Glue() {
    }

    @TargetApi(23)
    public static WebMessage cast(com.baidu.webkit.sdk.WebMessage webMessage) {
        if (webMessage == null) {
            return null;
        }
        return new WebMessage(webMessage.getData(), WebMessagePortImpl.from(webMessage.getPorts()));
    }

    @TargetApi(21)
    public static WebResourceResponse cast(com.baidu.webkit.sdk.WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        try {
            return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
        } catch (Throwable th) {
            return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        }
    }

    @SuppressLint({"NewApi"})
    public static WebSettings.LayoutAlgorithm cast(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        switch (layoutAlgorithm) {
            case NORMAL:
                return WebSettings.LayoutAlgorithm.NORMAL;
            case SINGLE_COLUMN:
                return WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
            case NARROW_COLUMNS:
                return WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
            case TEXT_AUTOSIZING:
                return WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
            default:
                return null;
        }
    }

    public static WebSettings.PluginState cast(WebSettings.PluginState pluginState) {
        switch (pluginState) {
            case ON:
                return WebSettings.PluginState.ON;
            case ON_DEMAND:
                return WebSettings.PluginState.ON_DEMAND;
            case OFF:
                return WebSettings.PluginState.OFF;
            default:
                return null;
        }
    }

    public static WebSettings.RenderPriority cast(WebSettings.RenderPriority renderPriority) {
        switch (renderPriority) {
            case NORMAL:
                return WebSettings.RenderPriority.NORMAL;
            case HIGH:
                return WebSettings.RenderPriority.NORMAL;
            case LOW:
                return WebSettings.RenderPriority.NORMAL;
            default:
                return null;
        }
    }

    public static WebSettings.ZoomDensity cast(WebSettings.ZoomDensity zoomDensity) {
        switch (zoomDensity) {
            case FAR:
                return WebSettings.ZoomDensity.FAR;
            case MEDIUM:
                return WebSettings.ZoomDensity.MEDIUM;
            case CLOSE:
                return WebSettings.ZoomDensity.CLOSE;
            default:
                return null;
        }
    }

    public static JsPromptResult cast(android.webkit.JsPromptResult jsPromptResult) {
        if (jsPromptResult == null) {
            return null;
        }
        return new JsPromptResult(new ResultReceiverWrapper(jsPromptResult, null));
    }

    public static JsResult cast(android.webkit.JsResult jsResult) {
        if (jsResult == null) {
            return null;
        }
        return new JsResult(new ResultReceiverWrapper(jsResult, null));
    }

    @TargetApi(23)
    public static com.baidu.webkit.sdk.WebMessage cast(WebMessage webMessage) {
        if (webMessage == null) {
            return null;
        }
        return new com.baidu.webkit.sdk.WebMessage(webMessage.getData(), WebMessagePortImpl.from(webMessage.getPorts()));
    }

    @TargetApi(21)
    public static com.baidu.webkit.sdk.WebResourceResponse cast(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        try {
            return new com.baidu.webkit.sdk.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
        } catch (Throwable th) {
            return new com.baidu.webkit.sdk.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        }
    }

    @SuppressLint({"NewApi"})
    public static WebSettings.LayoutAlgorithm cast(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        switch (AnonymousClass1.$SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()]) {
            case 1:
                return WebSettings.LayoutAlgorithm.NORMAL;
            case 2:
                return WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
            case 3:
                return WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
            case 4:
                return WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
            default:
                return null;
        }
    }

    public static WebSettings.PluginState cast(WebSettings.PluginState pluginState) {
        switch (AnonymousClass1.$SwitchMap$android$webkit$WebSettings$PluginState[pluginState.ordinal()]) {
            case 1:
                return WebSettings.PluginState.ON;
            case 2:
                return WebSettings.PluginState.ON_DEMAND;
            case 3:
                return WebSettings.PluginState.OFF;
            default:
                return null;
        }
    }

    public static WebSettings.ZoomDensity cast(WebSettings.ZoomDensity zoomDensity) {
        switch (AnonymousClass1.$SwitchMap$android$webkit$WebSettings$ZoomDensity[zoomDensity.ordinal()]) {
            case 1:
                return WebSettings.ZoomDensity.FAR;
            case 2:
                return WebSettings.ZoomDensity.MEDIUM;
            case 3:
                return WebSettings.ZoomDensity.CLOSE;
            default:
                return null;
        }
    }

    public static WebView.HitTestResult cast(WebView.HitTestResult hitTestResult) {
        if (hitTestResult == null) {
            return null;
        }
        WebView.HitTestResult hitTestResult2 = new WebView.HitTestResult();
        hitTestResult2.setType(hitTestResult.getType());
        hitTestResult2.setExtra(hitTestResult.getExtra());
        return hitTestResult2;
    }
}

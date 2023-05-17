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
/* loaded from: classes8.dex */
public final class Glue {
    public static Field ImmutableField;

    /* renamed from: com.baidu.webkit.sdk.system.Glue$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm;
        public static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$PluginState;
        public static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$ZoomDensity;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity;

        static {
            int[] iArr = new int[WebSettings.RenderPriority.values().length];
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority = iArr;
            try {
                iArr[WebSettings.RenderPriority.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[WebSettings.RenderPriority.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[WebSettings.RenderPriority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[WebSettings.PluginState.values().length];
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState = iArr2;
            try {
                iArr2[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[WebSettings.PluginState.values().length];
            $SwitchMap$android$webkit$WebSettings$PluginState = iArr3;
            try {
                iArr3[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$PluginState[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$PluginState[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[WebSettings.LayoutAlgorithm.values().length];
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm = iArr4;
            try {
                iArr4[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr5 = new int[WebSettings.LayoutAlgorithm.values().length];
            $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm = iArr5;
            try {
                iArr5[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            int[] iArr6 = new int[WebSettings.ZoomDensity.values().length];
            $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity = iArr6;
            try {
                iArr6[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr7 = new int[WebSettings.ZoomDensity.values().length];
            $SwitchMap$android$webkit$WebSettings$ZoomDensity = iArr7;
            try {
                iArr7[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$ZoomDensity[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$ZoomDensity[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class ResultReceiverWrapper implements JsResult.ResultReceiver {
        public android.webkit.JsResult mJsResult;

        public ResultReceiverWrapper(android.webkit.JsResult jsResult) {
            this.mJsResult = jsResult;
        }

        public /* synthetic */ ResultReceiverWrapper(android.webkit.JsResult jsResult, AnonymousClass1 anonymousClass1) {
            this(jsResult);
        }

        @Override // com.baidu.webkit.sdk.JsResult.ResultReceiver
        public void onJsResultComplete(JsResult jsResult) {
            if (!(jsResult instanceof JsPromptResult)) {
                if (jsResult.getResult()) {
                    this.mJsResult.confirm();
                    return;
                } else {
                    this.mJsResult.cancel();
                    return;
                }
            }
            JsPromptResult jsPromptResult = (JsPromptResult) jsResult;
            android.webkit.JsResult jsResult2 = this.mJsResult;
            if (jsResult2 instanceof android.webkit.JsPromptResult) {
                android.webkit.JsPromptResult jsPromptResult2 = (android.webkit.JsPromptResult) jsResult2;
                if (jsResult.getResult()) {
                    jsPromptResult2.confirm(jsPromptResult.getStringResult());
                } else {
                    jsPromptResult2.cancel();
                }
            }
        }
    }

    static {
        try {
            Field declaredField = WebResourceResponse.class.getDeclaredField("mImmutable");
            ImmutableField = declaredField;
            declaredField.setAccessible(true);
        } catch (Exception unused) {
            Log.e("Glue", "WebResourceResponse.getDeclaredField.mImmutable Exception.");
        }
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
        } catch (Throwable unused) {
            return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        }
    }

    @SuppressLint({"NewApi"})
    public static WebSettings.LayoutAlgorithm cast(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$webkit$sdk$WebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
                }
                return WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
            }
            return WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        }
        return WebSettings.LayoutAlgorithm.NORMAL;
    }

    public static WebSettings.PluginState cast(WebSettings.PluginState pluginState) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$webkit$sdk$WebSettings$PluginState[pluginState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return WebSettings.PluginState.OFF;
            }
            return WebSettings.PluginState.ON_DEMAND;
        }
        return WebSettings.PluginState.ON;
    }

    public static WebSettings.RenderPriority cast(WebSettings.RenderPriority renderPriority) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$webkit$sdk$WebSettings$RenderPriority[renderPriority.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return WebSettings.RenderPriority.NORMAL;
        }
        return null;
    }

    public static WebSettings.ZoomDensity cast(WebSettings.ZoomDensity zoomDensity) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$webkit$sdk$WebSettings$ZoomDensity[zoomDensity.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return WebSettings.ZoomDensity.CLOSE;
            }
            return WebSettings.ZoomDensity.MEDIUM;
        }
        return WebSettings.ZoomDensity.FAR;
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
        } catch (Throwable unused) {
            return new com.baidu.webkit.sdk.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        }
    }

    @SuppressLint({"NewApi"})
    public static WebSettings.LayoutAlgorithm cast(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        int i = AnonymousClass1.$SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
                }
                return WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
            }
            return WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        }
        return WebSettings.LayoutAlgorithm.NORMAL;
    }

    public static WebSettings.PluginState cast(WebSettings.PluginState pluginState) {
        int i = AnonymousClass1.$SwitchMap$android$webkit$WebSettings$PluginState[pluginState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return WebSettings.PluginState.OFF;
            }
            return WebSettings.PluginState.ON_DEMAND;
        }
        return WebSettings.PluginState.ON;
    }

    public static WebSettings.ZoomDensity cast(WebSettings.ZoomDensity zoomDensity) {
        int i = AnonymousClass1.$SwitchMap$android$webkit$WebSettings$ZoomDensity[zoomDensity.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return WebSettings.ZoomDensity.CLOSE;
            }
            return WebSettings.ZoomDensity.MEDIUM;
        }
        return WebSettings.ZoomDensity.FAR;
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

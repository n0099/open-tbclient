package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class qb4 extends vb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public String f;
    public boolean g;
    public ArrayList<yb4> h;
    public List<String> i;
    public List<String> j;

    /* loaded from: classes7.dex */
    public class a implements zb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;
        public final /* synthetic */ qb4 b;

        public a(qb4 qb4Var, c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb4Var, c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb4Var;
            this.a = c42Var;
        }

        @Override // com.baidu.tieba.zb4
        public void a(ac4 ac4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, ac4Var, str) == null) {
                this.b.B(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb4(fj2 fj2Var) {
        super(fj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new ArrayList<>();
        this.i = new ArrayList(3);
        this.j = new ArrayList(3);
    }

    public final boolean F(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = wb4.a().b().l();
            if (vb4.d) {
                Log.d("GameRecorderApi", "RecorderState:" + l);
            }
            if (recorderStateArr == null) {
                return true;
            }
            for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
                if (l == recorderState) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void B(c42 c42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, c42Var, str) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            he4.call(c42Var, false, new rb4(str));
        }
    }

    @NonNull
    public final String C(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                zr4.k(fo2.N(remove));
                if (vb4.d) {
                    Log.d("GameRecorderApi", "deleteFile: " + remove);
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.e + "," + this.f);
            }
            this.h.clear();
            this.g = false;
            wb4.a().b().t(this.e, this.f);
        }
    }

    public final boolean E(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dArr)) == null) {
            if (dArr == null || dArr.length < 2) {
                return false;
            }
            long j = (long) (dArr[0] * 1000.0d);
            long j2 = (long) (dArr[1] * 1000.0d);
            if (j < 0 || j2 < 0 || j + j2 <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final c42 G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            c42 F = c42.F(jsObject);
            if (F == null) {
                return new c42();
            }
            return F;
        }
        return (c42) invokeL.objValue;
    }

    public final void H(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            c42 G = G(jsObject);
            String B = G.B("path");
            if (vb4.d) {
                Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.g);
            }
            if (this.g) {
                return;
            }
            if (F(GameRecorderController.RecorderState.STOP)) {
                B(G, "clipVideo can only called after onStop");
            } else if (this.h.isEmpty()) {
                B(G, "range is illegal");
            } else {
                new bc4(this.h, fo2.B(B), fo2.N(C("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new a(this, G));
                this.h.clear();
                this.g = true;
                xi3 xi3Var = new xi3();
                xi3Var.b = "clipVideo";
                oi3.h(xi3Var);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_PAUSE);
            }
            if (F(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            wb4.a().b().o();
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_RESUME);
            }
            if (!F(GameRecorderController.RecorderState.PAUSE) && !wb4.a().c()) {
                wb4.a().b().q();
            }
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", "stop");
            }
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            wb4.a().b().u();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            c42 G = G(jsObject);
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = G.o("timeRange");
            H(jsObject);
            if (!E(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            yb4 b = yb4.b(wb4.a().b().k(), o[0], o[1]);
            if (vb4.d) {
                Log.d("GameRecorderApi", "recordClip:" + b.toString());
            }
            this.h.add(b);
            xi3 xi3Var = new xi3();
            xi3Var.b = "recordClip";
            oi3.h(xi3Var);
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (vb4.d) {
                Log.d("GameRecorderApi", "start");
            }
            if (!F(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !wb4.a().c()) {
                c42 G = G(jsObject);
                int r = G.r("duration", 10);
                this.e = r;
                if (r <= 0) {
                    this.e = 10;
                }
                if (this.e > 120) {
                    this.e = 120;
                }
                if (this.i.size() == 0) {
                    zr4.k(fo2.N("bdfile://tmp/SwanVideoRecorder/"));
                }
                String C = C("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
                z(C);
                String N = fo2.N(C);
                this.f = N;
                if (N == null) {
                    if (vb4.d) {
                        Log.e("GameRecorderApi", "recordPath == null.");
                        return;
                    }
                    return;
                }
                if (G.m("microphoneEnabled", false)) {
                    y(2);
                }
                D();
                hc4.l();
            }
        }
    }

    @JavascriptInterface
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            start(null);
        }
    }
}

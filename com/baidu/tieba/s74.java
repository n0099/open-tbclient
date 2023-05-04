package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class s74 extends x74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public String f;
    public boolean g;
    public ArrayList<a84> h;
    public List<String> i;
    public List<String> j;

    /* loaded from: classes6.dex */
    public class a implements b84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e02 a;
        public final /* synthetic */ s74 b;

        public a(s74 s74Var, e02 e02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var, e02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s74Var;
            this.a = e02Var;
        }

        @Override // com.baidu.tieba.b84
        public void a(c84 c84Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, c84Var, str) == null) {
                this.b.B(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s74(hf2 hf2Var) {
        super(hf2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hf2Var};
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
            GameRecorderController.RecorderState l = y74.a().b().l();
            if (x74.d) {
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

    public final void B(e02 e02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, e02Var, str) == null) {
            if (x74.d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            ja4.call(e02Var, false, new t74(str));
        }
    }

    @NonNull
    public final String C(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                bo4.k(hk2.N(remove));
                if (x74.d) {
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
            if (x74.d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.e + "," + this.f);
            }
            this.h.clear();
            this.g = false;
            y74.a().b().t(this.e, this.f);
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
    public final e02 G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            e02 F = e02.F(jsObject);
            if (F == null) {
                return new e02();
            }
            return F;
        }
        return (e02) invokeL.objValue;
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
            e02 G = G(jsObject);
            String B = G.B("path");
            if (x74.d) {
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
                new d84(this.h, hk2.B(B), hk2.N(C("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new a(this, G));
                this.h.clear();
                this.g = true;
                ze3 ze3Var = new ze3();
                ze3Var.b = "clipVideo";
                qe3.h(ze3Var);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (x74.d) {
                Log.d("GameRecorderApi", "pause");
            }
            if (F(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            y74.a().b().o();
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (x74.d) {
                Log.d("GameRecorderApi", "resume");
            }
            if (!F(GameRecorderController.RecorderState.PAUSE) && !y74.a().c()) {
                y74.a().b().q();
            }
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (x74.d) {
                Log.d("GameRecorderApi", "stop");
            }
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            y74.a().b().u();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            e02 G = G(jsObject);
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = G.o("timeRange");
            H(jsObject);
            if (!E(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            a84 b = a84.b(y74.a().b().k(), o[0], o[1]);
            if (x74.d) {
                Log.d("GameRecorderApi", "recordClip:" + b.toString());
            }
            this.h.add(b);
            ze3 ze3Var = new ze3();
            ze3Var.b = "recordClip";
            qe3.h(ze3Var);
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (x74.d) {
                Log.d("GameRecorderApi", "start");
            }
            if (!F(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !y74.a().c()) {
                e02 G = G(jsObject);
                int r = G.r("duration", 10);
                this.e = r;
                if (r <= 0) {
                    this.e = 10;
                }
                if (this.e > 120) {
                    this.e = 120;
                }
                if (this.i.size() == 0) {
                    bo4.k(hk2.N("bdfile://tmp/SwanVideoRecorder/"));
                }
                String C = C("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
                z(C);
                String N = hk2.N(C);
                this.f = N;
                if (N == null) {
                    if (x74.d) {
                        Log.e("GameRecorderApi", "recordPath == null.");
                        return;
                    }
                    return;
                }
                if (G.m("microphoneEnabled", false)) {
                    y(2);
                }
                D();
                j84.l();
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

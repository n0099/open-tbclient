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
/* loaded from: classes8.dex */
public class ya4 extends db4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public String f;
    public boolean g;
    public ArrayList<gb4> h;
    public List<String> i;
    public List<String> j;

    /* loaded from: classes8.dex */
    public class a implements hb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k32 a;
        public final /* synthetic */ ya4 b;

        public a(ya4 ya4Var, k32 k32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya4Var, k32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya4Var;
            this.a = k32Var;
        }

        @Override // com.baidu.tieba.hb4
        public void a(ib4 ib4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, ib4Var, str) == null) {
                this.b.A(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya4(ni2 ni2Var) {
        super(ni2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var};
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

    public final boolean E(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = eb4.a().b().l();
            if (db4.d) {
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

    public final void A(k32 k32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, k32Var, str) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            pd4.call(k32Var, false, new za4(str));
        }
    }

    @NonNull
    public final String B(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                hr4.k(nn2.N(remove));
                if (db4.d) {
                    Log.d("GameRecorderApi", "deleteFile: " + remove);
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.e + "," + this.f);
            }
            this.h.clear();
            this.g = false;
            eb4.a().b().t(this.e, this.f);
        }
    }

    public final boolean D(double[] dArr) {
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
    public final k32 F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            k32 F = k32.F(jsObject);
            if (F == null) {
                return new k32();
            }
            return F;
        }
        return (k32) invokeL.objValue;
    }

    public final void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            k32 F = F(jsObject);
            String B = F.B("path");
            if (db4.d) {
                Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.g);
            }
            if (this.g) {
                return;
            }
            if (E(GameRecorderController.RecorderState.STOP)) {
                A(F, "clipVideo can only called after onStop");
            } else if (this.h.isEmpty()) {
                A(F, "range is illegal");
            } else {
                new jb4(this.h, nn2.B(B), nn2.N(B("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new a(this, F));
                this.h.clear();
                this.g = true;
                fi3 fi3Var = new fi3();
                fi3Var.b = "clipVideo";
                wh3.h(fi3Var);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_PAUSE);
            }
            if (E(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            eb4.a().b().o();
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_RESUME);
            }
            if (!E(GameRecorderController.RecorderState.PAUSE) && !eb4.a().c()) {
                eb4.a().b().q();
            }
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", "stop");
            }
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            eb4.a().b().u();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            k32 F = F(jsObject);
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = F.o("timeRange");
            G(jsObject);
            if (!D(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            gb4 b = gb4.b(eb4.a().b().k(), o[0], o[1]);
            if (db4.d) {
                Log.d("GameRecorderApi", "recordClip:" + b.toString());
            }
            this.h.add(b);
            fi3 fi3Var = new fi3();
            fi3Var.b = "recordClip";
            wh3.h(fi3Var);
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (db4.d) {
                Log.d("GameRecorderApi", "start");
            }
            if (!E(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !eb4.a().c()) {
                k32 F = F(jsObject);
                int r = F.r("duration", 10);
                this.e = r;
                if (r <= 0) {
                    this.e = 10;
                }
                if (this.e > 120) {
                    this.e = 120;
                }
                if (this.i.size() == 0) {
                    hr4.k(nn2.N("bdfile://tmp/SwanVideoRecorder/"));
                }
                String B = B("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
                y(B);
                String N = nn2.N(B);
                this.f = N;
                if (N == null) {
                    if (db4.d) {
                        Log.e("GameRecorderApi", "recordPath == null.");
                        return;
                    }
                    return;
                }
                if (F.m("microphoneEnabled", false)) {
                    x(2);
                }
                C();
                pb4.l();
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

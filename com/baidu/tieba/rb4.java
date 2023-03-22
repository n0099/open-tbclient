package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
public class rb4 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public du1 a;
    public volatile String b;
    public e c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rb4 b;

        public a(rb4 rb4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb4Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.a == null) {
                    this.b.F();
                }
                if (!this.b.a.c()) {
                    this.b.a.H();
                }
                this.b.a.loadUrl(this.a);
                this.b.D("open", new sb4(this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb4 a;

        public b(rb4 rb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rb4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.c()) {
                this.a.a.removeFromParent();
                this.a.a.destroy();
                this.a.a = null;
                rb4 rb4Var = this.a;
                rb4Var.D("close", new sb4(rb4Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rb4 b;

        public c(rb4 rb4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb4Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null) {
                if (TextUtils.equals("1", this.a)) {
                    this.b.a.g(true);
                } else {
                    this.b.a.g(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb4 a;

        public d(rb4 rb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rb4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.close();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;
        public long d;

        public e(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public /* synthetic */ e(String str, String str2, long j, a aVar) {
            this(str, str2, j);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "H5GameInfo{mGameId='" + this.a + "', mGameName='" + this.b + "', mStartLoadingTimestamp=" + this.c + ", mFinishLoadingTimestamp=" + this.d + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948115845, "Lcom/baidu/tieba/rb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948115845, "Lcom/baidu/tieba/rb4;");
                return;
            }
        }
        d = do1.a;
    }

    public static rb4 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            bf2 n = t34.m().n();
            if (n == null) {
                return null;
            }
            EventTarget n2 = n.n();
            if (!(n2 instanceof a24)) {
                return null;
            }
            return ((a24) n2).getWebViewManager();
        }
        return (rb4) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(ar2.c());
            this.a = gameWebViewManager;
            gameWebViewManager.i(new d(this));
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            nl3.e0(new b(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb4(df2 df2Var) {
        super(df2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {df2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            a02 F = a02.F(jsObject);
            if (F == null) {
                D("error", C(null, "1001"));
            } else {
                nl3.e0(new c(this, F.C("setCloseViewVisibility", null)));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final tb4 C(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            switch (str2.hashCode()) {
                case 1507424:
                    if (str2.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507425:
                    if (str2.equals("1002")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return new tb4(str, str2, "open:host not in white list");
            }
            return new tb4(str, str2, "open:url is invalid");
        }
        return (tb4) invokeLL.objValue;
    }

    public final void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (d) {
                Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.c == null) {
                if (d) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                    return;
                }
                return;
            }
            t73 b0 = t73.b0();
            if (b0 == null) {
                if (d) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                    return;
                }
                return;
            }
            this.c.d = System.currentTimeMillis();
            if (d) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.c);
            }
            ub4.a(b0, this.c);
            this.c = null;
        }
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        a02 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jsObject) != null) || (F = a02.F(jsObject)) == null) {
            return;
        }
        String B = F.B("gameId");
        String B2 = F.B("gameName");
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(B2)) {
            this.c = new e(B, B2, System.currentTimeMillis(), null);
            if (d) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.c);
            }
            fa4.call(F, true, null);
            return;
        }
        fa4.call(F, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            a02 F = a02.F(jsObject);
            if (F == null) {
                D("error", C(null, "1001"));
                return;
            }
            String C = F.C("url", null);
            if (!G(C)) {
                D("error", C(C, "1001"));
            } else if (!k83.h(C)) {
                D("error", C(C, "1002"));
            } else {
                if (d) {
                    Log.i("GameWebViewApi", "open:" + C);
                }
                this.b = C;
                nl3.e0(new a(this, C));
            }
        }
    }
}

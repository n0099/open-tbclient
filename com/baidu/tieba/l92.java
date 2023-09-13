package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.i92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l92 implements i92.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final i92.b a;
    public o9c b;
    public InspectorNativeClient c;
    public pi2 d;
    public LinkedBlockingQueue<String> e;
    public String f;

    /* loaded from: classes6.dex */
    public class b extends o9c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l92 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.a.a.e.poll();
                    while (str != null) {
                        this.a.a.c.dispatchProtocolMessage(str);
                        this.a.c(str);
                        this.a.d(str);
                        str = (String) this.a.a.e.poll();
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.l92$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0375b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0375b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.a.onConnected();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l92 l92Var, URI uri) {
            super(uri);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l92Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((URI) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l92Var;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && this.a.a != null) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        gb3 K = gb3.K();
                        SwanAppActivity w = K.w();
                        if (K.E() && w != null) {
                            w.runOnUiThread(new RunnableC0375b(this));
                        }
                    }
                } catch (JSONException e) {
                    if (l92.g) {
                        Log.e("V8InspectorClient", "message is not a Json object", e);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.o9c
        public void onOpen(iac iacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, iacVar) == null) {
                h82.i("V8InspectorClient", "V8 inspector opened");
                dd2 W = bi2.U().W();
                if (W instanceof hd2) {
                    this.a.d = (pi2) W.e();
                }
                if (this.a.d == null) {
                    h82.i("V8InspectorClient", "inner error, V8 mEngine is null");
                    close();
                    return;
                }
                l92 l92Var = this.a;
                l92Var.c = l92Var.d.q0(new a(this.a));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
            if (r2 == 1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
            com.baidu.tieba.h82.c("V8InspectorClient", "Undefined command");
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
            com.baidu.tieba.h82.i("V8InspectorClient", "v8 inspector close");
            com.baidu.tieba.c92.d();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("command");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                char c = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -934641255) {
                    if (hashCode == 94756344 && optString.equals("close")) {
                        c = 1;
                    }
                } else if (optString.equals("reload")) {
                    c = 0;
                }
                h82.i("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException e) {
                if (l92.g) {
                    Log.e("V8InspectorClient", "message is not a json object", e);
                }
            }
        }

        @Override // com.baidu.tieba.o9c
        public void onClose(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                h82.i("V8InspectorClient", "V8 inspector closed");
            }
        }

        @Override // com.baidu.tieba.o9c
        public void onError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                h82.d("V8InspectorClient", "V8 inspector error", exc);
            }
        }

        @Override // com.baidu.tieba.o9c
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.e.offer(str);
                this.a.d.postOnJSThread(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l92 a;

        public a(l92 l92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l92Var;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    if (this.a.b != null) {
                        this.a.b.send(str);
                    }
                } catch (Exception unused) {
                    if (l92.g) {
                        Log.d("V8InspectorClient", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (l92.g) {
                    Log.d("V8InspectorClient", "getInspectorMessage");
                }
                try {
                    return (String) this.a.e.take();
                } catch (InterruptedException e) {
                    if (l92.g) {
                        Log.e("V8InspectorClient", "awaitMessage on Debugger", e);
                        return "";
                    }
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897636, "Lcom/baidu/tieba/l92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897636, "Lcom/baidu/tieba/l92;");
                return;
            }
        }
        g = rr1.a;
    }

    @Override // com.baidu.tieba.i92.c
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                b bVar = new b(this, new URI(this.f));
                this.b = bVar;
                bVar.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.i92.c
    public void stop() {
        o9c o9cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (o9cVar = this.b) != null) {
            o9cVar.close();
            this.b = null;
        }
    }

    public l92(String str, i92.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new LinkedBlockingQueue<>();
        this.f = str;
        this.a = bVar;
    }
}

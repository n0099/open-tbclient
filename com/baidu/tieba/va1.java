package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tieba.gd1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class va1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* loaded from: classes8.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    /* loaded from: classes8.dex */
    public class a extends xa1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(va1 va1Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va1Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.xa1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                dc1 dc1Var = new dc1("1");
                dc1Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                gc1.e(dc1Var);
                pc1.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xa1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                pc1.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Context b;
        public boolean c;

        public b() {
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
            this.a = 1;
            this.c = false;
        }

        public va1 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new va1(this, null);
            }
            return (va1) invokeV.objValue;
        }

        public b e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.b = context;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(int i, String str);

        public c() {
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
    }

    public va1(b bVar) {
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
        this.a = 0L;
        if (bVar != null) {
            if (bVar.b != null) {
                eb1.b(bVar.a);
                kb1.c(jb1.d(bVar.b.getApplicationContext()));
                tc1.b(bVar.b.getApplicationContext());
                pc1.d = bVar.c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }

    public /* synthetic */ va1(b bVar, ua1 ua1Var) {
        this(bVar);
    }

    public void a(Bundle bundle, yc1 yc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, yc1Var) == null) {
            zc1.a(bundle, yc1Var);
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            cc1.a("1.01", System.currentTimeMillis());
            fb1.j().f(sc1.b(tc1.a(), bundle), true, new a(this, dVar));
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, dd1 dd1Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, dd1Var, cVar}) == null) {
            if (context != null) {
                if (bundle != null) {
                    if (iChannelPay != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.a < 1000) {
                            pc1.g("cashier pay time interval less than 1s");
                            return;
                        }
                        this.a = currentTimeMillis;
                        pc1.g("cashier pay");
                        String str = "1";
                        cc1.a("1", currentTimeMillis);
                        String string = bundle.getString("chosenChannel");
                        String string2 = bundle.getString("panelType");
                        if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                            str = "0";
                        } else if (!TextUtils.equals(string2, "HALF") && TextUtils.equals(string2, "FULL")) {
                            str = "2";
                        }
                        dc1 dc1Var = new dc1("0");
                        dc1Var.a("panelType", str);
                        gc1.e(dc1Var);
                        PolyActivity.n(context, iChannelPay, iChannelAuth, dd1Var, cVar, bundle);
                        return;
                    }
                    throw new IllegalArgumentException("channelPay can not be null");
                }
                throw new IllegalArgumentException("arguments can not be null");
            }
            throw new IllegalArgumentException("context can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fc1.g().h();
        }
    }

    public void e(int i, JSONObject jSONObject, ac1 ac1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, jSONObject, ac1Var) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (ac1Var != null) {
                        ac1Var.a(1, "unknown command");
                        return;
                    }
                    return;
                }
                ib1.f(ac1Var);
                return;
            }
            eb1.c(jSONObject, ac1Var);
        }
    }

    public void f(Activity activity, id1 id1Var, gd1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, id1Var, dVar) == null) {
            if (activity == null) {
                pc1.d("couponEntity is null!");
            } else if (id1Var != null && id1Var.b != null) {
                gd1 gd1Var = new gd1(activity);
                gd1Var.d(dVar);
                gd1Var.e(id1Var.b);
                gd1Var.show();
            } else {
                pc1.d("couponEntity || couponItemList is null!");
            }
        }
    }
}

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
import com.baidu.tieba.bd1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* loaded from: classes5.dex */
    public class a extends sa1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(qa1 qa1Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var, dVar};
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

        @Override // com.baidu.tieba.sa1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                yb1 yb1Var = new yb1("1");
                yb1Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                bc1.e(yb1Var);
                kc1.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                kc1.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        public qa1 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new qa1(this, null) : (qa1) invokeV.objValue;
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

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public abstract void a(int i, String str);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    public /* synthetic */ qa1(b bVar, pa1 pa1Var) {
        this(bVar);
    }

    public void a(Bundle bundle, tc1 tc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, tc1Var) == null) {
            uc1.a(bundle, tc1Var);
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, yc1 yc1Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, yc1Var, cVar}) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (iChannelPay != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.a < 1000) {
                    kc1.g("cashier pay time interval less than 1s");
                    return;
                }
                this.a = currentTimeMillis;
                kc1.g("cashier pay");
                String str = "1";
                xb1.a("1", currentTimeMillis);
                String string = bundle.getString("chosenChannel");
                String string2 = bundle.getString("panelType");
                if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                    str = "0";
                } else if (!TextUtils.equals(string2, "HALF") && TextUtils.equals(string2, "FULL")) {
                    str = "2";
                }
                yb1 yb1Var = new yb1("0");
                yb1Var.a("panelType", str);
                bc1.e(yb1Var);
                PolyActivity.n(context, iChannelPay, iChannelAuth, yc1Var, cVar, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ac1.g().h();
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            xb1.a("1.01", System.currentTimeMillis());
            ab1.j().f(nc1.b(oc1.a(), bundle), true, new a(this, dVar));
        }
    }

    public void e(int i, JSONObject jSONObject, vb1 vb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, jSONObject, vb1Var) == null) {
            if (i == 1) {
                za1.c(jSONObject, vb1Var);
            } else if (i == 2) {
                db1.f(vb1Var);
            } else if (vb1Var != null) {
                vb1Var.a(1, "unknown command");
            }
        }
    }

    public void f(Activity activity, dd1 dd1Var, bd1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, dd1Var, dVar) == null) {
            if (activity == null) {
                kc1.d("couponEntity is null!");
            } else if (dd1Var != null && dd1Var.b != null) {
                bd1 bd1Var = new bd1(activity);
                bd1Var.d(dVar);
                bd1Var.update(dd1Var.b);
                bd1Var.show();
            } else {
                kc1.d("couponEntity || couponItemList is null!");
            }
        }
    }

    public qa1(b bVar) {
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
                za1.b(bVar.a);
                fb1.c(eb1.d(bVar.b.getApplicationContext()));
                oc1.b(bVar.b.getApplicationContext());
                kc1.d = bVar.c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}

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
import com.baidu.tieba.xi1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* loaded from: classes7.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    /* loaded from: classes7.dex */
    public class a extends og1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(mg1 mg1Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg1Var, dVar};
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

        @Override // com.baidu.tieba.og1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                uh1 uh1Var = new uh1("1");
                uh1Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                xh1.e(uh1Var);
                gi1.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                gi1.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

        public mg1 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new mg1(this, null);
            }
            return (mg1) invokeV.objValue;
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

    /* loaded from: classes7.dex */
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

    public mg1(b bVar) {
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
                vg1.b(bVar.a);
                bh1.c(ah1.d(bVar.b.getApplicationContext()));
                ki1.b(bVar.b.getApplicationContext());
                gi1.d = bVar.c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }

    public /* synthetic */ mg1(b bVar, lg1 lg1Var) {
        this(bVar);
    }

    public void a(Bundle bundle, pi1 pi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, pi1Var) == null) {
            qi1.a(bundle, pi1Var);
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            th1.a("1.01", System.currentTimeMillis());
            wg1.j().f(ji1.b(ki1.a(), bundle), true, new a(this, dVar));
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, ui1 ui1Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, ui1Var, cVar}) == null) {
            if (context != null) {
                if (bundle != null) {
                    if (iChannelPay != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.a < 1000) {
                            gi1.g("cashier pay time interval less than 1s");
                            return;
                        }
                        this.a = currentTimeMillis;
                        gi1.g("cashier pay");
                        String str = "1";
                        th1.a("1", currentTimeMillis);
                        String string = bundle.getString("chosenChannel");
                        String string2 = bundle.getString("panelType");
                        if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                            str = "0";
                        } else if (!TextUtils.equals(string2, "HALF") && TextUtils.equals(string2, "FULL")) {
                            str = "2";
                        }
                        uh1 uh1Var = new uh1("0");
                        uh1Var.a("panelType", str);
                        xh1.e(uh1Var);
                        PolyActivity.n(context, iChannelPay, iChannelAuth, ui1Var, cVar, bundle);
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
            wh1.g().h();
        }
    }

    public void e(int i, JSONObject jSONObject, rh1 rh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, jSONObject, rh1Var) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (rh1Var != null) {
                        rh1Var.a(1, "unknown command");
                        return;
                    }
                    return;
                }
                zg1.f(rh1Var);
                return;
            }
            vg1.c(jSONObject, rh1Var);
        }
    }

    public void f(Activity activity, zi1 zi1Var, xi1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, zi1Var, dVar) == null) {
            if (activity == null) {
                gi1.d("couponEntity is null!");
            } else if (zi1Var != null && zi1Var.b != null) {
                xi1 xi1Var = new xi1(activity);
                xi1Var.d(dVar);
                xi1Var.update(zi1Var.b);
                xi1Var.show();
            } else {
                gi1.d("couponEntity || couponItemList is null!");
            }
        }
    }
}

package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t43;
import com.baidu.tieba.tt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class lu1 extends ju1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lu1 a;

        /* renamed from: com.baidu.tieba.lu1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0375a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p53 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.baidu.tieba.lu1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0376a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0375a a;

                public DialogInterface$OnClickListenerC0376a(RunnableC0375a runnableC0375a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0375a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0375a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0375a runnableC0375a = this.a;
                            runnableC0375a.e.a.d(runnableC0375a.c, new qx1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0375a runnableC0375a2 = this.a;
                            runnableC0375a2.e.a.d(runnableC0375a2.c, new qx1(201));
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.lu1$a$a$b */
            /* loaded from: classes7.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0375a a;

                public b(RunnableC0375a runnableC0375a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0375a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0375a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0375a runnableC0375a = this.a;
                            runnableC0375a.e.a.d(runnableC0375a.c, new qx1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0375a runnableC0375a2 = this.a;
                            runnableC0375a2.e.a.d(runnableC0375a2.c, new qx1(201));
                        }
                    }
                }
            }

            public RunnableC0375a(a aVar, p53 p53Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, p53Var, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = aVar;
                this.a = p53Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w() != null && !this.a.w().isFinishing() && !this.a.w().isDestroyed()) {
                    t43.a aVar = new t43.a(this.e.a.i());
                    aVar.V(this.b.optString("title"));
                    aVar.x(this.b.optString("content"));
                    aVar.n(new xk3());
                    aVar.m(false);
                    if (this.b.optBoolean("showCancel", true)) {
                        aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f06044f);
                        String optString = this.b.optString("cancelText");
                        if (TextUtils.isEmpty(optString)) {
                            optString = this.e.a.i().getString(R.string.obfuscated_res_0x7f0f0141);
                        }
                        aVar.C(optString, new DialogInterface$OnClickListenerC0376a(this));
                    }
                    aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f060450);
                    aVar.P(this.d, new b(this));
                    aVar.X();
                }
            }
        }

        public a(lu1 lu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lu1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.i().getString(R.string.obfuscated_res_0x7f0f0149);
                }
                jj3.e0(new RunnableC0375a(this, p53Var, jSONObject, str, optString));
                return qx1.f();
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lu1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#showModal", false);
            return m(str, true, new a(this));
        }
        return (qx1) invokeL.objValue;
    }
}

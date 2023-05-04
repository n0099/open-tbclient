package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j26 extends tj1<zh1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    /* loaded from: classes5.dex */
    public class a implements zh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j26 c;

        @Override // com.baidu.tieba.zh1
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zh1
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 120;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.zh1
        @SuppressLint({"ResourceType"})
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.drawable.pic_splash_logo : invokeV.intValue;
        }

        @Override // com.baidu.tieba.zh1
        @NonNull
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "1481698145541" : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zh1
        public String from() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zh1
        @SuppressLint({"ResourceType"})
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.drawable.obfuscated_res_0x7f080254 : invokeV.intValue;
        }

        @Override // com.baidu.tieba.zh1
        @SuppressLint({"ResourceType"})
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.drawable.obfuscated_res_0x7f080255 : invokeV.intValue;
        }

        public a(j26 j26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j26Var;
        }

        @Override // com.baidu.tieba.zh1
        public JSONObject d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.c.a == null) {
                    this.c.a = new JSONObject();
                    try {
                        boolean z = true;
                        this.c.a.put("query_response_thread", 1);
                        this.c.a.put("query_unite_pid", "1640058553813");
                        this.c.a.put("nad_splash_query_download_opt", fm0.b().a().a("nad_splash_query_download_opt", 0));
                        boolean i = f55.m().i("key_splash_shake_ad_open", true);
                        JSONObject jSONObject = this.c.a;
                        if (i) {
                            z = false;
                        }
                        jSONObject.put("is_block_shake_gesture", z);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return this.c.a;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zh1
        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return eq5.l();
            }
            return invokeV.intValue;
        }
    }

    public j26() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tj1
    /* renamed from: c */
    public zh1 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (zh1) invokeV.objValue;
    }
}

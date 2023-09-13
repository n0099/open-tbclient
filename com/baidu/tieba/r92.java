package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r92 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bq3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ r92 b;

        public a(r92 r92Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r92Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r92Var;
            this.a = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bq3
        /* renamed from: a */
        public Bundle create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.d(this.a);
            }
            return (Bundle) invokeV.objValue;
        }
    }

    public r92() {
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

    public final Bundle d(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            int i = bundle.getInt("type");
            t92 t92Var = new t92();
            String string = bundle.getString("param1");
            Bundle bundle2 = new Bundle();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return bundle2;
                        }
                        bundle2.putString("result", t92Var.getCookie(string));
                        return bundle2;
                    }
                    t92Var.storeCookie(string, bundle.getStringArrayList("param2"));
                    return bundle2;
                }
                bundle2.putBoolean("result", t92Var.shouldSendCookie(string, bundle.getString("param2")));
                return bundle2;
            }
            bundle2.putBoolean("result", t92Var.shouldAcceptCookie(string, bundle.getString("param2")));
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            return (Bundle) yp3.b(new a(this, bundle));
        }
        return (Bundle) invokeL.objValue;
    }
}

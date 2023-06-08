package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.PkView;
/* loaded from: classes7.dex */
public class o58 implements vn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public long c;
    public String d;
    public long e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983351, "Lcom/baidu/tieba/o58;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983351, "Lcom/baidu/tieba/o58;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public o58() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return k;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void a(PkModule pkModule) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pkModule) != null) || pkModule == null) {
            return;
        }
        String str = pkModule.module_name;
        this.a = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.b = pkView.pk_desc;
        this.c = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.d = pkView2.pk_desc;
        this.e = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        if (pkModule.pk_1.has_clicked.intValue() == 1) {
            i = 1;
        } else if (pkModule.pk_2.has_clicked.intValue() == 1) {
            i = 2;
        } else {
            i = 0;
        }
        this.f = i;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.g = pkModule.pk_id.longValue();
        this.h = pkModule.user_pk_id.longValue();
        int i2 = this.f;
        long j2 = this.c;
        if (i2 == 1) {
            j2--;
        }
        this.i = j2;
        if (this.f == 2) {
            j = this.e - 1;
        } else {
            j = this.e;
        }
        this.j = j;
    }
}

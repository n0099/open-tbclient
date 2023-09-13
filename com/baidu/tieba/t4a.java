package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class t4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, s4a> d;
    public s4a e;

    /* loaded from: classes8.dex */
    public class a implements v29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s4a a;

        public a(t4a t4aVar, s4a s4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t4aVar, s4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s4aVar;
        }

        @Override // com.baidu.tieba.v29
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                AdvertAppInfo a = this.a.a();
                if (i != 0 && a != null) {
                    String str = "image";
                    if (hashMap != null) {
                        String str2 = (String) hashMap.get("da_area");
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                    }
                    if (j3a.h(i)) {
                        x4a.f(a, 0, str, i);
                    } else {
                        x4a.m(a, 0, str);
                    }
                    d39.c(a);
                }
            }
        }
    }

    public t4a(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = z;
        this.b = hVar;
        this.d = new HashMap();
    }

    public s4a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            s4a s4aVar = new s4a(this.a);
            s4aVar.b();
            s4aVar.setBusinessType(99);
            s4aVar.setFromCDN(this.c);
            s4aVar.D(this.b);
            s4aVar.setAfterClickSchemeListener(new a(this, s4aVar));
            return s4aVar;
        }
        return (s4a) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo != null && (advertAppInfo.h instanceof AdCard)) {
                s4a s4aVar = this.d.get(advertAppInfo);
                if (s4aVar == null) {
                    s4aVar = a();
                    this.d.put(advertAppInfo, s4aVar);
                }
                s4aVar.e((AdCard) advertAppInfo.h);
                this.e = s4aVar;
                if (z) {
                    s4aVar.x();
                }
                return s4aVar.s();
            }
            return null;
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        s4a s4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (s4aVar = this.e) != null) {
            s4aVar.x();
        }
    }

    public void d() {
        s4a s4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (s4aVar = this.e) != null) {
            s4aVar.B();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (s4a s4aVar : this.d.values()) {
                if (s4aVar != null) {
                    s4aVar.C();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        s4a s4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) && advertAppInfo != null && (s4aVar = this.d.get(advertAppInfo)) != null) {
            s4aVar.C();
            this.d.remove(advertAppInfo);
        }
    }
}

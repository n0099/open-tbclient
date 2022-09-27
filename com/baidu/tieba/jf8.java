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
/* loaded from: classes4.dex */
public class jf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, if8> d;
    public if8 e;

    /* loaded from: classes4.dex */
    public class a implements ng7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        public a(jf8 jf8Var, if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf8Var, if8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if8Var;
        }

        @Override // com.baidu.tieba.ng7
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                AdvertAppInfo a = this.a.a();
                if (i == 0 || a == null) {
                    return;
                }
                String str = "image";
                if (hashMap != null) {
                    String str2 = (String) hashMap.get("da_area");
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
                if (ce8.h(i)) {
                    of8.f(a, 0, str, i);
                } else {
                    of8.m(a, 0, str);
                }
                vg7.c(a);
            }
        }
    }

    public jf8(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public if8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if8 if8Var = new if8(this.a);
            if8Var.b();
            if8Var.setBusinessType(99);
            if8Var.setFromCDN(this.c);
            if8Var.C(this.b);
            if8Var.setAfterClickSchemeListener(new a(this, if8Var));
            return if8Var;
        }
        return (if8) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo == null || !(advertAppInfo.h instanceof AdCard)) {
                return null;
            }
            if8 if8Var = this.d.get(advertAppInfo);
            if (if8Var == null) {
                if8Var = a();
                this.d.put(advertAppInfo, if8Var);
            }
            if8Var.d((AdCard) advertAppInfo.h);
            this.e = if8Var;
            if (z) {
                if8Var.w();
            }
            return if8Var.r();
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        if8 if8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (if8Var = this.e) == null) {
            return;
        }
        if8Var.w();
    }

    public void d() {
        if8 if8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (if8Var = this.e) == null) {
            return;
        }
        if8Var.A();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (if8 if8Var : this.d.values()) {
                if (if8Var != null) {
                    if8Var.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        if8 if8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (if8Var = this.d.get(advertAppInfo)) == null) {
            return;
        }
        if8Var.B();
        this.d.remove(advertAppInfo);
    }
}

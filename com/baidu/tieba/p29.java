package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class p29 implements s19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yx5 a;
    public Map<String, AdvertAppInfo> b;
    public n29 c;
    public int d;
    public final Set<String> e;
    public boolean f;

    public p29(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedHashSet();
        this.f = false;
        yx5 yx5Var = new yx5(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.a = yx5Var;
        yx5Var.e(false);
        this.b = new HashMap();
        this.d = iv5.a().c();
    }

    @Override // com.baidu.tieba.s19
    public View b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            this.f = z;
            return this.c.b(this.b.get(str), z);
        }
        return (View) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.s19
    public void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, advertAppInfo) == null) {
            this.b.put(str, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.s19
    public AdvertAppInfo d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.b.get(str);
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s19
    public boolean f(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (advertAppInfo = this.b.get(str)) == null || j09.l(advertAppInfo)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.s19
    public void g(@NonNull ho5 ho5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ho5Var) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", ho5Var.c);
            hashMap.put("forum_name", ho5Var.d);
            this.a.d(this.d, hashMap);
        }
    }

    @Override // com.baidu.tieba.s19
    public void k(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) {
            s29.h(advertAppInfo, 0, 2);
        }
    }

    @Override // com.baidu.tieba.s19
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c.f(this.b.get(str));
        }
    }

    @Override // com.baidu.tieba.s19
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = 0;
            if (this.b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.b.values()) {
                if (!j09.l(advertAppInfo)) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.s19
    public void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, tbPageContext, hVar, z) == null) {
            this.c = new n29(tbPageContext, z, hVar);
        }
    }

    @Override // com.baidu.tieba.s19
    public void j(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || (advertAppInfo = this.b.get(str)) == null) {
            return;
        }
        s29.o(advertAppInfo);
        q38.b(q38.a(advertAppInfo));
        boolean add = this.e.add(str);
        if (!this.f && add) {
            this.c.d();
        } else {
            this.c.c();
        }
    }

    @Override // com.baidu.tieba.s19
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.clear();
        }
    }

    @Override // com.baidu.tieba.s19
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return !this.b.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s19
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.e();
            this.a.b();
            this.e.clear();
        }
    }
}

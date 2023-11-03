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
/* loaded from: classes7.dex */
public class kea implements lda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h26 a;
    public Map<String, AdvertAppInfo> b;
    public jea c;
    public int d;
    public final Set<String> e;
    public boolean f;

    public kea(IAdBaseAsyncController.a aVar) {
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
        h26 h26Var = new h26(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.a = h26Var;
        h26Var.e(false);
        this.b = new HashMap();
        this.d = sz5.a().c();
    }

    @Override // com.baidu.tieba.lda
    public View b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            this.f = z;
            return this.c.b(this.b.get(str), z);
        }
        return (View) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.lda
    public void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, advertAppInfo) == null) {
            this.b.put(str, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.lda
    public AdvertAppInfo d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.b.get(str);
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lda
    public boolean f(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (advertAppInfo = this.b.get(str)) == null || bca.l(advertAppInfo)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lda
    public void g(@NonNull ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ms5Var) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", ms5Var.c);
            hashMap.put("forum_name", ms5Var.d);
            this.a.d(this.d, hashMap);
        }
    }

    @Override // com.baidu.tieba.lda
    public void k(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) {
            nea.h(advertAppInfo, 0, 2);
        }
    }

    @Override // com.baidu.tieba.lda
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c.f(this.b.get(str));
        }
    }

    @Override // com.baidu.tieba.lda
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = 0;
            if (this.b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.b.values()) {
                if (!bca.l(advertAppInfo)) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lda
    public void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, tbPageContext, hVar, z) == null) {
            this.c = new jea(tbPageContext, z, hVar);
        }
    }

    @Override // com.baidu.tieba.lda
    public void j(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || (advertAppInfo = this.b.get(str)) == null) {
            return;
        }
        nea.o(advertAppInfo);
        boolean add = this.e.add(str);
        if (!this.f && add) {
            this.c.d();
        } else {
            this.c.c();
        }
    }

    @Override // com.baidu.tieba.lda
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.clear();
        }
    }

    @Override // com.baidu.tieba.lda
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return !this.b.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lda
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.e();
            this.a.b();
            this.e.clear();
        }
    }
}

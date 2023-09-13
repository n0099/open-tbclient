package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.compact.DelegateNativeAdView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lna implements oc7<DelegateNativeAdView, AdvertAppInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ICardInfo a;
    public final String b;
    public final int c;
    public TbPageContext<?> d;
    public String e;

    public lna(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kna.a(i);
        this.b = kna.c(i);
        this.c = i2;
    }

    public lna(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = kna.b(i, i2);
        this.b = kna.d(i, i2);
        this.c = i3;
    }

    @Override // com.baidu.tieba.oc7
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            DelegateNativeAdView delegateNativeAdView = new DelegateNativeAdView(viewGroup.getContext(), this.d, this.a, this.c, this.e);
            de7.i(delegateNativeAdView, Integer.valueOf(de7.e() - py.r));
            return delegateNativeAdView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oc7
    /* renamed from: d */
    public void b(@NonNull DelegateNativeAdView delegateNativeAdView, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, delegateNativeAdView, advertAppInfo) == null) {
            delegateNativeAdView.a(advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.oc7
    @NonNull
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public lna e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (lna) invokeL.objValue;
    }

    public lna f(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tbPageContext)) == null) {
            this.d = tbPageContext;
            return this;
        }
        return (lna) invokeL.objValue;
    }
}

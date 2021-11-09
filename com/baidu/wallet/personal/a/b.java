package com.baidu.wallet.personal.a;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.personal.a.a;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.ui.view.d;
/* loaded from: classes10.dex */
public class b extends a<CouponList.Coupon> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f60610c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ListView listView, Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60610c = context;
    }

    @Override // com.baidu.wallet.personal.a.a
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ResUtils.layout(this.f60610c, "wallet_personal_coupon_group_item") : invokeI.intValue;
    }

    @Override // com.baidu.wallet.personal.a.a
    public a.b<CouponList.Coupon> a(int i2, View view) {
        InterceptResult invokeIL;
        a.b<CouponList.Coupon> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view)) == null) {
            CouponList.Coupon coupon = (CouponList.Coupon) this.f60606a.get(i2);
            if (coupon != null) {
                int i3 = coupon.coupon_list_show_formwork;
                if (i3 != 5) {
                    if (i3 != 11 && i3 != 22 && i3 != 33 && i3 != 44) {
                        if (i3 != 55) {
                            if (i3 != 66) {
                                aVar = new com.baidu.wallet.personal.ui.view.b();
                                aVar.c(true);
                                aVar.a(view);
                                return aVar;
                            }
                        }
                    }
                    aVar = new d();
                    aVar.c(true);
                    aVar.a(view);
                    return aVar;
                }
                aVar = new com.baidu.wallet.personal.ui.view.a();
                aVar.c(true);
                aVar.a(view);
                return aVar;
            }
            return null;
        }
        return (a.b) invokeIL.objValue;
    }

    @Override // com.baidu.wallet.personal.a.a, android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}

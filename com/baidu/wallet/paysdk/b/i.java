package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.b.i$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static i f62365a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(849721911, "Lcom/baidu/wallet/paysdk/b/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(849721911, "Lcom/baidu/wallet/paysdk/b/i$a;");
                    return;
                }
            }
            f62365a = new i(null);
        }
    }

    public /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62365a : (i) invokeV.objValue;
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a(Context context, CardData.BondCard bondCard, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, bondCard, z)) == null) {
            if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
                return 0;
            }
            if ((context instanceof HalfScreenBaseActivity) || (context instanceof WalletSmsActivity)) {
                if (bondCard != null && 1 == bondCard.is_need_repaired) {
                    if ("1".equals(bondCard.need_true_name)) {
                        return 0;
                    }
                    r2 = "1".equals(bondCard.need_cvv2) ? 1 : 0;
                    if (z || "1".equals(bondCard.need_phone_num)) {
                        r2++;
                    }
                    if ("1".equals(bondCard.need_valid_date)) {
                        r2++;
                    }
                    if ("1".equals(bondCard.need_identity_code) && "1".equals(bondCard.need_identity_type)) {
                        r2++;
                    }
                    if (1 == r2 || 2 == r2) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("1");
                        arrayList.add(Integer.toString(r2));
                        StatisticManager.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
                    }
                }
                return r2;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public int a(Context context, ErrorContentResponse errorContentResponse) {
        InterceptResult invokeLL;
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, errorContentResponse)) == null) {
            if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
                return 0;
            }
            if (((context instanceof HalfScreenBaseActivity) || (context instanceof WalletSmsActivity)) && errorContentResponse != null && errorContentResponse.card_item_required != null && ((certificateTypeInfoArr = errorContentResponse.certificate_type_info) == null || 1 >= certificateTypeInfoArr.length)) {
                int i2 = "1".equals(errorContentResponse.card_item_required.valid_code) ? 1 : 0;
                if ("1".equals(errorContentResponse.card_item_required.valid_date)) {
                    i2++;
                }
                if ("1".equals(errorContentResponse.card_item_required.mobile)) {
                    i2++;
                }
                if ("1".equals(errorContentResponse.card_item_required.certificate_code)) {
                    GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = errorContentResponse.certificate_type_info;
                    if (1 == certificateTypeInfoArr2.length && "1".equals(certificateTypeInfoArr2[0].type)) {
                        i2++;
                    }
                }
                if (1 == i2 || 2 == i2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("2");
                    arrayList.add(Integer.toString(i2));
                    StatisticManager.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
                }
                return i2;
            }
            return 0;
        }
        return invokeLL.intValue;
    }
}

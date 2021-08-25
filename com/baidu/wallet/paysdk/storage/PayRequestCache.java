package com.baidu.wallet.paysdk.storage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class PayRequestCache implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, BeanRequestBase> f62593a;

    /* renamed from: com.baidu.wallet.paysdk.storage.PayRequestCache$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class BindCategory {
        public static final /* synthetic */ BindCategory[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BindCategory Initiative;
        public static final BindCategory Other;
        public static final BindCategory Pwd;
        public transient /* synthetic */ FieldHolder $fh;
        public int mScenario;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1920267442, "Lcom/baidu/wallet/paysdk/storage/PayRequestCache$BindCategory;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1920267442, "Lcom/baidu/wallet/paysdk/storage/PayRequestCache$BindCategory;");
                    return;
                }
            }
            Other = new BindCategory("Other", 0, 0);
            Initiative = new BindCategory("Initiative", 1, 11);
            BindCategory bindCategory = new BindCategory("Pwd", 2, 4);
            Pwd = bindCategory;
            $VALUES = new BindCategory[]{Other, Initiative, bindCategory};
        }

        public BindCategory(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mScenario = i3;
        }

        public static BindCategory from(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (11 == i2) {
                    return Initiative;
                }
                if (4 == i2) {
                    return Pwd;
                }
                return Other;
            }
            return (BindCategory) invokeI.objValue;
        }

        public static BindCategory valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (BindCategory) Enum.valueOf(BindCategory.class, str) : (BindCategory) invokeL.objValue;
        }

        public static BindCategory[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (BindCategory[]) $VALUES.clone() : (BindCategory[]) invokeV.objValue;
        }

        public int getScenario() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mScenario : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PayRequestCache f62594a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185360756, "Lcom/baidu/wallet/paysdk/storage/PayRequestCache$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1185360756, "Lcom/baidu/wallet/paysdk/storage/PayRequestCache$a;");
                    return;
                }
            }
            f62594a = new PayRequestCache(null);
        }
    }

    public /* synthetic */ PayRequestCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BindFastRequest getBindRequest(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            BindCategory bindCategory = BindCategory.Other;
            if (activity != null) {
                bindCategory = getInstance().getBindCategoryByIntent(activity.getIntent());
            }
            return (BindFastRequest) getInstance().getRequest(bindCategory);
        }
        return (BindFastRequest) invokeL.objValue;
    }

    public static PayRequestCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f62594a : (PayRequestCache) invokeV.objValue;
    }

    public void addBeanRequestToCache(String str, BeanRequestBase beanRequestBase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, beanRequestBase) == null) || str == null || str.equals("") || beanRequestBase == null) {
            return;
        }
        this.f62593a.put(str, beanRequestBase);
    }

    public void clearPaySdkRequestCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogUtil.e(PayRequestCache.class.getSimpleName(), "clearPaySdkRequestCache", null);
            Set<String> keySet = this.f62593a.keySet();
            HashSet<String> hashSet = new HashSet();
            for (String str : keySet) {
                if (this.f62593a.get(str) != null && this.f62593a.get(str).mBelongPaySdk) {
                    hashSet.add(str);
                }
            }
            for (String str2 : hashSet) {
                removeBeanRequestFromCache(str2);
            }
        }
    }

    public void clearRequestCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62593a.clear();
        }
    }

    public BeanRequestBase getBeanRequestFromCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null || str.equals("")) {
                return null;
            }
            return this.f62593a.get(str);
        }
        return (BeanRequestBase) invokeL.objValue;
    }

    public BindCategory getBindCategoryByIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) {
            if (intent == null) {
                return BindCategory.Other;
            }
            BindCategory bindCategory = BindCategory.Other;
            String stringExtra = intent.getStringExtra("baidu.wallet.from");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    bindCategory = BindCategory.valueOf(stringExtra);
                    if (isPaying()) {
                        return BindCategory.Other;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return bindCategory;
        }
        return (BindCategory) invokeL.objValue;
    }

    public BeanRequestBase getRequest(BindCategory bindCategory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bindCategory)) == null) {
            if (bindCategory == null) {
                return null;
            }
            return getBeanRequestFromCache(bindCategory.name());
        }
        return (BeanRequestBase) invokeL.objValue;
    }

    public CardData.BondCard getSelectCard() {
        InterceptResult invokeV;
        PayRequest.PayPrice payPrice;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest == null || (payPrice = payRequest.getPayPrice()) == null || payPrice.payType != PayRequest.PayPrice.PayType.BANKCARD) {
                return null;
            }
            return payRequest.mBondCard;
        }
        return (CardData.BondCard) invokeV.objValue;
    }

    public boolean isAuthFastPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
            return bindFastRequest != null && bindFastRequest.getmBindFrom() == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean isBondPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (PayDataCache.getInstance().hasBondCards()) {
                PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
                if (payRequest == null || payRequest.getPayPrice().payType != PayRequest.PayPrice.PayType.BANKCARD || payRequest.mBondCard == null) {
                    return false;
                }
                int indexOf = Arrays.asList(PayDataCache.getInstance().getBondCards()).indexOf(payRequest.mBondCard);
                return (bindFastRequest == null || !payRequest.mBondCard.equals(bindFastRequest.mBondCard)) ? indexOf >= 0 : (isCompletePay() || isAuthFastPay() || indexOf < 0) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isCompletePay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
            return bindFastRequest != null && (bindFastRequest.getmBindFrom() == 2 || bindFastRequest.getmBindFrom() == 7);
        }
        return invokeV.booleanValue;
    }

    public boolean isPaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            return (payRequest == null || BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void removeBeanRequestFromCache(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f62593a.remove(str);
    }

    public PayRequestCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62593a = new HashMap<>();
    }
}

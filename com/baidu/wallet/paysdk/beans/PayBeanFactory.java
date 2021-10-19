package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class PayBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_BALANCE_PAY = 14;
    public static final int BEAN_ID_BIND_CARD = 513;
    public static final int BEAN_ID_BIND_CARD_PROTOCOL = 605;
    public static final int BEAN_ID_CALC_PAYMENT = 16;
    public static final int BEAN_ID_CARD_ADD = 597;
    public static final int BEAN_ID_CHECK_CARD_INFO = 5;
    public static final int BEAN_ID_CHECK_CARD_INFO_4_MODIFY_PHONE = 17;
    public static final int BEAN_ID_CHECK_MOBILE_PWD = 258;
    public static final int BEAN_ID_CHECK_PWD = 529;
    public static final int BEAN_ID_CREDIT_PAY = 263;
    public static final int BEAN_ID_FAST_PAY_QUERY = 12;
    public static final int BEAN_ID_FIND_MOBILE_PWD = 260;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS = 523;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST = 526;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD = 524;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS = 522;
    public static final int BEAN_ID_GET_CARD_INFO = 4;
    public static final int BEAN_ID_GET_CARD_INFO_4_MODIFY_PHONE = 15;
    public static final int BEAN_ID_GET_PAY_ORDER = 1;
    public static final int BEAN_ID_GET_WALLET_INTERFACE = 525;
    public static final int BEAN_ID_MODIFY_MOBILE_PWD = 259;
    public static final int BEAN_ID_NEW_CHECK_PASSWORD = 606;
    public static final int BEAN_ID_OPEN_FINGERPRINT_REFACTOR = 596;
    public static final int BEAN_ID_PAY = 13;
    public static final int BEAN_ID_QUERY_BANK_INFO = 7;
    public static final int BEAN_ID_QUERY_TRANS = 604;
    public static final int BEAN_ID_SAVE_FEEDBACK = 598;
    public static final int BEAN_ID_SCANCODE_PAY = 594;
    public static final int BEAN_ID_SCANCODE_SEND_SMS_TO_PAY = 595;
    public static final int BEAN_ID_SEND_SMS = 9;
    public static final int BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK = 264;
    public static final int BEAN_ID_SIGN_CHANNEL_LIST = 517;
    public static final int BEAN_ID_UNBIND_CARD = 516;
    public static final int BEAN_ID_UNBIND_CARD_SEND_SMS = 514;
    public static final int BEAN_ID_USER_HAS_PAY_PASSWORD = 600;
    public static final int BEAN_ID_USER_INFO = 6;
    public static final int BEAN_ID_VERIFY_MOBILE_PWD = 257;
    public static final int BEAN_ID_VERIFY_SMS_CODE = 11;
    public static final int BEAN_ID_WIDTHDRAW = 527;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PayBeanFactory f62686a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1993138699, "Lcom/baidu/wallet/paysdk/beans/PayBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1993138699, "Lcom/baidu/wallet/paysdk/beans/PayBeanFactory$a;");
                    return;
                }
            }
            f62686a = new PayBeanFactory();
        }
    }

    public static PayBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62686a : (PayBeanFactory) invokeV.objValue;
    }

    public PayBeanFactory() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.dxmpay.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            Context applicationContext = context.getApplicationContext();
            BaseBean<?> baseBean = null;
            if (i2 == 1) {
                baseBean = new s(applicationContext);
            } else if (i2 == 9) {
                baseBean = new ac(applicationContext);
            } else if (i2 == 529) {
                baseBean = new h(applicationContext);
            } else if (i2 == 600) {
                baseBean = new VerifyPayPasswordBean(applicationContext);
            } else if (i2 == 4) {
                baseBean = new r(applicationContext);
            } else if (i2 == 5) {
                baseBean = new g(applicationContext);
            } else if (i2 == 6) {
                baseBean = new UserInfoBean(applicationContext);
            } else if (i2 == 7) {
                baseBean = new y(applicationContext);
            } else if (i2 == 263) {
                baseBean = new i(applicationContext);
            } else if (i2 == 264) {
                baseBean = new ab(applicationContext);
            } else if (i2 == 513) {
                baseBean = new b(applicationContext);
            } else if (i2 == 514) {
                baseBean = new p(applicationContext);
            } else if (i2 == 516) {
                baseBean = new UnbindCardBean(applicationContext);
            } else if (i2 == 517) {
                baseBean = new aa(applicationContext);
            } else if (i2 == 605) {
                baseBean = new c(applicationContext);
            } else if (i2 != 606) {
                switch (i2) {
                    case 11:
                        baseBean = new ad(applicationContext);
                        break;
                    case 12:
                        baseBean = new x(applicationContext);
                        break;
                    case 13:
                        baseBean = new w(applicationContext);
                        break;
                    case 14:
                        baseBean = new com.baidu.wallet.paysdk.beans.a(applicationContext);
                        break;
                    case 15:
                        baseBean = new q(applicationContext);
                        break;
                    case 16:
                        baseBean = new d(applicationContext);
                        break;
                    case 17:
                        baseBean = new f(applicationContext);
                        break;
                    default:
                        switch (i2) {
                            case 257:
                            case 258:
                            case 259:
                                baseBean = new u(applicationContext);
                                break;
                            case 260:
                                baseBean = new n(applicationContext);
                                break;
                            default:
                                switch (i2) {
                                    case BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS /* 522 */:
                                        baseBean = new m(applicationContext);
                                        break;
                                    case BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS /* 523 */:
                                        baseBean = new j(applicationContext);
                                        break;
                                    case BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD /* 524 */:
                                        baseBean = new l(applicationContext);
                                        break;
                                    case BEAN_ID_GET_WALLET_INTERFACE /* 525 */:
                                        baseBean = new t(applicationContext);
                                        break;
                                    case BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST /* 526 */:
                                        baseBean = new k(applicationContext);
                                        break;
                                    default:
                                        switch (i2) {
                                            case BEAN_ID_SCANCODE_PAY /* 594 */:
                                                BaseBean<?>[] baseBeanArr = {null};
                                                LocalRouter.getInstance(applicationContext).route(applicationContext, new RouterRequest().provider("scancode").action("getLimitPayBean"), new RouterCallback(this, baseBeanArr) { // from class: com.baidu.wallet.paysdk.beans.PayBeanFactory.1
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ BaseBean[] f62682a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ PayBeanFactory f62683b;

                                                    {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this, baseBeanArr};
                                                            interceptable2.invokeUnInit(65536, newInitContext);
                                                            int i3 = newInitContext.flag;
                                                            if ((i3 & 1) != 0) {
                                                                int i4 = i3 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.f62683b = this;
                                                        this.f62682a = baseBeanArr;
                                                    }

                                                    @Override // com.baidu.wallet.router.RouterCallback
                                                    public void onResult(int i3, HashMap hashMap) {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                                                            if (i3 == 0 && hashMap != null && hashMap.get("data") != null) {
                                                                Object obj = hashMap.get("data");
                                                                if (obj == null || !(obj instanceof BaseBean)) {
                                                                    return;
                                                                }
                                                                this.f62682a[0] = (BaseBean) obj;
                                                            } else if (i3 == 5) {
                                                                HashMap hashMap2 = new HashMap();
                                                                hashMap2.put("provider", "scancode");
                                                                hashMap2.put("action", "getLimitPayBean");
                                                                StatisticManager.onEventEndWithValues("sdk_router_error", i3, hashMap2.values());
                                                            }
                                                        }
                                                    }
                                                });
                                                baseBean = baseBeanArr[0];
                                                break;
                                            case BEAN_ID_SCANCODE_SEND_SMS_TO_PAY /* 595 */:
                                                BaseBean<?>[] baseBeanArr2 = {null};
                                                LocalRouter.getInstance(applicationContext).route(applicationContext, new RouterRequest().provider("scancode").action("getSendSmsBean"), new RouterCallback(this, baseBeanArr2) { // from class: com.baidu.wallet.paysdk.beans.PayBeanFactory.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ BaseBean[] f62684a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ PayBeanFactory f62685b;

                                                    {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this, baseBeanArr2};
                                                            interceptable2.invokeUnInit(65536, newInitContext);
                                                            int i3 = newInitContext.flag;
                                                            if ((i3 & 1) != 0) {
                                                                int i4 = i3 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.f62685b = this;
                                                        this.f62684a = baseBeanArr2;
                                                    }

                                                    @Override // com.baidu.wallet.router.RouterCallback
                                                    public void onResult(int i3, HashMap hashMap) {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                                                            if (i3 == 0 && hashMap != null) {
                                                                Object obj = hashMap.get("data");
                                                                if (obj == null || !(obj instanceof BaseBean)) {
                                                                    return;
                                                                }
                                                                this.f62684a[0] = (BaseBean) obj;
                                                            } else if (i3 == 5) {
                                                                HashMap hashMap2 = new HashMap();
                                                                hashMap2.put("provider", "scancode");
                                                                hashMap2.put("action", "getSendSmsBean");
                                                                StatisticManager.onEventEndWithValues("sdk_router_error", i3, hashMap2.values());
                                                            }
                                                        }
                                                    }
                                                });
                                                baseBean = baseBeanArr2[0];
                                                break;
                                            case BEAN_ID_OPEN_FINGERPRINT_REFACTOR /* 596 */:
                                                baseBean = new com.baidu.wallet.paysdk.fingerprint.bean.b(applicationContext);
                                                break;
                                            case BEAN_ID_CARD_ADD /* 597 */:
                                                baseBean = new e(applicationContext);
                                                break;
                                            case BEAN_ID_SAVE_FEEDBACK /* 598 */:
                                                baseBean = new z(applicationContext);
                                                break;
                                        }
                                }
                        }
                }
            } else {
                baseBean = new v(applicationContext);
            }
            if (baseBean != null) {
                BeanManager.getInstance().addBean(str, baseBean);
            }
            return baseBean;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}

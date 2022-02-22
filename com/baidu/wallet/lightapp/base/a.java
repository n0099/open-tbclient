package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.Domains;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: com.baidu.wallet.lightapp.base.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.lightapp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2014a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992755105, "Lcom/baidu/wallet/lightapp/base/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-992755105, "Lcom/baidu/wallet/lightapp/base/a$a;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2014a.a : (a) invokeV.objValue;
    }

    public a() {
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
        this.a = -1;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            try {
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                StringBuilder sb = new StringBuilder();
                sb.append("STDCJUVF=");
                sb.append(Base64Utils.encodeToString(("{\"ua\":\"" + BussinessUtils.getUA(context) + "\",\"cu\":\"" + PhoneUtils.getCUID(context) + "\",\"cu2\":\"" + PhoneUtils.getCUID2(context) + "\"}").getBytes()));
                String sb2 = sb.toString();
                String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT, ".dxmbaoxian.com", Domains.DU_XIAO_MAN_FUND, Domains.BAI_YING_FUND};
                for (int i2 = 0; i2 < 8; i2++) {
                    String str = strArr[i2];
                    cookieManager.setCookie("https://www" + str, sb2 + ";path=/;domain=" + str + ";secure;httponly");
                }
                String str2 = "" + System.currentTimeMillis();
                String str3 = SafePay.getInstance().getpwProxy();
                String encryptProxy = SafePay.getInstance().encryptProxy(str2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("TIMETOKEN=");
                sb3.append(Base64Utils.encodeToString(("{\"timestamp\":\"" + str2 + "\",\"key\":\"" + str3 + "\",\"timeencrypt\":\"" + encryptProxy + "\"}").getBytes()));
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append(";domain=" + DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}).substring(8));
                sb5.append(";path=/walletapp/misc/");
                sb5.append(";secure");
                sb5.append(";httponly");
                cookieManager.setCookie(DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}) + "/walletapp/misc/jump", sb5.toString());
                CookieSyncManager.getInstance().sync();
            } catch (Exception unused) {
            }
        }
    }

    public int a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, context, str, i2)) == null) {
            int bdussState = WalletLoginHelper.getInstance().getBdussState();
            if (i2 != -1 && i2 != bdussState && (bdussState == 0 || bdussState == 3 || bdussState == 4)) {
                WalletLoginHelper.getInstance().getOpenBduss(false, null, 4);
            }
            if (WalletLoginHelper.getInstance().getSyncLoginListener() == null) {
                return bdussState;
            }
            WalletLoginHelper.getInstance().syncH5LoginStatus(context, str);
            return bdussState;
        }
        return invokeLLI.intValue;
    }
}

package com.baidu.tieba.pay.panel;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/tieba/pay/panel/PayPanelUtils;", "", "()V", "Companion", "ParmasBuilder", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PayPanelUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String DEFAULT_URL = "https://tieba.baidu.com/mo/q/hybrid-business-vip/payPanel?customfullscreen=1&nonavigationbar=1&noshare=1&user_skin_overlay=0";
    public static final String KEY_PAY_PANEL_URL = "key_pay_panel_url";
    public static final String TAG = "PayPanel";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1502242150, "Lcom/baidu/tieba/pay/panel/PayPanelUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1502242150, "Lcom/baidu/tieba/pay/panel/PayPanelUtils;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tbPageContext) == null) {
            Companion.b(tbPageContext);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, tbPageContext, i) == null) {
            Companion.c(tbPageContext, i);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, i, str) == null) {
            Companion.d(tbPageContext, i, str);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65541, null, tbPageContext, i, str, str2) == null) {
            Companion.e(tbPageContext, i, str, str2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext, int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tbPageContext, Integer.valueOf(i), str, str2, str3}) == null) {
            Companion.f(tbPageContext, i, str, str2, str3);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchPayPanel(TbPageContext<?> tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, bVar) == null) {
            Companion.g(tbPageContext, bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        public final void b(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
                h(this, tbPageContext, 0, null, null, null, 30, null);
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void c(TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
                h(this, tbPageContext, i, null, null, null, 28, null);
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void d(TbPageContext<?> tbPageContext, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, tbPageContext, i, str) == null) {
                h(this, tbPageContext, i, str, null, null, 24, null);
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void e(TbPageContext<?> tbPageContext, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048580, this, tbPageContext, i, str, str2) == null) {
                h(this, tbPageContext, i, str, str2, null, 16, null);
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static /* synthetic */ void h(a aVar, TbPageContext tbPageContext, int i, String str, String str2, String str3, int i2, Object obj) {
            int i3;
            String str4;
            String str5;
            String str6;
            if ((i2 & 2) != 0) {
                i3 = 0;
            } else {
                i3 = i;
            }
            if ((i2 & 4) != 0) {
                str4 = "";
            } else {
                str4 = str;
            }
            if ((i2 & 8) != 0) {
                str5 = "";
            } else {
                str5 = str2;
            }
            if ((i2 & 16) != 0) {
                str6 = "";
            } else {
                str6 = str3;
            }
            aVar.f(tbPageContext, i3, str4, str5, str6);
        }

        public final String a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                String url = PayPanelUtils.DEFAULT_URL;
                String string = sharedPrefHelper.getString(PayPanelUtils.KEY_PAY_PANEL_URL, PayPanelUtils.DEFAULT_URL);
                if (string != null && !StringsKt__StringsJVMKt.isBlank(string)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    url = string;
                }
                Intrinsics.checkNotNullExpressionValue(url, "url");
                return url;
            }
            return (String) invokeV.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final void f(TbPageContext<?> tbPageContext, int i, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tbPageContext, Integer.valueOf(i), str, str2, str3}) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e(PayPanelUtils.TAG, "吊起支付面板场景sceneId=" + i);
                if (tbPageContext != null) {
                    String a = PayPanelUtils.Companion.a();
                    if (i != 0) {
                        a = Uri.parse(PayPanelUtils.Companion.a()).buildUpon().appendQueryParameter("scene_id", String.valueOf(i)).build().toString();
                        Intrinsics.checkNotNullExpressionValue(a, "parse(getPayPanelUrl()).…ing()).build().toString()");
                    }
                    HashMap<String, Serializable> hashMap = new HashMap<>();
                    if (str == null) {
                        str = "";
                    }
                    hashMap.put("referPage", str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put("clickZone", str2);
                    if (str3 == null) {
                        str3 = "";
                    }
                    hashMap.put("fromScene", str3);
                    pu4 j = pu4.j(tbPageContext.getPageActivity(), a);
                    j.f(hashMap);
                    TbWebViewActivityConfig b = j.b();
                    b.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                    b.start();
                    TbLog defaultLog2 = DefaultLog.getInstance();
                    defaultLog2.e(PayPanelUtils.TAG, "吊起支付面板场景url" + a);
                }
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void g(TbPageContext<?> tbPageContext, b panelBuilder) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, tbPageContext, panelBuilder) == null) {
                Intrinsics.checkNotNullParameter(panelBuilder, "panelBuilder");
                int e = panelBuilder.e();
                String c = panelBuilder.c();
                String a = panelBuilder.a();
                String b = panelBuilder.b();
                Integer d = panelBuilder.d();
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e(PayPanelUtils.TAG, "吊起支付面板场景sceneId=" + e);
                if (tbPageContext != null) {
                    String a2 = PayPanelUtils.Companion.a();
                    if (e != 0) {
                        a2 = Uri.parse(PayPanelUtils.Companion.a()).buildUpon().appendQueryParameter("scene_id", String.valueOf(e)).build().toString();
                        Intrinsics.checkNotNullExpressionValue(a2, "parse(getPayPanelUrl()).…ing()).build().toString()");
                    }
                    HashMap<String, Serializable> hashMap = new HashMap<>();
                    if (c == null) {
                        c = "";
                    }
                    hashMap.put("referPage", c);
                    if (a == null) {
                        a = "";
                    }
                    hashMap.put("clickZone", a);
                    if (b == null) {
                        b = "";
                    }
                    hashMap.put("fromScene", b);
                    pu4 j = pu4.j(tbPageContext.getPageActivity(), a2);
                    j.f(hashMap);
                    if (d != null) {
                        i = d.intValue();
                    } else {
                        i = 0;
                    }
                    j.o(i);
                    TbWebViewActivityConfig b2 = j.b();
                    b2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                    b2.start();
                    TbLog defaultLog2 = DefaultLog.getInstance();
                    defaultLog2.e(PayPanelUtils.TAG, "吊起支付面板场景url" + a2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public int c;
        public String d;
        public Integer e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = "";
            this.d = "";
            this.e = 0;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final Integer d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (Integer) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.b = str;
            }
        }

        public final void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.a = str;
            }
        }

        public final void h(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
                this.e = num;
            }
        }

        public final void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.c = i;
            }
        }
    }

    public PayPanelUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

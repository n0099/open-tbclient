package com.bytedance.embedapplog;

import androidx.core.view.InputDeviceCompat;
import c.b.a.h0;
import c.b.a.i0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class GameReportHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESS_ACCOUNT = "access_account";
    public static final String ACCESS_PAYMENT_CHANNEL = "access_payment_channel";
    public static final String ADD_CART = "add_cart";
    public static final String ADD_TO_FAVORITE = "add_to_favourite";
    public static final String CHECK_OUT = "check_out";
    public static final String CREATE_GAMEROLE = "create_gamerole";
    public static final String LOG_IN = "log_in";
    public static final String PURCHASE = "purchase";
    public static final String QUEST = "quest";
    public static final String REGISTER = "register";
    public static final String UPDATE_LEVEL = "update_level";
    public static final String VIEW_CONTENT = "view_content";
    public transient /* synthetic */ FieldHolder $fh;

    public GameReportHelper() {
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

    public static void onEventAccessAccount(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("account_type", str);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3(ACCESS_ACCOUNT, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventAccessPaymentChannel(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payment_channel", str);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3(ACCESS_PAYMENT_CHANNEL, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventAddCart(String str, String str2, String str3, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_type", str);
                jSONObject.put("content_name", str2);
                jSONObject.put("content_id", str3);
                jSONObject.put("content_num", i2);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3(ADD_CART, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventAddToFavorite(String str, String str2, String str3, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_type", str);
                jSONObject.put("content_name", str2);
                jSONObject.put("content_id", str3);
                jSONObject.put("content_num", i2);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3(ADD_TO_FAVORITE, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventCheckOut(String str, String str2, String str3, int i2, boolean z, String str4, String str5, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z), str4, str5, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_type", str);
                jSONObject.put("content_name", str2);
                jSONObject.put("content_id", str3);
                jSONObject.put("content_num", i2);
                jSONObject.put("is_virtual_currency", i0.e(z));
                jSONObject.put("virtual_currency", str4);
                jSONObject.put("currency", str5);
                jSONObject.put("is_success", i0.e(z2));
                jSONObject.put("currency_amount", i3);
                AppLog.onEventV3(CHECK_OUT, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventCreateGameRole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("gamerole_id", str);
                AppLog.onEventV3(CREATE_GAMEROLE, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventLogin(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method", str);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3(LOG_IN, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventPurchase(String str, String str2, String str3, int i2, String str4, String str5, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, Integer.valueOf(i2), str4, str5, Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_type", str);
                jSONObject.put("content_name", str2);
                jSONObject.put("content_id", str3);
                jSONObject.put("content_num", i2);
                jSONObject.put("payment_channel", str4);
                jSONObject.put("currency", str5);
                jSONObject.put("is_success", i0.e(z));
                jSONObject.put("currency_amount", i3);
                AppLog.onEventV3(PURCHASE, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventQuest(String str, String str2, String str3, int i2, boolean z, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z), str4}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("quest_id", str);
                jSONObject.put("quest_type", str2);
                jSONObject.put("quest_name", str3);
                jSONObject.put("quest_no", i2);
                jSONObject.put("is_success", i0.e(z));
                jSONObject.put("description", str4);
                AppLog.onEventV3(QUEST, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventRegister(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method", str);
                jSONObject.put("is_success", i0.e(z));
                AppLog.onEventV3("register", jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventUpdateLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", i2);
                AppLog.onEventV3(UPDATE_LEVEL, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }

    public static void onEventViewContent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, str3) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_type", str);
                jSONObject.put("content_name", str2);
                jSONObject.put("content_id", str3);
                AppLog.onEventV3(VIEW_CONTENT, jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
        }
    }
}

package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.b49;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MemberPayResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;
    public c b;
    public b c;

    /* loaded from: classes5.dex */
    public static class VipPayPrivilegeData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DYNAMIC_DISAPPEAR_CLICK = "click";
        public static final String DYNAMIC_DISAPPEAR_CONCEL = "concel";
        public static final int NEW_TIP_COLOR_ID = 2131099718;
        public static final String NEW_TIP_TEXT = "NEW";
        public static final String TIP_SHOW = "1";
        public static final int WAIT_TIP_COLOR_ID = 2131099749;
        public static final String WAIT_TIP_TEXT = "敬请期待";
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("dynamic_color")
        public String dynamicColor;
        @SerializedName("dynamic_color_dark")
        public String dynamicColorDark;
        @SerializedName("dynamic_color_night")
        public String dynamicColorNight;
        @SerializedName("dynamic_disappear")
        public String dynamicDisappear;
        @SerializedName("dynamic_text")
        public String dynamicText;
        @SerializedName("equity_id")
        public String mEquityId;
        @SerializedName("icon_url")
        public String mIconUrl;
        @SerializedName("link_url")
        public String mLinkUrl;
        @SerializedName("title")
        public String mTitle;
        @SerializedName("show_await")
        public String showAwait;
        @SerializedName("show_new")
        public String showNew;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1555272393, "Lcom/baidu/tieba/memberCenter/memberpay/MemberPayResult$VipPayPrivilegeData;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1555272393, "Lcom/baidu/tieba/memberCenter/memberpay/MemberPayResult$VipPayPrivilegeData;");
            }
        }

        public VipPayPrivilegeData() {
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

        public String getDynamicDisappear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if ("1".equals(this.showNew)) {
                    return "click";
                }
                if ("1".equals(this.showAwait)) {
                    return DYNAMIC_DISAPPEAR_CONCEL;
                }
                return this.dynamicDisappear;
            }
            return (String) invokeV.objValue;
        }

        public String getDynamicText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if ("1".equals(this.showNew)) {
                    return NEW_TIP_TEXT;
                }
                if ("1".equals(this.showAwait)) {
                    return WAIT_TIP_TEXT;
                }
                return this.dynamicText;
            }
            return (String) invokeV.objValue;
        }

        public int getDynamicColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if ("1".equals(this.showNew)) {
                    return SkinManager.getColor(NEW_TIP_COLOR_ID);
                }
                if ("1".equals(this.showAwait)) {
                    return SkinManager.getColor(WAIT_TIP_COLOR_ID);
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    return b49.f(this.dynamicColorDark);
                }
                return b49.f(this.dynamicColor);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<e> a;
        public List<g> b;
        public String c;

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
                    return;
                }
            }
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.c = jSONObject.optString("content");
            jSONObject.optString("tip_text");
            jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                e eVar = new e();
                eVar.a(jSONObject2);
                if (1 == eVar.g) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.i = z;
                this.a.add(eVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                g gVar = new g();
                gVar.a(optJSONArray2.optJSONObject(i2));
                this.b.add(gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<VipPayPrivilegeData> a;

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
            this.a = new ArrayList<>();
        }

        public void a(JSONArray jSONArray) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONArray) != null) || jSONArray == null) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.a.add((VipPayPrivilegeData) DataExt.toEntity(jSONArray.getJSONObject(i).toString(), VipPayPrivilegeData.class));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;
        public a b;

        public c() {
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
            this.a = new d();
            this.b = new a();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.a.a(jSONObject.optJSONObject("member"));
            this.b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<e> a;
        public List<g> b;
        public String c;

        public d() {
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
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.c = jSONObject.optString("content");
            jSONObject.optString("tip_text");
            jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                e eVar = new e();
                eVar.a(jSONObject2);
                if (1 == eVar.g) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.i = z;
                this.a.add(eVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                g gVar = new g();
                gVar.a(jSONObject3);
                this.b.add(gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public long e;
        public long f;
        public long g;
        public long h;
        public boolean i;
        public int j;
        public boolean k;

        public e() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("productId");
            this.b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.c = jSONObject.optString("discount");
            jSONObject.optString("original_cost");
            jSONObject.optString("icon");
            this.e = jSONObject.optLong("props_id");
            this.f = jSONObject.optLong("money");
            this.h = jSONObject.optLong("months");
            this.g = jSONObject.optLong("default");
            jSONObject.optString("packet_text");
            this.j = jSONObject.optInt("is_autopay");
            this.k = false;
            jSONObject.optString("payment_pos_key");
            this.d = jSONObject.optString(PushConstants.SUB_TAGS_STATUS_NAME);
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        public f() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* loaded from: classes5.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            jSONObject.optString("name");
            jSONObject.optLong("num");
        }
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public f a;

        public h() {
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
            this.a = new f();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            jSONObject.optString("name_show");
            jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.a.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public MemberPayResult() {
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
        this.a = new h();
        this.b = new c();
        this.c = new b();
    }

    public void a(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.a.a(jSONObject.optJSONObject("user"));
        this.b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
        this.c.a(jSONObject.optJSONArray("equity"));
    }
}

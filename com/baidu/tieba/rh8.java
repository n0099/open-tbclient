package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes8.dex */
public class rh8 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public List<String> f;
    public List<String> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121735, "Lcom/baidu/tieba/rh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121735, "Lcom/baidu/tieba/rh8;");
                return;
            }
        }
        h = BdUniqueId.gen();
    }

    public rh8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return h;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void c(LiveAnswer liveAnswer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, liveAnswer) != null) || liveAnswer == null) {
            return;
        }
        this.a = liveAnswer.activity_id.toString();
        this.d = liveAnswer.banner_url;
        this.b = liveAnswer.banner_high.intValue();
        this.c = liveAnswer.banner_width.intValue();
        this.e = liveAnswer.jump_url;
        this.f.clear();
        this.f.addAll(liveAnswer.show_statistics_urls);
        this.g.clear();
        this.g.addAll(liveAnswer.click_statistics_urls);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("activity_id", this.a);
                jSONObject.put("img_width", this.c);
                jSONObject.put(BigdayActivityConfig.IMG_URL, this.d);
                jSONObject.put("img_height", this.b);
                jSONObject.put(BigdayActivityConfig.JUMP_URL, this.e);
                jSONObject.put("show_statistics_urls", this.f);
                jSONObject.put("click_statistics_urls", this.g);
                return jSONObject.toString();
            } catch (JSONException e) {
                BdLog.e(e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}

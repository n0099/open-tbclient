package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y48 {
    public static /* synthetic */ Interceptable $ic;
    public static y48 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;
    public StringBuilder b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280300, "Lcom/baidu/tieba/y48;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280300, "Lcom/baidu/tieba/y48;");
                return;
            }
        }
        c = new y48();
    }

    public y48() {
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
        this.a = new HashSet<>();
        this.b = new StringBuilder();
    }

    public static y48 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (y48) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StringBuilder sb = this.b;
            if (sb != null && sb.length() > 0) {
                StringBuilder sb2 = this.b;
                sb2.delete(0, sb2.length());
            }
            HashSet<String> hashSet = this.a;
            if (hashSet != null) {
                hashSet.clear();
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.length() > 0) {
            StringBuilder sb = this.b;
            sb.append(str);
            sb.append(",");
        }
    }

    public void d(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && chatMessage.getUserInfo() != null && CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(chatMessage.getUserInfo().getUserId()) && !StringUtils.isNull(chatMessage.getContent())) {
            try {
                JSONArray jSONArray = new JSONArray(chatMessage.getContent());
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String optString = jSONObject.optString("msg_src");
                    String optString2 = jSONObject.optString("type");
                    CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_MSG_SHOW, optString + "_" + optString2, jSONObject.optString("title"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        k28 p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, chatMessage, context) != null) || chatMessage == null || StringUtils.isNull(chatMessage.getContent()) || (userInfo = chatMessage.getUserInfo()) == null) {
            return;
        }
        if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (p = t58.p(chatMessage.getContent())) != null && !TextUtils.isEmpty(p.b) && this.a.add(p.b)) {
            TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", p.a, "task_id", p.b);
        }
    }

    public void f(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, chatMessage, context) == null) && chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            StatisticItem statisticItem = new StatisticItem("c13989");
            statisticItem.param("service_id", chatMessage.getStatisticsServiceId());
            statisticItem.param("task_id", chatMessage.getStatTaskId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String str2 = null;
            if (this.a != null) {
                StringBuilder sb3 = new StringBuilder();
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && next.length() > 0) {
                        sb3.append(next);
                        sb3.append(",");
                    }
                }
                if (sb3.length() > 0) {
                    sb3.deleteCharAt(sb3.length() - 1);
                    if (sb3.length() > 0) {
                        str = sb3.toString();
                        sb = this.b;
                        if (sb != null && sb.length() > 0) {
                            this.b.deleteCharAt(sb2.length() - 1);
                            str2 = this.b.toString();
                        }
                        new AddMsgRecordModel().reqViewAndClick(str, str2);
                    }
                }
            }
            str = null;
            sb = this.b;
            if (sb != null) {
                this.b.deleteCharAt(sb2.length() - 1);
                str2 = this.b.toString();
            }
            new AddMsgRecordModel().reqViewAndClick(str, str2);
        }
    }
}

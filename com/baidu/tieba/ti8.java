package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.LiveConstants;
import com.baidu.searchbox.live.interfaces.service.EventDispatcherService;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ti8 implements EventDispatcherService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final void a(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public ti8() {
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

    public static void f(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, arrayList) != null) || arrayList == null || arrayList.size() == 0) {
        }
    }

    public final void h(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            String str = (String) map.get("data");
            if (!TextUtils.isEmpty(str) && str != null) {
                try {
                    bg8.o(new JSONObject(str));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public final void c(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("roomId", map.get("roomId"));
                jSONObject.put("isClosed", map.get("isClosed"));
                jSONObject.put("liveId", map.get("liveId"));
                jSONObject.put("type", map.get("type"));
                jSONObject.put("sid", map.get("sid"));
                jSONObject.put(YyLiveRoomConfig.KEY_SSID, map.get(YyLiveRoomConfig.KEY_SSID));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public void d(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, map) != null) || hi.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.param(str2, map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void e(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, map) != null) || map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String obj = map.remove("key").toString();
        for (String str : map.keySet()) {
            hashMap.put(str, map.get(str).toString());
        }
        d(obj, hashMap);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.live.interfaces.service.EventDispatcherService
    public void onEvent(String str, Map<String, ?> map) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, map) == null) {
            switch (str.hashCode()) {
                case -2147386482:
                    if (str.equals("sync_webview_cookie")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1369745389:
                    if (str.equals("living_room_is_closed")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1326603888:
                    if (str.equals(LiveConstants.SdkToHostEvents.DO_LOG)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -841542404:
                    if (str.equals(LiveConstants.SdkToHostEvents.GO_FEEDBACK)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 152519529:
                    if (str.equals("live_show_close")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1766660371:
                    if (str.equals(LiveConstants.SdkToHostEvents.BUY_TBEAN_RESULT)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1785162541:
                    if (str.equals(LiveConstants.SdkToHostEvents.KEY_PRE_DOWANLOAD_SWAN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    g();
                    return;
                case 1:
                    b();
                    return;
                case 2:
                    e(map);
                    return;
                case 3:
                    f((ArrayList) map.get(str));
                    return;
                case 4:
                    a(map);
                    return;
                case 5:
                    h(map);
                    return;
                case 6:
                    c(map);
                    return;
                default:
                    return;
            }
        }
    }
}

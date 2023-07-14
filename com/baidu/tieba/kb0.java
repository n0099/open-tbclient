package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.business.model.data.LiveStatInfo;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.model.data.ThirdLabelInfo;
import com.baidu.live.business.util.GrParasmUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.player.utils.ExtLogUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kb0 {
    public static /* synthetic */ Interceptable $ic;
    public static final UBCManager a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907184, "Lcom/baidu/tieba/kb0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907184, "Lcom/baidu/tieba/kb0;");
                return;
            }
        }
        a = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static void A(Context context, String str, String str2, Boolean bool, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, context, str, str2, bool, str3) == null) {
            z(context, str2, n(str), bool.booleanValue(), str3);
        }
    }

    public static void x(Context context, String str, String str2, Boolean bool, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65581, null, context, str, str2, bool, str3) == null) {
            w(context, str2, n(str), bool.booleanValue(), str3);
        }
    }

    public static void B(Context context, String str, String str2, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Integer.valueOf(i), liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    String str3 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject3.put(ExtLogUtil.GR_EXT, new JSONObject(str3));
                    }
                    jSONObject2.put("ext", jSONObject3);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog clk      " + jSONObject.toString());
            a.onEvent("5635", jSONObject.toString());
        }
    }

    public static void C(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, str, str2, str3, str4) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void D(Context context, LiveSearchResultInfo liveSearchResultInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, liveSearchResultInfo, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str2);
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", str);
                e(liveSearchResultInfo.statInfo, jSONObject2);
                jSONObject2.put("bduid", liveSearchResultInfo.uk);
                jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveSearchResultInfo.roomId);
                jSONObject2.put("nid", liveSearchResultInfo.feedId);
                jSONObject2.put("status", "live");
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            if (str2.equals("show")) {
                a.onEvent("5142", jSONObject.toString());
            }
            if (str2.equals("clk")) {
                a.onEvent("5143", jSONObject.toString());
            }
        }
    }

    public static void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4788", jSONObject.toString());
        }
    }

    public static void G(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4792", jSONObject.toString());
        }
    }

    public static void H(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4793", jSONObject.toString());
        }
    }

    public static void K(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5120", jSONObject.toString());
        }
    }

    public static void L(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4791", jSONObject.toString());
        }
    }

    public static void M(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4789", jSONObject.toString());
        }
    }

    public static void N(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4790", jSONObject.toString());
        }
    }

    public static void R(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4807", jSONObject.toString());
        }
    }

    public static String o(LiveRoomEntity liveRoomEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, liveRoomEntity)) == null) {
            if (liveRoomEntity == null) {
                return "";
            }
            if (liveRoomEntity.isYYShow() && liveRoomEntity.isHorizontalScreen()) {
                int i = liveRoomEntity.showTpl;
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        return "y-2";
                    }
                } else {
                    return "y-1";
                }
            } else if (liveRoomEntity.isHorizontalScreen()) {
                int i2 = liveRoomEntity.showTpl;
                if (i2 != 1 && i2 != 2) {
                    if (i2 == 3) {
                        return "h-2";
                    }
                } else {
                    return "h-1";
                }
            } else {
                int i3 = liveRoomEntity.showTpl;
                if (i3 != 1 && i3 != 2) {
                    if (i3 == 3) {
                        return "v-2";
                    }
                } else {
                    return "v-1";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", str);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4808", jSONObject.toString());
        }
    }

    public static void O(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sousuoci", str);
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4797", jSONObject.toString());
        }
    }

    public static void c(LiveRoomEntity liveRoomEntity, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, liveRoomEntity, jSONObject) == null) {
            LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
            if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.dot)) {
                try {
                    jSONObject.put("lt_value", liveRoomEntity.leftLabel.dot);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
            if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.dot)) {
                try {
                    jSONObject.put("rt_value", liveRoomEntity.rightLabel.dot);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
            if (thirdLabelInfo != null && !TextUtils.isEmpty(thirdLabelInfo.dot)) {
                try {
                    jSONObject.put("ld_value", liveRoomEntity.thirdLabel.dot);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static void I(Context context, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, context, i, liveRoomEntity) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    String str = "";
                    if (liveRoomEntity.hostInfo != null) {
                        str = liveRoomEntity.hostInfo.uk;
                    }
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5119", jSONObject.toString());
        }
    }

    public static void J(Context context, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, context, i, liveRoomEntity) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    String str = "";
                    if (liveRoomEntity.hostInfo != null) {
                        str = liveRoomEntity.hostInfo.uk;
                    }
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5121", jSONObject.toString());
        }
    }

    public static Flow P(Context context, boolean z, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Boolean.valueOf(z), flow})) == null) {
            if (z) {
                return a.beginFlow("4800");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "show");
                    jSONObject.put("from", "liveshow");
                    jSONObject.put("page", "neisou_page");
                    jSONObject.put("source", "yijitabzhibo");
                    b(context, null, new JSONObject());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void Q(Context context, LiveRoomEntity liveRoomEntity, LiveSearchResultInfo liveSearchResultInfo, Boolean bool, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, liveRoomEntity, liveSearchResultInfo, bool, Integer.valueOf(i), str}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (bool.booleanValue()) {
                    e(liveSearchResultInfo.statInfo, jSONObject2);
                    jSONObject2.put("bduid", liveSearchResultInfo.uk);
                    jSONObject2.put("touxiangqu_mukuai", "1");
                    jSONObject2.put("ziyuanqu_mukuai", 0);
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveSearchResultInfo.roomId);
                } else {
                    e(liveRoomEntity.statInfo, jSONObject2);
                    jSONObject2.put("bduid", liveRoomEntity.hostInfo.uk);
                    jSONObject2.put("ziyuanqu_mukuai", 1);
                    jSONObject2.put("touxiangqu_mukuai", "");
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveRoomEntity.roomId);
                    jSONObject2.put("nid", liveRoomEntity.nid);
                    if (liveRoomEntity.liveStatus == 0) {
                        jSONObject2.put("status", "preview");
                    } else if (liveRoomEntity.liveStatus == 1) {
                        jSONObject2.put("status", "live");
                    } else {
                        jSONObject2.put("status", "record");
                    }
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            if (str.equals("show")) {
                a.onEvent("4785", jSONObject.toString());
            }
            if (str.equals("clk")) {
                a.onEvent("4784", jSONObject.toString());
            }
        }
    }

    public static void S(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, context, i, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos", i);
                jSONObject2.put("action", str);
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4786", jSONObject.toString());
        }
    }

    public static void b(Context context, String str, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65559, null, context, str, jSONObject) != null) || jSONObject == null) {
            return;
        }
        jSONObject.put("host_suzhu", m());
        if (!vd0.a(str)) {
            jSONObject.put("position_changjing", str);
        }
        String yyhdid = LiveFeedPageSdk.getInstance().getYYHDID(context);
        if (!TextUtils.isEmpty(yyhdid)) {
            jSONObject.put("hdid", yyhdid);
        }
        String bdId = LiveFeedPageSdk.getInstance().getBdId();
        if (!TextUtils.isEmpty(bdId)) {
            jSONObject.put("yonghuid", bdId);
        }
    }

    public static void k(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65568, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void l(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void T(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, context, i) == null) {
            S(context, i, StickerDataChangeType.REPLACE);
        }
    }

    public static void U(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, context, i) == null) {
            S(context, i, "search");
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, str, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("from", "liveshow");
            jSONObject.put("page", "main_page");
            if (!vd0.a(str)) {
                jSONObject.put("source", str);
            }
        } catch (JSONException e) {
            LiveFeedPageSdk.liveLog(e.getMessage());
        }
    }

    public static void d(String str, String str2, int i, String str3, JSONObject jSONObject) throws JSONException {
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65561, null, new Object[]{str, str2, Integer.valueOf(i), str3, jSONObject}) != null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("nid", str2);
        }
        if (i == 0) {
            str4 = "preview";
        } else if (i == 1) {
            str4 = "live";
        } else if (i == 3) {
            str4 = "record";
        } else {
            str4 = "";
        }
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("status", str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("bduid", str3);
        }
    }

    public static void w(Context context, String str, String str2, boolean z, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{context, str, str2, Boolean.valueOf(z), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str4 = CriusAttrConstants.DISPLAY;
            } else {
                str4 = "click";
            }
            try {
                jSONObject.put("type", str4);
                jSONObject.put("value", str3);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5516", jSONObject.toString());
        }
    }

    public static void z(Context context, String str, String str2, boolean z, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{context, str, str2, Boolean.valueOf(z), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str4 = CriusAttrConstants.DISPLAY;
            } else {
                str4 = "click";
            }
            try {
                jSONObject.put("type", str4);
                jSONObject.put("value", str3);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5504", jSONObject.toString());
        }
    }

    public static void e(LiveStatInfo liveStatInfo, JSONObject jSONObject) {
        long j;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65562, null, liveStatInfo, jSONObject) == null) && jSONObject != null && liveStatInfo != null) {
            long j4 = 0;
            try {
                j = Long.parseLong(liveStatInfo.sid);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                j = 0;
            }
            try {
                j2 = Long.parseLong(liveStatInfo.ssid);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            try {
                j3 = Long.parseLong(liveStatInfo.yyuid);
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
                j3 = 0;
            }
            try {
                j4 = Integer.parseInt(liveStatInfo.tpl);
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put(TiebaStatic.YYParams.YYSID, j);
                jSONObject.put(TiebaStatic.YYParams.YYSSID, j2);
                jSONObject.put("yyuid", j3);
                if (liveStatInfo.isYY) {
                    jSONObject.put("isyylive", 1);
                }
                jSONObject.put("yytpl_id", j4);
                jSONObject.put("template_id", liveStatInfo.templateId);
            } catch (JSONException e5) {
                LiveFeedPageSdk.liveLog(e5.getMessage());
            }
        }
    }

    public static void f(Context context, String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "zhibopindao_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i);
                if (!vd0.a(str2)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str2);
                }
                if (!vd0.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i2);
                if (!vd0.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4222", jSONObject.toString());
        }
    }

    public static void g(Context context, String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "zhibopindao_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i);
                if (!vd0.a(str2)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str2);
                }
                if (!vd0.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i2);
                if (!vd0.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4221", jSONObject.toString());
        }
    }

    public static void h(Context context, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5) {
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str4);
                jSONObject2.put("request_sanjisubtab", str5);
                jSONObject2.put("request_session_id", str6);
                jSONObject2.put("response_feed_real_num", i3);
                jSONObject2.put("response_feed_num", i2);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("refresh_type", String.valueOf(i4));
                jSONObject2.put("refresh_index", i5);
                if (context != null) {
                    if (qb0.f(context)) {
                        str7 = "0";
                    } else {
                        str7 = "1";
                    }
                    jSONObject2.put("net_status", str7);
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4358", jSONObject.toString());
        }
    }

    public static void t(Context context, String str, String str2, long j, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{context, str, str2, Long.valueOf(j), Integer.valueOf(i), str3, str4, str5, str6, str7, str8, str9}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("request_time", j);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_logid", str4);
                jSONObject2.put("request_resource", str5);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("response_tab_availability", str9);
                }
                if (context != null) {
                    if (qb0.f(context)) {
                        str10 = "0";
                    } else {
                        str10 = "1";
                    }
                    jSONObject2.put("net_status", str10);
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4298", jSONObject.toString());
        }
    }

    public static void i(Context context, String str, String str2, String str3, int i, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "follow_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i);
                jSONObject2.put("bduid", str2);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4223", jSONObject.toString());
        }
    }

    public static void j(Context context, String str, String str2, String str3, int i, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "follow_page");
                if (!vd0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i);
                jSONObject2.put("bduid", str2);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4224", jSONObject.toString());
        }
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            if ("baidu".equals(LiveFeedPageSdk.getInstance().getHost())) {
                return "shoubai";
            }
            if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                return LiveFeedPageSdk.HOST_HAOKAN;
            }
            if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                return LiveFeedPageSdk.HOST_QUANMIN;
            }
            if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                return "tieba";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String n(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            switch (str.hashCode()) {
                case -2042598803:
                    if (str.equals(LiveFeedPageSdk.FOLLOW_VIDEO)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1137617387:
                    if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1333267023:
                    if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1418021314:
                    if (str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                return "zhibopindao";
            }
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        return "zhibopindao";
                    }
                    return "followvideo";
                }
                return "videobar";
            }
            return "chenjinshi";
        }
        return (String) invokeL.objValue;
    }

    public static void p(Context context, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    String str5 = "";
                    if (liveRoomEntity.hostInfo != null) {
                        str5 = liveRoomEntity.hostInfo.uk;
                    }
                    String str6 = "1";
                    if (liveRoomEntity.fromReserve) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject2.put("is_preview", obj);
                    if (!liveRoomEntity.hasInterest) {
                        str6 = "0";
                    }
                    jSONObject2.put("charu", str6);
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str5, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                    c(liveRoomEntity, jSONObject2);
                    jSONObject2.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject3 = new JSONObject();
                    String str7 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str7)) {
                        jSONObject3.put(ExtLogUtil.GR_EXT, new JSONObject(str7));
                    }
                    jSONObject2.put("ext", jSONObject3);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog clk      " + jSONObject.toString());
            a.onEvent("4384", jSONObject.toString());
        }
    }

    public static void y(Context context, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", CriusAttrConstants.DISPLAY);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    String str5 = "";
                    if (liveRoomEntity.hostInfo != null) {
                        str5 = liveRoomEntity.hostInfo.uk;
                    }
                    Object obj2 = "1";
                    if (liveRoomEntity.fromReserve) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject2.put("is_preview", obj);
                    if (!liveRoomEntity.hasInterest) {
                        obj2 = "0";
                    }
                    jSONObject2.put("charu", obj2);
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str5, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                    c(liveRoomEntity, jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject4 = new JSONObject();
                    String str6 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject4.put(ExtLogUtil.GR_EXT, new JSONObject(str6));
                    }
                    jSONObject3.put("ext", jSONObject4);
                    jSONObject3.put("position_changjing ", str2);
                    jSONObject3.put("pos", i);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject2.put("item", jSONArray);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog display      " + jSONObject.toString());
            a.onEvent("4383", jSONObject.toString());
        }
    }

    public static void q(String str, String str2, Boolean bool, LiveRoomEntity liveRoomEntity, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{str, str2, bool, liveRoomEntity, context, Integer.valueOf(i)}) == null) {
            if (liveRoomEntity.needLogShow || !bool.booleanValue()) {
                GrParasmUtil.logGrParam(liveRoomEntity.nid, bool.booleanValue(), !bool.booleanValue());
                String n = n(str);
                if (bool.booleanValue()) {
                    y(context, str2, n, i + 1, liveRoomEntity.belongSubTab, liveRoomEntity.belongThirdTab, liveRoomEntity);
                } else {
                    p(context, str2, n, i + 1, liveRoomEntity.belongSubTab, liveRoomEntity.belongThirdTab, liveRoomEntity);
                }
                liveRoomEntity.needLogShow = false;
            }
        }
    }

    public static void r(Context context, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, long j, long j2, int i3) {
        String str10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                jSONObject2.put("resp_logid", str4);
                jSONObject2.put(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE, str5);
                jSONObject2.put("cache_item", str9);
                jSONObject2.put("cache_cause", i2);
                jSONObject2.put("cache_time", j);
                jSONObject2.put("cache_read_time", j2);
                jSONObject2.put("cache_availability", i3);
                if (context != null) {
                    if (qb0.f(context)) {
                        str10 = "0";
                    } else {
                        str10 = "1";
                    }
                    jSONObject2.put("net_status", str10);
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4359", jSONObject.toString());
        }
    }

    public static Flow s(Context context, boolean z, String str, String str2, String str3, String str4, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3, str4, flow})) == null) {
            if (z) {
                return a.beginFlow("3327");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void u(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65578, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4261", jSONObject.toString());
        }
    }

    public static Flow v(Context context, boolean z, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity, Flow flow) {
        InterceptResult invokeCommon;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{context, Boolean.valueOf(z), str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity, flow})) == null) {
            if (z) {
                return a.beginFlow("4912");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "show");
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    jSONObject2.put("pos", i);
                    jSONObject2.put("kapianshipei", o(liveRoomEntity));
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    if (liveRoomEntity != null) {
                        String str6 = "";
                        if (liveRoomEntity.hostInfo == null) {
                            str5 = "";
                        } else {
                            str5 = liveRoomEntity.hostInfo.uk;
                        }
                        d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str5, jSONObject2);
                        jSONObject2.put("auto_play", liveRoomEntity.autoPlay);
                        if (!TextUtils.isEmpty(liveRoomEntity.beginTime)) {
                            str6 = liveRoomEntity.beginTime;
                        }
                        jSONObject2.put("live_union_id", str6);
                        e(liveRoomEntity.statInfo, jSONObject2);
                        jSONObject2.put("id", liveRoomEntity.nid);
                        JSONObject jSONObject3 = new JSONObject();
                        String str7 = liveRoomEntity.grExt;
                        if (!TextUtils.isEmpty(str7)) {
                            jSONObject3.put(ExtLogUtil.GR_EXT, new JSONObject(str7));
                        }
                        jSONObject2.put("ext", jSONObject3);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }
}

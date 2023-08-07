package com.baidu.tieba.pb.bot;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.bi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.CallRobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J$\u0010\u0017\u001a\u0004\u0018\u00010\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nR&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/pb/bot/BotEntranceManager;", "", "()V", "value", "", "curBotUk", "getCurBotUk", "()Ljava/lang/String;", "setCurBotUk", "(Ljava/lang/String;)V", "", "curSkillId", "getCurSkillId", "()I", "setCurSkillId", "(I)V", "curBotEntrance", "Ltbclient/CallRobotEntrance;", "infoList", "", "Ltbclient/RobotSkillInfo;", "skillList", "Ltbclient/RobotSkill;", "defaultBotSkillInfo", "getUkAndSkillId", "newBotGuideText", "updateUkAndSkillId", "", "botUk", "skillId", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BotEntranceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a c;
    public static final String d = "friend_bot_current_used_uk";
    public static final String e = "friend_bot_current_used_skill_id";
    public static final int f = 3;
    public static final Lazy<BotEntranceManager> g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;

    @JvmStatic
    public static final List<CallRobotEntrance> e(List<RobotSkillInfo> list, List<RobotSkill> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, list2)) == null) ? c.b(list, list2) : (List) invokeLL.objValue;
    }

    public static final BotEntranceManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.c() : (BotEntranceManager) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final BotEntranceManager c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (BotEntranceManager) BotEntranceManager.g.getValue();
            }
            return (BotEntranceManager) invokeV.objValue;
        }

        public final List<RobotSkillInfo> a(List<RobotSkillInfo> list, Map<String, ? extends List<Integer>> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, map)) == null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (map.containsKey(((RobotSkillInfo) obj).robot_uk)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            return (List) invokeLL.objValue;
        }

        @JvmStatic
        public final List<CallRobotEntrance> b(List<RobotSkillInfo> infoList, List<RobotSkill> skillList) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, infoList, skillList)) == null) {
                Intrinsics.checkNotNullParameter(infoList, "infoList");
                Intrinsics.checkNotNullParameter(skillList, "skillList");
                Map<String, List<Integer>> d = d(skillList);
                List<RobotSkillInfo> a = a(infoList, d);
                ArrayList arrayList = new ArrayList();
                for (RobotSkillInfo robotSkillInfo : a) {
                    List<Integer> list = d.get(robotSkillInfo.robot_uk);
                    List<CallRobotEntrance> list2 = robotSkillInfo.robot_skill_list;
                    Intrinsics.checkNotNullExpressionValue(list2, "filterInfo.robot_skill_list");
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list2) {
                        CallRobotEntrance callRobotEntrance = (CallRobotEntrance) obj;
                        if (list != null) {
                            z = list.contains(callRobotEntrance.skill_id);
                        } else {
                            z = false;
                        }
                        if (z) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList.addAll(arrayList2);
                }
                return CollectionsKt___CollectionsKt.take(arrayList, BotEntranceManager.f);
            }
            return (List) invokeLL.objValue;
        }

        public final Map<String, List<Integer>> d(List<RobotSkill> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (RobotSkill robotSkill : list) {
                    String str = robotSkill.robot_uk;
                    Intrinsics.checkNotNullExpressionValue(str, "skill.robot_uk");
                    List<Integer> list2 = robotSkill.skill_ids;
                    Intrinsics.checkNotNullExpressionValue(list2, "skill.skill_ids");
                    linkedHashMap.put(str, list2);
                }
                return linkedHashMap;
            }
            return (Map) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-241071692, "Lcom/baidu/tieba/pb/bot/BotEntranceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-241071692, "Lcom/baidu/tieba/pb/bot/BotEntranceManager;");
                return;
            }
        }
        c = new a(null);
        g = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) BotEntranceManager$Companion$instance$2.INSTANCE);
    }

    public BotEntranceManager() {
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
        this.a = "";
        this.b = -1;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == -1) {
                this.b = SharedPrefHelper.getInstance().getInt(e, -1);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049 A[EDGE_INSN: B:25:0x0049->B:19:0x0049 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CallRobotEntrance c(List<RobotSkillInfo> infoList, List<RobotSkill> skillList) {
        InterceptResult invokeLL;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, infoList, skillList)) == null) {
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            Intrinsics.checkNotNullParameter(skillList, "skillList");
            Iterator<T> it = c.b(infoList, skillList).iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    CallRobotEntrance callRobotEntrance = (CallRobotEntrance) obj;
                    if (TextUtils.equals(f(), callRobotEntrance.ability_conf.bot_uk)) {
                        int g2 = g();
                        Integer num = callRobotEntrance.skill_id;
                        if (num != null && g2 == num.intValue()) {
                            z = true;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    }
                    z = false;
                    continue;
                    if (z) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (CallRobotEntrance) obj;
        }
        return (CallRobotEntrance) invokeLL.objValue;
    }

    public final RobotSkillInfo d(List<RobotSkillInfo> infoList, List<RobotSkill> skillList) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, infoList, skillList)) == null) {
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            Intrinsics.checkNotNullParameter(skillList, "skillList");
            RobotSkill robotSkill = (RobotSkill) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) skillList);
            Object obj = null;
            if (robotSkill != null) {
                str = robotSkill.robot_uk;
            } else {
                str = null;
            }
            Iterator<T> it = infoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (TextUtils.equals(str, ((RobotSkillInfo) next).robot_uk)) {
                    obj = next;
                    break;
                }
            }
            return (RobotSkillInfo) obj;
        }
        return (RobotSkillInfo) invokeLL.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String string = SharedPrefHelper.getInstance().getString(d, "");
                Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…_BOT_CURRENT_USED_UK, \"\")");
                this.a = string;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!bi.isEmpty(f()) && g() != -1) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bot_uk", f());
                    jSONObject.put("skill_id", g());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
                return jSONArray2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String j(List<RobotSkillInfo> list) {
        InterceptResult invokeL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            RobotSkillInfo robotSkillInfo = (RobotSkillInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            if (robotSkillInfo != null) {
                str = robotSkillInfo.new_skill_guide;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void k(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.a = value;
            SharedPrefHelper.getInstance().putString(d, value);
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
            SharedPrefHelper.getInstance().putInt(e, i);
        }
    }

    public final void m(String botUk, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, botUk, i) == null) {
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            k(botUk);
            l(i);
        }
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FloatStrategy;
/* loaded from: classes7.dex */
public class pt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;
        public String b;
        public Integer c;
        public Long d;
        public Long e;
        public Integer f;
        public String g;

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
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final pt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-507067910, "Lcom/baidu/tieba/pt4$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-507067910, "Lcom/baidu/tieba/pt4$c;");
                    return;
                }
            }
            a = new pt4(null);
        }
    }

    public pt4() {
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
        this.a = false;
        this.b = true;
        this.c = false;
    }

    public static pt4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c.a;
        }
        return (pt4) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SharedPrefHelper.getInstance().putLong("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public /* synthetic */ pt4(a aVar) {
        this();
    }

    public final boolean c(dt4 dt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dt4Var)) == null) {
            if (dt4Var == null) {
                return false;
            }
            int x = dt4Var.x();
            if (x != 5 && x != 6 && x != 7 && x != 8) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SharedPrefHelper.getInstance().putString("pref_key_strategy_json", str);
            SharedPrefHelper.getInstance().putInt("pref_key_float_tip_num", 0);
        }
    }

    public void h(dt4 dt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, dt4Var) == null) && dt4Var != null && c(dt4Var)) {
            SharedPrefHelper.getInstance().putLong("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public final void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, bVar, z) != null) || bVar == null) {
            return;
        }
        try {
            if (!this.a) {
                return;
            }
            boolean z2 = SharedPrefHelper.getInstance().getBoolean("pref_key_task_first_open", true);
            int i = SharedPrefHelper.getInstance().getInt("pref_key_float_tip_num", 0);
            long j = SharedPrefHelper.getInstance().getLong("pref_key_new_task_complete_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (z2) {
                if (e(bVar)) {
                    this.c = true;
                    SharedPrefHelper.getInstance().putBoolean("pref_key_task_first_open", false);
                }
            } else if (!d(bVar, currentTimeMillis / 1000, j / 1000)) {
            } else {
                if (z) {
                    if (e(bVar)) {
                        this.c = true;
                        SharedPrefHelper.getInstance().putInt("pref_key_float_tip_num", 0);
                    }
                } else if (i < bVar.f.intValue() && e(bVar)) {
                    this.c = true;
                    SharedPrefHelper.getInstance().putInt("pref_key_float_tip_num", i + 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean d(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.b) && bVar.d.longValue() < bVar.e.longValue() && j >= bVar.d.longValue() && j <= bVar.e.longValue() && bVar.f.intValue() > 0 && bVar.a.intValue() >= 0 && j > j2) {
                String[] split = bVar.b.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        if ("3".equals(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
                long intValue = bVar.a.intValue() * 86400;
                long j3 = j - j2;
                if (j3 > intValue && j3 < intValue + 86400) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921409, bVar), Boolean.class);
            if (runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean)) {
                return ((Boolean) runTask.getData()).booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(cu4 cu4Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, cu4Var) == null) && cu4Var != null && cu4Var.a() != null && cu4Var.a().size() > 0) {
            ArrayList<FloatStrategy> a2 = cu4Var.a();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<FloatStrategy> it = a2.iterator();
            while (true) {
                if (it.hasNext()) {
                    FloatStrategy next = it.next();
                    if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                        bVar = new b();
                        bVar.b = next.browsetimepage;
                        bVar.c = next.duration;
                        bVar.f = next.show_num;
                        bVar.d = next.show_time_begin;
                        bVar.e = next.show_time_end;
                        bVar.g = next.toast;
                        bVar.a = next.un_do_mission;
                        break;
                    }
                } else {
                    bVar = null;
                    break;
                }
            }
            if (bVar == null) {
                f("");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("un_do_mission", bVar.a.intValue());
                jSONObject.put("browsetimepage", bVar.b);
                jSONObject.put("duration", bVar.c.intValue());
                jSONObject.put("show_time_begin", bVar.d.longValue());
                jSONObject.put("show_time_end", bVar.e.longValue());
                jSONObject.put("show_num", bVar.f.intValue());
                jSONObject.put("toast", bVar.g);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    f("");
                    return;
                }
                if (!jSONObject2.equals(SharedPrefHelper.getInstance().getString("pref_key_strategy_json", null))) {
                    f(jSONObject2);
                }
                a(bVar, true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (!z || !this.b) {
                return;
            }
            this.b = false;
            if (this.c || !et4.w().s()) {
                return;
            }
            String string = SharedPrefHelper.getInstance().getString("pref_key_strategy_json", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                b bVar = new b();
                bVar.a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                bVar.b = jSONObject.optString("browsetimepage", "");
                bVar.c = Integer.valueOf(jSONObject.optInt("duration", 0));
                bVar.d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                bVar.e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                bVar.f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                bVar.g = jSONObject.optString("toast", null);
                a(bVar, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

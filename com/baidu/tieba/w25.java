package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.PushPermissionDialogViewV2;
import com.baidu.tieba.au4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class w25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v25 a;

        public a(v25 v25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v25Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ au4 c;

        public b(zo4 zo4Var, int i, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo4Var, Integer.valueOf(i), au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo4Var;
            this.b = i;
            this.c = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zo4 zo4Var = this.a;
                if (zo4Var != null) {
                    zo4Var.a();
                }
                w25.d(this.b, true);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ au4 c;

        public c(zo4 zo4Var, int i, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo4Var, Integer.valueOf(i), au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo4Var;
            this.b = i;
            this.c = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zo4 zo4Var = this.a;
                if (zo4Var != null) {
                    zo4Var.onCancelClick();
                }
                w25.d(this.b, false);
                this.c.dismiss();
            }
        }
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 2 ? "im" : i == 3 ? "reply_message_bar" : i == 6 ? "at_message_bar" : i == 7 ? "agree_message_bar" : i == 8 ? "fan_message_bar" : i == 4 ? "forum_sign" : i == 5 ? "sign" : "default" : (String) invokeI.objValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 2) {
                return 12;
            }
            if (i == 3) {
                return 11;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 5) {
                return 5;
            }
            if (i == 6) {
                return 15;
            }
            if (i == 7) {
                return 14;
            }
            return i == 8 ? 16 : 0;
        }
        return invokeI.intValue;
    }

    public static void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TiebaStatic.log(new StatisticItem("c13673").param("obj_type", z ? 1 : 2).param("obj_source", c(i)));
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", c(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Map<String, String> f(String str) {
        InterceptResult invokeL;
        char c2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashMap hashMap = new HashMap();
            String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7d);
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3364:
                    if (str.equals("im")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f79);
            } else if (c2 == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7a);
            } else if (c2 == 2 || c2 == 3) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7c);
            } else if (c2 != 4) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f78);
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7b);
            }
            f15 f15Var = null;
            e15 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                f15Var = pushStrategyConfig.c(str);
            }
            if (f15Var != null && !TextUtils.isEmpty(f15Var.c())) {
                string2 = f15Var.c();
            }
            if (f15Var != null && !TextUtils.isEmpty(f15Var.b())) {
                string = f15Var.b();
            }
            hashMap.put("view_params_key_title", string2);
            hashMap.put("view_params_key_desc", string);
            hashMap.put("view_params_key_source", str);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(Context context, int i) {
        InterceptResult invokeLI;
        Date date;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            e15 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            int b2 = (pushStrategyConfig == null || !pushStrategyConfig.d()) ? 0 : pushStrategyConfig.b();
            if (b2 <= 0) {
                b2 = 7;
            }
            Date date2 = new Date(bx4.k().m("push_permission_dialog_scene_cold_start_key", 0L));
            Date date3 = new Date(bx4.k().m("push_permission_dialog_scene_interaction_key", 0L));
            Date date4 = new Date(bx4.k().m("push_permission_dialog_scene_push_sign_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date5 = new Date(currentTimeMillis);
            if (i == 0) {
                date = date2;
                if (TimeHelper.getDayDifference(date5, date3) >= b2 && !TimeHelper.isSameDay(date5, date)) {
                    z = true;
                    if (i != 1) {
                        z2 = z;
                        if (TimeHelper.getDayDifference(date5, date) >= b2 && !TimeHelper.isSameDay(date5, date3)) {
                            z3 = true;
                            if (i != 4 || i == 5) {
                                z4 = z3;
                                if (TimeHelper.getDayDifference(date5, date4) >= b2 && !TimeHelper.isSameDay(date5, date4)) {
                                    z5 = true;
                                    if (z5) {
                                        if (i == 0) {
                                            bx4.k().x("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                                        } else if (i == 1) {
                                            bx4.k().x("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                                        } else if (i == 4 || i == 5) {
                                            bx4.k().x("push_permission_dialog_scene_push_sign_key", currentTimeMillis);
                                        }
                                    }
                                    return z5;
                                }
                            } else {
                                z4 = z3;
                            }
                            z5 = z4;
                            if (z5) {
                            }
                            return z5;
                        }
                    } else {
                        z2 = z;
                    }
                    z3 = z2;
                    if (i != 4) {
                    }
                    z4 = z3;
                    if (TimeHelper.getDayDifference(date5, date4) >= b2) {
                        z5 = true;
                        if (z5) {
                        }
                        return z5;
                    }
                    z5 = z4;
                    if (z5) {
                    }
                    return z5;
                }
            } else {
                date = date2;
            }
            z = false;
            if (i != 1) {
            }
            z3 = z2;
            if (i != 4) {
            }
            z4 = z3;
            if (TimeHelper.getDayDifference(date5, date4) >= b2) {
            }
            z5 = z4;
            if (z5) {
            }
            return z5;
        }
        return invokeLI.booleanValue;
    }

    public static v25 h(TbPageContext<?> tbPageContext, Map<String, String> map, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{tbPageContext, map, Long.valueOf(j)})) == null) {
            if (tbPageContext == null || map == null) {
                return null;
            }
            v25 v25Var = new v25(tbPageContext, map);
            if (j <= 0) {
                v25Var.x();
            } else {
                gh.a().postDelayed(new a(v25Var), j);
            }
            return v25Var;
        }
        return (v25) invokeCommon.objValue;
    }

    public static v25 i(TbPageContext<?> tbPageContext, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, str, Long.valueOf(j)})) == null) ? j(tbPageContext, str, j, null) : (v25) invokeCommon.objValue;
    }

    public static v25 j(TbPageContext<?> tbPageContext, String str, long j, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, str, Long.valueOf(j), map})) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            Map<String, String> f = f(str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    f.put(entry.getKey(), entry.getValue());
                }
            }
            boolean areNotificationsEnabled = NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -485371922:
                    if (str.equals("homepage")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3530173:
                    if (str.equals("sign")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 949444906:
                    if (str.equals("collect")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (UbsABTestHelper.isPushOpenPlan3() || areNotificationsEnabled) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                case 1:
                    boolean y = x15.d().y();
                    if (areNotificationsEnabled && y) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                case 2:
                case 3:
                    return null;
                case 4:
                    return h(tbPageContext, f, j);
                case 5:
                    return h(tbPageContext, f, j);
                case 6:
                    if (areNotificationsEnabled) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
        }
        return (v25) invokeCommon.objValue;
    }

    public static void k(TbPageContext<?> tbPageContext, int i, zo4 zo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65546, null, tbPageContext, i, zo4Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        au4 au4Var = new au4(tbPageContext.getPageActivity());
        au4Var.setCancelable(false);
        au4Var.setPositiveButton((String) null, (au4.e) null);
        au4Var.setNegativeButton((String) null, (au4.e) null);
        au4Var.setContentViewSize(7);
        PushPermissionDialogViewV2 pushPermissionDialogViewV2 = new PushPermissionDialogViewV2(tbPageContext.getPageActivity());
        Map<String, String> f = f(b(i));
        pushPermissionDialogViewV2.setTitle(f.get("view_params_key_title"));
        pushPermissionDialogViewV2.setDescription(f.get("view_params_key_desc"));
        au4Var.setContentView(pushPermissionDialogViewV2);
        if (pushPermissionDialogViewV2.getConfirmButton() != null) {
            pushPermissionDialogViewV2.getConfirmButton().setOnClickListener(new b(zo4Var, i, au4Var));
        }
        if (pushPermissionDialogViewV2.getCancelButton() != null) {
            pushPermissionDialogViewV2.getCancelButton().setOnClickListener(new c(zo4Var, i, au4Var));
        }
        au4Var.create(tbPageContext).show();
        e(i);
    }

    public static void l(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, activity) == null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(true);
            bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f74));
            bdTopToast.i((ViewGroup) findViewById);
        }
    }
}

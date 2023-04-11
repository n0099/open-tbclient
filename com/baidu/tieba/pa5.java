package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.PushPermissionDialogViewV2;
import com.baidu.tieba.c05;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class pa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 2 ? "im" : i == 3 ? "reply_message_bar" : i == 6 ? "at_message_bar" : i == 7 ? "agree_message_bar" : i == 8 ? "fan_message_bar" : i == 4 ? "forum_sign" : i == 5 ? "sign" : i == 10 ? "user_follow" : "default" : (String) invokeI.objValue;
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
            if (i == 8) {
                return 16;
            }
            return i == 10 ? 17 : 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa5 a;

        public a(oa5 oa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ c05 c;

        public b(vu4 vu4Var, int i, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu4Var, Integer.valueOf(i), c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu4Var;
            this.b = i;
            this.c = c05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vu4 vu4Var = this.a;
                if (vu4Var != null) {
                    vu4Var.a();
                }
                pa5.d(this.b, true);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ c05 c;

        public c(vu4 vu4Var, int i, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu4Var, Integer.valueOf(i), c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu4Var;
            this.b = i;
            this.c = c05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vu4 vu4Var = this.a;
                if (vu4Var != null) {
                    vu4Var.onCancelClick();
                }
                pa5.d(this.b, false);
                this.c.dismiss();
            }
        }
    }

    public static void d(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int c2 = c(i);
            StatisticItem statisticItem = new StatisticItem("c13673");
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("obj_source", c2));
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
            String string2 = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_title);
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
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2 && c2 != 3) {
                        if (c2 != 4) {
                            string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc);
                        } else {
                            string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_msg);
                        }
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_reply);
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_bar_sign);
                }
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_bar_attention);
            }
            u85 u85Var = null;
            t85 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                u85Var = pushStrategyConfig.c(str);
            }
            if (u85Var != null && !TextUtils.isEmpty(u85Var.c())) {
                string2 = u85Var.c();
            }
            if (u85Var != null && !TextUtils.isEmpty(u85Var.b())) {
                string = u85Var.b();
            }
            hashMap.put("view_params_key_title", string2);
            hashMap.put("view_params_key_desc", string);
            hashMap.put("view_params_key_source", str);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
        if (com.baidu.tbadk.core.util.TimeHelper.isSameDay(r12, r7) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(Context context, int i) {
        InterceptResult invokeLI;
        int i2;
        Date date;
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            t85 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                i2 = pushStrategyConfig.b();
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                i2 = 7;
            }
            Date date2 = new Date(p45.m().o("push_permission_dialog_scene_cold_start_key", 0L));
            Date date3 = new Date(p45.m().o("push_permission_dialog_scene_interaction_key", 0L));
            Date date4 = new Date(p45.m().o("push_permission_dialog_scene_push_sign_key", 0L));
            Date date5 = null;
            if (UbsABTestHelper.isPushPermissionForumFollowTestA() || UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                date5 = new Date(p45.m().o("push_permission_dialog_scene_interaction_forum_follow_key", 0L));
            }
            long currentTimeMillis = System.currentTimeMillis();
            Date date6 = new Date(currentTimeMillis);
            if (i == 11 && date5 != null) {
                if (UbsABTestHelper.isPushPermissionForumFollowTestA() && TimeHelper.getDayDifference(date6, date5) >= i2 && !TimeHelper.isSameDay(date6, date2)) {
                    date = date2;
                } else if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                    date = date2;
                    if (TimeHelper.getDayDifference(date6, date5) >= i2) {
                        if (!TimeHelper.isSameDay(date6, date)) {
                        }
                    }
                    z = false;
                    if (i == 0) {
                        z2 = z;
                        str = "push_permission_dialog_scene_cold_start_key";
                        if (TimeHelper.getDayDifference(date6, date3) >= i2 && !TimeHelper.isSameDay(date6, date)) {
                            if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                                if (date5 != null && TimeHelper.isSameDay(date6, date5)) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                                z3 = z7;
                            } else {
                                z3 = true;
                            }
                            if (i != 1) {
                                z4 = z3;
                                if (TimeHelper.getDayDifference(date6, date) >= i2 && !TimeHelper.isSameDay(date6, date3)) {
                                    z5 = true;
                                    if (i == 4 && i != 5) {
                                        z6 = z5;
                                    } else {
                                        z6 = z5;
                                        if (TimeHelper.getDayDifference(date6, date4) >= i2 && !TimeHelper.isSameDay(date6, date4)) {
                                            z6 = true;
                                        }
                                    }
                                    if (z6) {
                                        if (i != 0) {
                                            if (i != 1) {
                                                if (i != 4 && i != 5) {
                                                    if (i == 11) {
                                                        p45.m().A("push_permission_dialog_scene_interaction_forum_follow_key", currentTimeMillis);
                                                    }
                                                } else {
                                                    p45.m().A("push_permission_dialog_scene_push_sign_key", currentTimeMillis);
                                                }
                                            } else {
                                                p45.m().A(str, currentTimeMillis);
                                            }
                                        } else {
                                            p45.m().A("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                                        }
                                    }
                                    return z6;
                                }
                            } else {
                                z4 = z3;
                            }
                            z5 = z4;
                            if (i == 4) {
                            }
                            z6 = z5;
                            if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                                z6 = true;
                            }
                            if (z6) {
                            }
                            return z6;
                        }
                    } else {
                        z2 = z;
                        str = "push_permission_dialog_scene_cold_start_key";
                    }
                    z3 = z2;
                    if (i != 1) {
                    }
                    z5 = z4;
                    if (i == 4) {
                    }
                    z6 = z5;
                    if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                    }
                    if (z6) {
                    }
                    return z6;
                }
                z = true;
                if (i == 0) {
                }
                z3 = z2;
                if (i != 1) {
                }
                z5 = z4;
                if (i == 4) {
                }
                z6 = z5;
                if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                }
                if (z6) {
                }
                return z6;
            }
            date = date2;
            z = false;
            if (i == 0) {
            }
            z3 = z2;
            if (i != 1) {
            }
            z5 = z4;
            if (i == 4) {
            }
            z6 = z5;
            if (TimeHelper.getDayDifference(date6, date4) >= i2) {
            }
            if (z6) {
            }
            return z6;
        }
        return invokeLI.booleanValue;
    }

    public static void h(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity, 3000);
        bdTopToast.h(true);
        bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.add_group_success_toast));
        bdTopToast.i((ViewGroup) findViewById);
    }

    public static void i(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity, 3000);
        bdTopToast.h(true);
        bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.delete_group_success_toast));
        bdTopToast.i((ViewGroup) findViewById);
    }

    public static void o(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity, 3000);
        bdTopToast.h(true);
        bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.push_permission_dialog_open_success_toast));
        bdTopToast.i((ViewGroup) findViewById);
    }

    public static oa5 j(TbPageContext<?> tbPageContext, Map<String, String> map, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, map, Long.valueOf(j)})) == null) {
            if (tbPageContext != null && map != null) {
                oa5 oa5Var = new oa5(tbPageContext, map);
                if (j <= 0) {
                    oa5Var.x();
                } else {
                    jg.a().postDelayed(new a(oa5Var), j);
                }
                return oa5Var;
            }
            return null;
        }
        return (oa5) invokeCommon.objValue;
    }

    public static oa5 k(TbPageContext<?> tbPageContext, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{tbPageContext, str, Long.valueOf(j)})) == null) {
            return l(tbPageContext, str, j, null);
        }
        return (oa5) invokeCommon.objValue;
    }

    public static void m(TbPageContext<?> tbPageContext, int i, vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, null, tbPageContext, i, vu4Var) == null) {
            n(tbPageContext, tbPageContext.getPageActivity(), i, vu4Var);
        }
    }

    public static oa5 l(TbPageContext<?> tbPageContext, String str, long j, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{tbPageContext, str, Long.valueOf(j), map})) == null) {
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
                    if (str.equals(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3530173:
                    if (str.equals("sign")) {
                        c2 = 1;
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
                    boolean A = o95.d().A();
                    if (areNotificationsEnabled && A) {
                        return null;
                    }
                    return j(tbPageContext, f, j);
                case 1:
                case 2:
                case 3:
                    return null;
                case 4:
                case 5:
                    return j(tbPageContext, f, j);
                case 6:
                    if (areNotificationsEnabled) {
                        return null;
                    }
                    return j(tbPageContext, f, j);
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
        }
        return (oa5) invokeCommon.objValue;
    }

    public static void n(TbPageContext<?> tbPageContext, Activity activity, int i, vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65549, null, tbPageContext, activity, i, vu4Var) == null) && activity != null && tbPageContext != null) {
            c05 c05Var = new c05(activity);
            c05Var.setCancelable(false);
            c05Var.setPositiveButton((String) null, (c05.e) null);
            c05Var.setNegativeButton((String) null, (c05.e) null);
            c05Var.setContentViewSize(7);
            PushPermissionDialogViewV2 pushPermissionDialogViewV2 = new PushPermissionDialogViewV2(activity);
            Map<String, String> f = f(b(i));
            pushPermissionDialogViewV2.setTitle(f.get("view_params_key_title"));
            pushPermissionDialogViewV2.setDescription(f.get("view_params_key_desc"));
            c05Var.setContentView(pushPermissionDialogViewV2);
            if (pushPermissionDialogViewV2.getConfirmButton() != null) {
                pushPermissionDialogViewV2.getConfirmButton().setOnClickListener(new b(vu4Var, i, c05Var));
            }
            if (pushPermissionDialogViewV2.getCancelButton() != null) {
                pushPermissionDialogViewV2.getCancelButton().setOnClickListener(new c(vu4Var, i, c05Var));
            }
            c05Var.create(tbPageContext).show();
            e(i);
        }
    }
}

package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n95 {
    public static /* synthetic */ Interceptable $ic;
    public static n95 q;
    public static Date r;
    public static Handler s;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public y95 j;
    public y95 k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;

    public int C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 12 || i == 13 || i == 28) {
                return 2;
            }
            if (i != 29) {
                if (i != 2000) {
                    switch (i) {
                        case 15:
                        case 18:
                        case 19:
                            return 2;
                        case 16:
                        case 17:
                            return 1;
                        default:
                            switch (i) {
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                    return 3;
                                default:
                                    return 0;
                            }
                    }
                }
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public final void T(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, newsNotifyMessage) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                n95.h0().V(n95.h0().B());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957311, "Lcom/baidu/tieba/n95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957311, "Lcom/baidu/tieba/n95;");
                return;
            }
        }
        s = new a();
    }

    public static n95 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (q == null) {
                q = new n95();
            }
            return q;
        }
        return (n95) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public y95 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return (y95) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b + this.c + this.d + this.e + this.g + this.h;
        }
        return invokeV.intValue;
    }

    public y95 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (y95) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            NotificationHelper.cancelNotification(this.a, 16);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            NotificationHelper.cancelNotification(this.a, 17);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            NotificationHelper.cancelNotification(this.a, 25);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            NotificationHelper.cancelNotification(this.a, 26);
        }
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return ChatStatusManager.getInst().getIsOpen(6);
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return ChatStatusManager.getInst().getIsOpen(7);
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            NotificationHelper.cancelNotification(this.a, 24);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            NotificationHelper.cancelNotification(this.a, 19);
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            int n = q45.m().n(q45.q("msg_tab_entrance_invitation_answer_unread_num"), 0);
            this.i = n;
            return n;
        }
        return invokeV.intValue;
    }

    public n95() {
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
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new y95();
        this.l = true;
        this.a = TbadkCoreApplication.getInst().getApp();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 29);
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 15);
            NotificationHelper.cancelNotification(this.a, 13);
            NotificationHelper.cancelNotification(this.a, 12);
        }
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!p95.d().E()) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            int i = (calendar.get(11) * 60) + calendar.get(12);
            String[] split = p95.d().h().split(":");
            int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            String[] split2 = p95.d().g().split(":");
            int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
            if (parseInt < parseInt2) {
                if (i < parseInt || i > parseInt2) {
                    return false;
                }
            } else if (parseInt <= parseInt2) {
                return false;
            } else {
                if ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(t());
            newsNotifyMessage.setMsgAtme(u());
            newsNotifyMessage.setMsgBookmark(v());
            newsNotifyMessage.setMsgChat(s());
            newsNotifyMessage.setMsgFans(x());
            newsNotifyMessage.setMsgReplyme(A());
            newsNotifyMessage.setMsgGiftNum(y());
            newsNotifyMessage.setMsgInvitation(z());
            newsNotifyMessage.setMsgPrivateChat(this.j.w());
            newsNotifyMessage.setMsgStrangerChat(this.j.y());
            newsNotifyMessage.setMsgOfficialMerge(this.j.t());
            T(newsNotifyMessage);
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public static boolean M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!"3222425470".equals(str) && !"801001117".equals(str) && !"5044059141".equals(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z) {
                U(0, 0, 0, 0, 0, 0, 0);
                return;
            }
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.g = 0;
            this.f = 0;
            this.i = 0;
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && i >= 0) {
            U(i, this.c, this.d, this.e, this.g, this.f, this.h);
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && i >= 0) {
            U(this.b, this.c, i, this.e, this.g, this.f, this.h);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && i >= 0) {
            U(this.b, this.c, this.d, this.e, this.g, i, this.h);
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && i >= 0) {
            U(this.b, this.c, this.d, i, this.g, this.f, this.h);
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i) == null) && i >= 0) {
            U(this.b, this.c, this.d, this.e, i, this.f, this.h);
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && i >= 0) {
            this.h = i;
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && i >= 0) {
            this.i = i;
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && i >= 0) {
            U(this.b, i, this.d, this.e, this.g, this.f, this.h);
        }
    }

    public void g0(y95 y95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, y95Var) == null) {
            this.j = y95Var;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            NotificationHelper.cancelNotification(this.a, i);
        }
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (r == null) {
                r = new Date();
                return true;
            }
            Date date = new Date();
            if (date.getTime() - r.getTime() < 10000) {
                return false;
            }
            r = date;
            return true;
        }
        return invokeV.booleanValue;
    }

    public Intent K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 14);
            intent.putExtra("group_msg_updates", this.j.o());
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 19);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 18);
            NotificationHelper.cancelNotification(this.a, 30);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return ((((this.j.w() + this.j.j()) + this.j.y()) + this.j.t()) + this.j.s()) - this.j.l();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent F(int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                Set<String> keySet = this.j.h().keySet();
                if (keySet.iterator().hasNext()) {
                    str = keySet.iterator().next();
                    Intent intent = new Intent();
                    if (!UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.a, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.a, DealIntentService.class);
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 5);
                    intent.putExtra("KeyOfNotiId", i);
                    intent.putExtra("agree_me", this.b);
                    intent.putExtra("at_me", this.d);
                    intent.putExtra("reply_me", this.c);
                    intent.putExtra("fans", this.g);
                    intent.putExtra("chat", w());
                    intent.putExtra("group_msg", this.j.j() - this.j.l());
                    intent.putExtra("group_msg_validate", this.j.q());
                    intent.putExtra("group_msg_updates", this.j.n());
                    intent.putExtra("officialbar_msg", this.j.u());
                    intent.putExtra("privateGid", str);
                    intent.putExtra("replyme_jump_scheme", this.o);
                    return intent;
                }
            }
            str = "";
            Intent intent2 = new Intent();
            if (!UtilHelper.isFlyMeOs()) {
            }
            intent2.putExtra(DealIntentService.KEY_CLASS, 5);
            intent2.putExtra("KeyOfNotiId", i);
            intent2.putExtra("agree_me", this.b);
            intent2.putExtra("at_me", this.d);
            intent2.putExtra("reply_me", this.c);
            intent2.putExtra("fans", this.g);
            intent2.putExtra("chat", w());
            intent2.putExtra("group_msg", this.j.j() - this.j.l());
            intent2.putExtra("group_msg_validate", this.j.q());
            intent2.putExtra("group_msg_updates", this.j.n());
            intent2.putExtra("officialbar_msg", this.j.u());
            intent2.putExtra("privateGid", str);
            intent2.putExtra("replyme_jump_scheme", this.o);
            return intent2;
        }
        return (Intent) invokeCommon.objValue;
    }

    public Intent G(y95.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 36);
            intent.putExtra(TiebaStatic.Params.TAB_ID, 1);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            y95 E = E();
            if (E == null) {
                c();
                return;
            }
            HashMap<String, String> a2 = E.a();
            if (a2 != null && !a2.isEmpty()) {
                if (a2.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            y95 E = E();
            if (E == null) {
                e();
            } else if (1 == i) {
                if (E.n() <= 0) {
                    e();
                }
            } else if (2 == i && E.q() <= 0) {
                e();
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            y95 E = E();
            if (E == null) {
                c();
                return;
            }
            HashMap<String, String> h = E.h();
            if (h != null && !h.isEmpty()) {
                if (h.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public Intent H(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 24);
            intent.putExtra("KeyOfNotiId", i);
            intent.putExtra("gift_num", this.h);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                intent.putExtra("un", currentAccount);
                intent.putExtra("name", currentAccountName);
            }
            return intent;
        }
        return (Intent) invokeI.objValue;
    }

    public Intent I(y95.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 27);
            intent.putExtra("uid", aVar.a);
            intent.putExtra("uname", aVar.e);
            intent.putExtra("user_type", aVar.f);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 35);
            intent.putExtra("KeyOfNotiId", i);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                intent.putExtra("un", currentAccount);
                intent.putExtra("name", currentAccountName);
            }
            return intent;
        }
        return (Intent) invokeI.objValue;
    }

    public final boolean N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (L()) {
                return false;
            }
            if (i == 24) {
                return p95.d().A();
            }
            if (i == 29) {
                return p95.d().D();
            }
            if (i == 26) {
                return p95.d().y();
            }
            if (i == 25) {
                return p95.d().v();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void k0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, jSONObject) == null) && jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("replyme_jump_scheme");
                String optString3 = optJSONObject.optString("atme");
                String optString4 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.n = optString;
                    this.o = optString2;
                }
                if (!StringUtils.isNull(optString4) && optInt2 > 0) {
                    this.m = optString4;
                }
                if (!StringUtils.isNull(optString3)) {
                    this.p = optString3;
                }
            }
        }
    }

    public final void O(y95.a aVar, int i) {
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048588, this, aVar, i) != null) || L()) {
            return;
        }
        Intent S = S(aVar);
        if (S != null && S.getDataString() != null && S.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            S.setFlags(276824064);
            NotificationHelper.showNotification(this.a, i, aVar.b, aVar.c, aVar.d, PendingIntent.getActivity(this.a, i, S, 134217728), false);
            return;
        }
        if (S == null) {
            S = I(aVar);
        }
        if (S == null) {
            S = G(aVar);
        }
        if (S == null) {
            return;
        }
        if (UtilHelper.isFlyMeOs()) {
            service = PendingIntent.getActivity(this.a, i, S, 134217728);
        } else {
            service = PendingIntent.getService(this.a, i, S, 134217728);
        }
        i(C(i), i);
        NotificationHelper.showNotification(this.a, i, aVar.b, aVar.c, aVar.d, service, false);
    }

    public final void P(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            Q(i, str, str2, str3, false);
        }
    }

    public final void Q(int i, String str, String str2, String str3, boolean z) {
        Intent F;
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3, Boolean.valueOf(z)}) != null) || !this.l || !N(i)) {
            return;
        }
        if (i == 23 && this.h > 0) {
            F = H(i);
        } else if (i == 26 && this.g > 0) {
            F = J(i);
        } else if (i == 18) {
            F = K();
        } else if (i == 24) {
            F = F(i, z);
            F.putExtra(TiebaStatic.Params.TAB_ID, 1);
            WriteImageActivityConfig.isActivityInStack = true;
        } else if (i != 16 && i != 17 && i != 18) {
            F = F(i, z);
            WriteImageActivityConfig.isActivityInStack = true;
        } else {
            F = F(i, z);
            F.putExtra(TiebaStatic.Params.TAB_ID, 2);
            WriteImageActivityConfig.isActivityInStack = true;
        }
        F.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (UtilHelper.isFlyMeOs()) {
            service = PendingIntent.getActivity(this.a, i, F, 134217728);
        } else {
            service = PendingIntent.getService(this.a, i, F, 134217728);
        }
        i(C(i), i);
        NotificationHelper.showNotification(this.a, i, str, str2, str3, service, false);
    }

    public Intent S(y95.a aVar) {
        InterceptResult invokeL;
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aVar)) == null) {
            if (aVar != null && (h = yz7.n().h(aVar.a, aVar.f)) != null && h.getLast_content() != null) {
                try {
                    String lastTaskId = h.getLastTaskId();
                    String lastServiceId = h.getLastServiceId();
                    JSONArray jSONArray = new JSONArray(h.getLastContentRawData());
                    if (jSONArray.length() != 1) {
                        return null;
                    }
                    String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                    if (StringUtils.isNull(optString)) {
                        return null;
                    }
                    Matcher matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(optString);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (!StringUtils.isNull(group)) {
                            Intent intent = new Intent();
                            if (UtilHelper.isFlyMeOs()) {
                                intent.setClass(this.a, DealIntentActivity.class);
                            } else {
                                intent.setClass(this.a, DealIntentService.class);
                            }
                            intent.putExtra(DealIntentService.KEY_CLASS, 1);
                            intent.putExtra("id", group);
                            intent.putExtra("is_from_push", true);
                            intent.putExtra("key_start_from", 7);
                            intent.putExtra(TbEnum.ParamKey.GID, aVar.a);
                            intent.putExtra("task_id", lastTaskId);
                            intent.putExtra("service_id", lastServiceId);
                            return intent;
                        }
                    } else {
                        if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                            if (optString.contains("open_wb_view=1")) {
                                Intent intent2 = new Intent();
                                if (UtilHelper.isFlyMeOs()) {
                                    intent2.setClass(this.a, DealIntentActivity.class);
                                } else {
                                    intent2.setClass(this.a, DealIntentService.class);
                                }
                                intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                                intent2.putExtra("url", optString.trim());
                                intent2.putExtra("task_id", lastTaskId);
                                intent2.putExtra("service_id", lastServiceId);
                                return intent2;
                            } else if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                                return Intent.parseUri(optString, 1);
                            } else {
                                if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                    Intent intent3 = new Intent();
                                    if (UtilHelper.isFlyMeOs()) {
                                        intent3.setClass(this.a, DealIntentActivity.class);
                                    } else {
                                        intent3.setClass(this.a, DealIntentService.class);
                                    }
                                    intent3.putExtra(DealIntentService.KEY_CLASS, 39);
                                    String paramStr = UrlManager.getParamStr(optString);
                                    if (!TextUtils.isEmpty(paramStr)) {
                                        Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                        if (!paramPair.isEmpty()) {
                                            String str = paramPair.get("tid");
                                            String str2 = paramPair.get("pid");
                                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                                intent3.putExtra("thread_id", str);
                                                intent3.putExtra("post_id", str2);
                                                return intent3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Intent intent4 = new Intent();
                        if (UtilHelper.isFlyMeOs()) {
                            intent4.setClass(this.a, DealIntentActivity.class);
                        } else {
                            intent4.setClass(this.a, DealIntentService.class);
                        }
                        intent4.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent4.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                        intent4.putExtra("task_id", lastTaskId);
                        intent4.putExtra("service_id", lastServiceId);
                        return intent4;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public void U(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (i == this.b && i2 == this.c && i3 == this.d && i4 == this.e && i5 == this.g && i6 == this.f && i7 == this.h) {
                return;
            }
            int i16 = this.b;
            int i17 = 2;
            if (i <= i16 && i2 <= (i14 = this.c) && i3 <= (i15 = this.d) && i4 <= this.e && i5 <= this.g && i6 <= this.f && i7 <= this.h) {
                if (i >= i16 && i2 >= i14 && i3 >= i15) {
                    i8 = 0;
                } else {
                    i8 = 2;
                }
            } else {
                i8 = 1;
            }
            int i18 = this.b;
            int i19 = this.c;
            if (i2 > i19) {
                i9 = 1;
            } else if (i2 < i19) {
                i9 = 2;
            } else {
                i9 = 0;
            }
            int i20 = this.d;
            if (i3 > i20) {
                i10 = 1;
            } else if (i3 < i20) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            if (i4 > this.e) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (i5 > this.g) {
                i12 = 1;
            } else {
                i12 = 0;
            }
            if (i7 > this.h) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.g = i5;
            this.f = i6;
            this.h = i7;
            if (D() <= 0) {
                i8 = 2;
                i9 = 2;
                i10 = 2;
                i11 = 2;
                i12 = 2;
            } else {
                i17 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                a();
                i0(i17, 23);
                i0(i11, 16);
                i0(i8, 17);
                i0(i9, 24);
                i0(i10, 25);
                i0(i12, 26);
            }
        }
    }

    public void V(y95 y95Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, y95Var) != null) || y95Var == null) {
            return;
        }
        this.j = y95Var;
        this.e = (y95Var.j() - y95Var.l()) + y95Var.w() + y95Var.t() + y95Var.s();
        b(y95Var);
        int i = 0;
        if (y95Var.z()) {
            this.k = null;
            s.removeMessages(0);
        }
        if (y95Var.z()) {
            if (p95.d().u() && p95.d().f() > 0) {
                i = y95Var.j() - y95Var.l();
            }
            if (p95.d().w() && p95.d().f() > 0) {
                j = y95Var.w();
            } else {
                j = 0;
            }
            if ((i > 0 || j > 0) && ((i > y95Var.m() - y95Var.l() && i > 0) || j > y95Var.x())) {
                j0(1, 16, y95Var);
            }
            int u = y95Var.u();
            if (u > 0 && u > y95Var.v()) {
                j0(1, 19, y95Var);
            }
            if (y95Var.n() > y95Var.p() || y95Var.q() > y95Var.r()) {
                if (y95Var.n() > y95Var.p() && y95Var.q() == y95Var.r() && l0()) {
                    return;
                }
                if (y95Var.n() == y95Var.p() && y95Var.q() > y95Var.r() && m0()) {
                    return;
                }
                j0(1, 17, y95Var);
            }
        }
    }

    public void W(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (i == this.b && i2 == this.c && i3 == this.d && i4 == this.e && i5 == this.g && this.h == i6) {
                return;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.g = i5;
            this.h = i6;
            a();
            if (D() <= 0) {
                i0(2, 16);
                i0(2, 17);
            }
        }
    }

    public void b(y95 y95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, y95Var) != null) || y95Var == null) {
            return;
        }
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(t());
        newsNotifyMessage.setMsgAtme(u());
        newsNotifyMessage.setMsgBookmark(v());
        newsNotifyMessage.setMsgChat(((((y95Var.w() + y95Var.j()) + y95Var.y()) + y95Var.t()) + y95Var.s()) - y95Var.l());
        newsNotifyMessage.setMsgFans(x());
        newsNotifyMessage.setMsgReplyme(A());
        newsNotifyMessage.setMsgGiftNum(y());
        newsNotifyMessage.setMsgInvitation(z());
        newsNotifyMessage.setMsgPrivateChat(y95Var.w());
        newsNotifyMessage.setMsgStrangerChat(y95Var.y());
        newsNotifyMessage.setMsgOfficialMerge(y95Var.t());
        T(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void i(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            if (1 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 16, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 17, i);
            } else if (2 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 12, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 13, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 15, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 18, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 19, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 28, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 2000, i);
            } else if (3 == j && !UbsABTestHelper.isOnlinePushShowTestA()) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 29, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 23, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 24, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 25, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 26, i);
            }
        }
    }

    public final void i0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i, i2) == null) {
            try {
                if (i == 1) {
                    if (i2 == 23) {
                        if (this.h > 0) {
                            String format = String.format(this.a.getString(R.string.notify_gift), String.valueOf(this.h));
                            P(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.b > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(String.format(this.a.getString(R.string.notify_agree), Integer.valueOf(this.b)));
                            P(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.c > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.c > 1) {
                                sb2.append(PreferencesUtil.LEFT_MOUNT);
                                sb2.append(String.valueOf(this.c));
                                sb2.append(this.a.getString(R.string.notify_unit));
                                sb2.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                            if (this.n != null) {
                                sb2.append(this.n);
                            } else {
                                sb2.append(this.a.getString(R.string.notify_reply));
                            }
                            P(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.d > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.d > 1) {
                                sb3.append(PreferencesUtil.LEFT_MOUNT);
                                sb3.append(String.valueOf(this.d));
                                sb3.append(this.a.getString(R.string.notify_unit));
                                sb3.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                            if (this.p != null) {
                                sb3.append(this.p);
                            } else {
                                sb3.append(this.a.getString(R.string.notify_at));
                            }
                            P(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.g > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(String.format(this.a.getString(R.string.notify_fans), Integer.valueOf(this.g)));
                            P(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 != 16 && p95.d().u()) {
                        p95.d().f();
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.a, 16);
                    NotificationHelper.cancelNotification(this.a, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02ef A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0334 A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0341 A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0(int i, int i2, y95 y95Var) {
        boolean z;
        boolean z2;
        int i3;
        long j;
        boolean z3;
        String e;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048617, this, i, i2, y95Var) != null) || y95Var == null) {
            return;
        }
        boolean z4 = true;
        try {
            if (i == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 23) {
                    if (this.h > 0) {
                        String format = String.format(this.a.getString(R.string.notify_gift), String.valueOf(this.h));
                        P(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.b > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.b > 1) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(String.valueOf(this.b));
                            sb.append(this.a.getString(R.string.notify_unit));
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.m != null) {
                            sb.append(this.m);
                        } else {
                            sb.append(this.a.getString(R.string.notify_agree));
                        }
                        P(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.c > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.c > 1) {
                            sb2.append(PreferencesUtil.LEFT_MOUNT);
                            sb2.append(String.valueOf(this.c));
                            sb2.append(this.a.getString(R.string.notify_unit));
                            sb2.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.n != null) {
                            sb2.append(this.n);
                        } else {
                            sb2.append(this.a.getString(R.string.notify_reply));
                        }
                        P(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.d > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.d > 1) {
                            sb3.append(PreferencesUtil.LEFT_MOUNT);
                            sb3.append(String.valueOf(this.d));
                            sb3.append(this.a.getString(R.string.notify_unit));
                            sb3.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.p != null) {
                            sb3.append(this.p);
                        } else {
                            sb3.append(this.a.getString(R.string.notify_at));
                        }
                        P(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.g > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        if (this.g > 1) {
                            sb4.append(String.format(this.a.getString(R.string.notify_fans_unit), Integer.valueOf(this.g)));
                        }
                        sb4.append(this.a.getString(R.string.notify_fans));
                        P(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16) {
                    if (p95.d().u() && p95.d().f() > 0) {
                        i3 = y95Var.j() - y95Var.l();
                    } else {
                        i3 = 0;
                    }
                    if (p95.d().w() && p95.d().f() > 0) {
                        j = y95Var.w();
                    } else {
                        j = 0;
                    }
                    if (j > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    long j2 = i3 + j;
                    int i4 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                    if (i4 > 0) {
                        stringBuffer.append(String.format(this.a.getString(R.string.notify_chat), Long.valueOf(j2)));
                        Q(16, null, stringBuffer.toString(), stringBuffer.toString(), z3);
                    } else if (i4 == 0) {
                        y95Var.i();
                        y95Var.f();
                        if (j == 1) {
                            String i5 = y95Var.i();
                            e = y95Var.f();
                            str2 = i5 + "：" + e;
                            str = i5;
                        } else if (i3 == 1) {
                            String b = y95Var.b();
                            e = y95Var.e();
                            str = b;
                            str2 = e;
                        } else {
                            return;
                        }
                        if (TextUtils.isEmpty(e)) {
                            stringBuffer.append(String.format(this.a.getString(R.string.notify_chat), Long.valueOf(j2)));
                            str3 = stringBuffer.toString();
                        } else {
                            str3 = e;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str4 = str3;
                        } else {
                            str4 = str2;
                        }
                        Q(16, str, str3, str4, z3);
                    }
                } else if (i2 == 19) {
                    List<y95.a> g = y95Var.g();
                    if (g != null && g.size() != 0) {
                        for (y95.a aVar : g) {
                            if (aVar != null && !StringUtils.isNull(aVar.c) && !hi.isEmpty(aVar.a) && aVar.g > aVar.h && aVar.i == null) {
                                O(aVar, 19);
                            }
                        }
                    }
                } else if (p95.d().u() && p95.d().f() > 0 && y95Var.n() + y95Var.q() > 0) {
                    if (y95Var.n() > 0 && !l0()) {
                        long n = y95Var.n() - y95Var.o();
                        if (n > 0) {
                            stringBuffer.append(String.format(this.a.getString(R.string.notify_updates), Long.valueOf(n)));
                            z = true;
                            z2 = false;
                            if (y95Var.q() <= 0 && !m0()) {
                                if (!z) {
                                    stringBuffer.append(String.format(this.a.getString(R.string.notify_validate), Integer.valueOf(y95Var.q())));
                                } else {
                                    stringBuffer.append(String.format(this.a.getString(R.string.notify_validate_1), Integer.valueOf(y95Var.q())));
                                }
                            } else {
                                z4 = z;
                            }
                            if (z4) {
                                P(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (z2) {
                                P(18, y95Var.d(), y95Var.c(), y95Var.c());
                                return;
                            }
                            return;
                        } else if (y95Var.o() > 0) {
                            z = false;
                            z2 = true;
                            if (y95Var.q() <= 0) {
                            }
                            z4 = z;
                            if (z4) {
                            }
                            if (z2) {
                            }
                        }
                    }
                    z = false;
                    z2 = false;
                    if (y95Var.q() <= 0) {
                    }
                    z4 = z;
                    if (z4) {
                    }
                    if (z2) {
                    }
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.a, 16);
                NotificationHelper.cancelNotification(this.a, 17);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}

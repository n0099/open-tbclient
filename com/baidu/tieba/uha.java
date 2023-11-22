package com.baidu.tieba;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.ScreenLockSyncSwitch;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.tieba.xs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes8.dex */
public class uha {
    public static /* synthetic */ Interceptable $ic;
    public static uha m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<xha> b;
    public xha c;
    public final q0b d;
    public int e;
    public int f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }

        public a(uha uhaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar};
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

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uha a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uha uhaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                this.a.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uha a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uha uhaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                this.a.r(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uha a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(uha uhaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uha a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(uha uhaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof RemindRecommendMessage) || !uha.n()) {
                return;
            }
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours >= 0 && hours <= 7) || hours >= 23) {
                return;
            }
            RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
            if (this.a.d.c()) {
                this.a.p(remindRecommendMessage);
            } else {
                this.a.o(remindRecommendMessage);
            }
            if (remindRecommendMessage.isLocal) {
                TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 2).param("obj_locate", 1));
            } else {
                TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 1).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ uha b;

        public f(uha uhaVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uhaVar;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (!bool.booleanValue() && this.a) {
                    this.b.u();
                    return null;
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uha a;

        public g(uha uhaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public uha() {
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
        this.b = new LinkedList();
        this.c = null;
        this.h = new a(this);
        this.i = new b(this, 0);
        this.j = new c(this, 0);
        this.k = new d(this, 2005016);
        this.l = new e(this, 2001355);
        this.a = TbadkApplication.getInst().getApp();
        MessageManager.getInstance().registerListener(2016004, this.i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012121, this.j);
        MessageManager.getInstance().registerListener(2012123, this.j);
        MessageManager.getInstance().registerListener(this.l);
        this.f = 0;
        this.d = new q0b();
    }

    public void u() {
        xha xhaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<xha> list = this.b;
            if ((list != null && list.size() != 0) || this.c != null) {
                if (!this.d.c() || this.f == 1) {
                    Activity currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        currentActivity.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                    this.h.postDelayed(new g(this), 1000L);
                    List<xha> list2 = this.b;
                    if (list2 != null && list2.size() > 0 && (xhaVar = this.b.get(0)) != null) {
                        TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", xhaVar.m / 100).param("task_id", xhaVar.s));
                    }
                }
            }
        }
    }

    public static uha j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new uha();
            }
            return m;
        }
        return (uha) invokeV.objValue;
    }

    public xha l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (xha) invokeV.objValue;
    }

    public List<xha> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.b);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.clear();
            this.c = null;
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TbadkSettings.getInst().loadInt(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_server_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (aa5.e().j() && aa5.e().A() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(xha xhaVar) {
        List<xha> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, xhaVar) != null) || (list = this.b) == null) {
            return;
        }
        list.add(xhaVar);
    }

    public void h(xha xhaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, xhaVar) != null) || xhaVar == null) {
            return;
        }
        this.b.remove(xhaVar);
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            return matcher.group(1);
        }
        return (String) invokeL.objValue;
    }

    public void q(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            h(e(data));
        }
    }

    public boolean d(ChatMessage chatMessage) {
        InterceptResult invokeL;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (msgType = chatMessage.getMsgType()) != 6 && msgType != 22 && msgType != 23) {
                switch (msgType) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        if (!StringUtils.isNull(chatMessage.getContent()) && !StringUtils.isNull(chatMessage.getUserInfo().getUserName()) && !chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkCoreApplication.getCurrentAccountName())) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public xha e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            xha xhaVar = new xha();
            if (imMessageCenterPojo == null) {
                return xhaVar;
            }
            xhaVar.i = imMessageCenterPojo.getUnread_count();
            xhaVar.j = imMessageCenterPojo.getGid();
            xhaVar.h = imMessageCenterPojo.getCustomGroupType();
            xhaVar.a = imMessageCenterPojo.getGroup_name();
            xhaVar.b = imMessageCenterPojo.getLast_user_name();
            xhaVar.c = imMessageCenterPojo.getNameShow();
            xhaVar.l = imMessageCenterPojo.getLast_content_time();
            xhaVar.e = imMessageCenterPojo.getLast_content();
            xhaVar.s = JavaTypesHelper.toLong(imMessageCenterPojo.getTaskId(), 0L);
            return xhaVar;
        }
        return (xha) invokeL.objValue;
    }

    public xha f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        xs8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            xha xhaVar = new xha();
            xhaVar.i = 0;
            chatMessage.getMsgType();
            xhaVar.h = i;
            xhaVar.b = chatMessage.getUserInfo().getUserName();
            xhaVar.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            xhaVar.m = chatMessage.getMsgId();
            boolean z = true;
            xhaVar.n = true;
            xhaVar.o = true;
            xhaVar.p = 1;
            xhaVar.s = chatMessage.getStatTaskId();
            xhaVar.t = chatMessage.getStatisticsServiceId();
            int i2 = xhaVar.h;
            if (i2 == 2) {
                xhaVar.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo h = ts8.n().h(xhaVar.j, 2);
                if (h != null) {
                    xhaVar.i = h.getUnread_count();
                    xhaVar.l = h.getLast_content_time();
                    if (h.getIsFriend() != 1) {
                        z = false;
                    }
                    xhaVar.o = z;
                    xhaVar.p = h.getFollowStatus();
                }
                xhaVar.a = chatMessage.getUserInfo().getUserName();
                xhaVar.e = kw8.F(chatMessage.getMsgType(), chatMessage.getContent());
                if (xhaVar.o) {
                    if (!aa5.e().x()) {
                        xhaVar.n = false;
                    } else {
                        xhaVar.n = ut8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), xhaVar.j);
                    }
                } else if (!aa5.e().x()) {
                    xhaVar.n = false;
                } else if (!aa5.e().H()) {
                    xhaVar.n = false;
                } else {
                    xhaVar.n = ut8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), xhaVar.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                xhaVar.j = userId;
                if (!"1501754229".equals(userId) && !"2807977073".equals(xhaVar.j)) {
                    return null;
                }
                ImMessageCenterPojo h2 = ts8.n().h(xhaVar.j, 4);
                if (h2 != null) {
                    xhaVar.i = h2.getUnread_count();
                    xhaVar.l = h2.getLast_content_time();
                    if (h2.getIsFriend() != 1) {
                        z = false;
                    }
                    xhaVar.o = z;
                    xhaVar.p = h2.getFollowStatus();
                }
                xhaVar.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<xs8.a> a2 = xs8.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        xhaVar.d = aVar.a;
                        xhaVar.e = aVar.b;
                        xhaVar.f = aVar.c;
                        xhaVar.q = aVar.d;
                        xhaVar.s = aVar.k;
                        xhaVar.t = aVar.l;
                    }
                } else {
                    xhaVar.e = kw8.F(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!aa5.e().p()) {
                    xhaVar.n = false;
                }
            }
            return xhaVar;
        }
        return (xha) invokeLI.objValue;
    }

    public final Intent k(Context context, cy4 cy4Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, cy4Var, str)) == null) {
            if (context == null || cy4Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            if (!str.startsWith(TbConfig.HTTP_PB_PREFIX) && !str.startsWith(TbConfig.HTTPS_PB_PREFIX)) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    String substring = str.substring(str.lastIndexOf(":") + 1);
                    intent.putExtra("class", 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra("class", 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra("class", 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra("class", 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith(NativeConstants.COMPONENT_VOTE)) {
                    intent.putExtra("class", 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra("class", 31);
                    String substring2 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring2.startsWith("pid=")) {
                        str2 = substring2.substring(substring2.lastIndexOf("pid=") + 4);
                    } else if (substring2.startsWith("http://")) {
                        str2 = substring2.substring(substring2.lastIndexOf("p/") + 2);
                    } else {
                        str2 = "";
                    }
                    if (StringUtils.isNull(str2)) {
                        return null;
                    }
                    intent.putExtra("tid", str2);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    return null;
                } else {
                    intent.putExtra("class", 0);
                    intent.putExtra("url", str);
                }
            } else {
                String substring3 = str.substring(str.lastIndexOf("/") + 1);
                intent.putExtra("class", 1);
                intent.putExtra("key_start_from", 7);
                intent.putExtra("id", substring3);
            }
            intent.putExtra("is_notify", true);
            intent.putExtra("link", str);
            intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, cy4Var.c());
            intent.putExtra("task_id", cy4Var.e());
            if (!TextUtils.isEmpty(cy4Var.d())) {
                intent.putExtra("stat", cy4Var.d());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, remindRecommendMessage) != null) || remindRecommendMessage == null) {
            return;
        }
        xha xhaVar = new xha();
        xhaVar.i = 0;
        xhaVar.j = "-1";
        xhaVar.h = 4;
        String str = remindRecommendMessage.name;
        xhaVar.a = str;
        xhaVar.b = str;
        xhaVar.d = remindRecommendMessage.title;
        xhaVar.f = remindRecommendMessage.picture;
        xhaVar.q = remindRecommendMessage.url;
        xhaVar.l = System.currentTimeMillis();
        xhaVar.n = true;
        xhaVar.o = true;
        xhaVar.p = 1;
        xhaVar.s = 0L;
        if (remindRecommendMessage.isLocal) {
            xhaVar.r = "2";
        } else {
            xhaVar.r = "1";
        }
        c(xhaVar);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) && remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent k = k(this.a, new cy4(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
            if (k == null) {
                return;
            }
            PendingIntent service = PendingIntent.getService(this.a, 0, k, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            Context context = this.a;
            String str2 = remindRecommendMessage.name;
            String str3 = remindRecommendMessage.title;
            NotificationHelper.showNotification(context, 2000, str2, str3, str3, service, false);
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    public List<ChatMessage> r(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) {
            if (!(responsedMessage instanceof GroupMsgData)) {
                return null;
            }
            GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
            int customType = groupMsgData.getGroupInfo().getCustomType();
            if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(groupMsgData.getListMessage());
            v(linkedList, customType);
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean t(ChatMessage chatMessage, xha xhaVar) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, xhaVar)) == null) {
            if (xhaVar != null && !StringUtils.isNull(xhaVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(xhaVar.q))) != null && JavaTypesHelper.toInt(paramPair.get("lockWindow"), 0) == 1) {
                long j = xhaVar.s;
                String i = i(xhaVar.q);
                if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.d.c()) {
                    Activity currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                        currentActivity.finish();
                    }
                    chatMessage.setHasRead(true);
                    NotificationHelper.cancelNotification(this.a, 19);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.a, j, i)));
                }
                TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void v(List<ChatMessage> list, int i) {
        xha f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, list, i) == null) && list != null && !list.isEmpty()) {
            boolean z = false;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && d(chatMessage) && (f2 = f(chatMessage, i)) != null && f2.i > 0) {
                    if (!f2.n) {
                        h(f2);
                    } else {
                        if (i == 4) {
                            if (t(chatMessage, f2)) {
                                return;
                            }
                            c(f2);
                        } else {
                            this.c = f2;
                        }
                        arrayList.add(String.valueOf(chatMessage.getUserId()));
                        z = true;
                    }
                }
            }
            ol5.a.a().b(arrayList, new f(this, z));
        }
    }
}

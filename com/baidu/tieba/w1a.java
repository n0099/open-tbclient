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
import com.baidu.tieba.rc8;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class w1a {
    public static /* synthetic */ Interceptable $ic;
    public static w1a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<z1a> b;
    public z1a c;
    public final ika d;
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

        public a(w1a w1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar};
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
        public final /* synthetic */ w1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w1a w1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar, Integer.valueOf(i)};
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
            this.a = w1aVar;
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
        public final /* synthetic */ w1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w1a w1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar, Integer.valueOf(i)};
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
            this.a = w1aVar;
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
        public final /* synthetic */ w1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w1a w1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar, Integer.valueOf(i)};
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
            this.a = w1aVar;
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
        public final /* synthetic */ w1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(w1a w1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar, Integer.valueOf(i)};
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
            this.a = w1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof RemindRecommendMessage) || !w1a.n()) {
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w1a a;

        public f(w1a w1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public w1a() {
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
        this.d = new ika();
    }

    public void u() {
        z1a z1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<z1a> list = this.b;
            if ((list != null && list.size() != 0) || this.c != null) {
                if (!this.d.c() || this.f == 1) {
                    Activity currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        currentActivity.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                    this.h.postDelayed(new f(this), 1000L);
                    List<z1a> list2 = this.b;
                    if (list2 != null && list2.size() > 0 && (z1aVar = this.b.get(0)) != null) {
                        TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", z1aVar.m / 100).param("task_id", z1aVar.s));
                    }
                }
            }
        }
    }

    public static w1a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new w1a();
            }
            return m;
        }
        return (w1a) invokeV.objValue;
    }

    public z1a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (z1a) invokeV.objValue;
    }

    public List<z1a> m() {
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
            if (de5.d().i() && de5.d().z() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(z1a z1aVar) {
        List<z1a> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, z1aVar) != null) || (list = this.b) == null) {
            return;
        }
        list.add(z1aVar);
    }

    public void h(z1a z1aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, z1aVar) != null) || z1aVar == null) {
            return;
        }
        this.b.remove(z1aVar);
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

    public z1a e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            z1a z1aVar = new z1a();
            if (imMessageCenterPojo == null) {
                return z1aVar;
            }
            z1aVar.i = imMessageCenterPojo.getUnread_count();
            z1aVar.j = imMessageCenterPojo.getGid();
            z1aVar.h = imMessageCenterPojo.getCustomGroupType();
            z1aVar.a = imMessageCenterPojo.getGroup_name();
            z1aVar.b = imMessageCenterPojo.getLast_user_name();
            z1aVar.c = imMessageCenterPojo.getNameShow();
            z1aVar.l = imMessageCenterPojo.getLast_content_time();
            z1aVar.e = imMessageCenterPojo.getLast_content();
            z1aVar.s = JavaTypesHelper.toLong(imMessageCenterPojo.getTaskId(), 0L);
            return z1aVar;
        }
        return (z1a) invokeL.objValue;
    }

    public z1a f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        rc8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            z1a z1aVar = new z1a();
            z1aVar.i = 0;
            chatMessage.getMsgType();
            z1aVar.h = i;
            z1aVar.b = chatMessage.getUserInfo().getUserName();
            z1aVar.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            z1aVar.m = chatMessage.getMsgId();
            boolean z = true;
            z1aVar.n = true;
            z1aVar.o = true;
            z1aVar.p = 1;
            z1aVar.s = chatMessage.getStatTaskId();
            z1aVar.t = chatMessage.getStatisticsServiceId();
            int i2 = z1aVar.h;
            if (i2 == 2) {
                z1aVar.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo h = nc8.n().h(z1aVar.j, 2);
                if (h != null) {
                    z1aVar.i = h.getUnread_count();
                    z1aVar.l = h.getLast_content_time();
                    if (h.getIsFriend() != 1) {
                        z = false;
                    }
                    z1aVar.o = z;
                    z1aVar.p = h.getFollowStatus();
                }
                z1aVar.a = chatMessage.getUserInfo().getUserName();
                z1aVar.e = ve8.D(chatMessage.getMsgType(), chatMessage.getContent());
                if (z1aVar.o) {
                    if (!de5.d().w()) {
                        z1aVar.n = false;
                    } else {
                        z1aVar.n = nd8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), z1aVar.j);
                    }
                } else if (!de5.d().w()) {
                    z1aVar.n = false;
                } else if (!de5.d().G()) {
                    z1aVar.n = false;
                } else {
                    z1aVar.n = nd8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), z1aVar.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                z1aVar.j = userId;
                if (!"1501754229".equals(userId) && !"2807977073".equals(z1aVar.j)) {
                    return null;
                }
                ImMessageCenterPojo h2 = nc8.n().h(z1aVar.j, 4);
                if (h2 != null) {
                    z1aVar.i = h2.getUnread_count();
                    z1aVar.l = h2.getLast_content_time();
                    if (h2.getIsFriend() != 1) {
                        z = false;
                    }
                    z1aVar.o = z;
                    z1aVar.p = h2.getFollowStatus();
                }
                z1aVar.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<rc8.a> a2 = rc8.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        z1aVar.d = aVar.a;
                        z1aVar.e = aVar.b;
                        z1aVar.f = aVar.c;
                        z1aVar.q = aVar.d;
                        z1aVar.s = aVar.k;
                        z1aVar.t = aVar.l;
                    }
                } else {
                    z1aVar.e = ve8.D(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!de5.d().o()) {
                    z1aVar.n = false;
                }
            }
            return z1aVar;
        }
        return (z1a) invokeLI.objValue;
    }

    public final Intent k(Context context, r25 r25Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, r25Var, str)) == null) {
            if (context == null || r25Var == null || TextUtils.isEmpty(str)) {
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
            intent.putExtra("message_id", r25Var.c());
            intent.putExtra("task_id", r25Var.e());
            if (!TextUtils.isEmpty(r25Var.d())) {
                intent.putExtra("stat", r25Var.d());
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
        z1a z1aVar = new z1a();
        z1aVar.i = 0;
        z1aVar.j = "-1";
        z1aVar.h = 4;
        String str = remindRecommendMessage.name;
        z1aVar.a = str;
        z1aVar.b = str;
        z1aVar.d = remindRecommendMessage.title;
        z1aVar.f = remindRecommendMessage.picture;
        z1aVar.q = remindRecommendMessage.url;
        z1aVar.l = System.currentTimeMillis();
        z1aVar.n = true;
        z1aVar.o = true;
        z1aVar.p = 1;
        z1aVar.s = 0L;
        if (remindRecommendMessage.isLocal) {
            z1aVar.r = "2";
        } else {
            z1aVar.r = "1";
        }
        c(z1aVar);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) && remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent k = k(this.a, new r25(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
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

    public final boolean t(ChatMessage chatMessage, z1a z1aVar) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, z1aVar)) == null) {
            if (z1aVar != null && !StringUtils.isNull(z1aVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(z1aVar.q))) != null && JavaTypesHelper.toInt(paramPair.get("lockWindow"), 0) == 1) {
                long j = z1aVar.s;
                String i = i(z1aVar.q);
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
        z1a f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, list, i) == null) && list != null && !list.isEmpty()) {
            boolean z = false;
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
                        z = true;
                    }
                }
            }
            if (z) {
                u();
            }
        }
    }
}

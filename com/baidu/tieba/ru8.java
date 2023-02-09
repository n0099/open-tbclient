package com.baidu.tieba;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
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
import com.baidu.tieba.bm7;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
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
/* loaded from: classes6.dex */
public class ru8 {
    public static /* synthetic */ Interceptable $ic;
    public static ru8 m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<uu8> b;
    public uu8 c;
    public final v99 d;
    public int e;
    public int f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }

        public a(ru8 ru8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var};
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

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ru8 ru8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var, Integer.valueOf(i)};
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
            this.a = ru8Var;
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

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ru8 ru8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var, Integer.valueOf(i)};
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
            this.a = ru8Var;
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

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ru8 ru8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var, Integer.valueOf(i)};
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
            this.a = ru8Var;
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

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ru8 ru8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var, Integer.valueOf(i)};
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
            this.a = ru8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof RemindRecommendMessage) || !ru8.n()) {
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

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 a;

        public f(ru8 ru8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ru8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public ru8() {
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
        this.d = new v99();
    }

    public void u() {
        uu8 uu8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<uu8> list = this.b;
            if ((list != null && list.size() != 0) || this.c != null) {
                if (!this.d.c() || this.f == 1) {
                    Activity b2 = t9.f().b();
                    if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        b2.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                    this.h.postDelayed(new f(this), 1000L);
                    List<uu8> list2 = this.b;
                    if (list2 != null && list2.size() > 0 && (uu8Var = this.b.get(0)) != null) {
                        TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", uu8Var.m / 100).param("task_id", uu8Var.s));
                    }
                }
            }
        }
    }

    public static ru8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new ru8();
            }
            return m;
        }
        return (ru8) invokeV.objValue;
    }

    public uu8 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (uu8) invokeV.objValue;
    }

    public List<uu8> m() {
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
            if (m85.d().i() && m85.d().y() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(uu8 uu8Var) {
        List<uu8> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, uu8Var) != null) || (list = this.b) == null) {
            return;
        }
        list.add(uu8Var);
    }

    public void h(uu8 uu8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, uu8Var) != null) || uu8Var == null) {
            return;
        }
        this.b.remove(uu8Var);
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

    public uu8 e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            uu8 uu8Var = new uu8();
            if (imMessageCenterPojo == null) {
                return uu8Var;
            }
            uu8Var.i = imMessageCenterPojo.getUnread_count();
            uu8Var.j = imMessageCenterPojo.getGid();
            uu8Var.h = imMessageCenterPojo.getCustomGroupType();
            uu8Var.a = imMessageCenterPojo.getGroup_name();
            uu8Var.b = imMessageCenterPojo.getLast_user_name();
            uu8Var.c = imMessageCenterPojo.getNameShow();
            uu8Var.l = imMessageCenterPojo.getLast_content_time();
            uu8Var.e = imMessageCenterPojo.getLast_content();
            uu8Var.s = dh.g(imMessageCenterPojo.getTaskId(), 0L);
            return uu8Var;
        }
        return (uu8) invokeL.objValue;
    }

    public uu8 f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        bm7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            uu8 uu8Var = new uu8();
            uu8Var.i = 0;
            chatMessage.getMsgType();
            uu8Var.h = i;
            uu8Var.b = chatMessage.getUserInfo().getUserName();
            uu8Var.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            uu8Var.m = chatMessage.getMsgId();
            boolean z = true;
            uu8Var.n = true;
            uu8Var.o = true;
            uu8Var.p = 1;
            uu8Var.s = chatMessage.getStatTaskId();
            uu8Var.t = chatMessage.getStatisticsServiceId();
            int i2 = uu8Var.h;
            if (i2 == 2) {
                uu8Var.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo h = xl7.n().h(uu8Var.j, 2);
                if (h != null) {
                    uu8Var.i = h.getUnread_count();
                    uu8Var.l = h.getLast_content_time();
                    if (h.getIsFriend() != 1) {
                        z = false;
                    }
                    uu8Var.o = z;
                    uu8Var.p = h.getFollowStatus();
                }
                uu8Var.a = chatMessage.getUserInfo().getUserName();
                uu8Var.e = eo7.B(chatMessage.getMsgType(), chatMessage.getContent());
                if (uu8Var.o) {
                    if (!m85.d().v()) {
                        uu8Var.n = false;
                    } else {
                        uu8Var.n = ym7.j().c(TbadkCoreApplication.getCurrentAccount(), uu8Var.j);
                    }
                } else if (!m85.d().v()) {
                    uu8Var.n = false;
                } else if (!m85.d().F()) {
                    uu8Var.n = false;
                } else {
                    uu8Var.n = ym7.j().c(TbadkCoreApplication.getCurrentAccount(), uu8Var.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                uu8Var.j = userId;
                if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(uu8Var.j)) {
                    return null;
                }
                ImMessageCenterPojo h2 = xl7.n().h(uu8Var.j, 4);
                if (h2 != null) {
                    uu8Var.i = h2.getUnread_count();
                    uu8Var.l = h2.getLast_content_time();
                    if (h2.getIsFriend() != 1) {
                        z = false;
                    }
                    uu8Var.o = z;
                    uu8Var.p = h2.getFollowStatus();
                }
                uu8Var.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<bm7.a> a2 = bm7.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        uu8Var.d = aVar.a;
                        uu8Var.e = aVar.b;
                        uu8Var.f = aVar.c;
                        uu8Var.q = aVar.d;
                        uu8Var.s = aVar.k;
                        uu8Var.t = aVar.l;
                    }
                } else {
                    uu8Var.e = eo7.B(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!m85.d().o()) {
                    uu8Var.n = false;
                }
            }
            return uu8Var;
        }
        return (uu8) invokeLI.objValue;
    }

    public final Intent k(Context context, ry4 ry4Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, ry4Var, str)) == null) {
            if (context == null || ry4Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            if (!str.startsWith(TbConfig.HTTP_PB_PREFIX) && !str.startsWith(TbConfig.HTTPS_PB_PREFIX)) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    String substring = str.substring(str.lastIndexOf(":") + 1);
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith(NativeConstants.COMPONENT_VOTE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 31);
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
                    intent.putExtra(DealIntentService.KEY_CLASS, 0);
                    intent.putExtra("url", str);
                }
            } else {
                String substring3 = str.substring(str.lastIndexOf("/") + 1);
                intent.putExtra(DealIntentService.KEY_CLASS, 1);
                intent.putExtra("key_start_from", 7);
                intent.putExtra("id", substring3);
            }
            intent.putExtra("is_notify", true);
            intent.putExtra("link", str);
            intent.putExtra("message_id", ry4Var.c());
            intent.putExtra("task_id", ry4Var.e());
            if (!TextUtils.isEmpty(ry4Var.d())) {
                intent.putExtra("stat", ry4Var.d());
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
        uu8 uu8Var = new uu8();
        uu8Var.i = 0;
        uu8Var.j = "-1";
        uu8Var.h = 4;
        String str = remindRecommendMessage.name;
        uu8Var.a = str;
        uu8Var.b = str;
        uu8Var.d = remindRecommendMessage.title;
        uu8Var.f = remindRecommendMessage.picture;
        uu8Var.q = remindRecommendMessage.url;
        uu8Var.l = System.currentTimeMillis();
        uu8Var.n = true;
        uu8Var.o = true;
        uu8Var.p = 1;
        uu8Var.s = 0L;
        if (remindRecommendMessage.isLocal) {
            uu8Var.r = "2";
        } else {
            uu8Var.r = "1";
        }
        c(uu8Var);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) && remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent k = k(this.a, new ry4(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
            if (k == null) {
                return;
            }
            PendingIntent service = PendingIntent.getService(this.a, 0, k, 134217728);
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

    public final boolean t(ChatMessage chatMessage, uu8 uu8Var) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, uu8Var)) == null) {
            if (uu8Var != null && !StringUtils.isNull(uu8Var.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(uu8Var.q))) != null && dh.e(paramPair.get("lockWindow"), 0) == 1) {
                long j = uu8Var.s;
                String i = i(uu8Var.q);
                if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.d.c()) {
                    Activity b2 = t9.f().b();
                    if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                        b2.finish();
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
        uu8 f2;
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

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
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.tieba.v98;
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
/* loaded from: classes7.dex */
public class oq9 {
    public static /* synthetic */ Interceptable $ic;
    public static oq9 m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<rq9> b;
    public rq9 c;
    public final z7a d;
    public int e;
    public int f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }

        public a(oq9 oq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var};
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
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(oq9 oq9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var, Integer.valueOf(i)};
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
            this.a = oq9Var;
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(oq9 oq9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var, Integer.valueOf(i)};
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
            this.a = oq9Var;
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(oq9 oq9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var, Integer.valueOf(i)};
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
            this.a = oq9Var;
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

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(oq9 oq9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var, Integer.valueOf(i)};
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
            this.a = oq9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof RemindRecommendMessage) || !oq9.n()) {
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

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq9 a;

        public f(oq9 oq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public oq9() {
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
        this.d = new z7a();
    }

    public void u() {
        rq9 rq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<rq9> list = this.b;
            if ((list != null && list.size() != 0) || this.c != null) {
                if (!this.d.c() || this.f == 1) {
                    Activity b2 = g9.f().b();
                    if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        b2.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                    this.h.postDelayed(new f(this), 1000L);
                    List<rq9> list2 = this.b;
                    if (list2 != null && list2.size() > 0 && (rq9Var = this.b.get(0)) != null) {
                        TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", rq9Var.m / 100).param("task_id", rq9Var.s));
                    }
                }
            }
        }
    }

    public static oq9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new oq9();
            }
            return m;
        }
        return (oq9) invokeV.objValue;
    }

    public rq9 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (rq9) invokeV.objValue;
    }

    public List<rq9> m() {
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
            if (oe5.d().i() && oe5.d().z() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(rq9 rq9Var) {
        List<rq9> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rq9Var) != null) || (list = this.b) == null) {
            return;
        }
        list.add(rq9Var);
    }

    public void h(rq9 rq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, rq9Var) != null) || rq9Var == null) {
            return;
        }
        this.b.remove(rq9Var);
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

    public rq9 e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            rq9 rq9Var = new rq9();
            if (imMessageCenterPojo == null) {
                return rq9Var;
            }
            rq9Var.i = imMessageCenterPojo.getUnread_count();
            rq9Var.j = imMessageCenterPojo.getGid();
            rq9Var.h = imMessageCenterPojo.getCustomGroupType();
            rq9Var.a = imMessageCenterPojo.getGroup_name();
            rq9Var.b = imMessageCenterPojo.getLast_user_name();
            rq9Var.c = imMessageCenterPojo.getNameShow();
            rq9Var.l = imMessageCenterPojo.getLast_content_time();
            rq9Var.e = imMessageCenterPojo.getLast_content();
            rq9Var.s = ug.g(imMessageCenterPojo.getTaskId(), 0L);
            return rq9Var;
        }
        return (rq9) invokeL.objValue;
    }

    public rq9 f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        v98.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            rq9 rq9Var = new rq9();
            rq9Var.i = 0;
            chatMessage.getMsgType();
            rq9Var.h = i;
            rq9Var.b = chatMessage.getUserInfo().getUserName();
            rq9Var.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            rq9Var.m = chatMessage.getMsgId();
            boolean z = true;
            rq9Var.n = true;
            rq9Var.o = true;
            rq9Var.p = 1;
            rq9Var.s = chatMessage.getStatTaskId();
            rq9Var.t = chatMessage.getStatisticsServiceId();
            int i2 = rq9Var.h;
            if (i2 == 2) {
                rq9Var.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo h = r98.n().h(rq9Var.j, 2);
                if (h != null) {
                    rq9Var.i = h.getUnread_count();
                    rq9Var.l = h.getLast_content_time();
                    if (h.getIsFriend() != 1) {
                        z = false;
                    }
                    rq9Var.o = z;
                    rq9Var.p = h.getFollowStatus();
                }
                rq9Var.a = chatMessage.getUserInfo().getUserName();
                rq9Var.e = ac8.D(chatMessage.getMsgType(), chatMessage.getContent());
                if (rq9Var.o) {
                    if (!oe5.d().w()) {
                        rq9Var.n = false;
                    } else {
                        rq9Var.n = sa8.j().c(TbadkCoreApplication.getCurrentAccount(), rq9Var.j);
                    }
                } else if (!oe5.d().w()) {
                    rq9Var.n = false;
                } else if (!oe5.d().G()) {
                    rq9Var.n = false;
                } else {
                    rq9Var.n = sa8.j().c(TbadkCoreApplication.getCurrentAccount(), rq9Var.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                rq9Var.j = userId;
                if (!"1501754229".equals(userId) && !"2807977073".equals(rq9Var.j)) {
                    return null;
                }
                ImMessageCenterPojo h2 = r98.n().h(rq9Var.j, 4);
                if (h2 != null) {
                    rq9Var.i = h2.getUnread_count();
                    rq9Var.l = h2.getLast_content_time();
                    if (h2.getIsFriend() != 1) {
                        z = false;
                    }
                    rq9Var.o = z;
                    rq9Var.p = h2.getFollowStatus();
                }
                rq9Var.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<v98.a> a2 = v98.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        rq9Var.d = aVar.a;
                        rq9Var.e = aVar.b;
                        rq9Var.f = aVar.c;
                        rq9Var.q = aVar.d;
                        rq9Var.s = aVar.k;
                        rq9Var.t = aVar.l;
                    }
                } else {
                    rq9Var.e = ac8.D(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!oe5.d().o()) {
                    rq9Var.n = false;
                }
            }
            return rq9Var;
        }
        return (rq9) invokeLI.objValue;
    }

    public final Intent k(Context context, j35 j35Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, j35Var, str)) == null) {
            if (context == null || j35Var == null || TextUtils.isEmpty(str)) {
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
            intent.putExtra("message_id", j35Var.c());
            intent.putExtra("task_id", j35Var.e());
            if (!TextUtils.isEmpty(j35Var.d())) {
                intent.putExtra("stat", j35Var.d());
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
        rq9 rq9Var = new rq9();
        rq9Var.i = 0;
        rq9Var.j = "-1";
        rq9Var.h = 4;
        String str = remindRecommendMessage.name;
        rq9Var.a = str;
        rq9Var.b = str;
        rq9Var.d = remindRecommendMessage.title;
        rq9Var.f = remindRecommendMessage.picture;
        rq9Var.q = remindRecommendMessage.url;
        rq9Var.l = System.currentTimeMillis();
        rq9Var.n = true;
        rq9Var.o = true;
        rq9Var.p = 1;
        rq9Var.s = 0L;
        if (remindRecommendMessage.isLocal) {
            rq9Var.r = "2";
        } else {
            rq9Var.r = "1";
        }
        c(rq9Var);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) && remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent k = k(this.a, new j35(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
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

    public final boolean t(ChatMessage chatMessage, rq9 rq9Var) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, rq9Var)) == null) {
            if (rq9Var != null && !StringUtils.isNull(rq9Var.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(rq9Var.q))) != null && ug.e(paramPair.get("lockWindow"), 0) == 1) {
                long j = rq9Var.s;
                String i = i(rq9Var.q);
                if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.d.c()) {
                    Activity b2 = g9.f().b();
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
        rq9 f2;
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

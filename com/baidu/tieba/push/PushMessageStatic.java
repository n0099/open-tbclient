package com.baidu.tieba.push;

import android.app.Activity;
import android.media.Ringtone;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.b95;
import com.baidu.tieba.f1a;
import com.baidu.tieba.g1a;
import com.baidu.tieba.h1a;
import com.baidu.tieba.me5;
import com.baidu.tieba.ne5;
import com.baidu.tieba.s1a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PushMessageStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.push.PushMessageStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0459a implements me5.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ringtone a;
            public final /* synthetic */ h1a b;

            public C0459a(a aVar, Ringtone ringtone, h1a h1aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ringtone, h1aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ringtone;
                this.b = h1aVar;
            }

            @Override // com.baidu.tieba.me5.h
            public void dismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Ringtone ringtone = this.a;
                    if (ringtone != null) {
                        ringtone.stop();
                    }
                    h1a h1aVar = this.b;
                    if (h1aVar != null) {
                        h1aVar.l();
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements h1a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ me5 a;

            public b(a aVar, me5 me5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, me5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = me5Var;
            }

            @Override // com.baidu.tieba.h1a.e
            public void a(View view2) {
                me5 me5Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (me5Var = this.a) != null) {
                    me5Var.t();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ PushGeneralData b;

            public c(a aVar, int i, PushGeneralData pushGeneralData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), pushGeneralData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = pushGeneralData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    boolean isOpen = ChatStatusManager.getInst().getIsOpen(0);
                    if (this.a == 4 && isOpen) {
                        return;
                    }
                    if (currentActivity != null) {
                        new f1a(currentActivity, this.b.getForegroundShowData().getExtData(), this.b.getForegroundShowData().getRemindInfo()).t();
                    } else {
                        g1a.c().f(this.b.getForegroundShowData().getExtData(), this.b.getForegroundShowData().getRemindInfo());
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ PushRemindInfo b;
            public final /* synthetic */ PushExtData c;

            public d(a aVar, boolean z, PushRemindInfo pushRemindInfo, PushExtData pushExtData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z), pushRemindInfo, pushExtData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
                this.b = pushRemindInfo;
                this.c = pushExtData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    PushMessageStatic.b(this.a, TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), this.b, this.c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PushGeneralData pushGeneralData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PushGeneralData) && (pushGeneralData = (PushGeneralData) customResponsedMessage.getData()) != null && pushGeneralData.getForegroundShowData() != null && pushGeneralData.getForegroundShowData().getExtData() != null && pushGeneralData.getForegroundShowData().getRemindInfo() != null) {
                PushExtData extData = pushGeneralData.getForegroundShowData().getExtData();
                PushRemindInfo remindInfo = pushGeneralData.getForegroundShowData().getRemindInfo();
                boolean isLiveData = pushGeneralData.getForegroundShowData().isLiveData();
                int type = extData.getType();
                TbPageContext currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
                if (type != 3 && type != 6 && type != 7) {
                    if (type == 1 || type == 2 || type == 4 || type == 5 || type == 8 || type == 9 || type == 10) {
                        SafeHandler.getInst().post(new c(this, type, pushGeneralData));
                    }
                } else {
                    h1a h1aVar = new h1a(currentPageContext);
                    h1aVar.o(pushGeneralData);
                    Ringtone f = s1a.f();
                    me5 f2 = ne5.f(h1aVar.m(), currentPageContext, null, 0L, remindInfo.getShowtime());
                    f2.x(new C0459a(this, f, h1aVar));
                    h1aVar.p(new b(this, f2));
                }
                IdleHandlerManager.getInstance().addOrRunTask("processLiveData", new d(this, isLiveData, remindInfo, extData));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && tbPageContext != null && strArr.length > 0) {
                    String str = strArr[0];
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                        s1a.e(tbPageContext.getContext(), str, true);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                        s1a.a(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                        s1a.d(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                        s1a.b(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                        s1a.c(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_MAIN_PAGE)) {
                        UrlSchemaJumpHelper.jumpGamePlayPage(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                        UrlSchemaJumpHelper.jumpDispatchOrderPage(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_MESSAGE_CENTER_PAGE)) {
                        UrlSchemaJumpHelper.jumpMessageCenterPage(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                        UrlSchemaJumpHelper.jumpUnPaidOrderPage(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_LIST_PAGE)) {
                        UrlSchemaJumpHelper.jumpUnPaidListPage(tbPageContext.getContext(), str);
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-821959961, "Lcom/baidu/tieba/push/PushMessageStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-821959961, "Lcom/baidu/tieba/push/PushMessageStatic;");
                return;
            }
        }
        c();
    }

    public PushMessageStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().registerListener(new a(2921711));
            UrlManager.getInstance().addListener(new b());
        }
    }

    public static void b(boolean z, TbPageContext tbPageContext, PushRemindInfo pushRemindInfo, PushExtData pushExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), tbPageContext, pushRemindInfo, pushExtData}) == null) && pushRemindInfo != null && pushExtData != null && z) {
            YyExtData yyExtData = new YyExtData();
            yyExtData.mSid = pushExtData.getSid();
            yyExtData.mSsid = pushExtData.getSsid();
            yyExtData.mTemplateId = pushExtData.getTemplateId();
            yyExtData.mYyUid = pushExtData.getYyUid();
            yyExtData.mRankShow = pushExtData.getRankShow();
            yyExtData.isYyGame = pushExtData.getIsYyGame();
            yyExtData.mIconUrl = pushExtData.getIconUrl();
            yyExtData.streamInfo = pushExtData.getStreamInfo();
            HashMap hashMap = new HashMap();
            hashMap.put("view_top_params_key_schema", pushRemindInfo.getScheme());
            hashMap.put("view_top_params_key_image_url", pushRemindInfo.getImage());
            hashMap.put("view_top_params_key_title", pushRemindInfo.getTitle());
            hashMap.put("view_top_params_key_desc", pushRemindInfo.getDesc());
            hashMap.put("view_top_params_is_breathe", Boolean.valueOf(pushRemindInfo.getIsBreathe()));
            hashMap.put("view_top_params_btn_text", pushRemindInfo.getBtnText());
            hashMap.put("view_top_params_key_nid", pushExtData.getRoomId());
            hashMap.put("view_top_params_key_yyext", yyExtData);
            hashMap.put("view_top_params_key_type", 1);
            hashMap.put("view_top_params_room_id", pushExtData.getLiveId());
            if (ne5.f(null, tbPageContext, hashMap, 0L, pushRemindInfo.getShowtime()) != null) {
                ne5.e();
                TbSingleton.getInstance().setIsNeedRemindLiveRoom(false);
                b95.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
            }
        }
    }
}

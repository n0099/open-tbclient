package com.baidu.tieba.push;

import android.app.Activity;
import android.media.Ringtone;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
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
import com.baidu.tieba.gu4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jz4;
import com.baidu.tieba.ma8;
import com.baidu.tieba.na8;
import com.baidu.tieba.oa8;
import com.baidu.tieba.sg;
import com.baidu.tieba.z8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PushMessageStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.push.PushMessageStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0382a implements iz4.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ringtone a;
            public final /* synthetic */ na8 b;

            public C0382a(a aVar, Ringtone ringtone, na8 na8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ringtone, na8Var};
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
                this.b = na8Var;
            }

            @Override // com.baidu.tieba.iz4.h
            public void dismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Ringtone ringtone = this.a;
                    if (ringtone != null) {
                        ringtone.stop();
                    }
                    na8 na8Var = this.b;
                    if (na8Var != null) {
                        na8Var.l();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements na8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ iz4 a;

            public b(a aVar, iz4 iz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iz4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iz4Var;
            }

            @Override // com.baidu.tieba.na8.e
            public void a(View view2) {
                iz4 iz4Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (iz4Var = this.a) == null) {
                    return;
                }
                iz4Var.t();
            }
        }

        /* loaded from: classes5.dex */
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
                    if ((this.a == 4 && isOpen) || currentActivity == null) {
                        return;
                    }
                    new ma8(currentActivity, this.b.getForegroundShowData().getExtData(), this.b.getForegroundShowData().getRemindInfo()).s();
                }
            }
        }

        /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PushGeneralData) || (pushGeneralData = (PushGeneralData) customResponsedMessage.getData()) == null || pushGeneralData.getForegroundShowData() == null || pushGeneralData.getForegroundShowData().getExtData() == null || pushGeneralData.getForegroundShowData().getRemindInfo() == null) {
                return;
            }
            PushExtData extData = pushGeneralData.getForegroundShowData().getExtData();
            PushRemindInfo remindInfo = pushGeneralData.getForegroundShowData().getRemindInfo();
            boolean isLiveData = pushGeneralData.getForegroundShowData().isLiveData();
            int type = extData.getType();
            TbPageContext currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
            if (type == 3 || type == 6 || type == 7) {
                na8 na8Var = new na8(currentPageContext);
                na8Var.o(pushGeneralData);
                Ringtone f = oa8.f();
                iz4 e = jz4.e(na8Var.m(), currentPageContext, null, 0L, remindInfo.getShowtime());
                e.x(new C0382a(this, f, na8Var));
                na8Var.p(new b(this, e));
            } else if (type == 1 || type == 2 || type == 4 || type == 5 || type == 8 || type == 9) {
                sg.a().post(new c(this, type, pushGeneralData));
            }
            String simpleName = z8.g().b() != null ? z8.g().b().getClass().getSimpleName() : "";
            if (System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime >= 10000 || TbadkCoreApplication.getInst().getStartType() != 2 || (!TextUtils.equals("MainTabActivity", simpleName) && !TextUtils.equals("LogoActivity", simpleName))) {
                PushMessageStatic.b(isLiveData, currentPageContext, remindInfo, extData);
            } else {
                sg.a().postDelayed(new d(this, isLiveData, remindInfo, extData), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements UrlManager.UrlDealListener {
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
                        oa8.e(tbPageContext.getContext(), str, true);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                        oa8.a(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                        oa8.d(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                        oa8.b(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                        oa8.c(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_MAIN_PAGE)) {
                        UrlSchemaJumpHelper.jumpGamePlayPage(tbPageContext.getContext(), str);
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

    public static void b(boolean z, TbPageContext tbPageContext, PushRemindInfo pushRemindInfo, PushExtData pushExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), tbPageContext, pushRemindInfo, pushExtData}) == null) && pushRemindInfo != null && pushExtData != null && z && gu4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
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
            if (jz4.e(null, tbPageContext, hashMap, 0L, pushRemindInfo.getShowtime()) != null) {
                jz4.d();
                TbSingleton.getInstance().setIsNeedRemindLiveRoom(false);
                gu4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
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
}

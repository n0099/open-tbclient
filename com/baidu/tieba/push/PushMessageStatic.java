package com.baidu.tieba.push;

import android.app.Activity;
import android.media.Ringtone;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fu4;
import com.repackage.gz4;
import com.repackage.ha8;
import com.repackage.hz4;
import com.repackage.ia8;
import com.repackage.ja8;
import com.repackage.rg;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class PushMessageStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.push.PushMessageStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0254a implements gz4.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ringtone a;
            public final /* synthetic */ ia8 b;

            public C0254a(a aVar, Ringtone ringtone, ia8 ia8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ringtone, ia8Var};
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
                this.b = ia8Var;
            }

            @Override // com.repackage.gz4.h
            public void dismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Ringtone ringtone = this.a;
                    if (ringtone != null) {
                        ringtone.stop();
                    }
                    ia8 ia8Var = this.b;
                    if (ia8Var != null) {
                        ia8Var.l();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ia8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gz4 a;

            public b(a aVar, gz4 gz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gz4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gz4Var;
            }

            @Override // com.repackage.ia8.e
            public void a(View view2) {
                gz4 gz4Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (gz4Var = this.a) == null) {
                    return;
                }
                gz4Var.t();
            }
        }

        /* loaded from: classes4.dex */
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
                    new ha8(currentActivity, this.b.getForegroundShowData().getExtData(), this.b.getForegroundShowData().getRemindInfo()).q();
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
                ia8 ia8Var = new ia8(currentPageContext);
                ia8Var.o(pushGeneralData);
                Ringtone f = ja8.f();
                gz4 b2 = hz4.b(ia8Var.m(), currentPageContext, null, 0L, remindInfo.getShowtime());
                b2.x(new C0254a(this, f, ia8Var));
                ia8Var.p(new b(this, b2));
            } else if (type == 1 || type == 2 || type == 4 || type == 5) {
                rg.a().post(new c(this, type, pushGeneralData));
            }
            if (remindInfo == null || extData == null || !isLiveData || !fu4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                return;
            }
            YyExtData yyExtData = new YyExtData();
            yyExtData.mSid = extData.getSid();
            yyExtData.mSsid = extData.getSsid();
            yyExtData.mTemplateId = extData.getTemplateId();
            yyExtData.mYyUid = extData.getYyUid();
            yyExtData.mRankShow = extData.getRankShow();
            yyExtData.isYyGame = extData.getIsYyGame();
            yyExtData.mIconUrl = extData.getIconUrl();
            yyExtData.streamInfo = extData.getStreamInfo();
            HashMap hashMap = new HashMap();
            hashMap.put("view_top_params_key_schema", remindInfo.getScheme());
            hashMap.put("view_top_params_key_image_url", remindInfo.getImage());
            hashMap.put("view_top_params_key_title", remindInfo.getTitle());
            hashMap.put("view_top_params_key_desc", remindInfo.getDesc());
            hashMap.put("view_top_params_is_breathe", Boolean.valueOf(remindInfo.getIsBreathe()));
            hashMap.put("view_top_params_btn_text", remindInfo.getBtnText());
            hashMap.put("view_top_params_key_nid", extData.getRoomId());
            hashMap.put("view_top_params_key_yyext", yyExtData);
            hashMap.put("view_top_params_key_type", 1);
            hashMap.put("view_top_params_room_id", extData.getLiveId());
            if (hz4.b(null, currentPageContext, hashMap, 0L, remindInfo.getShowtime()) != null) {
                hz4.a();
                TbSingleton.getInstance().setIsNeedRemindLiveRoom(false);
                fu4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        ja8.e(tbPageContext.getContext(), str, true);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                        ja8.a(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                        ja8.d(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                        ja8.b(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                        ja8.c(tbPageContext.getContext(), str);
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
        a();
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager.getInstance().registerListener(new a(2921711));
            UrlManager.getInstance().addListener(new b());
        }
    }
}

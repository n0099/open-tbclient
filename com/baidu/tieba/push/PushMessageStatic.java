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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f78;
import com.repackage.g78;
import com.repackage.h78;
import com.repackage.mx4;
import com.repackage.nx4;
import com.repackage.qg;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PushMessageStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.push.PushMessageStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0237a implements mx4.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ringtone a;
            public final /* synthetic */ g78 b;

            public C0237a(a aVar, Ringtone ringtone, g78 g78Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ringtone, g78Var};
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
                this.b = g78Var;
            }

            @Override // com.repackage.mx4.h
            public void dismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Ringtone ringtone = this.a;
                    if (ringtone != null) {
                        ringtone.stop();
                    }
                    g78 g78Var = this.b;
                    if (g78Var != null) {
                        g78Var.l();
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements g78.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mx4 a;

            public b(a aVar, mx4 mx4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, mx4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mx4Var;
            }

            @Override // com.repackage.g78.e
            public void a(View view2) {
                mx4 mx4Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mx4Var = this.a) == null) {
                    return;
                }
                mx4Var.t();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PushGeneralData a;

            public c(a aVar, PushGeneralData pushGeneralData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, pushGeneralData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pushGeneralData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity currentActivity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null) {
                    return;
                }
                new f78(currentActivity, this.a.getForegroundShowData().getExtData(), this.a.getForegroundShowData().getRemindInfo()).q();
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
            if (type == 3) {
                g78 g78Var = new g78(currentPageContext);
                g78Var.o(pushGeneralData);
                Ringtone f = h78.f();
                mx4 b2 = nx4.b(g78Var.m(), currentPageContext, null, 0L, remindInfo.getShowtime());
                b2.x(new C0237a(this, f, g78Var));
                g78Var.p(new b(this, b2));
            } else if (type == 1 || type == 2 || type == 4) {
                qg.a().post(new c(this, pushGeneralData));
            }
            if (remindInfo == null || extData == null || !isLiveData) {
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
            nx4.b(null, currentPageContext, hashMap, 0L, remindInfo.getShowtime());
            nx4.a();
            TbSingleton.getInstance().setIsNeedRemindLiveRoom(false);
        }
    }

    /* loaded from: classes3.dex */
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
                        h78.e(tbPageContext.getContext(), str, true);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                        h78.a(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                        h78.d(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                        h78.b(tbPageContext.getContext(), str);
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                        h78.c(tbPageContext.getContext(), str);
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

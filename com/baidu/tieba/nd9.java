package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.RobotEntrance;
import tbclient.RobotSkillInfo;
/* loaded from: classes7.dex */
public final class nd9 extends o05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements ee9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
        }

        @Override // com.baidu.tieba.ee9
        public void onDismiss() {
            dk9 E6;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFragment Y1 = ((PbActivity) this.a).Y1();
                if (Y1 != null && (E6 = Y1.E6()) != null && (V0 = E6.V0()) != null) {
                    V0.x();
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
            }
        }

        @Override // com.baidu.tieba.ee9
        public void onShow() {
            dk9 E6;
            FriendBotView V0;
            dk9 E62;
            FriendBotView V02;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment Y1 = ((PbActivity) this.a).Y1();
                if (Y1 != null && (E62 = Y1.E6()) != null && (V02 = E62.V0()) != null) {
                    V02.setDynamicLooping(true);
                }
                PbFragment Y12 = ((PbActivity) this.a).Y1();
                if (Y12 != null && (E6 = Y12.E6()) != null && (V0 = E6.V0()) != null) {
                    V0.r();
                }
                SharedPrefHelper.getInstance().putString("pb_friend_bot_bottom_new_skill_text", this.b);
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
            }
        }
    }

    public nd9() {
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

    @Override // com.baidu.tieba.o05
    public void a(Context context, c05 data) {
        List<RobotSkillInfo> list;
        boolean z;
        dk9 E6;
        ye9 s1;
        RobotEntrance K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新人设上线引导失败：当前Activity非PbActivity");
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
                return;
            }
            BotEntranceManager c = BotEntranceManager.c.c();
            PbActivity pbActivity = (PbActivity) context;
            PbModel J1 = pbActivity.J1();
            FriendBotView friendBotView = null;
            if (J1 != null && (s1 = J1.s1()) != null && (K = s1.K()) != null) {
                list = K.robot_skill_info;
            } else {
                list = null;
            }
            String j = c.j(list);
            if (j.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
                return;
            }
            PbFragment Y1 = pbActivity.Y1();
            if (Y1 != null && (E6 = Y1.E6()) != null) {
                friendBotView = E6.V0();
            }
            he9.e(j, friendBotView, (BaseFragmentActivity) context, new a(context, j));
        }
    }
}

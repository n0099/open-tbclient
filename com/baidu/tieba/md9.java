package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.CallRobotEntrance;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes7.dex */
public final class md9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<PbFragment> a;
    public final String b;

    public md9(String token, PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {token, pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(pbFragment, "pbFragment");
        this.a = new WeakReference<>(pbFragment);
        this.b = token;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pbFragment = this.a.get()) != null && pbFragment.E6() != null && pbFragment.e0() != null && pbFragment.E6().T0() != null && pbFragment.e0().s1() != null) {
            RobotEntrance K = pbFragment.e0().s1().K();
            if (K != null) {
                List<RobotSkillInfo> list = K.robot_skill_info;
                List<RobotSkill> list2 = K.bottom_bar_robot_skill;
                if (list != null && list2 != null) {
                    CallRobotEntrance c = BotEntranceManager.c.c().c(list, list2);
                    Intrinsics.checkNotNull(c);
                    str = c.style_conf.android_extra.bot_timeout_content;
                    Intrinsics.checkNotNullExpressionValue(str, "robotEntrance!!.style_co…extra.bot_timeout_content");
                    if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0800);
                        Intrinsics.checkNotNullExpressionValue(str, "getInst()\n              …bot_loading_timeout_text)");
                    }
                    hm9.d(this.b, str, "", 2);
                    pbFragment.E6().T0().f0();
                }
            }
            str = "";
            if (TextUtils.isEmpty(str)) {
            }
            hm9.d(this.b, str, "", 2);
            pbFragment.E6().T0().f0();
        }
    }
}

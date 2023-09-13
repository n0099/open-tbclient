package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.bot.RequestBotSkillHelper;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbContent;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes8.dex */
public class xp9 {
    public static /* synthetic */ Interceptable $ic;
    public static List<tha> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308200, "Lcom/baidu/tieba/xp9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308200, "Lcom/baidu/tieba/xp9;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull String str, long j, @NonNull String str2, @NonNull String str3, @NonNull String str4, FastRequest.b<Void> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, str, Long.valueOf(j), str2, str3, str4, bVar}) == null) {
            new RequestBotSkillHelper(tbPageContext).b(new RequestBotSkillHelper.BotRequest(str, j, str2, str3, str4), bVar);
        }
    }

    public static void b(PbModel pbModel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, pbModel, str) != null) || pbModel == null) {
            return;
        }
        aj9 r1 = pbModel.r1();
        aj9 aj9Var = new aj9();
        ArrayList<tha> F = aj9Var.F();
        tha thaVar = new tha();
        thaVar.s1(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        List<RobotSkillInfo> list = r1.K().robot_skill_info;
        List<RobotSkill> list2 = r1.K().bottom_bar_robot_skill;
        if (list != null && list2 != null) {
            builder.text = BotEntranceManager.h().c(list, list2).style_conf.android_extra.bot_loading_content;
        }
        if (TextUtils.isEmpty(builder.text)) {
            builder.text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f9);
        }
        arrayList.add(builder.build(true));
        thaVar.o1(new TbRichText(arrayList, pbModel.L1(), false));
        thaVar.T0(1);
        if (r1 != null && r1.y() != null) {
            thaVar.W0(r1.F().size() + 1);
        }
        if (r1 != null && r1.O() != null) {
            aj9Var.S0(r1.O());
            aj9Var.O().setReply_num(aj9Var.O().getReply_num() + 1);
        }
        MetaData metaData = new MetaData();
        UserData V = pbModel.r1().V();
        metaData.setName_show(V.getName_show());
        metaData.setPortrait(V.getPortrait());
        metaData.setUserId(V.getUserId());
        metaData.setLevel_id(V.getLevel_id());
        metaData.setLevelName(V.getLevelName());
        metaData.setIconInfo(V.getIconInfo());
        thaVar.P0(metaData);
        thaVar.Q0(str);
        F.clear();
        F.add(thaVar);
        a.add(thaVar);
        pbModel.C2(aj9Var, 8, false, 0, "", false, 0, 0L, 0L, true);
    }

    public static String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return ki.c(str + str2 + j);
        }
        return (String) invokeCommon.objValue;
    }

    public static void d(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, i) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (tha thaVar : a) {
                if (str.equals(thaVar.x()) && thaVar.l() == 1) {
                    ArrayList arrayList = new ArrayList();
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.text = str2;
                    arrayList.add(builder.build(true));
                    thaVar.o1(new TbRichText(arrayList, "", false));
                    thaVar.c1(str3);
                    thaVar.T0(i);
                    return;
                }
            }
        }
    }

    public static void e(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).show();
        }
    }
}

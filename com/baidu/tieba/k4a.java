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
/* loaded from: classes6.dex */
public class k4a {
    public static /* synthetic */ Interceptable $ic;
    public static List<mwa> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864497, "Lcom/baidu/tieba/k4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864497, "Lcom/baidu/tieba/k4a;");
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
        zv9 s1 = pbModel.s1();
        zv9 zv9Var = new zv9();
        ArrayList<mwa> I = zv9Var.I();
        mwa mwaVar = new mwa();
        mwaVar.w1(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        List<RobotSkillInfo> list = s1.N().robot_skill_info;
        List<RobotSkill> list2 = s1.N().bottom_bar_robot_skill;
        if (list != null && list2 != null) {
            builder.text = BotEntranceManager.g().c(list, list2).style_conf.android_extra.bot_loading_content;
        }
        if (TextUtils.isEmpty(builder.text)) {
            builder.text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f080a);
        }
        arrayList.add(builder.build(true));
        mwaVar.r1(new TbRichText(arrayList, pbModel.M1(), false));
        mwaVar.W0(1);
        if (s1 != null && s1.B() != null) {
            mwaVar.Z0(s1.I().size() + 1);
        }
        if (s1 != null && s1.R() != null) {
            zv9Var.T0(s1.R());
            zv9Var.R().setReply_num(zv9Var.R().getReply_num() + 1);
        }
        MetaData metaData = new MetaData();
        UserData Y = pbModel.s1().Y();
        metaData.setName_show(Y.getName_show());
        metaData.setPortrait(Y.getPortrait());
        metaData.setUserId(Y.getUserId());
        metaData.setLevel_id(Y.getLevel_id());
        metaData.setLevelName(Y.getLevelName());
        metaData.setIconInfo(Y.getIconInfo());
        mwaVar.T0(metaData);
        mwaVar.U0(str);
        I.clear();
        I.add(mwaVar);
        a.add(mwaVar);
        pbModel.E2(zv9Var, 8, false, 0, "", false, 0, 0L, 0L, true);
    }

    public static String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return xd.c(str + str2 + j);
        }
        return (String) invokeCommon.objValue;
    }

    public static void d(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, i) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (mwa mwaVar : a) {
                if (str.equals(mwaVar.z()) && mwaVar.l() == 1) {
                    ArrayList arrayList = new ArrayList();
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.text = str2;
                    arrayList.add(builder.build(true));
                    mwaVar.r1(new TbRichText(arrayList, "", false));
                    mwaVar.f1(str3);
                    mwaVar.W0(i);
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

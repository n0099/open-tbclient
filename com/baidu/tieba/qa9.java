package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.pb.bot.RequestBotSkillHelper;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.CallRobotEntrance;
import tbclient.PbContent;
import tbclient.StyleConf;
/* loaded from: classes7.dex */
public class qa9 {
    public static /* synthetic */ Interceptable $ic;
    public static List<b0a> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085248, "Lcom/baidu/tieba/qa9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948085248, "Lcom/baidu/tieba/qa9;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(TbPageContext<BaseFragmentActivity> tbPageContext, ThreadData threadData, long j, FastRequest.b<Void> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, threadData, Long.valueOf(j), bVar}) == null) && threadData != null && threadData.getCallRobotEntrance() != null) {
            String str = threadData.getCallRobotEntrance().ability_conf.bot_uk;
            int intValue = threadData.getCallRobotEntrance().ability_conf.skill_id.intValue();
            String tid = threadData.getTid();
            String firstPostId = threadData.getFirstPostId();
            new RequestBotSkillHelper(tbPageContext).b(new RequestBotSkillHelper.BotRequest(str, intValue, tid, firstPostId, c(firstPostId, TbadkCoreApplication.getCurrentPortrait(), j)), bVar);
        }
    }

    public static void b(PbModel pbModel, String str) {
        StyleConf styleConf;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, pbModel, str) != null) || pbModel == null) {
            return;
        }
        j49 y1 = pbModel.y1();
        j49 j49Var = new j49();
        ArrayList<b0a> F = j49Var.F();
        b0a b0aVar = new b0a();
        b0aVar.o1(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        FriendBotPostConfigData friendBotPostConfigData = TbSingleton.getInstance().getFriendBotPostConfigData();
        if (friendBotPostConfigData != null) {
            builder.text = friendBotPostConfigData.getLoadingPostContent();
        }
        if (TextUtils.isEmpty(builder.text)) {
            builder.text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e1);
        }
        arrayList.add(builder.build(true));
        b0aVar.k1(new TbRichText(arrayList, pbModel.R1(), false));
        b0aVar.Q0(1);
        if (y1 != null && y1.y() != null) {
            b0aVar.S0(y1.F().size() + 1);
        }
        MetaData metaData = new MetaData();
        CallRobotEntrance callRobotEntrance = null;
        if (y1 != null && y1.N() != null) {
            j49Var.P0(y1.N());
            j49Var.N().setReply_num(j49Var.N().getReply_num() + 1);
            callRobotEntrance = y1.N().getCallRobotEntrance();
        }
        if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null) {
            metaData.setName_show(styleConf.android_extra.bot_name);
            metaData.setPortrait(callRobotEntrance.style_conf.android_extra.bot_portrait);
            metaData.setUserId(BIMManager.getBdUidFromBdUK(callRobotEntrance.ability_conf.bot_uk));
        }
        b0aVar.N0(metaData);
        b0aVar.O0(str);
        F.clear();
        F.add(b0aVar);
        a.add(b0aVar);
        pbModel.I2(j49Var, 8, false, 0, "", false, 0, 0L, 0L, true);
    }

    public static String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return dj.c(str + str2 + j);
        }
        return (String) invokeCommon.objValue;
    }

    public static void d(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, i) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (b0a b0aVar : a) {
                if (str.equals(b0aVar.w()) && b0aVar.l() == 1) {
                    ArrayList arrayList = new ArrayList();
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.text = str2;
                    arrayList.add(builder.build(true));
                    b0aVar.k1(new TbRichText(arrayList, "", false));
                    b0aVar.Y0(str3);
                    b0aVar.Q0(i);
                    return;
                }
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getString(R.string.friend_bot_loading_toast_text));
            if (!TextUtils.isEmpty(str)) {
                b.l(str);
            }
            b.q();
        }
    }
}

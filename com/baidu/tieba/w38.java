package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class w38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ AbsPbActivity b;
        public final /* synthetic */ View c;

        public a(PbModel pbModel, AbsPbActivity absPbActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = absPbActivity;
            this.c = view2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (pbModel = this.a) != null && pbModel.S1() != null && this.a.S1().x0() && !TbSingleton.getInstance().isNotchScreen(this.b) && !TbSingleton.getInstance().isCutoutScreen(this.b) && (view2 = this.c) != null) {
                view2.setSystemUiVisibility(4);
            }
        }
    }

    public static int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i = threadData.threadType;
            if (i == 0) {
                return 1;
            }
            if (i == 40) {
                return 2;
            }
            if (i == 49) {
                return 3;
            }
            if (i == 54) {
                return 4;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    public static int b(uv7 uv7Var) {
        InterceptResult invokeL;
        ThreadData P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uv7Var)) == null) {
            if (uv7Var != null && (P = uv7Var.P()) != null) {
                if (P.isRealGod()) {
                    return 4;
                }
                if (P.getIsLive() == 1) {
                    return 3;
                }
                if (P.isBJHArticleThreadType()) {
                    return 5;
                }
                if (P.isBJHVideoThreadType()) {
                    return 6;
                }
                if (P.isBJHNormalThreadType()) {
                    return 7;
                }
                if (P.isBJHVideoDynamicThreadType()) {
                    return 8;
                }
                if (!P.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i, int i2) {
        String m2;
        String str;
        Uri parse;
        char c;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i, i2) == null) && absPbActivity != null && absPbActivity.i1() != null) {
            PbModel i1 = absPbActivity.i1();
            View rootView = absPbActivity.getRootView();
            if (!i1.a()) {
                return;
            }
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            uv7 S1 = i1.S1();
            String title = S1.P().getTitle();
            boolean v1 = i1.v1();
            if (S1.l() != null) {
                if (S1.l().isLike() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AddExperiencedModel.E(S1.m());
                }
            }
            ThreadData P = i1.S1().P();
            if (P.isUgcThreadType()) {
                m2 = P.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (v1 ? 1 : 0) + "&dtype=" + P.getBaijiahaoData().oriUgcType + "&dvid=" + P.getBaijiahaoData().oriUgcVid + "&nid=" + P.getBaijiahaoData().oriUgcNid;
            } else {
                m2 = i1.m2();
                str = "?share=9105&fr=sharewise&see_lz=" + (v1 ? 1 : 0);
            }
            String str2 = TbConfig.HTTPS_PB_PREFIX + m2 + (str + "&share_from=post");
            String[] N = S1.N();
            String str3 = N[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            if (str3 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str3);
            }
            String str4 = N[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", S1.m()).param("tid", S1.R()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a4);
            if (S1.k0() && P.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || P.isBJHVideoDynamicThreadType() || P.isBJHVideoThreadType()) {
                    if (TextUtils.isEmpty(title)) {
                        c = 1;
                        title = N[1];
                    } else {
                        c = 1;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = P.getAuthor().getName_show();
                    objArr[c] = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a5);
                    str4 = MessageFormat.format(string, objArr);
                }
            } else if (ej.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = ej.cutString(title, 100);
            String cutString2 = ej.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.v = cutString;
            shareItem.w = cutString2;
            if (S1.k0()) {
                shareItem.H = cutString2;
                shareItem.V = -1L;
            } else if (S1.P() != null && S1.P().getThreadVideoInfo() != null && !S1.P().isUgcThreadType()) {
                shareItem.V = S1.P().getThreadVideoInfo().play_count.intValue();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = i1.m2();
            shareItem.J = 3;
            shareItem.I = i2;
            shareItem.N = i1.getForumId();
            shareItem.O = i1.m2();
            shareItem.Q = b(S1);
            shareItem.R = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
            }
            if (i2 == 2) {
                shareItem.J = i1.w1();
            }
            if (S1.k0()) {
                shareItem.s0 = false;
            }
            shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(P);
            if (S1 != null && S1.G() != null && S1.G().size() > 0) {
                shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(P, 1, (PostData) S1.G().get(0));
            } else {
                shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(P, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (P != null) {
                shareItem.q0 = P.getShareImageUrl();
            }
            shareItem.K = a(P);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.Q);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putString("uid", shareItem.R);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig.setOnDismissListener(new a(i1, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f46.c().l(shareDialogConfig);
        }
    }
}

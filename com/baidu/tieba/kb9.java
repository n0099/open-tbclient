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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class kb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnDismissListener {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (pbModel = this.a) != null && pbModel.y1() != null && this.a.y1().w0() && !TbSingleton.getInstance().isNotchScreen(this.b) && !TbSingleton.getInstance().isCutoutScreen(this.b) && (view2 = this.c) != null) {
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

    public static int b(j39 j39Var) {
        InterceptResult invokeL;
        ThreadData N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j39Var)) == null) {
            if (j39Var != null && (N = j39Var.N()) != null) {
                if (N.isRealGod()) {
                    return 4;
                }
                if (N.getIsLive() == 1) {
                    return 3;
                }
                if (N.isBJHArticleThreadType()) {
                    return 5;
                }
                if (N.isBJHVideoThreadType()) {
                    return 6;
                }
                if (N.isBJHNormalThreadType()) {
                    return 7;
                }
                if (N.isBJHVideoDynamicThreadType()) {
                    return 8;
                }
                if (!N.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i, int i2) {
        String R1;
        String str;
        Uri parse;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i, i2) == null) && absPbActivity != null && absPbActivity.K1() != null) {
            PbModel K1 = absPbActivity.K1();
            View rootView = absPbActivity.getRootView();
            if (!K1.d()) {
                return;
            }
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            j39 y1 = K1.y1();
            String title = y1.N().getTitle();
            boolean b1 = K1.b1();
            if (y1.k() != null) {
                if (y1.k().isLike() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AddExperiencedModel.Z(y1.l());
                }
            }
            ThreadData N = K1.y1().N();
            if (N.isUgcThreadType()) {
                R1 = N.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (b1 ? 1 : 0) + "&dtype=" + N.getBaijiahaoData().oriUgcType + "&dvid=" + N.getBaijiahaoData().oriUgcVid + "&nid=" + N.getBaijiahaoData().oriUgcNid;
            } else {
                R1 = K1.R1();
                str = "?share=9105&fr=sharewise&see_lz=" + (b1 ? 1 : 0);
            }
            String str2 = TbConfig.HTTPS_PB_PREFIX + R1 + (str + "&share_from=post");
            String[] K = y1.K();
            String str3 = K[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            if (str3 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str3);
            }
            String str4 = K[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                ya9.u("c10399", y1.l(), y1.P(), currentAccount);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (y1.i0() && N.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || N.isBJHVideoDynamicThreadType() || N.isBJHVideoThreadType()) {
                    if (TextUtils.isEmpty(title)) {
                        title = K[1];
                    }
                    str4 = MessageFormat.format(string, N.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                }
            } else if (ui.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = ui.cutString(title, 100);
            String cutString2 = ui.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.v = cutString;
            shareItem.w = cutString2;
            if (y1.i0()) {
                shareItem.H = cutString2;
                shareItem.W = -1L;
            } else if (y1.N() != null && y1.N().getThreadVideoInfo() != null && !y1.N().isUgcThreadType()) {
                shareItem.W = y1.N().getThreadVideoInfo().play_count.intValue();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = K1.R1();
            shareItem.J = 3;
            shareItem.I = i2;
            shareItem.N = K1.getForumId();
            shareItem.O = K1.R1();
            shareItem.R = b(y1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
            }
            if (i2 == 2) {
                shareItem.J = K1.c1();
            }
            if (y1.i0()) {
                shareItem.v0 = false;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
            if (y1 != null && y1.F() != null && y1.F().size() > 0) {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, y1.F().get(0));
            } else {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (N != null) {
                shareItem.t0 = N.getShareImageUrl();
            }
            shareItem.K = a(N);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putString("uid", shareItem.S);
            shareItem.r(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig.setOnDismissListener(new a(K1, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            nr6.c().l(shareDialogConfig);
        }
    }
}

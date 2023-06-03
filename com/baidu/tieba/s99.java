package com.baidu.tieba;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.a55;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class s99 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ Thread2GroupShareView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ShareFromPBMsgData h;

        public a(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
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
            this.b = pbFragment;
            this.c = thread2GroupShareView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = shareFromPBMsgData;
        }

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.y1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.R1()).param("obj_locate", 1);
                    if (s99.f(this.a.y1()) != 0) {
                        param.param("obj_type", s99.f(this.a.y1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public b(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = thread2GroupShareView;
        }

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PbFragment> a;
        public final PbModel b;

        public c(PbFragment pbFragment, PbModel pbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, pbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(pbFragment);
            this.b = pbModel;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) || (pbFragment = this.a.get()) == null) {
                return;
            }
            s79 L5 = pbFragment.L5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.y1() != null && this.b.y1().w0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && L5 != null && L5.s1() != null) {
                L5.s1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106390, "Lcom/baidu/tieba/s99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106390, "Lcom/baidu/tieba/s99;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.add(str);
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return a.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static ShareItem c(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String R1;
        String str;
        Uri parse;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, pbModel)) == null) {
            j39 y1 = pbModel.y1();
            String title = y1.N().getTitle();
            boolean b1 = pbModel.b1();
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
            ThreadData N = pbModel.y1().N();
            N.setImShareFromPb(true);
            if (pbModel != null && pbModel.y1() != null) {
                N.setPbFirstShareData(pbModel.y1().h());
            }
            if (N.isUgcThreadType()) {
                R1 = N.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (b1 ? 1 : 0) + "&dtype=" + N.getBaijiahaoData().oriUgcType + "&dvid=" + N.getBaijiahaoData().oriUgcVid + "&nid=" + N.getBaijiahaoData().oriUgcNid;
            } else {
                R1 = pbModel.R1();
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
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(title) || N.isBJHVideoDynamicThreadType() || N.isBJHVideoThreadType()) {
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
            } else {
                shareItem.W = y1.O();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = pbModel.R1();
            if (i2 == 2) {
                shareItem.J = pbModel.c1();
            }
            shareItem.I = i2;
            shareItem.K = e(N);
            shareItem.N = pbModel.getForumId();
            shareItem.O = pbModel.R1();
            shareItem.R = f(y1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
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
            ThreadData threadData = shareItem.a0.threadData;
            if (threadData != null && threadData.getForumData() == null && y1 != null && y1.k() != null) {
                h45 h45Var = new h45();
                h45Var.m(y1.k().getName());
                h45Var.a = y1.k().getId();
                h45Var.c = y1.k().getImage_url();
                shareItem.a0.threadData.setForumData(h45Var);
            }
            if (N != null) {
                shareItem.t0 = N.getShareImageUrl();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putString("uid", shareItem.S);
            shareItem.r(bundle);
            int j = lf5.j(N);
            String forum_name = N.getForum_name();
            OriginalForumInfo originalForumInfo = N.mOriginalForumInfo;
            if (originalForumInfo != null) {
                forum_name = originalForumInfo.ori_fname;
            }
            shareItem.I0 = lf5.i(N, j);
            shareItem.J0 = lf5.h(N, j, forum_name, shareItem.W, "", K[1]);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.Q() != null && pbFragment.L5() != null) {
                PbModel Q = pbFragment.Q();
                s79 L5 = pbFragment.L5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] K = Q.y1().K();
                ey9 O0 = L5.O0();
                String str2 = "";
                if (O0 == null) {
                    str = "";
                } else {
                    str = O0.O();
                    String l = O0.l();
                    if (!ui.isEmpty(l)) {
                        K[1] = l;
                    }
                }
                String firstPostId = Q.y1().N().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(K[1]);
                shareFromPBMsgData.setImageUrl(K[0]);
                shareFromPBMsgData.setForumName(Q.y1().k().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(Q.y1().N().getId());
                shareFromPBMsgData.setTitle(Q.y1().N().getTitle());
                return shareFromPBMsgData;
            }
            return null;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static int e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadData)) == null) {
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

    public static int f(j39 j39Var) {
        InterceptResult invokeL;
        ThreadData N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, j39Var)) == null) {
            if (j39Var != null && (N = j39Var.N()) != null) {
                if (N.isRealGod()) {
                    return 4;
                }
                if (N.getIsLive() == 1) {
                    return 3;
                }
                if (N.isRealVideoThread()) {
                    return 2;
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
                if (!N.isBJHVideoDynamicThreadType()) {
                    return 1;
                }
                return 8;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void g(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbFragment, intent) == null) {
            i(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void i(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel Q = pbFragment.Q();
        ShareFromPBMsgData d = d(pbFragment);
        if (Q != null && Q.y1() != null && Q.y1().N() != null) {
            a55 a55Var = new a55(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(d);
            a55Var.setContentViewSize(1);
            a55Var.setContentView(thread2GroupShareView);
            a55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f133f, new a(Q, pbFragment, thread2GroupShareView, j, str, str2, str3, d));
            a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(pbFragment, thread2GroupShareView));
            a55Var.setCanceledOnTouchOutside(true);
            a55Var.create(pbFragment.getPageContext()).show();
            if (!ui.isEmpty(d.getImageUrl())) {
                String imageUrl = d.getImageUrl();
                if (Q.y1().r() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void j(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65546, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.Q() != null && pbFragment.L5() != null) {
            PbModel Q = pbFragment.Q();
            if (!Q.d()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(i, i2, Q);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, Q));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.r(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(Q.getTopicId());
            if (Q.y1().N().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (Q.y1() != null) {
                shareDialogConfig.setShowNovelMask(Q.y1().o0());
            }
            nr6.c().l(shareDialogConfig);
        }
    }
}

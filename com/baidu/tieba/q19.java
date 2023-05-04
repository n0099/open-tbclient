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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.u05;
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
/* loaded from: classes6.dex */
public class q19 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.z1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.S1()).param("obj_locate", 1);
                    if (q19.f(this.a.z1()) != 0) {
                        param.param("obj_type", q19.f(this.a.z1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            tz8 I5 = pbFragment.I5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.z1() != null && this.b.z1().v0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && I5 != null && I5.o1() != null) {
                I5.o1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039120, "Lcom/baidu/tieba/q19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039120, "Lcom/baidu/tieba/q19;");
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
        String S1;
        String str;
        Uri parse;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, pbModel)) == null) {
            qv8 z1 = pbModel.z1();
            String title = z1.M().getTitle();
            boolean c1 = pbModel.c1();
            if (z1.k() != null) {
                if (z1.k().isLike() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AddExperiencedModel.a0(z1.l());
                }
            }
            ThreadData M = pbModel.z1().M();
            M.setImShareFromPb(true);
            if (pbModel != null && pbModel.z1() != null) {
                M.setPbFirstShareData(pbModel.z1().h());
            }
            if (M.isUgcThreadType()) {
                S1 = M.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (c1 ? 1 : 0) + "&dtype=" + M.getBaijiahaoData().oriUgcType + "&dvid=" + M.getBaijiahaoData().oriUgcVid + "&nid=" + M.getBaijiahaoData().oriUgcNid;
            } else {
                S1 = pbModel.S1();
                str = "?share=9105&fr=sharewise&see_lz=" + (c1 ? 1 : 0);
            }
            String str2 = TbConfig.HTTPS_PB_PREFIX + S1 + (str + "&share_from=post");
            String[] K = z1.K();
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
                v29.u("c10399", z1.l(), z1.O(), currentAccount);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (z1.h0() && M.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(title) || M.isBJHVideoDynamicThreadType() || M.isBJHVideoThreadType()) {
                        title = K[1];
                    }
                    str4 = MessageFormat.format(string, M.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                }
            } else if (hi.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = hi.cutString(title, 100);
            String cutString2 = hi.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.v = cutString;
            shareItem.w = cutString2;
            if (z1.h0()) {
                shareItem.H = cutString2;
                shareItem.W = -1L;
            } else {
                shareItem.W = z1.N();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = pbModel.S1();
            if (i2 == 2) {
                shareItem.J = pbModel.d1();
            }
            shareItem.I = i2;
            shareItem.K = e(M);
            shareItem.N = pbModel.getForumId();
            shareItem.O = pbModel.S1();
            shareItem.R = f(z1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
            }
            if (z1.h0()) {
                shareItem.v0 = false;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(M);
            if (z1 != null && z1.F() != null && z1.F().size() > 0) {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(M, 1, z1.F().get(0));
            } else {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(M, 1, null);
            }
            ThreadData threadData = shareItem.a0.threadData;
            if (threadData != null && threadData.getForumData() == null && z1 != null && z1.k() != null) {
                b05 b05Var = new b05();
                b05Var.j(z1.k().getName());
                b05Var.a = z1.k().getId();
                b05Var.c = z1.k().getImage_url();
                shareItem.a0.threadData.setForumData(b05Var);
            }
            if (M != null) {
                shareItem.t0 = M.getShareImageUrl();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putString("uid", shareItem.S);
            shareItem.l(bundle);
            int j = ab5.j(M);
            String forum_name = M.getForum_name();
            OriginalForumInfo originalForumInfo = M.mOriginalForumInfo;
            if (originalForumInfo != null) {
                forum_name = originalForumInfo.ori_fname;
            }
            shareItem.I0 = ab5.i(M, j);
            shareItem.J0 = ab5.h(M, j, forum_name, shareItem.W, "", K[1]);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.Q() != null && pbFragment.I5() != null) {
                PbModel Q = pbFragment.Q();
                tz8 I5 = pbFragment.I5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] K = Q.z1().K();
                pp9 L0 = I5.L0();
                String str2 = "";
                if (L0 == null) {
                    str = "";
                } else {
                    str = L0.N();
                    String k = L0.k();
                    if (!hi.isEmpty(k)) {
                        K[1] = k;
                    }
                }
                String firstPostId = Q.z1().M().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(K[1]);
                shareFromPBMsgData.setImageUrl(K[0]);
                shareFromPBMsgData.setForumName(Q.z1().k().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(Q.z1().M().getId());
                shareFromPBMsgData.setTitle(Q.z1().M().getTitle());
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

    public static int f(qv8 qv8Var) {
        InterceptResult invokeL;
        ThreadData M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qv8Var)) == null) {
            if (qv8Var != null && (M = qv8Var.M()) != null) {
                if (M.isRealGod()) {
                    return 4;
                }
                if (M.getIsLive() == 1) {
                    return 3;
                }
                if (M.isRealVideoThread()) {
                    return 2;
                }
                if (M.isBJHArticleThreadType()) {
                    return 5;
                }
                if (M.isBJHVideoThreadType()) {
                    return 6;
                }
                if (M.isBJHNormalThreadType()) {
                    return 7;
                }
                if (!M.isBJHVideoDynamicThreadType()) {
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
        if (Q != null && Q.z1() != null && Q.z1().M() != null) {
            u05 u05Var = new u05(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(d);
            u05Var.setContentViewSize(1);
            u05Var.setContentView(thread2GroupShareView);
            u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1221, new a(Q, pbFragment, thread2GroupShareView, j, str, str2, str3, d));
            u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(pbFragment, thread2GroupShareView));
            u05Var.setCanceledOnTouchOutside(true);
            u05Var.create(pbFragment.getPageContext()).show();
            if (!hi.isEmpty(d.getImageUrl())) {
                String imageUrl = d.getImageUrl();
                if (Q.z1().r() == 1) {
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
        if ((interceptable == null || interceptable.invokeLII(65546, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.Q() != null && pbFragment.I5() != null) {
            PbModel Q = pbFragment.Q();
            if (!Q.e()) {
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
            shareDialogConfig.shareItem.l(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(Q.getTopicId());
            if (Q.z1().M().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (Q.z1() != null) {
                shareDialogConfig.setShowNovelMask(Q.z1().n0());
            }
            pl6.c().l(shareDialogConfig);
        }
    }
}

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
import com.baidu.tieba.p55;
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
public class ml9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.z1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.S1()).param("obj_locate", 1);
                    if (ml9.f(this.a.z1()) != 0) {
                        param.param("obj_type", ml9.f(this.a.z1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                p55Var.dismiss();
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
            ij9 L5 = pbFragment.L5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.z1() != null && this.b.z1().w0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && L5 != null && L5.p1() != null) {
                L5.p1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947976655, "Lcom/baidu/tieba/ml9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947976655, "Lcom/baidu/tieba/ml9;");
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

    /* JADX WARN: Removed duplicated region for block: B:55:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem c(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String S1;
        String str;
        Uri parse;
        String str2;
        String cutString;
        ShareItem shareItem;
        ThreadData threadData;
        OriginalForumInfo originalForumInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, pbModel)) == null) {
            ze9 z1 = pbModel.z1();
            String title = z1.N().getTitle();
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
            ThreadData N = pbModel.z1().N();
            N.setImShareFromPb(true);
            if (pbModel != null && pbModel.z1() != null) {
                N.setPbFirstShareData(pbModel.z1().h());
            }
            if (N.isUgcThreadType()) {
                S1 = N.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (c1 ? 1 : 0) + "&dtype=" + N.getBaijiahaoData().oriUgcType + "&dvid=" + N.getBaijiahaoData().oriUgcVid + "&nid=" + N.getBaijiahaoData().oriUgcNid;
            } else {
                S1 = pbModel.S1();
                str = "?share=9105&fr=sharewise&see_lz=" + (c1 ? 1 : 0);
            }
            String str3 = TbConfig.HTTPS_PB_PREFIX + S1 + (str + "&share_from=post");
            String[] K = z1.K();
            String str4 = K[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            if (str4 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str4);
            }
            String str5 = K[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                xm9.w("c10399", z1.l(), z1.P(), currentAccount);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (z1.i0() && N.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || N.isBJHVideoDynamicThreadType() || N.isBJHVideoThreadType()) {
                        title = K[1];
                    }
                    str2 = MessageFormat.format(string, N.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString2 = xi.cutString(title, 100);
                    cutString = xi.cutString(str2, 100);
                    if (cutString != null) {
                    }
                    String cutString3 = xi.cutString(cutString, 100);
                    shareItem = new ShareItem();
                    shareItem.v = cutString2;
                    shareItem.w = cutString3;
                    if (!z1.i0()) {
                    }
                    shareItem.x = str3;
                    shareItem.c = true;
                    shareItem.u = pbModel.S1();
                    if (i2 == 2) {
                    }
                    shareItem.I = i2;
                    shareItem.K = e(N);
                    shareItem.N = pbModel.getForumId();
                    shareItem.t = pbModel.Y0();
                    shareItem.O = pbModel.S1();
                    shareItem.R = f(z1);
                    shareItem.S = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (z1.i0()) {
                    }
                    shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                    if (z1 == null) {
                    }
                    shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                    threadData = shareItem.a0.threadData;
                    if (threadData != null) {
                    }
                    if (N != null) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.J);
                    bundle.putInt("obj_type", shareItem.R);
                    bundle.putString("fid", shareItem.N);
                    bundle.putString("tid", shareItem.O);
                    bundle.putString("uid", shareItem.S);
                    shareItem.r(bundle);
                    int j = tg5.j(N);
                    String forum_name = N.getForum_name();
                    originalForumInfo = N.mOriginalForumInfo;
                    if (originalForumInfo != null) {
                    }
                    shareItem.I0 = tg5.i(N, j);
                    shareItem.J0 = tg5.h(N, j, forum_name, shareItem.W, "", cutString3);
                    return shareItem;
                }
                str2 = str5;
                String cutString22 = xi.cutString(title, 100);
                cutString = xi.cutString(str2, 100);
                if (cutString != null) {
                }
                String cutString32 = xi.cutString(cutString, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString22;
                shareItem.w = cutString32;
                if (!z1.i0()) {
                }
                shareItem.x = str3;
                shareItem.c = true;
                shareItem.u = pbModel.S1();
                if (i2 == 2) {
                }
                shareItem.I = i2;
                shareItem.K = e(N);
                shareItem.N = pbModel.getForumId();
                shareItem.t = pbModel.Y0();
                shareItem.O = pbModel.S1();
                shareItem.R = f(z1);
                shareItem.S = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (z1.i0()) {
                }
                shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (z1 == null) {
                }
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                threadData = shareItem.a0.threadData;
                if (threadData != null) {
                }
                if (N != null) {
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.J);
                bundle2.putInt("obj_type", shareItem.R);
                bundle2.putString("fid", shareItem.N);
                bundle2.putString("tid", shareItem.O);
                bundle2.putString("uid", shareItem.S);
                shareItem.r(bundle2);
                int j2 = tg5.j(N);
                String forum_name2 = N.getForum_name();
                originalForumInfo = N.mOriginalForumInfo;
                if (originalForumInfo != null) {
                }
                shareItem.I0 = tg5.i(N, j2);
                shareItem.J0 = tg5.h(N, j2, forum_name2, shareItem.W, "", cutString32);
                return shareItem;
            }
            if (xi.isEmpty(str5)) {
                str2 = title;
                String cutString222 = xi.cutString(title, 100);
                cutString = xi.cutString(str2, 100);
                if (cutString != null) {
                    cutString = cutString.replaceAll("[\n\u0000]+", " ").replaceAll("[\n]+", " ");
                }
                String cutString322 = xi.cutString(cutString, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString222;
                shareItem.w = cutString322;
                if (!z1.i0()) {
                    shareItem.H = cutString322;
                    shareItem.W = -1L;
                } else {
                    shareItem.W = z1.O();
                }
                shareItem.x = str3;
                shareItem.c = true;
                shareItem.u = pbModel.S1();
                if (i2 == 2) {
                    shareItem.J = pbModel.d1();
                }
                shareItem.I = i2;
                shareItem.K = e(N);
                shareItem.N = pbModel.getForumId();
                shareItem.t = pbModel.Y0();
                shareItem.O = pbModel.S1();
                shareItem.R = f(z1);
                shareItem.S = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.z = parse;
                }
                if (z1.i0()) {
                    shareItem.v0 = false;
                }
                shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
                if (z1 == null && z1.F() != null && z1.F().size() > 0) {
                    shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, z1.F().get(0));
                } else {
                    shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
                }
                threadData = shareItem.a0.threadData;
                if (threadData != null && threadData.getForumData() == null && z1 != null && z1.k() != null) {
                    v45 v45Var = new v45();
                    v45Var.m(z1.k().getName());
                    v45Var.a = z1.k().getId();
                    v45Var.c = z1.k().getImage_url();
                    shareItem.a0.threadData.setForumData(v45Var);
                }
                if (N != null) {
                    shareItem.t0 = N.getShareImageUrl();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.J);
                bundle22.putInt("obj_type", shareItem.R);
                bundle22.putString("fid", shareItem.N);
                bundle22.putString("tid", shareItem.O);
                bundle22.putString("uid", shareItem.S);
                shareItem.r(bundle22);
                int j22 = tg5.j(N);
                String forum_name22 = N.getForum_name();
                originalForumInfo = N.mOriginalForumInfo;
                if (originalForumInfo != null) {
                    forum_name22 = originalForumInfo.ori_fname;
                }
                shareItem.I0 = tg5.i(N, j22);
                shareItem.J0 = tg5.h(N, j22, forum_name22, shareItem.W, "", cutString322);
                return shareItem;
            }
            str2 = str5;
            String cutString2222 = xi.cutString(title, 100);
            cutString = xi.cutString(str2, 100);
            if (cutString != null) {
            }
            String cutString3222 = xi.cutString(cutString, 100);
            shareItem = new ShareItem();
            shareItem.v = cutString2222;
            shareItem.w = cutString3222;
            if (!z1.i0()) {
            }
            shareItem.x = str3;
            shareItem.c = true;
            shareItem.u = pbModel.S1();
            if (i2 == 2) {
            }
            shareItem.I = i2;
            shareItem.K = e(N);
            shareItem.N = pbModel.getForumId();
            shareItem.t = pbModel.Y0();
            shareItem.O = pbModel.S1();
            shareItem.R = f(z1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (z1.i0()) {
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(N);
            if (z1 == null) {
            }
            shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(N, 1, null);
            threadData = shareItem.a0.threadData;
            if (threadData != null) {
                v45 v45Var2 = new v45();
                v45Var2.m(z1.k().getName());
                v45Var2.a = z1.k().getId();
                v45Var2.c = z1.k().getImage_url();
                shareItem.a0.threadData.setForumData(v45Var2);
            }
            if (N != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.J);
            bundle222.putInt("obj_type", shareItem.R);
            bundle222.putString("fid", shareItem.N);
            bundle222.putString("tid", shareItem.O);
            bundle222.putString("uid", shareItem.S);
            shareItem.r(bundle222);
            int j222 = tg5.j(N);
            String forum_name222 = N.getForum_name();
            originalForumInfo = N.mOriginalForumInfo;
            if (originalForumInfo != null) {
            }
            shareItem.I0 = tg5.i(N, j222);
            shareItem.J0 = tg5.h(N, j222, forum_name222, shareItem.W, "", cutString3222);
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
                ij9 L5 = pbFragment.L5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] K = Q.z1().K();
                yca L0 = L5.L0();
                String str2 = "";
                if (L0 == null) {
                    str = "";
                } else {
                    str = L0.S();
                    String m = L0.m();
                    if (!xi.isEmpty(m)) {
                        K[1] = m;
                    }
                }
                String firstPostId = Q.z1().N().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(K[1]);
                shareFromPBMsgData.setImageUrl(K[0]);
                shareFromPBMsgData.setForumName(Q.z1().k().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(Q.z1().N().getId());
                shareFromPBMsgData.setTitle(Q.z1().N().getTitle());
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

    public static int f(ze9 ze9Var) {
        InterceptResult invokeL;
        ThreadData N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ze9Var)) == null) {
            if (ze9Var != null && (N = ze9Var.N()) != null) {
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
        if (Q != null && Q.z1() != null && Q.z1().N() != null) {
            p55 p55Var = new p55(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(d);
            p55Var.setContentViewSize(1);
            p55Var.setContentView(thread2GroupShareView);
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1376, new a(Q, pbFragment, thread2GroupShareView, j, str, str2, str3, d));
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(pbFragment, thread2GroupShareView));
            p55Var.setCanceledOnTouchOutside(true);
            p55Var.create(pbFragment.getPageContext()).show();
            if (!xi.isEmpty(d.getImageUrl())) {
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
            if (Q.z1().N().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (Q.z1() != null) {
                shareDialogConfig.setShowNovelMask(Q.z1().o0());
            }
            eu6.c().l(shareDialogConfig);
        }
    }
}

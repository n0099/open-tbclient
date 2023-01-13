package com.baidu.tieba;

import android.content.Context;
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
import com.baidu.tbadk.core.data.MediaData;
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
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class za8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.l1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.F1()).param("obj_locate", 1);
                    if (za8.i(this.a.l1()) != 0) {
                        param.param("obj_type", za8.i(this.a.l1()));
                    }
                    TiebaStatic.log(param);
                }
                this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                wv4Var.dismiss();
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
            c98 K5 = pbFragment.K5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.l1() != null && this.b.l1().y0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && K5 != null && K5.t1() != null) {
                K5.t1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948353336, "Lcom/baidu/tieba/za8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948353336, "Lcom/baidu/tieba/za8;");
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

    public static int h(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                if (!threadData.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return a.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static ShareItem c(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, threadData)) == null) {
            if (threadData == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
            }
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String tid = threadData.getTid();
            String str = TbConfig.HTTPS_PB_PREFIX + tid + "?share=9105&fr=sharewise";
            String f = f(threadData);
            if (f == null) {
                parse = null;
            } else {
                parse = Uri.parse(f);
            }
            String str2 = threadData.getAbstract();
            String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.v = title;
            shareItem.w = format;
            shareItem.W = threadData.getView_num();
            shareItem.H = str2;
            shareItem.x = str;
            shareItem.s = 2;
            shareItem.u = tid;
            shareItem.J = 3;
            shareItem.N = valueOf;
            shareItem.t = forum_name;
            shareItem.O = tid;
            shareItem.f = true;
            shareItem.I = 6;
            shareItem.R = h(threadData);
            if (parse != null) {
                shareItem.z = parse;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            shareItem.t0 = threadData.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putInt("obj_source", shareItem.s);
            shareItem.l(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public static ShareItem d(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String F1;
        String str;
        Uri parse;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, pbModel)) == null) {
            y48 l1 = pbModel.l1();
            String title = l1.Q().getTitle();
            boolean O0 = pbModel.O0();
            if (l1.l() != null) {
                if (l1.l().isLike() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AddExperiencedModel.L(l1.m());
                }
            }
            ThreadData Q = pbModel.l1().Q();
            Q.setImShareFromPb(true);
            if (pbModel != null && pbModel.l1() != null) {
                Q.setPbFirstShareData(pbModel.l1().i());
            }
            if (Q.isUgcThreadType()) {
                F1 = Q.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (O0 ? 1 : 0) + "&dtype=" + Q.getBaijiahaoData().oriUgcType + "&dvid=" + Q.getBaijiahaoData().oriUgcVid + "&nid=" + Q.getBaijiahaoData().oriUgcNid;
            } else {
                F1 = pbModel.F1();
                str = "?share=9105&fr=sharewise&see_lz=" + (O0 ? 1 : 0);
            }
            String str2 = TbConfig.HTTPS_PB_PREFIX + F1 + (str + "&share_from=post");
            String[] O = l1.O();
            String str3 = O[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            if (str3 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str3);
            }
            String str4 = O[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                ac8.u("c10399", l1.m(), l1.S(), currentAccount);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (l1.l0() && Q.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(title) || Q.isBJHVideoDynamicThreadType() || Q.isBJHVideoThreadType()) {
                        title = O[1];
                    }
                    str4 = MessageFormat.format(string, Q.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                }
            } else if (yi.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = yi.cutString(title, 100);
            String cutString2 = yi.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.v = cutString;
            shareItem.w = cutString2;
            if (l1.l0()) {
                shareItem.H = cutString2;
                shareItem.W = -1L;
            } else {
                shareItem.W = l1.R();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = pbModel.F1();
            if (i2 == 2) {
                shareItem.J = pbModel.P0();
            }
            shareItem.I = i2;
            shareItem.K = g(Q);
            shareItem.N = pbModel.getForumId();
            shareItem.O = pbModel.F1();
            shareItem.R = i(l1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
            }
            if (l1.l0()) {
                shareItem.v0 = false;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(Q);
            if (l1 != null && l1.H() != null && l1.H().size() > 0) {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(Q, 1, l1.H().get(0));
            } else {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(Q, 1, null);
            }
            ThreadData threadData = shareItem.a0.threadData;
            if (threadData != null && threadData.getForumData() == null && l1 != null && l1.l() != null) {
                fv4 fv4Var = new fv4();
                fv4Var.i(l1.l().getName());
                fv4Var.a = l1.l().getId();
                fv4Var.c = l1.l().getImage_url();
                shareItem.a0.threadData.setForumData(fv4Var);
            }
            if (Q != null) {
                shareItem.t0 = Q.getShareImageUrl();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putString("uid", shareItem.S);
            shareItem.l(bundle);
            int j = t45.j(Q);
            String forum_name = Q.getForum_name();
            OriginalForumInfo originalForumInfo = Q.mOriginalForumInfo;
            if (originalForumInfo != null) {
                forum_name = originalForumInfo.ori_fname;
            }
            shareItem.J0 = t45.i(Q, j);
            shareItem.K0 = t45.h(Q, j, forum_name, shareItem.W, "", O[1]);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.M() != null && pbFragment.K5() != null) {
                PbModel M = pbFragment.M();
                c98 K5 = pbFragment.K5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] O = M.l1().O();
                PostData O0 = K5.O0();
                String str2 = "";
                if (O0 == null) {
                    str = "";
                } else {
                    str = O0.O();
                    String m = O0.m();
                    if (!yi.isEmpty(m)) {
                        O[1] = m;
                    }
                }
                String firstPostId = M.l1().Q().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(O[1]);
                shareFromPBMsgData.setImageUrl(O[0]);
                shareFromPBMsgData.setForumName(M.l1().l().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(M.l1().Q().getId());
                shareFromPBMsgData.setTitle(M.l1().Q().getTitle());
                return shareFromPBMsgData;
            }
            return null;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadData)) == null) {
            String str = null;
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i++;
            }
            if (str == null && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) {
                return threadData.getThreadVideoInfo().thumbnail_url;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadData)) == null) {
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

    public static int i(y48 y48Var) {
        InterceptResult invokeL;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, y48Var)) == null) {
            if (y48Var != null && (Q = y48Var.Q()) != null) {
                if (Q.isRealGod()) {
                    return 4;
                }
                if (Q.getIsLive() == 1) {
                    return 3;
                }
                if (Q.isRealVideoThread()) {
                    return 2;
                }
                if (Q.isBJHArticleThreadType()) {
                    return 5;
                }
                if (Q.isBJHVideoThreadType()) {
                    return 6;
                }
                if (Q.isBJHNormalThreadType()) {
                    return 7;
                }
                if (!Q.isBJHVideoDynamicThreadType()) {
                    return 1;
                }
                return 8;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void j(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pbFragment, intent) == null) {
            l(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void l(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel M = pbFragment.M();
        ShareFromPBMsgData e = e(pbFragment);
        if (M != null && M.l1() != null && M.l1().Q() != null) {
            wv4 wv4Var = new wv4(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(e);
            wv4Var.setContentViewSize(1);
            wv4Var.setContentView(thread2GroupShareView);
            wv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f11c8, new a(M, pbFragment, thread2GroupShareView, j, str, str2, str3, e));
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new b(pbFragment, thread2GroupShareView));
            wv4Var.setCanceledOnTouchOutside(true);
            wv4Var.create(pbFragment.getPageContext()).show();
            if (!yi.isEmpty(e.getImageUrl())) {
                String imageUrl = e.getImageUrl();
                if (M.l1().s() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void m(Context context, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65549, null, context, threadData, i) == null) && threadData != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, threadData), true));
        }
    }

    public static void n(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65550, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.M() != null && pbFragment.K5() != null) {
            PbModel M = pbFragment.M();
            if (!M.a()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d = d(i, i2, M);
            TbadkCoreApplication.getInst().setShareItem(d);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, M));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.l(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(M.getTopicId());
            if (M.l1().Q().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (M.l1() != null) {
                shareDialogConfig.setShowNovelMask(M.l1().q0());
            }
            qa6.c().l(shareDialogConfig);
        }
    }
}

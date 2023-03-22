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
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.zz4;
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
/* loaded from: classes5.dex */
public class lo8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.w1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.Q1()).param("obj_locate", 1);
                    if (lo8.i(this.a.w1()) != 0) {
                        param.param("obj_type", lo8.i(this.a.w1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            om8 M5 = pbFragment.M5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.w1() != null && this.b.w1().y0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && M5 != null && M5.t1() != null) {
                M5.t1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949716, "Lcom/baidu/tieba/lo8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949716, "Lcom/baidu/tieba/lo8;");
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
        String Q1;
        String str;
        Uri parse;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, pbModel)) == null) {
            ki8 w1 = pbModel.w1();
            String title = w1.Q().getTitle();
            boolean Z0 = pbModel.Z0();
            if (w1.l() != null) {
                if (w1.l().isLike() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AddExperiencedModel.W(w1.m());
                }
            }
            ThreadData Q = pbModel.w1().Q();
            Q.setImShareFromPb(true);
            if (pbModel != null && pbModel.w1() != null) {
                Q.setPbFirstShareData(pbModel.w1().i());
            }
            if (Q.isUgcThreadType()) {
                Q1 = Q.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (Z0 ? 1 : 0) + "&dtype=" + Q.getBaijiahaoData().oriUgcType + "&dvid=" + Q.getBaijiahaoData().oriUgcVid + "&nid=" + Q.getBaijiahaoData().oriUgcNid;
            } else {
                Q1 = pbModel.Q1();
                str = "?share=9105&fr=sharewise&see_lz=" + (Z0 ? 1 : 0);
            }
            String str2 = TbConfig.HTTPS_PB_PREFIX + Q1 + (str + "&share_from=post");
            String[] O = w1.O();
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
                mp8.u("c10399", w1.m(), w1.S(), currentAccount);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (w1.l0() && Q.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(title) || Q.isBJHVideoDynamicThreadType() || Q.isBJHVideoThreadType()) {
                        title = O[1];
                    }
                    str4 = MessageFormat.format(string, Q.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                }
            } else if (gi.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = gi.cutString(title, 100);
            String cutString2 = gi.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.v = cutString;
            shareItem.w = cutString2;
            if (w1.l0()) {
                shareItem.H = cutString2;
                shareItem.W = -1L;
            } else {
                shareItem.W = w1.R();
            }
            shareItem.x = str2;
            shareItem.c = true;
            shareItem.u = pbModel.Q1();
            if (i2 == 2) {
                shareItem.J = pbModel.a1();
            }
            shareItem.I = i2;
            shareItem.K = g(Q);
            shareItem.N = pbModel.getForumId();
            shareItem.O = pbModel.Q1();
            shareItem.R = i(w1);
            shareItem.S = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.z = parse;
            }
            if (w1.l0()) {
                shareItem.v0 = false;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(Q);
            if (w1 != null && w1.H() != null && w1.H().size() > 0) {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(Q, 1, w1.H().get(0));
            } else {
                shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(Q, 1, null);
            }
            ThreadData threadData = shareItem.a0.threadData;
            if (threadData != null && threadData.getForumData() == null && w1 != null && w1.l() != null) {
                iz4 iz4Var = new iz4();
                iz4Var.j(w1.l().getName());
                iz4Var.a = w1.l().getId();
                iz4Var.c = w1.l().getImage_url();
                shareItem.a0.threadData.setForumData(iz4Var);
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
            int j = e95.j(Q);
            String forum_name = Q.getForum_name();
            OriginalForumInfo originalForumInfo = Q.mOriginalForumInfo;
            if (originalForumInfo != null) {
                forum_name = originalForumInfo.ori_fname;
            }
            shareItem.J0 = e95.i(Q, j);
            shareItem.K0 = e95.h(Q, j, forum_name, shareItem.W, "", O[1]);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.L() != null && pbFragment.M5() != null) {
                PbModel L = pbFragment.L();
                om8 M5 = pbFragment.M5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] O = L.w1().O();
                bc9 O0 = M5.O0();
                String str2 = "";
                if (O0 == null) {
                    str = "";
                } else {
                    str = O0.O();
                    String m = O0.m();
                    if (!gi.isEmpty(m)) {
                        O[1] = m;
                    }
                }
                String firstPostId = L.w1().Q().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(O[1]);
                shareFromPBMsgData.setImageUrl(O[0]);
                shareFromPBMsgData.setForumName(L.w1().l().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(L.w1().Q().getId());
                shareFromPBMsgData.setTitle(L.w1().Q().getTitle());
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

    public static int i(ki8 ki8Var) {
        InterceptResult invokeL;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ki8Var)) == null) {
            if (ki8Var != null && (Q = ki8Var.Q()) != null) {
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
        PbModel L = pbFragment.L();
        ShareFromPBMsgData e = e(pbFragment);
        if (L != null && L.w1() != null && L.w1().Q() != null) {
            zz4 zz4Var = new zz4(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(e);
            zz4Var.setContentViewSize(1);
            zz4Var.setContentView(thread2GroupShareView);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1211, new a(L, pbFragment, thread2GroupShareView, j, str, str2, str3, e));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new b(pbFragment, thread2GroupShareView));
            zz4Var.setCanceledOnTouchOutside(true);
            zz4Var.create(pbFragment.getPageContext()).show();
            if (!gi.isEmpty(e.getImageUrl())) {
                String imageUrl = e.getImageUrl();
                if (L.w1().s() == 1) {
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
        if ((interceptable == null || interceptable.invokeLII(65550, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.L() != null && pbFragment.M5() != null) {
            PbModel L = pbFragment.L();
            if (!L.a()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d = d(i, i2, L);
            TbadkCoreApplication.getInst().setShareItem(d);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, L));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.l(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(L.getTopicId());
            if (L.w1().Q().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (L.w1() != null) {
                shareDialogConfig.setShowNovelMask(L.w1().q0());
            }
            dh6.c().l(shareDialogConfig);
        }
    }
}

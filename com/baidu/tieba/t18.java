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
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
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
import com.baidu.tieba.pu4;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class t18 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ yz7 c;

        public a(PbModel pbModel, PbFragment pbFragment, yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, yz7Var};
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
            this.c = yz7Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (pbModel = this.a) != null && pbModel.S1() != null && this.a.S1().x0() && !TbSingleton.getInstance().isNotchScreen(this.b.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.b.getBaseFragmentActivity())) {
                this.c.n1().setSystemUiVisibility(4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements pu4.e {
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

        public b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.S1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.m2()).param("obj_locate", 1);
                    if (t18.i(this.a.S1()) != 0) {
                        param.param("obj_type", t18.i(this.a.S1()));
                    }
                    TiebaStatic.log(param);
                }
                this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ ShareFromPBMsgData f;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView, Long.valueOf(j), str, Long.valueOf(j2), shareFromPBMsgData};
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
            this.c = j;
            this.d = str;
            this.e = j2;
            this.f = shareFromPBMsgData;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.getBaseFragmentActivity(), this.c, this.d, this.e, "from_share", this.b.getLeaveMsg(), this.f.toChatMessageContent())));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class e implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                pu4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948128462, "Lcom/baidu/tieba/t18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948128462, "Lcom/baidu/tieba/t18;");
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
            String format = MessageFormat.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f1163), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.v = title;
            shareItem.w = format;
            shareItem.V = threadData.getView_num();
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
            shareItem.Q = h(threadData);
            if (parse != null) {
                shareItem.z = parse;
            }
            shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            shareItem.q0 = threadData.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.Q);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putInt("obj_source", shareItem.s);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x029f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem d(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String m2;
        String str;
        Uri parse;
        String str2;
        ShareItem shareItem;
        ThreadData threadData;
        ThreadData threadData2;
        OriginalForumInfo originalForumInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, pbModel)) == null) {
            uv7 S1 = pbModel.S1();
            String title = S1.P().getTitle();
            boolean v1 = pbModel.v1();
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
            ThreadData P = pbModel.S1().P();
            P.setImShareFromPb(true);
            if (pbModel != null && pbModel.S1() != null) {
                P.setPbFirstShareData(pbModel.S1().i());
            }
            if (P.isUgcThreadType()) {
                m2 = P.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (v1 ? 1 : 0) + "&dtype=" + P.getBaijiahaoData().oriUgcType + "&dvid=" + P.getBaijiahaoData().oriUgcVid + "&nid=" + P.getBaijiahaoData().oriUgcNid;
            } else {
                m2 = pbModel.m2();
                str = "?share=9105&fr=sharewise&see_lz=" + (v1 ? 1 : 0);
            }
            String str3 = TbConfig.HTTPS_PB_PREFIX + m2 + (str + "&share_from=post");
            String[] N = S1.N();
            String str4 = N[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            if (str4 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str4);
            }
            String str5 = N[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", S1.m()).param("tid", S1.R()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a4);
            if (S1.k0() && P.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || P.isBJHVideoDynamicThreadType() || P.isBJHVideoThreadType()) {
                        title = N[1];
                    }
                    str2 = MessageFormat.format(string, P.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a5));
                    String cutString = ej.cutString(title, 100);
                    String cutString2 = ej.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.v = cutString;
                    shareItem.w = cutString2;
                    if (!S1.k0()) {
                    }
                    shareItem.x = str3;
                    shareItem.c = true;
                    shareItem.u = pbModel.m2();
                    if (i2 == 2) {
                    }
                    shareItem.I = i2;
                    shareItem.K = g(threadData);
                    shareItem.N = pbModel.getForumId();
                    shareItem.O = pbModel.m2();
                    shareItem.Q = i(S1);
                    shareItem.R = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (S1.k0()) {
                    }
                    shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                    if (S1 == null) {
                    }
                    shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                    threadData2 = shareItem.X.threadData;
                    if (threadData2 != null) {
                    }
                    if (threadData != null) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.J);
                    bundle.putInt("obj_type", shareItem.Q);
                    bundle.putString("fid", shareItem.N);
                    bundle.putString("tid", shareItem.O);
                    bundle.putString("uid", shareItem.R);
                    shareItem.k(bundle);
                    int j = k35.j(threadData);
                    String forum_name = threadData.getForum_name();
                    originalForumInfo = threadData.mOriginalForumInfo;
                    if (originalForumInfo != null) {
                    }
                    shareItem.G0 = k35.i(threadData, j);
                    shareItem.H0 = k35.h(threadData, j, forum_name, shareItem.V, "", N[1]);
                    return shareItem;
                }
                str2 = str5;
                String cutString3 = ej.cutString(title, 100);
                String cutString22 = ej.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString3;
                shareItem.w = cutString22;
                if (!S1.k0()) {
                }
                shareItem.x = str3;
                shareItem.c = true;
                shareItem.u = pbModel.m2();
                if (i2 == 2) {
                }
                shareItem.I = i2;
                shareItem.K = g(threadData);
                shareItem.N = pbModel.getForumId();
                shareItem.O = pbModel.m2();
                shareItem.Q = i(S1);
                shareItem.R = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (S1.k0()) {
                }
                shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (S1 == null) {
                }
                shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                threadData2 = shareItem.X.threadData;
                if (threadData2 != null) {
                }
                if (threadData != null) {
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.J);
                bundle2.putInt("obj_type", shareItem.Q);
                bundle2.putString("fid", shareItem.N);
                bundle2.putString("tid", shareItem.O);
                bundle2.putString("uid", shareItem.R);
                shareItem.k(bundle2);
                int j2 = k35.j(threadData);
                String forum_name2 = threadData.getForum_name();
                originalForumInfo = threadData.mOriginalForumInfo;
                if (originalForumInfo != null) {
                }
                shareItem.G0 = k35.i(threadData, j2);
                shareItem.H0 = k35.h(threadData, j2, forum_name2, shareItem.V, "", N[1]);
                return shareItem;
            }
            if (ej.isEmpty(str5)) {
                str2 = title;
                String cutString32 = ej.cutString(title, 100);
                String cutString222 = ej.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString32;
                shareItem.w = cutString222;
                if (!S1.k0()) {
                    shareItem.H = cutString222;
                    threadData = P;
                    shareItem.V = -1L;
                } else {
                    threadData = P;
                    shareItem.V = S1.Q();
                }
                shareItem.x = str3;
                shareItem.c = true;
                shareItem.u = pbModel.m2();
                if (i2 == 2) {
                    shareItem.J = pbModel.w1();
                }
                shareItem.I = i2;
                shareItem.K = g(threadData);
                shareItem.N = pbModel.getForumId();
                shareItem.O = pbModel.m2();
                shareItem.Q = i(S1);
                shareItem.R = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.z = parse;
                }
                if (S1.k0()) {
                    shareItem.s0 = false;
                }
                shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (S1 == null && S1.G() != null && S1.G().size() > 0) {
                    shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, (PostData) S1.G().get(0));
                } else {
                    shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                }
                threadData2 = shareItem.X.threadData;
                if (threadData2 != null && threadData2.getForumData() == null && S1 != null && S1.l() != null) {
                    zt4 zt4Var = new zt4();
                    zt4Var.j(S1.l().getName());
                    zt4Var.a = S1.l().getId();
                    zt4Var.c = S1.l().getImage_url();
                    shareItem.X.threadData.setForumData(zt4Var);
                }
                if (threadData != null) {
                    shareItem.q0 = threadData.getShareImageUrl();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.J);
                bundle22.putInt("obj_type", shareItem.Q);
                bundle22.putString("fid", shareItem.N);
                bundle22.putString("tid", shareItem.O);
                bundle22.putString("uid", shareItem.R);
                shareItem.k(bundle22);
                int j22 = k35.j(threadData);
                String forum_name22 = threadData.getForum_name();
                originalForumInfo = threadData.mOriginalForumInfo;
                if (originalForumInfo != null) {
                    forum_name22 = originalForumInfo.ori_fname;
                }
                shareItem.G0 = k35.i(threadData, j22);
                shareItem.H0 = k35.h(threadData, j22, forum_name22, shareItem.V, "", N[1]);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = ej.cutString(title, 100);
            String cutString2222 = ej.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.v = cutString322;
            shareItem.w = cutString2222;
            if (!S1.k0()) {
            }
            shareItem.x = str3;
            shareItem.c = true;
            shareItem.u = pbModel.m2();
            if (i2 == 2) {
            }
            shareItem.I = i2;
            shareItem.K = g(threadData);
            shareItem.N = pbModel.getForumId();
            shareItem.O = pbModel.m2();
            shareItem.Q = i(S1);
            shareItem.R = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (S1.k0()) {
            }
            shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            if (S1 == null) {
            }
            shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            threadData2 = shareItem.X.threadData;
            if (threadData2 != null) {
                zt4 zt4Var2 = new zt4();
                zt4Var2.j(S1.l().getName());
                zt4Var2.a = S1.l().getId();
                zt4Var2.c = S1.l().getImage_url();
                shareItem.X.threadData.setForumData(zt4Var2);
            }
            if (threadData != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.J);
            bundle222.putInt("obj_type", shareItem.Q);
            bundle222.putString("fid", shareItem.N);
            bundle222.putString("tid", shareItem.O);
            bundle222.putString("uid", shareItem.R);
            shareItem.k(bundle222);
            int j222 = k35.j(threadData);
            String forum_name222 = threadData.getForum_name();
            originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
            }
            shareItem.G0 = k35.i(threadData, j222);
            shareItem.H0 = k35.h(threadData, j222, forum_name222, shareItem.V, "", N[1]);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.K() != null && pbFragment.O5() != null) {
                PbModel K = pbFragment.K();
                yz7 O5 = pbFragment.O5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] N = K.S1().N();
                PostData I0 = O5.I0();
                String str2 = "";
                if (I0 == null) {
                    str = "";
                } else {
                    str = I0.M();
                    String n = I0.n();
                    if (!ej.isEmpty(n)) {
                        N[1] = n;
                    }
                }
                String firstPostId = K.S1().P().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(N[1]);
                shareFromPBMsgData.setImageUrl(N[0]);
                shareFromPBMsgData.setForumName(K.S1().l().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(K.S1().P().getId());
                shareFromPBMsgData.setTitle(K.S1().P().getTitle());
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

    public static int i(uv7 uv7Var) {
        InterceptResult invokeL;
        ThreadData P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uv7Var)) == null) {
            if (uv7Var != null && (P = uv7Var.P()) != null) {
                if (P.isRealGod()) {
                    return 4;
                }
                if (P.getIsLive() == 1) {
                    return 3;
                }
                if (P.isRealVideoThread()) {
                    return 2;
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
                if (!P.isBJHVideoDynamicThreadType()) {
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
            m(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void l(PbFragment pbFragment, long j, String str, long j2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j), str, Long.valueOf(j2)}) != null) || pbFragment == null) {
            return;
        }
        PbModel K = pbFragment.K();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (K != null && K.S1() != null && K.S1().P() != null) {
            pu4 pu4Var = new pu4(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(e2);
            pu4Var.setContentViewSize(1);
            pu4Var.setContentView(thread2GroupShareView);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f115b, new d(pbFragment, thread2GroupShareView, j, str, j2, e2));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new e(pbFragment, thread2GroupShareView));
            pu4Var.setCanceledOnTouchOutside(true);
            pu4Var.create(pbFragment.getPageContext()).show();
            if (!ej.isEmpty(e2.getImageUrl())) {
                String imageUrl = e2.getImageUrl();
                if (K.S1().s() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void m(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel K = pbFragment.K();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (K != null && K.S1() != null && K.S1().P() != null) {
            pu4 pu4Var = new pu4(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(e2);
            pu4Var.setContentViewSize(1);
            pu4Var.setContentView(thread2GroupShareView);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f115b, new b(K, pbFragment, thread2GroupShareView, j, str, str2, str3, e2));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c(pbFragment, thread2GroupShareView));
            pu4Var.setCanceledOnTouchOutside(true);
            pu4Var.create(pbFragment.getPageContext()).show();
            if (!ej.isEmpty(e2.getImageUrl())) {
                String imageUrl = e2.getImageUrl();
                if (K.S1().s() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void n(Context context, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65550, null, context, threadData, i) == null) && threadData != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, threadData), true));
        }
    }

    public static void o(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.K() != null && pbFragment.O5() != null) {
            PbModel K = pbFragment.K();
            yz7 O5 = pbFragment.O5();
            if (!K.a()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(i, i2, K);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(K, pbFragment, O5));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(K.getTopicId());
            if (K.S1().P().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (K.S1() != null) {
                shareDialogConfig.setShowNovelMask(K.S1().p0());
            }
            f46.c().l(shareDialogConfig);
        }
    }
}

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
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.f05;
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
/* loaded from: classes8.dex */
public class s4a {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.s1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.M1()).param("obj_locate", 1);
                    if (s4a.e(this.a.s1()) != 0) {
                        param.param("obj_type", s4a.e(this.a.s1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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
            n1a i7 = pbFragment.i7();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.s1() != null && this.b.s1().y0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && i7 != null && i7.u1() != null) {
                i7.u1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102825, "Lcom/baidu/tieba/s4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102825, "Lcom/baidu/tieba/s4a;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.add(str);
        }
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return a.contains(str);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem b(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        boolean z;
        ThreadData R;
        String M1;
        String str;
        String str2;
        Uri parse;
        String str3;
        String cutString;
        ThreadData threadData;
        OriginalForumInfo originalForumInfo;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, pbModel)) == null) {
            zv9 s1 = pbModel.s1();
            ShareItem shareItem = new ShareItem();
            String title = s1.R().getTitle();
            boolean V0 = pbModel.V0();
            if (s1.n() != null) {
                if (s1.n().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && AddExperiencedModel.T(s1.o())) {
                    z = true;
                    R = pbModel.s1().R();
                    if (R != null) {
                        return shareItem;
                    }
                    R.setImShareFromPb(true);
                    if (pbModel != null && pbModel.s1() != null) {
                        R.setPbFirstShareData(pbModel.s1().k());
                    }
                    if (!rd.isEmpty(R.getShareUrl())) {
                        str2 = R.getShareUrl();
                    } else {
                        if (R.isUgcThreadType()) {
                            M1 = R.getBaijiahaoData().oriUgcTid;
                            str = "?share=9105&fr=dshare&see_lz=" + (V0 ? 1 : 0) + "&dtype=" + R.getBaijiahaoData().oriUgcType + "&dvid=" + R.getBaijiahaoData().oriUgcVid + "&nid=" + R.getBaijiahaoData().oriUgcNid;
                        } else {
                            M1 = pbModel.M1();
                            str = "?share=9105&fr=sharewise&see_lz=" + (V0 ? 1 : 0);
                        }
                        str2 = TbConfig.HTTPS_PB_PREFIX + M1 + (str + "&share_from=post");
                    }
                    String[] O = s1.O();
                    String str4 = O[0];
                    if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str4 = str4.substring(37);
                    }
                    if (str4 == null) {
                        parse = null;
                    } else {
                        parse = Uri.parse(str4);
                    }
                    String str5 = O[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (i == 1) {
                        b6a.D("c10399", s1.o(), s1.T(), currentAccount);
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                    if (s1.a() && R.getAuthor() != null) {
                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                            if (TextUtils.isEmpty(title) || R.isBJHVideoDynamicThreadType() || R.isBJHVideoThreadType()) {
                                title = O[1];
                            }
                            str3 = MessageFormat.format(string, R.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                            String cutString2 = rd.cutString(title, 100);
                            cutString = rd.cutString(str3, 100);
                            if (cutString != null) {
                            }
                            String cutString3 = rd.cutString(cutString, 100);
                            shareItem.title = cutString2;
                            shareItem.content = cutString3;
                            if (!s1.a()) {
                            }
                            shareItem.linkUrl = str2;
                            shareItem.isFromSharePb = true;
                            shareItem.isShowAddExperienceTip = z;
                            shareItem.extData = pbModel.M1();
                            if (i2 == 2) {
                            }
                            shareItem.objSource = i2;
                            shareItem.objParam2 = d(R);
                            shareItem.fid = pbModel.getForumId();
                            shareItem.fName = pbModel.R0();
                            shareItem.tid = pbModel.M1();
                            shareItem.obj_type = e(s1);
                            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                            if (parse != null) {
                            }
                            if (s1.a()) {
                            }
                            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
                            if (s1 == null) {
                            }
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
                            threadData = shareItem.originalThreadInfo.threadData;
                            if (threadData != null) {
                            }
                            if (R != null) {
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("obj_param1", shareItem.objParam1);
                            bundle.putInt("obj_type", shareItem.obj_type);
                            bundle.putString("fid", shareItem.fid);
                            bundle.putString("tid", shareItem.tid);
                            bundle.putString("uid", shareItem.uid);
                            shareItem.setStats(bundle);
                            int j = kb5.j(R);
                            String forum_name = R.getForum_name();
                            originalForumInfo = R.mOriginalForumInfo;
                            if (originalForumInfo != null) {
                            }
                            shareItem.shareH5CardOptimizeTitle = kb5.i(R, j);
                            shareItem.shareH5CardOptimizeContent = kb5.h(R, j, forum_name, shareItem.readCount, "", cutString3);
                            return shareItem;
                        }
                        str3 = str5;
                        String cutString22 = rd.cutString(title, 100);
                        cutString = rd.cutString(str3, 100);
                        if (cutString != null) {
                        }
                        String cutString32 = rd.cutString(cutString, 100);
                        shareItem.title = cutString22;
                        shareItem.content = cutString32;
                        if (!s1.a()) {
                        }
                        shareItem.linkUrl = str2;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.M1();
                        if (i2 == 2) {
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = d(R);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.R0();
                        shareItem.tid = pbModel.M1();
                        shareItem.obj_type = e(s1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                        }
                        if (s1.a()) {
                        }
                        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
                        if (s1 == null) {
                        }
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
                        threadData = shareItem.originalThreadInfo.threadData;
                        if (threadData != null) {
                        }
                        if (R != null) {
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("obj_param1", shareItem.objParam1);
                        bundle2.putInt("obj_type", shareItem.obj_type);
                        bundle2.putString("fid", shareItem.fid);
                        bundle2.putString("tid", shareItem.tid);
                        bundle2.putString("uid", shareItem.uid);
                        shareItem.setStats(bundle2);
                        int j2 = kb5.j(R);
                        String forum_name2 = R.getForum_name();
                        originalForumInfo = R.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                        }
                        shareItem.shareH5CardOptimizeTitle = kb5.i(R, j2);
                        shareItem.shareH5CardOptimizeContent = kb5.h(R, j2, forum_name2, shareItem.readCount, "", cutString32);
                        return shareItem;
                    }
                    if (rd.isEmpty(str5)) {
                        str3 = title;
                        String cutString222 = rd.cutString(title, 100);
                        cutString = rd.cutString(str3, 100);
                        if (cutString != null) {
                            cutString = cutString.replaceAll("[\n\u0000]+", " ").replaceAll("[\n]+", " ");
                        }
                        String cutString322 = rd.cutString(cutString, 100);
                        shareItem.title = cutString222;
                        shareItem.content = cutString322;
                        if (!s1.a()) {
                            shareItem.shareAbstract = cutString322;
                            shareItem.readCount = -1L;
                        } else {
                            shareItem.readCount = s1.S();
                        }
                        shareItem.linkUrl = str2;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.M1();
                        if (i2 == 2) {
                            shareItem.objParam1 = pbModel.W0();
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = d(R);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.R0();
                        shareItem.tid = pbModel.M1();
                        shareItem.obj_type = e(s1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                            shareItem.imageUri = parse;
                        }
                        if (s1.a()) {
                            shareItem.canShareBySmartApp = false;
                        }
                        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
                        if (s1 == null && s1.I() != null && s1.I().size() > 0) {
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, s1.I().get(0));
                        } else {
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
                        }
                        threadData = shareItem.originalThreadInfo.threadData;
                        if (threadData != null && threadData.getForumData() == null && s1 != null && s1.n() != null) {
                            iz4 iz4Var = new iz4();
                            iz4Var.n(s1.n().getName());
                            iz4Var.a = s1.n().getId();
                            iz4Var.c = s1.n().getImage_url();
                            shareItem.originalThreadInfo.threadData.setForumData(iz4Var);
                        }
                        if (R != null) {
                            shareItem.smartAppShareImageUrl = R.getShareImageUrl();
                        }
                        Bundle bundle22 = new Bundle();
                        bundle22.putInt("obj_param1", shareItem.objParam1);
                        bundle22.putInt("obj_type", shareItem.obj_type);
                        bundle22.putString("fid", shareItem.fid);
                        bundle22.putString("tid", shareItem.tid);
                        bundle22.putString("uid", shareItem.uid);
                        shareItem.setStats(bundle22);
                        int j22 = kb5.j(R);
                        String forum_name22 = R.getForum_name();
                        originalForumInfo = R.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                            forum_name22 = originalForumInfo.ori_fname;
                        }
                        shareItem.shareH5CardOptimizeTitle = kb5.i(R, j22);
                        shareItem.shareH5CardOptimizeContent = kb5.h(R, j22, forum_name22, shareItem.readCount, "", cutString322);
                        return shareItem;
                    }
                    str3 = str5;
                    String cutString2222 = rd.cutString(title, 100);
                    cutString = rd.cutString(str3, 100);
                    if (cutString != null) {
                    }
                    String cutString3222 = rd.cutString(cutString, 100);
                    shareItem.title = cutString2222;
                    shareItem.content = cutString3222;
                    if (!s1.a()) {
                    }
                    shareItem.linkUrl = str2;
                    shareItem.isFromSharePb = true;
                    shareItem.isShowAddExperienceTip = z;
                    shareItem.extData = pbModel.M1();
                    if (i2 == 2) {
                    }
                    shareItem.objSource = i2;
                    shareItem.objParam2 = d(R);
                    shareItem.fid = pbModel.getForumId();
                    shareItem.fName = pbModel.R0();
                    shareItem.tid = pbModel.M1();
                    shareItem.obj_type = e(s1);
                    shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (s1.a()) {
                    }
                    shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
                    if (s1 == null) {
                    }
                    shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
                    threadData = shareItem.originalThreadInfo.threadData;
                    if (threadData != null) {
                        iz4 iz4Var2 = new iz4();
                        iz4Var2.n(s1.n().getName());
                        iz4Var2.a = s1.n().getId();
                        iz4Var2.c = s1.n().getImage_url();
                        shareItem.originalThreadInfo.threadData.setForumData(iz4Var2);
                    }
                    if (R != null) {
                    }
                    Bundle bundle222 = new Bundle();
                    bundle222.putInt("obj_param1", shareItem.objParam1);
                    bundle222.putInt("obj_type", shareItem.obj_type);
                    bundle222.putString("fid", shareItem.fid);
                    bundle222.putString("tid", shareItem.tid);
                    bundle222.putString("uid", shareItem.uid);
                    shareItem.setStats(bundle222);
                    int j222 = kb5.j(R);
                    String forum_name222 = R.getForum_name();
                    originalForumInfo = R.mOriginalForumInfo;
                    if (originalForumInfo != null) {
                    }
                    shareItem.shareH5CardOptimizeTitle = kb5.i(R, j222);
                    shareItem.shareH5CardOptimizeContent = kb5.h(R, j222, forum_name222, shareItem.readCount, "", cutString3222);
                    return shareItem;
                }
            }
            z = false;
            R = pbModel.s1().R();
            if (R != null) {
            }
        } else {
            return (ShareItem) invokeIIL.objValue;
        }
    }

    public static ShareFromPBMsgData c(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.l0() != null && pbFragment.i7() != null) {
                PbModel l0 = pbFragment.l0();
                n1a i7 = pbFragment.i7();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] O = l0.s1().O();
                mwa N0 = i7.N0();
                String str2 = "";
                if (N0 == null) {
                    str = "";
                } else {
                    str = N0.U();
                    String n = N0.n();
                    if (!rd.isEmpty(n)) {
                        O[1] = n;
                    }
                }
                String firstPostId = l0.s1().R().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(O[1]);
                shareFromPBMsgData.setImageUrl(O[0]);
                shareFromPBMsgData.setForumName(l0.s1().n().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(l0.s1().R().getId());
                shareFromPBMsgData.setTitle(l0.s1().R().getTitle());
                return shareFromPBMsgData;
            }
            return null;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static int d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
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

    public static int e(zv9 zv9Var) {
        InterceptResult invokeL;
        ThreadData R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, zv9Var)) == null) {
            if (zv9Var != null && (R = zv9Var.R()) != null) {
                if (R.isRealGod()) {
                    return 4;
                }
                if (R.getIsLive() == 1) {
                    return 3;
                }
                if (R.isRealVideoThread()) {
                    return 2;
                }
                if (R.isBJHArticleThreadType()) {
                    return 5;
                }
                if (R.isBJHVideoThreadType()) {
                    return 6;
                }
                if (R.isBJHNormalThreadType()) {
                    return 7;
                }
                if (!R.isBJHVideoDynamicThreadType()) {
                    return 1;
                }
                return 8;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void f(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, pbFragment, intent) == null) {
            h(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void h(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel l0 = pbFragment.l0();
        ShareFromPBMsgData c2 = c(pbFragment);
        if (l0 != null && l0.s1() != null && l0.s1().R() != null) {
            f05 f05Var = new f05(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(c2);
            f05Var.setContentViewSize(1);
            f05Var.setContentView(thread2GroupShareView);
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13d8, new a(l0, pbFragment, thread2GroupShareView, j, str, str2, str3, c2));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(pbFragment, thread2GroupShareView));
            f05Var.setCanceledOnTouchOutside(true);
            f05Var.create(pbFragment.getPageContext()).show();
            if (!rd.isEmpty(c2.getImageUrl())) {
                String imageUrl = c2.getImageUrl();
                if (l0.s1().u() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void i(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65545, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.l0() != null && pbFragment.i7() != null) {
            PbModel l0 = pbFragment.l0();
            if (!l0.d()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem b2 = b(i, i2, l0);
            TbadkCoreApplication.getInst().setShareItem(b2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), b2, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, l0));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.setStats(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(l0.getTopicId());
            if (l0.s1().R().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (l0.s1() != null && l0.s1().R() != null) {
                shareDialogConfig.setShowMask(l0.s1().R().isDisableShare());
                shareDialogConfig.setDisableShareToast(l0.s1().R().getDisableShareToast());
            }
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
        }
    }
}

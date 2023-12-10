package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes7.dex */
public class n1a {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public static boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65565, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends nu5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbModel b;

        public a(int i, PbModel pbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), pbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ShareSwitch.isOn()) {
                    i = 1;
                } else {
                    i = 6;
                }
                return t4a.b(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements st5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;

        public b(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.setStats(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a, this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ String c;

        public c(boolean z, PbFragment pbFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), pbFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = pbFragment;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u2a.j(this.a, this.b.getListView(), this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947950987, "Lcom/baidu/tieba/n1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947950987, "Lcom/baidu/tieba/n1a;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        a = new int[]{R.string.obfuscated_res_0x7f0f127f};
    }

    public static void A(aw9 aw9Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, aw9Var, str, str2) == null) && aw9Var != null && aw9Var.R() != null && aw9Var.R().isQuestionThread()) {
            ThreadData R = aw9Var.R();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", R.getId()).param("fid", R.getFid()).param("obj_source", i));
        }
    }

    public static boolean E(aw9 aw9Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{aw9Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || aw9Var == null) {
                return false;
            }
            if (aw9Var.n() != null && aw9Var.n().isBlockBawuDelete) {
                return false;
            }
            if ((aw9Var.R() != null && aw9Var.R().getAuthor() != null && aw9Var.R().getAuthor().isForumBusinessAccount() && !xt7.isOn()) || z2) {
                return false;
            }
            if ((aw9Var.R() != null && aw9Var.R().isBlocked()) || aw9Var.Z() == 0 || aw9Var.Z() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void B(PbFragment pbFragment, boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{pbFragment, Boolean.valueOf(z), str}) != null) || pbFragment == null) {
            return;
        }
        if (z(pbFragment)) {
            SafeHandler.getInst().post(new c(z, pbFragment, str));
        } else {
            u2a.j(z, pbFragment.getListView(), str);
        }
    }

    public static void C(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.I8(i);
        }
    }

    public static mwa f(aw9 aw9Var, String str) {
        InterceptResult invokeLL;
        mwa C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, aw9Var, str)) == null) {
            if (TextUtils.isEmpty(str) || aw9Var == null || (C = aw9Var.C()) == null || !str.equals(C.I1())) {
                return null;
            }
            return C;
        }
        return (mwa) invokeLL.objValue;
    }

    public static String p(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static boolean D(aw9 aw9Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        nx4 nx4Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aw9Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (aw9Var == null) {
                return false;
            }
            ThreadData R = aw9Var.R();
            if (R != null) {
                if (R.isBJHArticleThreadType() || R.isBJHVideoThreadType()) {
                    return false;
                }
                if (R.isBJHNormalThreadType() || R.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((R != null && R.getAuthor() != null && R.getAuthor().isForumBusinessAccount() && !xt7.isOn()) || z3 || R.isWorksInfo() || R.isScoreThread() || z2) {
                return false;
            }
            if (aw9Var.n() != null && aw9Var.n().isBlockBawuDelete) {
                return false;
            }
            if (aw9Var.R() != null && aw9Var.R().isBlocked()) {
                return false;
            }
            if (aw9Var.Z() != 0) {
                if (aw9Var.Z() == 3) {
                    return false;
                }
                return true;
            }
            List<iz4> r = aw9Var.r();
            if (ListUtils.getCount(r) <= 0) {
                return false;
            }
            for (iz4 iz4Var : r) {
                if (iz4Var != null && (nx4Var = iz4Var.h) != null && nx4Var.a && !nx4Var.c && ((i = nx4Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean F(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            if (z) {
                return false;
            }
            if (z4 || z5) {
                return true;
            }
            if (!z2 || (!z3 && !w(i))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void a(Context context, aw9 aw9Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, aw9Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && aw9Var != null && aw9Var.R() != null) {
            ThreadData R = aw9Var.R();
            R.mRecomAbTag = str2;
            R.mRecomWeight = str3;
            R.mRecomSource = str4;
            R.mRecomExtra = str5;
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(str, 0L));
            }
            StatisticItem i = cp5.i(context, R, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = cp5.l(context);
            if (l != null && "a008".equals(l.locatePage)) {
                i.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l != null && "a002".equals(l.locatePage)) {
                i.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i != null) {
                i.param(TiebaStatic.Params.REPLY_TYPE, 1);
                xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                A(aw9Var, str6, str7);
            }
        }
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, tbPageContext, i)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    return true;
                }
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static Intent j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent(context, DealIntentService.class);
                intent.putExtra("class", 1);
                intent.putExtra("id", str);
                intent.putExtra("from", "nas");
                intent.putExtra("key_start_from", 5);
                return intent;
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static boolean y(aw9 aw9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65567, null, aw9Var, z)) == null) {
            if (aw9Var == null || aw9Var.R() == null || aw9Var.R().getAuthor() == null || TextUtils.equals(aw9Var.R().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static void c(String str, aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, aw9Var) == null) && aw9Var != null && aw9Var.R() != null && aw9Var.R().isUgcThreadType()) {
            ThreadData R = aw9Var.R();
            int i = 0;
            if (R.isBJHArticleThreadType()) {
                i = 1;
            } else if (R.isBJHVideoThreadType()) {
                i = 2;
            } else if (R.isBJHNormalThreadType()) {
                i = 3;
            } else if (R.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean v(aw9 aw9Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, aw9Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (aw9Var.Y() != null && (forumToolAuth = aw9Var.Y().getForumToolAuth()) != null) {
                for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return a[0];
        }
        return invokeV.intValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString e(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1964);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f142e);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new t65(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static boolean g(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().X();
        }
        return invokeL.booleanValue;
    }

    public static boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().Y();
        }
        return invokeL.booleanValue;
    }

    public static String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return null;
            }
            return tbRichTextData.V().S();
        }
        return (String) invokeL.objValue;
    }

    public static long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return 0L;
            }
            return tbRichTextData.V().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean u(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.U6() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int i(PbFragment pbFragment) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.getActivity() != null) {
                i = BdUtilHelper.getDimens(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070421);
            } else {
                i = 0;
            }
            if (i == 0) {
                i = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070421);
            }
            return UtilHelper.getLightStatusBarHeight() + i;
        }
        return invokeL.intValue;
    }

    public static boolean t(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, aw9Var)) == null) {
            if (aw9Var != null && aw9Var.R() != null) {
                SpannableStringBuilder span_str = aw9Var.R().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f101a).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int q(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, aw9Var)) == null) {
            if (aw9Var == null || aw9Var.R() == null) {
                return 0;
            }
            if (aw9Var.R().isMutiForumThread()) {
                if (ListUtils.isEmpty(aw9Var.r()) && (aw9Var.j() == null || StringUtils.isNull(aw9Var.j().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int r(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, aw9Var)) == null) {
            if (aw9Var != null && aw9Var.R() != null) {
                if (aw9Var.R().getThreadType() == 0) {
                    return 1;
                }
                if (aw9Var.R().getThreadType() == 54) {
                    return 2;
                }
                if (aw9Var.R().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void s(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            ru5.b(new a(i2, pbModel), new b(context, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}

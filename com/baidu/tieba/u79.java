package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
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
import java.util.Iterator;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes8.dex */
public class u79 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65565, null, i)) == null) {
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

    /* loaded from: classes8.dex */
    public static class a extends ix5<ShareItem> {
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
        @Override // com.baidu.tieba.ix5
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
                return v99.c(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements mw5<ShareItem> {
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
        @Override // com.baidu.tieba.mw5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.r(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a, this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ String c;

        public c(int i, PbFragment pbFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), pbFragment, str};
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
            this.b = pbFragment;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w89.i(this.a, this.b.getListView(), this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w89.g(this.a.getListView());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164050, "Lcom/baidu/tieba/u79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164050, "Lcom/baidu/tieba/u79;");
                return;
            }
        }
        a = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        b = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        c = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        d = new int[]{R.string.obfuscated_res_0x7f0f11ef};
    }

    public static boolean C(m39 m39Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, m39Var, z)) == null) {
            if (m39Var == null || m39Var.N() == null || m39Var.N().getAuthor() == null || TextUtils.equals(m39Var.N().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, tbPageContext, i)) == null) {
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

    public static Intent m(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) {
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

    public static boolean D(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.v5() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void F(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, pbFragment) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            pbFragment.w0 = true;
            wg.a().post(new d(pbFragment));
            return;
        }
        w89.g(pbFragment.getListView());
    }

    public static void I(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, textView) == null) && textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }

    public static boolean j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.c0() == null) {
                return false;
            }
            return tbRichTextData.c0().b0();
        }
        return invokeL.booleanValue;
    }

    public static boolean k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.c0() == null) {
                return false;
            }
            return tbRichTextData.c0().c0();
        }
        return invokeL.booleanValue;
    }

    public static String n(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.c0() == null) {
                return null;
            }
            return tbRichTextData.c0().X();
        }
        return (String) invokeL.objValue;
    }

    public static long o(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.c0() == null) {
                return 0L;
            }
            return tbRichTextData.c0().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void E(m39 m39Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, m39Var, str, str2) == null) && m39Var != null && m39Var.N() != null && m39Var.N().isQuestionThread()) {
            ThreadData N = m39Var.N();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", N.getId()).param("fid", N.getFid()).param("obj_source", i));
        }
    }

    public static boolean L(m39 m39Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{m39Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || m39Var == null) {
                return false;
            }
            if (m39Var.k() != null && m39Var.k().isBlockBawuDelete) {
                return false;
            }
            if ((m39Var.N() != null && m39Var.N().getAuthor() != null && m39Var.N().getAuthor().isForumBusinessAccount() && !we7.isOn()) || z2) {
                return false;
            }
            if ((m39Var.N() != null && m39Var.N().isBlocked()) || m39Var.V() == 0 || m39Var.V() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void G(PbFragment pbFragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65543, null, pbFragment, i, str) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            wg.a().post(new c(i, pbFragment, str));
        } else {
            w89.i(i, pbFragment.getListView(), str);
        }
    }

    public static void H(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.K6(i);
        }
    }

    public static iy9 i(m39 m39Var, String str) {
        InterceptResult invokeLL;
        iy9 z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, m39Var, str)) == null) {
            if (TextUtils.isEmpty(str) || m39Var == null || (z = m39Var.z()) == null || !str.equals(z.t1())) {
                return null;
            }
            return z;
        }
        return (iy9) invokeLL.objValue;
    }

    public static String t(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65569, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static void J(Context context, m39 m39Var) {
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, context, m39Var) == null) && m39Var != null && context != null) {
            long c2 = mf5.c();
            if (c2 <= 0 || (h = b98.n().h(String.valueOf(c2), 2)) == null || z88.a(context)) {
                return;
            }
            MetaData metaData = new MetaData();
            metaData.setUserIdLong(c2);
            metaData.setUserName(h.getGroup_name());
            metaData.setName_show(h.getNameShow());
            metaData.setPortrait(h.getGroup_head());
            int i = 1;
            if (h.getIsFriend() != 1) {
                i = 0;
            }
            metaData.setIsMyFriend(i);
            ia8 ia8Var = new ia8(context, new na8(context));
            ia8Var.j(m39Var.N(), metaData);
            ia8Var.k();
        }
    }

    public static boolean K(m39 m39Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        n25 n25Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{m39Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (m39Var == null) {
                return false;
            }
            ThreadData N = m39Var.N();
            if (N != null) {
                if (N.isBJHArticleThreadType() || N.isBJHVideoThreadType()) {
                    return false;
                }
                if (N.isBJHNormalThreadType() || N.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((N != null && N.getAuthor() != null && N.getAuthor().isForumBusinessAccount() && !we7.isOn()) || z3 || N.isWorksInfo() || N.isScoreThread() || z2) {
                return false;
            }
            if (m39Var.k() != null && m39Var.k().isBlockBawuDelete) {
                return false;
            }
            if (m39Var.N() != null && m39Var.N().isBlocked()) {
                return false;
            }
            if (m39Var.V() != 0) {
                if (m39Var.V() == 3) {
                    return false;
                }
                return true;
            }
            List<j45> o = m39Var.o();
            if (ListUtils.getCount(o) <= 0) {
                return false;
            }
            for (j45 j45Var : o) {
                if (j45Var != null && (n25Var = j45Var.h) != null && n25Var.a && !n25Var.c && ((i = n25Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean M(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            if (z) {
                return false;
            }
            if (z4 || z5) {
                return true;
            }
            if (!z2 || (!z3 && !A(i))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static int q(int i, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            if (z) {
                i6 = a;
            } else {
                i6 = 0;
            }
            return ((((i - i2) - i3) - i4) - i5) - i6;
        }
        return invokeCommon.intValue;
    }

    public static void a(Context context, m39 m39Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, m39Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && m39Var != null && m39Var.N() != null) {
            ThreadData N = m39Var.N();
            N.mRecomAbTag = str2;
            N.mRecomWeight = str3;
            N.mRecomSource = str4;
            N.mRecomExtra = str5;
            if (N.getFid() == 0) {
                N.setFid(tg.g(str, 0L));
            }
            StatisticItem i = rr5.i(context, N, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = rr5.l(context);
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
                mr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                E(m39Var, str6, str7);
            }
        }
    }

    public static void b(@NonNull ImageView imageView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{imageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                imageView.setImageResource(R.drawable.pic_frs_headlines_n);
                imageView.setVisibility(0);
            } else if (z2 && z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0811b6);
                imageView.setVisibility(0);
            } else if (z2) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0811b4);
                imageView.setVisibility(0);
            } else if (z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0811b5);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (imageView.getVisibility() == 0 && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().height = r() - s();
            }
        }
    }

    public static void d(List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<vn> it = list.iterator();
        while (it.hasNext()) {
            vn next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof iy9) && !(next instanceof m66)) {
                if ((next instanceof jy9) && ((jy9) next).w0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int u(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, m39Var)) == null) {
            if (m39Var == null || m39Var.N() == null) {
                return 0;
            }
            if (m39Var.N().isMutiForumThread()) {
                if (ListUtils.isEmpty(m39Var.o()) && (m39Var.g() == null || StringUtils.isNull(m39Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int v(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, m39Var)) == null) {
            if (m39Var != null && m39Var.N() != null) {
                if (m39Var.N().getThreadType() == 0) {
                    return 1;
                }
                if (m39Var.N().getThreadType() == 54) {
                    return 2;
                }
                if (m39Var.N().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(List<vn> list, iy9 iy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65554, null, list, iy9Var) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<vn> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            vn next = it.next();
            hy9 hy9Var = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof m66)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                hy9Var = ((ThreadData) next).funAdData;
            } else if (next instanceof jy9) {
                hy9Var = ((jy9) next).w0;
            }
            if (hy9Var != null && hy9Var.i()) {
                i2 = i;
            }
            if (iy9Var != null && next == iy9Var) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void f(String str, m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, str, m39Var) == null) && m39Var != null && m39Var.N() != null && m39Var.N().isUgcThreadType()) {
            ThreadData N = m39Var.N();
            int i = 0;
            if (N.isBJHArticleThreadType()) {
                i = 1;
            } else if (N.isBJHVideoThreadType()) {
                i = 2;
            } else if (N.isBJHNormalThreadType()) {
                i = 3;
            } else if (N.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean z(m39 m39Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65575, null, m39Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (m39Var.U() != null && (forumToolAuth = m39Var.U().getForumToolAuth()) != null) {
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

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return d[0];
        }
        return invokeV.intValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString h(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f18ef);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1395);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new bb5(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void w(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            mx5.b(new a(i2, pbModel), new b(context, i));
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

    public static boolean x(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, m39Var)) == null) {
            if (m39Var != null && m39Var.N() != null) {
                SpannableStringBuilder span_str = m39Var.N().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f92).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

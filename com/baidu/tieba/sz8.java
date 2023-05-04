package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes6.dex */
public class sz8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
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

    public static boolean y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65573, null, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class a extends vr5<ShareItem> {
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
        @Override // com.baidu.tieba.vr5
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
                return q19.c(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements zq5<ShareItem> {
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
        @Override // com.baidu.tieba.zq5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.l(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a, this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                s09.i(this.a, this.b.getListView(), this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                s09.g(this.a.getListView());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948168824, "Lcom/baidu/tieba/sz8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948168824, "Lcom/baidu/tieba/sz8;");
                return;
            }
        }
        a = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        b = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        c = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        d = new int[]{R.string.obfuscated_res_0x7f0f10d6};
    }

    public static boolean A(qv8 qv8Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, qv8Var, z)) == null) {
            if (qv8Var == null || qv8Var.M() == null || qv8Var.M().getAuthor() == null || TextUtils.equals(qv8Var.M().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, tbPageContext, i)) == null) {
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

    public static Intent l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent(context, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 1);
                intent.putExtra("id", str);
                intent.putExtra("from", "nas");
                intent.putExtra("key_start_from", 5);
                return intent;
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static boolean B(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.t5() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void D(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment) != null) || pbFragment == null) {
            return;
        }
        if (B(pbFragment)) {
            pbFragment.v0 = true;
            jg.a().post(new d(pbFragment));
            return;
        }
        s09.g(pbFragment.getListView());
    }

    public static void G(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, textView) == null) && textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }

    public static boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().c0();
        }
        return invokeL.booleanValue;
    }

    public static boolean j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().d0();
        }
        return invokeL.booleanValue;
    }

    public static String m(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return null;
            }
            return tbRichTextData.d0().Y();
        }
        return (String) invokeL.objValue;
    }

    public static long n(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return 0L;
            }
            return tbRichTextData.d0().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean w(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void C(qv8 qv8Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, qv8Var, str, str2) == null) && qv8Var != null && qv8Var.M() != null && qv8Var.M().isQuestionThread()) {
            ThreadData M = qv8Var.M();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", M.getId()).param("fid", M.getFid()).param("obj_source", i));
        }
    }

    public static boolean J(qv8 qv8Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{qv8Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || qv8Var == null) {
                return false;
            }
            if (qv8Var.k() != null && qv8Var.k().isBlockBawuDelete) {
                return false;
            }
            if ((qv8Var.M() != null && qv8Var.M().getAuthor() != null && qv8Var.M().getAuthor().isForumBusinessAccount() && !d87.isOn()) || z2) {
                return false;
            }
            if ((qv8Var.M() != null && qv8Var.M().isBlocked()) || qv8Var.U() == 0 || qv8Var.U() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void E(PbFragment pbFragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65541, null, pbFragment, i, str) != null) || pbFragment == null) {
            return;
        }
        if (B(pbFragment)) {
            jg.a().post(new c(i, pbFragment, str));
        } else {
            s09.i(i, pbFragment.getListView(), str);
        }
    }

    public static void F(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65542, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.H6(i);
        }
    }

    public static op9 h(qv8 qv8Var, String str) {
        InterceptResult invokeLL;
        op9 z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, qv8Var, str)) == null) {
            if (TextUtils.isEmpty(str) || qv8Var == null || (z = qv8Var.z()) == null || !str.equals(z.t1())) {
                return null;
            }
            return z;
        }
        return (op9) invokeLL.objValue;
    }

    public static String s(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65566, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static void H(Context context, qv8 qv8Var) {
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, context, qv8Var) == null) && qv8Var != null && context != null) {
            long c2 = za5.c();
            if (c2 <= 0 || (h = v18.n().h(String.valueOf(c2), 2)) == null || t18.a(context)) {
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
            c38 c38Var = new c38(context, new g38(context));
            c38Var.j(qv8Var.M(), metaData);
            c38Var.k();
        }
    }

    public static boolean I(qv8 qv8Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        gy4 gy4Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{qv8Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (qv8Var == null) {
                return false;
            }
            ThreadData M = qv8Var.M();
            if (M != null) {
                if (M.isBJHArticleThreadType() || M.isBJHVideoThreadType()) {
                    return false;
                }
                if (M.isBJHNormalThreadType() || M.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((M != null && M.getAuthor() != null && M.getAuthor().isForumBusinessAccount() && !d87.isOn()) || z3 || M.isWorksInfo() || M.isScoreThread() || z2) {
                return false;
            }
            if (qv8Var.k() != null && qv8Var.k().isBlockBawuDelete) {
                return false;
            }
            if (qv8Var.M() != null && qv8Var.M().isBlocked()) {
                return false;
            }
            if (qv8Var.U() != 0) {
                if (qv8Var.U() == 3) {
                    return false;
                }
                return true;
            }
            List<b05> o = qv8Var.o();
            if (ListUtils.getCount(o) <= 0) {
                return false;
            }
            for (b05 b05Var : o) {
                if (b05Var != null && (gy4Var = b05Var.f) != null && gy4Var.a && !gy4Var.c && ((i = gy4Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean K(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            if (z) {
                return false;
            }
            if (z4 || z5) {
                return true;
            }
            if (!z2 || (!z3 && !y(i))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static int p(int i, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            if (z) {
                i6 = a;
            } else {
                i6 = 0;
            }
            return ((((i - i2) - i3) - i4) - i5) - i6;
        }
        return invokeCommon.intValue;
    }

    public static void a(Context context, qv8 qv8Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, qv8Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && qv8Var != null && qv8Var.M() != null) {
            ThreadData M = qv8Var.M();
            M.mRecomAbTag = str2;
            M.mRecomWeight = str3;
            M.mRecomSource = str4;
            M.mRecomExtra = str5;
            if (M.getFid() == 0) {
                M.setFid(gg.g(str, 0L));
            }
            StatisticItem i = em5.i(context, M, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = em5.l(context);
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
                zl5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                C(qv8Var, str6, str7);
            }
        }
    }

    public static void c(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<in> it = list.iterator();
        while (it.hasNext()) {
            in next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof op9) && !(next instanceof x06)) {
                if ((next instanceof pp9) && ((pp9) next).w0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int t(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, qv8Var)) == null) {
            if (qv8Var == null || qv8Var.M() == null) {
                return 0;
            }
            if (qv8Var.M().isMutiForumThread()) {
                if (ListUtils.isEmpty(qv8Var.o()) && (qv8Var.g() == null || StringUtils.isNull(qv8Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int u(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, qv8Var)) == null) {
            if (qv8Var != null && qv8Var.M() != null) {
                if (qv8Var.M().getThreadType() == 0) {
                    return 1;
                }
                if (qv8Var.M().getThreadType() == 54) {
                    return 2;
                }
                if (qv8Var.M().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void d(List<in> list, op9 op9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, list, op9Var) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<in> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            in next = it.next();
            np9 np9Var = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof x06)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                np9Var = ((ThreadData) next).funAdData;
            } else if (next instanceof pp9) {
                np9Var = ((pp9) next).w0;
            }
            if (np9Var != null && np9Var.i()) {
                i2 = i;
            }
            if (op9Var != null && next == op9Var) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void e(String str, qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, str, qv8Var) == null) && qv8Var != null && qv8Var.M() != null && qv8Var.M().isUgcThreadType()) {
            ThreadData M = qv8Var.M();
            int i = 0;
            if (M.isBJHArticleThreadType()) {
                i = 1;
            } else if (M.isBJHVideoThreadType()) {
                i = 2;
            } else if (M.isBJHNormalThreadType()) {
                i = 3;
            } else if (M.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean x(qv8 qv8Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, qv8Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (qv8Var.T() != null && (forumToolAuth = qv8Var.T().getForumToolAuth()) != null) {
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

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return d[0];
        }
        return invokeV.intValue;
    }

    public static int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString g(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1791);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1274);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new u65(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void v(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            zr5.b(new a(i2, pbModel), new b(context, i));
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

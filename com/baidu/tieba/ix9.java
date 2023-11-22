package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.adapter.underlayer.StatOnceSet;
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
import tbclient.SpriteMemeInfo;
/* loaded from: classes6.dex */
public class ix9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
    }

    public static int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i)) == null) {
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

    /* loaded from: classes6.dex */
    public class a extends bu5<ShareItem> {
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
        @Override // com.baidu.tieba.bu5
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
                return sz9.b(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gt5<ShareItem> {
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
        @Override // com.baidu.tieba.gt5
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
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
                oy9.j(this.a, this.b.getListView(), this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ int b;

        public d(PbFragment pbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ix9.H(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ SpriteMemeInfo c;
        public final /* synthetic */ vra d;

        public e(View.OnClickListener onClickListener, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, SpriteMemeInfo spriteMemeInfo, vra vraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, pbCommenFloorItemViewHolder, spriteMemeInfo, vraVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
            this.b = pbCommenFloorItemViewHolder;
            this.c = spriteMemeInfo;
            this.d = vraVar;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (onClickListener = this.a) != null) {
                onClickListener.onClick(this.b.H0);
                String str = this.c.use_same_guide;
                vra vraVar = this.d;
                ix9.N(2, str, vraVar.B0, String.valueOf(vraVar.p0()));
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onClickListener = this.a) != null) {
                onClickListener.onClick(this.b.H0);
                String str = this.c.use_same_text;
                vra vraVar = this.d;
                ix9.N(2, str, vraVar.B0, String.valueOf(vraVar.p0()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMemeInfo a;
        public final /* synthetic */ vra b;

        public f(SpriteMemeInfo spriteMemeInfo, vra vraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemeInfo, vraVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMemeInfo;
            this.b = vraVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.a.use_same_guide;
                vra vraVar = this.b;
                ix9.N(1, str, vraVar.B0, String.valueOf(vraVar.p0()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947869023, "Lcom/baidu/tieba/ix9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947869023, "Lcom/baidu/tieba/ix9;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        a = new int[]{R.string.obfuscated_res_0x7f0f126e};
    }

    public static boolean A(es9 es9Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, es9Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (es9Var.V() != null && (forumToolAuth = es9Var.V().getForumToolAuth()) != null) {
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

    public static void f(List<oi> list, ura uraVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, list, uraVar) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<oi> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            oi next = it.next();
            tra traVar = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof a36)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                traVar = ((ThreadData) next).funAdData;
            } else if (next instanceof vra) {
                traVar = ((vra) next).z0;
            }
            if (traVar != null && traVar.i()) {
                i2 = i;
            }
            if (uraVar != null && next == uraVar) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void g(String str, es9 es9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, str, es9Var) == null) && es9Var != null && es9Var.O() != null && es9Var.O().isUgcThreadType()) {
            ThreadData O = es9Var.O();
            int i = 0;
            if (O.isBJHArticleThreadType()) {
                i = 1;
            } else if (O.isBJHVideoThreadType()) {
                i = 2;
            } else if (O.isBJHNormalThreadType()) {
                i = 3;
            } else if (O.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean D(es9 es9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, es9Var, z)) == null) {
            if (es9Var == null || es9Var.O() == null || es9Var.O().getAuthor() == null || TextUtils.equals(es9Var.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean d(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, tbPageContext, i)) == null) {
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

    public static Intent o(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
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

    public static boolean E(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.I6() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.W() == null) {
                return false;
            }
            return tbRichTextData.W().X();
        }
        return invokeL.booleanValue;
    }

    public static boolean m(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.W() == null) {
                return false;
            }
            return tbRichTextData.W().Y();
        }
        return invokeL.booleanValue;
    }

    public static String p(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.W() == null) {
                return null;
            }
            return tbRichTextData.W().S();
        }
        return (String) invokeL.objValue;
    }

    public static long q(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.W() == null) {
                return 0L;
            }
            return tbRichTextData.W().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void F(es9 es9Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, es9Var, str, str2) == null) && es9Var != null && es9Var.O() != null && es9Var.O().isQuestionThread()) {
            ThreadData O = es9Var.O();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i));
        }
    }

    public static boolean L(es9 es9Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{es9Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || es9Var == null) {
                return false;
            }
            if (es9Var.k() != null && es9Var.k().isBlockBawuDelete) {
                return false;
            }
            if ((es9Var.O() != null && es9Var.O().getAuthor() != null && es9Var.O().getAuthor().isForumBusinessAccount() && !gr7.isOn()) || z2) {
                return false;
            }
            if ((es9Var.O() != null && es9Var.O().isBlocked()) || es9Var.W() == 0 || es9Var.W() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void G(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65543, null, pbFragment, i) != null) || pbFragment == null) {
            return;
        }
        if (E(pbFragment)) {
            pbFragment.w0 = true;
            SafeHandler.getInst().post(new d(pbFragment, i));
            return;
        }
        H(pbFragment, i);
    }

    public static void H(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, pbFragment, i) == null) {
            if (i > 0) {
                oy9.i(pbFragment.getListView(), i);
            } else {
                oy9.g(pbFragment.getListView());
            }
        }
    }

    public static void J(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65546, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.u8(i);
        }
    }

    public static ura k(es9 es9Var, String str) {
        InterceptResult invokeLL;
        ura z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, es9Var, str)) == null) {
            if (TextUtils.isEmpty(str) || es9Var == null || (z = es9Var.z()) == null || !str.equals(z.G1())) {
                return null;
            }
            return z;
        }
        return (ura) invokeLL.objValue;
    }

    public static String u(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65571, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static void I(PbFragment pbFragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65545, null, pbFragment, i, str) != null) || pbFragment == null) {
            return;
        }
        if (E(pbFragment)) {
            SafeHandler.getInst().post(new c(i, pbFragment, str));
        } else {
            oy9.j(i, pbFragment.getListView(), str);
        }
    }

    public static boolean K(es9 es9Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        ix4 ix4Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{es9Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (es9Var == null) {
                return false;
            }
            ThreadData O = es9Var.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !gr7.isOn()) || z3 || O.isWorksInfo() || O.isScoreThread() || z2) {
                return false;
            }
            if (es9Var.k() != null && es9Var.k().isBlockBawuDelete) {
                return false;
            }
            if (es9Var.O() != null && es9Var.O().isBlocked()) {
                return false;
            }
            if (es9Var.W() != 0) {
                if (es9Var.W() == 3) {
                    return false;
                }
                return true;
            }
            List<dz4> o = es9Var.o();
            if (ListUtils.getCount(o) <= 0) {
                return false;
            }
            for (dz4 dz4Var : o) {
                if (dz4Var != null && (ix4Var = dz4Var.h) != null && ix4Var.a && !ix4Var.c && ((i = ix4Var.b) == 1 || i == 2)) {
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
            if (!z2 || (!z3 && !B(i))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void N(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            rf5 rf5Var = new rf5();
            rf5Var.l(i);
            rf5Var.i(str);
            rf5Var.g(str2);
            rf5Var.k(str3);
            qf5.a.a(rf5Var);
        }
    }

    public static void b(Context context, es9 es9Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, es9Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && es9Var != null && es9Var.O() != null) {
            ThreadData O = es9Var.O();
            O.mRecomAbTag = str2;
            O.mRecomWeight = str3;
            O.mRecomSource = str4;
            O.mRecomExtra = str5;
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(str, 0L));
            }
            StatisticItem i = qo5.i(context, O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = qo5.l(context);
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
                lo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                F(es9Var, str6, str7);
            }
        }
    }

    public static void c(@NonNull ImageView imageView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{imageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                imageView.setImageResource(R.drawable.pic_frs_headlines_n);
                imageView.setVisibility(0);
            } else if (z2 && z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081251);
                imageView.setVisibility(0);
            } else if (z2) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08124f);
                imageView.setVisibility(0);
            } else if (z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081250);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (imageView.getVisibility() == 0 && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().height = s() - t();
            }
        }
    }

    public static void e(List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<oi> it = list.iterator();
        while (it.hasNext()) {
            oi next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof ura) && !(next instanceof a36)) {
                if ((next instanceof vra) && ((vra) next).z0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int v(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, es9Var)) == null) {
            if (es9Var == null || es9Var.O() == null) {
                return 0;
            }
            if (es9Var.O().isMutiForumThread()) {
                if (ListUtils.isEmpty(es9Var.o()) && (es9Var.g() == null || StringUtils.isNull(es9Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int w(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, es9Var)) == null) {
            if (es9Var != null && es9Var.O() != null) {
                if (es9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (es9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (es9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void h(@NonNull PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, @NonNull vra vraVar, @Nullable View.OnClickListener onClickListener, @NonNull StatOnceSet<String> statOnceSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65558, null, pbCommenFloorItemViewHolder, vraVar, onClickListener, statOnceSet) != null) || pbCommenFloorItemViewHolder.H0 == null) {
            return;
        }
        if (!vraVar.H0() && zf5.isOn()) {
            pbCommenFloorItemViewHolder.H0.setVisibility(8);
            return;
        }
        SpriteMemeInfo i0 = vraVar.i0();
        if (i0 == null) {
            return;
        }
        pbCommenFloorItemViewHolder.H0.a(new SpriteMemeReplyData(i0.use_same_guide, i0.use_same_text, SpriteMemeReplyData.SPRITE_SCENE.SCENE_PB, false, new e(onClickListener, pbCommenFloorItemViewHolder, i0, vraVar)));
        pbCommenFloorItemViewHolder.H0.setTag(i0);
        pbCommenFloorItemViewHolder.H0.setVisibility(0);
        statOnceSet.c(vraVar.T(), new f(i0, vraVar));
    }

    public static void x(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            fu5.b(new a(i2, pbModel), new b(context, i));
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

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return a[0];
        }
        return invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString j(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1953);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f141d);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new k65(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static int n(PbFragment pbFragment) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.getActivity() != null) {
                i = BdUtilHelper.getDimens(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070420);
            } else {
                i = 0;
            }
            if (i == 0) {
                i = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070420);
            }
            return UtilHelper.getLightStatusBarHeight() + i;
        }
        return invokeL.intValue;
    }

    public static boolean y(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, es9Var)) == null) {
            if (es9Var != null && es9Var.O() != null) {
                SpannableStringBuilder span_str = es9Var.O().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1009).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.view.UserIconBox;
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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes5.dex */
public class q18 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int[] d;
    public static TextView e;
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

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) {
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

    /* loaded from: classes5.dex */
    public static class a extends nj5<ShareItem> {
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
        @Override // com.baidu.tieba.nj5
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
                return o38.d(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements si5<ShareItem> {
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
        @Override // com.baidu.tieba.si5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a, this.b, shareItem, false));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039089, "Lcom/baidu/tieba/q18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039089, "Lcom/baidu/tieba/q18;");
                return;
            }
        }
        a = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        b = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        d = new int[]{R.string.obfuscated_res_0x7f0f1033};
    }

    public static boolean C(ox7 ox7Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, ox7Var, z)) == null) {
            if (ox7Var == null || ox7Var.Q() == null || ox7Var.Q().getAuthor() == null || TextUtils.equals(ox7Var.Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, int i) {
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

    public static Intent n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
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

    public static void D(ox7 ox7Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ox7Var, str, str2) == null) && ox7Var != null && ox7Var.Q() != null && ox7Var.Q().isQuestionThread()) {
            ThreadData Q = ox7Var.Q();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i));
        }
    }

    public static boolean I(ox7 ox7Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{ox7Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || ox7Var == null) {
                return false;
            }
            if (ox7Var.l() != null && ox7Var.l().isBlockBawuDelete) {
                return false;
            }
            if ((ox7Var.Q() != null && ox7Var.Q().getAuthor() != null && ox7Var.Q().getAuthor().isForumBusinessAccount() && !tk6.isOn()) || z2) {
                return false;
            }
            if ((ox7Var.Q() != null && ox7Var.Q().isBlocked()) || ox7Var.Y() == 0 || ox7Var.Y() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static Layout E(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, spannableStringBuilder)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int l = yi.l(context) - (yi.g(context, R.dimen.tbds44) * 2);
            int contentSize = TbConfig.getContentSize();
            try {
                if (e == null) {
                    e = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = e;
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                textView.setText(spannableStringBuilder);
                textView.setTextSize(0, contentSize);
                textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
                textView.getPaint().setFakeBoldText(true);
                textView.measure(View.MeasureSpec.makeMeasureSpec(l, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                return textView.getLayout();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Layout) invokeL.objValue;
    }

    public static SpannableString h(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16a3);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11d2);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new e05(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void F(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, textView) == null) && textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03e1, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
        }
        return (String) invokeL.objValue;
    }

    public static boolean k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public static boolean l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public static String o(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public static long p(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void G(Context context, ox7 ox7Var) {
        ImMessageCenterPojo i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, context, ox7Var) == null) && ox7Var != null && context != null) {
            long c2 = g45.c();
            if (c2 <= 0 || (i = pc7.o().i(String.valueOf(c2), 2)) == null || mc7.a(context)) {
                return;
            }
            MetaData metaData = new MetaData();
            metaData.setUserIdLong(c2);
            metaData.setUserName(i.getGroup_name());
            metaData.setName_show(i.getNameShow());
            metaData.setPortrait(i.getGroup_head());
            int i2 = 1;
            if (i.getIsFriend() != 1) {
                i2 = 0;
            }
            metaData.setIsMyFriend(i2);
            xd7 xd7Var = new xd7(context);
            xd7Var.o(ox7Var.Q(), metaData);
            xd7Var.p();
        }
    }

    public static boolean H(ox7 ox7Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        xs4 xs4Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{ox7Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (ox7Var == null) {
                return false;
            }
            ThreadData Q = ox7Var.Q();
            if (Q != null) {
                if (Q.isBJHArticleThreadType() || Q.isBJHVideoThreadType()) {
                    return false;
                }
                if (Q.isBJHNormalThreadType() || Q.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((Q != null && Q.getAuthor() != null && Q.getAuthor().isForumBusinessAccount() && !tk6.isOn()) || z3 || Q.isWorksInfo() || Q.isScoreThread() || z2) {
                return false;
            }
            if (ox7Var.l() != null && ox7Var.l().isBlockBawuDelete) {
                return false;
            }
            if (ox7Var.Q() != null && ox7Var.Q().isBlocked()) {
                return false;
            }
            if (ox7Var.Y() != 0) {
                if (ox7Var.Y() == 3) {
                    return false;
                }
                return true;
            }
            List<su4> p = ox7Var.p();
            if (ListUtils.getCount(p) <= 0) {
                return false;
            }
            for (su4 su4Var : p) {
                if (su4Var != null && (xs4Var = su4Var.f) != null && xs4Var.a && !xs4Var.c && ((i = xs4Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean J(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
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

    public static int r(int i, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            if (z) {
                i6 = a;
            } else {
                i6 = 0;
            }
            return ((((i - i2) - i3) - i4) - i5) - i6;
        }
        return invokeCommon.intValue;
    }

    public static void a(Context context, ox7 ox7Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, ox7Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && ox7Var != null && ox7Var.Q() != null) {
            ThreadData Q = ox7Var.Q();
            Q.mRecomAbTag = str2;
            Q.mRecomWeight = str3;
            Q.mRecomSource = str4;
            Q.mRecomExtra = str5;
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(str, 0L));
            }
            StatisticItem i = be5.i(context, Q, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = be5.l(context);
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
                wd5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                D(ox7Var, str6, str7);
            }
        }
    }

    public static void b(int i, String str, TextView textView, TextView textView2, ImageView imageView, UserIconBox userIconBox, UserIconBox userIconBox2) {
        int width;
        int width2;
        int width3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), str, textView, textView2, imageView, userIconBox, userIconBox2}) == null) && !TextUtils.isEmpty(str) && textView != null && textView2 != null && imageView != null && userIconBox != null && userIconBox2 != null) {
            int measureText = (int) textView.getPaint().measureText(str);
            int i2 = 0;
            if (textView2.getVisibility() == 8) {
                width = 0;
            } else {
                width = textView2.getWidth() + b;
            }
            if (imageView.getVisibility() == 8) {
                width2 = 0;
            } else {
                width2 = imageView.getWidth() + b;
            }
            if (userIconBox2.getVisibility() == 8) {
                width3 = 0;
            } else {
                width3 = userIconBox2.getWidth() + c + b;
            }
            if (userIconBox.getVisibility() != 8) {
                i2 = userIconBox.getWidth() + b;
            }
            int i3 = (i - width3) - measureText;
            int i4 = width2 + width;
            if (i3 <= i2 + i4 && i3 > i4) {
                userIconBox.setVisibility(8);
            } else if (i3 > width) {
                imageView.setVisibility(8);
                userIconBox.setVisibility(8);
            } else {
                textView2.setVisibility(8);
                imageView.setVisibility(8);
                userIconBox.setVisibility(8);
            }
        }
    }

    public static void d(List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<xn> it = list.iterator();
        while (it.hasNext()) {
            xn next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof kp8) && !(next instanceof qr5)) {
                if ((next instanceof PostData) && ((PostData) next).v0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int v(ox7 ox7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, ox7Var)) == null) {
            if (ox7Var == null || ox7Var.Q() == null) {
                return 0;
            }
            if (ox7Var.Q().isMutiForumThread()) {
                if (ListUtils.isEmpty(ox7Var.p()) && (ox7Var.h() == null || StringUtils.isNull(ox7Var.h().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int w(ox7 ox7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, ox7Var)) == null) {
            if (ox7Var != null && ox7Var.Q() != null) {
                if (ox7Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (ox7Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (ox7Var.Q().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(List<xn> list, kp8 kp8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, list, kp8Var) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<xn> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            xn next = it.next();
            jp8 jp8Var = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof qr5)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                jp8Var = ((ThreadData) next).funAdData;
            } else if (next instanceof PostData) {
                jp8Var = ((PostData) next).v0;
            }
            if (jp8Var != null && jp8Var.i()) {
                i2 = i;
            }
            if (kp8Var != null && next == kp8Var) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void f(String str, ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, str, ox7Var) == null) && ox7Var != null && ox7Var.Q() != null && ox7Var.Q().isUgcThreadType()) {
            ThreadData Q = ox7Var.Q();
            int i = 0;
            if (Q.isBJHArticleThreadType()) {
                i = 1;
            } else if (Q.isBJHVideoThreadType()) {
                i = 2;
            } else if (Q.isBJHNormalThreadType()) {
                i = 3;
            } else if (Q.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean z(ox7 ox7Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65572, null, ox7Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (ox7Var.X() != null && (forumToolAuth = ox7Var.X().getForumToolAuth()) != null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return d[0];
        }
        return invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static kp8 i(ox7 ox7Var, String str) {
        InterceptResult invokeLL;
        kp8 A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, ox7Var, str)) == null) {
            if (TextUtils.isEmpty(str) || ox7Var == null || (A = ox7Var.A()) == null || !str.equals(A.n1())) {
                return null;
            }
            return A;
        }
        return (kp8) invokeLL.objValue;
    }

    public static String u(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65567, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static void x(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            rj5.b(new a(i2, pbModel), new b(context, i));
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

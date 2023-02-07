package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GroupChatEntranceStatisticUtils;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.richText.RichTextMaker;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.le5;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class xs5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static final h b;
    public transient /* synthetic */ FieldHolder $fh;

    @DrawableRes
    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? i == 5 ? R.drawable.icon_group_chat_icon : R.drawable.icon_pure_post_link16 : invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a extends RichTextMaker<pg5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            h(R.drawable.icon_pure_videotopic31);
            i(R.dimen.tbds3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        @NonNull
        /* renamed from: j */
        public SpannableString b(int i, @NonNull String str, @NonNull pg5 pg5Var) {
            InterceptResult invokeILL;
            RichTextMaker.IconPos iconPos;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, pg5Var)) == null) {
                if (pg5Var.n() && str.contains("[视频]")) {
                    pg5Var.p(true);
                    str = str.replace("[视频]", "");
                }
                f(pg5Var.m());
                if (pg5Var.o()) {
                    iconPos = RichTextMaker.IconPos.START_OFFSET.setOffset(1);
                } else {
                    iconPos = RichTextMaker.IconPos.NONE;
                }
                g(iconPos);
                return super.b(i, str, pg5Var);
            }
            return (SpannableString) invokeILL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: k */
        public void c(@NonNull View view2, int i, @NonNull pg5 pg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, pg5Var) == null) {
                if (pg5Var.n()) {
                    Context context = view2.getContext();
                    BdToast b = BdToast.b(context, context.getString(R.string.video_check_click_msg));
                    b.g(BdToast.ToastIcon.FAILURE);
                    b.k();
                    return;
                }
                if (pg5Var.o()) {
                    HotTopicStat.a(UrlUtils.getParamValue(pg5Var.h(), "topic_id"), UrlUtils.getParamValue(pg5Var.h(), IntentConfig.TOPIC_NAME), pg5Var.i(), pg5Var.g(), pg5Var.k());
                }
                xs5.D(pg5Var.h(), pg5Var.l());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends RichTextMaker<ft5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RichTextMaker.IconPos iconPos, int i, int i2, int i3) {
            super(iconPos, i, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RichTextMaker.IconPos) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: j */
        public void c(@NonNull View view2, int i, @NonNull ft5 ft5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, ft5Var) == null) {
                ft5Var.q(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(ft5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ys5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = str2;
        }

        @Override // com.baidu.tieba.ys5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            xs5.D(this.i, null);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends ys5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ys5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast b = BdToast.b(SelectorHelper.getContext(), SelectorHelper.getContext().getString(R.string.video_check_click_msg));
                b.g(BdToast.ToastIcon.FAILURE);
                b.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends ys5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i, String str, ThreadData threadData, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, threadData, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = threadData;
            this.j = str2;
        }

        @Override // com.baidu.tieba.ys5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            xs5.A(this.i, this.j);
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends ys5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String i;
        public final /* synthetic */ ThreadData j;
        public final /* synthetic */ String k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, String str, String str2, ThreadData threadData, String str3) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, threadData, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = str2;
            this.j = threadData;
            this.k = str3;
        }

        @Override // com.baidu.tieba.ys5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            xs5.B(this.i, this.j, this.k);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends ys5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i, String str, int i2, int i3, String str2, int i4) {
            super(i, str, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = i3;
            this.j = str2;
            this.k = i4;
        }

        @Override // com.baidu.tieba.ys5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xs5.C(this.i, this.j, this.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<RichTextMaker<?>> a;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new SparseArray<>();
        }

        public <T> RichTextMaker<T> a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (RichTextMaker<T>) this.a.get(i);
            }
            return (RichTextMaker) invokeI.objValue;
        }

        public void b(int i, RichTextMaker<?> richTextMaker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, richTextMaker) == null) {
                this.a.put(i, richTextMaker);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310959, "Lcom/baidu/tieba/xs5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310959, "Lcom/baidu/tieba/xs5;");
                return;
            }
        }
        b = new h();
        y();
        x();
    }

    @Deprecated
    public static SpannableString t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return new SpannableString("");
        }
        return (SpannableString) invokeV.objValue;
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            b.b(18, new a());
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            b.b(35, new b(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static void A(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, threadData, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && currentActivity != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
                if (threadData != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
                    if (threadData.isFromConcern()) {
                        statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                        statisticItem.param("obj_source", 1);
                        g(statisticItem, threadData);
                    } else if (threadData.isFromHomPage) {
                        statisticItem.param("obj_source", 2);
                        if (threadData.getBaijiahaoData() != null) {
                            statisticItem.param("obj_type", threadData.getBaijiahaoData().oriUgcType);
                        }
                    } else {
                        statisticItem.param("obj_source", 3);
                        if (threadData.getBaijiahaoData() != null) {
                            statisticItem.param("obj_type", threadData.getBaijiahaoData().oriUgcType);
                        }
                    }
                    statisticItem.param("obj_locate", 5);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public static void g(StatisticItem statisticItem, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, statisticItem, threadData) == null) {
            if (threadData.isVideoThreadType()) {
                statisticItem.param("obj_type", 2);
            } else if (threadData.isLinkThread()) {
                statisticItem.param("obj_type", 4);
            } else if (threadData.isShareThread) {
                statisticItem.param("obj_type", 5);
            } else if (threadData.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 6);
            } else if (threadData.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else if (threadData.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (threadData.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                statisticItem.param("obj_type", 1);
            }
        }
    }

    public static SpannableString r(int i, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i < 0) {
                return null;
            }
            if (i > 5) {
                i2 = 5;
            } else {
                i2 = i;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
            spannableString.setSpan(new g55(i2, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static boolean z(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, str, str2)) == null) {
            if (dj.isEmpty(str) || dj.isEmpty(str2)) {
                return false;
            }
            if (UrlManager.getInstance().isUrlValid(str2) && UrlManager.getInstance().isUrlValid(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (ListUtils.isEmpty(queryParameters)) {
                    return true;
                }
                String str3 = queryParameters.get(0);
                if (!str.equals(str3)) {
                    if (!("http://" + str).equals(str3)) {
                        if (("https://" + str).equals(str3)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void B(String str, ThreadData threadData, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, threadData, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", threadData.getTid());
            if (threadData.isFromHomPage) {
                i = 1;
            } else {
                i = 2;
            }
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8);
        }
    }

    public static void C(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
            }
            if (i == 2 && i2 == 5) {
                u(str);
            }
        }
    }

    public static void D(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, threadData) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
                wa5 wa5Var = new wa5();
                wa5Var.a = str;
                if (threadData != null) {
                    wa5Var.b = threadData.getResource();
                    wa5Var.c = threadData.getPbTitle();
                }
                no5.h(wa5Var);
                UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{wa5Var.a, wa5Var.c});
            }
        }
    }

    public static SpannableStringBuilder E(ThreadData threadData, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, threadData, list, str)) == null) {
            return F(threadData, list, str, null);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableString h(ThreadData threadData, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, threadData, str, str2)) == null) {
            return m(threadData, 16, str, str2, 0);
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public static SpannableStringBuilder F(ThreadData threadData, List<PbContent> list, String str, @Nullable List<ft5> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, ft5> q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, threadData, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        PbContent pbContent = list.get(i);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            CharSequence charSequence = null;
                            if (f2 == 35 && (q = q(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = q.first;
                                dp5.b(list2);
                                list2.add(q.second);
                            }
                            if (charSequence == null) {
                                charSequence = o(threadData, pbContent);
                            }
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        }
                    }
                }
            } else {
                if (str == null) {
                    str = "";
                }
                spannableStringBuilder.append((CharSequence) str);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLLL.objValue;
    }

    public static SpannableStringBuilder G(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            return H(list, "");
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(list);
            return d(itemStarData);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    @NonNull
    public static final String i(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                return tiebaPlusInfo.desc;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableStringBuilder H(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, list, str)) == null) {
            return E(null, list, str);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder I(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable ThreadData threadData, @Nullable List<ft5> list3) {
        InterceptResult invokeCommon;
        int size;
        CharSequence charSequence;
        char c2;
        Pair<CharSequence, ft5> q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{list, list2, Boolean.valueOf(z), threadData, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        PbContent pbContent = list.get(i);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            SpannableStringBuilder spannableStringBuilder2 = null;
                            if (f2 == 35 && (q = q(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = q.first;
                                dp5.b(list3);
                                list3.add(q.second);
                            } else {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = o(threadData, pbContent);
                            }
                            if (i == 0 && list2 != null) {
                                spannableStringBuilder2 = e(list2);
                                if (f2 == 16) {
                                    c2 = 1;
                                } else {
                                    c2 = 0;
                                }
                            } else {
                                c2 = 65535;
                            }
                            if (c2 == 65535) {
                                if (charSequence != null) {
                                    spannableStringBuilder.append(charSequence);
                                }
                            } else if (c2 == 0) {
                                if (spannableStringBuilder2 != null) {
                                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                                }
                                if (charSequence != null) {
                                    spannableStringBuilder.append(charSequence);
                                }
                            } else {
                                if (charSequence != null) {
                                    spannableStringBuilder.append(charSequence);
                                }
                                if (spannableStringBuilder2 != null) {
                                    if (z) {
                                        spannableStringBuilder.append((CharSequence) "\n");
                                    }
                                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                                }
                            }
                        }
                    }
                }
            } else {
                spannableStringBuilder.append((CharSequence) "");
            }
            if (spannableStringBuilder.toString().endsWith("\n")) {
                try {
                    return spannableStringBuilder.replace(spannableStringBuilder.length() - 2, spannableStringBuilder.length(), (CharSequence) "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder d(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        String str;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, itemStarData)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (itemStarData != null && (list = itemStarData.list) != null) {
                int count = ListUtils.getCount(list);
                if (count == 0) {
                    return spannableStringBuilder;
                }
                if (count == 1) {
                    try {
                        i2 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
                    } catch (NumberFormatException unused) {
                        i2 = 0;
                    }
                    spannableStringBuilder.append((CharSequence) r(i2, false));
                } else {
                    for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(singleItemStar.name);
                        sb.append(": ");
                        if (singleItemStar.type == 1) {
                            str = singleItemStar.content;
                        } else {
                            str = " ";
                        }
                        sb.append(str);
                        spannableStringBuilder.append((CharSequence) new SpannableString(sb.toString()));
                        if (singleItemStar.type == 2) {
                            try {
                                i = Integer.parseInt(singleItemStar.content);
                            } catch (NumberFormatException unused2) {
                                i = 0;
                            }
                            spannableStringBuilder.append((CharSequence) r(i, false));
                        }
                        if (!spannableStringBuilder.toString().endsWith("\n")) {
                            spannableStringBuilder.append((CharSequence) "\n");
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static int f(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, num)) == null) {
            int intValue = num.intValue();
            if (intValue != 13) {
                if (intValue != 14) {
                    if (intValue != 18) {
                        if (intValue != 20) {
                            if (intValue != 27) {
                                if (intValue != 1282) {
                                    switch (intValue) {
                                        case 0:
                                            return 1;
                                        case 1:
                                            return 2;
                                        case 2:
                                            return 4;
                                        case 3:
                                            return 8;
                                        case 4:
                                            return 16;
                                        case 5:
                                            return 32;
                                        case 6:
                                            return 64;
                                        default:
                                            switch (intValue) {
                                                case 8:
                                                    return 128;
                                                case 9:
                                                    return 256;
                                                case 10:
                                                    return 512;
                                                case 11:
                                                    return 17;
                                                default:
                                                    switch (intValue) {
                                                        case 30:
                                                        case 31:
                                                        case 32:
                                                        case 33:
                                                            return 1;
                                                        default:
                                                            switch (intValue) {
                                                                case 35:
                                                                    return 35;
                                                                case 36:
                                                                    return 36;
                                                                case 37:
                                                                    return 37;
                                                                default:
                                                                    return 0;
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return 1282;
                            }
                            return 39;
                        }
                        return 20;
                    }
                    return 18;
                }
                return 1280;
            }
            return 1024;
        }
        return invokeL.intValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        String str2;
        le5.a f2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (str != null && TbFaceManager.i().o(str)) {
                String j = TbFaceManager.i().j(str);
                if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
                    str2 = PreferencesUtil.LEFT_MOUNT + j + PreferencesUtil.RIGHT_MOUNT;
                    f2 = TbFaceManager.i().f("image_emoticon");
                } else {
                    str2 = SmallTailInfo.EMOTION_PREFIX + j + SmallTailInfo.EMOTION_SUFFIX;
                    f2 = TbFaceManager.i().f(str);
                }
                SpannableString spannableString = new SpannableString(str2 + " ");
                ws5 c2 = TbFaceManager.i().c(str);
                if (f2 != null) {
                    if (str != null && str.startsWith("bearchildren_")) {
                        d2 = 0.25d;
                        a2 = f2.a();
                    } else {
                        d2 = 0.4d;
                        a2 = f2.a();
                    }
                    int i = (int) (a2 * d2);
                    c2.setBounds(new Rect(0, 0, i, i));
                } else {
                    c2.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new lq5(c2, 2), 0, str2.length(), 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString k(ThreadData threadData, int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{threadData, Integer.valueOf(i), str, str2, str3})) == null) {
            return s(threadData, i, str, str2, 0, 0, str3);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString m(ThreadData threadData, int i, String str, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{threadData, Integer.valueOf(i), str, str2, Integer.valueOf(i2)})) == null) {
            return s(threadData, i, str, str2, 0, i2, null);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString l(ThreadData threadData, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65557, null, threadData, str, str2, str3)) == null) {
            return k(threadData, 39, str, str2, str3);
        }
        return (SpannableString) invokeLLLL.objValue;
    }

    public static CharSequence o(ThreadData threadData, PbContent pbContent) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, threadData, pbContent)) == null) {
            int f2 = f(pbContent.type);
            if (f2 != 2) {
                if (f2 != 4) {
                    if (f2 != 16) {
                        if (f2 != 18) {
                            String str = "";
                            if (f2 != 35) {
                                if (f2 != 39) {
                                    if (f2 != 1282) {
                                        String str2 = pbContent.text;
                                        if (str2 != null) {
                                            str = str2;
                                        }
                                        return new SpannableString(str);
                                    }
                                } else {
                                    String str3 = pbContent.text;
                                    return l(threadData, str3, pbContent.item_id + "", pbContent.item_forum_name);
                                }
                            } else {
                                return new SpannableString("");
                            }
                        }
                        if (threadData != null && pbContent != null) {
                            pg5 f3 = pg5.f(threadData, pbContent);
                            f3.b(HotTopicStat.Locate.THREAD_CARD);
                            if (f2 == 1282) {
                                z = true;
                            } else {
                                z = false;
                            }
                            f3.a(z);
                            return p(f3);
                        }
                    } else {
                        return h(threadData, pbContent.text, String.valueOf(pbContent.uid));
                    }
                }
                return j(pbContent.text);
            }
            return m(threadData, 2, pbContent.text, pbContent.link, pbContent.link_type.intValue());
        }
        return (CharSequence) invokeLL.objValue;
    }

    public static SpannableString p(@NonNull pg5 pg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, pg5Var)) == null) {
            SpannableString b2 = b.a(18).b(18, pg5Var.j().text, pg5Var);
            SpecHotTopicHelper.addSpecTopic(pg5Var.l(), b2, b2.toString(), 0);
            return b2;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 13).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public static boolean v(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (!ListUtils.isEmpty(firstFloorList)) {
                for (int count = ListUtils.getCount(firstFloorList) - 1; count >= 0; count--) {
                    if (firstFloorList.get(count).type.intValue() == 37) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean w(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, postData)) == null) {
            if (postData != null && postData.Z() != null) {
                ArrayList<TbRichTextData> I = postData.Z().I();
                if (!ListUtils.isEmpty(I)) {
                    for (int count = ListUtils.getCount(I) - 1; count >= 0; count--) {
                        if (I.get(count).getType() == 37) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static Pair<CharSequence, ft5> q(int i, @Nullable ThreadData threadData, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65562, null, i, threadData, tiebaPlusInfo)) == null) {
            if (threadData != null && TiePlusHelper.m(tiebaPlusInfo) && !TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                ft5 c2 = ft5.c(i, tiebaPlusInfo, threadData);
                RichTextMaker a2 = b.a(i);
                int intValue = tiebaPlusInfo.jump_type.intValue();
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 5) {
                            if (intValue != 6) {
                                if (intValue != 7) {
                                    a2.h(R.drawable.icon_pure_post_link16);
                                }
                            } else {
                                a2.h(R.drawable.pic_post_order);
                            }
                        } else {
                            a2.h(R.drawable.icon_mask_messageline);
                        }
                    }
                    a2.h(R.drawable.icon_pure_wechat16);
                } else {
                    a2.h(R.drawable.icon_pure_post_download16);
                }
                return Pair.create(a2.b(i, tiebaPlusInfo.desc, c2), c2);
            }
            return null;
        }
        return (Pair) invokeILL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannableString s(ThreadData threadData, int i, String str, String str2, int i2, int i3, String str3) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        SpannableString spannableString;
        ys5 gVar;
        SpannableString spannableString2;
        String str4;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{threadData, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3})) == null) {
            String str5 = str;
            if (str5 != null) {
                int i6 = 2;
                if (i == 2 && z(str, str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == 39) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!str5.endsWith(" ")) {
                    str5 = str5 + " ";
                }
                String str6 = str5;
                if (z) {
                    spannableString = new SpannableString("m" + str6);
                } else if (z2) {
                    spannableString = new SpannableString(str6 + "m");
                } else {
                    spannableString = new SpannableString(str6);
                }
                SpannableString spannableString3 = spannableString;
                if (i == 18) {
                    gVar = new c(i, str2, str2);
                } else if (i == 1282) {
                    gVar = new d(i, str2);
                } else if (i == 16) {
                    gVar = new e(i, str2, threadData, str2);
                } else if (i == 39) {
                    gVar = new f(i, str2, str2, threadData, str3);
                } else {
                    spannableString2 = spannableString3;
                    str4 = str6;
                    i4 = 1;
                    i5 = 0;
                    gVar = new g(i, str2, i3, i, str2, i3);
                    gVar.l(i2);
                    gVar.k(i3);
                    if (i2 != i4) {
                        gVar.j(R.color.CAM_X0109);
                    } else {
                        gVar.j(-1);
                    }
                    if (!z) {
                        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(n(i3), R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                        eMRichTextAnyIconSpan.e(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                        spannableString2.setSpan(eMRichTextAnyIconSpan, i5, i4, 33);
                        spannableString2.setSpan(gVar, i4, (i4 + str4.length()) - i4, 33);
                    } else if (z2) {
                        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                        eMRichTextAnyIconSpan2.h(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                        spannableString2.setSpan(eMRichTextAnyIconSpan2, str4.length() - i4, i4 + str4.length(), 33);
                        spannableString2.setSpan(gVar, i5, str4.length() - i4, 33);
                        if (a != threadData.getTid()) {
                            a = threadData.getTid();
                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                            statisticItem.param("tid", a);
                            if (threadData.isFromHomPage) {
                                i6 = 1;
                            }
                            statisticItem.param("obj_locate", i6);
                            TiebaStatic.log(statisticItem);
                        }
                    } else {
                        spannableString2.setSpan(gVar, i5, str4.length() - i4, 33);
                    }
                    return spannableString2;
                }
                spannableString2 = spannableString3;
                str4 = str6;
                i4 = 1;
                i5 = 0;
                gVar.l(i2);
                gVar.k(i3);
                if (i2 != i4) {
                }
                if (!z) {
                }
                return spannableString2;
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }
}

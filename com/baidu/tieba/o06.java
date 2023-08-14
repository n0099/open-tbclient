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
import com.baidu.tieba.pl5;
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
public class o06 {
    public static /* synthetic */ Interceptable $ic;
    public static final h a;
    public transient /* synthetic */ FieldHolder $fh;

    @DrawableRes
    public static int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) ? i == 5 ? R.drawable.icon_group_chat_icon : R.drawable.icon_pure_post_link16 : invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a extends RichTextMaker<co5> {
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
        /* renamed from: k */
        public SpannableString b(int i, @NonNull String str, @NonNull co5 co5Var) {
            InterceptResult invokeILL;
            RichTextMaker.IconPos iconPos;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, co5Var)) == null) {
                if (co5Var.q() && str.contains("[视频]")) {
                    co5Var.s(true);
                    str = str.replace("[视频]", "");
                }
                j(co5Var.p());
                f(co5Var.o());
                if (co5Var.r()) {
                    iconPos = RichTextMaker.IconPos.START_OFFSET.setOffset(1);
                } else {
                    iconPos = RichTextMaker.IconPos.NONE;
                }
                g(iconPos);
                return super.b(i, str, co5Var);
            }
            return (SpannableString) invokeILL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: l */
        public void c(@NonNull View view2, int i, @NonNull co5 co5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, co5Var) == null) {
                if (co5Var.q()) {
                    Context context = view2.getContext();
                    BdToast.makeText(context, context.getString(R.string.video_check_click_msg)).setIcon(BdToast.ToastIcon.FAILURE).show();
                    return;
                }
                if (co5Var.r()) {
                    HotTopicStat.a(UrlUtils.getParamValue(co5Var.k(), "topic_id"), UrlUtils.getParamValue(co5Var.k(), "topic_name"), co5Var.l(), co5Var.i(), co5Var.m());
                }
                o06.E(co5Var.k(), co5Var.n());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends RichTextMaker<w06> {
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
        /* renamed from: k */
        public void c(@NonNull View view2, int i, @NonNull w06 w06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, w06Var) == null) {
                w06Var.q(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(w06Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends p06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String m;

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
            this.m = str2;
        }

        @Override // com.baidu.tieba.p06, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            o06.E(this.m, null);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends p06 {
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

        @Override // com.baidu.tieba.p06, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast.makeText(SelectorHelper.getContext(), SelectorHelper.getContext().getString(R.string.video_check_click_msg)).setIcon(BdToast.ToastIcon.FAILURE).show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends p06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData m;
        public final /* synthetic */ String n;

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
            this.m = threadData;
            this.n = str2;
        }

        @Override // com.baidu.tieba.p06, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            o06.B(this.m, this.n);
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends p06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String m;
        public final /* synthetic */ ThreadData n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;
        public final /* synthetic */ int q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, String str, String str2, ThreadData threadData, String str3, String str4, int i2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, threadData, str3, str4, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = str2;
            this.n = threadData;
            this.o = str3;
            this.p = str4;
            this.q = i2;
        }

        @Override // com.baidu.tieba.p06, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            o06.C(this.m, this.n, this.o, this.p, this.q);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends p06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int m;
        public final /* synthetic */ String n;
        public final /* synthetic */ int o;

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
            this.m = i3;
            this.n = str2;
            this.o = i4;
        }

        @Override // com.baidu.tieba.p06, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                o06.D(this.m, this.n, this.o);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947978484, "Lcom/baidu/tieba/o06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947978484, "Lcom/baidu/tieba/o06;");
                return;
            }
        }
        a = new h();
        z();
        y();
    }

    @Deprecated
    public static SpannableString u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return new SpannableString("");
        }
        return (SpannableString) invokeV.objValue;
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, null) == null) {
            a.b(18, new a());
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, null) == null) {
            a.b(35, new b(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static boolean A(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (bi.isEmpty(str) || bi.isEmpty(str2)) {
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

    public static void B(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, threadData, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65554, null, statisticItem, threadData) == null) {
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

    public static SpannableString s(int i, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
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
            spannableString.setSpan(new pa5(i2, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static void C(String str, ThreadData threadData, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, threadData, str2, str3, Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("obj_locate", k(threadData));
            statisticItem.param("obj_type", str);
            statisticItem.param("obj_param1", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8, str3);
        }
    }

    public static void D(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
            }
            if (i == 2 && i2 == 5) {
                v(str);
            }
        }
    }

    public static void E(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, threadData) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
                wg5 wg5Var = new wg5();
                wg5Var.a = str;
                if (threadData != null) {
                    wg5Var.b = threadData.getResource();
                    wg5Var.c = threadData.getPbTitle();
                }
                ov5.h(wg5Var);
                UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{wg5Var.a, wg5Var.c});
            }
        }
    }

    public static SpannableStringBuilder F(ThreadData threadData, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, threadData, list, str)) == null) {
            return G(threadData, list, str, null);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableString h(ThreadData threadData, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, threadData, str, str2)) == null) {
            return n(threadData, 16, str, str2, 0);
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public static SpannableStringBuilder G(ThreadData threadData, List<PbContent> list, String str, @Nullable List<w06> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, w06> r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, threadData, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        PbContent pbContent = list.get(i);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            CharSequence charSequence = null;
                            if (f2 == 35 && (r = r(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = r.first;
                                dw5.b(list2);
                                list2.add(r.second);
                            }
                            if (charSequence == null) {
                                charSequence = p(threadData, pbContent);
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

    public static SpannableStringBuilder K(ThreadData threadData, List<PbContent> list, String str, @Nullable List<w06> list2) {
        InterceptResult invokeLLLL;
        Pair<CharSequence, w06> r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, threadData, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                if (str == null) {
                    str = "";
                }
                return spannableStringBuilder.append((CharSequence) str);
            }
            if (str == null) {
                str = "";
            }
            spannableStringBuilder.append((CharSequence) str);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = list.get(i);
                if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                    int f2 = f(pbContent.type);
                    CharSequence charSequence = null;
                    if (f2 == 35 && (r = r(f2, threadData, pbContent.tiebaplus_info)) != null) {
                        charSequence = r.first;
                        dw5.b(list2);
                        list2.add(r.second);
                    }
                    if (charSequence == null && f2 != 32) {
                        charSequence = p(threadData, pbContent);
                    }
                    if (charSequence != null) {
                        spannableStringBuilder.append(charSequence);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLLL.objValue;
    }

    public static SpannableStringBuilder H(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
            return I(list, "");
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                return tiebaPlusInfo.desc;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, threadData)) == null) {
            if (threadData.isFromHomPage) {
                return 1;
            }
            if (threadData.isFromConcern) {
                return 2;
            }
            if (threadData.isFromFeedTab) {
                return 3;
            }
            return 6;
        }
        return invokeL.intValue;
    }

    public static SpannableString q(@NonNull co5 co5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, co5Var)) == null) {
            SpannableString b2 = a.a(18).b(18, co5Var.j(), co5Var);
            SpecHotTopicHelper.addSpecTopic(co5Var.n(), b2, b2.toString(), 0);
            return b2;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableStringBuilder I(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, str)) == null) {
            return F(null, list, str);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder J(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable ThreadData threadData, @Nullable List<w06> list3) {
        InterceptResult invokeCommon;
        int size;
        CharSequence charSequence;
        char c2;
        Pair<CharSequence, w06> r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{list, list2, Boolean.valueOf(z), threadData, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        PbContent pbContent = list.get(i);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            SpannableStringBuilder spannableStringBuilder2 = null;
                            if (f2 == 35 && (r = r(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = r.first;
                                dw5.b(list3);
                                list3.add(r.second);
                            } else {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = p(threadData, pbContent);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, itemStarData)) == null) {
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
                    spannableStringBuilder.append((CharSequence) s(i2, false));
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
                            spannableStringBuilder.append((CharSequence) s(i, false));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, num)) == null) {
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
        pl5.a f2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
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
                n06 c2 = TbFaceManager.i().c(str);
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
                spannableString.setSpan(new px5(c2, 2), 0, str2.length(), 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString l(ThreadData threadData, int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{threadData, Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            return t(threadData, i, str, str4, 0, i2, str3, str2);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString m(ThreadData threadData, String str, String str2, String str3, String str4, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{threadData, str, str2, str3, str4, Integer.valueOf(i)})) == null) {
            return l(threadData, 39, str, str2, str3, str4, i);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString n(ThreadData threadData, int i, String str, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{threadData, Integer.valueOf(i), str, str2, Integer.valueOf(i2)})) == null) {
            return t(threadData, i, str, str2, 0, i2, null, "");
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static CharSequence p(ThreadData threadData, PbContent pbContent) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, threadData, pbContent)) == null) {
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
                                    return m(threadData, str3, pbContent.item_id + "", pbContent.item_forum_name, pbContent.link, pbContent.link_type.intValue());
                                }
                            } else {
                                return new SpannableString("");
                            }
                        }
                        if (threadData != null && pbContent != null) {
                            co5 h2 = co5.h(pbContent.text, pbContent.link);
                            h2.e(threadData);
                            h2.b(HotTopicStat.Locate.THREAD_CARD);
                            if (f2 == 1282) {
                                z = true;
                            } else {
                                z = false;
                            }
                            h2.a(z);
                            return q(h2);
                        }
                    } else {
                        return h(threadData, pbContent.text, String.valueOf(pbContent.uid));
                    }
                }
                return j(pbContent.text);
            }
            return n(threadData, 2, pbContent.text, pbContent.link, pbContent.link_type.intValue());
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Nullable
    public static Pair<CharSequence, w06> r(int i, @Nullable ThreadData threadData, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65565, null, i, threadData, tiebaPlusInfo)) == null) {
            if (threadData != null && TiePlusHelper.m(tiebaPlusInfo) && !TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                w06 c2 = w06.c(i, tiebaPlusInfo, threadData);
                RichTextMaker a2 = a.a(i);
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannableString t(ThreadData threadData, int i, String str, String str2, int i2, int i3, String str3, String str4) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        SpannableString spannableString;
        SpannableString spannableString2;
        p06 gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, null, new Object[]{threadData, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3, str4})) == null) {
            String str5 = str;
            if (str5 != null) {
                if (i == 2 && A(str, str2)) {
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
                } else {
                    if (i == 39) {
                        spannableString2 = spannableString3;
                        gVar = new f(i, str4, str4, threadData, str3, str2, i3);
                    } else {
                        spannableString2 = spannableString3;
                        gVar = new g(i, str2, i3, i, str2, i3);
                    }
                    gVar.t(i2);
                    gVar.s(i3);
                    if (i2 != 1) {
                        gVar.r(R.color.CAM_X0109);
                    } else {
                        gVar.r(-1);
                    }
                    if (!z) {
                        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(o(i3), R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                        eMRichTextAnyIconSpan.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                        spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                        spannableString2.setSpan(gVar, 1, (str6.length() + 1) - 1, 33);
                    } else if (z2) {
                        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                        eMRichTextAnyIconSpan2.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                        spannableString2.setSpan(eMRichTextAnyIconSpan2, str6.length() - 1, str6.length() + 1, 33);
                        spannableString2.setSpan(gVar, 0, str6.length() - 1, 33);
                        if (threadData != null && !TextUtils.isEmpty(threadData.getTid()) && !TextUtils.equals("0", threadData.getTid())) {
                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("tid", threadData.getTid());
                            statisticItem.param("obj_locate", k(threadData));
                            statisticItem.param("obj_param1", i3);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str4);
                            TiebaStatic.log(statisticItem);
                        }
                    } else {
                        spannableString2.setSpan(gVar, 0, str6.length() - 1, 33);
                    }
                    return spannableString2;
                }
                spannableString2 = spannableString3;
                gVar.t(i2);
                gVar.s(i3);
                if (i2 != 1) {
                }
                if (!z) {
                }
                return spannableString2;
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 13).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public static boolean w(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, threadData)) == null) {
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

    public static boolean x(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, rbaVar)) == null) {
            if (rbaVar != null && rbaVar.e0() != null) {
                ArrayList<TbRichTextData> P = rbaVar.e0().P();
                if (!ListUtils.isEmpty(P)) {
                    for (int count = ListUtils.getCount(P) - 1; count >= 0; count--) {
                        if (P.get(count).getType() == 37) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

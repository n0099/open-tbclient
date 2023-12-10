package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.richText.RichTextMaker;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.fj5;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes8.dex */
public class ty5 {
    public static /* synthetic */ Interceptable $ic;
    public static final j a;
    public transient /* synthetic */ FieldHolder $fh;

    @DrawableRes
    public static int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) ? i2 == 5 ? R.drawable.icon_group_chat_icon : R.drawable.icon_pure_post_link16 : invokeI.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends RichTextMaker<wl5> {
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
        public SpannableString b(int i, @NonNull String str, @NonNull wl5 wl5Var) {
            InterceptResult invokeILL;
            RichTextMaker.IconPos iconPos;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, wl5Var)) == null) {
                if (wl5Var.q() && str.contains("[视频]")) {
                    wl5Var.s(true);
                    str = str.replace("[视频]", "");
                }
                j(wl5Var.p());
                f(wl5Var.o());
                if (wl5Var.r()) {
                    iconPos = RichTextMaker.IconPos.START_OFFSET.setOffset(1);
                } else {
                    iconPos = RichTextMaker.IconPos.NONE;
                }
                g(iconPos);
                return super.b(i, str, wl5Var);
            }
            return (SpannableString) invokeILL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: l */
        public void c(@NonNull View view2, int i, @NonNull wl5 wl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, wl5Var) == null) {
                if (wl5Var.q()) {
                    Context context = view2.getContext();
                    BdToast.makeText(context, context.getString(R.string.video_check_click_msg)).setIcon(BdToast.ToastIcon.FAILURE).show();
                    return;
                }
                if (wl5Var.r()) {
                    HotTopicStat.a(UrlUtils.getParamValue(wl5Var.k(), "topic_id"), UrlUtils.getParamValue(wl5Var.k(), "topic_name"), wl5Var.l(), wl5Var.i(), wl5Var.m());
                }
                ty5.F(wl5Var.k(), wl5Var.n());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RichTextMaker<bz5> {
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
        public void c(@NonNull View view2, int i, @NonNull bz5 bz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, bz5Var) == null) {
                bz5Var.q(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(bz5Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;

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
            this.n = str2;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            ty5.F(this.n, null);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends uy5 {
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

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast.makeText(SelectorHelper.getContext(), SelectorHelper.getContext().getString(R.string.video_check_click_msg)).setIcon(BdToast.ToastIcon.FAILURE).show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ ThreadData o;
        public final /* synthetic */ String p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i, String str, String str2, ThreadData threadData, String str3) {
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
            this.n = str2;
            this.o = threadData;
            this.p = str3;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (fy9.a(this.n)) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + this.n);
                    return;
                }
                ty5.C(this.o, this.p);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ ThreadData o;
        public final /* synthetic */ String p;
        public final /* synthetic */ String q;
        public final /* synthetic */ int r;

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
            this.n = str2;
            this.o = threadData;
            this.p = str3;
            this.q = str4;
            this.r = i2;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            ty5.D(this.n, this.o, this.p, this.q, this.r);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int n;
        public final /* synthetic */ String o;
        public final /* synthetic */ int p;

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
            this.n = i3;
            this.o = str2;
            this.p = i4;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ty5.E(this.n, this.o, this.p);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ ThreadData p;
        public final /* synthetic */ int q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i, String str, String str2, String str3, ThreadData threadData, int i2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, str3, threadData, Integer.valueOf(i2)};
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
            this.n = str2;
            this.o = str3;
            this.p = threadData;
            this.q = i2;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TbRichTextHelper", "heat infarction jump Scheme=" + this.n);
                if (!rd.isEmpty(this.n)) {
                    UrlManager.getInstance().dealOneLink(this.n);
                    nua.w(this.o, 2, this.p, this.q);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EMRichTextAnyIconSpan a;
        public final /* synthetic */ Drawable b;

        public i(EMRichTextAnyIconSpan eMRichTextAnyIconSpan, Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eMRichTextAnyIconSpan, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eMRichTextAnyIconSpan;
            this.b = drawable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, drawable, transition) == null) {
                this.a.d(drawable);
            }
        }

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
                this.a.d(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<RichTextMaker<?>> a;

        public j() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948197561, "Lcom/baidu/tieba/ty5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948197561, "Lcom/baidu/tieba/ty5;");
                return;
            }
        }
        a = new j();
        A();
        z();
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            a.b(35, new b(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    @Deprecated
    public static SpannableString v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return new SpannableString("");
        }
        return (SpannableString) invokeV.objValue;
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, null) == null) {
            a.b(18, new a());
        }
    }

    public static boolean B(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (rd.isEmpty(str) || rd.isEmpty(str2)) {
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

    public static void C(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, threadData, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65555, null, statisticItem, threadData) == null) {
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

    public static SpannableString t(int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return null;
            }
            if (i2 > 5) {
                i3 = 5;
            } else {
                i3 = i2;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
            spannableString.setSpan(new w65(i3, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static void D(String str, ThreadData threadData, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, threadData, str2, str3, Integer.valueOf(i2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("obj_locate", l(threadData));
            statisticItem.param("obj_type", str);
            statisticItem.param("obj_param1", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8, str3);
        }
    }

    public static void E(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
            }
            if (i2 == 2 && i3 == 5) {
                w(str);
            }
        }
    }

    public static void F(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, threadData) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
                ld5 ld5Var = new ld5();
                ld5Var.a = str;
                if (threadData != null) {
                    ld5Var.b = threadData.getResource();
                    ld5Var.c = threadData.getPbTitle();
                }
                rt5.h(ld5Var);
                UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{ld5Var.a, ld5Var.c});
            }
        }
    }

    public static SpannableStringBuilder G(ThreadData threadData, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, threadData, list, str)) == null) {
            return H(threadData, list, str, null);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableStringBuilder H(ThreadData threadData, List<PbContent> list, String str, @Nullable List<bz5> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, bz5> s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, threadData, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        PbContent pbContent = list.get(i2);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            CharSequence charSequence = null;
                            if (f2 == 35 && (s = s(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = s.first;
                                gu5.b(list2);
                                list2.add(s.second);
                            }
                            if (charSequence == null) {
                                charSequence = q(threadData, pbContent);
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

    public static SpannableStringBuilder L(ThreadData threadData, List<PbContent> list, String str, @Nullable List<bz5> list2) {
        InterceptResult invokeLLLL;
        Pair<CharSequence, bz5> s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, threadData, list, str, list2)) == null) {
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
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                    int f2 = f(pbContent.type);
                    CharSequence charSequence = null;
                    if (f2 == 35 && (s = s(f2, threadData, pbContent.tiebaplus_info)) != null) {
                        charSequence = s.first;
                        gu5.b(list2);
                        list2.add(s.second);
                    }
                    if (charSequence == null && f2 != 32) {
                        charSequence = q(threadData, pbContent);
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

    public static SpannableStringBuilder I(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            return J(list, "");
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, list)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                return tiebaPlusInfo.desc;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int l(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, threadData)) == null) {
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

    public static SpannableString r(@NonNull wl5 wl5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, wl5Var)) == null) {
            SpannableString b2 = a.a(18).b(18, wl5Var.j(), wl5Var);
            SpecHotTopicHelper.addSpecTopic(wl5Var.n(), b2, b2.toString(), 0);
            return b2;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableStringBuilder J(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, list, str)) == null) {
            return G(null, list, str);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder K(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable ThreadData threadData, @Nullable List<bz5> list3) {
        InterceptResult invokeCommon;
        int size;
        CharSequence charSequence;
        char c2;
        Pair<CharSequence, bz5> s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{list, list2, Boolean.valueOf(z), threadData, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!ListUtils.isEmpty(list)) {
                if (list != null && (size = list.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        PbContent pbContent = list.get(i2);
                        if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                            int f2 = f(pbContent.type);
                            SpannableStringBuilder spannableStringBuilder2 = null;
                            if (f2 == 35 && (s = s(f2, threadData, pbContent.tiebaplus_info)) != null) {
                                charSequence = s.first;
                                gu5.b(list3);
                                list3.add(s.second);
                            } else {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = q(threadData, pbContent);
                            }
                            if (i2 == 0 && list2 != null) {
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

    public static SpannableString k(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ThreadData threadData, int i2) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{str, str2, str3, threadData, Integer.valueOf(i2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return new SpannableString("");
            }
            if (str.endsWith(" ")) {
                str4 = str;
            } else {
                str4 = str + " ";
            }
            SpannableString spannableString = new SpannableString(str4 + "m");
            h hVar = new h(40, str3, str3, str, threadData, i2);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_regeng, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.tbds5));
            eMRichTextAnyIconSpan.j(UtilHelper.getDimenPixelSize(R.dimen.tbds5));
            if (!rd.isEmpty(str2)) {
                eMRichTextAnyIconSpan.e(EMRichTextAnyIconSpan.IconType.NET);
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_regeng, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
                Glide.with(TbadkCoreApplication.getInst()).load(str2).placeholder(pureDrawable).into((RequestBuilder) new i(eMRichTextAnyIconSpan, pureDrawable));
            }
            spannableString.setSpan(eMRichTextAnyIconSpan, str4.length() - 1, str4.length() + 1, 33);
            spannableString.setSpan(hVar, 0, str4.length() - 1, 33);
            nua.w(str, 1, threadData, i2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableStringBuilder d(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        String str;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, itemStarData)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (itemStarData != null && (list = itemStarData.list) != null) {
                int count = ListUtils.getCount(list);
                if (count == 0) {
                    return spannableStringBuilder;
                }
                if (count == 1) {
                    try {
                        i3 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
                    } catch (NumberFormatException unused) {
                        i3 = 0;
                    }
                    spannableStringBuilder.append((CharSequence) t(i3, false));
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
                                i2 = Integer.parseInt(singleItemStar.content);
                            } catch (NumberFormatException unused2) {
                                i2 = 0;
                            }
                            spannableStringBuilder.append((CharSequence) t(i2, false));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, num)) == null) {
            int intValue = num.intValue();
            if (intValue != 13) {
                if (intValue != 14) {
                    if (intValue != 18) {
                        if (intValue != 20) {
                            if (intValue != 27) {
                                if (intValue != 40) {
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
                                return 40;
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

    public static SpannableString h(ThreadData threadData, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, threadData, str, str2, str3)) == null) {
            return o(threadData, 16, str, str2, 0, str3);
        }
        return (SpannableString) invokeLLLL.objValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        String str2;
        fj5.a f2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str != null && TbFaceManager.i().o(str)) {
                String j2 = TbFaceManager.i().j(str);
                if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
                    str2 = PreferencesUtil.LEFT_MOUNT + j2 + PreferencesUtil.RIGHT_MOUNT;
                    f2 = TbFaceManager.i().f("image_emoticon");
                } else {
                    str2 = SmallTailInfo.EMOTION_PREFIX + j2 + SmallTailInfo.EMOTION_SUFFIX;
                    f2 = TbFaceManager.i().f(str);
                }
                SpannableString spannableString = new SpannableString(str2 + " ");
                sy5 c2 = TbFaceManager.i().c(str);
                if (f2 != null) {
                    if (str != null && str.startsWith("bearchildren_")) {
                        d2 = 0.25d;
                        a2 = f2.a();
                    } else {
                        d2 = 0.4d;
                        a2 = f2.a();
                    }
                    int i2 = (int) (a2 * d2);
                    c2.setBounds(new Rect(0, 0, i2, i2));
                } else {
                    c2.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new sv5(c2, 2), 0, str2.length(), 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString m(ThreadData threadData, int i2, String str, String str2, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{threadData, Integer.valueOf(i2), str, str2, str3, str4, Integer.valueOf(i3)})) == null) {
            return u(threadData, i2, str, str4, 0, i3, str3, str2, "");
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString n(ThreadData threadData, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{threadData, str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            return m(threadData, 39, str, str2, str3, str4, i2);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString o(ThreadData threadData, int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{threadData, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            return u(threadData, i2, str, str2, 0, i3, null, "", str3);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static CharSequence q(ThreadData threadData, PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, threadData, pbContent)) == null) {
            int f2 = f(pbContent.type);
            int i2 = 2;
            if (f2 != 2) {
                if (f2 != 4) {
                    if (f2 != 16) {
                        boolean z = true;
                        if (f2 != 18) {
                            String str = "";
                            if (f2 != 35) {
                                if (f2 != 1282) {
                                    if (f2 != 39) {
                                        if (f2 != 40) {
                                            String str2 = pbContent.text;
                                            if (str2 != null) {
                                                str = str2;
                                            }
                                            return new SpannableString(str);
                                        }
                                        return k(pbContent.text, pbContent.src, pbContent.link, threadData, (threadData == null || !threadData.isFromFrs()) ? 1 : 1);
                                    }
                                    String str3 = pbContent.text;
                                    return n(threadData, str3, pbContent.item_id + "", pbContent.item_forum_name, pbContent.link, pbContent.link_type.intValue());
                                }
                            } else {
                                return new SpannableString("");
                            }
                        }
                        if (threadData != null && pbContent != null) {
                            wl5 h2 = wl5.h(pbContent.text, pbContent.link);
                            h2.e(threadData);
                            h2.b(HotTopicStat.Locate.THREAD_CARD);
                            if (f2 != 1282) {
                                z = false;
                            }
                            h2.a(z);
                            return r(h2);
                        }
                    } else {
                        return h(threadData, pbContent.text, String.valueOf(pbContent.uid), pbContent.target_scheme);
                    }
                }
                return j(pbContent.text);
            }
            return o(threadData, 2, pbContent.text, pbContent.link, pbContent.link_type.intValue(), pbContent.target_scheme);
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Nullable
    public static Pair<CharSequence, bz5> s(int i2, @Nullable ThreadData threadData, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65567, null, i2, threadData, tiebaPlusInfo)) == null) {
            if (threadData != null && TiePlusHelper.t(tiebaPlusInfo) && !TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                bz5 c2 = bz5.c(i2, tiebaPlusInfo, threadData);
                RichTextMaker a2 = a.a(i2);
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
                return Pair.create(a2.b(i2, tiebaPlusInfo.desc, c2), c2);
            }
            return null;
        }
        return (Pair) invokeILL.objValue;
    }

    public static SpannableString u(ThreadData threadData, int i2, String str, String str2, int i3, int i4, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        SpannableString spannableString;
        uy5 gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{threadData, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, str4, str5})) == null) {
            String str6 = str;
            if (str6 != null) {
                if (i2 == 2 && B(str, str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == 39) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!str6.endsWith(" ")) {
                    str6 = str6 + " ";
                }
                String str7 = str6;
                if (z) {
                    spannableString = new SpannableString("m" + str7);
                } else if (z2) {
                    spannableString = new SpannableString(str7 + "m");
                } else {
                    spannableString = new SpannableString(str7);
                }
                SpannableString spannableString2 = spannableString;
                if (i2 == 18) {
                    gVar = new c(i2, str2, str2);
                } else if (i2 == 1282) {
                    gVar = new d(i2, str2);
                } else if (i2 == 16) {
                    gVar = new e(i2, str2, str5, threadData, str2);
                } else if (i2 == 39) {
                    gVar = new f(i2, str4, str4, threadData, str3, str2, i4);
                } else {
                    gVar = new g(i2, str2, i4, i2, str2, i4);
                }
                gVar.u(i3);
                gVar.t(i4);
                if (i3 == 1) {
                    gVar.s(R.color.CAM_X0109);
                } else {
                    gVar.s(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(p(i4), R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString2.setSpan(gVar, 1, (str7.length() + 1) - 1, 33);
                    return spannableString2;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString2.setSpan(eMRichTextAnyIconSpan2, str7.length() - 1, str7.length() + 1, 33);
                    spannableString2.setSpan(gVar, 0, str7.length() - 1, 33);
                    if (threadData != null && !TextUtils.isEmpty(threadData.getTid()) && !TextUtils.equals("0", threadData.getTid())) {
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", threadData.getTid());
                        statisticItem.param("obj_locate", l(threadData));
                        statisticItem.param("obj_param1", i4);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str4);
                        TiebaStatic.log(statisticItem);
                        return spannableString2;
                    }
                    return spannableString2;
                } else {
                    spannableString2.setSpan(gVar, 0, str7.length() - 1, 33);
                    return spannableString2;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 13).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public static boolean x(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, threadData)) == null) {
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

    public static boolean y(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, nwaVar)) == null) {
            if (nwaVar != null && nwaVar.f0() != null) {
                ArrayList<TbRichTextData> Q = nwaVar.f0().Q();
                if (!ListUtils.isEmpty(Q)) {
                    for (int count = ListUtils.getCount(Q) - 1; count >= 0; count--) {
                        if (Q.get(count).getType() == 37) {
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

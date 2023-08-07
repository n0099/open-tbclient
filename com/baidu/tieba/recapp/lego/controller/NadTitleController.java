package com.baidu.tieba.recapp.lego.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.richtextview.NadRichTextView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.cs0;
import com.baidu.tieba.el0;
import com.baidu.tieba.iy9;
import com.baidu.tieba.l46;
import com.baidu.tieba.q31;
import com.baidu.tieba.recapp.lego.controller.NadTitleController;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.rl0;
import com.baidu.tieba.sy9;
import com.baidu.tieba.t21;
import com.baidu.tieba.v05;
import com.baidu.tieba.x51;
import com.baidu.tieba.xx8;
import com.baidu.tieba.z65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0003J\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0006H\u0002J\u001e\u00100\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020$2\u0006\u00101\u001a\u000202R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tieba/recapp/lego/controller/NadTitleController;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "adCard", "Lcom/baidu/tieba/recapp/lego/model/AdCard;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "emNoPaddingSpan", "Lcom/baidu/tieba/recapp/lego/controller/NadTitleController$EMNoPaddingSpan;", "getEmNoPaddingSpan", "()Lcom/baidu/tieba/recapp/lego/controller/NadTitleController$EMNoPaddingSpan;", "emNoPaddingSpan$delegate", "Lkotlin/Lazy;", "richTitle", "Lcom/baidu/nadcore/richtextview/NadRichTextView;", "getRichTitle", "()Lcom/baidu/nadcore/richtextview/NadRichTextView;", "richTitle$delegate", "title", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getTitle", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "title$delegate", "titleLinkDownloadPresenter", "Lcom/baidu/nadcore/download/presenter/AdDownloadPresenterNormal;", "getDownloadCompleteIcon", "Landroid/graphics/drawable/Drawable;", "getDownloadIcon", "shortUrlModel", "Lcom/baidu/nadcore/model/NadRichTitleLinkModel$NadShortUrlModel;", "getLinkIcon", "getLinkTextColor", "", "getTitleView", "Landroid/widget/TextView;", "performLinkClick", "", "cmd", "", "setRichTitle", "", "card", "maxWidth", "setTitle", StickerDataChangeType.UPDATE, "titleListener", "Landroid/view/View$OnClickListener;", "EMNoPaddingSpan", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NadTitleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public AdCard c;
    public rl0 d;
    public final Lazy e;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J8\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/baidu/tieba/recapp/lego/controller/NadTitleController$EMNoPaddingSpan;", "Landroid/text/style/LineHeightSpan;", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "addMarginBottom", "", "addMarginTop", "marginLayoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMarginLayoutParams", "()Landroid/view/ViewGroup$MarginLayoutParams;", "originMarginBottom", "originMarginLayoutParams", "originMarginTop", "textSize", "textViewWeakReference", "Ljava/lang/ref/WeakReference;", "getTextViewWeakReference", "()Ljava/lang/ref/WeakReference;", "textViewWeakReference$delegate", "Lkotlin/Lazy;", "autoAdjustMargin", "", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "text", "", "start", "end", "spanstartv", "lineHeight", "init", "layoutParamsChanged", "", "restoreMargin", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class EMNoPaddingSpan implements LineHeightSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Lazy a;
        public int b;
        public ViewGroup.MarginLayoutParams c;
        public int d;
        public int e;
        public int f;
        public int g;

        public EMNoPaddingSpan(final TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.a = LazyKt__LazyJVMKt.lazy(new Function0<WeakReference<TextView>>(textView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTitleController$EMNoPaddingSpan$textViewWeakReference$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TextView $textView;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {textView};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext2.callArgs[0]).intValue());
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.$textView = textView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final WeakReference<TextView> invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return new WeakReference<>(this.$textView);
                    }
                    return (WeakReference) invokeV.objValue;
                }
            });
            d();
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fontMetricsInt) == null) && (b = b()) != null) {
                this.d = b.topMargin;
                this.e = b.bottomMargin;
                this.f = fontMetricsInt.top - fontMetricsInt.ascent;
                int dimenPixelSize = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                this.g = dimenPixelSize;
                b.topMargin += this.f;
                b.bottomMargin += dimenPixelSize;
            }
        }

        public final ViewGroup.MarginLayoutParams b() {
            InterceptResult invokeV;
            ViewGroup.LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TextView textView = c().get();
                if (textView != null) {
                    layoutParams = textView.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    return null;
                }
                return (ViewGroup.MarginLayoutParams) layoutParams;
            }
            return (ViewGroup.MarginLayoutParams) invokeV.objValue;
        }

        public final WeakReference<TextView> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (WeakReference) this.a.getValue();
            }
            return (WeakReference) invokeV.objValue;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{text, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fm}) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(fm, "fm");
                f();
                z65.a(fm, this.b);
                TextView textView = c().get();
                if (textView == null || (textView.getGravity() & 112) != 16) {
                    a(fm);
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TextView textView = c().get();
                if (textView != null) {
                    this.b = (int) textView.getTextSize();
                }
                ViewGroup.MarginLayoutParams b = b();
                this.c = b;
                if (b != null) {
                    this.d = b.topMargin;
                    this.e = b.bottomMargin;
                }
                this.f = 0;
                this.g = 0;
            }
        }

        public final boolean e() {
            InterceptResult invokeV;
            ViewGroup.MarginLayoutParams b;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.c != null && (b = b()) != null && Intrinsics.areEqual(this.c, b)) {
                    if (this.d + this.f == b.topMargin) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.e + this.g == b.bottomMargin) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (e()) {
                    d();
                    return;
                }
                ViewGroup.MarginLayoutParams b = b();
                if (b == null) {
                    return;
                }
                b.topMargin -= this.f;
                b.bottomMargin -= this.g;
                TextView textView = c().get();
                if (textView != null) {
                    this.b = (int) textView.getTextSize();
                }
                this.f = 0;
                this.g = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements NadRichTextView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadTitleController a;

        public a(NadTitleController nadTitleController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadTitleController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadTitleController;
        }

        @Override // com.baidu.nadcore.richtextview.NadRichTextView.b
        public CharSequence a(CharSequence text) {
            InterceptResult invokeL;
            SpannableStringBuilder spannableStringBuilder;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, text)) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                if (text instanceof SpannableStringBuilder) {
                    spannableStringBuilder = (SpannableStringBuilder) text;
                } else {
                    spannableStringBuilder = new SpannableStringBuilder(text);
                }
                spannableStringBuilder.setSpan(this.a.h(), 0, text.length(), 33);
                return spannableStringBuilder;
            }
            return (CharSequence) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadTitleController a;

        public b(NadTitleController nadTitleController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadTitleController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadTitleController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdCard adCard;
            cs0 cs0Var;
            cs0.b bVar;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (adCard = this.a.c) != null && (cs0Var = adCard.richTitleLinkModel) != null && (bVar = cs0Var.a) != null) {
                String str2 = bVar.a;
                if (!Intrinsics.areEqual(str2, "command")) {
                    if (Intrinsics.areEqual(str2, "download")) {
                        AdCard adCard2 = this.a.c;
                        AdvertAppInfo advertAppInfo = null;
                        if (adCard2 != null) {
                            str = adCard2.getButtonCmdScheme();
                        } else {
                            str = null;
                        }
                        l46.a(str);
                        AdCard adCard3 = this.a.c;
                        if (adCard3 != null) {
                            advertAppInfo = adCard3.getAdvertAppInfo();
                        }
                        xx8.c(advertAppInfo);
                        rl0 rl0Var = this.a.d;
                        if (rl0Var != null) {
                            rl0Var.l();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.n(bVar.e);
            }
        }
    }

    public NadTitleController(final View rootView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rootView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<EMTextView>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTitleController$title$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View $rootView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {rootView};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$rootView = rootView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EMTextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (EMTextView) this.$rootView.findViewById(R.id.obfuscated_res_0x7f090113);
                }
                return (EMTextView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<NadRichTextView>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTitleController$richTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View $rootView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {rootView};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$rootView = rootView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadRichTextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    NadRichTextView nadRichTextView = (NadRichTextView) this.$rootView.findViewById(R.id.obfuscated_res_0x7f0900f3);
                    nadRichTextView.setTextSize(0, TbConfig.getContentSize());
                    return nadRichTextView;
                }
                return (NadRichTextView) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<EMNoPaddingSpan>(this) { // from class: com.baidu.tieba.recapp.lego.controller.NadTitleController$emNoPaddingSpan$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadTitleController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadTitleController.EMNoPaddingSpan invoke() {
                InterceptResult invokeV;
                NadRichTextView k;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (NadTitleController.EMNoPaddingSpan) invokeV.objValue;
                }
                k = this.this$0.k();
                return new NadTitleController.EMNoPaddingSpan(k);
            }
        });
    }

    public final Drawable i(cs0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            return x51.a.a(getContext(), bVar.b);
        }
        return (Drawable) invokeL.objValue;
    }

    @ColorRes
    public final int j(cs0.b bVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            Resources resources = getContext().getResources();
            if (resources == null) {
                i = iy9.b;
                return i;
            }
            return resources.getIdentifier(bVar.d, "color", getContext().getPackageName());
        }
        return invokeL.intValue;
    }

    private final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Context context = l().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "title.context");
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public final Drawable f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Resources resources = getContext().getResources();
            if (resources != null) {
                return ResourcesCompat.getDrawable(resources, R.drawable.nad_download_complete_icon, resources.newTheme());
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public final EMNoPaddingSpan h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (EMNoPaddingSpan) this.e.getValue();
        }
        return (EMNoPaddingSpan) invokeV.objValue;
    }

    public final NadRichTextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-richTitle>(...)");
            return (NadRichTextView) value;
        }
        return (NadRichTextView) invokeV.objValue;
    }

    public final EMTextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object value = this.a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-title>(...)");
            return (EMTextView) value;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdCard adCard = this.c;
            boolean z = true;
            if ((adCard == null || !adCard.isShowNewTitle()) ? false : false) {
                return k();
            }
            return l();
        }
        return (TextView) invokeV.objValue;
    }

    public final Drawable g(cs0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            Drawable a2 = x51.a.a(getContext(), bVar.b);
            if (a2 == null) {
                Resources resources = getContext().getResources();
                if (resources != null) {
                    return ResourcesCompat.getDrawable(resources, R.drawable.nad_download_icon, resources.newTheme());
                }
                return null;
            }
            return a2;
        }
        return (Drawable) invokeL.objValue;
    }

    public final void p(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            int i = adCard.maxTitleLine;
            if (i <= 0) {
                i = 4;
            }
            l().setMaxLines(i);
            l().setText(adCard.threadTitle);
            Boolean bool = adCard.titleBold;
            Intrinsics.checkNotNullExpressionValue(bool, "card.titleBold");
            if (bool.booleanValue()) {
                l().setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                l().setTypeface(Typeface.DEFAULT);
            }
        }
    }

    public final void n(String str) {
        AdvertAppInfo advertAppInfo;
        v05 v05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            AdCard adCard = this.c;
            AdvertAppInfo advertAppInfo2 = null;
            if (adCard != null) {
                advertAppInfo = adCard.getAdvertAppInfo();
            } else {
                advertAppInfo = null;
            }
            if (advertAppInfo == null || (v05Var = advertAppInfo.i) == null) {
                return;
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.CLICK).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(v05Var.b)).v(advertAppInfo.j).j("title_shorturl").p(advertAppInfo.g);
            q31.e(clogBuilder);
            AdCard adCard2 = this.c;
            if (adCard2 != null) {
                advertAppInfo2 = adCard2.getAdvertAppInfo();
            }
            xx8.c(advertAppInfo2);
            l46.a(str);
        }
    }

    public final boolean o(AdCard adCard, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, adCard, i)) == null) {
            cs0.b bVar = adCard.richTitleLinkModel.a;
            if (bVar == null) {
                return false;
            }
            NadRichTextView k = k();
            String str = bVar.a;
            String str2 = adCard.threadTitle;
            Intrinsics.checkNotNullExpressionValue(str2, "card.threadTitle");
            Boolean bool = adCard.titleBold;
            Intrinsics.checkNotNullExpressionValue(bool, "card.titleBold");
            boolean booleanValue = bool.booleanValue();
            i2 = iy9.a;
            k.setParams(new t21(str, str2, booleanValue, i2, bVar.c, j(bVar), i(bVar), g(bVar), f(), i, adCard.maxTitleLine));
            k().setCustomizedProcessor(new a(this));
            if (!k().k()) {
                return false;
            }
            k().postInvalidate();
            rl0 rl0Var = this.d;
            if (rl0Var != null) {
                if (rl0Var != null) {
                    rl0Var.j();
                }
                this.d = null;
            }
            el0 d = sy9.d(adCard);
            d.q.j = "title_shorturl";
            this.d = new rl0(d, k());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void update(AdCard card, int i, View.OnClickListener titleListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, card, i, titleListener) == null) {
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(titleListener, "titleListener");
            this.c = card;
            String str = card.threadTitle;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                l().setVisibility(8);
                k().setVisibility(8);
            } else if (card.isShowNewTitle() && o(card, i)) {
                k().setOnClickListener(titleListener, new b(this));
                k().setVisibility(0);
                l().setVisibility(8);
            } else {
                p(card);
                l().setOnClickListener(titleListener);
                l().setVisibility(0);
                k().setVisibility(8);
            }
        }
    }
}

package com.baidu.tieba.recapp.lego.controller;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a1a;
import com.baidu.tieba.p0a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.bumptech.glide.load.engine.GlideException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u0006H\u0003J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020 J&\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\b¨\u0006&"}, d2 = {"Lcom/baidu/tieba/recapp/lego/controller/NadTagController;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "buttonWidth", "", "getButtonWidth", "()I", "buttonWidth$delegate", "Lkotlin/Lazy;", "closeViewWidth", "getCloseViewWidth", "closeViewWidth$delegate", "reasonNameSwitchTag", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getReasonNameSwitchTag", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "reasonNameSwitchTag$delegate", "recommendReasonTag", "getRecommendReasonTag", "recommendReasonTag$delegate", "tagTextMarginWidth", "getTagTextMarginWidth", "tagTextMarginWidth$delegate", "getNewReasonColor", "getTagMaxWidth", "maxWidth", "isPbBanner", "", "isUrlAd", "onChangeSkinType", "", StickerDataChangeType.UPDATE, "card", "Lcom/baidu/tieba/recapp/lego/model/AdCard;", "tagListener", "Landroid/view/View$OnClickListener;", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NadTagController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public NadTagController(final View rootView) {
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
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<EMTextView>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTagController$reasonNameSwitchTag$2
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
                    return (EMTextView) this.$rootView.findViewById(R.id.obfuscated_res_0x7f090158);
                }
                return (EMTextView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<EMTextView>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTagController$recommendReasonTag$2
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
                    return (EMTextView) this.$rootView.findViewById(R.id.obfuscated_res_0x7f091eab);
                }
                return (EMTextView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<Integer>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTagController$buttonWidth$2
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
            public final Integer invoke() {
                InterceptResult invokeV;
                int i3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Resources resources = this.$rootView.getResources();
                    i3 = p0a.b;
                    return Integer.valueOf((int) resources.getDimension(i3));
                }
                return (Integer) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<Integer>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTagController$tagTextMarginWidth$2
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
            public final Integer invoke() {
                InterceptResult invokeV;
                int i3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Resources resources = this.$rootView.getResources();
                    i3 = p0a.c;
                    return Integer.valueOf((int) resources.getDimension(i3));
                }
                return (Integer) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<Integer>(rootView) { // from class: com.baidu.tieba.recapp.lego.controller.NadTagController$closeViewWidth$2
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
            public final Integer invoke() {
                InterceptResult invokeV;
                int i3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Resources resources = this.$rootView.getResources();
                    i3 = p0a.d;
                    return Integer.valueOf((int) resources.getDimension(i3));
                }
                return (Integer) invokeV.objValue;
            }
        });
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((Number) this.c.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((Number) this.e.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final EMTextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object value = this.a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-reasonNameSwitchTag>(...)");
            return (EMTextView) value;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final EMTextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-recommendReasonTag>(...)");
            return (EMTextView) value;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ((Number) this.d.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setViewTextColor(e(), c());
            EMTextView d = d();
            i = p0a.a;
            SkinManager.setViewTextColor(d, i);
        }
    }

    @ColorRes
    public final int c() {
        InterceptResult invokeV;
        AdCard adCard;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object tag = d().getTag();
            if (tag instanceof AdCard) {
                adCard = (AdCard) tag;
            } else {
                adCard = null;
            }
            if (adCard == null || TextUtils.isEmpty(adCard.recommendReasonColor)) {
                i = p0a.a;
                return i;
            }
            Resources resources = e().getContext().getResources();
            if (resources == null) {
                i2 = p0a.a;
                return i2;
            }
            return resources.getIdentifier(adCard.recommendReasonColor, "color", e().getContext().getPackageName());
        }
        return invokeV.intValue;
    }

    public final int f(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2 || z) {
                int g = i - g();
                if (z2) {
                    g -= a();
                }
                if (z) {
                    return g - b();
                }
                return g;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public final void i(AdCard card, int i, boolean z, View.OnClickListener tagListener) {
        boolean z2;
        boolean z3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{card, Integer.valueOf(i), Boolean.valueOf(z), tagListener}) == null) {
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(tagListener, "tagListener");
            AdvertAppInfo advertAppInfo = card.getAdvertAppInfo();
            if (advertAppInfo != null) {
                z2 = advertAppInfo.g();
            } else {
                z2 = false;
            }
            int f = f(i, z, z2);
            d().setTag(card);
            String str2 = card.recommendReason;
            String str3 = card.recommendReasonNew;
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                str2 = card.userName;
            }
            if (card.hitAdTagMove()) {
                str = "";
            } else {
                str = GlideException.IndentedAppendable.INDENT + "广告";
            }
            if (card.isShowNewRecommendReason()) {
                float f2 = f;
                if (e().getPaint().measureText(str3 + GlideException.IndentedAppendable.INDENT) + d().getPaint().measureText(str2 + str) < f2) {
                    e().setText(str3 + GlideException.IndentedAppendable.INDENT);
                    d().setText(str2 + str);
                } else {
                    float measureText = f2 - (e().getPaint().measureText(str3 + GlideException.IndentedAppendable.INDENT) + d().getPaint().measureText(str));
                    float textSize = d().getTextSize() * ((float) 7);
                    if (measureText > textSize) {
                        CharSequence ellipsize = TextUtils.ellipsize(str2, d().getPaint(), measureText, TextUtils.TruncateAt.END);
                        e().setText(str3 + GlideException.IndentedAppendable.INDENT);
                        d().setText(((Object) ellipsize) + str);
                    } else {
                        CharSequence ellipsize2 = TextUtils.ellipsize(str2, d().getPaint(), textSize, TextUtils.TruncateAt.END);
                        CharSequence ellipsize3 = TextUtils.ellipsize(str3, e().getPaint(), f2 - (e().getPaint().measureText(GlideException.IndentedAppendable.INDENT) + d().getPaint().measureText(((Object) ellipsize2) + str)), TextUtils.TruncateAt.END);
                        e().setText(((Object) ellipsize3) + GlideException.IndentedAppendable.INDENT);
                        d().setText(((Object) ellipsize2) + str);
                    }
                }
                SkinManager.setViewTextColor(e(), c());
                e().setOnClickListener(tagListener);
                e().setVisibility(0);
            } else {
                e().setVisibility(8);
                d().setText(a1a.e(str2, StringsKt__StringsKt.trim((CharSequence) str).toString(), f, d().getPaint()));
            }
            d().setOnClickListener(tagListener);
        }
    }
}

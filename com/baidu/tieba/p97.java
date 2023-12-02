package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.xa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tbclient.FeedContentResource;
/* loaded from: classes7.dex */
public final class p97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends ba7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j57 b;
        public final /* synthetic */ b87 c;
        public final /* synthetic */ r67 d;

        public a(j57 j57Var, b87 b87Var, r67 r67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, b87Var, r67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j57Var;
            this.c = b87Var;
            this.d = r67Var;
        }

        @Override // com.baidu.tieba.ba7, android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                Function2<Context, String, Unit> f = this.b.f();
                Context context = widget.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "widget.context");
                String b = ya7.b(this.c.e(), this.d.d());
                Intrinsics.checkNotNullExpressionValue(b, "appendParams(richTextDat…xtraData.schemaLocalInfo)");
                f.invoke(context, b);
                e87 f2 = this.c.f();
                if (f2 != null) {
                    this.b.g().invoke(f2);
                }
                ac7.a.c(new tb7("rich_text_click", this.c.d(), MapsKt__MapsKt.emptyMap(), this.c.a().a()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:11:0x0031, B:13:0x0059, B:14:0x0064, B:16:0x0082, B:22:0x008e, B:24:0x009f, B:30:0x00d6, B:25:0x00b3, B:27:0x00bd, B:29:0x00c5, B:31:0x00dd), top: B:41:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0025 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(List<FeedContentResource> list, SpannableStringBuilder stringBuilder, r67 feedExtraData, final j57 uiState) {
        aa7 aa7Var;
        b87 c;
        String c2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, list, stringBuilder, feedExtraData, uiState) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            if (ListUtils.isEmpty(list)) {
                return;
            }
            SpannableString spannableString = null;
            for (FeedContentResource feedContentResource : list) {
                try {
                    HashMap<String, Class> a2 = da7.a();
                    xa7.a aVar = xa7.a;
                    Integer num = feedContentResource.type;
                    Intrinsics.checkNotNullExpressionValue(num, "content.type");
                    Class cls = a2.get(aVar.a(num.intValue()));
                    Intrinsics.checkNotNull(cls);
                    aa7Var = (aa7) cls.newInstance();
                    if (aa7Var instanceof ha7) {
                        ((ha7) aa7Var).a(new la7() { // from class: com.baidu.tieba.d97
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.la7
                            public final void onUpdate() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    p97.b(j57.this);
                                }
                            }
                        });
                    }
                    c = xa7.a.c(feedContentResource, feedExtraData.a(), feedExtraData.c(), feedExtraData.e());
                    c2 = c.g().c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (c2 != null && c2.length() != 0) {
                    z = false;
                    if (!z) {
                        String c3 = c.g().c();
                        if (StringsKt__StringsJVMKt.endsWith$default(c3, "\n", false, 2, null)) {
                            c3 = StringsKt__StringsKt.replaceRange((CharSequence) c3, c3.length() - 1, c3.length(), (CharSequence) " \n").toString();
                        } else if (Intrinsics.areEqual(feedContentResource, CollectionsKt___CollectionsKt.last((List<? extends Object>) list)) && !StringsKt__StringsJVMKt.endsWith$default(c3, " ", false, 2, null)) {
                            c3 = c3 + WebvttCueParser.CHAR_SPACE;
                        }
                        c.g().d(c3);
                    }
                    spannableString = aa7Var.b(v27.a, c, new a(uiState, c, feedExtraData));
                    uiState.h().add(c.a());
                    if (spannableString == null) {
                        stringBuilder.append((CharSequence) spannableString);
                    }
                }
                z = true;
                if (!z) {
                }
                spannableString = aa7Var.b(v27.a, c, new a(uiState, c, feedExtraData));
                uiState.h().add(c.a());
                if (spannableString == null) {
                }
            }
        }
    }

    public static final void b(j57 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            uiState.b();
        }
    }
}

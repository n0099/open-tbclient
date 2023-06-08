package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.r77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tbclient.FeedContentResource;
/* loaded from: classes7.dex */
public final class t67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends a77 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s47 b;
        public final /* synthetic */ a67 c;
        public final /* synthetic */ l57 d;

        public a(s47 s47Var, a67 a67Var, l57 l57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s47Var, a67Var, l57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s47Var;
            this.c = a67Var;
            this.d = l57Var;
        }

        @Override // com.baidu.tieba.a77, android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                Function2<Context, String, Unit> d = this.b.d();
                Context context = widget.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "widget.context");
                String b = s77.b(this.c.d(), this.d.c());
                Intrinsics.checkNotNullExpressionValue(b, "appendParams(richTextDat…xtraData.schemaLocalInfo)");
                d.invoke(context, b);
                c67 e = this.c.e();
                if (e != null) {
                    this.b.e().invoke(e);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[Catch: Exception -> 0x00e9, TryCatch #0 {Exception -> 0x00e9, blocks: (B:11:0x0031, B:13:0x0059, B:14:0x0064, B:16:0x0082, B:22:0x008e, B:24:0x009f, B:30:0x00d6, B:25:0x00b3, B:27:0x00bd, B:29:0x00c5, B:31:0x00dd), top: B:41:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0025 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(List<FeedContentResource> list, SpannableStringBuilder stringBuilder, l57 feedExtraData, final s47 uiState) {
        z67 z67Var;
        a67 c;
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
                    HashMap<String, Class> a2 = c77.a();
                    r77.a aVar = r77.a;
                    Integer num = feedContentResource.type;
                    Intrinsics.checkNotNullExpressionValue(num, "content.type");
                    Class cls = a2.get(aVar.a(num.intValue()));
                    Intrinsics.checkNotNull(cls);
                    z67Var = (z67) cls.newInstance();
                    if (z67Var instanceof g77) {
                        ((g77) z67Var).a(new j77() { // from class: com.baidu.tieba.i67
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.j77
                            public final void onUpdate() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    t67.b(s47.this);
                                }
                            }
                        });
                    }
                    c = r77.a.c(feedContentResource, feedExtraData.a(), feedExtraData.b(), feedExtraData.d());
                    c2 = c.f().c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (c2 != null && c2.length() != 0) {
                    z = false;
                    if (!z) {
                        String c3 = c.f().c();
                        if (StringsKt__StringsJVMKt.endsWith$default(c3, "\n", false, 2, null)) {
                            c3 = StringsKt__StringsKt.replaceRange((CharSequence) c3, c3.length() - 1, c3.length(), (CharSequence) " \n").toString();
                        } else if (Intrinsics.areEqual(feedContentResource, CollectionsKt___CollectionsKt.last((List<? extends Object>) list)) && !StringsKt__StringsJVMKt.endsWith$default(c3, " ", false, 2, null)) {
                            c3 = c3 + WebvttCueParser.CHAR_SPACE;
                        }
                        c.f().d(c3);
                    }
                    spannableString = z67Var.b(g37.a, c, new a(uiState, c, feedExtraData));
                    if (spannableString == null) {
                        stringBuilder.append((CharSequence) spannableString);
                    }
                }
                z = true;
                if (!z) {
                }
                spannableString = z67Var.b(g37.a, c, new a(uiState, c, feedExtraData));
                if (spannableString == null) {
                }
            }
        }
    }

    public static final void b(s47 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            uiState.b();
        }
    }
}

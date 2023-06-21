package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.w77;
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
/* loaded from: classes8.dex */
public final class y67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a extends f77 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x47 b;
        public final /* synthetic */ f67 c;
        public final /* synthetic */ q57 d;

        public a(x47 x47Var, f67 f67Var, q57 q57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x47Var, f67Var, q57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x47Var;
            this.c = f67Var;
            this.d = q57Var;
        }

        @Override // com.baidu.tieba.f77, android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                Function2<Context, String, Unit> d = this.b.d();
                Context context = widget.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "widget.context");
                String b = x77.b(this.c.d(), this.d.c());
                Intrinsics.checkNotNullExpressionValue(b, "appendParams(richTextDat…xtraData.schemaLocalInfo)");
                d.invoke(context, b);
                h67 e = this.c.e();
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
    public static final void a(List<FeedContentResource> list, SpannableStringBuilder stringBuilder, q57 feedExtraData, final x47 uiState) {
        e77 e77Var;
        f67 c;
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
                    HashMap<String, Class> a2 = h77.a();
                    w77.a aVar = w77.a;
                    Integer num = feedContentResource.type;
                    Intrinsics.checkNotNullExpressionValue(num, "content.type");
                    Class cls = a2.get(aVar.a(num.intValue()));
                    Intrinsics.checkNotNull(cls);
                    e77Var = (e77) cls.newInstance();
                    if (e77Var instanceof l77) {
                        ((l77) e77Var).a(new o77() { // from class: com.baidu.tieba.n67
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.o77
                            public final void onUpdate() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    y67.b(x47.this);
                                }
                            }
                        });
                    }
                    c = w77.a.c(feedContentResource, feedExtraData.a(), feedExtraData.b(), feedExtraData.d());
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
                    spannableString = e77Var.b(l37.a, c, new a(uiState, c, feedExtraData));
                    if (spannableString == null) {
                        stringBuilder.append((CharSequence) spannableString);
                    }
                }
                z = true;
                if (!z) {
                }
                spannableString = e77Var.b(l37.a, c, new a(uiState, c, feedExtraData));
                if (spannableString == null) {
                }
            }
        }
    }

    public static final void b(x47 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            uiState.b();
        }
    }
}

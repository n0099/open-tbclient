package com.baidu.tieba.impersonal.typewriter;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.impersonal.typewriter.TextTypeWriter;
import com.baidu.tieba.impersonal.typewriter.TextTypeWriter$attachStateChangeListener$2;
import com.baidu.tieba.ja9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u001f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010!\u001a\u00020\u0010R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "", "()V", "attachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateChangeListener", "()Landroid/view/View$OnAttachStateChangeListener;", "attachStateChangeListener$delegate", "Lkotlin/Lazy;", "curContent", "", "curIndex", "", "curLineCount", "finishCallback", "Lkotlin/Function0;", "", DownloadStatisticConstants.UBC_TYPE_FINISHED, "", "fullContent", "lineCountChange", "Lkotlin/Function1;", "target", "Landroid/widget/TextView;", "typeHandler", "Landroid/os/Handler;", "getTypeHandler", "()Landroid/os/Handler;", "typeHandler$delegate", "typeRunnable", "Ljava/lang/Runnable;", "start", "text", "stop", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextTypeWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public Runnable b;
    public TextView c;
    public String d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public Function0<Unit> i;
    public Function1<? super Integer, Unit> j;
    public final Lazy k;

    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextTypeWriter a;
        public final /* synthetic */ List<String> b;

        public a(TextTypeWriter textTypeWriter, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textTypeWriter, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textTypeWriter;
            this.b = list;
        }

        public static final void a(TextView this_run, TextTypeWriter this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this_run, this$0) == null) {
                Intrinsics.checkNotNullParameter(this_run, "$this_run");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this_run.getLineCount() == this$0.g) {
                    return;
                }
                this$0.g = this_run.getLineCount();
                Function1 function1 = this$0.j;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(this_run.getLineCount()));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f += Random.Default.nextInt(3);
                if (this.a.f >= this.b.size()) {
                    TextTypeWriter textTypeWriter = this.a;
                    textTypeWriter.f = textTypeWriter.d.length();
                    TextView textView = this.a.c;
                    if (textView != null) {
                        textView.setText(this.a.d);
                    }
                    this.a.h = true;
                    return;
                }
                TextTypeWriter textTypeWriter2 = this.a;
                textTypeWriter2.e = CollectionsKt___CollectionsKt.joinToString$default(this.b.subList(0, textTypeWriter2.f), "", null, null, 0, null, null, 62, null);
                final TextView textView2 = this.a.c;
                if (textView2 != null) {
                    final TextTypeWriter textTypeWriter3 = this.a;
                    textView2.setText(textTypeWriter3.e);
                    textView2.post(new Runnable() { // from class: com.baidu.tieba.ia9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                TextTypeWriter.a.a(textView2, textTypeWriter3);
                            }
                        }
                    });
                }
                this.a.m().postDelayed(this, Random.Default.nextLong(300L));
            }
        }
    }

    public TextTypeWriter() {
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
        this.a = LazyKt__LazyJVMKt.lazy(TextTypeWriter$typeHandler$2.INSTANCE);
        this.d = "";
        this.e = "";
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<TextTypeWriter$attachStateChangeListener$2.a>(this) { // from class: com.baidu.tieba.impersonal.typewriter.TextTypeWriter$attachStateChangeListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextTypeWriter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            /* loaded from: classes6.dex */
            public static final class a implements View.OnAttachStateChangeListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TextTypeWriter a;

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    }
                }

                public a(TextTypeWriter textTypeWriter) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {textTypeWriter};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = textTypeWriter;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.a.o();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
    }

    public static final void p(TextView this_run, String finalContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this_run, finalContent) == null) {
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            Intrinsics.checkNotNullParameter(finalContent, "$finalContent");
            this_run.setText(finalContent);
        }
    }

    public final View.OnAttachStateChangeListener l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (View.OnAttachStateChangeListener) this.k.getValue();
        }
        return (View.OnAttachStateChangeListener) invokeV.objValue;
    }

    public final Handler m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Handler) this.a.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    public final void n(TextView textView, String text, Function1<? super Integer, Unit> lineCountChange, Function0<Unit> finishCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, textView, text, lineCountChange, finishCallback) == null) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(lineCountChange, "lineCountChange");
            Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
            if (!Intrinsics.areEqual(this.c, textView)) {
                o();
            }
            if (textView == null) {
                return;
            }
            this.c = textView;
            this.i = finishCallback;
            this.j = lineCountChange;
            textView.addOnAttachStateChangeListener(l());
            this.d = text;
            this.e = "";
            this.f = 0;
            a aVar = new a(this, ja9.a.a(text));
            this.b = aVar;
            if (aVar != null) {
                aVar.run();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            final TextView textView = this.c;
            if (textView != null) {
                final String str = this.d;
                textView.post(new Runnable() { // from class: com.baidu.tieba.ha9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            TextTypeWriter.p(textView, str);
                        }
                    }
                });
                textView.removeOnAttachStateChangeListener(l());
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                m().removeCallbacks(runnable);
            }
            this.b = null;
            this.c = null;
            this.d = "";
            this.e = "";
            this.f = 0;
            this.g = 0;
            Function0<Unit> function0 = this.i;
            if (function0 != null) {
                function0.invoke();
            }
            this.i = null;
            this.j = null;
        }
    }
}

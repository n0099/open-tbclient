package com.baidu.tieba.write.webwrite.data;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.a1b;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c4b;
import com.baidu.tieba.h3b;
import com.baidu.tieba.k3b;
import com.baidu.tieba.nu6;
import com.baidu.tieba.q3b;
import com.baidu.tieba.w3b;
import com.baidu.tieba.wi5;
import com.baidu.tieba.write.webwrite.data.BizBase$makeWrapListener$1;
import com.baidu.tieba.ym6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\"\u001a\u00020#JF\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'26\u0010(\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b()\u0012\u0013\u0012\u00110*¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00130\fJ$\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020'2\u0014\u0010.\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00130\u0017J*\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020'2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00130\fJ\u0006\u00100\u001a\u00020\u0013J\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\rRA\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R/\u0010\u0016\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\u00180\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Biz;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "dispatchToH5", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lorg/json/JSONObject;", "r", "", "getDispatchToH5", "()Lkotlin/jvm/functions/Function2;", "makeWrapListener", "Lkotlin/Function1;", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "getMakeWrapListener", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "getWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "getWriteData", "()Lcom/baidu/tbadk/coreExtra/data/WriteData;", "getWritePageState", "()Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "isTextFull", "", "makeActionHandler", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "code", "", "onAction", "id", "", "obj", "makeCodeHandler", "Lcom/baidu/tieba/write/webwrite/data/SimpleRequestCodeHandler;", "onResult", "Landroid/content/Intent;", "refreshPostStatus", PopItemMethodConstant.showToast, "toast", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class BizBase implements k3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final TbWebView b;
    public final WriteData c;
    public final c4b d;
    public final Function2<String, Function1<? super String, Unit>, WrapListener> e;
    public final Function2<String, JSONObject, Unit> f;

    /* loaded from: classes8.dex */
    public static final class a implements h3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function2<Integer, Object, Unit> a;
        public final /* synthetic */ int b;

        public a(Function2<? super Integer, Object, Unit> function2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function2;
            this.b = i;
        }

        @Override // com.baidu.tieba.h3b
        public Integer[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Integer[]{Integer.valueOf(this.b)} : (Integer[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.h3b
        public void b(wi5 action) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Function2<Integer, Object, Unit> function2 = this.a;
                Integer valueOf = Integer.valueOf(action.b);
                Object obj = action.c;
                if (obj == null) {
                    obj = "";
                }
                function2.invoke(valueOf, obj);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r6v1. Raw type applied. Possible types: kotlin.jvm.functions.Function2<java.lang.String, kotlin.jvm.functions.Function1<? super java.lang.String, ? extends kotlin.Unit>, com.baidu.tieba.write.webwrite.data.BizBase$makeWrapListener$1$a>, kotlin.jvm.functions.Function2<java.lang.String, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, com.baidu.tieba.write.webwrite.data.WrapListener> */
    public BizBase(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, c4b writePageState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        this.a = pageContext;
        this.b = webView;
        this.c = writeData;
        this.d = writePageState;
        this.e = new Function2<String, Function1<? super String, ? extends Unit>, BizBase$makeWrapListener$1.a>(this) { // from class: com.baidu.tieba.write.webwrite.data.BizBase$makeWrapListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BizBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
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

            /* loaded from: classes8.dex */
            public static final class a extends WrapListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1<String, Unit> c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(String str, Function1<? super String, Unit> function1, TbWebView tbWebView) {
                    super(str, tbWebView);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, function1, tbWebView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (TbWebView) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = function1;
                }

                @Override // com.baidu.tieba.hz4.c
                public void a(String data) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        this.c.invoke(data);
                    }
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final a invoke2(String key, Function1<? super String, Unit> notify) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, key, notify)) == null) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(notify, "notify");
                    return new a(key, notify, this.this$0.j());
                }
                return (a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ a invoke(String str, Function1<? super String, ? extends Unit> function1) {
                return invoke2(str, (Function1<? super String, Unit>) function1);
            }
        };
        this.f = new Function2<String, JSONObject, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.data.BizBase$dispatchToH5$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BizBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
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

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
                invoke2(str, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String e, JSONObject r) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e, r) == null) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    Intrinsics.checkNotNullParameter(r, "r");
                    ym6.a().i(this.this$0.j(), e, r);
                }
            }
        };
    }

    @Override // com.baidu.tieba.k3b
    public Function1<JSONObject, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return k3b.a.a(this);
        }
        return (Function1) invokeV.objValue;
    }

    public final Function2<String, JSONObject, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<String, Function1<? super String, Unit>, WrapListener> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Function2) invokeV.objValue;
    }

    public final TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final TbWebView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final WriteData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (WriteData) invokeV.objValue;
    }

    public final c4b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (c4b) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.c.getContent())) {
                return false;
            }
            String content = this.c.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "writeData.content");
            if (StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) a1b.c, false, 2, (Object) null) || this.c.getContent().length() < 5000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final h3b n(int i, Function2<? super Integer, Object, Unit> onAction) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, onAction)) == null) {
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            return new a(onAction, i);
        }
        return (h3b) invokeIL.objValue;
    }

    public final q3b o(int i, final Function1<? super Intent, Unit> onResult) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, onResult)) == null) {
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            return new q3b(new Integer[]{Integer.valueOf(i)}, new Function2<Integer, Intent, Unit>(onResult) { // from class: com.baidu.tieba.write.webwrite.data.BizBase$makeCodeHandler$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1<Intent, Unit> $onResult;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onResult = onResult;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Intent intent) {
                    invoke(num.intValue(), intent);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, intent) == null) {
                        this.$onResult.invoke(intent);
                    }
                }
            });
        }
        return (q3b) invokeIL.objValue;
    }

    public final q3b p(int i, Function2<? super Integer, ? super Intent, Unit> onResult) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, onResult)) == null) {
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            return new q3b(new Integer[]{Integer.valueOf(i)}, onResult);
        }
        return (q3b) invokeIL.objValue;
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c4b c4bVar = this.d;
            if (!c4bVar.f() && ((this.c.getWriteImagesInfo() == null || this.c.getWriteImagesInfo().getChosedFiles() == null || this.c.getWriteImagesInfo().size() <= 0) && this.c.getVoiceModel() == null && this.c.getWriteVoteData() == null)) {
                z = false;
            } else {
                z = true;
            }
            c4bVar.s(z);
            nu6.b().b(new w3b(this.d.e()));
        }
    }
}

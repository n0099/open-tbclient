package com.baidu.tieba.pb.pb.main.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.cg6;
import com.baidu.tieba.cy8;
import com.baidu.tieba.dd6;
import com.baidu.tieba.dg6;
import com.baidu.tieba.dj8;
import com.baidu.tieba.ed6;
import com.baidu.tieba.g35;
import com.baidu.tieba.gg6;
import com.baidu.tieba.kh6;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorWebView;
import com.baidu.tieba.uv8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B'\u0012\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;", "Lcom/baidu/tieba/card/BaseCardView;", "Lcom/baidu/tieba/pb/data/PbFirstFloorWebViewItemData;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "pbFirstFloorWebViewSizeChange", "Lcom/baidu/tieba/pb/pb/main/IPbFirstFloorWebViewChange;", "webViewClickListener", "Lcom/baidu/tieba/browser/listener/IWebViewClickListener;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/pb/pb/main/IPbFirstFloorWebViewChange;Lcom/baidu/tieba/browser/listener/IWebViewClickListener;)V", "mFirstFloorWebView", "Lcom/baidu/tieba/browser/TbWebView;", "getMFirstFloorWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "mFirstFloorWebView$delegate", "Lkotlin/Lazy;", "mFirstFloorWebViewBottom", "Landroid/view/View;", "getMFirstFloorWebViewBottom", "()Landroid/view/View;", "mFirstFloorWebViewBottom$delegate", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "generatorHeadlines4WebView", "Lorg/json/JSONObject;", "headlinesData", "", "getLayout", "", "init", "", "onBindDataToView", "data", "onChangeSkinType", "context", WriteMulitImageActivityConfig.SKIN_TYPE, "onClick", "v", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "Companion", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PbFirstFloorWebView extends kh6<uv8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> i;
    public final cy8 j;
    public final cg6 k;
    public final Lazy l;
    public final Lazy m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1573347922, "Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1573347922, "Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;");
        }
    }

    @Override // com.baidu.tieba.kh6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0723 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements ed6<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorWebView a;
        public final /* synthetic */ uv8 b;

        public a(PbFirstFloorWebView pbFirstFloorWebView, uv8 uv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorWebView, uv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorWebView;
            this.b = uv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ed6, java.util.concurrent.Callable
        public JSONObject call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.r(this.b.c());
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorWebView(TbPageContext<?> tbPageContext, cy8 cy8Var, cg6 cg6Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cy8Var, cg6Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        this.j = cy8Var;
        this.k = cg6Var;
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<TbWebView>(this) { // from class: com.baidu.tieba.pb.pb.main.view.PbFirstFloorWebView$mFirstFloorWebView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PbFirstFloorWebView this$0;

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
            public final TbWebView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbWebView) this.this$0.h().findViewById(R.id.obfuscated_res_0x7f090abe);
                }
                return (TbWebView) invokeV.objValue;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.pb.pb.main.view.PbFirstFloorWebView$mFirstFloorWebViewBottom$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PbFirstFloorWebView this$0;

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
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.h().findViewById(R.id.obfuscated_res_0x7f090abf);
                }
                return (View) invokeV.objValue;
            }
        });
        u();
    }

    public static final void A(PbFirstFloorWebView this$0, View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, view2, motionEvent) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            cg6 cg6Var = this$0.k;
            if (cg6Var != null) {
                cg6Var.i(view2, motionEvent);
            }
        }
    }

    public static final boolean x(PbFirstFloorWebView this$0, WebView webView, String url) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, this$0, webView, url)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (url != null && !StringsKt__StringsJVMKt.isBlank(url)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this$0.i;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                int dealOneLinkWithOutJumpWebView = urlManager.dealOneLinkWithOutJumpWebView(tbPageContext, new String[]{url});
                if (dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final void y(PbFirstFloorWebView this$0, Integer t1, Double t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, t1, t2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewGroup.LayoutParams layoutParams = this$0.s().getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) t2.doubleValue();
            }
            this$0.s().requestLayout();
            cy8 cy8Var = this$0.j;
            if (cy8Var != null) {
                Intrinsics.checkNotNullExpressionValue(t1, "t1");
                int intValue = t1.intValue();
                Intrinsics.checkNotNullExpressionValue(t2, "t2");
                cy8Var.a(intValue, t2.doubleValue());
            }
            dj8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("PbFirstFloorWebView", "pb首楼WebView尺寸发生变化，resultCode：" + t1 + ", resultCode: " + t2 + ", url: " + this$0.s().getUrl());
        }
    }

    public static final void z(PbFirstFloorWebView this$0, WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{this$0, webView, webResourceRequest, Integer.valueOf(i), charSequence}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (webResourceRequest.isForMainFrame()) {
                dj8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("PbFirstFloorWebView", "pb首楼WebView,初始化WebView异常回调, url: " + this$0.s().getUrl());
                cy8 cy8Var = this$0.j;
                if (cy8Var != null) {
                    cy8Var.b();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6
    /* renamed from: B */
    public void i(uv8 uv8Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, uv8Var) == null) && uv8Var != null) {
            String d = uv8Var.d();
            boolean z2 = false;
            if (d != null && !StringsKt__StringsJVMKt.isBlank(d)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String c = uv8Var.c();
                if (!((c == null || StringsKt__StringsJVMKt.isBlank(c)) ? true : true)) {
                    s().v("pbToutiaoCard", new a(this, uv8Var));
                }
                dj8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("PbFirstFloorWebView", "loadUrl: " + uv8Var.d());
                s().loadUrl(uv8Var.d());
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DefaultLog.getInstance().c("PbFirstFloorWebView", MissionEvent.MESSAGE_DESTROY);
            s().onDestroy();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DefaultLog.getInstance().c("PbFirstFloorWebView", MissionEvent.MESSAGE_PAUSE);
            s().onPause();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DefaultLog.getInstance().c("PbFirstFloorWebView", "onResume");
            s().onResume();
            s().O();
        }
    }

    public final TbWebView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object value = this.l.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mFirstFloorWebView>(...)");
            return (TbWebView) value;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Object value = this.m.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mFirstFloorWebViewBottom>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    public final JSONObject r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null) {
                return new JSONObject(str);
            }
            return new JSONObject();
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kh6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            g35 d = g35.d(t());
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0201);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            s().setOnLoadUrlListener(new dg6() { // from class: com.baidu.tieba.u19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.dg6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? PbFirstFloorWebView.x(PbFirstFloorWebView.this, webView, str) : invokeLL.booleanValue;
                }
            });
            s().setNestedScrollingEnabled(false);
            s().setScrollBarEnabled(1, false);
            s().setOnSizeChangedListener(new dd6() { // from class: com.baidu.tieba.w19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.dd6
                public final void call(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        PbFirstFloorWebView.y(PbFirstFloorWebView.this, (Integer) obj, (Double) obj2);
                    }
                }
            });
            s().setOnReceivedErrorListener(new gg6() { // from class: com.baidu.tieba.x19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gg6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        PbFirstFloorWebView.z(PbFirstFloorWebView.this, webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            s().setOnDoubleClickListener(new cg6() { // from class: com.baidu.tieba.v19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.cg6
                public final void i(View view2, MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, motionEvent) == null) {
                        PbFirstFloorWebView.A(PbFirstFloorWebView.this, view2, motionEvent);
                    }
                }
            });
        }
    }
}

package com.baidu.tieba.write.webwrite.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.c4b;
import com.baidu.tieba.e1b;
import com.baidu.tieba.en6;
import com.baidu.tieba.g3b;
import com.baidu.tieba.gn6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nu6;
import com.baidu.tieba.r3b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.t7b;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.vj6;
import com.baidu.tieba.vy4;
import com.baidu.tieba.wi5;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.write.webwrite.data.WriteDataManager;
import com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment;
import com.baidu.tieba.wt5;
import com.baidu.tieba.xi5;
import com.baidu.tieba.ym6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0010\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001cH&J\b\u0010?\u001a\u00020@H&J\u0010\u0010A\u001a\u00020\b2\b\b\u0002\u0010B\u001a\u00020CJ\b\u0010D\u001a\u00020\bH\u0002J\b\u0010E\u001a\u00020FH&J\b\u0010G\u001a\u00020,H&J\u0006\u0010H\u001a\u00020\bJ\u0006\u0010I\u001a\u00020\bJ \u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020C2\b\u0010M\u001a\u0004\u0018\u00010NJ\u0006\u0010O\u001a\u00020\bJ\b\u0010P\u001a\u00020\bH\u0016J\b\u0010Q\u001a\u00020\u001cH\u0002J\"\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010%2\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020\u001cH\u0002J\u0006\u0010V\u001a\u00020\bJ\b\u0010W\u001a\u00020'H\u0002J\b\u0010X\u001a\u00020\bH\u0002J\b\u0010Y\u001a\u00020\bH&J\u0012\u0010Z\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020CH\u0016J&\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010#2\b\u0010S\u001a\u0004\u0018\u00010%H\u0016J\b\u0010d\u001a\u00020\bH\u0016J\b\u0010e\u001a\u00020\bH\u0016J\u0010\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\rH\u0016J\b\u0010h\u001a\u00020\bH\u0014J\u0010\u0010i\u001a\u00020\b2\b\u0010j\u001a\u0004\u0018\u00010NJ\b\u0010k\u001a\u00020\bH\u0016J\b\u0010l\u001a\u00020\bH\u0016J\u0010\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020%H\u0016J\b\u0010o\u001a\u00020\bH\u0016J\b\u0010p\u001a\u00020\bH\u0002R-\u0010\u0005\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006q"}, d2 = {"Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;", "Lcom/baidu/tbadk/browser/BaseWebViewFragment;", "Lcom/baidu/tbadk/editortools/ActionListener;", "Lcom/baidu/tbadk/browser/loading/IWebLoadingBehavior;", "()V", "destroyHooks", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getDestroyHooks", "()Ljava/util/ArrayList;", "initDelay", "", "getInitDelay", "()Z", "setInitDelay", "(Z)V", "isLoading", "isPageFinished", "loadError", "mBackgroundSwitchController", "Lcom/baidu/tieba/write/write/components/helper/BackgroundSwitchController;", "getMBackgroundSwitchController", "()Lcom/baidu/tieba/write/write/components/helper/BackgroundSwitchController;", "mBackgroundSwitchController$delegate", "Lkotlin/Lazy;", "mEditor", "Lcom/baidu/tbadk/editortools/EditorTools;", "getMEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "mEditor$delegate", "mLoadStateContainer", "Landroid/widget/FrameLayout;", "mRootView", "Landroid/view/ViewGroup;", "mSavedInstanceState", "Landroid/os/Bundle;", "mWebView", "Lcom/baidu/tieba/browser/TbWebView;", "getMWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "mWebView$delegate", "mWriteDataManager", "Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "getMWriteDataManager$write_release", "()Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "mWriteDataManager$delegate", "mWritePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "getMWritePageState", "()Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "mWritePageState$delegate", "outPageFinishedListener", "Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;", "getOutPageFinishedListener", "()Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;", "setOutPageFinishedListener", "(Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;)V", "checkLinkBubble", "clearDraft", "configEditor", "editorTools", "delayMillis", "", "finishActivity", "result", "", "forceRefresh", "getTypeStr", "", "getWriteDataManager", "handleBackPressed", "handlePost", "handlerActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "hideLinkBubble", "hideLoading", "initEditor", "initManager", "savedInstanceState", "webView", "editor", "initPage", "initWebView", "logPageShow", "notifyNext", "onAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onKeyboardVisibilityChanged", "isVisible", "onNetRefreshButtonClicked", "onNewIntent", "intent", MissionEvent.MESSAGE_PAUSE, "onResume", "onSaveInstanceState", "outState", "showLoading", "showNetRefreshView", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class BaseWebWriteFragment extends BaseWebViewFragment implements xi5, vy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy e;
    public en6 f;
    public ViewGroup g;
    public FrameLayout h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public Bundle p;
    public final ArrayList<Function0<Unit>> q;
    public final Lazy r;

    public abstract String I2();

    public abstract WriteDataManager J2();

    public abstract void V2();

    public abstract void y2(EditorTools editorTools);

    /* loaded from: classes8.dex */
    public static final class a extends g3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<TbWebView> f;
        public final /* synthetic */ BaseWebWriteFragment g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Ref.ObjectRef<TbWebView> objectRef, BaseWebWriteFragment baseWebWriteFragment) {
            super(objectRef.element);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, baseWebWriteFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((TbWebView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = objectRef;
            this.g = baseWebWriteFragment;
        }

        public static final void k(BaseWebWriteFragment this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.V2();
            }
        }

        public static final void l(BaseWebWriteFragment this$0, WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, webView, str) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                en6 H2 = this$0.H2();
                if (H2 != null) {
                    H2.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.g3b
        public void i(final WebView webView, final String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, webView, str) != null) {
                return;
            }
            this.g.i = false;
            this.g.k = true;
            FrameLayout frameLayout = null;
            if (this.g.j) {
                this.f.element.getController().e();
                this.f.element.setVisibility(8);
                FrameLayout frameLayout2 = this.g.h;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout2 = null;
                }
                frameLayout2.setVisibility(0);
                BaseWebWriteFragment baseWebWriteFragment = this.g;
                FrameLayout frameLayout3 = baseWebWriteFragment.h;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                } else {
                    frameLayout = frameLayout3;
                }
                baseWebWriteFragment.hideLoadingView(frameLayout);
                this.g.Z2();
            } else {
                this.f.element.setVisibility(0);
                FrameLayout frameLayout4 = this.g.h;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout4 = null;
                }
                frameLayout4.setVisibility(8);
                BaseWebWriteFragment baseWebWriteFragment2 = this.g;
                FrameLayout frameLayout5 = baseWebWriteFragment2.h;
                if (frameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout5 = null;
                }
                baseWebWriteFragment2.hideLoadingView(frameLayout5);
                BaseWebWriteFragment baseWebWriteFragment3 = this.g;
                FrameLayout frameLayout6 = baseWebWriteFragment3.h;
                if (frameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                } else {
                    frameLayout = frameLayout6;
                }
                baseWebWriteFragment3.hideNetRefreshView(frameLayout);
                String b = this.f.element.getController().b();
                if (!TextUtils.isEmpty(b)) {
                    this.g.l2(b);
                }
            }
            SafeHandler inst = SafeHandler.getInst();
            final BaseWebWriteFragment baseWebWriteFragment4 = this.g;
            inst.post(new Runnable() { // from class: com.baidu.tieba.z3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BaseWebWriteFragment.a.k(BaseWebWriteFragment.this);
                    }
                }
            });
            SafeHandler inst2 = SafeHandler.getInst();
            final BaseWebWriteFragment baseWebWriteFragment5 = this.g;
            inst2.postDelayed(new Runnable() { // from class: com.baidu.tieba.x3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BaseWebWriteFragment.a.l(BaseWebWriteFragment.this, webView, str);
                    }
                }
            }, 100L);
        }

        @Override // com.baidu.tieba.g3b
        public void j(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) != null) {
                return;
            }
            this.g.j = false;
        }
    }

    public BaseWebWriteFragment() {
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
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<c4b>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mWritePageState$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebWriteFragment this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c4b invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new c4b(this.this$0);
                }
                return (c4b) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<TbWebView>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mWebView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebWriteFragment this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbWebView invoke() {
                InterceptResult invokeV;
                TbWebView R2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (TbWebView) invokeV.objValue;
                }
                R2 = this.this$0.R2();
                return R2;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<EditorTools>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mEditor$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebWriteFragment this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditorTools invoke() {
                InterceptResult invokeV;
                EditorTools O2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EditorTools) invokeV.objValue;
                }
                O2 = this.this$0.O2();
                return O2;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<WriteDataManager>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mWriteDataManager$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebWriteFragment this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WriteDataManager invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.J2();
                }
                return (WriteDataManager) invokeV.objValue;
            }
        });
        this.q = new ArrayList<>();
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<t7b>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mBackgroundSwitchController$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebWriteFragment this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final t7b invoke() {
                InterceptResult invokeV;
                EditorTools D2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TbPageContext<BaseFragmentActivity> pageContext = this.this$0.getPageContext();
                    D2 = this.this$0.D2();
                    return new t7b(pageContext, D2);
                }
                return (t7b) invokeV.objValue;
            }
        });
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (D2().x()) {
                D2().t();
                return;
            }
            G2().l().b();
            if (!G2().g().e(G2().e(), F2().b())) {
                A2(this, 0, 1, null);
            }
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && isAdded() && !G2().i()) {
            G2().x(true);
            P2(this.p, E2(), D2());
            y2(D2());
            D2().z(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onResume();
            if (!G2().i()) {
                Q2();
            }
            if (isAdded()) {
                ym6.a().d(E2(), CommonTbJsBridge.RE_SHOW, null);
                E2().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
            U2();
            s1b.a(E2());
        }
    }

    public static /* synthetic */ void A2(BaseWebWriteFragment baseWebWriteFragment, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 100;
            }
            baseWebWriteFragment.z2(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishActivity");
    }

    public static final void S2(BaseWebWriteFragment this$0, WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{this$0, webView, webResourceRequest, Integer.valueOf(i), charSequence}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this$0.j = true;
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("WebWriteActivity", this$0.I2() + "新发布器OnReceivedError:" + i + WebvttCueParser.CHAR_SPACE + ((Object) charSequence) + WebvttCueParser.CHAR_SPACE + webView + WebvttCueParser.CHAR_SPACE + webResourceRequest);
                this$0.Z2();
            }
        }
    }

    public static final Unit T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            nu6.b().b(new r3b(true));
            return Unit.INSTANCE;
        }
        return (Unit) invokeV.objValue;
    }

    public final ArrayList<Function0<Unit>> B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final t7b C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (t7b) this.r.getValue();
        }
        return (t7b) invokeV.objValue;
    }

    public final EditorTools D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (EditorTools) this.m.getValue();
        }
        return (EditorTools) invokeV.objValue;
    }

    public final TbWebView E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (TbWebView) this.l.getValue();
        }
        return (TbWebView) invokeV.objValue;
    }

    public final WriteDataManager F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (WriteDataManager) this.n.getValue();
        }
        return (WriteDataManager) invokeV.objValue;
    }

    public final c4b G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (c4b) this.e.getValue();
        }
        return (c4b) invokeV.objValue;
    }

    public final en6 H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (en6) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && G2().q()) {
            ym6.a().i(E2(), "writePageNa.handlePost", new JSONObject());
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            C2().f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e42);
            } else {
                h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onPause();
            C2().f();
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            C2().g();
            C2().e();
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            G2().g().b();
        }
    }

    @Override // com.baidu.tieba.xi5
    public void O(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, wi5Var) == null) && wi5Var != null) {
            F2().k(wi5Var);
        }
    }

    public final void W2(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, intent) == null) && intent != null) {
            F2().l(intent);
        }
    }

    public final void X2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.o = z;
        }
    }

    public final void Y2(en6 en6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, en6Var) == null) {
            this.f = en6Var;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            F2().m(outState);
        }
    }

    public final void z2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(i);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public final void M2(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            if (i2 == -1) {
                F2().h(i, intent);
            }
            if (i2 == 0 && i == 12006 && intent != null && intent.getExtras() != null) {
                Bundle extras = intent.getExtras();
                Intrinsics.checkNotNull(extras);
                if (extras.getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) {
                    Bundle extras2 = intent.getExtras();
                    Intrinsics.checkNotNull(extras2);
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) extras2.getSerializable("post_write_callback_data");
                    if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        getPageContext().showToast(postWriteCallBackData.getErrorString());
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorString", postWriteCallBackData.getErrorString());
                        jSONObject.put("sensitiveWords", postWriteCallBackData.getSensitiveWords());
                        ym6.a().i(E2(), "writePageNa.vCodeResult", new JSONObject());
                    }
                }
            }
        }
    }

    public final void P2(Bundle bundle, TbWebView tbWebView, EditorTools editorTools) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, bundle, tbWebView, editorTools) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            F2().f(G2(), bundle, intent);
            WriteDataManager F2 = F2();
            c4b G2 = G2();
            TbWebView E2 = E2();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            F2.n(G2, E2, editorTools, pageContext);
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_draft_fid_" + I2()), null);
            if (TextUtils.isEmpty(F2().b().getForumId()) && !TextUtils.isEmpty(string)) {
                F2().b().setForumId(string);
            }
            G2().g().c();
            F2().g(bundle, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            k2(requireArguments().getString("write_url"));
            this.p = bundle;
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0154, (ViewGroup) null);
            if (inflate != null) {
                ViewGroup viewGroup2 = (ViewGroup) inflate;
                this.g = viewGroup2;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup2 = null;
                }
                View findViewById = viewGroup2.findViewById(R.id.load_state_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.load_state_container)");
                this.h = (FrameLayout) findViewById;
                if (!this.o) {
                    Q2();
                }
                ViewGroup viewGroup3 = this.g;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    return null;
                }
                return viewGroup3;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        return (View) invokeLLL.objValue;
    }

    public final EditorTools O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            EditorTools editorTools = new EditorTools(getPageContext().getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ViewGroup viewGroup = this.g;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.addView(editorTools, layoutParams);
            return editorTools;
        }
        return (EditorTools) invokeV.objValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || E2() == null) {
            return;
        }
        E2().setVisibility(8);
        FrameLayout frameLayout = this.h;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            frameLayout2 = null;
        }
        showNetRefreshView(frameLayout2, null, true);
    }

    @Override // com.baidu.tieba.vy4
    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.h == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            }
            this.i = false;
            FrameLayout frameLayout = this.h;
            FrameLayout frameLayout2 = null;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(8);
            FrameLayout frameLayout3 = this.h;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            } else {
                frameLayout2 = frameLayout3;
            }
            hideLoadingView(frameLayout2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDestroy();
            if (G2().q() && !G2().j()) {
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
            }
            Iterator<T> it = this.q.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            this.q.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (G2().i()) {
                s1b.b(E2());
                if (!this.k) {
                    E2().p();
                }
                E2().onDestroy();
                F2().j();
            }
            super.onDestroyView();
        }
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.baidu.tieba.browser.TbWebView] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.baidu.tieba.browser.TbWebView] */
    public final TbWebView R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            WriteWebViewCacheManager b = WriteWebViewCacheManager.c.b();
            String mUrl = this.a;
            Intrinsics.checkNotNullExpressionValue(mUrl, "mUrl");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ?? d = b.d(mUrl, requireContext);
            objectRef.element = d;
            if (d == 0) {
                e1b.a aVar = e1b.a;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                ?? a2 = aVar.a(requireContext2);
                objectRef.element = a2;
                ((TbWebView) a2).loadUrl(this.a);
            }
            G2().D(new a(objectRef, this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.g;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.addView((View) objectRef.element, layoutParams);
            ((TbWebView) objectRef.element).setNeedDisAllowParentInterceptTouchEvent(false);
            ((TbWebView) objectRef.element).setOnReceivedErrorListener(new gn6() { // from class: com.baidu.tieba.y3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gn6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        BaseWebWriteFragment.S2(BaseWebWriteFragment.this, webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            ((TbWebView) objectRef.element).setInvalidPageCallback(new vj6() { // from class: com.baidu.tieba.a4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vj6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? BaseWebWriteFragment.T2() : invokeV2.objValue;
                }
            });
            G2().n().g();
            return (TbWebView) objectRef.element;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final void U2() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            int F = G2().F();
            int i2 = -1;
            if (F != 9) {
                if (F != 11) {
                    if (F != 14) {
                        i = -1;
                    } else {
                        i = 5;
                    }
                } else {
                    i = 2;
                }
            } else {
                i = 1;
            }
            if (Intrinsics.areEqual("main_tab", F2().b().getFrom())) {
                i2 = 0;
            } else if (Intrinsics.areEqual("frs", F2().b().getFrom())) {
                i2 = 1;
            }
            new StatisticItem("c14823").addParam("obj_source", i).addParam("obj_locate", i2).addParam("obj_type", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.h == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            }
            if (E2() != null && !this.i && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
                this.i = true;
                FrameLayout frameLayout = this.h;
                FrameLayout frameLayout2 = null;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                E2().setVisibility(8);
                FrameLayout frameLayout3 = this.h;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout3 = null;
                }
                hideNetRefreshView(frameLayout3);
                FrameLayout frameLayout4 = this.h;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                } else {
                    frameLayout2 = frameLayout4;
                }
                showLoadingView(frameLayout2);
                E2().loadUrl(this.a);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.g != null) {
            super.onChangeSkinType(i);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            ViewGroup viewGroup = this.g;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            wt5.a(pageContext, viewGroup);
            ViewGroup viewGroup3 = this.g;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup3;
            }
            EMManager.from(viewGroup2).setBackGroundColor(R.color.CAM_X0201);
            if (G2().i()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
                Intrinsics.checkNotNullExpressionValue(currentSkinTypeString, "getCurrentSkinTypeString()");
                linkedHashMap.put("skin", currentSkinTypeString);
                ym6.a().d(E2(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                D2().z(TbadkCoreApplication.getInst().getSkinType());
                E2().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (z) {
                D2().t();
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (z) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
            } else {
                i = 0;
            }
            hashMap.put("height", Integer.valueOf(i));
            hashMap.put("animationDuration", Float.valueOf(1.0f));
            ym6.a().d(E2(), "keyboardHeightChange", hashMap);
        }
    }
}

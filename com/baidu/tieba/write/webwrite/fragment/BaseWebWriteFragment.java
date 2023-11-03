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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.a9b;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.cbb;
import com.baidu.tieba.dj6;
import com.baidu.tieba.jj6;
import com.baidu.tieba.lj6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mq6;
import com.baidu.tieba.nbb;
import com.baidu.tieba.o9b;
import com.baidu.tieba.pfb;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.ut4;
import com.baidu.tieba.wp5;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.write.webwrite.data.WriteDataManager;
import com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment;
import com.baidu.tieba.xd5;
import com.baidu.tieba.ybb;
import com.baidu.tieba.yd5;
import com.baidu.tieba.zf6;
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
public abstract class BaseWebWriteFragment extends BaseWebViewFragment implements yd5, ut4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy e;
    public jj6 f;
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

    public abstract void Q2(EditorTools editorTools);

    public abstract String a3();

    public abstract WriteDataManager b3();

    public abstract void n3();

    /* loaded from: classes8.dex */
    public static final class a extends cbb {
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
                this$0.n3();
            }
        }

        public static final void l(BaseWebWriteFragment this$0, WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, webView, str) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                jj6 Z2 = this$0.Z2();
                if (Z2 != null) {
                    Z2.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.cbb
        public void i(final WebView webView, final String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
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
                    this.g.r3();
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
                        this.g.D2(b);
                    }
                }
                SafeHandler inst = SafeHandler.getInst();
                final BaseWebWriteFragment baseWebWriteFragment4 = this.g;
                inst.post(new Runnable() { // from class: com.baidu.tieba.vbb
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
                inst2.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbb
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
        }

        @Override // com.baidu.tieba.cbb
        public void j(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                this.g.j = false;
            }
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
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<ybb>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mWritePageState$2
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
            public final ybb invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new ybb(this.this$0);
                }
                return (ybb) invokeV.objValue;
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
                TbWebView j3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (TbWebView) invokeV.objValue;
                }
                j3 = this.this$0.j3();
                return j3;
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
                EditorTools g3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EditorTools) invokeV.objValue;
                }
                g3 = this.this$0.g3();
                return g3;
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
                    return this.this$0.b3();
                }
                return (WriteDataManager) invokeV.objValue;
            }
        });
        this.q = new ArrayList<>();
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<pfb>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mBackgroundSwitchController$2
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
            public final pfb invoke() {
                InterceptResult invokeV;
                EditorTools V2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TbPageContext<BaseFragmentActivity> pageContext = this.this$0.getPageContext();
                    V2 = this.this$0.V2();
                    return new pfb(pageContext, V2);
                }
                return (pfb) invokeV.objValue;
            }
        });
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (V2().D()) {
                V2().y();
                return;
            }
            Y2().l().b();
            if (!Y2().g().e(Y2().e(), X2().b())) {
                S2(this, 0, 1, null);
            }
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && isAdded() && !Y2().i()) {
            Y2().x(true);
            h3(this.p, W2(), V2());
            Q2(V2());
            V2().F(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            if (!Y2().i()) {
                i3();
            }
            if (isAdded()) {
                dj6.a().d(W2(), CommonTbJsBridge.RE_SHOW, null);
                W2().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
            m3();
            o9b.a(W2());
        }
    }

    public final void R2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
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

    @Override // com.baidu.tieba.yd5
    public void S(xd5 xd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xd5Var) == null) && xd5Var != null) {
            X2().k(xd5Var);
        }
    }

    public final void o3(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, intent) == null) && intent != null) {
            X2().l(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            X2().m(outState);
        }
    }

    public final void p3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.o = z;
        }
    }

    public final void q3(jj6 jj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jj6Var) == null) {
            this.f = jj6Var;
        }
    }

    public static /* synthetic */ void S2(BaseWebWriteFragment baseWebWriteFragment, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 100;
            }
            baseWebWriteFragment.R2(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishActivity");
    }

    public static final void k3(BaseWebWriteFragment this$0, WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{this$0, webView, webResourceRequest, Integer.valueOf(i), charSequence}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this$0.j = true;
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("WebWriteActivity", this$0.a3() + "新发布器OnReceivedError:" + i + WebvttCueParser.CHAR_SPACE + ((Object) charSequence) + WebvttCueParser.CHAR_SPACE + webView + WebvttCueParser.CHAR_SPACE + webResourceRequest);
                this$0.r3();
            }
        }
    }

    public static final Unit l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            mq6.b().c(new nbb(true));
            return Unit.INSTANCE;
        }
        return (Unit) invokeV.objValue;
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            U2().g();
            U2().e();
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Y2().g().b();
        }
    }

    public final ArrayList<Function0<Unit>> T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final pfb U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (pfb) this.r.getValue();
        }
        return (pfb) invokeV.objValue;
    }

    public final EditorTools V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (EditorTools) this.m.getValue();
        }
        return (EditorTools) invokeV.objValue;
    }

    public final TbWebView W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (TbWebView) this.l.getValue();
        }
        return (TbWebView) invokeV.objValue;
    }

    public final WriteDataManager X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (WriteDataManager) this.n.getValue();
        }
        return (WriteDataManager) invokeV.objValue;
    }

    public final ybb Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (ybb) this.e.getValue();
        }
        return (ybb) invokeV.objValue;
    }

    public final jj6 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (jj6) invokeV.objValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && Y2().q()) {
            dj6.a().i(W2(), "writePageNa.handlePost", new JSONObject());
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            U2().f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e61);
            } else {
                i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            U2().f();
        }
    }

    public final void e3(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            if (i2 == -1) {
                X2().h(i, intent);
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
                        dj6.a().i(W2(), "writePageNa.vCodeResult", new JSONObject());
                    }
                }
            }
        }
    }

    public final void h3(Bundle bundle, TbWebView tbWebView, EditorTools editorTools) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, bundle, tbWebView, editorTools) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            X2().f(Y2(), bundle, intent);
            WriteDataManager X2 = X2();
            ybb Y2 = Y2();
            TbWebView W2 = W2();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            X2.n(Y2, W2, editorTools, pageContext);
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_draft_fid_" + a3()), null);
            if (TextUtils.isEmpty(X2().b().getForumId()) && !TextUtils.isEmpty(string)) {
                X2().b().setForumId(string);
            }
            Y2().g().c();
            X2().g(bundle, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            C2(requireArguments().getString("write_url"));
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
                    i3();
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

    public final EditorTools g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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

    @Override // com.baidu.tieba.ut4
    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroy();
            if (Y2().q() && !Y2().j()) {
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
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (Y2().i()) {
                o9b.b(W2());
                if (!this.k) {
                    W2().q();
                }
                W2().onDestroy();
                X2().j();
            }
            super.onDestroyView();
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || W2() == null) {
            return;
        }
        W2().setVisibility(8);
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

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.h == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            }
            if (W2() != null && !this.i && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
                this.i = true;
                FrameLayout frameLayout = this.h;
                FrameLayout frameLayout2 = null;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                W2().setVisibility(8);
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
                W2().loadUrl(this.a);
            }
        }
    }

    public final void m3() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int F = Y2().F();
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
            if (Intrinsics.areEqual("main_tab", X2().b().getFrom())) {
                i2 = 0;
            } else if (Intrinsics.areEqual("frs", X2().b().getFrom())) {
                i2 = 1;
            }
            new StatisticItem("c14823").addParam("obj_source", i).addParam("obj_locate", i2).addParam("obj_type", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.baidu.tieba.browser.TbWebView] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.baidu.tieba.browser.TbWebView] */
    public final TbWebView j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            WriteWebViewCacheManager b = WriteWebViewCacheManager.c.b();
            String mUrl = this.a;
            Intrinsics.checkNotNullExpressionValue(mUrl, "mUrl");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ?? e = b.e(mUrl, requireContext);
            objectRef.element = e;
            if (e == 0) {
                a9b.a aVar = a9b.a;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                ?? a2 = aVar.a(requireContext2);
                objectRef.element = a2;
                ((TbWebView) a2).loadUrl(this.a);
            }
            Y2().D(new a(objectRef, this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.g;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.addView((View) objectRef.element, layoutParams);
            ((TbWebView) objectRef.element).setNeedDisAllowParentInterceptTouchEvent(false);
            ((TbWebView) objectRef.element).setOnReceivedErrorListener(new lj6() { // from class: com.baidu.tieba.ubb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lj6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        BaseWebWriteFragment.k3(BaseWebWriteFragment.this, webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            ((TbWebView) objectRef.element).setInvalidPageCallback(new zf6() { // from class: com.baidu.tieba.wbb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zf6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? BaseWebWriteFragment.l3() : invokeV2.objValue;
                }
            });
            Y2().n().g();
            return (TbWebView) objectRef.element;
        }
        return (TbWebView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && this.g != null) {
            super.onChangeSkinType(i);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            ViewGroup viewGroup = this.g;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            wp5.a(pageContext, viewGroup);
            ViewGroup viewGroup3 = this.g;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup3;
            }
            EMManager.from(viewGroup2).setBackGroundColor(R.color.CAM_X0201);
            if (Y2().i()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
                Intrinsics.checkNotNullExpressionValue(currentSkinTypeString, "getCurrentSkinTypeString()");
                linkedHashMap.put("skin", currentSkinTypeString);
                dj6.a().d(W2(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                V2().F(TbadkCoreApplication.getInst().getSkinType());
                W2().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (z) {
                V2().y();
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (z) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
            } else {
                i = 0;
            }
            hashMap.put("height", Integer.valueOf(i));
            hashMap.put("animationDuration", Float.valueOf(1.0f));
            dj6.a().d(W2(), "keyboardHeightChange", hashMap);
        }
    }
}

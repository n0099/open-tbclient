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
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.ee5;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fq5;
import com.baidu.tieba.ig6;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.kgb;
import com.baidu.tieba.leb;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mkb;
import com.baidu.tieba.nj6;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.tj6;
import com.baidu.tieba.vgb;
import com.baidu.tieba.vj6;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.write.webwrite.data.WriteDataManager;
import com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment;
import com.baidu.tieba.wt4;
import com.baidu.tieba.xdb;
import com.baidu.tieba.xq6;
import com.baidu.tieba.zfb;
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
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0010\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001cH&J\b\u0010?\u001a\u00020@H&J\u0010\u0010A\u001a\u00020\b2\b\b\u0002\u0010B\u001a\u00020CJ\b\u0010D\u001a\u00020\bH\u0002J\b\u0010E\u001a\u00020FH&J\b\u0010G\u001a\u00020,H&J\u0006\u0010H\u001a\u00020\bJ\u0006\u0010I\u001a\u00020\bJ \u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020C2\b\u0010M\u001a\u0004\u0018\u00010NJ\u0006\u0010O\u001a\u00020\bJ\b\u0010P\u001a\u00020\bH\u0016J\b\u0010Q\u001a\u00020\u001cH\u0002J\"\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010%2\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020\u001cH\u0002J\u0006\u0010V\u001a\u00020\bJ\b\u0010W\u001a\u00020'H\u0002J\b\u0010X\u001a\u00020\bH\u0002J\b\u0010Y\u001a\u00020\bH&J\u0012\u0010Z\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020CH\u0016J&\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010#2\b\u0010S\u001a\u0004\u0018\u00010%H\u0016J\b\u0010d\u001a\u00020\bH\u0016J\b\u0010e\u001a\u00020\bH\u0016J\u0010\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\rH\u0016J\b\u0010h\u001a\u00020\bH\u0014J\u0010\u0010i\u001a\u00020\b2\b\u0010j\u001a\u0004\u0018\u00010NJ\b\u0010k\u001a\u00020\bH\u0016J\b\u0010l\u001a\u00020\bH\u0016J\u0010\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020%H\u0016J\b\u0010o\u001a\u00020\bH\u0016J\b\u0010p\u001a\u00020\bH\u0002R-\u0010\u0005\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006q"}, d2 = {"Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;", "Lcom/baidu/tbadk/browser/BaseWebViewFragment;", "Lcom/baidu/tbadk/editortools/ActionListener;", "Lcom/baidu/tbadk/browser/loading/IWebLoadingBehavior;", "()V", "destroyHooks", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getDestroyHooks", "()Ljava/util/ArrayList;", "initDelay", "", "getInitDelay", "()Z", "setInitDelay", "(Z)V", "isLoading", "isPageFinished", "loadError", "mBackgroundSwitchController", "Lcom/baidu/tieba/write/write/components/helper/BackgroundSwitchController;", "getMBackgroundSwitchController", "()Lcom/baidu/tieba/write/write/components/helper/BackgroundSwitchController;", "mBackgroundSwitchController$delegate", "Lkotlin/Lazy;", "mEditor", "Lcom/baidu/tbadk/editortools/EditorTools;", "getMEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "mEditor$delegate", "mLoadStateContainer", "Landroid/widget/FrameLayout;", "mRootView", "Landroid/view/ViewGroup;", "mSavedInstanceState", "Landroid/os/Bundle;", "mWebView", "Lcom/baidu/tieba/browser/TbWebView;", "getMWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "mWebView$delegate", "mWriteDataManager", "Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "getMWriteDataManager$write_release", "()Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "mWriteDataManager$delegate", "mWritePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "getMWritePageState", "()Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "mWritePageState$delegate", "outPageFinishedListener", "Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;", "getOutPageFinishedListener", "()Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;", "setOutPageFinishedListener", "(Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;)V", "checkLinkBubble", "clearDraft", "configEditor", "editorTools", "delayMillis", "", "finishActivity", "result", "", "forceRefresh", "getTypeStr", "", "getWriteDataManager", "handleBackPressed", "handlePost", "handlerActivityResult", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "hideLinkBubble", "hideLoading", "initEditor", "initManager", "savedInstanceState", "webView", "editor", "initPage", "initWebView", "logPageShow", "notifyNext", "onAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onKeyboardVisibilityChanged", "isVisible", "onNetRefreshButtonClicked", "onNewIntent", "intent", MissionEvent.MESSAGE_PAUSE, "onResume", "onSaveInstanceState", "outState", "showLoading", "showNetRefreshView", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class BaseWebWriteFragment extends BaseWebViewFragment implements fe5, wt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy e;
    public tj6 f;
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

    public abstract void c3(EditorTools editorTools);

    public abstract String m3();

    public abstract WriteDataManager n3();

    public abstract void z3();

    /* loaded from: classes8.dex */
    public static final class a extends zfb {
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
                this$0.z3();
            }
        }

        public static final void l(BaseWebWriteFragment this$0, WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, webView, str) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                tj6 l3 = this$0.l3();
                if (l3 != null) {
                    l3.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.zfb
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
                    this.g.D3();
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
                        this.g.P2(b);
                    }
                }
                SafeHandler inst = SafeHandler.getInst();
                final BaseWebWriteFragment baseWebWriteFragment4 = this.g;
                inst.post(new Runnable() { // from class: com.baidu.tieba.sgb
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
                inst2.postDelayed(new Runnable() { // from class: com.baidu.tieba.qgb
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

        @Override // com.baidu.tieba.zfb
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
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<vgb>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mWritePageState$2
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
            public final vgb invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new vgb(this.this$0);
                }
                return (vgb) invokeV.objValue;
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
                TbWebView v3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (TbWebView) invokeV.objValue;
                }
                v3 = this.this$0.v3();
                return v3;
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
                EditorTools s3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EditorTools) invokeV.objValue;
                }
                s3 = this.this$0.s3();
                return s3;
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
                    return this.this$0.n3();
                }
                return (WriteDataManager) invokeV.objValue;
            }
        });
        this.q = new ArrayList<>();
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<mkb>(this) { // from class: com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment$mBackgroundSwitchController$2
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
            public final mkb invoke() {
                InterceptResult invokeV;
                EditorTools h3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TbPageContext<BaseFragmentActivity> pageContext = this.this$0.getPageContext();
                    h3 = this.this$0.h3();
                    return new mkb(pageContext, h3);
                }
                return (mkb) invokeV.objValue;
            }
        });
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (h3().D()) {
                h3().y();
                return;
            }
            k3().l().b();
            if (!k3().g().e(k3().e(), j3().b())) {
                e3(this, 0, 1, null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            if (!k3().i()) {
                u3();
            }
            if (isAdded()) {
                nj6.a().d(i3(), CommonTbJsBridge.RE_SHOW, null);
                i3().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
            y3();
            leb.a(i3());
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && isAdded() && !k3().i()) {
            k3().x(true);
            t3(this.p, i3(), h3());
            c3(h3());
            h3().F(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void A3(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null) {
            j3().l(intent);
        }
    }

    public final void B3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.o = z;
        }
    }

    public final void C3(tj6 tj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tj6Var) == null) {
            this.f = tj6Var;
        }
    }

    @Override // com.baidu.tieba.fe5
    public void U(ee5 ee5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ee5Var) == null) && ee5Var != null) {
            j3().k(ee5Var);
        }
    }

    public final void d3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
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

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            j3().m(outState);
        }
    }

    public static /* synthetic */ void e3(BaseWebWriteFragment baseWebWriteFragment, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 100;
            }
            baseWebWriteFragment.d3(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishActivity");
    }

    public static final void w3(BaseWebWriteFragment this$0, WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{this$0, webView, webResourceRequest, Integer.valueOf(i), charSequence}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this$0.j = true;
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("WebWriteActivity", this$0.m3() + "新发布器OnReceivedError:" + i + WebvttCueParser.CHAR_SPACE + ((Object) charSequence) + WebvttCueParser.CHAR_SPACE + webView + WebvttCueParser.CHAR_SPACE + webResourceRequest);
                this$0.D3();
            }
        }
    }

    public static final Unit x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            xq6.b().c(new kgb(true));
            return Unit.INSTANCE;
        }
        return (Unit) invokeV.objValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g3().g();
            g3().e();
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k3().g().b();
        }
    }

    public final ArrayList<Function0<Unit>> f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final mkb g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (mkb) this.r.getValue();
        }
        return (mkb) invokeV.objValue;
    }

    public final EditorTools h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (EditorTools) this.m.getValue();
        }
        return (EditorTools) invokeV.objValue;
    }

    public final TbWebView i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (TbWebView) this.l.getValue();
        }
        return (TbWebView) invokeV.objValue;
    }

    public final WriteDataManager j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (WriteDataManager) this.n.getValue();
        }
        return (WriteDataManager) invokeV.objValue;
    }

    public final vgb k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (vgb) this.e.getValue();
        }
        return (vgb) invokeV.objValue;
    }

    public final tj6 l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return (tj6) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e6f);
            } else {
                l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            g3().f();
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && k3().q()) {
            nj6.a().i(i3(), "writePageNa.handlePost", new JSONObject());
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            g3().f();
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || i3() == null) {
            return;
        }
        i3().setVisibility(8);
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

    @Override // com.baidu.tieba.wt4
    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            if (k3().q() && !k3().j()) {
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (k3().i()) {
                leb.b(i3());
                if (!this.k) {
                    i3().q();
                }
                i3().onDestroy();
                j3().j();
            }
            super.onDestroyView();
        }
    }

    public final EditorTools s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
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

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.h == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
            }
            if (i3() != null && !this.i && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
                this.i = true;
                FrameLayout frameLayout = this.h;
                FrameLayout frameLayout2 = null;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadStateContainer");
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                i3().setVisibility(8);
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
                i3().loadUrl(this.a);
            }
        }
    }

    public final void y3() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            int F = k3().F();
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
            if (Intrinsics.areEqual("main_tab", j3().b().getFrom())) {
                i2 = 0;
            } else if (Intrinsics.areEqual("frs", j3().b().getFrom())) {
                i2 = 1;
            }
            new StatisticItem("c14823").addParam("obj_source", i).addParam("obj_locate", i2).addParam("obj_type", 1).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && this.g != null) {
            super.onChangeSkinType(i);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            ViewGroup viewGroup = this.g;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            fq5.a(pageContext, viewGroup);
            ViewGroup viewGroup3 = this.g;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup3;
            }
            EMManager.from(viewGroup2).setBackGroundColor(R.color.CAM_X0201);
            if (k3().i()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
                Intrinsics.checkNotNullExpressionValue(currentSkinTypeString, "getCurrentSkinTypeString()");
                linkedHashMap.put("skin", currentSkinTypeString);
                nj6.a().d(i3(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                h3().F(TbadkCoreApplication.getInst().getSkinType());
                i3().setWebViewSkinOverly(this.a, R.color.CAM_X0503);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            O2(requireArguments().getString("write_url"));
            this.p = bundle;
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0158, (ViewGroup) null);
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
                    u3();
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

    public final void q3(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i, i2, intent) == null) {
            if (i2 == -1) {
                j3().h(i, intent);
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
                        nj6.a().i(i3(), "writePageNa.vCodeResult", new JSONObject());
                    }
                }
            }
        }
    }

    public final void t3(Bundle bundle, TbWebView tbWebView, EditorTools editorTools) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048610, this, bundle, tbWebView, editorTools) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            j3().f(k3(), bundle, intent);
            WriteDataManager j3 = j3();
            vgb k3 = k3();
            TbWebView i3 = i3();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            j3.n(k3, i3, editorTools, pageContext);
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_draft_fid_" + m3()), null);
            if (TextUtils.isEmpty(j3().b().getForumId()) && !TextUtils.isEmpty(string)) {
                j3().b().setForumId(string);
            }
            k3().g().c();
            j3().g(bundle, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                h3().y();
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (z) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
            } else {
                i = 0;
            }
            hashMap.put("height", Integer.valueOf(i));
            hashMap.put("animationDuration", Float.valueOf(1.0f));
            nj6.a().d(i3(), "keyboardHeightChange", hashMap);
        }
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.baidu.tieba.browser.TbWebView] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.baidu.tieba.browser.TbWebView] */
    public final TbWebView v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            WriteWebViewCacheManager b = WriteWebViewCacheManager.c.b();
            String mUrl = this.a;
            Intrinsics.checkNotNullExpressionValue(mUrl, "mUrl");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ?? e = b.e(mUrl, requireContext);
            objectRef.element = e;
            if (e == 0) {
                xdb.a aVar = xdb.a;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                ?? a2 = aVar.a(requireContext2);
                objectRef.element = a2;
                ((TbWebView) a2).loadUrl(this.a);
            }
            k3().D(new a(objectRef, this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.g;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.addView((View) objectRef.element, layoutParams);
            ((TbWebView) objectRef.element).setNeedDisAllowParentInterceptTouchEvent(false);
            ((TbWebView) objectRef.element).setOnReceivedErrorListener(new vj6() { // from class: com.baidu.tieba.rgb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vj6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        BaseWebWriteFragment.w3(BaseWebWriteFragment.this, webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            ((TbWebView) objectRef.element).setInvalidPageCallback(new ig6() { // from class: com.baidu.tieba.tgb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ig6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? BaseWebWriteFragment.x3() : invokeV2.objValue;
                }
            });
            k3().n().g();
            return (TbWebView) objectRef.element;
        }
        return (TbWebView) invokeV.objValue;
    }
}

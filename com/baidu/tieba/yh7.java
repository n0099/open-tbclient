package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.hybrid.biz.AcitvityHeadJumpBiz;
import com.baidu.tieba.forum.hybrid.biz.AdVideoLocationBiz;
import com.baidu.tieba.forum.hybrid.biz.BusinessPromotBiz;
import com.baidu.tieba.forum.hybrid.biz.ChatRoomSocketBiz;
import com.baidu.tieba.forum.hybrid.biz.FrsFollowAndSignBiz;
import com.baidu.tieba.forum.hybrid.biz.H5HeightStateBiz;
import com.baidu.tieba.forum.hybrid.biz.SharePageBiz;
import com.baidu.tieba.forum.hybrid.biz.ShowBubbleStateBiz;
import com.baidu.tieba.forum.hybrid.manager.InteractLayer;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.ForumInfo;
/* loaded from: classes9.dex */
public final class yh7 extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final String c;
    public String d;
    public String e;
    public BottomWebView f;
    public FrameLayout g;
    public final InteractLayer h;

    public yh7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.c = TbSingleton.getFRSWebViewHost();
        this.d = "";
        this.e = this.c + "mo/q/hybrid-main-frs/mainPage?needNotify=1&customfullscreen=1&nonavigationbar=1";
        this.h = new InteractLayer();
    }

    public static final void s(yh7 this$0, pi7 pi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, pi7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (pi7Var != null) {
                PrintStream printStream = System.out;
                printStream.println("通知H5渲染数据 -> " + System.currentTimeMillis());
                this$0.h.e(pi7Var);
                oj6 a = rj6.a();
                BottomWebView bottomWebView = this$0.f;
                if (bottomWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView = null;
                }
                a.i(bottomWebView, "frsPageNa.frsPageRes", new JSONObject());
                ci7.l(this$0.b).q();
            }
        }
    }

    public static final Object u(yh7 this$0) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, this$0)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.d;
        }
        return invokeL.objValue;
    }

    public static final Object v(MutableLiveData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            pi7 pi7Var = (pi7) data.getValue();
            if (pi7Var != null) {
                return gj7.a(pi7Var);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static final Object x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i == -1) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return invokeI.objValue;
    }

    public static final Object w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Integer.valueOf(jo7.a());
        }
        return invokeV.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            bottomWebView.loadUrl(this.e);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.l();
            this.h.d();
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            bottomWebView.onDestroy();
        }
    }

    @Override // com.baidu.tieba.xh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.n();
            oj6 a = rj6.a();
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            a.d(bottomWebView, CommonTbJsBridge.RE_SHOW, null);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.gh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        yh7.s(yh7.this, (pi7) obj);
                    }
                }
            });
            t();
        }
    }

    public static final Object y(MutableLiveData data, yh7 this$0) {
        InterceptResult invokeLL;
        BusinessPromot businessPromot;
        int i;
        ForumInfo d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, data, this$0)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            zua zuaVar = new zua();
            pi7 pi7Var = (pi7) data.getValue();
            Long l = null;
            if (pi7Var != null) {
                businessPromot = pi7Var.b();
            } else {
                businessPromot = null;
            }
            zuaVar.t(businessPromot);
            if (!ci7.b(this$0.b).C() && !ci7.b(this$0.b).R0()) {
                pi7 pi7Var2 = (pi7) data.getValue();
                if (pi7Var2 != null && (d = pi7Var2.d()) != null) {
                    l = d.id;
                }
                if (!gk7.e(zuaVar, String.valueOf(l))) {
                    i = 0;
                    return Integer.valueOf(i);
                }
            }
            i = 1;
            return Integer.valueOf(i);
        }
        return invokeLL.objValue;
    }

    public static final boolean z(yh7 this$0, WebView webView, String url) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, this$0, webView, url)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> a = ko7.a(this$0.b);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (urlManager.dealOneLinkWithOutJumpWebView(a, new String[]{url}) != 3) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof BaseFragmentActivity) {
                InteractLayer interactLayer = this.h;
                TbPageContext<BaseFragmentActivity> pageContext = ((BaseFragmentActivity) fragmentActivity).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "activity.pageContext");
                BottomWebView bottomWebView = this.f;
                BottomWebView bottomWebView2 = null;
                if (bottomWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView = null;
                }
                interactLayer.f(new H5HeightStateBiz(pageContext, bottomWebView));
                InteractLayer interactLayer2 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext2 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext2, "activity.pageContext");
                BottomWebView bottomWebView3 = this.f;
                if (bottomWebView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView3 = null;
                }
                interactLayer2.f(new AdVideoLocationBiz(pageContext2, bottomWebView3));
                InteractLayer interactLayer3 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext3 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext3, "activity.pageContext");
                BottomWebView bottomWebView4 = this.f;
                if (bottomWebView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView4 = null;
                }
                interactLayer3.f(new AcitvityHeadJumpBiz(pageContext3, bottomWebView4));
                InteractLayer interactLayer4 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext4 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext4, "activity.pageContext");
                BottomWebView bottomWebView5 = this.f;
                if (bottomWebView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView5 = null;
                }
                interactLayer4.f(new ShowBubbleStateBiz(pageContext4, bottomWebView5));
                InteractLayer interactLayer5 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext5 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext5, "activity.pageContext");
                BottomWebView bottomWebView6 = this.f;
                if (bottomWebView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView6 = null;
                }
                interactLayer5.f(new ChatRoomSocketBiz(pageContext5, bottomWebView6));
                InteractLayer interactLayer6 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext6 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext6, "activity.pageContext");
                BottomWebView bottomWebView7 = this.f;
                if (bottomWebView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView7 = null;
                }
                interactLayer6.f(new BusinessPromotBiz(pageContext6, bottomWebView7));
                InteractLayer interactLayer7 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext7 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext7, "activity.pageContext");
                BottomWebView bottomWebView8 = this.f;
                if (bottomWebView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView8 = null;
                }
                interactLayer7.f(new SharePageBiz(pageContext7, bottomWebView8));
                InteractLayer interactLayer8 = this.h;
                TbPageContext<BaseFragmentActivity> pageContext8 = ((BaseFragmentActivity) this.b).getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext8, "activity.pageContext");
                BottomWebView bottomWebView9 = this.f;
                if (bottomWebView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                } else {
                    bottomWebView2 = bottomWebView9;
                }
                interactLayer8.f(new FrsFollowAndSignBiz(pageContext8, bottomWebView2));
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void g(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            this.h.c(i, intent);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            BottomWebView bottomWebView = binding.d;
            Intrinsics.checkNotNullExpressionValue(bottomWebView, "binding.bottomWeb");
            this.f = bottomWebView;
            FrameLayout frameLayout = binding.q;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.rootContainer");
            this.g = frameLayout;
            BottomWebView bottomWebView2 = this.f;
            BottomWebView bottomWebView3 = null;
            if (bottomWebView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView2 = null;
            }
            boolean z2 = true;
            bottomWebView2.setNestedScrollingEnabled(true);
            BottomWebView bottomWebView4 = this.f;
            if (bottomWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView4 = null;
            }
            bottomWebView4.setScrollBarEnabled(1, false);
            BottomWebView bottomWebView5 = this.f;
            if (bottomWebView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView5 = null;
            }
            bottomWebView5.setInterceptParentCls(SwipeBackLayout.class);
            q();
            A();
            Bundle extras = this.b.getIntent().getExtras();
            if (extras == null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
            } else {
                bundle = extras;
            }
            String string = bundle.getString("name");
            if (string == null) {
                string = "";
            }
            this.d = string;
            Uri uri = (Uri) bundle.getParcelable(IntentConfig.KEY_URI);
            if (uri == null || (str = uri.getQueryParameter("name")) == null) {
                if (uri != null) {
                    str = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                } else {
                    str = null;
                }
            }
            if (this.d.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (str != null && str.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    this.d = str.toString();
                }
            }
            this.e += "&forumName=" + this.d;
            BottomWebView bottomWebView6 = this.f;
            if (bottomWebView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView6 = null;
            }
            bottomWebView6.loadUrl(this.e);
            BottomWebView bottomWebView7 = this.f;
            if (bottomWebView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
            } else {
                bottomWebView3 = bottomWebView7;
            }
            bottomWebView3.setOnLoadUrlListener(new wj6() { // from class: com.baidu.tieba.ah7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.wj6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str2)) == null) ? yh7.z(yh7.this, webView, str2) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void p(String eventName, JSONObject params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eventName, params) == null) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            oj6 a = rj6.a();
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            a.i(bottomWebView, eventName, params);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            final MutableLiveData<pi7> a = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a();
            BottomWebView bottomWebView = this.f;
            BottomWebView bottomWebView2 = null;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            bottomWebView.I(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, new mg6() { // from class: com.baidu.tieba.wg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? yh7.u(yh7.this) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView3 = this.f;
            if (bottomWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView3 = null;
            }
            bottomWebView3.I("frsPageRes", new mg6() { // from class: com.baidu.tieba.qg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? yh7.v(MutableLiveData.this) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView4 = this.f;
            if (bottomWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView4 = null;
            }
            bottomWebView4.I("networkStatus", new mg6() { // from class: com.baidu.tieba.ig7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? yh7.w() : invokeV.objValue;
                }
            });
            final int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            BottomWebView bottomWebView5 = this.f;
            if (bottomWebView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView5 = null;
            }
            bottomWebView5.I("videoAutoPlay", new mg6() { // from class: com.baidu.tieba.sh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? yh7.x(autoPlaySwitch) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView6 = this.f;
            if (bottomWebView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView6 = null;
            }
            bottomWebView6.I("bannerPrompt", new mg6() { // from class: com.baidu.tieba.mh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? yh7.y(MutableLiveData.this, this) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView7 = this.f;
            if (bottomWebView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
            } else {
                bottomWebView2 = bottomWebView7;
            }
            bottomWebView2.J("namoaixud", TbSingleton.getInstance().getWalletSignLink());
        }
    }
}

package com.baidu.tieba.write.webwrite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.write.NewWritePageStateEvent;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.an6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.d2b;
import com.baidu.tieba.e2b;
import com.baidu.tieba.g75;
import com.baidu.tieba.gu6;
import com.baidu.tieba.hu6;
import com.baidu.tieba.ju6;
import com.baidu.tieba.ku6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rq6;
import com.baidu.tieba.t55;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.write.webwrite.WebWriteActivity;
import com.baidu.tieba.write.webwrite.fragment.ArticleWebWriteFragment;
import com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment;
import com.baidu.tieba.write.webwrite.fragment.HelpWebWriteFragment;
import com.baidu.tieba.write.webwrite.fragment.NormalWebWriteFragment;
import com.baidu.tieba.write.webwrite.fragment.TabPagerAdapter;
import com.baidu.tieba.z1b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002efB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u000209J\b\u0010:\u001a\u000207H\u0002J\b\u0010;\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u000207H\u0016J\b\u0010B\u001a\u00020\fH\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u000203H\u0016J\b\u0010H\u001a\u000207H\u0002J\b\u0010I\u001a\u000207H\u0002J\"\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u000207H\u0016J\u0010\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020LH\u0014J\u0012\u0010S\u001a\u0002072\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J\b\u0010V\u001a\u000207H\u0014J\u0010\u0010W\u001a\u0002072\u0006\u0010X\u001a\u00020\u0006H\u0014J\u0012\u0010Y\u001a\u0002072\b\u0010Z\u001a\u0004\u0018\u00010OH\u0014J\u001c\u0010[\u001a\u0002072\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010_\u001a\u000207H\u0014J\b\u0010`\u001a\u000207H\u0014J\u0010\u0010a\u001a\u0002072\u0006\u0010b\u001a\u00020UH\u0014J\b\u0010c\u001a\u000207H\u0014J\b\u0010d\u001a\u000207H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0006\u0012\u0002\b\u000305X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/baidu/tieba/write/webwrite/WebWriteActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tbadk/core/voice/VoiceManager$IVoiceActivity;", "Lcom/baidu/tieba/browser/listener/OnPageFinishedListener;", "()V", "canBackPressed", "", "fragmentList", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/write/webwrite/fragment/TabPagerAdapter$FragmentItem;", "Lkotlin/collections/ArrayList;", "lastTab", "", "mErrorContainer", "Landroid/widget/FrameLayout;", "getMErrorContainer", "()Landroid/widget/FrameLayout;", "mErrorContainer$delegate", "Lkotlin/Lazy;", "mFrom", "mGestureDetector", "Landroid/view/GestureDetector;", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getMNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "mNavigationBar$delegate", "mNavigationBarBackBtn", "Landroid/widget/ImageView;", "mNavigationBarRightBtn", "Landroid/widget/RelativeLayout;", "mNavigationBarRightBtnBg", "Landroid/view/View;", "mRootView", "getMRootView", "()Landroid/view/View;", "mRootView$delegate", "mTabLayout", "Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip;", "getMTabLayout", "()Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip;", "mTabLayout$delegate", "mTargetTab", "mViewPager", "Lcom/baidu/tbadk/core/view/viewpager/BdBaseViewPager;", "getMViewPager", "()Lcom/baidu/tbadk/core/view/viewpager/BdBaseViewPager;", "mViewPager$delegate", "mViewPagerAdapter", "Lcom/baidu/tieba/write/webwrite/fragment/TabPagerAdapter;", "mVoiceManager", "Lcom/baidu/tbadk/core/voice/VoiceManager;", "topToastEventListener", "Lcom/baidu/tbadk/mutiprocess/ResponsedEventListener;", "chooseSelectWriteMode", "", "startOffset", "", "clickPublishBtn", "closeAnimation", "dispatchTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "enablePublishBtn", "enable", "enterExitAnimation", "getCurrentPageKey", "getRealView", "Lcom/baidu/tbadk/core/voice/VoiceManager$IPlayView;", "m", "Lcom/baidu/tbadk/core/data/VoiceData$VoiceModel;", "getVoiceManager", "initTabLayout", "initViewPager", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyboardVisibilityChanged", "isVisible", "onNewIntent", "intent", "onPageFinished", "webView", "Landroid/webkit/WebView;", "url", MissionEvent.MESSAGE_PAUSE, "onResume", "onSaveInstanceState", "outState", "onStart", MissionEvent.MESSAGE_STOP, "Companion", "GestureListener", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WebWriteActivity extends BaseFragmentActivity implements VoiceManager.j, an6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ArrayList<TabPagerAdapter.a> b;
    public GestureDetector c;
    public VoiceManager d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public ImageView h;
    public RelativeLayout i;
    public View j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public TabPagerAdapter n;
    public String o;
    public String p;
    public final ResponsedEventListener<?> q;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, m)) == null) {
            Intrinsics.checkNotNullParameter(m, "m");
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(WebWriteActivity webWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webWriteActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                Intrinsics.checkNotNullParameter(e2, "e2");
                BdUtilHelper.hideSoftKeyPad(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(e1, e2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends ku6<e2b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebWriteActivity webWriteActivity, Class<e2b> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = webWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ku6
        public void onEvent(e2b event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                RelativeLayout relativeLayout = this.b.i;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout = null;
                }
                relativeLayout.setClickable(event.a());
                this.b.B1(event.a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends ku6<d2b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebWriteActivity webWriteActivity, Class<d2b> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = webWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ku6
        public void onEvent(d2b event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.b.y1(350L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WebWriteActivity webWriteActivity) {
            super(2921622);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (!Intrinsics.areEqual(msg.getData(), Boolean.TRUE)) {
                    return;
                }
                TabPagerAdapter tabPagerAdapter = this.a.n;
                if (tabPagerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                    tabPagerAdapter = null;
                }
                BaseWebWriteFragment b = tabPagerAdapter.b();
                if (b != null) {
                    b.r2();
                }
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends ku6<z1b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WebWriteActivity webWriteActivity, Class<z1b> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = webWriteActivity;
        }

        public static final void b(WebWriteActivity this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.finish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ku6
        public void onEvent(z1b event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.a()) {
                    this.b.C1().setVisibility(0);
                    WebWriteActivity webWriteActivity = this.b;
                    FrameLayout C1 = webWriteActivity.C1();
                    String string = this.b.getString(R.string.hanpen_error);
                    String string2 = this.b.getString(R.string.write_save_draft_leave);
                    final WebWriteActivity webWriteActivity2 = this.b;
                    webWriteActivity.showNetRefreshView(C1, string, null, string2, true, new View.OnClickListener() { // from class: com.baidu.tieba.f1b
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                WebWriteActivity.e.b(WebWriteActivity.this, view2);
                            }
                        }
                    });
                    return;
                }
                WebWriteActivity webWriteActivity3 = this.b;
                webWriteActivity3.hideNetRefreshView(webWriteActivity3.C1());
                this.b.C1().setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebWriteActivity a;

        public f(WebWriteActivity webWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.eq5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, action)) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                new BdTopToast(this.a.getPageContext().getPageActivity()).setIcon(action.isSuccess()).setContent(action.getContent()).show((ViewGroup) this.a.E1());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(26431547, "Lcom/baidu/tieba/write/webwrite/WebWriteActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26431547, "Lcom/baidu/tieba/write/webwrite/WebWriteActivity;");
                return;
            }
        }
        Intrinsics.checkNotNullExpressionValue(TbSingleton.getWritePageHost(), "getWritePageHost()");
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter.b();
            if (b2 != null) {
                b2.F2();
            }
        }
    }

    public final FrameLayout C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object value = this.m.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mErrorContainer>(...)");
            return (FrameLayout) value;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final NavigationBar D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object value = this.g.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mNavigationBar>(...)");
            return (NavigationBar) value;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final View E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object value = this.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mRootView>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    public final NewPagerSlidingTabBaseStrip F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (NewPagerSlidingTabBaseStrip) this.k.getValue();
        }
        return (NewPagerSlidingTabBaseStrip) invokeV.objValue;
    }

    public final BdBaseViewPager G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object value = this.l.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mViewPager>(...)");
            return (BdBaseViewPager) value;
        }
        return (BdBaseViewPager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == null) {
                this.d = new VoiceManager();
            }
            VoiceManager voiceManager = this.d;
            Intrinsics.checkNotNull(voiceManager);
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            H0().onPause();
            BdUtilHelper.hideSoftKeyPad(this, getCurrentFocus());
            YunDialogManager.onHidden(t55.o);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            H0().onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
            H0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStop();
            H0().onStop(getPageContext());
        }
    }

    public WebWriteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.e = true;
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.write.webwrite.WebWriteActivity$mRootView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebWriteActivity this$0;

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
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.obfuscated_res_0x7f091fd6);
                }
                return (View) invokeV.objValue;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<NavigationBar>(this) { // from class: com.baidu.tieba.write.webwrite.WebWriteActivity$mNavigationBar$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebWriteActivity this$0;

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
            public final NavigationBar invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (NavigationBar) this.this$0.findViewById(R.id.view_navigation_bar);
                }
                return (NavigationBar) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<NewPagerSlidingTabBaseStrip>(this) { // from class: com.baidu.tieba.write.webwrite.WebWriteActivity$mTabLayout$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebWriteActivity this$0;

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
            public final NewPagerSlidingTabBaseStrip invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new NewPagerSlidingTabBaseStrip(this.this$0);
                }
                return (NewPagerSlidingTabBaseStrip) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<BdBaseViewPager>(this) { // from class: com.baidu.tieba.write.webwrite.WebWriteActivity$mViewPager$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebWriteActivity this$0;

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
            public final BdBaseViewPager invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (BdBaseViewPager) this.this$0.findViewById(R.id.obfuscated_res_0x7f092ad0);
                }
                return (BdBaseViewPager) invokeV.objValue;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(this) { // from class: com.baidu.tieba.write.webwrite.WebWriteActivity$mErrorContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebWriteActivity this$0;

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
            public final FrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (FrameLayout) this.this$0.findViewById(R.id.obfuscated_res_0x7f090a45);
                }
                return (FrameLayout) invokeV.objValue;
            }
        });
        this.q = new f(this);
    }

    public static final void I1(WebWriteActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.A1();
        }
    }

    public static final void J1(WebWriteActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onBackPressed();
        }
    }

    public static final boolean L1(String lastTab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lastTab)) == null) {
            Intrinsics.checkNotNullParameter(lastTab, "$lastTab");
            WriteWebViewCacheManager.c.b().j(lastTab);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void M1(WebWriteActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e = true;
        }
    }

    public final void B1(boolean z) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtnBg");
                view2 = null;
            }
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.5f;
            }
            view2.setAlpha(f2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ev)) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            GestureDetector gestureDetector = this.c;
            Intrinsics.checkNotNull(gestureDetector);
            if (gestureDetector.onTouchEvent(ev)) {
                ev.setAction(3);
            }
            return super.dispatchTouchEvent(ev);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter.b();
            if (b2 != null) {
                b2.onKeyboardVisibilityChanged(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
            super.onNewIntent(intent);
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter.b();
            if (b2 != null) {
                b2.Q2(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            H0().onSaveInstanceState(this);
            super.onSaveInstanceState(outState);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            F1().setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            F1().setRectPaintColor(R.color.CAM_X0302);
            F1().E(BdUtilHelper.getDimens(this, R.dimen.T_X05), BdUtilHelper.getDimens(this, R.dimen.T_X04), BdUtilHelper.getDimens(this, R.dimen.tbds10), BdUtilHelper.getDimens(this, R.dimen.tbds42), true);
            F1().setmIndicatorWidth(BdUtilHelper.getDimens(this, R.dimen.tbds42));
            F1().setIndicatorOvershot(BdUtilHelper.getDimens(this, R.dimen.tbds8));
            F1().setIndicatorRadius(BdUtilHelper.getDimens(this, R.dimen.tbds8));
            F1().setIndicatorMarginBottom(BdUtilHelper.getDimens(this, R.dimen.tbds0));
            F1().setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(this, R.dimen.tbds100)));
            F1().setTabPadding(BdUtilHelper.getDimens(this, R.dimen.tbds36), 0, BdUtilHelper.getDimens(this, R.dimen.tbds36), 0);
            F1().setViewPager(G1());
            D1().setIsClose(true);
            D1().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g1b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WebWriteActivity.J1(WebWriteActivity.this, view2);
                    }
                }
            });
            ImageView backImageView = D1().getBackImageView();
            Intrinsics.checkNotNullExpressionValue(backImageView, "mNavigationBar.backImageView");
            this.h = backImageView;
            if (backImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBackBtn");
                backImageView = null;
            }
            WebPManager.setPureDrawable(backImageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0105, null);
            ImageView imageView = this.h;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBackBtn");
                imageView = null;
            }
            int dimens = BdUtilHelper.getDimens(this, R.dimen.M_W_X001);
            imageView.setPadding(dimens, dimens, dimens, dimens);
            ImageView imageView2 = this.h;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBackBtn");
                imageView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = BdUtilHelper.getDimens(this, R.dimen.M_W_X001);
                imageView2.setLayoutParams(marginLayoutParams);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                relativeLayout.setGravity(17);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(BdUtilHelper.getDimens(this, R.dimen.tbds192), BdUtilHelper.getDimens(this, R.dimen.tbds75));
                marginLayoutParams2.rightMargin = BdUtilHelper.getDimens(this, R.dimen.M_W_X007);
                relativeLayout.setLayoutParams(marginLayoutParams2);
                this.i = relativeLayout;
                View view2 = new View(this);
                EMManager.from(view2).setCorner(R.string.J_X07).setGradientColor(new int[]{R.color.CAM_X0302, R.color.CAM_X0341}, Direction.LEFT);
                RelativeLayout relativeLayout2 = this.i;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout2 = null;
                }
                relativeLayout2.addView(view2, new ViewGroup.LayoutParams(-1, -1));
                this.j = view2;
                ImageView imageView3 = new ImageView(this);
                imageView3.setImageResource(R.drawable.obfuscated_res_0x7f080bc5);
                imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                RelativeLayout relativeLayout3 = this.i;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout3 = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this, R.dimen.tbds151), BdUtilHelper.getDimens(this, R.dimen.tbds75));
                layoutParams2.addRule(13);
                Unit unit = Unit.INSTANCE;
                relativeLayout3.addView(imageView3, layoutParams2);
                NavigationBar D1 = D1();
                NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
                RelativeLayout relativeLayout4 = this.i;
                if (relativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout4 = null;
                }
                D1.addCustomView(controlAlign, relativeLayout4, new View.OnClickListener() { // from class: com.baidu.tieba.d1b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            WebWriteActivity.I1(WebWriteActivity.this, view3);
                        }
                    }
                });
                RelativeLayout relativeLayout5 = this.i;
                if (relativeLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout5 = null;
                }
                relativeLayout5.setVisibility(4);
                RelativeLayout relativeLayout6 = this.i;
                if (relativeLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                    relativeLayout6 = null;
                }
                relativeLayout6.setClickable(false);
                B1(false);
                D1().hideBottomLine();
                D1().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, F1(), (View.OnClickListener) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public final void K1() {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b = new ArrayList<>();
            TabPagerAdapter.a aVar = new TabPagerAdapter.a();
            ArticleWebWriteFragment articleWebWriteFragment = new ArticleWebWriteFragment();
            Bundle bundle = new Bundle();
            bundle.putString("write_url", WriteWebViewCacheManager.c.a());
            articleWebWriteFragment.setArguments(bundle);
            aVar.c(articleWebWriteFragment);
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02dc);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.article)");
            aVar.d(string);
            ArrayList<TabPagerAdapter.a> arrayList = this.b;
            ArrayList<TabPagerAdapter.a> arrayList2 = null;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
                arrayList = null;
            }
            arrayList.add(aVar);
            TabPagerAdapter.a aVar2 = new TabPagerAdapter.a();
            NormalWebWriteFragment normalWebWriteFragment = new NormalWebWriteFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("write_url", WriteWebViewCacheManager.c.c());
            normalWebWriteFragment.setArguments(bundle2);
            normalWebWriteFragment.S2(this);
            aVar2.c(normalWebWriteFragment);
            String string2 = TbadkCoreApplication.getInst().getString(R.string.text_post);
            Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.string.text_post)");
            aVar2.d(string2);
            ArrayList<TabPagerAdapter.a> arrayList3 = this.b;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
                arrayList3 = null;
            }
            arrayList3.add(aVar2);
            TabPagerAdapter.a aVar3 = new TabPagerAdapter.a();
            HelpWebWriteFragment helpWebWriteFragment = new HelpWebWriteFragment();
            helpWebWriteFragment.e2(WriteWebViewCacheManager.c.d());
            Bundle bundle3 = new Bundle();
            bundle3.putString("write_url", WriteWebViewCacheManager.c.d());
            helpWebWriteFragment.setArguments(bundle3);
            aVar3.c(helpWebWriteFragment);
            String string3 = TbadkCoreApplication.getInst().getString(R.string.send_help);
            Intrinsics.checkNotNullExpressionValue(string3, "getInst().getString(R.string.send_help)");
            aVar3.d(string3);
            ArrayList<TabPagerAdapter.a> arrayList4 = this.b;
            if (arrayList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
                arrayList4 = null;
            }
            arrayList4.add(aVar3);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ArrayList<TabPagerAdapter.a> arrayList5 = this.b;
            if (arrayList5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
                arrayList5 = null;
            }
            this.n = new TabPagerAdapter(supportFragmentManager, arrayList5);
            BdBaseViewPager G1 = G1();
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            G1.setAdapter(tabPagerAdapter);
            BdBaseViewPager G12 = G1();
            ArrayList<TabPagerAdapter.a> arrayList6 = this.b;
            if (arrayList6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
                arrayList6 = null;
            }
            G12.setOffscreenPageLimit(arrayList6.size());
            String str = this.p;
            if (str == null) {
                str = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_last_select_write_tab"), "");
                Intrinsics.checkNotNullExpressionValue(str, "getInstance()\n          …ST_SELECT_WRITE_TAB), \"\")");
            }
            this.a = str;
            if (Intrinsics.areEqual(str, "article")) {
                i = 0;
            } else if (Intrinsics.areEqual(str, "help")) {
                i = 2;
            } else {
                i = 1;
            }
            G1().setCurrentItem(i, false);
            ArrayList<TabPagerAdapter.a> arrayList7 = this.b;
            if (arrayList7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentList");
            } else {
                arrayList2 = arrayList7;
            }
            Iterator<TabPagerAdapter.a> it = arrayList2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                BaseWebWriteFragment a2 = it.next().a();
                if (i != i2) {
                    z = true;
                } else {
                    z = false;
                }
                a2.R2(z);
                i2 = i3;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter.b();
            if (b2 != null) {
                b2.G2(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || !this.e) {
            return;
        }
        TabPagerAdapter tabPagerAdapter = this.n;
        TabPagerAdapter tabPagerAdapter2 = null;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
            tabPagerAdapter = null;
        }
        if (tabPagerAdapter.b() != null) {
            TabPagerAdapter tabPagerAdapter3 = this.n;
            if (tabPagerAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
            } else {
                tabPagerAdapter2 = tabPagerAdapter3;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter2.b();
            Intrinsics.checkNotNull(b2);
            b2.E2();
            return;
        }
        setResult(100);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            D1().onChangeSkinType(getPageContext(), i);
            F1().H();
            ImageView imageView = this.h;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBackBtn");
                imageView = null;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0105, null);
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            int count = tabPagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                TabPagerAdapter tabPagerAdapter2 = this.n;
                if (tabPagerAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                    tabPagerAdapter2 = null;
                }
                Fragment item = tabPagerAdapter2.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).onChangeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0a36);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.c = new GestureDetector(getPageContext().getPageActivity(), new a(this));
            H0().onCreate(getPageContext());
            K1();
            H1();
            ju6 b2 = hu6.b();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            b2.a(new gu6(pageContext, e2b.class), new b(this, e2b.class));
            ju6 b3 = hu6.b();
            TbPageContext<BaseFragmentActivity> pageContext2 = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext2, "pageContext");
            b3.a(new gu6(pageContext2, d2b.class), new c(this, d2b.class));
            String str2 = "";
            if (bundle != null) {
                str2 = bundle.getString("from", "");
                Intrinsics.checkNotNullExpressionValue(str2, "savedInstanceState.getSt…BaseWriteConfig.FROM, \"\")");
            } else if (getIntent() != null && (stringExtra = getIntent().getStringExtra("from")) != null) {
                str2 = stringExtra;
            }
            this.o = str2;
            if (getIntent() != null) {
                str = getIntent().getStringExtra(WriteActivityConfig.KEY_TARGET_TAB);
            } else {
                str = null;
            }
            this.p = str;
            MutiProcessManager.publishEvent(new NewWritePageStateEvent(true));
            registerResponsedEventListener(TopToastEvent.class, this.q);
            registerListener(new d(this));
            ju6 b4 = hu6.b();
            TbPageContext<BaseFragmentActivity> pageContext3 = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext3, "pageContext");
            b4.a(new gu6(pageContext3, z1b.class), new e(this, z1b.class));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_source", "new_write").param("obj_type", this.a));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            TabPagerAdapter tabPagerAdapter = this.n;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            BaseWebWriteFragment b2 = tabPagerAdapter.b();
            final String str = (b2 == null || (str = b2.C2()) == null) ? "normal" : "normal";
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_last_select_write_tab"), str);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.c1b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? WebWriteActivity.L1(str) : invokeV.booleanValue;
                }
            });
            MutiProcessManager.publishEvent(new NewWritePageStateEvent(false));
            H0().stopPlay();
            H0().onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tieba.an6
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, webView, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("write", "页面加载完成:url=" + str);
            if (this.isResumed) {
                if (g75.a.a("newWritePageGuideDialog") < 1) {
                    this.e = false;
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.e1b
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                WebWriteActivity.M1(WebWriteActivity.this);
                            }
                        }
                    }, 500L);
                }
                JSONObject jSONObject = new JSONObject();
                String str2 = this.o;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFrom");
                    str2 = null;
                }
                rq6.a(jSONObject, "from", str2);
                YunDialogManager.onShow(this, "newWritePageGuideDialog", jSONObject);
                YunDialogManager.onShow(this, t55.o);
            }
        }
    }

    public final void y1(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048604, this, j) == null) && !G1().a()) {
            TbLog hybridLog = HybridLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("锁定当前Tab：");
            TabPagerAdapter tabPagerAdapter = this.n;
            RelativeLayout relativeLayout = null;
            if (tabPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
                tabPagerAdapter = null;
            }
            sb.append(tabPagerAdapter.b());
            hybridLog.i("WebWriteActivity", sb.toString());
            G1().setmDisallowSlip(true);
            F1().y(j);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setStartOffset(j);
            alphaAnimation.setFillAfter(true);
            RelativeLayout relativeLayout2 = this.i;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(0);
            RelativeLayout relativeLayout3 = this.i;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarRightBtn");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.startAnimation(alphaAnimation);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_source", "new_write_select_tab").param("obj_type", j));
        }
    }
}

package com.baidu.tieba.immessagecenter.slice;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility;
import com.baidu.tieba.tw7;
import com.baidu.tieba.uw7;
import com.baidu.tieba.vw7;
import com.baidu.tieba.ww7;
import com.baidu.tieba.xw7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0000H\u0016J1\u0010/\u001a\u00020,2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010-\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b0J\u0010\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020\u0000H\u0016J#\u00103\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u00010 2\b\b\u0001\u00105\u001a\u00020\u000fH\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0000H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u0010.\u001a\u00020\u0000H\u0016J\u0011\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0096\u0001J\u0011\u0010>\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0096\u0001J\u0011\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@H\u0096\u0001J\b\u0010A\u001a\u00020,H\u0016J\"\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u000202H\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u000fH\u0016J\b\u0010K\u001a\u00020,H\u0016J$\u0010L\u001a\u0004\u0018\u00010 2\u0006\u0010M\u001a\u00020N2\u0006\u0010-\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010O\u001a\u00020,H\u0016J\b\u0010P\u001a\u00020,H\u0016J\u0018\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020,H\u0016J\u0018\u0010V\u001a\u00020,2\u0006\u0010W\u001a\u00020\u00022\u0006\u0010S\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020,H\u0016J\b\u0010Z\u001a\u00020,H\u0016J\b\u0010[\u001a\u00020,H\u0016J\b\u0010\\\u001a\u00020,H\u0016J+\u0010]\u001a\u00020,2\u0006\u0010C\u001a\u00020\u000f2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020=0_2\u0006\u0010`\u001a\u00020aH\u0016¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020,H\u0016J\u0010\u0010d\u001a\u00020,2\u0006\u0010e\u001a\u00020\u001cH\u0016J\u0010\u0010f\u001a\u00020,2\u0006\u0010g\u001a\u000202H\u0016J\b\u0010h\u001a\u00020,H\u0016J\b\u0010i\u001a\u00020,H\u0016J\u001c\u0010j\u001a\u00020,2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010k\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0000H\u0016J!\u0010l\u001a\u0002H4\"\b\b\u0000\u00104*\u00020 2\b\b\u0001\u00105\u001a\u00020\u000fH\u0016¢\u0006\u0002\u00106J\u0011\u0010m\u001a\u00020,2\u0006\u0010n\u001a\u00020=H\u0096\u0001J\u0010\u0010o\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0000H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006p"}, d2 = {"Lcom/baidu/tieba/immessagecenter/slice/Slice;", "Lcom/baidu/tieba/immessagecenter/slice/ability/LifecycleAbility;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/baidu/tieba/immessagecenter/slice/ability/LogAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/SysEventAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/OpAbility;", "()V", "host", "Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "getHost", "()Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "setHost", "(Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;)V", "lastSkinType", "", "getLastSkinType", "()I", "setLastSkinType", "(I)V", "parent", "getParent", "()Lcom/baidu/tieba/immessagecenter/slice/Slice;", "setParent", "(Lcom/baidu/tieba/immessagecenter/slice/Slice;)V", "parentContainer", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "sliceManager", "Lcom/baidu/tieba/immessagecenter/slice/SliceManager;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewAbility", "Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility$Impl;", "getViewAbility", "()Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility$Impl;", "viewAbility$delegate", "Lkotlin/Lazy;", "addChild", "", "container", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "attach", "attach$imMessageCenter_release", "contains", "", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "getLifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "hideChild", "isShowing", "logD", "log", "", "logE", "throwable", "", "onActivityFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackgroundSwitched", NotificationCompat.WearableExtender.KEY_BACKGROUND, "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", MissionEvent.MESSAGE_PAUSE, "onPostAny", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "onPostCreate", "onPostDestroy", "onPreCreate", "onPreDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onScreenLocked", "locked", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "removeChild", "requireViewById", "setTag", "tag", "showChild", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Slice implements LifecycleAbility, LifecycleOwner, vw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ uw7 a;
    public SliceFragment b;
    public Slice c;
    public ViewGroup d;
    public Bundle e;
    public View f;
    public final tw7 g;
    public int h;

    public void e(String log) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, log) == null) {
            Intrinsics.checkNotNullParameter(log, "log");
            this.a.a(log);
        }
    }

    public Slice() {
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
        this.a = new uw7(null, 1, null);
        LazyKt__LazyJVMKt.lazy(new Function0<ww7>(this) { // from class: com.baidu.tieba.immessagecenter.slice.Slice$viewAbility$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Slice this$0;

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
            public final ww7 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.this$0.d() != null) {
                        View d = this.this$0.d();
                        Intrinsics.checkNotNull(d);
                        return new ww7(d);
                    }
                    throw new IllegalArgumentException("视图为空，不能进行相关操作".toString());
                }
                return (ww7) invokeV.objValue;
            }
        });
        this.g = new tw7(this);
        this.h = -1;
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.f = view2;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            vw7.a.c(this, z);
            this.g.e(z);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || this.h == i) {
            return;
        }
        this.h = i;
        vw7.a.d(this, i);
        this.g.f(i);
    }

    public void p(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            vw7.a.g(this, outState);
            this.g.j(outState);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            vw7.a.h(this, z);
            this.g.k(z);
        }
    }

    public final void z(SliceFragment sliceFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sliceFragment) == null) {
            Intrinsics.checkNotNullParameter(sliceFragment, "<set-?>");
            this.b = sliceFragment;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LifecycleAbility.a.f(this);
            e("onPostDestroy:" + getClass().getSimpleName());
        }
    }

    public final SliceFragment c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SliceFragment sliceFragment = this.b;
            if (sliceFragment != null) {
                return sliceFragment;
            }
            Intrinsics.throwUninitializedPropertyAccessException("host");
            return null;
        }
        return (SliceFragment) invokeV.objValue;
    }

    public final View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            vw7.a.a(this);
            this.g.g();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            e("onDestroyView:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LifecycleAbility.a.h(this);
            e("onPreCreate:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LifecycleAbility.a.b(this);
            e("onCreate:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LifecycleAbility.a.c(this);
            e("onDestroy:" + getClass().getSimpleName());
        }
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void performCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LifecycleAbility.a.performCreate(this);
        }
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void performDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            LifecycleAbility.a.performDestroy(this);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    @CallSuper
    public void I(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, lifecycleOwner, event) == null) {
            LifecycleAbility.a.a(this, lifecycleOwner, event);
        }
    }

    public void a(ViewGroup container, Slice child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, container, child) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(child, "child");
            child.b(c(), this, container, this.e);
            this.g.a(container, child);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void f(LifecycleOwner owner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, owner, event) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(event, "event");
            LifecycleAbility.a.d(this, owner, event);
            this.g.c(event);
        }
    }

    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            vw7.a.e(this, i, event);
            return this.g.h(i, event);
        }
        return invokeIL.booleanValue;
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void performAny(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, lifecycleOwner, event) == null) {
            LifecycleAbility.a.performAny(this, lifecycleOwner, event);
        }
    }

    public void w(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, view2, bundle) == null) {
            e("onViewCreated:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    @CallSuper
    public void x(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, lifecycleOwner, event) == null) {
            LifecycleAbility.a.g(this, lifecycleOwner, event);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void J() {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LifecycleAbility.a.i(this);
            e("onPreDestroy:" + getClass().getSimpleName());
            m();
            View view2 = this.f;
            ViewGroup viewGroup = null;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.f);
            }
        }
    }

    public final void b(SliceFragment host, Slice slice, ViewGroup container, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, host, slice, container, bundle) == null) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(container, "container");
            xw7.a.a();
            z(host);
            this.c = slice;
            this.d = container;
            this.e = bundle;
            if (slice == null) {
                host.getLifecycle().addObserver(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g.b();
        }
        return (LifecycleRegistry) invokeV.objValue;
    }

    public void i(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            vw7.a.b(this, i, i2, intent);
            this.g.d(i, i2, intent);
        }
    }

    public void n(int i, String[] permissions, int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048594, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            vw7.a.f(this, i, permissions, grantResults);
            this.g.i(i, permissions, grantResults);
        }
    }

    public View l(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            e("onCreateView:" + getClass().getSimpleName());
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void s() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LifecycleAbility.a.e(this);
            e("onPostCreate:" + getClass().getSimpleName());
            LayoutInflater layoutInflater = c().getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "host.layoutInflater");
            ViewGroup viewGroup = this.d;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup = null;
            }
            View l = l(layoutInflater, viewGroup, this.e);
            this.f = l;
            ViewGroup viewGroup3 = this.d;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup3 = null;
            }
            if (!Intrinsics.areEqual(l, viewGroup3)) {
                ViewGroup viewGroup4 = this.d;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                } else {
                    viewGroup2 = viewGroup4;
                }
                viewGroup2.addView(this.f);
            }
            w(this.f, this.e);
            Slice slice = this.c;
            if (slice != null && (i = slice.h) != -1 && this.h == -1) {
                k(i);
            }
        }
    }
}

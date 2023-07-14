package com.baidu.tieba.immessagecenter.slice;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.av8;
import com.baidu.tieba.bv8;
import com.baidu.tieba.cv8;
import com.baidu.tieba.dv8;
import com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility;
import com.baidu.tieba.zu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0000H\u0016J1\u00106\u001a\u0002032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00002\u0006\u00104\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0000H\u0016J#\u00109\u001a\u0002H:\"\n\b\u0000\u0010:*\u0004\u0018\u00010'2\b\b\u0001\u0010;\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016J\u0010\u0010@\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0000H\u0016J\u0011\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020CH\u0096\u0001J\u0011\u0010D\u001a\u0002032\u0006\u0010B\u001a\u00020CH\u0096\u0001J\u0011\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020FH\u0096\u0001J\b\u0010G\u001a\u000203H\u0016J\"\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00162\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020\u000fH\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020\u0016H\u0016J\b\u0010Q\u001a\u000203H\u0016J$\u0010R\u001a\u0004\u0018\u00010'2\u0006\u0010S\u001a\u00020T2\u0006\u00104\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010U\u001a\u000203H\u0016J\b\u0010V\u001a\u000203H\u0016J\u0018\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u0002032\u0006\u0010\\\u001a\u00020\u000fH\u0016J\b\u0010]\u001a\u000203H\u0016J\u0018\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020`H\u0016J\b\u0010a\u001a\u000203H\u0016J\b\u0010b\u001a\u000203H\u0016J\b\u0010c\u001a\u000203H\u0016J\b\u0010d\u001a\u000203H\u0016J+\u0010e\u001a\u0002032\u0006\u0010I\u001a\u00020\u00162\f\u0010f\u001a\b\u0012\u0004\u0012\u00020C0g2\u0006\u0010h\u001a\u00020iH\u0016¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u000203H\u0016J\u0010\u0010l\u001a\u0002032\u0006\u0010m\u001a\u00020#H\u0016J\u0010\u0010n\u001a\u0002032\u0006\u0010o\u001a\u00020\u000fH\u0016J\b\u0010p\u001a\u000203H\u0016J\b\u0010q\u001a\u000203H\u0016J\u001c\u0010r\u001a\u0002032\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010s\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016J!\u0010t\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020'2\b\b\u0001\u0010;\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010<J\u0011\u0010u\u001a\u0002032\u0006\u0010v\u001a\u00020CH\u0096\u0001J\u0010\u0010w\u001a\u0002032\u0006\u00105\u001a\u00020\u0000H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u0006x"}, d2 = {"Lcom/baidu/tieba/immessagecenter/slice/Slice;", "Lcom/baidu/tieba/immessagecenter/slice/ability/LifecycleAbility;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/baidu/tieba/immessagecenter/slice/ability/LogAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/SysEventAbility;", "Lcom/baidu/tieba/immessagecenter/slice/ability/OpAbility;", "()V", "host", "Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "getHost", "()Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "setHost", "(Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;)V", "isBackground", "", "()Z", "setBackground", "(Z)V", "isScreenLocked", "setScreenLocked", "lastSkinType", "", "getLastSkinType", "()I", "setLastSkinType", "(I)V", "parent", "getParent", "()Lcom/baidu/tieba/immessagecenter/slice/Slice;", "setParent", "(Lcom/baidu/tieba/immessagecenter/slice/Slice;)V", "parentContainer", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "sliceManager", "Lcom/baidu/tieba/immessagecenter/slice/SliceManager;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewAbility", "Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility$Impl;", "getViewAbility", "()Lcom/baidu/tieba/immessagecenter/slice/ability/ViewAbility$Impl;", "viewAbility$delegate", "Lkotlin/Lazy;", "addChild", "", "container", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "attach", "attach$imMessageCenter_release", "contains", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "getLifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "hideChild", "isShowing", "logD", LocalFilesFilterKt.FILTER_NAME_LOG, "", "logE", "throwable", "", "onActivityFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackgroundSwitched", NotificationCompat.WearableExtender.KEY_BACKGROUND, "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, MissionEvent.MESSAGE_PAUSE, "onPostAny", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "onPostCreate", "onPostDestroy", "onPreCreate", "onPreDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onScreenLocked", "locked", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "removeChild", "requireViewById", "setTag", "tag", "showChild", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class Slice extends LifecycleAbility implements LifecycleOwner, bv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ av8 a;
    public SliceFragment b;
    public Slice c;
    public ViewGroup d;
    public Bundle e;
    public View f;
    public final zu8 g;
    public int h;
    public boolean i;

    public void I(String log) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, log) == null) {
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
        this.a = new av8(null, 1, null);
        LazyKt__LazyJVMKt.lazy(new Function0<cv8>(this) { // from class: com.baidu.tieba.immessagecenter.slice.Slice$viewAbility$2
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
            public final cv8 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.this$0.F() != null) {
                        View F = this.this$0.F();
                        Intrinsics.checkNotNull(F);
                        return new cv8(F);
                    }
                    throw new IllegalArgumentException("视图为空，不能进行相关操作".toString());
                }
                return (cv8) invokeV.objValue;
            }
        });
        this.g = new zu8(this);
        this.h = -1;
    }

    public void A(ViewGroup container, Slice child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, container, child) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(child, "child");
            child.D(E(), this, container, this.e);
            this.g.a(container, child);
        }
    }

    public void U(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            I("onViewCreated:" + getClass().getSimpleName());
        }
    }

    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            bv8.a.e(this, i, event);
            return this.g.h(i, event);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void r(LifecycleOwner owner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, owner, event) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(event, "event");
            super.r(owner, event);
            this.g.c(event);
        }
    }

    public final void D(SliceFragment host, Slice slice, ViewGroup container, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, host, slice, container, bundle) == null) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(container, "container");
            dv8.a.a();
            V(host);
            this.c = slice;
            this.d = container;
            this.e = bundle;
            if (slice == null) {
                host.getLifecycle().addObserver(this);
            }
        }
    }

    public final SliceFragment E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SliceFragment sliceFragment = this.b;
            if (sliceFragment != null) {
                return sliceFragment;
            }
            Intrinsics.throwUninitializedPropertyAccessException("host");
            return null;
        }
        return (SliceFragment) invokeV.objValue;
    }

    public final View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            bv8.a.a(this);
            this.g.g();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            I("onDestroyView:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            I("onDestroy:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            I("onPause:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            I("onResume:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
            I("onStart:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStop();
            I("onStop:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.q();
            I("onCreate:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.t();
            I("onPostDestroy:" + getClass().getSimpleName());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.v();
            I("onPreCreate:" + getClass().getSimpleName());
        }
    }

    public void K(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            bv8.a.b(this, i, i2, intent);
            this.g.d(i, i2, intent);
        }
    }

    public void R(int i, String[] permissions, int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            bv8.a.g(this, i, permissions, grantResults);
            this.g.j(i, permissions, grantResults);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            bv8.a.c(this, z);
            this.g.e(z);
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            bv8.a.f(this, z);
            this.g.i(z);
        }
    }

    public void S(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            bv8.a.h(this, outState);
            this.g.k(outState);
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            bv8.a.i(this, z);
            this.i = z;
            this.g.l(z);
        }
    }

    public final void V(SliceFragment sliceFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sliceFragment) == null) {
            Intrinsics.checkNotNullParameter(sliceFragment, "<set-?>");
            this.b = sliceFragment;
        }
    }

    public final void W(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.f = view2;
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048596, this, i) != null) || this.h == i) {
            return;
        }
        this.h = i;
        bv8.a.d(this, i);
        this.g.f(i);
    }

    public View N(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            I("onCreateView:" + getClass().getSimpleName());
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g.b();
        }
        return (LifecycleRegistry) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void s() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.s();
            I("onPostCreate:" + getClass().getSimpleName());
            LayoutInflater layoutInflater = E().getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "host.layoutInflater");
            ViewGroup viewGroup = this.d;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup = null;
            }
            View N = N(layoutInflater, viewGroup, this.e);
            this.f = N;
            ViewGroup viewGroup3 = this.d;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                viewGroup3 = null;
            }
            if (!Intrinsics.areEqual(N, viewGroup3)) {
                ViewGroup viewGroup4 = this.d;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
                } else {
                    viewGroup2 = viewGroup4;
                }
                viewGroup2.addView(this.f);
            }
            U(this.f, this.e);
            Slice slice = this.c;
            if (slice != null && (i = slice.h) != -1 && this.h == -1) {
                onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void w() {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.w();
            I("onPreDestroy:" + getClass().getSimpleName());
            O();
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
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class vq7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public HashMap<Class, IPlayerContext> d;
    public IVideoPlayerCallback e;
    public List<LivePlayer.OnInfoListener> f;
    public List<LivePlayer.OnProgressChangeListener> g;
    public String h;
    public ViewGroup i;
    public OrientationHelper j;
    public boolean k;
    public BaseKernelLayer l;
    public Button m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948249517, "Lcom/baidu/tieba/vq7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948249517, "Lcom/baidu/tieba/vq7;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public boolean b;
        public boolean c;
        public long d;
        public final /* synthetic */ vq7 e;

        public a(vq7 vq7Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq7Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vq7Var;
            this.d = 0L;
            this.a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || !this.e.k || vq7.n || OrientationHelper.isSystemOrientationLocked(this.a)) {
                return;
            }
            if (!this.e.d()) {
                this.b = false;
                if (OrientationHelper.isPortrait(i)) {
                    this.c = true;
                }
                if (this.c && System.currentTimeMillis() - this.d > 1000) {
                    if (OrientationHelper.isReverseLandscape(i)) {
                        this.b = true;
                        BdActivityUtils.requestLandscape(this.a, true);
                        return;
                    } else if (OrientationHelper.isLandscape(i)) {
                        this.b = true;
                        BdActivityUtils.requestLandscape(this.a, false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            this.c = false;
            if (OrientationHelper.isReverseLandscape(i)) {
                this.b = true;
                BdActivityUtils.requestLandscape(this.a, true);
            } else if (OrientationHelper.isLandscape(i)) {
                this.b = true;
                BdActivityUtils.requestLandscape(this.a, false);
            } else if (OrientationHelper.isPortrait(i) && this.b && System.currentTimeMillis() - this.d > 1000) {
                this.d = System.currentTimeMillis();
                this.b = false;
                BdActivityUtils.requestPortrait(this.a);
            }
        }
    }

    public vq7() {
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
        this.a = false;
        this.b = false;
        this.c = "lp_bdrtc";
        this.d = new HashMap<>();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = PlayerConstant.HALF_MODE;
        this.k = true;
        this.l = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.b) {
            Log.d("lp_bdrtc", str);
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) && onInfoListener != null && !this.f.contains(onInfoListener)) {
            this.f.add(onInfoListener);
        }
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) && onProgressChangeListener != null && !this.g.contains(onProgressChangeListener)) {
            this.g.add(onProgressChangeListener);
        }
    }

    public void attachKernelLayer(BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseKernelLayer) == null) {
            a("attachKernelLayer " + baseKernelLayer);
            this.l = baseKernelLayer;
            detachKernelLayer();
        }
    }

    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            this.i = viewGroup;
        }
    }

    public void b(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            boolean z2 = true;
            if (i >= 3) {
                z = true;
            } else {
                z = false;
            }
            this.b = z;
            if (i < 2) {
                z2 = false;
            }
            this.a = z2;
        }
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return TextUtils.equals(this.h, str);
        }
        return invokeL.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && this.a) {
            Log.v(this.c, str);
        }
    }

    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                enableOrientationEventHelper();
            } else {
                disableOrientationEventHelper();
            }
            ViewGroup viewGroup = this.i;
            if (viewGroup != null && (viewGroup.getContext() instanceof Activity)) {
                VideoSystemHelper.setKeepScreenOnOff((Activity) this.i.getContext(), z);
            }
        }
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onInfoListener) == null) && onInfoListener != null) {
            this.f.remove(onInfoListener);
        }
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, onProgressChangeListener) == null) && onProgressChangeListener != null) {
            this.g.remove(onProgressChangeListener);
        }
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            a("setMode mode= " + str);
            this.h = str;
        }
    }

    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            n = z;
            if (!z) {
                enableOrientationEventHelper();
            }
        }
    }

    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVideoPlayerCallback) == null) {
            this.e = iVideoPlayerCallback;
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            a("initHelper");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.j = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.j.enableSensor();
                this.j.setListener(new a(this, (Activity) context));
            }
        }
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.d.get(cls);
            if (t == null) {
                return null;
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    @PublicMethod
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return TextUtils.equals(this.h, PlayerConstant.FULL_MODE);
        }
        return invokeV.booleanValue;
    }

    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a("detachKernelLayer ");
            getPlayerKernelLayer();
            Button button = this.m;
            if (button != null) {
                ((ViewGroup) button.getParent()).removeView(this.m);
            }
            return this.l;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (orientationHelper = this.j) != null) {
            this.k = false;
            orientationHelper.disable();
        }
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (orientationHelper = this.j) != null && orientationHelper.canDetectOrientation()) {
            this.k = this.j.enableSensor();
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return TextUtils.equals(this.h, PlayerConstant.FLOATING_MODE);
        }
        return invokeV.booleanValue;
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (orientationHelper = this.j) != null) {
            orientationHelper.disable();
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.i != null && d() && (this.i.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.i.getContext());
        }
    }

    public void e(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, obj) == null) && this.f != null) {
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.f.get(i3).onInfo(i, i2, obj);
            }
        }
    }

    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            a("getPlayerKernelLayer ");
            if (this.l == null && this.i != null) {
                this.m = new Button(this.i.getContext());
                this.l = new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER);
            }
            return this.l;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.d.put(cls, iPlayerContext);
        }
    }
}

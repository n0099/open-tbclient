package com.bigkoo.svprogresshud;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bigkoo.svprogresshud.listener.OnDismissListener;
import com.bigkoo.svprogresshud.view.SVCircleProgressBar;
import com.bigkoo.svprogresshud.view.SVProgressDefaultView;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class SVProgressHUD {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DISMISSDELAYED = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> contextWeak;
    public ViewGroup decorView;
    public int gravity;
    public Animation inAnim;
    public boolean isDismissing;
    public boolean isShowing;
    public Handler mHandler;
    public SVProgressHUDMaskType mSVProgressHUDMaskType;
    public SVProgressDefaultView mSharedView;
    public final View.OnTouchListener onCancelableTouchListener;
    public OnDismissListener onDismissListener;
    public Animation outAnim;
    public Animation.AnimationListener outAnimListener;
    public final FrameLayout.LayoutParams params;
    public ViewGroup rootView;

    /* renamed from: com.bigkoo.svprogresshud.SVProgressHUD$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1887341046, "Lcom/bigkoo/svprogresshud/SVProgressHUD$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1887341046, "Lcom/bigkoo/svprogresshud/SVProgressHUD$4;");
                    return;
                }
            }
            int[] iArr = new int[SVProgressHUDMaskType.values().length];
            $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType = iArr;
            try {
                iArr[SVProgressHUDMaskType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Clear.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.ClearCancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Black.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.BlackCancel.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Gradient.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.GradientCancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class SVProgressHUDMaskType {
        public static final /* synthetic */ SVProgressHUDMaskType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SVProgressHUDMaskType Black;
        public static final SVProgressHUDMaskType BlackCancel;
        public static final SVProgressHUDMaskType Clear;
        public static final SVProgressHUDMaskType ClearCancel;
        public static final SVProgressHUDMaskType Gradient;
        public static final SVProgressHUDMaskType GradientCancel;
        public static final SVProgressHUDMaskType None;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-177641155, "Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-177641155, "Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;");
                    return;
                }
            }
            None = new SVProgressHUDMaskType("None", 0);
            Clear = new SVProgressHUDMaskType("Clear", 1);
            Black = new SVProgressHUDMaskType("Black", 2);
            Gradient = new SVProgressHUDMaskType("Gradient", 3);
            ClearCancel = new SVProgressHUDMaskType("ClearCancel", 4);
            BlackCancel = new SVProgressHUDMaskType("BlackCancel", 5);
            SVProgressHUDMaskType sVProgressHUDMaskType = new SVProgressHUDMaskType("GradientCancel", 6);
            GradientCancel = sVProgressHUDMaskType;
            $VALUES = new SVProgressHUDMaskType[]{None, Clear, Black, Gradient, ClearCancel, BlackCancel, sVProgressHUDMaskType};
        }

        public SVProgressHUDMaskType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SVProgressHUDMaskType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SVProgressHUDMaskType) Enum.valueOf(SVProgressHUDMaskType.class, str);
            }
            return (SVProgressHUDMaskType) invokeL.objValue;
        }

        public static SVProgressHUDMaskType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SVProgressHUDMaskType[]) $VALUES.clone();
            }
            return (SVProgressHUDMaskType[]) invokeV.objValue;
        }
    }

    public SVProgressHUD(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new FrameLayout.LayoutParams(-1, -2, 80);
        this.gravity = 17;
        this.mHandler = new Handler(this) { // from class: com.bigkoo.svprogresshud.SVProgressHUD.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SVProgressHUD this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    this.this$0.dismiss();
                }
            }
        };
        this.onCancelableTouchListener = new View.OnTouchListener(this) { // from class: com.bigkoo.svprogresshud.SVProgressHUD.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SVProgressHUD this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.this$0.dismiss();
                        this.this$0.setCancelable(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        };
        this.outAnimListener = new Animation.AnimationListener(this) { // from class: com.bigkoo.svprogresshud.SVProgressHUD.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SVProgressHUD this$0;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.this$0.dismissImmediately();
                }
            }
        };
        this.contextWeak = new WeakReference<>(context);
        this.gravity = 17;
        initViews();
        initDefaultView();
        initAnimation();
    }

    private void setMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, sVProgressHUDMaskType) == null) {
            this.mSVProgressHUDMaskType = sVProgressHUDMaskType;
            switch (AnonymousClass4.$SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[sVProgressHUDMaskType.ordinal()]) {
                case 1:
                    configMaskType(17170445, false, false);
                    return;
                case 2:
                    configMaskType(17170445, true, false);
                    return;
                case 3:
                    configMaskType(17170445, true, true);
                    return;
                case 4:
                    configMaskType(com.baidu.tieba.R.color.obfuscated_res_0x7f06049d, true, false);
                    return;
                case 5:
                    configMaskType(com.baidu.tieba.R.color.obfuscated_res_0x7f06049d, true, true);
                    return;
                case 6:
                    configMaskType(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080321, true, false);
                    return;
                case 7:
                    configMaskType(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080321, true, true);
                    return;
                default:
                    return;
            }
        }
    }

    public void showErrorWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, str, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showErrorWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showInfoWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, str, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showInfoWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showSuccessWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, str, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showSuccessWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showWithProgress(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, str, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showWithProgress(str);
        svShow();
    }

    public void showWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, str, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showWithStatus(str);
        svShow();
    }

    private void configMaskType(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.rootView.setBackgroundResource(i);
            this.rootView.setClickable(z);
            setCancelable(z2);
        }
    }

    private void onAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.isShowing = true;
            this.decorView.addView(this.rootView);
            if (this.mSharedView.getParent() != null) {
                ((ViewGroup) this.mSharedView.getParent()).removeView(this.mSharedView);
            }
            this.rootView.addView(this.mSharedView);
        }
    }

    private void scheduleDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    private void svShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mHandler.removeCallbacksAndMessages(null);
            onAttached();
            this.mSharedView.startAnimation(this.inAnim);
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.isDismissing) {
            return;
        }
        this.isDismissing = true;
        this.outAnim.setAnimationListener(this.outAnimListener);
        this.mSharedView.dismiss();
        this.mSharedView.startAnimation(this.outAnim);
    }

    public void dismissImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mSharedView.dismiss();
            this.rootView.removeView(this.mSharedView);
            this.decorView.removeView(this.rootView);
            this.isShowing = false;
            this.isDismissing = false;
            OnDismissListener onDismissListener = this.onDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
        }
    }

    public Animation getInAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.contextWeak.get();
            if (context == null) {
                return null;
            }
            return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, true));
        }
        return (Animation) invokeV.objValue;
    }

    public OnDismissListener getOnDismissListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.onDismissListener;
        }
        return (OnDismissListener) invokeV.objValue;
    }

    public Animation getOutAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.contextWeak.get();
            if (context == null) {
                return null;
            }
            return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, false));
        }
        return (Animation) invokeV.objValue;
    }

    public SVCircleProgressBar getProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSharedView.getCircleProgressBar();
        }
        return (SVCircleProgressBar) invokeV.objValue;
    }

    public void initAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.inAnim == null) {
                this.inAnim = getInAnimation();
            }
            if (this.outAnim == null) {
                this.outAnim = getOutAnimation();
            }
        }
    }

    public void initDefaultView() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (context = this.contextWeak.get()) == null) {
            return;
        }
        SVProgressDefaultView sVProgressDefaultView = new SVProgressDefaultView(context);
        this.mSharedView = sVProgressDefaultView;
        FrameLayout.LayoutParams layoutParams = this.params;
        layoutParams.gravity = this.gravity;
        sVProgressDefaultView.setLayoutParams(layoutParams);
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.rootView.getParent() == null && !this.isShowing) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.show();
        svShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            View findViewById = this.rootView.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092244);
            if (z) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onDismissListener) == null) {
            this.onDismissListener = onDismissListener;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mSharedView.setText(str);
        }
    }

    public void showErrorWithStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showErrorWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showInfoWithStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showInfoWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showSuccessWithStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showSuccessWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showWithMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, sVProgressHUDMaskType) != null) || isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.show();
        svShow();
    }

    public void showWithStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showWithStatus(str);
        svShow();
    }

    public void initViews() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (context = this.contextWeak.get()) == null) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        this.decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        ViewGroup viewGroup = (ViewGroup) from.inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d057d, (ViewGroup) null, false);
        this.rootView = viewGroup;
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
}

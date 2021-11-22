package com.baidu.wallet.base.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes10.dex */
public class BubbleForSubMenu extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f58385a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58386b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownTimer f58387c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f58388d;

    /* renamed from: e  reason: collision with root package name */
    public Animator.AnimatorListener f58389e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f58390f;

    /* renamed from: g  reason: collision with root package name */
    public Animator.AnimatorListener f58391g;

    /* renamed from: h  reason: collision with root package name */
    public float f58392h;

    /* renamed from: i  reason: collision with root package name */
    public float f58393i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 11)
    public BubbleForSubMenu(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 11)
    public void setTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            if (z) {
                this.f58386b.setAlpha(0.0f);
                this.f58386b.setTextColor(ResUtils.getColor(getContext(), "wallet_base_transparent"));
                return;
            }
            this.f58386b.setAlpha(1.0f);
            this.f58386b.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        }
    }

    @RequiresApi(api = 11)
    public void addExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ObjectAnimator objectAnimator = this.f58390f;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.f58385a.clearAnimation();
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "hide fromX = " + this.f58393i + " ; toX = " + this.f58392h);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58385a, "translationX", this.f58393i, this.f58392h);
                this.f58390f = ofFloat;
                if (ofFloat != null && ofFloat.getListeners() == null) {
                    this.f58390f.addListener(this.f58391g);
                }
                this.f58390f.setDuration(400L).start();
            }
        }
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "隐藏bubble");
            CountDownTimer countDownTimer = this.f58387c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (z) {
                addExitAnimation();
                return;
            }
            this.f58385a.setVisibility(8);
            setTransparent(true);
        }
    }

    @RequiresApi(api = 11)
    public boolean isShowingBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("正在展示bubble = ");
            sb.append(this.f58385a.getVisibility() == 0);
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, sb.toString());
            return this.f58385a.getVisibility() == 0 && this.f58386b.getAlpha() == 1.0f;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(api = 11)
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "onDetachedFromWindow");
            super.onDetachedFromWindow();
            ObjectAnimator objectAnimator = this.f58388d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f58388d.cancel();
                this.f58388d.removeAllListeners();
                this.f58388d = null;
            }
            ObjectAnimator objectAnimator2 = this.f58390f;
            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                return;
            }
            this.f58390f.cancel();
            this.f58390f.removeAllListeners();
            this.f58390f = null;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f58386b.setText(str);
        }
    }

    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    public void showBubble(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if (!TextUtils.isEmpty(str) && (!isShowingBubble() || !str.equals(this.f58386b.getText()))) {
                if (isShowingBubble()) {
                    hideBubble(false);
                }
                setText(str);
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble");
                this.f58385a.setVisibility(0);
                if (z) {
                    c();
                } else {
                    setTransparent(false);
                }
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble width = " + getWidth());
                if (this.f58387c == null) {
                    this.f58387c = new CountDownTimer(this, 5000L, 1000L) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BubbleForSubMenu f58396a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r11, r13);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Long.valueOf(r11), Long.valueOf(r13)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f58396a = this;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "5s倒计时到点");
                                this.f58396a.f58385a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f58397a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f58397a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f58397a.f58396a.hideBubble(true);
                                        }
                                    }
                                });
                            }
                        }

                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                            }
                        }
                    };
                }
                CountDownTimer countDownTimer = this.f58387c;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    this.f58387c.start();
                    return;
                }
                return;
            }
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "正在展示bubble 直接return");
        }
    }

    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ObjectAnimator objectAnimator = this.f58388d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f58388d.cancel();
            }
            this.f58385a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f58398a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58398a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BubbleForSubMenu bubbleForSubMenu = this.f58398a;
                        bubbleForSubMenu.f58392h = bubbleForSubMenu.f58386b.getRight();
                        BubbleForSubMenu bubbleForSubMenu2 = this.f58398a;
                        bubbleForSubMenu2.f58393i = bubbleForSubMenu2.f58386b.getLeft();
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "show fromX = " + this.f58398a.f58392h + " ; toX = " + this.f58398a.f58393i);
                        BubbleForSubMenu bubbleForSubMenu3 = this.f58398a;
                        bubbleForSubMenu3.f58388d = ObjectAnimator.ofFloat(bubbleForSubMenu3.f58385a, "translationX", this.f58398a.f58392h, this.f58398a.f58393i);
                        if (this.f58398a.f58388d != null && this.f58398a.f58388d.getListeners() == null) {
                            this.f58398a.f58388d.addListener(this.f58398a.f58389e);
                        }
                        this.f58398a.f58388d.setDuration(400L).start();
                    }
                }
            });
        }
    }

    @RequiresApi(api = 11)
    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f58389e = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f58394a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58394a = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "进入动画：start");
                        this.f58394a.setTransparent(false);
                    }
                }
            };
            this.f58391g = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f58395a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58395a = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "退出动画：end");
                        this.f58395a.f58385a.setVisibility(8);
                        this.f58395a.setTransparent(true);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                    }
                }
            };
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_langbridge_sub_menu_bubble"), this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11, -1);
            layoutParams.addRule(15, -1);
            layoutParams.rightMargin = DisplayUtils.dip2px(getContext(), 82.0f);
            setLayoutParams(layoutParams);
            this.f58385a = (FrameLayout) findViewById(ResUtils.id(getContext(), FileHelper.FILE_CACHE_BUBBLE));
            this.f58386b = (TextView) findViewById(ResUtils.id(getContext(), "bubble_text"));
        }
    }
}

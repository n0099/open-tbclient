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
import androidx.constraintlayout.motion.widget.Key;
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
    public FrameLayout f57463a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57464b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownTimer f57465c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f57466d;

    /* renamed from: e  reason: collision with root package name */
    public Animator.AnimatorListener f57467e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f57468f;

    /* renamed from: g  reason: collision with root package name */
    public Animator.AnimatorListener f57469g;

    /* renamed from: h  reason: collision with root package name */
    public float f57470h;

    /* renamed from: i  reason: collision with root package name */
    public float f57471i;

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
                this.f57464b.setAlpha(0.0f);
                this.f57464b.setTextColor(ResUtils.getColor(getContext(), "wallet_base_transparent"));
                return;
            }
            this.f57464b.setAlpha(1.0f);
            this.f57464b.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        }
    }

    @RequiresApi(api = 11)
    public void addExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ObjectAnimator objectAnimator = this.f57468f;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.f57463a.clearAnimation();
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "hide fromX = " + this.f57471i + " ; toX = " + this.f57470h);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f57463a, Key.TRANSLATION_X, this.f57471i, this.f57470h);
                this.f57468f = ofFloat;
                if (ofFloat != null && ofFloat.getListeners() == null) {
                    this.f57468f.addListener(this.f57469g);
                }
                this.f57468f.setDuration(400L).start();
            }
        }
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "隐藏bubble");
            CountDownTimer countDownTimer = this.f57465c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (z) {
                addExitAnimation();
                return;
            }
            this.f57463a.setVisibility(8);
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
            sb.append(this.f57463a.getVisibility() == 0);
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, sb.toString());
            return this.f57463a.getVisibility() == 0 && this.f57464b.getAlpha() == 1.0f;
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
            ObjectAnimator objectAnimator = this.f57466d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f57466d.cancel();
                this.f57466d.removeAllListeners();
                this.f57466d = null;
            }
            ObjectAnimator objectAnimator2 = this.f57468f;
            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                return;
            }
            this.f57468f.cancel();
            this.f57468f.removeAllListeners();
            this.f57468f = null;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f57464b.setText(str);
        }
    }

    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    public void showBubble(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if (!TextUtils.isEmpty(str) && (!isShowingBubble() || !str.equals(this.f57464b.getText()))) {
                if (isShowingBubble()) {
                    hideBubble(false);
                }
                setText(str);
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble");
                this.f57463a.setVisibility(0);
                if (z) {
                    c();
                } else {
                    setTransparent(false);
                }
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble width = " + getWidth());
                if (this.f57465c == null) {
                    this.f57465c = new CountDownTimer(this, 5000L, 1000L) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BubbleForSubMenu f57474a;

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
                            this.f57474a = this;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "5s倒计时到点");
                                this.f57474a.f57463a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f57475a;

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
                                        this.f57475a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f57475a.f57474a.hideBubble(true);
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
                CountDownTimer countDownTimer = this.f57465c;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    this.f57465c.start();
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
            ObjectAnimator objectAnimator = this.f57466d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f57466d.cancel();
            }
            this.f57463a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f57476a;

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
                    this.f57476a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BubbleForSubMenu bubbleForSubMenu = this.f57476a;
                        bubbleForSubMenu.f57470h = bubbleForSubMenu.f57464b.getRight();
                        BubbleForSubMenu bubbleForSubMenu2 = this.f57476a;
                        bubbleForSubMenu2.f57471i = bubbleForSubMenu2.f57464b.getLeft();
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "show fromX = " + this.f57476a.f57470h + " ; toX = " + this.f57476a.f57471i);
                        BubbleForSubMenu bubbleForSubMenu3 = this.f57476a;
                        bubbleForSubMenu3.f57466d = ObjectAnimator.ofFloat(bubbleForSubMenu3.f57463a, Key.TRANSLATION_X, this.f57476a.f57470h, this.f57476a.f57471i);
                        if (this.f57476a.f57466d != null && this.f57476a.f57466d.getListeners() == null) {
                            this.f57476a.f57466d.addListener(this.f57476a.f57467e);
                        }
                        this.f57476a.f57466d.setDuration(400L).start();
                    }
                }
            });
        }
    }

    @RequiresApi(api = 11)
    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f57467e = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f57472a;

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
                    this.f57472a = this;
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
                        this.f57472a.setTransparent(false);
                    }
                }
            };
            this.f57469g = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f57473a;

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
                    this.f57473a = this;
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
                        this.f57473a.f57463a.setVisibility(8);
                        this.f57473a.setTransparent(true);
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
            this.f57463a = (FrameLayout) findViewById(ResUtils.id(getContext(), FileHelper.FILE_CACHE_BUBBLE));
            this.f57464b = (TextView) findViewById(ResUtils.id(getContext(), "bubble_text"));
        }
    }
}

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
/* loaded from: classes8.dex */
public class BubbleForSubMenu extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f60216a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60217b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownTimer f60218c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f60219d;

    /* renamed from: e  reason: collision with root package name */
    public Animator.AnimatorListener f60220e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f60221f;

    /* renamed from: g  reason: collision with root package name */
    public Animator.AnimatorListener f60222g;

    /* renamed from: h  reason: collision with root package name */
    public float f60223h;

    /* renamed from: i  reason: collision with root package name */
    public float f60224i;

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
                this.f60217b.setAlpha(0.0f);
                this.f60217b.setTextColor(ResUtils.getColor(getContext(), "wallet_base_transparent"));
                return;
            }
            this.f60217b.setAlpha(1.0f);
            this.f60217b.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        }
    }

    @RequiresApi(api = 11)
    public void addExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ObjectAnimator objectAnimator = this.f60221f;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.f60216a.clearAnimation();
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "hide fromX = " + this.f60224i + " ; toX = " + this.f60223h);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f60216a, "translationX", this.f60224i, this.f60223h);
                this.f60221f = ofFloat;
                if (ofFloat != null && ofFloat.getListeners() == null) {
                    this.f60221f.addListener(this.f60222g);
                }
                this.f60221f.setDuration(400L).start();
            }
        }
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "隐藏bubble");
            CountDownTimer countDownTimer = this.f60218c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (z) {
                addExitAnimation();
                return;
            }
            this.f60216a.setVisibility(8);
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
            sb.append(this.f60216a.getVisibility() == 0);
            LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, sb.toString());
            return this.f60216a.getVisibility() == 0 && this.f60217b.getAlpha() == 1.0f;
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
            ObjectAnimator objectAnimator = this.f60219d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f60219d.cancel();
                this.f60219d.removeAllListeners();
                this.f60219d = null;
            }
            ObjectAnimator objectAnimator2 = this.f60221f;
            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                return;
            }
            this.f60221f.cancel();
            this.f60221f.removeAllListeners();
            this.f60221f = null;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f60217b.setText(str);
        }
    }

    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    public void showBubble(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if (!TextUtils.isEmpty(str) && (!isShowingBubble() || !str.equals(this.f60217b.getText()))) {
                if (isShowingBubble()) {
                    hideBubble(false);
                }
                setText(str);
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble");
                this.f60216a.setVisibility(0);
                if (z) {
                    c();
                } else {
                    setTransparent(false);
                }
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "展示bubble width = " + getWidth());
                if (this.f60218c == null) {
                    this.f60218c = new CountDownTimer(this, 5000L, 1000L) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BubbleForSubMenu f60227a;

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
                            this.f60227a = this;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "5s倒计时到点");
                                this.f60227a.f60216a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f60228a;

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
                                        this.f60228a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f60228a.f60227a.hideBubble(true);
                                        }
                                    }
                                });
                            }
                        }

                        @Override // android.os.CountDownTimer
                        public void onTick(long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                            }
                        }
                    };
                }
                CountDownTimer countDownTimer = this.f60218c;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    this.f60218c.start();
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
            ObjectAnimator objectAnimator = this.f60219d;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f60219d.cancel();
            }
            this.f60216a.post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f60229a;

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
                    this.f60229a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BubbleForSubMenu bubbleForSubMenu = this.f60229a;
                        bubbleForSubMenu.f60223h = bubbleForSubMenu.f60217b.getRight();
                        BubbleForSubMenu bubbleForSubMenu2 = this.f60229a;
                        bubbleForSubMenu2.f60224i = bubbleForSubMenu2.f60217b.getLeft();
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "show fromX = " + this.f60229a.f60223h + " ; toX = " + this.f60229a.f60224i);
                        BubbleForSubMenu bubbleForSubMenu3 = this.f60229a;
                        bubbleForSubMenu3.f60219d = ObjectAnimator.ofFloat(bubbleForSubMenu3.f60216a, "translationX", this.f60229a.f60223h, this.f60229a.f60224i);
                        if (this.f60229a.f60219d != null && this.f60229a.f60219d.getListeners() == null) {
                            this.f60229a.f60219d.addListener(this.f60229a.f60220e);
                        }
                        this.f60229a.f60219d.setDuration(400L).start();
                    }
                }
            });
        }
    }

    @RequiresApi(api = 11)
    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f60220e = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f60225a;

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
                    this.f60225a = this;
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
                        this.f60225a.setTransparent(false);
                    }
                }
            };
            this.f60222g = new Animator.AnimatorListener(this) { // from class: com.baidu.wallet.base.widget.BubbleForSubMenu.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BubbleForSubMenu f60226a;

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
                    this.f60226a = this;
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
                        this.f60226a.f60216a.setVisibility(8);
                        this.f60226a.setTransparent(true);
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
            this.f60216a = (FrameLayout) findViewById(ResUtils.id(getContext(), FileHelper.FILE_CACHE_BUBBLE));
            this.f60217b = (TextView) findViewById(ResUtils.id(getContext(), "bubble_text"));
        }
    }
}

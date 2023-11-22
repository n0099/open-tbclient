package com.baidu.tieba.pb;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.wd5;
import com.baidu.tieba.xb;
import com.baidu.tieba.xd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes7.dex */
public class PbFirstFloorDoubleClickAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView agreeView;
    public Animator.AnimatorListener animatorListener;
    public FrameLayout contentView;
    public final Context context;
    public int lottieHeight;
    public int lottieWidth;
    public int lottieXOffset;
    public int lottieYOffset;
    public int mGravity;
    public d mPraiseAnimatorListener;
    public PopupWindow popupWindow;

    /* loaded from: classes7.dex */
    public interface d {
        void onFinish();
    }

    /* loaded from: classes7.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorDoubleClickAnimation a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorDoubleClickAnimation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorDoubleClickAnimation;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.popupWindow.dismiss();
                if (this.a.mPraiseAnimatorListener != null) {
                    this.a.mPraiseAnimatorListener.onFinish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFirstFloorDoubleClickAnimation d;

        public b(PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorDoubleClickAnimation, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFirstFloorDoubleClickAnimation;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.tieba.wd5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.d.agreeView.setAnimation(i);
                if (!TextUtils.isEmpty(str)) {
                    this.d.agreeView.setImageAssetsFolder(str);
                }
                this.d.playAnimation(this.a, this.b, this.c);
            }
        }

        @Override // com.baidu.tieba.wd5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.d.agreeView.setAnimationDir(str);
                this.d.playAnimation(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements wd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFirstFloorDoubleClickAnimation d;

        public c(PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorDoubleClickAnimation, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFirstFloorDoubleClickAnimation;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.tieba.wd5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.d.agreeView.setAlpha(1.0f);
                this.d.agreeView.setAnimation(i);
                this.d.agreeView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
                if (!TextUtils.isEmpty(str)) {
                    this.d.agreeView.setImageAssetsFolder(str);
                    this.d.playAnimation(this.a, this.b, this.c);
                }
            }
        }

        @Override // com.baidu.tieba.wd5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.d.agreeView.setAlpha(1.0f);
                this.d.agreeView.setAnimationDir(str);
                this.d.agreeView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
                this.d.playAnimation(this.a, this.b, this.c);
            }
        }
    }

    public PbFirstFloorDoubleClickAnimation(Context context) {
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
        this.lottieHeight = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        this.lottieWidth = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds484);
        this.mGravity = 0;
        this.context = context;
        initListener();
        initContentView();
        initPopupWindow();
    }

    public void setClippingEnable(boolean z) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (popupWindow = this.popupWindow) != null) {
            popupWindow.setClippingEnabled(z);
        }
    }

    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mGravity = i;
        }
    }

    public void setLayoutParmas(ViewGroup.MarginLayoutParams marginLayoutParams) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marginLayoutParams) == null) && (tBLottieAnimationView = this.agreeView) != null) {
            tBLottieAnimationView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setLottieHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.lottieHeight = i;
        }
    }

    public void setOnPraiseAnimatorListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.mPraiseAnimatorListener = dVar;
        }
    }

    private void initContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.contentView = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.agreeView = new TBLottieAnimationView(this.context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.lottieWidth, this.lottieHeight);
            this.agreeView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.agreeView.setLayoutParams(layoutParams);
            this.agreeView.addAnimatorListener(this.animatorListener);
            this.contentView.addView(this.agreeView);
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.animatorListener = new a(this);
        }
    }

    private void initPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.popupWindow = popupWindow;
            popupWindow.setContentView(this.contentView);
            this.popupWindow.setHeight(-2);
            this.popupWindow.setWidth(-2);
            GreyUtil.grey(this.popupWindow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimation(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65544, this, view2, i, i2) == null) && xb.m(this.popupWindow, view2, this.mGravity, i - this.lottieXOffset, i2 - this.lottieYOffset)) {
            this.agreeView.playAnimation();
        }
    }

    public void show(View view2, int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            this.lottieXOffset = this.lottieWidth / 2;
            this.lottieYOffset = this.lottieHeight / 2;
            xd5.g().b(str, str2, new b(this, view2, i, i2));
        }
    }

    public void showFireworks(boolean z, View view2, int i, int i2, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), view2, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            this.lottieXOffset = 0;
            this.lottieYOffset = this.lottieHeight;
            if (new Random().nextBoolean()) {
                str3 = "/duang1";
            } else {
                str3 = "/duang2";
            }
            xd5.g().e(str3, str, str2, z, new c(this, view2, i, i2));
        }
    }
}

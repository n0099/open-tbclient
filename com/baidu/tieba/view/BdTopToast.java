package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BdTopToast extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DURATION = 5000;
    public static final int DEFAULT_THIRD_DURATION = 3000;
    public static final int DEFAULT_YOUNGSTER_DURATION = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mContentView;
    public int mDuration;
    public Runnable mHideRunnable;
    public ImageView mIconView;
    public Animation mInAnimation;
    public boolean mIsSuc;
    public Animation mOutAnimation;
    public BottomShadowLinearLayout mShadowGroup;
    public View mStatusBarView;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTopToast a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public a(BdTopToast bdTopToast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTopToast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTopToast;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.release();
            if (this.a.getParent() != null) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTopToast a;

        public b(BdTopToast bdTopToast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTopToast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTopToast;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.hide();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTopToast(Context context) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTopToast(Context context, int i) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDuration = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDuration = -1;
        init();
    }

    public BdTopToast setContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (getContext() != null) {
                this.mContentView.setText(str);
            }
            return this;
        }
        return (BdTopToast) invokeL.objValue;
    }

    public BdTopToast setIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.mIsSuc = z;
            return this;
        }
        return (BdTopToast) invokeZ.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || getContext() == null) {
            return;
        }
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mStatusBarView = new View(getContext());
            addView(this.mStatusBarView, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
        LayoutInflater.from(getContext()).inflate(R.layout.bd_top_toast_layout, this);
        this.mShadowGroup = (BottomShadowLinearLayout) findViewById(R.id.bd_top_toast_group);
        this.mIconView = (ImageView) findViewById(R.id.bd_top_toast_icon);
        this.mContentView = (TextView) findViewById(R.id.bd_top_toast_content);
        initAnimation();
    }

    private void initAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010100);
            this.mOutAnimation = loadAnimation;
            loadAnimation.setAnimationListener(new a(this));
            this.mHideRunnable = new b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.mHideRunnable);
            if (getContext() == null) {
                return;
            }
            clearAnimation();
        }
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || getContext() == null) {
            return;
        }
        release();
        startAnimation(this.mOutAnimation);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || getContext() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0207);
        if (this.mIsSuc) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mIconView, R.drawable.ic_icon_pure_succeed_use_n, R.color.CAM_X0302, null);
            SkinManager.setViewTextColor(this.mContentView, (int) R.color.CAM_X0302);
        } else {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mIconView, R.drawable.ic_icon_pure_defeated_use_n, R.color.CAM_X0301, null);
            SkinManager.setViewTextColor(this.mContentView, (int) R.color.CAM_X0301);
        }
        this.mShadowGroup.b();
    }

    public void show(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) && viewGroup != null && getContext() != null) {
            release();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            viewGroup.addView(this, -1, -2);
            onChangeSkinType();
            startAnimation(this.mInAnimation);
            if (this.mDuration >= 0) {
                SafeHandler.getInst().postDelayed(this.mHideRunnable, this.mDuration);
            } else {
                SafeHandler.getInst().postDelayed(this.mHideRunnable, 5000L);
            }
        }
    }
}

package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes12.dex */
public class VideoZoomBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoContainerLayout a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPbViewModel f46911b;

    public VideoZoomBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final VideoContainerLayout a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        VideoContainerLayout a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            if (viewGroup instanceof VideoContainerLayout) {
                return (VideoContainerLayout) viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                    return a;
                }
            }
            return null;
        }
        return (VideoContainerLayout) invokeL.objValue;
    }

    public final void b(int i2, AppBarLayout appBarLayout, View view, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), appBarLayout, view, Integer.valueOf(i3)}) == null) && i3 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i2 >= 0 || topAndBottomOffset != 0) && (i2 <= 0 || topAndBottomOffset != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, coordinatorLayout, appBarLayout, motionEvent)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i2) {
        InterceptResult invokeI;
        VideoContainerLayout videoContainerLayout;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            boolean topAndBottomOffset = super.setTopAndBottomOffset(i2);
            if (topAndBottomOffset && (videoContainerLayout = this.a) != null && (layoutParams = videoContainerLayout.getLayoutParams()) != null) {
                int maxHeight = this.a.getMaxHeight() + i2;
                if (layoutParams.height != maxHeight) {
                    layoutParams.height = maxHeight;
                    this.a.setLayoutParams(layoutParams);
                }
                if (this.f46911b == null && (this.a.getContext() instanceof AbsPbActivity)) {
                    this.f46911b = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) this.a.getContext()).get(VideoPbViewModel.class);
                }
                VideoPbViewModel videoPbViewModel = this.f46911b;
                if (videoPbViewModel != null) {
                    if (i2 > -5) {
                        MutableLiveData<Boolean> isDetailTabTop = videoPbViewModel.getIsDetailTabTop();
                        if (isDetailTabTop == null || isDetailTabTop.getValue() == null || !isDetailTabTop.getValue().booleanValue()) {
                            this.f46911b.setIsDetailTabTop(true);
                        }
                    } else {
                        MutableLiveData<Boolean> isDetailTabTop2 = videoPbViewModel.getIsDetailTabTop();
                        if (isDetailTabTop2 == null || isDetailTabTop2.getValue() == null || isDetailTabTop2.getValue().booleanValue()) {
                            this.f46911b.setIsDetailTabTop(false);
                        }
                    }
                }
            }
            return topAndBottomOffset;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, coordinatorLayout, appBarLayout, i2)) == null) {
            this.a = a(appBarLayout);
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        }
        return invokeLLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{coordinatorLayout, appBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
            b(i3, appBarLayout, view, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{coordinatorLayout, appBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, i4, i5, i6);
            b(i5, appBarLayout, view, i6);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{coordinatorLayout, appBarLayout, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            VideoContainerLayout a = a(appBarLayout);
            this.a = a;
            return (a == null || (i2 & 2) == 0) ? false : true;
        }
        return invokeCommon.booleanValue;
    }
}

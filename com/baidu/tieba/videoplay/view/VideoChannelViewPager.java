package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import b.a.e.e.p.l;
import b.a.q0.f1.r.b;
import b.a.r0.b4.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoChannelViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f55197e;

    /* renamed from: f  reason: collision with root package name */
    public float f55198f;

    /* renamed from: g  reason: collision with root package name */
    public int f55199g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55200h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55201i;
    public b.InterfaceC0660b j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelViewPager(@NonNull Context context) {
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
        this.f55200h = true;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f55199g = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f55200h = ((float) getHeight()) - motionEvent.getY() > ((float) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.g(getContext(), d.tbds50)));
            }
            handleTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void handleTouchEvent(MotionEvent motionEvent) {
        b.InterfaceC0660b interfaceC0660b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) && this.f55201i && this.f55200h) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && getCurrentItem() == 1 && Math.abs(this.f55197e - motionEvent.getX()) > this.f55199g && Math.abs(this.f55198f - motionEvent.getY()) < 100.0f && (this.f55197e - motionEvent.getX()) - 50.0f > Math.abs(this.f55198f - motionEvent.getY()) && (interfaceC0660b = this.j) != null) {
                    interfaceC0660b.onViewDragToRight();
                    return;
                }
                return;
            }
            this.f55197e = motionEvent.getX();
            this.f55198f = motionEvent.getY();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.f55201i && this.f55200h) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.f55201i && this.f55200h) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setListener(b.InterfaceC0660b interfaceC0660b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0660b) == null) {
            this.j = interfaceC0660b;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f55201i = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f55200h = true;
        a(context);
    }
}

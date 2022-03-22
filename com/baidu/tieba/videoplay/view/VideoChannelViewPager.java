package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.o0.e1.r.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoChannelViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f36790b;

    /* renamed from: c  reason: collision with root package name */
    public int f36791c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36792d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36793e;

    /* renamed from: f  reason: collision with root package name */
    public b.InterfaceC0807b f36794f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f36795g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelViewPager(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36792d = true;
        this.f36795g = new ArrayList();
        b(context);
    }

    public void a(MotionEvent motionEvent) {
        float f2;
        float f3;
        b.InterfaceC0807b interfaceC0807b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.f36793e && this.f36792d) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f36795g.clear();
                this.a = motionEvent.getX();
                this.f36790b = motionEvent.getY();
            } else if (action != 1) {
                if (action != 2) {
                    return;
                }
                this.f36795g.add(motionEvent.getX() + "&" + motionEvent.getY());
            } else if (getCurrentItem() != 1) {
            } else {
                float x = motionEvent.getX();
                float f4 = this.a;
                if (x >= f4 || f4 - motionEvent.getX() <= this.f36791c) {
                    return;
                }
                int size = this.f36795g.size() / 2;
                if (this.f36795g.size() > size && this.f36795g.get(size) != null) {
                    String[] split = this.f36795g.get(size).split("&");
                    if (split.length > 1) {
                        f3 = Math.abs(this.a - Float.parseFloat(split[0]));
                        f2 = Math.abs(this.f36790b - Float.parseFloat(split[1]));
                        if (f3 != 0.0f || f2 / f3 > Math.tan(Math.toRadians(30.0d)) || (interfaceC0807b = this.f36794f) == null) {
                            return;
                        }
                        interfaceC0807b.onViewDragToRight();
                        return;
                    }
                }
                f2 = 0.0f;
                f3 = 0.0f;
                if (f3 != 0.0f) {
                }
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f36791c = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f36792d = ((float) getHeight()) - motionEvent.getY() > ((float) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + n.f(getContext(), R.dimen.tbds50)));
            }
            a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.f36793e && this.f36792d) {
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
            if (this.f36793e && this.f36792d) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setListener(b.InterfaceC0807b interfaceC0807b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0807b) == null) {
            this.f36794f = interfaceC0807b;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f36793e = z;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36792d = true;
        this.f36795g = new ArrayList();
        b(context);
    }
}

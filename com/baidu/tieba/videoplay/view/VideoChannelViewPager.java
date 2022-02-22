package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.t0.f1.r.b;
import c.a.u0.p4.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class VideoChannelViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f49180e;

    /* renamed from: f  reason: collision with root package name */
    public float f49181f;

    /* renamed from: g  reason: collision with root package name */
    public int f49182g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49183h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49184i;

    /* renamed from: j  reason: collision with root package name */
    public b.InterfaceC0867b f49185j;
    public List<String> k;

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
        this.f49183h = true;
        this.k = new ArrayList();
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f49182g = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f49183h = ((float) getHeight()) - motionEvent.getY() > ((float) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + n.f(getContext(), d.tbds50)));
            }
            handleTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void handleTouchEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        b.InterfaceC0867b interfaceC0867b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) && this.f49184i && this.f49183h) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.k.clear();
                this.f49180e = motionEvent.getX();
                this.f49181f = motionEvent.getY();
            } else if (action != 1) {
                if (action != 2) {
                    return;
                }
                this.k.add(motionEvent.getX() + "&" + motionEvent.getY());
            } else if (getCurrentItem() != 1) {
            } else {
                float x = motionEvent.getX();
                float f4 = this.f49180e;
                if (x >= f4 || f4 - motionEvent.getX() <= this.f49182g) {
                    return;
                }
                int size = this.k.size() / 2;
                if (this.k.size() > size && this.k.get(size) != null) {
                    String[] split = this.k.get(size).split("&");
                    if (split.length > 1) {
                        f3 = Math.abs(this.f49180e - Float.parseFloat(split[0]));
                        f2 = Math.abs(this.f49181f - Float.parseFloat(split[1]));
                        if (f3 != 0.0f || f2 / f3 > Math.tan(Math.toRadians(30.0d)) || (interfaceC0867b = this.f49185j) == null) {
                            return;
                        }
                        interfaceC0867b.onViewDragToRight();
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

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.f49184i && this.f49183h) {
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
            if (this.f49184i && this.f49183h) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setListener(b.InterfaceC0867b interfaceC0867b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0867b) == null) {
            this.f49185j = interfaceC0867b;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f49184i = z;
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
        this.f49183h = true;
        this.k = new ArrayList();
        a(context);
    }
}

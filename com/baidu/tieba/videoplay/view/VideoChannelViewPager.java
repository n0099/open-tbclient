package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oj5;
import com.repackage.qi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoChannelViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public int c;
    public boolean d;
    public boolean e;
    public oj5.b f;
    public List<String> g;

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
        this.d = true;
        this.g = new ArrayList();
        b(context);
    }

    public void a(MotionEvent motionEvent) {
        float f;
        float f2;
        oj5.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.e && this.d) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.g.clear();
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
            } else if (action != 1) {
                if (action != 2) {
                    return;
                }
                this.g.add(motionEvent.getX() + "&" + motionEvent.getY());
            } else if (getCurrentItem() != 1) {
            } else {
                float x = motionEvent.getX();
                float f3 = this.a;
                if (x >= f3 || f3 - motionEvent.getX() <= this.c) {
                    return;
                }
                int size = this.g.size() / 2;
                if (this.g.size() > size && this.g.get(size) != null) {
                    String[] split = this.g.get(size).split("&");
                    if (split.length > 1) {
                        f2 = Math.abs(this.a - Float.parseFloat(split[0]));
                        f = Math.abs(this.b - Float.parseFloat(split[1]));
                        if (f2 != 0.0f || f / f2 > Math.tan(Math.toRadians(30.0d)) || (bVar = this.f) == null) {
                            return;
                        }
                        bVar.onViewDragToRight();
                        return;
                    }
                }
                f = 0.0f;
                f2 = 0.0f;
                if (f2 != 0.0f) {
                }
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.d = ((float) getHeight()) - motionEvent.getY() > ((float) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + qi.f(getContext(), R.dimen.tbds50)));
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
            if (this.e && this.d) {
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
            if (this.e && this.d) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setListener(oj5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
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
        this.d = true;
        this.g = new ArrayList();
        b(context);
    }
}

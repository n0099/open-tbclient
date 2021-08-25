package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DealEventView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f57628e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57629f;

    /* renamed from: g  reason: collision with root package name */
    public b f57630g;

    /* renamed from: h  reason: collision with root package name */
    public float f57631h;

    /* renamed from: i  reason: collision with root package name */
    public float f57632i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57633j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DealEventView f57634e;

        public a(DealEventView dealEventView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dealEventView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57634e = dealEventView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57634e.f57629f || !this.f57634e.f57633j || this.f57634e.f57630g == null) {
                return;
            }
            this.f57634e.f57630g.onViewClick();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onViewClick();

        void onViewDoubleClick();

        void onViewDragToRight();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DealEventView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f57631h = motionEvent.getX();
                this.f57632i = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f57628e < 300) {
                    this.f57629f = true;
                    b bVar2 = this.f57630g;
                    if (bVar2 != null) {
                        bVar2.onViewDoubleClick();
                    }
                } else {
                    this.f57629f = false;
                }
                this.f57628e = currentTimeMillis;
            } else if (action != 1) {
                if (action == 2 && this.f57631h - motionEvent.getX() > 60.0f && (this.f57631h - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.f57632i) && !this.f57629f && (bVar = this.f57630g) != null) {
                    bVar.onViewDragToRight();
                }
            } else {
                if (this.f57631h - motionEvent.getX() < 10.0f && this.f57632i - motionEvent.getY() < 10.0f) {
                    this.f57633j = true;
                } else {
                    this.f57633j = false;
                }
                postDelayed(new a(this), 300L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getTag() instanceof AnimatorSet) {
                    ((AnimatorSet) childAt.getTag()).cancel();
                }
            }
            super.removeAllViews();
        }
    }

    public void setOnViewClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f57630g = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DealEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DealEventView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d();
    }
}

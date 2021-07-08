package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EditorScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f19534e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19535f;

    /* renamed from: g  reason: collision with root package name */
    public int f19536g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f19537h;

    /* renamed from: i  reason: collision with root package name */
    public a f19538i;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c(EditorScrollView editorScrollView, int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorScrollView(Context context) {
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
        this.f19536g = 50;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onFinishInflate();
            if (getChildCount() > 0) {
                this.f19534e = getChildAt(0);
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.onOverScrolled(i2, i3, z, z2);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            a aVar3 = this.f19538i;
            if (aVar3 != null) {
                aVar3.c(this, i2, i3, i4, i5);
            }
            if (getHeight() + i3 >= this.f19534e.getHeight() && (aVar2 = this.f19538i) != null) {
                aVar2.a();
            }
            if ((i3 == 0 || getHeight() + i3 > this.f19534e.getHeight()) && (aVar = this.f19538i) != null) {
                aVar.b();
            }
            if (this.f19537h == null || !this.f19535f || Math.abs(i4 - i3) < this.f19536g) {
                return;
            }
            this.f19537h.onScrollChanged();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r0 != 3) goto L10;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                this.f19535f = false;
                return super.onTouchEvent(motionEvent);
            }
            this.f19535f = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onScrollChangedListener) == null) {
            this.f19537h = onScrollChangedListener;
        }
    }

    public void setOnScrollChangedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f19538i = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorScrollView(Context context, AttributeSet attributeSet) {
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
        this.f19536g = 50;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorScrollView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f19536g = 50;
    }
}

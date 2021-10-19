package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SwitchImageView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PRESSED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58419e;

    /* renamed from: f  reason: collision with root package name */
    public int f58420f;

    /* renamed from: g  reason: collision with root package name */
    public int f58421g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58422h;

    /* renamed from: i  reason: collision with root package name */
    public AbsSvgType f58423i;

    /* renamed from: j  reason: collision with root package name */
    public AbsSvgType f58424j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchImageView(Context context) {
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
        this.f58422h = false;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58419e = 0;
            this.f58420f = 0;
            this.f58421g = 0;
        }
    }

    public int getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58419e : invokeV.intValue;
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                this.f58419e = 0;
                if (this.f58422h) {
                    setImageDrawable(this.f58423i.getDrawable());
                } else {
                    setImageResource(this.f58420f);
                }
            } else if (i2 == 1) {
                this.f58419e = 1;
                if (this.f58422h) {
                    setImageDrawable(this.f58424j.getDrawable());
                } else {
                    setImageResource(this.f58421g);
                }
            }
        }
    }

    public void setStateImage(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f58420f = i2;
            this.f58421g = i3;
        }
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, absSvgType, absSvgType2) == null) {
            this.f58423i = absSvgType;
            this.f58424j = absSvgType2;
            this.f58422h = true;
        }
    }

    public void switchState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f58419e == 0) {
                this.f58419e = 1;
                setState(1);
                return;
            }
            this.f58419e = 0;
            setState(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f58422h = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f58422h = false;
        a();
    }
}

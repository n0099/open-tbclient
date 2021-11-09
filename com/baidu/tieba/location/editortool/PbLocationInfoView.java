package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.r0.l3.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbLocationInfoView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_RESULT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51291e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f51292f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoView(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51292f = new Rect(0, 0, getResources().getDimensionPixelSize(R.dimen.ds32), getResources().getDimensionPixelSize(R.dimen.ds32));
            setState(0, null);
            onChangeSkinType();
        }
    }

    public void changeIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f51291e == 1) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_posts_pin_loading_anim);
                if (drawable != null) {
                    drawable.setBounds(this.f51292f);
                }
                setCompoundDrawables(drawable, null, null, null);
                a.a((TbPageContextSupport) j.b(getContext()), (Animatable) drawable);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_tips_site);
            if (drawable2 != null) {
                drawable2.setBounds(this.f51292f);
            }
            setCompoundDrawables(drawable2, null, null, null);
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51291e : invokeV.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            changeIcon();
        }
    }

    public void setState(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            this.f51291e = i2;
            if (i2 == 1) {
                if (str == null) {
                    str = getResources().getString(R.string.location_loading);
                }
                setText(str);
            } else {
                if (str == null) {
                    str = getResources().getString(R.string.location_default);
                }
                setText(str);
            }
            changeIcon();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
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
        a();
    }
}

package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdMenuItem {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f58370a = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f58371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58372c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58373d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58374e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f58375f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f58376g;

    /* renamed from: h  reason: collision with root package name */
    public int f58377h;

    /* renamed from: i  reason: collision with root package name */
    public String f58378i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes10.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58372c = true;
        this.f58373d = false;
        this.f58374e = false;
        this.f58377h = 0;
        this.k = context;
        this.f58371b = i2;
        this.f58375f = charSequence;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Drawable drawable = this.f58376g;
            if (drawable != null) {
                return drawable;
            }
            if (this.f58377h != 0) {
                Drawable drawable2 = this.k.getResources().getDrawable(this.f58377h);
                this.f58377h = 0;
                this.f58376g = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58378i : (String) invokeV.objValue;
    }

    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58371b : invokeV.intValue;
    }

    public BdMenu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (BdMenu) invokeV.objValue;
    }

    public OnItemClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (OnItemClickListener) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58375f : (CharSequence) invokeV.objValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58373d : invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58372c : invokeV.booleanValue;
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f58373d = z;
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f58372c = z;
        }
    }

    public BdMenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, drawable)) == null) {
            this.f58377h = 0;
            this.f58376g = drawable;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public BdMenuItem setIconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f58377h = 0;
            this.f58378i = str;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public void setMenu(BdMenu bdMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdMenu) == null) {
            this.l = bdMenu;
        }
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            this.j = onItemClickListener;
        }
    }

    public void setShowTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f58374e = z;
        }
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            this.f58375f = charSequence;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public boolean showTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f58374e : invokeV.booleanValue;
    }

    public BdMenuItem setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f58375f = this.k.getResources().getText(i2, this.f58375f);
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f58376g = null;
            this.f58377h = i2;
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58372c = true;
        this.f58373d = false;
        this.f58374e = false;
        this.f58377h = 0;
        this.k = context;
        this.f58371b = i2;
        this.f58375f = charSequence;
        this.f58377h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, drawable};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58372c = true;
        this.f58373d = false;
        this.f58374e = false;
        this.f58377h = 0;
        this.k = context;
        this.f58371b = i2;
        this.f58375f = charSequence;
        this.f58376g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f58372c = true;
        this.f58373d = false;
        this.f58374e = false;
        this.f58377h = 0;
        this.k = context;
        this.f58371b = i2;
        this.f58375f = charSequence;
        this.f58378i = str;
    }
}

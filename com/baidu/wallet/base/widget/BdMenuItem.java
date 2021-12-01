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
/* loaded from: classes11.dex */
public class BdMenuItem {
    public static /* synthetic */ Interceptable $ic;
    public static final int a = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f52008b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52009c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52010d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52011e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f52012f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f52013g;

    /* renamed from: h  reason: collision with root package name */
    public int f52014h;

    /* renamed from: i  reason: collision with root package name */
    public String f52015i;

    /* renamed from: j  reason: collision with root package name */
    public OnItemClickListener f52016j;

    /* renamed from: k  reason: collision with root package name */
    public Context f52017k;
    public BdMenu l;

    /* loaded from: classes11.dex */
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
        this.f52009c = true;
        this.f52010d = false;
        this.f52011e = false;
        this.f52014h = 0;
        this.f52017k = context;
        this.f52008b = i2;
        this.f52012f = charSequence;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Drawable drawable = this.f52013g;
            if (drawable != null) {
                return drawable;
            }
            if (this.f52014h != 0) {
                Drawable drawable2 = this.f52017k.getResources().getDrawable(this.f52014h);
                this.f52014h = 0;
                this.f52013g = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52015i : (String) invokeV.objValue;
    }

    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52008b : invokeV.intValue;
    }

    public BdMenu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (BdMenu) invokeV.objValue;
    }

    public OnItemClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52016j : (OnItemClickListener) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52012f : (CharSequence) invokeV.objValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52010d : invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52009c : invokeV.booleanValue;
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f52010d = z;
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f52009c = z;
        }
    }

    public BdMenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, drawable)) == null) {
            this.f52014h = 0;
            this.f52013g = drawable;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public BdMenuItem setIconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f52014h = 0;
            this.f52015i = str;
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
            this.f52016j = onItemClickListener;
        }
    }

    public void setShowTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f52011e = z;
        }
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            this.f52012f = charSequence;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public boolean showTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f52011e : invokeV.booleanValue;
    }

    public BdMenuItem setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f52012f = this.f52017k.getResources().getText(i2, this.f52012f);
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f52013g = null;
            this.f52014h = i2;
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
        this.f52009c = true;
        this.f52010d = false;
        this.f52011e = false;
        this.f52014h = 0;
        this.f52017k = context;
        this.f52008b = i2;
        this.f52012f = charSequence;
        this.f52014h = i3;
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
        this.f52009c = true;
        this.f52010d = false;
        this.f52011e = false;
        this.f52014h = 0;
        this.f52017k = context;
        this.f52008b = i2;
        this.f52012f = charSequence;
        this.f52013g = drawable;
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
        this.f52009c = true;
        this.f52010d = false;
        this.f52011e = false;
        this.f52014h = 0;
        this.f52017k = context;
        this.f52008b = i2;
        this.f52012f = charSequence;
        this.f52015i = str;
    }
}

package com.baidu.tieba;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class vv extends Resources {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, hw<String, Integer>> d;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;
    public String b;
    public Resources c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320237, "Lcom/baidu/tieba/vv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320237, "Lcom/baidu/tieba/vv;");
                return;
            }
        }
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
        d = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, assetManager, displayMetrics, configuration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = resources;
        new HashMap();
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (!TextUtils.isEmpty(this.b) && !this.b.equals("com.baidu.browser.theme.default")) {
                try {
                    String resourceEntryName = this.c.getResourceEntryName(i);
                    String resourceTypeName = this.c.getResourceTypeName(i);
                    hw<String, Integer> hwVar = d.get(resourceTypeName);
                    if (hwVar == null) {
                        hwVar = new hw<>(100);
                        d.put(resourceTypeName, hwVar);
                    }
                    Integer c = hwVar.c(resourceEntryName);
                    if (c == null) {
                        c = Integer.valueOf(this.a.getIdentifier(resourceEntryName, resourceTypeName, this.b));
                        if (c.intValue() != 0) {
                            hwVar.d(resourceEntryName, c);
                        }
                    }
                    return c.intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getAnimation(a);
            }
            return this.c.getAnimation(i);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.c.getBoolean(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return getColor(i, null);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return getColorStateList(i, null);
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDimension(a);
            }
            return this.c.getDimension(i);
        }
        return invokeI.floatValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDimensionPixelOffset(a);
            }
            return this.c.getDimensionPixelOffset(i);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDimensionPixelSize(a);
            }
            return this.c.getDimensionPixelSize(i);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDrawable(a);
            }
            return this.c.getDrawable(i);
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getIntArray(a);
            }
            return this.c.getIntArray(i);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getInteger(a);
            }
            return this.c.getInteger(i);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getLayout(a);
            }
            return this.c.getLayout(i);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getMovie(a);
            }
            return this.c.getMovie(i);
        }
        return (Movie) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return this.c.getResourceEntryName(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            return this.c.getResourceName(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return this.c.getResourcePackageName(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            return this.c.getResourceTypeName(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getString(a);
            }
            return this.c.getString(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getStringArray(a);
            }
            return this.c.getStringArray(i);
        }
        return (String[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getText(a);
            }
            return this.c.getText(i);
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getTextArray(a);
            }
            return this.c.getTextArray(i);
        }
        return (CharSequence[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            return this.c.getXml(i);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            return this.c.obtainTypedArray(i);
        }
        return (TypedArray) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
            int a = a(i);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.c.openRawResource(i);
        }
        return (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
            int a = a(i);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a);
                    if (openRawResourceFd != null) {
                        return openRawResourceFd;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.c.openRawResourceFd(i);
        }
        return (AssetFileDescriptor) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, theme)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getColor(a);
            }
            return this.c.getColor(i);
        }
        return invokeIL.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, theme)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getColorStateList(a);
            }
            return this.c.getColorStateList(i);
        }
        return (ColorStateList) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, theme)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDrawable(a, null);
            }
            return this.c.getDrawable(i, theme);
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getDrawableForDensity(a, i2);
            }
            return this.c.getDrawableForDensity(i, i2);
        }
        return (Drawable) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getQuantityString(a, i2);
            }
            return this.c.getQuantityString(i, i2);
        }
        return (String) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getQuantityText(a, i2);
            }
            return this.c.getQuantityText(i, i2);
        }
        return (CharSequence) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i, objArr)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getString(a, objArr);
            }
            return this.c.getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i, charSequence)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getText(a, charSequence);
            }
            return this.c.getText(i, charSequence);
        }
        return (CharSequence) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, attributeSet, iArr)) == null) {
            return this.c.obtainAttributes(attributeSet, iArr);
        }
        return (TypedArray) invokeLL.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, typedValue)) == null) {
            int a = a(i);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a, typedValue);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.c.openRawResource(i, typedValue);
        }
        return (InputStream) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c.getConfiguration();
        }
        return (Configuration) invokeV.objValue;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i, i2, i3)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getFraction(a, i2, i3);
            }
            return this.c.getFraction(i, i2, i3);
        }
        return invokeIII.floatValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i, i2, objArr)) == null) {
            int a = a(i);
            if (a != 0) {
                return this.a.getQuantityString(a, i2, objArr);
            }
            return this.c.getQuantityString(i, i2, objArr);
        }
        return (String) invokeIIL.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048609, this, str, typedValue, z) == null) {
            this.c.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), typedValue, Boolean.valueOf(z)}) == null) {
            int a = a(i);
            if (a != 0) {
                this.a.getValue(a, typedValue, z);
            } else {
                this.c.getValue(i, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), typedValue, Boolean.valueOf(z)}) == null) {
            int a = a(i);
            if (a != 0) {
                this.a.getValueForDensity(a, i2, typedValue, z);
            } else {
                this.c.getValueForDensity(i, i2, typedValue, z);
            }
        }
    }
}

package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class DrawableDecoderCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile boolean shouldCallAppCompatResources = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1021568377, "Lcom/bumptech/glide/load/resource/drawable/DrawableDecoderCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1021568377, "Lcom/bumptech/glide/load/resource/drawable/DrawableDecoderCompat;");
        }
    }

    public DrawableDecoderCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, context2, i2)) == null) ? getDrawable(context, context2, i2, null) : (Drawable) invokeLLI.objValue;
    }

    public static Drawable loadDrawableV4(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, context, i2, theme)) == null) ? ResourcesCompat.getDrawable(context.getResources(), i2, theme) : (Drawable) invokeLIL.objValue;
    }

    public static Drawable loadDrawableV7(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, context, i2, theme)) == null) {
            if (theme != null) {
                context = new ContextThemeWrapper(context, theme);
            }
            return AppCompatResources.getDrawable(context, i2);
        }
        return (Drawable) invokeLIL.objValue;
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, context, i2, theme)) == null) ? getDrawable(context, context, i2, theme) : (Drawable) invokeLIL.objValue;
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, context2, i2, theme)) == null) {
            try {
                if (shouldCallAppCompatResources) {
                    return loadDrawableV7(context2, i2, theme);
                }
            } catch (Resources.NotFoundException unused) {
            } catch (IllegalStateException e2) {
                if (!context.getPackageName().equals(context2.getPackageName())) {
                    return ContextCompat.getDrawable(context2, i2);
                }
                throw e2;
            } catch (NoClassDefFoundError unused2) {
                shouldCallAppCompatResources = false;
            }
            if (theme == null) {
                theme = context2.getTheme();
            }
            return loadDrawableV4(context2, i2, theme);
        }
        return (Drawable) invokeLLIL.objValue;
    }
}

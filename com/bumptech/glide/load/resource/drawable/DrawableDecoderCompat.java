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
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, context, i, theme)) == null) {
            return getDrawable(context, context, i, theme);
        }
        return (Drawable) invokeLIL.objValue;
    }

    public static Drawable loadDrawableV4(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, context, i, theme)) == null) {
            return ResourcesCompat.getDrawable(context.getResources(), i, theme);
        }
        return (Drawable) invokeLIL.objValue;
    }

    public static Drawable loadDrawableV7(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, context, i, theme)) == null) {
            if (theme != null) {
                context = new ContextThemeWrapper(context, theme);
            }
            return AppCompatResources.getDrawable(context, i);
        }
        return (Drawable) invokeLIL.objValue;
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, context2, i)) == null) {
            return getDrawable(context, context2, i, null);
        }
        return (Drawable) invokeLLI.objValue;
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, context2, i, theme)) == null) {
            try {
                if (shouldCallAppCompatResources) {
                    return loadDrawableV7(context2, i, theme);
                }
            } catch (Resources.NotFoundException unused) {
            } catch (IllegalStateException e) {
                if (!context.getPackageName().equals(context2.getPackageName())) {
                    return ContextCompat.getDrawable(context2, i);
                }
                throw e;
            } catch (NoClassDefFoundError unused2) {
                shouldCallAppCompatResources = false;
            }
            if (theme == null) {
                theme = context2.getTheme();
            }
            return loadDrawableV4(context2, i, theme);
        }
        return (Drawable) invokeLLIL.objValue;
    }
}

package com.baidu.tieba;

import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class qg extends Resources {
    public static /* synthetic */ Interceptable $ic;
    public static final ColorStateList c;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448314967, "Lcom/baidu/tieba/qg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448314967, "Lcom/baidu/tieba/qg;");
                return;
            }
        }
        c = ColorStateList.valueOf(-16777216);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources};
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
        this.a = resources;
        this.b = false;
    }

    public final void a(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            try {
                str2 = this.a.getResourceEntryName(i);
            } catch (Exception unused) {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            try {
                BdStatisticsManager.getInstance().error("resources", str, null, -9115, null, "resid", Integer.valueOf(i), "resname", str2);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    return this.a.getColor(i);
                } catch (OutOfMemoryError e) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("color", i);
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    return this.a.getColorStateList(i);
                } catch (OutOfMemoryError e) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("colorstatelist", i);
            return c;
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    return this.a.getDrawable(i);
                } catch (OutOfMemoryError e) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a(ResourceManager.DRAWABLE, i);
            return null;
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    return this.a.getString(i);
                } catch (OutOfMemoryError e) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a(EMABTest.TYPE_STRING, i);
            return "";
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.a.openRawResource(i) : (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, typedValue)) == null) ? this.a.openRawResource(i, typedValue) : (InputStream) invokeIL.objValue;
    }
}

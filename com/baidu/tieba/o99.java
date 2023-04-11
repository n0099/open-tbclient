package com.baidu.tieba;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class o99 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public Point b;
    public Point c;
    public Point d;
    public Camera e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987226, "Lcom/baidu/tieba/o99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987226, "Lcom/baidu/tieba/o99;");
                return;
            }
        }
        f = Pattern.compile(",");
    }

    public Point e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (Point) invokeV.objValue;
    }

    public void i() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (camera = this.e) != null) {
            try {
                h(camera);
                j(this.e);
            } catch (Exception unused) {
            }
        }
    }

    public o99(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static boolean a(Camera camera) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, camera)) == null) {
            if (d(camera.getParameters().getSupportedFocusModes(), "auto") != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, camera) == null) {
            Camera.Parameters parameters = camera.getParameters();
            Point point = this.d;
            parameters.setPreviewSize(point.x, point.y);
            k(parameters);
            camera.setDisplayOrientation(f());
            camera.setParameters(parameters);
        }
    }

    public static int b(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i)) == null) {
            int i2 = 0;
            for (String str : f.split(charSequence)) {
                try {
                    double parseDouble = Double.parseDouble(str.trim());
                    int i3 = (int) (10.0d * parseDouble);
                    if (Math.abs(i - parseDouble) < Math.abs(i - i2)) {
                        i2 = i3;
                    }
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static Point c(List<Camera.Size> list, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, point)) == null) {
            Iterator<Camera.Size> it = list.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = Integer.MAX_VALUE;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                int i4 = next.width;
                int i5 = next.height;
                int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
                if (abs == 0) {
                    i2 = i5;
                    i = i4;
                    break;
                } else if (abs < i3) {
                    i2 = i5;
                    i = i4;
                    i3 = abs;
                }
            }
            if (i > 0 && i2 > 0) {
                return new Point(i, i2);
            }
            return null;
        }
        return (Point) invokeLL.objValue;
    }

    public static String d(Collection<String> collection, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, collection, strArr)) == null) {
            if (collection != null) {
                for (String str : strArr) {
                    if (collection.contains(str)) {
                        return str;
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static Point g(Camera.Parameters parameters, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, parameters, point)) == null) {
            Point c = c(parameters.getSupportedPreviewSizes(), point);
            if (c == null) {
                return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
            }
            return c;
        }
        return (Point) invokeLL.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i = 0;
            Camera.getCameraInfo(0, cameraInfo);
            int rotation = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            i = 270;
                        }
                    } else {
                        i = 180;
                    }
                } else {
                    i = 90;
                }
            }
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i) + 360) % 360;
        }
        return invokeV.intValue;
    }

    public void h(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, camera) == null) {
            this.e = camera;
            Camera.Parameters parameters = camera.getParameters();
            if (a(camera)) {
                parameters.setFocusMode("auto");
            }
            this.b = n99.d(this.a);
            Point point = new Point();
            Point point2 = this.b;
            point.x = point2.x;
            point.y = point2.y;
            int c = n99.c(this.a);
            if (c == 0) {
                Point point3 = this.b;
                point.x = point3.y;
                point.y = point3.x;
            }
            if (UtilHelper.isOppoFoldLargeScreen(this.a)) {
                this.d = new Point(1792, 1920);
            } else {
                this.d = g(parameters, point);
            }
            if (c == 0) {
                Point point4 = this.d;
                this.c = new Point(point4.y, point4.x);
                return;
            }
            this.c = this.d;
        }
    }

    public final void k(Camera.Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, parameters) == null) {
            String str = parameters.get("zoom-supported");
            if (str != null && !Boolean.parseBoolean(str)) {
                return;
            }
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = b(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}

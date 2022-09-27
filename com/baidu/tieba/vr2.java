package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class vr2 implements tr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public BitmapRegionDecoder a;
    public final Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948250323, "Lcom/baidu/tieba/vr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948250323, "Lcom/baidu/tieba/vr2;");
                return;
            }
        }
        c = vj1.a;
    }

    public vr2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Object();
    }

    @Override // com.baidu.tieba.tr2
    public Point a(Context context, Bitmap bitmap) throws Exception {
        InputStream inputStream;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, context, bitmap)) != null) {
            return (Point) invokeLL.objValue;
        }
        try {
            inputStream = b(bitmap);
            try {
                this.a = BitmapRegionDecoder.newInstance(inputStream, false);
                pj4.d(inputStream);
                return new Point(this.a.getWidth(), this.a.getHeight());
            } catch (Throwable th) {
                th = th;
                pj4.d(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public InputStream b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            if (bitmap.hasAlpha()) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tr2
    @SuppressLint({"BDThrowableCheck"})
    public Bitmap decodeRegion(Rect rect, int i) {
        InterceptResult invokeLI;
        Bitmap decodeRegion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, rect, i)) == null) {
            synchronized (this.b) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeRegion = this.a.decodeRegion(rect, options);
                if (decodeRegion == null) {
                    if (!c) {
                        l02.k("SkiaImageRegionDecoder", "bitmap is null");
                    } else {
                        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                    }
                }
            }
            return decodeRegion;
        }
        return (Bitmap) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.tr2
    public Point init(Context context, Uri uri) throws Exception {
        InterceptResult invokeLL;
        Resources resourcesForApplication;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, uri)) == null) {
            String uri2 = uri.toString();
            if (uri2.startsWith("android.resource://")) {
                String authority = uri.getAuthority();
                if (context.getPackageName().equals(authority)) {
                    resourcesForApplication = context.getResources();
                } else {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                }
                List<String> pathSegments = uri.getPathSegments();
                int size = pathSegments.size();
                if (size == 2 && pathSegments.get(0).equals(ResourceManager.DRAWABLE)) {
                    i = resourcesForApplication.getIdentifier(pathSegments.get(1), ResourceManager.DRAWABLE, authority);
                } else {
                    if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    i = 0;
                }
                this.a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
            } else if (uri2.startsWith("file:///android_asset/")) {
                this.a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
            } else if (uri2.startsWith("file://")) {
                this.a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
            } else {
                InputStream inputStream = null;
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    this.a = BitmapRegionDecoder.newInstance(inputStream, false);
                } finally {
                    pj4.d(inputStream);
                }
            }
            return new Point(this.a.getWidth(), this.a.getHeight());
        }
        return (Point) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tr2
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BitmapRegionDecoder bitmapRegionDecoder = this.a;
            return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tr2
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.recycle();
        }
    }
}

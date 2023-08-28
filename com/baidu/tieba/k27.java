package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.tieba.heb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.RecordConstants;
/* loaded from: classes6.dex */
public abstract class k27 implements n27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q27 a;
    public o27 b;
    public Thread c;
    public boolean d;

    public abstract void f();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k27 a;

        public a(k27 k27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k27Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public k27() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
    }

    @Override // com.baidu.tieba.n27
    public void a(q27 q27Var, o27 o27Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, q27Var, o27Var) != null) || o27Var == null) {
            return;
        }
        this.b = o27Var;
        if (q27Var == null) {
            o27Var.onError(StringUtil.NULL_STRING, "cover config is null !!");
            return;
        }
        this.a = q27Var;
        this.c = new Thread(new a(this));
        ThreadPool.b().e(this.c);
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q27 q27Var = this.a;
            int[] iArr = {q27Var.a, q27Var.b};
            if (!q27Var.g && !q27Var.e) {
                float f = q27Var.d;
                if (f != 0.0f) {
                    heb.a e = heb.e(f, RecordConstants.VIDEO_CONSTANT_WIDTH);
                    iArr[0] = e.b();
                    iArr[1] = e.a();
                }
            } else {
                heb.a e2 = e();
                float f2 = this.a.d;
                if (f2 != 0.0f) {
                    heb.a f3 = heb.f(f2, e2.b(), e2.a());
                    iArr[0] = f3.b();
                    iArr[1] = f3.a();
                }
                heb.a d = heb.d(iArr[0], iArr[1]);
                iArr[0] = d.b();
                iArr[1] = d.a();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public Bitmap c(Bitmap bitmap, float f, MultiMediaData multiMediaData) {
        InterceptResult invokeCommon;
        Bitmap bitmap2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Float.valueOf(f), multiMediaData})) == null) {
            if (multiMediaData != null && ((i2 = 360 - (((int) multiMediaData.angle) % 360)) == 90 || i2 == 270)) {
                Matrix matrix = new Matrix();
                matrix.setRotate(i2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                bitmap2 = null;
            }
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (bitmap.getHeight() / bitmap.getWidth() > f) {
                width = (int) (bitmap.getHeight() * f);
            } else {
                height = (int) (bitmap.getWidth() * f);
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.save();
            int i3 = 0;
            if (height != bitmap.getHeight()) {
                i = Math.abs(height - bitmap.getHeight()) / 2;
            } else {
                i = 0;
            }
            if (width != bitmap.getWidth()) {
                i3 = Math.abs(width - bitmap.getWidth()) / 2;
            }
            canvas.drawBitmap(bitmap, i3, i, (Paint) null);
            canvas.restore();
            bitmap.recycle();
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public String d(int i, int i2, Bitmap bitmap, boolean z) {
        InterceptResult invokeCommon;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bitmap, Boolean.valueOf(z)})) == null) {
            if (i != 0 && i2 != 0) {
                Bitmap h = bgb.h(bitmap, i, i2, z);
                if (this.d) {
                    a2 = mwa.b();
                } else {
                    a2 = mwa.a();
                }
                String c = mwa.c(a2, h, System.currentTimeMillis() + ".jpg");
                if (h != null) {
                    h.recycle();
                    return c;
                }
                return c;
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public heb.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MultiMediaData multiMediaData = this.a.c;
            int i = RecordConstants.VIDEO_CONSTANT_WIDTH;
            int i2 = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            if (multiMediaData == null) {
                return new heb.a(i, i2);
            }
            if (multiMediaData.type == 1) {
                float f = multiMediaData.angle;
                float f2 = multiMediaData.rotation;
                if ((f + f2) % 360.0f != 90.0f && (f + f2) % 360.0f != 270.0f) {
                    i = multiMediaData.width;
                    i2 = multiMediaData.height;
                } else {
                    i = multiMediaData.height;
                    i2 = multiMediaData.width;
                }
            }
            return new heb.a(i, i2);
        }
        return (heb.a) invokeV.objValue;
    }

    public void g(p27 p27Var, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, p27Var, bitmap) == null) {
            if (p27Var == null) {
                p27Var = new p27();
            }
            int[] b = b();
            p27Var.a = d(b[0], b[1], bitmap, true);
            this.b.a(this.a.f, p27Var);
        }
    }
}

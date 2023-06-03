package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n52 extends e52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public String b;
    public Matrix c;

    @Override // com.baidu.tieba.e52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947953374, "Lcom/baidu/tieba/n52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947953374, "Lcom/baidu/tieba/n52;");
                return;
            }
        }
        d = is1.a;
    }

    public n52(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = str;
    }

    @Override // com.baidu.tieba.e52
    public void a(f52 f52Var, Canvas canvas) {
        Bitmap bitmap;
        Matrix matrix;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, f52Var, canvas) == null) && (bitmap = this.a) != null && (matrix = this.c) != null) {
            canvas.drawBitmap(bitmap, matrix, f52Var.d);
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                int g = pp3.g((float) jSONObject.optDouble("x"));
                int g2 = pp3.g((float) jSONObject.optDouble("y"));
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                if (optInt > 0 && optInt2 > 0) {
                    float g3 = pp3.g(optInt);
                    float g4 = pp3.g(optInt2);
                    String optString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(optString)) {
                        return 2001;
                    }
                    try {
                        byte[] decode = Base64.decode(optString, 2);
                        int i = optInt * optInt2 * 4;
                        if (decode != null && decode.length == i) {
                            this.a = e(d(decode, optInt, optInt2), g3, g4);
                            Matrix matrix = new Matrix();
                            this.c = matrix;
                            matrix.postTranslate(g, g2);
                            return 0;
                        }
                        return 2001;
                    } catch (Exception e) {
                        if (d) {
                            e.printStackTrace();
                        }
                        y82.c("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                        return 1001;
                    }
                }
                return 2002;
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeV.intValue;
    }

    @NonNull
    public final Bitmap d(@NonNull byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            int i3 = i * i2;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * 4;
                iArr[i4] = Color.argb(bArr[i5 + 3] & 255, bArr[i5] & 255, bArr[i5 + 1] & 255, bArr[i5 + 2] & 255);
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @NonNull
    public final Bitmap e(@NonNull Bitmap bitmap, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bitmap, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Matrix matrix = new Matrix();
            matrix.postScale(f / bitmap.getWidth(), f2 / bitmap.getHeight());
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeCommon.objValue;
    }
}

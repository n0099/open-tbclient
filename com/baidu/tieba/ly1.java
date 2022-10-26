package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ly1 extends jy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public int l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly1(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.k = dh3.g((float) jSONObject.optDouble("x"));
            this.l = dh3.g((float) jSONObject.optDouble("y"));
            this.m = dh3.g((float) jSONObject.optDouble("width"));
            this.n = dh3.g((float) jSONObject.optDouble("height"));
        } catch (Exception e) {
            m02.d("canvasGetImageData", "CanvasGetImageData meets json exception", e);
        }
    }

    public final byte[] h(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] bArr = new byte[i * 4];
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                int i4 = i2 * 4;
                bArr[i4] = (byte) Color.red(i3);
                bArr[i4 + 1] = (byte) Color.green(i3);
                bArr[i4 + 2] = (byte) Color.blue(i3);
                bArr[i4 + 3] = (byte) Color.alpha(i3);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public JSONObject i(View view2) {
        InterceptResult invokeL;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            int i2 = 0;
            if (measuredWidth > 0 && measuredHeight > 0) {
                int i3 = this.k;
                this.k = (i3 < 0 || i3 >= measuredWidth) ? 0 : 0;
                int i4 = this.l;
                this.l = (i4 < 0 || i4 >= measuredHeight) ? 0 : 0;
                int i5 = this.m;
                if (i5 <= 0 || this.k + i5 > measuredWidth) {
                    i5 = measuredWidth - this.k;
                }
                this.m = i5;
                int i6 = this.n;
                if (i6 <= 0 || this.l + i6 > measuredHeight) {
                    i6 = measuredHeight - this.l;
                }
                this.n = i6;
                Bitmap createBitmap = Bitmap.createBitmap(this.m, i6, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.translate(-this.k, -this.l);
                view2.draw(canvas);
                Bitmap j = j(createBitmap);
                str = Base64.encodeToString(h(j), 2);
                i2 = j.getWidth();
                i = j.getHeight();
            } else {
                m02.b("canvasGetImageData", "canvas size is invalid.");
                str = "";
                i = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i2);
                jSONObject.put("height", i);
                jSONObject.put("data", str);
            } catch (Exception e) {
                m02.d("canvasGetImageData", "CanvasGetImageData meets json exception", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final Bitmap j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
            float l = 1.0f / dh3.l(tm2.c());
            Matrix matrix = new Matrix();
            matrix.postScale(l, l);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }
}

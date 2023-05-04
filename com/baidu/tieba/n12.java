package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class n12 extends d12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Rect d;
    public Rect e;
    public Bitmap f;
    public int g;
    public Uri h;
    public String i;

    /* loaded from: classes5.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ e12 b;
        public final /* synthetic */ n12 c;

        public a(n12 n12Var, DataSource dataSource, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n12Var, dataSource, e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n12Var;
            this.a = dataSource;
            this.b = e12Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.c.g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.a.isFinished() && bitmap != null) {
                    this.c.f = Bitmap.createBitmap(bitmap);
                    this.a.close();
                    CanvasView canvasView = this.b.h;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.c.g = 2;
            }
        }
    }

    public n12() {
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
        this.g = 0;
    }

    public final int i(JSONArray jSONArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i)) == null) {
            return ol3.g((float) jSONArray.optDouble(i));
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.d12
    public void a(e12 e12Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, e12Var, canvas) == null) {
            if (h(e12Var)) {
                int alpha = e12Var.d.getAlpha();
                e12Var.c(e12Var.d);
                Rect rect = this.e;
                if (rect != null) {
                    canvas.drawBitmap(this.f, this.d, rect, e12Var.d);
                } else {
                    canvas.drawBitmap(this.f, this.b, this.c, e12Var.d);
                }
                e12Var.d.setAlpha(alpha);
                return;
            }
            try {
                j(e12Var);
            } catch (Exception e) {
                if (ho1.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String g(String str, x73 x73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, x73Var)) == null) {
            if (!TextUtils.isEmpty(str) && x73Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = ff3.M(str, x73Var.b);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        return file.getAbsolutePath();
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d12
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            x73 b0 = x73.b0();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.i = this.a;
                    String optString = jSONArray.optString(0);
                    this.a = optString;
                    this.a = f(b0, optString);
                }
                if (length > 2) {
                    this.b = i(jSONArray, 1);
                    this.c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i = this.b;
                    int i2 = this.c;
                    int i3 = i(jSONArray, 3);
                    int i4 = i(jSONArray, 4);
                    if (i3 > 0 && i4 > 0) {
                        this.e = new Rect(i, i2, i3 + i, i4 + i2);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (b0 != null) {
                    String g = g(this.a, b0);
                    if (!TextUtils.isEmpty(g)) {
                        this.f = BitmapFactory.decodeFile(g);
                    } else if (!TextUtils.isEmpty(this.a)) {
                        if (this.h == null || !TextUtils.equals(this.a, this.i)) {
                            this.h = Uri.parse(this.a);
                        }
                    }
                }
            } catch (Exception e) {
                if (ho1.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) && hashMap != null && !TextUtils.isEmpty(this.a) && this.f != null && !hashMap.containsKey(this.a)) {
            hashMap.put(this.a, this.f);
        }
    }

    public final String f(x73 x73Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, x73Var, str)) == null) {
            if (!TextUtils.isEmpty(str) && x73Var != null) {
                try {
                    if (!"bdfile".equalsIgnoreCase(URI.create(str).getScheme()) && !str.startsWith(rl3.x(x73Var).getPath())) {
                        return rl3.w(x73Var, str);
                    }
                    return str;
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final boolean h(e12 e12Var) {
        InterceptResult invokeL;
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e12Var)) == null) {
            if (this.f != null) {
                return true;
            }
            if (this.h == null || e12Var == null || (canvasView = e12Var.h) == null) {
                return false;
            }
            Bitmap e = canvasView.e(this.a);
            this.f = e;
            if (e != null) {
                return true;
            }
            Bitmap c = uk3.c(this.h, e12Var.h.getContext());
            this.f = c;
            if (c != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public final void j(e12 e12Var) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, e12Var) == null) && this.g == 0 && (canvasView = e12Var.h) != null && canvasView.getContext() != null && !TextUtils.isEmpty(this.a)) {
            this.g = 1;
            DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.a)).build(), e12Var.h.getContext());
            fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, e12Var), UiThreadImmediateExecutorService.getInstance());
        }
    }
}

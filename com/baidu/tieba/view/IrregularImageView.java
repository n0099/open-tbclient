package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class IrregularImageView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public final BdResourceCallback<BdImage> c;

    /* loaded from: classes8.dex */
    public class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IrregularImageView a;

        public a(IrregularImageView irregularImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {irregularImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = irregularImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                if (bdImage == null) {
                    if (this.a.b != 0) {
                        Bitmap bitmap = null;
                        try {
                            bitmap = BitmapFactory.decodeResource(this.a.getResources(), this.a.b);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (bitmap != null) {
                            IrregularImageView irregularImageView = this.a;
                            irregularImageView.setImage(bitmap, irregularImageView.a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.setImage(bdImage.getRawBitmap(), this.a.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IrregularImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IrregularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IrregularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    public void setErrorRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b = i;
        }
    }

    public final Bitmap A(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) {
            if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && i != 0 && i2 != 0) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f2 = i * 1.0f;
                float f3 = i2;
                float f4 = width;
                float f5 = height;
                if (f2 / f3 > (f4 * 1.0f) / f5) {
                    f = f2 / f4;
                    int i7 = (int) ((f3 * 1.0f) / f);
                    i4 = i7;
                    i3 = width;
                    i5 = (height - i7) / 2;
                    i6 = 0;
                } else {
                    float f6 = (f3 * 1.0f) / f5;
                    int i8 = (int) (f2 / f6);
                    i3 = i8;
                    f = f6;
                    i4 = height;
                    i5 = 0;
                    i6 = (width - i8) / 2;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
            }
            return null;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public void setImage(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bitmap, i) != null) || bitmap == null) {
            return;
        }
        try {
            bitmap2 = BitmapFactory.decodeResource(getResources(), i);
            try {
                bitmap3 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
                try {
                    bitmap4 = A(bitmap, bitmap2.getWidth(), bitmap2.getHeight());
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    bitmap4 = null;
                    if (bitmap2 == null) {
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmap3 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap2 = null;
            bitmap3 = null;
        }
        if (bitmap2 == null && bitmap3 != null && bitmap4 != null) {
            Canvas canvas = new Canvas(bitmap3);
            Paint paint = new Paint(1);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmap4, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            paint.setXfermode(null);
            setImageBitmap(bitmap3);
        }
    }

    public void setImage(String str, BdUniqueId bdUniqueId, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, str, bdUniqueId, i) == null) {
            this.a = i;
            BdResourceLoader.getInstance().loadResource(str, 10, this.c, 0, 0, bdUniqueId, new Object[0]);
        }
    }
}

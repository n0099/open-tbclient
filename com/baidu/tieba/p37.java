package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.io.IOException;
/* loaded from: classes7.dex */
public class p37 extends o37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p37(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = z;
    }

    public final int j(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException unused) {
                exifInterface = null;
            }
            if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt == 8) {
                            return 270;
                        }
                    } else {
                        return 90;
                    }
                } else {
                    return 180;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public Bitmap k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            u37 u37Var = this.a;
            Bitmap i = i(str, u37Var.a, u37Var.b);
            if (i == null) {
                return null;
            }
            int j = j(str);
            Matrix matrix = new Matrix();
            matrix.setRotate(j);
            return Bitmap.createBitmap(i, 0, 0, i.getWidth(), i.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int h(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 <= i2 && i4 <= i) {
                return 1;
            }
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            if (round >= round2) {
                round = round2;
            }
            if (round >= 3) {
                if (round < 6.5d) {
                    return 4;
                }
                if (round < 8) {
                    return 8;
                }
            }
            return round;
        }
        return invokeLII.intValue;
    }

    public static Bitmap i(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = h(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeLII.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:39:0x005f). Please submit an issue!!! */
    @Override // com.baidu.tieba.o37
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u37 u37Var = this.a;
            if (u37Var.e) {
                this.b.onError(u37Var.f, "is cartoon style !!");
                return;
            }
            MultiMediaData multiMediaData = u37Var.c;
            if (multiMediaData != null && !TextUtils.isEmpty(multiMediaData.path)) {
                String str = multiMediaData.path;
                if (multiMediaData.type == 1) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(multiMediaData.start * 1000);
                            if (this.a.d != 0.0f) {
                                g(new t37(), c(frameAtTime, this.a.d, multiMediaData));
                            } else {
                                g(new t37(), frameAtTime);
                            }
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (Exception unused) {
                        }
                        return;
                    } finally {
                        mediaMetadataRetriever.release();
                    }
                }
                Bitmap k = k(str);
                if (k != null) {
                    g(new t37(), k);
                    return;
                }
                return;
            }
            this.b.onError(this.a.f, "multiMediaData is null !!");
        }
    }
}

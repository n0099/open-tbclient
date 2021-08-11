package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.Div;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public class BitmapType {
    public static final /* synthetic */ BitmapType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BitmapType NULL;
    public static final BitmapType NinePatch;
    public static final BitmapType PlainImage;
    public static final BitmapType RawNinePatch;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(40997543, "Lcom/baidu/ugc/editvideo/subtitle/ninepatchchunk/BitmapType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(40997543, "Lcom/baidu/ugc/editvideo/subtitle/ninepatchchunk/BitmapType;");
                return;
            }
        }
        NinePatch = new BitmapType("NinePatch", 0) { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
            public NinePatchChunk createChunk(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bitmap)) == null) ? NinePatchChunk.parse(bitmap.getNinePatchChunk()) : (NinePatchChunk) invokeL.objValue;
            }
        };
        RawNinePatch = new BitmapType("RawNinePatch", 1) { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            private void recalculateDivs(float f2, ArrayList<Div> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), arrayList}) == null) {
                    Iterator<Div> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Div next = it.next();
                        next.start = Math.round(next.start * f2);
                        next.stop = Math.round(next.stop * f2);
                    }
                }
            }

            @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
            public NinePatchChunk createChunk(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bitmap)) == null) {
                    try {
                        return NinePatchChunk.createChunkFromRawBitmap(bitmap, false);
                    } catch (DivLengthException unused) {
                        return NinePatchChunk.createEmptyChunk();
                    } catch (WrongPaddingException unused2) {
                        return NinePatchChunk.createEmptyChunk();
                    }
                }
                return (NinePatchChunk) invokeL.objValue;
            }

            @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
            public Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resources, bitmap, ninePatchChunk)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
                    int i2 = resources.getDisplayMetrics().densityDpi;
                    float density = i2 / bitmap.getDensity();
                    if (density != 1.0f) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, Math.round(createBitmap.getWidth() * density), Math.round(createBitmap.getHeight() * density), true);
                        createScaledBitmap.setDensity(i2);
                        ninePatchChunk.padding = new Rect(Math.round(ninePatchChunk.padding.left * density), Math.round(ninePatchChunk.padding.top * density), Math.round(ninePatchChunk.padding.right * density), Math.round(ninePatchChunk.padding.bottom * density));
                        recalculateDivs(density, ninePatchChunk.xDivs);
                        recalculateDivs(density, ninePatchChunk.yDivs);
                        return createScaledBitmap;
                    }
                    return createBitmap;
                }
                return (Bitmap) invokeLLL.objValue;
            }
        };
        PlainImage = new BitmapType("PlainImage", 2) { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
            public NinePatchChunk createChunk(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bitmap)) == null) ? NinePatchChunk.createEmptyChunk() : (NinePatchChunk) invokeL.objValue;
            }
        };
        BitmapType bitmapType = new BitmapType("NULL", 3) { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
            public NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, resources, bitmap, str)) == null) {
                    return null;
                }
                return (NinePatchDrawable) invokeLLL.objValue;
            }
        };
        NULL = bitmapType;
        $VALUES = new BitmapType[]{NinePatch, RawNinePatch, PlainImage, bitmapType};
    }

    public BitmapType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BitmapType determineBitmapType(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            if (bitmap == null) {
                return NULL;
            }
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            return (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) ? NinePatchChunk.isRawNinePatchBitmap(bitmap) ? RawNinePatch : PlainImage : NinePatch;
        }
        return (BitmapType) invokeL.objValue;
    }

    public static NinePatchDrawable getNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, bitmap, str)) == null) ? determineBitmapType(bitmap).createNinePatchDrawable(resources, bitmap, str) : (NinePatchDrawable) invokeLLL.objValue;
    }

    public static BitmapType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (BitmapType) Enum.valueOf(BitmapType.class, str) : (BitmapType) invokeL.objValue;
    }

    public static BitmapType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (BitmapType[]) $VALUES.clone() : (BitmapType[]) invokeV.objValue;
    }

    public NinePatchChunk createChunk(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) ? NinePatchChunk.createEmptyChunk() : (NinePatchChunk) invokeL.objValue;
    }

    public NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resources, bitmap, str)) == null) {
            NinePatchChunk createChunk = createChunk(bitmap);
            return new NinePatchDrawable(resources, modifyBitmap(resources, bitmap, createChunk), createChunk.toBytes(), createChunk.padding, str);
        }
        return (NinePatchDrawable) invokeLLL.objValue;
    }

    public Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, resources, bitmap, ninePatchChunk)) == null) ? bitmap : (Bitmap) invokeLLL.objValue;
    }
}

package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.Div;
import d.a.v0.t.c;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class NinePatchChunk implements Externalizable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DENSITY = 160;
    public static final int NO_COLOR = 1;
    public static final int TRANSPARENT_COLOR = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] colors;
    public Rect padding;
    public boolean wasSerialized;
    public ArrayList<Div> xDivs;
    public ArrayList<Div> yDivs;

    public NinePatchChunk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wasSerialized = true;
        this.padding = new Rect();
    }

    public static void checkDivCount(byte b2) throws DivLengthException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(65537, null, b2) == null) {
            if (b2 == 0 || (b2 & 1) != 0) {
                throw new DivLengthException("Div count should be aliquot 2 and more then 0, but was: " + ((int) b2));
            }
        }
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, Bitmap bitmap, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, bitmap, str)) == null) ? BitmapType.getNinePatchDrawable(context.getResources(), bitmap, str) : (NinePatchDrawable) invokeLLL.objValue;
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, int i2, String str) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, context, inputStream, i2, str)) == null) ? createChunkFromRawBitmap(context, inputStream, i2).getNinePatchDrawable(context.getResources(), str) : (NinePatchDrawable) invokeLLIL.objValue;
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, inputStream, str)) == null) ? create9PatchDrawable(context, inputStream, 160, str) : (NinePatchDrawable) invokeLLL.objValue;
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, bitmap)) == null) {
            BitmapType determineBitmapType = BitmapType.determineBitmapType(bitmap);
            NinePatchChunk createChunk = determineBitmapType.createChunk(bitmap);
            return new ImageLoadingResult(determineBitmapType.modifyBitmap(context.getResources(), bitmap, createChunk), createChunk);
        }
        return (ImageLoadingResult) invokeLL.objValue;
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, inputStream)) == null) ? createChunkFromRawBitmap(context, inputStream, 160) : (ImageLoadingResult) invokeLL.objValue;
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, context, inputStream, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = i2;
            options.inTargetDensity = i2;
            return createChunkFromRawBitmap(context, BitmapFactory.decodeStream(inputStream, new Rect(), options));
        }
        return (ImageLoadingResult) invokeLLI.objValue;
    }

    public static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bitmap)) == null) {
            try {
                return createChunkFromRawBitmap(bitmap, true);
            } catch (RuntimeException unused) {
                return createEmptyChunk();
            }
        }
        return (NinePatchChunk) invokeL.objValue;
    }

    public static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap, boolean z) throws WrongPaddingException, DivLengthException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, bitmap, z)) == null) {
            if (!z || isRawNinePatchBitmap(bitmap)) {
                NinePatchChunk ninePatchChunk = new NinePatchChunk();
                setupStretchableRegions(bitmap, ninePatchChunk);
                setupPadding(bitmap, ninePatchChunk);
                setupColors(bitmap, ninePatchChunk);
                return ninePatchChunk;
            }
            return createEmptyChunk();
        }
        return (NinePatchChunk) invokeLZ.objValue;
    }

    public static void createColors(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bitmap, ninePatchChunk) == null) {
            ArrayList<Div> regions = getRegions(ninePatchChunk.xDivs, bitmap.getWidth() - 2);
            ArrayList<Div> regions2 = getRegions(ninePatchChunk.yDivs, bitmap.getHeight() - 2);
            ninePatchChunk.colors = new int[regions.size() * regions2.size()];
            Iterator<Div> it = regions2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Div next = it.next();
                Iterator<Div> it2 = regions.iterator();
                while (it2.hasNext()) {
                    Div next2 = it2.next();
                    int i3 = next2.start + 1;
                    int i4 = next.start + 1;
                    if (hasSameColor(bitmap, i3, next2.stop + 1, i4, next.stop + 1)) {
                        int pixel = bitmap.getPixel(i3, i4);
                        if (isTransparent(pixel)) {
                            pixel = 0;
                        }
                        ninePatchChunk.colors[i2] = pixel;
                    } else {
                        ninePatchChunk.colors[i2] = 1;
                    }
                    i2++;
                }
            }
        }
    }

    public static int[] createColorsArray(NinePatchChunk ninePatchChunk, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, ninePatchChunk, i2, i3)) == null) {
            if (ninePatchChunk == null) {
                return new int[0];
            }
            int[] iArr = new int[getRegions(ninePatchChunk.xDivs, i2).size() * getRegions(ninePatchChunk.yDivs, i3).size()];
            Arrays.fill(iArr, 1);
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    public static void createColorsArrayAndSet(NinePatchChunk ninePatchChunk, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65548, null, ninePatchChunk, i2, i3) == null) {
            int[] createColorsArray = createColorsArray(ninePatchChunk, i2, i3);
            if (ninePatchChunk != null) {
                ninePatchChunk.colors = createColorsArray;
            }
        }
    }

    public static NinePatchChunk createEmptyChunk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            NinePatchChunk ninePatchChunk = new NinePatchChunk();
            ninePatchChunk.colors = new int[0];
            ninePatchChunk.padding = new Rect();
            ninePatchChunk.yDivs = new ArrayList<>();
            ninePatchChunk.xDivs = new ArrayList<>();
            return ninePatchChunk;
        }
        return (NinePatchChunk) invokeV.objValue;
    }

    public static ArrayList<Div> getRegions(ArrayList<Div> arrayList, int i2) {
        InterceptResult invokeLI;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, arrayList, i2)) == null) {
            ArrayList<Div> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    Div div = arrayList.get(i5);
                    if (i5 == 0 && (i4 = div.start) != 0) {
                        arrayList2.add(new Div(0, i4 - 1));
                    }
                    if (i5 > 0) {
                        arrayList2.add(new Div(arrayList.get(i5 - 1).stop, div.start - 1));
                    }
                    arrayList2.add(new Div(div.start, div.stop - 1));
                    if (i5 == arrayList.size() - 1 && (i3 = div.stop) < i2) {
                        arrayList2.add(new Div(i3, i2 - 1));
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public static ArrayList<Div> getXDivs(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, bitmap, i2)) == null) {
            ArrayList<Div> arrayList = new ArrayList<>();
            Div div = null;
            for (int i3 = 1; i3 < bitmap.getWidth(); i3++) {
                div = processChunk(bitmap.getPixel(i3, i2), div, i3 - 1, arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public static ArrayList<Div> getYDivs(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, bitmap, i2)) == null) {
            ArrayList<Div> arrayList = new ArrayList<>();
            Div div = null;
            for (int i3 = 1; i3 < bitmap.getHeight(); i3++) {
                div = processChunk(bitmap.getPixel(i2, i3), div, i3 - 1, arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public static boolean hasNinePatchBorder(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bitmap)) == null) {
            int width = bitmap.getWidth() - 1;
            int height = bitmap.getHeight() - 1;
            for (int i2 = 1; i2 < width; i2++) {
                if (!isBorderPixel(bitmap.getPixel(i2, 0)) || !isBorderPixel(bitmap.getPixel(i2, height))) {
                    return false;
                }
            }
            for (int i3 = 1; i3 < height; i3++) {
                if (!isBorderPixel(bitmap.getPixel(0, i3)) || !isBorderPixel(bitmap.getPixel(width, i3))) {
                    return false;
                }
            }
            return getXDivs(bitmap, 0).size() != 0 && getXDivs(bitmap, height).size() <= 1 && getYDivs(bitmap, 0).size() != 0 && getYDivs(bitmap, width).size() <= 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasSameColor(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            try {
                int pixel = bitmap.getPixel(i2, i4);
                while (i2 <= i3) {
                    for (int i6 = i4; i6 <= i5; i6++) {
                        if (pixel != bitmap.getPixel(i2, i6)) {
                            return false;
                        }
                    }
                    i2++;
                }
                return true;
            } catch (Exception e2) {
                c.g(e2);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isBlack(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? i2 == -16777216 : invokeI.booleanValue;
    }

    public static boolean isBorderPixel(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) ? isTransparent(i2) || isBlack(i2) : invokeI.booleanValue;
    }

    public static boolean isCornerPixelsAreTrasperent(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bitmap)) == null) {
            int height = bitmap.getHeight() - 1;
            int width = bitmap.getWidth() - 1;
            return isTransparent(bitmap.getPixel(0, 0)) && isTransparent(bitmap.getPixel(0, height)) && isTransparent(bitmap.getPixel(width, 0)) && isTransparent(bitmap.getPixel(width, height));
        }
        return invokeL.booleanValue;
    }

    public static boolean isRawNinePatchBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bitmap)) == null) ? bitmap != null && bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3 && isCornerPixelsAreTrasperent(bitmap) && hasNinePatchBorder(bitmap) : invokeL.booleanValue;
    }

    public static boolean isTransparent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i2)) == null) ? Color.alpha(i2) == 0 : invokeI.booleanValue;
    }

    public static NinePatchChunk parse(byte[] bArr) throws DivLengthException, ChunkNotSerializedException, BufferUnderflowException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65560, null, bArr)) != null) {
            return (NinePatchChunk) invokeL.objValue;
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        NinePatchChunk ninePatchChunk = new NinePatchChunk();
        int i2 = 0;
        boolean z = order.get() != 0;
        ninePatchChunk.wasSerialized = z;
        if (!z) {
            throw new ChunkNotSerializedException();
        }
        byte b2 = order.get();
        checkDivCount(b2);
        byte b3 = order.get();
        checkDivCount(b3);
        ninePatchChunk.colors = new int[order.get()];
        order.getInt();
        order.getInt();
        ninePatchChunk.padding.left = order.getInt();
        ninePatchChunk.padding.right = order.getInt();
        ninePatchChunk.padding.top = order.getInt();
        ninePatchChunk.padding.bottom = order.getInt();
        order.getInt();
        int i3 = b2 >> 1;
        ArrayList<Div> arrayList = new ArrayList<>(i3);
        ninePatchChunk.xDivs = arrayList;
        readDivs(i3, order, arrayList);
        int i4 = b3 >> 1;
        ArrayList<Div> arrayList2 = new ArrayList<>(i4);
        ninePatchChunk.yDivs = arrayList2;
        readDivs(i4, order, arrayList2);
        while (true) {
            int[] iArr = ninePatchChunk.colors;
            if (i2 >= iArr.length) {
                return ninePatchChunk;
            }
            iArr[i2] = order.getInt();
            i2++;
        }
    }

    public static Div processChunk(int i2, Div div, int i3, ArrayList<Div> arrayList) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{Integer.valueOf(i2), div, Integer.valueOf(i3), arrayList})) == null) {
            if (isBlack(i2) && div == null) {
                div = new Div();
                div.start = i3;
            }
            if (!isTransparent(i2) || div == null) {
                return div;
            }
            div.stop = i3;
            arrayList.add(div);
            return null;
        }
        return (Div) invokeCommon.objValue;
    }

    public static void readDivs(int i2, ByteBuffer byteBuffer, ArrayList<Div> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65562, null, i2, byteBuffer, arrayList) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                Div div = new Div();
                div.start = byteBuffer.getInt();
                div.stop = byteBuffer.getInt();
                arrayList.add(div);
            }
        }
    }

    public static void setupColors(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, bitmap, ninePatchChunk) == null) {
            ArrayList<Div> regions = getRegions(ninePatchChunk.xDivs, bitmap.getWidth() - 2);
            ArrayList<Div> regions2 = getRegions(ninePatchChunk.yDivs, bitmap.getHeight() - 2);
            ninePatchChunk.colors = new int[regions.size() * regions2.size()];
            Iterator<Div> it = regions2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Div next = it.next();
                Iterator<Div> it2 = regions.iterator();
                while (it2.hasNext()) {
                    Div next2 = it2.next();
                    int i3 = next2.start + 1;
                    int i4 = next.start + 1;
                    if (hasSameColor(bitmap, i3, next2.stop + 1, i4, next.stop + 1)) {
                        int pixel = bitmap.getPixel(i3, i4);
                        if (isTransparent(pixel)) {
                            pixel = 0;
                        }
                        ninePatchChunk.colors[i2] = pixel;
                    } else {
                        ninePatchChunk.colors[i2] = 1;
                    }
                    i2++;
                }
            }
        }
    }

    public static void setupPadding(Bitmap bitmap, NinePatchChunk ninePatchChunk) throws WrongPaddingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, bitmap, ninePatchChunk) == null) {
            int width = bitmap.getWidth() - 2;
            int height = bitmap.getHeight() - 2;
            ArrayList<Div> xDivs = getXDivs(bitmap, bitmap.getHeight() - 1);
            if (xDivs.size() > 1) {
                throw new WrongPaddingException("Raw padding is wrong. Should be only one horizontal padding region");
            }
            ArrayList<Div> yDivs = getYDivs(bitmap, bitmap.getWidth() - 1);
            if (yDivs.size() > 1) {
                throw new WrongPaddingException("Column padding is wrong. Should be only one vertical padding region");
            }
            if (xDivs.size() == 0) {
                xDivs.add(ninePatchChunk.xDivs.get(0));
            }
            if (yDivs.size() == 0) {
                yDivs.add(ninePatchChunk.yDivs.get(0));
            }
            Rect rect = new Rect();
            ninePatchChunk.padding = rect;
            rect.left = xDivs.get(0).start;
            ninePatchChunk.padding.right = width - xDivs.get(0).stop;
            ninePatchChunk.padding.top = yDivs.get(0).start;
            ninePatchChunk.padding.bottom = height - yDivs.get(0).stop;
        }
    }

    public static void setupStretchableRegions(Bitmap bitmap, NinePatchChunk ninePatchChunk) throws DivLengthException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, bitmap, ninePatchChunk) == null) {
            ArrayList<Div> xDivs = getXDivs(bitmap, 0);
            ninePatchChunk.xDivs = xDivs;
            if (xDivs.size() == 0) {
                throw new DivLengthException("must be at least one horizontal stretchable region");
            }
            ArrayList<Div> yDivs = getYDivs(bitmap, 0);
            ninePatchChunk.yDivs = yDivs;
            if (yDivs.size() == 0) {
                throw new DivLengthException("must be at least one vertical stretchable region");
            }
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectInput) == null) {
            byte[] bArr = new byte[objectInput.readInt()];
            objectInput.read(bArr);
            try {
                NinePatchChunk parse = parse(bArr);
                this.wasSerialized = parse.wasSerialized;
                this.xDivs = parse.xDivs;
                this.yDivs = parse.yDivs;
                this.padding = parse.padding;
                this.colors = parse.colors;
            } catch (ChunkNotSerializedException | DivLengthException e2) {
                c.g(e2);
            }
        }
    }

    public byte[] toBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer order = ByteBuffer.allocate((this.xDivs.size() * 2 * 4) + 32 + (this.yDivs.size() * 2 * 4) + (this.colors.length * 4)).order(ByteOrder.nativeOrder());
            Integer num = 1;
            order.put(num.byteValue());
            order.put(Integer.valueOf(this.xDivs.size() * 2).byteValue());
            order.put(Integer.valueOf(this.yDivs.size() * 2).byteValue());
            order.put(Integer.valueOf(this.colors.length).byteValue());
            order.putInt(0);
            order.putInt(0);
            if (this.padding == null) {
                this.padding = new Rect();
            }
            order.putInt(this.padding.left);
            order.putInt(this.padding.right);
            order.putInt(this.padding.top);
            order.putInt(this.padding.bottom);
            order.putInt(0);
            Iterator<Div> it = this.xDivs.iterator();
            while (it.hasNext()) {
                Div next = it.next();
                order.putInt(next.start);
                order.putInt(next.stop);
            }
            Iterator<Div> it2 = this.yDivs.iterator();
            while (it2.hasNext()) {
                Div next2 = it2.next();
                order.putInt(next2.start);
                order.putInt(next2.stop);
            }
            for (int i2 : this.colors) {
                order.putInt(i2);
            }
            return order.array();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
            byte[] bytes = toBytes();
            objectOutput.writeInt(bytes.length);
            objectOutput.write(bytes);
        }
    }
}

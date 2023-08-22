package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.baidu.tieba.yfb;
import com.baidu.ugc.editvideo.data.Div;
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
/* loaded from: classes9.dex */
public class NinePatchChunk implements Externalizable {
    public static final int DEFAULT_DENSITY = 160;
    public static final int NO_COLOR = 1;
    public static final int TRANSPARENT_COLOR = 0;
    public int[] colors;
    public ArrayList<Div> xDivs;
    public ArrayList<Div> yDivs;
    public boolean wasSerialized = true;
    public Rect padding = new Rect();

    public static void checkDivCount(byte b) throws DivLengthException {
        if (b == 0 || (b & 1) != 0) {
            throw new DivLengthException("Div count should be aliquot 2 and more then 0, but was: " + ((int) b));
        }
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, Bitmap bitmap, String str) {
        return BitmapType.getNinePatchDrawable(context.getResources(), bitmap, str);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, int i, String str) {
        return createChunkFromRawBitmap(context, inputStream, i).getNinePatchDrawable(context.getResources(), str);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, String str) {
        return create9PatchDrawable(context, inputStream, 160, str);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, Bitmap bitmap) {
        BitmapType determineBitmapType = BitmapType.determineBitmapType(bitmap);
        NinePatchChunk createChunk = determineBitmapType.createChunk(bitmap);
        return new ImageLoadingResult(determineBitmapType.modifyBitmap(context.getResources(), bitmap, createChunk), createChunk);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream) {
        return createChunkFromRawBitmap(context, inputStream, 160);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = i;
        options.inTargetDensity = i;
        return createChunkFromRawBitmap(context, BitmapFactory.decodeStream(inputStream, new Rect(), options));
    }

    public static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap) {
        try {
            return createChunkFromRawBitmap(bitmap, true);
        } catch (RuntimeException unused) {
            return createEmptyChunk();
        }
    }

    public static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap, boolean z) throws WrongPaddingException, DivLengthException {
        if (!z || isRawNinePatchBitmap(bitmap)) {
            NinePatchChunk ninePatchChunk = new NinePatchChunk();
            setupStretchableRegions(bitmap, ninePatchChunk);
            setupPadding(bitmap, ninePatchChunk);
            setupColors(bitmap, ninePatchChunk);
            return ninePatchChunk;
        }
        return createEmptyChunk();
    }

    public static void createColors(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        ArrayList<Div> regions = getRegions(ninePatchChunk.xDivs, bitmap.getWidth() - 2);
        ArrayList<Div> regions2 = getRegions(ninePatchChunk.yDivs, bitmap.getHeight() - 2);
        ninePatchChunk.colors = new int[regions.size() * regions2.size()];
        Iterator<Div> it = regions2.iterator();
        int i = 0;
        while (it.hasNext()) {
            Div next = it.next();
            Iterator<Div> it2 = regions.iterator();
            while (it2.hasNext()) {
                Div next2 = it2.next();
                int i2 = next2.start + 1;
                int i3 = next.start + 1;
                if (hasSameColor(bitmap, i2, next2.stop + 1, i3, next.stop + 1)) {
                    int pixel = bitmap.getPixel(i2, i3);
                    if (isTransparent(pixel)) {
                        pixel = 0;
                    }
                    ninePatchChunk.colors[i] = pixel;
                } else {
                    ninePatchChunk.colors[i] = 1;
                }
                i++;
            }
        }
    }

    public static int[] createColorsArray(NinePatchChunk ninePatchChunk, int i, int i2) {
        if (ninePatchChunk == null) {
            return new int[0];
        }
        int[] iArr = new int[getRegions(ninePatchChunk.xDivs, i).size() * getRegions(ninePatchChunk.yDivs, i2).size()];
        Arrays.fill(iArr, 1);
        return iArr;
    }

    public static void createColorsArrayAndSet(NinePatchChunk ninePatchChunk, int i, int i2) {
        int[] createColorsArray = createColorsArray(ninePatchChunk, i, i2);
        if (ninePatchChunk != null) {
            ninePatchChunk.colors = createColorsArray;
        }
    }

    public static NinePatchChunk createEmptyChunk() {
        NinePatchChunk ninePatchChunk = new NinePatchChunk();
        ninePatchChunk.colors = new int[0];
        ninePatchChunk.padding = new Rect();
        ninePatchChunk.yDivs = new ArrayList<>();
        ninePatchChunk.xDivs = new ArrayList<>();
        return ninePatchChunk;
    }

    public static ArrayList<Div> getRegions(ArrayList<Div> arrayList, int i) {
        int i2;
        int i3;
        ArrayList<Div> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Div div = arrayList.get(i4);
                if (i4 == 0 && (i3 = div.start) != 0) {
                    arrayList2.add(new Div(0, i3 - 1));
                }
                if (i4 > 0) {
                    arrayList2.add(new Div(arrayList.get(i4 - 1).stop, div.start - 1));
                }
                arrayList2.add(new Div(div.start, div.stop - 1));
                if (i4 == arrayList.size() - 1 && (i2 = div.stop) < i) {
                    arrayList2.add(new Div(i2, i - 1));
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<Div> getXDivs(Bitmap bitmap, int i) {
        ArrayList<Div> arrayList = new ArrayList<>();
        Div div = null;
        for (int i2 = 1; i2 < bitmap.getWidth(); i2++) {
            div = processChunk(bitmap.getPixel(i2, i), div, i2 - 1, arrayList);
        }
        return arrayList;
    }

    public static ArrayList<Div> getYDivs(Bitmap bitmap, int i) {
        ArrayList<Div> arrayList = new ArrayList<>();
        Div div = null;
        for (int i2 = 1; i2 < bitmap.getHeight(); i2++) {
            div = processChunk(bitmap.getPixel(i, i2), div, i2 - 1, arrayList);
        }
        return arrayList;
    }

    public static boolean hasNinePatchBorder(Bitmap bitmap) {
        int width = bitmap.getWidth() - 1;
        int height = bitmap.getHeight() - 1;
        for (int i = 1; i < width; i++) {
            if (!isBorderPixel(bitmap.getPixel(i, 0)) || !isBorderPixel(bitmap.getPixel(i, height))) {
                return false;
            }
        }
        for (int i2 = 1; i2 < height; i2++) {
            if (!isBorderPixel(bitmap.getPixel(0, i2)) || !isBorderPixel(bitmap.getPixel(width, i2))) {
                return false;
            }
        }
        return getXDivs(bitmap, 0).size() != 0 && getXDivs(bitmap, height).size() <= 1 && getYDivs(bitmap, 0).size() != 0 && getYDivs(bitmap, width).size() <= 1;
    }

    public static boolean hasSameColor(Bitmap bitmap, int i, int i2, int i3, int i4) {
        try {
            int pixel = bitmap.getPixel(i, i3);
            while (i <= i2) {
                for (int i5 = i3; i5 <= i4; i5++) {
                    if (pixel != bitmap.getPixel(i, i5)) {
                        return false;
                    }
                }
                i++;
            }
            return true;
        } catch (Exception e) {
            yfb.g(e);
            return true;
        }
    }

    public static boolean isBlack(int i) {
        return i == -16777216;
    }

    public static boolean isBorderPixel(int i) {
        return isTransparent(i) || isBlack(i);
    }

    public static boolean isCornerPixelsAreTrasperent(Bitmap bitmap) {
        int height = bitmap.getHeight() - 1;
        int width = bitmap.getWidth() - 1;
        return isTransparent(bitmap.getPixel(0, 0)) && isTransparent(bitmap.getPixel(0, height)) && isTransparent(bitmap.getPixel(width, 0)) && isTransparent(bitmap.getPixel(width, height));
    }

    public static boolean isRawNinePatchBitmap(Bitmap bitmap) {
        return bitmap != null && bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3 && isCornerPixelsAreTrasperent(bitmap) && hasNinePatchBorder(bitmap);
    }

    public static boolean isTransparent(int i) {
        return Color.alpha(i) == 0;
    }

    public static NinePatchChunk parse(byte[] bArr) throws DivLengthException, ChunkNotSerializedException, BufferUnderflowException {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        NinePatchChunk ninePatchChunk = new NinePatchChunk();
        int i = 0;
        boolean z = order.get() != 0;
        ninePatchChunk.wasSerialized = z;
        if (!z) {
            throw new ChunkNotSerializedException();
        }
        byte b = order.get();
        checkDivCount(b);
        byte b2 = order.get();
        checkDivCount(b2);
        ninePatchChunk.colors = new int[order.get()];
        order.getInt();
        order.getInt();
        ninePatchChunk.padding.left = order.getInt();
        ninePatchChunk.padding.right = order.getInt();
        ninePatchChunk.padding.top = order.getInt();
        ninePatchChunk.padding.bottom = order.getInt();
        order.getInt();
        int i2 = b >> 1;
        ArrayList<Div> arrayList = new ArrayList<>(i2);
        ninePatchChunk.xDivs = arrayList;
        readDivs(i2, order, arrayList);
        int i3 = b2 >> 1;
        ArrayList<Div> arrayList2 = new ArrayList<>(i3);
        ninePatchChunk.yDivs = arrayList2;
        readDivs(i3, order, arrayList2);
        while (true) {
            int[] iArr = ninePatchChunk.colors;
            if (i >= iArr.length) {
                return ninePatchChunk;
            }
            iArr[i] = order.getInt();
            i++;
        }
    }

    public static Div processChunk(int i, Div div, int i2, ArrayList<Div> arrayList) {
        if (isBlack(i) && div == null) {
            div = new Div();
            div.start = i2;
        }
        if (!isTransparent(i) || div == null) {
            return div;
        }
        div.stop = i2;
        arrayList.add(div);
        return null;
    }

    public static void readDivs(int i, ByteBuffer byteBuffer, ArrayList<Div> arrayList) {
        for (int i2 = 0; i2 < i; i2++) {
            Div div = new Div();
            div.start = byteBuffer.getInt();
            div.stop = byteBuffer.getInt();
            arrayList.add(div);
        }
    }

    public static void setupColors(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        ArrayList<Div> regions = getRegions(ninePatchChunk.xDivs, bitmap.getWidth() - 2);
        ArrayList<Div> regions2 = getRegions(ninePatchChunk.yDivs, bitmap.getHeight() - 2);
        ninePatchChunk.colors = new int[regions.size() * regions2.size()];
        Iterator<Div> it = regions2.iterator();
        int i = 0;
        while (it.hasNext()) {
            Div next = it.next();
            Iterator<Div> it2 = regions.iterator();
            while (it2.hasNext()) {
                Div next2 = it2.next();
                int i2 = next2.start + 1;
                int i3 = next.start + 1;
                if (hasSameColor(bitmap, i2, next2.stop + 1, i3, next.stop + 1)) {
                    int pixel = bitmap.getPixel(i2, i3);
                    if (isTransparent(pixel)) {
                        pixel = 0;
                    }
                    ninePatchChunk.colors[i] = pixel;
                } else {
                    ninePatchChunk.colors[i] = 1;
                }
                i++;
            }
        }
    }

    public static void setupPadding(Bitmap bitmap, NinePatchChunk ninePatchChunk) throws WrongPaddingException {
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

    public static void setupStretchableRegions(Bitmap bitmap, NinePatchChunk ninePatchChunk) throws DivLengthException {
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

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte[] bArr = new byte[objectInput.readInt()];
        objectInput.read(bArr);
        try {
            NinePatchChunk parse = parse(bArr);
            this.wasSerialized = parse.wasSerialized;
            this.xDivs = parse.xDivs;
            this.yDivs = parse.yDivs;
            this.padding = parse.padding;
            this.colors = parse.colors;
        } catch (ChunkNotSerializedException | DivLengthException e) {
            yfb.g(e);
        }
    }

    public byte[] toBytes() {
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
        for (int i : this.colors) {
            order.putInt(i);
        }
        return order.array();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte[] bytes = toBytes();
        objectOutput.writeInt(bytes.length);
        objectOutput.write(bytes);
    }
}

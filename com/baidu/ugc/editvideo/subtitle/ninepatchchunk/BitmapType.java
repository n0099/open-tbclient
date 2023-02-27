package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.baidu.ugc.editvideo.data.Div;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public enum BitmapType {
    NinePatch { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.1
        @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
        public NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.parse(bitmap.getNinePatchChunk());
        }
    },
    RawNinePatch { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.2
        private void recalculateDivs(float f, ArrayList<Div> arrayList) {
            Iterator<Div> it = arrayList.iterator();
            while (it.hasNext()) {
                Div next = it.next();
                next.start = Math.round(next.start * f);
                next.stop = Math.round(next.stop * f);
            }
        }

        @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
        public NinePatchChunk createChunk(Bitmap bitmap) {
            try {
                return NinePatchChunk.createChunkFromRawBitmap(bitmap, false);
            } catch (DivLengthException unused) {
                return NinePatchChunk.createEmptyChunk();
            } catch (WrongPaddingException unused2) {
                return NinePatchChunk.createEmptyChunk();
            }
        }

        @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
        public Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
            int i = resources.getDisplayMetrics().densityDpi;
            float density = i / bitmap.getDensity();
            if (density != 1.0f) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, Math.round(createBitmap.getWidth() * density), Math.round(createBitmap.getHeight() * density), true);
                createScaledBitmap.setDensity(i);
                ninePatchChunk.padding = new Rect(Math.round(ninePatchChunk.padding.left * density), Math.round(ninePatchChunk.padding.top * density), Math.round(ninePatchChunk.padding.right * density), Math.round(ninePatchChunk.padding.bottom * density));
                recalculateDivs(density, ninePatchChunk.xDivs);
                recalculateDivs(density, ninePatchChunk.yDivs);
                return createScaledBitmap;
            }
            return createBitmap;
        }
    },
    PlainImage { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.3
        @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
        public NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.createEmptyChunk();
        }
    },
    NULL { // from class: com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType.4
        @Override // com.baidu.ugc.editvideo.subtitle.ninepatchchunk.BitmapType
        public NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
            return null;
        }
    };

    public static BitmapType determineBitmapType(Bitmap bitmap) {
        if (bitmap == null) {
            return NULL;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        return (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) ? NinePatchChunk.isRawNinePatchBitmap(bitmap) ? RawNinePatch : PlainImage : NinePatch;
    }

    public static NinePatchDrawable getNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        return determineBitmapType(bitmap).createNinePatchDrawable(resources, bitmap, str);
    }

    public NinePatchChunk createChunk(Bitmap bitmap) {
        return NinePatchChunk.createEmptyChunk();
    }

    public NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        NinePatchChunk createChunk = createChunk(bitmap);
        return new NinePatchDrawable(resources, modifyBitmap(resources, bitmap, createChunk), createChunk.toBytes(), createChunk.padding, str);
    }

    public Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        return bitmap;
    }
}

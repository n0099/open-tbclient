package com.baidu.ugc.editvideo.faceunity.gles;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public class Drawable2d {
    public static final FloatBuffer FULL_RECTANGLE_BUF;
    public static final float[] FULL_RECTANGLE_COORDS;
    public static final FloatBuffer RECTANGLE_BUF;
    public static final float[] RECTANGLE_COORDS;
    public static final int SIZEOF_FLOAT = 4;
    public static final FloatBuffer TRIANGLE_BUF;
    public static final float[] TRIANGLE_COORDS;
    public int mCoordsPerVertex;
    public Prefab mPrefab;
    public FloatBuffer mTexCoordArray;
    public FloatBuffer mTexCoordArray2;
    public int mTexCoordStride;
    public FloatBuffer mVertexArray;
    public int mVertexCount;
    public int mVertexStride;
    public static final float[] TRIANGLE_TEX_COORDS = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    public static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final FloatBuffer RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    public static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static float[] FULL_RECTANGLE_LINE_COORDS = {-1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF2 = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    public static final FloatBuffer FULL_RECTANGLE_LINE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_LINE_COORDS);

    /* loaded from: classes9.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_LINE
    }

    /* renamed from: com.baidu.ugc.editvideo.faceunity.gles.Drawable2d$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab;

        static {
            int[] iArr = new int[Prefab.values().length];
            $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab[Prefab.FULL_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr2;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr3;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab[prefab.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.mVertexArray = FULL_RECTANGLE_LINE_BUF;
                    } else {
                        throw new RuntimeException("Unknown shape " + prefab);
                    }
                } else {
                    this.mVertexArray = FULL_RECTANGLE_BUF;
                    this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                    this.mTexCoordArray2 = FULL_RECTANGLE_TEX_BUF2;
                    this.mCoordsPerVertex = 2;
                    this.mVertexStride = 2 * 4;
                    this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
                }
            } else {
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = 2 * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / 2;
            }
        } else {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public FloatBuffer getTexCoordArray2() {
        return this.mTexCoordArray2;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public String toString() {
        if (this.mPrefab != null) {
            return "[Drawable2d: " + this.mPrefab + PreferencesUtil.RIGHT_MOUNT;
        }
        return "[Drawable2d: ...]";
    }

    public void setScale(float f, float f2) {
        float f3 = f2 * (-1.0f);
        float f4 = (-1.0f) * f;
        float f5 = f2 * 1.0f;
        float f6 = f * 1.0f;
        this.mVertexArray.put(new float[]{f3, f4, f5, f4, f3, f6, f5, f6});
        this.mVertexArray.position(0);
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        float[] fArr = new float[8];
        float f5 = f * (-1.0f);
        fArr[0] = f5;
        float f6 = (-1.0f) * f2;
        fArr[1] = f6;
        float f7 = f * 1.0f;
        fArr[2] = f7;
        fArr[3] = f6;
        fArr[4] = f5;
        float f8 = f2 * 1.0f;
        fArr[5] = f8;
        fArr[6] = f7;
        fArr[7] = f8;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                fArr[i] = fArr[i] + f3;
            } else if (i != 1 && i != 3) {
                fArr[i] = fArr[i] + f4;
            } else {
                fArr[i] = fArr[i] + f4;
            }
        }
        this.mVertexArray.put(fArr);
        this.mVertexArray.position(0);
    }
}

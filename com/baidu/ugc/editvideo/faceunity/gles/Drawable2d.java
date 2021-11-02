package com.baidu.ugc.editvideo.faceunity.gles;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes10.dex */
public class Drawable2d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FloatBuffer FULL_RECTANGLE_BUF;
    public static final float[] FULL_RECTANGLE_COORDS;
    public static final FloatBuffer FULL_RECTANGLE_LINE_BUF;
    public static float[] FULL_RECTANGLE_LINE_COORDS = null;
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF;
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF2;
    public static final float[] FULL_RECTANGLE_TEX_COORDS;
    public static final FloatBuffer RECTANGLE_BUF;
    public static final float[] RECTANGLE_COORDS;
    public static final FloatBuffer RECTANGLE_TEX_BUF;
    public static final float[] RECTANGLE_TEX_COORDS;
    public static final int SIZEOF_FLOAT = 4;
    public static final FloatBuffer TRIANGLE_BUF;
    public static final float[] TRIANGLE_COORDS;
    public static final FloatBuffer TRIANGLE_TEX_BUF;
    public static final float[] TRIANGLE_TEX_COORDS;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCoordsPerVertex;
    public Prefab mPrefab;
    public FloatBuffer mTexCoordArray;
    public FloatBuffer mTexCoordArray2;
    public int mTexCoordStride;
    public FloatBuffer mVertexArray;
    public int mVertexCount;
    public int mVertexStride;

    /* renamed from: com.baidu.ugc.editvideo.faceunity.gles.Drawable2d$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1817746691, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1817746691, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d$1;");
                    return;
                }
            }
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Prefab {
        public static final /* synthetic */ Prefab[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Prefab FULL_LINE;
        public static final Prefab FULL_RECTANGLE;
        public static final Prefab RECTANGLE;
        public static final Prefab TRIANGLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1142611934, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d$Prefab;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1142611934, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d$Prefab;");
                    return;
                }
            }
            TRIANGLE = new Prefab("TRIANGLE", 0);
            RECTANGLE = new Prefab("RECTANGLE", 1);
            FULL_RECTANGLE = new Prefab("FULL_RECTANGLE", 2);
            Prefab prefab = new Prefab("FULL_LINE", 3);
            FULL_LINE = prefab;
            $VALUES = new Prefab[]{TRIANGLE, RECTANGLE, FULL_RECTANGLE, prefab};
        }

        public Prefab(String str, int i2) {
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

        public static Prefab valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Prefab) Enum.valueOf(Prefab.class, str) : (Prefab) invokeL.objValue;
        }

        public static Prefab[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Prefab[]) $VALUES.clone() : (Prefab[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-418219728, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-418219728, "Lcom/baidu/ugc/editvideo/faceunity/gles/Drawable2d;");
                return;
            }
        }
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        TRIANGLE_TEX_COORDS = new float[]{0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr2;
        RECTANGLE_TEX_COORDS = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr2);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr3;
        FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_LINE_COORDS = new float[]{-1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        FULL_RECTANGLE_TEX_BUF2 = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        FULL_RECTANGLE_LINE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_LINE_COORDS);
    }

    public Drawable2d(Prefab prefab) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {prefab};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i4 = AnonymousClass1.$SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Drawable2d$Prefab[prefab.ordinal()];
        if (i4 == 1) {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        } else if (i4 == 2) {
            this.mVertexArray = RECTANGLE_BUF;
            this.mTexCoordArray = RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = RECTANGLE_COORDS.length / 2;
        } else if (i4 == 3) {
            this.mVertexArray = FULL_RECTANGLE_BUF;
            this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
            this.mTexCoordArray2 = FULL_RECTANGLE_TEX_BUF2;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
        } else if (i4 == 4) {
            this.mVertexArray = FULL_RECTANGLE_LINE_BUF;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public int getCoordsPerVertex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCoordsPerVertex : invokeV.intValue;
    }

    public FloatBuffer getTexCoordArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTexCoordArray : (FloatBuffer) invokeV.objValue;
    }

    public FloatBuffer getTexCoordArray2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTexCoordArray2 : (FloatBuffer) invokeV.objValue;
    }

    public int getTexCoordStride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTexCoordStride : invokeV.intValue;
    }

    public FloatBuffer getVertexArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVertexArray : (FloatBuffer) invokeV.objValue;
    }

    public int getVertexCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVertexCount : invokeV.intValue;
    }

    public int getVertexStride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVertexStride : invokeV.intValue;
    }

    public void setScale(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float f4 = f3 * (-1.0f);
            float f5 = (-1.0f) * f2;
            float f6 = f3 * 1.0f;
            float f7 = f2 * 1.0f;
            this.mVertexArray.put(new float[]{f4, f5, f6, f5, f4, f7, f6, f7});
            this.mVertexArray.position(0);
        }
    }

    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = new float[8];
            float f6 = f2 * (-1.0f);
            fArr[0] = f6;
            float f7 = (-1.0f) * f3;
            fArr[1] = f7;
            float f8 = f2 * 1.0f;
            fArr[2] = f8;
            fArr[3] = f7;
            fArr[4] = f6;
            float f9 = f3 * 1.0f;
            fArr[5] = f9;
            fArr[6] = f8;
            fArr[7] = f9;
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 % 2 == 0) {
                    fArr[i2] = fArr[i2] + f4;
                } else if (i2 != 1 && i2 != 3) {
                    fArr[i2] = fArr[i2] + f5;
                } else {
                    fArr[i2] = fArr[i2] + f5;
                }
            }
            this.mVertexArray.put(fArr);
            this.mVertexArray.position(0);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mPrefab != null) {
                return "[Drawable2d: " + this.mPrefab + PreferencesUtil.RIGHT_MOUNT;
            }
            return "[Drawable2d: ...]";
        }
        return (String) invokeV.objValue;
    }
}

package com.baidu.ugc.editvideo.faceunity.gles;

import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w89;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class Texture2dProgram {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float alpha;\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = color * alpha;\n}\n";
    public static final String FRAGMENT_SHADER_2D_BLEND = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoord2;\nuniform sampler2D sTexture;\nuniform sampler2D sTexture2;\nuniform float thresholdSensitivity;\nuniform float smoothing;\nuniform vec3 colorToReplace;\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);void main() {\n    vec4 textureColor =texture2D(sTexture, vTextureCoord);\n    vec4 textureColor2 =texture2D(sTexture2, vTextureCoord2);\n    float maskY = 0.2989 * colorToReplace.r + 0.5866 * colorToReplace.g + 0.1145 * colorToReplace.b;\n    float maskCr = 0.7132 * (colorToReplace.r - maskY);\n    float maskCb = 0.5647 * (colorToReplace.b - maskY);\n    float Y = 0.2989 * textureColor.r + 0.5866 * textureColor.g + 0.1145 * textureColor.b;\n    float Cr = 0.7132 * (textureColor.r - Y);\n    float Cb = 0.5647 * (textureColor.b - Y);\n    float L = dot(textureColor.rgb, W);\n    float maskL = dot(colorToReplace.rgb, W);\n    float blendValue = 1.0 - smoothstep(thresholdSensitivity, thresholdSensitivity + smoothing, distance(vec3(Cr, Cb, L), vec3(maskCr, maskCb, maskL)));\n    gl_FragColor = mix(textureColor, textureColor2, blendValue);\n}\n";
    public static final String FRAGMENT_SHADER_2D_FOLLOW = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float alpha;\nuniform float dx;\nuniform float dy;\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec2 st = vTextureCoord.xy;\n    float l = step(dx, st.x);\n    float b = step(dy, st.y);\n    float p = b*l;\n    float r = step(dx, 1.0 - st.x);\n    float t = step(dy, 1.0 - st.y);\n          p*=r*t;\n    if(p==0.0){\n       gl_FragColor = vec4(1.0);\n     }else{\n       gl_FragColor =color * alpha;}\n}\n";
    public static final String FRAGMENT_SHADER_2D_HUMAN_SEGMENTATION = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoord2;\nuniform sampler2D sTexture;\nuniform sampler2D sTexture2;\nuniform int maskMode;\nuniform vec4 maskColor;\nvoid main() {\n    vec4 textureColor =texture2D(sTexture, vTextureCoord);\n    vec4 textureColor2 =texture2D(sTexture2, vTextureCoord2);\n    if (textureColor2.r == 0.0 && textureColor2.g == 0.0 && textureColor2.b ==0.0){\n       textureColor2.a = 0.0;\n       gl_FragColor = textureColor2;\n       // discard;\n    } else {\n       if (maskMode == 1) {\n           gl_FragColor = vec4(maskColor.rgb, 1.0)*maskColor.a;\n           //0.5为透明度为50%的蒙层的颜色，maskMode=1为生成自动抠图蒙版的模式\n       } else {\n           //maskMode==0为根据蒙版生成抠图结果的模式，alpha为0.5是抠图画笔颜色的透明度，textureColor2.a*1.0/maskColor.a是为了还原蒙层没有做透明时原图的透明度\n           gl_FragColor = textureColor*(textureColor2.a*(1.0/maskColor.a));\n       }    }\n}\n";
    public static final String FRAGMENT_SHADER_2D_SLIDE = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoord2;\nuniform sampler2D sTexture;\nuniform sampler2D sTexture2;\nuniform float distance;\nvoid main() {\n    vec2 vector;\n    vec4 color;\n    if(vTextureCoord.x < distance){\n       vector[0]=vTextureCoord.x+(1.0-distance);\n       vector[1]=vTextureCoord.y;\n       color = texture2D(sTexture, vector);\n       gl_FragColor = color * 0.2;\n       for (int i = 1; i<5;i++) {\n           gl_FragColor+=texture2D(sTexture,vec2(vector.x-0.02*float(i)*(1.0-distance),vector.y))*0.1;\n       }\n       for (int i = 1; i<5;i++) {\n           gl_FragColor+=texture2D(sTexture,vec2(vector.x+0.02*(1.0-distance)*float(i),vector.y))*0.1;\n       }\n    } else {\n       vector[0]=vTextureCoord2.x-distance;\n       vector[1]=vTextureCoord2.y;\n       color = texture2D(sTexture2, vector);\n       gl_FragColor = color * 0.2;\n       for (int i = 1; i<5;i++) {\n           gl_FragColor+=texture2D(sTexture2,vec2(vector.x-0.02*float(i)*(distance),vector.y))*0.1;\n       }\n       for (int i = 1; i<5;i++) {\n           gl_FragColor+=texture2D(sTexture2,vec2(vector.x+0.02*float(i)*(distance),vector.y))*0.1;\n       }\n    }\n}\n";
    public static final String FRAGMENT_SHADER_2D_X_BLUR = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float distance;\nvoid main() {\n    vec2 vector;\n    vec4 color;\n    float tranAlpha = 1.0;\n    if(vTextureCoord.x < distance){\n           tranAlpha=(1.0-distance);\n    } else { \n           tranAlpha=distance;\n    }\n    vector[0]=vTextureCoord.x;\n    vector[1]=vTextureCoord.y;\n    color = texture2D(sTexture, vector);\n    gl_FragColor = color * 0.2;\n    for (int i = 1; i<5;i++) {\n        gl_FragColor+=texture2D(sTexture,vec2(vector.x-0.05*float(i)*tranAlpha,vector.y))*0.1;\n    }\n    for (int i = 1; i<5;i++) {\n         gl_FragColor+=texture2D(sTexture,vec2(vector.x+0.05*tranAlpha*float(i),vector.y))*0.1;\n    }\n}\n";
    public static final String FRAGMENT_SHADER_AR_ALPHA = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoord2;\nuniform sampler2D sTexture;\nuniform sampler2D sTexture2;\nvoid main() {\n    vec4 textureColor =texture2D(sTexture, vTextureCoord);\n    vec4 textureColor2 =texture2D(sTexture2, vTextureCoord2);\n    gl_FragColor = vec4(textureColor2.r, textureColor2.g, textureColor2.b, textureColor.a);\n}\n";
    public static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float alpha;\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = color * alpha;\n}\n";
    public static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    public static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final String FRAGMENT_SHADER_FILTER = "precision highp float;\nvarying highp vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform sampler2D sTexture2;\nvec4 applyFilterOnColor(vec4 inputColor, sampler2D inputLut, float saturation) {\n   highp float blueColor = inputColor.b * 63.0;\n   highp vec2 quad1;\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n   highp vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n   highp vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n   highp vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n   lowp vec4 newColor1 = texture2D(inputLut, texPos1);\n   lowp vec4 newColor2 = texture2D(inputLut, texPos2);\n   lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n   return newColor;\n}\nvoid main(){\n   vec4 inputColor = texture2D(sTexture, vTextureCoord);\n   if (inputColor.r == 0.0 && inputColor.g == 0.0 && inputColor.b == 0.0) {\n       gl_FragColor = inputColor;\n   }  else {\n       vec4 outColor = applyFilterOnColor(inputColor, sTexture2, 1.0);\n       gl_FragColor = mix(inputColor, vec4(outColor.rgb, inputColor.w), 1.0);\n   }\n}\n";
    public static final String FRAGMENT_SHADER_LINE = "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n    gl_FragColor = uColor;\n}\n";
    public static final int KERNEL_SIZE = 9;
    public static final String TAG = "Grafika";
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    public static final String VERTEX_SHADER_BLEND = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform mat4 uTexMatrix2;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aTextureCoord2;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoord2;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    vTextureCoord2 = (uTexMatrix2 * aTextureCoord2).xy;\n}\n";
    public static final String VERTEX_SHADER_LINE = "uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n}\n";
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mColorAdjust;
    public float[] mColorToReplace;
    public float mDistance;
    public float mDx;
    public float mDy;
    public int mFilterInputTextureUniform;
    public int mFilterInputTextureUniform2;
    public float[] mKernel;
    public float[] mMaskColor;
    public int mMaskMode;
    public int mProgramHandle;
    public ProgramType mProgramType;
    public float[] mTexOffset;
    public int mTextureTarget;
    public int maPositionLoc;
    public int maTextureCoordLoc;
    public int maTextureCoordLoc2;
    public int muColorAdjustLoc;
    public int muColorLocation;
    public int muKernelLoc;
    public int muMVPMatrixLoc;
    public int muTexMatrixLoc;
    public int muTexMatrixLoc2;
    public int muTexOffsetLoc;

    /* renamed from: com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1579727484, "Lcom/baidu/ugc/editvideo/faceunity/gles/Texture2dProgram$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1579727484, "Lcom/baidu/ugc/editvideo/faceunity/gles/Texture2dProgram$1;");
                    return;
                }
            }
            int[] iArr = new int[ProgramType.values().length];
            $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_AR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_FOLLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_BW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_BLEND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_HUMAN_SEGMENTATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_SLIDE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_X_BLUR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_FILTER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_LINE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_2D_AR_ALPHA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ProgramType {
        public static final /* synthetic */ ProgramType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProgramType TEXTURE_2D;
        public static final ProgramType TEXTURE_2D_AR;
        public static final ProgramType TEXTURE_2D_AR_ALPHA;
        public static final ProgramType TEXTURE_2D_BLEND;
        public static final ProgramType TEXTURE_2D_FILTER;
        public static final ProgramType TEXTURE_2D_FOLLOW;
        public static final ProgramType TEXTURE_2D_HUMAN_SEGMENTATION;
        public static final ProgramType TEXTURE_2D_LINE;
        public static final ProgramType TEXTURE_2D_SLIDE;
        public static final ProgramType TEXTURE_2D_X_BLUR;
        public static final ProgramType TEXTURE_EXT;
        public static final ProgramType TEXTURE_EXT_BW;
        public static final ProgramType TEXTURE_EXT_FILT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1607465457, "Lcom/baidu/ugc/editvideo/faceunity/gles/Texture2dProgram$ProgramType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1607465457, "Lcom/baidu/ugc/editvideo/faceunity/gles/Texture2dProgram$ProgramType;");
                    return;
                }
            }
            TEXTURE_2D = new ProgramType("TEXTURE_2D", 0);
            TEXTURE_EXT = new ProgramType("TEXTURE_EXT", 1);
            TEXTURE_EXT_BW = new ProgramType("TEXTURE_EXT_BW", 2);
            TEXTURE_EXT_FILT = new ProgramType("TEXTURE_EXT_FILT", 3);
            TEXTURE_2D_BLEND = new ProgramType("TEXTURE_2D_BLEND", 4);
            TEXTURE_2D_HUMAN_SEGMENTATION = new ProgramType("TEXTURE_2D_HUMAN_SEGMENTATION", 5);
            TEXTURE_2D_SLIDE = new ProgramType("TEXTURE_2D_SLIDE", 6);
            TEXTURE_2D_X_BLUR = new ProgramType("TEXTURE_2D_X_BLUR", 7);
            TEXTURE_2D_FOLLOW = new ProgramType("TEXTURE_2D_FOLLOW", 8);
            TEXTURE_2D_AR = new ProgramType("TEXTURE_2D_AR", 9);
            TEXTURE_2D_FILTER = new ProgramType("TEXTURE_2D_FILTER", 10);
            TEXTURE_2D_LINE = new ProgramType("TEXTURE_2D_LINE", 11);
            ProgramType programType = new ProgramType("TEXTURE_2D_AR_ALPHA", 12);
            TEXTURE_2D_AR_ALPHA = programType;
            $VALUES = new ProgramType[]{TEXTURE_2D, TEXTURE_EXT, TEXTURE_EXT_BW, TEXTURE_EXT_FILT, TEXTURE_2D_BLEND, TEXTURE_2D_HUMAN_SEGMENTATION, TEXTURE_2D_SLIDE, TEXTURE_2D_X_BLUR, TEXTURE_2D_FOLLOW, TEXTURE_2D_AR, TEXTURE_2D_FILTER, TEXTURE_2D_LINE, programType};
        }

        public ProgramType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ProgramType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProgramType) Enum.valueOf(ProgramType.class, str) : (ProgramType) invokeL.objValue;
        }

        public static ProgramType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProgramType[]) $VALUES.clone() : (ProgramType[]) invokeV.objValue;
        }
    }

    public Texture2dProgram(ProgramType programType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {programType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKernel = new float[9];
        this.mColorToReplace = new float[]{0.0f, 0.0f, 0.0f};
        this.mMaskColor = new float[]{1.0f, 0.0f, 0.0f, 0.5f};
        this.mAlpha = 1.0f;
        this.mDistance = 1.0f;
        this.mDx = 0.01f;
        this.mDy = 0.01f;
        this.mProgramType = programType;
        switch (AnonymousClass1.$SwitchMap$com$baidu$ugc$editvideo$faceunity$gles$Texture2dProgram$ProgramType[programType.ordinal()]) {
            case 1:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D);
                break;
            case 2:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case 3:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D_FOLLOW);
                break;
            case 4:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case 5:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
                break;
            case 6:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
                break;
            case 7:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_BLEND, FRAGMENT_SHADER_2D_BLEND);
                break;
            case 8:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_BLEND, FRAGMENT_SHADER_2D_HUMAN_SEGMENTATION);
                break;
            case 9:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_BLEND, FRAGMENT_SHADER_2D_SLIDE);
                break;
            case 10:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D_X_BLUR);
                break;
            case 11:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_FILTER);
                break;
            case 12:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_LINE, FRAGMENT_SHADER_LINE);
                break;
            case 13:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_BLEND, FRAGMENT_SHADER_AR_ALPHA);
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle != 0) {
            w89.c("Grafika", "Created program " + this.mProgramHandle + " (" + programType + SmallTailInfo.EMOTION_SUFFIX);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            GlUtil.checkLocation(glGetAttribLocation, "aPosition");
            this.mFilterInputTextureUniform = GLES20.glGetUniformLocation(this.mProgramHandle, "sTexture");
            if (this.mProgramType != ProgramType.TEXTURE_2D_LINE) {
                int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
                this.maTextureCoordLoc = glGetAttribLocation2;
                GlUtil.checkLocation(glGetAttribLocation2, "aTextureCoord");
                int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
                this.muTexMatrixLoc = glGetUniformLocation;
                GlUtil.checkLocation(glGetUniformLocation, "uTexMatrix");
            }
            ProgramType programType2 = this.mProgramType;
            if (programType2 == ProgramType.TEXTURE_2D_BLEND || programType2 == ProgramType.TEXTURE_2D_HUMAN_SEGMENTATION || programType2 == ProgramType.TEXTURE_2D_SLIDE || programType2 == ProgramType.TEXTURE_2D_AR_ALPHA) {
                this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(this.mProgramHandle, "sTexture2");
                int glGetAttribLocation3 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord2");
                this.maTextureCoordLoc2 = glGetAttribLocation3;
                GlUtil.checkLocation(glGetAttribLocation3, "aTextureCoord2");
            }
            if (this.mProgramType == ProgramType.TEXTURE_2D_FILTER) {
                this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(this.mProgramHandle, "sTexture2");
            }
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation2;
            GlUtil.checkLocation(glGetUniformLocation2, "uMVPMatrix");
            ProgramType programType3 = this.mProgramType;
            if (programType3 == ProgramType.TEXTURE_2D_BLEND || programType3 == ProgramType.TEXTURE_2D_HUMAN_SEGMENTATION || programType3 == ProgramType.TEXTURE_2D_SLIDE || programType3 == ProgramType.TEXTURE_2D_AR_ALPHA) {
                int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix2");
                this.muTexMatrixLoc2 = glGetUniformLocation3;
                GlUtil.checkLocation(glGetUniformLocation3, "uTexMatrix2");
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
            this.muKernelLoc = glGetUniformLocation4;
            if (glGetUniformLocation4 < 0) {
                this.muKernelLoc = -1;
                this.muTexOffsetLoc = -1;
                this.muColorAdjustLoc = -1;
            } else {
                int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
                this.muTexOffsetLoc = glGetUniformLocation5;
                GlUtil.checkLocation(glGetUniformLocation5, "uTexOffset");
                int glGetUniformLocation6 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
                this.muColorAdjustLoc = glGetUniformLocation6;
                GlUtil.checkLocation(glGetUniformLocation6, "uColorAdjust");
                setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
                setTexSize(256, 256);
            }
            if (this.mProgramType == ProgramType.TEXTURE_2D_LINE) {
                this.muColorLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uColor");
                return;
            }
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public int createTexture2DObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GlUtil.checkGlError("glGenTextures");
            int i = iArr[0];
            GLES20.glBindTexture(this.mTextureTarget, i);
            GlUtil.checkGlError("glBindTexture " + i);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GlUtil.checkGlError("glTexParameter");
            return i;
        }
        return invokeV.intValue;
    }

    public int createTextureObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GlUtil.checkGlError("glGenTextures");
            int i = iArr[0];
            GLES20.glBindTexture(this.mTextureTarget, i);
            GlUtil.checkGlError("glBindTexture " + i);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GlUtil.checkGlError("glTexParameter");
            return i;
        }
        return invokeV.intValue;
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{fArr, floatBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fArr2, floatBuffer2, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.mTextureTarget, i5);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, i3, 5126, false, i4, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i6, (Buffer) floatBuffer2);
            GlUtil.checkGlError("glVertexAttribPointer");
            int i7 = this.muKernelLoc;
            if (i7 >= 0) {
                GLES20.glUniform1fv(i7, 9, this.mKernel, 0);
                GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
                GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
            }
            onDrawArraysPre();
            GLES20.glDrawArrays(5, i, i2);
            GlUtil.checkGlError("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.maPositionLoc);
            GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
            GLES20.glBindTexture(this.mTextureTarget, 0);
            GLES20.glUseProgram(0);
        }
    }

    public ProgramType getProgramType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mProgramType : (ProgramType) invokeV.objValue;
    }

    public int hexCharToDecimal(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Character.valueOf(c)})) == null) ? (c < 'A' || c > 'F') ? c - '0' : (c + '\n') - 65 : invokeCommon.intValue;
    }

    public int hexToDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i = (i * 16) + hexCharToDecimal(str.charAt(i2));
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void onDrawArraysPre() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "alpha"), this.mAlpha);
            if (this.mProgramType == ProgramType.TEXTURE_2D_BLEND) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "thresholdSensitivity"), 0.5f);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "smoothing"), 0.2f);
                GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.mProgramHandle, "colorToReplace"), 1, FloatBuffer.wrap(this.mColorToReplace));
            }
            if (this.mProgramType == ProgramType.TEXTURE_2D_HUMAN_SEGMENTATION) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.mProgramHandle, "maskMode"), this.mMaskMode);
                GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.mProgramHandle, "maskColor"), 1, FloatBuffer.wrap(this.mMaskColor));
            }
            ProgramType programType = this.mProgramType;
            if (programType == ProgramType.TEXTURE_2D_SLIDE || programType == ProgramType.TEXTURE_2D_X_BLUR) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "distance"), this.mDistance);
            }
            if (this.mProgramType == ProgramType.TEXTURE_2D_FOLLOW) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "dx"), this.mDx);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgramHandle, "dy"), this.mDy);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            w89.c("Grafika", "deleting program " + this.mProgramHandle);
            GLES20.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
    }

    public void setAlpha(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.mAlpha = f;
        }
    }

    public void setDistance(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            this.mDistance = f;
        }
    }

    public void setDxDy(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mDx = f;
            this.mDy = f2;
        }
    }

    public void setHumanSegMaskParams(int i, String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), str, Float.valueOf(f)}) == null) {
            this.mMaskMode = i;
            if (TextUtils.isEmpty(str) || str.length() < 6) {
                return;
            }
            try {
                String substring = str.substring(str.length() - 6, str.length() - 4);
                String substring2 = str.substring(str.length() - 4, str.length() - 2);
                String substring3 = str.substring(str.length() - 2, str.length());
                int hexToDecimal = hexToDecimal(substring.toUpperCase());
                int hexToDecimal2 = hexToDecimal(substring2.toUpperCase());
                int hexToDecimal3 = hexToDecimal(substring3.toUpperCase());
                this.mMaskColor[0] = (hexToDecimal * 1.0f) / 255.0f;
                this.mMaskColor[1] = (hexToDecimal2 * 1.0f) / 255.0f;
                this.mMaskColor[2] = (hexToDecimal3 * 1.0f) / 255.0f;
            } catch (Exception unused) {
                float[] fArr = this.mMaskColor;
                fArr[0] = 1.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
            }
            this.mMaskColor[3] = f;
        }
    }

    public void setKernel(float[] fArr, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048590, this, fArr, f) == null) {
            if (fArr.length == 9) {
                System.arraycopy(fArr, 0, this.mKernel, 0, 9);
                this.mColorAdjust = f;
                return;
            }
            throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
        }
    }

    public void setShaderBgColor(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str) || str.length() < 6) {
            return;
        }
        try {
            String substring = str.substring(str.length() - 6, str.length() - 4);
            String substring2 = str.substring(str.length() - 4, str.length() - 2);
            String substring3 = str.substring(str.length() - 2, str.length());
            int hexToDecimal = hexToDecimal(substring.toUpperCase());
            int hexToDecimal2 = hexToDecimal(substring2.toUpperCase());
            int hexToDecimal3 = hexToDecimal(substring3.toUpperCase());
            this.mColorToReplace[0] = (hexToDecimal * 1.0f) / 255.0f;
            this.mColorToReplace[1] = (hexToDecimal2 * 1.0f) / 255.0f;
            this.mColorToReplace[2] = (hexToDecimal3 * 1.0f) / 255.0f;
        } catch (Exception unused) {
            float[] fArr = this.mColorToReplace;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
        }
    }

    public void setTexSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            float f = 1.0f / i;
            float f2 = 1.0f / i2;
            float f3 = -f;
            float f4 = -f2;
            this.mTexOffset = new float[]{f3, f4, 0.0f, f4, f, f4, f3, 0.0f, 0.0f, 0.0f, f, 0.0f, f3, f2, 0.0f, f2, f, f2};
        }
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, int i7, float[] fArr3, FloatBuffer floatBuffer3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{fArr, floatBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fArr2, floatBuffer2, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), fArr3, floatBuffer3}) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.mTextureTarget, i5);
            GLES20.glUniform1i(this.mFilterInputTextureUniform, 0);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, i3, 5126, false, i4, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i6, (Buffer) floatBuffer2);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.mTextureTarget, i7);
            GLES20.glUniform1i(this.mFilterInputTextureUniform2, 1);
            if (this.mProgramType != ProgramType.TEXTURE_2D_FILTER) {
                GLES20.glUniformMatrix4fv(this.muTexMatrixLoc2, 1, false, fArr3, 0);
                GlUtil.checkGlError("glUniformMatrix4fv");
                GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc2);
                GlUtil.checkGlError("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(this.maTextureCoordLoc2, 2, 5126, false, i6, (Buffer) floatBuffer3);
                GlUtil.checkGlError("glVertexAttribPointer");
            }
            int i8 = this.muKernelLoc;
            if (i8 >= 0) {
                GLES20.glUniform1fv(i8, 9, this.mKernel, 0);
                GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
                GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
            }
            onDrawArraysPre();
            GLES20.glDrawArrays(5, i, i2);
            GlUtil.checkGlError("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.maPositionLoc);
            GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
            if (this.mProgramType != ProgramType.TEXTURE_2D_FILTER) {
                GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc2);
            }
            GLES20.glBindTexture(this.mTextureTarget, 0);
            GLES20.glUseProgram(0);
        }
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fArr, floatBuffer) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, 2, 5126, false, 0, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glUniform4f(this.muColorLocation, 1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glLineWidth(2.0f);
            GLES20.glDrawArrays(2, 0, 4);
        }
    }
}

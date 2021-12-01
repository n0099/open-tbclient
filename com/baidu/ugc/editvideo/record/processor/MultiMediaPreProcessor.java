package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.b.a.e;
import c.a.a0.b.a.g;
import c.a.x0.t.c;
import c.a.x0.t.h;
import c.a.x0.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import com.faceunity.gles.GeneratedTexture;
import java.io.File;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class MultiMediaPreProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FBO_SIZE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBgBitmap;
    public int mBgTextureId;
    public boolean mCompat;
    public int mCurrentFboIndex;
    public int[] mFboTexture2DIds;
    public int[] mFramebuffers;
    public String mLastBgRes;
    public long mPlayTime;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float[] mProjectionMatrix;
    public Map<String, ShaderConfig> mShaderConfigMap;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public boolean mTestSavePic;
    public int mTestSavePicCount;
    public List<MediaTrack> mUpdateMediaTracks;

    public MultiMediaPreProcessor() {
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
        this.mProjectionMatrix = new float[16];
        this.mTestSavePic = false;
    }

    public static float[] calculateModelView(MultiMediaData multiMediaData, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{multiMediaData, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? calculateModelView(multiMediaData, false, i2, i3, i4, i5, true) : (float[]) invokeCommon.objValue;
    }

    public static float[] calculateModelView(MultiMediaData multiMediaData, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{multiMediaData, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) ? calculateModelView(multiMediaData, false, i2, i3, i4, i5, z) : (float[]) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (r1 < 0.001d) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float[] calculateModelView(MultiMediaData multiMediaData, boolean z, int i2, int i3, int i4, int i5, boolean z2) {
        InterceptResult invokeCommon;
        CharSequence charSequence;
        float scaled;
        float f2;
        float f3;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z2)})) == null) {
            float f4 = (multiMediaData.rotation + multiMediaData.angle) % 360.0f;
            if (TextUtils.equals(multiMediaData.scaleType, "center_crop") || TextUtils.equals(multiMediaData.scaleType, "center_inside")) {
                charSequence = "adaptive";
                float f5 = (i2 * 1.0f) / i3;
                float f6 = (multiMediaData.width * 1.0f) / multiMediaData.height;
                if (f4 == 90.0f || f4 == 270.0f) {
                    f6 = 1.0f / f6;
                }
                String str = multiMediaData.scaleType;
                if (z2) {
                    float f7 = f6 - f5;
                    if (f7 <= 0.0f || f7 <= 0.001d) {
                        float f8 = f5 - f6;
                        if (f8 > 0.0f) {
                        }
                    }
                    str = "center_crop";
                }
                scaled = getScaled(multiMediaData.width, multiMediaData.height, i2, i3, f4, !TextUtils.equals(str, "center_crop"));
                f2 = 1.0f;
            } else {
                charSequence = "adaptive";
                float scaled2 = getScaled(multiMediaData.width, multiMediaData.height, i2, i3, f4, false);
                f2 = (i4 == 0 || !TextUtils.equals(multiMediaData.scaleType, charSequence)) ? 1.0f : (i2 * 1.0f) / i4;
                scaled = (scaled2 / ((i2 * 1.0f) / multiMediaData.width)) * f2;
            }
            float f9 = i2;
            float f10 = f9 / 2.0f;
            float f11 = i3;
            float f12 = f11 / 2.0f;
            if (TextUtils.equals(multiMediaData.scaleType, "top")) {
                int i8 = multiMediaData.height;
                f3 = ((i8 / 2.0f) + f11) - i8;
            } else if (TextUtils.equals(multiMediaData.scaleType, "bottom")) {
                int i9 = multiMediaData.height;
                f3 = f11 - (((i9 / 2.0f) + f11) - i9);
            } else if (TextUtils.equals(multiMediaData.scaleType, charSequence)) {
                float f13 = multiMediaData.x;
                float f14 = multiMediaData.y;
                if (i4 != 0) {
                    f13 = (f13 / i4) * f9;
                }
                if (i5 != 0) {
                    f14 = (multiMediaData.y / i5) * f11;
                }
                f10 = f13 + ((multiMediaData.width / 2.0f) * f2);
                f3 = (f11 - ((multiMediaData.height / 2.0f) * f2)) - f14;
                c.e("MultiMediaPreProcessor", "ADAPTIVE,x:" + multiMediaData.x + ",y:" + multiMediaData.y + ",posx:" + f10 + ",posy:" + f3 + ",previewwidth:" + i4 + ",previeheight:" + i5);
            } else if (multiMediaData.scaleType.contains(charSequence)) {
                int min = Math.min(i2, i3);
                float f15 = min;
                i6 = (multiMediaData.width * min) / 375;
                int i10 = (multiMediaData.height * min) / 375;
                int i11 = (int) ((multiMediaData.y * f15) / 375.0f);
                float f16 = (i6 * f2) / 2.0f;
                float f17 = (int) ((multiMediaData.x * f15) / 375.0f);
                float f18 = (f9 - f16) - f17;
                float f19 = (i10 * f2) / 2.0f;
                float f20 = i11;
                float f21 = (f11 - f19) - f20;
                float f22 = f16 + f17;
                float f23 = f19 + f20;
                if (TextUtils.equals(multiMediaData.scaleType, "adaptive_br")) {
                    f10 = f18;
                } else if (!TextUtils.equals(multiMediaData.scaleType, "adaptive_bl")) {
                    if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tl")) {
                        f12 = f21;
                        f10 = f22;
                    } else if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tr")) {
                        f10 = f18;
                        f12 = f21;
                    }
                    i7 = i10;
                    f3 = f12;
                    if (i6 <= 0) {
                        i6 = multiMediaData.width;
                    }
                    int ceil = (int) Math.ceil((i6 * scaled) / 2.0f);
                    if (i7 <= 0) {
                        i7 = multiMediaData.height;
                    }
                    int ceil2 = (int) Math.ceil((scaled * i7) / 2.0f);
                    float[] fArr = new float[16];
                    Matrix.setIdentityM(fArr, 0);
                    Matrix.translateM(fArr, 0, f10, f3, 1.0f);
                    if (multiMediaData.type == 0) {
                        float f24 = multiMediaData.rotation;
                        if (f24 == 0.0f || f24 == 180.0f) {
                            f4 += 180.0f;
                        }
                        Matrix.rotateM(fArr, 0, f4 % 360.0f, 0.0f, 0.0f, 1.0f);
                        ceil = -ceil;
                    } else {
                        Matrix.rotateM(fArr, 0, (f4 - multiMediaData.rotation) % 360.0f, 0.0f, 0.0f, 1.0f);
                        float f25 = multiMediaData.rotation;
                        if (f25 == 90.0f || f25 == 270.0f) {
                            ceil = ceil2;
                            ceil2 = ceil;
                        }
                    }
                    Matrix.scaleM(fArr, 0, ceil * multiMediaData.scaleX, ceil2 * multiMediaData.scaleY, 1.0f);
                    return fArr;
                } else {
                    f10 = f22;
                }
                f12 = f23;
                i7 = i10;
                f3 = f12;
                if (i6 <= 0) {
                }
                int ceil3 = (int) Math.ceil((i6 * scaled) / 2.0f);
                if (i7 <= 0) {
                }
                int ceil22 = (int) Math.ceil((scaled * i7) / 2.0f);
                float[] fArr2 = new float[16];
                Matrix.setIdentityM(fArr2, 0);
                Matrix.translateM(fArr2, 0, f10, f3, 1.0f);
                if (multiMediaData.type == 0) {
                }
                Matrix.scaleM(fArr2, 0, ceil3 * multiMediaData.scaleX, ceil22 * multiMediaData.scaleY, 1.0f);
                return fArr2;
            } else {
                float f26 = multiMediaData.x;
                float f27 = multiMediaData.y;
                if (i4 != 0) {
                    f26 = (f26 / i4) * f9;
                }
                if (i5 != 0) {
                    f27 = (multiMediaData.y / i5) * f11;
                }
                f10 += f26;
                f3 = f12 - f27;
            }
            i6 = 0;
            i7 = 0;
            if (i6 <= 0) {
            }
            int ceil32 = (int) Math.ceil((i6 * scaled) / 2.0f);
            if (i7 <= 0) {
            }
            int ceil222 = (int) Math.ceil((scaled * i7) / 2.0f);
            float[] fArr22 = new float[16];
            Matrix.setIdentityM(fArr22, 0);
            Matrix.translateM(fArr22, 0, f10, f3, 1.0f);
            if (multiMediaData.type == 0) {
            }
            Matrix.scaleM(fArr22, 0, ceil32 * multiMediaData.scaleX, ceil222 * multiMediaData.scaleY, 1.0f);
            return fArr22;
        }
        return (float[]) invokeCommon.objValue;
    }

    private boolean checkBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mBgBitmap != null) {
                return true;
            }
            if (h.e(this.mUpdateMediaTracks)) {
                return false;
            }
            for (int i2 = 1; i2 < this.mUpdateMediaTracks.size(); i2++) {
                MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i2);
                if (mediaTrack != null && (c.a.a0.b.a.k.c.m(mediaTrack, "user_background") || c.a.a0.b.a.k.c.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) || c.a.a0.b.a.k.c.m(mediaTrack, "only_background"))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean checkInitialFbo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int[] iArr = this.mFramebuffers;
            return iArr == null || this.mCurrentFboIndex >= iArr.length;
        }
        return invokeV.booleanValue;
    }

    private void drawBg(FullFrameRect fullFrameRect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fullFrameRect) == null) {
            if (this.mBgBitmap != null) {
                if (this.mBgTextureId == 0) {
                    this.mBgTextureId = fullFrameRect.createTexture2DObject();
                    GLUtils.texImage2D(3553, 0, this.mBgBitmap, 0);
                }
                int i2 = this.mBgTextureId;
                if (i2 != 0) {
                    fullFrameRect.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
                }
            }
            if (this.mUpdateMediaTracks != null) {
                for (int i3 = 1; i3 < this.mUpdateMediaTracks.size(); i3++) {
                    MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i3);
                    if (mediaTrack != null) {
                        List<MediaTrack> list = this.mUpdateMediaTracks;
                        String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
                        if (!c.a.a0.b.a.k.c.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                            str = "user_background";
                        }
                        if (c.a.a0.b.a.k.c.m(mediaTrack, str)) {
                            List<MediaSegment> list2 = mediaTrack.mediaSegments;
                            if (list2 != null) {
                                for (MediaSegment mediaSegment : list2) {
                                    if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                        long j2 = mediaSegment.start;
                                        long j3 = mediaSegment.end;
                                        if (j2 != j3) {
                                            long j4 = this.mPlayTime;
                                            if (j4 >= j2 && j4 <= j3) {
                                            }
                                        }
                                    }
                                    int i4 = mediaSegment.textureId;
                                    if (i4 != 0) {
                                        fullFrameRect.drawFrame(i4, GlUtil.IDENTITY_MATRIX);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    private void drawOneTransition(int i2, long j2, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, e eVar, MediaTrack mediaTrack, List<MultiMediaData> list) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), fullFrameRect, fullFrameRect2, eVar, mediaTrack, list}) == null) {
            List<MediaTransition> list2 = mediaTrack.mediaTransitions;
            if (list2 != null && list2.size() > i2) {
                MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i2);
                long j3 = mediaTransition.end;
                long j4 = j3 - mediaTransition.start;
                if (j4 > 0 && j3 - j2 < j4) {
                    ShaderConfig shaderConfig = this.mShaderConfigMap.get(mediaTransition.shaderConfigKey);
                    if (shaderConfig == null || shaderConfig.textures == null || list.size() <= (i3 = i2 + 1)) {
                        return;
                    }
                    int preDraw = preDraw(list.get(i3), fullFrameRect, fullFrameRect2, eVar, true, true, mediaTrack.glClearColor);
                    for (MediaTextureData mediaTextureData : shaderConfig.textures) {
                        if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                            mediaTextureData.textureId = preDraw;
                        }
                    }
                }
            }
        }
    }

    public static float getScaled(int i2, int i3, int i4, int i5, float f2, boolean z) {
        InterceptResult invokeCommon;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (z) {
                if (f2 == 90.0f || f2 == 270.0f) {
                    f4 = i5;
                    return (f4 * 1.0f) / i2;
                }
                f3 = i5;
                return (f3 * 1.0f) / i3;
            } else if (f2 == 90.0f || f2 == 270.0f) {
                f3 = i4;
                return (f3 * 1.0f) / i3;
            } else {
                f4 = i4;
                return (f4 * 1.0f) / i2;
            }
        }
        return invokeCommon.floatValue;
    }

    private void initialFbo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            int[] iArr = this.mFramebuffers;
            int length = iArr != null ? i2 + iArr.length : i2;
            int[] iArr2 = new int[length];
            int[] iArr3 = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr4 = this.mFramebuffers;
                if (iArr4 != null && iArr4.length > i3) {
                    iArr2[i3] = iArr4[i3];
                }
                int[] iArr5 = this.mFboTexture2DIds;
                if (iArr5 != null && iArr5.length > i3) {
                    iArr3[i3] = iArr5[i3];
                }
                if (iArr3[i3] == 0) {
                    GLES20.glGenFramebuffers(1, iArr2, i3);
                    GLES20.glGenTextures(1, iArr3, i3);
                    GLES20.glBindTexture(3553, iArr3[i3]);
                    GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mSurfaceViewWidth, this.mSurfaceViewHeight, 0, GeneratedTexture.FORMAT, 5121, null);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glBindFramebuffer(36160, iArr2[i3]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[i3], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
            }
            this.mFramebuffers = iArr2;
            this.mFboTexture2DIds = iArr3;
        }
    }

    private int preDraw(MultiMediaData multiMediaData, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, e eVar, boolean z, boolean z2, float[] fArr) {
        InterceptResult invokeCommon;
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{multiMediaData, fullFrameRect, fullFrameRect2, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), fArr})) == null) {
            if (multiMediaData != null && (surfaceTexture = multiMediaData.surfaceTexture) != null) {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(multiMediaData.mtx);
            }
            boolean checkBg = checkBg();
            if (z2 && checkBg && eVar != null && this.mUpdateMediaTracks != null) {
                int i2 = 1;
                while (true) {
                    if (i2 >= this.mUpdateMediaTracks.size()) {
                        break;
                    }
                    MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i2);
                    if (mediaTrack != null) {
                        List<MediaTrack> list = this.mUpdateMediaTracks;
                        String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
                        if (!c.a.a0.b.a.k.c.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                            str = "user_background";
                        }
                        if (c.a.a0.b.a.k.c.m(mediaTrack, str)) {
                            List<MediaSegment> list2 = mediaTrack.mediaSegments;
                            if (list2 != null) {
                                for (MediaSegment mediaSegment : list2) {
                                    if (TextUtils.equals(mediaSegment.type, "input")) {
                                        processGaussianBlurBg(multiMediaData, eVar, mediaTrack, mediaSegment, fullFrameRect2);
                                    }
                                }
                            }
                        }
                    }
                    i2++;
                }
            }
            if (checkInitialFbo()) {
                initialFbo(2);
            }
            GLES20.glBindFramebuffer(36160, this.mFramebuffers[this.mCurrentFboIndex]);
            GLES20.glViewport(0, 0, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            GLES20.glClearColor(fArr[0], fArr[1], fArr[2], (!z || checkBg) ? fArr[3] : 1.0f);
            GLES20.glClear(16640);
            FullFrameRect fullFrameRect3 = fullFrameRect;
            if (z2) {
                drawBg(fullFrameRect3);
            }
            if (multiMediaData != null && multiMediaData.width > 0 && multiMediaData.height > 0) {
                float[] fArr2 = new float[16];
                Matrix.setIdentityM(fArr2, 0);
                Matrix.multiplyMM(fArr2, 0, this.mProjectionMatrix, 0, calculateModelView(multiMediaData, z, this.mSurfaceViewWidth, this.mSurfaceViewHeight, this.mPreviewWidth, this.mPreviewHeight, true), 0);
                if (multiMediaData.type != 0) {
                    fullFrameRect3 = fullFrameRect2;
                }
                fullFrameRect3.setVertexPoint(fArr2);
                fullFrameRect3.drawFrame(multiMediaData.textureId, multiMediaData.mtx);
                Matrix.setIdentityM(fArr2, 0);
                fullFrameRect3.setVertexPoint(fArr2);
            }
            GLES20.glBindFramebuffer(36160, 0);
            int[] iArr = this.mFboTexture2DIds;
            int i3 = this.mCurrentFboIndex;
            int i4 = iArr[i3];
            this.mCurrentFboIndex = i3 + 1;
            return i4;
        }
        return invokeCommon.intValue;
    }

    private int preDraw(MultiMediaData multiMediaData, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, boolean z, boolean z2, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{multiMediaData, fullFrameRect, fullFrameRect2, Boolean.valueOf(z), Boolean.valueOf(z2), fArr})) == null) ? preDraw(multiMediaData, fullFrameRect, fullFrameRect2, null, z, z2, fArr) : invokeCommon.intValue;
    }

    private int preDrawBlendVideo(MultiMediaData multiMediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, multiMediaData)) == null) {
            SurfaceTexture surfaceTexture = multiMediaData.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(multiMediaData.mtx);
                return multiMediaData.textureId;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void processGaussianBlurBg(MultiMediaData multiMediaData, e eVar, MediaTrack mediaTrack, MediaSegment mediaSegment, FullFrameRect fullFrameRect) {
        float[] fArr;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65549, this, multiMediaData, eVar, mediaTrack, mediaSegment, fullFrameRect) == null) || multiMediaData == null || eVar == null) {
            return;
        }
        float[] fArr2 = mediaTrack.glClearColor;
        float f2 = fArr2[0];
        float f3 = fArr2[1];
        float f4 = (multiMediaData.rotation + multiMediaData.angle) % 360.0f;
        float f5 = (this.mSurfaceViewWidth * 1.0f) / this.mSurfaceViewHeight;
        float f6 = (multiMediaData.width * 1.0f) / multiMediaData.height;
        if (f4 == 90.0f || f4 == 270.0f) {
            f6 = 1.0f / f6;
        }
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        float f7 = 1.0f / f2;
        int i3 = (int) (this.mSurfaceViewWidth * f7);
        int i4 = (int) (this.mSurfaceViewHeight * f7);
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float f8 = i3;
        float f9 = f8 / 2.0f;
        float f10 = i4;
        float f11 = f10 / 2.0f;
        float scaled = getScaled(multiMediaData.width, multiMediaData.height, i3, i4, f4, f5 <= f6);
        int round = Math.round(multiMediaData.width * scaled) / 2;
        int round2 = Math.round(scaled * multiMediaData.height) / 2;
        Matrix.translateM(fArr4, 0, f9, f11, 1.0f);
        if (multiMediaData.type == 0) {
            float f12 = multiMediaData.rotation;
            if (f12 == 0.0f || f12 == 180.0f) {
                f4 += 180.0f;
            }
            Matrix.rotateM(fArr4, 0, f4 % 360.0f, 0.0f, 0.0f, 1.0f);
            round *= -1;
        } else {
            Matrix.rotateM(fArr4, 0, (f4 - multiMediaData.rotation) % 360.0f, 0.0f, 0.0f, 1.0f);
            float f13 = multiMediaData.rotation;
            if (f13 == 90.0f || f13 == 270.0f) {
                round = round2;
                round2 = round;
            }
        }
        Matrix.scaleM(fArr4, 0, round, round2, 1.0f);
        float[] fArr5 = new float[16];
        Matrix.orthoM(fArr5, 0, 0.0f, f8, 0.0f, f10, -1.0f, 1.0f);
        Matrix.multiplyMM(fArr3, 0, fArr5, 0, fArr4, 0);
        int i5 = multiMediaData.textureId;
        float[] fArr6 = multiMediaData.mtx;
        if (multiMediaData.type == 1) {
            if (checkInitialFbo()) {
                initialFbo(2);
            }
            GLES20.glBindFramebuffer(36160, this.mFramebuffers[this.mCurrentFboIndex]);
            GLES20.glViewport(0, 0, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            if (multiMediaData.width <= 0 || multiMediaData.height <= 0) {
                fArr = fArr3;
            } else {
                fArr = fArr3;
                fullFrameRect.setVertexPoint(fArr);
                fullFrameRect.drawFrame(multiMediaData.textureId, fArr6);
                Matrix.setIdentityM(fArr, 0);
                fullFrameRect.setVertexPoint(fArr);
            }
            Matrix.setIdentityM(fArr, 0);
            float[] fArr7 = g.f1277b;
            GLES20.glBindFramebuffer(36160, 0);
            int[] iArr = this.mFboTexture2DIds;
            int i6 = this.mCurrentFboIndex;
            i2 = iArr[i6];
            this.mCurrentFboIndex = i6 + 1;
            fArr6 = fArr7;
        } else {
            fArr = fArr3;
            i2 = i5;
        }
        mediaSegment.textureId = eVar.k(i2, fArr, fArr6, i3, i4, f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgRes(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65550, this, str) != null) {
            return;
        }
        String str2 = this.mLastBgRes;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        Bitmap bitmap = null;
        Bitmap decodeFile = str != null ? BitmapFactory.decodeFile(str) : null;
        if (decodeFile == null) {
            Bitmap bitmap2 = this.mBgBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mBgBitmap.recycle();
            }
            this.mLastBgRes = str;
            if (decodeFile != null && !decodeFile.isRecycled()) {
                decodeFile.recycle();
            }
            i2 = this.mBgTextureId;
            if (i2 == 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.mBgTextureId = 0;
                return;
            }
            return;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(180.0f);
        bitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        this.mBgBitmap = bitmap;
        this.mLastBgRes = str;
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        i2 = this.mBgTextureId;
        if (i2 == 0) {
        }
    }

    private void setTextureData(MultiMediaData multiMediaData, String str, int i2) {
        ShaderConfig shaderConfig;
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65551, this, multiMediaData, str, i2) == null) || TextUtils.isEmpty(str) || (shaderConfig = this.mShaderConfigMap.get(str)) == null || (list = shaderConfig.textures) == null || list.size() <= 0) {
            return;
        }
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            if (!TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_VIDEO) && TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                mediaTextureData.textureId = multiMediaData.textureId;
            } else {
                mediaTextureData.textureId = i2;
            }
        }
    }

    private void testPic(MultiMediaData multiMediaData) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, multiMediaData) == null) && this.mTestSavePic && (i2 = this.mTestSavePicCount) < 1) {
            if (i2 == 0) {
                u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaPreProcessor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            FileUtils.deleteFileOrDir(new File("/sdcard/zhmy/"));
                        }
                    }
                });
            }
            StringBuilder sb = new StringBuilder();
            sb.append("test-");
            sb.append(this.mTestSavePicCount);
            sb.append("—");
            sb.append(System.currentTimeMillis());
            if (multiMediaData == null || multiMediaData.surfaceTexture == null) {
                str = "";
            } else {
                str = "-" + multiMediaData.surfaceTexture.getTimestamp();
            }
            sb.append(str);
            sb.append(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
            ThreadPool.b().e(new Runnable(this, sb.toString(), MultiDataSourceUtil.saveOffscreenBitmap(this.mSurfaceViewWidth, this.mSurfaceViewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaPreProcessor this$0;
                public final /* synthetic */ Bitmap val$bitmap;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$name = r7;
                    this.val$bitmap = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FileUtils.saveBitmap2PNG("/sdcard/zhmy/", this.val$name, this.val$bitmap, 100);
                    }
                }
            });
            this.mTestSavePicCount++;
        }
    }

    public void destroyFramebuffers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int[] iArr = this.mFboTexture2DIds;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.mFboTexture2DIds = null;
            }
            int[] iArr2 = this.mFramebuffers;
            if (iArr2 != null) {
                GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.mFramebuffers = null;
            }
            int i2 = this.mBgTextureId;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.mBgTextureId = 0;
            }
        }
    }

    public void initFrameBuffers(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        if (this.mSurfaceViewWidth == i2 && this.mSurfaceViewHeight == i3) {
            return;
        }
        this.mSurfaceViewWidth = i2;
        this.mSurfaceViewHeight = i3;
        Matrix.orthoM(this.mProjectionMatrix, 0, 0.0f, i2, 0.0f, i3, -1.0f, 1.0f);
        destroyFramebuffers();
        initialFbo(2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int preProcess(List<MultiMediaDataTrack> list, int i2, long j2, OnDrawUpdateTextureListener onDrawUpdateTextureListener) {
        InterceptResult invokeCommon;
        MediaTrack mediaTrack;
        int i3;
        int i4;
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        List<MediaTrack> list2;
        MultiMediaData multiMediaData3;
        int i5;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaTrack mediaTrack2;
        int i6;
        MediaSegment mediaSegment3;
        MultiMediaData multiMediaData4;
        MediaAEffect mediaAEffect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j2), onDrawUpdateTextureListener})) == null) {
            FullFrameRect fullFrameRect2D = onDrawUpdateTextureListener.getFullFrameRect2D();
            FullFrameRect fullFrameRectEXT = onDrawUpdateTextureListener.getFullFrameRectEXT();
            e vlogCore = onDrawUpdateTextureListener.getVlogCore();
            int i7 = 0;
            this.mCurrentFboIndex = 0;
            this.mPlayTime = j2;
            if (h.e(list)) {
                return 0;
            }
            List<MediaTrack> list3 = this.mUpdateMediaTracks;
            if (list3 != null && list3.size() == list.size()) {
                int i8 = 1;
                while (i8 < this.mUpdateMediaTracks.size()) {
                    MediaTrack mediaTrack3 = this.mUpdateMediaTracks.get(i8);
                    MultiMediaDataTrack multiMediaDataTrack2 = list.get(i8);
                    List<MultiMediaData> list4 = multiMediaDataTrack2.multiMediaDataList;
                    if (list4 != null && mediaTrack3.mediaSegments != null && list4.size() == mediaTrack3.mediaSegments.size() && (!this.mCompat || !c.a.a0.b.a.k.c.m(mediaTrack3, "edit_sticker"))) {
                        int i9 = 0;
                        while (i9 < multiMediaDataTrack2.multiMediaDataList.size()) {
                            MultiMediaData multiMediaData5 = multiMediaDataTrack2.multiMediaDataList.get(i9);
                            MediaSegment mediaSegment4 = mediaTrack3.mediaSegments.get(i9);
                            if (multiMediaData5.textureId != 0) {
                                if (TextUtils.equals(mediaSegment4.type, "blend")) {
                                    i7 = preDrawBlendVideo(multiMediaData5);
                                } else {
                                    multiMediaData3 = multiMediaData5;
                                    i5 = i9;
                                    multiMediaDataTrack = multiMediaDataTrack2;
                                    mediaTrack2 = mediaTrack3;
                                    i6 = i8;
                                    int preDraw = preDraw(multiMediaData5, fullFrameRect2D, fullFrameRectEXT, TextUtils.equals("multi_input", mediaTrack3.trackType), false, mediaTrack3.glClearColor);
                                    mediaSegment3 = mediaSegment4;
                                    mediaSegment3.textureId = preDraw;
                                    if (TextUtils.isEmpty(mediaSegment3.shaderConfigKey)) {
                                        multiMediaData4 = multiMediaData3;
                                        setTextureData(multiMediaData4, mediaSegment3.shaderConfigKey, mediaSegment3.textureId);
                                    } else {
                                        multiMediaData4 = multiMediaData3;
                                    }
                                    mediaAEffect = mediaSegment3.mediaAEffect;
                                    if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                                        setTextureData(multiMediaData4, mediaSegment3.mediaAEffect.shaderConfigKey, mediaSegment3.textureId);
                                    }
                                    i9 = i5 + 1;
                                    i8 = i6;
                                    multiMediaDataTrack2 = multiMediaDataTrack;
                                    mediaTrack3 = mediaTrack2;
                                    i7 = 0;
                                }
                            }
                            mediaSegment4.textureId = i7;
                            multiMediaData3 = multiMediaData5;
                            i5 = i9;
                            multiMediaDataTrack = multiMediaDataTrack2;
                            mediaTrack2 = mediaTrack3;
                            i6 = i8;
                            mediaSegment3 = mediaSegment4;
                            if (TextUtils.isEmpty(mediaSegment3.shaderConfigKey)) {
                            }
                            mediaAEffect = mediaSegment3.mediaAEffect;
                            if (mediaAEffect != null) {
                                setTextureData(multiMediaData4, mediaSegment3.mediaAEffect.shaderConfigKey, mediaSegment3.textureId);
                            }
                            i9 = i5 + 1;
                            i8 = i6;
                            multiMediaDataTrack2 = multiMediaDataTrack;
                            mediaTrack3 = mediaTrack2;
                            i7 = 0;
                        }
                    }
                    i8++;
                    i7 = 0;
                }
            }
            if (list.get(0) != null && list.get(0).multiMediaDataList.size() > i2) {
                List<MultiMediaData> list5 = list.get(0).multiMediaDataList;
                MultiMediaData multiMediaData6 = list5.get(i2);
                if (this.mShaderConfigMap != null && (list2 = this.mUpdateMediaTracks) != null && list2.size() > 0) {
                    mediaTrack = this.mUpdateMediaTracks.get(0);
                    int preDraw2 = c.a.a0.b.a.k.c.m(mediaTrack, "input_blank") ? preDraw(null, fullFrameRect2D, fullFrameRectEXT, true, true, mediaTrack.glClearColor) : preDraw(multiMediaData6, fullFrameRect2D, fullFrameRectEXT, vlogCore, true, true, mediaTrack.glClearColor);
                    List<MediaSegment> list6 = mediaTrack.mediaSegments;
                    if (list6 == null || list6.size() <= i2) {
                        i4 = preDraw2;
                    } else {
                        mediaTrack.mediaSegments.get(i2).textureId = preDraw2;
                        i4 = preDraw2;
                        drawOneTransition(i2, j2, fullFrameRect2D, fullFrameRectEXT, vlogCore, mediaTrack, list5);
                    }
                    i3 = 0;
                    multiMediaData = list.get(i3).multiMediaDataSuperpositionHeader;
                    if (mediaTrack != null && (mediaSegment2 = mediaTrack.superpositionHeader) != null && multiMediaData != null) {
                        if (multiMediaData.textureId != 0) {
                            mediaSegment2.textureId = i3;
                        } else {
                            mediaSegment2.textureId = multiMediaData.type == 1 ? preDrawBlendVideo(multiMediaData) : preDraw(multiMediaData, fullFrameRect2D, fullFrameRectEXT, false, false, mediaTrack.glClearColor);
                            i3 = 0;
                        }
                    }
                    multiMediaData2 = list.get(i3).multiMediaDataSuperpositionFooter;
                    if (mediaTrack != null && (mediaSegment = mediaTrack.superpositionFooter) != null && multiMediaData2 != null) {
                        if (multiMediaData2.textureId != 0) {
                            i3 = multiMediaData2.type == 1 ? preDrawBlendVideo(multiMediaData2) : preDraw(multiMediaData2, fullFrameRect2D, fullFrameRectEXT, false, false, mediaTrack.glClearColor);
                        }
                        mediaSegment.textureId = i3;
                    }
                    return i4;
                }
            }
            mediaTrack = null;
            i3 = 0;
            i4 = 0;
            multiMediaData = list.get(i3).multiMediaDataSuperpositionHeader;
            if (mediaTrack != null) {
                if (multiMediaData.textureId != 0) {
                }
            }
            multiMediaData2 = list.get(i3).multiMediaDataSuperpositionFooter;
            if (mediaTrack != null) {
                if (multiMediaData2.textureId != 0) {
                }
                mediaSegment.textureId = i3;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public void setCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mCompat = z;
        }
    }

    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mediaTrackConfig) == null) || mediaTrackConfig == null) {
            return;
        }
        setBgRes(mediaTrackConfig.bgRes);
    }

    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
        }
    }

    public void setShaderConfigMap(Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            this.mShaderConfigMap = map;
        }
    }

    public void setUpdateMediaTracks(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mUpdateMediaTracks = list;
        }
    }
}

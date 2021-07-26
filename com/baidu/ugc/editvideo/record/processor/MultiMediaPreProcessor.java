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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.faceunity.gles.GeneratedTexture;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import d.a.w0.t.c;
import d.a.w0.t.h;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
        if (r15 < 0.001d) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float[] calculateModelView(MultiMediaData multiMediaData, boolean z, int i2, int i3, int i4, int i5, boolean z2) {
        InterceptResult invokeCommon;
        float f2;
        float f3;
        float f4;
        int i6;
        int i7;
        int i8;
        int i9;
        float f5;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z2)})) == null) {
            float f6 = (multiMediaData.rotation + multiMediaData.angle) % 360.0f;
            if (TextUtils.equals(multiMediaData.scaleType, "center_crop") || TextUtils.equals(multiMediaData.scaleType, "center_inside")) {
                float f7 = i2 * 1.0f;
                float f8 = i3;
                float f9 = f7 / f8;
                int i11 = (f6 > 90.0f ? 1 : (f6 == 90.0f ? 0 : -1));
                float f10 = (i11 == 0 || f6 == 270.0f) ? (multiMediaData.height * 1.0f) / multiMediaData.width : (multiMediaData.width * 1.0f) / multiMediaData.height;
                String str = multiMediaData.scaleType;
                if (z2) {
                    if (f9 >= f10) {
                        float f11 = f9 - f10;
                        if (f11 > 0.0f) {
                        }
                    }
                    str = "center_crop";
                }
                if (!TextUtils.equals(str, "center_crop")) {
                    if (i11 == 0 || f6 == 270.0f) {
                        f4 = f8 * 1.0f;
                        i6 = multiMediaData.width;
                    } else {
                        f4 = f8 * 1.0f;
                        i6 = multiMediaData.height;
                    }
                    f2 = f4 / i6;
                } else {
                    f2 = f7 / ((i11 == 0 || f6 == 270.0f) ? multiMediaData.height : multiMediaData.width);
                }
                f3 = 1.0f;
            } else {
                if (f6 == 90.0f || f6 == 270.0f) {
                    f5 = i2 * 1.0f;
                    i10 = multiMediaData.height;
                } else {
                    f5 = i2 * 1.0f;
                    i10 = multiMediaData.width;
                }
                float f12 = f5 / i10;
                f3 = (i4 == 0 || !TextUtils.equals(multiMediaData.scaleType, "adaptive")) ? 1.0f : (i2 * 1.0f) / i4;
                f2 = (f12 / ((i2 * 1.0f) / multiMediaData.width)) * f3;
            }
            float f13 = i2;
            float f14 = f13 / 2.0f;
            float f15 = i3;
            float f16 = f15 / 2.0f;
            if (TextUtils.equals(multiMediaData.scaleType, "top")) {
                int i12 = multiMediaData.height;
                f16 = ((i12 / 2.0f) + f15) - i12;
            } else if (TextUtils.equals(multiMediaData.scaleType, TipsConfigItem.TipConfigData.BOTTOM)) {
                int i13 = multiMediaData.height;
                f16 = f15 - (((i13 / 2.0f) + f15) - i13);
            } else if (!TextUtils.equals(multiMediaData.scaleType, "adaptive")) {
                if (TextUtils.equals(multiMediaData.scaleType, "adaptive_br")) {
                    int min = Math.min(i2, i3);
                    float f17 = min;
                    i7 = (multiMediaData.width * min) / 375;
                    i8 = (multiMediaData.height * min) / 375;
                    f14 = (f13 - ((i7 * f3) / 2.0f)) - ((int) ((multiMediaData.x * f17) / 375.0f));
                    f16 = ((i8 * f3) / 2.0f) + ((int) ((multiMediaData.y * f17) / 375.0f));
                } else {
                    if (TextUtils.equals(multiMediaData.scaleType, "adaptive_bl")) {
                        int min2 = Math.min(i2, i3);
                        float f18 = min2;
                        i9 = (multiMediaData.width * min2) / 375;
                        i8 = (multiMediaData.height * min2) / 375;
                        f14 = ((i9 * f3) / 2.0f) + ((int) ((multiMediaData.x * f18) / 375.0f));
                        f16 = ((i8 * f3) / 2.0f) + ((int) ((multiMediaData.y * f18) / 375.0f));
                    } else if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tl")) {
                        int min3 = Math.min(i2, i3);
                        float f19 = min3;
                        i9 = (multiMediaData.width * min3) / 375;
                        i8 = (multiMediaData.height * min3) / 375;
                        f14 = ((i9 * f3) / 2.0f) + ((int) ((multiMediaData.x * f19) / 375.0f));
                        f16 = (f15 - ((i8 * f3) / 2.0f)) - ((int) ((multiMediaData.y * f19) / 375.0f));
                    } else if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tr")) {
                        int min4 = Math.min(i2, i3);
                        float f20 = min4;
                        i7 = (multiMediaData.width * min4) / 375;
                        i8 = (multiMediaData.height * min4) / 375;
                        f14 = (f13 - ((i7 * f3) / 2.0f)) - ((int) ((multiMediaData.x * f20) / 375.0f));
                        f16 = (f15 - ((i8 * f3) / 2.0f)) - ((int) ((multiMediaData.y * f20) / 375.0f));
                    }
                    i7 = i9;
                }
                if (i7 <= 0) {
                    i7 = multiMediaData.width;
                }
                int round = Math.round(i7 * f2) / 2;
                if (i8 <= 0) {
                    i8 = multiMediaData.height;
                }
                int round2 = Math.round(f2 * i8) / 2;
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                Matrix.translateM(fArr, 0, f14, f16, 1.0f);
                if (multiMediaData.type != 0) {
                    float f21 = multiMediaData.rotation;
                    if (f21 == 0.0f || f21 == 180.0f) {
                        f6 += 180.0f;
                    }
                    Matrix.rotateM(fArr, 0, f6 % 360.0f, 0.0f, 0.0f, 1.0f);
                    round = -round;
                } else {
                    Matrix.rotateM(fArr, 0, (f6 - multiMediaData.rotation) % 360.0f, 0.0f, 0.0f, 1.0f);
                    float f22 = multiMediaData.rotation;
                    if (f22 == 90.0f || f22 == 270.0f) {
                        round = round2;
                        round2 = round;
                    }
                }
                Matrix.scaleM(fArr, 0, round * multiMediaData.scaleX, round2 * multiMediaData.scaleY, 1.0f);
                return fArr;
            } else {
                float f23 = multiMediaData.x;
                float f24 = multiMediaData.y;
                if (i4 != 0) {
                    f23 = (f23 / i4) * f13;
                }
                if (i5 != 0) {
                    f24 = (multiMediaData.y / i5) * f15;
                }
                f14 = ((multiMediaData.width / 2.0f) * f3) + f23;
                f16 = (f15 - ((multiMediaData.height / 2.0f) * f3)) - f24;
                c.e("MultiMediaPreProcessor", "ADAPTIVE,x:" + multiMediaData.x + ",y:" + multiMediaData.y + ",posx:" + f14 + ",posy:" + f16 + ",previewwidth:" + i4 + ",previeheight:" + i5);
            }
            i8 = 0;
            i7 = 0;
            if (i7 <= 0) {
            }
            int round3 = Math.round(i7 * f2) / 2;
            if (i8 <= 0) {
            }
            int round22 = Math.round(f2 * i8) / 2;
            float[] fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
            Matrix.translateM(fArr2, 0, f14, f16, 1.0f);
            if (multiMediaData.type != 0) {
            }
            Matrix.scaleM(fArr2, 0, round3 * multiMediaData.scaleX, round22 * multiMediaData.scaleY, 1.0f);
            return fArr2;
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
                if (mediaTrack != null && (d.a.a0.b.a.k.c.l(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) || d.a.a0.b.a.k.c.l(mediaTrack, "only_background"))) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int[] iArr = this.mFramebuffers;
            return iArr == null || this.mCurrentFboIndex >= iArr.length;
        }
        return invokeV.booleanValue;
    }

    private void drawBg(FullFrameRect fullFrameRect, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, fullFrameRect, z) == null) && z) {
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
                    if (mediaTrack != null && d.a.a0.b.a.k.c.l(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                        for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                            if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                long j = mediaSegment.start;
                                long j2 = mediaSegment.end;
                                if (j != j2) {
                                    long j3 = this.mPlayTime;
                                    if (j3 >= j && j3 <= j2) {
                                    }
                                }
                            }
                            GLES20.glEnable(3042);
                            GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
                            fullFrameRect.drawFrame(mediaSegment.textureId, GlUtil.IDENTITY_MATRIX);
                            GLES20.glDisable(3042);
                        }
                        return;
                    }
                }
            }
        }
    }

    private void drawOneTransition(int i2, long j, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, MediaTrack mediaTrack, List<MultiMediaData> list) {
        List<MediaTransition> list2;
        ShaderConfig shaderConfig;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), fullFrameRect, fullFrameRect2, mediaTrack, list}) == null) || (list2 = mediaTrack.mediaTransitions) == null || list2.size() <= i2) {
            return;
        }
        MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i2);
        long j2 = mediaTransition.end;
        long j3 = j2 - mediaTransition.start;
        if (j3 <= 0 || j2 - j >= j3 || (shaderConfig = this.mShaderConfigMap.get(mediaTransition.shaderConfigKey)) == null || shaderConfig.textures == null || list.size() <= (i3 = i2 + 1)) {
            return;
        }
        int preDraw = preDraw(list.get(i3), fullFrameRect, fullFrameRect2, true, true, mediaTrack.glClearColor);
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                mediaTextureData.textureId = preDraw;
            }
        }
    }

    private void initialFbo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
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

    private int preDraw(MultiMediaData multiMediaData, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, boolean z, boolean z2, float[] fArr) {
        InterceptResult invokeCommon;
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{multiMediaData, fullFrameRect, fullFrameRect2, Boolean.valueOf(z), Boolean.valueOf(z2), fArr})) == null) {
            if (checkInitialFbo()) {
                initialFbo(2);
            }
            if (multiMediaData != null && (surfaceTexture = multiMediaData.surfaceTexture) != null) {
                surfaceTexture.updateTexImage();
                if (surfaceTexture.getTimestamp() != 0 || this.mPreviewWidth != 0) {
                    surfaceTexture.getTransformMatrix(multiMediaData.mtx);
                }
            }
            GLES20.glBindFramebuffer(36160, this.mFramebuffers[this.mCurrentFboIndex]);
            GLES20.glViewport(0, 0, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            GLES20.glClearColor(fArr[0], fArr[1], fArr[2], (!z || checkBg()) ? fArr[3] : 1.0f);
            GLES20.glClear(16640);
            FullFrameRect fullFrameRect3 = fullFrameRect;
            drawBg(fullFrameRect3, z2);
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
            int i2 = this.mCurrentFboIndex;
            int i3 = iArr[i2];
            this.mCurrentFboIndex = i2 + 1;
            return i3;
        }
        return invokeCommon.intValue;
    }

    private int preDrawBlendVideo(MultiMediaData multiMediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, multiMediaData)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgRes(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65547, this, str) != null) {
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
        if (!(interceptable == null || interceptable.invokeLLI(65548, this, multiMediaData, str, i2) == null) || TextUtils.isEmpty(str) || (shaderConfig = this.mShaderConfigMap.get(str)) == null || (list = shaderConfig.textures) == null || list.size() <= 0) {
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int preProcess(List<MultiMediaDataTrack> list, int i2, long j, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        InterceptResult invokeCommon;
        MediaTrack mediaTrack;
        int i3;
        int i4;
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        List<MediaTrack> list2;
        MediaSegment mediaSegment3;
        MultiMediaData multiMediaData3;
        int i5;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaAEffect mediaAEffect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j), fullFrameRect, fullFrameRect2})) == null) {
            int i6 = 0;
            this.mCurrentFboIndex = 0;
            this.mPlayTime = j;
            if (h.e(list)) {
                return 0;
            }
            List<MediaTrack> list3 = this.mUpdateMediaTracks;
            if (list3 != null && list3.size() == list.size()) {
                int i7 = 1;
                while (i7 < this.mUpdateMediaTracks.size()) {
                    MediaTrack mediaTrack2 = this.mUpdateMediaTracks.get(i7);
                    MultiMediaDataTrack multiMediaDataTrack2 = list.get(i7);
                    List<MultiMediaData> list4 = multiMediaDataTrack2.multiMediaDataList;
                    if (list4 != null && mediaTrack2.mediaSegments != null && list4.size() == mediaTrack2.mediaSegments.size() && (!this.mCompat || !d.a.a0.b.a.k.c.l(mediaTrack2, "edit_sticker"))) {
                        int i8 = 0;
                        while (i8 < multiMediaDataTrack2.multiMediaDataList.size()) {
                            MultiMediaData multiMediaData4 = multiMediaDataTrack2.multiMediaDataList.get(i8);
                            MediaSegment mediaSegment4 = mediaTrack2.mediaSegments.get(i8);
                            if (multiMediaData4.textureId == 0) {
                                mediaSegment4.textureId = i6;
                            } else if (TextUtils.equals(mediaSegment4.type, "blend")) {
                                mediaSegment4.textureId = preDrawBlendVideo(multiMediaData4);
                            } else {
                                mediaSegment3 = mediaSegment4;
                                multiMediaData3 = multiMediaData4;
                                i5 = i8;
                                multiMediaDataTrack = multiMediaDataTrack2;
                                mediaSegment3.textureId = preDraw(multiMediaData4, fullFrameRect, fullFrameRect2, TextUtils.equals("multi_input", mediaTrack2.trackType), false, mediaTrack2.glClearColor);
                                if (!TextUtils.isEmpty(mediaSegment3.shaderConfigKey)) {
                                    setTextureData(multiMediaData3, mediaSegment3.shaderConfigKey, mediaSegment3.textureId);
                                }
                                mediaAEffect = mediaSegment3.mediaAEffect;
                                if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                                    setTextureData(multiMediaData3, mediaSegment3.mediaAEffect.shaderConfigKey, mediaSegment3.textureId);
                                }
                                i8 = i5 + 1;
                                multiMediaDataTrack2 = multiMediaDataTrack;
                                i6 = 0;
                            }
                            mediaSegment3 = mediaSegment4;
                            multiMediaData3 = multiMediaData4;
                            i5 = i8;
                            multiMediaDataTrack = multiMediaDataTrack2;
                            if (!TextUtils.isEmpty(mediaSegment3.shaderConfigKey)) {
                            }
                            mediaAEffect = mediaSegment3.mediaAEffect;
                            if (mediaAEffect != null) {
                                setTextureData(multiMediaData3, mediaSegment3.mediaAEffect.shaderConfigKey, mediaSegment3.textureId);
                            }
                            i8 = i5 + 1;
                            multiMediaDataTrack2 = multiMediaDataTrack;
                            i6 = 0;
                        }
                    }
                    i7++;
                    i6 = 0;
                }
            }
            if (list.get(0) != null && list.get(0).multiMediaDataList.size() > i2) {
                List<MultiMediaData> list5 = list.get(0).multiMediaDataList;
                MultiMediaData multiMediaData5 = list5.get(i2);
                if (this.mShaderConfigMap != null && (list2 = this.mUpdateMediaTracks) != null && list2.size() > 0) {
                    mediaTrack = this.mUpdateMediaTracks.get(0);
                    i4 = d.a.a0.b.a.k.c.l(mediaTrack, "input_blank") ? preDraw(null, fullFrameRect, fullFrameRect2, true, true, mediaTrack.glClearColor) : preDraw(multiMediaData5, fullFrameRect, fullFrameRect2, true, true, mediaTrack.glClearColor);
                    List<MediaSegment> list6 = mediaTrack.mediaSegments;
                    if (list6 != null && list6.size() > i2) {
                        mediaTrack.mediaSegments.get(i2).textureId = i4;
                        drawOneTransition(i2, j, fullFrameRect, fullFrameRect2, mediaTrack, list5);
                    }
                    i3 = 0;
                    multiMediaData = list.get(i3).multiMediaDataSuperpositionHeader;
                    if (mediaTrack != null && (mediaSegment2 = mediaTrack.superpositionHeader) != null && multiMediaData != null) {
                        if (multiMediaData.textureId != 0) {
                            mediaSegment2.textureId = i3;
                        } else {
                            mediaSegment2.textureId = multiMediaData.type == 1 ? preDrawBlendVideo(multiMediaData) : preDraw(multiMediaData, fullFrameRect, fullFrameRect2, false, false, mediaTrack.glClearColor);
                            i3 = 0;
                        }
                    }
                    multiMediaData2 = list.get(i3).multiMediaDataSuperpositionFooter;
                    if (mediaTrack != null && (mediaSegment = mediaTrack.superpositionFooter) != null && multiMediaData2 != null) {
                        if (multiMediaData2.textureId != 0) {
                            i3 = multiMediaData2.type == 1 ? preDrawBlendVideo(multiMediaData2) : preDraw(multiMediaData2, fullFrameRect, fullFrameRect2, false, false, mediaTrack.glClearColor);
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mediaTrackConfig) == null) || mediaTrackConfig == null || TextUtils.isEmpty(mediaTrackConfig.bgRes)) {
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

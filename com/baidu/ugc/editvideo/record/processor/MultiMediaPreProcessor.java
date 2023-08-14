package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.bab;
import com.baidu.tieba.j9b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.pg0;
import com.baidu.tieba.rg0;
import com.baidu.tieba.xg0;
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
/* loaded from: classes9.dex */
public class MultiMediaPreProcessor {
    public static final int DEFAULT_FBO_SIZE = 2;
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
    public Map<String, ShaderConfig> mShaderConfigMap;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public int mTestSavePicCount;
    public List<MediaTrack> mUpdateMediaTracks;
    public float[] mProjectionMatrix = new float[16];
    public boolean mTestSavePic = false;

    public static float[] calculateModelView(MultiMediaData multiMediaData, int i, int i2, int i3, int i4) {
        return calculateModelView(multiMediaData, false, i, i2, i3, i4, true);
    }

    public static float[] calculateModelView(MultiMediaData multiMediaData, int i, int i2, int i3, int i4, boolean z) {
        return calculateModelView(multiMediaData, false, i, i2, i3, i4, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
        if (r1 < 0.001d) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float[] calculateModelView(MultiMediaData multiMediaData, boolean z, int i, int i2, int i3, int i4, boolean z2) {
        CharSequence charSequence;
        float scaled;
        float f;
        float f2;
        int i5;
        int i6;
        float f3 = (multiMediaData.rotation + multiMediaData.angle) % 360.0f;
        if (TextUtils.equals(multiMediaData.scaleType, "center_crop") || TextUtils.equals(multiMediaData.scaleType, "center_inside")) {
            charSequence = "adaptive";
            float f4 = (i * 1.0f) / i2;
            float f5 = (multiMediaData.width * 1.0f) / multiMediaData.height;
            if (f3 == 90.0f || f3 == 270.0f) {
                f5 = 1.0f / f5;
            }
            String str = multiMediaData.scaleType;
            if (z2) {
                float f6 = f5 - f4;
                if (f6 <= 0.0f || f6 <= 0.001d) {
                    float f7 = f4 - f5;
                    if (f7 > 0.0f) {
                    }
                }
                str = "center_crop";
            }
            scaled = getScaled(multiMediaData.width, multiMediaData.height, i, i2, f3, !TextUtils.equals(str, "center_crop"));
            f = 1.0f;
        } else {
            charSequence = "adaptive";
            float scaled2 = getScaled(multiMediaData.width, multiMediaData.height, i, i2, f3, false);
            f = (i3 == 0 || !TextUtils.equals(multiMediaData.scaleType, charSequence)) ? 1.0f : (i * 1.0f) / i3;
            scaled = (scaled2 / ((i * 1.0f) / multiMediaData.width)) * f;
        }
        float f8 = i;
        float f9 = f8 / 2.0f;
        float f10 = i2;
        float f11 = f10 / 2.0f;
        if (TextUtils.equals(multiMediaData.scaleType, "top")) {
            int i7 = multiMediaData.height;
            f2 = ((i7 / 2.0f) + f10) - i7;
        } else if (TextUtils.equals(multiMediaData.scaleType, "bottom")) {
            int i8 = multiMediaData.height;
            f2 = f10 - (((i8 / 2.0f) + f10) - i8);
        } else if (TextUtils.equals(multiMediaData.scaleType, charSequence)) {
            float f12 = multiMediaData.x;
            float f13 = multiMediaData.y;
            if (i3 != 0) {
                f12 = (f12 / i3) * f8;
            }
            if (i4 != 0) {
                f13 = (multiMediaData.y / i4) * f10;
            }
            f9 = f12 + ((multiMediaData.width / 2.0f) * f);
            f2 = (f10 - ((multiMediaData.height / 2.0f) * f)) - f13;
            j9b.e("MultiMediaPreProcessor", "ADAPTIVE,x:" + multiMediaData.x + ",y:" + multiMediaData.y + ",posx:" + f9 + ",posy:" + f2 + ",previewwidth:" + i3 + ",previeheight:" + i4);
        } else if (multiMediaData.scaleType.contains(charSequence)) {
            int min = Math.min(i, i2);
            float f14 = min;
            i5 = (multiMediaData.width * min) / 375;
            int i9 = (multiMediaData.height * min) / 375;
            int i10 = (int) ((multiMediaData.y * f14) / 375.0f);
            float f15 = (i5 * f) / 2.0f;
            float f16 = (int) ((multiMediaData.x * f14) / 375.0f);
            float f17 = (f8 - f15) - f16;
            float f18 = (i9 * f) / 2.0f;
            float f19 = i10;
            float f20 = (f10 - f18) - f19;
            float f21 = f15 + f16;
            float f22 = f18 + f19;
            if (TextUtils.equals(multiMediaData.scaleType, "adaptive_br")) {
                f9 = f17;
            } else if (!TextUtils.equals(multiMediaData.scaleType, "adaptive_bl")) {
                if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tl")) {
                    f11 = f20;
                    f9 = f21;
                } else if (TextUtils.equals(multiMediaData.scaleType, "adaptive_tr")) {
                    f9 = f17;
                    f11 = f20;
                }
                i6 = i9;
                f2 = f11;
                if (i5 <= 0) {
                    i5 = multiMediaData.width;
                }
                int ceil = (int) Math.ceil((i5 * scaled) / 2.0f);
                if (i6 <= 0) {
                    i6 = multiMediaData.height;
                }
                int ceil2 = (int) Math.ceil((scaled * i6) / 2.0f);
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                Matrix.translateM(fArr, 0, f9, f2, 1.0f);
                if (multiMediaData.type == 0) {
                    float f23 = multiMediaData.rotation;
                    if (f23 == 0.0f || f23 == 180.0f) {
                        f3 += 180.0f;
                    }
                    Matrix.rotateM(fArr, 0, f3 % 360.0f, 0.0f, 0.0f, 1.0f);
                    ceil = -ceil;
                } else {
                    Matrix.rotateM(fArr, 0, (f3 - multiMediaData.rotation) % 360.0f, 0.0f, 0.0f, 1.0f);
                    float f24 = multiMediaData.rotation;
                    if (f24 == 90.0f || f24 == 270.0f) {
                        ceil = ceil2;
                        ceil2 = ceil;
                    }
                }
                Matrix.scaleM(fArr, 0, ceil * multiMediaData.scaleX, ceil2 * multiMediaData.scaleY, 1.0f);
                return fArr;
            } else {
                f9 = f21;
            }
            f11 = f22;
            i6 = i9;
            f2 = f11;
            if (i5 <= 0) {
            }
            int ceil3 = (int) Math.ceil((i5 * scaled) / 2.0f);
            if (i6 <= 0) {
            }
            int ceil22 = (int) Math.ceil((scaled * i6) / 2.0f);
            float[] fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
            Matrix.translateM(fArr2, 0, f9, f2, 1.0f);
            if (multiMediaData.type == 0) {
            }
            Matrix.scaleM(fArr2, 0, ceil3 * multiMediaData.scaleX, ceil22 * multiMediaData.scaleY, 1.0f);
            return fArr2;
        } else {
            float f25 = multiMediaData.x;
            float f26 = multiMediaData.y;
            if (i3 != 0) {
                f25 = (f25 / i3) * f8;
            }
            if (i4 != 0) {
                f26 = (multiMediaData.y / i4) * f10;
            }
            f9 += f25;
            f2 = f11 - f26;
        }
        i5 = 0;
        i6 = 0;
        if (i5 <= 0) {
        }
        int ceil32 = (int) Math.ceil((i5 * scaled) / 2.0f);
        if (i6 <= 0) {
        }
        int ceil222 = (int) Math.ceil((scaled * i6) / 2.0f);
        float[] fArr22 = new float[16];
        Matrix.setIdentityM(fArr22, 0);
        Matrix.translateM(fArr22, 0, f9, f2, 1.0f);
        if (multiMediaData.type == 0) {
        }
        Matrix.scaleM(fArr22, 0, ceil32 * multiMediaData.scaleX, ceil222 * multiMediaData.scaleY, 1.0f);
        return fArr22;
    }

    private boolean checkBg() {
        if (this.mBgBitmap != null) {
            return true;
        }
        if (o9b.e(this.mUpdateMediaTracks)) {
            return false;
        }
        for (int i = 1; i < this.mUpdateMediaTracks.size(); i++) {
            MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i);
            if (mediaTrack != null && (xg0.m(mediaTrack, "user_background") || xg0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) || xg0.m(mediaTrack, "only_background"))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInitialFbo() {
        int[] iArr = this.mFramebuffers;
        return iArr == null || this.mCurrentFboIndex >= iArr.length;
    }

    private void drawBg(FullFrameRect fullFrameRect) {
        if (this.mBgBitmap != null) {
            if (this.mBgTextureId == 0) {
                this.mBgTextureId = fullFrameRect.createTexture2DObject();
                GLUtils.texImage2D(3553, 0, this.mBgBitmap, 0);
            }
            int i = this.mBgTextureId;
            if (i != 0) {
                fullFrameRect.drawFrame(i, GlUtil.IDENTITY_MATRIX);
            }
        }
        if (this.mUpdateMediaTracks != null) {
            for (int i2 = 1; i2 < this.mUpdateMediaTracks.size(); i2++) {
                MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i2);
                if (mediaTrack != null) {
                    List<MediaTrack> list = this.mUpdateMediaTracks;
                    String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
                    if (!xg0.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                        str = "user_background";
                    }
                    if (xg0.m(mediaTrack, str)) {
                        List<MediaSegment> list2 = mediaTrack.mediaSegments;
                        if (list2 != null) {
                            for (MediaSegment mediaSegment : list2) {
                                if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                    long j = mediaSegment.start;
                                    long j2 = mediaSegment.end;
                                    if (j != j2) {
                                        long j3 = this.mPlayTime;
                                        if (j3 >= j && j3 <= j2) {
                                        }
                                    }
                                }
                                int i3 = mediaSegment.textureId;
                                if (i3 != 0) {
                                    fullFrameRect.drawFrame(i3, GlUtil.IDENTITY_MATRIX);
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

    private void drawOneTransition(int i, long j, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, pg0 pg0Var, MediaTrack mediaTrack, List<MultiMediaData> list) {
        int i2;
        List<MediaTransition> list2 = mediaTrack.mediaTransitions;
        if (list2 != null && list2.size() > i) {
            MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i);
            long j2 = mediaTransition.end;
            long j3 = j2 - mediaTransition.start;
            if (j3 > 0 && j2 - j < j3) {
                ShaderConfig shaderConfig = this.mShaderConfigMap.get(mediaTransition.shaderConfigKey);
                if (shaderConfig == null || shaderConfig.textures == null || list.size() <= (i2 = i + 1)) {
                    return;
                }
                int preDraw = preDraw(list.get(i2), fullFrameRect, fullFrameRect2, pg0Var, true, true, mediaTrack.glClearColor);
                for (MediaTextureData mediaTextureData : shaderConfig.textures) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                        mediaTextureData.textureId = preDraw;
                    }
                }
            }
        }
    }

    public static float getScaled(int i, int i2, int i3, int i4, float f, boolean z) {
        float f2;
        float f3;
        if (z) {
            if (f == 90.0f || f == 270.0f) {
                f3 = i4;
                return (f3 * 1.0f) / i;
            }
            f2 = i4;
            return (f2 * 1.0f) / i2;
        } else if (f == 90.0f || f == 270.0f) {
            f2 = i3;
            return (f2 * 1.0f) / i2;
        } else {
            f3 = i3;
            return (f3 * 1.0f) / i;
        }
    }

    private void initialFbo(int i) {
        int[] iArr = this.mFramebuffers;
        int length = iArr != null ? i + iArr.length : i;
        int[] iArr2 = new int[length];
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr4 = this.mFramebuffers;
            if (iArr4 != null && iArr4.length > i2) {
                iArr2[i2] = iArr4[i2];
            }
            int[] iArr5 = this.mFboTexture2DIds;
            if (iArr5 != null && iArr5.length > i2) {
                iArr3[i2] = iArr5[i2];
            }
            if (iArr3[i2] == 0) {
                GLES20.glGenFramebuffers(1, iArr2, i2);
                GLES20.glGenTextures(1, iArr3, i2);
                GLES20.glBindTexture(3553, iArr3[i2]);
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mSurfaceViewWidth, this.mSurfaceViewHeight, 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, iArr2[i2]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[i2], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        this.mFramebuffers = iArr2;
        this.mFboTexture2DIds = iArr3;
    }

    private int preDraw(MultiMediaData multiMediaData, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, pg0 pg0Var, boolean z, boolean z2, float[] fArr) {
        SurfaceTexture surfaceTexture;
        if (multiMediaData != null && (surfaceTexture = multiMediaData.surfaceTexture) != null) {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(multiMediaData.mtx);
        }
        boolean checkBg = checkBg();
        if (z2 && checkBg && pg0Var != null && this.mUpdateMediaTracks != null) {
            int i = 1;
            while (true) {
                if (i >= this.mUpdateMediaTracks.size()) {
                    break;
                }
                MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i);
                if (mediaTrack != null) {
                    List<MediaTrack> list = this.mUpdateMediaTracks;
                    String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
                    if (!xg0.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                        str = "user_background";
                    }
                    if (xg0.m(mediaTrack, str)) {
                        List<MediaSegment> list2 = mediaTrack.mediaSegments;
                        if (list2 != null) {
                            for (MediaSegment mediaSegment : list2) {
                                if (TextUtils.equals(mediaSegment.type, "input")) {
                                    processGaussianBlurBg(multiMediaData, pg0Var, mediaTrack, mediaSegment, fullFrameRect2);
                                }
                            }
                        }
                    }
                }
                i++;
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
        int i2 = this.mCurrentFboIndex;
        int i3 = iArr[i2];
        this.mCurrentFboIndex = i2 + 1;
        return i3;
    }

    private int preDraw(MultiMediaData multiMediaData, FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2, boolean z, boolean z2, float[] fArr) {
        return preDraw(multiMediaData, fullFrameRect, fullFrameRect2, null, z, z2, fArr);
    }

    private int preDrawBlendVideo(MultiMediaData multiMediaData) {
        SurfaceTexture surfaceTexture = multiMediaData.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(multiMediaData.mtx);
            return multiMediaData.textureId;
        }
        return 0;
    }

    private void processGaussianBlurBg(MultiMediaData multiMediaData, pg0 pg0Var, MediaTrack mediaTrack, MediaSegment mediaSegment, FullFrameRect fullFrameRect) {
        float[] fArr;
        int i;
        if (multiMediaData == null || pg0Var == null) {
            return;
        }
        float[] fArr2 = mediaTrack.glClearColor;
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = (multiMediaData.rotation + multiMediaData.angle) % 360.0f;
        float f4 = (this.mSurfaceViewWidth * 1.0f) / this.mSurfaceViewHeight;
        float f5 = (multiMediaData.width * 1.0f) / multiMediaData.height;
        if (f3 == 90.0f || f3 == 270.0f) {
            f5 = 1.0f / f5;
        }
        if (f == 0.0f) {
            f = 1.0f;
        }
        float f6 = 1.0f / f;
        int i2 = (int) (this.mSurfaceViewWidth * f6);
        int i3 = (int) (this.mSurfaceViewHeight * f6);
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float f7 = i2;
        float f8 = f7 / 2.0f;
        float f9 = i3;
        float f10 = f9 / 2.0f;
        float scaled = getScaled(multiMediaData.width, multiMediaData.height, i2, i3, f3, f4 <= f5);
        int round = Math.round(multiMediaData.width * scaled) / 2;
        int round2 = Math.round(scaled * multiMediaData.height) / 2;
        Matrix.translateM(fArr4, 0, f8, f10, 1.0f);
        if (multiMediaData.type == 0) {
            float f11 = multiMediaData.rotation;
            if (f11 == 0.0f || f11 == 180.0f) {
                f3 += 180.0f;
            }
            Matrix.rotateM(fArr4, 0, f3 % 360.0f, 0.0f, 0.0f, 1.0f);
            round *= -1;
        } else {
            Matrix.rotateM(fArr4, 0, (f3 - multiMediaData.rotation) % 360.0f, 0.0f, 0.0f, 1.0f);
            float f12 = multiMediaData.rotation;
            if (f12 == 90.0f || f12 == 270.0f) {
                round = round2;
                round2 = round;
            }
        }
        Matrix.scaleM(fArr4, 0, round, round2, 1.0f);
        float[] fArr5 = new float[16];
        Matrix.orthoM(fArr5, 0, 0.0f, f7, 0.0f, f9, -1.0f, 1.0f);
        Matrix.multiplyMM(fArr3, 0, fArr5, 0, fArr4, 0);
        int i4 = multiMediaData.textureId;
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
            float[] fArr7 = rg0.b;
            GLES20.glBindFramebuffer(36160, 0);
            int[] iArr = this.mFboTexture2DIds;
            int i5 = this.mCurrentFboIndex;
            i = iArr[i5];
            this.mCurrentFboIndex = i5 + 1;
            fArr6 = fArr7;
        } else {
            fArr = fArr3;
            i = i4;
        }
        mediaSegment.textureId = pg0Var.k(i, fArr, fArr6, i2, i3, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgRes(String str) {
        int i;
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
            i = this.mBgTextureId;
            if (i == 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
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
        i = this.mBgTextureId;
        if (i == 0) {
        }
    }

    private void setTextureData(MultiMediaData multiMediaData, String str, int i) {
        ShaderConfig shaderConfig;
        List<MediaTextureData> list;
        if (TextUtils.isEmpty(str) || (shaderConfig = this.mShaderConfigMap.get(str)) == null || (list = shaderConfig.textures) == null || list.size() <= 0) {
            return;
        }
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            if (!TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_VIDEO) && TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                mediaTextureData.textureId = multiMediaData.textureId;
            } else {
                mediaTextureData.textureId = i;
            }
        }
    }

    private void testPic(MultiMediaData multiMediaData) {
        int i;
        String str;
        if (this.mTestSavePic && (i = this.mTestSavePicCount) < 1) {
            if (i == 0) {
                bab.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUtils.deleteFileOrDir(new File("/sdcard/zhmy/"));
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
            sb.append(".png");
            final String sb2 = sb.toString();
            final Bitmap saveOffscreenBitmap = MultiDataSourceUtil.saveOffscreenBitmap(this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            ThreadPool.b().e(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.saveBitmap2PNG("/sdcard/zhmy/", sb2, saveOffscreenBitmap, 100);
                }
            });
            this.mTestSavePicCount++;
        }
    }

    public void destroyFramebuffers() {
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
        int i = this.mBgTextureId;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.mBgTextureId = 0;
        }
    }

    public void initFrameBuffers(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        if (this.mSurfaceViewWidth == i && this.mSurfaceViewHeight == i2) {
            return;
        }
        this.mSurfaceViewWidth = i;
        this.mSurfaceViewHeight = i2;
        Matrix.orthoM(this.mProjectionMatrix, 0, 0.0f, i, 0.0f, i2, -1.0f, 1.0f);
        destroyFramebuffers();
        initialFbo(2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int preProcess(List<MultiMediaDataTrack> list, int i, long j, OnDrawUpdateTextureListener onDrawUpdateTextureListener) {
        MediaTrack mediaTrack;
        int i2;
        int i3;
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        List<MediaTrack> list2;
        MultiMediaData multiMediaData3;
        int i4;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaTrack mediaTrack2;
        int i5;
        MediaSegment mediaSegment3;
        MultiMediaData multiMediaData4;
        MediaAEffect mediaAEffect;
        FullFrameRect fullFrameRect2D = onDrawUpdateTextureListener.getFullFrameRect2D();
        FullFrameRect fullFrameRectEXT = onDrawUpdateTextureListener.getFullFrameRectEXT();
        pg0 vlogCore = onDrawUpdateTextureListener.getVlogCore();
        int i6 = 0;
        this.mCurrentFboIndex = 0;
        this.mPlayTime = j;
        if (o9b.e(list)) {
            return 0;
        }
        List<MediaTrack> list3 = this.mUpdateMediaTracks;
        if (list3 != null && list3.size() == list.size()) {
            int i7 = 1;
            while (i7 < this.mUpdateMediaTracks.size()) {
                MediaTrack mediaTrack3 = this.mUpdateMediaTracks.get(i7);
                MultiMediaDataTrack multiMediaDataTrack2 = list.get(i7);
                List<MultiMediaData> list4 = multiMediaDataTrack2.multiMediaDataList;
                if (list4 != null && mediaTrack3.mediaSegments != null && list4.size() == mediaTrack3.mediaSegments.size() && (!this.mCompat || !xg0.m(mediaTrack3, "edit_sticker"))) {
                    int i8 = 0;
                    while (i8 < multiMediaDataTrack2.multiMediaDataList.size()) {
                        MultiMediaData multiMediaData5 = multiMediaDataTrack2.multiMediaDataList.get(i8);
                        MediaSegment mediaSegment4 = mediaTrack3.mediaSegments.get(i8);
                        if (multiMediaData5.textureId != 0) {
                            if (TextUtils.equals(mediaSegment4.type, "blend")) {
                                i6 = preDrawBlendVideo(multiMediaData5);
                            } else {
                                multiMediaData3 = multiMediaData5;
                                i4 = i8;
                                multiMediaDataTrack = multiMediaDataTrack2;
                                mediaTrack2 = mediaTrack3;
                                i5 = i7;
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
                                i8 = i4 + 1;
                                i7 = i5;
                                multiMediaDataTrack2 = multiMediaDataTrack;
                                mediaTrack3 = mediaTrack2;
                                i6 = 0;
                            }
                        }
                        mediaSegment4.textureId = i6;
                        multiMediaData3 = multiMediaData5;
                        i4 = i8;
                        multiMediaDataTrack = multiMediaDataTrack2;
                        mediaTrack2 = mediaTrack3;
                        i5 = i7;
                        mediaSegment3 = mediaSegment4;
                        if (TextUtils.isEmpty(mediaSegment3.shaderConfigKey)) {
                        }
                        mediaAEffect = mediaSegment3.mediaAEffect;
                        if (mediaAEffect != null) {
                            setTextureData(multiMediaData4, mediaSegment3.mediaAEffect.shaderConfigKey, mediaSegment3.textureId);
                        }
                        i8 = i4 + 1;
                        i7 = i5;
                        multiMediaDataTrack2 = multiMediaDataTrack;
                        mediaTrack3 = mediaTrack2;
                        i6 = 0;
                    }
                }
                i7++;
                i6 = 0;
            }
        }
        if (list.get(0) != null && list.get(0).multiMediaDataList.size() > i) {
            List<MultiMediaData> list5 = list.get(0).multiMediaDataList;
            MultiMediaData multiMediaData6 = list5.get(i);
            if (this.mShaderConfigMap != null && (list2 = this.mUpdateMediaTracks) != null && list2.size() > 0) {
                mediaTrack = this.mUpdateMediaTracks.get(0);
                int preDraw2 = xg0.m(mediaTrack, "input_blank") ? preDraw(null, fullFrameRect2D, fullFrameRectEXT, true, true, mediaTrack.glClearColor) : preDraw(multiMediaData6, fullFrameRect2D, fullFrameRectEXT, vlogCore, true, true, mediaTrack.glClearColor);
                List<MediaSegment> list6 = mediaTrack.mediaSegments;
                if (list6 == null || list6.size() <= i) {
                    i3 = preDraw2;
                } else {
                    mediaTrack.mediaSegments.get(i).textureId = preDraw2;
                    i3 = preDraw2;
                    drawOneTransition(i, j, fullFrameRect2D, fullFrameRectEXT, vlogCore, mediaTrack, list5);
                }
                i2 = 0;
                multiMediaData = list.get(i2).multiMediaDataSuperpositionHeader;
                if (mediaTrack != null && (mediaSegment2 = mediaTrack.superpositionHeader) != null && multiMediaData != null) {
                    if (multiMediaData.textureId != 0) {
                        mediaSegment2.textureId = i2;
                    } else {
                        mediaSegment2.textureId = multiMediaData.type == 1 ? preDrawBlendVideo(multiMediaData) : preDraw(multiMediaData, fullFrameRect2D, fullFrameRectEXT, false, false, mediaTrack.glClearColor);
                        i2 = 0;
                    }
                }
                multiMediaData2 = list.get(i2).multiMediaDataSuperpositionFooter;
                if (mediaTrack != null && (mediaSegment = mediaTrack.superpositionFooter) != null && multiMediaData2 != null) {
                    if (multiMediaData2.textureId != 0) {
                        i2 = multiMediaData2.type == 1 ? preDrawBlendVideo(multiMediaData2) : preDraw(multiMediaData2, fullFrameRect2D, fullFrameRectEXT, false, false, mediaTrack.glClearColor);
                    }
                    mediaSegment.textureId = i2;
                }
                return i3;
            }
        }
        mediaTrack = null;
        i2 = 0;
        i3 = 0;
        multiMediaData = list.get(i2).multiMediaDataSuperpositionHeader;
        if (mediaTrack != null) {
            if (multiMediaData.textureId != 0) {
            }
        }
        multiMediaData2 = list.get(i2).multiMediaDataSuperpositionFooter;
        if (mediaTrack != null) {
            if (multiMediaData2.textureId != 0) {
            }
            mediaSegment.textureId = i2;
        }
        return i3;
    }

    public void setCompat(boolean z) {
        this.mCompat = z;
    }

    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        if (mediaTrackConfig == null) {
            return;
        }
        setBgRes(mediaTrackConfig.bgRes);
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    public void setShaderConfigMap(Map<String, ShaderConfig> map) {
        this.mShaderConfigMap = map;
    }

    public void setUpdateMediaTracks(List<MediaTrack> list) {
        this.mUpdateMediaTracks = list;
    }
}

package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tieba.de0;
import com.baidu.tieba.e8a;
import com.baidu.tieba.jf0;
import com.baidu.tieba.m7a;
import com.baidu.tieba.p3a;
import com.baidu.tieba.r3a;
import com.baidu.tieba.r7a;
import com.baidu.tieba.yd0;
import com.baidu.tieba.zd0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import com.baidu.ugc.utils.SafeConcurrentHashMap;
import com.faceunity.gles.GeneratedTexture;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public class AREditProcessor extends BaseEffectProcessor implements DuMixCallback {
    public static final float GENDER_MALE_DEFAULT = 0.8f;
    public static final String TAG = "AREditProcessor";
    public long mCurrPosition;
    public DuMixCallback mDuMixCallback;
    public DuArEditProcessorCallback mEditProcessCallback;
    public yd0 mEffect;
    public yd0.l mEffectHolder;
    public int mFboInputTexId;
    public int mFboOutTexId;
    public FullFrameRect mFullArAlpha;
    public FullFrameRect mFullScreen2D;
    public volatile boolean mImageQualityOpen;
    public int mInputFrameBuffer;
    public Texture mInputTexture;
    public boolean mIsArLoadSuccess;
    public boolean mIsStickerLoaded;
    public CountDownLatch mLatch;
    public int mOutFrameBuffer;
    public Texture mOutputTexture;
    public volatile boolean mPreviewSyncInputContent;
    public Sticker mSticker;
    public long mStickerEndTime;
    public long mStickerStartTime;
    public Map<BeautyType, Object> mBeautyMap = new SafeConcurrentHashMap();
    public volatile boolean mSyncInputContent = false;
    public boolean mIsSetup = false;
    public boolean mSkipARAfterSetup = true;
    public boolean savePic = false;
    public de0 beautyEnableStatus = new de0();
    public int i = 0;

    /* loaded from: classes7.dex */
    public interface DuArEditProcessorCallback {
        void onBeautyEnableChanged(de0 de0Var);

        void onChangeGender(boolean z);
    }

    public AREditProcessor() {
        this.mEffectHolder = null;
        this.mIsArLoadSuccess = false;
        this.mEffectHolder = new yd0.l() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.1
            @Override // com.baidu.tieba.yd0.l
            public void onHolderChanged(yd0.l lVar) {
            }
        };
        r3a e = p3a.c().e();
        if (e != null) {
            this.mIsArLoadSuccess = e.a();
        }
    }

    private boolean checkSticker(Sticker sticker) {
        return sticker != null && sticker.isSupport(yd0.a0()) && !TextUtils.isEmpty(sticker.getPath()) && new File(sticker.getPath()).exists() && yd0.k1(sticker.getPath());
    }

    private void createArInstance() {
        if (yd0.M(this.mEffect, this.mEffectHolder)) {
            return;
        }
        if (!yd0.i0()) {
            yd0.k0();
        }
        if (yd0.i0()) {
            this.mEffect = yd0.U(p3a.c().getContext(), this.mEffectHolder, EGL14.eglGetCurrentContext(), zd0.b());
            yd0.h1(this.mSyncInputContent || this.mPreviewSyncInputContent);
            this.mEffect.g1();
            this.mEffect.X0(new FaceListener() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.7
                @Override // com.baidu.ar.face.FaceListener
                public void onFaceResult(Object obj) {
                    FaceResultData faceResultData;
                    float[] genders;
                    if (obj == null || !(obj instanceof FaceResultData) || (genders = (faceResultData = (FaceResultData) obj).getGenders()) == null) {
                        return;
                    }
                    boolean z = genders[0] > 0.8f;
                    if (AREditProcessor.this.mEditProcessCallback != null) {
                        AREditProcessor.this.mEditProcessCallback.onChangeGender(z);
                    }
                    int[] faceIds = faceResultData.getFaceIds();
                    if (faceIds == null) {
                        return;
                    }
                    m7a.c(AREditProcessor.TAG, "faceid  " + faceIds[0] + "  isMale:  " + z + "  result: " + genders[0]);
                }

                @Override // com.baidu.ar.face.FaceListener
                public void onStickerLoadingFinished(List<String> list) {
                }

                @Override // com.baidu.ar.face.FaceListener
                public void onTriggerFired(String str) {
                }
            });
        }
    }

    private void createOutputTexture() {
        if (this.mFboOutTexId != 0) {
            return;
        }
        this.mFboOutTexId = this.mFullScreen2D.createTexture2DObject();
        GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mPreviewWidth, this.mPreviewHeight, 0, GeneratedTexture.FORMAT, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mOutFrameBuffer = iArr[0];
    }

    private void drawFrameBuffer(int i) {
        GLES20.glBindFramebuffer(36160, this.mInputFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFboInputTexId, 0);
        GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
        GLES20.glClear(16640);
        GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
        this.mFullScreen2D.drawFrame(i, GlUtil.IDENTITY_MATRIX);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void initDefParams() {
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.c0(false);
        }
    }

    private void initInputTexture() {
        if (this.mFboInputTexId == 0) {
            this.mFboInputTexId = this.mFullScreen2D.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mPreviewWidth, this.mPreviewHeight, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.mInputFrameBuffer = iArr[0];
        }
        if (this.mInputTexture == null) {
            Texture texture = new Texture();
            this.mInputTexture = texture;
            texture.setId(this.mFboInputTexId);
            this.mInputTexture.setHandle(-1L);
            this.mInputTexture.setType(3553);
        }
    }

    private Texture initOutputTexture(int i, int i2) {
        if (this.mOutputTexture == null) {
            int createTexture2DObject = this.mFullScreen2D.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, i, i2, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            Texture texture = new Texture();
            this.mOutputTexture = texture;
            texture.setId(createTexture2DObject);
            this.mOutputTexture.setType(3553);
        }
        return this.mOutputTexture;
    }

    private void innerSetBeautyValues(Map<BeautyType, Object> map) {
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.R0(map);
        }
    }

    private void loadCase() {
        if (this.mSticker == null || this.mIsStickerLoaded) {
            return;
        }
        m7a.c(TAG, "mCurrPosition = " + this.mCurrPosition + ", id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
        Sticker.AbilityModel abilityModel = this.mSticker.getAbilityModel();
        if (abilityModel != null) {
            this.mEffect.d1(abilityModel.getPath());
        }
        int arType = this.mSticker.getArType();
        this.mEffect.j0(ARType.valueOf(arType), this.mSticker.getPath(), this.mSticker.getId());
        this.mIsStickerLoaded = true;
    }

    private void releaseARInstance() {
        this.mIsSetup = false;
        if (this.mEffect != null) {
            m7a.c(TAG, "release AR instance");
            this.mEffect.B0();
            this.mEffect = null;
        }
    }

    private void releaseCase() {
        if (this.mEffect != null && this.mIsStickerLoaded) {
            if (this.mSticker != null) {
                m7a.c(TAG, "id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
            }
            this.mEffect.O();
        }
        this.mIsStickerLoaded = false;
    }

    private void resetInputAndOutputTexture() {
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.E0();
        }
    }

    private void setCloseImageQuality() {
        if (this.mImageQualityOpen) {
            return;
        }
        setBeautyValue(BeautyType.hazeAtom, 0.0f);
    }

    private void setupArInstance(Texture texture) {
        if (texture == null) {
            return;
        }
        yd0 yd0Var = this.mEffect;
        if (yd0Var == null) {
            m7a.c(TAG, "setInput Effect == null");
            return;
        }
        yd0Var.c1(texture);
        m7a.c(TAG, "check ar size ：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
        onCameraDrawerCreated(null, this.mPreviewWidth, this.mPreviewHeight);
        onARDrawerCreated(null, null, this.mPreviewWidth, this.mPreviewHeight);
    }

    private void testAr(int i, int i2) {
        int i3;
        this.i++;
        if (this.mSyncInputContent && this.savePic && (i3 = this.i) <= 2) {
            if (i3 == 1) {
                e8a.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUtils.deleteFileOrDir(new File("/sdcard/aguogh/"));
                    }
                });
            }
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            fullFrameRect.drawFrame(i, GlUtil.IDENTITY_MATRIX);
            final String str = "input-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            final Bitmap saveOffscreenBitmap = MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight);
            ThreadPool.b().e(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.4
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.saveBitmap2PNG("/sdcard/aguogh/", str, saveOffscreenBitmap, 100);
                }
            });
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            fullFrameRect.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
            final String str2 = "ar-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            final Bitmap saveOffscreenBitmap2 = MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight);
            ThreadPool.b().e(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.5
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.saveBitmap2PNG("/sdcard/aguogh/", str2, saveOffscreenBitmap2, 100);
                }
            });
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            fullFrameRect.drawFrame(this.mFboInputTexId, GlUtil.IDENTITY_MATRIX);
            final String str3 = "fbo-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            final Bitmap saveOffscreenBitmap3 = MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight);
            ThreadPool.b().e(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.6
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.saveBitmap2PNG("/sdcard/aguogh/", str3, saveOffscreenBitmap3, 100);
                }
            });
        }
    }

    public void clearAllFilter() {
        this.mBeautyMap.clear();
        if (isSetup()) {
            this.mEffect.N();
            this.mEffect.L0(BeautyType.whiten, 0.0f);
            this.mEffect.L0(BeautyType.smooth, 0.0f);
        }
    }

    public boolean isSetup() {
        return this.mIsSetup && yd0.M(this.mEffect, this.mEffectHolder);
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        m7a.c(TAG, "onARDrawerChanged, mEffect=" + this.mEffect);
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2) {
        if (this.mEffect == null) {
            m7a.c(TAG, "onARDrawerCreated Effect == null");
            return;
        }
        initOutputTexture(i, i2);
        this.mEffect.e1(this.mOutputTexture);
        this.mEffect.t0(surfaceTexture, onFrameAvailableListener, i, i2, false, this);
        this.mEffect.a1(new FilterStateListener() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.2
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                Boolean bool;
                Boolean bool2;
                Boolean bool3;
                Boolean bool4 = null;
                if (hashMap != null) {
                    bool4 = hashMap.get(FilterNode.makeupFilter);
                    bool2 = hashMap.get(FilterNode.lutFilter);
                    bool3 = hashMap.get(FilterNode.skinFilter);
                    bool = hashMap.get(FilterNode.faceFilter);
                } else {
                    bool = null;
                    bool2 = null;
                    bool3 = null;
                }
                boolean z = false;
                AREditProcessor.this.beautyEnableStatus.d(bool4 == null || bool4.booleanValue());
                AREditProcessor.this.beautyEnableStatus.c(bool2 == null || bool2.booleanValue());
                AREditProcessor.this.beautyEnableStatus.a(bool3 == null || bool3.booleanValue());
                AREditProcessor.this.beautyEnableStatus.b((bool == null || bool.booleanValue()) ? true : true);
                if (AREditProcessor.this.mEditProcessCallback != null) {
                    e8a.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AREditProcessor.this.mEditProcessCallback.onBeautyEnableChanged(AREditProcessor.this.beautyEnableStatus);
                        }
                    });
                }
            }
        });
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.v0(surfaceTexture, i, i2);
        } else {
            m7a.c(TAG, "onCameraDrawerCreated Effect == null");
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseCreate(boolean z, String str, String str2) {
        Sticker sticker;
        m7a.b("create callback ---- result b = " + z + " casePath = " + str + " caseId = " + str2);
        if (str2 == null || (sticker = this.mSticker) == null || !TextUtils.equals(str2, sticker.getId())) {
            this.mIsStickerLoaded = false;
        } else {
            this.mIsStickerLoaded = z;
        }
        DuMixCallback duMixCallback = this.mDuMixCallback;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(z, str, str2);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseDestroy() {
        m7a.b("case destroy callback");
        DuMixCallback duMixCallback = this.mDuMixCallback;
        if (duMixCallback != null) {
            duMixCallback.onCaseDestroy();
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
        DuMixCallback duMixCallback = this.mDuMixCallback;
        if (duMixCallback != null) {
            duMixCallback.onError(duMixErrorType, str, str2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(jf0 jf0Var, int i, float[] fArr) {
        if (!this.mIsArLoadSuccess) {
            m7a.c(TAG, "ship AR --- AR load so fail");
            return i;
        }
        if (this.mInputTexture == null) {
            initInputTexture();
            setupArInstance(this.mInputTexture);
            if (!this.mSyncInputContent || this.mIsSetup) {
                m7a.c(TAG, "----- initAr started -----");
            } else {
                try {
                    m7a.c(TAG, "----- waiting -----");
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.mLatch = countDownLatch;
                    try {
                        countDownLatch.await();
                    } catch (Exception unused) {
                    }
                    m7a.c(TAG, "----- notified -----");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        m7a.c(TAG, "-----params----- mSyncInputContent : " + this.mSyncInputContent + " mSkipARAfterSetup : " + this.mSkipARAfterSetup + " mBeautyMap : " + r7a.f(this.mBeautyMap) + " mSticker : " + this.mSticker + " mImageQualityOpen : " + this.mImageQualityOpen);
        if (!this.mSyncInputContent && this.mSkipARAfterSetup && r7a.f(this.mBeautyMap) && this.mSticker == null && !this.mImageQualityOpen) {
            m7a.c(TAG, "ship AR --- no ar effect");
            return i;
        }
        if (jf0Var != null) {
            this.mCurrPosition = jf0Var.b();
        }
        if (!this.mIsSetup) {
            m7a.c(TAG, "ship AR --- AR not setup or fail to setup, curPos = " + this.mCurrPosition);
            return i;
        }
        yd0 yd0Var = this.mEffect;
        int X = yd0Var != null ? yd0Var.X() : 0;
        if (X == 0) {
            m7a.c(TAG, "ship AR --- AR output texture id is zero, curPos = " + this.mCurrPosition);
            return i;
        } else if (this.mEffect == null) {
            m7a.c(TAG, "ship AR --- AR instace is null, curPos = " + this.mCurrPosition);
            return i;
        } else {
            drawFrameBuffer(i);
            long j = this.mCurrPosition;
            if (j < this.mStickerStartTime || j > this.mStickerEndTime) {
                releaseCase();
            } else {
                loadCase();
            }
            setCloseImageQuality();
            if (!this.mSyncInputContent && this.mSkipARAfterSetup) {
                GLES20.glFinish();
            }
            this.mEffect.C0();
            createOutputTexture();
            GLES20.glBindFramebuffer(36160, this.mOutFrameBuffer);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFboOutTexId, 0);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            FullFrameRect fullFrameRect = this.mFullArAlpha;
            float[] fArr2 = GlUtil.IDENTITY_MATRIX;
            fullFrameRect.drawFrame(i, fArr2, X, fArr2);
            GLES20.glBindFramebuffer(36160, 0);
            testAr(i, X);
            if (this.mSyncInputContent || !this.mSkipARAfterSetup) {
                return this.mFboOutTexId;
            }
            m7a.c(TAG, "ship AR --- ar first frame when ar is async, curPos = " + this.mCurrPosition);
            this.mSkipARAfterSetup = false;
            return i;
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onRelease() {
        DuMixCallback duMixCallback = this.mDuMixCallback;
        if (duMixCallback != null) {
            duMixCallback.onRelease();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.F0();
            m7a.c(TAG, "onResume1");
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        CountDownLatch countDownLatch;
        if (z) {
            m7a.c(TAG, "----- onSetup result：" + z + " -----");
            initDefParams();
            innerSetBeautyValues(this.mBeautyMap);
            setSticker(this.mSticker, this.mStickerStartTime, this.mStickerEndTime);
        } else {
            m7a.c(TAG, "1571，onSetup返回失败：" + z);
        }
        this.mIsSetup = z;
        if (this.mSyncInputContent && (countDownLatch = this.mLatch) != null) {
            countDownLatch.countDown();
        }
        DuMixCallback duMixCallback = this.mDuMixCallback;
        if (duMixCallback != null) {
            duMixCallback.onSetup(z, duMixInput, duMixOutput);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        this.mFullScreen2D = fullFrameRect2;
        this.mFullArAlpha = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR_ALPHA));
        createArInstance();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        resetInputAndOutputTexture();
        releaseCase();
        releaseARInstance();
        this.mSkipARAfterSetup = true;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        if (this.mInputTexture != null) {
            this.mInputTexture = null;
        }
        if (this.mFboInputTexId != 0) {
            GLES20.glDeleteFramebuffers(1, new int[this.mInputFrameBuffer], 0);
            GLES20.glDeleteTextures(1, new int[]{this.mFboInputTexId}, 0);
            this.mFboInputTexId = 0;
            this.mInputFrameBuffer = 0;
        }
        Texture texture = this.mOutputTexture;
        if (texture != null) {
            MultiDataSourceUtil.glDeleteTextures(texture.getId());
            this.mOutputTexture = null;
        }
        if (this.mFboOutTexId != 0) {
            GLES20.glDeleteFramebuffers(1, new int[this.mOutFrameBuffer], 0);
            GLES20.glDeleteTextures(1, new int[]{this.mFboOutTexId}, 0);
            this.mFboOutTexId = 0;
            this.mOutFrameBuffer = 0;
        }
        FullFrameRect fullFrameRect = this.mFullArAlpha;
        if (fullFrameRect != null) {
            fullFrameRect.release(true);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.L0(beautyType, f);
        }
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        this.mBeautyMap.put(beautyType, Integer.valueOf(i));
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.M0(beautyType, i);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        this.mBeautyMap.put(beautyType, str);
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.P0(beautyType, str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        this.mBeautyMap.put(beautyType, fArr);
        yd0 yd0Var = this.mEffect;
        if (yd0Var != null) {
            yd0Var.Q0(beautyType, fArr);
        }
    }

    public void setBeautyValues(Map<BeautyType, Object> map) {
        if (r7a.f(map)) {
            return;
        }
        this.mBeautyMap.putAll(map);
        innerSetBeautyValues(map);
    }

    public void setDuMixCallback(DuMixCallback duMixCallback) {
        this.mDuMixCallback = duMixCallback;
    }

    public void setEditProcessCallback(DuArEditProcessorCallback duArEditProcessorCallback) {
        this.mEditProcessCallback = duArEditProcessorCallback;
    }

    public void setImageQualityStatus(boolean z, boolean z2, boolean z3) {
        float f;
        this.mImageQualityOpen = z;
        if (!z) {
            if (r7a.f(this.mBeautyMap) && this.mSticker == null) {
                return;
            }
            setCloseImageQuality();
            return;
        }
        BeautyType beautyType = BeautyType.hazeAtom;
        if (z2) {
            setBeautyValue(beautyType, 0.15f);
            beautyType = BeautyType.hazeBlend;
            f = beautyType.value;
        } else {
            f = 0.0f;
        }
        setBeautyValue(beautyType, f);
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i, int i2) {
        if (i != this.mPreviewWidth && i2 != this.mPreviewHeight) {
            m7a.c(TAG, "check ar size before：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
            m7a.c(TAG, "check ar size after ：width = " + i + " , height = " + i2);
        }
        super.setPreviewSize(i, i2);
    }

    public void setPreviewSyncInputContent(boolean z) {
        this.mPreviewSyncInputContent = z;
    }

    public void setSticker(Sticker sticker, long j, long j2) {
        m7a.c(TAG, "startTime = " + j + " , endTime = " + j2);
        if (this.mSticker != sticker) {
            releaseCase();
        }
        if (checkSticker(sticker)) {
            this.mSticker = sticker;
            this.mStickerStartTime = j;
            this.mStickerEndTime = j2;
            return;
        }
        this.mSticker = null;
        this.mStickerStartTime = 0L;
        this.mStickerEndTime = 0L;
    }

    public void setSyncInputContent(boolean z) {
        this.mSyncInputContent = z;
    }
}

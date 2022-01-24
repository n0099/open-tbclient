package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.b;
import c.a.a1.d;
import c.a.a1.t.c;
import c.a.a1.t.h;
import c.a.a1.t.u;
import c.a.b0.a.a;
import c.a.b0.a.f.a;
import c.a.b0.b.a.e;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes13.dex */
public class AREditProcessor extends BaseEffectProcessor implements DuMixCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float GENDER_MALE_DEFAULT = 0.8f;
    public static final String TAG = "AREditProcessor";
    public transient /* synthetic */ FieldHolder $fh;
    public a beautyEnableStatus;

    /* renamed from: i  reason: collision with root package name */
    public int f50341i;
    public Map<BeautyType, Object> mBeautyMap;
    public long mCurrPosition;
    public DuMixCallback mDuMixCallback;
    public DuArEditProcessorCallback mEditProcessCallback;
    public c.a.b0.a.a mEffect;
    public a.l mEffectHolder;
    public int mFboInputTexId;
    public int mFboOutTexId;
    public FullFrameRect mFullArAlpha;
    public FullFrameRect mFullScreen2D;
    public volatile boolean mImageQualityOpen;
    public int mInputFrameBuffer;
    public Texture mInputTexture;
    public boolean mIsArLoadSuccess;
    public boolean mIsSetup;
    public boolean mIsStickerLoaded;
    public CountDownLatch mLatch;
    public int mOutFrameBuffer;
    public Texture mOutputTexture;
    public volatile boolean mPreviewSyncInputContent;
    public boolean mSkipARAfterSetup;
    public Sticker mSticker;
    public long mStickerEndTime;
    public long mStickerStartTime;
    public volatile boolean mSyncInputContent;
    public boolean savePic;

    /* loaded from: classes13.dex */
    public interface DuArEditProcessorCallback {
        void onBeautyEnableChanged(c.a.b0.a.f.a aVar);

        void onChangeGender(boolean z);
    }

    public AREditProcessor() {
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
        this.mEffectHolder = null;
        this.mBeautyMap = new SafeConcurrentHashMap();
        this.mSyncInputContent = false;
        this.mIsSetup = false;
        this.mIsArLoadSuccess = false;
        this.mSkipARAfterSetup = true;
        this.savePic = false;
        this.beautyEnableStatus = new c.a.b0.a.f.a();
        this.f50341i = 0;
        this.mEffectHolder = new a.l(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AREditProcessor this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.b0.a.a.l
            public void onHolderChanged(a.l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, lVar) == null) {
                }
            }
        };
        d e2 = b.c().e();
        if (e2 != null) {
            this.mIsArLoadSuccess = e2.a();
        }
    }

    private boolean checkSticker(Sticker sticker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, sticker)) == null) ? sticker != null && sticker.isSupport(c.a.b0.a.a.a0()) && !TextUtils.isEmpty(sticker.getPath()) && new File(sticker.getPath()).exists() && c.a.b0.a.a.k1(sticker.getPath()) : invokeL.booleanValue;
    }

    private void createArInstance() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || c.a.b0.a.a.M(this.mEffect, this.mEffectHolder)) {
            return;
        }
        if (!c.a.b0.a.a.i0()) {
            c.a.b0.a.a.k0();
        }
        if (c.a.b0.a.a.i0()) {
            this.mEffect = c.a.b0.a.a.U(b.c().getContext(), this.mEffectHolder, EGL14.eglGetCurrentContext(), c.a.b0.a.b.b());
            c.a.b0.a.a.h1(this.mSyncInputContent || this.mPreviewSyncInputContent);
            this.mEffect.g1();
            this.mEffect.X0(new FaceListener(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AREditProcessor this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.ar.face.FaceListener
                public void onFaceResult(Object obj) {
                    FaceResultData faceResultData;
                    float[] genders;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) || obj == null || !(obj instanceof FaceResultData) || (genders = (faceResultData = (FaceResultData) obj).getGenders()) == null) {
                        return;
                    }
                    boolean z = genders[0] > 0.8f;
                    if (this.this$0.mEditProcessCallback != null) {
                        this.this$0.mEditProcessCallback.onChangeGender(z);
                    }
                    int[] faceIds = faceResultData.getFaceIds();
                    if (faceIds == null) {
                        return;
                    }
                    c.c(AREditProcessor.TAG, "faceid  " + faceIds[0] + "  isMale:  " + z + "  result: " + genders[0]);
                }

                @Override // com.baidu.ar.face.FaceListener
                public void onStickerLoadingFinished(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    }
                }

                @Override // com.baidu.ar.face.FaceListener
                public void onTriggerFired(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }
            });
        }
    }

    private void createOutputTexture() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mFboOutTexId == 0) {
            this.mFboOutTexId = this.mFullScreen2D.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mPreviewWidth, this.mPreviewHeight, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.mOutFrameBuffer = iArr[0];
        }
    }

    private void drawFrameBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i2) == null) {
            GLES20.glBindFramebuffer(36160, this.mInputFrameBuffer);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFboInputTexId, 0);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            this.mFullScreen2D.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    private void initDefParams() {
        c.a.b0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (aVar = this.mEffect) == null) {
            return;
        }
        aVar.c0(false);
    }

    private void initInputTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
    }

    private Texture initOutputTexture(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, this, i2, i3)) == null) {
            if (this.mOutputTexture == null) {
                int createTexture2DObject = this.mFullScreen2D.createTexture2DObject();
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, i2, i3, 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                Texture texture = new Texture();
                this.mOutputTexture = texture;
                texture.setId(createTexture2DObject);
                this.mOutputTexture.setType(3553);
            }
            return this.mOutputTexture;
        }
        return (Texture) invokeII.objValue;
    }

    private void innerSetBeautyValues(Map<BeautyType, Object> map) {
        c.a.b0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, map) == null) || (aVar = this.mEffect) == null) {
            return;
        }
        aVar.R0(map);
    }

    private void loadCase() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.mSticker == null || this.mIsStickerLoaded) {
            return;
        }
        c.c(TAG, "mCurrPosition = " + this.mCurrPosition + ", id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
        Sticker.AbilityModel abilityModel = this.mSticker.getAbilityModel();
        if (abilityModel != null) {
            this.mEffect.d1(abilityModel.getPath());
        }
        int arType = this.mSticker.getArType();
        this.mEffect.j0(ARType.valueOf(arType), this.mSticker.getPath(), this.mSticker.getId());
        this.mIsStickerLoaded = true;
    }

    private void releaseARInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mIsSetup = false;
            if (this.mEffect != null) {
                c.c(TAG, "release AR instance");
                this.mEffect.B0();
                this.mEffect = null;
            }
        }
    }

    private void releaseCase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.mEffect != null && this.mIsStickerLoaded) {
                if (this.mSticker != null) {
                    c.c(TAG, "id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
                }
                this.mEffect.O();
            }
            this.mIsStickerLoaded = false;
        }
    }

    private void resetInputAndOutputTexture() {
        c.a.b0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (aVar = this.mEffect) == null) {
            return;
        }
        aVar.E0();
    }

    private void setCloseImageQuality() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.mImageQualityOpen) {
            return;
        }
        setBeautyValue(BeautyType.hazeAtom, 0.0f);
    }

    private void setupArInstance(Texture texture) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, texture) == null) || texture == null) {
            return;
        }
        c.a.b0.a.a aVar = this.mEffect;
        if (aVar == null) {
            c.c(TAG, "setInput Effect == null");
            return;
        }
        aVar.c1(texture);
        c.c(TAG, "check ar size ：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
        onCameraDrawerCreated(null, this.mPreviewWidth, this.mPreviewHeight);
        onARDrawerCreated(null, null, this.mPreviewWidth, this.mPreviewHeight);
    }

    private void testAr(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65553, this, i2, i3) == null) {
            this.f50341i++;
            if (this.mSyncInputContent && this.savePic && (i4 = this.f50341i) <= 2) {
                if (i4 == 1) {
                    u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AREditProcessor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
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
                                FileUtils.deleteFileOrDir(new File("/sdcard/aguogh/"));
                            }
                        }
                    });
                }
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                fullFrameRect.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
                ThreadPool.b().e(new Runnable(this, "input-" + this.f50341i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AREditProcessor this$0;
                    public final /* synthetic */ Bitmap val$bitmap1;
                    public final /* synthetic */ String val$name1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$name1 = r7;
                        this.val$bitmap1 = r8;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            FileUtils.saveBitmap2PNG("/sdcard/aguogh/", this.val$name1, this.val$bitmap1, 100);
                        }
                    }
                });
                GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                fullFrameRect.drawFrame(i3, GlUtil.IDENTITY_MATRIX);
                ThreadPool.b().e(new Runnable(this, "ar-" + this.f50341i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AREditProcessor this$0;
                    public final /* synthetic */ Bitmap val$bitmap2;
                    public final /* synthetic */ String val$name2;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$name2 = r7;
                        this.val$bitmap2 = r8;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            FileUtils.saveBitmap2PNG("/sdcard/aguogh/", this.val$name2, this.val$bitmap2, 100);
                        }
                    }
                });
                GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                fullFrameRect.drawFrame(this.mFboInputTexId, GlUtil.IDENTITY_MATRIX);
                ThreadPool.b().e(new Runnable(this, "fbo-" + this.f50341i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AREditProcessor this$0;
                    public final /* synthetic */ Bitmap val$bitmap3;
                    public final /* synthetic */ String val$name3;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$name3 = r7;
                        this.val$bitmap3 = r8;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            FileUtils.saveBitmap2PNG("/sdcard/aguogh/", this.val$name3, this.val$bitmap3, 100);
                        }
                    }
                });
            }
        }
    }

    public void clearAllFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBeautyMap.clear();
            if (isSetup()) {
                this.mEffect.N();
                this.mEffect.L0(BeautyType.whiten, 0.0f);
                this.mEffect.L0(BeautyType.smooth, 0.0f);
            }
        }
    }

    public boolean isSetup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsSetup && c.a.b0.a.a.M(this.mEffect, this.mEffectHolder) : invokeV.booleanValue;
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
            c.c(TAG, "onARDrawerChanged, mEffect=" + this.mEffect);
        }
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, surfaceTexture, onFrameAvailableListener, i2, i3) == null) {
            if (this.mEffect == null) {
                c.c(TAG, "onARDrawerCreated Effect == null");
                return;
            }
            initOutputTexture(i2, i3);
            this.mEffect.e1(this.mOutputTexture);
            this.mEffect.t0(surfaceTexture, onFrameAvailableListener, i2, i3, false, this);
            this.mEffect.a1(new FilterStateListener(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AREditProcessor this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.ar.filter.FilterStateListener
                public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                    Boolean bool;
                    Boolean bool2;
                    Boolean bool3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, hashMap, str) == null) {
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
                        this.this$0.beautyEnableStatus.d(bool4 == null || bool4.booleanValue());
                        this.this$0.beautyEnableStatus.c(bool2 == null || bool2.booleanValue());
                        this.this$0.beautyEnableStatus.a(bool3 == null || bool3.booleanValue());
                        this.this$0.beautyEnableStatus.b((bool == null || bool.booleanValue()) ? true : true);
                        if (this.this$0.mEditProcessCallback != null) {
                            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.mEditProcessCallback.onBeautyEnableChanged(this.this$1.this$0.beautyEnableStatus);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, surfaceTexture, i2, i3) == null) {
            c.a.b0.a.a aVar = this.mEffect;
            if (aVar != null) {
                aVar.v0(surfaceTexture, i2, i3);
            } else {
                c.c(TAG, "onCameraDrawerCreated Effect == null");
            }
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseCreate(boolean z, String str, String str2) {
        Sticker sticker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            c.b("create callback ---- result b = " + z + " casePath = " + str + " caseId = " + str2);
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
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b("case destroy callback");
            DuMixCallback duMixCallback = this.mDuMixCallback;
            if (duMixCallback != null) {
                duMixCallback.onCaseDestroy();
            }
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
        DuMixCallback duMixCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, duMixErrorType, str, str2) == null) || (duMixCallback = this.mDuMixCallback) == null) {
            return;
        }
        duMixCallback.onError(duMixErrorType, str, str2);
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, i2, fArr)) == null) {
            if (!this.mIsArLoadSuccess) {
                c.c(TAG, "ship AR --- AR load so fail");
                return i2;
            }
            if (this.mInputTexture == null) {
                initInputTexture();
                setupArInstance(this.mInputTexture);
                if (!this.mSyncInputContent || this.mIsSetup) {
                    c.c(TAG, "----- initAr started -----");
                } else {
                    try {
                        c.c(TAG, "----- waiting -----");
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        this.mLatch = countDownLatch;
                        try {
                            countDownLatch.await();
                        } catch (Exception unused) {
                        }
                        c.c(TAG, "----- notified -----");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            c.c(TAG, "-----params----- mSyncInputContent : " + this.mSyncInputContent + " mSkipARAfterSetup : " + this.mSkipARAfterSetup + " mBeautyMap : " + h.f(this.mBeautyMap) + " mSticker : " + this.mSticker + " mImageQualityOpen : " + this.mImageQualityOpen);
            if (!this.mSyncInputContent && this.mSkipARAfterSetup && h.f(this.mBeautyMap) && this.mSticker == null && !this.mImageQualityOpen) {
                c.c(TAG, "ship AR --- no ar effect");
                return i2;
            }
            if (eVar != null) {
                this.mCurrPosition = eVar.a();
            }
            if (!this.mIsSetup) {
                c.c(TAG, "ship AR --- AR not setup or fail to setup, curPos = " + this.mCurrPosition);
                return i2;
            }
            c.a.b0.a.a aVar = this.mEffect;
            int X = aVar != null ? aVar.X() : 0;
            if (X == 0) {
                c.c(TAG, "ship AR --- AR output texture id is zero, curPos = " + this.mCurrPosition);
                return i2;
            } else if (this.mEffect == null) {
                c.c(TAG, "ship AR --- AR instace is null, curPos = " + this.mCurrPosition);
                return i2;
            } else {
                drawFrameBuffer(i2);
                long j2 = this.mCurrPosition;
                if (j2 < this.mStickerStartTime || j2 > this.mStickerEndTime) {
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
                fullFrameRect.drawFrame(i2, fArr2, X, fArr2);
                GLES20.glBindFramebuffer(36160, 0);
                testAr(i2, X);
                if (this.mSyncInputContent || !this.mSkipARAfterSetup) {
                    return this.mFboOutTexId;
                }
                c.c(TAG, "ship AR --- ar first frame when ar is async, curPos = " + this.mCurrPosition);
                this.mSkipARAfterSetup = false;
                return i2;
            }
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onRelease() {
        DuMixCallback duMixCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (duMixCallback = this.mDuMixCallback) == null) {
            return;
        }
        duMixCallback.onRelease();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        c.a.b0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.mEffect) == null) {
            return;
        }
        aVar.F0();
        c.c(TAG, "onResume1");
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        CountDownLatch countDownLatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
            if (z) {
                c.c(TAG, "----- onSetup result：" + z + " -----");
                initDefParams();
                innerSetBeautyValues(this.mBeautyMap);
                setSticker(this.mSticker, this.mStickerStartTime, this.mStickerEndTime);
            } else {
                c.c(TAG, "1571，onSetup返回失败：" + z);
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
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, fullFrameRect, fullFrameRect2) == null) {
            this.mFullScreen2D = fullFrameRect2;
            this.mFullArAlpha = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR_ALPHA));
            createArInstance();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            resetInputAndOutputTexture();
            releaseCase();
            releaseARInstance();
            this.mSkipARAfterSetup = true;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
    }

    public void setBeautyValue(BeautyType beautyType, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048591, this, beautyType, f2) == null) {
            this.mBeautyMap.put(beautyType, Float.valueOf(f2));
            c.a.b0.a.a aVar = this.mEffect;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, beautyType, i2) == null) {
            this.mBeautyMap.put(beautyType, Integer.valueOf(i2));
            c.a.b0.a.a aVar = this.mEffect;
            if (aVar != null) {
                aVar.M0(beautyType, i2);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, beautyType, str) == null) {
            this.mBeautyMap.put(beautyType, str);
            c.a.b0.a.a aVar = this.mEffect;
            if (aVar != null) {
                aVar.P0(beautyType, str);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, beautyType, fArr) == null) {
            this.mBeautyMap.put(beautyType, fArr);
            c.a.b0.a.a aVar = this.mEffect;
            if (aVar != null) {
                aVar.Q0(beautyType, fArr);
            }
        }
    }

    public void setBeautyValues(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, map) == null) || h.f(map)) {
            return;
        }
        this.mBeautyMap.putAll(map);
        innerSetBeautyValues(map);
    }

    public void setDuMixCallback(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, duMixCallback) == null) {
            this.mDuMixCallback = duMixCallback;
        }
    }

    public void setEditProcessCallback(DuArEditProcessorCallback duArEditProcessorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, duArEditProcessorCallback) == null) {
            this.mEditProcessCallback = duArEditProcessorCallback;
        }
    }

    public void setImageQualityStatus(boolean z, boolean z2, boolean z3) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mImageQualityOpen = z;
            if (!z) {
                if (h.f(this.mBeautyMap) && this.mSticker == null) {
                    return;
                }
                setCloseImageQuality();
                return;
            }
            BeautyType beautyType = BeautyType.hazeAtom;
            if (z2) {
                setBeautyValue(beautyType, 0.15f);
                beautyType = BeautyType.hazeBlend;
                f2 = beautyType.value;
            } else {
                f2 = 0.0f;
            }
            setBeautyValue(beautyType, f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            if (i2 != this.mPreviewWidth && i3 != this.mPreviewHeight) {
                c.c(TAG, "check ar size before：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
                c.c(TAG, "check ar size after ：width = " + i2 + " , height = " + i3);
            }
            super.setPreviewSize(i2, i3);
        }
    }

    public void setPreviewSyncInputContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mPreviewSyncInputContent = z;
        }
    }

    public void setSticker(Sticker sticker, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{sticker, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            c.c(TAG, "startTime = " + j2 + " , endTime = " + j3);
            if (this.mSticker != sticker) {
                releaseCase();
            }
            if (checkSticker(sticker)) {
                this.mSticker = sticker;
                this.mStickerStartTime = j2;
                this.mStickerEndTime = j3;
                return;
            }
            this.mSticker = null;
            this.mStickerStartTime = 0L;
            this.mStickerEndTime = 0L;
        }
    }

    public void setSyncInputContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mSyncInputContent = z;
        }
    }
}

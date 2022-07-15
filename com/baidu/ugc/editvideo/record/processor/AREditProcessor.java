package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.b59;
import com.repackage.b99;
import com.repackage.dd0;
import com.repackage.ed0;
import com.repackage.id0;
import com.repackage.o99;
import com.repackage.oe0;
import com.repackage.w89;
import com.repackage.z49;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public class AREditProcessor extends BaseEffectProcessor implements DuMixCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float GENDER_MALE_DEFAULT = 0.8f;
    public static final String TAG = "AREditProcessor";
    public transient /* synthetic */ FieldHolder $fh;
    public id0 beautyEnableStatus;
    public int i;
    public Map<BeautyType, Object> mBeautyMap;
    public long mCurrPosition;
    public DuMixCallback mDuMixCallback;
    public DuArEditProcessorCallback mEditProcessCallback;
    public dd0 mEffect;
    public dd0.l mEffectHolder;
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

    /* loaded from: classes4.dex */
    public interface DuArEditProcessorCallback {
        void onBeautyEnableChanged(id0 id0Var);

        void onChangeGender(boolean z);
    }

    public AREditProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.beautyEnableStatus = new id0();
        this.i = 0;
        this.mEffectHolder = new dd0.l(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.repackage.dd0.l
            public void onHolderChanged(dd0.l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, lVar) == null) {
                }
            }
        };
        b59 e = z49.c().e();
        if (e != null) {
            this.mIsArLoadSuccess = e.a();
        }
    }

    private boolean checkSticker(Sticker sticker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, sticker)) == null) ? sticker != null && sticker.isSupport(dd0.a0()) && !TextUtils.isEmpty(sticker.getPath()) && new File(sticker.getPath()).exists() && dd0.k1(sticker.getPath()) : invokeL.booleanValue;
    }

    private void createArInstance() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || dd0.M(this.mEffect, this.mEffectHolder)) {
            return;
        }
        if (!dd0.i0()) {
            dd0.k0();
        }
        if (dd0.i0()) {
            this.mEffect = dd0.U(z49.c().getContext(), this.mEffectHolder, EGL14.eglGetCurrentContext(), ed0.b());
            dd0.h1(this.mSyncInputContent || this.mPreviewSyncInputContent);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    w89.c(AREditProcessor.TAG, "faceid  " + faceIds[0] + "  isMale:  " + z + "  result: " + genders[0]);
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

    private void drawFrameBuffer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            GLES20.glBindFramebuffer(36160, this.mInputFrameBuffer);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFboInputTexId, 0);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            this.mFullScreen2D.drawFrame(i, GlUtil.IDENTITY_MATRIX);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    private void initDefParams() {
        dd0 dd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (dd0Var = this.mEffect) == null) {
            return;
        }
        dd0Var.c0(false);
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

    private Texture initOutputTexture(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, this, i, i2)) == null) {
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
        return (Texture) invokeII.objValue;
    }

    private void innerSetBeautyValues(Map<BeautyType, Object> map) {
        dd0 dd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, map) == null) || (dd0Var = this.mEffect) == null) {
            return;
        }
        dd0Var.R0(map);
    }

    private void loadCase() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.mSticker == null || this.mIsStickerLoaded) {
            return;
        }
        w89.c(TAG, "mCurrPosition = " + this.mCurrPosition + ", id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
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
                w89.c(TAG, "release AR instance");
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
                    w89.c(TAG, "id = " + this.mSticker.getId() + " , path = " + this.mSticker.getPath());
                }
                this.mEffect.O();
            }
            this.mIsStickerLoaded = false;
        }
    }

    private void resetInputAndOutputTexture() {
        dd0 dd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (dd0Var = this.mEffect) == null) {
            return;
        }
        dd0Var.E0();
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
        dd0 dd0Var = this.mEffect;
        if (dd0Var == null) {
            w89.c(TAG, "setInput Effect == null");
            return;
        }
        dd0Var.c1(texture);
        w89.c(TAG, "check ar size ：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
        onCameraDrawerCreated(null, this.mPreviewWidth, this.mPreviewHeight);
        onARDrawerCreated(null, null, this.mPreviewWidth, this.mPreviewHeight);
    }

    private void testAr(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65553, this, i, i2) == null) {
            this.i++;
            if (this.mSyncInputContent && this.savePic && (i3 = this.i) <= 2) {
                if (i3 == 1) {
                    o99.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.3
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
                fullFrameRect.drawFrame(i, GlUtil.IDENTITY_MATRIX);
                ThreadPool.b().e(new Runnable(this, "input-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.4
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                fullFrameRect.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
                ThreadPool.b().e(new Runnable(this, "ar-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.5
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                ThreadPool.b().e(new Runnable(this, "fbo-" + this.i + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.6
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsSetup && dd0.M(this.mEffect, this.mEffectHolder) : invokeV.booleanValue;
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i, i2) == null) {
            w89.c(TAG, "onARDrawerChanged, mEffect=" + this.mEffect);
        }
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, surfaceTexture, onFrameAvailableListener, i, i2) == null) {
            if (this.mEffect == null) {
                w89.c(TAG, "onARDrawerCreated Effect == null");
                return;
            }
            initOutputTexture(i, i2);
            this.mEffect.e1(this.mOutputTexture);
            this.mEffect.t0(surfaceTexture, onFrameAvailableListener, i, i2, false, this);
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
                            o99.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.AREditProcessor.2.1
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
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
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

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, surfaceTexture, i, i2) == null) {
            dd0 dd0Var = this.mEffect;
            if (dd0Var != null) {
                dd0Var.v0(surfaceTexture, i, i2);
            } else {
                w89.c(TAG, "onCameraDrawerCreated Effect == null");
            }
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseCreate(boolean z, String str, String str2) {
        Sticker sticker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            w89.b("create callback ---- result b = " + z + " casePath = " + str + " caseId = " + str2);
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
            w89.b("case destroy callback");
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
    public int onProcessFrame(oe0 oe0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oe0Var, i, fArr)) == null) {
            if (!this.mIsArLoadSuccess) {
                w89.c(TAG, "ship AR --- AR load so fail");
                return i;
            }
            if (this.mInputTexture == null) {
                initInputTexture();
                setupArInstance(this.mInputTexture);
                if (!this.mSyncInputContent || this.mIsSetup) {
                    w89.c(TAG, "----- initAr started -----");
                } else {
                    try {
                        w89.c(TAG, "----- waiting -----");
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        this.mLatch = countDownLatch;
                        try {
                            countDownLatch.await();
                        } catch (Exception unused) {
                        }
                        w89.c(TAG, "----- notified -----");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            w89.c(TAG, "-----params----- mSyncInputContent : " + this.mSyncInputContent + " mSkipARAfterSetup : " + this.mSkipARAfterSetup + " mBeautyMap : " + b99.f(this.mBeautyMap) + " mSticker : " + this.mSticker + " mImageQualityOpen : " + this.mImageQualityOpen);
            if (!this.mSyncInputContent && this.mSkipARAfterSetup && b99.f(this.mBeautyMap) && this.mSticker == null && !this.mImageQualityOpen) {
                w89.c(TAG, "ship AR --- no ar effect");
                return i;
            }
            if (oe0Var != null) {
                this.mCurrPosition = oe0Var.a();
            }
            if (!this.mIsSetup) {
                w89.c(TAG, "ship AR --- AR not setup or fail to setup, curPos = " + this.mCurrPosition);
                return i;
            }
            dd0 dd0Var = this.mEffect;
            int X = dd0Var != null ? dd0Var.X() : 0;
            if (X == 0) {
                w89.c(TAG, "ship AR --- AR output texture id is zero, curPos = " + this.mCurrPosition);
                return i;
            } else if (this.mEffect == null) {
                w89.c(TAG, "ship AR --- AR instace is null, curPos = " + this.mCurrPosition);
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
                w89.c(TAG, "ship AR --- ar first frame when ar is async, curPos = " + this.mCurrPosition);
                this.mSkipARAfterSetup = false;
                return i;
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
        dd0 dd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (dd0Var = this.mEffect) == null) {
            return;
        }
        dd0Var.F0();
        w89.c(TAG, "onResume1");
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        CountDownLatch countDownLatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
            if (z) {
                w89.c(TAG, "----- onSetup result：" + z + " -----");
                initDefParams();
                innerSetBeautyValues(this.mBeautyMap);
                setSticker(this.mSticker, this.mStickerStartTime, this.mStickerEndTime);
            } else {
                w89.c(TAG, "1571，onSetup返回失败：" + z);
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

    public void setBeautyValue(BeautyType beautyType, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048591, this, beautyType, f) == null) {
            this.mBeautyMap.put(beautyType, Float.valueOf(f));
            dd0 dd0Var = this.mEffect;
            if (dd0Var != null) {
                dd0Var.L0(beautyType, f);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, beautyType, i) == null) {
            this.mBeautyMap.put(beautyType, Integer.valueOf(i));
            dd0 dd0Var = this.mEffect;
            if (dd0Var != null) {
                dd0Var.M0(beautyType, i);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, beautyType, str) == null) {
            this.mBeautyMap.put(beautyType, str);
            dd0 dd0Var = this.mEffect;
            if (dd0Var != null) {
                dd0Var.P0(beautyType, str);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, beautyType, fArr) == null) {
            this.mBeautyMap.put(beautyType, fArr);
            dd0 dd0Var = this.mEffect;
            if (dd0Var != null) {
                dd0Var.Q0(beautyType, fArr);
            }
        }
    }

    public void setBeautyValues(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, map) == null) || b99.f(map)) {
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
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mImageQualityOpen = z;
            if (!z) {
                if (b99.f(this.mBeautyMap) && this.mSticker == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            if (i != this.mPreviewWidth && i2 != this.mPreviewHeight) {
                w89.c(TAG, "check ar size before：width = " + this.mPreviewWidth + " , height = " + this.mPreviewHeight);
                w89.c(TAG, "check ar size after ：width = " + i + " , height = " + i2);
            }
            super.setPreviewSize(i, i2);
        }
    }

    public void setPreviewSyncInputContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mPreviewSyncInputContent = z;
        }
    }

    public void setSticker(Sticker sticker, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{sticker, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            w89.c(TAG, "startTime = " + j + " , endTime = " + j2);
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
    }

    public void setSyncInputContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mSyncInputContent = z;
        }
    }
}

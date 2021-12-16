package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import c.a.b0.b.a.e;
import c.a.b0.b.a.k.c;
import c.a.y0.t.h;
import c.a.y0.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
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
import java.io.File;
/* loaded from: classes13.dex */
public class InputProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mTestSavePicCount;

    public InputProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void testPic(int i2, String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65537, this, i2, str) == null) || (i3 = this.mTestSavePicCount) >= 10) {
            return;
        }
        if (i3 == 0) {
            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.InputProcessor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InputProcessor this$0;

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
                        FileUtils.deleteFileOrDir(new File("/sdcard/zhmy/"));
                    }
                }
            });
        }
        FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        fullFrameRect.drawFrame(i2, GlUtil.IDENTITY_MATRIX);
        ThreadPool.b().e(new Runnable(this, str + "-test-" + this.mTestSavePicCount + "—" + System.currentTimeMillis() + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight)) { // from class: com.baidu.ugc.editvideo.record.processor.InputProcessor.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InputProcessor this$0;
            public final /* synthetic */ Bitmap val$bitmap;
            public final /* synthetic */ String val$name;

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

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, eVar, i2, fArr)) == null) {
            if (eVar == null || eVar.l() == null) {
                return i2;
            }
            MediaTrack mediaTrack = (MediaTrack) h.c(eVar.l(), 0);
            boolean m = c.m(mediaTrack, "input_blank");
            int f2 = !m ? eVar.f(mediaTrack, eVar.f(mediaTrack, eVar.f(mediaTrack, eVar.f(mediaTrack, eVar.f(mediaTrack, i2, 1, null), 5, null), 2, null), 3, null), 4, null) : i2;
            if (m) {
                for (int i3 = 1; i3 < eVar.l().size(); i3++) {
                    MediaTrack mediaTrack2 = eVar.l().get(i3);
                    if (mediaTrack2 != null && c.m(mediaTrack2, "multi_input")) {
                        f2 = eVar.i(mediaTrack2, f2, null);
                    }
                }
                f2 = eVar.f(mediaTrack, f2, 1, null);
            }
            return f2 == 0 ? i2 : f2;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}

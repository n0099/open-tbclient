package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
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
import com.repackage.fe0;
import com.repackage.h89;
import com.repackage.ne0;
import com.repackage.u79;
import java.io.File;
/* loaded from: classes4.dex */
public class InputProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mTestSavePicCount;

    public InputProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void testPic(int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65537, this, i, str) == null) || (i2 = this.mTestSavePicCount) >= 10) {
            return;
        }
        if (i2 == 0) {
            h89.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.processor.InputProcessor.1
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
        FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        fullFrameRect.drawFrame(i, GlUtil.IDENTITY_MATRIX);
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

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(fe0 fe0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, fe0Var, i, fArr)) == null) {
            if (fe0Var == null || fe0Var.l() == null) {
                return i;
            }
            MediaTrack mediaTrack = (MediaTrack) u79.c(fe0Var.l(), 0);
            boolean m = ne0.m(mediaTrack, "input_blank");
            int f = !m ? fe0Var.f(mediaTrack, fe0Var.f(mediaTrack, fe0Var.f(mediaTrack, fe0Var.f(mediaTrack, fe0Var.f(mediaTrack, i, 1, null), 5, null), 2, null), 3, null), 4, null) : i;
            if (m) {
                for (int i2 = 1; i2 < fe0Var.l().size(); i2++) {
                    MediaTrack mediaTrack2 = fe0Var.l().get(i2);
                    if (mediaTrack2 != null && ne0.m(mediaTrack2, "multi_input")) {
                        f = fe0Var.i(mediaTrack2, f, null);
                    }
                }
                f = fe0Var.f(mediaTrack, f, 1, null);
            }
            return f == 0 ? i : f;
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

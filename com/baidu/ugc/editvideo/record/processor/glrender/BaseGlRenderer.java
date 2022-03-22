package com.baidu.ugc.editvideo.record.processor.glrender;

import c.a.v0.r.c;
import c.a.v0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class BaseGlRenderer implements IGlRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public int mOutHeight;
    public int mOutWidth;
    public LinkedList<Runnable> runOnProcess;

    public BaseGlRenderer() {
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
        this.runOnProcess = new LinkedList<>();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fullFrameRect, fullFrameRect2) == null) {
            this.mFullScreenEXT = fullFrameRect;
            this.mFullScreen2D = fullFrameRect2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onPreProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            runPendingOnProcessTasks();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onSizeChange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.mOutWidth = i;
            this.mOutHeight = i2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void releaseProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void runPendingOnProcessTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (h.b(this.runOnProcess) > 0) {
                    c.b("runPendingOnProcessTasks : " + this.runOnProcess.size());
                }
                while (!this.runOnProcess.isEmpty()) {
                    this.runOnProcess.removeFirst().run();
                }
            } catch (Exception e2) {
                this.runOnProcess.clear();
                e2.printStackTrace();
            }
        }
    }
}

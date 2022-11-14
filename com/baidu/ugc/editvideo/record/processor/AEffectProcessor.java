package com.baidu.ugc.editvideo.record.processor;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.ff9;
import com.baidu.tieba.fg0;
import com.baidu.tieba.hj9;
import com.baidu.tieba.kg0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class AEffectProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCamera;
    public Map<String, ShaderConfig> mTrackConfig;
    public List<MediaTrack> mUpdateMediaTracks;
    public kg0 mVlogEditCore;
    public final LinkedList<Runnable> runOnDraw;

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public AEffectProcessor() {
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
        this.runOnDraw = new LinkedList<>();
        kg0 kg0Var = new kg0();
        this.mVlogEditCore = kg0Var;
        kg0Var.j(ff9.c().getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCamera() {
        MediaSegment mediaSegment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.isCamera = false;
            MediaTrack mediaTrack = (MediaTrack) hj9.c(this.mUpdateMediaTracks, 0);
            if (mediaTrack != null && (mediaSegment = (MediaSegment) hj9.c(mediaTrack.mediaSegments, 0)) != null && TextUtils.equals(mediaSegment.type, "camera")) {
                this.isCamera = true;
            }
        }
    }

    public void updateMediaTracks(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mUpdateMediaTracks = list;
            this.runOnDraw.add(new Runnable(this, list) { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AEffectProcessor this$0;
                public final /* synthetic */ List val$updateMediaTracks;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
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
                    this.val$updateMediaTracks = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.checkCamera();
                        this.this$0.mVlogEditCore.n(this.val$updateMediaTracks);
                    }
                }
            });
        }
    }

    private void runPendingOnDrawTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            while (!this.runOnDraw.isEmpty()) {
                this.runOnDraw.removeFirst().run();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            changeEffect(this.mTrackConfig, this.mUpdateMediaTracks);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mVlogEditCore.release();
        }
    }

    public void changeEffect(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, map, list) == null) {
            this.mTrackConfig = map;
            this.mUpdateMediaTracks = list;
            this.runOnDraw.add(new Runnable(this, list, map) { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AEffectProcessor this$0;
                public final /* synthetic */ Map val$shaderConfigMap;
                public final /* synthetic */ List val$updateMediaTracks;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, map};
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
                    this.val$updateMediaTracks = list;
                    this.val$shaderConfigMap = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.checkCamera();
                        if (this.this$0.mTrackConfig != null) {
                            this.this$0.mVlogEditCore.e(this.val$updateMediaTracks, this.val$shaderConfigMap);
                        } else {
                            this.this$0.mVlogEditCore.e(null, null);
                        }
                    }
                }
            });
        }
    }

    public void startRecordAnim(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.runOnDraw.add(new Runnable(this, i, j) { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AEffectProcessor this$0;
                public final /* synthetic */ int val$currentIndex;
                public final /* synthetic */ long val$playTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(j)};
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
                    this.val$currentIndex = i;
                    this.val$playTime = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mVlogEditCore.g(this.val$currentIndex, this.val$playTime);
                    }
                }
            });
        }
    }

    public int onProcessFrame(int i, float[] fArr) {
        InterceptResult invokeIL;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fArr)) == null) {
            runPendingOnDrawTasks();
            HashMap hashMap = new HashMap();
            if (this.isCamera) {
                c = this.mVlogEditCore.m(i, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
            } else {
                c = this.mVlogEditCore.c(this.mPreviewWidth, this.mPreviewHeight, hashMap);
            }
            if (c != 0) {
                return c;
            }
            return i;
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(fg0 fg0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, fg0Var, i, fArr)) == null) {
            runPendingOnDrawTasks();
            HashMap hashMap = new HashMap();
            if (this.isCamera) {
                c = this.mVlogEditCore.m(i, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
            } else {
                c = this.mVlogEditCore.c(this.mPreviewWidth, this.mPreviewHeight, hashMap);
            }
            if (c != 0) {
                return c;
            }
            return i;
        }
        return invokeLIL.intValue;
    }
}

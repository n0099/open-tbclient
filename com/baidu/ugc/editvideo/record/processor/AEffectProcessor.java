package com.baidu.ugc.editvideo.record.processor;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.v0.b;
import d.a.v0.t.h;
import d.a.z.b.a.e;
import d.a.z.b.a.j;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class AEffectProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCamera;
    public Map<String, ShaderConfig> mTrackConfig;
    public List<MediaTrack> mUpdateMediaTracks;
    public j mVlogEditCore;
    public final LinkedList<Runnable> runOnDraw;

    public AEffectProcessor() {
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
        this.runOnDraw = new LinkedList<>();
        j jVar = new j();
        this.mVlogEditCore = jVar;
        jVar.j(b.d().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCamera() {
        MediaSegment mediaSegment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.isCamera = false;
            MediaTrack mediaTrack = (MediaTrack) h.c(this.mUpdateMediaTracks, 0);
            if (mediaTrack == null || (mediaSegment = (MediaSegment) h.c(mediaTrack.mediaSegments, 0)) == null || !TextUtils.equals(mediaSegment.type, "camera")) {
                return;
            }
            this.isCamera = true;
        }
    }

    private void runPendingOnDrawTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            while (!this.runOnDraw.isEmpty()) {
                this.runOnDraw.removeFirst().run();
            }
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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

    public int onProcessFrame(int i2, float[] fArr) {
        InterceptResult invokeIL;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, fArr)) == null) {
            runPendingOnDrawTasks();
            HashMap hashMap = new HashMap();
            if (this.isCamera) {
                c2 = this.mVlogEditCore.l(i2, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
            } else {
                c2 = this.mVlogEditCore.c(this.mPreviewWidth, this.mPreviewHeight, hashMap);
            }
            return c2 == 0 ? i2 : c2;
        }
        return invokeIL.intValue;
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
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mVlogEditCore.release();
        }
    }

    public void startRecordAnim(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.runOnDraw.add(new Runnable(this, i2, j) { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.3
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
                        Object[] objArr = {this, Integer.valueOf(i2), Long.valueOf(j)};
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
                    this.val$currentIndex = i2;
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        this.this$0.mVlogEditCore.m(this.val$updateMediaTracks);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, eVar, i2, fArr)) == null) {
            runPendingOnDrawTasks();
            HashMap hashMap = new HashMap();
            if (this.isCamera) {
                c2 = this.mVlogEditCore.l(i2, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
            } else {
                c2 = this.mVlogEditCore.c(this.mPreviewWidth, this.mPreviewHeight, hashMap);
            }
            return c2 == 0 ? i2 : c2;
        }
        return invokeLIL.intValue;
    }
}

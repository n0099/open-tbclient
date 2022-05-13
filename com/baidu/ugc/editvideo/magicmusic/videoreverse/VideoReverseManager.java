package com.baidu.ugc.editvideo.magicmusic.videoreverse;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.listener.OnTimeReverseListener;
import com.baidu.ugc.utils.FileUtils;
import com.repackage.va9;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class VideoReverseManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile VideoReverseManager mVideoReverseManager;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoReverseHelper mReverseHelper;
    public Map<String, ReverseTask> mTaskMap;

    /* loaded from: classes4.dex */
    public class ReverseTask {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STATE_DONE = 2;
        public static final int STATE_FAILED = 3;
        public static final int STATE_RUNNING = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int state;
        public final /* synthetic */ VideoReverseManager this$0;
        public String videoPath;

        public ReverseTask(VideoReverseManager videoReverseManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoReverseManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = videoReverseManager;
        }
    }

    public VideoReverseManager() {
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
        this.mTaskMap = new WeakHashMap();
    }

    public static VideoReverseManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mVideoReverseManager == null) {
                synchronized (VideoReverseManager.class) {
                    if (mVideoReverseManager == null) {
                        mVideoReverseManager = new VideoReverseManager();
                    }
                }
            }
            return mVideoReverseManager;
        }
        return (VideoReverseManager) invokeV.objValue;
    }

    private void reverseVideo(ReverseTask reverseTask, WeakReference<OnTimeReverseListener> weakReference, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, reverseTask, weakReference, z) == null) {
            synchronized (reverseTask) {
                reverseTask.state = 1;
                if (this.mReverseHelper != null) {
                    this.mReverseHelper.setCancel(true);
                }
                VideoReverseHelper videoReverseHelper = new VideoReverseHelper();
                this.mReverseHelper = videoReverseHelper;
                videoReverseHelper.setTimeReverseListener(weakReference);
                if (this.mReverseHelper.reverseVideo(reverseTask.videoPath, VideoReverseHelper.getVideoReversePath(reverseTask.videoPath), z)) {
                    reverseTask.state = 2;
                } else {
                    reverseTask.state = 3;
                }
                reverseTask.notifyAll();
            }
        }
    }

    public VideoReverseHelper getReverseHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mReverseHelper : (VideoReverseHelper) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0063 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean reverseVideo(String str, OnTimeReverseListener onTimeReverseListener, boolean z) {
        InterceptResult invokeLLZ;
        ReverseTask reverseTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, onTimeReverseListener, z)) == null) {
            synchronized (this) {
                WeakReference<OnTimeReverseListener> weakReference = new WeakReference<>(onTimeReverseListener);
                try {
                } catch (Exception e) {
                    va9.g(e);
                    OnTimeReverseListener onTimeReverseListener2 = weakReference.get();
                    if (onTimeReverseListener2 != null) {
                        String str2 = z ? "MediaCodec点击倒放失败" : "MediaCodec预倒放失败";
                        onTimeReverseListener2.onTimeReverseError(new Exception(str2 + e.getMessage()));
                    }
                }
                if (FileUtils.checkFile(str)) {
                    if (FileUtils.checkFile(VideoReverseHelper.getVideoReversePath(str))) {
                        return true;
                    }
                    if (this.mTaskMap.containsKey(str)) {
                        reverseTask = this.mTaskMap.get(str);
                        if (reverseTask.state == 1) {
                            synchronized (reverseTask) {
                                if (reverseTask.state == 1) {
                                    try {
                                        reverseTask.wait();
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            if (FileUtils.checkFile(VideoReverseHelper.getVideoReversePath(str))) {
                                return true;
                            }
                            return false;
                        }
                        reverseTask.state = 1;
                    } else {
                        reverseTask = new ReverseTask(this);
                        reverseTask.videoPath = str;
                        this.mTaskMap.put(str, reverseTask);
                    }
                    reverseVideo(reverseTask, weakReference, z);
                    if (FileUtils.checkFile(VideoReverseHelper.getVideoReversePath(str))) {
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}

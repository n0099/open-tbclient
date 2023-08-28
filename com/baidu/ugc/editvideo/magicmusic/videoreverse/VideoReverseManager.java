package com.baidu.ugc.editvideo.magicmusic.videoreverse;

import com.baidu.tieba.agb;
import com.baidu.ugc.editvideo.listener.OnTimeReverseListener;
import com.baidu.ugc.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes9.dex */
public class VideoReverseManager {
    public static volatile VideoReverseManager mVideoReverseManager;
    public VideoReverseHelper mReverseHelper;
    public Map<String, ReverseTask> mTaskMap = new WeakHashMap();

    /* loaded from: classes9.dex */
    public class ReverseTask {
        public static final int STATE_DONE = 2;
        public static final int STATE_FAILED = 3;
        public static final int STATE_RUNNING = 1;
        public volatile int state;
        public String videoPath;

        public ReverseTask() {
        }
    }

    public static VideoReverseManager getInstance() {
        if (mVideoReverseManager == null) {
            synchronized (VideoReverseManager.class) {
                if (mVideoReverseManager == null) {
                    mVideoReverseManager = new VideoReverseManager();
                }
            }
        }
        return mVideoReverseManager;
    }

    private void reverseVideo(ReverseTask reverseTask, WeakReference<OnTimeReverseListener> weakReference, boolean z) {
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

    public VideoReverseHelper getReverseHelper() {
        return this.mReverseHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean reverseVideo(String str, OnTimeReverseListener onTimeReverseListener, boolean z) {
        ReverseTask reverseTask;
        WeakReference<OnTimeReverseListener> weakReference = new WeakReference<>(onTimeReverseListener);
        try {
        } catch (Exception e) {
            agb.g(e);
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
                reverseTask = new ReverseTask();
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

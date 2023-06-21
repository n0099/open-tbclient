package com.baidu.ugc.editvideo.editvideo.addfilter;

import com.baidu.tieba.bxa;
import com.baidu.tieba.jxa;
/* loaded from: classes8.dex */
public class InnerMediaProcessor extends Thread {
    public boolean mAddTrack;
    public volatile boolean mCanRetry;
    public long mClipDuration;
    public long mClipPoint;
    public boolean mCurrentEncodeHevcVideo;
    public boolean mEncodeHevcVideo;
    public String mErrMsg;
    public int mFrameRate;
    public OnGenFilterVideoListener mListener;
    public InnerMuxerWrapper mMuxer;
    public int mOutBitRate;
    public int mOutHeight;
    public int mOutWidth;
    public BaseOutputSurface mOutputSurface;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public volatile boolean mUserInterrupted;

    public void extractDecodeEditEncodeMux() throws Exception {
    }

    public String getMuxerLog() {
        return "no more log";
    }

    public void onInterrupt() {
    }

    public void onPostExecute() {
    }

    public void onPreExecute() {
    }

    public void onProgress(int i) {
    }

    public InnerMediaProcessor(String str) {
        super(str);
        this.mAddTrack = false;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setOutputSurface(BaseOutputSurface baseOutputSurface) {
        this.mOutputSurface = baseOutputSurface;
    }

    public void setOutputVideoBitRate(int i) {
        this.mOutBitRate = i;
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        this.mEncodeHevcVideo = z;
    }

    public void checkMuxerStart(boolean z) {
        if (!this.mMuxer.isStarted() && this.mAddTrack) {
            if (z) {
                this.mMuxer.setVideoStart();
            } else {
                this.mMuxer.setAudioStart();
            }
            if (!this.mMuxer.start()) {
                synchronized (this.mMuxer) {
                    while (!this.mMuxer.isStarted()) {
                        try {
                            this.mMuxer.wait(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
        this.mUserInterrupted = true;
    }

    public boolean isUnInterrupted() {
        if (!Thread.currentThread().isInterrupted() && !this.mUserInterrupted) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            extractDecodeEditEncodeMux();
            if (isUnInterrupted()) {
                jxa.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InnerMediaProcessor.this.onPostExecute();
                    }
                });
            }
        } catch (Exception unused) {
            if (this.mListener != null) {
                jxa.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        InnerMediaProcessor innerMediaProcessor = InnerMediaProcessor.this;
                        OnGenFilterVideoListener onGenFilterVideoListener = innerMediaProcessor.mListener;
                        if (onGenFilterVideoListener != null) {
                            if (!innerMediaProcessor.mCanRetry && !InnerMediaProcessor.this.mCurrentEncodeHevcVideo) {
                                i = -4;
                            } else {
                                i = -100;
                            }
                            onGenFilterVideoListener.onGenFilterVideoFail(i, InnerMediaProcessor.this.mErrMsg);
                        }
                    }
                });
            }
        }
    }

    public void log(String str, String str2) {
        bxa.l(str, str2);
    }

    public void setClipRange(long j, long j2) {
        this.mClipPoint = j;
        this.mClipDuration = j2;
    }

    public void setErrMsg(boolean z, String str) {
        this.mCanRetry = z;
        this.mErrMsg = str;
    }

    public void setOutputVideoSize(int i, int i2) {
        this.mOutWidth = i;
        this.mOutHeight = i2;
    }

    public void setPreviewVideoSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}

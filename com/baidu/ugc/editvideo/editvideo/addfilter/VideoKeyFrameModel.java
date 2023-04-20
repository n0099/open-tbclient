package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.tieba.lha;
import com.baidu.tieba.oda;
import com.baidu.tieba.qha;
import com.baidu.ugc.editvideo.editvideo.clip.OutputSurfaceWithoutFilter;
import com.baidu.ugc.editvideo.faceunity.encoder.MediaCodecHelper;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
import com.baidu.ugc.editvideo.magicmusic.EffectUtil;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@TargetApi(17)
/* loaded from: classes7.dex */
public class VideoKeyFrameModel {
    public static final String TAG = "VideoKeyFrameModel";
    public static final boolean VERBOSE = false;
    public Bitmap mBitmap;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mIsRelease;
    public OnDecodeFrameAvailableListener mOnDecodeFrameAvailableListener;
    public VideoEffectData mVideoEffectData;
    public Object mLock = new Object();
    public volatile boolean isStarted = false;
    public long mStartPosition = 0;
    public long mDuration = 0;
    public int mPerSecondFrame = 1;
    public long mLastPresentTime = 0;
    public int mAngle = 180;
    public boolean isMirror = true;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType;

        static {
            int[] iArr = new int[EffectType.values().length];
            $SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType = iArr;
            try {
                iArr[EffectType.TIME_REPEAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnAPeriodOfTimeFrameAvailableListener extends OnDecodeFrameAvailableListener {
        void onDecodeFrameEnd();

        void onDecodeFrameError();
    }

    /* loaded from: classes7.dex */
    public interface OnDecodeFrameAvailableListener {
        void onFrameAvailable(long j, Bitmap bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<Long> list, boolean z) throws IOException {
        long j;
        long j2;
        long j3;
        String str;
        long j4;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        OnDecodeFrameAvailableListener onDecodeFrameAvailableListener;
        int dequeueInputBuffer;
        MediaExtractor mediaExtractor2 = mediaExtractor;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        if (qha.e(list) || list.size() != 1) {
            j = 0;
            j2 = -1;
        } else {
            long longValue = list.get(0).longValue();
            long j5 = longValue <= 0 ? 1L : longValue;
            mediaExtractor.getSampleTime();
            if (z) {
                mediaExtractor2.seekTo(j5, 0);
            } else {
                mediaExtractor2.seekTo(j5, 2);
            }
            j = 0;
            if (mediaExtractor.getSampleTime() > j5) {
                mediaExtractor2.seekTo(0L, 2);
            }
            j2 = j5;
        }
        if (qha.e(list)) {
            if (this.mStartPosition > j) {
                mediaExtractor.getSampleTime();
                long j6 = this.mStartPosition;
                if (z) {
                    mediaExtractor2.seekTo(j6, 0);
                } else {
                    mediaExtractor2.seekTo(j6, 2);
                }
                if (mediaExtractor.getSampleTime() > this.mStartPosition) {
                    j3 = 0;
                    mediaExtractor2.seekTo(0L, 2);
                }
            }
            j3 = 0;
        } else {
            j3 = j;
        }
        int i3 = 0;
        boolean z5 = false;
        boolean z6 = false;
        while (!z5 && !this.mIsRelease) {
            if (z6 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                str = TAG;
                j4 = j3;
                i2 = i3;
            } else {
                int readSampleData = mediaExtractor2.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                if (readSampleData < 0) {
                    str = TAG;
                    j4 = j3;
                    i2 = i3;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    z6 = true;
                } else {
                    str = TAG;
                    j4 = j3;
                    i2 = i3;
                    if (mediaExtractor.getSampleTrackIndex() != i) {
                        lha.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                    }
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                    mediaExtractor.advance();
                }
            }
            if (z5) {
                i3 = i2;
                j3 = j4;
                mediaExtractor2 = mediaExtractor;
            } else {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else if (dequeueOutputBuffer < 0) {
                        lha.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    } else {
                        boolean z7 = (bufferInfo.flags & 4) != 0 ? true : z5;
                        if (this.mDuration > j4 || qha.e(list)) {
                            if (bufferInfo.size != 0) {
                                z2 = z7;
                                if (bufferInfo.presentationTimeUs >= this.mStartPosition) {
                                    z3 = true;
                                    z4 = z3;
                                    boolean z8 = z2;
                                    if (bufferInfo.presentationTimeUs > this.mStartPosition + this.mDuration) {
                                        bufferInfo.flags = 4;
                                    }
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                                    if (z4) {
                                        baseOutputSurface.awaitNewImage();
                                        baseOutputSurface.drawImage((int) (bufferInfo.presentationTimeUs / 1000));
                                        long j7 = this.mLastPresentTime;
                                        if ((j7 == j4 || bufferInfo.presentationTimeUs - j7 >= 1000000 / this.mPerSecondFrame) && (onDecodeFrameAvailableListener = this.mOnDecodeFrameAvailableListener) != null) {
                                            onDecodeFrameAvailableListener.onFrameAvailable(bufferInfo.presentationTimeUs, baseOutputSurface.getFrameBitmap());
                                            this.mLastPresentTime = bufferInfo.presentationTimeUs;
                                        }
                                    }
                                    i3 = i2;
                                    z5 = (bufferInfo.flags & 4) == 0 ? true : z8;
                                }
                            } else {
                                z2 = z7;
                            }
                            z3 = false;
                            z4 = z3;
                            boolean z82 = z2;
                            if (bufferInfo.presentationTimeUs > this.mStartPosition + this.mDuration) {
                            }
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                            if (z4) {
                            }
                            i3 = i2;
                            if ((bufferInfo.flags & 4) == 0) {
                            }
                        } else {
                            boolean z9 = bufferInfo.size != 0;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z9);
                            if (z9) {
                                baseOutputSurface.awaitNewImage();
                                baseOutputSurface.drawImage((int) (bufferInfo.presentationTimeUs / 1000));
                                if (j2 != -1) {
                                    if (!z) {
                                        this.mBitmap = baseOutputSurface.getFrameBitmap();
                                    } else if (bufferInfo.presentationTimeUs >= j2) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        this.mBitmap = baseOutputSurface.getFrameBitmap();
                                        lha.c("zmy", "draw cost : " + (System.currentTimeMillis() - currentTimeMillis));
                                    }
                                    i3 = i2;
                                    z7 = true;
                                    z5 = z7;
                                } else {
                                    long longValue2 = list.get(i2).longValue();
                                    if (longValue2 <= j4) {
                                        longValue2 = 1;
                                    } else if (i2 == list.size() - 1) {
                                        longValue2 -= 800000;
                                    }
                                    if (bufferInfo.presentationTimeUs >= longValue2) {
                                        OnDecodeFrameAvailableListener onDecodeFrameAvailableListener2 = this.mOnDecodeFrameAvailableListener;
                                        if (onDecodeFrameAvailableListener2 != null) {
                                            onDecodeFrameAvailableListener2.onFrameAvailable(list.get(i2).longValue(), baseOutputSurface.getFrameBitmap());
                                        }
                                        if (i2 == list.size() - 1) {
                                            z7 = true;
                                        }
                                        i3 = i2 + 1;
                                        z5 = z7;
                                    }
                                }
                            }
                            i3 = i2;
                            z5 = z7;
                        }
                        mediaExtractor2 = mediaExtractor;
                        j3 = j4;
                    }
                }
                i3 = i2;
                mediaExtractor2 = mediaExtractor;
                j3 = j4;
            }
        }
    }

    private void extractMpegFrames(String str, List<Long> list, boolean z) throws IOException {
        extractMpegFrames(str, list, z, 0, 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0044 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:9|(13:13|14|15|(2:17|18)(2:58|59)|19|21|22|23|24|25|(1:27)|28|29)|64|14|15|(0)(0)|19|21|22|23|24|25|(0)|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a8, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        r11 = null;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r11 = null;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f8, code lost:
        com.baidu.tieba.lha.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fd, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0100, code lost:
        if (r11 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0102, code lost:
        r11.stop();
        r11.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0108, code lost:
        if (r9 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010f, code lost:
        if (r1 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0114, code lost:
        if (r11 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
        r11.stop();
        r11.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011c, code lost:
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011e, code lost:
        r9.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0121, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[Catch: all -> 0x00d4, Exception -> 0x00d7, TRY_LEAVE, TryCatch #10 {Exception -> 0x00d7, all -> 0x00d4, blocks: (B:6:0x0015, B:8:0x0022, B:14:0x003e, B:16:0x0046, B:19:0x0066, B:13:0x0030, B:41:0x00bd, B:42:0x00d3), top: B:72:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[Catch: all -> 0x00d4, Exception -> 0x00d7, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x00d7, all -> 0x00d4, blocks: (B:6:0x0015, B:8:0x0022, B:14:0x003e, B:16:0x0046, B:19:0x0066, B:13:0x0030, B:41:0x00bd, B:42:0x00d3), top: B:72:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011e  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractMpegFrames(String str, List<Long> list, boolean z, int i, int i2) throws IOException {
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec;
        File file;
        int andSelectVideoTrackIndex;
        int integer;
        int integer2;
        ?? hasEffect;
        BaseOutputSurface baseOutputSurface = null;
        try {
            file = new File(str);
        } catch (Exception e) {
            e = e;
            mediaExtractor = null;
            mediaCodec = null;
        } catch (Throwable th) {
            th = th;
            mediaExtractor = null;
            mediaCodec = null;
        }
        if (!file.canRead()) {
            throw new FileNotFoundException("Unable to read " + file);
        }
        mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(file.toString());
            andSelectVideoTrackIndex = MediaCodecHelper.getAndSelectVideoTrackIndex(mediaExtractor);
        } catch (Exception e2) {
            e = e2;
            mediaCodec = null;
        } catch (Throwable th2) {
            th = th2;
            mediaCodec = null;
        }
        if (andSelectVideoTrackIndex < 0) {
            throw new RuntimeException("No video track found in " + file);
        }
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
        if (i != 0 && i2 != 0) {
            integer = i;
            integer2 = i2;
            hasEffect = VideoEffectData.hasEffect(this.mVideoEffectData);
            if (hasEffect == 0) {
                OutputSurfaceWithFilter outputSurfaceWithFilter = new OutputSurfaceWithFilter(oda.c().getContext(), null, false, integer, integer2, true, this.mHandler);
                outputSurfaceWithFilter.setMagicEffectList(this.mVideoEffectData.getMagicEffectList());
                hasEffect = outputSurfaceWithFilter;
            } else {
                OutputSurfaceWithoutFilter outputSurfaceWithoutFilter = new OutputSurfaceWithoutFilter(integer, integer2, true, this.mHandler);
                outputSurfaceWithoutFilter.setAngle(this.mAngle);
                outputSurfaceWithoutFilter.setMirror(this.isMirror);
                hasEffect = outputSurfaceWithoutFilter;
            }
            BaseOutputSurface baseOutputSurface2 = hasEffect;
            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            mediaCodec.configure(trackFormat, baseOutputSurface2.getSurface(), (MediaCrypto) null, 0);
            mediaCodec.start();
            doExtract(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, baseOutputSurface2, list, z);
            baseOutputSurface2.release();
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            mediaExtractor.release();
        }
        integer = trackFormat.getInteger("width");
        integer2 = trackFormat.getInteger("height");
        hasEffect = VideoEffectData.hasEffect(this.mVideoEffectData);
        if (hasEffect == 0) {
        }
        BaseOutputSurface baseOutputSurface22 = hasEffect;
        mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        mediaCodec.configure(trackFormat, baseOutputSurface22.getSurface(), (MediaCrypto) null, 0);
        mediaCodec.start();
        doExtract(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, baseOutputSurface22, list, z);
        baseOutputSurface22.release();
        if (mediaCodec != null) {
        }
        mediaExtractor.release();
    }

    private void processEffectList() {
        VideoEffectData videoEffectData = this.mVideoEffectData;
        if (videoEffectData == null) {
            return;
        }
        if (!qha.e(videoEffectData.getMagicEffectList())) {
            ArrayList arrayList = new ArrayList();
            for (BaseEffect baseEffect : this.mVideoEffectData.getMagicEffectList()) {
                EffectUtil.addEffect(baseEffect, arrayList);
            }
            this.mVideoEffectData.setMagicEffectList(arrayList);
        }
        processMagicEffectListForTimeEffect();
    }

    private void processMagicEffectListForTimeEffect() {
        int i;
        int i2;
        if (qha.e(this.mVideoEffectData.getMagicEffectList()) || this.mVideoEffectData.getTimeEffect() == null) {
            return;
        }
        BaseEffect timeEffect = this.mVideoEffectData.getTimeEffect();
        if (AnonymousClass4.$SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType[timeEffect.effectType.ordinal()] != 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = timeEffect.endTime - timeEffect.startTime;
        for (BaseEffect baseEffect : this.mVideoEffectData.getMagicEffectList()) {
            if (baseEffect != null) {
                int i4 = 0;
                if (baseEffect.startTime < timeEffect.startTime || baseEffect.endTime > timeEffect.endTime) {
                    int i5 = baseEffect.startTime;
                    int i6 = timeEffect.startTime;
                    if (i5 >= i6 || (i2 = baseEffect.endTime) <= i6 || i2 >= timeEffect.endTime) {
                        int i7 = baseEffect.startTime;
                        if (i7 <= timeEffect.startTime || i7 >= (i = timeEffect.endTime) || baseEffect.endTime <= i) {
                            int i8 = baseEffect.startTime;
                            if (i8 > timeEffect.endTime) {
                                int i9 = i3 * 2;
                                baseEffect.startTime = i8 + i9;
                                baseEffect.endTime += i9;
                            }
                            arrayList.add(baseEffect);
                        } else {
                            while (i4 < 3) {
                                BaseEffect baseEffect2 = (BaseEffect) baseEffect.clone();
                                int i10 = i3 * i4;
                                baseEffect2.startTime += i10;
                                baseEffect2.endTime = (i4 < 2 ? timeEffect.endTime : baseEffect2.endTime) + i10;
                                arrayList.add(baseEffect2);
                                i4++;
                            }
                        }
                    } else {
                        while (i4 < 3) {
                            BaseEffect baseEffect3 = (BaseEffect) baseEffect.clone();
                            int i11 = i3 * i4;
                            baseEffect3.startTime = (i4 == 0 ? baseEffect3.startTime : timeEffect.startTime) + i11;
                            baseEffect3.endTime += i11;
                            arrayList.add(baseEffect3);
                            i4++;
                        }
                    }
                } else {
                    while (i4 < 3) {
                        BaseEffect baseEffect4 = (BaseEffect) baseEffect.clone();
                        int i12 = i3 * i4;
                        baseEffect4.startTime += i12;
                        baseEffect4.endTime += i12;
                        arrayList.add(baseEffect4);
                        i4++;
                    }
                }
            }
        }
        this.mVideoEffectData.setMagicEffectList(arrayList);
    }

    public Bitmap getFrameAtTime(String str, long j, boolean z) {
        return getFrameAtTime(str, j, z, 0, 0);
    }

    public Bitmap getFrameAtTime(final String str, final long j, final boolean z, final int i, final int i2) {
        HandlerThread handlerThread = new HandlerThread("fuck_code") { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.1
            @Override // android.os.HandlerThread
            public void onLooperPrepared() {
                super.onLooperPrepared();
                synchronized (VideoKeyFrameModel.this.mLock) {
                    VideoKeyFrameModel.this.isStarted = true;
                    VideoKeyFrameModel.this.mHandler = new Handler(VideoKeyFrameModel.this.mHandlerThread.getLooper());
                    VideoKeyFrameModel.this.mLock.notifyAll();
                }
            }
        };
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        if (!this.isStarted) {
            synchronized (this.mLock) {
                try {
                    if (!this.isStarted) {
                        this.mLock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(j));
                    VideoKeyFrameModel.this.extractMpegFrames(str, arrayList, z, i, i2);
                } catch (Exception e2) {
                    lha.g(e2);
                    e2.printStackTrace();
                }
            }
        }, "codec getFrameAtTime");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        return null;
    }

    public void getFrameAtTimeList(final String str, final List<Long> list, final int i, final int i2, OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        this.mOnDecodeFrameAvailableListener = onDecodeFrameAvailableListener;
        this.mHandler = null;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VideoKeyFrameModel.this.extractMpegFrames(str, list, true, i, i2);
                } catch (Exception e) {
                    lha.g(e);
                    e.printStackTrace();
                }
            }
        }, "codec getFrameAtTime").start();
    }

    public void release() {
        this.mIsRelease = true;
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void setAngle(int i) {
        this.mAngle = i;
    }

    public void setMirror(boolean z) {
        this.isMirror = z;
    }

    public void setOnDecodeFrameAvailableListener(OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        this.mOnDecodeFrameAvailableListener = onDecodeFrameAvailableListener;
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        this.mVideoEffectData = videoEffectData;
        processEffectList();
    }
}

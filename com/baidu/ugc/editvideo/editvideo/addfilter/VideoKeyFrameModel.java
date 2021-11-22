package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import b.a.x0.b;
import b.a.x0.t.c;
import b.a.x0.t.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public class VideoKeyFrameModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VideoKeyFrameModel";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMirror;
    public volatile boolean isStarted;
    public int mAngle;
    public Bitmap mBitmap;
    public long mDuration;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mIsRelease;
    public long mLastPresentTime;
    public Object mLock;
    public OnDecodeFrameAvailableListener mOnDecodeFrameAvailableListener;
    public int mPerSecondFrame;
    public long mStartPosition;
    public VideoEffectData mVideoEffectData;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(573750157, "Lcom/baidu/ugc/editvideo/editvideo/addfilter/VideoKeyFrameModel$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(573750157, "Lcom/baidu/ugc/editvideo/editvideo/addfilter/VideoKeyFrameModel$4;");
                    return;
                }
            }
            int[] iArr = new int[EffectType.values().length];
            $SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType = iArr;
            try {
                iArr[EffectType.TIME_REPEAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface OnAPeriodOfTimeFrameAvailableListener extends OnDecodeFrameAvailableListener {
        void onDecodeFrameEnd();

        void onDecodeFrameError();
    }

    /* loaded from: classes9.dex */
    public interface OnDecodeFrameAvailableListener {
        void onFrameAvailable(long j, Bitmap bitmap);
    }

    public VideoKeyFrameModel() {
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
        this.mLock = new Object();
        this.isStarted = false;
        this.mStartPosition = 0L;
        this.mDuration = 0L;
        this.mPerSecondFrame = 1;
        this.mLastPresentTime = 0L;
        this.mAngle = 180;
        this.isMirror = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i2, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<Long> list, boolean z) throws IOException {
        long j;
        long j2;
        long j3;
        String str;
        long j4;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        OnDecodeFrameAvailableListener onDecodeFrameAvailableListener;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{mediaExtractor, Integer.valueOf(i2), mediaCodec, baseOutputSurface, list, Boolean.valueOf(z)}) == null) {
            MediaExtractor mediaExtractor2 = mediaExtractor;
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            if (h.e(list) || list.size() != 1) {
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
            if (h.e(list)) {
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
            int i4 = 0;
            boolean z5 = false;
            boolean z6 = false;
            while (!z5 && !this.mIsRelease) {
                if (z6 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                    str = TAG;
                    j4 = j3;
                    i3 = i4;
                } else {
                    int readSampleData = mediaExtractor2.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                    if (readSampleData < 0) {
                        str = TAG;
                        j4 = j3;
                        i3 = i4;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        z6 = true;
                    } else {
                        str = TAG;
                        j4 = j3;
                        i3 = i4;
                        if (mediaExtractor.getSampleTrackIndex() != i2) {
                            c.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i2);
                        }
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                        mediaExtractor.advance();
                    }
                }
                if (z5) {
                    i4 = i3;
                    j3 = j4;
                    mediaExtractor2 = mediaExtractor;
                } else {
                    int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                    if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer == -2) {
                            mediaCodec.getOutputFormat();
                        } else if (dequeueOutputBuffer < 0) {
                            c.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        } else {
                            boolean z7 = (bufferInfo.flags & 4) != 0 ? true : z5;
                            if (this.mDuration > j4 || h.e(list)) {
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
                                        i4 = i3;
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
                                i4 = i3;
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
                                            c.c("zmy", "draw cost : " + (System.currentTimeMillis() - currentTimeMillis));
                                        }
                                        i4 = i3;
                                        z7 = true;
                                        z5 = z7;
                                    } else {
                                        long longValue2 = list.get(i3).longValue();
                                        if (longValue2 <= j4) {
                                            longValue2 = 1;
                                        } else if (i3 == list.size() - 1) {
                                            longValue2 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= longValue2) {
                                            OnDecodeFrameAvailableListener onDecodeFrameAvailableListener2 = this.mOnDecodeFrameAvailableListener;
                                            if (onDecodeFrameAvailableListener2 != null) {
                                                onDecodeFrameAvailableListener2.onFrameAvailable(list.get(i3).longValue(), baseOutputSurface.getFrameBitmap());
                                            }
                                            if (i3 == list.size() - 1) {
                                                z7 = true;
                                            }
                                            i4 = i3 + 1;
                                            z5 = z7;
                                        }
                                    }
                                }
                                i4 = i3;
                                z5 = z7;
                            }
                            mediaExtractor2 = mediaExtractor;
                            j3 = j4;
                        }
                    }
                    i4 = i3;
                    mediaExtractor2 = mediaExtractor;
                    j3 = j4;
                }
            }
        }
    }

    private void extractMpegFrames(String str, List<Long> list, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, this, str, list, z) == null) {
            extractMpegFrames(str, list, z, 0, 0);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0048 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:11|(13:15|16|17|(2:19|20)(2:60|61)|21|22|23|25|26|27|(1:29)|30|31)|66|16|17|(0)(0)|21|22|23|25|26|27|(0)|30|31) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r11 = null;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00be, code lost:
        r11 = null;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fc, code lost:
        b.a.x0.t.c.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ff, code lost:
        if (r1 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0101, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0104, code lost:
        if (r11 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0106, code lost:
        r11.stop();
        r11.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
        if (r9 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0112, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0113, code lost:
        if (r1 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0115, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0118, code lost:
        if (r11 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
        r11.stop();
        r11.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0120, code lost:
        if (r9 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0122, code lost:
        r9.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0125, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[Catch: all -> 0x00d8, Exception -> 0x00db, TRY_LEAVE, TryCatch #8 {Exception -> 0x00db, all -> 0x00d8, blocks: (B:8:0x0019, B:10:0x0026, B:16:0x0042, B:18:0x004a, B:21:0x006a, B:15:0x0034, B:43:0x00c1, B:44:0x00d7), top: B:82:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x00d8, Exception -> 0x00db, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x00db, all -> 0x00d8, blocks: (B:8:0x0019, B:10:0x0026, B:16:0x0042, B:18:0x004a, B:21:0x006a, B:15:0x0034, B:43:0x00c1, B:44:0x00d7), top: B:82:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractMpegFrames(String str, List<Long> list, boolean z, int i2, int i3) throws IOException {
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec;
        File file;
        int andSelectVideoTrackIndex;
        int integer;
        int integer2;
        ?? hasEffect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            BaseOutputSurface baseOutputSurface = null;
            try {
                file = new File(str);
            } catch (Exception e2) {
                e = e2;
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
            } catch (Exception e3) {
                e = e3;
                mediaCodec = null;
            } catch (Throwable th2) {
                th = th2;
                mediaCodec = null;
            }
            if (andSelectVideoTrackIndex < 0) {
                throw new RuntimeException("No video track found in " + file);
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
            if (i2 != 0 && i3 != 0) {
                integer = i2;
                integer2 = i3;
                hasEffect = VideoEffectData.hasEffect(this.mVideoEffectData);
                if (hasEffect == 0) {
                    OutputSurfaceWithFilter outputSurfaceWithFilter = new OutputSurfaceWithFilter(b.c().getContext(), null, false, integer, integer2, true, this.mHandler);
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
    }

    private void processEffectList() {
        VideoEffectData videoEffectData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (videoEffectData = this.mVideoEffectData) == null) {
            return;
        }
        if (!h.e(videoEffectData.getMagicEffectList())) {
            ArrayList arrayList = new ArrayList();
            for (BaseEffect baseEffect : this.mVideoEffectData.getMagicEffectList()) {
                EffectUtil.addEffect(baseEffect, arrayList);
            }
            this.mVideoEffectData.setMagicEffectList(arrayList);
        }
        processMagicEffectListForTimeEffect();
    }

    private void processMagicEffectListForTimeEffect() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || h.e(this.mVideoEffectData.getMagicEffectList()) || this.mVideoEffectData.getTimeEffect() == null) {
            return;
        }
        BaseEffect timeEffect = this.mVideoEffectData.getTimeEffect();
        if (AnonymousClass4.$SwitchMap$com$baidu$ugc$editvideo$magicmusic$EffectType[timeEffect.effectType.ordinal()] != 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = timeEffect.endTime - timeEffect.startTime;
        for (BaseEffect baseEffect : this.mVideoEffectData.getMagicEffectList()) {
            if (baseEffect != null) {
                int i5 = 0;
                if (baseEffect.startTime < timeEffect.startTime || baseEffect.endTime > timeEffect.endTime) {
                    int i6 = baseEffect.startTime;
                    int i7 = timeEffect.startTime;
                    if (i6 >= i7 || (i3 = baseEffect.endTime) <= i7 || i3 >= timeEffect.endTime) {
                        int i8 = baseEffect.startTime;
                        if (i8 <= timeEffect.startTime || i8 >= (i2 = timeEffect.endTime) || baseEffect.endTime <= i2) {
                            int i9 = baseEffect.startTime;
                            if (i9 > timeEffect.endTime) {
                                int i10 = i4 * 2;
                                baseEffect.startTime = i9 + i10;
                                baseEffect.endTime += i10;
                            }
                            arrayList.add(baseEffect);
                        } else {
                            while (i5 < 3) {
                                BaseEffect baseEffect2 = (BaseEffect) baseEffect.clone();
                                int i11 = i4 * i5;
                                baseEffect2.startTime += i11;
                                baseEffect2.endTime = (i5 < 2 ? timeEffect.endTime : baseEffect2.endTime) + i11;
                                arrayList.add(baseEffect2);
                                i5++;
                            }
                        }
                    } else {
                        while (i5 < 3) {
                            BaseEffect baseEffect3 = (BaseEffect) baseEffect.clone();
                            int i12 = i4 * i5;
                            baseEffect3.startTime = (i5 == 0 ? baseEffect3.startTime : timeEffect.startTime) + i12;
                            baseEffect3.endTime += i12;
                            arrayList.add(baseEffect3);
                            i5++;
                        }
                    }
                } else {
                    while (i5 < 3) {
                        BaseEffect baseEffect4 = (BaseEffect) baseEffect.clone();
                        int i13 = i4 * i5;
                        baseEffect4.startTime += i13;
                        baseEffect4.endTime += i13;
                        arrayList.add(baseEffect4);
                        i5++;
                    }
                }
            }
        }
        this.mVideoEffectData.setMagicEffectList(arrayList);
    }

    public Bitmap getFrameAtTime(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) ? getFrameAtTime(str, j, z, 0, 0) : (Bitmap) invokeCommon.objValue;
    }

    public Bitmap getFrameAtTime(String str, long j, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            HandlerThread handlerThread = new HandlerThread(this, "fuck_code") { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoKeyFrameModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.HandlerThread
                public void onLooperPrepared() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.onLooperPrepared();
                        synchronized (this.this$0.mLock) {
                            this.this$0.isStarted = true;
                            this.this$0.mHandler = new Handler(this.this$0.mHandlerThread.getLooper());
                            this.this$0.mLock.notifyAll();
                        }
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
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Thread thread = new Thread(new Runnable(this, j, str, z, i2, i3) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoKeyFrameModel this$0;
                public final /* synthetic */ boolean val$exactTime;
                public final /* synthetic */ int val$height;
                public final /* synthetic */ long val$timeUs;
                public final /* synthetic */ String val$videoPath;
                public final /* synthetic */ int val$width;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
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
                    this.val$timeUs = j;
                    this.val$videoPath = str;
                    this.val$exactTime = z;
                    this.val$width = i2;
                    this.val$height = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(Long.valueOf(this.val$timeUs));
                            this.this$0.extractMpegFrames(this.val$videoPath, arrayList, this.val$exactTime, this.val$width, this.val$height);
                        } catch (Exception e3) {
                            c.g(e3);
                            e3.printStackTrace();
                        }
                    }
                }
            }, "codec getFrameAtTime");
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                return bitmap;
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public void getFrameAtTimeList(String str, List<Long> list, int i2, int i3, OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i2), Integer.valueOf(i3), onDecodeFrameAvailableListener}) == null) {
            this.mOnDecodeFrameAvailableListener = onDecodeFrameAvailableListener;
            this.mHandler = null;
            new Thread(new Runnable(this, str, list, i2, i3) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoKeyFrameModel this$0;
                public final /* synthetic */ int val$height;
                public final /* synthetic */ List val$timeUsList;
                public final /* synthetic */ String val$videoPath;
                public final /* synthetic */ int val$width;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, list, Integer.valueOf(i2), Integer.valueOf(i3)};
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
                    this.val$videoPath = str;
                    this.val$timeUsList = list;
                    this.val$width = i2;
                    this.val$height = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.extractMpegFrames(this.val$videoPath, this.val$timeUsList, true, this.val$width, this.val$height);
                        } catch (Exception e2) {
                            c.g(e2);
                            e2.printStackTrace();
                        }
                    }
                }
            }, "codec getFrameAtTime").start();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mIsRelease = true;
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
        }
    }

    public void setAngle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mAngle = i2;
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isMirror = z;
        }
    }

    public void setOnDecodeFrameAvailableListener(OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onDecodeFrameAvailableListener) == null) {
            this.mOnDecodeFrameAvailableListener = onDecodeFrameAvailableListener;
        }
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoEffectData) == null) {
            this.mVideoEffectData = videoEffectData;
            processEffectList();
        }
    }
}

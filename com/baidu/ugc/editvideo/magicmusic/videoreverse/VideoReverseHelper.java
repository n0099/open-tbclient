package com.baidu.ugc.editvideo.magicmusic.videoreverse;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import c.a.y0.t.c;
import c.a.y0.t.h;
import c.a.y0.t.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.listener.OnTimeReverseListener;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
@TargetApi(18)
/* loaded from: classes13.dex */
public class VideoReverseHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    public static final String REVERSE_SUFFIX = "mini_reverse";
    public static final String REVERSE_TEMP_SUFFIX = "temp_mini_reverse_file_";
    public static final int TIMEOUT_USEC = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaFormat mDeocderOutputFormat;
    public boolean mIsCancel;
    public MediaExtractor mMediaExtractor;
    public MediaMuxer mMediaMuxer;
    public WeakReference<OnTimeReverseListener> mOnTimeReverseListenerWeakReference;
    public MediaCodec mVideoDecoder;
    public MediaCodec mVideoEncoder;

    /* loaded from: classes13.dex */
    public static class BuffeInfoWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaCodec.BufferInfo bufferInfo;
        public int fileOffset;

        public BuffeInfoWrapper() {
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
    }

    public VideoReverseHelper() {
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
        this.mIsCancel = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
        com.baidu.ugc.utils.FileUtils.deleteFile(r25);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<BuffeInfoWrapper> extractVideoToPath(String str, String str2) {
        InterceptResult invokeLL;
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            if (this.mMediaExtractor == null) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                this.mMediaExtractor = mediaExtractor;
                try {
                    mediaExtractor.setDataSource(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            File file = new File(str2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            try {
                FileChannel channel = new RandomAccessFile(str2, "rw").getChannel();
                ArrayList arrayList = new ArrayList();
                int andSelectVideoTrackIndex = getAndSelectVideoTrackIndex(this.mMediaExtractor);
                MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                if (this.mVideoDecoder == null) {
                    try {
                        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(trackFormat));
                        this.mVideoDecoder = createDecoderByType;
                        createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                        this.mDeocderOutputFormat = this.mVideoDecoder.getOutputFormat();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return null;
                    }
                }
                this.mVideoDecoder.start();
                this.mMediaExtractor.selectTrack(andSelectVideoTrackIndex);
                try {
                    ByteBuffer[] inputBuffers = this.mVideoDecoder.getInputBuffers();
                    ByteBuffer[] outputBuffers = this.mVideoDecoder.getOutputBuffers();
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    boolean z = false;
                    boolean z2 = false;
                    int i3 = 0;
                    while (true) {
                        if (z) {
                            break;
                        } else if (this.mIsCancel) {
                            break;
                        } else {
                            while (true) {
                                i2 = -1;
                                j2 = 10000;
                                if (z2) {
                                    break;
                                } else if (this.mIsCancel) {
                                    FileUtils.deleteFile(str2);
                                    break;
                                } else {
                                    int dequeueInputBuffer = this.mVideoDecoder.dequeueInputBuffer(10000L);
                                    if (dequeueInputBuffer == -1) {
                                        break;
                                    }
                                    int readSampleData = this.mMediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                    if (readSampleData >= 0) {
                                        this.mVideoDecoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), this.mMediaExtractor.getSampleFlags());
                                    }
                                    z2 = !this.mMediaExtractor.advance();
                                    if (z2) {
                                        this.mVideoDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    }
                                }
                            }
                            while (true) {
                                if (z) {
                                    break;
                                } else if (this.mIsCancel) {
                                    FileUtils.deleteFile(str2);
                                    break;
                                } else {
                                    int dequeueOutputBuffer = this.mVideoDecoder.dequeueOutputBuffer(bufferInfo, j2);
                                    if (dequeueOutputBuffer != i2) {
                                        if (dequeueOutputBuffer == -3) {
                                            outputBuffers = this.mVideoDecoder.getOutputBuffers();
                                            break;
                                        } else if (dequeueOutputBuffer == -2) {
                                            this.mDeocderOutputFormat = this.mVideoDecoder.getOutputFormat();
                                            break;
                                        } else {
                                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                            if ((bufferInfo.flags & 2) != 0) {
                                                this.mVideoDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                                break;
                                            }
                                            if (bufferInfo.size != 0) {
                                                while (byteBuffer.hasRemaining()) {
                                                    channel.write(byteBuffer);
                                                }
                                                MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                                                bufferInfo2.offset = bufferInfo.offset;
                                                bufferInfo2.size = bufferInfo.size;
                                                bufferInfo2.flags = 1;
                                                bufferInfo2.presentationTimeUs = bufferInfo.presentationTimeUs;
                                                BuffeInfoWrapper buffeInfoWrapper = new BuffeInfoWrapper();
                                                buffeInfoWrapper.bufferInfo = bufferInfo2;
                                                buffeInfoWrapper.fileOffset = i3;
                                                arrayList.add(buffeInfoWrapper);
                                                i3 += bufferInfo.size;
                                            }
                                            this.mVideoDecoder.releaseOutputBuffer(dequeueOutputBuffer, bufferInfo.size != 0);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                z = true;
                                            }
                                            i2 = -1;
                                            j2 = 10000;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    try {
                        channel.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return arrayList;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return null;
                } finally {
                    this.mVideoDecoder.stop();
                    this.mVideoDecoder.release();
                }
            } catch (FileNotFoundException e7) {
                e7.printStackTrace();
                return null;
            }
        }
        return (List) invokeLL.objValue;
    }

    private int[] getAllSupportColorFormat() {
        InterceptResult invokeV;
        MediaCodecInfo mediaCodecInfo;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            int i2 = 0;
            while (true) {
                if (i2 >= codecCount) {
                    mediaCodecInfo = null;
                    break;
                }
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
                if (mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= supportedTypes.length) {
                            z = false;
                            break;
                        } else if (supportedTypes[i3].equals("video/avc")) {
                            System.out.println("found");
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
                i2++;
            }
            if (mediaCodecInfo == null || (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc")) == null) {
                return null;
            }
            return capabilitiesForType.colorFormats;
        }
        return (int[]) invokeV.objValue;
    }

    private int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mediaExtractor)) == null) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                if (isVideoFormat(mediaExtractor.getTrackFormat(i2))) {
                    mediaExtractor.selectTrack(i2);
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String getMimeTypeFor(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaFormat)) == null) ? mediaFormat.getString("mime") : (String) invokeL.objValue;
    }

    private int getSupportColorFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int[] allSupportColorFormat = getAllSupportColorFormat();
            if (allSupportColorFormat == null || allSupportColorFormat.length <= 0) {
                return 2135033992;
            }
            for (int i2 = 0; i2 < allSupportColorFormat.length; i2++) {
                switch (allSupportColorFormat[i2]) {
                    case 19:
                    case 20:
                    case 21:
                    case 39:
                    case 2130706688:
                    case 2135033992:
                    case 2141391872:
                        return allSupportColorFormat[i2];
                    default:
                }
            }
            return 2135033992;
        }
        return invokeV.intValue;
    }

    private int[] getUVPos(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65542, this, i2, i3, i4, i5)) == null) {
            if (i2 % 2 != 0) {
                i2 = (i2 / 2) * 2;
            }
            if (i3 % 2 != 0) {
                i3 = (i3 / 2) * 2;
            }
            int i6 = (i2 * i4) / 4;
            int i7 = (i6 % i4) + (i3 / 2);
            int i8 = ((i6 / i4) * 2) + i5;
            return new int[]{(i8 * i4) + i7, ((i8 + 1) * i4) + i7};
        }
        return (int[]) invokeIIII.objValue;
    }

    public static String getVideoOriginalPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? isReverseVideo(str) ? str.substring(0, (str.length() - 12) - 1) : str : (String) invokeL.objValue;
    }

    public static String getVideoReversePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return str + "." + REVERSE_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isReverseVideo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String name = new File(str).getName();
            return name.substring(name.lastIndexOf(".") + 1).equals(REVERSE_SUFFIX);
        }
        return invokeL.booleanValue;
    }

    public static boolean isVideoFormat(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mediaFormat)) == null) ? getMimeTypeFor(mediaFormat).startsWith(com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START) : invokeL.booleanValue;
    }

    public static MediaCodecInfo selectCodec(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public static void setMediaFormatProperty(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65548, null, mediaFormat, mediaFormat2, str, i2) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i2 = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:198:0x041a, code lost:
        r3 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ec, code lost:
        com.baidu.ugc.utils.FileUtils.deleteFile(r5);
        com.baidu.ugc.utils.FileUtils.deleteFile(r28);
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0335 A[Catch: Exception -> 0x0486, IOException -> 0x048a, FileNotFoundException -> 0x048e, TryCatch #15 {FileNotFoundException -> 0x048e, IOException -> 0x048a, Exception -> 0x0486, blocks: (B:55:0x0147, B:57:0x014a, B:64:0x0158, B:65:0x015c, B:69:0x0182, B:83:0x01be, B:85:0x01e8, B:87:0x01ec, B:91:0x01fe, B:93:0x0202, B:94:0x020a, B:175:0x03ae, B:177:0x03b2, B:178:0x03b9, B:183:0x03ca, B:186:0x03d7, B:187:0x03e9, B:189:0x03f1, B:190:0x03f8, B:192:0x03fc, B:193:0x040a, B:196:0x0411, B:98:0x021f, B:100:0x0239, B:104:0x0252, B:160:0x032a, B:162:0x0335, B:164:0x033f, B:166:0x0346, B:168:0x034e, B:169:0x0354, B:101:0x0240, B:103:0x0250, B:170:0x0371, B:68:0x0163, B:60:0x0150), top: B:294:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034e A[Catch: Exception -> 0x0486, IOException -> 0x048a, FileNotFoundException -> 0x048e, TryCatch #15 {FileNotFoundException -> 0x048e, IOException -> 0x048a, Exception -> 0x0486, blocks: (B:55:0x0147, B:57:0x014a, B:64:0x0158, B:65:0x015c, B:69:0x0182, B:83:0x01be, B:85:0x01e8, B:87:0x01ec, B:91:0x01fe, B:93:0x0202, B:94:0x020a, B:175:0x03ae, B:177:0x03b2, B:178:0x03b9, B:183:0x03ca, B:186:0x03d7, B:187:0x03e9, B:189:0x03f1, B:190:0x03f8, B:192:0x03fc, B:193:0x040a, B:196:0x0411, B:98:0x021f, B:100:0x0239, B:104:0x0252, B:160:0x032a, B:162:0x0335, B:164:0x033f, B:166:0x0346, B:168:0x034e, B:169:0x0354, B:101:0x0240, B:103:0x0250, B:170:0x0371, B:68:0x0163, B:60:0x0150), top: B:294:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:327:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0141 A[Catch: Exception -> 0x019e, IOException -> 0x01a1, FileNotFoundException -> 0x01a4, TRY_LEAVE, TryCatch #16 {FileNotFoundException -> 0x01a4, IOException -> 0x01a1, Exception -> 0x019e, blocks: (B:43:0x011b, B:46:0x0127, B:48:0x012f, B:50:0x013b, B:52:0x0141), top: B:292:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0158 A[Catch: Exception -> 0x0486, IOException -> 0x048a, FileNotFoundException -> 0x048e, TryCatch #15 {FileNotFoundException -> 0x048e, IOException -> 0x048a, Exception -> 0x0486, blocks: (B:55:0x0147, B:57:0x014a, B:64:0x0158, B:65:0x015c, B:69:0x0182, B:83:0x01be, B:85:0x01e8, B:87:0x01ec, B:91:0x01fe, B:93:0x0202, B:94:0x020a, B:175:0x03ae, B:177:0x03b2, B:178:0x03b9, B:183:0x03ca, B:186:0x03d7, B:187:0x03e9, B:189:0x03f1, B:190:0x03f8, B:192:0x03fc, B:193:0x040a, B:196:0x0411, B:98:0x021f, B:100:0x0239, B:104:0x0252, B:160:0x032a, B:162:0x0335, B:164:0x033f, B:166:0x0346, B:168:0x034e, B:169:0x0354, B:101:0x0240, B:103:0x0250, B:170:0x0371, B:68:0x0163, B:60:0x0150), top: B:294:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean reverseVideo(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        WeakReference<OnTimeReverseListener> weakReference;
        OnTimeReverseListener onTimeReverseListener;
        WeakReference<OnTimeReverseListener> weakReference2;
        OnTimeReverseListener onTimeReverseListener2;
        WeakReference<OnTimeReverseListener> weakReference3;
        OnTimeReverseListener onTimeReverseListener3;
        long j2;
        String str8;
        long j3;
        int i2;
        int i3;
        int i4;
        int i5;
        ByteBuffer[] byteBufferArr;
        int i6;
        FileChannel fileChannel;
        boolean z2;
        MediaCodec.BufferInfo bufferInfo;
        ByteBuffer[] byteBufferArr2;
        int i7;
        FileChannel fileChannel2;
        List<BuffeInfoWrapper> list;
        int i8;
        OnTimeReverseListener onTimeReverseListener4;
        int[] uVPos;
        byte b2;
        int i9;
        int i10;
        int i11;
        int[] allSupportColorFormat;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, str2, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        if (TextUtils.isEmpty(str) || !FileUtils.checkFile(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str9 = new File(str).getParent() + File.separator + REVERSE_TEMP_SUFFIX + System.currentTimeMillis() + ".temp";
        String str10 = new File(str).getParent() + File.separator + REVERSE_TEMP_SUFFIX + System.currentTimeMillis() + ".temp_reverse";
        List<BuffeInfoWrapper> extractVideoToPath = extractVideoToPath(str, str9);
        if (h.e(extractVideoToPath) || !FileUtils.checkFile(str9)) {
            FileUtils.deleteFile(str9);
            return false;
        }
        try {
            long duration = n.d(str).getDuration() * 1000;
            if (this.mMediaMuxer == null) {
                this.mMediaMuxer = new MediaMuxer(str10, 0);
            }
            MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(getAndSelectVideoTrackIndex(this.mMediaExtractor));
            if (this.mVideoEncoder == null) {
                this.mVideoEncoder = MediaCodec.createByCodecName(selectCodec("video/avc").getName());
                i4 = trackFormat.getInteger("width");
                i5 = trackFormat.getInteger("height");
                try {
                    try {
                        if (i4 % 16 == 0) {
                            if (i5 % 16 == 0) {
                                str3 = "MediaCodec点击倒放失败";
                                str4 = "MediaCodec预倒放失败";
                                i2 = i4;
                                i3 = i5;
                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
                                j2 = currentTimeMillis;
                                if (this.mDeocderOutputFormat == null && this.mDeocderOutputFormat.containsKey("color-format")) {
                                    i11 = this.mDeocderOutputFormat.getInteger("color-format");
                                    j3 = duration;
                                } else {
                                    j3 = duration;
                                    i11 = -1;
                                }
                                allSupportColorFormat = getAllSupportColorFormat();
                                if (allSupportColorFormat != null) {
                                    if (allSupportColorFormat.length > 0) {
                                        str8 = str10;
                                        for (int i12 : allSupportColorFormat) {
                                            try {
                                                if (i12 == i11) {
                                                    z3 = true;
                                                    break;
                                                }
                                            } catch (FileNotFoundException e2) {
                                                e = e2;
                                                str7 = str8;
                                                e.printStackTrace();
                                                c.d(e.toString());
                                                FileUtils.deleteFile(str9);
                                                FileUtils.deleteFile(str7);
                                                weakReference3 = this.mOnTimeReverseListenerWeakReference;
                                                return weakReference3 != null ? false : false;
                                            } catch (IOException e3) {
                                                e = e3;
                                                str6 = str8;
                                                e.printStackTrace();
                                                c.d(e.toString());
                                                FileUtils.deleteFile(str9);
                                                FileUtils.deleteFile(str6);
                                                weakReference2 = this.mOnTimeReverseListenerWeakReference;
                                                return weakReference2 != null ? false : false;
                                            } catch (Exception e4) {
                                                e = e4;
                                                str5 = str8;
                                                e.printStackTrace();
                                                c.d(e.toString());
                                                FileUtils.deleteFile(str9);
                                                FileUtils.deleteFile(str5);
                                                weakReference = this.mOnTimeReverseListenerWeakReference;
                                                return weakReference != null ? false : false;
                                            }
                                        }
                                        z3 = false;
                                        if (!z3) {
                                            i11 = getSupportColorFormat();
                                        }
                                        createVideoFormat.setInteger("color-format", i11);
                                        if (i2 == i4 || i3 != i5) {
                                            createVideoFormat.setInteger("stride", i2);
                                            createVideoFormat.setInteger("slice-height", i3);
                                            createVideoFormat.setInteger("crop-left", 0);
                                            createVideoFormat.setInteger("crop-right", i4 - 1);
                                            createVideoFormat.setInteger("crop-top", 0);
                                            createVideoFormat.setInteger("crop-bottom", i5 - 1);
                                        }
                                        setMediaFormatProperty(trackFormat, createVideoFormat, "bitrate", RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                                        setMediaFormatProperty(trackFormat, createVideoFormat, "frame-rate", 30);
                                        setMediaFormatProperty(trackFormat, createVideoFormat, "i-frame-interval", 5);
                                        this.mVideoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                                    }
                                }
                                str8 = str10;
                                z3 = false;
                                if (!z3) {
                                }
                                createVideoFormat.setInteger("color-format", i11);
                                if (i2 == i4) {
                                }
                                createVideoFormat.setInteger("stride", i2);
                                createVideoFormat.setInteger("slice-height", i3);
                                createVideoFormat.setInteger("crop-left", 0);
                                createVideoFormat.setInteger("crop-right", i4 - 1);
                                createVideoFormat.setInteger("crop-top", 0);
                                createVideoFormat.setInteger("crop-bottom", i5 - 1);
                                setMediaFormatProperty(trackFormat, createVideoFormat, "bitrate", RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                                setMediaFormatProperty(trackFormat, createVideoFormat, "frame-rate", 30);
                                setMediaFormatProperty(trackFormat, createVideoFormat, "i-frame-interval", 5);
                                this.mVideoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                            }
                        }
                        MediaFormat createVideoFormat2 = MediaFormat.createVideoFormat("video/avc", i2, i3);
                        j2 = currentTimeMillis;
                        if (this.mDeocderOutputFormat == null) {
                        }
                        j3 = duration;
                        i11 = -1;
                        allSupportColorFormat = getAllSupportColorFormat();
                        if (allSupportColorFormat != null) {
                        }
                        str8 = str10;
                        z3 = false;
                        if (!z3) {
                        }
                        createVideoFormat2.setInteger("color-format", i11);
                        if (i2 == i4) {
                        }
                        createVideoFormat2.setInteger("stride", i2);
                        createVideoFormat2.setInteger("slice-height", i3);
                        createVideoFormat2.setInteger("crop-left", 0);
                        createVideoFormat2.setInteger("crop-right", i4 - 1);
                        createVideoFormat2.setInteger("crop-top", 0);
                        createVideoFormat2.setInteger("crop-bottom", i5 - 1);
                        setMediaFormatProperty(trackFormat, createVideoFormat2, "bitrate", RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                        setMediaFormatProperty(trackFormat, createVideoFormat2, "frame-rate", 30);
                        setMediaFormatProperty(trackFormat, createVideoFormat2, "i-frame-interval", 5);
                        this.mVideoEncoder.configure(createVideoFormat2, (Surface) null, (MediaCrypto) null, 1);
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        str7 = str10;
                        e.printStackTrace();
                        c.d(e.toString());
                        FileUtils.deleteFile(str9);
                        FileUtils.deleteFile(str7);
                        weakReference3 = this.mOnTimeReverseListenerWeakReference;
                        if (weakReference3 != null && (onTimeReverseListener3 = weakReference3.get()) != null) {
                            onTimeReverseListener3.onTimeReverseError(new Exception((z ? str3 : str4) + e.getMessage()));
                            return false;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        str6 = str10;
                        e.printStackTrace();
                        c.d(e.toString());
                        FileUtils.deleteFile(str9);
                        FileUtils.deleteFile(str6);
                        weakReference2 = this.mOnTimeReverseListenerWeakReference;
                        if (weakReference2 != null && (onTimeReverseListener2 = weakReference2.get()) != null) {
                            onTimeReverseListener2.onTimeReverseError(new Exception((z ? str3 : str4) + e.getMessage()));
                            return false;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str5 = str10;
                        e.printStackTrace();
                        c.d(e.toString());
                        FileUtils.deleteFile(str9);
                        FileUtils.deleteFile(str5);
                        weakReference = this.mOnTimeReverseListenerWeakReference;
                        if (weakReference != null && (onTimeReverseListener = weakReference.get()) != null) {
                            onTimeReverseListener.onTimeReverseError(new Exception((z ? str3 : str4) + e.getMessage()));
                            return false;
                        }
                    }
                    if (this.mDeocderOutputFormat != null) {
                        int integer = this.mDeocderOutputFormat.getInteger("stride");
                        i10 = this.mDeocderOutputFormat.getInteger("slice-height");
                        i2 = integer;
                    } else {
                        i2 = i4;
                        i10 = i5;
                    }
                    if (i2 == 0 || i2 % 16 != 0) {
                        i2 = (16 - (i4 % 16)) + i4;
                    }
                    if (i10 == 0 || i10 % 16 != 0) {
                        i10 = i5 + (16 - (i5 % 16));
                    }
                    str4 = "MediaCodec预倒放失败";
                    i3 = i10;
                } catch (FileNotFoundException e8) {
                    e = e8;
                    str4 = "MediaCodec预倒放失败";
                    str7 = str10;
                    e.printStackTrace();
                    c.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str7);
                    weakReference3 = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference3 != null) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    str4 = "MediaCodec预倒放失败";
                    str6 = str10;
                    e.printStackTrace();
                    c.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str6);
                    weakReference2 = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference2 != null) {
                    }
                } catch (Exception e10) {
                    e = e10;
                    str4 = "MediaCodec预倒放失败";
                    str5 = str10;
                    e.printStackTrace();
                    c.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str5);
                    weakReference = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference != null) {
                    }
                }
                str3 = "MediaCodec点击倒放失败";
            } else {
                str3 = "MediaCodec点击倒放失败";
                str4 = "MediaCodec预倒放失败";
                j2 = currentTimeMillis;
                str8 = str10;
                j3 = duration;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            this.mVideoEncoder.start();
            int size = extractVideoToPath.size() - 1;
            ByteBuffer[] inputBuffers = this.mVideoEncoder.getInputBuffers();
            ByteBuffer[] outputBuffers = this.mVideoEncoder.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            FileChannel channel = new FileInputStream(str9).getChannel();
            boolean z4 = false;
            boolean z5 = false;
            int i13 = 0;
            while (true) {
                if (z4) {
                    break;
                } else if (this.mIsCancel) {
                    break;
                } else {
                    ByteBuffer[] byteBufferArr3 = outputBuffers;
                    MediaCodec.BufferInfo bufferInfo3 = bufferInfo2;
                    boolean z6 = z5;
                    int i14 = size;
                    while (true) {
                        if (z6) {
                            break;
                        } else if (this.mIsCancel) {
                            FileUtils.deleteFile(str9);
                            FileUtils.deleteFile(str8);
                            break;
                        } else {
                            z2 = z4;
                            int dequeueInputBuffer = this.mVideoEncoder.dequeueInputBuffer(10000L);
                            if (dequeueInputBuffer == -1) {
                                byteBufferArr = inputBuffers;
                                i6 = i2;
                                fileChannel = channel;
                                break;
                            }
                            if (i14 >= 0) {
                                BuffeInfoWrapper buffeInfoWrapper = extractVideoToPath.get(i14);
                                int i15 = buffeInfoWrapper.fileOffset;
                                MediaCodec.BufferInfo bufferInfo4 = buffeInfoWrapper.bufferInfo;
                                int i16 = i5;
                                boolean z7 = z6;
                                if (i14 == extractVideoToPath.size() - 1) {
                                    bufferInfo4.presentationTimeUs = 0L;
                                    list = extractVideoToPath;
                                    i8 = i14;
                                } else {
                                    long j4 = j3 - bufferInfo4.presentationTimeUs;
                                    bufferInfo4.presentationTimeUs = j4;
                                    list = extractVideoToPath;
                                    i8 = i14;
                                    if (j4 < 0) {
                                        bufferInfo4.presentationTimeUs = 0L;
                                    }
                                }
                                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                channel.position(i15);
                                channel.read(byteBuffer);
                                if (i2 != i4) {
                                    int i17 = 0;
                                    while (i17 < i3) {
                                        int i18 = i17 * i2;
                                        int i19 = i4 - 1;
                                        try {
                                            uVPos = getUVPos(i17, i19, i2, i3);
                                            b2 = byteBuffer.get(i19 + i18);
                                            byteBufferArr2 = inputBuffers;
                                        } catch (Exception e11) {
                                            e = e11;
                                            byteBufferArr2 = inputBuffers;
                                        }
                                        try {
                                            byte b3 = byteBuffer.get(uVPos[0]);
                                            byte b4 = byteBuffer.get(uVPos[1]);
                                            int i20 = i4;
                                            while (i20 < i2) {
                                                fileChannel2 = channel;
                                                try {
                                                    byteBuffer.put(i18 + i20, b2);
                                                    if (i17 % 2 == 0 && i20 % 2 == 0) {
                                                        int[] uVPos2 = getUVPos(i17, i20, i2, i3);
                                                        i9 = i18;
                                                        byteBuffer.put(uVPos2[0], b3);
                                                        byteBuffer.put(uVPos2[1], b4);
                                                    } else {
                                                        i9 = i18;
                                                    }
                                                    i20++;
                                                    i18 = i9;
                                                    channel = fileChannel2;
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    i5 = i16;
                                                    i7 = i2;
                                                    c.d(e.toString());
                                                    if (this.mOnTimeReverseListenerWeakReference != null && (onTimeReverseListener4 = this.mOnTimeReverseListenerWeakReference.get()) != null) {
                                                        onTimeReverseListener4.onTimeReverseError(e);
                                                    }
                                                    if (bufferInfo4.size > byteBuffer.position()) {
                                                    }
                                                    this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                    i14 = i8 - 1;
                                                    z6 = z7;
                                                    z4 = z2;
                                                    i2 = i7;
                                                    extractVideoToPath = list;
                                                    inputBuffers = byteBufferArr2;
                                                    channel = fileChannel2;
                                                }
                                            }
                                            i17++;
                                            inputBuffers = byteBufferArr2;
                                        } catch (Exception e13) {
                                            e = e13;
                                            fileChannel2 = channel;
                                            i5 = i16;
                                            i7 = i2;
                                            c.d(e.toString());
                                            if (this.mOnTimeReverseListenerWeakReference != null) {
                                                onTimeReverseListener4.onTimeReverseError(e);
                                            }
                                            if (bufferInfo4.size > byteBuffer.position()) {
                                            }
                                            this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                            i14 = i8 - 1;
                                            z6 = z7;
                                            z4 = z2;
                                            i2 = i7;
                                            extractVideoToPath = list;
                                            inputBuffers = byteBufferArr2;
                                            channel = fileChannel2;
                                        }
                                    }
                                }
                                byteBufferArr2 = inputBuffers;
                                fileChannel2 = channel;
                                i5 = i16;
                                if (i3 != i5) {
                                    int i21 = 0;
                                    while (i21 < i3) {
                                        int i22 = i5 - 1;
                                        int i23 = i22 * i2;
                                        try {
                                            int[] uVPos3 = getUVPos(i22, i21, i2, i3);
                                            byte b5 = byteBuffer.get(i23 + i21);
                                            byte b6 = byteBuffer.get(uVPos3[0]);
                                            byte b7 = byteBuffer.get(uVPos3[1]);
                                            int i24 = i5;
                                            while (i24 < i3) {
                                                int i25 = i23;
                                                byteBuffer.put(i23 + i2 + i21, b5);
                                                if (i24 % 2 == 0 && i21 % 2 == 0) {
                                                    int[] uVPos4 = getUVPos(i24, i21, i2, i3);
                                                    i7 = i2;
                                                    try {
                                                        byteBuffer.put(uVPos4[0], b6);
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        c.d(e.toString());
                                                        if (this.mOnTimeReverseListenerWeakReference != null) {
                                                        }
                                                        if (bufferInfo4.size > byteBuffer.position()) {
                                                        }
                                                        this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                        i14 = i8 - 1;
                                                        z6 = z7;
                                                        z4 = z2;
                                                        i2 = i7;
                                                        extractVideoToPath = list;
                                                        inputBuffers = byteBufferArr2;
                                                        channel = fileChannel2;
                                                    }
                                                    try {
                                                        byteBuffer.put(uVPos4[1], b7);
                                                    } catch (Exception e15) {
                                                        e = e15;
                                                        c.d(e.toString());
                                                        if (this.mOnTimeReverseListenerWeakReference != null) {
                                                        }
                                                        if (bufferInfo4.size > byteBuffer.position()) {
                                                        }
                                                        this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                        i14 = i8 - 1;
                                                        z6 = z7;
                                                        z4 = z2;
                                                        i2 = i7;
                                                        extractVideoToPath = list;
                                                        inputBuffers = byteBufferArr2;
                                                        channel = fileChannel2;
                                                    }
                                                } else {
                                                    i7 = i2;
                                                }
                                                i24++;
                                                i23 = i25;
                                                i2 = i7;
                                            }
                                            i21++;
                                            i2 = i2;
                                        } catch (Exception e16) {
                                            e = e16;
                                            i7 = i2;
                                            c.d(e.toString());
                                            if (this.mOnTimeReverseListenerWeakReference != null) {
                                            }
                                            if (bufferInfo4.size > byteBuffer.position()) {
                                            }
                                            this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                            i14 = i8 - 1;
                                            z6 = z7;
                                            z4 = z2;
                                            i2 = i7;
                                            extractVideoToPath = list;
                                            inputBuffers = byteBufferArr2;
                                            channel = fileChannel2;
                                        }
                                    }
                                }
                                i7 = i2;
                                if (bufferInfo4.size > byteBuffer.position()) {
                                    bufferInfo4.size = byteBuffer.position();
                                }
                                this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                i14 = i8 - 1;
                                z6 = z7;
                            } else {
                                byteBufferArr2 = inputBuffers;
                                i7 = i2;
                                fileChannel2 = channel;
                                list = extractVideoToPath;
                                this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, j3, 4);
                                i14 = i14;
                                z6 = true;
                            }
                            z4 = z2;
                            i2 = i7;
                            extractVideoToPath = list;
                            inputBuffers = byteBufferArr2;
                            channel = fileChannel2;
                        }
                    }
                    byteBufferArr = inputBuffers;
                    i6 = i2;
                    fileChannel = channel;
                    z2 = z4;
                    List<BuffeInfoWrapper> list2 = extractVideoToPath;
                    int i26 = i14;
                    boolean z8 = z6;
                    z4 = z2;
                    while (true) {
                        if (z4) {
                            break;
                        } else if (this.mIsCancel) {
                            FileUtils.deleteFile(str9);
                            FileUtils.deleteFile(str8);
                            break;
                        } else {
                            bufferInfo = bufferInfo3;
                            int dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(bufferInfo, 10000L);
                            if (dequeueOutputBuffer == -1) {
                                break;
                            } else if (dequeueOutputBuffer == -3) {
                                outputBuffers = this.mVideoEncoder.getOutputBuffers();
                                bufferInfo2 = bufferInfo;
                                z5 = z8;
                                break;
                            } else if (dequeueOutputBuffer == -2) {
                                i13 = this.mMediaMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                                this.mMediaMuxer.start();
                                break;
                            } else {
                                ByteBuffer byteBuffer2 = byteBufferArr3[dequeueOutputBuffer];
                                if ((bufferInfo.flags & 2) != 0) {
                                    this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    break;
                                }
                                if (bufferInfo.size != 0) {
                                    byteBuffer2.position(0);
                                    byteBuffer2.limit(bufferInfo.size);
                                    this.mMediaMuxer.writeSampleData(i13, byteBuffer2, bufferInfo);
                                }
                                if ((bufferInfo.flags & 4) != 0) {
                                    z4 = true;
                                }
                                this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                bufferInfo3 = bufferInfo;
                            }
                        }
                    }
                    bufferInfo2 = bufferInfo;
                    z5 = z8;
                    outputBuffers = byteBufferArr3;
                    i2 = i6;
                    extractVideoToPath = list2;
                    size = i26;
                    inputBuffers = byteBufferArr;
                    channel = fileChannel;
                }
            }
            try {
                this.mMediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (Exception e17) {
                c.g(e17);
            }
            try {
                this.mMediaExtractor.release();
            } catch (Exception e18) {
                c.g(e18);
            }
            try {
                this.mVideoEncoder.stop();
                this.mVideoEncoder.release();
            } catch (Exception e19) {
                c.g(e19);
            }
            c.d("finish:" + (System.currentTimeMillis() - j2));
            FileUtils.deleteFile(str9);
            new File(str8).renameTo(new File(str2));
            return true;
        } catch (FileNotFoundException e20) {
            e = e20;
            str3 = "MediaCodec点击倒放失败";
        } catch (IOException e21) {
            e = e21;
            str3 = "MediaCodec点击倒放失败";
        } catch (Exception e22) {
            e = e22;
            str3 = "MediaCodec点击倒放失败";
        }
    }

    public void setCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mIsCancel = z;
        }
    }

    public void setTimeReverseListener(WeakReference<OnTimeReverseListener> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, weakReference) == null) {
            this.mOnTimeReverseListenerWeakReference = weakReference;
        }
    }
}

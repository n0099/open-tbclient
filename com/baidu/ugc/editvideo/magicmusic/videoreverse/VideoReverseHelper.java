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
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.tieba.akb;
import com.baidu.tieba.fkb;
import com.baidu.tieba.lkb;
import com.baidu.ugc.editvideo.listener.OnTimeReverseListener;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
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
/* loaded from: classes9.dex */
public class VideoReverseHelper {
    public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    public static final String REVERSE_SUFFIX = "mini_reverse";
    public static final String REVERSE_TEMP_SUFFIX = "temp_mini_reverse_file_";
    public static final int TIMEOUT_USEC = 10000;
    public MediaFormat mDeocderOutputFormat;
    public boolean mIsCancel = false;
    public MediaExtractor mMediaExtractor;
    public MediaMuxer mMediaMuxer;
    public WeakReference<OnTimeReverseListener> mOnTimeReverseListenerWeakReference;
    public MediaCodec mVideoDecoder;
    public MediaCodec mVideoEncoder;

    /* loaded from: classes9.dex */
    public static class BuffeInfoWrapper {
        public MediaCodec.BufferInfo bufferInfo;
        public int fileOffset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
        com.baidu.ugc.utils.FileUtils.deleteFile(r25);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<BuffeInfoWrapper> extractVideoToPath(String str, String str2) {
        int i;
        long j;
        if (this.mMediaExtractor == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            try {
                mediaExtractor.setDataSource(str);
            } catch (IOException e) {
                e.printStackTrace();
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
            } catch (IOException e2) {
                e2.printStackTrace();
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
                } catch (Exception e3) {
                    e3.printStackTrace();
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
                int i2 = 0;
                while (true) {
                    if (z) {
                        break;
                    } else if (this.mIsCancel) {
                        break;
                    } else {
                        while (true) {
                            i = -1;
                            j = 10000;
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
                                int dequeueOutputBuffer = this.mVideoDecoder.dequeueOutputBuffer(bufferInfo, j);
                                if (dequeueOutputBuffer != i) {
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
                                            buffeInfoWrapper.fileOffset = i2;
                                            arrayList.add(buffeInfoWrapper);
                                            i2 += bufferInfo.size;
                                        }
                                        this.mVideoDecoder.releaseOutputBuffer(dequeueOutputBuffer, bufferInfo.size != 0);
                                        if ((bufferInfo.flags & 4) != 0) {
                                            z = true;
                                        }
                                        i = -1;
                                        j = 10000;
                                    }
                                }
                            }
                        }
                    }
                }
                try {
                    channel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return arrayList;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            } finally {
                this.mVideoDecoder.stop();
                this.mVideoDecoder.release();
            }
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private int[] getAllSupportColorFormat() {
        MediaCodecInfo mediaCodecInfo;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z;
        int codecCount = MediaCodecList.getCodecCount();
        int i = 0;
        while (true) {
            if (i >= codecCount) {
                mediaCodecInfo = null;
                break;
            }
            mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 >= supportedTypes.length) {
                        z = false;
                        break;
                    } else if (supportedTypes[i2].equals("video/avc")) {
                        System.out.println("found");
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    break;
                }
            }
            i++;
        }
        if (mediaCodecInfo == null || (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc")) == null) {
            return null;
        }
        return capabilitiesForType.colorFormats;
    }

    private int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (isVideoFormat(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    public static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
    }

    private int getSupportColorFormat() {
        int[] allSupportColorFormat = getAllSupportColorFormat();
        if (allSupportColorFormat == null || allSupportColorFormat.length <= 0) {
            return 2135033992;
        }
        for (int i = 0; i < allSupportColorFormat.length; i++) {
            switch (allSupportColorFormat[i]) {
                case 19:
                case 20:
                case 21:
                case 39:
                case 2130706688:
                case 2135033992:
                case 2141391872:
                    return allSupportColorFormat[i];
                default:
            }
        }
        return 2135033992;
    }

    private int[] getUVPos(int i, int i2, int i3, int i4) {
        if (i % 2 != 0) {
            i = (i / 2) * 2;
        }
        if (i2 % 2 != 0) {
            i2 = (i2 / 2) * 2;
        }
        int i5 = (i * i3) / 4;
        int i6 = (i5 % i3) + (i2 / 2);
        int i7 = ((i5 / i3) * 2) + i4;
        return new int[]{(i7 * i3) + i6, ((i7 + 1) * i3) + i6};
    }

    public static String getVideoOriginalPath(String str) {
        return isReverseVideo(str) ? str.substring(0, (str.length() - 12) - 1) : str;
    }

    public static String getVideoReversePath(String str) {
        return str + "." + REVERSE_SUFFIX;
    }

    public static boolean isReverseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String name = new File(str).getName();
        return name.substring(name.lastIndexOf(".") + 1).equals(REVERSE_SUFFIX);
    }

    public static boolean isVideoFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith(com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START);
    }

    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
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

    public static void setMediaFormatProperty(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i) {
        if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
            i = mediaFormat.getInteger(str);
        }
        if (mediaFormat2 != null) {
            mediaFormat2.setInteger(str, i);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:17|18|(15:(2:20|(14:22|23|24|25|(1:259)(1:29)|30|(2:32|(8:34|(4:38|(2:41|42)(1:40)|35|36)|216|217|(1:44)|45|(1:215)|48))|258|217|(0)|45|(0)|215|48))|23|24|25|(1:27)|259|30|(0)|258|217|(0)|45|(0)|215|48)|270|271|272|(1:274)(1:286)|(1:285)|(2:282|283)|281) */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x041b, code lost:
        r3 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0497, code lost:
        r23 = "MediaCodec预倒放失败";
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x04b6, code lost:
        if (r48 != false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x04b8, code lost:
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04bb, code lost:
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04bd, code lost:
        r2.onTimeReverseError(new java.lang.Exception(r3 + r0.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04d8, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04dd, code lost:
        r23 = "MediaCodec预倒放失败";
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04fc, code lost:
        if (r48 != false) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04fe, code lost:
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0501, code lost:
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0503, code lost:
        r2.onTimeReverseError(new java.lang.Exception(r3 + r0.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x051e, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0523, code lost:
        r23 = "MediaCodec预倒放失败";
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0542, code lost:
        if (r48 != false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0544, code lost:
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0547, code lost:
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0549, code lost:
        r2.onTimeReverseError(new java.lang.Exception(r3 + r0.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0564, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01ab, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ae, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ed, code lost:
        com.baidu.ugc.utils.FileUtils.deleteFile(r5);
        com.baidu.ugc.utils.FileUtils.deleteFile(r28);
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0336 A[Catch: Exception -> 0x0487, IOException -> 0x048b, FileNotFoundException -> 0x048f, TryCatch #15 {FileNotFoundException -> 0x048f, IOException -> 0x048b, Exception -> 0x0487, blocks: (B:53:0x0148, B:55:0x014b, B:62:0x0159, B:63:0x015d, B:67:0x0183, B:81:0x01bf, B:83:0x01e9, B:85:0x01ed, B:89:0x01ff, B:91:0x0203, B:92:0x020b, B:173:0x03af, B:175:0x03b3, B:176:0x03ba, B:181:0x03cb, B:184:0x03d8, B:185:0x03ea, B:187:0x03f2, B:188:0x03f9, B:190:0x03fd, B:191:0x040b, B:194:0x0412, B:96:0x0220, B:98:0x023a, B:102:0x0253, B:158:0x032b, B:160:0x0336, B:162:0x0340, B:164:0x0347, B:166:0x034f, B:167:0x0355, B:99:0x0241, B:101:0x0251, B:168:0x0372, B:66:0x0164, B:58:0x0151), top: B:288:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x034f A[Catch: Exception -> 0x0487, IOException -> 0x048b, FileNotFoundException -> 0x048f, TryCatch #15 {FileNotFoundException -> 0x048f, IOException -> 0x048b, Exception -> 0x0487, blocks: (B:53:0x0148, B:55:0x014b, B:62:0x0159, B:63:0x015d, B:67:0x0183, B:81:0x01bf, B:83:0x01e9, B:85:0x01ed, B:89:0x01ff, B:91:0x0203, B:92:0x020b, B:173:0x03af, B:175:0x03b3, B:176:0x03ba, B:181:0x03cb, B:184:0x03d8, B:185:0x03ea, B:187:0x03f2, B:188:0x03f9, B:190:0x03fd, B:191:0x040b, B:194:0x0412, B:96:0x0220, B:98:0x023a, B:102:0x0253, B:158:0x032b, B:160:0x0336, B:162:0x0340, B:164:0x0347, B:166:0x034f, B:167:0x0355, B:99:0x0241, B:101:0x0251, B:168:0x0372, B:66:0x0164, B:58:0x0151), top: B:288:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:317:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[Catch: Exception -> 0x019f, IOException -> 0x01a2, FileNotFoundException -> 0x01a5, TRY_LEAVE, TryCatch #14 {FileNotFoundException -> 0x01a5, IOException -> 0x01a2, Exception -> 0x019f, blocks: (B:41:0x011c, B:44:0x0128, B:46:0x0130, B:48:0x013c, B:50:0x0142), top: B:290:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159 A[Catch: Exception -> 0x0487, IOException -> 0x048b, FileNotFoundException -> 0x048f, TryCatch #15 {FileNotFoundException -> 0x048f, IOException -> 0x048b, Exception -> 0x0487, blocks: (B:53:0x0148, B:55:0x014b, B:62:0x0159, B:63:0x015d, B:67:0x0183, B:81:0x01bf, B:83:0x01e9, B:85:0x01ed, B:89:0x01ff, B:91:0x0203, B:92:0x020b, B:173:0x03af, B:175:0x03b3, B:176:0x03ba, B:181:0x03cb, B:184:0x03d8, B:185:0x03ea, B:187:0x03f2, B:188:0x03f9, B:190:0x03fd, B:191:0x040b, B:194:0x0412, B:96:0x0220, B:98:0x023a, B:102:0x0253, B:158:0x032b, B:160:0x0336, B:162:0x0340, B:164:0x0347, B:166:0x034f, B:167:0x0355, B:99:0x0241, B:101:0x0251, B:168:0x0372, B:66:0x0164, B:58:0x0151), top: B:288:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0162 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean reverseVideo(String str, String str2, boolean z) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j;
        String str8;
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        ByteBuffer[] byteBufferArr;
        int i5;
        FileChannel fileChannel;
        boolean z2;
        MediaCodec.BufferInfo bufferInfo;
        ByteBuffer[] byteBufferArr2;
        int i6;
        FileChannel fileChannel2;
        List<BuffeInfoWrapper> list;
        int i7;
        OnTimeReverseListener onTimeReverseListener;
        int[] uVPos;
        byte b;
        int i8;
        int i9;
        int i10;
        int[] allSupportColorFormat;
        boolean z3;
        if (TextUtils.isEmpty(str) || !FileUtils.checkFile(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str9 = new File(str).getParent() + File.separator + REVERSE_TEMP_SUFFIX + System.currentTimeMillis() + ".temp";
        String str10 = new File(str).getParent() + File.separator + REVERSE_TEMP_SUFFIX + System.currentTimeMillis() + ".temp_reverse";
        List<BuffeInfoWrapper> extractVideoToPath = extractVideoToPath(str, str9);
        if (fkb.e(extractVideoToPath) || !FileUtils.checkFile(str9)) {
            FileUtils.deleteFile(str9);
            return false;
        }
        try {
            long duration = lkb.d(str).getDuration() * 1000;
            if (this.mMediaMuxer == null) {
                this.mMediaMuxer = new MediaMuxer(str10, 0);
            }
            MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(getAndSelectVideoTrackIndex(this.mMediaExtractor));
            if (this.mVideoEncoder == null) {
                this.mVideoEncoder = MediaCodec.createByCodecName(selectCodec("video/avc").getName());
                i3 = trackFormat.getInteger("width");
                i4 = trackFormat.getInteger("height");
                try {
                    if (i3 % 16 == 0) {
                        if (i4 % 16 == 0) {
                            str3 = "MediaCodec点击倒放失败";
                            str4 = "MediaCodec预倒放失败";
                            i = i3;
                            i2 = i4;
                            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
                            j = currentTimeMillis;
                            if (this.mDeocderOutputFormat == null && this.mDeocderOutputFormat.containsKey("color-format")) {
                                i10 = this.mDeocderOutputFormat.getInteger("color-format");
                                j2 = duration;
                            } else {
                                j2 = duration;
                                i10 = -1;
                            }
                            allSupportColorFormat = getAllSupportColorFormat();
                            if (allSupportColorFormat != null) {
                                if (allSupportColorFormat.length > 0) {
                                    str8 = str10;
                                    for (int i11 : allSupportColorFormat) {
                                        try {
                                            if (i11 == i10) {
                                                z3 = true;
                                                break;
                                            }
                                        } catch (FileNotFoundException e) {
                                            e = e;
                                            str7 = str8;
                                            e.printStackTrace();
                                            akb.d(e.toString());
                                            FileUtils.deleteFile(str9);
                                            FileUtils.deleteFile(str7);
                                            WeakReference<OnTimeReverseListener> weakReference = this.mOnTimeReverseListenerWeakReference;
                                            return weakReference == null ? false : false;
                                        } catch (IOException e2) {
                                            e = e2;
                                            str6 = str8;
                                            e.printStackTrace();
                                            akb.d(e.toString());
                                            FileUtils.deleteFile(str9);
                                            FileUtils.deleteFile(str6);
                                            WeakReference<OnTimeReverseListener> weakReference2 = this.mOnTimeReverseListenerWeakReference;
                                            return weakReference2 == null ? false : false;
                                        } catch (Exception e3) {
                                            e = e3;
                                            str5 = str8;
                                            e.printStackTrace();
                                            akb.d(e.toString());
                                            FileUtils.deleteFile(str9);
                                            FileUtils.deleteFile(str5);
                                            WeakReference<OnTimeReverseListener> weakReference3 = this.mOnTimeReverseListenerWeakReference;
                                            return weakReference3 == null ? false : false;
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                        i10 = getSupportColorFormat();
                                    }
                                    createVideoFormat.setInteger("color-format", i10);
                                    if (i == i3 || i2 != i4) {
                                        createVideoFormat.setInteger("stride", i);
                                        createVideoFormat.setInteger("slice-height", i2);
                                        createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_LEFT, 0);
                                        createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_RIGHT, i3 - 1);
                                        createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_TOP, 0);
                                        createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_BOTTOM, i4 - 1);
                                    }
                                    setMediaFormatProperty(trackFormat, createVideoFormat, MediaInfo.DPM_KEY_BITRATE, RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                                    setMediaFormatProperty(trackFormat, createVideoFormat, "frame-rate", 30);
                                    setMediaFormatProperty(trackFormat, createVideoFormat, "i-frame-interval", 5);
                                    this.mVideoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                                }
                            }
                            str8 = str10;
                            z3 = false;
                            if (!z3) {
                            }
                            createVideoFormat.setInteger("color-format", i10);
                            if (i == i3) {
                            }
                            createVideoFormat.setInteger("stride", i);
                            createVideoFormat.setInteger("slice-height", i2);
                            createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_LEFT, 0);
                            createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_RIGHT, i3 - 1);
                            createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_TOP, 0);
                            createVideoFormat.setInteger(MediaCodecVideoRenderer.KEY_CROP_BOTTOM, i4 - 1);
                            setMediaFormatProperty(trackFormat, createVideoFormat, MediaInfo.DPM_KEY_BITRATE, RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                            setMediaFormatProperty(trackFormat, createVideoFormat, "frame-rate", 30);
                            setMediaFormatProperty(trackFormat, createVideoFormat, "i-frame-interval", 5);
                            this.mVideoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        }
                    }
                    MediaFormat createVideoFormat2 = MediaFormat.createVideoFormat("video/avc", i, i2);
                    j = currentTimeMillis;
                    if (this.mDeocderOutputFormat == null) {
                    }
                    j2 = duration;
                    i10 = -1;
                    allSupportColorFormat = getAllSupportColorFormat();
                    if (allSupportColorFormat != null) {
                    }
                    str8 = str10;
                    z3 = false;
                    if (!z3) {
                    }
                    createVideoFormat2.setInteger("color-format", i10);
                    if (i == i3) {
                    }
                    createVideoFormat2.setInteger("stride", i);
                    createVideoFormat2.setInteger("slice-height", i2);
                    createVideoFormat2.setInteger(MediaCodecVideoRenderer.KEY_CROP_LEFT, 0);
                    createVideoFormat2.setInteger(MediaCodecVideoRenderer.KEY_CROP_RIGHT, i3 - 1);
                    createVideoFormat2.setInteger(MediaCodecVideoRenderer.KEY_CROP_TOP, 0);
                    createVideoFormat2.setInteger(MediaCodecVideoRenderer.KEY_CROP_BOTTOM, i4 - 1);
                    setMediaFormatProperty(trackFormat, createVideoFormat2, MediaInfo.DPM_KEY_BITRATE, RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                    setMediaFormatProperty(trackFormat, createVideoFormat2, "frame-rate", 30);
                    setMediaFormatProperty(trackFormat, createVideoFormat2, "i-frame-interval", 5);
                    this.mVideoEncoder.configure(createVideoFormat2, (Surface) null, (MediaCrypto) null, 1);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    str7 = str10;
                    e.printStackTrace();
                    akb.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str7);
                    WeakReference<OnTimeReverseListener> weakReference4 = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference4 == null) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    str6 = str10;
                    e.printStackTrace();
                    akb.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str6);
                    WeakReference<OnTimeReverseListener> weakReference22 = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference22 == null) {
                    }
                } catch (Exception e6) {
                    e = e6;
                    str5 = str10;
                    e.printStackTrace();
                    akb.d(e.toString());
                    FileUtils.deleteFile(str9);
                    FileUtils.deleteFile(str5);
                    WeakReference<OnTimeReverseListener> weakReference32 = this.mOnTimeReverseListenerWeakReference;
                    if (weakReference32 == null) {
                    }
                }
                str3 = "MediaCodec点击倒放失败";
                if (this.mDeocderOutputFormat != null) {
                    int integer = this.mDeocderOutputFormat.getInteger("stride");
                    i9 = this.mDeocderOutputFormat.getInteger("slice-height");
                    i = integer;
                } else {
                    i = i3;
                    i9 = i4;
                }
                if (i == 0 || i % 16 != 0) {
                    i = (16 - (i3 % 16)) + i3;
                }
                if (i9 == 0 || i9 % 16 != 0) {
                    i9 = i4 + (16 - (i4 % 16));
                }
                str4 = "MediaCodec预倒放失败";
                i2 = i9;
            } else {
                str3 = "MediaCodec点击倒放失败";
                str4 = "MediaCodec预倒放失败";
                j = currentTimeMillis;
                str8 = str10;
                j2 = duration;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            this.mVideoEncoder.start();
            int size = extractVideoToPath.size() - 1;
            ByteBuffer[] inputBuffers = this.mVideoEncoder.getInputBuffers();
            ByteBuffer[] outputBuffers = this.mVideoEncoder.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            FileChannel channel = new FileInputStream(str9).getChannel();
            boolean z4 = false;
            boolean z5 = false;
            int i12 = 0;
            while (true) {
                if (z4) {
                    break;
                } else if (this.mIsCancel) {
                    break;
                } else {
                    ByteBuffer[] byteBufferArr3 = outputBuffers;
                    MediaCodec.BufferInfo bufferInfo3 = bufferInfo2;
                    boolean z6 = z5;
                    int i13 = size;
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
                                i5 = i;
                                fileChannel = channel;
                                break;
                            }
                            if (i13 >= 0) {
                                BuffeInfoWrapper buffeInfoWrapper = extractVideoToPath.get(i13);
                                int i14 = buffeInfoWrapper.fileOffset;
                                MediaCodec.BufferInfo bufferInfo4 = buffeInfoWrapper.bufferInfo;
                                int i15 = i4;
                                boolean z7 = z6;
                                if (i13 == extractVideoToPath.size() - 1) {
                                    bufferInfo4.presentationTimeUs = 0L;
                                    list = extractVideoToPath;
                                    i7 = i13;
                                } else {
                                    long j3 = j2 - bufferInfo4.presentationTimeUs;
                                    bufferInfo4.presentationTimeUs = j3;
                                    list = extractVideoToPath;
                                    i7 = i13;
                                    if (j3 < 0) {
                                        bufferInfo4.presentationTimeUs = 0L;
                                    }
                                }
                                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                channel.position(i14);
                                channel.read(byteBuffer);
                                if (i != i3) {
                                    int i16 = 0;
                                    while (i16 < i2) {
                                        int i17 = i16 * i;
                                        int i18 = i3 - 1;
                                        try {
                                            uVPos = getUVPos(i16, i18, i, i2);
                                            b = byteBuffer.get(i18 + i17);
                                            byteBufferArr2 = inputBuffers;
                                        } catch (Exception e7) {
                                            e = e7;
                                            byteBufferArr2 = inputBuffers;
                                        }
                                        try {
                                            byte b2 = byteBuffer.get(uVPos[0]);
                                            byte b3 = byteBuffer.get(uVPos[1]);
                                            int i19 = i3;
                                            while (i19 < i) {
                                                fileChannel2 = channel;
                                                try {
                                                    byteBuffer.put(i17 + i19, b);
                                                    if (i16 % 2 == 0 && i19 % 2 == 0) {
                                                        int[] uVPos2 = getUVPos(i16, i19, i, i2);
                                                        i8 = i17;
                                                        byteBuffer.put(uVPos2[0], b2);
                                                        byteBuffer.put(uVPos2[1], b3);
                                                    } else {
                                                        i8 = i17;
                                                    }
                                                    i19++;
                                                    i17 = i8;
                                                    channel = fileChannel2;
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    i4 = i15;
                                                    i6 = i;
                                                    akb.d(e.toString());
                                                    if (this.mOnTimeReverseListenerWeakReference != null && (onTimeReverseListener = this.mOnTimeReverseListenerWeakReference.get()) != null) {
                                                        onTimeReverseListener.onTimeReverseError(e);
                                                    }
                                                    if (bufferInfo4.size > byteBuffer.position()) {
                                                    }
                                                    this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                    i13 = i7 - 1;
                                                    z6 = z7;
                                                    z4 = z2;
                                                    i = i6;
                                                    extractVideoToPath = list;
                                                    inputBuffers = byteBufferArr2;
                                                    channel = fileChannel2;
                                                }
                                            }
                                            i16++;
                                            inputBuffers = byteBufferArr2;
                                        } catch (Exception e9) {
                                            e = e9;
                                            fileChannel2 = channel;
                                            i4 = i15;
                                            i6 = i;
                                            akb.d(e.toString());
                                            if (this.mOnTimeReverseListenerWeakReference != null) {
                                            }
                                            if (bufferInfo4.size > byteBuffer.position()) {
                                            }
                                            this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                            i13 = i7 - 1;
                                            z6 = z7;
                                            z4 = z2;
                                            i = i6;
                                            extractVideoToPath = list;
                                            inputBuffers = byteBufferArr2;
                                            channel = fileChannel2;
                                        }
                                    }
                                }
                                byteBufferArr2 = inputBuffers;
                                fileChannel2 = channel;
                                i4 = i15;
                                if (i2 != i4) {
                                    int i20 = 0;
                                    while (i20 < i2) {
                                        int i21 = i4 - 1;
                                        int i22 = i21 * i;
                                        try {
                                            int[] uVPos3 = getUVPos(i21, i20, i, i2);
                                            byte b4 = byteBuffer.get(i22 + i20);
                                            byte b5 = byteBuffer.get(uVPos3[0]);
                                            byte b6 = byteBuffer.get(uVPos3[1]);
                                            int i23 = i4;
                                            while (i23 < i2) {
                                                int i24 = i22;
                                                byteBuffer.put(i22 + i + i20, b4);
                                                if (i23 % 2 == 0 && i20 % 2 == 0) {
                                                    int[] uVPos4 = getUVPos(i23, i20, i, i2);
                                                    i6 = i;
                                                    try {
                                                        byteBuffer.put(uVPos4[0], b5);
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        akb.d(e.toString());
                                                        if (this.mOnTimeReverseListenerWeakReference != null) {
                                                        }
                                                        if (bufferInfo4.size > byteBuffer.position()) {
                                                        }
                                                        this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                        i13 = i7 - 1;
                                                        z6 = z7;
                                                        z4 = z2;
                                                        i = i6;
                                                        extractVideoToPath = list;
                                                        inputBuffers = byteBufferArr2;
                                                        channel = fileChannel2;
                                                    }
                                                    try {
                                                        byteBuffer.put(uVPos4[1], b6);
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        akb.d(e.toString());
                                                        if (this.mOnTimeReverseListenerWeakReference != null) {
                                                        }
                                                        if (bufferInfo4.size > byteBuffer.position()) {
                                                        }
                                                        this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                                        i13 = i7 - 1;
                                                        z6 = z7;
                                                        z4 = z2;
                                                        i = i6;
                                                        extractVideoToPath = list;
                                                        inputBuffers = byteBufferArr2;
                                                        channel = fileChannel2;
                                                    }
                                                } else {
                                                    i6 = i;
                                                }
                                                i23++;
                                                i22 = i24;
                                                i = i6;
                                            }
                                            i20++;
                                            i = i;
                                        } catch (Exception e12) {
                                            e = e12;
                                            i6 = i;
                                            akb.d(e.toString());
                                            if (this.mOnTimeReverseListenerWeakReference != null) {
                                                onTimeReverseListener.onTimeReverseError(e);
                                            }
                                            if (bufferInfo4.size > byteBuffer.position()) {
                                            }
                                            this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                            i13 = i7 - 1;
                                            z6 = z7;
                                            z4 = z2;
                                            i = i6;
                                            extractVideoToPath = list;
                                            inputBuffers = byteBufferArr2;
                                            channel = fileChannel2;
                                        }
                                    }
                                }
                                i6 = i;
                                if (bufferInfo4.size > byteBuffer.position()) {
                                    bufferInfo4.size = byteBuffer.position();
                                }
                                this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, bufferInfo4.size, bufferInfo4.presentationTimeUs, bufferInfo4.flags);
                                i13 = i7 - 1;
                                z6 = z7;
                            } else {
                                byteBufferArr2 = inputBuffers;
                                i6 = i;
                                fileChannel2 = channel;
                                list = extractVideoToPath;
                                this.mVideoEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, j2, 4);
                                i13 = i13;
                                z6 = true;
                            }
                            z4 = z2;
                            i = i6;
                            extractVideoToPath = list;
                            inputBuffers = byteBufferArr2;
                            channel = fileChannel2;
                        }
                    }
                    byteBufferArr = inputBuffers;
                    i5 = i;
                    fileChannel = channel;
                    z2 = z4;
                    List<BuffeInfoWrapper> list2 = extractVideoToPath;
                    int i25 = i13;
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
                                i12 = this.mMediaMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
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
                                    this.mMediaMuxer.writeSampleData(i12, byteBuffer2, bufferInfo);
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
                    i = i5;
                    extractVideoToPath = list2;
                    size = i25;
                    inputBuffers = byteBufferArr;
                    channel = fileChannel;
                }
            }
            try {
                this.mMediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (Exception e13) {
                akb.g(e13);
            }
            try {
                this.mMediaExtractor.release();
            } catch (Exception e14) {
                akb.g(e14);
            }
            try {
                this.mVideoEncoder.stop();
                this.mVideoEncoder.release();
            } catch (Exception e15) {
                akb.g(e15);
            }
            akb.d("finish:" + (System.currentTimeMillis() - j));
            FileUtils.deleteFile(str9);
            new File(str8).renameTo(new File(str2));
            return true;
        } catch (FileNotFoundException e16) {
            e = e16;
            str3 = "MediaCodec点击倒放失败";
        } catch (IOException e17) {
            e = e17;
            str3 = "MediaCodec点击倒放失败";
        } catch (Exception e18) {
            e = e18;
            str3 = "MediaCodec点击倒放失败";
        }
    }

    public void setCancel(boolean z) {
        this.mIsCancel = z;
    }

    public void setTimeReverseListener(WeakReference<OnTimeReverseListener> weakReference) {
        this.mOnTimeReverseListenerWeakReference = weakReference;
    }
}

package com.baidu.tieba.video.meida;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import tv.danmaku.ijk.media.player.IMediaFormat;
/* loaded from: classes2.dex */
public class g {
    public static boolean hgl = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int hgh = 48000;
        public int channelCount = 1;
        public int hgf = 16;
        public int hgm = 0;

        public boolean bDo() {
            return this.hgm == 1 || this.hgm == 4 || this.hgm == 6 || this.hgm == 9;
        }

        public boolean bDp() {
            return this.hgm == 3 || this.hgm == 4 || this.hgm == 8 || this.hgm == 9;
        }

        public boolean bDq() {
            return this.hgm == 5 || this.hgm == 6 || this.hgm == 8 || this.hgm == 9;
        }
    }

    public static void bDn() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            hgl = true;
        } else {
            hgl = false;
        }
    }

    public static boolean a(a... aVarArr) {
        a aVar;
        if (aVarArr == null || aVarArr.length < 2 || (aVar = aVarArr[0]) == null) {
            return false;
        }
        boolean z = true;
        for (int i = 1; i < aVarArr.length; i++) {
            if (aVar.hgh != aVarArr[i].hgh) {
                aVarArr[i].hgm++;
                z = false;
            }
            if (aVar.channelCount != aVarArr[i].channelCount) {
                aVarArr[i].hgm += 3;
                z = false;
            }
            if (aVar.hgf != aVarArr[i].hgf) {
                aVarArr[i].hgm += 5;
                z = false;
            }
        }
        return z;
    }

    @TargetApi(16)
    public static a vb(String str) {
        MediaFormat mediaFormat;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int i = 0;
            while (true) {
                if (i >= mediaExtractor.getTrackCount()) {
                    mediaFormat = null;
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i);
                if (!mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                    i++;
                } else {
                    mediaExtractor.selectTrack(i);
                    break;
                }
            }
            if (mediaFormat == null) {
                mediaExtractor.release();
                return null;
            }
            a aVar = new a();
            aVar.hgh = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
            aVar.channelCount = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
            aVar.hgf = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
            mediaExtractor.release();
            return aVar;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean e(String str, String str2, int i, int i2) {
        BdLog.e("resampling sampleRate = " + i + " resampleRate = " + i2);
        if (i2 == i) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            new j(fileInputStream, fileOutputStream, i, i2, 2, 2, 1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0.0d, 0, true);
            fileInputStream.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] a(int i, int i2, int i3, byte[] bArr) {
        int i4 = 0;
        BdLog.e("convertChannelCount sourceChannelCount = " + i + " outputChannelCount = " + i2);
        if (i != i2) {
            switch (i3) {
                case 1:
                case 2:
                    int length = bArr.length;
                    switch (i) {
                        case 1:
                            switch (i2) {
                                case 2:
                                    byte[] bArr2 = new byte[length * 2];
                                    switch (i3) {
                                        case 1:
                                            while (i4 < length) {
                                                byte b = bArr[i4];
                                                bArr2[i4 * 2] = b;
                                                bArr2[(i4 * 2) + 1] = b;
                                                i4++;
                                            }
                                            break;
                                        case 2:
                                            while (i4 < length) {
                                                byte b2 = bArr[i4];
                                                byte b3 = bArr[i4 + 1];
                                                bArr2[i4 * 2] = b2;
                                                bArr2[(i4 * 2) + 1] = b3;
                                                bArr2[(i4 * 2) + 2] = b2;
                                                bArr2[(i4 * 2) + 3] = b3;
                                                i4 += 2;
                                            }
                                            break;
                                    }
                                    return bArr2;
                                default:
                                    return bArr;
                            }
                        case 2:
                            switch (i2) {
                                case 1:
                                    int i5 = length / 2;
                                    byte[] bArr3 = new byte[i5];
                                    switch (i3) {
                                        case 1:
                                            while (i4 < i5) {
                                                bArr3[i4] = (byte) (((short) (bArr[i4 * 2] + bArr[(i4 * 2) + 1])) >> 1);
                                                i4 += 2;
                                            }
                                            break;
                                        case 2:
                                            for (int i6 = 0; i6 < i5; i6 += 2) {
                                                byte[] a2 = a(bArr[i6 * 2], bArr[(i6 * 2) + 1], bArr[(i6 * 2) + 2], bArr[(i6 * 2) + 3], hgl);
                                                bArr3[i6] = a2[0];
                                                bArr3[i6 + 1] = a2[1];
                                            }
                                            break;
                                    }
                                    return bArr3;
                                default:
                                    return bArr;
                            }
                        default:
                            return bArr;
                    }
                default:
                    return bArr;
            }
        }
        return bArr;
    }

    public static byte[] c(int i, int i2, byte[] bArr) {
        BdLog.e("convertChannelCount sourceByteWidth = " + i + " outputByteWidth = " + i2);
        if (i != i2) {
            int length = bArr.length;
            switch (i) {
                case 1:
                    switch (i2) {
                        case 2:
                            byte[] bArr2 = new byte[length * 2];
                            for (int i3 = 0; i3 < length; i3++) {
                                byte[] a2 = a((short) (bArr[i3] * 256), hgl);
                                bArr2[i3 * 2] = a2[0];
                                bArr2[(i3 * 2) + 1] = a2[1];
                            }
                            return bArr2;
                        default:
                            return bArr;
                    }
                case 2:
                    switch (i2) {
                        case 1:
                            int i4 = length / 2;
                            byte[] bArr3 = new byte[i4];
                            for (int i5 = 0; i5 < i4; i5++) {
                                bArr3[i5] = (byte) (a(bArr[i5 * 2], bArr[(i5 * 2) + 1], hgl) / 256);
                            }
                            return bArr3;
                        default:
                            return bArr;
                    }
                default:
                    return bArr;
            }
        }
        return bArr;
    }

    public static byte[] a(byte b, byte b2, byte b3, byte b4, boolean z) {
        return a((short) ((a(b, b2, z) / 2) + (a(b3, b4, z) / 2)), z);
    }

    public static short a(byte b, byte b2, boolean z) {
        if (z) {
            return (short) (((short) (((short) (0 | (b & 255))) << 8)) | (b2 & 255));
        }
        return (short) (((short) (((short) (0 | (b2 & 255))) << 8)) | (b & 255));
    }

    public static byte[] a(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            bArr[1] = (byte) (s & 255);
            bArr[0] = (byte) (((short) (s >> 8)) & 255);
        } else {
            bArr[0] = (byte) (s & 255);
            bArr[1] = (byte) (((short) (s >> 8)) & 255);
        }
        return bArr;
    }
}

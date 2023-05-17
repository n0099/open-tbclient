package com.baidu.ugc.editvideo.editvideo.muxer;

import com.baidu.tieba.fna;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes8.dex */
public abstract class MultiAudioMixer {
    public OnAudioMixListener mOnAudioMixListener;

    /* loaded from: classes8.dex */
    public interface OnAudioMixListener {
        void onMixComplete();

        void onMixError(int i);

        void onMixing(byte[] bArr) throws IOException;
    }

    public abstract byte[] mixRawAudioBytes(byte[][] bArr, float[] fArr);

    /* loaded from: classes8.dex */
    public static class AudioMixException extends IOException {
        public static final long serialVersionUID = -1344782236320621800L;

        public AudioMixException(String str) {
            super(str);
        }
    }

    /* loaded from: classes8.dex */
    public static class AverageAudioMixer extends MultiAudioMixer {
        public AverageAudioMixer() {
        }

        @Override // com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer
        public byte[] mixRawAudioBytes(byte[][] bArr, float[] fArr) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            byte[] bArr2 = bArr[0];
            if (bArr.length == 1) {
                return bArr2;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i].length != bArr2.length) {
                    fna.d("column of the road of audio + " + i + " is diffrent.");
                    return null;
                }
            }
            int length = bArr.length;
            int length2 = bArr2.length / 2;
            short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i3 * 2;
                    short s = (short) ((bArr[i2][i4] & 255) | ((bArr[i2][i4 + 1] & 255) << 8));
                    if (fArr.length == length) {
                        s = (short) (s * fArr[i2]);
                    }
                    sArr[i2][i3] = s;
                }
            }
            short[] sArr2 = new short[length2];
            for (int i5 = 0; i5 < length2; i5++) {
                int i6 = 0;
                for (int i7 = 0; i7 < length; i7++) {
                    i6 += sArr[i7][i5];
                }
                sArr2[i5] = (short) (i6 / length);
            }
            for (int i8 = 0; i8 < length2; i8++) {
                int i9 = i8 * 2;
                bArr2[i9] = (byte) (sArr2[i8] & 255);
                bArr2[i9 + 1] = (byte) ((sArr2[i8] & 65280) >> 8);
            }
            return bArr2;
        }
    }

    public static MultiAudioMixer createAudioMixer() {
        return new AverageAudioMixer();
    }

    public void mixAudios(File[] fileArr, float[] fArr) {
        boolean z;
        int length = fileArr.length;
        FileInputStream[] fileInputStreamArr = new FileInputStream[length];
        byte[][] bArr = new byte[length];
        boolean[] zArr = new boolean[length];
        byte[] bArr2 = new byte[4096];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                try {
                    try {
                        fileInputStreamArr[i2] = new FileInputStream(fileArr[i2]);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (this.mOnAudioMixListener != null) {
                            this.mOnAudioMixListener.onMixError(1);
                        }
                        while (i < length) {
                            FileInputStream fileInputStream = fileInputStreamArr[i];
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            i++;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            } catch (Throwable th) {
                while (i < length) {
                    try {
                        FileInputStream fileInputStream2 = fileInputStreamArr[i];
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        i++;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
        do {
            for (int i3 = 0; i3 < length; i3++) {
                FileInputStream fileInputStream3 = fileInputStreamArr[i3];
                if (!zArr[i3] && fileInputStream3.read(bArr2) != -1) {
                    bArr[i3] = Arrays.copyOf(bArr2, 4096);
                } else {
                    zArr[i3] = true;
                    bArr[i3] = new byte[4096];
                }
            }
            byte[] mixRawAudioBytes = mixRawAudioBytes(bArr, fArr);
            if (mixRawAudioBytes != null && this.mOnAudioMixListener != null) {
                this.mOnAudioMixListener.onMixing(mixRawAudioBytes);
            }
            z = true;
            for (int i4 = 0; i4 < length; i4++) {
                if (!zArr[i4]) {
                    z = false;
                }
            }
        } while (!z);
        if (this.mOnAudioMixListener != null) {
            this.mOnAudioMixListener.onMixComplete();
        }
        while (i < length) {
            FileInputStream fileInputStream4 = fileInputStreamArr[i];
            if (fileInputStream4 != null) {
                fileInputStream4.close();
            }
            i++;
        }
    }

    public void setOnAudioMixListener(OnAudioMixListener onAudioMixListener) {
        this.mOnAudioMixListener = onAudioMixListener;
    }
}

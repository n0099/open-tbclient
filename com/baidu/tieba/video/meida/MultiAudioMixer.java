package com.baidu.tieba.video.meida;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class MultiAudioMixer {

    /* renamed from: a  reason: collision with root package name */
    public c f21807a;

    /* loaded from: classes5.dex */
    public static class AudioMixException extends IOException {
        public static final long serialVersionUID = -1344782236320621800L;

        public AudioMixException(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends MultiAudioMixer {
        public b() {
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer
        public byte[] c(byte[][] bArr) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            byte[] bArr2 = bArr[0];
            if (bArr.length == 1) {
                return bArr2;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i].length != bArr2.length) {
                    BdLog.e("column of the road of audio + " + i + " is diffrent.");
                    return null;
                }
            }
            int length = bArr.length;
            int length2 = bArr2.length / 2;
            short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i3 * 2;
                    sArr[i2][i3] = (short) ((bArr[i2][i4] & 255) | ((bArr[i2][i4 + 1] & 255) << 8));
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

    /* loaded from: classes5.dex */
    public interface c {
        void a(byte[] bArr) throws IOException;

        void b(int i);

        void c();
    }

    public static MultiAudioMixer a() {
        return new b();
    }

    public void b(File[] fileArr) {
        boolean z;
        int length = fileArr.length;
        FileInputStream[] fileInputStreamArr = new FileInputStream[length];
        byte[][] bArr = new byte[length];
        boolean[] zArr = new boolean[length];
        byte[] bArr2 = new byte[512];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                try {
                    try {
                        fileInputStreamArr[i2] = new FileInputStream(fileArr[i2]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.f21807a != null) {
                            this.f21807a.b(1);
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
                } catch (Exception e3) {
                    e3.printStackTrace();
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
                    } catch (Exception e4) {
                        e4.printStackTrace();
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
                    bArr[i3] = Arrays.copyOf(bArr2, 512);
                } else {
                    zArr[i3] = true;
                    bArr[i3] = new byte[512];
                }
            }
            byte[] c2 = c(bArr);
            if (c2 != null && this.f21807a != null) {
                this.f21807a.a(c2);
            }
            z = true;
            for (int i4 = 0; i4 < length; i4++) {
                if (!zArr[i4]) {
                    z = false;
                }
            }
        } while (!z);
        if (this.f21807a != null) {
            this.f21807a.c();
        }
        while (i < length) {
            FileInputStream fileInputStream4 = fileInputStreamArr[i];
            if (fileInputStream4 != null) {
                fileInputStream4.close();
            }
            i++;
        }
    }

    public abstract byte[] c(byte[][] bArr);

    public void d(c cVar) {
        this.f21807a = cVar;
    }
}

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
    public c f21378a;

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
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2].length != bArr2.length) {
                    BdLog.e("column of the road of audio + " + i2 + " is diffrent.");
                    return null;
                }
            }
            int length = bArr.length;
            int length2 = bArr2.length / 2;
            short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
            for (int i3 = 0; i3 < length; i3++) {
                for (int i4 = 0; i4 < length2; i4++) {
                    int i5 = i4 * 2;
                    sArr[i3][i4] = (short) ((bArr[i3][i5] & 255) | ((bArr[i3][i5 + 1] & 255) << 8));
                }
            }
            short[] sArr2 = new short[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = 0;
                for (int i8 = 0; i8 < length; i8++) {
                    i7 += sArr[i8][i6];
                }
                sArr2[i6] = (short) (i7 / length);
            }
            for (int i9 = 0; i9 < length2; i9++) {
                int i10 = i9 * 2;
                bArr2[i10] = (byte) (sArr2[i9] & 255);
                bArr2[i10 + 1] = (byte) ((sArr2[i9] & 65280) >> 8);
            }
            return bArr2;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(byte[] bArr) throws IOException;

        void b();

        void c(int i2);
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
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                try {
                    try {
                        fileInputStreamArr[i3] = new FileInputStream(fileArr[i3]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.f21378a != null) {
                            this.f21378a.c(1);
                        }
                        while (i2 < length) {
                            FileInputStream fileInputStream = fileInputStreamArr[i2];
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            i2++;
                        }
                        return;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (Throwable th) {
                while (i2 < length) {
                    try {
                        FileInputStream fileInputStream2 = fileInputStreamArr[i2];
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        i2++;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
        do {
            for (int i4 = 0; i4 < length; i4++) {
                FileInputStream fileInputStream3 = fileInputStreamArr[i4];
                if (!zArr[i4] && fileInputStream3.read(bArr2) != -1) {
                    bArr[i4] = Arrays.copyOf(bArr2, 512);
                } else {
                    zArr[i4] = true;
                    bArr[i4] = new byte[512];
                }
            }
            byte[] c2 = c(bArr);
            if (c2 != null && this.f21378a != null) {
                this.f21378a.a(c2);
            }
            z = true;
            for (int i5 = 0; i5 < length; i5++) {
                if (!zArr[i5]) {
                    z = false;
                }
            }
        } while (!z);
        if (this.f21378a != null) {
            this.f21378a.b();
        }
        while (i2 < length) {
            FileInputStream fileInputStream4 = fileInputStreamArr[i2];
            if (fileInputStream4 != null) {
                fileInputStream4.close();
            }
            i2++;
        }
    }

    public abstract byte[] c(byte[][] bArr);

    public void d(c cVar) {
        this.f21378a = cVar;
    }
}

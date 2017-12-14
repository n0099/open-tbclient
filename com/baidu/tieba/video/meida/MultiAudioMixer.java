package com.baidu.tieba.video.meida;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes2.dex */
public abstract class MultiAudioMixer {
    private b gVs;

    /* loaded from: classes2.dex */
    public interface b {
        void D(byte[] bArr) throws IOException;

        void bDa();

        void vx(int i);
    }

    abstract byte[] b(byte[][] bArr);

    public static MultiAudioMixer bCZ() {
        return new a();
    }

    public void a(b bVar) {
        this.gVs = bVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[ARITH, INVOKE, ARITH, IF, INVOKE, MOVE_EXCEPTION, AGET, IF, ARRAY_LENGTH, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=6] */
    public void a(File[] fileArr) {
        boolean z;
        int i = 0;
        int length = fileArr.length;
        FileInputStream[] fileInputStreamArr = new FileInputStream[length];
        byte[][] bArr = new byte[length];
        boolean[] zArr = new boolean[length];
        byte[] bArr2 = new byte[512];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                try {
                    fileInputStreamArr[i2] = new FileInputStream(fileArr[i2]);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gVs != null) {
                        this.gVs.vx(1);
                    }
                    try {
                        int length2 = fileInputStreamArr.length;
                        while (i < length2) {
                            FileInputStream fileInputStream = fileInputStreamArr[i];
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            i++;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            } finally {
                try {
                    int length3 = fileInputStreamArr.length;
                    while (i < length3) {
                        FileInputStream fileInputStream2 = fileInputStreamArr[i];
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        i++;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        do {
            for (int i3 = 0; i3 < length; i3++) {
                FileInputStream fileInputStream3 = fileInputStreamArr[i3];
                if (zArr[i3] || fileInputStream3.read(bArr2) == -1) {
                    zArr[i3] = true;
                    bArr[i3] = new byte[512];
                } else {
                    bArr[i3] = Arrays.copyOf(bArr2, bArr2.length);
                }
            }
            byte[] b2 = b(bArr);
            if (b2 != null && this.gVs != null) {
                this.gVs.D(b2);
            }
            z = true;
            for (boolean z2 : zArr) {
                if (!z2) {
                    z = false;
                }
            }
        } while (!z);
        if (this.gVs != null) {
            this.gVs.bDa();
        }
    }

    /* loaded from: classes2.dex */
    public static class AudioMixException extends IOException {
        private static final long serialVersionUID = -1344782236320621800L;

        public AudioMixException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends MultiAudioMixer {
        private a() {
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer
        byte[] b(byte[][] bArr) {
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
            short[][] sArr = (short[][]) Array.newInstance(Short.TYPE, length, length2);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length2; i3++) {
                    sArr[i2][i3] = (short) ((bArr[i2][i3 * 2] & 255) | ((bArr[i2][(i3 * 2) + 1] & 255) << 8));
                }
            }
            short[] sArr2 = new short[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = 0;
                for (int i6 = 0; i6 < length; i6++) {
                    i5 += sArr[i6][i4];
                }
                sArr2[i4] = (short) (i5 / length);
            }
            for (int i7 = 0; i7 < length2; i7++) {
                bArr2[i7 * 2] = (byte) (sArr2[i7] & 255);
                bArr2[(i7 * 2) + 1] = (byte) ((sArr2[i7] & 65280) >> 8);
            }
            return bArr2;
        }
    }
}

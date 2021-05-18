package com.baidu.wallet.base.audio;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f23183e = "RIFF";

    /* renamed from: f  reason: collision with root package name */
    public static final String f23184f = "WAVE";

    /* renamed from: g  reason: collision with root package name */
    public static final String f23185g = "fmt ";

    /* renamed from: h  reason: collision with root package name */
    public static final String f23186h = "data";

    /* renamed from: a  reason: collision with root package name */
    public short f23187a;

    /* renamed from: b  reason: collision with root package name */
    public int f23188b;

    /* renamed from: c  reason: collision with root package name */
    public short f23189c;

    /* renamed from: d  reason: collision with root package name */
    public int f23190d;

    /* renamed from: i  reason: collision with root package name */
    public final ByteBuffer f23191i = ByteBuffer.allocate(44);
    public int j;
    public int k;

    public static b a(InputStream inputStream) {
        b bVar = new b();
        try {
            bVar.f23191i.order(ByteOrder.LITTLE_ENDIAN);
            inputStream.read(bVar.f23191i.array());
            bVar.j = bVar.f23191i.getInt(4);
            bVar.f23187a = bVar.f23191i.getShort(22);
            bVar.f23188b = bVar.f23191i.getInt(24);
            bVar.f23189c = bVar.f23191i.getShort(34);
            int b2 = bVar.b(inputStream);
            bVar.k = b2;
            if (-1 != b2) {
                bVar.f23190d = bVar.f23191i.getInt(40);
                return bVar;
            }
            return bVar;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private int b(InputStream inputStream) {
        byte[] bArr = new byte[4];
        int i2 = 36;
        do {
            int i3 = -1;
            try {
                this.f23191i.position(36);
                this.f23191i.get(bArr);
                int i4 = this.f23191i.getInt(40);
                if (Arrays.equals("data".getBytes(), bArr)) {
                    i3 = i2 + 8;
                    return i3;
                }
                inputStream.skip(i4);
                i2 += i4 + 8;
            } catch (IOException e2) {
                e2.printStackTrace();
                return i3;
            }
        } while (8 == inputStream.read(this.f23191i.array(), 36, 8));
        return -1;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        b bVar = new b();
        bVar.f23191i.order(ByteOrder.LITTLE_ENDIAN);
        bVar.f23191i.put(f23183e.getBytes());
        int i6 = (i5 + 44) - 8;
        bVar.j = i6;
        bVar.f23191i.putInt(i6);
        bVar.f23191i.put(f23184f.getBytes());
        bVar.f23191i.put(f23185g.getBytes());
        bVar.f23191i.putInt(16);
        bVar.f23191i.putShort((short) 1);
        short s = (short) i2;
        bVar.f23187a = s;
        bVar.f23191i.putShort(s);
        bVar.f23188b = i4;
        bVar.f23191i.putInt(i4);
        short s2 = (short) ((i2 * i3) / 8);
        bVar.f23191i.putInt(i4 * s2);
        bVar.f23191i.putShort(s2);
        short s3 = (short) i3;
        bVar.f23189c = s3;
        bVar.f23191i.putShort(s3);
        bVar.f23191i.put("data".getBytes());
        bVar.k = 44;
        bVar.f23190d = i5;
        bVar.f23191i.putInt(i5);
        return bVar;
    }

    public void a(OutputStream outputStream) {
        try {
            outputStream.write(this.f23191i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(DataOutput dataOutput) {
        try {
            dataOutput.write(this.f23191i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        System.out.println("--Wave Header--\nfile length:" + this.j + "\nchannels:" + ((int) this.f23187a) + "\nsample rate:" + this.f23188b + "\nbit depth:" + ((int) this.f23189c) + "\npcm length:" + this.f23190d + "\ndata offset:" + this.k + "\n");
    }
}

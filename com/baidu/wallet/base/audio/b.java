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
    public static final String f23223e = "RIFF";

    /* renamed from: f  reason: collision with root package name */
    public static final String f23224f = "WAVE";

    /* renamed from: g  reason: collision with root package name */
    public static final String f23225g = "fmt ";

    /* renamed from: h  reason: collision with root package name */
    public static final String f23226h = "data";

    /* renamed from: a  reason: collision with root package name */
    public short f23227a;

    /* renamed from: b  reason: collision with root package name */
    public int f23228b;

    /* renamed from: c  reason: collision with root package name */
    public short f23229c;

    /* renamed from: d  reason: collision with root package name */
    public int f23230d;
    public final ByteBuffer i = ByteBuffer.allocate(44);
    public int j;
    public int k;

    public static b a(InputStream inputStream) {
        b bVar = new b();
        try {
            bVar.i.order(ByteOrder.LITTLE_ENDIAN);
            inputStream.read(bVar.i.array());
            bVar.j = bVar.i.getInt(4);
            bVar.f23227a = bVar.i.getShort(22);
            bVar.f23228b = bVar.i.getInt(24);
            bVar.f23229c = bVar.i.getShort(34);
            int b2 = bVar.b(inputStream);
            bVar.k = b2;
            if (-1 != b2) {
                bVar.f23230d = bVar.i.getInt(40);
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
        int i = 36;
        do {
            int i2 = -1;
            try {
                this.i.position(36);
                this.i.get(bArr);
                int i3 = this.i.getInt(40);
                if (Arrays.equals("data".getBytes(), bArr)) {
                    i2 = i + 8;
                    return i2;
                }
                inputStream.skip(i3);
                i += i3 + 8;
            } catch (IOException e2) {
                e2.printStackTrace();
                return i2;
            }
        } while (8 == inputStream.read(this.i.array(), 36, 8));
        return -1;
    }

    public static b a(int i, int i2, int i3, int i4) {
        b bVar = new b();
        bVar.i.order(ByteOrder.LITTLE_ENDIAN);
        bVar.i.put(f23223e.getBytes());
        int i5 = (i4 + 44) - 8;
        bVar.j = i5;
        bVar.i.putInt(i5);
        bVar.i.put(f23224f.getBytes());
        bVar.i.put(f23225g.getBytes());
        bVar.i.putInt(16);
        bVar.i.putShort((short) 1);
        short s = (short) i;
        bVar.f23227a = s;
        bVar.i.putShort(s);
        bVar.f23228b = i3;
        bVar.i.putInt(i3);
        short s2 = (short) ((i * i2) / 8);
        bVar.i.putInt(i3 * s2);
        bVar.i.putShort(s2);
        short s3 = (short) i2;
        bVar.f23229c = s3;
        bVar.i.putShort(s3);
        bVar.i.put("data".getBytes());
        bVar.k = 44;
        bVar.f23230d = i4;
        bVar.i.putInt(i4);
        return bVar;
    }

    public void a(OutputStream outputStream) {
        try {
            outputStream.write(this.i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(DataOutput dataOutput) {
        try {
            dataOutput.write(this.i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        System.out.println("--Wave Header--\nfile length:" + this.j + "\nchannels:" + ((int) this.f23227a) + "\nsample rate:" + this.f23228b + "\nbit depth:" + ((int) this.f23229c) + "\npcm length:" + this.f23230d + "\ndata offset:" + this.k + "\n");
    }
}

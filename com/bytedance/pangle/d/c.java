package com.bytedance.pangle.d;

import com.bytedance.pangle.util.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public final class c implements Closeable {
    public final FileInputStream a;
    public a b;
    public b[] c;
    public C0532c[] d;
    public final Map<String, C0532c> e = new HashMap();

    /* loaded from: classes8.dex */
    public static class a {
        public final byte[] a;
        public final short b;
        public final short c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        public a(FileChannel fileChannel) {
            int i;
            ByteOrder byteOrder;
            this.a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.a));
            byte[] bArr = this.a;
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b = bArr[4];
                c.a(b, 2, "bad elf class: " + ((int) this.a[4]));
                byte b2 = this.a[5];
                c.a(b2, 2, "bad elf data encoding: " + ((int) this.a[5]));
                if (this.a[4] == 1) {
                    i = 36;
                } else {
                    i = 48;
                }
                ByteBuffer allocate = ByteBuffer.allocate(i);
                if (this.a[5] == 1) {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
                allocate.order(byteOrder);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.b = allocate.getShort();
                this.c = allocate.getShort();
                int i2 = allocate.getInt();
                this.d = i2;
                c.a(i2, 1, "bad elf version: " + this.d);
                byte b3 = this.a[4];
                if (b3 != 1) {
                    if (b3 == 2) {
                        this.e = allocate.getLong();
                        this.f = allocate.getLong();
                        this.g = allocate.getLong();
                    } else {
                        throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                    }
                } else {
                    this.e = allocate.getInt();
                    this.f = allocate.getInt();
                    this.g = allocate.getInt();
                }
                this.h = allocate.getInt();
                this.i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }

        public /* synthetic */ a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final long h;

        public b(ByteBuffer byteBuffer, int i) {
            if (i != 1) {
                if (i == 2) {
                    this.a = byteBuffer.getInt();
                    this.b = byteBuffer.getInt();
                    this.c = byteBuffer.getLong();
                    this.d = byteBuffer.getLong();
                    this.e = byteBuffer.getLong();
                    this.f = byteBuffer.getLong();
                    this.g = byteBuffer.getLong();
                    this.h = byteBuffer.getLong();
                    return;
                }
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.a = byteBuffer.getInt();
            this.c = byteBuffer.getInt();
            this.d = byteBuffer.getInt();
            this.e = byteBuffer.getInt();
            this.f = byteBuffer.getInt();
            this.g = byteBuffer.getInt();
            this.b = byteBuffer.getInt();
            this.h = byteBuffer.getInt();
        }

        public /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0532c {
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        public final long i;
        public final long j;
        public String k;

        public C0532c(ByteBuffer byteBuffer, int i) {
            if (i != 1) {
                if (i == 2) {
                    this.a = byteBuffer.getInt();
                    this.b = byteBuffer.getInt();
                    this.c = byteBuffer.getLong();
                    this.d = byteBuffer.getLong();
                    this.e = byteBuffer.getLong();
                    this.f = byteBuffer.getLong();
                    this.g = byteBuffer.getInt();
                    this.h = byteBuffer.getInt();
                    this.i = byteBuffer.getLong();
                    this.j = byteBuffer.getLong();
                } else {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
                }
            } else {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            }
            this.k = null;
        }

        public /* synthetic */ C0532c(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }
    }

    public c(File file) {
        ByteOrder byteOrder;
        C0532c[] c0532cArr;
        C0532c[] c0532cArr2;
        this.b = null;
        this.c = null;
        this.d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.b.j);
        if (this.b.a[5] == 1) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        allocate.order(byteOrder);
        channel.position(this.b.f);
        this.c = new b[this.b.k];
        for (int i = 0; i < this.c.length; i++) {
            b(channel, allocate, "failed to read phdr.");
            this.c[i] = new b(allocate, this.b.a[4], (byte) 0);
        }
        channel.position(this.b.g);
        allocate.limit(this.b.l);
        this.d = new C0532c[this.b.m];
        int i2 = 0;
        while (true) {
            c0532cArr = this.d;
            if (i2 >= c0532cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.d[i2] = new C0532c(allocate, this.b.a[4], (byte) 0);
            i2++;
        }
        short s = this.b.n;
        if (s > 0) {
            C0532c c0532c = c0532cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c0532c.f);
            this.a.getChannel().position(c0532c.e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c0532c.k);
            for (C0532c c0532c2 : this.d) {
                allocate2.position(c0532c2.a);
                String a2 = a(allocate2);
                c0532c2.k = a2;
                this.e.put(a2, c0532c2);
            }
        }
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName(HTTP.ASCII));
    }

    public static /* synthetic */ void a(int i, int i2, String str) {
        if (i > 0 && i <= i2) {
            return;
        }
        throw new IOException(str);
    }

    public static boolean a(File file) {
        try {
            f.a(new c(file));
            return true;
        } catch (IOException unused) {
            f.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            f.a((Closeable) null);
            throw th;
        }
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        this.e.clear();
        this.c = null;
        this.d = null;
    }
}

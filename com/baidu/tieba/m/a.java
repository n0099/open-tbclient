package com.baidu.tieba.m;

import com.baidu.android.imsdk.internal.Constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
/* loaded from: classes23.dex */
class a {
    private static final int llP = aj(new byte[]{102, 114, Constants.SHORT_PING_CMD_TYPE, Constants.SHORT_PING_CMD_TYPE});
    private static final int llQ = aj(new byte[]{106, 117, 110, 107});
    private static final int llR = aj(new byte[]{109, 100, 97, 116});
    private static final int llS = aj(new byte[]{109, 111, 111, 118});
    private static final int llT = aj(new byte[]{112, 110, 111, 116});
    private static final int llU = aj(new byte[]{115, 107, 105, 112});
    private static final int llV = aj(new byte[]{119, 105, 100, Constants.SHORT_PING_CMD_TYPE});
    private static final int llW = aj(new byte[]{80, 73, 67, 84});
    private static final int llX = aj(new byte[]{102, 116, 121, 112});
    private static final int llY = aj(new byte[]{117, 117, 105, 100});
    private static final int llZ = aj(new byte[]{99, 109, 111, 118});
    private static final int lma = aj(new byte[]{115, 116, 99, 111});
    private static final int lmb = aj(new byte[]{99, 111, 54, 52});

    static long Gh(int i) {
        return i & 4294967295L;
    }

    static int hk(long j) throws RuntimeException {
        if (j > 2147483647L || j < 0) {
            throw new RuntimeException("uint32 value is too large");
        }
        return (int) j;
    }

    static long hl(long j) throws RuntimeException {
        if (j < 0) {
            throw new RuntimeException("uint64 value is too large");
        }
        return j;
    }

    private static int aj(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        return read == byteBuffer.capacity();
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer, j);
        byteBuffer.flip();
        return read == byteBuffer.capacity();
    }

    public static int Pu(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int a2 = a(fileInputStream.getChannel());
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                return a2;
            } catch (Exception e) {
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                return 2;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static int a(FileChannel fileChannel) throws IOException, RuntimeException {
        int i;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        int i2 = 0;
        while (true) {
            if (!a(fileChannel, order)) {
                i = i2;
                break;
            }
            long Gh = Gh(order.getInt());
            i = order.getInt();
            if (i == llX) {
                int hk = hk(Gh);
                ByteBuffer order2 = ByteBuffer.allocate(hk).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                order2.put(order);
                if (fileChannel.read(order2) >= hk - 8) {
                    order2.flip();
                    if ((i == llP && i != llQ && i != llR && i != llS && i != llT && i != llU && i != llV && i != llW && i != llY && i != llX) || Gh < 8) {
                        break;
                    }
                    i2 = i;
                } else {
                    break;
                }
            } else {
                if (Gh == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        break;
                    }
                    Gh = hl(order.getLong());
                    fileChannel.position((fileChannel.position() + Gh) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + Gh) - 8);
                }
                if (i == llP) {
                }
                i2 = i;
            }
        }
        return i != llS ? 0 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=4] */
    public static boolean fP(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                FileChannel channel = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(str2);
                try {
                    boolean a2 = a(channel, fileOutputStream.getChannel());
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    return a2;
                } catch (Exception e) {
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x00cc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(FileChannel fileChannel, FileChannel fileChannel2) throws IOException {
        ByteBuffer byteBuffer;
        int i;
        long j;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        int i2 = 0;
        long j2 = 0;
        ByteBuffer byteBuffer2 = null;
        long j3 = 0;
        while (true) {
            if (!a(fileChannel, order)) {
                long j4 = j3;
                byteBuffer = byteBuffer2;
                i = i2;
                j = j4;
                break;
            }
            j2 = Gh(order.getInt());
            i2 = order.getInt();
            if (i2 == llX) {
                int hk = hk(j2);
                byteBuffer2 = ByteBuffer.allocate(hk).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer2.put(order);
                if (fileChannel.read(byteBuffer2) < hk - 8) {
                    long j5 = j3;
                    byteBuffer = byteBuffer2;
                    i = i2;
                    j = j5;
                    break;
                }
                byteBuffer2.flip();
                j3 = fileChannel.position();
                if (i2 == llP && i2 != llQ && i2 != llR && i2 != llS && i2 != llT && i2 != llU && i2 != llV && i2 != llW && i2 != llY && i2 != llX) {
                    long j6 = j3;
                    byteBuffer = byteBuffer2;
                    i = i2;
                    j = j6;
                    break;
                } else if (j2 < 8) {
                    long j7 = j3;
                    byteBuffer = byteBuffer2;
                    i = i2;
                    j = j7;
                    break;
                }
            } else {
                if (j2 == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        long j8 = j3;
                        byteBuffer = byteBuffer2;
                        i = i2;
                        j = j8;
                        break;
                    }
                    j2 = hl(order.getLong());
                    fileChannel.position((fileChannel.position() + j2) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + j2) - 8);
                }
                if (i2 == llP) {
                }
                if (j2 < 8) {
                }
            }
        }
        if (i != llS) {
            return false;
        }
        int hk2 = hk(j2);
        long size = fileChannel.size() - hk2;
        ByteBuffer order2 = ByteBuffer.allocate(hk2).order(ByteOrder.BIG_ENDIAN);
        if (!a(fileChannel, order2, size)) {
            throw new RuntimeException("failed to read moov atom");
        }
        if (order2.getInt(12) == llZ) {
            throw new RuntimeException("this utility does not support compressed moov atoms yet");
        }
        while (order2.remaining() >= 8) {
            int position = order2.position();
            int i3 = order2.getInt(position + 4);
            if (i3 != lma && i3 != lmb) {
                order2.position(order2.position() + 1);
            } else if (Gh(order2.getInt(position)) > order2.remaining()) {
                throw new RuntimeException("bad atom size");
            } else {
                order2.position(position + 12);
                if (order2.remaining() < 4) {
                    throw new RuntimeException("malformed atom");
                }
                int hk3 = hk(order2.getInt());
                if (i3 == lma) {
                    if (order2.remaining() < hk3 * 4) {
                        throw new RuntimeException("bad atom size/element count");
                    }
                    for (int i4 = 0; i4 < hk3; i4++) {
                        int i5 = order2.getInt(order2.position());
                        int i6 = i5 + hk2;
                        if (i5 < 0 && i6 >= 0) {
                            throw new RuntimeException("This is bug in original qt-faststart.c: stco atom should be extended to co64 atom as new offset value overflows uint32, but is not implemented.");
                        }
                        order2.putInt(i6);
                    }
                    continue;
                } else if (i3 != lmb) {
                    continue;
                } else if (order2.remaining() < hk3 * 8) {
                    throw new RuntimeException("bad atom size/element count");
                } else {
                    for (int i7 = 0; i7 < hk3; i7++) {
                        order2.putLong(order2.getLong(order2.position()) + hk2);
                    }
                }
            }
        }
        fileChannel.position(j);
        if (byteBuffer != null) {
            byteBuffer.rewind();
            fileChannel2.write(byteBuffer);
        }
        order2.rewind();
        fileChannel2.write(order2);
        fileChannel.transferTo(j, size - j, fileChannel2);
        return true;
    }
}

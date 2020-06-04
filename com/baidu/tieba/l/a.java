package com.baidu.tieba.l;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a {
    private static final int jsE = ae(new byte[]{102, 114, Constants.SHORT_PING_CMD_TYPE, Constants.SHORT_PING_CMD_TYPE});
    private static final int jsF = ae(new byte[]{106, 117, 110, 107});
    private static final int jsG = ae(new byte[]{109, 100, 97, 116});
    private static final int jsH = ae(new byte[]{109, 111, 111, 118});
    private static final int jsI = ae(new byte[]{112, 110, 111, 116});
    private static final int jsJ = ae(new byte[]{115, 107, 105, 112});
    private static final int jsK = ae(new byte[]{119, 105, 100, Constants.SHORT_PING_CMD_TYPE});
    private static final int jsL = ae(new byte[]{80, 73, 67, 84});
    private static final int jsM = ae(new byte[]{102, 116, 121, 112});
    private static final int jsN = ae(new byte[]{117, 117, 105, 100});
    private static final int jsO = ae(new byte[]{99, 109, 111, 118});
    private static final int jsP = ae(new byte[]{115, 116, 99, 111});
    private static final int jsQ = ae(new byte[]{99, 111, 54, 52});

    /* renamed from: com.baidu.tieba.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0654a {
        void qz(boolean z);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void n(Integer num);
    }

    static long zD(int i) {
        return i & 4294967295L;
    }

    static int eW(long j) throws RuntimeException {
        if (j > 2147483647L || j < 0) {
            throw new RuntimeException("uint32 value is too large");
        }
        return (int) j;
    }

    static long eX(long j) throws RuntimeException {
        if (j < 0) {
            throw new RuntimeException("uint64 value is too large");
        }
        return j;
    }

    private static int ae(byte[] bArr) {
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

    public static void a(String str, final b bVar) {
        if (bVar != null) {
            if (StringUtils.isNull(str)) {
                bVar.n(2);
            }
            new BdAsyncTask<String, Void, Integer>() { // from class: com.baidu.tieba.l.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: N */
                public Integer doInBackground(String... strArr) {
                    if (strArr == null || strArr.length != 1) {
                        return 2;
                    }
                    return Integer.valueOf(a.IE(strArr[0]));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Integer num) {
                    super.onPostExecute((AnonymousClass1) num);
                    if (b.this != null) {
                        b.this.n(num);
                    }
                }
            }.execute(str);
        }
    }

    public static int IE(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int a = a(fileInputStream.getChannel());
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                return a;
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
            long zD = zD(order.getInt());
            i = order.getInt();
            if (i == jsM) {
                int eW = eW(zD);
                ByteBuffer order2 = ByteBuffer.allocate(eW).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                order2.put(order);
                if (fileChannel.read(order2) >= eW - 8) {
                    order2.flip();
                    if ((i == jsE && i != jsF && i != jsG && i != jsH && i != jsI && i != jsJ && i != jsK && i != jsL && i != jsN && i != jsM) || zD < 8) {
                        break;
                    }
                    i2 = i;
                } else {
                    break;
                }
            } else {
                if (zD == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        break;
                    }
                    zD = eX(order.getLong());
                    fileChannel.position((fileChannel.position() + zD) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + zD) - 8);
                }
                if (i == jsE) {
                }
                i2 = i;
            }
        }
        return i != jsH ? 0 : 1;
    }

    public static void a(String str, String str2, final InterfaceC0654a interfaceC0654a) {
        if (interfaceC0654a != null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || !new File(str).exists()) {
                interfaceC0654a.qz(false);
            } else {
                new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.l.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Boolean doInBackground(String... strArr) {
                        if (strArr == null || strArr.length != 2) {
                            return false;
                        }
                        return Boolean.valueOf(a.eL(strArr[0], strArr[1]));
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onPostExecute(Boolean bool) {
                        super.onPostExecute((AnonymousClass2) bool);
                        if (InterfaceC0654a.this != null) {
                            InterfaceC0654a.this.qz(bool.booleanValue());
                        }
                    }
                }.execute(str, str2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=4] */
    public static boolean eL(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                FileChannel channel = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(str2);
                try {
                    boolean a = a(channel, fileOutputStream.getChannel());
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    return a;
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
            j2 = zD(order.getInt());
            i2 = order.getInt();
            if (i2 == jsM) {
                int eW = eW(j2);
                byteBuffer2 = ByteBuffer.allocate(eW).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer2.put(order);
                if (fileChannel.read(byteBuffer2) < eW - 8) {
                    long j5 = j3;
                    byteBuffer = byteBuffer2;
                    i = i2;
                    j = j5;
                    break;
                }
                byteBuffer2.flip();
                j3 = fileChannel.position();
                if (i2 == jsE && i2 != jsF && i2 != jsG && i2 != jsH && i2 != jsI && i2 != jsJ && i2 != jsK && i2 != jsL && i2 != jsN && i2 != jsM) {
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
                    j2 = eX(order.getLong());
                    fileChannel.position((fileChannel.position() + j2) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + j2) - 8);
                }
                if (i2 == jsE) {
                }
                if (j2 < 8) {
                }
            }
        }
        if (i != jsH) {
            return false;
        }
        int eW2 = eW(j2);
        long size = fileChannel.size() - eW2;
        ByteBuffer order2 = ByteBuffer.allocate(eW2).order(ByteOrder.BIG_ENDIAN);
        if (!a(fileChannel, order2, size)) {
            throw new RuntimeException("failed to read moov atom");
        }
        if (order2.getInt(12) == jsO) {
            throw new RuntimeException("this utility does not support compressed moov atoms yet");
        }
        while (order2.remaining() >= 8) {
            int position = order2.position();
            int i3 = order2.getInt(position + 4);
            if (i3 != jsP && i3 != jsQ) {
                order2.position(order2.position() + 1);
            } else if (zD(order2.getInt(position)) > order2.remaining()) {
                throw new RuntimeException("bad atom size");
            } else {
                order2.position(position + 12);
                if (order2.remaining() < 4) {
                    throw new RuntimeException("malformed atom");
                }
                int eW3 = eW(order2.getInt());
                if (i3 == jsP) {
                    if (order2.remaining() < eW3 * 4) {
                        throw new RuntimeException("bad atom size/element count");
                    }
                    for (int i4 = 0; i4 < eW3; i4++) {
                        int i5 = order2.getInt(order2.position());
                        int i6 = i5 + eW2;
                        if (i5 < 0 && i6 >= 0) {
                            throw new RuntimeException("This is bug in original qt-faststart.c: stco atom should be extended to co64 atom as new offset value overflows uint32, but is not implemented.");
                        }
                        order2.putInt(i6);
                    }
                    continue;
                } else if (i3 != jsQ) {
                    continue;
                } else if (order2.remaining() < eW3 * 8) {
                    throw new RuntimeException("bad atom size/element count");
                } else {
                    for (int i7 = 0; i7 < eW3; i7++) {
                        order2.putLong(order2.getLong(order2.position()) + eW2);
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

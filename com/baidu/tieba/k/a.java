package com.baidu.tieba.k;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {
    private static final int fhv = F(new byte[]{102, 114, 101, 101});
    private static final int fhw = F(new byte[]{106, 117, 110, 107});
    private static final int fhx = F(new byte[]{109, 100, 97, 116});
    private static final int fhy = F(new byte[]{109, 111, 111, 118});
    private static final int fhz = F(new byte[]{112, 110, 111, 116});
    private static final int fhA = F(new byte[]{115, 107, 105, 112});
    private static final int fhB = F(new byte[]{119, 105, 100, 101});
    private static final int fhC = F(new byte[]{80, 73, 67, 84});
    private static final int fhD = F(new byte[]{102, 116, 121, 112});
    private static final int fhE = F(new byte[]{117, 117, 105, 100});
    private static final int fhF = F(new byte[]{99, 109, 111, 118});
    private static final int fhG = F(new byte[]{115, 116, 99, 111});
    private static final int fhH = F(new byte[]{99, 111, 54, 52});

    /* renamed from: com.baidu.tieba.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0189a {
        void jb(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void pY(int i);
    }

    static long pX(int i) {
        return i & 4294967295L;
    }

    static int cC(long j) throws RuntimeException {
        if (j > 2147483647L || j < 0) {
            throw new RuntimeException("uint32 value is too large");
        }
        return (int) j;
    }

    static long cD(long j) throws RuntimeException {
        if (j < 0) {
            throw new RuntimeException("uint64 value is too large");
        }
        return j;
    }

    private static int F(byte[] bArr) {
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
                bVar.pY(2);
            }
            new BdAsyncTask<String, Void, Integer>() { // from class: com.baidu.tieba.k.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: x */
                public Integer doInBackground(String... strArr) {
                    if (strArr == null || strArr.length != 1) {
                        return 2;
                    }
                    return Integer.valueOf(a.qG(strArr[0]));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Integer num) {
                    super.onPostExecute((AnonymousClass1) num);
                    if (b.this != null) {
                        b.this.pY(num.intValue());
                    }
                }
            }.execute(str);
        }
    }

    public static int qG(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int a = a(fileInputStream.getChannel());
                com.baidu.adp.lib.g.a.f(fileInputStream);
                return a;
            } catch (Exception e) {
                com.baidu.adp.lib.g.a.f(fileInputStream);
                return 2;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.f(fileInputStream);
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
            long pX = pX(order.getInt());
            i = order.getInt();
            if (i == fhD) {
                int cC = cC(pX);
                ByteBuffer order2 = ByteBuffer.allocate(cC).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                order2.put(order);
                if (fileChannel.read(order2) >= cC - 8) {
                    order2.flip();
                    if ((i == fhv && i != fhw && i != fhx && i != fhy && i != fhz && i != fhA && i != fhB && i != fhC && i != fhE && i != fhD) || pX < 8) {
                        break;
                    }
                    i2 = i;
                } else {
                    break;
                }
            } else {
                if (pX == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        break;
                    }
                    pX = cD(order.getLong());
                    fileChannel.position((fileChannel.position() + pX) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + pX) - 8);
                }
                if (i == fhv) {
                }
                i2 = i;
            }
        }
        return i != fhy ? 0 : 1;
    }

    public static void a(String str, String str2, final InterfaceC0189a interfaceC0189a) {
        if (interfaceC0189a != null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || !new File(str).exists()) {
                interfaceC0189a.jb(false);
            } else {
                new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.k.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Boolean doInBackground(String... strArr) {
                        if (strArr == null || strArr.length != 2) {
                            return false;
                        }
                        return Boolean.valueOf(a.bN(strArr[0], strArr[1]));
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onPostExecute(Boolean bool) {
                        super.onPostExecute((AnonymousClass2) bool);
                        if (InterfaceC0189a.this != null) {
                            InterfaceC0189a.this.jb(bool.booleanValue());
                        }
                    }
                }.execute(str, str2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=4] */
    public static boolean bN(String str, String str2) {
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
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    return a;
                } catch (Exception e) {
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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
            j2 = pX(order.getInt());
            i2 = order.getInt();
            if (i2 == fhD) {
                int cC = cC(j2);
                byteBuffer2 = ByteBuffer.allocate(cC).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer2.put(order);
                if (fileChannel.read(byteBuffer2) < cC - 8) {
                    long j5 = j3;
                    byteBuffer = byteBuffer2;
                    i = i2;
                    j = j5;
                    break;
                }
                byteBuffer2.flip();
                j3 = fileChannel.position();
                if (i2 == fhv && i2 != fhw && i2 != fhx && i2 != fhy && i2 != fhz && i2 != fhA && i2 != fhB && i2 != fhC && i2 != fhE && i2 != fhD) {
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
                    j2 = cD(order.getLong());
                    fileChannel.position((fileChannel.position() + j2) - 16);
                } else {
                    fileChannel.position((fileChannel.position() + j2) - 8);
                }
                if (i2 == fhv) {
                }
                if (j2 < 8) {
                }
            }
        }
        if (i != fhy) {
            return false;
        }
        int cC2 = cC(j2);
        long size = fileChannel.size() - cC2;
        ByteBuffer order2 = ByteBuffer.allocate(cC2).order(ByteOrder.BIG_ENDIAN);
        if (!a(fileChannel, order2, size)) {
            throw new RuntimeException("failed to read moov atom");
        }
        if (order2.getInt(12) == fhF) {
            throw new RuntimeException("this utility does not support compressed moov atoms yet");
        }
        while (order2.remaining() >= 8) {
            int position = order2.position();
            int i3 = order2.getInt(position + 4);
            if (i3 != fhG && i3 != fhH) {
                order2.position(order2.position() + 1);
            } else if (pX(order2.getInt(position)) > order2.remaining()) {
                throw new RuntimeException("bad atom size");
            } else {
                order2.position(position + 12);
                if (order2.remaining() < 4) {
                    throw new RuntimeException("malformed atom");
                }
                int cC3 = cC(order2.getInt());
                if (i3 == fhG) {
                    if (order2.remaining() < cC3 * 4) {
                        throw new RuntimeException("bad atom size/element count");
                    }
                    for (int i4 = 0; i4 < cC3; i4++) {
                        int i5 = order2.getInt(order2.position());
                        int i6 = i5 + cC2;
                        if (i5 < 0 && i6 >= 0) {
                            throw new RuntimeException("This is bug in original qt-faststart.c: stco atom should be extended to co64 atom as new offset value overflows uint32, but is not implemented.");
                        }
                        order2.putInt(i6);
                    }
                    continue;
                } else if (i3 != fhH) {
                    continue;
                } else if (order2.remaining() < cC3 * 8) {
                    throw new RuntimeException("bad atom size/element count");
                } else {
                    for (int i7 = 0; i7 < cC3; i7++) {
                        order2.putLong(order2.getLong(order2.position()) + cC2);
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

package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tieba.vq2;
import com.baidu.tieba.wq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public class uq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final AtomicInteger b;
    public static CharSequence c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ AtomicInteger d;
        public final /* synthetic */ AtomicInteger e;

        public a(File file, String str, byte[] bArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, bArr, atomicInteger, atomicInteger2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = str;
            this.c = bArr;
            this.d = atomicInteger;
            this.e = atomicInteger2;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    File file = new File(this.a, this.b);
                    if (file.exists()) {
                        if (file.length() == this.c.length) {
                            return;
                        }
                    }
                    zn4.m(file.getParentFile());
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(this.c);
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (Exception e) {
                        if (this.d != null) {
                            this.d.incrementAndGet();
                        }
                        v42.l("BundleDecrypt", "write file fail - " + file.getAbsolutePath(), e);
                    }
                } finally {
                    this.e.getAndDecrement();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = "";
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BufferedInputStream a;
        public int b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = -1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948219571, "Lcom/baidu/tieba/uq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948219571, "Lcom/baidu/tieba/uq2;");
                return;
            }
        }
        a = fo1.a;
        b = new AtomicInteger(0);
        c = "._";
        cr2.g0().getSwitch("swan_pkg_unzip_quickly", false);
        d = false;
    }

    public static void a(File file, String str, byte[] bArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, file, str, bArr, atomicInteger, atomicInteger2) == null) {
            xq2.a(new a(file, str, bArr, atomicInteger, atomicInteger2));
        }
    }

    public static boolean b(int i, @NonNull File file, int i2, @NonNull b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), file, Integer.valueOf(i2), bVar})) == null) {
            if (i > 0) {
                String str = i + " files write error";
                bVar.b = str;
                v42.k("BundleDecrypt", str);
                we3 we3Var = new we3();
                oj3 oj3Var = new oj3();
                oj3Var.k(4L);
                oj3Var.i(52L);
                we3Var.p(oj3Var);
                we3Var.l("path", file.getAbsolutePath());
                we3Var.l("eMsg", str);
                we3Var.l("decryptType", String.valueOf(i2));
                we3Var.l("stack", pl3.z(30));
                oe3.R(we3Var);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public static Pair<Boolean, File> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            File file = new File(cr2.c().getFilesDir(), "swan_tmp_unzip");
            zn4.l(file);
            File file2 = new File(file, System.nanoTime() + "_" + b.incrementAndGet());
            boolean l = zn4.l(file2);
            v42.k("BundleDecrypt", "#createTmpUnzipDir tmpUnzipDir=" + file2 + " dirExist=" + l);
            return new Pair<>(Boolean.valueOf(l), file2);
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03fc  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b d(BufferedInputStream bufferedInputStream, File file, int i) {
        InterceptResult invokeLLI;
        long j;
        DataInputStream dataInputStream;
        long j2;
        File file2;
        DataInputStream dataInputStream2;
        byte[] f;
        DataInputStream dataInputStream3;
        DataInputStream dataInputStream4;
        AtomicInteger atomicInteger;
        CountDownLatch countDownLatch;
        String str;
        ArrayList arrayList;
        String str2;
        String str3;
        long j3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedInputStream, file, i)) == null) {
            String str5 = " 耗时(ms): ";
            String str6 = "删除tmpUnzipDir ";
            String str7 = "BundleDecrypt";
            if (d) {
                v42.k("BundleDecrypt", "#decryptQuickly dstFolder=" + file + " type=" + i);
                return g(bufferedInputStream, file, i);
            }
            if (a) {
                j = System.nanoTime();
            } else {
                j = 0;
            }
            b bVar = new b(false);
            if (file != null && bufferedInputStream != null && i != 0) {
                vq2 vq2Var = new vq2();
                try {
                    dataInputStream2 = new DataInputStream(bufferedInputStream);
                    try {
                        try {
                            l(dataInputStream2);
                            vq2Var.a = l(dataInputStream2);
                            vq2Var.b = l(dataInputStream2);
                            l(dataInputStream2);
                            m(dataInputStream2);
                            dataInputStream2.readFully(vq2Var.c);
                            f = f(vq2Var.c);
                        } catch (Exception e) {
                            e = e;
                            j2 = j;
                        }
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            dataInputStream = dataInputStream2;
                            file2 = null;
                            try {
                                bVar.b = e.getLocalizedMessage();
                                v42.l(str7, "解压异常", e);
                                zn4.d(dataInputStream);
                                if (file2 != null) {
                                }
                                if (a) {
                                }
                                return bVar;
                            } catch (Throwable th) {
                                th = th;
                                zn4.d(dataInputStream);
                                if (file2 != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream = dataInputStream2;
                        file2 = null;
                        zn4.d(dataInputStream);
                        if (file2 != null) {
                            v42.k(str7, str6 + file2.getAbsolutePath());
                            zn4.L(file2);
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    j2 = j;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
                if (f != null && f.length > 0) {
                    byte[] bArr = new byte[vq2Var.b];
                    dataInputStream2.readFully(bArr);
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(f, 0, bArr2, 0, 16);
                    System.arraycopy(f, 16, bArr3, 0, 16);
                    byte[] e4 = e(bArr, bArr2, bArr3);
                    if (e4 != null && e4.length > 0) {
                        if (i == 2) {
                            try {
                                dataInputStream3 = new DataInputStream(cr2.j().a(new ByteArrayInputStream(e4)));
                                dataInputStream4 = new DataInputStream(cr2.j().a(dataInputStream2));
                            } catch (Exception e5) {
                                e = e5;
                                dataInputStream = dataInputStream2;
                                j2 = j;
                                file2 = null;
                                bVar.b = e.getLocalizedMessage();
                                v42.l(str7, "解压异常", e);
                                zn4.d(dataInputStream);
                                if (file2 != null) {
                                }
                                if (a) {
                                }
                                return bVar;
                            }
                        } else {
                            dataInputStream3 = new DataInputStream(new ByteArrayInputStream(e4));
                            dataInputStream4 = new DataInputStream(new GZIPInputStream(dataInputStream2));
                        }
                        DataInputStream dataInputStream5 = dataInputStream3;
                        DataInputStream dataInputStream6 = dataInputStream4;
                        if (!zn4.l(file)) {
                            String str8 = "解压目录创建失败 path=" + file.getAbsolutePath();
                            v42.k("BundleDecrypt", str8);
                            bVar.b = str8;
                            zn4.d(dataInputStream2);
                            return bVar;
                        }
                        Pair<Boolean, File> c2 = c();
                        if (!((Boolean) c2.first).booleanValue()) {
                            String str9 = "临时目录创建失败 path=" + ((File) c2.second).getAbsolutePath();
                            v42.k("BundleDecrypt", str9);
                            bVar.b = str9;
                            zn4.d(dataInputStream2);
                            return bVar;
                        }
                        File file3 = (File) c2.second;
                        try {
                            try {
                                atomicInteger = new AtomicInteger(0);
                                countDownLatch = new CountDownLatch(4);
                                j2 = j;
                                try {
                                    Handler[] handlerArr = new Handler[4];
                                    int i2 = 0;
                                    for (int i3 = 4; i2 < i3; i3 = 4) {
                                        String str10 = str5;
                                        try {
                                            wq2 wq2Var = new wq2("BundleDecrypt" + i2, file3, countDownLatch, atomicInteger);
                                            wq2Var.start();
                                            handlerArr[i2] = wq2Var.d();
                                            i2++;
                                            str5 = str10;
                                        } catch (Exception e6) {
                                            e = e6;
                                            dataInputStream = dataInputStream2;
                                            file2 = file3;
                                            str5 = str10;
                                            bVar.b = e.getLocalizedMessage();
                                            v42.l(str7, "解压异常", e);
                                            zn4.d(dataInputStream);
                                            if (file2 != null) {
                                                v42.k(str7, str6 + file2.getAbsolutePath());
                                                zn4.L(file2);
                                            }
                                            if (a) {
                                            }
                                            return bVar;
                                        }
                                    }
                                    str = str5;
                                    try {
                                        arrayList = new ArrayList();
                                        int i4 = 0;
                                        while (i4 < vq2Var.a) {
                                            try {
                                                vq2.a r = r(dataInputStream5);
                                                vq2 vq2Var2 = vq2Var;
                                                String str11 = str7;
                                                try {
                                                    if (r.c.contains(c)) {
                                                        dataInputStream6.skipBytes(r.a);
                                                        str4 = str6;
                                                    } else {
                                                        byte[] bArr4 = new byte[r.a];
                                                        dataInputStream6.readFully(bArr4);
                                                        Message obtain = Message.obtain();
                                                        str4 = str6;
                                                        try {
                                                            wq2.b bVar2 = new wq2.b();
                                                            bVar2.b = bArr4;
                                                            bVar2.a = r.c;
                                                            obtain.what = 100;
                                                            obtain.obj = bVar2;
                                                            handlerArr[i4 % 4].sendMessage(obtain);
                                                            arrayList.add(r);
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            for (int i5 = 0; i5 < 4; i5++) {
                                                                handlerArr[i5].sendEmptyMessage(200);
                                                            }
                                                            countDownLatch.await();
                                                            zn4.d(dataInputStream5);
                                                            zn4.d(dataInputStream6);
                                                            throw th;
                                                        }
                                                    }
                                                    i4++;
                                                    vq2Var = vq2Var2;
                                                    str7 = str11;
                                                    str6 = str4;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                        }
                                        str2 = str6;
                                        str3 = str7;
                                        int i6 = 0;
                                        for (int i7 = 4; i6 < i7; i7 = 4) {
                                            try {
                                                handlerArr[i6].sendEmptyMessage(200);
                                                i6++;
                                            } catch (Exception e7) {
                                                e = e7;
                                                dataInputStream = dataInputStream2;
                                                file2 = file3;
                                                str5 = str;
                                                str7 = str3;
                                                str6 = str2;
                                                bVar.b = e.getLocalizedMessage();
                                                v42.l(str7, "解压异常", e);
                                                zn4.d(dataInputStream);
                                                if (file2 != null) {
                                                }
                                                if (a) {
                                                }
                                                return bVar;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                dataInputStream = dataInputStream2;
                                                file2 = file3;
                                                str7 = str3;
                                                str6 = str2;
                                                zn4.d(dataInputStream);
                                                if (file2 != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        str5 = str;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            j2 = j;
                        }
                        try {
                            countDownLatch.await();
                            zn4.d(dataInputStream5);
                            zn4.d(dataInputStream6);
                        } catch (Exception e11) {
                            e = e11;
                            str5 = str;
                            str7 = str3;
                            str6 = str2;
                            dataInputStream = dataInputStream2;
                            file2 = file3;
                            bVar.b = e.getLocalizedMessage();
                            v42.l(str7, "解压异常", e);
                            zn4.d(dataInputStream);
                            if (file2 != null) {
                            }
                            if (a) {
                            }
                            return bVar;
                        } catch (Throwable th9) {
                            th = th9;
                            str7 = str3;
                            str6 = str2;
                            dataInputStream = dataInputStream2;
                            file2 = file3;
                            zn4.d(dataInputStream);
                            if (file2 != null) {
                            }
                            throw th;
                        }
                        if (b(atomicInteger.get(), file, i, bVar)) {
                            zn4.d(dataInputStream2);
                            if (file3 != null) {
                                v42.k(str3, str2 + file3.getAbsolutePath());
                                zn4.L(file3);
                            }
                            return bVar;
                        }
                        str7 = str3;
                        str6 = str2;
                        if (!n(arrayList, file3, i)) {
                            String str12 = "解压后校验失败 tmpUnzipDir=" + file3;
                            v42.k(str7, str12);
                            bVar.b = str12;
                            zn4.d(dataInputStream2);
                            if (file3 != null) {
                                v42.k(str7, str6 + file3.getAbsolutePath());
                                zn4.L(file3);
                            }
                            return bVar;
                        }
                        if (a) {
                            j3 = System.nanoTime();
                        } else {
                            j3 = 0;
                        }
                        boolean q = q(file3, file, arrayList);
                        if (a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("#moveToDestDir dstFolder=");
                            sb.append(file.getAbsolutePath());
                            sb.append(" moveRes=");
                            sb.append(q);
                            sb.append(" fileCount=");
                            sb.append(arrayList.size());
                            str5 = str;
                            sb.append(str5);
                            sb.append((System.nanoTime() - j3) / 1000000.0d);
                            Log.i(str7, sb.toString());
                        } else {
                            str5 = str;
                        }
                        if (!q) {
                            String str13 = "解压后rename失败 dstFolder=" + file;
                            v42.k(str7, str13);
                            bVar.b = str13;
                            zn4.d(dataInputStream2);
                            if (file3 != null) {
                                v42.k(str7, str6 + file3.getAbsolutePath());
                                zn4.L(file3);
                            }
                            return bVar;
                        }
                        bVar.a = true;
                        zn4.d(dataInputStream2);
                        if (file3 != null) {
                            v42.k(str7, str6 + file3.getAbsolutePath());
                            zn4.L(file3);
                        }
                        if (a) {
                            Log.i(str7, "#decrypt dstFolder=" + file.getAbsolutePath() + str5 + ((System.nanoTime() - j2) / 1000000.0d));
                        }
                        return bVar;
                    }
                    v42.k("BundleDecrypt", "index array length <= 0");
                    bVar.b = "index array length <= 0";
                    zn4.d(dataInputStream2);
                    return bVar;
                }
                v42.k("BundleDecrypt", "cipher is null");
                bVar.b = "cipher is null";
                zn4.d(dataInputStream2);
                return bVar;
            }
            return bVar;
        }
        return (b) invokeLLI.objValue;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, bArr, bArr2, bArr3)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                if (a) {
                    Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, o());
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                if (a) {
                    Log.e("BundleDecrypt", "decypt cipher fail", e);
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static vq2.a r(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, dataInputStream)) == null) {
            vq2.a aVar = new vq2.a();
            l(dataInputStream);
            aVar.a = l(dataInputStream);
            int l = l(dataInputStream);
            aVar.b = l;
            byte[] bArr = new byte[l];
            dataInputStream.readFully(bArr);
            aVar.c = new String(bArr, IMAudioTransRequest.CHARSET);
            return aVar;
        }
        return (vq2.a) invokeL.objValue;
    }

    public static b g(BufferedInputStream bufferedInputStream, File file, int i) {
        InterceptResult invokeLLI;
        DataInputStream dataInputStream;
        byte[] f;
        DataInputStream dataInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, bufferedInputStream, file, i)) == null) {
            b bVar = new b(false);
            if (file != null && bufferedInputStream != null && i != 0) {
                vq2 vq2Var = new vq2();
                DataInputStream dataInputStream3 = null;
                try {
                    try {
                        dataInputStream = new DataInputStream(bufferedInputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    l(dataInputStream);
                    vq2Var.a = l(dataInputStream);
                    vq2Var.b = l(dataInputStream);
                    l(dataInputStream);
                    m(dataInputStream);
                    dataInputStream.readFully(vq2Var.c);
                    f = f(vq2Var.c);
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream3 = dataInputStream;
                    bVar.b = e.getLocalizedMessage();
                    v42.l("BundleDecrypt", "解压异常 dstFolder=" + file, e);
                    zn4.d(dataInputStream3);
                    return bVar;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream3 = dataInputStream;
                    zn4.d(dataInputStream3);
                    throw th;
                }
                if (f != null && f.length > 0) {
                    byte[] bArr = new byte[vq2Var.b];
                    dataInputStream.readFully(bArr);
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(f, 0, bArr2, 0, 16);
                    System.arraycopy(f, 16, bArr3, 0, 16);
                    byte[] e3 = e(bArr, bArr2, bArr3);
                    if (e3 != null && e3.length > 0) {
                        if (i == 2) {
                            dataInputStream3 = new DataInputStream(cr2.j().a(new ByteArrayInputStream(e3)));
                            dataInputStream2 = new DataInputStream(cr2.j().a(dataInputStream));
                        } else {
                            dataInputStream3 = new DataInputStream(new ByteArrayInputStream(e3));
                            dataInputStream2 = new DataInputStream(new GZIPInputStream(dataInputStream));
                        }
                        if (!zn4.m(file)) {
                            String str = "解压目录创建失败 path=" + file.getAbsolutePath();
                            v42.k("BundleDecrypt", str);
                            bVar.b = str;
                            zn4.d(dataInputStream);
                            return bVar;
                        }
                        AtomicInteger atomicInteger = new AtomicInteger(0);
                        AtomicInteger atomicInteger2 = new AtomicInteger(vq2Var.a);
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < vq2Var.a; i2++) {
                            try {
                                vq2.a r = r(dataInputStream3);
                                if (r.c.contains(c)) {
                                    atomicInteger2.getAndDecrement();
                                    dataInputStream2.skipBytes(r.a);
                                } else {
                                    byte[] bArr4 = new byte[r.a];
                                    dataInputStream2.readFully(bArr4);
                                    a(file, r.c, bArr4, atomicInteger, atomicInteger2);
                                    arrayList.add(r);
                                }
                            } catch (Throwable th3) {
                                atomicInteger2.set(0);
                                zn4.d(dataInputStream3);
                                zn4.d(dataInputStream2);
                                throw th3;
                            }
                        }
                        while (atomicInteger2.get() > 0) {
                            TimeUnit.MILLISECONDS.sleep(1L);
                        }
                        atomicInteger2.set(0);
                        zn4.d(dataInputStream3);
                        zn4.d(dataInputStream2);
                        if (b(atomicInteger.get(), file, i, bVar)) {
                            zn4.d(dataInputStream);
                            return bVar;
                        } else if (!n(arrayList, file, i)) {
                            String str2 = "解压后校验失败 dstFolder=" + file;
                            v42.k("BundleDecrypt", str2);
                            bVar.b = str2;
                            zn4.d(dataInputStream);
                            return bVar;
                        } else {
                            bVar.a = true;
                            zn4.d(dataInputStream);
                            return bVar;
                        }
                    }
                    v42.k("BundleDecrypt", "index array length <= 0");
                    bVar.b = "index array length <= 0";
                    zn4.d(dataInputStream);
                    return bVar;
                }
                v42.k("BundleDecrypt", "cipher is null");
                bVar.b = "cipher is null";
                zn4.d(dataInputStream);
                return bVar;
            }
            return bVar;
        }
        return (b) invokeLLI.objValue;
    }

    public static void h(int i) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i) == null) {
            File file = new File(k());
            FileWriter fileWriter2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                fileWriter.write(String.valueOf(i));
                fileWriter.write(44);
                zn4.d(fileWriter);
            } catch (IOException e2) {
                e = e2;
                fileWriter2 = fileWriter;
                if (a) {
                    e.printStackTrace();
                }
                zn4.d(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                zn4.d(fileWriter2);
                throw th;
            }
        }
    }

    public static c i(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bufferedInputStream)) == null) {
            c cVar = new c();
            cVar.a = bufferedInputStream;
            bufferedInputStream.mark(8);
            int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
            if (read == -1122498812) {
                cVar.b = 1;
            } else if (read == -1122434039) {
                cVar.b = 2;
            } else {
                bufferedInputStream.reset();
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c j(File file) {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            c cVar = new c();
            if (file != null && file.exists()) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                }
                try {
                    read = bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (a) {
                        Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    }
                    bufferedInputStream = bufferedInputStream2;
                    zn4.d(bufferedInputStream);
                    return cVar;
                }
                if (read == -1122498812) {
                    cVar.a = bufferedInputStream;
                    cVar.b = 1;
                    return cVar;
                }
                if (read == -1122434039) {
                    cVar.a = bufferedInputStream;
                    cVar.b = 2;
                    return cVar;
                }
                zn4.d(bufferedInputStream);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new File(ns2.d().get(0).a, "/decryptLog.csv").getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static int l(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, dataInputStream)) == null) {
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
        return invokeL.intValue;
    }

    public static long m(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, dataInputStream)) == null) {
            byte[] bArr = new byte[8];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
        }
        return invokeL.longValue;
    }

    public static boolean n(List<vq2.a> list, File file, int i) {
        InterceptResult invokeLLI;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, list, file, i)) == null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            for (vq2.a aVar : list) {
                File file2 = new File(file, aVar.c);
                if (!file2.exists() || (file2.isFile() && file2.length() != aVar.a)) {
                    v42.k("BundleDecrypt", "decrypt：unpack file " + aVar.c + " fail");
                    we3 we3Var = new we3();
                    oj3 oj3Var = new oj3();
                    oj3Var.k(4L);
                    oj3Var.i(52L);
                    we3Var.p(oj3Var);
                    we3Var.l("path", file2.getAbsolutePath());
                    we3Var.l("eMsg", "decrypt files not match encrypt content");
                    we3Var.l("decryptType", String.valueOf(i));
                    we3Var.l("stack", pl3.z(30));
                    oe3.R(we3Var);
                    return false;
                }
            }
            if (a) {
                Log.d("BundleDecrypt", "check all files valid cost - " + (System.currentTimeMillis() - j) + "ms");
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static PublicKey o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes(IMAudioTransRequest.CHARSET), 0)));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                if (a) {
                    Log.e("BundleDecrypt", e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (PublicKey) invokeV.objValue;
    }

    public static boolean p(@NonNull File file, @NonNull File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, file, file2)) == null) {
            if (file2.exists()) {
                if (file.length() != file2.length() && !file.renameTo(file2)) {
                    return false;
                }
                return true;
            }
            file2.getParentFile().mkdirs();
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(File file, File file2, List<vq2.a> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, file, file2, list)) == null) {
            if (file == null || file2 == null || list == null || !file.isDirectory() || !file2.isDirectory()) {
                return false;
            }
            for (vq2.a aVar : list) {
                String str = aVar.c;
                File file3 = new File(file, str);
                File file4 = new File(file2, str);
                if (!p(file3, file4)) {
                    v42.k("BundleDecrypt", "#moveFile fail src=" + file3.getAbsolutePath() + "dst=" + file4.getAbsolutePath());
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

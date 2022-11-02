package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class lc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ic a;
    public AtomicBoolean b;
    public DiskFileOperate c;

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(lc lcVar, DiskFileOperate diskFileOperate, ic icVar);
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(256523577, "Lcom/baidu/tieba/lc$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(256523577, "Lcom/baidu/tieba/lc$a;");
                    return;
                }
            }
            int[] iArr = new int[DiskFileOperate.Action.values().length];
            a = iArr;
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DiskFileOperate.Action.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DiskFileOperate.Action.APPEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[DiskFileOperate.Action.INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[DiskFileOperate.Action.RENAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[DiskFileOperate.Action.READ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public lc(ic icVar, DiskFileOperate diskFileOperate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {icVar, diskFileOperate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        if (icVar != null && diskFileOperate != null && diskFileOperate.getAction() != null) {
            this.b = new AtomicBoolean(false);
            this.a = icVar;
            this.c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskWorker Parameter is null");
    }

    private boolean delete() {
        InterceptResult invokeV;
        File c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            boolean z = false;
            try {
                try {
                    c = this.a.c(this.c.buildPath(), this.c.getName(), false, this.c.isSdCard(), this.c.isSavedCache());
                } catch (Exception e) {
                    e.getMessage();
                }
                if (c != null && !this.b.get()) {
                    if (c.exists()) {
                        z = c.delete();
                    }
                    if (z) {
                        this.c.setFileInfo(c);
                        this.c.setSuccess(true);
                    }
                    return z;
                }
                return false;
            } finally {
                this.c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            switch (a.a[this.c.getAction().ordinal()]) {
                case 1:
                    return i(false);
                case 2:
                    return i(true);
                case 3:
                    return delete();
                case 4:
                    return e();
                case 5:
                    return a(false);
                case 6:
                    return a(true);
                case 7:
                    return f();
                case 8:
                    return h();
                case 9:
                    return g();
                case 10:
                    return c();
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        File d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c.getName() != null) {
                d = this.a.c(this.c.buildPath(), this.c.getName(), false, this.c.isSdCard(), this.c.isSavedCache());
            } else {
                d = this.a.d(this.c.buildPath(), false, this.c.isSdCard(), this.c.isSavedCache());
            }
            if (d != null && d.exists()) {
                this.c.setFileInfo(d);
                this.c.setSuccess(true);
                this.c.unLock();
                return true;
            }
            this.c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            boolean z = false;
            try {
                try {
                    File c = this.a.c(this.c.buildPath(), this.c.getName(), false, this.c.isSdCard(), this.c.isSavedCache());
                    File c2 = this.a.c(this.c.buildDesPath(), this.c.getDesName(), true, this.c.isSdCard(), this.c.isSavedCache());
                    if (c != null) {
                        if (c2 != null) {
                            c2.delete();
                        }
                        z = c.renameTo(c2);
                    }
                    if (z) {
                        this.c.setSuccess(true);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                return z;
            } finally {
                this.c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            OutputStream outputStream = this.c.getOutputStream();
            File fileInfo = this.c.getFileInfo();
            try {
                if (outputStream == null) {
                    try {
                        fileInfo = this.a.c(this.c.buildPath(), this.c.getName(), true, this.c.isSdCard(), this.c.isSavedCache());
                        if (fileInfo != null && !this.b.get()) {
                            outputStream = new FileOutputStream(fileInfo, true);
                        }
                        this.c.unLock();
                        return false;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        if (!z) {
                            vg.d(outputStream);
                        }
                        this.c.unLock();
                        return false;
                    }
                }
                byte[] buildFormatData = this.c.buildFormatData();
                byte[] data = this.c.getData();
                if ((buildFormatData == null && data == null) || this.b.get()) {
                    if (!z) {
                        vg.d(outputStream);
                    }
                    this.c.unLock();
                    return false;
                }
                if (buildFormatData != null) {
                    outputStream.write(buildFormatData);
                }
                if (data != null) {
                    outputStream.write(data);
                }
                outputStream.flush();
                this.c.setFileInfo(fileInfo);
                this.c.setSuccess(true);
                if (!z) {
                    vg.d(outputStream);
                } else {
                    this.c.setOutputStream(outputStream);
                }
                this.c.unLock();
                return true;
            } catch (Throwable th) {
                if (!z) {
                    vg.d(outputStream);
                }
                this.c.unLock();
                throw th;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File c = this.a.c(this.c.buildPath(), this.c.getName(), true, this.c.isSdCard(), this.c.isSavedCache());
                    if (c != null && !this.b.get()) {
                        if (c.exists()) {
                            if (z) {
                                c.delete();
                            } else {
                                vg.d(null);
                                this.c.unLock();
                                return true;
                            }
                        }
                        byte[] buildFormatData = this.c.buildFormatData();
                        byte[] data = this.c.getData();
                        if ((buildFormatData != null || data != null) && !this.b.get()) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(c);
                            if (buildFormatData != null) {
                                try {
                                    fileOutputStream2.write(buildFormatData);
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream = fileOutputStream2;
                                    BdLog.e(e.getMessage());
                                    vg.d(fileOutputStream);
                                    this.c.unLock();
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    vg.d(fileOutputStream);
                                    this.c.unLock();
                                    throw th;
                                }
                            }
                            if (data != null) {
                                fileOutputStream2.write(data);
                            }
                            fileOutputStream2.flush();
                            vg.d(fileOutputStream2);
                            this.c.setFileInfo(c);
                            this.c.setSuccess(true);
                            this.c.unLock();
                            return true;
                        }
                    }
                    vg.d(null);
                    this.c.unLock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return invokeZ.booleanValue;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.set(true);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = false;
            try {
                try {
                    if (this.c.getCustomOperate() != null) {
                        z = this.c.getCustomOperate().a(this, this.c, this.a);
                    }
                    if (z) {
                        this.c.setSuccess(true);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                return z;
            } finally {
                this.c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = false;
            try {
                try {
                    File d = this.a.d(this.c.getPath(), false, this.c.isSdCard(), this.c.isSavedCache());
                    z = d(d);
                    if (z) {
                        this.c.setFileInfo(d);
                        this.c.setSuccess(true);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                return z;
            } finally {
                this.c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) {
            if (file != null) {
                DiskFileOperate diskFileOperate = this.c;
                if (diskFileOperate instanceof hc) {
                    hc hcVar = (hc) diskFileOperate;
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (int i = 0; i < listFiles.length && !this.b.get(); i++) {
                                if (listFiles[i].isDirectory()) {
                                    d(listFiles[i]);
                                } else if (hcVar.compare(listFiles[i])) {
                                    listFiles[i].delete();
                                }
                            }
                        }
                        file.delete();
                    } else if (hcVar.compare(file)) {
                        file.delete();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        File c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.c.startLog();
            boolean z = false;
            try {
                c = this.a.c(this.c.buildPath(), this.c.getName(), false, this.c.isSdCard(), this.c.isSavedCache());
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            if (c != null && c.exists() && !this.b.get()) {
                fileInputStream = new FileInputStream(c);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read == -1 || this.b.get()) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (!this.b.get()) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!this.c.isFormatData() || this.c.formatData(byteArray)) {
                                    this.c.setData(byteArray);
                                    z = true;
                                }
                            }
                            vg.c(fileInputStream);
                            vg.d(byteArrayOutputStream);
                            if (z) {
                                this.c.setSuccess(true);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.e(e.getMessage());
                            vg.c(fileInputStream);
                            vg.d(byteArrayOutputStream);
                            this.c.unLock();
                            this.c.endLog();
                            return z;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        vg.c(fileInputStream);
                        vg.d(byteArrayOutputStream);
                        this.c.unLock();
                        throw th;
                    }
                } catch (Exception e4) {
                    byteArrayOutputStream = null;
                    e = e4;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    th = th;
                    vg.c(fileInputStream);
                    vg.d(byteArrayOutputStream);
                    this.c.unLock();
                    throw th;
                }
                this.c.unLock();
                this.c.endLog();
                return z;
            }
            vg.c(null);
            vg.d(null);
            this.c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }
}

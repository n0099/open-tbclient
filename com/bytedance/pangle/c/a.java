package com.bytedance.pangle.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import androidx.multidex.MultiDexExtractor;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.k;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes4.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;
    public final long b;
    public final File c;
    public final RandomAccessFile d;
    public final FileChannel e;
    public final FileLock f;

    /* renamed from: com.bytedance.pangle.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0259a extends File {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0259a(File file, String str) {
            super(file, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((File) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1L;
        }
    }

    public a(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, file2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor(" + file.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getPath() + SmallTailInfo.EMOTION_SUFFIX);
        this.a = file;
        this.c = file2;
        this.b = b(file);
        File file3 = new File(file2, MultiDexExtractor.LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.d = randomAccessFile;
        try {
            this.e = randomAccessFile.getChannel();
            try {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Blocking on lock " + file3.getPath());
                this.f = this.e.lock();
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex " + file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                a(this.e);
                throw e;
            } catch (Error e2) {
                e = e2;
                a(this.e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                a(this.e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            a(this.d);
            throw e4;
        }
    }

    public static long b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            long a = k.a(file);
            return a == -1 ? a - 1 : a;
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<? extends File> a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        List<C0259a> list;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, str, z)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor.load(" + this.a.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + SmallTailInfo.EMOTION_SUFFIX);
            if (this.f.isValid()) {
                if (!z) {
                    File file = this.a;
                    long j = this.b;
                    SharedPreferences a = a(context);
                    if (a.getLong(str + "timestamp", -1L) == a(file)) {
                        if (a.getLong(str + MultiDexExtractor.KEY_CRC, -1L) == j) {
                            z2 = false;
                            if (!z2) {
                                try {
                                    list = a(context, str);
                                } catch (IOException e) {
                                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                                }
                                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex load found " + list.size() + " secondary dex files");
                                return list;
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                if (z) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Forced extraction must be performed.");
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Detected that extraction must be performed.");
                }
                List<C0259a> a2 = a();
                a(context, str, a(this.a), this.b, a2);
                list = a2;
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex load found " + list.size() + " secondary dex files");
                return list;
            }
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        return (List) invokeLLZ.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.release();
            this.e.close();
            this.d.close();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            File[] listFiles = this.c.listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? !file.getName().equals(MultiDexExtractor.LOCK_FILENAME) : invokeL.booleanValue;
                }
            });
            if (listFiles == null) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + this.c.getPath() + ").");
                return;
            }
            for (File file : listFiles) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Trying to delete old file " + file.getPath() + " of size " + file.length());
                if (file.delete()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old file " + file.getPath());
                } else {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete old file " + file.getPath());
                }
            }
        }
    }

    private List<C0259a> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex loading existing secondary dex files");
            String str2 = this.a.getName() + ".classes";
            SharedPreferences a = a(context);
            int i = a.getInt(str + "dex.number", 1);
            ArrayList arrayList = new ArrayList(i + (-1));
            int i2 = 2;
            while (i2 <= i) {
                C0259a c0259a = new C0259a(this.c, str2 + i2 + ".zip");
                if (c0259a.isFile()) {
                    c0259a.a = b(c0259a);
                    long j = a.getLong(str + MultiDexExtractor.KEY_DEX_CRC + i2, -1L);
                    long j2 = a.getLong(str + MultiDexExtractor.KEY_DEX_TIME + i2, -1L);
                    long lastModified = c0259a.lastModified();
                    if (j2 == lastModified) {
                        String str3 = str2;
                        SharedPreferences sharedPreferences = a;
                        if (j == c0259a.a) {
                            arrayList.add(c0259a);
                            i2++;
                            a = sharedPreferences;
                            str2 = str3;
                        }
                    }
                    throw new IOException("Invalid extracted dex: " + c0259a + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + c0259a.a);
                }
                throw new IOException("Missing extracted secondary dex file '" + c0259a.getPath() + "'");
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            long lastModified = file.lastModified();
            return lastModified == -1 ? lastModified - 1 : lastModified;
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x012c, code lost:
        throw new java.io.IOException("Could not create zip file " + r8.getAbsolutePath() + " for secondary dex (" + r5 + com.baidu.tbadk.core.data.SmallTailInfo.EMOTION_SUFFIX);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<C0259a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, this)) != null) {
            return (List) invokeV.objValue;
        }
        String str = this.a.getName() + ".classes";
        b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry == null) {
                    return arrayList;
                }
                C0259a c0259a = new C0259a(this.c, str + i + ".zip");
                arrayList.add(c0259a);
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Extraction is needed for file ".concat(String.valueOf(c0259a)));
                int i2 = 0;
                boolean z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    a(zipFile, entry, c0259a, str);
                    try {
                        c0259a.a = b(c0259a);
                        z = true;
                    } catch (IOException e) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to read crc from " + c0259a.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder("PluginMultiDex Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0259a.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0259a.length());
                    sb.append(" - crc: ");
                    sb.append(c0259a.a);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
                    if (!z) {
                        c0259a.delete();
                        if (c0259a.exists()) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete corrupted secondary dex '" + c0259a.getPath() + "'");
                        }
                    }
                }
                if (!z) {
                    break;
                }
                i++;
                str2 = MultiDexExtractor.DEX_PREFIX + i + ".dex";
            } finally {
                try {
                    zipFile.close();
                } catch (IOException e2) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e2);
                }
            }
        }
    }

    public static void a(Context context, String str, long j, long j2, List<C0259a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Long.valueOf(j), Long.valueOf(j2), list}) == null) {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putLong(str + "timestamp", j);
            edit.putLong(str + MultiDexExtractor.KEY_CRC, j2);
            edit.putInt(str + "dex.number", list.size() + 1);
            int i = 2;
            for (C0259a c0259a : list) {
                edit.putLong(str + MultiDexExtractor.KEY_DEX_CRC + i, c0259a.a);
                edit.putLong(str + MultiDexExtractor.KEY_DEX_TIME + i, c0259a.lastModified());
                i++;
            }
            edit.commit();
        }
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, zipFile, zipEntry, file, str) == null) {
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".zip", file.getParentFile());
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Extracting " + createTempFile.getPath());
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Renaming to " + file.getPath());
                    if (createTempFile.renameTo(file)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } finally {
                a(inputStream);
                createTempFile.delete();
            }
        }
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, closeable) == null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e);
            }
        }
    }
}

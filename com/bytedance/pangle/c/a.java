package com.bytedance.pangle.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import androidx.multidex.MultiDexExtractor;
import com.alipay.sdk.util.f;
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
/* loaded from: classes2.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final long f52970b;

    /* renamed from: c  reason: collision with root package name */
    public final File f52971c;

    /* renamed from: d  reason: collision with root package name */
    public final RandomAccessFile f52972d;

    /* renamed from: e  reason: collision with root package name */
    public final FileChannel f52973e;

    /* renamed from: f  reason: collision with root package name */
    public final FileLock f52974f;

    /* renamed from: com.bytedance.pangle.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2032a extends File {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2032a(File file, String str) {
            super(file, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor(" + file.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getPath() + SmallTailInfo.EMOTION_SUFFIX);
        this.a = file;
        this.f52971c = file2;
        this.f52970b = b(file);
        File file3 = new File(file2, MultiDexExtractor.LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f52972d = randomAccessFile;
        try {
            this.f52973e = randomAccessFile.getChannel();
            try {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Blocking on lock " + file3.getPath());
                this.f52974f = this.f52973e.lock();
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex " + file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                a(this.f52973e);
                throw e;
            } catch (Error e3) {
                e = e3;
                a(this.f52973e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                a(this.f52973e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a(this.f52972d);
            throw e5;
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
        List<C2032a> list;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, str, z)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor.load(" + this.a.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + SmallTailInfo.EMOTION_SUFFIX);
            if (this.f52974f.isValid()) {
                if (!z) {
                    File file = this.a;
                    long j2 = this.f52970b;
                    SharedPreferences a = a(context);
                    if (a.getLong(str + "timestamp", -1L) == a(file)) {
                        if (a.getLong(str + MultiDexExtractor.KEY_CRC, -1L) == j2) {
                            z2 = false;
                            if (!z2) {
                                try {
                                    list = a(context, str);
                                } catch (IOException e2) {
                                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
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
                List<C2032a> a2 = a();
                a(context, str, a(this.a), this.f52970b, a2);
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
            this.f52974f.release();
            this.f52973e.close();
            this.f52972d.close();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            File[] listFiles = this.f52971c.listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.c.a.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + this.f52971c.getPath() + ").");
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

    private List<C2032a> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex loading existing secondary dex files");
            String str2 = this.a.getName() + ".classes";
            SharedPreferences a = a(context);
            int i2 = a.getInt(str + "dex.number", 1);
            ArrayList arrayList = new ArrayList(i2 + (-1));
            int i3 = 2;
            while (i3 <= i2) {
                C2032a c2032a = new C2032a(this.f52971c, str2 + i3 + ".zip");
                if (c2032a.isFile()) {
                    c2032a.a = b(c2032a);
                    long j2 = a.getLong(str + MultiDexExtractor.KEY_DEX_CRC + i3, -1L);
                    long j3 = a.getLong(str + MultiDexExtractor.KEY_DEX_TIME + i3, -1L);
                    long lastModified = c2032a.lastModified();
                    if (j3 == lastModified) {
                        String str3 = str2;
                        SharedPreferences sharedPreferences = a;
                        if (j2 == c2032a.a) {
                            arrayList.add(c2032a);
                            i3++;
                            a = sharedPreferences;
                            str2 = str3;
                        }
                    }
                    throw new IOException("Invalid extracted dex: " + c2032a + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + c2032a.a);
                }
                throw new IOException("Missing extracted secondary dex file '" + c2032a.getPath() + "'");
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
    private List<C2032a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, this)) != null) {
            return (List) invokeV.objValue;
        }
        String str = this.a.getName() + ".classes";
        b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        int i2 = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry == null) {
                    return arrayList;
                }
                C2032a c2032a = new C2032a(this.f52971c, str + i2 + ".zip");
                arrayList.add(c2032a);
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Extraction is needed for file ".concat(String.valueOf(c2032a)));
                int i3 = 0;
                boolean z = false;
                while (i3 < 3 && !z) {
                    i3++;
                    a(zipFile, entry, c2032a, str);
                    try {
                        c2032a.a = b(c2032a);
                        z = true;
                    } catch (IOException e2) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to read crc from " + c2032a.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder("PluginMultiDex Extraction ");
                    sb.append(z ? "succeeded" : f.f30928j);
                    sb.append(" '");
                    sb.append(c2032a.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c2032a.length());
                    sb.append(" - crc: ");
                    sb.append(c2032a.a);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
                    if (!z) {
                        c2032a.delete();
                        if (c2032a.exists()) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete corrupted secondary dex '" + c2032a.getPath() + "'");
                        }
                    }
                }
                if (!z) {
                    break;
                }
                i2++;
                str2 = MultiDexExtractor.DEX_PREFIX + i2 + ".dex";
            } finally {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e3);
                }
            }
        }
    }

    public static void a(Context context, String str, long j2, long j3, List<C2032a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Long.valueOf(j2), Long.valueOf(j3), list}) == null) {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putLong(str + "timestamp", j2);
            edit.putLong(str + MultiDexExtractor.KEY_CRC, j3);
            edit.putInt(str + "dex.number", list.size() + 1);
            int i2 = 2;
            for (C2032a c2032a : list) {
                edit.putLong(str + MultiDexExtractor.KEY_DEX_CRC + i2, c2032a.a);
                edit.putLong(str + MultiDexExtractor.KEY_DEX_TIME + i2, c2032a.lastModified());
                i2++;
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
            } catch (IOException e2) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e2);
            }
        }
    }
}

package com.bumptech.glide.disklrucache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class DiskLruCache implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public final int appVersion;
    public final Callable<Void> cleanupCallable;
    public final File directory;
    public final ThreadPoolExecutor executorService;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public Writer journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries;
    public long maxSize;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;

    /* loaded from: classes4.dex */
    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DiskLruCacheThreadFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Thread thread;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                synchronized (this) {
                    thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                    thread.setPriority(1);
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean committed;
        public final Entry entry;
        public final /* synthetic */ DiskLruCache this$0;
        public final boolean[] written;

        private InputStream newInputStream(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor == this) {
                        if (this.entry.readable) {
                            try {
                                return new FileInputStream(this.entry.getCleanFile(i));
                            } catch (FileNotFoundException unused) {
                                return null;
                            }
                        }
                        return null;
                    }
                    throw new IllegalStateException();
                }
            }
            return (InputStream) invokeI.objValue;
        }

        public void abort() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.completeEdit(this, false);
            }
        }

        public void abortUnlessCommitted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.committed) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        public void commit() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.completeEdit(this, true);
                this.committed = true;
            }
        }

        public File getFile(int i) throws IOException {
            InterceptResult invokeI;
            File dirtyFile;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor == this) {
                        if (!this.entry.readable) {
                            this.written[i] = true;
                        }
                        dirtyFile = this.entry.getDirtyFile(i);
                        if (!this.this$0.directory.exists()) {
                            this.this$0.directory.mkdirs();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return dirtyFile;
            }
            return (File) invokeI.objValue;
        }

        public String getString(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                InputStream newInputStream = newInputStream(i);
                if (newInputStream != null) {
                    return DiskLruCache.inputStreamToString(newInputStream);
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public void set(int i, String str) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048581, this, i, str) != null) {
                return;
            }
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(getFile(i)), Util.UTF_8);
                try {
                    outputStreamWriter2.write(str);
                    Util.closeQuietly(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[diskLruCache.valueCount];
        }
    }

    /* loaded from: classes4.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File[] cleanFiles;
        public Editor currentEditor;
        public File[] dirtyFiles;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        private IOException invalidLengths(String[] strArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, strArr) == null) {
                if (strArr.length == this.this$0.valueCount) {
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            this.lengths[i] = Long.parseLong(strArr[i]);
                        } catch (NumberFormatException unused) {
                            throw invalidLengths(strArr);
                        }
                    }
                    return;
                }
                throw invalidLengths(strArr);
            }
        }

        public File getCleanFile(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.cleanFiles[i] : (File) invokeI.objValue;
        }

        public File getDirtyFile(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.dirtyFiles[i] : (File) invokeI.objValue;
        }

        public String getLengths() throws IOException {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.lengths) {
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public Entry(DiskLruCache diskLruCache, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.valueCount];
            this.cleanFiles = new File[diskLruCache.valueCount];
            this.dirtyFiles = new File[diskLruCache.valueCount];
            StringBuilder sb = new StringBuilder(str);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i3 = 0; i3 < diskLruCache.valueCount; i3++) {
                sb.append(i3);
                this.cleanFiles[i3] = new File(diskLruCache.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i3] = new File(diskLruCache.directory, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class Value {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final File[] files;
        public final String key;
        public final long[] lengths;
        public final long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        public Editor edit() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.edit(this.key, this.sequenceNumber) : (Editor) invokeV.objValue;
        }

        public File getFile(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.files[i] : (File) invokeI.objValue;
        }

        public long getLength(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.lengths[i] : invokeI.longValue;
        }

        public String getString(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? DiskLruCache.inputStreamToString(new FileInputStream(this.files[i])) : (String) invokeI.objValue;
        }

        public Value(DiskLruCache diskLruCache, String str, long j, File[] fileArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str, Long.valueOf(j), fileArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.lengths = jArr;
        }
    }

    public DiskLruCache(File file, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
        this.cleanupCallable = new Callable<Void>(this) { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DiskLruCache this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    synchronized (this.this$0) {
                        if (this.this$0.journalWriter == null) {
                            return null;
                        }
                        this.this$0.trimToSize();
                        if (this.this$0.journalRebuildRequired()) {
                            this.this$0.rebuildJournal();
                            this.this$0.redundantOpCount = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
    }

    private void checkNotClosed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, this, editor, z) == null) {
            synchronized (this) {
                Entry entry = editor.entry;
                if (entry.currentEditor == editor) {
                    if (z && !entry.readable) {
                        for (int i = 0; i < this.valueCount; i++) {
                            if (editor.written[i]) {
                                if (!entry.getDirtyFile(i).exists()) {
                                    editor.abort();
                                    return;
                                }
                            } else {
                                editor.abort();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        File dirtyFile = entry.getDirtyFile(i2);
                        if (z) {
                            if (dirtyFile.exists()) {
                                File cleanFile = entry.getCleanFile(i2);
                                dirtyFile.renameTo(cleanFile);
                                long j = entry.lengths[i2];
                                long length = cleanFile.length();
                                entry.lengths[i2] = length;
                                this.size = (this.size - j) + length;
                            }
                        } else {
                            deleteIfExists(dirtyFile);
                        }
                    }
                    this.redundantOpCount++;
                    entry.currentEditor = null;
                    if (entry.readable | z) {
                        entry.readable = true;
                        this.journalWriter.append((CharSequence) "CLEAN");
                        this.journalWriter.append(WebvttCueParser.CHAR_SPACE);
                        this.journalWriter.append((CharSequence) entry.key);
                        this.journalWriter.append((CharSequence) entry.getLengths());
                        this.journalWriter.append('\n');
                        if (z) {
                            long j2 = this.nextSequenceNumber;
                            this.nextSequenceNumber = 1 + j2;
                            entry.sequenceNumber = j2;
                        }
                    } else {
                        this.lruEntries.remove(entry.key);
                        this.journalWriter.append((CharSequence) "REMOVE");
                        this.journalWriter.append(WebvttCueParser.CHAR_SPACE);
                        this.journalWriter.append((CharSequence) entry.key);
                        this.journalWriter.append('\n');
                    }
                    this.journalWriter.flush();
                    if (this.size > this.maxSize || journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public static void deleteIfExists(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, inputStream)) == null) ? Util.readFully(new InputStreamReader(inputStream, Util.UTF_8)) : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            int i = this.redundantOpCount;
            return i >= 2000 && i >= this.lruEntries.size();
        }
        return invokeV.booleanValue;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i2 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            renameTo(file2, file3, false);
                        }
                    }
                    DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
                    if (diskLruCache.journalFile.exists()) {
                        try {
                            diskLruCache.readJournal();
                            diskLruCache.processJournal();
                            return diskLruCache;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            diskLruCache.delete();
                        }
                    }
                    file.mkdirs();
                    DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                    diskLruCache2.rebuildJournal();
                    return diskLruCache2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (DiskLruCache) invokeCommon.objValue;
    }

    private void processJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            deleteIfExists(this.journalFileTmp);
            Iterator<Entry> it = this.lruEntries.values().iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                int i = 0;
                if (next.currentEditor != null) {
                    next.currentEditor = null;
                    while (i < this.valueCount) {
                        deleteIfExists(next.getCleanFile(i));
                        deleteIfExists(next.getDirtyFile(i));
                        i++;
                    }
                    it.remove();
                } else {
                    while (i < this.valueCount) {
                        this.size += next.lengths[i];
                        i++;
                    }
                }
            }
        }
    }

    private void readJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65555, this) != null) {
            return;
        }
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine5 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(strictLineReader);
            throw th;
        }
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(32, i);
                if (indexOf2 == -1) {
                    substring = str.substring(i);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.lruEntries.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i, indexOf2);
                }
                Entry entry = this.lruEntries.get(substring);
                if (entry == null) {
                    entry = new Entry(substring);
                    this.lruEntries.put(substring, entry);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    entry.readable = true;
                    entry.currentEditor = null;
                    entry.setLengths(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    entry.currentEditor = new Editor(entry);
                    return;
                } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                } else {
                    throw new IOException("unexpected journal line: " + str);
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            synchronized (this) {
                if (this.journalWriter != null) {
                    this.journalWriter.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        bufferedWriter.write("DIRTY " + entry.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.journalFile.exists()) {
                    renameTo(this.journalFile, this.journalFileBackup, true);
                }
                renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
            }
        }
    }

    public static void renameTo(File file, File file2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65558, null, file, file2, z) == null) {
            if (z) {
                deleteIfExists(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            while (this.size > this.maxSize) {
                remove(this.lruEntries.entrySet().iterator().next().getKey());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.journalWriter == null) {
                    return;
                }
                Iterator it = new ArrayList(this.lruEntries.values()).iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
            }
        }
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close();
            Util.deleteContents(this.directory);
        }
    }

    public Editor edit(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? edit(str, -1L) : (Editor) invokeL.objValue;
    }

    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                checkNotClosed();
                trimToSize();
                this.journalWriter.flush();
            }
        }
    }

    public synchronized Value get(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                Entry entry = this.lruEntries.get(str);
                if (entry == null) {
                    return null;
                }
                if (entry.readable) {
                    for (File file : entry.cleanFiles) {
                        if (!file.exists()) {
                            return null;
                        }
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append((CharSequence) "READ");
                    this.journalWriter.append(WebvttCueParser.CHAR_SPACE);
                    this.journalWriter.append((CharSequence) str);
                    this.journalWriter.append('\n');
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return new Value(str, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
                }
                return null;
            }
        }
        return (Value) invokeL.objValue;
    }

    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.directory : (File) invokeV.objValue;
    }

    public synchronized long getMaxSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                j = this.maxSize;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                z = this.journalWriter == null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean remove(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                Entry entry = this.lruEntries.get(str);
                if (entry != null && entry.currentEditor == null) {
                    for (int i = 0; i < this.valueCount; i++) {
                        File cleanFile = entry.getCleanFile(i);
                        if (cleanFile.exists() && !cleanFile.delete()) {
                            throw new IOException("failed to delete " + cleanFile);
                        }
                        this.size -= entry.lengths[i];
                        entry.lengths[i] = 0;
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append((CharSequence) "REMOVE");
                    this.journalWriter.append(WebvttCueParser.CHAR_SPACE);
                    this.journalWriter.append((CharSequence) str);
                    this.journalWriter.append('\n');
                    this.lruEntries.remove(str);
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void setMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            synchronized (this) {
                this.maxSize = j;
                this.executorService.submit(this.cleanupCallable);
            }
        }
    }

    public synchronized long size() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                j = this.size;
            }
            return j;
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor edit(String str, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65550, this, str, j)) == null) {
            synchronized (this) {
                checkNotClosed();
                Entry entry = this.lruEntries.get(str);
                if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
                    if (entry != null) {
                        if (entry.currentEditor != null) {
                            return null;
                        }
                    } else {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(entry);
                    entry.currentEditor = editor;
                    this.journalWriter.append((CharSequence) "DIRTY");
                    this.journalWriter.append(WebvttCueParser.CHAR_SPACE);
                    this.journalWriter.append((CharSequence) str);
                    this.journalWriter.append('\n');
                    this.journalWriter.flush();
                    return editor;
                }
                return null;
            }
        }
        return (Editor) invokeLJ.objValue;
    }
}

package com.bytedance.sdk.component.net.executor;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.e;
import com.bytedance.sdk.component.b.b.f;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.utils.NetLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes5.dex */
public class DownloadExecutor extends NetExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SEGMENT_SIZE = 16384;
    public static final String TAG = "DownloadExecutor";
    public transient /* synthetic */ FieldHolder $fh;
    public File file;
    public File tempFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadExecutor(w wVar) {
        super(wVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((w) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFileWhenError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                this.file.delete();
            } catch (Throwable unused) {
            }
            try {
                this.tempFile.delete();
            } catch (Throwable unused2) {
            }
        }
    }

    public static long getContentLength(Map<String, String> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, map)) == null) {
            if (map.containsKey(Headers.CONTENT_LEN)) {
                str = map.get(Headers.CONTENT_LEN);
            } else {
                str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
            }
            if (TextUtils.isEmpty(str) || str == null) {
                return 0L;
            }
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static boolean isGzipContent(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) ? TextUtils.equals(map.get("Content-Encoding"), AsyncHttpClient.ENCODING_GZIP) : invokeL.booleanValue;
    }

    public static boolean isSupportRange(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, map)) == null) {
            if (TextUtils.equals(map.get(Util.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get(Headers.ACCEPT_RANGES), "bytes")) {
                return true;
            }
            String str = map.get("Content-Range");
            if (TextUtils.isEmpty(str)) {
                str = map.get("content-range");
            }
            return str != null && str.startsWith("bytes");
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    public void enqueue(NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, netCallback) == null) {
            File file = this.file;
            if (file == null || this.tempFile == null) {
                if (netCallback != null) {
                    netCallback.onFailure(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                    return;
                }
                return;
            }
            if (file.exists() && this.file.length() != 0 && netCallback != null) {
                long currentTimeMillis = System.currentTimeMillis();
                NetResponse netResponse = new NetResponse(true, 200, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS, null, null, currentTimeMillis, currentTimeMillis);
                netResponse.setFile(this.file);
                netCallback.onResponse(this, netResponse);
                return;
            }
            long length = this.tempFile.length();
            long j = length >= 0 ? length : 0L;
            z.a aVar = new z.a();
            aVar.a((Object) getTag());
            addHeader("Range", "bytes=" + j + "-");
            if (TextUtils.isEmpty(this.url)) {
                netCallback.onFailure(this, new IOException("Url is Empty"));
                return;
            }
            try {
                aVar.a(this.url);
                for (Map.Entry<String, String> entry : this.requestHeadsMap.entrySet()) {
                    aVar.b(entry.getKey(), entry.getValue());
                }
                this.okHttpClient.a(aVar.a().d()).a(new f(this, netCallback, j) { // from class: com.bytedance.sdk.component.net.executor.DownloadExecutor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadExecutor this$0;
                    public final /* synthetic */ long val$cachedSize;
                    public final /* synthetic */ NetCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, netCallback, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = netCallback;
                        this.val$cachedSize = j;
                    }

                    @Override // com.bytedance.sdk.component.b.b.f
                    public void onFailure(e eVar, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, eVar, iOException) == null) {
                            NetCallback netCallback2 = this.val$callback;
                            if (netCallback2 != null) {
                                netCallback2.onFailure(this.this$0, iOException);
                            }
                            this.this$0.deleteFileWhenError();
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:143:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:163:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:170:0x01c2 A[EDGE_INSN: B:170:0x01c2->B:67:0x01c2 ?: BREAK  , SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x017c A[Catch: all -> 0x0279, TryCatch #10 {all -> 0x0279, blocks: (B:46:0x015a, B:48:0x0160, B:50:0x0164, B:51:0x016a, B:52:0x0173, B:54:0x017c, B:56:0x018a, B:62:0x0198, B:64:0x01a8), top: B:159:0x015a }] */
                    /* JADX WARN: Removed duplicated region for block: B:62:0x0198 A[Catch: all -> 0x0279, TryCatch #10 {all -> 0x0279, blocks: (B:46:0x015a, B:48:0x0160, B:50:0x0164, B:51:0x016a, B:52:0x0173, B:54:0x017c, B:56:0x018a, B:62:0x0198, B:64:0x01a8), top: B:159:0x015a }] */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6  */
                    /* JADX WARN: Removed duplicated region for block: B:69:0x01c7 A[Catch: all -> 0x01d2, TryCatch #9 {all -> 0x01d2, blocks: (B:66:0x01ab, B:69:0x01c7, B:75:0x01dd, B:77:0x01e7, B:79:0x01f3, B:81:0x0201, B:82:0x021d, B:83:0x022a, B:87:0x0249), top: B:158:0x01ab }] */
                    /* JADX WARN: Removed duplicated region for block: B:72:0x01d5  */
                    /* JADX WARN: Removed duplicated region for block: B:85:0x0246  */
                    /* JADX WARN: Removed duplicated region for block: B:86:0x0248  */
                    @Override // com.bytedance.sdk.component.b.b.f
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResponse(e eVar, ab abVar) throws IOException {
                        long j2;
                        RandomAccessFile randomAccessFile;
                        long j3;
                        boolean z;
                        InputStream inputStream;
                        int i2;
                        int i3;
                        InputStream c2;
                        byte[] bArr;
                        long j4;
                        int i4;
                        int read;
                        long length2;
                        int i5;
                        NetResponse netResponse2;
                        long j5;
                        boolean z2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, abVar) == null) || this.val$callback == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        if (abVar == null) {
                            return;
                        }
                        s g2 = abVar.g();
                        if (g2 != null) {
                            for (int i6 = 0; i6 < g2.a(); i6++) {
                                hashMap.put(g2.a(i6), g2.b(i6));
                            }
                        }
                        NetResponse netResponse3 = r13;
                        NetResponse netResponse4 = new NetResponse(abVar.d(), abVar.c(), abVar.e(), hashMap, null, abVar.l(), abVar.m());
                        if (abVar.d()) {
                            long b2 = abVar.h().b();
                            long j6 = 0;
                            if (b2 <= 0) {
                                b2 = DownloadExecutor.getContentLength(hashMap);
                            }
                            boolean isSupportRange = DownloadExecutor.isSupportRange(hashMap);
                            if (isSupportRange) {
                                b2 += this.val$cachedSize;
                                String str = (String) hashMap.get("Content-Range");
                                if (!TextUtils.isEmpty(str)) {
                                    String str2 = "bytes " + this.val$cachedSize + "-" + (b2 - 1);
                                    if (TextUtils.indexOf(str, str2) == -1) {
                                        this.this$0.deleteFileWhenError();
                                        this.val$callback.onFailure(this.this$0, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + this.this$0.tempFile + "]."));
                                        return;
                                    }
                                }
                            }
                            long j7 = b2;
                            if (j7 > 0 && this.this$0.tempFile.exists() && this.this$0.tempFile.length() == j7) {
                                DownloadExecutor downloadExecutor = this.this$0;
                                if (downloadExecutor.tempFile.renameTo(downloadExecutor.file)) {
                                    this.this$0.updateProgress(j7, j7, this.val$callback);
                                    netResponse3.setFile(this.this$0.file);
                                    this.val$callback.onResponse(this.this$0, netResponse3);
                                    return;
                                }
                                this.val$callback.onFailure(this.this$0, new IOException("Rename fail"));
                                return;
                            }
                            try {
                                randomAccessFile = new RandomAccessFile(this.this$0.tempFile, "rw");
                            } catch (Throwable unused) {
                                j2 = j7;
                                randomAccessFile = null;
                            }
                            if (isSupportRange) {
                                j2 = j7;
                                randomAccessFile.seek(this.val$cachedSize);
                                j3 = this.val$cachedSize;
                                try {
                                    c2 = abVar.h().c();
                                    try {
                                        if (DownloadExecutor.isGzipContent(hashMap) && !(c2 instanceof GZIPInputStream)) {
                                            c2 = new GZIPInputStream(c2);
                                        }
                                        bArr = new byte[16384];
                                        j4 = 0;
                                        long j8 = j3;
                                        i4 = 0;
                                        while (true) {
                                            read = c2.read(bArr, i4, 16384 - i4);
                                            if (read != -1) {
                                                break;
                                            }
                                            i4 += read;
                                            netResponse2 = netResponse3;
                                            j5 = j4 + read;
                                            try {
                                                if (j5 % 16384 != j6 && j5 != j2 - this.val$cachedSize) {
                                                    z2 = false;
                                                    if (!z2) {
                                                        long j9 = j8;
                                                        randomAccessFile.seek(j9);
                                                        randomAccessFile.write(bArr, 0, i4);
                                                        j8 = j9 + i4;
                                                        i4 = 0;
                                                    }
                                                    z = isSupportRange;
                                                    this.this$0.updateProgress(this.val$cachedSize + j5, j2, this.val$callback);
                                                    isSupportRange = z;
                                                    j4 = j5;
                                                    netResponse3 = netResponse2;
                                                    j6 = 0;
                                                }
                                                this.this$0.updateProgress(this.val$cachedSize + j5, j2, this.val$callback);
                                                isSupportRange = z;
                                                j4 = j5;
                                                netResponse3 = netResponse2;
                                                j6 = 0;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream = c2;
                                                try {
                                                    NetLog.v("Error occured when FileRequest.parseHttpResponse");
                                                    th.printStackTrace();
                                                    this.val$callback.onFailure(this.this$0, new IOException(th.getMessage()));
                                                    if (!z) {
                                                        this.this$0.deleteFileWhenError();
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused2) {
                                                            NetLog.v("Error occured when calling InputStream.close");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused3) {
                                                            i3 = 0;
                                                            o.a("Error occured when calling consumingContent", new Object[0]);
                                                            randomAccessFile.close();
                                                            return;
                                                        }
                                                    }
                                                    i3 = 0;
                                                    try {
                                                        randomAccessFile.close();
                                                        return;
                                                    } catch (Throwable unused4) {
                                                        o.a("Error occured when calling tmpFile.close", new Object[i3]);
                                                        return;
                                                    }
                                                } catch (Throwable th2) {
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused5) {
                                                            NetLog.v("Error occured when calling InputStream.close");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused6) {
                                                            i2 = 0;
                                                            o.a("Error occured when calling consumingContent", new Object[0]);
                                                            randomAccessFile.close();
                                                            throw th2;
                                                        }
                                                    }
                                                    i2 = 0;
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused7) {
                                                        o.a("Error occured when calling tmpFile.close", new Object[i2]);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            z2 = true;
                                            if (!z2) {
                                            }
                                            z = isSupportRange;
                                        }
                                        NetResponse netResponse5 = netResponse3;
                                        length2 = isSupportRange ? this.this$0.tempFile.length() : j2;
                                        if (length2 <= 0 && this.this$0.tempFile.exists() && this.this$0.tempFile.length() == length2) {
                                            if (this.this$0.tempFile.renameTo(this.this$0.file)) {
                                                this.this$0.updateProgress(length2, length2, this.val$callback);
                                                netResponse5.setFile(this.this$0.file);
                                                this.val$callback.onResponse(this.this$0, netResponse5);
                                            } else {
                                                this.val$callback.onFailure(this.this$0, new IOException("Rename fail"));
                                            }
                                        } else {
                                            NetCallback netCallback2 = this.val$callback;
                                            DownloadExecutor downloadExecutor2 = this.this$0;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(" tempFile.length() == fileSize is");
                                            sb.append(this.this$0.tempFile.length() != length2);
                                            netCallback2.onFailure(downloadExecutor2, new IOException(sb.toString()));
                                        }
                                        if (c2 != null) {
                                            try {
                                                c2.close();
                                            } catch (Throwable unused8) {
                                                NetLog.v("Error occured when calling InputStream.close");
                                            }
                                        }
                                        if (c2 != null) {
                                            try {
                                                c2.close();
                                            } catch (Throwable unused9) {
                                                i5 = 0;
                                                o.a("Error occured when calling consumingContent", new Object[0]);
                                            }
                                        }
                                        i5 = 0;
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable unused10) {
                                            o.a("Error occured when calling tmpFile.close", new Object[i5]);
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = isSupportRange;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    z = isSupportRange;
                                    inputStream = null;
                                }
                            } else {
                                j2 = j7;
                                randomAccessFile.setLength(0L);
                                j3 = 0;
                                c2 = abVar.h().c();
                                if (DownloadExecutor.isGzipContent(hashMap)) {
                                    c2 = new GZIPInputStream(c2);
                                }
                                bArr = new byte[16384];
                                j4 = 0;
                                long j82 = j3;
                                i4 = 0;
                                while (true) {
                                    read = c2.read(bArr, i4, 16384 - i4);
                                    if (read != -1) {
                                    }
                                    this.this$0.updateProgress(this.val$cachedSize + j5, j2, this.val$callback);
                                    isSupportRange = z;
                                    j4 = j5;
                                    netResponse3 = netResponse2;
                                    j6 = 0;
                                }
                                NetResponse netResponse52 = netResponse3;
                                if (isSupportRange) {
                                }
                                if (length2 <= 0) {
                                }
                                NetCallback netCallback22 = this.val$callback;
                                DownloadExecutor downloadExecutor22 = this.this$0;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(" tempFile.length() == fileSize is");
                                sb2.append(this.this$0.tempFile.length() != length2);
                                netCallback22.onFailure(downloadExecutor22, new IOException(sb2.toString()));
                                if (c2 != null) {
                                }
                                if (c2 != null) {
                                }
                                i5 = 0;
                                randomAccessFile.close();
                            }
                        } else {
                            this.val$callback.onResponse(this.this$0, netResponse3);
                        }
                    }
                });
            } catch (IllegalArgumentException unused) {
                netCallback.onFailure(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:34|(3:36|(2:39|37)|40)|41|(1:43)|44|(2:46|(4:48|(2:50|51)|52|(4:64|65|66|(12:68|69|70|71|72|(3:155|156|(1:158))|74|(12:75|76|(7:78|79|80|(1:85)|105|106|92)(1:110)|93|94|95|96|(1:98)|(1:100)|(1:102)|103|104)|111|(1:113)|114|(9:137|138|139|(1:141)(1:150)|142|(1:144)|(1:146)|147|148)(2:120|(5:122|(1:124)|(1:126)|127|128)(5:130|(1:132)|(1:134)|135|136)))(22:165|166|69|70|71|72|(0)|74|(13:75|76|(0)(0)|93|94|95|96|(0)|(0)|(0)|103|104|92)|111|(0)|114|(1:116)|137|138|139|(0)(0)|142|(0)|(0)|147|148))(2:58|(2:60|61)(2:62|63))))|170|52|(1:54)|64|65|66|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d8, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0222, code lost:
        r2.seek(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0228, code lost:
        r2.write(r0, 0, r7);
        r3 = r3 + r7;
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e1 A[Catch: all -> 0x02e5, TRY_ENTER, TRY_LEAVE, TryCatch #15 {IOException -> 0x0367, blocks: (B:28:0x00b7, B:30:0x00c3, B:32:0x00c9, B:35:0x00d5, B:37:0x00db, B:38:0x00ea, B:40:0x0116, B:41:0x011a, B:43:0x0128, B:45:0x0137, B:47:0x015d, B:52:0x0197, B:54:0x019f, B:56:0x01a9, B:58:0x01b3, B:60:0x01b9, B:142:0x02e1, B:127:0x02a3, B:146:0x02ea, B:166:0x032a, B:130:0x02ac, B:170:0x0333, B:149:0x02f3, B:110:0x0274, B:114:0x027d, B:173:0x033c, B:162:0x031b, B:164:0x0325, B:117:0x0288, B:123:0x029a), top: B:214:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ea A[Catch: all -> 0x02ee, TRY_ENTER, TRY_LEAVE, TryCatch #15 {IOException -> 0x0367, blocks: (B:28:0x00b7, B:30:0x00c3, B:32:0x00c9, B:35:0x00d5, B:37:0x00db, B:38:0x00ea, B:40:0x0116, B:41:0x011a, B:43:0x0128, B:45:0x0137, B:47:0x015d, B:52:0x0197, B:54:0x019f, B:56:0x01a9, B:58:0x01b3, B:60:0x01b9, B:142:0x02e1, B:127:0x02a3, B:146:0x02ea, B:166:0x032a, B:130:0x02ac, B:170:0x0333, B:149:0x02f3, B:110:0x0274, B:114:0x027d, B:173:0x033c, B:162:0x031b, B:164:0x0325, B:117:0x0288, B:123:0x029a), top: B:214:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0325 A[Catch: all -> 0x0348, TRY_LEAVE, TryCatch #15 {IOException -> 0x0367, blocks: (B:28:0x00b7, B:30:0x00c3, B:32:0x00c9, B:35:0x00d5, B:37:0x00db, B:38:0x00ea, B:40:0x0116, B:41:0x011a, B:43:0x0128, B:45:0x0137, B:47:0x015d, B:52:0x0197, B:54:0x019f, B:56:0x01a9, B:58:0x01b3, B:60:0x01b9, B:142:0x02e1, B:127:0x02a3, B:146:0x02ea, B:166:0x032a, B:130:0x02ac, B:170:0x0333, B:149:0x02f3, B:110:0x0274, B:114:0x027d, B:173:0x033c, B:162:0x031b, B:164:0x0325, B:117:0x0288, B:123:0x029a), top: B:214:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032a A[Catch: all -> 0x032e, TRY_ENTER, TRY_LEAVE, TryCatch #15 {IOException -> 0x0367, blocks: (B:28:0x00b7, B:30:0x00c3, B:32:0x00c9, B:35:0x00d5, B:37:0x00db, B:38:0x00ea, B:40:0x0116, B:41:0x011a, B:43:0x0128, B:45:0x0137, B:47:0x015d, B:52:0x0197, B:54:0x019f, B:56:0x01a9, B:58:0x01b3, B:60:0x01b9, B:142:0x02e1, B:127:0x02a3, B:146:0x02ea, B:166:0x032a, B:130:0x02ac, B:170:0x0333, B:149:0x02f3, B:110:0x0274, B:114:0x027d, B:173:0x033c, B:162:0x031b, B:164:0x0325, B:117:0x0288, B:123:0x029a), top: B:214:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0333 A[Catch: all -> 0x0337, TRY_ENTER, TRY_LEAVE, TryCatch #15 {IOException -> 0x0367, blocks: (B:28:0x00b7, B:30:0x00c3, B:32:0x00c9, B:35:0x00d5, B:37:0x00db, B:38:0x00ea, B:40:0x0116, B:41:0x011a, B:43:0x0128, B:45:0x0137, B:47:0x015d, B:52:0x0197, B:54:0x019f, B:56:0x01a9, B:58:0x01b3, B:60:0x01b9, B:142:0x02e1, B:127:0x02a3, B:146:0x02ea, B:166:0x032a, B:130:0x02ac, B:170:0x0333, B:149:0x02f3, B:110:0x0274, B:114:0x027d, B:173:0x033c, B:162:0x031b, B:164:0x0325, B:117:0x0288, B:123:0x029a), top: B:214:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x023f A[EDGE_INSN: B:224:0x023f->B:95:0x023f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cb A[Catch: all -> 0x01d5, TRY_ENTER, TryCatch #13 {all -> 0x01d5, blocks: (B:65:0x01cb, B:66:0x01d0), top: B:217:0x01c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d0 A[Catch: all -> 0x01d5, TRY_LEAVE, TryCatch #13 {all -> 0x01d5, blocks: (B:65:0x01cb, B:66:0x01d0), top: B:217:0x01c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0242 A[Catch: all -> 0x0249, TryCatch #17 {all -> 0x0249, blocks: (B:89:0x0228, B:97:0x0242, B:102:0x0251, B:104:0x0259, B:106:0x0263, B:108:0x026d), top: B:210:0x0228 }] */
    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetResponse execute() {
        InterceptResult invokeV;
        Object obj;
        long j;
        InputStream inputStream;
        InputStream c2;
        byte[] bArr;
        int i2;
        long j2;
        String str;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (NetResponse) invokeV.objValue;
        }
        File file = this.file;
        if (file == null || this.tempFile == null) {
            return null;
        }
        if (file.exists() && this.file.length() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            NetResponse netResponse = new NetResponse(true, 200, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS, null, null, currentTimeMillis, currentTimeMillis);
            netResponse.setFile(this.file);
            return netResponse;
        }
        long length = this.tempFile.length();
        if (length < 0) {
            length = 0;
        }
        z.a aVar = new z.a();
        aVar.a((Object) getTag());
        addHeader("Range", "bytes=" + length + "-");
        boolean isEmpty = TextUtils.isEmpty(this.url);
        String str2 = TAG;
        if (isEmpty) {
            Log.e(TAG, "execute: Url is Empty");
            return null;
        }
        try {
            aVar.a(this.url);
            for (Map.Entry<String, String> entry : this.requestHeadsMap.entrySet()) {
                aVar.b(entry.getKey(), entry.getValue());
            }
            try {
                ab b2 = this.okHttpClient.a(aVar.a().d()).b();
                if (b2 == null || !b2.d()) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                s g2 = b2.g();
                if (g2 != null) {
                    for (int i3 = 0; i3 < g2.a(); i3++) {
                        hashMap.put(g2.a(i3), g2.b(i3));
                    }
                }
                NetResponse netResponse2 = new NetResponse(b2.d(), b2.c(), b2.e(), hashMap, null, b2.l(), b2.m());
                long b3 = b2.h().b();
                if (b3 <= 0) {
                    b3 = getContentLength(hashMap);
                }
                long length2 = this.tempFile.length();
                boolean isSupportRange = isSupportRange(hashMap);
                if (isSupportRange) {
                    b3 += length2;
                    String str3 = (String) hashMap.get("Content-Range");
                    if (!TextUtils.isEmpty(str3)) {
                        obj = "Error occured when calling consumingContent";
                        String str4 = "bytes " + length2 + "-" + (b3 - 1);
                        if (TextUtils.indexOf(str3, str4) == -1) {
                            NetLog.i(TAG, "execute: The Content-Range Header is invalid Assume[" + str4 + "] vs Real[" + str3 + "], please remove the temporary file [" + this.tempFile + "].");
                            deleteFileWhenError();
                            return null;
                        }
                        if (b3 <= 0 && this.tempFile.exists() && this.tempFile.length() == b3) {
                            if (this.tempFile.renameTo(this.file)) {
                                netResponse2.setFile(this.file);
                                return netResponse2;
                            }
                            NetLog.i(TAG, "Rename fail");
                            return null;
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
                        if (!isSupportRange) {
                            randomAccessFile.seek(length);
                            j = length;
                            try {
                                c2 = b2.h().c();
                                try {
                                    if (isGzipContent(hashMap)) {
                                        try {
                                            if (!(c2 instanceof GZIPInputStream)) {
                                                c2 = new GZIPInputStream(c2);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = c2;
                                        }
                                    }
                                    bArr = new byte[16384];
                                    i2 = 0;
                                    j2 = 0;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = c2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                            while (true) {
                                str = str2;
                                read = c2.read(bArr, i2, 16384 - i2);
                                boolean z = true;
                                inputStream = c2;
                                if (read != -1) {
                                    break;
                                }
                                int i4 = i2 + read;
                                j2 += read;
                                try {
                                    if (j2 % 16384 != 0 && j2 != b3 - length) {
                                        z = false;
                                    }
                                    i2 = i4;
                                    str2 = str;
                                    c2 = inputStream;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                th = th;
                                NetLog.v("Error occured when FileRequest.parseHttpResponse");
                                th.printStackTrace();
                                if (!isSupportRange) {
                                    deleteFileWhenError();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                randomAccessFile.close();
                                return null;
                            }
                            if (!isSupportRange) {
                                b3 = this.tempFile.length();
                            }
                            if (b3 <= 0 && this.tempFile.exists() && this.tempFile.length() == b3) {
                                if (this.tempFile.renameTo(this.file)) {
                                    netResponse2.setFile(this.file);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    randomAccessFile.close();
                                    return netResponse2;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                randomAccessFile.close();
                                return null;
                            }
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append(" tempFile.length() == fileSize is");
                                sb.append(this.tempFile.length() != b3);
                                NetLog.i(str, sb.toString());
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                randomAccessFile.close();
                                return null;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            randomAccessFile.setLength(0L);
                            j = 0;
                            c2 = b2.h().c();
                            if (isGzipContent(hashMap)) {
                            }
                            bArr = new byte[16384];
                            i2 = 0;
                            j2 = 0;
                            while (true) {
                                str = str2;
                                read = c2.read(bArr, i2, 16384 - i2);
                                boolean z2 = true;
                                inputStream = c2;
                                if (read != -1) {
                                }
                                th = th;
                                NetLog.v("Error occured when FileRequest.parseHttpResponse");
                                th.printStackTrace();
                                if (!isSupportRange) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                randomAccessFile.close();
                                return null;
                                str2 = str;
                                c2 = inputStream;
                            }
                            if (!isSupportRange) {
                            }
                            if (b3 <= 0) {
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" tempFile.length() == fileSize is");
                            sb2.append(this.tempFile.length() != b3);
                            NetLog.i(str, sb2.toString());
                            if (inputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            randomAccessFile.close();
                            return null;
                        }
                    }
                }
                obj = "Error occured when calling consumingContent";
                if (b3 <= 0) {
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.tempFile, "rw");
                if (!isSupportRange) {
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                deleteFileWhenError();
                return null;
            }
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "execute: Url is not a valid HTTP or HTTPS URL");
            return null;
        }
    }

    public void setFileInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            File file = new File(str);
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            this.file = new File(str, str2);
            this.tempFile = new File(str, str2 + XAdSimpleImageLoader.TEMP_SUFFIX);
        }
    }

    public void updateProgress(long j, long j2, NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), netCallback}) == null) || netCallback == null) {
            return;
        }
        netCallback.onDownloadProgress(this, j, j2);
    }
}

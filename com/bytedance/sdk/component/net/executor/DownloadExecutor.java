package com.bytedance.sdk.component.net.executor;

import android.net.http.Headers;
import android.text.TextUtils;
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
/* loaded from: classes9.dex */
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
            long j2 = length >= 0 ? length : 0L;
            z.a aVar = new z.a();
            aVar.a((Object) getTag());
            addHeader("Range", "bytes=" + j2 + "-");
            if (TextUtils.isEmpty(this.url)) {
                netCallback.onFailure(this, new IOException("Url is Empty"));
                return;
            }
            try {
                aVar.a(this.url);
                traverseHeadMapToRequestBuilder(aVar);
                this.okHttpClient.a(aVar.a().d()).a(new f(this, netCallback, j2) { // from class: com.bytedance.sdk.component.net.executor.DownloadExecutor.1
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
                            Object[] objArr = {this, netCallback, Long.valueOf(j2)};
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
                        this.val$cachedSize = j2;
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
                        long j3;
                        RandomAccessFile randomAccessFile;
                        long j4;
                        boolean z;
                        InputStream inputStream;
                        int i2;
                        int i3;
                        InputStream c2;
                        byte[] bArr;
                        long j5;
                        int i4;
                        int read;
                        long length2;
                        int i5;
                        NetResponse netResponse2;
                        long j6;
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
                            long j7 = 0;
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
                            long j8 = b2;
                            if (j8 > 0 && this.this$0.tempFile.exists() && this.this$0.tempFile.length() == j8) {
                                DownloadExecutor downloadExecutor = this.this$0;
                                if (downloadExecutor.tempFile.renameTo(downloadExecutor.file)) {
                                    this.this$0.updateProgress(j8, j8, this.val$callback);
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
                                j3 = j8;
                                randomAccessFile = null;
                            }
                            if (isSupportRange) {
                                j3 = j8;
                                randomAccessFile.seek(this.val$cachedSize);
                                j4 = this.val$cachedSize;
                                try {
                                    c2 = abVar.h().c();
                                    try {
                                        if (DownloadExecutor.isGzipContent(hashMap) && !(c2 instanceof GZIPInputStream)) {
                                            c2 = new GZIPInputStream(c2);
                                        }
                                        bArr = new byte[16384];
                                        j5 = 0;
                                        long j9 = j4;
                                        i4 = 0;
                                        while (true) {
                                            read = c2.read(bArr, i4, 16384 - i4);
                                            if (read != -1) {
                                                break;
                                            }
                                            i4 += read;
                                            netResponse2 = netResponse3;
                                            j6 = j5 + read;
                                            try {
                                                if (j6 % 16384 != j7 && j6 != j3 - this.val$cachedSize) {
                                                    z2 = false;
                                                    if (!z2) {
                                                        long j10 = j9;
                                                        randomAccessFile.seek(j10);
                                                        randomAccessFile.write(bArr, 0, i4);
                                                        j9 = j10 + i4;
                                                        i4 = 0;
                                                    }
                                                    z = isSupportRange;
                                                    this.this$0.updateProgress(this.val$cachedSize + j6, j3, this.val$callback);
                                                    isSupportRange = z;
                                                    j5 = j6;
                                                    netResponse3 = netResponse2;
                                                    j7 = 0;
                                                }
                                                this.this$0.updateProgress(this.val$cachedSize + j6, j3, this.val$callback);
                                                isSupportRange = z;
                                                j5 = j6;
                                                netResponse3 = netResponse2;
                                                j7 = 0;
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
                                        length2 = isSupportRange ? this.this$0.tempFile.length() : j3;
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
                                j3 = j8;
                                randomAccessFile.setLength(0L);
                                j4 = 0;
                                c2 = abVar.h().c();
                                if (DownloadExecutor.isGzipContent(hashMap)) {
                                    c2 = new GZIPInputStream(c2);
                                }
                                bArr = new byte[16384];
                                j5 = 0;
                                long j92 = j4;
                                i4 = 0;
                                while (true) {
                                    read = c2.read(bArr, i4, 16384 - i4);
                                    if (read != -1) {
                                    }
                                    this.this$0.updateProgress(this.val$cachedSize + j6, j3, this.val$callback);
                                    isSupportRange = z;
                                    j5 = j6;
                                    netResponse3 = netResponse2;
                                    j7 = 0;
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

    /* JADX WARN: Can't wrap try/catch for region: R(15:28|(3:30|(2:33|31)|34)|35|(1:37)|38|39|(3:41|42|(4:44|(2:46|47)|48|(5:60|61|62|63|(22:65|66|67|68|69|(3:155|156|(2:158|159))|71|72|(11:73|74|(7:76|77|78|(1:83)|102|103|90)(1:107)|91|92|93|(1:95)|(1:97)|(1:99)|100|101)|108|(1:110)|112|(3:130|131|(2:135|(5:137|(1:139)|(1:141)|142|143)(5:145|(1:147)|(1:149)|150|151)))|114|115|116|(1:118)(1:127)|119|(1:121)|(1:123)|124|125)(23:168|169|66|67|68|69|(0)|71|72|(12:73|74|(0)(0)|91|92|93|(0)|(0)|(0)|100|101|90)|108|(0)|112|(0)|114|115|116|(0)(0)|119|(0)|(0)|124|125))(2:54|(2:56|57)(2:58|59))))|173|48|(1:50)|60|61|62|63|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b5, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0206, code lost:
        r5.seek(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x020a, code lost:
        r5.write(r0, 0, r10);
        r14 = r14 + r10;
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02be A[Catch: all -> 0x02c2, TRY_ENTER, TRY_LEAVE, TryCatch #12 {IOException -> 0x0335, blocks: (B:23:0x008d, B:25:0x0099, B:27:0x009f, B:30:0x00ab, B:32:0x00b1, B:33:0x00bf, B:35:0x00f3, B:36:0x00f7, B:40:0x0106, B:42:0x0114, B:44:0x0138, B:49:0x0170, B:51:0x0178, B:53:0x0182, B:55:0x018c, B:57:0x0194, B:117:0x025c, B:120:0x0265, B:126:0x0275, B:170:0x02f8, B:147:0x02be, B:130:0x027e, B:174:0x0301, B:151:0x02c7, B:133:0x0287, B:177:0x030a, B:154:0x02d0, B:166:0x02e9, B:168:0x02f3, B:113:0x0253), top: B:227:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c7 A[Catch: all -> 0x02cb, TRY_ENTER, TRY_LEAVE, TryCatch #12 {IOException -> 0x0335, blocks: (B:23:0x008d, B:25:0x0099, B:27:0x009f, B:30:0x00ab, B:32:0x00b1, B:33:0x00bf, B:35:0x00f3, B:36:0x00f7, B:40:0x0106, B:42:0x0114, B:44:0x0138, B:49:0x0170, B:51:0x0178, B:53:0x0182, B:55:0x018c, B:57:0x0194, B:117:0x025c, B:120:0x0265, B:126:0x0275, B:170:0x02f8, B:147:0x02be, B:130:0x027e, B:174:0x0301, B:151:0x02c7, B:133:0x0287, B:177:0x030a, B:154:0x02d0, B:166:0x02e9, B:168:0x02f3, B:113:0x0253), top: B:227:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02f3 A[Catch: all -> 0x0316, TRY_LEAVE, TryCatch #12 {IOException -> 0x0335, blocks: (B:23:0x008d, B:25:0x0099, B:27:0x009f, B:30:0x00ab, B:32:0x00b1, B:33:0x00bf, B:35:0x00f3, B:36:0x00f7, B:40:0x0106, B:42:0x0114, B:44:0x0138, B:49:0x0170, B:51:0x0178, B:53:0x0182, B:55:0x018c, B:57:0x0194, B:117:0x025c, B:120:0x0265, B:126:0x0275, B:170:0x02f8, B:147:0x02be, B:130:0x027e, B:174:0x0301, B:151:0x02c7, B:133:0x0287, B:177:0x030a, B:154:0x02d0, B:166:0x02e9, B:168:0x02f3, B:113:0x0253), top: B:227:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f8 A[Catch: all -> 0x02fc, TRY_ENTER, TRY_LEAVE, TryCatch #12 {IOException -> 0x0335, blocks: (B:23:0x008d, B:25:0x0099, B:27:0x009f, B:30:0x00ab, B:32:0x00b1, B:33:0x00bf, B:35:0x00f3, B:36:0x00f7, B:40:0x0106, B:42:0x0114, B:44:0x0138, B:49:0x0170, B:51:0x0178, B:53:0x0182, B:55:0x018c, B:57:0x0194, B:117:0x025c, B:120:0x0265, B:126:0x0275, B:170:0x02f8, B:147:0x02be, B:130:0x027e, B:174:0x0301, B:151:0x02c7, B:133:0x0287, B:177:0x030a, B:154:0x02d0, B:166:0x02e9, B:168:0x02f3, B:113:0x0253), top: B:227:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0301 A[Catch: all -> 0x0305, TRY_ENTER, TRY_LEAVE, TryCatch #12 {IOException -> 0x0335, blocks: (B:23:0x008d, B:25:0x0099, B:27:0x009f, B:30:0x00ab, B:32:0x00b1, B:33:0x00bf, B:35:0x00f3, B:36:0x00f7, B:40:0x0106, B:42:0x0114, B:44:0x0138, B:49:0x0170, B:51:0x0178, B:53:0x0182, B:55:0x018c, B:57:0x0194, B:117:0x025c, B:120:0x0265, B:126:0x0275, B:170:0x02f8, B:147:0x02be, B:130:0x027e, B:174:0x0301, B:151:0x02c7, B:133:0x0287, B:177:0x030a, B:154:0x02d0, B:166:0x02e9, B:168:0x02f3, B:113:0x0253), top: B:227:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0230 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x021e A[EDGE_INSN: B:229:0x021e->B:97:0x021e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a8 A[Catch: all -> 0x01b2, TRY_ENTER, TryCatch #23 {all -> 0x01b2, blocks: (B:63:0x01a8, B:64:0x01ad), top: B:210:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ad A[Catch: all -> 0x01b2, TRY_LEAVE, TryCatch #23 {all -> 0x01b2, blocks: (B:63:0x01a8, B:64:0x01ad), top: B:210:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0221 A[Catch: all -> 0x0228, TRY_LEAVE, TryCatch #24 {all -> 0x0228, blocks: (B:91:0x020a, B:99:0x0221), top: B:208:0x020a }] */
    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetResponse execute() {
        InterceptResult invokeV;
        Object obj;
        long j2;
        InputStream inputStream;
        InputStream c2;
        byte[] bArr;
        int i2;
        long j3;
        int read;
        String str;
        long j4;
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
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        try {
            aVar.a(this.url);
            traverseHeadMapToRequestBuilder(aVar);
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
                String str2 = TAG;
                if (isSupportRange) {
                    b3 += length2;
                    String str3 = (String) hashMap.get("Content-Range");
                    if (!TextUtils.isEmpty(str3)) {
                        StringBuilder sb = new StringBuilder();
                        obj = "Error occured when calling tmpFile.close";
                        sb.append("bytes ");
                        sb.append(length2);
                        sb.append("-");
                        sb.append(b3 - 1);
                        String sb2 = sb.toString();
                        if (TextUtils.indexOf(str3, sb2) == -1) {
                            NetLog.i(TAG, "execute: The Content-Range Header is invalid Assume[" + sb2 + "] vs Real[" + str3 + "], please remove the temporary file [" + this.tempFile + "].");
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
                            j2 = length;
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
                                    j3 = 0;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                            while (true) {
                                read = c2.read(bArr, i2, 16384 - i2);
                                boolean z = true;
                                str = str2;
                                if (read != -1) {
                                    break;
                                }
                                i2 += read;
                                j4 = length;
                                j3 += read;
                                try {
                                    if (j3 % 16384 != 0 && j3 != b3 - j4) {
                                        z = false;
                                    }
                                    str2 = str;
                                    length = j4;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                th = th;
                                inputStream = c2;
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
                            if (b3 > 0) {
                                try {
                                    if (this.tempFile.exists() && this.tempFile.length() == b3) {
                                        if (this.tempFile.renameTo(this.file)) {
                                            netResponse2.setFile(this.file);
                                            if (c2 != null) {
                                                c2.close();
                                            }
                                            if (c2 != null) {
                                                c2.close();
                                            }
                                            randomAccessFile.close();
                                            return netResponse2;
                                        }
                                        if (c2 != null) {
                                            c2.close();
                                        }
                                        if (c2 != null) {
                                            c2.close();
                                        }
                                        randomAccessFile.close();
                                        return null;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream = c2;
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
                                }
                            }
                            try {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(" tempFile.length() == fileSize is");
                                sb3.append(this.tempFile.length() != b3);
                                NetLog.i(str, sb3.toString());
                                if (c2 != null) {
                                    c2.close();
                                }
                                if (c2 != null) {
                                    c2.close();
                                }
                                randomAccessFile.close();
                                return null;
                            } catch (Throwable th6) {
                                th = th6;
                                inputStream = c2;
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
                            }
                        }
                        randomAccessFile.setLength(0L);
                        j2 = 0;
                        c2 = b2.h().c();
                        if (isGzipContent(hashMap)) {
                        }
                        bArr = new byte[16384];
                        i2 = 0;
                        j3 = 0;
                        while (true) {
                            read = c2.read(bArr, i2, 16384 - i2);
                            boolean z2 = true;
                            str = str2;
                            if (read != -1) {
                            }
                            th = th;
                            inputStream = c2;
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
                            length = j4;
                        }
                        if (!isSupportRange) {
                        }
                        if (b3 > 0) {
                        }
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(" tempFile.length() == fileSize is");
                        sb32.append(this.tempFile.length() != b3);
                        NetLog.i(str, sb32.toString());
                        if (c2 != null) {
                        }
                        if (c2 != null) {
                        }
                        randomAccessFile.close();
                        return null;
                    }
                }
                obj = "Error occured when calling tmpFile.close";
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

    public void updateProgress(long j2, long j3, NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), netCallback}) == null) || netCallback == null) {
            return;
        }
        netCallback.onDownloadProgress(this, j2, j3);
    }
}

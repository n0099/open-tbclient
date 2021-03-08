package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.IMConnection;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import com.coremedia.iso.boxes.AuthorBox;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class c implements com.bytedance.sdk.adnet.e.c {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f4035a = q.f4050a;
    protected final com.bytedance.sdk.adnet.e.a pxA;
    protected final d pxB;

    public c(com.bytedance.sdk.adnet.e.a aVar) {
        this(aVar, new d(4096));
    }

    public c(com.bytedance.sdk.adnet.e.a aVar, d dVar) {
        this.pxA = aVar;
        this.pxB = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [177=6, 178=6, 179=6, 182=5] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.e.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k c(Request<?> request) throws VAdError {
        b bVar;
        byte[] bArr;
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b bVar2 = null;
            List<a> emptyList = Collections.emptyList();
            try {
                bVar = this.pxA.a(request, a(request.getCacheEntry()));
                try {
                    try {
                        int statusCode = bVar.getStatusCode();
                        emptyList = bVar.erb();
                        if (statusCode == 304) {
                            b.a cacheEntry = request.getCacheEntry();
                            if (cacheEntry != null) {
                                k kVar = new k(304, cacheEntry.b, true, SystemClock.elapsedRealtime() - elapsedRealtime, a(emptyList, cacheEntry));
                                if (bVar != null) {
                                    try {
                                        if (bVar.getContent() != null) {
                                            bVar.getContent().close();
                                        }
                                    } catch (Throwable th) {
                                    }
                                }
                                return kVar;
                            }
                            k kVar2 = new k(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, emptyList);
                            if (bVar != null) {
                                try {
                                    if (bVar.getContent() != null) {
                                        bVar.getContent().close();
                                        return kVar2;
                                    }
                                    return kVar2;
                                } catch (Throwable th2) {
                                    return kVar2;
                                }
                            }
                            return kVar2;
                        }
                        byte[] a2 = a(request, bVar);
                        try {
                            a(SystemClock.elapsedRealtime() - elapsedRealtime, request, a2, statusCode);
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            k kVar3 = new k(statusCode, a2, false, SystemClock.elapsedRealtime() - elapsedRealtime, emptyList);
                            if (bVar != null) {
                                try {
                                    if (bVar.getContent() != null) {
                                        bVar.getContent().close();
                                        return kVar3;
                                    }
                                    return kVar3;
                                } catch (Throwable th3) {
                                    return kVar3;
                                }
                            }
                            return kVar3;
                        } catch (IOException e) {
                            e = e;
                            bArr = a2;
                            if (bVar == null) {
                                throw new com.bytedance.sdk.adnet.err.d(e);
                            }
                            try {
                                int statusCode2 = bVar.getStatusCode();
                                q.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                                if (bArr != null) {
                                    k kVar4 = new k(statusCode2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, emptyList);
                                    if (statusCode2 == 401 || statusCode2 == 403) {
                                        a(AuthorBox.TYPE, request, new com.bytedance.sdk.adnet.err.a(kVar4));
                                    } else if (statusCode2 >= 400 && statusCode2 <= 499) {
                                        throw new com.bytedance.sdk.adnet.err.b(kVar4);
                                    } else {
                                        if (statusCode2 < 500 || statusCode2 > 599) {
                                            throw new com.bytedance.sdk.adnet.err.f(kVar4);
                                        }
                                        if (!request.shouldRetryServerErrors()) {
                                            throw new com.bytedance.sdk.adnet.err.f(kVar4);
                                        }
                                        a("server", request, new com.bytedance.sdk.adnet.err.f(kVar4));
                                    }
                                } else {
                                    a("network", request, new com.bytedance.sdk.adnet.err.c());
                                }
                                if (bVar != null) {
                                    try {
                                        if (bVar.getContent() != null) {
                                            bVar.getContent().close();
                                        }
                                    } catch (Throwable th4) {
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                if (bVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bArr = null;
                    }
                } catch (MalformedURLException e3) {
                    e = e3;
                    throw new RuntimeException("Bad URL " + request.getUrl(), e);
                } catch (SocketTimeoutException e4) {
                    bVar2 = bVar;
                    try {
                        a("socket", request, new com.bytedance.sdk.adnet.err.g());
                        if (bVar2 != null) {
                            try {
                                if (bVar2.getContent() != null) {
                                    bVar2.getContent().close();
                                }
                            } catch (Throwable th6) {
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        bVar = bVar2;
                        if (bVar != null) {
                            try {
                                if (bVar.getContent() != null) {
                                    bVar.getContent().close();
                                }
                            } catch (Throwable th8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (MalformedURLException e5) {
                e = e5;
            } catch (SocketTimeoutException e6) {
            } catch (IOException e7) {
                e = e7;
                bArr = null;
                bVar = null;
            } catch (Throwable th9) {
                th = th9;
                bVar = null;
                if (bVar != null) {
                }
                throw th;
            }
        }
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (f4035a || j > IMConnection.RETRY_DELAY_TIMES) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            q.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        com.bytedance.sdk.adnet.e.e retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.b(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private Map<String, String> a(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (aVar.c != null) {
            hashMap.put("If-None-Match", aVar.c);
        }
        if (aVar.e > 0) {
            hashMap.put("If-Modified-Since", com.bytedance.sdk.adnet.d.b.a(aVar.e));
            return hashMap;
        }
        return hashMap;
    }

    protected byte[] a(Request<?> request, b bVar) throws IOException, com.bytedance.sdk.adnet.err.f {
        if (request instanceof com.bytedance.sdk.adnet.b.c) {
            return ((com.bytedance.sdk.adnet.b.c) request).a(bVar);
        }
        InputStream content = bVar.getContent();
        if (content != null) {
            return a(content, bVar.getContentLength());
        }
        return new byte[0];
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, com.bytedance.sdk.adnet.err.f {
        e eVar = new e(this.pxB, i);
        try {
            if (inputStream == null) {
                throw new com.bytedance.sdk.adnet.err.f();
            }
            byte[] a2 = this.pxB.a(1024);
            while (true) {
                int read = inputStream.read(a2);
                if (read == -1) {
                    break;
                }
                eVar.write(a2, 0, read);
            }
            byte[] byteArray = eVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    q.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.pxB.a(a2);
            eVar.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    q.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.pxB.a((byte[]) null);
            eVar.close();
            throw th;
        }
    }

    private static List<a> a(List<a> list, b.a aVar) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (a aVar2 : list) {
                treeSet.add(aVar2.getName());
                arrayList.add(aVar2);
            }
        }
        if (aVar != null) {
            if (aVar.i != null) {
                if (!aVar.i.isEmpty()) {
                    for (a aVar3 : aVar.i) {
                        if (!treeSet.contains(aVar3.getName())) {
                            arrayList.add(aVar3);
                        }
                    }
                }
            } else if (!aVar.h.isEmpty()) {
                for (Map.Entry<String, String> entry : aVar.h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new a(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}

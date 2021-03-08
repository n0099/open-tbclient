package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.AbstractBceClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f3897a;
    private static final String[] d = {"GET", "POST"};
    private static final String[] e = {"aid", "app_version", "tt_data"};
    static final String[] b = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] c = {"tt_data", "device_platform"};
    private static com.bytedance.embedapplog.util.a ppg = com.bytedance.embedapplog.util.a.Ow(0);

    private static String a(String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str) && b.enI()) {
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            ArrayList<Pair> arrayList = new ArrayList();
            for (String str2 : e) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    arrayList.add(new Pair(str2, queryParameter));
                }
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.clearQuery();
            for (Pair pair : arrayList) {
                buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
            }
            buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(b.YN(query), 8)));
            return buildUpon.build().toString();
        }
        return str;
    }

    public static String a(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            HashMap hashMap = new HashMap(strArr.length);
            for (String str2 : strArr) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    hashMap.put(str2, queryParameter);
                }
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.clearQuery();
            for (String str3 : hashMap.keySet()) {
                buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
            }
            return buildUpon.build().toString();
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [342=4, 345=4] */
    public static java.lang.String a(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) {
        /*
            r6 = 200(0xc8, float:2.8E-43)
            r5 = 1
            r3 = 0
            boolean r0 = com.bytedance.embedapplog.au.b
            if (r0 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "http: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.bytedance.embedapplog.au.a(r0, r3)
            if (r9 == 0) goto L7c
            java.util.Set r0 = r9.entrySet()
            java.util.Iterator r2 = r0.iterator()
        L29:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L7c
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L29
            java.lang.Object r1 = r0.getValue()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L29
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "http headers key:"
            java.lang.StringBuilder r4 = r1.append(r4)
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = " value:"
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.bytedance.embedapplog.au.a(r0, r3)
            goto L29
        L7c:
            if (r10 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "http data length:"
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r10.length
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bytedance.embedapplog.au.a(r0, r3)
        L96:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> Lf2
            r0.<init>(r8)     // Catch: java.lang.Throwable -> Lf2
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> Lf2
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> Lf2
            if (r7 != 0) goto L120
            r1 = 0
            r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> Lf2
        La7:
            java.lang.String[] r1 = com.bytedance.embedapplog.aa.d     // Catch: java.lang.Throwable -> Lf2
            r1 = r1[r7]     // Catch: java.lang.Throwable -> Lf2
            r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> Lf2
            if (r9 == 0) goto L141
            boolean r1 = r9.isEmpty()     // Catch: java.lang.Throwable -> Lf2
            if (r1 != 0) goto L141
            java.util.Set r1 = r9.entrySet()     // Catch: java.lang.Throwable -> Lf2
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> Lf2
        Lbe:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> Lf2
            if (r1 == 0) goto L141
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> Lf2
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> Lf2
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> Lf2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> Lf2
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf2
            if (r2 != 0) goto L13b
            java.lang.Object r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> Lf2
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf2
            if (r2 != 0) goto L13b
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> Lf2
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lf2
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf2
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lf2
            r0.addRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> Lf2
            goto Lbe
        Lf2:
            r1 = move-exception
            r2 = r1
            r0 = r3
            r4 = r3
            r5 = r3
        Lf7:
            com.bytedance.embedapplog.au.a(r2)     // Catch: java.lang.Throwable -> L22d
            if (r5 == 0) goto Lff
            r5.close()     // Catch: java.io.IOException -> L21a
        Lff:
            if (r4 == 0) goto L104
            r4.close()     // Catch: java.io.IOException -> L21d
        L104:
            boolean r1 = com.bytedance.embedapplog.au.b
            if (r1 == 0) goto L11f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "http response: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.bytedance.embedapplog.au.a(r1, r3)
        L11f:
            return r0
        L120:
            if (r7 != r5) goto L135
            r1 = 1
            r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> Lf2
            goto La7
        L127:
            r0 = move-exception
            r1 = r3
            r5 = r3
        L12a:
            if (r5 == 0) goto L12f
            r5.close()     // Catch: java.io.IOException -> L220
        L12f:
            if (r1 == 0) goto L134
            r1.close()     // Catch: java.io.IOException -> L223
        L134:
            throw r0
        L135:
            r1 = 0
            com.bytedance.embedapplog.au.a(r1)     // Catch: java.lang.Throwable -> Lf2
            goto La7
        L13b:
            r1 = 0
            com.bytedance.embedapplog.au.a(r1)     // Catch: java.lang.Throwable -> Lf2
            goto Lbe
        L141:
            java.lang.String r1 = "Accept-Encoding"
            java.lang.String r2 = "gzip"
            r0.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> Lf2
            if (r10 == 0) goto L23a
            int r1 = r10.length     // Catch: java.lang.Throwable -> Lf2
            if (r1 <= 0) goto L23a
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> Lf2
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch: java.lang.Throwable -> Lf2
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lf2
            r5.write(r10)     // Catch: java.lang.Throwable -> L1b9
            r5.flush()     // Catch: java.lang.Throwable -> L1b9
            r5.close()     // Catch: java.lang.Throwable -> L1b9
        L161:
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L1b9
            if (r1 != r6) goto L1ea
            int r1 = r0.getContentLength()     // Catch: java.lang.Throwable -> L1b9
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 >= r2) goto L1e3
            java.io.InputStream r2 = r0.getInputStream()     // Catch: java.lang.Throwable -> L1b9
            java.lang.String r0 = r0.getContentEncoding()     // Catch: java.lang.Throwable -> L1b9
            java.lang.String r1 = "gzip"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L1b9
            if (r0 == 0) goto L1ae
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L1b9
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L1b9
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L1b9
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L1b9
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L1b9
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L1b9
        L18f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a9
            int r2 = r2.available()     // Catch: java.lang.Throwable -> L1a9
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1a9
        L198:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L1a9
            if (r2 == 0) goto L1bf
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch: java.lang.Throwable -> L1a9
            java.lang.String r4 = "\n"
            r2.append(r4)     // Catch: java.lang.Throwable -> L1a9
            goto L198
        L1a9:
            r2 = move-exception
            r0 = r3
            r4 = r1
            goto Lf7
        L1ae:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L1b9
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L1b9
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1b9
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L1b9
            goto L18f
        L1b9:
            r1 = move-exception
            r2 = r1
            r0 = r3
            r4 = r3
            goto Lf7
        L1bf:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1a9
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L231
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L231
            java.lang.String r4 = "http_code"
            r6 = 200(0xc8, float:2.8E-43)
            r2.put(r4, r6)     // Catch: java.lang.Throwable -> L231
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L231
        L1d4:
            if (r5 == 0) goto L1d9
            r5.close()     // Catch: java.io.IOException -> L218
        L1d9:
            if (r1 == 0) goto L104
            r1.close()     // Catch: java.io.IOException -> L1e0
            goto L104
        L1e0:
            r1 = move-exception
            goto L104
        L1e3:
            r0 = 0
            com.bytedance.embedapplog.au.a(r0)     // Catch: java.lang.Throwable -> L1b9
            r0 = r3
            r1 = r3
            goto L1d4
        L1ea:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1b9
            r0.<init>()     // Catch: java.lang.Throwable -> L1b9
            java.lang.String r2 = "http_code"
            org.json.JSONObject r0 = r0.put(r2, r1)     // Catch: java.lang.Throwable -> L1b9
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1b9
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L235
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L235
            r4.<init>()     // Catch: java.lang.Throwable -> L235
            java.lang.String r6 = "HttpCode:"
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> L235
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> L235
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L235
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L235
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L235
            r1 = r3
            goto L1d4
        L218:
            r2 = move-exception
            goto L1d9
        L21a:
            r1 = move-exception
            goto Lff
        L21d:
            r1 = move-exception
            goto L104
        L220:
            r2 = move-exception
            goto L12f
        L223:
            r1 = move-exception
            goto L134
        L226:
            r0 = move-exception
            r1 = r3
            goto L12a
        L22a:
            r0 = move-exception
            goto L12a
        L22d:
            r0 = move-exception
            r1 = r4
            goto L12a
        L231:
            r2 = move-exception
            r4 = r1
            goto Lf7
        L235:
            r1 = move-exception
            r2 = r1
            r4 = r3
            goto Lf7
        L23a:
            r5 = r3
            goto L161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.aa.a(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static void a(int i) {
        ppg = com.bytedance.embedapplog.util.a.Ow(i);
    }

    public static com.bytedance.embedapplog.util.a eoj() {
        return ppg;
    }

    public static JSONObject a(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (b.enI()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        }
        String a2 = a(1, a(str), hashMap, b.YN(jSONObject.toString()));
        if (a2 != null) {
            try {
                return new JSONObject(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static boolean x(String str, JSONObject jSONObject) {
        float f;
        JSONObject jSONObject2;
        StringBuilder sb = new StringBuilder(str);
        float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        a(sb, "timezone", ((rawOffset >= -12.0f ? rawOffset : -12.0f) <= 12.0f ? f : 12.0f) + "");
        JSONArray optJSONArray = jSONObject.optJSONArray("sim_serial_number");
        if (optJSONArray != null) {
            try {
                String optString = ((JSONObject) optJSONArray.get(0)).optString("sim_serial_number");
                for (int i = 1; i < optJSONArray.length(); i++) {
                    optString = optString + "," + ((JSONObject) optJSONArray.get(i)).optString("sim_serial_number");
                }
                a(sb, "sim_serial_number", optString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String a2 = a(0, a(sb.toString()), null, null);
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return jSONObject2 == null && "success".equals(jSONObject2.optString("message", ""));
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
    }

    protected static void a(StringBuilder sb, String str, String str2) {
        if (sb != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (sb.toString().indexOf(63) < 0) {
                sb.append("?");
            } else {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(str).append("=").append(Uri.encode(str2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String[] strArr, byte[] bArr, cn cnVar) {
        JSONObject jSONObject;
        int i;
        int i2;
        HashMap hashMap = new HashMap(2);
        if (b.enI()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        }
        String str = null;
        for (String str2 : strArr) {
            str = a(1, str2, hashMap, bArr);
            if (TextUtils.isEmpty(str)) {
            }
        }
        try {
            if (TextUtils.isEmpty(str)) {
                i2 = 0;
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(str);
                try {
                    i2 = jSONObject.optInt("http_code");
                    if (i2 == 200) {
                        if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            i2 = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                        } else {
                            i2 = Integer.valueOf("102").intValue();
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    au.a(e);
                    i = 0;
                    if (i == 200) {
                    }
                    return i;
                }
            }
            i = i2;
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
        }
        if (i == 200) {
            try {
                long optLong = jSONObject.optLong("server_time");
                if (optLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", optLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    f3897a = jSONObject2;
                }
            } catch (Exception e4) {
                au.a(e4);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.UserInfoColumns.COLUMN_BLACKLIST);
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray(AbstractBceClient.URL_PREFIX);
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                HashSet<String> hashSet = new HashSet<>(length);
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3, null);
                    if (!TextUtils.isEmpty(optString)) {
                        hashSet.add(optString);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("v3");
                int length2 = optJSONArray2 != null ? optJSONArray2.length() : 0;
                HashSet<String> hashSet2 = new HashSet<>(length2);
                for (int i4 = 0; i4 < length2; i4++) {
                    String optString2 = optJSONArray2.optString(i4, null);
                    if (!TextUtils.isEmpty(optString2)) {
                        hashSet2.add(optString2);
                    }
                }
                cnVar.a(hashSet, hashSet2);
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject y(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String a2 = a(1, str, null, b.YN(jSONObject.toString()));
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
                return null;
            }
            return jSONObject2.optJSONObject("config");
        }
        jSONObject2 = null;
        if (jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject z(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String a2 = a(1, str, null, b.YN(jSONObject.toString()));
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null && "success".equals(jSONObject2.optString("message", ""))) {
                return null;
            }
            return jSONObject2.optJSONObject("data");
        }
        jSONObject2 = null;
        if (jSONObject2 == null && "success".equals(jSONObject2.optString("message", ""))) {
        }
    }
}

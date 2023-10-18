package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface b<T> {
        T a(int i, String str, InputStream inputStream) throws IOException;

        void b(int i, String str, T t);
    }

    /* loaded from: classes8.dex */
    public static abstract class a implements b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg.b
        /* renamed from: c */
        public JSONObject a(int i, String str, InputStream inputStream) throws IOException {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, inputStream)) == null) {
                if (i == 200) {
                    if (inputStream != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString("UTF-8"));
                                    DefaultLog.getInstance().i(TitanDownloadService.TAG, jSONObject.toString());
                                    return jSONObject;
                                }
                            }
                        } catch (Exception e) {
                            throw new IOException(e);
                        }
                    } else {
                        throw new IOException("parse response error: input stream is null");
                    }
                } else {
                    throw new IOException("parse response error: statuscode is " + i);
                }
            } else {
                return (JSONObject) invokeILL.objValue;
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e(TitanDownloadService.TAG, "getVersionName Exception:" + e);
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String sb;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if (charAt > 31 && charAt < 127) {
                        sb2.append(charAt);
                    } else {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    }
                }
                sb = sb2.toString();
            }
            String osVersion = DeviceInfoHelper.getOsVersion();
            if (TextUtils.isEmpty(osVersion)) {
                replace = com.baidu.mobads.sdk.internal.cj.d;
            } else {
                replace = osVersion.replace("_", "-");
            }
            return sb + " baiduboxapp/" + a(context) + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0123 A[Catch: all -> 0x0136, TRY_LEAVE, TryCatch #3 {all -> 0x0136, blocks: (B:64:0x0109, B:66:0x0123), top: B:80:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void c(Context context, String str, String str2, byte[] bArr, Map<String, String> map, b<T> bVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, bArr, map, bVar}) == null) {
            OutputStream outputStream3 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestProperty("User-Agent", b(context));
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpURLConnection.setRequestMethod(str2);
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (TextUtils.equals(str2, "POST")) {
                        if (bArr == null) {
                            DefaultLog.getInstance().e(TitanDownloadService.TAG, "post requestSync body is null");
                            if (bVar != null) {
                                bVar.b(-1, "post requestSync body is null", null);
                            }
                            Closeables.closeSafely((Closeable) null);
                            Closeables.closeSafely((Closeable) null);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        httpURLConnection.setDoOutput(true);
                        if (map == null || !map.containsKey("Content-Type")) {
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        }
                        outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            outputStream2.write(bArr);
                        } catch (Exception e) {
                            e = e;
                            inputStream = null;
                            outputStream = outputStream2;
                            e = e;
                            httpURLConnection2 = httpURLConnection;
                            try {
                                DefaultLog.getInstance().e(TitanDownloadService.TAG, "post requestSync Exception:" + e);
                                if (bVar != null) {
                                }
                                Closeables.closeSafely(outputStream);
                                Closeables.closeSafely(inputStream);
                                if (httpURLConnection2 == null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                outputStream3 = outputStream;
                                httpURLConnection = httpURLConnection2;
                                Closeables.closeSafely(outputStream3);
                                Closeables.closeSafely(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            outputStream3 = outputStream2;
                            th = th;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } else {
                        outputStream2 = null;
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    DefaultLog.getInstance().i(TitanDownloadService.TAG, "request code = " + responseCode + " msg = " + httpURLConnection.getResponseMessage());
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        if (bVar != null) {
                            try {
                                t = bVar.a(responseCode, httpURLConnection.getResponseMessage(), inputStream);
                            } catch (Exception e2) {
                                e = e2;
                                outputStream = outputStream2;
                                e = e;
                                httpURLConnection2 = httpURLConnection;
                                DefaultLog.getInstance().e(TitanDownloadService.TAG, "post requestSync Exception:" + e);
                                if (bVar != null) {
                                    bVar.b(-1, e.getMessage(), null);
                                }
                                Closeables.closeSafely(outputStream);
                                Closeables.closeSafely(inputStream);
                                if (httpURLConnection2 == null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream3 = outputStream2;
                                th = th;
                                Closeables.closeSafely(outputStream3);
                                Closeables.closeSafely(inputStream);
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        } else {
                            t = null;
                        }
                    } else {
                        inputStream = null;
                        t = null;
                    }
                    if (bVar != null) {
                        bVar.b(responseCode, httpURLConnection.getResponseMessage(), t);
                    }
                    Closeables.closeSafely(outputStream2);
                    Closeables.closeSafely(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection2 = httpURLConnection;
                    outputStream = null;
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
                outputStream = null;
                httpURLConnection2 = null;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
            }
        }
    }
}

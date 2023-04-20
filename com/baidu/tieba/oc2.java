package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class oc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static kc2 a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        InputStream inputStream;
        int i;
        HttpURLConnection httpURLConnection;
        String scheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            String str4 = null;
            if (TextUtils.isEmpty(str) || !Patterns.WEB_URL.matcher(str).matches()) {
                return null;
            }
            String scheme2 = Uri.parse(str).getScheme();
            int i2 = 200;
            HttpURLConnection httpURLConnection2 = null;
            while (true) {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        if (map != null) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                            }
                        }
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setConnectTimeout(ac2.a().e());
                        httpURLConnection.setReadTimeout(ac2.a().h());
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            scheme = null;
                        } else {
                            scheme = Uri.parse(headerField).getScheme();
                        }
                        if (headerField == null || (scheme != null && scheme.equals(scheme2))) {
                            break;
                        }
                        scheme2 = scheme;
                        httpURLConnection2 = httpURLConnection;
                        str = headerField;
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection2 = httpURLConnection;
                        str2 = null;
                        if (ec2.a) {
                            Log.e("HybridIntercept", Log.getStackTraceString(e));
                        }
                        str3 = str2;
                        inputStream = null;
                        i = i2;
                        httpURLConnection = httpURLConnection2;
                        HashMap hashMap = new HashMap();
                        String str5 = "UTF-8";
                        if (httpURLConnection != null) {
                        }
                        String str6 = str5;
                        String str7 = str4;
                        if (TextUtils.isEmpty(str3)) {
                        }
                        return new kc2(i, str3, inputStream, hashMap, str6, str7);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            i2 = httpURLConnection.getResponseCode();
            str3 = httpURLConnection.getResponseMessage();
            try {
                inputStream = httpURLConnection.getInputStream();
                i = i2;
            } catch (Exception e3) {
                httpURLConnection2 = httpURLConnection;
                str2 = str3;
                e = e3;
                if (ec2.a) {
                }
                str3 = str2;
                inputStream = null;
                i = i2;
                httpURLConnection = httpURLConnection2;
                HashMap hashMap2 = new HashMap();
                String str52 = "UTF-8";
                if (httpURLConnection != null) {
                }
                String str62 = str52;
                String str72 = str4;
                if (TextUtils.isEmpty(str3)) {
                }
                return new kc2(i, str3, inputStream, hashMap2, str62, str72);
            }
            HashMap hashMap22 = new HashMap();
            String str522 = "UTF-8";
            if (httpURLConnection != null) {
                if (httpURLConnection.getContentEncoding() != null) {
                    str522 = httpURLConnection.getContentEncoding();
                }
                str4 = httpURLConnection.getContentType();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                if (headerFields != null) {
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        List<String> value = entry2.getValue();
                        if (!value.isEmpty()) {
                            hashMap22.put(entry2.getKey(), value.get(0));
                        }
                    }
                }
            }
            String str622 = str522;
            String str722 = str4;
            if (TextUtils.isEmpty(str3)) {
                str3 = DnsModel.MSG_OK;
            }
            return new kc2(i, str3, inputStream, hashMap22, str622, str722);
        }
        return (kc2) invokeLL.objValue;
    }
}

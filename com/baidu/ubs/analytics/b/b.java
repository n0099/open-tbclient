package com.baidu.ubs.analytics.b;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.d;
import com.baidu.ubs.analytics.d.j;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {

    /* loaded from: classes6.dex */
    public interface a<T> {
        void Lc(String str);

        void a(T t);
    }

    public static String m(String str, Map<String, Object> map) {
        String str2;
        String stringBuffer;
        if (map.size() <= 0) {
            str2 = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            if (map.isEmpty()) {
                stringBuffer = "";
            } else {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (stringBuffer2.length() <= 0) {
                        stringBuffer2.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
                    } else {
                        stringBuffer2.append(ETAG.ITEM_SEPARATOR).append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
                    }
                }
                stringBuffer = stringBuffer2.toString();
            }
            str2 = stringBuffer;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(MessageConfig.SOCKET_TIME_OUT_MS_2G);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("token", d.cVW().k());
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));
            printWriter.write(str2);
            printWriter.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                } else {
                    printWriter.close();
                    bufferedInputStream.close();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Exception e) {
            j.b(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [261=4, 263=5, 265=4] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file, String str) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        String uuid = UUID.randomUUID().toString();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(MessageConfig.SOCKET_TIME_OUT_MS_2G);
                httpURLConnection.setConnectTimeout(40000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                httpURLConnection.setRequestProperty("token", d.cVW().k());
                if (file != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("--");
                    stringBuffer.append(uuid);
                    stringBuffer.append("\r\n");
                    stringBuffer.append("Content-Disposition: form-data; name=\"txt\"; filename=\"" + file.getName() + "\"\r\n");
                    stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n");
                    stringBuffer.append("\r\n");
                    dataOutputStream.write(stringBuffer.toString().getBytes("UTF-8"));
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                        dataOutputStream.write("\r\n".getBytes("UTF-8"));
                        dataOutputStream.write(("--" + uuid + "--\r\n").getBytes("UTF-8"));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        if (httpURLConnection.getResponseCode() != 200) {
                            com.baidu.ubs.analytics.d.b.Lf(file.getAbsolutePath() + "     上传文件失败…………");
                            httpURLConnection.disconnect();
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        while (true) {
                            int read2 = inputStream2.read();
                            if (read2 == -1) {
                                inputStream2.close();
                                httpURLConnection.disconnect();
                                String stringBuffer3 = stringBuffer2.toString();
                                try {
                                    fileInputStream.close();
                                    return stringBuffer3;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return stringBuffer3;
                                }
                            }
                            stringBuffer2.append((char) read2);
                        }
                    } catch (IOException e3) {
                        e = e3;
                        j.a(e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Exception e5) {
                        e = e5;
                        j.a(e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                inputStream = "multipart/form-data";
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileInputStream = null;
        } catch (Exception e9) {
            e = e9;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
            }
            throw th;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.toString().getBytes("UTF-8").length));
            httpURLConnection.setReadTimeout(MessageConfig.SOCKET_TIME_OUT_MS_2G);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty("token", d.cVW().k());
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(new String(readLine.getBytes("UTF-8"), "utf-8"));
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        httpURLConnection.disconnect();
                        return stringBuffer.toString();
                    }
                }
            } else {
                com.baidu.ubs.analytics.d.b.Lf("上传log失败    ");
                httpURLConnection.disconnect();
                return null;
            }
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.b.Lf("上传log失败    " + e.getMessage());
            j.a(e);
            return null;
        }
    }

    public static boolean a(String str, a aVar) {
        try {
        } catch (Exception e) {
            j.a(e);
        }
        if (str == null) {
            if (aVar != null) {
                aVar.Lc("-1");
                return false;
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getString("status").equals("0")) {
            if (aVar != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                } else {
                    aVar.a(jSONObject.optJSONArray("data"));
                }
            }
            return true;
        } else if (jSONObject.getString("status").equals("1")) {
            if (aVar != null) {
                aVar.Lc(jSONObject.optString("status"));
            }
            com.baidu.ubs.analytics.d.b.Lf("net status  error ");
            return false;
        } else {
            if (jSONObject.getString("status").equals("2")) {
                g.d(d.cVW().getContext());
                com.baidu.ubs.analytics.d.b.Lf("net  token error ");
                return false;
            }
            if (aVar != null) {
                aVar.Lc("-1");
                return false;
            }
            return false;
        }
    }
}

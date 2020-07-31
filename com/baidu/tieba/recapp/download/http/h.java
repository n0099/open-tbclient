package com.baidu.tieba.recapp.download.http;

import com.baidu.adp.lib.util.k;
import com.baidu.webkit.internal.ETAG;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes20.dex */
public class h {
    private String url = "";
    protected Map<String, String> KY = new HashMap();
    protected LinkedList<BasicNameValuePair> KZ = new LinkedList<>();
    protected HashMap<String, byte[]> La = new HashMap<>();

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        if (str == null) {
            this.url = "";
        } else {
            this.url = str;
        }
    }

    public boolean kX() {
        return this.La != null && this.La.size() > 0;
    }

    public String c(e eVar) {
        if (this.KZ.size() == 0) {
            if (eVar != null) {
                eVar.KC = this.url.length();
            }
            return this.url;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.url);
        if (this.url.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.url.endsWith("?") && !this.url.endsWith(ETAG.ITEM_SEPARATOR)) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.KZ.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.KZ.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.getUrlEncode(this.KZ.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.KC = sb.length();
        }
        return sb.toString();
    }

    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.KY != null) {
            for (Map.Entry<String, String> entry : this.KY.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        kZ();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.KZ != null) {
                    Iterator<BasicNameValuePair> it = this.KZ.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + "\r\n");
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                }
                if (this.La != null) {
                    for (Map.Entry<String, byte[]> entry : this.La.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + "\r\n");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--\r\n");
                dataOutputStream.flush();
                i = dataOutputStream.size();
            } finally {
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
            }
        }
        if (eVar != null) {
            eVar.KC = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = kY().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (eVar != null) {
            eVar.KC = i;
        }
    }

    private StringBuilder kY() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.KZ != null) {
            Iterator<BasicNameValuePair> it = this.KZ.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(name + ETAG.EQUAL);
                    sb.append(k.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void kZ() {
    }

    public String bC(String str) {
        if (this.KY != null) {
            return this.KY.get(str);
        }
        return null;
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.KZ.add(basicNameValuePair);
    }

    public void s(String str, String str2) {
        if (this.KY != null) {
            this.KY.put(str, str2);
        }
    }
}

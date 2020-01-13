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
/* loaded from: classes11.dex */
public class h {
    private String url = "";
    protected Map<String, String> rh = new HashMap();
    protected LinkedList<BasicNameValuePair> ri = new LinkedList<>();
    protected HashMap<String, byte[]> rj = new HashMap<>();

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

    public boolean gb() {
        return this.rj != null && this.rj.size() > 0;
    }

    public String c(e eVar) {
        if (this.ri.size() == 0) {
            if (eVar != null) {
                eVar.qL = this.url.length();
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
            if (i2 >= this.ri.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.ri.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.getUrlEncode(this.ri.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.qL = sb.length();
        }
        return sb.toString();
    }

    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.rh != null) {
            for (Map.Entry<String, String> entry : this.rh.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        ge();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.ri != null) {
                    Iterator<BasicNameValuePair> it = this.ri.iterator();
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
                if (this.rj != null) {
                    for (Map.Entry<String, byte[]> entry : this.rj.entrySet()) {
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
            eVar.qL = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = gd().toString();
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
            eVar.qL = i;
        }
    }

    private StringBuilder gd() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.ri != null) {
            Iterator<BasicNameValuePair> it = this.ri.iterator();
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

    protected void ge() {
    }

    public String al(String str) {
        if (this.rh != null) {
            return this.rh.get(str);
        }
        return null;
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.ri.add(basicNameValuePair);
    }

    public void l(String str, String str2) {
        if (this.rh != null) {
            this.rh.put(str, str2);
        }
    }
}

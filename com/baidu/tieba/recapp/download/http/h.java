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
/* loaded from: classes7.dex */
public class h {
    private String url = "";
    protected Map<String, String> Mx = new HashMap();
    protected LinkedList<BasicNameValuePair> My = new LinkedList<>();
    protected HashMap<String, byte[]> Mz = new HashMap<>();

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

    public boolean lZ() {
        return this.Mz != null && this.Mz.size() > 0;
    }

    public String c(e eVar) {
        if (this.My.size() == 0) {
            if (eVar != null) {
                eVar.Mb = this.url.length();
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
            if (i2 >= this.My.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.My.get(i2).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.My.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.Mb = sb.length();
        }
        return sb.toString();
    }

    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.Mx != null) {
            for (Map.Entry<String, String> entry : this.Mx.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        mb();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.My != null) {
                    Iterator<BasicNameValuePair> it = this.My.iterator();
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
                if (this.Mz != null) {
                    for (Map.Entry<String, byte[]> entry : this.Mz.entrySet()) {
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
            eVar.Mb = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = ma().toString();
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
            eVar.Mb = i;
        }
    }

    private StringBuilder ma() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.My != null) {
            Iterator<BasicNameValuePair> it = this.My.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(name + "=");
                    sb.append(k.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void mb() {
    }

    public String bG(String str) {
        if (this.Mx != null) {
            return this.Mx.get(str);
        }
        return null;
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.My.add(basicNameValuePair);
    }

    public void u(String str, String str2) {
        if (this.Mx != null) {
            this.Mx.put(str, str2);
        }
    }
}

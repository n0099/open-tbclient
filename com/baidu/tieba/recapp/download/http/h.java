package com.baidu.tieba.recapp.download.http;

import com.baidu.adp.lib.util.k;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class h {
    private String url = "";
    protected Map<String, String> zX = new HashMap();
    protected LinkedList<BasicNameValuePair> zY = new LinkedList<>();
    protected HashMap<String, byte[]> zZ = new HashMap<>();

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

    public boolean hZ() {
        return this.zZ != null && this.zZ.size() > 0;
    }

    public String c(e eVar) {
        if (this.zY.size() == 0) {
            if (eVar != null) {
                eVar.zE = this.url.length();
            }
            return this.url;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.url);
        if (this.url.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.url.endsWith("?") && !this.url.endsWith("&")) {
            sb.append("&");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zY.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.zY.get(i2).getName());
            sb.append("=");
            sb.append(k.be(this.zY.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.zE = sb.length();
        }
        return sb.toString();
    }

    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.zX != null) {
            for (Map.Entry<String, String> entry : this.zX.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        ib();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.zY != null) {
                    Iterator<BasicNameValuePair> it = this.zY.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + SystemInfoUtil.LINE_END);
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + SystemInfoUtil.LINE_END);
                                dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                            }
                        }
                    }
                }
                if (this.zZ != null) {
                    for (Map.Entry<String, byte[]> entry : this.zZ.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + SystemInfoUtil.LINE_END);
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + SystemInfoUtil.LINE_END);
                            dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--" + SystemInfoUtil.LINE_END);
                dataOutputStream.flush();
                i = dataOutputStream.size();
            } finally {
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
            }
        }
        if (eVar != null) {
            eVar.zE = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = ia().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (eVar != null) {
            eVar.zE = i;
        }
    }

    private StringBuilder ia() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.zY != null) {
            Iterator<BasicNameValuePair> it = this.zY.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(k.be(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void ib() {
    }

    public String ay(String str) {
        if (this.zX != null) {
            return this.zX.get(str);
        }
        return null;
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.zY.add(basicNameValuePair);
    }

    public void q(String str, String str2) {
        if (this.zX != null) {
            this.zX.put(str, str2);
        }
    }
}

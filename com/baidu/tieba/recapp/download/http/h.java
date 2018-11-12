package com.baidu.tieba.recapp.download.http;

import com.baidu.adp.lib.util.k;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.webkit.internal.ETAG;
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
    protected Map<String, String> Da = new HashMap();
    protected LinkedList<BasicNameValuePair> Db = new LinkedList<>();
    protected HashMap<String, byte[]> Dc = new HashMap<>();

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

    public boolean jt() {
        return this.Dc != null && this.Dc.size() > 0;
    }

    public String c(e eVar) {
        if (this.Db.size() == 0) {
            if (eVar != null) {
                eVar.CF = this.url.length();
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
            if (i2 >= this.Db.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.Db.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.bx(this.Db.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.CF = sb.length();
        }
        return sb.toString();
    }

    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.Da != null) {
            for (Map.Entry<String, String> entry : this.Da.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        jv();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.Db != null) {
                    Iterator<BasicNameValuePair> it = this.Db.iterator();
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
                if (this.Dc != null) {
                    for (Map.Entry<String, byte[]> entry : this.Dc.entrySet()) {
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
            eVar.CF = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = ju().toString();
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
            eVar.CF = i;
        }
    }

    private StringBuilder ju() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.Db != null) {
            Iterator<BasicNameValuePair> it = this.Db.iterator();
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
                    sb.append(k.bx(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void jv() {
    }

    public String aQ(String str) {
        if (this.Da != null) {
            return this.Da.get(str);
        }
        return null;
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Db.add(basicNameValuePair);
    }

    public void y(String str, String str2) {
        if (this.Da != null) {
            this.Da.put(str, str2);
        }
    }
}

package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class b {
    private static b lHp;
    private List<JSONObject> lHq;
    private List<JSONObject> lHr;
    private List<JSONObject> lHs;

    public static b doc() {
        if (lHp == null) {
            synchronized (b.class) {
                if (lHp == null) {
                    lHp = new b();
                }
            }
        }
        return lHp;
    }

    public synchronized void eW(List<JSONObject> list) {
        if (this.lHq == null) {
            this.lHq = new ArrayList();
        }
        this.lHq.clear();
        this.lHq.addAll(list);
    }

    public String dod() {
        synchronized (this) {
            if (y.isEmpty(this.lHq)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lHq) {
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            try {
                return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public synchronized void eX(List<JSONObject> list) {
        if (this.lHr == null) {
            this.lHr = new ArrayList();
        }
        this.lHr.clear();
        this.lHr.addAll(list);
    }

    public String doe() {
        synchronized (this) {
            if (y.isEmpty(this.lHr)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lHr) {
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            try {
                return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public synchronized void eY(List<JSONObject> list) {
        if (this.lHs == null) {
            this.lHs = new ArrayList();
        }
        this.lHs.clear();
        this.lHs.addAll(list);
    }

    public String dof() {
        synchronized (this) {
            if (y.isEmpty(this.lHs)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lHs) {
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            try {
                return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public synchronized void dog() {
        if (this.lHs != null) {
            this.lHs.clear();
            this.lHs = null;
        }
    }

    public static JSONObject a(ThreadInfo threadInfo, String str) {
        String str2;
        if (threadInfo == null) {
            return null;
        }
        String str3 = "" + threadInfo.tid;
        String str4 = (StringUtils.isNull(str3) || "0".equals(str3)) ? "" + threadInfo.id : str3;
        if (threadInfo.video_info == null) {
            str2 = "0";
        } else {
            str2 = "" + threadInfo.video_info.video_duration;
        }
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = threadInfo._abstract;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (list.get(i2) != null && list.get(i2).type.intValue() == 0) {
                    sb.append(list.get(i2).text);
                }
                i = i2 + 1;
            }
        }
        String sb2 = sb.toString();
        String str5 = "" + threadInfo.author_id;
        if (threadInfo.author != null && threadInfo.author.id != null && threadInfo.author.id.longValue() != 0) {
            str5 = "" + threadInfo.author.id;
        }
        if (StringUtils.isNull(str)) {
            str = threadInfo.fname;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", threadInfo.title);
            jSONObject.put("tid", str4);
            jSONObject.put("fname", str);
            jSONObject.put("abstract", sb2);
            jSONObject.put("author_id", str5);
            jSONObject.put("video_duration", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject f(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return null;
        }
        return a(threadInfo, threadInfo.fname);
    }
}

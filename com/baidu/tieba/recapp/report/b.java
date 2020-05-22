package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b {
    private static b kOx;
    private List<JSONObject> kOA;
    private List<JSONObject> kOy;
    private List<JSONObject> kOz;

    public static b cVe() {
        if (kOx == null) {
            synchronized (b.class) {
                if (kOx == null) {
                    kOx = new b();
                }
            }
        }
        return kOx;
    }

    public synchronized void es(List<JSONObject> list) {
        if (this.kOy == null) {
            this.kOy = new ArrayList();
        }
        this.kOy.clear();
        this.kOy.addAll(list);
    }

    public String cVf() {
        synchronized (this) {
            if (v.isEmpty(this.kOy)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.kOy) {
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

    public synchronized void et(List<JSONObject> list) {
        if (this.kOz == null) {
            this.kOz = new ArrayList();
        }
        this.kOz.clear();
        this.kOz.addAll(list);
    }

    public String cVg() {
        synchronized (this) {
            if (v.isEmpty(this.kOz)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.kOz) {
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

    public synchronized void eu(List<JSONObject> list) {
        if (this.kOA == null) {
            this.kOA = new ArrayList();
        }
        this.kOA.clear();
        this.kOA.addAll(list);
    }

    public String cVh() {
        synchronized (this) {
            if (v.isEmpty(this.kOA)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.kOA) {
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

    public synchronized void cVi() {
        if (this.kOA != null) {
            this.kOA.clear();
            this.kOA = null;
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

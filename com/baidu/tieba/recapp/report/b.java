package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
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
    private static b ljz;
    private List<JSONObject> ljA;
    private List<JSONObject> ljB;
    private List<JSONObject> ljC;

    public static b cZK() {
        if (ljz == null) {
            synchronized (b.class) {
                if (ljz == null) {
                    ljz = new b();
                }
            }
        }
        return ljz;
    }

    public synchronized void eI(List<JSONObject> list) {
        if (this.ljA == null) {
            this.ljA = new ArrayList();
        }
        this.ljA.clear();
        this.ljA.addAll(list);
    }

    public String cZL() {
        synchronized (this) {
            if (w.isEmpty(this.ljA)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.ljA) {
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

    public synchronized void eJ(List<JSONObject> list) {
        if (this.ljB == null) {
            this.ljB = new ArrayList();
        }
        this.ljB.clear();
        this.ljB.addAll(list);
    }

    public String cZM() {
        synchronized (this) {
            if (w.isEmpty(this.ljB)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.ljB) {
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

    public synchronized void eK(List<JSONObject> list) {
        if (this.ljC == null) {
            this.ljC = new ArrayList();
        }
        this.ljC.clear();
        this.ljC.addAll(list);
    }

    public String cZN() {
        synchronized (this) {
            if (w.isEmpty(this.ljC)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.ljC) {
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

    public synchronized void cZO() {
        if (this.ljC != null) {
            this.ljC.clear();
            this.ljC = null;
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

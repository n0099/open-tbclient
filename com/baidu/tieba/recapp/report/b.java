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
/* loaded from: classes.dex */
public class b {
    private static b lQw;
    private List<JSONObject> lQx;
    private List<JSONObject> lQy;
    private List<JSONObject> lQz;

    public static b drP() {
        if (lQw == null) {
            synchronized (b.class) {
                if (lQw == null) {
                    lQw = new b();
                }
            }
        }
        return lQw;
    }

    public synchronized void fe(List<JSONObject> list) {
        if (this.lQx == null) {
            this.lQx = new ArrayList();
        }
        this.lQx.clear();
        this.lQx.addAll(list);
    }

    public String drQ() {
        synchronized (this) {
            if (y.isEmpty(this.lQx)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lQx) {
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

    public synchronized void ff(List<JSONObject> list) {
        if (this.lQy == null) {
            this.lQy = new ArrayList();
        }
        this.lQy.clear();
        this.lQy.addAll(list);
    }

    public String drR() {
        synchronized (this) {
            if (y.isEmpty(this.lQy)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lQy) {
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

    public synchronized void fg(List<JSONObject> list) {
        if (this.lQz == null) {
            this.lQz = new ArrayList();
        }
        this.lQz.clear();
        this.lQz.addAll(list);
    }

    public String drS() {
        synchronized (this) {
            if (y.isEmpty(this.lQz)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lQz) {
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

    public synchronized void drT() {
        if (this.lQz != null) {
            this.lQz.clear();
            this.lQz = null;
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

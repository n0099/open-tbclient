package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
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
    private static b lqU;
    private List<JSONObject> lqV;
    private List<JSONObject> lqW;
    private List<JSONObject> lqX;

    public static b dcS() {
        if (lqU == null) {
            synchronized (b.class) {
                if (lqU == null) {
                    lqU = new b();
                }
            }
        }
        return lqU;
    }

    public synchronized void eO(List<JSONObject> list) {
        if (this.lqV == null) {
            this.lqV = new ArrayList();
        }
        this.lqV.clear();
        this.lqV.addAll(list);
    }

    public String dcT() {
        synchronized (this) {
            if (x.isEmpty(this.lqV)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lqV) {
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

    public synchronized void eP(List<JSONObject> list) {
        if (this.lqW == null) {
            this.lqW = new ArrayList();
        }
        this.lqW.clear();
        this.lqW.addAll(list);
    }

    public String dcU() {
        synchronized (this) {
            if (x.isEmpty(this.lqW)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lqW) {
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

    public synchronized void eQ(List<JSONObject> list) {
        if (this.lqX == null) {
            this.lqX = new ArrayList();
        }
        this.lqX.clear();
        this.lqX.addAll(list);
    }

    public String dcV() {
        synchronized (this) {
            if (x.isEmpty(this.lqX)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : this.lqX) {
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

    public synchronized void dcW() {
        if (this.lqX != null) {
            this.lqX.clear();
            this.lqX = null;
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

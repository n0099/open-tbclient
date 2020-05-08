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
    private static b kwE;
    private List<JSONObject> kwF;
    private List<JSONObject> kwG;
    private List<JSONObject> kwH;

    public static b cOc() {
        if (kwE == null) {
            synchronized (b.class) {
                if (kwE == null) {
                    kwE = new b();
                }
            }
        }
        return kwE;
    }

    public void el(List<JSONObject> list) {
        if (this.kwF == null) {
            this.kwF = new ArrayList();
        }
        this.kwF.clear();
        this.kwF.addAll(list);
    }

    public String cOd() {
        if (v.isEmpty(this.kwF)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : this.kwF) {
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

    public void em(List<JSONObject> list) {
        if (this.kwG == null) {
            this.kwG = new ArrayList();
        }
        this.kwG.clear();
        this.kwG.addAll(list);
    }

    public String cOe() {
        if (v.isEmpty(this.kwG)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : this.kwG) {
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

    public void en(List<JSONObject> list) {
        if (this.kwH == null) {
            this.kwH = new ArrayList();
        }
        this.kwH.clear();
        this.kwH.addAll(list);
    }

    public String cOf() {
        if (v.isEmpty(this.kwH)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : this.kwH) {
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

    public void cOg() {
        if (this.kwH != null) {
            this.kwH.clear();
            this.kwH = null;
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

    public static JSONObject e(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return null;
        }
        return a(threadInfo, threadInfo.fname);
    }
}

package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b {
    private static b mXt;
    private ConcurrentHashMap<String, List<JSONObject>> mXu = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> mXv = new ConcurrentHashMap<>();

    private b() {
    }

    public static b dEt() {
        if (mXt == null) {
            synchronized (b.class) {
                if (mXt == null) {
                    mXt = new b();
                }
            }
        }
        return mXt;
    }

    public void q(String str, List<JSONObject> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.mXu.put(str, arrayList);
    }

    public String RR(String str) {
        return fM(this.mXu.get(str));
    }

    public void RS(String str) {
        this.mXu.put(str, new ArrayList());
    }

    public void bO(String str, int i) {
        this.mXv.put(str, Integer.valueOf(i));
    }

    public int RT(String str) {
        Integer num = this.mXv.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static JSONObject f(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return null;
        }
        return a(threadInfo, threadInfo.fname);
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
                Abstract r0 = (Abstract) com.baidu.tieba.lego.card.c.a.l(list, i2);
                if (r0 != null && r0.type.intValue() == 0) {
                    sb.append(r0.text);
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
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String fM(List<JSONObject> list) {
        try {
            if (y.isEmpty(list)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : list) {
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            return com.baidu.adp.lib.util.c.encodeBytes(jSONArray.toString().getBytes("UTF-8"));
        } catch (Exception e) {
            return "";
        }
    }
}

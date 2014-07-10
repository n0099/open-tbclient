package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.Hao123Data;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Hao123Model extends com.baidu.adp.base.e {
    public static final String HAO123_KEY = "hao123_cache_data_key";
    private static final int LIKES_MAX_SIZE = 19;

    public static String getHao123Cache() {
        com.baidu.adp.lib.cache.s<String> d = com.baidu.tbadk.core.a.b.a().d();
        if (d != null) {
            return d.a(HAO123_KEY);
        }
        return null;
    }

    public static void setHao123Cache(String str) {
        com.baidu.adp.lib.cache.s<String> d = com.baidu.tbadk.core.a.b.a().d();
        if (d != null) {
            d.a(HAO123_KEY, str);
        }
    }

    public static String getHao123JosnStr(Hao123Data hao123Data) {
        return new Gson().toJson(hao123Data);
    }

    public static Hao123Data parserLikeForums(String str) {
        try {
            return parserLikeForums(new JSONArray(str));
        } catch (Exception e) {
            BdLog.detailException(e);
            return new Hao123Data();
        }
    }

    public static Hao123Data parserLikeForums(JSONArray jSONArray) {
        Hao123Data hao123Data = new Hao123Data();
        if (jSONArray != null) {
            try {
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (TbadkApplication.isLogin()) {
                hao123Data.login = "yes";
                parseBarInfoList(jSONArray, hao123Data.myBa);
                if (hao123Data.myBa.size() >= 19) {
                    hao123Data.more = "yes";
                } else {
                    hao123Data.more = "no";
                }
                return hao123Data;
            }
        }
        hao123Data.login = "no";
        return hao123Data;
    }

    public static void updateSign(String str, boolean z, int i) {
        String hao123Cache = getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) new Gson().fromJson(hao123Cache, (Class<Object>) Hao123Data.class);
            for (Hao123Data.BarInfo barInfo : hao123Data.myBa) {
                if (barInfo.baID.equals(str) && z) {
                    barInfo.qianDao = "yes";
                    barInfo.level = String.valueOf(com.baidu.adp.lib.f.b.a(barInfo.level, 0) + i);
                }
            }
            setHao123Cache(new Gson().toJson(hao123Data));
        }
    }

    public static void addLikeData(String str, String str2, int i) {
        String hao123Cache = getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) new Gson().fromJson(hao123Cache, (Class<Object>) Hao123Data.class);
            List<Hao123Data.BarInfo> list = hao123Data.myBa;
            if (list.size() < 19) {
                boolean z = false;
                for (Hao123Data.BarInfo barInfo : list) {
                    if (barInfo.baID.equals(str)) {
                        z = true;
                    }
                }
                if (!z) {
                    Hao123Data.BarInfo barInfo2 = new Hao123Data.BarInfo();
                    barInfo2.baID = str;
                    barInfo2.baName = str2;
                    barInfo2.level = String.valueOf(i);
                    barInfo2.qianDao = "no";
                    list.add(barInfo2);
                    if (list.size() >= 19) {
                        hao123Data.more = "yes";
                    } else {
                        hao123Data.more = "no";
                    }
                    setHao123Cache(new Gson().toJson(hao123Data));
                }
            }
        }
    }

    public static void parseBarInfoList(JSONArray jSONArray, List<Hao123Data.BarInfo> list) {
        if (jSONArray != null) {
            try {
                int min = Math.min(19, jSONArray.length());
                for (int i = 0; i < min; i++) {
                    list.add(parseBarInfo(jSONArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private static Hao123Data.BarInfo parseBarInfo(JSONObject jSONObject) {
        Hao123Data.BarInfo barInfo = new Hao123Data.BarInfo();
        if (jSONObject != null) {
            try {
                barInfo.baID = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
                barInfo.baName = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
                if (jSONObject.optInt("is_sign", 0) != 0) {
                    barInfo.qianDao = "yes";
                } else {
                    barInfo.qianDao = "";
                }
                barInfo.level = String.valueOf(jSONObject.optInt("level_id", 0));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        return barInfo;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

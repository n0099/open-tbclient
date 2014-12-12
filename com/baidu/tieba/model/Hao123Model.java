package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.data.Hao123Data;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class Hao123Model extends com.baidu.adp.base.f<BaseActivity> {
    public static final String HAO123_KEY = "hao123_cache_data_key";
    private static final int LIKES_MAX_SIZE = 19;
    private static ArrayList<ab> likeForums;

    public Hao123Model() {
    }

    protected Hao123Model(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
    }

    public static String getHao123Cache() {
        com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.hao123");
        if (bV != null) {
            return bV.get(HAO123_KEY);
        }
        return null;
    }

    public static void setHao123Cache(String str) {
        com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.hao123");
        if (bV != null) {
            bV.g(HAO123_KEY, str);
        }
    }

    public static String getHao123JosnStr(Hao123Data hao123Data) {
        return i.jsonStrWithObject(hao123Data);
    }

    public static Hao123Data parserLikeForums(String str) {
        try {
            return parserLikeForums(new JSONArray(str));
        } catch (Exception e) {
            BdLog.detailException(e);
            return new Hao123Data();
        }
    }

    public static Hao123Data parserLikeForumsProtoBuf(List<?> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            likeForums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!(list.get(i) instanceof LikeForum)) {
                    return null;
                }
                ab abVar = new ab();
                abVar.a((LikeForum) list.get(i));
                likeForums.add(abVar);
            }
            return parserLikeForumDataList(likeForums);
        } catch (Exception e) {
            BdLog.detailException(e);
            return new Hao123Data();
        }
    }

    public static Hao123Data parserLikeForumDataList(ArrayList<?> arrayList) {
        Hao123Data hao123Data = new Hao123Data();
        if (arrayList != null) {
            try {
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (TbadkCoreApplication.isLogin()) {
                hao123Data.login = "yes";
                parseBarInfoListFromForumDataList(arrayList, hao123Data.myBa);
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

    public static void parseBarInfoListFromForumDataList(ArrayList<?> arrayList, List<Hao123Data.BarInfo> list) {
        if (arrayList != null) {
            try {
                int min = Math.min(19, arrayList.size());
                for (int i = 0; i < min; i++) {
                    if (arrayList.get(i) instanceof ab) {
                        list.add(parseBarInfoFromForumData((ab) arrayList.get(i)));
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private static Hao123Data.BarInfo parseBarInfoFromForumData(ab abVar) {
        Hao123Data.BarInfo barInfo = new Hao123Data.BarInfo();
        if (abVar != null) {
            try {
                barInfo.baID = abVar.getId();
                barInfo.baName = abVar.getName();
                if (abVar.aeA() != 0) {
                    barInfo.qianDao = "yes";
                } else {
                    barInfo.qianDao = "";
                }
                barInfo.level = String.valueOf(abVar.getLevel());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        return barInfo;
    }

    public static Hao123Data parserLikeForums(JSONArray jSONArray) {
        Hao123Data hao123Data = new Hao123Data();
        if (jSONArray != null) {
            try {
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (TbadkCoreApplication.isLogin()) {
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
            Hao123Data hao123Data = (Hao123Data) i.objectWithJsonStr(hao123Cache, Hao123Data.class);
            for (Hao123Data.BarInfo barInfo : hao123Data.myBa) {
                if (barInfo.baID.equals(str) && z) {
                    barInfo.qianDao = "yes";
                    barInfo.level = String.valueOf(com.baidu.adp.lib.g.c.toInt(barInfo.level, 0) + i);
                }
            }
            setHao123Cache(i.jsonStrWithObject(hao123Data));
        }
    }

    public static void addLikeData(String str, String str2, int i) {
        String hao123Cache = getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) i.objectWithJsonStr(hao123Cache, Hao123Data.class);
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
                    setHao123Cache(i.jsonStrWithObject(hao123Data));
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
                barInfo.baID = jSONObject.optString("forum_id");
                barInfo.baName = jSONObject.optString("forum_name");
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

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}

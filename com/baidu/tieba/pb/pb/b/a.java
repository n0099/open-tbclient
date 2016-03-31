package com.baidu.tieba.pb.pb.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.c.m;
import com.baidu.tbadk.core.c.o;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.e;
import com.baidu.tbadk.core.data.f;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.l;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends o {
    private com.baidu.tbadk.core.data.a dfv;
    private PbActivity dfw;
    private boolean dfx;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(m mVar, com.baidu.tbadk.core.data.a aVar, PbActivity pbActivity) {
        super(mVar);
        this.dfx = false;
        this.dfv = aVar;
        this.dfw = pbActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String pT() {
        return "TBHY_EXT_SeniorLotteryPB";
    }

    public Map<String, Object> avW() {
        HashMap hashMap = new HashMap();
        if (this.dfv != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GroupActivityActivityConfig.ACTIVITY_ID, this.dfv.getActivityId());
            jSONObject.put("status", this.dfv.getStatus());
            jSONObject.put("begin_time", this.dfv.qV());
            jSONObject.put("end_time", this.dfv.qW());
            jSONObject.put("total_num", this.dfv.qX());
            jSONObject.put("show_total_num", this.dfv.rc());
            jSONObject.put("pic_flag", l.qE().qK());
            al rd = this.dfv.rd();
            if (rd != null) {
                z sN = rd.sN();
                if (sN != null) {
                    JSONArray jSONArray = new JSONArray();
                    String si = sN.si();
                    if (!StringUtils.isNull(si)) {
                        String[] split = si.split(",");
                        for (String str : split) {
                            jSONArray.put(str);
                        }
                    }
                    jSONObject.put("color_theme", jSONArray);
                    jSONObject.put("banner_url", sN.sj());
                }
                List<e> sO = rd.sO();
                if (sO != null && sO.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    int size = sO.size();
                    for (int i = 0; i < size; i++) {
                        e eVar = sO.get(i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (eVar != null) {
                            jSONObject2.put("award_id", eVar.rp());
                            jSONObject2.put("award_name", eVar.rq());
                            jSONObject2.put("desc_pic", eVar.rr());
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("award_info", jSONArray2);
                }
                List<f> sQ = rd.sQ();
                if (sQ != null && sQ.size() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    int size2 = sQ.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        f fVar = sQ.get(i2);
                        JSONObject jSONObject3 = new JSONObject();
                        if (fVar != null) {
                            jSONObject3.put("user_id", fVar.getUserId());
                            jSONObject3.put("award_name", fVar.rq());
                            jSONObject3.put("create_time", fVar.rs());
                            jSONObject3.put("user_name", fVar.getUserName());
                        }
                        jSONArray3.put(jSONObject3);
                    }
                    jSONObject.put("lucky_list", jSONArray3);
                }
                jSONObject.put("activity_desc", rd.sR());
                List<y> sS = rd.sS();
                if (sS != null && sS.size() > 0) {
                    JSONArray jSONArray4 = new JSONArray();
                    int size3 = sS.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        y yVar = sS.get(i3);
                        if (yVar != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("regular", yVar.sg());
                            List<Integer> sh = yVar.sh();
                            if (sh != null && sh.size() > 0) {
                                JSONArray jSONArray5 = new JSONArray();
                                int size4 = sh.size();
                                for (int i4 = 0; i4 < size4; i4++) {
                                    jSONArray5.put(sh.get(i4));
                                }
                                jSONObject4.put("chance", jSONArray5);
                            }
                            jSONArray4.put(jSONObject4);
                        }
                    }
                    jSONObject.put("activity_rule", jSONArray4);
                }
                jSONObject.put("my_award_list_url", rd.sP());
            }
            hashMap.put("data", jSONObject);
            hashMap.put("status", 0);
            hashMap.put("message", "");
        } else {
            hashMap.put("status", -1);
            hashMap.put("message", "没有数据");
        }
        return hashMap;
    }

    @p("drawLottery")
    protected JSONObject drawLottery(JSONObject jSONObject) {
        this.dfw.awf();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("status", 0);
        return jSONObject2;
    }

    @p("pageFinish")
    protected void pageFinish(JSONObject jSONObject) {
        this.dfx = true;
        this.dfw.hideLoadingView(this.dfw.awi().getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avX() {
        return this.dfx;
    }

    @p("drawFinish")
    protected void drawFinish(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("message");
            this.dfw.J(jSONObject.optInt("status"), optString);
            return;
        }
        this.dfw.J(5, null);
    }
}

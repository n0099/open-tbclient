package com.baidu.tieba.pb.pb.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.c.o;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends o {
    private a dfZ;
    private com.baidu.tbadk.core.data.a dhX;
    private PbActivity dhY;
    private boolean dhZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(com.baidu.tbadk.core.c.m mVar, com.baidu.tbadk.core.data.a aVar, PbActivity pbActivity) {
        super(mVar);
        this.dhZ = false;
        this.dhX = aVar;
        this.dhY = pbActivity;
        this.dfZ = new a(pbActivity, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String nj() {
        return "TBHY_EXT_SeniorLotteryPB";
    }

    public Map<String, Object> awm() {
        HashMap hashMap = new HashMap();
        if (this.dhX != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GroupActivityActivityConfig.ACTIVITY_ID, this.dhX.getActivityId());
            jSONObject.put("status", this.dhX.getStatus());
            jSONObject.put("begin_time", this.dhX.os());
            jSONObject.put(ThActivityDetailActivityConfig.END_TIME, this.dhX.ot());
            jSONObject.put("total_num", this.dhX.ou());
            jSONObject.put("show_total_num", this.dhX.oy());
            jSONObject.put("pic_flag", com.baidu.tbadk.core.l.ob().oh());
            aq oz = this.dhX.oz();
            if (oz != null) {
                aa qm = oz.qm();
                if (qm != null) {
                    JSONArray jSONArray = new JSONArray();
                    String pC = qm.pC();
                    if (!StringUtils.isNull(pC)) {
                        String[] split = pC.split(",");
                        for (String str : split) {
                            jSONArray.put(str);
                        }
                    }
                    jSONObject.put("color_theme", jSONArray);
                    jSONObject.put("banner_url", qm.pD());
                }
                List<com.baidu.tbadk.core.data.e> qn = oz.qn();
                if (qn != null && qn.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    int size = qn.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.core.data.e eVar = qn.get(i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (eVar != null) {
                            jSONObject2.put("award_id", eVar.oJ());
                            jSONObject2.put("award_name", eVar.oK());
                            jSONObject2.put("desc_pic", eVar.oL());
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("award_info", jSONArray2);
                }
                List<com.baidu.tbadk.core.data.f> qp = oz.qp();
                if (qp != null && qp.size() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    int size2 = qp.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        com.baidu.tbadk.core.data.f fVar = qp.get(i2);
                        JSONObject jSONObject3 = new JSONObject();
                        if (fVar != null) {
                            jSONObject3.put("user_id", fVar.getUserId());
                            jSONObject3.put("award_name", fVar.oK());
                            jSONObject3.put("create_time", fVar.oM());
                            jSONObject3.put("user_name", fVar.getUserName());
                        }
                        jSONArray3.put(jSONObject3);
                    }
                    jSONObject.put("lucky_list", jSONArray3);
                }
                jSONObject.put("activity_desc", oz.qq());
                List<z> qr = oz.qr();
                if (qr != null && qr.size() > 0) {
                    JSONArray jSONArray4 = new JSONArray();
                    int size3 = qr.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        z zVar = qr.get(i3);
                        if (zVar != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("regular", zVar.pA());
                            List<Integer> pB = zVar.pB();
                            if (pB != null && pB.size() > 0) {
                                JSONArray jSONArray5 = new JSONArray();
                                int size4 = pB.size();
                                for (int i4 = 0; i4 < size4; i4++) {
                                    jSONArray5.put(pB.get(i4));
                                }
                                jSONObject4.put("chance", jSONArray5);
                            }
                            jSONArray4.put(jSONObject4);
                        }
                    }
                    jSONObject.put("activity_rule", jSONArray4);
                }
                jSONObject.put("my_award_list_url", oz.qo());
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

    @p(sD = "drawLottery")
    protected JSONObject drawLottery(JSONObject jSONObject) {
        this.dfZ.awj();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("status", 0);
        return jSONObject2;
    }

    @p(sD = "pageFinish")
    protected void pageFinish(JSONObject jSONObject) {
        this.dhZ = true;
        this.dhY.hideLoadingView(this.dhY.awt().getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awn() {
        return this.dhZ;
    }

    @p(sD = "drawFinish")
    protected void drawFinish(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("message");
            this.dfZ.H(jSONObject.optInt("status"), optString);
            return;
        }
        this.dfZ.H(5, null);
    }
}

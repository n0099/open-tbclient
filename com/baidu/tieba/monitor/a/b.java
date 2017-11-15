package com.baidu.tieba.monitor.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.monitor.VideoMonitorStatic;
import com.baidu.tieba.monitor.a.c;
import com.baidu.tieba.monitor.b.e;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a {
    private final int exS;
    private final int exT;
    private final long exU;
    private e[] exV;
    private final int what;

    public b(int i, int i2, int i3, long j, e... eVarArr) {
        super(300);
        this.exS = i;
        this.what = i2;
        this.exT = i3;
        this.exU = j;
        this.exV = eVarArr;
    }

    @Override // com.baidu.tieba.monitor.a.c.a, com.baidu.tieba.monitor.a.c
    public JSONObject aNo() {
        JSONObject aNo = super.aNo();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.exS, this.what, this.exT, this.exU).toString()));
            if (this.exV != null) {
                int length = this.exV.length;
                for (int i = 0; i < length; i++) {
                    e eVar = this.exV[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.monitor.b.oH(eVar.url).toString()));
                    }
                }
            }
            aNo.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNo;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(d.j.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(d.j.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(d.j.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoMonitorStatic.pd(i2));
            jSONObject.put("extra", i3 + "  " + VideoMonitorStatic.pd(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

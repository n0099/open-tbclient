package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a {
    private final long fRP;
    private final String fRQ;
    private com.baidu.tieba.j.a.e[] fRR;
    private final int fRm;
    private final int fRn;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.fRm = i;
        this.what = i2;
        this.fRn = i3;
        this.fRP = j;
        this.fRQ = str;
        this.fRR = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bhi() {
        JSONObject bhi = super.bhi();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.fRm, this.what, this.fRn, this.fRP).toString()));
            if (this.fRR != null) {
                int length = this.fRR.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.fRR[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.pz(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.fRQ)) {
                jSONArray.put(new JSONObject().put("error_parent", this.fRQ));
            }
            bhi.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bhi;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(d.k.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(d.k.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(d.k.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gk(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gk(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

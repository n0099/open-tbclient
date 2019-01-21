package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.e;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends c.a {
    private final long gJO;
    private final String gJP;
    private com.baidu.tieba.j.a.e[] gJQ;
    private final int gJj;
    private final int gJk;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gJj = i;
        this.what = i2;
        this.gJk = i3;
        this.gJO = j;
        this.gJP = str;
        this.gJQ = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject btE() {
        JSONObject btE = super.btE();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", c(this.gJj, this.what, this.gJk, this.gJO).toString()));
            if (this.gJQ != null) {
                int length = this.gJQ.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gJQ[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.sn(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gJP)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gJP));
            }
            btE.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btE;
    }

    public static JSONObject c(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(e.j.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(e.j.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(e.j.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.hB(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.hB(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

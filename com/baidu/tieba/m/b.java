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
    private final long gFS;
    private final String gFT;
    private com.baidu.tieba.j.a.e[] gFU;
    private final int gFn;
    private final int gFo;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gFn = i;
        this.what = i2;
        this.gFo = i3;
        this.gFS = j;
        this.gFT = str;
        this.gFU = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bsk() {
        JSONObject bsk = super.bsk();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", c(this.gFn, this.what, this.gFo, this.gFS).toString()));
            if (this.gFU != null) {
                int length = this.gFU.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gFU[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.rU(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gFT)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gFT));
            }
            bsk.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bsk;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.hA(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.hA(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

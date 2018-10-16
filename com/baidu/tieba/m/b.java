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
    private final int gwV;
    private final int gwW;
    private final long gxA;
    private final String gxB;
    private com.baidu.tieba.j.a.e[] gxC;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gwV = i;
        this.what = i2;
        this.gwW = i3;
        this.gxA = j;
        this.gxB = str;
        this.gxC = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bqV() {
        JSONObject bqV = super.bqV();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", b(this.gwV, this.what, this.gwW, this.gxA).toString()));
            if (this.gxC != null) {
                int length = this.gxC.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gxC[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.rr(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gxB)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gxB));
            }
            bqV.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bqV;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gZ(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gZ(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

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
    private final int gyx;
    private final int gyy;
    private final long gzc;
    private final String gzd;
    private com.baidu.tieba.j.a.e[] gze;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gyx = i;
        this.what = i2;
        this.gyy = i3;
        this.gzc = j;
        this.gzd = str;
        this.gze = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bqr() {
        JSONObject bqr = super.bqr();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", c(this.gyx, this.what, this.gyy, this.gzc).toString()));
            if (this.gze != null) {
                int length = this.gze.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gze[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.rs(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gzd)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gzd));
            }
            bqr.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bqr;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.hm(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.hm(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

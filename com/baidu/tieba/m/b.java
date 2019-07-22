package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends c.a {
    private final String iAa;
    private com.baidu.tieba.j.a.e[] iAb;
    private final long izZ;
    private final int izs;
    private final int izt;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.izs = i;
        this.what = i2;
        this.izt = i3;
        this.izZ = j;
        this.iAa = str;
        this.iAb = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cfj() {
        JSONObject cfj = super.cfj();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, c(this.izs, this.what, this.izt, this.izZ).toString()));
            if (this.iAb != null) {
                int length = this.iAb.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.iAb[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.AS(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.iAa)) {
                jSONArray.put(new JSONObject().put("error_parent", this.iAa));
            }
            cfj.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cfj;
    }

    public static JSONObject c(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(R.string.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(R.string.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.mm(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.mm(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

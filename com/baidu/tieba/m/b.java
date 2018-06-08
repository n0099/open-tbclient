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
    private final int gdB;
    private final int gdC;
    private final long gef;
    private final String geg;
    private com.baidu.tieba.j.a.e[] geh;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gdB = i;
        this.what = i2;
        this.gdC = i3;
        this.gef = j;
        this.geg = str;
        this.geh = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bmg() {
        JSONObject bmg = super.bmg();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.gdB, this.what, this.gdC, this.gef).toString()));
            if (this.geh != null) {
                int length = this.geh.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.geh[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.qq(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.geg)) {
                jSONArray.put(new JSONObject().put("error_parent", this.geg));
            }
            bmg.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmg;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gm(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gm(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

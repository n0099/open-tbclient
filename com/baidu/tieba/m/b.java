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
    private final int ghC;
    private final int ghD;
    private final long gih;
    private final String gii;
    private com.baidu.tieba.j.a.e[] gij;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.ghC = i;
        this.what = i2;
        this.ghD = i3;
        this.gih = j;
        this.gii = str;
        this.gij = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bmK() {
        JSONObject bmK = super.bmK();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.ghC, this.what, this.ghD, this.gih).toString()));
            if (this.gij != null) {
                int length = this.gij.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gij[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.qq(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gii)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gii));
            }
            bmK.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmK;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gn(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gn(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

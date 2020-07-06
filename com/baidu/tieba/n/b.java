package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c.a {
    private final int kXU;
    private final int kXV;
    private final long kYB;
    private final String kYC;
    private com.baidu.tieba.k.a.e[] kYD;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.kXU = i;
        this.what = i2;
        this.kXV = i3;
        this.kYB = j;
        this.kYC = str;
        this.kYD = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cWy() {
        JSONObject cWy = super.cWy();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", d(this.kXU, this.what, this.kXV, this.kYB).toString()));
            if (this.kYD != null) {
                int length = this.kYD.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.kYD[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.IR(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.kYC)) {
                jSONArray.put(new JSONObject().put("error_parent", this.kYC));
            }
            cWy.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cWy;
    }

    public static JSONObject d(int i, int i2, int i3, long j) {
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.px(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.px(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

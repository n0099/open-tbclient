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
    private final int kkV;
    private final int kkW;
    private final long klC;
    private final String klD;
    private com.baidu.tieba.k.a.e[] klE;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.kkV = i;
        this.what = i2;
        this.kkW = i3;
        this.klC = j;
        this.klD = str;
        this.klE = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cKQ() {
        JSONObject cKQ = super.cKQ();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", d(this.kkV, this.what, this.kkW, this.klC).toString()));
            if (this.klE != null) {
                int length = this.klE.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.klE[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.GF(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.klD)) {
                jSONArray.put(new JSONObject().put("error_parent", this.klD));
            }
            cKQ.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cKQ;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.op(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.op(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

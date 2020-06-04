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
    private final int kDY;
    private final int kDZ;
    private final long kEF;
    private final String kEG;
    private com.baidu.tieba.k.a.e[] kEH;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.kDY = i;
        this.what = i2;
        this.kDZ = i3;
        this.kEF = j;
        this.kEG = str;
        this.kEH = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cSh() {
        JSONObject cSh = super.cSh();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", d(this.kDY, this.what, this.kDZ, this.kEF).toString()));
            if (this.kEH != null) {
                int length = this.kEH.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.kEH[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.Ip(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.kEG)) {
                jSONArray.put(new JSONObject().put("error_parent", this.kEG));
            }
            cSh.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cSh;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.oY(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.oY(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

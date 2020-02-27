package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c.a {
    private final int jyZ;
    private final long jzG;
    private final String jzH;
    private com.baidu.tieba.k.a.e[] jzI;
    private final int jza;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.jyZ = i;
        this.what = i2;
        this.jza = i3;
        this.jzG = j;
        this.jzH = str;
        this.jzI = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject czM() {
        JSONObject czM = super.czM();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.jyZ, this.what, this.jza, this.jzG).toString()));
            if (this.jzI != null) {
                int length = this.jzI.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.jzI[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.EU(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.jzH)) {
                jSONArray.put(new JSONObject().put("error_parent", this.jzH));
            }
            czM.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return czM;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.oa(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.oa(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

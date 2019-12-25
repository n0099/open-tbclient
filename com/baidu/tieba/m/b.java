package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends c.a {
    private final int juC;
    private final int juD;
    private final long jvj;
    private final String jvk;
    private com.baidu.tieba.j.a.e[] jvl;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.juC = i;
        this.what = i2;
        this.juD = i3;
        this.jvj = j;
        this.jvk = str;
        this.jvl = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cxi() {
        JSONObject cxi = super.cxi();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.juC, this.what, this.juD, this.jvj).toString()));
            if (this.jvl != null) {
                int length = this.jvl.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.jvl[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.Eu(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.jvk)) {
                jSONArray.put(new JSONObject().put("error_parent", this.jvk));
            }
            cxi.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cxi;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.nJ(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.nJ(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

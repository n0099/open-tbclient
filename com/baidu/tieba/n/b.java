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
    private final long jzU;
    private final String jzV;
    private com.baidu.tieba.k.a.e[] jzW;
    private final int jzn;
    private final int jzo;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.jzn = i;
        this.what = i2;
        this.jzo = i3;
        this.jzU = j;
        this.jzV = str;
        this.jzW = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject czP() {
        JSONObject czP = super.czP();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.jzn, this.what, this.jzo, this.jzU).toString()));
            if (this.jzW != null) {
                int length = this.jzW.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.jzW[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.EV(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.jzV)) {
                jSONArray.put(new JSONObject().put("error_parent", this.jzV));
            }
            czP.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return czP;
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

package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends c.a {
    private final long jyL;
    private final String jyM;
    private com.baidu.tieba.j.a.e[] jyN;
    private final int jye;
    private final int jyf;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.jye = i;
        this.what = i2;
        this.jyf = i3;
        this.jyL = j;
        this.jyM = str;
        this.jyN = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cyp() {
        JSONObject cyp = super.cyp();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.jye, this.what, this.jyf, this.jyL).toString()));
            if (this.jyN != null) {
                int length = this.jyN.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.jyN[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.EE(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.jyM)) {
                jSONArray.put(new JSONObject().put("error_parent", this.jyM));
            }
            cyp.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cyp;
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

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
    private final int iAw;
    private final int iAx;
    private final long iBd;
    private final String iBe;
    private com.baidu.tieba.j.a.e[] iBf;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.iAw = i;
        this.what = i2;
        this.iAx = i3;
        this.iBd = j;
        this.iBe = str;
        this.iBf = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cfB() {
        JSONObject cfB = super.cfB();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, c(this.iAw, this.what, this.iAx, this.iBd).toString()));
            if (this.iBf != null) {
                int length = this.iBf.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.iBf[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.AT(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.iBe)) {
                jSONArray.put(new JSONObject().put("error_parent", this.iBe));
            }
            cfB.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cfB;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.mn(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.mn(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

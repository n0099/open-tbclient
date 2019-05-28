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
    private final long itH;
    private final String itI;
    private com.baidu.tieba.j.a.e[] itJ;
    private final int ita;
    private final int itb;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.ita = i;
        this.what = i2;
        this.itb = i3;
        this.itH = j;
        this.itI = str;
        this.itJ = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject ccs() {
        JSONObject ccs = super.ccs();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, c(this.ita, this.what, this.itb, this.itH).toString()));
            if (this.itJ != null) {
                int length = this.itJ.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.itJ[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.Af(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.itI)) {
                jSONArray.put(new JSONObject().put("error_parent", this.itI));
            }
            ccs.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ccs;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.mf(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.mf(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

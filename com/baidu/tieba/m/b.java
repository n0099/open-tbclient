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
    private final int iCO;
    private final int iCP;
    private final long iDv;
    private final String iDw;
    private com.baidu.tieba.j.a.e[] iDx;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.iCO = i;
        this.what = i2;
        this.iCP = i3;
        this.iDv = j;
        this.iDw = str;
        this.iDx = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cgp() {
        JSONObject cgp = super.cgp();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, c(this.iCO, this.what, this.iCP, this.iDv).toString()));
            if (this.iDx != null) {
                int length = this.iDx.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.iDx[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.Bs(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.iDw)) {
                jSONArray.put(new JSONObject().put("error_parent", this.iDw));
            }
            cgp.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cgp;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.mr(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.mr(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

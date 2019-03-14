package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends c.a {
    private final int iaE;
    private final int iaF;
    private final long ibn;
    private final String ibo;
    private com.baidu.tieba.j.a.e[] ibp;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.iaE = i;
        this.what = i2;
        this.iaF = i3;
        this.ibn = j;
        this.ibo = str;
        this.ibp = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bUs() {
        JSONObject bUs = super.bUs();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, c(this.iaE, this.what, this.iaF, this.ibn).toString()));
            if (this.ibp != null) {
                int length = this.ibp.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.ibp[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.yQ(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.ibo)) {
                jSONArray.put(new JSONObject().put("error_parent", this.ibo));
            }
            bUs.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bUs;
    }

    public static JSONObject c(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(d.j.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(d.j.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(d.j.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.lr(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.lr(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

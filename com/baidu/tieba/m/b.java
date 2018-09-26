package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.e;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a {
    private final long gpZ;
    private final int gpu;
    private final int gpv;
    private final String gqa;
    private com.baidu.tieba.j.a.e[] gqb;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gpu = i;
        this.what = i2;
        this.gpv = i3;
        this.gpZ = j;
        this.gqa = str;
        this.gqb = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bnG() {
        JSONObject bnG = super.bnG();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.gpu, this.what, this.gpv, this.gpZ).toString()));
            if (this.gqb != null) {
                int length = this.gqb.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.gqb[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.qQ(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gqa)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gqa));
            }
            bnG.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bnG;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(e.j.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(e.j.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(e.j.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gR(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gR(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

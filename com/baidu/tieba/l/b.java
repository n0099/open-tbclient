package com.baidu.tieba.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.l.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a {
    private final long guY;
    private final String guZ;
    private final int guu;
    private final int guv;
    private com.baidu.tieba.i.a.e[] gva;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.i.a.e... eVarArr) {
        super(300);
        this.guu = i;
        this.what = i2;
        this.guv = i3;
        this.guY = j;
        this.guZ = str;
        this.gva = eVarArr;
    }

    @Override // com.baidu.tieba.l.c.a, com.baidu.tieba.l.c
    public JSONObject bkO() {
        JSONObject bkO = super.bkO();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.guu, this.what, this.guv, this.guY).toString()));
            if (this.gva != null) {
                int length = this.gva.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.i.a.e eVar = this.gva[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.i.d.pd(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.guZ)) {
                jSONArray.put(new JSONObject().put("error_parent", this.guZ));
            }
            bkO.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bkO;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.jq(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.jq(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

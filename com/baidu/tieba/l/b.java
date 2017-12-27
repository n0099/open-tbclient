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
    private final long gFP;
    private final String gFQ;
    private com.baidu.tieba.i.a.e[] gFR;
    private final int gFm;
    private final int gFn;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.i.a.e... eVarArr) {
        super(300);
        this.gFm = i;
        this.what = i2;
        this.gFn = i3;
        this.gFP = j;
        this.gFQ = str;
        this.gFR = eVarArr;
    }

    @Override // com.baidu.tieba.l.c.a, com.baidu.tieba.l.c
    public JSONObject brv() {
        JSONObject brv = super.brv();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.gFm, this.what, this.gFn, this.gFP).toString()));
            if (this.gFR != null) {
                int length = this.gFR.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.i.a.e eVar = this.gFR[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.i.d.pa(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.gFQ)) {
                jSONArray.put(new JSONObject().put("error_parent", this.gFQ));
            }
            brv.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brv;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.ju(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.ju(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

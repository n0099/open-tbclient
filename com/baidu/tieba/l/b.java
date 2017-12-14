package com.baidu.tieba.l;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.l.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a {
    private final int fRA;
    private final int fRz;
    private final long fSa;
    private com.baidu.tieba.i.a.e[] fSb;
    private final int what;

    public b(int i, int i2, int i3, long j, com.baidu.tieba.i.a.e... eVarArr) {
        super(300);
        this.fRz = i;
        this.what = i2;
        this.fRA = i3;
        this.fSa = j;
        this.fSb = eVarArr;
    }

    @Override // com.baidu.tieba.l.c.a, com.baidu.tieba.l.c
    public JSONObject bjQ() {
        JSONObject bjQ = super.bjQ();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.fRz, this.what, this.fRA, this.fSa).toString()));
            if (this.fSb != null) {
                int length = this.fSb.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.i.a.e eVar = this.fSb[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.i.d.oQ(eVar.url).toString()));
                    }
                }
            }
            bjQ.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bjQ;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gv(i2));
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_EXTRA, i3 + "  " + VideoPlatformStatic.gv(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

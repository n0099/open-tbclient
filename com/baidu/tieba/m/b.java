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
    private final long iBR;
    private final String iBS;
    private com.baidu.tieba.j.a.e[] iBT;
    private final int iBk;
    private final int iBl;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.iBk = i;
        this.what = i2;
        this.iBl = i3;
        this.iBR = j;
        this.iBS = str;
        this.iBT = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cdp() {
        JSONObject cdp = super.cdp();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.iBk, this.what, this.iBl, this.iBR).toString()));
            if (this.iBT != null) {
                int length = this.iBT.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.iBT[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.zM(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.iBS)) {
                jSONArray.put(new JSONObject().put("error_parent", this.iBS));
            }
            cdp.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdp;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.lw(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.lw(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

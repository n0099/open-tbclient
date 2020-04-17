package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c.a {
    private final int kkR;
    private final int kkS;
    private com.baidu.tieba.k.a.e[] klA;
    private final long kly;
    private final String klz;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.kkR = i;
        this.what = i2;
        this.kkS = i3;
        this.kly = j;
        this.klz = str;
        this.klA = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cKT() {
        JSONObject cKT = super.cKT();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.kkR, this.what, this.kkS, this.kly).toString()));
            if (this.klA != null) {
                int length = this.klA.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.klA[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.GC(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.klz)) {
                jSONArray.put(new JSONObject().put("error_parent", this.klz));
            }
            cKT.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cKT;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.op(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.op(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

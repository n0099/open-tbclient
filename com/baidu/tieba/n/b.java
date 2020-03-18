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
    private final int jAM;
    private final int jAN;
    private final long jBt;
    private final String jBu;
    private com.baidu.tieba.k.a.e[] jBv;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.jAM = i;
        this.what = i2;
        this.jAN = i3;
        this.jBt = j;
        this.jBu = str;
        this.jBv = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cAj() {
        JSONObject cAj = super.cAj();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.jAM, this.what, this.jAN, this.jBt).toString()));
            if (this.jBv != null) {
                int length = this.jBv.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.jBv[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.EU(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.jBu)) {
                jSONArray.put(new JSONObject().put("error_parent", this.jBu));
            }
            cAj.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cAj;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.oc(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.oc(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

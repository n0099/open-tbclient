package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c.a {
    private final int kCQ;
    private final int kCR;
    private final long kDx;
    private final String kDy;
    private com.baidu.tieba.k.a.e[] kDz;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.k.a.e... eVarArr) {
        super(300);
        this.kCQ = i;
        this.what = i2;
        this.kCR = i3;
        this.kDx = j;
        this.kDy = str;
        this.kDz = eVarArr;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cRR() {
        JSONObject cRR = super.cRR();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("error_msg", d(this.kCQ, this.what, this.kCR, this.kDx).toString()));
            if (this.kDz != null) {
                int length = this.kDz.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.k.a.e eVar = this.kDz[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.k.d.Io(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.kDy)) {
                jSONArray.put(new JSONObject().put("error_parent", this.kDy));
            }
            cRR.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cRR;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.oW(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.oW(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

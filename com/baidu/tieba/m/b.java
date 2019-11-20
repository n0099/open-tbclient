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
    private final int iAt;
    private final int iAu;
    private final long iBa;
    private final String iBb;
    private com.baidu.tieba.j.a.e[] iBc;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.iAt = i;
        this.what = i2;
        this.iAu = i3;
        this.iBa = j;
        this.iBb = str;
        this.iBc = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cdn() {
        JSONObject cdn = super.cdn();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, d(this.iAt, this.what, this.iAu, this.iBa).toString()));
            if (this.iBc != null) {
                int length = this.iBc.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.iBc[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.zM(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.iBb)) {
                jSONArray.put(new JSONObject().put("error_parent", this.iBb));
            }
            cdn.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdn;
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
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.lv(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.lv(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

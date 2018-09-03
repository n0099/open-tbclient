package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.f;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a {
    private final long giH;
    private final String giI;
    private com.baidu.tieba.j.a.e[] giJ;
    private final int gib;
    private final int gic;
    private final int what;

    public b(int i, int i2, int i3, long j, String str, com.baidu.tieba.j.a.e... eVarArr) {
        super(300);
        this.gib = i;
        this.what = i2;
        this.gic = i3;
        this.giH = j;
        this.giI = str;
        this.giJ = eVarArr;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bla() {
        JSONObject bla = super.bla();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b(this.gib, this.what, this.gic, this.giH).toString()));
            if (this.giJ != null) {
                int length = this.giJ.length;
                for (int i = 0; i < length; i++) {
                    com.baidu.tieba.j.a.e eVar = this.giJ[i];
                    if (eVar != null) {
                        jSONArray.put(new JSONObject().put(eVar.key, com.baidu.tieba.j.d.ql(eVar.url).toString()));
                    }
                }
            }
            if (!StringUtils.isNull(this.giI)) {
                jSONArray.put(new JSONObject().put("error_parent", this.giI));
            }
            bla.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bla;
    }

    public static JSONObject b(int i, int i2, int i3, long j) {
        String string;
        JSONObject jSONObject = new JSONObject();
        if (i == -200) {
            string = TbadkCoreApplication.getInst().getString(f.j.player_ijk);
        } else if (i == -100) {
            string = TbadkCoreApplication.getInst().getString(f.j.player_system);
        } else {
            string = TbadkCoreApplication.getInst().getString(f.j.player_unknown);
        }
        try {
            jSONObject.put("player", string);
            jSONObject.put("what", i2 + "  " + VideoPlatformStatic.gr(i2));
            jSONObject.put("extra", i3 + "  " + VideoPlatformStatic.gr(i3));
            if (j != 0) {
                jSONObject.put("speed", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i implements u {
    public static final BdUniqueId dWK = BdUniqueId.gen();
    public List<j> dWL = new ArrayList();
    public String dWM;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dWK;
    }

    public static i e(DataRes.Builder builder) {
        j a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        i iVar = new i();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = j.a(tagStruct)) != null) {
                iVar.dWL.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < iVar.dWL.size()) {
                j jVar = iVar.dWL.get(i2);
                if (jVar != null && !StringUtils.isNull(jVar.dWN)) {
                    sb.append(jVar.dWN);
                    if (i2 != iVar.dWL.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                iVar.dWM = sb.toString();
                return iVar;
            }
        }
    }
}

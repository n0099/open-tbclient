package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class j {
    public String dWN;
    public boolean dWO;

    public static j a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        j jVar = new j();
        jVar.dWN = tagStruct.tag_name;
        jVar.dWO = tagStruct.selected.intValue() == 1;
        return jVar;
    }
}

package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class a {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            ar arVar = new ar(str);
            arVar.ap("obj_locate", i);
            arVar.v("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsO();
        }
    }
}

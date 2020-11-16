package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes20.dex */
public class a {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            ar arVar = new ar(str);
            arVar.ak("obj_locate", i);
            arVar.w("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bqy();
        }
    }
}

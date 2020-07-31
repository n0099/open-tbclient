package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes15.dex */
public class a {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            ap apVar = new ap(str);
            apVar.ah("obj_locate", i);
            apVar.t("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.baO();
        }
    }
}

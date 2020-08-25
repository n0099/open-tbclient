package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes15.dex */
public class a {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            aq aqVar = new aq(str);
            aqVar.ai("obj_locate", i);
            aqVar.u("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bjn();
        }
    }
}

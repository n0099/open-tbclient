package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes7.dex */
public class a {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            aq aqVar = new aq(str);
            aqVar.an("obj_locate", i);
            aqVar.w("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bsu();
        }
    }
}

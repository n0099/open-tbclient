package com.baidu.tieba.newlist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class a {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.newlist.b.b) {
            ao aoVar = new ao(str);
            aoVar.ag("obj_locate", i);
            aoVar.s("topic_id", ((com.baidu.tieba.newlist.b.b) obj).topicId);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.aWN();
        }
    }
}

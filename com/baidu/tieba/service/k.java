package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class k implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<String> a(com.baidu.adp.framework.message.a<String> aVar) {
        String a = aVar.a();
        Intent intent = new Intent(TbadkApplication.j(), TiebaMessageService.class);
        if ("start".equals(a)) {
            com.baidu.tieba.r.c();
            if (com.baidu.tieba.r.p()) {
                TbadkApplication.j().startService(intent);
                return null;
            }
            return null;
        } else if ("start_once".equals(a)) {
            com.baidu.tieba.r.c();
            if (com.baidu.tieba.r.p()) {
                intent.putExtra("getMessageAtOnce", true);
                TbadkApplication.j().startService(intent);
                return null;
            }
            return null;
        } else if ("stop".equals(a)) {
            TbadkApplication.j().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}

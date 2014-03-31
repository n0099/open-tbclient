package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class c implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<String> a(com.baidu.adp.framework.message.a<String> aVar) {
        String a = aVar.a();
        Intent intent = new Intent(TbadkApplication.j(), FatalErrorService.class);
        if ("start".equals(a)) {
            TbadkApplication.j().startService(intent);
            return null;
        } else if ("stop".equals(a)) {
            TbadkApplication.j().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}

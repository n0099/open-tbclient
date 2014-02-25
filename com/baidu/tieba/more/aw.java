package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ au a;

    private aw(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(au auVar, aw awVar) {
        this(auVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        super.a((aw) str);
        this.a.b = null;
        iVar = this.a.e;
        if (iVar != null) {
            iVar2 = this.a.e;
            iVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.tieba.im.c.a.f().d();
        com.baidu.tieba.im.c.a.f().b((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.c.a.f().c((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.c.a.f().b(false, null);
        TiebaSocketLinkService.a(true, "clear cache");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String A = TiebaApplication.A();
        if (!TextUtils.isEmpty(A)) {
            com.baidu.tieba.im.db.g.a(A);
        }
        com.baidu.tieba.im.db.h.a().e();
        return null;
    }
}

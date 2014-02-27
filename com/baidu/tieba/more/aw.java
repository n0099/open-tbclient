package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ au a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String v = TiebaApplication.v();
        if (!TextUtils.isEmpty(v)) {
            com.baidu.tieba.im.db.g.a(v);
        }
        com.baidu.tieba.im.db.h.a().e();
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        super.a((aw) str);
        this.a.b = null;
        iVar = this.a.e;
        if (iVar != null) {
            iVar2 = this.a.e;
            iVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.tieba.im.c.a.d().b();
        com.baidu.tieba.im.c.a.d().a((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.c.a.d().b((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.c.a.d().b(false, null);
        TiebaSocketLinkService.a(true, "clear cache");
    }

    private aw(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(au auVar, byte b) {
        this(auVar);
    }
}

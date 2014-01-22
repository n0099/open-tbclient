package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ av a;

    private ay(av avVar) {
        this.a = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ay) str);
        this.a.b = null;
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.tieba.im.db.ae.a().c();
        com.baidu.tieba.im.c.a.h().f();
        com.baidu.tieba.im.c.a.h().b((RecentChatFriendData) null);
        com.baidu.tieba.im.c.a.h().c((RecentChatFriendData) null);
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
        TiebaSocketLinkService.a(true, "clear cache");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String A = TiebaApplication.A();
        if (!TextUtils.isEmpty(A)) {
            com.baidu.tieba.im.db.s.a(A);
            return null;
        }
        return null;
    }
}

package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f2002a;

    private ba(ax axVar) {
        this.f2002a = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ba) str);
        this.f2002a.b = null;
        gVar = this.f2002a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f2002a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.tieba.im.db.x.a().b();
        com.baidu.tieba.im.pushNotify.a.g().e();
        com.baidu.tieba.im.pushNotify.a.g().b((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.g().c((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
        TiebaSocketLinkService.a(true, "clear cache");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String C = TiebaApplication.C();
        if (!TextUtils.isEmpty(C)) {
            com.baidu.tieba.im.db.m.a(C);
            return null;
        }
        return null;
    }
}

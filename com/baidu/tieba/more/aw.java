package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f2084a;

    private aw(at atVar) {
        this.f2084a = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((aw) str);
        this.f2084a.b = null;
        gVar = this.f2084a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f2084a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.tieba.im.db.ad.a().c();
        com.baidu.tieba.im.pushNotify.a.h().f();
        com.baidu.tieba.im.pushNotify.a.h().b((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.h().c((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
        TiebaSocketLinkService.a(true, "clear cache");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String B = TiebaApplication.B();
        if (!TextUtils.isEmpty(B)) {
            com.baidu.tieba.im.db.s.a(B);
            return null;
        }
        return null;
    }
}

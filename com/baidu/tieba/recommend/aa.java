package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1630a;

    private aa(z zVar) {
        this.f1630a = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(z zVar, aa aaVar) {
        this(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/f/forum/recommendupdate");
            uVar.c(false);
            String optString = new JSONObject(uVar.k()).optString("date");
            String bc = TiebaApplication.f().bc();
            if (optString != null && !optString.equals(bc)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        Context context;
        super.a((Object) bool);
        if (bool.booleanValue()) {
            TiebaApplication.f().w(true);
            context = this.f1630a.f1681a;
            context.sendBroadcast(new Intent("com.baidu.tieba.broadcast.newrecommends"));
            return;
        }
        TiebaApplication.f().w(false);
    }
}

package com.baidu.tieba.topRec;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, TRForumListData> {

    /* renamed from: a  reason: collision with root package name */
    TRForumListData f2556a;
    final /* synthetic */ l b;
    private am c;

    private n(l lVar) {
        this.b = lVar;
        this.c = null;
        this.f2556a = new TRForumListData();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public TRForumListData a(Object... objArr) {
        String l;
        try {
            this.c = new am(com.baidu.tieba.data.h.f1248a + "c/f/forum/random_recommend_forum");
            this.c.a("rn", "100");
            l = this.c.l();
            bd.e("TopRecModel", "doInBackground", l);
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (l == null) {
            return null;
        }
        if (!this.c.c()) {
            this.b.c = false;
        } else {
            this.f2556a = (TRForumListData) new GsonBuilder().create().fromJson(l, (Class<Object>) TRForumListData.class);
            this.b.c = true;
            bd.c(this.f2556a.toString());
        }
        return this.f2556a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(TRForumListData tRForumListData) {
        boolean z;
        boolean z2;
        super.a((n) tRForumListData);
        if (tRForumListData != null) {
            bd.c(tRForumListData.toString());
            if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                o oVar = this.b.b;
                z2 = this.b.c;
                oVar.a(Boolean.valueOf(z2), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                return;
            }
            o oVar2 = this.b.b;
            z = this.b.c;
            oVar2.a(Boolean.valueOf(z), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
        }
    }
}

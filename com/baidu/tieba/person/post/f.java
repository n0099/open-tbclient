package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Void, Void, PersonPostReplyModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<e> f2272a;
    private boolean b;
    private ap c;

    public f(e eVar, boolean z) {
        this.f2272a = new WeakReference<>(eVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostReplyModel a(Void... voidArr) {
        PersonPostReplyModel personPostReplyModel;
        this.c = new ap(com.baidu.tieba.data.h.f1196a + "c/u/feed/userpost");
        this.c.a("uid", String.valueOf(PersonPostReplyModel.mLastReplyUid));
        this.c.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(0));
        this.c.a("need_content", String.valueOf(1));
        String j = this.c.j();
        bg.e("PersonPostReplyModel", "doInBackground", j);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            bg.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(this.c.e());
        personPostReplyModel.setErrorString(this.c.g());
        return personPostReplyModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostReplyModel personPostReplyModel) {
        e eVar = this.f2272a.get();
        if (eVar != null) {
            eVar.a(personPostReplyModel, this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.h();
        }
        PersonPostReplyModel.sFetchReplyAsyncTask = null;
    }
}

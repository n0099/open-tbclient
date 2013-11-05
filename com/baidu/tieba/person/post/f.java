package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Void, Void, PersonPostReplyModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<e> f2237a;
    private boolean b;

    public f(e eVar, boolean z) {
        this.f2237a = new WeakReference<>(eVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostReplyModel a(Void... voidArr) {
        PersonPostReplyModel personPostReplyModel;
        ag agVar = new ag(com.baidu.tieba.data.h.f1165a + "c/u/feed/userpost");
        agVar.a("uid", String.valueOf(PersonPostReplyModel.mLastReplyUid));
        agVar.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        agVar.a("rn", String.valueOf(20));
        agVar.a("is_thread", String.valueOf(0));
        agVar.a("need_content", String.valueOf(1));
        String j = agVar.j();
        be.e("PersonPostReplyModel", "doInBackground", j);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            be.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(agVar.e());
        personPostReplyModel.setErrorString(agVar.g());
        return personPostReplyModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostReplyModel personPostReplyModel) {
        e eVar = this.f2237a.get();
        if (eVar != null) {
            eVar.a(personPostReplyModel, this.b);
        }
    }
}

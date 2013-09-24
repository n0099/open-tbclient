package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Void, Void, PersonPostReplyModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<e> f1717a;
    private boolean b;

    public f(e eVar, boolean z) {
        this.f1717a = new WeakReference<>(eVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostReplyModel a(Void... voidArr) {
        PersonPostReplyModel personPostReplyModel;
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/feed/userpost");
        zVar.a("uid", String.valueOf(PersonPostReplyModel.mLastReplyUid));
        zVar.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        zVar.a("rn", String.valueOf(20));
        zVar.a("is_thread", String.valueOf(0));
        zVar.a("need_content", String.valueOf(1));
        String j = zVar.j();
        av.e("PersonPostReplyModel", "doInBackground", j);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            av.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(zVar.e());
        personPostReplyModel.setErrorString(zVar.g());
        return personPostReplyModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostReplyModel personPostReplyModel) {
        e eVar = this.f1717a.get();
        if (eVar != null) {
            eVar.a(personPostReplyModel, this.b);
        }
    }
}

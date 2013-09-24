package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<g> f1718a;
    private boolean b;

    public h(g gVar, boolean z) {
        this.f1718a = new WeakReference<>(gVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/feed/userpost");
        str = PersonPostThreadModel.b;
        zVar.a("uid", String.valueOf(str));
        i = PersonPostThreadModel.f1705a;
        zVar.a("pn", String.valueOf(i));
        zVar.a("rn", String.valueOf(20));
        zVar.a("is_thread", String.valueOf(1));
        zVar.a("need_content", String.valueOf(1));
        String j = zVar.j();
        av.e("PersonPostThreadModel", "doInBackground", j);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            av.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(zVar.e());
        personPostThreadModel.setErrorString(zVar.g());
        return personPostThreadModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostThreadModel personPostThreadModel) {
        g gVar = this.f1718a.get();
        if (gVar != null) {
            gVar.a(personPostThreadModel, this.b);
        }
    }
}

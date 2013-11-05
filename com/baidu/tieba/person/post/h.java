package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<g> f2238a;
    private boolean b;

    public h(g gVar, boolean z) {
        this.f2238a = new WeakReference<>(gVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        ag agVar = new ag(com.baidu.tieba.data.h.f1165a + "c/u/feed/userpost");
        str = PersonPostThreadModel.b;
        agVar.a("uid", String.valueOf(str));
        i = PersonPostThreadModel.f2225a;
        agVar.a("pn", String.valueOf(i));
        agVar.a("rn", String.valueOf(20));
        agVar.a("is_thread", String.valueOf(1));
        agVar.a("need_content", String.valueOf(1));
        String j = agVar.j();
        be.e("PersonPostThreadModel", "doInBackground", j);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            be.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(agVar.e());
        personPostThreadModel.setErrorString(agVar.g());
        return personPostThreadModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostThreadModel personPostThreadModel) {
        g gVar = this.f2238a.get();
        if (gVar != null) {
            gVar.a(personPostThreadModel, this.b);
        }
    }
}

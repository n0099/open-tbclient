package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tbadk.core.util.ak;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Void, Void, PersonPostThreadModel> {
    private WeakReference<h> a;
    private boolean b;
    private ak c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ PersonPostThreadModel a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(PersonPostThreadModel personPostThreadModel) {
        PersonPostThreadModel personPostThreadModel2 = personPostThreadModel;
        h hVar = this.a.get();
        if (hVar != null) {
            hVar.a(personPostThreadModel2, this.b);
        }
    }

    public i(h hVar, boolean z) {
        this.a = new WeakReference<>(hVar);
        this.b = z;
    }

    private PersonPostThreadModel a() {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/feed/userpost");
        ak akVar = this.c;
        str = PersonPostThreadModel.b;
        akVar.a("uid", String.valueOf(str));
        ak akVar2 = this.c;
        i = PersonPostThreadModel.a;
        akVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String i2 = this.c.i();
        com.baidu.adp.lib.util.f.e("PersonPostThreadModel", "doInBackground", i2);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(i2, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.f.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(this.c.d());
        personPostThreadModel.setErrorString(this.c.f());
        return personPostThreadModel;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.g();
        }
        PersonPostThreadModel.sFetchThreadAsyncTask = null;
    }
}

package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Void, Void, PersonPostThreadModel> {
    private WeakReference<h> a;
    private boolean b;
    private ba c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ PersonPostThreadModel a(Void... voidArr) {
        return d();
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

    private PersonPostThreadModel d() {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/userpost");
        ba baVar = this.c;
        str = PersonPostThreadModel.b;
        baVar.a(SapiAccountManager.SESSION_UID, String.valueOf(str));
        ba baVar2 = this.c;
        i = PersonPostThreadModel.a;
        baVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String l = this.c.l();
        com.baidu.adp.lib.util.e.e("PersonPostThreadModel", "doInBackground", l);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(l, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.e.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(this.c.e());
        personPostThreadModel.setErrorString(this.c.i());
        return personPostThreadModel;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.j();
        }
        PersonPostThreadModel.sFetchThreadAsyncTask = null;
    }
}

package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ v a;
    private com.baidu.tbadk.core.util.an b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;

    public w(v vVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.a = vVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
        this.i = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        String str2 = TbConfig.SERVER_ADDRESS;
        if (this.g == 0) {
            str = String.valueOf(str2) + "c/c/bawu/delthread";
        } else {
            str = String.valueOf(str2) + "c/c/bawu/delpost";
        }
        this.b = new com.baidu.tbadk.core.util.an(str);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        if (this.g == 0) {
            if (this.h == 0) {
                this.b.a("delete_my_thread", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
        } else if (this.g == 1) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "0");
            this.b.a("src", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
        } else if (this.g == 2) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            this.b.a("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
        }
        if (this.h == 0 && !this.i) {
            this.b.a("is_vipdel", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        } else {
            this.b.a("is_vipdel", "0");
        }
        this.b.a().a().a = true;
        this.b.i();
        if (this.b.a().b().b()) {
            return null;
        }
        return this.b.f();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.e eVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
        super.cancel(true);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.adp.base.e eVar;
        com.baidu.adp.base.e eVar2;
        super.onPostExecute(str);
        this.a.a = null;
        if (this.b == null) {
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        x xVar = new x(this.a);
        xVar.c = this.g;
        xVar.d = this.f;
        xVar.b = str;
        if (str == null) {
            xVar.a = true;
        } else {
            xVar.a = false;
        }
        eVar = this.a.mLoadDataCallBack;
        eVar.a(xVar);
    }
}

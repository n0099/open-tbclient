package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.PbEditorCacheModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck extends BdAsyncTask<String, String, String> {
    private PbEditorCacheModel.OP_TYPE a;
    private cl b;
    private String c;
    private String d;

    public ck(PbEditorCacheModel.OP_TYPE op_type, String str, cl clVar, String str2) {
        this.a = op_type;
        this.b = clVar;
        this.c = str2;
        this.d = "pb_editor_" + TiebaApplication.A() + str;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        try {
            com.baidu.adp.lib.cache.s<String> d = com.baidu.tieba.b.a.a().d();
            String a = d.a(this.d);
            try {
                if (this.a == PbEditorCacheModel.OP_TYPE.SET) {
                    if (com.baidu.tieba.util.bu.c(this.c)) {
                        if (!com.baidu.tieba.util.bu.c(a)) {
                            d.c(this.d);
                        }
                    } else {
                        d.a(this.d, this.c, 86400000L);
                    }
                }
                return a;
            } catch (Exception e) {
                return a;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((ck) str);
        if (this.b != null) {
            this.b.a(str);
        }
    }
}

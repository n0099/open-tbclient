package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.PbEditorCacheModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl extends BdAsyncTask<String, String, String> {
    private PbEditorCacheModel.OP_TYPE a;
    private cm b;
    private String c;
    private String d;

    public cl(PbEditorCacheModel.OP_TYPE op_type, String str, cm cmVar, String str2) {
        this.a = op_type;
        this.b = cmVar;
        this.c = str2;
        this.d = "pb_editor_" + TiebaApplication.B() + str;
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
                    if (com.baidu.tieba.util.bc.c(this.c)) {
                        if (!com.baidu.tieba.util.bc.c(a)) {
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
        super.a((cl) str);
        if (this.b != null) {
            this.b.a(str);
        }
    }
}

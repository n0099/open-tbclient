package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.PbEditorCacheModel;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj extends BdAsyncTask<String, String, String> {

    /* renamed from: a  reason: collision with root package name */
    private PbEditorCacheModel.OP_TYPE f2116a;
    private ck b;
    private String c;
    private String d;

    public cj(PbEditorCacheModel.OP_TYPE op_type, String str, ck ckVar, String str2) {
        this.f2116a = op_type;
        this.b = ckVar;
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
            String a2 = d.a(this.d);
            try {
                if (this.f2116a == PbEditorCacheModel.OP_TYPE.SET) {
                    if (com.baidu.tieba.util.be.c(this.c)) {
                        if (!com.baidu.tieba.util.be.c(a2)) {
                            d.c(this.d);
                        }
                    } else {
                        d.a(this.d, this.c, Util.MILLSECONDS_OF_DAY);
                    }
                }
                return a2;
            } catch (Exception e) {
                return a2;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((cj) str);
        if (this.b != null) {
            this.b.a(str);
        }
    }
}

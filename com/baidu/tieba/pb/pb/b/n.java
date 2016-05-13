package com.baidu.tieba.pb.pb.b;

import com.baidu.tieba.pb.pb.main.PbActivity;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.c.l {
    final /* synthetic */ l die;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.die = lVar;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(com.baidu.tbadk.core.c.n nVar, JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(int i, Throwable th) {
        k kVar;
        PbActivity pbActivity;
        switch (i) {
            case 1:
                kVar = this.die.did;
                if (!kVar.awq()) {
                    pbActivity = this.die.dic;
                    pbActivity.aww().azK();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

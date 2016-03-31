package com.baidu.tieba.pb.pb.b;

import com.baidu.tbadk.core.c.l;
import com.baidu.tbadk.core.c.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ b dfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dfC = bVar;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(n nVar, JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(int i, Throwable th) {
        a aVar;
        PbActivity pbActivity;
        switch (i) {
            case 1:
                aVar = this.dfC.dfB;
                if (!aVar.avX()) {
                    pbActivity = this.dfC.dfA;
                    pbActivity.awi().azq();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cv;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cv.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cv.a
    public void i(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        ey eyVar;
        PbModel pbModel3;
        if (i != 0) {
            this.emk.showToast(w.l.operation_failed);
            return;
        }
        this.emk.oj(2);
        ep.aNL().reset();
        pbModel = this.emk.ekv;
        pbModel.aMV();
        pbModel2 = this.emk.ekv;
        ArrayList<PostData> aKA = pbModel2.getPbData().aKA();
        if (aKA != null) {
            Iterator<PostData> it = aKA.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (ex.g(next) && next.bjx().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                eyVar = this.emk.eli;
                pbModel3 = this.emk.ekv;
                eyVar.k(pbModel3.getPbData());
            }
            this.emk.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cv.a
    public void onError(int i, String str) {
        this.emk.showToast(w.l.operation_failed);
    }
}

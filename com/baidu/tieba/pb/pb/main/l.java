package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements df.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.df.a
    public void i(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        fx fxVar;
        PbModel pbModel3;
        if (i != 0) {
            this.enc.showToast(w.l.operation_failed);
            return;
        }
        this.enc.os(2);
        fg.aLX().reset();
        pbModel = this.enc.ele;
        pbModel.aLe();
        pbModel2 = this.enc.ele;
        ArrayList<PostData> aID = pbModel2.getPbData().aID();
        if (aID != null) {
            Iterator<PostData> it = aID.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (fw.i(next) && next.bio().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                fxVar = this.enc.elU;
                pbModel3 = this.enc.ele;
                fxVar.l(pbModel3.getPbData());
            }
            this.enc.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.df.a
    public void onError(int i, String str) {
        this.enc.showToast(w.l.operation_failed);
    }
}

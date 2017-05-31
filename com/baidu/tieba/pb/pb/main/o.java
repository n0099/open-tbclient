package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
/* loaded from: classes.dex */
class o implements SuggestEmotionModel.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
    public void a(com.baidu.tieba.pb.pb.main.emotion.data.b bVar) {
        fx fxVar;
        com.baidu.tieba.pb.pb.main.emotion.a aVar;
        if (bVar != null && bVar.aNn() != null && !bVar.aNn().isEmpty()) {
            fxVar = this.enc.elU;
            aVar = this.enc.emx;
            fxVar.a(bVar, aVar);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
    public void onFail(int i, String str) {
        BdLog.e(str);
    }
}

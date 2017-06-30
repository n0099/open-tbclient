package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
/* loaded from: classes.dex */
class p implements SuggestEmotionModel.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
    public void a(com.baidu.tieba.pb.pb.main.emotion.data.b bVar) {
        gg ggVar;
        com.baidu.tieba.pb.pb.main.emotion.a aVar;
        if (bVar != null && bVar.aRm() != null && !bVar.aRm().isEmpty()) {
            ggVar = this.ewh.euU;
            aVar = this.ewh.evB;
            ggVar.a(bVar, aVar);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
    public void onFail(int i, String str) {
        BdLog.e(str);
    }
}

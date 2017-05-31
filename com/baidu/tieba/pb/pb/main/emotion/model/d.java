package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.GetEmotionPidModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements GetEmotionPidModel.a {
    private final /* synthetic */ com.baidu.tieba.pb.data.f eqk;
    private final /* synthetic */ EmotionImageData evF;
    final /* synthetic */ b evX;
    private final /* synthetic */ PbModel evY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.evX = bVar;
        this.evF = emotionImageData;
        this.evY = pbModel;
        this.eqk = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetEmotionPidModel.a
    public void onSuccess(String str) {
        this.evF.setPicId(str);
        this.evX.b(this.evF, this.evY, this.eqk);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetEmotionPidModel.a
    public void onFail(int i, String str) {
        NewWriteModel.d dVar;
        NewWriteModel.d dVar2;
        dVar = this.evX.evS;
        if (dVar != null) {
            dVar2 = this.evX.evS;
            dVar2.callback(false, null, null, null, null);
        }
    }
}

package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements GetEmotionPidModel.a {
    private final /* synthetic */ EmotionImageData eEV;
    final /* synthetic */ a eFk;
    private final /* synthetic */ PbModel eFl;
    private final /* synthetic */ f ezv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        this.eFk = aVar;
        this.eEV = emotionImageData;
        this.eFl = pbModel;
        this.ezv = fVar;
    }

    @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
    public void a(com.baidu.tbadk.img.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
            this.eEV.setPicId(cVar.picId);
            this.eFk.b(this.eEV, this.eFl, this.ezv);
        }
    }

    @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
    public void onFail(int i, String str) {
        NewWriteModel.d dVar;
        NewWriteModel.d dVar2;
        dVar = this.eFk.eFf;
        if (dVar != null) {
            dVar2 = this.eFk.eFf;
            dVar2.callback(false, null, null, null, null);
        }
    }
}

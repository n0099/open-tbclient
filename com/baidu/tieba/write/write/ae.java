package com.baidu.tieba.write.write;

import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements PhotoLiveLinearLayout.a {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
    public void aCu() {
        this.dqi.aDB();
    }
}

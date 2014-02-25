package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements ab {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.ab
    public void a(w wVar, boolean z, boolean z2) {
        av avVar;
        avVar = this.a.e;
        if (avVar.getSelectedView() == wVar) {
            this.a.setZoomButton(wVar);
        }
    }
}

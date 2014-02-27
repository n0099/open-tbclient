package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bs implements ab {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.ab
    public final void a(w wVar) {
        av avVar;
        avVar = this.a.e;
        if (avVar.getSelectedView() == wVar) {
            this.a.setZoomButton(wVar);
        }
    }
}

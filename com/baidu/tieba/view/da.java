package com.baidu.tieba.view;

import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class da implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && str != null) {
            com.baidu.tieba.util.ch.a((ViewGroup) this.a, false, (com.baidu.tieba.util.cj) new db(this, str));
        }
    }
}

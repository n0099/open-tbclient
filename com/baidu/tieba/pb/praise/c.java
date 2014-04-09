package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null && str != null) {
            headImageView = this.a.b;
            if (str.equals(headImageView.getTag())) {
                headImageView2 = this.a.b;
                bVar.a(headImageView2);
            }
        }
    }
}

package com.baidu.tieba.view;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        tbImageView = this.a.c;
        if (tbImageView.getTag() != null) {
            tbImageView2 = this.a.c;
            if (((String) tbImageView2.getTag()).equals(str)) {
                tbImageView3 = this.a.c;
                tbImageView3.invalidate();
            }
        }
    }
}

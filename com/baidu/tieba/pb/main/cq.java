package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bq bqVar) {
        this.a = bqVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.o;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (aVar == null) {
            if (imageView != null && (imageView instanceof TbImageView)) {
                ((TbImageView) imageView).e();
            }
        } else if (imageView != null) {
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).e();
            } else {
                imageView.invalidate();
            }
        }
    }
}

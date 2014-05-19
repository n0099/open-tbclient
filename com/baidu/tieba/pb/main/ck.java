package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        com.baidu.tieba.pb.sub.m mVar;
        com.baidu.tieba.pb.sub.m mVar2;
        bdListView = this.a.o;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (aVar == null) {
            if (imageView != null && (imageView instanceof TbImageView)) {
                ((TbImageView) imageView).e();
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).e();
            }
            imageView.invalidate();
        }
        if (this.a.D()) {
            mVar = this.a.N;
            if (mVar != null) {
                mVar2 = this.a.N;
                ImageView imageView2 = (ImageView) mVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}

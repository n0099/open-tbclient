package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        String portrait;
        f fVar3;
        BdListView bdListView3;
        BdListView bdListView4;
        try {
            bdListView = this.a.e;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.e;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                int i3 = lastVisiblePosition - 1;
                i = firstVisiblePosition - 1;
                i2 = i3;
            } else {
                i = firstVisiblePosition;
                i2 = lastVisiblePosition;
            }
            for (int i4 = i; i4 <= i2; i4++) {
                fVar = this.a.f;
                if (i4 < fVar.getCount()) {
                    fVar2 = this.a.f;
                    com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) fVar2.getItem(i4);
                    if (uVar != null && (portrait = uVar.i().getPortrait()) != null && portrait.length() > 0) {
                        fVar3 = this.a.f;
                        com.baidu.adp.widget.ImageView.d b = fVar3.e().b(portrait, new l(this));
                        if (b != null) {
                            bdListView3 = this.a.e;
                            ImageView imageView = (ImageView) bdListView3.findViewWithTag(portrait);
                            while (imageView != null) {
                                imageView.setTag(null);
                                if (imageView != null) {
                                    b.a(imageView);
                                }
                                bdListView4 = this.a.e;
                                imageView = (ImageView) bdListView4.findViewWithTag(portrait);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            bo.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}

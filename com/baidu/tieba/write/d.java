package com.baidu.tieba.write;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.util.cj;
/* loaded from: classes.dex */
final class d implements cj {
    final /* synthetic */ c a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = cVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        if ((view instanceof ImageView) && view.getTag() != null) {
            Object tag = view.getTag();
            if (tag instanceof MetaData) {
                ImageView imageView = (ImageView) view;
                MetaData metaData = (MetaData) tag;
                if (this.b != null && this.b.equals(metaData.getPortrait()) && this.c != null) {
                    this.c.a(imageView);
                }
            }
        }
        return false;
    }
}

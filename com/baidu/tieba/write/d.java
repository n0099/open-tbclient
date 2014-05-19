package com.baidu.tieba.write;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.util.br {
    final /* synthetic */ c a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = cVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
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

package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.tbadk.core.data.n;
/* loaded from: classes.dex */
final class i implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ ImageViewerActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ImageViewerActivity imageViewerActivity) {
        this.a = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public final void a(int i) {
        boolean z;
        a aVar;
        z = this.a.B;
        if (z) {
            Intent intent = new Intent(n.s());
            intent.putExtra("index", -1);
            intent.putExtra("state", i);
            this.a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.a.u;
            aVar.b();
        }
    }
}

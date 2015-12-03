package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup arZ;
    final /* synthetic */ ab dLP;
    private final /* synthetic */ ab.a dLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ViewGroup viewGroup, ab.a aVar) {
        this.dLP = abVar;
        this.arZ = viewGroup;
        this.dLQ = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.arZ.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.dLQ.dLU = false;
        }
    }
}

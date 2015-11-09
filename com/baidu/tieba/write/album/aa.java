package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.z;
/* loaded from: classes.dex */
class aa implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aqc;
    final /* synthetic */ z dmJ;
    private final /* synthetic */ z.a dmK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, ViewGroup viewGroup, z.a aVar) {
        this.dmJ = zVar;
        this.aqc = viewGroup;
        this.dmK = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aqc.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.dmK.dmO = false;
        }
    }
}

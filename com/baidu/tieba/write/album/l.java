package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int aak;
    final /* synthetic */ k fMG;
    private final /* synthetic */ ViewGroup fMH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, ViewGroup viewGroup, int i) {
        this.fMG = kVar;
        this.fMH = viewGroup;
        this.aak = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.fMH.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.fMG.fME;
            map.put(Integer.valueOf(this.aak), true);
        }
    }
}

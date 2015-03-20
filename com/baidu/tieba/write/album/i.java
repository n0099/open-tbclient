package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int Rx;
    final /* synthetic */ h ctJ;
    private final /* synthetic */ ViewGroup ctK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.ctJ = hVar;
        this.ctK = viewGroup;
        this.Rx = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.ctK.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.ctJ.ctI;
            map.put(Integer.valueOf(this.Rx), true);
        }
    }
}

package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int Sg;
    final /* synthetic */ j eXZ;
    private final /* synthetic */ ViewGroup eYa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup, int i) {
        this.eXZ = jVar;
        this.eYa = viewGroup;
        this.Sg = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.eYa.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.eXZ.eXY;
            map.put(Integer.valueOf(this.Sg), true);
        }
    }
}

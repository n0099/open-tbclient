package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int WS;
    final /* synthetic */ j eHf;
    private final /* synthetic */ ViewGroup eHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup, int i) {
        this.eHf = jVar;
        this.eHg = viewGroup;
        this.WS = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.eHg.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.eHf.eHe;
            map.put(Integer.valueOf(this.WS), true);
        }
    }
}

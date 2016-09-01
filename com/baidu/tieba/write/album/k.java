package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int VV;
    final /* synthetic */ j gau;
    private final /* synthetic */ ViewGroup gav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup, int i) {
        this.gau = jVar;
        this.gav = viewGroup;
        this.VV = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.gav.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.gau.gas;
            map.put(Integer.valueOf(this.VV), true);
        }
    }
}

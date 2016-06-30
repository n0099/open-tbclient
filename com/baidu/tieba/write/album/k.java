package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int Sx;
    final /* synthetic */ j fDc;
    private final /* synthetic */ ViewGroup fDd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup, int i) {
        this.fDc = jVar;
        this.fDd = viewGroup;
        this.Sx = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.fDd.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.fDc.fDb;
            map.put(Integer.valueOf(this.Sx), true);
        }
    }
}

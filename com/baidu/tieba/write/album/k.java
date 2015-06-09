package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int RY;
    final /* synthetic */ j cys;
    private final /* synthetic */ ViewGroup cyt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup, int i) {
        this.cys = jVar;
        this.cyt = viewGroup;
        this.RY = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.cyt.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.cys.cyr;
            map.put(Integer.valueOf(this.RY), true);
        }
    }
}

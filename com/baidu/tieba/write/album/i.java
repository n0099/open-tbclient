package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ h dlV;
    private final /* synthetic */ ViewGroup dlW;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.dlV = hVar;
        this.dlW = viewGroup;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.dlW.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.dlV.dlU;
            map.put(Integer.valueOf(this.val$position), true);
        }
    }
}

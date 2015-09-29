package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ g djN;
    private final /* synthetic */ ViewGroup djO;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, ViewGroup viewGroup, int i) {
        this.djN = gVar;
        this.djO = viewGroup;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.djO.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.djN.djM;
            map.put(Integer.valueOf(this.val$position), true);
        }
    }
}

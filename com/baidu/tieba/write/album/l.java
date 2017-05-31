package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ int aaj;
    final /* synthetic */ k fUn;
    private final /* synthetic */ ViewGroup fUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, ViewGroup viewGroup, int i) {
        this.fUn = kVar;
        this.fUo = viewGroup;
        this.aaj = i;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.fUo.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.fUn.fUl;
            map.put(Integer.valueOf(this.aaj), true);
        }
    }
}

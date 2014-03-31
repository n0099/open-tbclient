package com.baidu.tieba.im.view;

import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ HorizontalPanelView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HorizontalPanelView horizontalPanelView) {
        this.a = horizontalPanelView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        List<HeadImageView> list;
        if (bVar != null) {
            list = this.a.g;
            for (HeadImageView headImageView : list) {
                if (str.equals(headImageView.getUrl())) {
                    bVar.a(headImageView);
                }
            }
            return;
        }
        if (("HorizontalPanelView not Portrait" + str) == null) {
            str = "not url";
        }
        com.baidu.adp.lib.util.f.b(str);
    }
}

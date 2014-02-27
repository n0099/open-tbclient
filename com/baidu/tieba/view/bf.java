package com.baidu.tieba.view;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ HorizontalPanelView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(HorizontalPanelView horizontalPanelView) {
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
        com.baidu.adp.lib.util.e.b(str);
    }
}

package com.baidu.tieba.view;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ HorizontalPanelView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(HorizontalPanelView horizontalPanelView) {
        this.a = horizontalPanelView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        List<HeadImageView> list;
        if (dVar != null) {
            list = this.a.g;
            for (HeadImageView headImageView : list) {
                if (str.equals(headImageView.getUrl())) {
                    dVar.a(headImageView);
                }
            }
            return;
        }
        if (("HorizontalPanelView not Portrait" + str) == null) {
            str = "not url";
        }
        com.baidu.adp.lib.g.e.a(str);
    }
}

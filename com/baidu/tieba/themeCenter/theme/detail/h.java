package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements HorizontalListView.a {
    final /* synthetic */ g dGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dGU = gVar;
    }

    @Override // com.baidu.tbadk.core.view.HorizontalListView.a
    public void cQ(int i) {
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        indicatorView = this.dGU.agf;
        if (indicatorView != null) {
            indicatorView2 = this.dGU.agf;
            indicatorView2.setPosition(i);
        }
    }
}

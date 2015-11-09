package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.d<b> {
    final /* synthetic */ f dhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.dhU = fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        DressupCenterActivity dressupCenterActivity;
        TiebaStatic.log("c10262");
        az uX = az.uX();
        dressupCenterActivity = this.dhU.dhS;
        uX.b(dressupCenterActivity.getPageContext(), new String[]{str});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, b bVar) {
    }
}

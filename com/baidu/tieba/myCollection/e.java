package com.baidu.tieba.myCollection;

import android.content.Context;
import com.baidu.adp.base.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mainTab.e {
    final /* synthetic */ d bwK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.bwK = dVar;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void onClick() {
        com.baidu.tbadk.mainTab.f fVar;
        fVar = EditMarkStatic.aNZ;
        MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(((TbPageContext) m.D(fVar.getContext())).getPageActivity())));
    }
}

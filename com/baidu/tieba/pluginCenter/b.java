package com.baidu.tieba.pluginCenter;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b extends com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> {
    final /* synthetic */ PluginCenterActivity eKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PluginCenterActivity pluginCenterActivity, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        this.eKf = pluginCenterActivity;
    }

    @Override // com.baidu.tbadk.mvc.f.b
    public int eY(int i) {
        return getItem(i) instanceof String ? 1 : 0;
    }
}

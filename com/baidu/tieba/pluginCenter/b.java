package com.baidu.tieba.pluginCenter;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    final /* synthetic */ PluginCenterActivity eWK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PluginCenterActivity pluginCenterActivity, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        this.eWK = pluginCenterActivity;
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eW(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 2;
        }
        if (item instanceof PluginConfigWrapper) {
            return 1;
        }
        return 0;
    }
}

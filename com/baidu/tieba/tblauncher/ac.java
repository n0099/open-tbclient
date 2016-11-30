package com.baidu.tieba.tblauncher;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ac implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (StringUtils.isNull(str) || !str.startsWith("tiebavr:") || TbadkCoreApplication.m9getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
            return 3;
        }
        tbPageContext.showToast(r.j.vr_plugin_not_available);
        return 1;
    }
}

package com.baidu.tieba.livesdk.scheme;

import android.app.Activity;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.sdk.a.g;
/* loaded from: classes2.dex */
public class a implements g {
    public void DT(String str) {
        Activity currentActivity;
        if (!StringUtils.isNull(str) && (currentActivity = com.baidu.adp.base.a.eG().currentActivity()) != null) {
            ba.aEt().a((TbPageContext) i.ab(currentActivity), new String[]{str}, true);
        }
    }

    @Override // com.baidu.tieba.sdk.a.g
    public void DU(String str) {
        DT(str);
    }
}

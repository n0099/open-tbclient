package com.baidu.tieba.livesdk.i;

import android.app.Activity;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.sdk.a.g;
/* loaded from: classes6.dex */
public class a implements g {
    public void zb(String str) {
        Activity currentActivity;
        if (!StringUtils.isNull(str) && (currentActivity = com.baidu.adp.base.a.em().currentActivity()) != null) {
            ba.amQ().a((TbPageContext) i.ab(currentActivity), new String[]{str}, true);
        }
    }

    @Override // com.baidu.tieba.sdk.a.g
    public void zc(String str) {
        zb(str);
    }
}

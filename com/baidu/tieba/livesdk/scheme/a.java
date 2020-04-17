package com.baidu.tieba.livesdk.scheme;

import android.app.Activity;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.sdk.a.g;
/* loaded from: classes3.dex */
public class a implements g {
    public void openScheme(String str) {
        Activity currentActivity;
        if (!StringUtils.isNull(str) && (currentActivity = com.baidu.adp.base.a.jm().currentActivity()) != null) {
            ba.aOY().a((TbPageContext) i.T(currentActivity), new String[]{str}, true);
        }
    }

    @Override // com.baidu.tieba.sdk.a.g
    public void FS(String str) {
        openScheme(str);
    }
}

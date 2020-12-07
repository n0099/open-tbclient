package com.baidu.tieba.r;

import com.baidu.searchbox.aperf.param.IAperfOverlayContext;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a implements IAperfOverlayContext {
    @Override // com.baidu.searchbox.aperf.param.IAperfOverlayContext
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}

package com.baidu.tieba.q;

import com.baidu.searchbox.logsystem.util.ILokiOverlayContext;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class m implements ILokiOverlayContext {
    @Override // com.baidu.searchbox.logsystem.util.ILokiOverlayContext
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}

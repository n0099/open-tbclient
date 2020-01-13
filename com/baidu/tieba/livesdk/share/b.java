package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes2.dex */
public class b implements IShareChannelBuild {
    private IShareChannel ibQ;

    public b(IShareChannel iShareChannel) {
        this.ibQ = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.ibQ;
    }
}

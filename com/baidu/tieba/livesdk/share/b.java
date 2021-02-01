package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes10.dex */
public class b implements IShareChannelBuild {
    private IShareChannel lhB;

    public b(IShareChannel iShareChannel) {
        this.lhB = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.lhB;
    }
}

package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes3.dex */
public class b implements IShareChannelBuild {
    private IShareChannel jeH;

    public b(IShareChannel iShareChannel) {
        this.jeH = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.jeH;
    }
}

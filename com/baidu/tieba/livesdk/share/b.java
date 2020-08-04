package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes4.dex */
public class b implements IShareChannelBuild {
    private IShareChannel jFl;

    public b(IShareChannel iShareChannel) {
        this.jFl = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.jFl;
    }
}

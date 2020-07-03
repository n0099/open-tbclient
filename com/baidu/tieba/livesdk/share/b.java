package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes3.dex */
public class b implements IShareChannelBuild {
    private IShareChannel jwF;

    public b(IShareChannel iShareChannel) {
        this.jwF = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.jwF;
    }
}

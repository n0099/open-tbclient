package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes6.dex */
public class b implements IShareChannelBuild {
    private IShareChannel hkl;

    public b(IShareChannel iShareChannel) {
        this.hkl = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.hkl;
    }
}

package com.baidu.tieba.livesdk.share;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes10.dex */
public class b implements IShareChannelBuild {
    private IShareChannel lhP;

    public b(IShareChannel iShareChannel) {
        this.lhP = iShareChannel;
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild
    public IShareChannel build() {
        return this.lhP;
    }
}

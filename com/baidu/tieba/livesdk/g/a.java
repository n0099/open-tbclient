package com.baidu.tieba.livesdk.g;

import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
/* loaded from: classes6.dex */
public class a implements INetWorkBuilder {
    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder
    public INetWork buildNetWork() {
        return new b();
    }
}

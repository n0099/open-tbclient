package com.baidu.tieba.setting.more;

import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ w cfv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.cfv = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        boolean z;
        if (bArr != null) {
            try {
                this.cfv.a(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                z = true;
            } catch (Exception e) {
                z = false;
            }
            if (z) {
                this.cfv.mUIHandler.post(new z(this));
            }
        }
    }
}

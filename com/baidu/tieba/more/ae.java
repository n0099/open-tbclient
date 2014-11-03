package com.baidu.tieba.more;

import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes.dex */
class ae implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ ac brm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.brm = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: i */
    public void d(String str, byte[] bArr) {
        boolean z;
        if (bArr != null) {
            try {
                this.brm.a(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                z = true;
            } catch (Exception e) {
                z = false;
            }
            if (z) {
                this.brm.mUIHandler.post(new af(this));
            }
        }
    }
}

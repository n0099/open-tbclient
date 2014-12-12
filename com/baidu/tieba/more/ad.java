package com.baidu.tieba.more;

import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ ab buA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.buA = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: k */
    public void onItemGet(String str, byte[] bArr) {
        boolean z;
        if (bArr != null) {
            try {
                this.buA.a(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                z = true;
            } catch (Exception e) {
                z = false;
            }
            if (z) {
                this.buA.mUIHandler.post(new ae(this));
            }
        }
    }
}

package com.baidu.tieba.setting.model;

import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements o.a<byte[]> {
    final /* synthetic */ c dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.dIS = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void h(String str, byte[] bArr) {
        boolean z;
        if (bArr != null) {
            try {
                this.dIS.a(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                z = true;
            } catch (Exception e) {
                z = false;
            }
            if (z) {
                this.dIS.mUIHandler.post(new f(this));
            }
        }
        this.dIS.mIsLoading = false;
    }
}

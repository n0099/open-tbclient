package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements com.baidu.adp.lib.c.d {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    TbadkApplication.j();
                    TbadkApplication.i(valueOf);
                    TbadkApplication.j();
                    TbadkApplication.j(valueOf2);
                    TbadkApplication.j();
                    TbadkApplication.k(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
    }
}

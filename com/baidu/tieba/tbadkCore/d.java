package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d fzm;
    private com.baidu.adp.lib.cache.o<byte[]> aNn;
    private n responseData = null;

    private d() {
        this.aNn = null;
        this.aNn = BdCacheService.dB().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d bkd() {
        d dVar;
        synchronized (d.class) {
            if (fzm == null) {
                fzm = new d();
            }
            dVar = fzm;
        }
        return dVar;
    }

    public boolean rn(String str) {
        if (this.aNn != null && str != null) {
            byte[] bArr = this.aNn.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new n();
                this.responseData.D(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aNn.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aNn.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void R(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aNn.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aNn.U(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.c<byte[]> T;
        if (str == null || str.length() <= 0 || (T = this.aNn.T(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(T.my, System.currentTimeMillis());
    }

    public n getResponseData() {
        return this.responseData;
    }

    public String e(String str, int i, int i2, int i3) {
        String str2 = String.valueOf(str) + i + i2;
        if (i3 != 0) {
            return String.valueOf(str) + i + i2 + "categoryid" + String.valueOf(i3);
        }
        return str2;
    }
}

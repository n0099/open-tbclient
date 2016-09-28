package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d fsf;
    private com.baidu.adp.lib.cache.o<byte[]> aMc;
    private n responseData = null;

    private d() {
        this.aMc = null;
        this.aMc = BdCacheService.dB().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d bhH() {
        d dVar;
        synchronized (d.class) {
            if (fsf == null) {
                fsf = new d();
            }
            dVar = fsf;
        }
        return dVar;
    }

    public boolean qT(String str) {
        if (this.aMc != null && str != null) {
            byte[] bArr = this.aMc.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                this.aMc.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aMc.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void R(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aMc.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aMc.U(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.c<byte[]> T;
        if (str == null || str.length() <= 0 || (T = this.aMc.T(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(T.mx, System.currentTimeMillis());
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

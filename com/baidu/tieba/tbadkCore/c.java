package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class c {
    private static c emN;
    private com.baidu.adp.lib.cache.o<byte[]> bhe;
    private m responseData = null;

    private c() {
        this.bhe = null;
        this.bhe = BdCacheService.gs().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c aRC() {
        c cVar;
        synchronized (c.class) {
            if (emN == null) {
                emN = new c();
            }
            cVar = emN;
        }
        return cVar;
    }

    public boolean nH(String str) {
        if (this.bhe != null && str != null) {
            byte[] bArr = this.bhe.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.B(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bhe.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bhe.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void J(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bhe.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.bhe.aa(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> Z;
        if (str == null || str.length() <= 0 || (Z = this.bhe.Z(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(Z.tQ, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String at(String str, int i) {
        if (i != 0) {
            return String.valueOf(str) + "categoryid" + String.valueOf(i);
        }
        return str;
    }
}

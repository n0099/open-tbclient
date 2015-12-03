package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d dwS;
    private com.baidu.adp.lib.cache.o<byte[]> aWe;
    private n responseData = null;

    private d() {
        this.aWe = null;
        this.aWe = BdCacheService.gk().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d aBA() {
        d dVar;
        synchronized (d.class) {
            if (dwS == null) {
                dwS = new d();
            }
            dVar = dwS;
        }
        return dVar;
    }

    public boolean mi(String str) {
        if (this.aWe != null && str != null) {
            byte[] bArr = this.aWe.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new n();
                this.responseData.U(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aWe.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aWe.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void J(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aWe.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aWe.ab(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> aa;
        if (str == null || str.length() <= 0 || (aa = this.aWe.aa(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(aa.tw, System.currentTimeMillis());
    }

    public n getResponseData() {
        return this.responseData;
    }

    public String ai(String str, int i) {
        if (i != 0) {
            return String.valueOf(str) + "categoryid" + String.valueOf(i);
        }
        return str;
    }
}

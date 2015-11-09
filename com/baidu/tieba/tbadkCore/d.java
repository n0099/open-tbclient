package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    private static d cYo;
    private com.baidu.adp.lib.cache.o<byte[]> aRa;
    private m responseData = null;

    private d() {
        this.aRa = null;
        this.aRa = BdCacheService.gl().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized d avW() {
        d dVar;
        synchronized (d.class) {
            if (cYo == null) {
                cYo = new d();
            }
            dVar = cYo;
        }
        return dVar;
    }

    public boolean lu(String str) {
        if (this.aRa != null && str != null) {
            byte[] bArr = this.aRa.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.U(bArr);
                return true;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aRa.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aRa.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void H(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aRa.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aRa.ab(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.b<byte[]> aa;
        if (str == null || str.length() <= 0 || (aa = this.aRa.aa(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(aa.tv, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String ad(String str, int i) {
        if (i != 0) {
            return String.valueOf(str) + "categoryid" + String.valueOf(i);
        }
        return str;
    }
}

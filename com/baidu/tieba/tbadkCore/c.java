package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private static c ggF;
    private com.baidu.adp.lib.cache.l<byte[]> bdE;
    private g responseData = null;

    private c() {
        this.bdE = null;
        this.bdE = BdCacheService.eQ().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c bqV() {
        c cVar;
        synchronized (c.class) {
            if (ggF == null) {
                ggF = new c();
            }
            cVar = ggF;
        }
        return cVar;
    }

    public boolean rT(String str) {
        if (this.bdE != null && str != null) {
            byte[] bArr = this.bdE.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new g();
                this.responseData.F(bArr);
                if (this.responseData.eFH != null && this.responseData.eFH.getFrsBannerData() != null) {
                    this.responseData.eFH.getFrsBannerData().WO = false;
                }
                return true;
            }
        }
        return false;
    }

    public void cf(String str, String str2) {
        if (this.bdE != null && str != null) {
            byte[] bArr = this.bdE.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.thread_list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ThreadInfo threadInfo : frsPageResIdl.data.thread_list) {
                            if (threadInfo != null && threadInfo.tid != null && str2 != null && str2.equals(threadInfo.tid.toString())) {
                                arrayList.add(threadInfo);
                            }
                        }
                        DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
                        if (builder.thread_list != null) {
                            builder.thread_list.removeAll(arrayList);
                        }
                        FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
                        builder2.data = builder.build(true);
                        c(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cg(String str, String str2) {
        if (this.bdE != null && str != null) {
            byte[] bArr = this.bdE.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.forum != null && frsPageResIdl.data.forum.banner_list != null && frsPageResIdl.data.forum.banner_list.app != null && frsPageResIdl.data.forum.banner_list.app.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (App app : frsPageResIdl.data.forum.banner_list.app) {
                            if (app != null && str2.equals(app.id)) {
                                arrayList.add(app);
                            }
                        }
                        BannerList.Builder builder = new BannerList.Builder(frsPageResIdl.data.forum.banner_list);
                        if (builder.app != null) {
                            builder.app.removeAll(arrayList);
                        }
                        FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
                        DataRes.Builder builder3 = new DataRes.Builder(frsPageResIdl.data);
                        ForumInfo.Builder builder4 = new ForumInfo.Builder(frsPageResIdl.data.forum);
                        builder4.banner_list = builder.build(true);
                        builder3.forum = builder4.build(true);
                        builder2.data = builder3.build(true);
                        c(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void c(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bdE.a(TbadkCoreApplication.getCurrentAccount() + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.bdE.b(TbadkCoreApplication.getCurrentAccount() + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void aa(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bdE.remove(TbadkCoreApplication.getCurrentAccount() + str);
                return;
            }
            this.bdE.ae(TbadkCoreApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        l.c<byte[]> ad;
        if (str == null || str.length() <= 0 || (ad = this.bdE.ad(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(ad.vv, System.currentTimeMillis());
    }

    public g getResponseData() {
        return this.responseData;
    }

    public String g(String str, int i, int i2, int i3) {
        String str2 = str + i + i2;
        if (i3 != 0) {
            return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + String.valueOf(i3);
        }
        return str2;
    }
}

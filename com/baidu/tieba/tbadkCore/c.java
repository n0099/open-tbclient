package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
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
    private static c fzc;
    private com.baidu.adp.lib.cache.o<byte[]> aYJ;
    private l responseData = null;

    private c() {
        this.aYJ = null;
        this.aYJ = BdCacheService.eI().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized c bgf() {
        c cVar;
        synchronized (c.class) {
            if (fzc == null) {
                fzc = new c();
            }
            cVar = fzc;
        }
        return cVar;
    }

    public boolean pY(String str) {
        if (this.aYJ != null && str != null) {
            byte[] bArr = this.aYJ.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new l();
                this.responseData.C(bArr);
                return true;
            }
        }
        return false;
    }

    public void bW(String str, String str2) {
        if (this.aYJ != null && str != null) {
            byte[] bArr = this.aYJ.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                        a(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void bX(String str, String str2) {
        if (this.aYJ != null && str != null) {
            byte[] bArr = this.aYJ.get(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
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
                        a(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aYJ.a(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
                return;
            }
            this.aYJ.b(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    public void S(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.aYJ.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
                return;
            }
            this.aYJ.Q(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str);
        }
    }

    public boolean isSameDay(String str) {
        o.c<byte[]> P;
        if (str == null || str.length() <= 0 || (P = this.aYJ.P(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(P.tP, System.currentTimeMillis());
    }

    public l getResponseData() {
        return this.responseData;
    }

    public String g(String str, int i, int i2, int i3) {
        String str2 = String.valueOf(str) + i + i2;
        if (i3 != 0) {
            return String.valueOf(str) + i + i2 + FrsRequestData.CATEGORY_ID_KEY + String.valueOf(i3);
        }
        return str2;
    }
}

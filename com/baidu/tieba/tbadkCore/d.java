package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class d {
    public static final Wire WIRE = new Wire(new Class[0]);
    private static d iDW;
    private com.baidu.adp.lib.cache.l<byte[]> dfX;
    private j responseData = null;

    private d() {
        this.dfX = null;
        this.dfX = BdCacheService.iy().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static d cds() {
        if (iDW == null) {
            synchronized (d.class) {
                if (iDW == null) {
                    iDW = new d();
                }
            }
        }
        return iDW;
    }

    public long cdt() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_frs_cache_time", TbConfig.APP_OVERDUR_DRAFT_BOX);
        return j < 0 ? TbConfig.APP_OVERDUR_DRAFT_BOX : j;
    }

    public boolean Cp(String str) {
        if (this.dfX != null && str != null) {
            byte[] bArr = this.dfX.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new j();
                this.responseData.parserProtobuf(bArr);
                if (this.responseData.forum != null && this.responseData.forum.getFrsBannerData() != null) {
                    this.responseData.forum.getFrsBannerData().byB = false;
                }
                return true;
            }
        }
        return false;
    }

    public void dS(String str, String str2) {
        if (this.dfX != null && str != null) {
            byte[] bArr = this.dfX.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.ala_stage_list != null) {
                        DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
                        if (builder.ala_stage_list != null) {
                            builder.ala_stage_list.clear();
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

    public void dT(String str, String str2) {
        if (this.dfX != null && str != null) {
            byte[] bArr = this.dfX.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void dU(String str, String str2) {
        if (this.dfX != null && str != null) {
            byte[] bArr = this.dfX.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void n(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int S;
        int i;
        if (this.dfX != null && str != null && bArr != null && bArr.length > 0) {
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null && (S = com.baidu.tbadk.core.util.v.S((list = frsPageResIdl.data.thread_list))) > 0) {
                    if (S >= 15) {
                        c(str, bArr, true);
                        return;
                    }
                    byte[] bArr2 = this.dfX.get(TbadkCoreApplication.getCurrentAccount() + str);
                    if (bArr2 == null) {
                        c(str, bArr, true);
                        return;
                    }
                    FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) WIRE.parseFrom(bArr2, FrsPageResIdl.class);
                    if (frsPageResIdl2 == null || frsPageResIdl2.data == null || frsPageResIdl2.data.thread_list == null) {
                        c(str, bArr, true);
                        return;
                    }
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int S2 = com.baidu.tbadk.core.util.v.S(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (i2 < S2 && S < 15) {
                        ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.v.c(list2, i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.is_top.intValue() != 0 || c(threadInfo.tid.longValue(), list)) {
                            i = S;
                        } else {
                            arrayList.add(threadInfo);
                            User b = b(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (b != null) {
                                arrayList2.add(b);
                            }
                            i = S + 1;
                        }
                        i2++;
                        S = i;
                    }
                    FrsPageResIdl.Builder builder = new FrsPageResIdl.Builder(frsPageResIdl);
                    DataRes.Builder builder2 = new DataRes.Builder(frsPageResIdl.data);
                    builder2.thread_list.addAll(arrayList);
                    builder2.user_list.addAll(arrayList2);
                    builder.data = builder2.build(true);
                    c(str, builder.build(true).toByteArray(), true);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private boolean c(long j, List<ThreadInfo> list) {
        int S = com.baidu.tbadk.core.util.v.S(list);
        for (int i = 0; i < S; i++) {
            ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.v.c(list, i);
            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private User b(List<User> list, long j) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return null;
        }
        for (User user : list) {
            if (user != null && user.id.longValue() == j) {
                return user;
            }
        }
        return null;
    }

    public void c(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.dfX.a(TbadkCoreApplication.getCurrentAccount() + str, bArr, cdt());
                return;
            }
            this.dfX.b(TbadkCoreApplication.getCurrentAccount() + str, bArr, cdt());
        }
    }

    public void au(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.dfX.remove(TbadkCoreApplication.getCurrentAccount() + str);
                return;
            }
            this.dfX.aG(TbadkCoreApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        l.b<byte[]> aF;
        if (str == null || str.length() <= 0 || (aF = this.dfX.aF(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(aF.AZ, System.currentTimeMillis());
    }

    public j getResponseData() {
        return this.responseData;
    }

    public String d(String str, int i, int i2, int i3) {
        String str2 = str + i + i2;
        if (i3 != 0) {
            return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + i3;
        }
        return str2;
    }
}

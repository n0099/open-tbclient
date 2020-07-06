package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes.dex */
public class e {
    public static final Wire WIRE = new Wire(new Class[0]);
    private static e lDz;
    private com.baidu.adp.lib.cache.l<byte[]> hvk;
    private m responseData = null;

    private e() {
        this.hvk = null;
        this.hvk = BdCacheService.kv().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static e dgZ() {
        if (lDz == null) {
            synchronized (e.class) {
                if (lDz == null) {
                    lDz = new e();
                }
            }
        }
        return lDz;
    }

    public long dha() {
        long j = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_frs_cache_time", 604800000L);
        if (j < 0) {
            return 604800000L;
        }
        return j;
    }

    public boolean MS(String str) {
        if (this.hvk != null && str != null) {
            byte[] bArr = this.hvk.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.parserProtobuf(bArr, false);
                if (this.responseData.forum != null && this.responseData.forum.getFrsBannerData() != null) {
                    this.responseData.forum.getFrsBannerData().dIN = false;
                }
                return true;
            }
        }
        return false;
    }

    public void ft(String str, String str2) {
        if (this.hvk != null && str != null) {
            byte[] bArr = this.hvk.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void fu(String str, String str2) {
        if (this.hvk != null && str != null) {
            byte[] bArr = this.hvk.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void fv(String str, String str2) {
        if (this.hvk != null && str != null) {
            byte[] bArr = this.hvk.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void p(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        int i;
        if (this.hvk != null && str != null && bArr != null && bArr.length > 0) {
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null && (count = com.baidu.tbadk.core.util.w.getCount((list = frsPageResIdl.data.thread_list))) > 0) {
                    if (count >= 15) {
                        c(str, bArr, true);
                        return;
                    }
                    byte[] bArr2 = this.hvk.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                    int count2 = com.baidu.tbadk.core.util.w.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (i2 < count2 && count < 15) {
                        ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.w.getItem(list2, i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.is_top.intValue() != 0 || c(threadInfo.tid.longValue(), list)) {
                            i = count;
                        } else {
                            arrayList.add(threadInfo);
                            User a = a(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (a != null) {
                                arrayList2.add(a);
                            }
                            i = count + 1;
                        }
                        i2++;
                        count = i;
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
        int count = com.baidu.tbadk.core.util.w.getCount(list);
        for (int i = 0; i < count; i++) {
            ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.w.getItem(list, i);
            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private User a(List<User> list, long j) {
        if (com.baidu.tbadk.core.util.w.isEmpty(list)) {
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
                this.hvk.set(TbadkCoreApplication.getCurrentAccount() + str, bArr, dha());
                return;
            }
            this.hvk.asyncSet(TbadkCoreApplication.getCurrentAccount() + str, bArr, dha());
        }
    }

    public void aV(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.hvk.remove(TbadkCoreApplication.getCurrentAccount() + str);
                return;
            }
            this.hvk.asyncRemove(TbadkCoreApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        l.b<byte[]> bu;
        if (str == null || str.length() <= 0 || (bu = this.hvk.bu(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(bu.lastSaveTime, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String e(String str, int i, int i2, int i3) {
        String str2 = str + i + i2;
        if (i3 != 0) {
            return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + i3;
        }
        return str2;
    }
}

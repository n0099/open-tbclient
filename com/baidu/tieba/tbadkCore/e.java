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
    private static e nkw;
    private com.baidu.adp.lib.cache.l<byte[]> iVY;
    private m responseData = null;

    private e() {
        this.iVY = null;
        this.iVY = BdCacheService.lx().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static e dKh() {
        if (nkw == null) {
            synchronized (e.class) {
                if (nkw == null) {
                    nkw = new e();
                }
            }
        }
        return nkw;
    }

    public long dKi() {
        long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_frs_cache_time", 604800000L);
        if (j < 0) {
            return 604800000L;
        }
        return j;
    }

    public boolean RV(String str) {
        if (this.iVY != null && str != null) {
            byte[] bArr = this.iVY.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new m();
                this.responseData.parserProtobuf(bArr, false);
                if (this.responseData.forum != null && this.responseData.forum.getFrsBannerData() != null) {
                    this.responseData.forum.getFrsBannerData().eLv = false;
                }
                return true;
            }
        }
        return false;
    }

    public void gm(String str, String str2) {
        if (this.iVY != null && str != null) {
            byte[] bArr = this.iVY.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                        d(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void gn(String str, String str2) {
        if (this.iVY != null && str != null) {
            byte[] bArr = this.iVY.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                        d(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void go(String str, String str2) {
        if (this.iVY != null && str != null) {
            byte[] bArr = this.iVY.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                        d(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void r(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        int i;
        if (this.iVY != null && str != null && bArr != null && bArr.length > 0) {
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null && (count = com.baidu.tbadk.core.util.x.getCount((list = frsPageResIdl.data.thread_list))) > 0) {
                    if (count >= 15) {
                        d(str, bArr, true);
                        return;
                    }
                    byte[] bArr2 = this.iVY.get(TbadkCoreApplication.getCurrentAccount() + str);
                    if (bArr2 == null) {
                        d(str, bArr, true);
                        return;
                    }
                    FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) WIRE.parseFrom(bArr2, FrsPageResIdl.class);
                    if (frsPageResIdl2 == null || frsPageResIdl2.data == null || frsPageResIdl2.data.thread_list == null) {
                        d(str, bArr, true);
                        return;
                    }
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int count2 = com.baidu.tbadk.core.util.x.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (i2 < count2 && count < 15) {
                        ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.x.getItem(list2, i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.is_top.intValue() != 0 || b(threadInfo.tid.longValue(), list)) {
                            i = count;
                        } else {
                            arrayList.add(threadInfo);
                            User c = c(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (c != null) {
                                arrayList2.add(c);
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
                    d(str, builder.build(true).toByteArray(), true);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private boolean b(long j, List<ThreadInfo> list) {
        int count = com.baidu.tbadk.core.util.x.getCount(list);
        for (int i = 0; i < count; i++) {
            ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.x.getItem(list, i);
            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private User c(List<User> list, long j) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        for (User user : list) {
            if (user != null && user.id.longValue() == j) {
                return user;
            }
        }
        return null;
    }

    public void d(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.iVY.set(TbadkCoreApplication.getCurrentAccount() + str, bArr, dKi());
                return;
            }
            this.iVY.asyncSet(TbadkCoreApplication.getCurrentAccount() + str, bArr, dKi());
        }
    }

    public void bd(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.iVY.remove(TbadkCoreApplication.getCurrentAccount() + str);
                return;
            }
            this.iVY.asyncRemove(TbadkCoreApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        l.b<byte[]> by;
        if (str == null || str.length() <= 0 || (by = this.iVY.by(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(by.lastSaveTime, System.currentTimeMillis());
    }

    public m getResponseData() {
        return this.responseData;
    }

    public String f(String str, int i, int i2, int i3) {
        String str2 = str + i + i2;
        if (i3 != 0) {
            return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + i3;
        }
        return str2;
    }
}

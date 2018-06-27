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
/* loaded from: classes2.dex */
public class c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private static c gJE;
    private com.baidu.adp.lib.cache.l<byte[]> bwp;
    private i responseData = null;

    private c() {
        this.bwp = null;
        this.bwp = BdCacheService.he().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static c bvo() {
        if (gJE == null) {
            synchronized (c.class) {
                if (gJE == null) {
                    gJE = new c();
                }
            }
        }
        return gJE;
    }

    public long bvp() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_frs_cache_time", 604800000L);
        if (j < 0) {
            return 604800000L;
        }
        return j;
    }

    public boolean ty(String str) {
        if (this.bwp != null && str != null) {
            byte[] bArr = this.bwp.get(TbadkCoreApplication.getCurrentAccount() + str);
            if (bArr != null && bArr.length > 0) {
                this.responseData = new i();
                this.responseData.G(bArr);
                if (this.responseData.fsh != null && this.responseData.fsh.getFrsBannerData() != null) {
                    this.responseData.fsh.getFrsBannerData().agh = false;
                }
                return true;
            }
        }
        return false;
    }

    public void ck(String str, String str2) {
        if (this.bwp != null && str != null) {
            byte[] bArr = this.bwp.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void cl(String str, String str2) {
        if (this.bwp != null && str != null) {
            byte[] bArr = this.bwp.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void cm(String str, String str2) {
        if (this.bwp != null && str != null) {
            byte[] bArr = this.bwp.get(TbadkCoreApplication.getCurrentAccount() + str);
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

    public void o(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int z;
        int i;
        if (this.bwp != null && str != null && bArr != null && bArr.length > 0) {
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null && (z = com.baidu.tbadk.core.util.w.z((list = frsPageResIdl.data.thread_list))) > 0) {
                    if (z >= 15) {
                        c(str, bArr, true);
                        return;
                    }
                    byte[] bArr2 = this.bwp.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                    int z2 = com.baidu.tbadk.core.util.w.z(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (i2 < z2 && z < 15) {
                        ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.w.d(list2, i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.is_top.intValue() != 0 || e(threadInfo.tid.longValue(), list)) {
                            i = z;
                        } else {
                            arrayList.add(threadInfo);
                            User a = a(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (a != null) {
                                arrayList2.add(a);
                            }
                            i = z + 1;
                        }
                        i2++;
                        z = i;
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

    private boolean e(long j, List<ThreadInfo> list) {
        int z = com.baidu.tbadk.core.util.w.z(list);
        for (int i = 0; i < z; i++) {
            ThreadInfo threadInfo = (ThreadInfo) com.baidu.tbadk.core.util.w.d(list, i);
            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private User a(List<User> list, long j) {
        if (com.baidu.tbadk.core.util.w.A(list)) {
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
                this.bwp.a(TbadkCoreApplication.getCurrentAccount() + str, bArr, bvp());
                return;
            }
            this.bwp.b(TbadkCoreApplication.getCurrentAccount() + str, bArr, bvp());
        }
    }

    public void U(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.bwp.remove(TbadkCoreApplication.getCurrentAccount() + str);
                return;
            }
            this.bwp.ao(TbadkCoreApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        l.b<byte[]> an;
        if (str == null || str.length() <= 0 || (an = this.bwp.an(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(an.xY, System.currentTimeMillis());
    }

    public i getResponseData() {
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

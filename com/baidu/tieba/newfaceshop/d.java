package com.baidu.tieba.newfaceshop;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.faceshop.ab;
import com.baidu.tieba.faceshop.ad;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class d {
    private static volatile d lAt;
    private boolean lAr;
    private boolean lAs;
    private NewFaceSyncUploadModel lAo = new NewFaceSyncUploadModel();
    private NewFaceSyncDownloadModel lAp = new NewFaceSyncDownloadModel();
    private NewFaceGroupDownloadModel iUd = new NewFaceGroupDownloadModel();
    private ad lAq = new ad();

    public static d dip() {
        if (lAt == null) {
            synchronized (d.class) {
                if (lAt == null) {
                    lAt = new d();
                }
            }
        }
        return lAt;
    }

    public void diq() {
        a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<MyEmotionGroupData> dim = c.dil().dim();
                if (dim != null) {
                    if (!dim.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (int i2 = 0; i2 < dim.size() && i < 30; i2++) {
                            MyEmotionGroupData myEmotionGroupData = dim.get(i2);
                            if (myEmotionGroupData != null) {
                                sb.append(myEmotionGroupData.getGroupId());
                                if (i2 < dim.size() - 1) {
                                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                }
                                i++;
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = UserCollectModel.ALL_DELETE;
                    }
                    d.this.lAo.OQ(str);
                }
            }
        });
    }

    public void dir() {
        this.lAr = true;
        this.lAs = true;
        this.lAp.a(new com.baidu.tieba.newfaceshop.a.a() { // from class: com.baidu.tieba.newfaceshop.d.2
            @Override // com.baidu.tieba.newfaceshop.a.a
            public void a(final GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                if (getCloudFaceGroupMessage == null) {
                    d.this.lAs = false;
                    d.this.lAr = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.getCollectUpdateTime()) {
                    d.this.lAs = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.getCollectUpdateTime()) {
                        new UserCollectModel().upload();
                    }
                    ab.czG().czH();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    d.this.lAs = false;
                } else {
                    a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lAq.dc(getCloudFaceGroupMessage.getCollectEmotionList());
                        }
                    });
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.getFaceGroupUpdateTime()) {
                    d.this.lAr = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.getFaceGroupUpdateTime()) {
                        d.this.diq();
                    }
                    c.dil().din();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    d.this.eW(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    d.this.lAr = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(final List<String> list) {
        a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.3
            @Override // java.lang.Runnable
            public void run() {
                c.dil().ur(true);
                List<MyEmotionGroupData> dim = c.dil().dim();
                ArrayList arrayList = new ArrayList();
                if (dim != null) {
                    for (MyEmotionGroupData myEmotionGroupData : dim) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                d.this.D(list, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<String> list, List<String> list2) {
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list2) {
                if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                c.dil().v(arrayList, false);
            }
        }
        E(list, list2);
    }

    private void E(final List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            this.lAr = false;
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
            if (!list2.contains(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            final AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
            for (String str2 : arrayList) {
                this.iUd.a(str2, false, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.d.4
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str3) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            d.this.eY(list);
                        }
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str3) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            d.this.eY(list);
                        }
                    }
                });
            }
            return;
        }
        eX(list);
    }

    private void eX(final List<String> list) {
        if (l.isMainThread()) {
            a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eY(list);
                }
            });
        } else {
            eY(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(List<String> list) {
        if (c.dil().w(list, false)) {
            ho(System.currentTimeMillis());
        }
        this.lAr = false;
    }

    public static long getFaceGroupUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong("face_group_update_time" + diu(), 0L);
    }

    public static long getCollectUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong("face_collect_update_time" + diu(), 0L);
    }

    public static void hn(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("face_collect_update_time" + diu(), j);
    }

    public static void ho(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("face_group_update_time" + diu(), j);
    }

    public boolean dis() {
        return this.lAr;
    }

    public boolean dit() {
        return this.lAs;
    }

    public void us(boolean z) {
        this.lAs = z;
    }

    private static String diu() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }
}

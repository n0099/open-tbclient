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
    private static volatile d lAH;
    private boolean lAF;
    private boolean lAG;
    private NewFaceSyncUploadModel lAC = new NewFaceSyncUploadModel();
    private NewFaceSyncDownloadModel lAD = new NewFaceSyncDownloadModel();
    private NewFaceGroupDownloadModel iUr = new NewFaceGroupDownloadModel();
    private ad lAE = new ad();

    public static d diw() {
        if (lAH == null) {
            synchronized (d.class) {
                if (lAH == null) {
                    lAH = new d();
                }
            }
        }
        return lAH;
    }

    public void dix() {
        a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<MyEmotionGroupData> dit = c.dis().dit();
                if (dit != null) {
                    if (!dit.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (int i2 = 0; i2 < dit.size() && i < 30; i2++) {
                            MyEmotionGroupData myEmotionGroupData = dit.get(i2);
                            if (myEmotionGroupData != null) {
                                sb.append(myEmotionGroupData.getGroupId());
                                if (i2 < dit.size() - 1) {
                                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                }
                                i++;
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = UserCollectModel.ALL_DELETE;
                    }
                    d.this.lAC.OR(str);
                }
            }
        });
    }

    public void diy() {
        this.lAF = true;
        this.lAG = true;
        this.lAD.a(new com.baidu.tieba.newfaceshop.a.a() { // from class: com.baidu.tieba.newfaceshop.d.2
            @Override // com.baidu.tieba.newfaceshop.a.a
            public void a(final GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                if (getCloudFaceGroupMessage == null) {
                    d.this.lAG = false;
                    d.this.lAF = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.getCollectUpdateTime()) {
                    d.this.lAG = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.getCollectUpdateTime()) {
                        new UserCollectModel().upload();
                    }
                    ab.czN().czO();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    d.this.lAG = false;
                } else {
                    a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lAE.dc(getCloudFaceGroupMessage.getCollectEmotionList());
                        }
                    });
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.getFaceGroupUpdateTime()) {
                    d.this.lAF = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.getFaceGroupUpdateTime()) {
                        d.this.dix();
                    }
                    c.dis().diu();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    d.this.eW(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    d.this.lAF = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(final List<String> list) {
        a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.3
            @Override // java.lang.Runnable
            public void run() {
                c.dis().ur(true);
                List<MyEmotionGroupData> dit = c.dis().dit();
                ArrayList arrayList = new ArrayList();
                if (dit != null) {
                    for (MyEmotionGroupData myEmotionGroupData : dit) {
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
                c.dis().v(arrayList, false);
            }
        }
        E(list, list2);
    }

    private void E(final List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            this.lAF = false;
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
                this.iUr.a(str2, false, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.d.4
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
            a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.5
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
        if (c.dis().w(list, false)) {
            ho(System.currentTimeMillis());
        }
        this.lAF = false;
    }

    public static long getFaceGroupUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong("face_group_update_time" + diB(), 0L);
    }

    public static long getCollectUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong("face_collect_update_time" + diB(), 0L);
    }

    public static void hn(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("face_collect_update_time" + diB(), j);
    }

    public static void ho(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("face_group_update_time" + diB(), j);
    }

    public boolean diz() {
        return this.lAF;
    }

    public boolean diA() {
        return this.lAG;
    }

    public void us(boolean z) {
        this.lAG = z;
    }

    private static String diB() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }
}

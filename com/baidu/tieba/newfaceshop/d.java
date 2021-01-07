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
    private static volatile d lwU;
    private boolean lwS;
    private boolean lwT;
    private NewFaceSyncUploadModel lwP = new NewFaceSyncUploadModel();
    private NewFaceSyncDownloadModel lwQ = new NewFaceSyncDownloadModel();
    private NewFaceGroupDownloadModel iTd = new NewFaceGroupDownloadModel();
    private ad lwR = new ad();

    public static d dkg() {
        if (lwU == null) {
            synchronized (d.class) {
                if (lwU == null) {
                    lwU = new d();
                }
            }
        }
        return lwU;
    }

    public void dkh() {
        a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<MyEmotionGroupData> dkd = c.dkc().dkd();
                if (dkd != null) {
                    if (!dkd.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (int i2 = 0; i2 < dkd.size() && i < 30; i2++) {
                            MyEmotionGroupData myEmotionGroupData = dkd.get(i2);
                            if (myEmotionGroupData != null) {
                                sb.append(myEmotionGroupData.getGroupId());
                                if (i2 < dkd.size() - 1) {
                                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                }
                                i++;
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = UserCollectModel.ALL_DELETE;
                    }
                    d.this.lwP.Pi(str);
                }
            }
        });
    }

    public void dki() {
        this.lwS = true;
        this.lwT = true;
        this.lwQ.a(new com.baidu.tieba.newfaceshop.a.a() { // from class: com.baidu.tieba.newfaceshop.d.2
            @Override // com.baidu.tieba.newfaceshop.a.a
            public void a(final GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                if (getCloudFaceGroupMessage == null) {
                    d.this.lwT = false;
                    d.this.lwS = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.getCollectUpdateTime()) {
                    d.this.lwT = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.getCollectUpdateTime()) {
                        new UserCollectModel().upload();
                    }
                    ab.cCn().cCo();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    d.this.lwT = false;
                } else {
                    a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lwR.dh(getCloudFaceGroupMessage.getCollectEmotionList());
                        }
                    });
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.getFaceGroupUpdateTime()) {
                    d.this.lwS = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.getFaceGroupUpdateTime()) {
                        d.this.dkh();
                    }
                    c.dkc().dke();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    d.this.eY(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    d.this.lwS = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(final List<String> list) {
        a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.3
            @Override // java.lang.Runnable
            public void run() {
                c.dkc().ui(true);
                List<MyEmotionGroupData> dkd = c.dkc().dkd();
                ArrayList arrayList = new ArrayList();
                if (dkd != null) {
                    for (MyEmotionGroupData myEmotionGroupData : dkd) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                d.this.E(list, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<String> list, List<String> list2) {
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list2) {
                if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                c.dkc().u(arrayList, false);
            }
        }
        F(list, list2);
    }

    private void F(final List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            this.lwS = false;
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
                this.iTd.a(str2, false, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.d.4
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str3) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            d.this.fa(list);
                        }
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str3) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            d.this.fa(list);
                        }
                    }
                });
            }
            return;
        }
        eZ(list);
    }

    private void eZ(final List<String> list) {
        if (l.isMainThread()) {
            a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fa(list);
                }
            });
        } else {
            fa(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(List<String> list) {
        if (c.dkc().v(list, false)) {
            hj(System.currentTimeMillis());
        }
        this.lwS = false;
    }

    public static long getFaceGroupUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getLong("face_group_update_time" + dkl(), 0L);
    }

    public static long getCollectUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getLong("face_collect_update_time" + dkl(), 0L);
    }

    public static void hi(long j) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong("face_collect_update_time" + dkl(), j);
    }

    public static void hj(long j) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong("face_group_update_time" + dkl(), j);
    }

    public boolean dkj() {
        return this.lwS;
    }

    public boolean dkk() {
        return this.lwT;
    }

    public void uj(boolean z) {
        this.lwT = z;
    }

    private static String dkl() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }
}

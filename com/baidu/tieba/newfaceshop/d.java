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
/* loaded from: classes8.dex */
public class d {
    private static volatile d lso;
    private boolean lsm;
    private boolean lsn;
    private NewFaceSyncUploadModel lsj = new NewFaceSyncUploadModel();
    private NewFaceSyncDownloadModel lsk = new NewFaceSyncDownloadModel();
    private NewFaceGroupDownloadModel iOw = new NewFaceGroupDownloadModel();
    private ad lsl = new ad();

    public static d dgo() {
        if (lso == null) {
            synchronized (d.class) {
                if (lso == null) {
                    lso = new d();
                }
            }
        }
        return lso;
    }

    public void dgp() {
        a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<MyEmotionGroupData> dgl = c.dgk().dgl();
                if (dgl != null) {
                    if (!dgl.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (int i2 = 0; i2 < dgl.size() && i < 30; i2++) {
                            MyEmotionGroupData myEmotionGroupData = dgl.get(i2);
                            if (myEmotionGroupData != null) {
                                sb.append(myEmotionGroupData.getGroupId());
                                if (i2 < dgl.size() - 1) {
                                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                }
                                i++;
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = UserCollectModel.ALL_DELETE;
                    }
                    d.this.lsj.Oa(str);
                }
            }
        });
    }

    public void dgq() {
        this.lsm = true;
        this.lsn = true;
        this.lsk.a(new com.baidu.tieba.newfaceshop.a.a() { // from class: com.baidu.tieba.newfaceshop.d.2
            @Override // com.baidu.tieba.newfaceshop.a.a
            public void a(final GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                if (getCloudFaceGroupMessage == null) {
                    d.this.lsn = false;
                    d.this.lsm = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.getCollectUpdateTime()) {
                    d.this.lsn = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.getCollectUpdateTime()) {
                        new UserCollectModel().upload();
                    }
                    ab.cyv().cyw();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    d.this.lsn = false;
                } else {
                    a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lsl.dh(getCloudFaceGroupMessage.getCollectEmotionList());
                        }
                    });
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.getFaceGroupUpdateTime()) {
                    d.this.lsm = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.getFaceGroupUpdateTime()) {
                        d.this.dgp();
                    }
                    c.dgk().dgm();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    d.this.eY(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    d.this.lsm = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(final List<String> list) {
        a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.3
            @Override // java.lang.Runnable
            public void run() {
                c.dgk().ue(true);
                List<MyEmotionGroupData> dgl = c.dgk().dgl();
                ArrayList arrayList = new ArrayList();
                if (dgl != null) {
                    for (MyEmotionGroupData myEmotionGroupData : dgl) {
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
                c.dgk().u(arrayList, false);
            }
        }
        F(list, list2);
    }

    private void F(final List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            this.lsm = false;
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
                this.iOw.a(str2, false, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.d.4
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
            a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.5
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
        if (c.dgk().v(list, false)) {
            hj(System.currentTimeMillis());
        }
        this.lsm = false;
    }

    public static long getFaceGroupUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getLong("face_group_update_time" + dgt(), 0L);
    }

    public static long getCollectUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getLong("face_collect_update_time" + dgt(), 0L);
    }

    public static void hi(long j) {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong("face_collect_update_time" + dgt(), j);
    }

    public static void hj(long j) {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong("face_group_update_time" + dgt(), j);
    }

    public boolean dgr() {
        return this.lsm;
    }

    public boolean dgs() {
        return this.lsn;
    }

    public void uf(boolean z) {
        this.lsn = z;
    }

    private static String dgt() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }
}

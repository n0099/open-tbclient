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
    private static volatile d lCJ;
    private boolean lCH;
    private boolean lCI;
    private NewFaceSyncUploadModel lCE = new NewFaceSyncUploadModel();
    private NewFaceSyncDownloadModel lCF = new NewFaceSyncDownloadModel();
    private NewFaceGroupDownloadModel iWa = new NewFaceGroupDownloadModel();
    private ad lCG = new ad();

    public static d diF() {
        if (lCJ == null) {
            synchronized (d.class) {
                if (lCJ == null) {
                    lCJ = new d();
                }
            }
        }
        return lCJ;
    }

    public void diG() {
        a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<MyEmotionGroupData> diC = c.diB().diC();
                if (diC != null) {
                    if (!diC.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (int i2 = 0; i2 < diC.size() && i < 30; i2++) {
                            MyEmotionGroupData myEmotionGroupData = diC.get(i2);
                            if (myEmotionGroupData != null) {
                                sb.append(myEmotionGroupData.getGroupId());
                                if (i2 < diC.size() - 1) {
                                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                }
                                i++;
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = UserCollectModel.ALL_DELETE;
                    }
                    d.this.lCE.OX(str);
                }
            }
        });
    }

    public void diH() {
        this.lCH = true;
        this.lCI = true;
        this.lCF.a(new com.baidu.tieba.newfaceshop.a.a() { // from class: com.baidu.tieba.newfaceshop.d.2
            @Override // com.baidu.tieba.newfaceshop.a.a
            public void a(final GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                if (getCloudFaceGroupMessage == null) {
                    d.this.lCI = false;
                    d.this.lCH = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.getCollectUpdateTime()) {
                    d.this.lCI = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.getCollectUpdateTime()) {
                        new UserCollectModel().upload();
                    }
                    ab.czT().czU();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    d.this.lCI = false;
                } else {
                    a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lCG.dc(getCloudFaceGroupMessage.getCollectEmotionList());
                        }
                    });
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.getFaceGroupUpdateTime()) {
                    d.this.lCH = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.getFaceGroupUpdateTime()) {
                        d.this.diG();
                    }
                    c.diB().diD();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    d.this.eW(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    d.this.lCH = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(final List<String> list) {
        a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.3
            @Override // java.lang.Runnable
            public void run() {
                c.diB().ur(true);
                List<MyEmotionGroupData> diC = c.diB().diC();
                ArrayList arrayList = new ArrayList();
                if (diC != null) {
                    for (MyEmotionGroupData myEmotionGroupData : diC) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                d.this.C(list, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List<String> list, List<String> list2) {
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list2) {
                if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                c.diB().v(arrayList, false);
            }
        }
        D(list, list2);
    }

    private void D(final List<String> list, List<String> list2) {
        if (list == null || list.isEmpty()) {
            this.lCH = false;
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
                this.iWa.a(str2, false, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.d.4
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
            a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.d.5
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
        if (c.diB().w(list, false)) {
            ho(System.currentTimeMillis());
        }
        this.lCH = false;
    }

    public static long getFaceGroupUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getLong("face_group_update_time" + diK(), 0L);
    }

    public static long getCollectUpdateTime() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getLong("face_collect_update_time" + diK(), 0L);
    }

    public static void hn(long j) {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong("face_collect_update_time" + diK(), j);
    }

    public static void ho(long j) {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong("face_group_update_time" + diK(), j);
    }

    public boolean diI() {
        return this.lCH;
    }

    public boolean diJ() {
        return this.lCI;
    }

    public void us(boolean z) {
        this.lCI = z;
    }

    private static String diK() {
        return TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
    }
}

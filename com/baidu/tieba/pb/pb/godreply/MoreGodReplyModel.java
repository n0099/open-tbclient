package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel hJW;
    private int hJX;
    private int hJY;
    private z.a hJZ;
    private final z.a hKa;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hJX = -1;
        this.hJY = -1;
        this.hKa = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aD(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bQI = MoreGodReplyModel.this.hJW.getPbData().bQI();
                if (bQI != null) {
                    List<PostData> list2 = bQI.hJg;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hJW.a(MoreGodReplyModel.this.hJW.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hJX > 0) {
                    MoreGodReplyModel.this.hJY = MoreGodReplyModel.this.hJX;
                }
                if (MoreGodReplyModel.this.hJZ != null) {
                    MoreGodReplyModel.this.hJZ.aD(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hJZ != null) {
                    MoreGodReplyModel.this.hJZ.n(i, str, str2);
                }
            }
        };
        this.hJW = pbModel;
        this.hJW.bUb().b(this.hKa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(List<PostData> list, PostData postData) {
        if (list != null && postData != null) {
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.getId() != null && postData.getId() != null && postData2.getId().equals(postData.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bRC() {
        m bQI;
        com.baidu.tieba.pb.data.d pbData = this.hJW.getPbData();
        if (pbData == null || (bQI = pbData.bQI()) == null) {
            return false;
        }
        if (this.hJY < 0) {
            this.hJY = bQI.getCount();
        }
        List<Long> list = bQI.hJh;
        int size = list.size();
        int i = this.hJY;
        if (size <= i || bQI.hJg.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hJX = min;
        this.isLoading = true;
        this.hJW.bUb().dV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel bRD() {
        return this.hJW;
    }

    public List<com.baidu.adp.widget.ListView.m> bRE() {
        com.baidu.tieba.pb.data.d pbData = this.hJW.getPbData();
        if (pbData == null || pbData.bQI() == null || v.isEmpty(pbData.bQI().hJg)) {
            return null;
        }
        m bQI = pbData.bQI();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bQI.hJg;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.jih = i < size + (-1);
            }
            i++;
        }
        return arrayList;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        return false;
    }

    public void a(z.a aVar) {
        this.hJZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pz() {
        m bQI;
        com.baidu.tieba.pb.data.d pbData = this.hJW.getPbData();
        if (pbData == null || (bQI = pbData.bQI()) == null) {
            return false;
        }
        if (this.hJY < 0) {
            this.hJY = bQI.getCount();
        }
        return bQI.hJh.size() > this.hJY && bQI.hJg.size() < 100;
    }
}

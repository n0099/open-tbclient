package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel eJB;
    private int eJC;
    private int eJD;
    private x.a eJE;
    private final x.a eJF;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.eJC = -1;
        this.eJD = -1;
        this.eJF = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void B(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aQg = MoreGodReplyModel.this.eJB.getPbData().aQg();
                if (aQg != null) {
                    List<PostData> list2 = aQg.eHD;
                    int size = list2.size();
                    if (!v.v(list)) {
                        for (PostData postData : list) {
                            if (!list2.contains(postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.eJB.a(MoreGodReplyModel.this.eJB.getPbData(), size);
                }
                if (MoreGodReplyModel.this.eJC > 0) {
                    MoreGodReplyModel.this.eJD = MoreGodReplyModel.this.eJC;
                }
                if (MoreGodReplyModel.this.eJE != null) {
                    MoreGodReplyModel.this.eJE.B(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.eJE != null) {
                    MoreGodReplyModel.this.eJE.h(i, str, str2);
                }
            }
        };
        this.eJB = pbModel;
        this.eJB.aTh().b(this.eJF);
    }

    public boolean aQZ() {
        n aQg;
        f pbData = this.eJB.getPbData();
        if (pbData == null || (aQg = pbData.aQg()) == null) {
            return false;
        }
        if (this.eJD < 0) {
            this.eJD = aQg.getCount();
        }
        List<Long> list = aQg.eHE;
        int size = list.size();
        int i = this.eJD;
        if (size <= i || aQg.eHD.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.eJC = min;
        this.isLoading = true;
        this.eJB.aTh().cw(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wz() {
        return this.isLoading;
    }

    public PbModel aRa() {
        return this.eJB;
    }

    public List<com.baidu.adp.widget.ListView.f> aRb() {
        f pbData = this.eJB.getPbData();
        if (pbData == null || pbData.aQg() == null || v.v(pbData.aQg().eHD)) {
            return null;
        }
        n aQg = pbData.aQg();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aQg.eHD;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gqW = i < size + (-1);
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

    public void a(x.a aVar) {
        this.eJE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Yg() {
        n aQg;
        f pbData = this.eJB.getPbData();
        if (pbData == null || (aQg = pbData.aQg()) == null) {
            return false;
        }
        if (this.eJD < 0) {
            this.eJD = aQg.getCount();
        }
        return aQg.eHE.size() > this.eJD && aQg.eHD.size() < 100;
    }
}

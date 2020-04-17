package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel jpB;
    private int jpC;
    private int jpD;
    private x.a jpE;
    private final x.a jpF;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.jpC = -1;
        this.jpD = -1;
        this.jpF = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void aS(List<PostData> list) {
                n cvF;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jpB != null && MoreGodReplyModel.this.jpB.getPbData() != null && (cvF = MoreGodReplyModel.this.jpB.getPbData().cvF()) != null) {
                    List<PostData> list2 = cvF.joL;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.jpB.a(MoreGodReplyModel.this.jpB.getPbData(), size);
                }
                if (MoreGodReplyModel.this.jpC > 0) {
                    MoreGodReplyModel.this.jpD = MoreGodReplyModel.this.jpC;
                }
                if (MoreGodReplyModel.this.jpE != null) {
                    MoreGodReplyModel.this.jpE.aS(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jpE != null) {
                    MoreGodReplyModel.this.jpE.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.jpB = pbModel;
            x czd = pbModel.czd();
            if (czd != null) {
                czd.b(this.jpF);
            }
        }
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

    public boolean cwC() {
        n cvF;
        com.baidu.tieba.pb.data.e pbData = this.jpB.getPbData();
        if (pbData == null || (cvF = pbData.cvF()) == null) {
            return false;
        }
        if (this.jpD < 0) {
            this.jpD = cvF.getCount();
        }
        List<Long> list = cvF.joM;
        int size = list.size();
        int i = this.jpD;
        if (size <= i || cvF.joL.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.jpC = min;
        this.isLoading = true;
        this.jpB.czd().dR(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cwD() {
        return this.jpB;
    }

    public List<m> cwE() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jpB == null || (pbData = this.jpB.getPbData()) == null || pbData.cvF() == null || v.isEmpty(pbData.cvF().joL)) {
            return null;
        }
        n cvF = pbData.cvF();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cvF.joL;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.kSZ = i < size + (-1);
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
        this.jpE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aki() {
        com.baidu.tieba.pb.data.e pbData;
        n cvF;
        if (this.jpB == null || (pbData = this.jpB.getPbData()) == null || (cvF = pbData.cvF()) == null) {
            return false;
        }
        if (this.jpD < 0) {
            this.jpD = cvF.getCount();
        }
        return cvF.joM.size() > this.jpD && cvF.joL.size() < 100;
    }
}

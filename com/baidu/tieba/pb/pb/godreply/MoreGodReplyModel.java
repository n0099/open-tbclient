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
    private PbModel jpF;
    private int jpG;
    private int jpH;
    private x.a jpI;
    private final x.a jpJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.jpG = -1;
        this.jpH = -1;
        this.jpJ = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void aS(List<PostData> list) {
                n cvC;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jpF != null && MoreGodReplyModel.this.jpF.getPbData() != null && (cvC = MoreGodReplyModel.this.jpF.getPbData().cvC()) != null) {
                    List<PostData> list2 = cvC.joP;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.jpF.a(MoreGodReplyModel.this.jpF.getPbData(), size);
                }
                if (MoreGodReplyModel.this.jpG > 0) {
                    MoreGodReplyModel.this.jpH = MoreGodReplyModel.this.jpG;
                }
                if (MoreGodReplyModel.this.jpI != null) {
                    MoreGodReplyModel.this.jpI.aS(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jpI != null) {
                    MoreGodReplyModel.this.jpI.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.jpF = pbModel;
            x cza = pbModel.cza();
            if (cza != null) {
                cza.b(this.jpJ);
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

    public boolean cwz() {
        n cvC;
        com.baidu.tieba.pb.data.e pbData = this.jpF.getPbData();
        if (pbData == null || (cvC = pbData.cvC()) == null) {
            return false;
        }
        if (this.jpH < 0) {
            this.jpH = cvC.getCount();
        }
        List<Long> list = cvC.joQ;
        int size = list.size();
        int i = this.jpH;
        if (size <= i || cvC.joP.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.jpG = min;
        this.isLoading = true;
        this.jpF.cza().dR(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cwA() {
        return this.jpF;
    }

    public List<m> cwB() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jpF == null || (pbData = this.jpF.getPbData()) == null || pbData.cvC() == null || v.isEmpty(pbData.cvC().joP)) {
            return null;
        }
        n cvC = pbData.cvC();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cvC.joP;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.kTd = i < size + (-1);
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
        this.jpI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean akh() {
        com.baidu.tieba.pb.data.e pbData;
        n cvC;
        if (this.jpF == null || (pbData = this.jpF.getPbData()) == null || (cvC = pbData.cvC()) == null) {
            return false;
        }
        if (this.jpH < 0) {
            this.jpH = cvC.getCount();
        }
        return cvC.joQ.size() > this.jpH && cvC.joP.size() < 100;
    }
}

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
    private final PbModel iDF;
    private int iDG;
    private int iDH;
    private x.a iDI;
    private final x.a iDJ;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iDG = -1;
        this.iDH = -1;
        this.iDJ = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void onSuccess(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n ckD = MoreGodReplyModel.this.iDF.getPbData().ckD();
                if (ckD != null) {
                    List<PostData> list2 = ckD.iCQ;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iDF.a(MoreGodReplyModel.this.iDF.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iDG > 0) {
                    MoreGodReplyModel.this.iDH = MoreGodReplyModel.this.iDG;
                }
                if (MoreGodReplyModel.this.iDI != null) {
                    MoreGodReplyModel.this.iDI.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iDI != null) {
                    MoreGodReplyModel.this.iDI.l(i, str, str2);
                }
            }
        };
        this.iDF = pbModel;
        this.iDF.cnZ().b(this.iDJ);
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

    public boolean cly() {
        n ckD;
        com.baidu.tieba.pb.data.e pbData = this.iDF.getPbData();
        if (pbData == null || (ckD = pbData.ckD()) == null) {
            return false;
        }
        if (this.iDH < 0) {
            this.iDH = ckD.getCount();
        }
        List<Long> list = ckD.iCR;
        int size = list.size();
        int i = this.iDH;
        if (size <= i || ckD.iCQ.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iDG = min;
        this.isLoading = true;
        this.iDF.cnZ().dG(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel clz() {
        return this.iDF;
    }

    public List<m> clA() {
        com.baidu.tieba.pb.data.e pbData = this.iDF.getPbData();
        if (pbData == null || pbData.ckD() == null || v.isEmpty(pbData.ckD().iCQ)) {
            return null;
        }
        n ckD = pbData.ckD();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = ckD.iCQ;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.khc = i < size + (-1);
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
        this.iDI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean abY() {
        n ckD;
        com.baidu.tieba.pb.data.e pbData = this.iDF.getPbData();
        if (pbData == null || (ckD = pbData.ckD()) == null) {
            return false;
        }
        if (this.iDH < 0) {
            this.iDH = ckD.getCount();
        }
        return ckD.iCR.size() > this.iDH && ckD.iCQ.size() < 100;
    }
}

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
    private final PbModel iDT;
    private int iDU;
    private int iDV;
    private x.a iDW;
    private final x.a iDX;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iDU = -1;
        this.iDV = -1;
        this.iDX = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void onSuccess(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n ckG = MoreGodReplyModel.this.iDT.getPbData().ckG();
                if (ckG != null) {
                    List<PostData> list2 = ckG.iDe;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iDT.a(MoreGodReplyModel.this.iDT.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iDU > 0) {
                    MoreGodReplyModel.this.iDV = MoreGodReplyModel.this.iDU;
                }
                if (MoreGodReplyModel.this.iDW != null) {
                    MoreGodReplyModel.this.iDW.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iDW != null) {
                    MoreGodReplyModel.this.iDW.l(i, str, str2);
                }
            }
        };
        this.iDT = pbModel;
        this.iDT.coc().b(this.iDX);
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

    public boolean clB() {
        n ckG;
        com.baidu.tieba.pb.data.e pbData = this.iDT.getPbData();
        if (pbData == null || (ckG = pbData.ckG()) == null) {
            return false;
        }
        if (this.iDV < 0) {
            this.iDV = ckG.getCount();
        }
        List<Long> list = ckG.iDf;
        int size = list.size();
        int i = this.iDV;
        if (size <= i || ckG.iDe.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iDU = min;
        this.isLoading = true;
        this.iDT.coc().dG(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel clC() {
        return this.iDT;
    }

    public List<m> clD() {
        com.baidu.tieba.pb.data.e pbData = this.iDT.getPbData();
        if (pbData == null || pbData.ckG() == null || v.isEmpty(pbData.ckG().iDe)) {
            return null;
        }
        n ckG = pbData.ckG();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = ckG.iDe;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.khq = i < size + (-1);
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
        this.iDW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aca() {
        n ckG;
        com.baidu.tieba.pb.data.e pbData = this.iDT.getPbData();
        if (pbData == null || (ckG = pbData.ckG()) == null) {
            return false;
        }
        if (this.iDV < 0) {
            this.iDV = ckG.getCount();
        }
        return ckG.iDf.size() > this.iDV && ckG.iDe.size() < 100;
    }
}

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
    private final PbModel iDH;
    private int iDI;
    private int iDJ;
    private x.a iDK;
    private final x.a iDL;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iDI = -1;
        this.iDJ = -1;
        this.iDL = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void onSuccess(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n ckF = MoreGodReplyModel.this.iDH.getPbData().ckF();
                if (ckF != null) {
                    List<PostData> list2 = ckF.iCS;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iDH.a(MoreGodReplyModel.this.iDH.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iDI > 0) {
                    MoreGodReplyModel.this.iDJ = MoreGodReplyModel.this.iDI;
                }
                if (MoreGodReplyModel.this.iDK != null) {
                    MoreGodReplyModel.this.iDK.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iDK != null) {
                    MoreGodReplyModel.this.iDK.l(i, str, str2);
                }
            }
        };
        this.iDH = pbModel;
        this.iDH.cob().b(this.iDL);
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

    public boolean clA() {
        n ckF;
        com.baidu.tieba.pb.data.e pbData = this.iDH.getPbData();
        if (pbData == null || (ckF = pbData.ckF()) == null) {
            return false;
        }
        if (this.iDJ < 0) {
            this.iDJ = ckF.getCount();
        }
        List<Long> list = ckF.iCT;
        int size = list.size();
        int i = this.iDJ;
        if (size <= i || ckF.iCS.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iDI = min;
        this.isLoading = true;
        this.iDH.cob().dG(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel clB() {
        return this.iDH;
    }

    public List<m> clC() {
        com.baidu.tieba.pb.data.e pbData = this.iDH.getPbData();
        if (pbData == null || pbData.ckF() == null || v.isEmpty(pbData.ckF().iCS)) {
            return null;
        }
        n ckF = pbData.ckF();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = ckF.iCS;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.khe = i < size + (-1);
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
        this.iDK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aca() {
        n ckF;
        com.baidu.tieba.pb.data.e pbData = this.iDH.getPbData();
        if (pbData == null || (ckF = pbData.ckF()) == null) {
            return false;
        }
        if (this.iDJ < 0) {
            this.iDJ = ckF.getCount();
        }
        return ckF.iCT.size() > this.iDJ && ckF.iCS.size() < 100;
    }
}

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
    private final PbModel hDc;
    private int hDd;
    private int hDe;
    private z.a hDf;
    private final z.a hDg;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hDd = -1;
        this.hDe = -1;
        this.hDg = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bPT = MoreGodReplyModel.this.hDc.getPbData().bPT();
                if (bPT != null) {
                    List<PostData> list2 = bPT.hCk;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hDc.a(MoreGodReplyModel.this.hDc.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hDd > 0) {
                    MoreGodReplyModel.this.hDe = MoreGodReplyModel.this.hDd;
                }
                if (MoreGodReplyModel.this.hDf != null) {
                    MoreGodReplyModel.this.hDf.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hDf != null) {
                    MoreGodReplyModel.this.hDf.l(i, str, str2);
                }
            }
        };
        this.hDc = pbModel;
        this.hDc.bTh().b(this.hDg);
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

    public boolean bQN() {
        m bPT;
        com.baidu.tieba.pb.data.d pbData = this.hDc.getPbData();
        if (pbData == null || (bPT = pbData.bPT()) == null) {
            return false;
        }
        if (this.hDe < 0) {
            this.hDe = bPT.getCount();
        }
        List<Long> list = bPT.hCl;
        int size = list.size();
        int i = this.hDe;
        if (size <= i || bPT.hCk.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hDd = min;
        this.isLoading = true;
        this.hDc.bTh().dH(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pu() {
        return this.isLoading;
    }

    public PbModel bQO() {
        return this.hDc;
    }

    public List<com.baidu.adp.widget.ListView.m> bQP() {
        com.baidu.tieba.pb.data.d pbData = this.hDc.getPbData();
        if (pbData == null || pbData.bPT() == null || v.aa(pbData.bPT().hCk)) {
            return null;
        }
        m bPT = pbData.bPT();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bPT.hCk;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iZk = i < size + (-1);
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
        this.hDf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean JO() {
        m bPT;
        com.baidu.tieba.pb.data.d pbData = this.hDc.getPbData();
        if (pbData == null || (bPT = pbData.bPT()) == null) {
            return false;
        }
        if (this.hDe < 0) {
            this.hDe = bPT.getCount();
        }
        return bPT.hCl.size() > this.hDe && bPT.hCk.size() < 100;
    }
}

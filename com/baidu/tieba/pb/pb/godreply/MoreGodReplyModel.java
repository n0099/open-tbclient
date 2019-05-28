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
    private final PbModel hDf;
    private int hDg;
    private int hDh;
    private z.a hDi;
    private final z.a hDj;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hDg = -1;
        this.hDh = -1;
        this.hDj = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bPW = MoreGodReplyModel.this.hDf.getPbData().bPW();
                if (bPW != null) {
                    List<PostData> list2 = bPW.hCn;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hDf.a(MoreGodReplyModel.this.hDf.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hDg > 0) {
                    MoreGodReplyModel.this.hDh = MoreGodReplyModel.this.hDg;
                }
                if (MoreGodReplyModel.this.hDi != null) {
                    MoreGodReplyModel.this.hDi.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hDi != null) {
                    MoreGodReplyModel.this.hDi.l(i, str, str2);
                }
            }
        };
        this.hDf = pbModel;
        this.hDf.bTk().b(this.hDj);
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

    public boolean bQQ() {
        m bPW;
        com.baidu.tieba.pb.data.d pbData = this.hDf.getPbData();
        if (pbData == null || (bPW = pbData.bPW()) == null) {
            return false;
        }
        if (this.hDh < 0) {
            this.hDh = bPW.getCount();
        }
        List<Long> list = bPW.hCo;
        int size = list.size();
        int i = this.hDh;
        if (size <= i || bPW.hCn.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hDg = min;
        this.isLoading = true;
        this.hDf.bTk().dH(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pu() {
        return this.isLoading;
    }

    public PbModel bQR() {
        return this.hDf;
    }

    public List<com.baidu.adp.widget.ListView.m> bQS() {
        com.baidu.tieba.pb.data.d pbData = this.hDf.getPbData();
        if (pbData == null || pbData.bPW() == null || v.aa(pbData.bPW().hCn)) {
            return null;
        }
        m bPW = pbData.bPW();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bPW.hCn;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iZm = i < size + (-1);
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
        this.hDi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean JO() {
        m bPW;
        com.baidu.tieba.pb.data.d pbData = this.hDf.getPbData();
        if (pbData == null || (bPW = pbData.bPW()) == null) {
            return false;
        }
        if (this.hDh < 0) {
            this.hDh = bPW.getCount();
        }
        return bPW.hCo.size() > this.hDh && bPW.hCn.size() < 100;
    }
}

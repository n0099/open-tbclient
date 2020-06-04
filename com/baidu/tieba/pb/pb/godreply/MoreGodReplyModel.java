package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel jHu;
    private int jHv;
    private int jHw;
    private ae.a jHx;
    private final ae.a jHy;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.jHv = -1;
        this.jHw = -1;
        this.jHy = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void aN(List<PostData> list) {
                p cCM;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jHu != null && MoreGodReplyModel.this.jHu.getPbData() != null && (cCM = MoreGodReplyModel.this.jHu.getPbData().cCM()) != null) {
                    List<PostData> list2 = cCM.jGE;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.jHu.b(MoreGodReplyModel.this.jHu.getPbData(), size);
                }
                if (MoreGodReplyModel.this.jHv > 0) {
                    MoreGodReplyModel.this.jHw = MoreGodReplyModel.this.jHv;
                }
                if (MoreGodReplyModel.this.jHx != null) {
                    MoreGodReplyModel.this.jHx.aN(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jHx != null) {
                    MoreGodReplyModel.this.jHx.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.jHu = pbModel;
            ae cGn = pbModel.cGn();
            if (cGn != null) {
                cGn.b(this.jHy);
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

    public boolean cDN() {
        p cCM;
        com.baidu.tieba.pb.data.e pbData = this.jHu.getPbData();
        if (pbData == null || (cCM = pbData.cCM()) == null) {
            return false;
        }
        if (this.jHw < 0) {
            this.jHw = cCM.getCount();
        }
        List<Long> list = cCM.jGF;
        int size = list.size();
        int i = this.jHw;
        if (size <= i || cCM.jGE.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.jHv = min;
        this.isLoading = true;
        this.jHu.cGn().dZ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cDO() {
        return this.jHu;
    }

    public List<o> cDP() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jHu == null || (pbData = this.jHu.getPbData()) == null || pbData.cCM() == null || v.isEmpty(pbData.cCM().jGE)) {
            return null;
        }
        p cCM = pbData.cCM();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cCM.jGE;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.lmD = i < size + (-1);
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

    public void a(ae.a aVar) {
        this.jHx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean anV() {
        com.baidu.tieba.pb.data.e pbData;
        p cCM;
        if (this.jHu == null || (pbData = this.jHu.getPbData()) == null || (cCM = pbData.cCM()) == null) {
            return false;
        }
        if (this.jHw < 0) {
            this.jHw = cCM.getCount();
        }
        return cCM.jGF.size() > this.jHw && cCM.jGE.size() < 100;
    }
}

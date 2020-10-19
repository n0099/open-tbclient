package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.r;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kWR;
    private int kWS;
    private int kWT;
    private ai.a kWU;
    private final ai.a kWV;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kWS = -1;
        this.kWT = -1;
        this.kWV = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bk(List<PostData> list) {
                r dcO;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kWR != null && MoreGodReplyModel.this.kWR.getPbData() != null && (dcO = MoreGodReplyModel.this.kWR.getPbData().dcO()) != null) {
                    List<PostData> list2 = dcO.kWd;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kWR.a(MoreGodReplyModel.this.kWR.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kWS > 0) {
                    MoreGodReplyModel.this.kWT = MoreGodReplyModel.this.kWS;
                }
                if (MoreGodReplyModel.this.kWU != null) {
                    MoreGodReplyModel.this.kWU.bk(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kWU != null) {
                    MoreGodReplyModel.this.kWU.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kWR = pbModel;
            ai dgs = pbModel.dgs();
            if (dgs != null) {
                dgs.b(this.kWV);
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

    public boolean ddP() {
        r dcO;
        f pbData = this.kWR.getPbData();
        if (pbData == null || (dcO = pbData.dcO()) == null) {
            return false;
        }
        if (this.kWT < 0) {
            this.kWT = dcO.getCount();
        }
        List<Long> list = dcO.kWe;
        int size = list.size();
        int i = this.kWT;
        if (size <= i || dcO.kWd.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kWS = min;
        this.isLoading = true;
        this.kWR.dgs().eM(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel ddQ() {
        return this.kWR;
    }

    public List<q> ddR() {
        f pbData;
        if (this.kWR == null || (pbData = this.kWR.getPbData()) == null || pbData.dcO() == null || y.isEmpty(pbData.dcO().kWd)) {
            return null;
        }
        r dcO = pbData.dcO();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dcO.kWd;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mEQ = i < size + (-1);
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

    public void a(ai.a aVar) {
        this.kWU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aCp() {
        f pbData;
        r dcO;
        if (this.kWR == null || (pbData = this.kWR.getPbData()) == null || (dcO = pbData.dcO()) == null) {
            return false;
        }
        if (this.kWT < 0) {
            this.kWT = dcO.getCount();
        }
        return dcO.kWe.size() > this.kWT && dcO.kWd.size() < 100;
    }
}

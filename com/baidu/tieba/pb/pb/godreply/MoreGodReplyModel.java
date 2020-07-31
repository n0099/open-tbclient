package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.r;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kjI;
    private int kjJ;
    private int kjK;
    private ai.a kjL;
    private final ai.a kjM;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kjJ = -1;
        this.kjK = -1;
        this.kjM = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bd(List<PostData> list) {
                r cKL;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kjI != null && MoreGodReplyModel.this.kjI.getPbData() != null && (cKL = MoreGodReplyModel.this.kjI.getPbData().cKL()) != null) {
                    List<PostData> list2 = cKL.kiU;
                    int size = list2.size();
                    if (!x.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kjI.a(MoreGodReplyModel.this.kjI.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kjJ > 0) {
                    MoreGodReplyModel.this.kjK = MoreGodReplyModel.this.kjJ;
                }
                if (MoreGodReplyModel.this.kjL != null) {
                    MoreGodReplyModel.this.kjL.bd(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kjL != null) {
                    MoreGodReplyModel.this.kjL.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kjI = pbModel;
            ai cOp = pbModel.cOp();
            if (cOp != null) {
                cOp.b(this.kjM);
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

    public boolean cLO() {
        r cKL;
        f pbData = this.kjI.getPbData();
        if (pbData == null || (cKL = pbData.cKL()) == null) {
            return false;
        }
        if (this.kjK < 0) {
            this.kjK = cKL.getCount();
        }
        List<Long> list = cKL.kiV;
        int size = list.size();
        int i = this.kjK;
        if (size <= i || cKL.kiU.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kjJ = min;
        this.isLoading = true;
        this.kjI.cOp().et(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cLP() {
        return this.kjI;
    }

    public List<q> cLQ() {
        f pbData;
        if (this.kjI == null || (pbData = this.kjI.getPbData()) == null || pbData.cKL() == null || x.isEmpty(pbData.cKL().kiU)) {
            return null;
        }
        r cKL = pbData.cKL();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cKL.kiU;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.lNK = i < size + (-1);
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
        this.kjL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aqL() {
        f pbData;
        r cKL;
        if (this.kjI == null || (pbData = this.kjI.getPbData()) == null || (cKL = pbData.cKL()) == null) {
            return false;
        }
        if (this.kjK < 0) {
            this.kjK = cKL.getCount();
        }
        return cKL.kiV.size() > this.kjK && cKL.kiU.size() < 100;
    }
}

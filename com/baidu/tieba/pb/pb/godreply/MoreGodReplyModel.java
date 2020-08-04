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
    private PbModel kjK;
    private int kjL;
    private int kjM;
    private ai.a kjN;
    private final ai.a kjO;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kjL = -1;
        this.kjM = -1;
        this.kjO = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bd(List<PostData> list) {
                r cKL;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kjK != null && MoreGodReplyModel.this.kjK.getPbData() != null && (cKL = MoreGodReplyModel.this.kjK.getPbData().cKL()) != null) {
                    List<PostData> list2 = cKL.kiW;
                    int size = list2.size();
                    if (!x.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kjK.a(MoreGodReplyModel.this.kjK.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kjL > 0) {
                    MoreGodReplyModel.this.kjM = MoreGodReplyModel.this.kjL;
                }
                if (MoreGodReplyModel.this.kjN != null) {
                    MoreGodReplyModel.this.kjN.bd(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kjN != null) {
                    MoreGodReplyModel.this.kjN.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kjK = pbModel;
            ai cOp = pbModel.cOp();
            if (cOp != null) {
                cOp.b(this.kjO);
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
        f pbData = this.kjK.getPbData();
        if (pbData == null || (cKL = pbData.cKL()) == null) {
            return false;
        }
        if (this.kjM < 0) {
            this.kjM = cKL.getCount();
        }
        List<Long> list = cKL.kiX;
        int size = list.size();
        int i = this.kjM;
        if (size <= i || cKL.kiW.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kjL = min;
        this.isLoading = true;
        this.kjK.cOp().et(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cLP() {
        return this.kjK;
    }

    public List<q> cLQ() {
        f pbData;
        if (this.kjK == null || (pbData = this.kjK.getPbData()) == null || pbData.cKL() == null || x.isEmpty(pbData.cKL().kiW)) {
            return null;
        }
        r cKL = pbData.cKL();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cKL.kiW;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.lNM = i < size + (-1);
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
        this.kjN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aqL() {
        f pbData;
        r cKL;
        if (this.kjK == null || (pbData = this.kjK.getPbData()) == null || (cKL = pbData.cKL()) == null) {
            return false;
        }
        if (this.kjM < 0) {
            this.kjM = cKL.getCount();
        }
        return cKL.kiX.size() > this.kjM && cKL.kiW.size() < 100;
    }
}

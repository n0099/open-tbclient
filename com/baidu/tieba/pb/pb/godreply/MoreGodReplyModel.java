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
/* loaded from: classes16.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kzj;
    private int kzk;
    private int kzl;
    private ai.a kzm;
    private final ai.a kzn;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kzk = -1;
        this.kzl = -1;
        this.kzn = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bd(List<PostData> list) {
                r cVA;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kzj != null && MoreGodReplyModel.this.kzj.getPbData() != null && (cVA = MoreGodReplyModel.this.kzj.getPbData().cVA()) != null) {
                    List<PostData> list2 = cVA.kyv;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kzj.a(MoreGodReplyModel.this.kzj.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kzk > 0) {
                    MoreGodReplyModel.this.kzl = MoreGodReplyModel.this.kzk;
                }
                if (MoreGodReplyModel.this.kzm != null) {
                    MoreGodReplyModel.this.kzm.bd(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kzm != null) {
                    MoreGodReplyModel.this.kzm.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kzj = pbModel;
            ai cZg = pbModel.cZg();
            if (cZg != null) {
                cZg.b(this.kzn);
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

    public boolean cWD() {
        r cVA;
        f pbData = this.kzj.getPbData();
        if (pbData == null || (cVA = pbData.cVA()) == null) {
            return false;
        }
        if (this.kzl < 0) {
            this.kzl = cVA.getCount();
        }
        List<Long> list = cVA.kyw;
        int size = list.size();
        int i = this.kzl;
        if (size <= i || cVA.kyv.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kzk = min;
        this.isLoading = true;
        this.kzj.cZg().eB(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cWE() {
        return this.kzj;
    }

    public List<q> cWF() {
        f pbData;
        if (this.kzj == null || (pbData = this.kzj.getPbData()) == null || pbData.cVA() == null || y.isEmpty(pbData.cVA().kyv)) {
            return null;
        }
        r cVA = pbData.cVA();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cVA.kyv;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mfL = i < size + (-1);
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
        this.kzm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ayX() {
        f pbData;
        r cVA;
        if (this.kzj == null || (pbData = this.kzj.getPbData()) == null || (cVA = pbData.cVA()) == null) {
            return false;
        }
        if (this.kzl < 0) {
            this.kzl = cVA.getCount();
        }
        return cVA.kyw.size() > this.kzl && cVA.kyv.size() < 100;
    }
}

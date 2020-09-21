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
/* loaded from: classes21.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kHG;
    private int kHH;
    private int kHI;
    private ai.a kHJ;
    private final ai.a kHK;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kHH = -1;
        this.kHI = -1;
        this.kHK = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bh(List<PostData> list) {
                r cZf;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kHG != null && MoreGodReplyModel.this.kHG.getPbData() != null && (cZf = MoreGodReplyModel.this.kHG.getPbData().cZf()) != null) {
                    List<PostData> list2 = cZf.kGS;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kHG.a(MoreGodReplyModel.this.kHG.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kHH > 0) {
                    MoreGodReplyModel.this.kHI = MoreGodReplyModel.this.kHH;
                }
                if (MoreGodReplyModel.this.kHJ != null) {
                    MoreGodReplyModel.this.kHJ.bh(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kHJ != null) {
                    MoreGodReplyModel.this.kHJ.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kHG = pbModel;
            ai dcJ = pbModel.dcJ();
            if (dcJ != null) {
                dcJ.b(this.kHK);
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

    public boolean dag() {
        r cZf;
        f pbData = this.kHG.getPbData();
        if (pbData == null || (cZf = pbData.cZf()) == null) {
            return false;
        }
        if (this.kHI < 0) {
            this.kHI = cZf.getCount();
        }
        List<Long> list = cZf.kGT;
        int size = list.size();
        int i = this.kHI;
        if (size <= i || cZf.kGS.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kHH = min;
        this.isLoading = true;
        this.kHG.dcJ().eJ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dah() {
        return this.kHG;
    }

    public List<q> dai() {
        f pbData;
        if (this.kHG == null || (pbData = this.kHG.getPbData()) == null || pbData.cZf() == null || y.isEmpty(pbData.cZf().kGS)) {
            return null;
        }
        r cZf = pbData.cZf();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cZf.kGS;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mpk = i < size + (-1);
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
        this.kHJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean azG() {
        f pbData;
        r cZf;
        if (this.kHG == null || (pbData = this.kHG.getPbData()) == null || (cZf = pbData.cZf()) == null) {
            return false;
        }
        if (this.kHI < 0) {
            this.kHI = cZf.getCount();
        }
        return cZf.kGT.size() > this.kHI && cZf.kGS.size() < 100;
    }
}

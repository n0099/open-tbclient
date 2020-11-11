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
    private PbModel lpr;
    private int lps;
    private int lpt;
    private ai.a lpu;
    private final ai.a lpv;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.lps = -1;
        this.lpt = -1;
        this.lpv = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void af(List<PostData> list) {
                r diy;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lpr != null && MoreGodReplyModel.this.lpr.getPbData() != null && (diy = MoreGodReplyModel.this.lpr.getPbData().diy()) != null) {
                    List<PostData> list2 = diy.loD;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lpr.a(MoreGodReplyModel.this.lpr.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lps > 0) {
                    MoreGodReplyModel.this.lpt = MoreGodReplyModel.this.lps;
                }
                if (MoreGodReplyModel.this.lpu != null) {
                    MoreGodReplyModel.this.lpu.af(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lpu != null) {
                    MoreGodReplyModel.this.lpu.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lpr = pbModel;
            ai dmb = pbModel.dmb();
            if (dmb != null) {
                dmb.b(this.lpv);
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

    public boolean djy() {
        r diy;
        f pbData = this.lpr.getPbData();
        if (pbData == null || (diy = pbData.diy()) == null) {
            return false;
        }
        if (this.lpt < 0) {
            this.lpt = diy.getCount();
        }
        List<Long> list = diy.loE;
        int size = list.size();
        int i = this.lpt;
        if (size <= i || diy.loD.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lps = min;
        this.isLoading = true;
        this.lpr.dmb().fd(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel djz() {
        return this.lpr;
    }

    public List<q> djA() {
        f pbData;
        if (this.lpr == null || (pbData = this.lpr.getPbData()) == null || pbData.diy() == null || y.isEmpty(pbData.diy().loD)) {
            return null;
        }
        r diy = pbData.diy();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = diy.loD;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mXA = i < size + (-1);
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
        this.lpu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aGJ() {
        f pbData;
        r diy;
        if (this.lpr == null || (pbData = this.lpr.getPbData()) == null || (diy = pbData.diy()) == null) {
            return false;
        }
        if (this.lpt < 0) {
            this.lpt = diy.getCount();
        }
        return diy.loE.size() > this.lpt && diy.loD.size() < 100;
    }
}

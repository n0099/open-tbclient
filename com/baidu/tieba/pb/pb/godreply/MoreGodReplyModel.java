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
    private PbModel ljq;
    private int ljr;
    private int ljs;
    private ai.a ljt;
    private final ai.a lju;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.ljr = -1;
        this.ljs = -1;
        this.lju = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void aa(List<PostData> list) {
                r dfW;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.ljq != null && MoreGodReplyModel.this.ljq.getPbData() != null && (dfW = MoreGodReplyModel.this.ljq.getPbData().dfW()) != null) {
                    List<PostData> list2 = dfW.liC;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.ljq.a(MoreGodReplyModel.this.ljq.getPbData(), size);
                }
                if (MoreGodReplyModel.this.ljr > 0) {
                    MoreGodReplyModel.this.ljs = MoreGodReplyModel.this.ljr;
                }
                if (MoreGodReplyModel.this.ljt != null) {
                    MoreGodReplyModel.this.ljt.aa(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.ljt != null) {
                    MoreGodReplyModel.this.ljt.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.ljq = pbModel;
            ai djz = pbModel.djz();
            if (djz != null) {
                djz.b(this.lju);
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

    public boolean dgW() {
        r dfW;
        f pbData = this.ljq.getPbData();
        if (pbData == null || (dfW = pbData.dfW()) == null) {
            return false;
        }
        if (this.ljs < 0) {
            this.ljs = dfW.getCount();
        }
        List<Long> list = dfW.liD;
        int size = list.size();
        int i = this.ljs;
        if (size <= i || dfW.liC.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.ljr = min;
        this.isLoading = true;
        this.ljq.djz().eV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dgX() {
        return this.ljq;
    }

    public List<q> dgY() {
        f pbData;
        if (this.ljq == null || (pbData = this.ljq.getPbData()) == null || pbData.dfW() == null || y.isEmpty(pbData.dfW().liC)) {
            return null;
        }
        r dfW = pbData.dfW();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dfW.liC;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mRx = i < size + (-1);
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
        this.ljt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aEj() {
        f pbData;
        r dfW;
        if (this.ljq == null || (pbData = this.ljq.getPbData()) == null || (dfW = pbData.dfW()) == null) {
            return false;
        }
        if (this.ljs < 0) {
            this.ljs = dfW.getCount();
        }
        return dfW.liD.size() > this.ljs && dfW.liC.size() < 100;
    }
}

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
    private PbModel lDp;
    private int lDq;
    private int lDr;
    private ai.a lDs;
    private final ai.a lDt;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.lDq = -1;
        this.lDr = -1;
        this.lDt = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void ah(List<PostData> list) {
                r dnh;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDp != null && MoreGodReplyModel.this.lDp.getPbData() != null && (dnh = MoreGodReplyModel.this.lDp.getPbData().dnh()) != null) {
                    List<PostData> list2 = dnh.lCq;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lDp.a(MoreGodReplyModel.this.lDp.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lDq > 0) {
                    MoreGodReplyModel.this.lDr = MoreGodReplyModel.this.lDq;
                }
                if (MoreGodReplyModel.this.lDs != null) {
                    MoreGodReplyModel.this.lDs.ah(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void p(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDs != null) {
                    MoreGodReplyModel.this.lDs.p(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lDp = pbModel;
            ai dqO = pbModel.dqO();
            if (dqO != null) {
                dqO.b(this.lDt);
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

    public boolean doj() {
        r dnh;
        f pbData = this.lDp.getPbData();
        if (pbData == null || (dnh = pbData.dnh()) == null) {
            return false;
        }
        if (this.lDr < 0) {
            this.lDr = dnh.getCount();
        }
        List<Long> list = dnh.lCr;
        int size = list.size();
        int i = this.lDr;
        if (size <= i || dnh.lCq.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lDq = min;
        this.isLoading = true;
        this.lDp.dqO().fo(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dok() {
        return this.lDp;
    }

    public List<q> dol() {
        f pbData;
        if (this.lDp == null || (pbData = this.lDp.getPbData()) == null || pbData.dnh() == null || y.isEmpty(pbData.dnh().lCq)) {
            return null;
        }
        r dnh = pbData.dnh();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dnh.lCq;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nmq = i < size + (-1);
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
        this.lDs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aJj() {
        f pbData;
        r dnh;
        if (this.lDp == null || (pbData = this.lDp.getPbData()) == null || (dnh = pbData.dnh()) == null) {
            return false;
        }
        if (this.lDr < 0) {
            this.lDr = dnh.getCount();
        }
        return dnh.lCr.size() > this.lDr && dnh.lCq.size() < 100;
    }
}

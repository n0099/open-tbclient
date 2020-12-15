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
    private PbModel lDr;
    private int lDs;
    private int lDt;
    private ai.a lDu;
    private final ai.a lDv;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.lDs = -1;
        this.lDt = -1;
        this.lDv = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void ah(List<PostData> list) {
                r dni;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDr != null && MoreGodReplyModel.this.lDr.getPbData() != null && (dni = MoreGodReplyModel.this.lDr.getPbData().dni()) != null) {
                    List<PostData> list2 = dni.lCs;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lDr.a(MoreGodReplyModel.this.lDr.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lDs > 0) {
                    MoreGodReplyModel.this.lDt = MoreGodReplyModel.this.lDs;
                }
                if (MoreGodReplyModel.this.lDu != null) {
                    MoreGodReplyModel.this.lDu.ah(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void p(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDu != null) {
                    MoreGodReplyModel.this.lDu.p(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lDr = pbModel;
            ai dqP = pbModel.dqP();
            if (dqP != null) {
                dqP.b(this.lDv);
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

    public boolean dok() {
        r dni;
        f pbData = this.lDr.getPbData();
        if (pbData == null || (dni = pbData.dni()) == null) {
            return false;
        }
        if (this.lDt < 0) {
            this.lDt = dni.getCount();
        }
        List<Long> list = dni.lCt;
        int size = list.size();
        int i = this.lDt;
        if (size <= i || dni.lCs.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lDs = min;
        this.isLoading = true;
        this.lDr.dqP().fo(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dol() {
        return this.lDr;
    }

    public List<q> dom() {
        f pbData;
        if (this.lDr == null || (pbData = this.lDr.getPbData()) == null || pbData.dni() == null || y.isEmpty(pbData.dni().lCs)) {
            return null;
        }
        r dni = pbData.dni();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dni.lCs;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nms = i < size + (-1);
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
        this.lDu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aJj() {
        f pbData;
        r dni;
        if (this.lDr == null || (pbData = this.lDr.getPbData()) == null || (dni = pbData.dni()) == null) {
            return false;
        }
        if (this.lDt < 0) {
            this.lDt = dni.getCount();
        }
        return dni.lCt.size() > this.lDt && dni.lCs.size() < 100;
    }
}

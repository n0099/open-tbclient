package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel hKm;
    private int hKn;
    private int hKo;
    private z.a hKp;
    private final z.a hKq;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hKn = -1;
        this.hKo = -1;
        this.hKq = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bSW = MoreGodReplyModel.this.hKm.getPbData().bSW();
                if (bSW != null) {
                    List<PostData> list2 = bSW.hJu;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hKm.a(MoreGodReplyModel.this.hKm.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hKn > 0) {
                    MoreGodReplyModel.this.hKo = MoreGodReplyModel.this.hKn;
                }
                if (MoreGodReplyModel.this.hKp != null) {
                    MoreGodReplyModel.this.hKp.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hKp != null) {
                    MoreGodReplyModel.this.hKp.l(i, str, str2);
                }
            }
        };
        this.hKm = pbModel;
        this.hKm.bWo().b(this.hKq);
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

    public boolean bTQ() {
        m bSW;
        com.baidu.tieba.pb.data.d pbData = this.hKm.getPbData();
        if (pbData == null || (bSW = pbData.bSW()) == null) {
            return false;
        }
        if (this.hKo < 0) {
            this.hKo = bSW.getCount();
        }
        List<Long> list = bSW.hJv;
        int size = list.size();
        int i = this.hKo;
        if (size <= i || bSW.hJu.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hKn = min;
        this.isLoading = true;
        this.hKm.bWo().dI(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pP() {
        return this.isLoading;
    }

    public PbModel bTR() {
        return this.hKm;
    }

    public List<com.baidu.adp.widget.ListView.m> bTS() {
        com.baidu.tieba.pb.data.d pbData = this.hKm.getPbData();
        if (pbData == null || pbData.bSW() == null || v.aa(pbData.bSW().hJu)) {
            return null;
        }
        m bSW = pbData.bSW();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bSW.hJu;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.jgO = i < size + (-1);
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

    public void a(z.a aVar) {
        this.hKp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean KB() {
        m bSW;
        com.baidu.tieba.pb.data.d pbData = this.hKm.getPbData();
        if (pbData == null || (bSW = pbData.bSW()) == null) {
            return false;
        }
        if (this.hKo < 0) {
            this.hKo = bSW.getCount();
        }
        return bSW.hJv.size() > this.hKo && bSW.hJu.size() < 100;
    }
}

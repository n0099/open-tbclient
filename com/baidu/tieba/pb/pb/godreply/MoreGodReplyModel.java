package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.r;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    private boolean isLoading;
    private PbModel lDR;
    private int lDS;
    private int lDT;
    private ab.a lDU;
    private final ab.a lDV;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lDS = -1;
        this.lDT = -1;
        this.lDV = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void ai(List<PostData> list) {
                r djb;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDR != null && MoreGodReplyModel.this.lDR.getPbData() != null && (djb = MoreGodReplyModel.this.lDR.getPbData().djb()) != null) {
                    List<PostData> list2 = djb.lCS;
                    int size = list2.size();
                    if (!x.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lDR.a(MoreGodReplyModel.this.lDR.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lDS > 0) {
                    MoreGodReplyModel.this.lDT = MoreGodReplyModel.this.lDS;
                }
                if (MoreGodReplyModel.this.lDU != null) {
                    MoreGodReplyModel.this.lDU.ai(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lDU != null) {
                    MoreGodReplyModel.this.lDU.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lDR = pbModel;
            ab dmJ = pbModel.dmJ();
            if (dmJ != null) {
                dmJ.b(this.lDV);
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

    public boolean dkc() {
        r djb;
        com.baidu.tieba.pb.data.f pbData = this.lDR.getPbData();
        if (pbData == null || (djb = pbData.djb()) == null) {
            return false;
        }
        if (this.lDT < 0) {
            this.lDT = djb.getCount();
        }
        List<Long> list = djb.lCT;
        int size = list.size();
        int i = this.lDT;
        if (size <= i || djb.lCS.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lDS = min;
        this.isLoading = true;
        this.lDR.dmJ().fo(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dkd() {
        return this.lDR;
    }

    public List<n> dke() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lDR == null || (pbData = this.lDR.getPbData()) == null || pbData.djb() == null || x.isEmpty(pbData.djb().lCS)) {
            return null;
        }
        r djb = pbData.djb();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = djb.lCS;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nnx = i < size + (-1);
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

    public void a(ab.a aVar) {
        this.lDU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aHa() {
        com.baidu.tieba.pb.data.f pbData;
        r djb;
        if (this.lDR == null || (pbData = this.lDR.getPbData()) == null || (djb = pbData.djb()) == null) {
            return false;
        }
        if (this.lDT < 0) {
            this.lDT = djb.getCount();
        }
        return djb.lCT.size() > this.lDT && djb.lCS.size() < 100;
    }
}

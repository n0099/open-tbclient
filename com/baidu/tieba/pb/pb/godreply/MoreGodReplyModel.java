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
    private final ab.a lIA;
    private PbModel lIw;
    private int lIx;
    private int lIy;
    private ab.a lIz;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lIx = -1;
        this.lIy = -1;
        this.lIA = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void ai(List<PostData> list) {
                r dmT;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lIw != null && MoreGodReplyModel.this.lIw.getPbData() != null && (dmT = MoreGodReplyModel.this.lIw.getPbData().dmT()) != null) {
                    List<PostData> list2 = dmT.lHx;
                    int size = list2.size();
                    if (!x.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lIw.a(MoreGodReplyModel.this.lIw.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lIx > 0) {
                    MoreGodReplyModel.this.lIy = MoreGodReplyModel.this.lIx;
                }
                if (MoreGodReplyModel.this.lIz != null) {
                    MoreGodReplyModel.this.lIz.ai(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lIz != null) {
                    MoreGodReplyModel.this.lIz.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lIw = pbModel;
            ab dqC = pbModel.dqC();
            if (dqC != null) {
                dqC.b(this.lIA);
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

    public boolean dnV() {
        r dmT;
        com.baidu.tieba.pb.data.f pbData = this.lIw.getPbData();
        if (pbData == null || (dmT = pbData.dmT()) == null) {
            return false;
        }
        if (this.lIy < 0) {
            this.lIy = dmT.getCount();
        }
        List<Long> list = dmT.lHy;
        int size = list.size();
        int i = this.lIy;
        if (size <= i || dmT.lHx.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lIx = min;
        this.isLoading = true;
        this.lIw.dqC().fo(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dnW() {
        return this.lIw;
    }

    public List<n> dnX() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lIw == null || (pbData = this.lIw.getPbData()) == null || pbData.dmT() == null || x.isEmpty(pbData.dmT().lHx)) {
            return null;
        }
        r dmT = pbData.dmT();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dmT.lHx;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nsd = i < size + (-1);
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
        this.lIz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aKU() {
        com.baidu.tieba.pb.data.f pbData;
        r dmT;
        if (this.lIw == null || (pbData = this.lIw.getPbData()) == null || (dmT = pbData.dmT()) == null) {
            return false;
        }
        if (this.lIy < 0) {
            this.lIy = dmT.getCount();
        }
        return dmT.lHy.size() > this.lIy && dmT.lHx.size() < 100;
    }
}

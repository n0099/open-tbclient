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
    private ab.a lIA;
    private final ab.a lIB;
    private PbModel lIx;
    private int lIy;
    private int lIz;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lIy = -1;
        this.lIz = -1;
        this.lIB = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void ai(List<PostData> list) {
                r dmS;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lIx != null && MoreGodReplyModel.this.lIx.getPbData() != null && (dmS = MoreGodReplyModel.this.lIx.getPbData().dmS()) != null) {
                    List<PostData> list2 = dmS.lHy;
                    int size = list2.size();
                    if (!x.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lIx.a(MoreGodReplyModel.this.lIx.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lIy > 0) {
                    MoreGodReplyModel.this.lIz = MoreGodReplyModel.this.lIy;
                }
                if (MoreGodReplyModel.this.lIA != null) {
                    MoreGodReplyModel.this.lIA.ai(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lIA != null) {
                    MoreGodReplyModel.this.lIA.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lIx = pbModel;
            ab dqB = pbModel.dqB();
            if (dqB != null) {
                dqB.b(this.lIB);
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

    public boolean dnU() {
        r dmS;
        com.baidu.tieba.pb.data.f pbData = this.lIx.getPbData();
        if (pbData == null || (dmS = pbData.dmS()) == null) {
            return false;
        }
        if (this.lIz < 0) {
            this.lIz = dmS.getCount();
        }
        List<Long> list = dmS.lHz;
        int size = list.size();
        int i = this.lIz;
        if (size <= i || dmS.lHy.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lIy = min;
        this.isLoading = true;
        this.lIx.dqB().fo(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dnV() {
        return this.lIx;
    }

    public List<n> dnW() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lIx == null || (pbData = this.lIx.getPbData()) == null || pbData.dmS() == null || x.isEmpty(pbData.dmS().lHy)) {
            return null;
        }
        r dmS = pbData.dmS();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dmS.lHy;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nse = i < size + (-1);
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
        this.lIA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aKT() {
        com.baidu.tieba.pb.data.f pbData;
        r dmS;
        if (this.lIx == null || (pbData = this.lIx.getPbData()) == null || (dmS = pbData.dmS()) == null) {
            return false;
        }
        if (this.lIz < 0) {
            this.lIz = dmS.getCount();
        }
        return dmS.lHz.size() > this.lIz && dmS.lHy.size() < 100;
    }
}

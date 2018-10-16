package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fJB;
    private int fJC;
    private int fJD;
    private z.a fJE;
    private final z.a fJF;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fJC = -1;
        this.fJD = -1;
        this.fJF = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void Q(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bfg = MoreGodReplyModel.this.fJB.getPbData().bfg();
                if (bfg != null) {
                    List<PostData> list2 = bfg.fIF;
                    int size = list2.size();
                    if (!v.J(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fJB.a(MoreGodReplyModel.this.fJB.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fJC > 0) {
                    MoreGodReplyModel.this.fJD = MoreGodReplyModel.this.fJC;
                }
                if (MoreGodReplyModel.this.fJE != null) {
                    MoreGodReplyModel.this.fJE.Q(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void i(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fJE != null) {
                    MoreGodReplyModel.this.fJE.i(i, str, str2);
                }
            }
        };
        this.fJB = pbModel;
        this.fJB.bio().b(this.fJF);
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

    public boolean bfZ() {
        k bfg;
        com.baidu.tieba.pb.data.d pbData = this.fJB.getPbData();
        if (pbData == null || (bfg = pbData.bfg()) == null) {
            return false;
        }
        if (this.fJD < 0) {
            this.fJD = bfg.getCount();
        }
        List<Long> list = bfg.fIG;
        int size = list.size();
        int i = this.fJD;
        if (size <= i || bfg.fIF.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fJC = min;
        this.isLoading = true;
        this.fJB.bio().dk(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean DU() {
        return this.isLoading;
    }

    public PbModel bga() {
        return this.fJB;
    }

    public List<h> bgb() {
        com.baidu.tieba.pb.data.d pbData = this.fJB.getPbData();
        if (pbData == null || pbData.bfg() == null || v.J(pbData.bfg().fIF)) {
            return null;
        }
        k bfg = pbData.bfg();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bfg.fIF;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hdD = i < size + (-1);
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
        this.fJE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k bfg;
        com.baidu.tieba.pb.data.d pbData = this.fJB.getPbData();
        if (pbData == null || (bfg = pbData.bfg()) == null) {
            return false;
        }
        if (this.fJD < 0) {
            this.fJD = bfg.getCount();
        }
        return bfg.fIG.size() > this.fJD && bfg.fIF.size() < 100;
    }
}

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
    private final PbModel hMj;
    private int hMk;
    private int hMl;
    private z.a hMm;
    private final z.a hMn;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hMk = -1;
        this.hMl = -1;
        this.hMn = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bTJ = MoreGodReplyModel.this.hMj.getPbData().bTJ();
                if (bTJ != null) {
                    List<PostData> list2 = bTJ.hLr;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hMj.a(MoreGodReplyModel.this.hMj.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hMk > 0) {
                    MoreGodReplyModel.this.hMl = MoreGodReplyModel.this.hMk;
                }
                if (MoreGodReplyModel.this.hMm != null) {
                    MoreGodReplyModel.this.hMm.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hMm != null) {
                    MoreGodReplyModel.this.hMm.m(i, str, str2);
                }
            }
        };
        this.hMj = pbModel;
        this.hMj.bXb().b(this.hMn);
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

    public boolean bUD() {
        m bTJ;
        com.baidu.tieba.pb.data.d pbData = this.hMj.getPbData();
        if (pbData == null || (bTJ = pbData.bTJ()) == null) {
            return false;
        }
        if (this.hMl < 0) {
            this.hMl = bTJ.getCount();
        }
        List<Long> list = bTJ.hLs;
        int size = list.size();
        int i = this.hMl;
        if (size <= i || bTJ.hLr.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hMk = min;
        this.isLoading = true;
        this.hMj.bXb().dI(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pQ() {
        return this.isLoading;
    }

    public PbModel bUE() {
        return this.hMj;
    }

    public List<com.baidu.adp.widget.ListView.m> bUF() {
        com.baidu.tieba.pb.data.d pbData = this.hMj.getPbData();
        if (pbData == null || pbData.bTJ() == null || v.aa(pbData.bTJ().hLr)) {
            return null;
        }
        m bTJ = pbData.bTJ();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bTJ.hLr;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.jjk = i < size + (-1);
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
        this.hMm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean KF() {
        m bTJ;
        com.baidu.tieba.pb.data.d pbData = this.hMj.getPbData();
        if (pbData == null || (bTJ = pbData.bTJ()) == null) {
            return false;
        }
        if (this.hMl < 0) {
            this.hMl = bTJ.getCount();
        }
        return bTJ.hLs.size() > this.hMl && bTJ.hLr.size() < 100;
    }
}

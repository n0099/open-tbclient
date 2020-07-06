package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kbe;
    private int kbf;
    private int kbg;
    private ae.a kbh;
    private final ae.a kbi;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kbf = -1;
        this.kbg = -1;
        this.kbi = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void aX(List<PostData> list) {
                p cHc;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kbe != null && MoreGodReplyModel.this.kbe.getPbData() != null && (cHc = MoreGodReplyModel.this.kbe.getPbData().cHc()) != null) {
                    List<PostData> list2 = cHc.kao;
                    int size = list2.size();
                    if (!w.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kbe.a(MoreGodReplyModel.this.kbe.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kbf > 0) {
                    MoreGodReplyModel.this.kbg = MoreGodReplyModel.this.kbf;
                }
                if (MoreGodReplyModel.this.kbh != null) {
                    MoreGodReplyModel.this.kbh.aX(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kbh != null) {
                    MoreGodReplyModel.this.kbh.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kbe = pbModel;
            ae cKE = pbModel.cKE();
            if (cKE != null) {
                cKE.b(this.kbi);
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

    public boolean cIe() {
        p cHc;
        com.baidu.tieba.pb.data.e pbData = this.kbe.getPbData();
        if (pbData == null || (cHc = pbData.cHc()) == null) {
            return false;
        }
        if (this.kbg < 0) {
            this.kbg = cHc.getCount();
        }
        List<Long> list = cHc.kap;
        int size = list.size();
        int i = this.kbg;
        if (size <= i || cHc.kao.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kbf = min;
        this.isLoading = true;
        this.kbe.cKE().en(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cIf() {
        return this.kbe;
    }

    public List<q> cIg() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.kbe == null || (pbData = this.kbe.getPbData()) == null || pbData.cHc() == null || w.isEmpty(pbData.cHc().kao)) {
            return null;
        }
        p cHc = pbData.cHc();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cHc.kao;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.lGw = i < size + (-1);
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

    public void a(ae.a aVar) {
        this.kbh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean apb() {
        com.baidu.tieba.pb.data.e pbData;
        p cHc;
        if (this.kbe == null || (pbData = this.kbe.getPbData()) == null || (cHc = pbData.cHc()) == null) {
            return false;
        }
        if (this.kbg < 0) {
            this.kbg = cHc.getCount();
        }
        return cHc.kap.size() > this.kbg && cHc.kao.size() < 100;
    }
}

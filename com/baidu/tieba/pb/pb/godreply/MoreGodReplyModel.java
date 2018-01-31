package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fGD;
    private int fGE;
    private int fGF;
    private z.a fGG;
    private final z.a fGH;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fGE = -1;
        this.fGF = -1;
        this.fGH = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void J(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aYW = MoreGodReplyModel.this.fGD.getPbData().aYW();
                if (aYW != null) {
                    List<PostData> list2 = aYW.fES;
                    int size = list2.size();
                    if (!v.E(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fGD.a(MoreGodReplyModel.this.fGD.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fGE > 0) {
                    MoreGodReplyModel.this.fGF = MoreGodReplyModel.this.fGE;
                }
                if (MoreGodReplyModel.this.fGG != null) {
                    MoreGodReplyModel.this.fGG.J(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fGG != null) {
                    MoreGodReplyModel.this.fGG.h(i, str, str2);
                }
            }
        };
        this.fGD = pbModel;
        this.fGD.bck().b(this.fGH);
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

    public boolean aZS() {
        n aYW;
        f pbData = this.fGD.getPbData();
        if (pbData == null || (aYW = pbData.aYW()) == null) {
            return false;
        }
        if (this.fGF < 0) {
            this.fGF = aYW.getCount();
        }
        List<Long> list = aYW.fET;
        int size = list.size();
        int i = this.fGF;
        if (size <= i || aYW.fES.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fGE = min;
        this.isLoading = true;
        this.fGD.bck().cP(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean DR() {
        return this.isLoading;
    }

    public PbModel aZT() {
        return this.fGD;
    }

    public List<i> aZU() {
        f pbData = this.fGD.getPbData();
        if (pbData == null || pbData.aYW() == null || v.E(pbData.aYW().fES)) {
            return null;
        }
        n aYW = pbData.aYW();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aYW.fES;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gZk = i < size + (-1);
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
        this.fGG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aho() {
        n aYW;
        f pbData = this.fGD.getPbData();
        if (pbData == null || (aYW = pbData.aYW()) == null) {
            return false;
        }
        if (this.fGF < 0) {
            this.fGF = aYW.getCount();
        }
        return aYW.fET.size() > this.fGF && aYW.fES.size() < 100;
    }
}

package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel eQZ;
    private int eRa;
    private int eRb;
    private z.a eRc;
    private final z.a eRd;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.eRa = -1;
        this.eRb = -1;
        this.eRd = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void C(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aRr = MoreGodReplyModel.this.eQZ.getPbData().aRr();
                if (aRr != null) {
                    List<PostData> list2 = aRr.ePo;
                    int size = list2.size();
                    if (!v.w(list)) {
                        for (PostData postData : list) {
                            if (!list2.contains(postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.eQZ.a(MoreGodReplyModel.this.eQZ.getPbData(), size);
                }
                if (MoreGodReplyModel.this.eRa > 0) {
                    MoreGodReplyModel.this.eRb = MoreGodReplyModel.this.eRa;
                }
                if (MoreGodReplyModel.this.eRc != null) {
                    MoreGodReplyModel.this.eRc.C(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.eRc != null) {
                    MoreGodReplyModel.this.eRc.h(i, str, str2);
                }
            }
        };
        this.eQZ = pbModel;
        this.eQZ.aUF().b(this.eRd);
    }

    public boolean aSn() {
        n aRr;
        f pbData = this.eQZ.getPbData();
        if (pbData == null || (aRr = pbData.aRr()) == null) {
            return false;
        }
        if (this.eRb < 0) {
            this.eRb = aRr.getCount();
        }
        List<Long> list = aRr.ePp;
        int size = list.size();
        int i = this.eRb;
        if (size <= i || aRr.ePo.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.eRa = min;
        this.isLoading = true;
        this.eQZ.aUF().cJ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wC() {
        return this.isLoading;
    }

    public PbModel aSo() {
        return this.eQZ;
    }

    public List<com.baidu.adp.widget.ListView.f> aSp() {
        f pbData = this.eQZ.getPbData();
        if (pbData == null || pbData.aRr() == null || v.w(pbData.aRr().ePo)) {
            return null;
        }
        n aRr = pbData.aRr();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aRr.ePo;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gzP = i < size + (-1);
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
        this.eRc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ZQ() {
        n aRr;
        f pbData = this.eQZ.getPbData();
        if (pbData == null || (aRr = pbData.aRr()) == null) {
            return false;
        }
        if (this.eRb < 0) {
            this.eRb = aRr.getCount();
        }
        return aRr.ePp.size() > this.eRb && aRr.ePo.size() < 100;
    }
}

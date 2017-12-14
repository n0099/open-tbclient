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
    private final PbModel eSc;
    private int eSd;
    private int eSe;
    private z.a eSf;
    private final z.a eSg;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.eSd = -1;
        this.eSe = -1;
        this.eSg = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void C(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aRA = MoreGodReplyModel.this.eSc.getPbData().aRA();
                if (aRA != null) {
                    List<PostData> list2 = aRA.eQr;
                    int size = list2.size();
                    if (!v.w(list)) {
                        for (PostData postData : list) {
                            if (!list2.contains(postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.eSc.a(MoreGodReplyModel.this.eSc.getPbData(), size);
                }
                if (MoreGodReplyModel.this.eSd > 0) {
                    MoreGodReplyModel.this.eSe = MoreGodReplyModel.this.eSd;
                }
                if (MoreGodReplyModel.this.eSf != null) {
                    MoreGodReplyModel.this.eSf.C(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.eSf != null) {
                    MoreGodReplyModel.this.eSf.h(i, str, str2);
                }
            }
        };
        this.eSc = pbModel;
        this.eSc.aUO().b(this.eSg);
    }

    public boolean aSw() {
        n aRA;
        f pbData = this.eSc.getPbData();
        if (pbData == null || (aRA = pbData.aRA()) == null) {
            return false;
        }
        if (this.eSe < 0) {
            this.eSe = aRA.getCount();
        }
        List<Long> list = aRA.eQs;
        int size = list.size();
        int i = this.eSe;
        if (size <= i || aRA.eQr.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.eSd = min;
        this.isLoading = true;
        this.eSc.aUO().cK(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wA() {
        return this.isLoading;
    }

    public PbModel aSx() {
        return this.eSc;
    }

    public List<com.baidu.adp.widget.ListView.f> aSy() {
        f pbData = this.eSc.getPbData();
        if (pbData == null || pbData.aRA() == null || v.w(pbData.aRA().eQr)) {
            return null;
        }
        n aRA = pbData.aRA();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aRA.eQr;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gCy = i < size + (-1);
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
        this.eSf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ZR() {
        n aRA;
        f pbData = this.eSc.getPbData();
        if (pbData == null || (aRA = pbData.aRA()) == null) {
            return false;
        }
        if (this.eSe < 0) {
            this.eSe = aRA.getCount();
        }
        return aRA.eQs.size() > this.eSe && aRA.eQr.size() < 100;
    }
}

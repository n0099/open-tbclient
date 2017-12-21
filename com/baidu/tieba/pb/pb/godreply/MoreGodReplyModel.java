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
    private final PbModel eSh;
    private int eSi;
    private int eSj;
    private z.a eSk;
    private final z.a eSl;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.eSi = -1;
        this.eSj = -1;
        this.eSl = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void C(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aRA = MoreGodReplyModel.this.eSh.getPbData().aRA();
                if (aRA != null) {
                    List<PostData> list2 = aRA.eQw;
                    int size = list2.size();
                    if (!v.w(list)) {
                        for (PostData postData : list) {
                            if (!list2.contains(postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.eSh.a(MoreGodReplyModel.this.eSh.getPbData(), size);
                }
                if (MoreGodReplyModel.this.eSi > 0) {
                    MoreGodReplyModel.this.eSj = MoreGodReplyModel.this.eSi;
                }
                if (MoreGodReplyModel.this.eSk != null) {
                    MoreGodReplyModel.this.eSk.C(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.eSk != null) {
                    MoreGodReplyModel.this.eSk.h(i, str, str2);
                }
            }
        };
        this.eSh = pbModel;
        this.eSh.aUO().b(this.eSl);
    }

    public boolean aSw() {
        n aRA;
        f pbData = this.eSh.getPbData();
        if (pbData == null || (aRA = pbData.aRA()) == null) {
            return false;
        }
        if (this.eSj < 0) {
            this.eSj = aRA.getCount();
        }
        List<Long> list = aRA.eQx;
        int size = list.size();
        int i = this.eSj;
        if (size <= i || aRA.eQw.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.eSi = min;
        this.isLoading = true;
        this.eSh.aUO().cK(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wA() {
        return this.isLoading;
    }

    public PbModel aSx() {
        return this.eSh;
    }

    public List<com.baidu.adp.widget.ListView.f> aSy() {
        f pbData = this.eSh.getPbData();
        if (pbData == null || pbData.aRA() == null || v.w(pbData.aRA().eQw)) {
            return null;
        }
        n aRA = pbData.aRA();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aRA.eQw;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gCD = i < size + (-1);
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
        this.eSk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ZR() {
        n aRA;
        f pbData = this.eSh.getPbData();
        if (pbData == null || (aRA = pbData.aRA()) == null) {
            return false;
        }
        if (this.eSj < 0) {
            this.eSj = aRA.getCount();
        }
        return aRA.eQx.size() > this.eSj && aRA.eQw.size() < 100;
    }
}

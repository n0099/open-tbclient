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
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fCa;
    private int fCb;
    private int fCc;
    private z.a fCd;
    private final z.a fCe;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fCb = -1;
        this.fCc = -1;
        this.fCe = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void H(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bbU = MoreGodReplyModel.this.fCa.getPbData().bbU();
                if (bbU != null) {
                    List<PostData> list2 = bbU.fBd;
                    int size = list2.size();
                    if (!v.z(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fCa.a(MoreGodReplyModel.this.fCa.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fCb > 0) {
                    MoreGodReplyModel.this.fCc = MoreGodReplyModel.this.fCb;
                }
                if (MoreGodReplyModel.this.fCd != null) {
                    MoreGodReplyModel.this.fCd.H(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fCd != null) {
                    MoreGodReplyModel.this.fCd.g(i, str, str2);
                }
            }
        };
        this.fCa = pbModel;
        this.fCa.bfc().b(this.fCe);
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

    public boolean bcN() {
        k bbU;
        com.baidu.tieba.pb.data.d pbData = this.fCa.getPbData();
        if (pbData == null || (bbU = pbData.bbU()) == null) {
            return false;
        }
        if (this.fCc < 0) {
            this.fCc = bbU.getCount();
        }
        List<Long> list = bbU.fBe;
        int size = list.size();
        int i = this.fCc;
        if (size <= i || bbU.fBd.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fCb = min;
        this.isLoading = true;
        this.fCa.bfc().cW(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean BO() {
        return this.isLoading;
    }

    public PbModel bcO() {
        return this.fCa;
    }

    public List<h> bcP() {
        com.baidu.tieba.pb.data.d pbData = this.fCa.getPbData();
        if (pbData == null || pbData.bbU() == null || v.z(pbData.bbU().fBd)) {
            return null;
        }
        k bbU = pbData.bbU();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bbU.fBd;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gWi = i < size + (-1);
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
        this.fCd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aiH() {
        k bbU;
        com.baidu.tieba.pb.data.d pbData = this.fCa.getPbData();
        if (pbData == null || (bbU = pbData.bbU()) == null) {
            return false;
        }
        if (this.fCc < 0) {
            this.fCc = bbU.getCount();
        }
        return bbU.fBe.size() > this.fCc && bbU.fBd.size() < 100;
    }
}

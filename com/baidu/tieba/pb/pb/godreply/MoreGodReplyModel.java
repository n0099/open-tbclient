package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fJP;
    private int fJQ;
    private int fJR;
    private y.a fJS;
    private final y.a fJT;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fJQ = -1;
        this.fJR = -1;
        this.fJT = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void L(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l baE = MoreGodReplyModel.this.fJP.getPbData().baE();
                if (baE != null) {
                    List<PostData> list2 = baE.fIe;
                    int size = list2.size();
                    if (!v.E(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fJP.a(MoreGodReplyModel.this.fJP.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fJQ > 0) {
                    MoreGodReplyModel.this.fJR = MoreGodReplyModel.this.fJQ;
                }
                if (MoreGodReplyModel.this.fJS != null) {
                    MoreGodReplyModel.this.fJS.L(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fJS != null) {
                    MoreGodReplyModel.this.fJS.h(i, str, str2);
                }
            }
        };
        this.fJP = pbModel;
        this.fJP.bdL().b(this.fJT);
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

    public boolean bby() {
        l baE;
        com.baidu.tieba.pb.data.d pbData = this.fJP.getPbData();
        if (pbData == null || (baE = pbData.baE()) == null) {
            return false;
        }
        if (this.fJR < 0) {
            this.fJR = baE.getCount();
        }
        List<Long> list = baE.fIf;
        int size = list.size();
        int i = this.fJR;
        if (size <= i || baE.fIe.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fJQ = min;
        this.isLoading = true;
        this.fJP.bdL().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Ek() {
        return this.isLoading;
    }

    public PbModel bbz() {
        return this.fJP;
    }

    public List<i> bbA() {
        com.baidu.tieba.pb.data.d pbData = this.fJP.getPbData();
        if (pbData == null || pbData.baE() == null || v.E(pbData.baE().fIe)) {
            return null;
        }
        l baE = pbData.baE();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = baE.fIe;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hbj = i < size + (-1);
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

    public void a(y.a aVar) {
        this.fJS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aip() {
        l baE;
        com.baidu.tieba.pb.data.d pbData = this.fJP.getPbData();
        if (pbData == null || (baE = pbData.baE()) == null) {
            return false;
        }
        if (this.fJR < 0) {
            this.fJR = baE.getCount();
        }
        return baE.fIf.size() > this.fJR && baE.fIe.size() < 100;
    }
}

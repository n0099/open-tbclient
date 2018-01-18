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
    private final PbModel fGi;
    private int fGj;
    private int fGk;
    private z.a fGl;
    private final z.a fGm;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fGj = -1;
        this.fGk = -1;
        this.fGm = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void J(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aYR = MoreGodReplyModel.this.fGi.getPbData().aYR();
                if (aYR != null) {
                    List<PostData> list2 = aYR.fEx;
                    int size = list2.size();
                    if (!v.E(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fGi.a(MoreGodReplyModel.this.fGi.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fGj > 0) {
                    MoreGodReplyModel.this.fGk = MoreGodReplyModel.this.fGj;
                }
                if (MoreGodReplyModel.this.fGl != null) {
                    MoreGodReplyModel.this.fGl.J(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fGl != null) {
                    MoreGodReplyModel.this.fGl.h(i, str, str2);
                }
            }
        };
        this.fGi = pbModel;
        this.fGi.bcf().b(this.fGm);
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

    public boolean aZN() {
        n aYR;
        f pbData = this.fGi.getPbData();
        if (pbData == null || (aYR = pbData.aYR()) == null) {
            return false;
        }
        if (this.fGk < 0) {
            this.fGk = aYR.getCount();
        }
        List<Long> list = aYR.fEy;
        int size = list.size();
        int i = this.fGk;
        if (size <= i || aYR.fEx.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fGj = min;
        this.isLoading = true;
        this.fGi.bcf().cP(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean DP() {
        return this.isLoading;
    }

    public PbModel aZO() {
        return this.fGi;
    }

    public List<i> aZP() {
        f pbData = this.fGi.getPbData();
        if (pbData == null || pbData.aYR() == null || v.E(pbData.aYR().fEx)) {
            return null;
        }
        n aYR = pbData.aYR();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aYR.fEx;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gYQ = i < size + (-1);
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
        this.fGl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ahl() {
        n aYR;
        f pbData = this.fGi.getPbData();
        if (pbData == null || (aYR = pbData.aYR()) == null) {
            return false;
        }
        if (this.fGk < 0) {
            this.fGk = aYR.getCount();
        }
        return aYR.fEy.size() > this.fGk && aYR.fEx.size() < 100;
    }
}

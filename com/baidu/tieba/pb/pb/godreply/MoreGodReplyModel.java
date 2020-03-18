package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private PbModel iFu;
    private int iFv;
    private int iFw;
    private x.a iFx;
    private final x.a iFy;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iFv = -1;
        this.iFw = -1;
        this.iFy = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void onSuccess(List<PostData> list) {
                n cla;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iFu != null && MoreGodReplyModel.this.iFu.getPbData() != null && (cla = MoreGodReplyModel.this.iFu.getPbData().cla()) != null) {
                    List<PostData> list2 = cla.iEF;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iFu.a(MoreGodReplyModel.this.iFu.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iFv > 0) {
                    MoreGodReplyModel.this.iFw = MoreGodReplyModel.this.iFv;
                }
                if (MoreGodReplyModel.this.iFx != null) {
                    MoreGodReplyModel.this.iFx.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iFx != null) {
                    MoreGodReplyModel.this.iFx.l(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.iFu = pbModel;
            x cox = pbModel.cox();
            if (cox != null) {
                cox.b(this.iFy);
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

    public boolean clW() {
        n cla;
        com.baidu.tieba.pb.data.e pbData = this.iFu.getPbData();
        if (pbData == null || (cla = pbData.cla()) == null) {
            return false;
        }
        if (this.iFw < 0) {
            this.iFw = cla.getCount();
        }
        List<Long> list = cla.iEG;
        int size = list.size();
        int i = this.iFw;
        if (size <= i || cla.iEF.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iFv = min;
        this.isLoading = true;
        this.iFu.cox().dG(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel clX() {
        return this.iFu;
    }

    public List<m> clY() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.iFu == null || (pbData = this.iFu.getPbData()) == null || pbData.cla() == null || v.isEmpty(pbData.cla().iEF)) {
            return null;
        }
        n cla = pbData.cla();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cla.iEF;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.kiT = i < size + (-1);
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

    public void a(x.a aVar) {
        this.iFx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean acd() {
        com.baidu.tieba.pb.data.e pbData;
        n cla;
        if (this.iFu == null || (pbData = this.iFu.getPbData()) == null || (cla = pbData.cla()) == null) {
            return false;
        }
        if (this.iFw < 0) {
            this.iFw = cla.getCount();
        }
        return cla.iEG.size() > this.iFw && cla.iEF.size() < 100;
    }
}
